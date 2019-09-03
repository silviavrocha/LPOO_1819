package com.tetris.proj.menu;

import com.tetris.proj.game.model.GameModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class MenuGeneralizationTest {

    private MenuGeneralization menu;

    @Before
    public void helper(){
        try {
             menu= Mockito.mock(MenuGeneralization.class);
            when(menu.run()).thenReturn(0);
            GameModel model = new GameModel(false);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @Test
    public void  run() {
        try {
            menu.run();
            Mockito.verify(menu, times(1)).run();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}