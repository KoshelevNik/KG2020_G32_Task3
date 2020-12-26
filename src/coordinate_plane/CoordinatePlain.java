package coordinate_plane;

import draw_algorithms.Bresenham;

import java.awt.*;

public class CoordinatePlain {

    private final int[][] coordinateXY = {{0, 500, 500, 500}, {0, 0, 0, 500}};

    private int i = 0;
    private int j = 0;
    private int size = 30;

    private int iX = 1;
    private int segmentX = 125;
    private int a = 0;

    private int iY = 1;
    private double segmentY = 30;
    private int b = 0;

    public void draw(Graphics g, Bresenham coordinateDrawer) {
        g.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        coordinateDrawer.drawLine(coordinateXY[0][0], coordinateXY[0][1], coordinateXY[0][2], coordinateXY[0][3], Color.BLACK);
        coordinateDrawer.drawLine(coordinateXY[0][0], coordinateXY[0][1] - 1, coordinateXY[0][2], coordinateXY[0][3] - 1, Color.BLACK);
        coordinateDrawer.drawLine(coordinateXY[1][0], coordinateXY[1][1], coordinateXY[1][2], coordinateXY[1][3], Color.BLACK);
        coordinateDrawer.drawLine(coordinateXY[1][0] + 1, coordinateXY[1][1], coordinateXY[1][2] + 1, coordinateXY[1][3], Color.BLACK);
        int k = iX;
        while (k * size - 10 - a >= 0) {
            k--;
        }
        iX = k + 1;
        k = iX;
        while (k * size - 10 - a <= 500) {
            if (k * size - 10 - a >= 0) {
                g.drawString(String.valueOf(segmentX * k), k * size - 10 - a, 500 - g.getFont().getSize());
            } else {
                iX++;
            }
            k++;
        }
        k = iY;
        while (k * size + b - 5 >= 0) {
            k--;
        }
        iY = k + 1;
        k = iY;
        while (505 - k * size - b >= 0) {
            if (k * size + b - 5 >= 0) {
                g.drawString(String.valueOf(segmentY * k), 10, 505 - k * size - b);
            } else {
                iY++;
            }
            k++;
        }
        k = i;
        while (coordinateXY[0][1] - k * size >= 0) {
            if (k * size >= 0) {
                coordinateDrawer.drawLine(0, coordinateXY[0][1] - k * size, 500, coordinateXY[0][1] - k * size, Color.GRAY);
            } else {
                i++;
            }
            k++;
        }
        k = j;
        while (coordinateXY[1][0] + k * size <= 500) {
            if (k * size >= 0) {
                coordinateDrawer.drawLine(coordinateXY[1][0] + k * size, 0, coordinateXY[1][0] + k * size, 500, Color.GRAY);
            } else {
                j++;
            }
            k++;
        }
    }

    public void move(int dX, int dY) {
        if (coordinateXY[0][1] + dY >= 500) {
            coordinateXY[0][1] += dY;
            coordinateXY[0][3] += dY;
            b -= dY;
        }
        if (coordinateXY[1][0] + dX <= 0) {
            coordinateXY[1][0] += dX;
            coordinateXY[1][2] += dX;
            a -= dX;
        }
    }

    public void toScale(int dSize) {
        if (segmentX != 1 || dSize > 0) {
            size -= dSize;
            if (size > 125) {
                size -= 100;
                segmentX /= 5;
                segmentY /= 5;
            } else if (size < 25) {
                size += 100;
                segmentX *= 5;
                segmentY *= 5;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int[][] getCoordinateXY() {
        return coordinateXY;
    }

    public int getSegmentX() {
        return segmentX;
    }

    public double getSegmentY() {
        return segmentY;
    }
}
