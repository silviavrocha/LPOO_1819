package com.tetris.proj.menu.model;

public class Option {
    private Boolean active;
    private String description;
    private int starting_x;
    private int starting_y;
    private int height;
    private int length;
    private int color_active[];
    private int color_inactive[];

    public Option(String description, Boolean active, int starting_x, int starting_y, int height, int length, int[] color_active , int[] color_inactive)
    {
        this.description=description;
        this.active=active;
        this.starting_x=starting_x;
        this.starting_y=starting_y;
        this.height=height;
        this.length=length;
        this.color_active=color_active;
        this.color_inactive=color_inactive;
    }

    public boolean getActive(){return active;}

    public int[] getColor_active(){return color_active;}

    public int[] getColor_inactive(){return color_inactive;}

    public void changeActive(){
        active = !active;
    }

    public int getStarting_x() {
        return starting_x;
    }

    public int getStarting_y() {
        return starting_y;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }
}
