package draw_algorithms;

import draw_algorithms.pixel_drawer.PixelDrawer;

import java.awt.*;

public class Bresenham {
    private final PixelDrawer pixelDrawer;

    public Bresenham(PixelDrawer pixelDrawer) {
        this.pixelDrawer = pixelDrawer;
    }

    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        int x = x1;
        int y = y1;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int differenceX = (x2 - x1 > 0) ? 1 : -1;
        int differenceY = (y2 - y1 > 0) ? 1 : -1;
        if (dx > dy) {
            int e = 2 * dy - dx;
            for (int i = 0; i <= dx; i++) {
                pixelDrawer.drawPixel(x, y, color);
                if (e > 0) {
                    y += differenceY;
                    e += 2 * dy - 2 * dx;
                } else {
                    e += 2 * dy;
                }
                x += differenceX;
            }
        } else {
            int e = 2 * dx - dy;
            for (int i = 0; i <= dy; i++) {
                pixelDrawer.drawPixel(x, y, color);
                if (e > 0) {
                    x += differenceX;
                    e += 2 * dx - 2 * dy;
                } else {
                    e += 2 * dx;
                }
                y += differenceY;
            }
        }
    }
}
