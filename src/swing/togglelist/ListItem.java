package swing.togglelist;

import java.awt.Component;
import toggle.ToggleButton;

public class ListItem extends Item {

    private final Component[] components;

    public ListItem() {
        initComponents();
        components = new Component[]{new SubListItem(), new SubListItem(), new ListItem(new SubListItem(), new ListItem(new SubListItem()))};
    }

    public ListItem(Component... components) {
        initComponents();
        this.components = components;
    }

    @Override
    public Component[] getSubItem() {
        return components;
    }

    @Override
    public ToggleButton getToggleButton() {
        return toggleButton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggleButton = new toggle.ToggleButton();
        lbTitle1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        toggleButton.setForeground(new java.awt.Color(0, 198, 255));

        lbTitle1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbTitle1.setForeground(new java.awt.Color(99, 98, 98));
        lbTitle1.setText("Description");

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(99, 98, 98));
        lbTitle.setText("Title");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(lbTitle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(toggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(toggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTitle1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private toggle.ToggleButton toggleButton;
    // End of variables declaration//GEN-END:variables
}
