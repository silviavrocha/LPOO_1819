package com.tetris.proj;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
        Handler handler;
        handler = new HandlerLanterna();
        //handler = new HandlerSwing();
        handler.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
