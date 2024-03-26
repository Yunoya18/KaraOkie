package karaokie;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private int arcWidth, arcHeight, w, h;
    private Color backgroundColor;

    public RoundedPanel(int arcWidth, int arcHeight, int w, int h, Color backgroundColor) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.backgroundColor = backgroundColor;
        this.h = h;
        this.w = w;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(arcWidth, arcHeight);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }
}
