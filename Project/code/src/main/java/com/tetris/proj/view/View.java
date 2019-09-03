package com.tetris.proj.view;

import com.tetris.proj.model.Model;

public interface View<T extends Model> {
    void draw(T model);
    void clear();
}
