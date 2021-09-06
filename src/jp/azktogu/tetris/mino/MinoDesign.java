package jp.azktogu.tetris.mino;

import java.awt.*;

public class MinoDesign {

    public void draw(int minoId, Graphics g, int x, int y, int blockSize) {
        Graphics2D g2 = (Graphics2D)g;

        Color c = getColor(minoId);
        float[] hsb = new float[3];
        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsb);

        g.setColor(c);
        g.fillRect(x, y, blockSize, blockSize);
        drawSide(minoId, g, x, y, blockSize);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g2.drawRect(x, y, blockSize, blockSize);
    }

    public void drawShadow(int minoId, Graphics g, int x, int y, int blockSize) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(getColor(minoId));
        g2.setStroke(new BasicStroke(1));
        g2.drawRect(x, y, blockSize-2, blockSize-2);
    }

    public void drawSide(int minoId, Graphics g, int x, int y, int blockSize) {
        Color c = getColor(minoId);
        float[] hsb = new float[3];
        Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsb);

        if (minoId != 8) { g.setColor(new Color(Color.HSBtoRGB(hsb[0], hsb[1], hsb[2] - 0.55F))); }
        else { g.setColor(Color.GRAY); }
        for (int i = 0; i <= blockSize / 6; i++) {
            g.drawLine(x + i, blockSize + y - i, x + blockSize - i, blockSize + y - i);
            g.drawLine(blockSize + x - i, y + i, blockSize + x - i, blockSize + y - i);
        }
        if (minoId != 8) { g.setColor(new Color(Color.HSBtoRGB(hsb[0], hsb[1] - 0.55F, hsb[2]))); }
        else { g.setColor(Color.WHITE); }
        for (int i = 0; i <= blockSize / 6; i++) {
            g.drawLine(x + i, y + i, x + blockSize - i, y + i);
            g.drawLine(x + i, y + i, x + i, blockSize + y - i);
        }
    }

    public Color getColor(int id) {
        if (id == Mino.Type.I.getId()) return Color.CYAN;
        if (id == Mino.Type.T.getId()) return Color.MAGENTA;
        if (id == Mino.Type.S.getId()) return Color.GREEN;
        if (id == Mino.Type.Z.getId()) return Color.RED;
        if (id == Mino.Type.L.getId()) return Color.ORANGE;
        if (id == Mino.Type.J.getId()) return Color.BLUE;
        if (id == Mino.Type.O.getId()) return Color.YELLOW;
        if (id == Mino.Type.M.getId()) return new Color(219, 219, 219);
        return Color.BLACK;
    }
}