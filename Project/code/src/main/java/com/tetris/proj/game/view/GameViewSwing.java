package com.tetris.proj.game.view;

import com.tetris.proj.game.model.Position;
import com.tetris.proj.game.model.GameArea;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.model.Piece;
import com.tetris.proj.view.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;

public class GameViewSwing implements View<GameModel> {
    private final Painting paint;
    JFrame frame;
    private int starting_x;
    private int starting_y;
    private int starting_x2;

    public GameViewSwing(JFrame frame)  throws IOException {
        this.frame=frame;

        paint = new Painting();
        paint.setDoubleBuffered(true);
        frame.getContentPane().add(paint);
        frame.revalidate();

        this.starting_x=30;
        this.starting_y =50;
        this.starting_x2=480;
    }

    public void clear(){
        frame.getContentPane().removeAll();
    }

    public void draw(GameModel model){
            drawGameArea(model);
    }


    public void drawGameArea(GameModel model){
        paint.setModel(model);
        paint.repaint();
    }

    public class Painting extends JPanel {

        private GameModel model;

        Painting(){}

        public void setModel(GameModel model) {
            this.model = model;
        }

        public void drawPosition(Position p, int starting_x, int starting_y, Graphics g){
            g.setColor(new Color(p.getColor()[0], p.getColor()[1], p.getColor()[2]));
            for(int i=0; i<10; i++)
                for(int j=0; j<10; j++)
                    g.drawLine(p.getX()*10+starting_x+j, p.getY()*10+starting_y+i, p.getX()*10+starting_x+j, p.getY()*10+starting_y+i);
        }

        public void drawPiece(Piece p, int starting_x, int starting_y, Graphics g){
            for (Position position: p.getPositions()){
                drawPosition(position, starting_x, starting_y, g);
            }
        }

        private void drawMatrix(Graphics g, GameArea ga, int starting_x, int starting_y){
            for (int i=0; i<ga.getHeight(); i++)
            {
                for (int j=0; j<ga.getLength(); j++)
                    drawPosition(ga.getMatrix()[i][j], starting_x, starting_y,g);
            }
        }

        private void drawNext(Graphics g, GameArea ga, int starting_x, int starting_y){
            g.setColor(BLACK);
            g.drawString("NEXT", ga.getLength()*10+starting_x+90, starting_y+60);
            drawPiece(ga.getNextPiece(), starting_x+ga.getLength()*10+30, starting_y+100, g);
        }

        private void drawHold(Graphics g, GameArea ga, int starting_x, int starting_y){
            g.setColor(BLACK);
            g.drawString("HOLD", ga.getLength()*10+starting_x+90, starting_y+150);
            g.setColor(new Color(ga.getHoldPiece().getColor()[0], ga.getHoldPiece().getColor()[1], ga.getHoldPiece().getColor()[2]));
            drawPiece(ga.getHoldPiece(), starting_x+ga.getLength()*10+30, starting_y+200, g);
        }

        public void drawPoints(Graphics g, GameArea ga, int starting_x, int starting_y){
            g.setColor(BLACK);
            g.drawString("POINTS",ga.getLength()*10+starting_x+90, starting_y+10);
            g.drawString(String.valueOf(ga.getPoints()),ga.getLength()*10+starting_x+100, starting_y+25);
        }

        public void drawFrame(Graphics g, GameArea ga, int starting_x, int starting_y){
            g.setColor(BLUE);
            g.drawLine(starting_x-5, starting_y-5, starting_x+ga.getLength()*10+5, starting_y-5);
            g.drawLine(starting_x-8, starting_y-8, starting_x+ga.getLength()*10+8, starting_y-8);

            g.drawLine(starting_x-5, starting_y+ga.getHeight()*10+5, starting_x+ga.getLength()*10+5, starting_y+ga.getHeight()*10+5);
            g.drawLine(starting_x-8, starting_y+ga.getHeight()*10+8, starting_x+ga.getLength()*10+8, starting_y+ga.getHeight()*10+8);

            g.drawLine(starting_x-5, starting_y-5, starting_x-5, starting_y+ga.getHeight()*10+5);
            g.drawLine(starting_x-8, starting_y-8, starting_x-8, starting_y+ga.getHeight()*10+8);

            g.drawLine(starting_x+ga.getLength()*10+5, starting_y-5, starting_x+ga.getLength()*10+5, starting_y+ga.getHeight()*10+5);
            g.drawLine(starting_x+ga.getLength()*10+8, starting_y-8, starting_x+ga.getLength()*10+8, starting_y+ga.getHeight()*10+8);

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (model == null) return;

            GameArea ga = model.getArea();
            drawMatrix(g, ga, starting_x, starting_y);
            drawPiece(ga.getActivePiece(), starting_x, starting_y, g);
            drawFrame(g,ga, starting_x, starting_y);
            drawNext(g, ga, starting_x, starting_y);
            drawHold(g, ga, starting_x, starting_y);
            drawPoints(g, ga, starting_x, starting_y);
            if(model.getMultiplayer())
            {
                GameArea ga2 = model.getArea2();
                drawMatrix(g, ga2, starting_x2, starting_y);
                drawPiece(ga2.getActivePiece(), starting_x2, starting_y, g);
                drawFrame(g,ga2, starting_x2, starting_y);
                drawNext(g, ga2, starting_x2, starting_y);
                drawHold(g, ga2, starting_x2, starting_y);
                drawPoints(g, ga2, starting_x2, starting_y);
            }

        }
    }

}
