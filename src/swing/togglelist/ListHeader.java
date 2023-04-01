package swing.togglelist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

public class ListHeader extends JComponent {

    public ListHeader() {
        setBackground(Color.decode("#0072ff"));
        setForeground(Color.decode("#00c6ff"));
        setPreferredSize(new Dimension(50, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 15, 15));
        g2.setPaint(new GradientPaint(0, 0, getBackground(), width, 0, getForeground()));
        area.add(new Area(new Rectangle2D.Double(0, 15, width, height - 15)));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }
}
