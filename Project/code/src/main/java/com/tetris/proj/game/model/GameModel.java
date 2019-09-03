package com.tetris.proj.game.model;

import com.tetris.proj.model.Model;

public class GameModel implements Model {
    private GameArea area;
    private GameArea area2;
    private boolean multiplayer;

    public GameModel (boolean multiplayer){
        this.area=new GameArea(10, 20);
        this.multiplayer=multiplayer;
        if(multiplayer)
            this.area2=new GameArea(10, 20);
    }

    public GameArea getArea() {
        return area;
    }

    public GameArea getArea2() {
        return area2;
    }

    public boolean getMultiplayer(){
        return multiplayer;
    }

    public Boolean GameOver(){
        if (multiplayer)
            return (area.gameEnded()||area2.gameEnded());
        return (area.gameEnded());
    }
}
