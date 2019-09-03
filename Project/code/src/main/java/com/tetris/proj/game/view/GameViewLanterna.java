package com.tetris.proj.game.view;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.tetris.proj.game.model.Position;
import com.tetris.proj.game.model.GameArea;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.model.Piece;
import com.tetris.proj.view.View;

import java.io.IOException;

public class GameViewLanterna implements View<GameModel> {
    Screen screen;
    private int starting_x;
    private int starting_y;
    private int starting_x2;

    public Screen getScreen() {
        return screen;
    }

    public void clear(){
        screen.clear();
    }

    public GameViewLanterna(Screen screen)  throws IOException {
        this.screen=screen;
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        this.starting_x=1;
        this.starting_y =1;
        this.starting_x2=40;
    }

    public void draw(GameModel model){
        screen.clear();
        drawGameArea(model.getArea(), starting_x, starting_y);
        if (model.getMultiplayer())
            drawGameArea(model.getArea2(), starting_x2, starting_y);
        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
        screen.clear();
    }

    public void drawPosition(Position p, int starting_x, int starting_y){
        screen.setCharacter(p.getX()*2+starting_x, p.getY()+starting_y, new TextCharacter('o', new TextColor.RGB(p.getColor()[0], p.getColor()[1], p.getColor()[2]), new TextColor.RGB(p.getColor()[0], p.getColor()[1], p.getColor()[2])));
        screen.setCharacter(p.getX()*2+1+starting_x, p.getY()+starting_y, new TextCharacter('o', new TextColor.RGB(p.getColor()[0], p.getColor()[1], p.getColor()[2]), new TextColor.RGB(p.getColor()[0], p.getColor()[1], p.getColor()[2])));
    }

    public void drawPiece(Piece p, int starting_x, int starting_y){
        for (Position position: p.getPositions()){
            drawPosition(position, starting_x, starting_y);
        }
    }

    public void drawGameArea(GameArea g, int starting_x, int starting_y){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

        drawFrame(textGraphics, g, starting_x, starting_y);
        drawMatrix(g, starting_x, starting_y);
        drawNext(g, textGraphics, starting_x, starting_y);
        drawHold(g, textGraphics, starting_x, starting_y);
        drawPoints(g, textGraphics, starting_x, starting_y);
        drawPiece(g.getActivePiece(), starting_x, starting_y);
    }

    private void drawMatrix(GameArea g, int starting_x, int starting_y){
        for (int i=0; i<g.getHeight(); i++)
        {
            for (int j=0; j<g.getLength(); j++)
                drawPosition(g.getMatrix()[i][j], starting_x, starting_y);
        }
    }


    private void drawNext(GameArea g, TextGraphics textGraphics, int starting_x, int starting_y){
        textGraphics.putString(g.getLength()*2+starting_x+8, starting_y+6, "NEXT");
        drawPiece(g.getNextPiece(), starting_x+g.getLength()+10, starting_y+11);
    }

    private void drawHold(GameArea g, TextGraphics textGraphics, int starting_x, int starting_y){
        textGraphics.putString(g.getLength()*2+starting_x+8, starting_y+13, "HOLD");
        drawPiece(g.getHoldPiece(), starting_x+g.getLength()+10, starting_y+18);
    }

    public void drawPoints(GameArea g, TextGraphics textGraphics, int starting_x, int starting_y){
        textGraphics.putString(g.getLength()*2+starting_x+7, starting_y+2, "POINTS");
        textGraphics.putString(g.getLength()*2+starting_x+8, starting_y+3, String.valueOf(g.getPoints()));
    }

    public void drawFrame(TextGraphics textGraphics, GameArea g, int starting_x, int starting_y){
        for (int i=1; i<g.getHeight()+1; i++){
            textGraphics.setCharacter(starting_x-1+0, starting_y-1+i, Symbols.DOUBLE_LINE_VERTICAL);
            textGraphics.setCharacter(starting_x-1+2*g.getLength()+1, starting_y-1+i, Symbols.DOUBLE_LINE_VERTICAL);
        }
        for (int i=1; i<g.getLength()*2+1; i++){
            textGraphics.setCharacter(starting_x-1+i, starting_y-1+0, Symbols.DOUBLE_LINE_HORIZONTAL);
            textGraphics.setCharacter(starting_x-1+i, starting_y-1+g.getHeight()+1, Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        textGraphics.setCharacter(starting_x-1+0, starting_y-1+0, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
        textGraphics.setCharacter(starting_x-1+00, starting_y-1+g.getHeight()+1, Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
        textGraphics.setCharacter(starting_x-1+02*g.getLength()+1, starting_y-1+0, Symbols. 	DOUBLE_LINE_TOP_RIGHT_CORNER);
        textGraphics.setCharacter(starting_x-1+02*g.getLength()+1, starting_y-1+g.getHeight()+1, Symbols. 	DOUBLE_LINE_BOTTOM_RIGHT_CORNER);

    }

}
