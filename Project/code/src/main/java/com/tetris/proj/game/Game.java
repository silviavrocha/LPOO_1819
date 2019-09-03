package com.tetris.proj.game;

import com.tetris.proj.game.controller.GameController;
import com.tetris.proj.game.model.GameModel;
import com.tetris.proj.game.view.GameViewAdapter;
import com.tetris.proj.menu.GameOverMenu;
import com.tetris.proj.model.Context;
import com.tetris.proj.model.State;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Game<T> extends State<GameModel, GameViewAdapter,GameController> {
    private Timer timer;
    private int goDownRate = 300;
    T gui;

    public Game(boolean multiplayer, T gui) throws IOException {
        this.model = new GameModel(multiplayer);
        this.controller= new GameController();
        view = new GameViewAdapter(gui, controller, model);
        this.timer=new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 0, goDownRate);
        this.gui=gui;
    }

    public int[] run(){
        while (!model.GameOver()) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (model.getMultiplayer())
                this.controller.processLines(model);
        }
        view.removeKeyListener();
        timer.cancel();
        view.clear();
        if(model.getMultiplayer())
            return new int[] {model.getArea().getPoints(), model.getArea().gameEnded() ? 1:0, model.getArea2().getPoints(), model.getArea2().gameEnded() ? 1:0};
        return new int[] {model.getArea().getPoints(), model.getArea().gameEnded() ? 1:0};
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            if(controller.isPaused())
                return;

            controller.Down(model.getArea());
            if(model.getMultiplayer())
                controller.Down(model.getArea2());
                view.draw(model);
        }
    }

    public void doAction(Context context) throws IOException{
        int[] scores = this.run();
        context.setState(new GameOverMenu(gui, scores, model.getMultiplayer()));
    }

}
