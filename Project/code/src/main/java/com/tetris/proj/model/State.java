package com.tetris.proj.model;

import com.tetris.proj.controller.Controller;
import com.tetris.proj.view.View;

import java.io.IOException;

public abstract class State<M extends Model, V extends View, C extends Controller> {
    protected M model;
    protected V view;
    protected C controller;

    public abstract void doAction(Context context) throws IOException;
}

