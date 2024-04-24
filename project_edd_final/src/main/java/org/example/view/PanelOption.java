package org.example.view;

import java.awt.GridLayout;

/**
 *
 * @author giovanic
 */
public class PanelOption extends javax.swing.JPanel {

    /**
     * Creates new form PanelOption
     */
    public PanelOption() {
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        origenLb = new javax.swing.JLabel();
        origenComboBox = new javax.swing.JComboBox<>();
        destinoLb = new javax.swing.JLabel();
        destinoComboBox = new javax.swing.JComboBox<>();
        irBtn = new javax.swing.JButton();
        tipoLb = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox<>();
        btnGenArbol = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(300, 600));
        setMinimumSize(new java.awt.Dimension(300, 600));
        setPreferredSize(new java.awt.Dimension(300, 600));

        origenLb.setFont(new java.awt.Font("Nimbus Sans", 1, 18)); // NOI18N
        origenLb.setForeground(new java.awt.Color(0, 0, 0));
        origenLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        origenLb.setText("ORIGEN");
        origenLb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        origenComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        origenComboBox.setMaximumSize(new java.awt.Dimension(32767, 35));
        origenComboBox.setMinimumSize(new java.awt.Dimension(82, 35));
        origenComboBox.setPreferredSize(new java.awt.Dimension(82, 35));

        destinoLb.setFont(new java.awt.Font("Nimbus Sans", 1, 18)); // NOI18N
        destinoLb.setForeground(new java.awt.Color(0, 0, 0));
        destinoLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        destinoLb.setText("DESTINO");
        destinoLb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        destinoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        destinoComboBox.setMaximumSize(new java.awt.Dimension(32767, 35));
        destinoComboBox.setMinimumSize(new java.awt.Dimension(82, 35));
        destinoComboBox.setPreferredSize(new java.awt.Dimension(82, 35));

        irBtn.setText("INICIAR RECORRIDO");
        irBtn.setMaximumSize(new java.awt.Dimension(84, 35));
        irBtn.setMinimumSize(new java.awt.Dimension(84, 35));
        irBtn.setPreferredSize(new java.awt.Dimension(84, 35));
        irBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irBtnActionPerformed(evt);
            }
        });

        tipoLb.setFont(new java.awt.Font("Nimbus Sans", 1, 18)); // NOI18N
        tipoLb.setForeground(new java.awt.Color(0, 0, 0));
        tipoLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tipoLb.setText("TIPO");
        tipoLb.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tipoComboBox.setMaximumSize(new java.awt.Dimension(32767, 35));
        tipoComboBox.setMinimumSize(new java.awt.Dimension(82, 35));
        tipoComboBox.setPreferredSize(new java.awt.Dimension(82, 35));

        btnGenArbol.setText("GENERAR ARBOL");
        btnGenArbol.setMaximumSize(new java.awt.Dimension(84, 35));
        btnGenArbol.setMinimumSize(new java.awt.Dimension(84, 35));
        btnGenArbol.setPreferredSize(new java.awt.Dimension(84, 35));
        btnGenArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenArbolActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO RECORRIDO");
        btnNuevo.setMaximumSize(new java.awt.Dimension(84, 35));
        btnNuevo.setMinimumSize(new java.awt.Dimension(84, 35));
        btnNuevo.setPreferredSize(new java.awt.Dimension(84, 35));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(destinoLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(origenComboBox, 0, 270, Short.MAX_VALUE)
                            .addComponent(origenLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tipoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(irBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(btnGenArbol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(origenLb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(origenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(destinoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(destinoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(tipoLb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(irBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenArbol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        origenComboBox.getAccessibleContext().setAccessibleName("");
        destinoComboBox.getAccessibleContext().setAccessibleName("");
        tipoComboBox.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void irBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irBtnActionPerformed
        System.out.println("PRUEBA BOTON <<IR>>");
    }//GEN-LAST:event_irBtnActionPerformed

    private void btnGenArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenArbolActionPerformed
        System.out.println("<<NUEVO ARBOL>>");
    }//GEN-LAST:event_btnGenArbolActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        System.out.println("<<NUEVO RECORRIDO>>");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void organizar() {
        setLayout(new GridLayout(6, 2, 15, 25));
        add(origenLb);
        add(origenComboBox);
        add(destinoLb);
        add(destinoComboBox);
        add(irBtn);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenArbol;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> destinoComboBox;
    private javax.swing.JLabel destinoLb;
    private javax.swing.JButton irBtn;
    private javax.swing.JComboBox<String> origenComboBox;
    private javax.swing.JLabel origenLb;
    private javax.swing.JComboBox<String> tipoComboBox;
    private javax.swing.JLabel tipoLb;
    // End of variables declaration//GEN-END:variables
}
