package jp.azktogu.tetris.mino;

import jp.azktogu.tetris.Tetris;

public class Mino {
    private Type minoType;

    public enum Type{
        I(1),
        J(2),
        L(3),
        O(4),
        S(5),
        T(6),
        Z(7),
        M(8);

        private final int id;
        Type(int id){
            this.id=id;
        }
        public int getId(){
            return this.id;
        }
    }

    public Mino(Type minoType){
        this.minoType=minoType;
    }

    public Mino(){
        this(Type.M);
    }

    public int getId(){
        return this.minoType.getId();
    }

    public int[][][] get() {
        return new int[][][] {
                {
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1}
                },
                {
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1}
                },
                {
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1}
                },
                {
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1},
                        { 1, 1, 1, 1}
                },
        };
    }

    public int getMinX(int rotation) { return 0; }

    public int getMaxX(int rotation) { return 6; }

    public int getMinY(int rotation) { return 0; }

    public int getMaxY(int rotation) { return 16; }

    public void setMino(Tetris tetris, int x, int y, int rotation) {
        tetris.setMinoY(tetris.getMinoY() + y);
        tetris.setMinoX(tetris.getMinoX() + x);

        tetris.setRotation(rotation);

        if (tetris.getMinoX() >= tetris.currentMino.getMaxX(rotation)) {
            tetris.setMinoX(tetris.currentMino.getMaxX(rotation));
        } else if (tetris.getMinoX() <= tetris.currentMino.getMinX(rotation)) {
            tetris.setMinoX(tetris.currentMino.getMinX(rotation));
        }

        if (tetris.getMinoY() >= tetris.currentMino.getMaxY(rotation)) {
            tetris.setMinoY(tetris.currentMino.getMaxY(rotation));
        }
    }

    public void srsRight(Tetris tetris) {
        if (tetris.getRotation() == 0) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 1)) { setMino(tetris, 0, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 1)) { setMino(tetris, -1, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 1, 1)) { setMino(tetris, -1, -1, 1); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() + 2, 1)) { setMino(tetris, 0, 2, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 2, 1)) { setMino(tetris, -1, 2, 1); }

        } else if (tetris.getRotation() == 1) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 2)) { setMino(tetris, 0, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 1, 2)) { setMino(tetris, 1, 1, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 2)) { setMino(tetris, -1, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 1, 2)) { setMino(tetris, -1, 1, 2); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() - 2, 2)) { setMino(tetris, 0, -2, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 2, 2)) { setMino(tetris, -1, -2, 2); }

        } else if (tetris.getRotation() == 2) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 3)) { setMino(tetris, 0, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 3)) { setMino(tetris, 1, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 1, 3)) { setMino(tetris, 1, -1, 3); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() + 2, 3)) { setMino(tetris, 0, 2, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 2, 3)) { setMino(tetris, 1, 2, 3); }

        } else if (tetris.getRotation() == 3) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 0)) { setMino(tetris, 0, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 0)) { setMino(tetris, -1, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 1, 0)) { setMino(tetris, -1, 1, 0); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() - 2, 0)) { setMino(tetris, 0, -2, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 2, 0)) { setMino(tetris, -1, -2, 0); }
        }
    }

    public void srsLeft(Tetris tetris) {
        if (tetris.getRotation() == 0) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 3)) { setMino(tetris, 0, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 3)) { setMino(tetris, 1, 0, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 1, 3)) { setMino(tetris, 1, 1, 3); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() - 2, 3)) { setMino(tetris, 0, -2, 3); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 2, 3)) { setMino(tetris, 1, -2, 3); }

        } else if (tetris.getRotation() == 1) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 0)) { setMino(tetris, 0, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 0)) { setMino(tetris, 1, 0, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 1, 0)) { setMino(tetris, 1, 1, 0); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() - 2, 0)) { setMino(tetris, 0, -2, 0); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 2, 0)) { setMino(tetris, 1, -2, 0); }

        } else if (tetris.getRotation() == 2) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 1)) { setMino(tetris, 0, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY(), 1)) { setMino(tetris, -1, 0, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() - 1, 1)) { setMino(tetris, -1, -1, 1); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() + 2, 1)) { setMino(tetris, 0, 2, 1); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 2, 1)) { setMino(tetris, -1, 2, 1); }

        } else if (tetris.getRotation() == 3) {
            if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY(), 2)) { setMino(tetris, 0, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() - 1, tetris.getMinoY() + 1, 2)) { setMino(tetris, -1, 1, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY(), 2)) { setMino(tetris, 1, 0, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() + 1, 2)) { setMino(tetris, 1, 1, 2); }
            else if (tetris.checkSpace(tetris.getMinoX(), tetris.getMinoY() - 2, 2)) { setMino(tetris, 0, -2, 2); }
            else if (tetris.checkSpace(tetris.getMinoX() + 1, tetris.getMinoY() - 2, 2)) { setMino(tetris, 1, -2, 2); }
        }
    }
}