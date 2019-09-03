package com.tetris.proj.controller;
import com.tetris.proj.model.Model;
import com.tetris.proj.view.View;

import java.awt.event.KeyEvent;

public interface Controller <T extends Model, Q extends View>{
    void processKey(T model, KeyEvent key, Q view);
}
