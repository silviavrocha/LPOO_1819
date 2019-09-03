package com.tetris.proj.menu.model;

import com.tetris.proj.model.Model;

import java.util.List;

public class MenuModel implements Model {
    private Menu menu;

    public MenuModel(List<Option> options){
        this.menu=new Menu(options);
    }

    public Menu getMenu() {
        return menu;
    }

    public Boolean selected(){
        return menu.selected();
    }
}
