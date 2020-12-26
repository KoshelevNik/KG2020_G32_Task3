package window;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 540);
        frame.setResizable(false);
        frame.add(new DrawPanel());
        frame.setVisible(true);
    }
}
