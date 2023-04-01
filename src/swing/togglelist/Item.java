package swing.togglelist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import toggle.ToggleAdapter;
import toggle.ToggleButton;

public abstract class Item extends JPanel {

    public ToggleListAnimation getListAnimation() {
        return listAnimation;
    }

    private ToggleListAnimation listAnimation;

    public abstract Component[] getSubItem();

    public abstract ToggleButton getToggleButton();

    public void show(Component components[], float animated, boolean selected) {
        int width = (int) (100f * animated);
        int gap = (int) ((50 * (1f - (animated))));
        for (Component com : components) {
            int height = (int) (com.getPreferredSize().height * animated);
            getListAnimation().getMigLayout().setComponentConstraints(com, "h " + height + "!, w " + width + "%!, gap " + gap + "%! n 0px 0px");
            if (com instanceof Item) {
                Item item = (Item) com;
                if (item.getSubItem() != null) {
                    if ((!selected && item.getToggleButton().isSelected()) || (selected && item.getToggleButton().isSelected())) {
                        show(item.getSubItem(), animated, item.getToggleButton().isSelected());
                    }
                }
            }
        }
        getListAnimation().revalidate();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(230, 230, 230));
        g2.drawLine(0, 0, 0, getHeight() - 1);
        g2.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
        g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        g2.dispose();
    }

    public void setListAnimation(ToggleListAnimation listAnimation) {
        this.listAnimation = listAnimation;
        getToggleButton().addEventToggleSelected(new ToggleAdapter() {
            @Override
            public void onAnimated(float animated) {
                show(getSubItem(), animated, getToggleButton().isSelected());
            }
        });
    }

    public static class SubItem extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(new Color(230, 230, 230));
            g2.setColor(new Color(230, 230, 230));
            g2.drawLine(0, 0, 0, getHeight() - 1);
            g2.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
            g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
            g2.dispose();
        }
    }
}
