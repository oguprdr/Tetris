package jp.azktogu.tetris;

import jp.azktogu.tetris.mino.Mino;
import jp.azktogu.tetris.mino.Minos;

public class Tetris {

    public static final int FIELD_Y=20,FIELD_X=10,INFINITY=150,FRAME=200;

    private int rotation,minoX,minoY;
    private int frame,infinity;

    public int[][] field;
    public boolean canHold;

    public Minos minos;
    public Mino currentMino,holdMino;

    public Tetris(){
        init();
    }

    public void init(){
        this.field=new int[FIELD_Y][FIELD_X];
        for(int i=0;i<FIELD_Y;i++)for(int j=0;j<FIELD_X;j++){
            this.field[i][j]=0;
        }

        this.rotation=0;
        this.minoX=3;
        this.minoY=0;

        this.frame=0;
        this.infinity=0;

        this.canHold=true;

        this.minos=new Minos();
        this.currentMino=(Mino)this.minos.next.remove(0);
        this.holdMino=null;


    }

    public void update(){
        this.frame++;

        if(canPlace()) this.infinity++;
        else infinity=0;

        if(this.infinity>=INFINITY){
            if(canPlace())setMino();
            this.infinity=0;
        }

        if(this.frame>=FRAME){
            if(!canPlace())minoY++;
            this.frame=0;
        }


    }

    public void right(){
        this.infinity=0;
        this.currentMino.srsRight(this);
    }

    public void left(){
        this.infinity=0;
        this.currentMino.srsLeft(this);
    }

    public void hardDrop(){
        if(minoY==this.currentMino.getMaxY(rotation)){
            setMino();
            return;
        }
        if(canPlace()){
            setMino();
            return;
        }
        for(int i=this.getMinoY();i<FIELD_Y;i++){
            if(canPlace(i)){
                minoY=i;
                setMino();
                break;
            }
        }
    }

    public void softDrop(){
        if(minoY==this.currentMino.getMaxY(rotation))return;
        if(canPlace())return;
        minoY++;
    }

    public void moveRight(){
        if(minoX==this.currentMino.getMaxX(rotation))return;
        if(!canMove(0))return;
        minoX++;
    }

    public void moveLeft(){
        if(minoX==this.currentMino.getMinX(rotation))return;
        if(!canMove(1))return;
        minoX--;
    }

    public void hold(){
        if(this.canHold){
            if(this.holdMino==null){
                this.holdMino=this.currentMino;
                this.currentMino=(Mino)this.minos.next.remove(0);
            }else{
                Mino tmp=this.currentMino;
                this.currentMino=this.holdMino;
                this.holdMino=tmp;
            }
            this.canHold=false;
            this.setRotation(0);
            this.setMinoX(3);
            this.setMinoY(this.currentMino.getMinY(rotation));
        }
    }


    public void setMino(){
        int[][][] mino=this.currentMino.get();

        for(int i=0;i<mino[rotation].length;i++){
            for(int j=0;j<mino[rotation][i].length;j++){
                if(mino[rotation][i][j]!=0){
                    if(minoY>=this.currentMino.getMaxY(rotation)){
                        this.field[this.currentMino.getMaxY(rotation)+i][minoX+j]=this.currentMino.getId();
                    }else{
                        this.field[minoY+i][minoX+j]=this.currentMino.getId();
                    }

                }
            }
        }

        remove();

        this.currentMino=(Mino)this.minos.next.remove(0);
        this.canHold=true;
        this.setRotation(0);
        this.setMinoX(3);
        this.setMinoY(this.currentMino.getMinY(rotation));

        if(this.minos.next.size()<7)this.minos.make7();
    }

    public void remove(){
        for(int i=0;i<FIELD_Y;i++){
            int ll=0;
            for(int j=0;j<FIELD_X&&this.field[i][j]!=0;j++){
                ll++;
                if(ll==10){
                    this.field[i][j]=0;
                    for(int k=i-1;0<=k;k--)for(int l=0;l<FIELD_X;l++)field[k+1][l]=field[k][l];
                }
            }
        }
    }

    public boolean canPlace(){
        int[][][] mino=this.currentMino.get();
        if(this.getMinoY()>=FIELD_Y-1)return true;
        for(int i=0;i<mino[rotation].length;i++){
            for(int j=0;j<mino[rotation][i].length;j++){
                if(mino[rotation][i][j]!=0){
                    if(minoY+i+1>=this.FIELD_Y)return true;
                    if(this.field[minoY+i+1][minoX+j]!=0)return true;
                }
            }
        }
        return false;
    }

    public boolean canPlace(int y){
        int[][][] mino=this.currentMino.get();
        for(int i=0;i<mino[rotation].length;i++){
            for(int j=0;j<mino[rotation][i].length;j++){
                if(mino[rotation][i][j]!=0){
                    if(y+i+1>=FIELD_Y)return true;
                    if(this.field[y+i+1][minoX+j]!=0)return true;
                }
            }
        }
        return false;
    }

    public boolean canMove(int direction){
        int[][][] mino=this.currentMino.get();
        for(int i=0;i<mino[rotation].length;i++){
            for(int j=0;j<mino[rotation][i].length;j++){
                if(mino[rotation][i][j]!=0){
                    if(direction==0){
                        if(minoY>=this.currentMino.getMaxY(rotation)&&this.field[this.currentMino.getMaxY(rotation)+i][minoX+j+1]!=0)return false;
                        if(this.field[minoY+i][minoX+j+1]!=0)return false;
                    }else if(direction==1){
                        if(minoY>=this.currentMino.getMaxY(rotation)&&this.field[this.currentMino.getMaxY(rotation)+i][minoX+j-1]!=0)return false;
                        if(this.field[minoY+i][minoX+j-1]!=0)return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkSpace(int x, int y, int rotation) {
        int[][][] mino=this.currentMino.get();

        for (int i=0; i < mino[rotation].length; i++) {
            for (int j = 0; j < mino[rotation][i].length; j++) {
                if (mino[rotation][i][j] != 0) {
                    if (y + i >= this.FIELD_Y) return false;
                    if (x + j < 0) return false;
                    if (x + j >= this.FIELD_X) return false;
                    if (y + i < 0) return false;
                    if (this.field[y + i][x + j] != 0) return false;

                }
            }
        }
        return true;
    }

    public void setMinoX(int x){
        this.minoX=x;
    }

    public void setMinoY(int y){
        this.minoY=y;
    }

    public void setRotation(int rotation){
        this.rotation=rotation;
    }

    public int getMinoX(){
        return this.minoX;
    }

    public int getMinoY(){
        return this.minoY;
    }

    public int getRotation(){
        return this.rotation;
    }
}
