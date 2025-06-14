package Vista;

import comun.Common;
import Controlador.ControladorVentasCerrar;

public class Vista_ventas_cerrar extends javax.swing.JInternalFrame {

    ControladorVentasCerrar logica_caja;

    public Vista_ventas_cerrar(ControladorVentasCerrar logica_caja) {
        initComponents();
        this.logica_caja = logica_caja;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_cierre = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();
        txtAbrir = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtExtras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTotal_orden = new javax.swing.JLabel();
        lblSimbolo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGastos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        txtCredito = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setTitle("Cierre de caja");
        setMinimumSize(new java.awt.Dimension(1100, 480));
        setPreferredSize(new java.awt.Dimension(381, 550));

        panel_cierre.setBackground(new java.awt.Color(144, 198, 149));
        panel_cierre.setPreferredSize(new java.awt.Dimension(1060, 410));
        panel_cierre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Comentario:");
        panel_cierre.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        btnProcesar.setText("Procesar cierre");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        panel_cierre.add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 160, -1));

        txtAbrir.setText("0.00");
        txtAbrir.setEnabled(false);
        panel_cierre.add(txtAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 130, -1));

        jLabel3.setText("Extras (+):");
        panel_cierre.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        txtExtras.setText("0.0");
        txtExtras.setEnabled(false);
        txtExtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtExtrasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExtrasKeyTyped(evt);
            }
        });
        panel_cierre.add(txtExtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 130, -1));

        jLabel4.setText("Ingresos efectivo (+):");
        panel_cierre.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtEfectivo.setText("0.0");
        txtEfectivo.setEnabled(false);
        panel_cierre.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, -1));

        jLabel5.setText("Ingresos tarjeta (+):");
        panel_cierre.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        txtTarjeta.setText("0.0");
        txtTarjeta.setEnabled(false);
        panel_cierre.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 130, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblTotal_orden.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblTotal_orden.setForeground(new java.awt.Color(0, 204, 0));
        lblTotal_orden.setText("0.00");

        lblSimbolo.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSimbolo.setForeground(new java.awt.Color(0, 204, 0));
        lblSimbolo.setText("S/.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lblSimbolo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal_orden)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal_orden)
                    .addComponent(lblSimbolo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_cierre.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 310, 50));

        jLabel7.setText("Apertura (+):");
        panel_cierre.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtGastos.setText("0.0");
        txtGastos.setEnabled(false);
        panel_cierre.add(txtGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

        jLabel8.setText("Gastos (-):");
        panel_cierre.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        panel_cierre.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 316, 310, 130));

        txtCredito.setText("0.0");
        txtCredito.setEnabled(false);
        panel_cierre.add(txtCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 130, -1));

        jLabel11.setText("Crédito:");
        panel_cierre.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_cierre, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_cierre, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        logica_caja.procesar();
        dispose();

    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtExtrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExtrasKeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtExtrasKeyReleased

    private void txtExtrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExtrasKeyTyped
        Common.validar_decimal(evt);
    }//GEN-LAST:event_txtExtrasKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblSimbolo;
    public javax.swing.JLabel lblTotal_orden;
    public javax.swing.JPanel panel_cierre;
    public javax.swing.JTextField txtAbrir;
    public javax.swing.JTextArea txtComentario;
    public javax.swing.JTextField txtCredito;
    public javax.swing.JTextField txtEfectivo;
    public javax.swing.JTextField txtExtras;
    public javax.swing.JTextField txtGastos;
    public javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
