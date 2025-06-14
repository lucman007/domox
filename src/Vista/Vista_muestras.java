package Vista;

import Controlador.ControladorMuestras;

public class Vista_muestras extends javax.swing.JInternalFrame {

    private final ControladorMuestras controladorMuestras;

    public Vista_muestras(ControladorMuestras controladorMuestras) {
        initComponents();
        this.controladorMuestras = controladorMuestras;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMuestras = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalle = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        lblTotal_orden = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setTitle("Muestras");
        setMinimumSize(new java.awt.Dimension(1200, 480));
        setPreferredSize(new java.awt.Dimension(1200, 480));

        jPanel2.setBackground(new java.awt.Color(144, 198, 149));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMuestras=comun.Common.no_edit_table(tablaMuestras);
        tablaMuestras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idmuestra", "Fecha", "Despacho", "Preventa", "Importe"
            }
        ));
        tablaMuestras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaMuestras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMuestrasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMuestras);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 520, 300));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setAlignmentY(1.0F);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 90, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Total:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 385, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Lista de muestras:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 33, -1, -1));

        btnRefresh.setText("Actualizar");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        tablaDetalle=comun.Common.no_edit_table(tablaDetalle);
        tablaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idproducto", "Código", "Nombre", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane2.setViewportView(tablaDetalle);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 580, 300));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Pre-venta:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 33, -1, -1));

        lblCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 33, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.setAlignmentY(1.0F);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 100, 30));

        btnImprimir.setText("Imprimir");
        btnImprimir.setAlignmentY(1.0F);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 90, 30));

        lblTotal_orden.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblTotal_orden.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal_orden.setText("0.00");
        jPanel2.add(lblTotal_orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 385, 80, -1));

        btnBorrar.setText("Borrar");
        btnBorrar.setAlignmentY(1.0F);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        controladorMuestras.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaMuestrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMuestrasMousePressed
        controladorMuestras.abrir_muestra();
        controladorMuestras.calcular_total();
    }//GEN-LAST:event_tablaMuestrasMousePressed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        controladorMuestras.mostrar("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        controladorMuestras.editar_item();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        controladorMuestras.imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        controladorMuestras.borrar_item();
    }//GEN-LAST:event_btnBorrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblCliente;
    public javax.swing.JLabel lblTotal_orden;
    public javax.swing.JTable tablaDetalle;
    public javax.swing.JTable tablaMuestras;
    // End of variables declaration//GEN-END:variables
}
