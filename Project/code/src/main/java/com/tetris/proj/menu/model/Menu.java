package com.tetris.proj.menu.model;
import java.util.List;

public class Menu {
    private List<Option> options;
    private int current_option;
    private Boolean selected;


    public Boolean selected(){
        return selected;
    }

    public void select(){
        selected=true;
    }

    public List<Option> getOptions(){return options;}

    public int selectedOption(){
        return current_option;
    }

    public Menu(List<Option> options){
        selected=false;
        this.options=options;
        current_option=0;
    }

    public void next(){
        options.get(current_option).changeActive();
        current_option++;
        current_option%=options.size();
        options.get(current_option).changeActive();
    }

    public void previous(){
        options.get(current_option).changeActive();
        current_option--;
        current_option+=options.size();
        current_option%=options.size();
        options.get(current_option).changeActive();
    }
}
