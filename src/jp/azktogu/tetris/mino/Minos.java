package jp.azktogu.tetris.mino;

import java.util.ArrayList;
import java.util.Collections;

public class Minos {
    public static final Imino I = new Imino();
    public static final Jmino J = new Jmino();
    public static final Lmino L = new Lmino();
    public static final Omino O = new Omino();
    public static final Smino S = new Smino();
    public static final Tmino T = new Tmino();
    public static final Zmino Z = new Zmino();
    public static final Mino M = new Mino();

    private ArrayList<Mino> minos;
    public ArrayList<Mino> next;

    public Minos() {
        this.minos = new ArrayList();
        this.next = new ArrayList();
        this.minos.add(I);
        this.minos.add(J);
        this.minos.add(L);
        this.minos.add(O);
        this.minos.add(S);
        this.minos.add(T);
        this.minos.add(Z);
        make14();
    }

    public Minos(Mino... ms) {
        this.next = new ArrayList();
        for (int i = 0;i<ms.length;i++) {
            this.next.add(ms[i]);
        }
    }

    public void make7() {
        Collections.shuffle(this.minos);
        this.minos.stream().forEach(this.next::add);
    }

    public void make14() {
        Collections.shuffle(this.minos);
        this.minos.stream().forEach(this.next::add);
        Collections.shuffle(this.minos);
        this.minos.stream().forEach(this.next::add);

    }
}