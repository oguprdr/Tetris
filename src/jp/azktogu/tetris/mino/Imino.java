package jp.azktogu.tetris.mino;

import jp.azktogu.tetris.Tetris;

public class Imino extends Mino {

    public Imino() { super(Mino.Type.I); }

    @Override
    public int[][][] get() {
        return new int[][][] {
                {
                        {0, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                },
                {
                        {0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 1, 0}
                },
                {
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 0, 0, 0}
                },
                {
                        {0, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 0, 0}
                }
        };
    }

    @Override
    public int getMinX(int rotation) {
        if (rotation == 1) return -2;
        if (rotation == 3) return -1;
        return 0;
    }

    @Override
    public int getMaxX(int rotation) {
        if (rotation == 1) return 7;
        if (rotation == 3) return 8;
        return 6;
    }

    @Override
    public int getMinY(int rotation) { return 0; }

    @Override
    public int getMaxY(int rotation) {
        if (rotation == 0) return 18;
        if (rotation == 2) return 17;
        return 16;
    }

    @Override
    public void srsRight(Tetris tetris) {
        if (tetris.getRotation() == 0) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 1)) { setMino(tetris, 0, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY(), 1)) { setMino(tetris, -2, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 1)) { setMino(tetris, 1, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY() + 1, 1)) { setMino(tetris, -2, 1, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 2, 1)) { setMino(tetris, 1, -2, 1); }
        } else if (tetris.getRotation() == 1) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 2)) { setMino(tetris, 0, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 2)) { setMino(tetris, -1, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY(), 2)) { setMino(tetris, 2, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 2, 2)) { setMino(tetris, -1, -2, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY() + 1, 2)) { setMino(tetris, 2, 1, 2); }
        } else if (tetris.getRotation() == 2) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 3)) { setMino(tetris, 0, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY(), 3)) { setMino(tetris, 2, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 3)) { setMino(tetris, -1, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY() - 1, 3)) { setMino(tetris, 2, -1, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 2, 3)) { setMino(tetris, -1, 2, 3); }
        } else if (tetris.getRotation() == 3) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 0)) { setMino(tetris, 0, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY(), 0)) { setMino(tetris, -2, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 0)) { setMino(tetris, -1, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 2, 0)) { setMino(tetris, 1, 2, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY() - 1, 0)) { setMino(tetris, -2, -1, 0); }

        }
    }

    @Override
    public void srsLeft(Tetris tetris) {
        if (tetris.getRotation() == 0) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 3)) { setMino(tetris, 0, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 3)) { setMino(tetris, -1, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY(), 3)) { setMino(tetris, 2, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 2, 3)) { setMino(tetris, -1, -2, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY() + 1, 3)) { setMino(tetris, 2, 1, 3); }
        } else if (tetris.getRotation() == 1) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 0)) { setMino(tetris, 0, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY(), 0)) { setMino(tetris, 2, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 0)) { setMino(tetris, -1, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 2, tetris.getMinoY() - 1, 0)) { setMino(tetris, 2, -1, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 2, 0)) { setMino(tetris, -1, 2, 0); }
        } else if (tetris.getRotation() == 2) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 1)) { setMino(tetris, 0, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 1)) { setMino(tetris, 1, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY(), 1)) { setMino(tetris, -2, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 2, 1)) { setMino(tetris, 1, 2, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY() - 1, 1)) { setMino(tetris, -2, -1, 1); }
        } else if (tetris.getRotation() == 3) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 2)) { setMino(tetris, 0, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 2)) { setMino(tetris, 1, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY(), 2)) { setMino(tetris, -2, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 2, tetris.getMinoY() + 1, 2)) { setMino(tetris, -2, 1, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 2, 2)) { setMino(tetris, 1, -2, 2); }

        }
    }
}
