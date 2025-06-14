package Vista;

import comun.Common;
import java.awt.Color;
import Controlador.ControladorVentas;

public class Vista_ventas extends javax.swing.JInternalFrame {

    private final ControladorVentas controladorVentas;

    public Vista_ventas(ControladorVentas controladorVentas) {
        initComponents();
        this.controladorVentas = controladorVentas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupoComprobante = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        rdoBoleta = new javax.swing.JRadioButton();
        rdoFactura = new javax.swing.JRadioButton();
        btnAnular = new javax.swing.JButton();
        btnCompletar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblPedido = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTotal_orden = new javax.swing.JLabel();
        lblTotal_orden1 = new javax.swing.JLabel();
        cboPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnEditar_cliente = new javax.swing.JButton();
        lblVuelto = new javax.swing.JLabel();
        btnBorrar_cliente1 = new javax.swing.JButton();
        rdoNinguno = new javax.swing.JRadioButton();
        btnEditar = new javax.swing.JButton();
        btnPedido = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNum_comprobante = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPaga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelComp = new javax.swing.JPanel();
        lblComp = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setTitle("Caja - Registro de ventas");
        setMinimumSize(new java.awt.Dimension(1200, 680));
        setPreferredSize(new java.awt.Dimension(1200, 650));

        jPanel2.setBackground(new java.awt.Color(144, 198, 149));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPendientes=comun.Common.no_edit_table(tablaPendientes);
        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° pedido", "Fecha", "Vendedor", "Cliente", "Importe", "Comprobante"
            }
        ));
        tablaPendientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPendientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPendientes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 690, 150));

        rdoGrupoComprobante.add(rdoBoleta);
        rdoBoleta.setSelected(true);
        rdoBoleta.setText("Boleta");
        rdoBoleta.setEnabled(false);
        rdoBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBoletaActionPerformed(evt);
            }
        });
        jPanel2.add(rdoBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        rdoGrupoComprobante.add(rdoFactura);
        rdoFactura.setText("Factura");
        rdoFactura.setEnabled(false);
        rdoFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFacturaActionPerformed(evt);
            }
        });
        jPanel2.add(rdoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

        btnAnular.setBackground(new java.awt.Color(255, 0, 0));
        btnAnular.setForeground(new java.awt.Color(255, 255, 255));
        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btnAnular.setText("Anular venta");
        btnAnular.setAlignmentY(1.0F);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, 160, 30));

        btnCompletar.setBackground(new java.awt.Color(0, 102, 0));
        btnCompletar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/check.png"))); // NOI18N
        btnCompletar.setText("Completar venta");
        btnCompletar.setAlignmentY(1.0F);
        btnCompletar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCompletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 520, 160, 30));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setAlignmentY(1.0F);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, 150, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("IGV 18%:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 420, -1, -1));

        lblPedido.setBackground(new java.awt.Color(255, 255, 255));
        lblPedido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPedido.setText("-");
        jPanel2.add(lblPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 100, -1));

        lblSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        lblSubtotal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblSubtotal.setText("0.00");
        jPanel2.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 400, 80, -1));

        lblIgv.setBackground(new java.awt.Color(255, 255, 255));
        lblIgv.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblIgv.setText("0.00");
        jPanel2.add(lblIgv, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 420, 80, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblTotal_orden.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblTotal_orden.setForeground(new java.awt.Color(0, 204, 0));
        lblTotal_orden.setText("0.00");

        lblTotal_orden1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblTotal_orden1.setForeground(new java.awt.Color(0, 204, 0));
        lblTotal_orden1.setText("S/.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblTotal_orden1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal_orden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal_orden)
                    .addComponent(lblTotal_orden1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 400, 50));

        cboPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Crédito" }));
        cboPago.setEnabled(false);
        jPanel2.add(cboPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 250, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Lista de pedidos:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, -1, -1));

        btnRefresh.setText("Actualizar");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        tablaDetalle=comun.Common.no_edit_table(tablaDetalle);
        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 690, 300));

        jLabel10.setText("Código:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 173, -1, -1));

        btnEditar_cliente.setText("...");
        btnEditar_cliente.setEnabled(false);
        btnEditar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 210, -1, -1));

        lblVuelto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVuelto.setText("0.00");
        jPanel2.add(lblVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 335, -1, -1));

        btnBorrar_cliente1.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar_cliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnBorrar_cliente1.setEnabled(false);
        btnBorrar_cliente1.setPreferredSize(new java.awt.Dimension(53, 23));
        btnBorrar_cliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar_cliente1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar_cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 210, 35, 28));

        rdoGrupoComprobante.add(rdoNinguno);
        rdoNinguno.setText("Ninguno");
        rdoNinguno.setEnabled(false);
        rdoNinguno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNingunoActionPerformed(evt);
            }
        });
        jPanel2.add(rdoNinguno, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, -1, -1));

        btnEditar.setText("Editar pedido");
        btnEditar.setAlignmentY(1.0F);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 150, 30));

        btnPedido.setText("Nuevo pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btnPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 120, -1));

        txtCliente.setEnabled(false);
        jPanel2.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 270, -1));

        jLabel1.setText("N° doc:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 133, -1, -1));

        txtCodigo.setEnabled(false);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 120, -1));

        jLabel12.setText("Cliente:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 213, -1, -1));

        jLabel13.setText("Pago:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 253, -1, -1));

        txtNum_comprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNum_comprobanteKeyTyped(evt);
            }
        });
        jPanel2.add(txtNum_comprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 120, -1));

        jLabel14.setText("Calcular:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, -1, -1));

        jLabel15.setText("Paga con:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 333, -1, -1));

        txtPaga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagaKeyTyped(evt);
            }
        });
        jPanel2.add(txtPaga, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 120, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Subtotal:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Pedido N°");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 90, -1));

        panelComp.setBackground(new java.awt.Color(255, 102, 51));

        lblComp.setBackground(new java.awt.Color(255, 255, 255));
        lblComp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblComp.setForeground(new java.awt.Color(255, 255, 255));
        lblComp.setText("FACTURA");

        javax.swing.GroupLayout panelCompLayout = new javax.swing.GroupLayout(panelComp);
        panelComp.setLayout(panelCompLayout);
        panelCompLayout.setHorizontalGroup(
            panelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCompLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblComp)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelCompLayout.setVerticalGroup(
            panelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCompLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblComp)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(panelComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 25, 180, 30));

        jLabel16.setText("Vuelto:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 333, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        controladorVentas.anular();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed
        controladorVentas.completar();
    }//GEN-LAST:event_btnCompletarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        controladorVentas.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaPendientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPendientesMousePressed
        controladorVentas.abrir_pedido();
    }//GEN-LAST:event_tablaPendientesMousePressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        controladorVentas.mostrar(null);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar_clienteActionPerformed
        controladorVentas.dialogo_agregar_cliente();
    }//GEN-LAST:event_btnEditar_clienteActionPerformed

    private void btnBorrar_cliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar_cliente1ActionPerformed
        controladorVentas.borrar_cliente();
    }//GEN-LAST:event_btnBorrar_cliente1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        controladorVentas.editar_pedido();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        controladorVentas.nuevo_pedido();
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void rdoBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBoletaActionPerformed
        panelComp.setBackground(new Color(0, 153, 153));
        lblComp.setText("BOLETA");
        panelComp.setVisible(true);
    }//GEN-LAST:event_rdoBoletaActionPerformed

    private void rdoFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFacturaActionPerformed
        panelComp.setBackground(new Color(255, 102, 51));
        lblComp.setText("FACTURA");
        panelComp.setVisible(true);
    }//GEN-LAST:event_rdoFacturaActionPerformed

    private void rdoNingunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNingunoActionPerformed
        panelComp.setVisible(false);
    }//GEN-LAST:event_rdoNingunoActionPerformed

    private void txtPagaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaKeyReleased
        controladorVentas.calcular_vuelto();
    }//GEN-LAST:event_txtPagaKeyReleased

    private void txtPagaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagaKeyTyped
        Common.validar_decimal(evt);
    }//GEN-LAST:event_txtPagaKeyTyped

    private void txtNum_comprobanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNum_comprobanteKeyTyped
        Common.validar_entero(evt);
    }//GEN-LAST:event_txtNum_comprobanteKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    public javax.swing.JButton btnBorrar_cliente1;
    private javax.swing.JButton btnCompletar;
    private javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEditar_cliente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnRefresh;
    public javax.swing.JComboBox<String> cboPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblComp;
    public javax.swing.JLabel lblIgv;
    public javax.swing.JLabel lblPedido;
    public javax.swing.JLabel lblSubtotal;
    public javax.swing.JLabel lblTotal_orden;
    public static javax.swing.JLabel lblTotal_orden1;
    public javax.swing.JLabel lblVuelto;
    public javax.swing.JPanel panelComp;
    public javax.swing.JRadioButton rdoBoleta;
    public javax.swing.JRadioButton rdoFactura;
    private javax.swing.ButtonGroup rdoGrupoComprobante;
    public javax.swing.JRadioButton rdoNinguno;
    public javax.swing.JTable tablaDetalle;
    public javax.swing.JTable tablaPendientes;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtNum_comprobante;
    public javax.swing.JTextField txtPaga;
    // End of variables declaration//GEN-END:variables
}
