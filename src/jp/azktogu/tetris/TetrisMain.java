package jp.azktogu.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisMain {

    public static Tetris tetris;
    public static TetrisUI tetrisUI;

    private static JPanel panel;
    private static Thread thread;

    public static void main(String[] args){

        tetris=new Tetris();
        tetrisUI=new TetrisUI(tetris);

        JFrame frame=new JFrame("tetris");
        frame.setSize(TetrisUI.WIDTH,TetrisUI.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)tetris.moveRight();
                if(e.getKeyCode()==KeyEvent.VK_LEFT)tetris.moveLeft();
                if(e.getKeyCode()==KeyEvent.VK_DOWN)tetris.softDrop();
                if(e.getKeyCode()==KeyEvent.VK_UP)tetris.hardDrop();
                if(e.getKeyCode()==KeyEvent.VK_SHIFT)tetris.hold();
                if(e.getKeyCode()==KeyEvent.VK_X)tetris.right();
                if(e.getKeyCode()==KeyEvent.VK_Z)tetris.left();
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE)tetris.init();
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

        panel=new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                tetrisUI.draw(g);
            }
        };

        frame.add(panel);

        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        tetris.update();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                panel.repaint();
                            }
                        });
                        Thread.sleep(5);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        frame.setVisible(true);
    }
}
