package candle;

import coordinate_plane.CoordinatePlain;
import draw_algorithms.Bresenham;
import draw_algorithms.pixel_drawer.GraphicsPixelDrawer;

import java.awt.*;
import java.util.ArrayList;

public class Diagram {

    private final ArrayList<Candle> candles = new ArrayList<>();
    private final ArrayList<Integer> data;

    private final CoordinatePlain coordinatePlain;

    private int size = 30;

    private int i = 0;

    private int segmentX;
    private double segmentY;

    public Diagram(ArrayList<Integer> data, CoordinatePlain coordinatePlain, int segmentX, double segmentY) {
        this.data = data;
        this.coordinatePlain = coordinatePlain;
        this.segmentX = segmentX;
        this.segmentY = segmentY;
        intDataToCandle();
    }

    public void toScale(int dSize) {
        if (segmentX > 1 || dSize > 0) {
            size -= dSize;
            if (size > 125) {
                size -= 100;
                segmentX /= 5;
                segmentY /= 5;
                candles.clear();
                intDataToCandle();
            } else if (size < 25) {
                size += 100;
                segmentX *= 5;
                segmentY *= 5;
                candles.clear();
                intDataToCandle();
            } else {
                for (Candle v : candles) {
                    v.setSize(size);
                }
            }
        }
    }

    public void draw(Graphics g) {
        Bresenham bresenham = new Bresenham(new GraphicsPixelDrawer(g));
        int j = i;
        if (segmentY > 1) {
            while (j * size + candles.get(0).getCoordinateX() >= 0) {
                j--;
            }
            i = j + 1;
            j = i;
            while (j * size + candles.get(0).getCoordinateX() <= 500 && j < candles.size()) {
                if (j * size + candles.get(0).getCoordinateX() >= 0) {
                    candles.get(j).draw(bresenham);
                } else {
                    i++;
                }
                j++;
            }
        }
    }

    public void move(int dX, int dY) {
        if (candles.get(0).getCoordinateY() + dY >= 500) {
            for (Candle v : candles) {
                v.setCoordinateY(v.getCoordinateY() + dY);
            }
        }
        if (candles.get(0).getCoordinateX() + dX <= 0) {
            for (Candle v : candles) {
                v.setCoordinateX(v.getCoordinateX() + dX);
            }
        }
    }

    private void intDataToCandle() {
        for (int i = 0; i < data.size() / segmentX; i++) {
            int open = 0;
            int close = 0;
            int max = 0;
            int min = data.get(0);
            for (int j = i * segmentX; j < i * segmentX + segmentX; j++) {
                if (j == i * segmentX) {
                    open = data.get(j);
                } else if (j == i * segmentX + segmentX - 1) {
                    close = data.get(j);
                }
                if (data.get(j) > max) {
                    max = data.get(j);
                }
                if (data.get(j) < min) {
                    min = data.get(j);
                }
            }
            candles.add(new Candle(size, open, close, max, min, i, coordinatePlain.getCoordinateXY()[1][0], coordinatePlain.getCoordinateXY()[0][1], segmentY));
        }
    }
}
