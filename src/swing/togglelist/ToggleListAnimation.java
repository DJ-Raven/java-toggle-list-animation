package swing.togglelist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JComponent;
import net.miginfocom.swing.MigLayout;

public class ToggleListAnimation extends JComponent {

    public ToggleListAnimation() {
        init();
    }
    private MigLayout layout;

    private void init() {
        setBackground(Color.WHITE);
        layout = new MigLayout("wrap, fillx, inset 0, hidemode 1", "[fill]", "[top]0[]");
        setLayout(layout);
    }

    public MigLayout getMigLayout() {
        return layout;
    }

    @Override
    public Component add(Component comp) {
        Component com = super.add(comp);
        checkComponent(comp);
        return com;
    }

    private void checkComponent(Component comp) {
        if (comp instanceof Item) {
            Item item = (Item) comp;
            if (item.getSubItem() != null) {
                item.setListAnimation(this);
                for (Component com : item.getSubItem()) {
                    if (item.getToggleButton().isSelected()) {
                        super.add(com);
                    } else {
                        super.add(com, "h 0!");
                    }
                    if (com instanceof Item) {
                        checkComponent(com);
                    }
                }
                revalidate();
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        if (isOpaque()) {
            grphcs.setColor(getBackground());
            grphcs.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(grphcs);
    }

}
