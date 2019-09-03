import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    private int height;
    private int width;
    Hero hero= new Hero(10,10);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    Arena(int height, int width)
    {
        this.width=width;
        this.height=height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters=createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

      private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
        hero.draw(graphics);
    }

    private boolean verifyMonsterCollisions(Position position)
    {
         for (Monster monster : monsters)
            if(monster.getPosition().equals(position))
                return true;
        return false;
    }

    private void moveMonsters()
    {
         Random random = new Random();
         int rand;
         for (Monster monster : monsters)
        {
            Position position;
            rand= random.nextInt(2) + 1;
            switch(rand)
            {
                case 0:
                    position = new Position(monster.getPosition().getX()+1, monster.getPosition().getY());
                    if(position.getX()<0 || position.getX()>=width || position.getY()<0 || position.getY()>=height)
                        break;
                    monster.setPosition(position);
                    break;
                case 1:
                    position = new Position(monster.getPosition().getX()-1, monster.getPosition().getY());
                    if(position.getX()<0 || position.getX()>=width || position.getY()<0 || position.getY()>=height)
                        break;
                    monster.setPosition(position);
                    break;
                case 2:
                    position = new Position (monster.getPosition().getX(), monster.getPosition().getY()+1);
                    if(position.getX()<0 || position.getX()>=width || position.getY()<0 || position.getY()>=height)
                        break;
                    monster.setPosition(position);
                    break;
                case 3: 
                    position = new Position (monster.getPosition().getX(), monster.getPosition().getY()-1);
                    if(position.getX()<0 || position.getX()>=width || position.getY()<0 || position.getY()>=height)
                        break;
                    monster.setPosition(position);
                    break;
            }

        }

    }
    private boolean canHeroMove(Position position)
    {
        if(position.getX()<0 || position.getX()>=width || position.getY()<0 || position.getY()>=height)
            return false;
        for (Wall wall : walls)
        {
            if(wall.getPosition().equals(position))
                return false;
        }
        if(verifyMonsterCollisions(position))
        {
            System.out.println("You died!");
            System.exit(0);
        }
        moveMonsters();
        if(verifyMonsterCollisions(position))
        {
            System.out.println("You died!");
            System.exit(0);
        }
        retrieveCoins(position);
        return true;

    }

    private void retrieveCoins(Position position) {
        int i=0;
        boolean delete=false;
        for (Coin coin : coins)
        {
            if(coin.getPosition().equals(position))
            {
                delete=true;
                break;
            }

            i++;
        }
        if(delete)
            coins.remove(i);
    }

    private void moveHero(Position position)
    {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType())
        {
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            default:
                break;

        }
    }
}
