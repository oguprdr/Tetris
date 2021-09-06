package jp.azktogu.tetris.mino;

import jp.azktogu.tetris.Tetris;

public class Zmino extends Mino {

    public Zmino() { super(Mino.Type.Z); }

    @Override
    public int[][][] get() {
        return new int[][][]{
                {
                        {1, 1, 0, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 1, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 1, 0, 0},
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 0}
                }
        };
    }

    @Override
    public int getMinX(int rotation) {
        if (rotation == 1) return -1;
        return 0;
    }

    @Override
    public int getMaxX(int rotation) {
        if (rotation == 3) return 8;
        return 7;
    }

    @Override
    public int getMinY(int rotation) { return 0; }

    @Override
    public int getMaxY(int rotation) {
        if (rotation == 0) return 18;return 17;
    }

    @Override
    public void srsRight(Tetris tetris) { super.srsRight(tetris); }

    @Override
    public void srsLeft(Tetris tetris) { super.srsLeft(tetris); }
}

