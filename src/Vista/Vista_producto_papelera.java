/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.KeyEvent;
import comun.Helper_shortcuts;
import Controlador.ControladorProducto;

/**
 *
 * @author Li
 */
public class Vista_producto_papelera extends javax.swing.JDialog {

    private final ControladorProducto controladorProducto;

    public Vista_producto_papelera(java.awt.Frame parent, boolean modal, ControladorProducto controladorProducto) {
        super(parent, modal);
        initComponents();
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape").dialog_putKeys();
        this.controladorProducto = controladorProducto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPapelera = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos eliminados");

        mainPanel.setBackground(new java.awt.Color(43, 112, 72));
        mainPanel.setPreferredSize(new java.awt.Dimension(1060, 410));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPapelera=comun.Common.no_edit_table(tablaPapelera);
        tablaPapelera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPapelera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPapelera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPapeleraMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPapelera);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 600, 320));

        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Lista de productos eliminados:");
        mainPanel.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, -1, -1));

        btnCancelar.setText("Listo");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        mainPanel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 100, 30));

        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        mainPanel.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        controladorProducto.restaurar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void tablaPapeleraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPapeleraMousePressed
        controladorProducto.seleccionar_item_papelera();

    }//GEN-LAST:event_tablaPapeleraMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel mainPanel;
    public javax.swing.JTable tablaPapelera;
    // End of variables declaration//GEN-END:variables

}
