package Vista;

import java.awt.event.KeyEvent;
import comun.Helper_shortcuts;
import Controlador.ControladorVentasEgresos;

/**
 *
 * @author Luciano Ces
 */
public class Vista_ventas_egresos extends javax.swing.JDialog {

    private final ControladorVentasEgresos logica_gastos;

    public Vista_ventas_egresos(java.awt.Frame parent, boolean modal, ControladorVentasEgresos logica_gastos) {
        super(parent, modal);
        initComponents();
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape").dialog_putKeys();
        this.logica_gastos = logica_gastos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        rdoIngreso = new javax.swing.JRadioButton();
        rdoEgreso = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        chkIngreso = new javax.swing.JCheckBox();
        chkEgreso = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        fechaInicial = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        fechaFinal = new com.toedter.calendar.JDateChooser();
        btnBorrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTotal_resumen3 = new javax.swing.JLabel();
        lblEgresos = new javax.swing.JLabel();
        lblIngresos = new javax.swing.JLabel();
        lblTotal_resumen6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar egreso / ingreso");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(43, 112, 72));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("Agregar >>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 140, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripción del gasto:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 180, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 140));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Monto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jPanel1.add(cboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Empleado:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compra de insumos", "Pagos de servicios", "Adelanto de sueldo", "Retiro de caja", "Otros gastos" }));
        jPanel1.add(cboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, -1));

        buttonGroup1.add(rdoIngreso);
        rdoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        rdoIngreso.setText("Ingreso");
        rdoIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoIngresoItemStateChanged(evt);
            }
        });
        jPanel1.add(rdoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        buttonGroup1.add(rdoEgreso);
        rdoEgreso.setForeground(new java.awt.Color(255, 255, 255));
        rdoEgreso.setSelected(true);
        rdoEgreso.setText("Egreso");
        jPanel1.add(rdoEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Idegreso", "Fecha", "Empleado", "Operación", "Tipo", "Monto", "Descripción"
            }
        ));
        tablaGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGastosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGastos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 590, 310));

        chkIngreso.setForeground(new java.awt.Color(255, 255, 255));
        chkIngreso.setSelected(true);
        chkIngreso.setText("Ingresos");
        chkIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkIngresoItemStateChanged(evt);
            }
        });
        jPanel1.add(chkIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        chkEgreso.setForeground(new java.awt.Color(255, 255, 255));
        chkEgreso.setSelected(true);
        chkEgreso.setText("Egresos");
        chkEgreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkEgresoItemStateChanged(evt);
            }
        });
        jPanel1.add(chkEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo de gasto:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        fechaInicial.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel1.add(fechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("al");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        fechaFinal.setPreferredSize(new java.awt.Dimension(95, 25));
        jPanel1.add(fechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 30, 130, -1));

        btnBorrar.setText("Borrar item");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(310, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotal_resumen3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotal_resumen3.setText("Egresos:");
        jPanel2.add(lblTotal_resumen3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 60, -1));

        lblEgresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEgresos.setText("0.0");
        jPanel2.add(lblEgresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 5, 80, -1));

        lblIngresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIngresos.setText("0.0");
        jPanel2.add(lblIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 5, 80, -1));

        lblTotal_resumen6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotal_resumen6.setText("Ingresos:");
        jPanel2.add(lblTotal_resumen6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, 70, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 390, 340, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        logica_gastos.agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaGastosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGastosMousePressed
        logica_gastos.seleccionar_item();
    }//GEN-LAST:event_tablaGastosMousePressed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        logica_gastos.borrar_item();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void rdoIngresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoIngresoItemStateChanged
        if (evt.getStateChange() == 1) {
            cboTipo.setEnabled(false);
        } else {
            cboTipo.setEnabled(true);
        }
    }//GEN-LAST:event_rdoIngresoItemStateChanged

    private void chkEgresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkEgresoItemStateChanged
        logica_gastos.mostrar(null);
    }//GEN-LAST:event_chkEgresoItemStateChanged

    private void chkIngresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkIngresoItemStateChanged
        logica_gastos.mostrar(null);
    }//GEN-LAST:event_chkIngresoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cboEmpleado;
    public javax.swing.JComboBox<String> cboTipo;
    public javax.swing.JCheckBox chkEgreso;
    public javax.swing.JCheckBox chkIngreso;
    public com.toedter.calendar.JDateChooser fechaFinal;
    public com.toedter.calendar.JDateChooser fechaInicial;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblEgresos;
    public javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblTotal_resumen3;
    private javax.swing.JLabel lblTotal_resumen6;
    public javax.swing.JRadioButton rdoEgreso;
    public javax.swing.JRadioButton rdoIngreso;
    public javax.swing.JTable tablaGastos;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
