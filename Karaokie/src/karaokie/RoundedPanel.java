package karaokie;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private int arcWidth, arcHeight, w, h;
    private Color backgroundColor;
    private float oppa;

    public RoundedPanel(int arcWidth, int arcHeight, int w, int h, Color backgroundColor, float oppa) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.backgroundColor = backgroundColor;
        this.h = h;
        this.w = w;
        this.oppa = oppa;
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 21, 21));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(arcWidth, arcHeight);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setComposite(AlphaComposite.SrcOver.derive(oppa));
        
        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        
        graphics.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }
}
