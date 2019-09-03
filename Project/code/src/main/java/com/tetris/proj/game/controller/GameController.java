package com.tetris.proj.game.controller;

import com.tetris.proj.game.model.Position;
import com.tetris.proj.game.view.GameViewAdapter;
import com.tetris.proj.controller.Controller;
import com.tetris.proj.game.model.GameArea;
import com.tetris.proj.game.model.GameModel;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class GameController implements Controller<GameModel, GameViewAdapter> {
    private boolean isPaused =false;

    public void processKey(GameModel model, KeyEvent key, GameViewAdapter view)
    {
        if(model.getArea().gameEnded())
            return;
        if (isPaused() && key.getKeyCode() != KeyEvent.VK_P)
            return;
        switch (key.getKeyCode()) {
            case KeyEvent.VK_A:
                Left(model.getArea());
                break;
            case  KeyEvent.VK_S:
                Down(model.getArea());
                break;
            case  KeyEvent.VK_D:
                Right(model.getArea());
                break;
            case  KeyEvent.VK_SPACE:
                Drop(model.getArea());
                break;
            case  KeyEvent.VK_W:
                Rotate(model.getArea());
                break;
            case  KeyEvent.VK_P:
                this.isPaused = !this.isPaused;
                break;
            case  KeyEvent.VK_H:
                model.getArea().changeHoldPiece();
                break;
            default:
                break;
        }


        if(model.getMultiplayer())
        {
            switch(key.getKeyCode())
            {
                case  KeyEvent.VK_DOWN:
                    Down(model.getArea2());
                    break;
                case  KeyEvent.VK_UP:
                    Rotate(model.getArea2());
                    break;
                case  KeyEvent.VK_LEFT:
                    Left(model.getArea2());
                    break;
                case  KeyEvent.VK_RIGHT:
                    Right(model.getArea2());
                    break;
                case  KeyEvent.VK_ENTER:
                    Drop(model.getArea2());
                    break;
                case  KeyEvent.VK_BACK_SPACE:
                    model.getArea2().changeHoldPiece();
                default:
                    break;
            }
        }
            view.draw(model);
    }

    public void Rotate(GameArea area) {
        area.getActivePiece().rotate();
        correctRotation(area);
    }

    public void Drop(GameArea area) {
        while (checkDown(area)) {
            area.getActivePiece().goDown();
        }
        area.setPiece();
    }

    public void Right(GameArea area) {
        if (checkRight(area))
            area.getActivePiece().goRight();
    }

    public void Down(GameArea area) {
        if (checkDown(area))
            area.getActivePiece().goDown();
        else
            area.setPiece();
    }

    public void Left(GameArea area) {
        if (checkLeft(area))
            area.getActivePiece().goLeft();
    }

    public Boolean checkDown(GameArea area){
        if (!(area.getActivePiece().getMaxY()<= area.getHeight()-2))
            return false;
        for (Position position:area.getActivePiece().getPositions()){
            if (position.getX()<0 || position.getX()>=area.getLength())
                continue;
            if (position.getY()<0)
                continue;
            if (!(position.getY()<area.getHeight()-1 && Arrays.equals(area.getMatrix()[Math.max(Math.min(position.getY()+1,area.getHeight()),0)][position.getX()].getColor(), new int[] {0,0,0})))
                return false;
        }
        return true;
    }
    public Boolean checkUp(GameArea area){
        if (!(area.getActivePiece().getMinY()>=1))
            return false;
        for (Position position:area.getActivePiece().getPositions()){
            if (position.getX()<0 || position.getX()>=area.getLength())
                continue;
            if (position.getY()>=area.getHeight())
                continue;
            if (!(position.getY()>0 && Arrays.equals(area.getMatrix()[Math.max(position.getY()-1, 0)][position.getX()].getColor(), new int[] {0,0,0})))
                return false;
        }
        return true;
    }
    public Boolean checkLeft(GameArea area){
        if (area.getActivePiece().getMinX()<1)
            return false;
        for (Position position:area.getActivePiece().getPositions()){
            if (position.getY()<0)
                continue;
            if (position.getX()-1> area.getLength()-1)
                continue;
            if (!(position.getX()>0 && Arrays.equals(area.getMatrix()[position.getY()][Math.max(position.getX()-1,0)].getColor(),new int[] {0,0,0})))
                return false;
        }
        return true;
    }
    public Boolean checkRight(GameArea area){
        if (!(area.getActivePiece().getMaxX()<=area.getLength()-2))
            return false;
        for (Position position:area.getActivePiece().getPositions()){
            if (position.getY()<0)
                continue;
            if (position.getX()+1< 0)
                continue;
            if (!(position.getX()<area.getLength()-1 && Arrays.equals(area.getMatrix()[Math.max(position.getY(),0)][Math.min(area.getLength(), position.getX()+1)].getColor(), new int[] {0,0,0})))
                return false;
        }
        return true;
    }

    private void correctRotation(GameArea area){
        //verifying rigth bounds
        int x_max_out_of_bounds=area.getActivePiece().getMaxX() - area.getLength()+1;
        if (x_max_out_of_bounds<=0)
        {
            int k=1;
            while(k<=3){
                for (int i=0; i<k; i++)
                    area.getActivePiece().goLeft();
                boolean taking_positions=checkRight(area);
                for (int i=0; i<k; i++)
                    area.getActivePiece().goRight();
                if (!taking_positions)
                    k++;
                else
                    break;
            }
            x_max_out_of_bounds=k-1;
        }
        //verifying left bounds
        int x_min_out_of_bounds=0- area.getActivePiece().getMinX();
        if (x_min_out_of_bounds<=0)
        {
            int k=1;
            while(k<=3){
                for (int i=0; i<k; i++)
                    area.getActivePiece().goRight();
                boolean taking_positions=checkLeft(area);
                for (int i=0; i<k; i++)
                    area.getActivePiece().goLeft();
                if (!taking_positions)
                    k++;
                else
                    break;
            }
            x_min_out_of_bounds=k-1;
        }
        //verifying down bounds
        int y_max_out_of_bounds= area.getActivePiece().getMaxY() - area.getHeight()+1;
        if (y_max_out_of_bounds<=0)
        {
            int k=1;
            while(k<=3){
                for (int i=0; i<k; i++)
                    area.getActivePiece().goDown();
                boolean taking_positions=checkUp(area);
                for (int i=0; i<k; i++)
                    area.getActivePiece().goUp();
                if (!taking_positions)
                    k++;
                else
                    break;
            }
            y_max_out_of_bounds=k-1;
        }
        //verifying upper bounds
        int y_min_out_of_bounds=0;
            int k=1;
            while(k<=3){
                for (int i=0; i<k; i++)
                    area.getActivePiece().goUp();
                boolean taking_positions=checkDown(area);
                for (int i=0; i<k; i++)
                    area.getActivePiece().goDown();
                if (!taking_positions)
                    k++;
                else
                    break;
            }
            y_min_out_of_bounds=k-1;
        //checking if correction is possible
        if (x_max_out_of_bounds>2 && x_min_out_of_bounds>2)
        {
            undoRotation(area);
            return;
        }
        if (y_max_out_of_bounds>2 && y_min_out_of_bounds>2)
        {
            undoRotation(area);
            return;
        }
        //correcting right
        if (x_max_out_of_bounds<=2)
            for (int i=0; i<x_max_out_of_bounds; i++) {
                if (checkLeft(area))
                    area.getActivePiece().goLeft();
                else {
                    for (int j=0; j<i; j++)
                        area.getActivePiece().goRight();
                    undoRotation(area);
                    return;
                }
            }
        //correct left
        if (x_min_out_of_bounds<=2)
        for (int i=0; i<x_min_out_of_bounds; i++) {
            if (checkRight(area))
                area.getActivePiece().goRight();
            else {
                for (int j=0; j<i; j++)
                    area.getActivePiece().goLeft();

                undoRotation(area);
                return;
            }
        }
        //correct down
        if (y_max_out_of_bounds<=2)
        for (int i=0; i<y_max_out_of_bounds; i++) {
            if (checkDown(area))
                area.getActivePiece().goDown();
            else {
                for (int j=0; j<i; j++)
                    area.getActivePiece().goUp();
                undoRotation(area);
                return;
            }
        }
        //correct up
        if (y_min_out_of_bounds<=2)
        for (int i=0; i<y_min_out_of_bounds; i++) {
            if (checkUp(area))
                area.getActivePiece().goUp();
            else {
                for (int j=0; j<i; j++)
                    area.getActivePiece().goDown();
                undoRotation(area);
                return;
            }
        }


    }

    private void undoRotation(GameArea area){
        for (int i=0; i<3;i++){
            area.getActivePiece().rotate();
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void processLines(GameModel model){
        for(int i=0; i< model.getArea().getSendLines(); i++)
            model.getArea2().receiveLine();
        model.getArea().setSendLines(0);
        for(int i=0; i< model.getArea2().getSendLines(); i++)
            model.getArea().receiveLine();
        model.getArea2().setSendLines(0);

    }
}
