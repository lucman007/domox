package Vista;

import java.awt.event.KeyEvent;
import comun.Helper_shortcuts;
import Controlador.ControladorVentasCredito;
import Controlador.ControladorVentasResumen;

/**
 *
 * @author Luciano Ces
 */
public class Vista_ventas_detalle extends javax.swing.JDialog {

    private final ControladorVentasResumen logica_resumen;
    private final ControladorVentasCredito logica_credito;

    public Vista_ventas_detalle(java.awt.Frame parent, boolean modal, ControladorVentasResumen logica_resumen, ControladorVentasCredito logica_credito) {
        super(parent, modal);
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape").dialog_putKeys();
        initComponents();
        this.logica_resumen = logica_resumen;
        this.logica_credito = logica_credito;
        btnDireccion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnListo = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        cboComprobante = new javax.swing.JComboBox<>();
        btnImprimir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnDireccion = new javax.swing.JButton();
        txtVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPreventa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de venta");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(43, 112, 72));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnListo.setText("Listo");
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoActionPerformed(evt);
            }
        });
        jPanel1.add(btnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 140, -1));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Subtotal:");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, -1, -1));

        tablaDetalle=comun.Common.no_edit_table(tablaDetalle);
        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Cantidad", "Precio", "Importe"
            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 470, 220));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Venta:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(255, 255, 255));
        lblNumero.setText("1");
        jPanel1.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 120, -1));

        cboComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Guía" }));
        cboComprobante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboComprobanteItemStateChanged(evt);
            }
        });
        jPanel1.add(cboComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 130, -1));

        btnImprimir.setBackground(new java.awt.Color(0, 134, 22));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/print.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 57, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Igv:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Subtotal:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        lblSubtotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblSubtotal.setText("Subtotal:");
        jPanel1.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        lblIgv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIgv.setForeground(new java.awt.Color(255, 255, 255));
        lblIgv.setText("Subtotal:");
        jPanel1.add(lblIgv, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Venta N°");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btnDireccion.setText("Cambiar dirección destino");
        btnDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        txtVenta.setEditable(false);
        txtVenta.setEnabled(false);
        jPanel1.add(txtVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 330, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Imprimir:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 63, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Caja:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtCaja.setEditable(false);
        txtCaja.setEnabled(false);
        jPanel1.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 330, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Pre-venta:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        txtPreventa.setEditable(false);
        txtPreventa.setEnabled(false);
        jPanel1.add(txtPreventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 330, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoActionPerformed
        dispose();
    }//GEN-LAST:event_btnListoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (logica_resumen == null) {
            logica_credito.imprimir_venta();
        } else {
            logica_resumen.imprimir_venta();
        }
        dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireccionActionPerformed
        if (logica_resumen == null) {
            logica_credito.dialogo_cambiar_direccion();
        } else {
            logica_resumen.dialogo_cambiar_direccion();
        }
    }//GEN-LAST:event_btnDireccionActionPerformed

    private void cboComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboComprobanteItemStateChanged
        if (evt.getItem().equals("Guía")) {
            btnDireccion.setVisible(true);
        } else {
            btnDireccion.setVisible(false);
        }
    }//GEN-LAST:event_cboComprobanteItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDireccion;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnListo;
    public javax.swing.JComboBox<String> cboComprobante;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblIgv;
    public javax.swing.JLabel lblNumero;
    public javax.swing.JLabel lblSubtotal;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JTable tablaDetalle;
    public javax.swing.JTextField txtCaja;
    public javax.swing.JTextField txtPreventa;
    public javax.swing.JTextField txtVenta;
    // End of variables declaration//GEN-END:variables
}
