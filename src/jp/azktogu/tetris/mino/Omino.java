package jp.azktogu.tetris.mino;

import jp.azktogu.tetris.Tetris;

public class Omino extends Mino {
    public Omino() { super(Mino.Type.O); }
    @Override
    public int[][][] get() {
        return new int[][][] {
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}
                }
        };
    }

    @Override
    public int getMinX(int rotation) { return -1; }

    @Override
    public int getMaxX(int rotation) { return 7; }

    @Override
    public int getMinY(int rotation) { return -1; }

    @Override
    public int getMaxY(int rotation) { return 17; }

    @Override
    public void srsRight(Tetris tetris) { super.srsRight(tetris); }

    @Override
    public void srsLeft(Tetris tetris) { super.srsLeft(tetris); }
}