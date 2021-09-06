package jp.azktogu.tetris;

import jp.azktogu.tetris.mino.Mino;
import jp.azktogu.tetris.mino.MinoDesign;

import java.awt.*;

public class TetrisUI {

    public static final int WIDTH=900;
    public static final int HEIGHT=800;

    private static final int BLOCKSIZE=30;

    private final MinoDesign design=new MinoDesign();

    private Tetris tetris;

    public TetrisUI(Tetris tetris){
        this.tetris=tetris;
    }

    public void draw(Graphics g) {
        int x=200,y=100;

        drawField(g, x, y);
        drawShadow(g, x, y);
        drawMino(g, x, y);
        drawHold(g, x - 10 * 30 / 2, y);
        drawNext(g, x + 10 * 30 + 20, y);

        ((Graphics2D)g).setStroke(new BasicStroke(3.0F));
        g.setColor(Color.BLUE);
        g.drawRect(x - 2, y - 2, 30 * 10 + 3, 30 * 20 + 3);
    }

    private void drawMino(Graphics g, int x, int y) {
        int[][][] mino = this.tetris.currentMino.get();
        int mr = this.tetris.getRotation();
        for (int i = 0; i < mino[mr].length; i++) {
            for (int l = 0; l < mino[mr][i].length; l++) {
                if (mino[mr][i][l] != 0) {
                    this.design.draw(this.tetris.currentMino.getId(), g, 30 * this.tetris.getMinoX() + x + l * 30, y + i * 30 + 30 * this.tetris.getMinoY(), BLOCKSIZE);
                }
            }
        }
    }

    private void drawField(Graphics g, int x, int y) {
        int[][] field = this.tetris.field;
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 300, 600);
        for (int i = 0; i < field.length; i++) {
            for (int l = 0; l < field[i].length; l++) {
                if (field[i][l] != 0 ) {
                    this.design.draw(field[i][l], g, x + l * 30, y + i * 30, BLOCKSIZE);
                }
            }
        }
    }

    private void drawHold(Graphics g, int x, int y) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 120, 120);
        ((Graphics2D)g).setStroke(new BasicStroke(1.0F));
        if (this.tetris.holdMino != null) {
            int[][][] mino = this.tetris.holdMino.get();
            for (int i = 0; i < mino[0].length; i++) {
                for (int l = 0; l < mino[0][i].length; l++) {
                    if (mino[0][i][l] != 0) {
                        this.design.draw(this.tetris.holdMino.getId(), g, x + l * 20 + 30, y + i * 20 + 30, BLOCKSIZE-8);
                    }
                }
            }
        }
        if (!this.tetris.canHold) {
            ((Graphics2D)g).setStroke(new BasicStroke(1.0F));
            g.setColor(Color.RED);
            g.drawLine(x + 1, y + 1, x + 120 - 1, y + 120 - 1);
            g.drawLine(x + 120 - 1, y + 1, x + 1, y + 120 - 1);
        }
        ((Graphics2D)g).setStroke(new BasicStroke(3.0F));
        g.setColor(Color.BLUE);
        g.drawRect(x - 2, y - 2, 123, 123);
    }

    private void drawNext(Graphics g, int x, int y) {
        ((Graphics2D)g).setStroke(new BasicStroke(3.0F));
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 120, 480);

        g.setColor(Color.BLUE);
        g.drawRect(x - 2, y - 2, 123, 483);
        ((Graphics2D)g).setStroke(new BasicStroke(1));

        for (int j = 1; j <= 5; j++) {
            y += 30;
            for (int i = 0; i < ((Mino)this.tetris.minos.next.get(0)).get()[0].length; i++) {
                for (int l = 0; l < ((Mino) this.tetris.minos.next.get(0)).get()[0][i].length; l++) {
                    if (((Mino) this.tetris.minos.next.get(j - 1)).get()[0][i][l] != 0)
                        this.design.draw(((Mino) this.tetris.minos.next.get(j - 1)).getId(), g, x + l * 20 + 15, y + i * 20 + 60 * (j - 1), BLOCKSIZE-8);
                }
            }
        }
    }

    private void drawShadow(Graphics g, int x, int y) {
        int mr = this.tetris.getRotation();
        for (int i = this.tetris.getMinoY(); i < 20; i++) {
            if (this.tetris.canPlace(i)) {
                int[][][] mino = this.tetris.currentMino.get();
                for (int j = 0; j < mino[mr].length; j++) {
                    for (int l = 0; l < mino[mr][j].length; l++) {
                        if (mino[mr][j][l] != 0) {
                            this.design.drawShadow(this.tetris.currentMino.getId(), g, 30 * this.tetris.getMinoX() + x + l * 30 + 1, y + j * 30 + i * 30 + 1, BLOCKSIZE);
                        }
                    }
                }
                break;
            }
        }
    }

}
