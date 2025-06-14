package Vista;

import Controlador.ControladorVentasOperaciones;

public class Vista_ventas_operaciones extends javax.swing.JInternalFrame {

    private final ControladorVentasOperaciones logica_operaciones;

    public Vista_ventas_operaciones(ControladorVentasOperaciones logica_operaciones) {
        initComponents();
        this.logica_operaciones = logica_operaciones;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        fechaInicial = new com.toedter.calendar.JDateChooser();
        fechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        txtAbrir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtExtras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        txtGastos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setTitle("Operaciones");
        setPreferredSize(new java.awt.Dimension(960, 620));

        jPanel1.setBackground(new java.awt.Color(144, 198, 149));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVentas=comun.Common.no_edit_table(tablaVentas);
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Empleado", "Apertura", "Cierre"
            }
        ));
        tablaVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaVentasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 520, 485));

        jLabel2.setText("al");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 32, 15, -1));
        jPanel1.add(fechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 27, 163, -1));
        jPanel1.add(fechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 27, 163, -1));

        jLabel1.setText("Fecha de:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 32, -1, -1));

        txtAbrir.setText("0.00");
        txtAbrir.setEnabled(false);
        jPanel1.add(txtAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 130, -1));

        jLabel3.setText("Extras (+):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, -1, -1));

        txtExtras.setText("0.0");
        txtExtras.setEnabled(false);
        jPanel1.add(txtExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 130, -1));

        jLabel4.setText("Ingresos efectivo (+):");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        txtEfectivo.setText("0.0");
        txtEfectivo.setEnabled(false);
        jPanel1.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 130, -1));

        jLabel5.setText("Ingresos tarjeta (+):");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, -1, -1));

        txtTarjeta.setText("0.0");
        txtTarjeta.setEnabled(false);
        jPanel1.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 130, -1));

        txtGastos.setText("0.0");
        txtGastos.setEnabled(false);
        jPanel1.add(txtGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 130, -1));

        jLabel8.setText("Gastos (-):");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        txtCredito.setText("0.0");
        txtCredito.setEnabled(false);
        jPanel1.add(txtCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 130, -1));

        jLabel11.setText("Crédito:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, -1, -1));

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        txtComentario.setEnabled(false);
        jScrollPane2.setViewportView(txtComentario);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 310, 310, 130));

        jLabel6.setText("Comentario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, -1, -1));

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 160, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, -1, -1));

        jLabel9.setText("Apertura (+):");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMousePressed
        logica_operaciones.seleccionar_item();
        logica_operaciones.inhabilitar();
    }//GEN-LAST:event_tablaVentasMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        logica_operaciones.habilitar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        logica_operaciones.editar_item();
        logica_operaciones.limpiar();
        logica_operaciones.inhabilitar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        logica_operaciones.imprimir();
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    public com.toedter.calendar.JDateChooser fechaFinal;
    public com.toedter.calendar.JDateChooser fechaInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaVentas;
    public javax.swing.JTextField txtAbrir;
    public javax.swing.JTextArea txtComentario;
    public javax.swing.JTextField txtCredito;
    public javax.swing.JTextField txtEfectivo;
    public javax.swing.JTextField txtExtras;
    public javax.swing.JTextField txtGastos;
    public javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
