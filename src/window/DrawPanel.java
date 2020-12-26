package window;

import candle.Candle;
import candle.Diagram;
import coordinate_plane.CoordinatePlain;
import draw_algorithms.Bresenham;
import draw_algorithms.pixel_drawer.GraphicsPixelDrawer;
import file_work.FileWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class DrawPanel extends JPanel implements MouseWheelListener, MouseMotionListener {

    private final CoordinatePlain coordinatePlain = new CoordinatePlain();

    private final Diagram diagram = new Diagram(FileWorker.getData(), coordinatePlain, coordinatePlain.getSegmentX(), coordinatePlain.getSegmentY());

    private int xM = 0;
    private int yM = 0;

    public DrawPanel() {
        addMouseMotionListener(this);
        addMouseWheelListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        coordinatePlain.draw(g, new Bresenham(new GraphicsPixelDrawer(g)));
        diagram.draw(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        coordinatePlain.move(e.getX() - xM, e.getY() - yM);
        diagram.move(e.getX() - xM, e.getY() - yM);
        repaint();
        xM = e.getX();
        yM = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xM = e.getX();
        yM = e.getY();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        coordinatePlain.toScale(e.getWheelRotation());
        diagram.toScale(e.getWheelRotation());
        repaint();
    }
}
