package candle;

import draw_algorithms.Bresenham;

import java.awt.*;

public class Candle {

    private final Color color;

    private int size;

    private final int open;
    private final int close;

    private final int max;
    private final int min;

    private final int i;

    private int coordinateX;
    private int coordinateY;

    private final double segmentY;

    public Candle(int size, int open, int close, int max, int min, int i, int coordinateX, int coordinateY, double segmentY) {
        this.size = size;
        this.open = open;
        this.close = close;
        this.max = max;
        this.min = min;
        this.i = i;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.segmentY = segmentY;
        if (open < close) {
            color = Color.BLUE;
        } else {
            color = Color.RED;
        }
    }

    public void draw(Bresenham bresenham) {
        bresenham.drawLine(i * size + size / 2 + coordinateX, (int) (coordinateY - min * size / segmentY), i * size + size / 2 + coordinateX, (int) (coordinateY - Math.min(close, open) * size / segmentY), color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, (int) (coordinateY - Math.min(close, open) * size / segmentY), i * size + size / 5 + coordinateX, (int) (coordinateY - Math.max(close, open) * size / segmentY), color);
        int x1 = i * size + 4 * size / 5;
        bresenham.drawLine(x1 + coordinateX, (int) (coordinateY - Math.min(close, open) * size / segmentY), x1 + coordinateX, (int) (coordinateY - Math.max(close, open) * size / segmentY), color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, (int) (coordinateY - close * size / segmentY), x1 + coordinateX, (int) (coordinateY - close * size / segmentY), color);
        bresenham.drawLine(i * size + size / 5 + coordinateX, (int) (coordinateY - open * size / segmentY), x1 + coordinateX, (int) (coordinateY - open * size / segmentY), color);
        bresenham.drawLine(i * size + size / 2 + coordinateX, (int) (coordinateY - Math.max(close, open) * size / segmentY), i * size + size / 2 + coordinateX, (int) (coordinateY - max * size / segmentY), color);
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
