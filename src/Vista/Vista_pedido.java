package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import comun.Helper_shortcuts;
import Controlador.ControladorPedido;

public class Vista_pedido extends javax.swing.JInternalFrame {

    private final ControladorPedido controladorPedido;

    public Vista_pedido(ControladorPedido controladorPedido) {
        initComponents();
        this.controladorPedido = controladorPedido;
        teclas_rapidas();
        advertencia.setVisible(false);
    }

    public ControladorPedido getLogica_pedido() {
        return controladorPedido;
    }

    private void teclas_rapidas() {
        new Helper_shortcuts(this, KeyEvent.VK_F5, "buscar", txtBuscar_producto, null).frame_putKeys();
        new Helper_shortcuts(this, KeyEvent.VK_F4, "historial", null, controladorPedido).frame_putKeys();

        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "generar");
        this.getActionMap().put("generar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controladorPedido.generar_pedido();
            }
        });

        tablaProductos.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        tablaProductos.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controladorPedido.agregar();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupoComprobante = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar_producto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnBorrar_cliente = new javax.swing.JButton();
        advertencia = new javax.swing.JPanel();
        lblAdvertencia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JButton();
        rdoBoleta = new javax.swing.JRadioButton();
        rdoFactura = new javax.swing.JRadioButton();
        btnAnular = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTotal_orden = new javax.swing.JLabel();
        lblTotal_orden1 = new javax.swing.JLabel();
        chkMayor = new javax.swing.JCheckBox();
        btnDescuentos = new javax.swing.JButton();
        lblCliente_ = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        btnBorrar_item = new javax.swing.JButton();
        chkImpresion_rapida = new javax.swing.JCheckBox();
        cboOperacion = new javax.swing.JComboBox<>();
        cboEmpleado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Registro de pedido");
        setMinimumSize(new java.awt.Dimension(1100, 650));
        setPreferredSize(new java.awt.Dimension(1100, 650));

        jPanel2.setBackground(new java.awt.Color(144, 198, 149));
        jPanel2.setPreferredSize(new java.awt.Dimension(1100, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Pre-venta:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 25, -1, -1));

        txtBuscar_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar_productoKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 240, -1));

        tablaProductos=comun.Common.no_edit_table(tablaProductos);
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código", "Nombre", "Características", "Categoría", "Precio", "Por mayor", "Costo", "Stock", "Stock bajo", "Imagen"
            }
        ));
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1020, 160));

        jLabel2.setText("Precio:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 563, -1, -1));

        txtPrecio.setText("0.00");
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 62, -1));

        jLabel3.setText("Cantidad:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 563, -1, -1));

        txtCantidad.setText("0");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 62, -1));

        btnBorrar_cliente.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/delete.png"))); // NOI18N
        btnBorrar_cliente.setPreferredSize(new java.awt.Dimension(53, 23));
        btnBorrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar_clienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 35, 28));

        advertencia.setBackground(new java.awt.Color(255, 51, 51));
        advertencia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdvertencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdvertencia.setForeground(new java.awt.Color(255, 255, 0));
        lblAdvertencia.setText("jLabel4");
        advertencia.add(lblAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, -1, -1));

        jPanel2.add(advertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 610, 20));

        tablaPedido=comun.Common.no_edit_table(tablaPedido);
        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total", "Stock", "Stock_min", "Descuentos"
            }
        ));
        tablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPedidoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPedido);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 610, 300));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Código:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        btnCliente.setText("Seleccionar cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, -1, -1));

        rdoGrupoComprobante.add(rdoBoleta);
        rdoBoleta.setSelected(true);
        rdoBoleta.setText("Boleta");
        jPanel2.add(rdoBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 263, -1, -1));

        rdoGrupoComprobante.add(rdoFactura);
        rdoFactura.setText("Factura");
        jPanel2.add(rdoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 263, -1, -1));

        btnAnular.setBackground(new java.awt.Color(255, 0, 0));
        btnAnular.setForeground(new java.awt.Color(255, 255, 255));
        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cancel.png"))); // NOI18N
        btnAnular.setText("Anular pedido");
        btnAnular.setAlignmentY(1.0F);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 160, 30));

        btnGenerar.setBackground(new java.awt.Color(0, 102, 0));
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/check.png"))); // NOI18N
        btnGenerar.setText("Generar pedido");
        btnGenerar.setAlignmentY(1.0F);
        btnGenerar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 160, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("IGV 18%:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Subtotal:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, -1, -1));

        lblSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        lblSubtotal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("0.00");
        jPanel2.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 440, 80, -1));

        lblIgv.setBackground(new java.awt.Color(255, 255, 255));
        lblIgv.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblIgv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIgv.setText("0.00");
        jPanel2.add(lblIgv, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 460, 80, -1));

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
                .addGap(111, 111, 111)
                .addComponent(lblTotal_orden1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal_orden)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal_orden)
                    .addComponent(lblTotal_orden1))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 340, 50));

        chkMayor.setText("Por mayor");
        chkMayor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chkMayorMousePressed(evt);
            }
        });
        jPanel2.add(chkMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 23, -1, -1));

        btnDescuentos.setText("Descuento");
        btnDescuentos.setAlignmentY(1.0F);
        btnDescuentos.setEnabled(false);
        btnDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescuentosActionPerformed(evt);
            }
        });
        jPanel2.add(btnDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 110, 30));

        lblCliente_.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCliente_.setText("Cliente:");
        jPanel2.add(lblCliente_, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, -1, -1));

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, -1, -1));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, -1, -1));

        btnBorrar_item.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/trash.png"))); // NOI18N
        btnBorrar_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar_itemActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 90, -1));

        chkImpresion_rapida.setText("Impresion rápida");
        jPanel2.add(chkImpresion_rapida, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, -1, -1));

        cboOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venta", "Muestras" }));
        cboOperacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOperacionItemStateChanged(evt);
            }
        });
        jPanel2.add(cboOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, -1));

        jPanel2.add(cboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 20, 130, -1));

        jLabel4.setText("Buscar producto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 25, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        controladorPedido.calcular();
        int cantidad = txtCantidad.getText().isEmpty() ? 0 : Integer.parseInt(txtCantidad.getText());
        Double precio = txtPrecio.getText().isEmpty() ? 0.0 : Double.parseDouble(txtPrecio.getText());
        controladorPedido.verificar_stock(cantidad, precio);
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
        controladorPedido.calcular();
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (tablaPedido.getRowCount() != 0) {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de anular la orden de pedido?") == 0) {
                controladorPedido.anular_pedido();
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void txtBuscar_productoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_productoKeyReleased
        controladorPedido.buscar();
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
            tablaProductos.requestFocus();
            tablaProductos.changeSelection(0, 0, false, false);
        }
    }//GEN-LAST:event_txtBuscar_productoKeyReleased

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        controladorPedido.dialogo_agregar_cliente();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        controladorPedido.generar_pedido();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnBorrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar_clienteActionPerformed
        controladorPedido.borrar_cliente();
    }//GEN-LAST:event_btnBorrar_clienteActionPerformed

    private void btnDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescuentosActionPerformed
        controladorPedido.dialogo_descuentos();
    }//GEN-LAST:event_btnDescuentosActionPerformed

    private void chkMayorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkMayorMousePressed
        txtBuscar_producto.requestFocus();
    }//GEN-LAST:event_chkMayorMousePressed

    private void btnBorrar_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar_itemActionPerformed
        controladorPedido.borrar_item();
    }//GEN-LAST:event_btnBorrar_itemActionPerformed

    private void tablaProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMousePressed
        controladorPedido.agregar();
    }//GEN-LAST:event_tablaProductosMousePressed

    private void tablaPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidoMousePressed
        controladorPedido.seleccionar_producto_agregado();
    }//GEN-LAST:event_tablaPedidoMousePressed

    private void cboOperacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOperacionItemStateChanged
        if (evt.getItem().equals("Muestras")) {
            btnGenerar.setText("Procesar");
            btnAnular.setText("Anular");
            btnCliente.setEnabled(false);
        } else {
            btnGenerar.setText("Generar pedido");
            btnAnular.setText("Anular pedido");
            btnCliente.setEnabled(true);
        }
    }//GEN-LAST:event_cboOperacionItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel advertencia;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBorrar_cliente;
    private javax.swing.JButton btnBorrar_item;
    private javax.swing.JButton btnCliente;
    public javax.swing.JButton btnDescuentos;
    public javax.swing.JButton btnGenerar;
    public javax.swing.JComboBox<String> cboEmpleado;
    public javax.swing.JComboBox<String> cboOperacion;
    public static javax.swing.JCheckBox chkImpresion_rapida;
    public javax.swing.JCheckBox chkMayor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblAdvertencia;
    public javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente_;
    public javax.swing.JLabel lblCodigo;
    public javax.swing.JLabel lblIgv;
    public javax.swing.JLabel lblSubtotal;
    public javax.swing.JLabel lblTotal_orden;
    private javax.swing.JLabel lblTotal_orden1;
    public javax.swing.JRadioButton rdoBoleta;
    public javax.swing.JRadioButton rdoFactura;
    private javax.swing.ButtonGroup rdoGrupoComprobante;
    public javax.swing.JTable tablaPedido;
    public javax.swing.JTable tablaProductos;
    public javax.swing.JTextField txtBuscar_producto;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
