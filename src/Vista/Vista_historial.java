package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import comun.Helper_shortcuts;
import Controlador.ControladorPedido;

public class Vista_historial extends javax.swing.JInternalFrame {

    private final ControladorPedido controladorPedido;

    public Vista_historial(ControladorPedido controladorPedido) {
        initComponents();
        this.controladorPedido = controladorPedido;
        teclas_rapidas();
    }

    private void teclas_rapidas() {
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape", null, null).frame_putKeys();
        tablaHistorial.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "imprimir");
        tablaHistorial.getActionMap().put("imprimir", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controladorPedido.imprimir_historial("Ticket");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Historial de pedidos");
        setMinimumSize(new java.awt.Dimension(900, 480));
        setPreferredSize(new java.awt.Dimension(870, 450));

        jPanel2.setBackground(new java.awt.Color(43, 112, 72));
        jPanel2.setPreferredSize(new java.awt.Dimension(1060, 410));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaHistorial=comun.Common.no_edit_table(tablaHistorial);
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaHistorialMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaHistorial);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 790, 300));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Visualiza el historial de pedidos realizados durante el día:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 100, -1));

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 100, -1));

        btnDetalle.setText("Ver detalle");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });
        jPanel2.add(btnDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 100, -1));

        btnImprimir1.setText("Imprimir historial");
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        controladorPedido.editar_pedido_historial();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        controladorPedido.imprimir_historial("Ticket");
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        controladorPedido.ver_detalle_historial();
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        controladorPedido.imprimir_historial("Historial");
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void tablaHistorialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaHistorialMousePressed
        controladorPedido.seleccionar_item_historial();
        controladorPedido.habilitar_edicion();
    }//GEN-LAST:event_tablaHistorialMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalle;
    public javax.swing.JButton btnEditar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
