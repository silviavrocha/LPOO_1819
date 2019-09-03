package com.tetris.proj.menu.view;

import com.tetris.proj.menu.model.Menu;
import com.tetris.proj.menu.model.MenuModel;
import com.tetris.proj.menu.model.Option;
import com.tetris.proj.view.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class MenuViewSwing implements View<MenuModel> {
    private JFrame frame;

    public MenuViewSwing(JFrame frame)  throws IOException {
        this.frame=frame;
    }

    public void draw(MenuModel model){
        Painting paint = new Painting(model);
        paint.setDoubleBuffered(true);
        frame.getContentPane().add(paint);
        frame.revalidate();
        frame.repaint();
    }

    public void clear(){
        frame.getContentPane().removeAll();
    }

    public void RemovePainter(){
        frame.getContentPane().removeAll();
    }

    public class Painting extends JPanel {

        private MenuModel model;

        public void drawMenu(Menu menu, Graphics g){
            for (Option option:menu.getOptions()){
                drawOption(option, g);
            }
        }

        public void drawOption(Option op, Graphics g){
            if (op.getActive())
            {
                g.setColor(new Color(op.getColor_active()[0], op.getColor_active()[1], op.getColor_active()[2]));
                g.drawString(op.getDescription(), op.getStarting_x()*10, op.getStarting_y()*10 +op.getHeight()*10);

            }
            else{
                g.setColor(new Color(op.getColor_inactive()[0], op.getColor_inactive()[1], op.getColor_inactive()[2]));
                g.drawString(op.getDescription(), op.getStarting_x()*10, op.getStarting_y()*10 +op.getHeight()*10);

            }
        }

        Painting(MenuModel model) {
            this.model = model;
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setDoubleBuffered(true);
            drawMenu(model.getMenu(), g);

        }
    }


    }
