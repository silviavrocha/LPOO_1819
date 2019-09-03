package com.tetris.proj.game.model;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GameArea {
    private int length;
    private int height;
    private Piece activePiece;
    private Piece nextPiece;
    private Piece holdPiece;
    private Position[][] matrix;
    private boolean gameEnded=false;
    private int numLinesRemoved=0;
    private int numLinesReceived=0;
    private int previousRemoved=0;
    private int sendLines=0;
    private boolean holded=false;

    public Piece getActivePiece(){
        return activePiece;
    }

    public Position[][] getMatrix() {
        return matrix;
    }

    public int getHeight(){
        return height;
    }

    public int getLength(){
        return length;
    }

    public int getPoints() { return numLinesRemoved;}

    public Piece getNextPiece(){ return nextPiece;}

    public Piece getHoldPiece(){ return holdPiece;}

    private Piece generateRandomPiece(){
        int random=ThreadLocalRandom.current().nextInt(0, 6 + 1);
        switch (random){
            case 0:
                return new BlueRickyPiece(length);
            case 1:
                return new ClevelandZPiece(length);
            case 2:
                return new HeroPiece(length);
            case 3:
                return new OrangeRickyPiece(length);
            case 4:
                return new RhodeIslandZPiece(length);
            case 5:
                return new SmashBoyPiece(length);
            case 6:
                return new TeeweePiece(length);
            default:
                return new HeroPiece(length);
        }
    }

    private void fillMatrix(){
        for (int i=0; i<height; i++)
        {
            for (int j=0; j<length; j++)
                this.matrix[i][j]=new Position(j, i, new int[] {0,0,0});
        }
    }

    public GameArea(int length, int height){
        this.length=length;
        this.height=height;

        this.nextPiece= generateRandomPiece();
        this.activePiece= generateRandomPiece();
        this.holdPiece= generateRandomPiece();

        this.matrix = new Position[height][length];
        fillMatrix();
    }

    public void setPiece(){
        for (Position position:this.getActivePiece().getPositions())
        {
            this.matrix[Math.max(position.getY(),0)][position.getX()].setColor(this.getActivePiece().getColor());
        }
        this.sendLines = removeFullLines();
        if(this.getActivePiece().getMinY()<=0)
        {
            gameEnded=true;
            return;
        }
        this.activePiece=nextPiece;
        this.nextPiece=generateRandomPiece();
        holded=false;
    }

    private int removeFullLines() {

        int send=0;
        for (int i=0; i<height; i++)
        {
            if(checkLineFull(i)){
                previousRemoved=numLinesRemoved;
                numLinesRemoved++;
                if(sendLine())
                    send++;
                for(int j=i; j>0;j--)
                {
                    for(int k=0;k<length;k++)
                        this.matrix[j][k].setColor(this.matrix[j-1][k].getColor());
                }
            }
        }
        return send;
    }

    public void receiveLine() {
        for (int i=0; i<height-1; i++)
        {
            for(int k=0;k<length;k++)
                this.matrix[i][k].setColor(this.matrix[i+1][k].getColor());
        }
        for (int i=0; i<length;i++)
            this.matrix[height-1][i].setColor(new int[] {128, 128, 128});
        this.numLinesReceived++;
    }

    private boolean sendLine(){
        if(this.numLinesRemoved%3==0 && (this.numLinesRemoved != this.previousRemoved))
        {
            if(this.numLinesReceived>0)
            {
                this.numLinesReceived--;
                for (int i=height-1; i>0; i--)
                {
                    for(int k=0;k<length;k++)
                        this.matrix[i][k].setColor(this.matrix[i-1][k].getColor());
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkLineFull(int line) {
        for(int i=0; i<this.length; i++)
        {
            if (Arrays.equals(this.matrix[line][i].getColor(),new int[] {0,0,0}) || Arrays.equals(this.matrix[line][i].getColor(),new int[] {128,128,128}) )
                return false;
        }
        return true;
    }

    public boolean gameEnded() {
        return gameEnded;
    }

    public void changeHoldPiece(){
        if(!holded)
        {
            Piece aux=activePiece;
            activePiece=holdPiece;
            holdPiece=aux;
            holdPiece.startingPosition(length);
            holded=true;
        }
    }

    public int getSendLines() {
        return sendLines;
    }

    public void setSendLines(int sendLines) {
        this.sendLines = sendLines;
    }
}
