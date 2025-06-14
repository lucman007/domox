package Vista;

import Controlador.ControladorVentasAbrir;

public class Vista_ventas_abrir extends javax.swing.JInternalFrame {

    ControladorVentasAbrir logica_caja;

    public Vista_ventas_abrir(ControladorVentasAbrir logica_caja) {
        initComponents();
        this.logica_caja = logica_caja;
        txtMonto0.selectAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMonto0 = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblSimbol = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMonto1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMonto2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMonto3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMonto4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMonto5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonto6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMonto7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtMonto8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtMonto9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtMonto10 = new javax.swing.JTextField();
        txtDirecto = new javax.swing.JTextField();
        chkMonto = new javax.swing.JCheckBox();
        btnLimpiar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setTitle("Apertura de caja");
        setMinimumSize(new java.awt.Dimension(1100, 480));
        setPreferredSize(new java.awt.Dimension(730, 500));

        panel.setBackground(new java.awt.Color(144, 198, 149));
        panel.setPreferredSize(new java.awt.Dimension(380, 450));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Comentario:");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, -1, -1));

        btnProcesar.setText("Procesar apertura de caja");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        panel.add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 190, -1));

        jLabel4.setText("Monedas de S/. 0.10");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 73, -1, -1));

        txtMonto0.setText("0");
        txtMonto0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto0ActionPerformed(evt);
            }
        });
        txtMonto0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto0KeyReleased(evt);
            }
        });
        panel.add(txtMonto0, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setText("LUCIANO CÉSPEDES");
        panel.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 204, 0));
        lblTotal.setText("0.00");

        lblSimbol.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSimbol.setForeground(new java.awt.Color(0, 204, 0));
        lblSimbol.setText("S/.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblSimbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblSimbol))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 310, 50));

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 236, 310, 110));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("CAJA:");
        panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel5.setText("Monedas de S/. 0.20");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, -1));

        txtMonto1.setText("0");
        txtMonto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto1ActionPerformed(evt);
            }
        });
        txtMonto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto1KeyReleased(evt);
            }
        });
        panel.add(txtMonto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 130, -1));

        jLabel7.setText("Monedas de S/. 0.50");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 133, -1, -1));

        txtMonto2.setText("0");
        txtMonto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto2ActionPerformed(evt);
            }
        });
        txtMonto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto2KeyReleased(evt);
            }
        });
        panel.add(txtMonto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 130, -1));

        jLabel8.setText("Monedas de S/. 1.00");
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 163, -1, -1));

        txtMonto3.setText("0");
        txtMonto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto3ActionPerformed(evt);
            }
        });
        txtMonto3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto3KeyReleased(evt);
            }
        });
        panel.add(txtMonto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 130, -1));

        jLabel10.setText("Monedas de S/. 2.00");
        panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, -1, -1));

        txtMonto4.setText("0");
        txtMonto4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto4ActionPerformed(evt);
            }
        });
        txtMonto4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto4KeyReleased(evt);
            }
        });
        panel.add(txtMonto4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 130, -1));

        jLabel11.setText("Monedas de S/. 5.00");
        panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 223, -1, -1));

        txtMonto5.setText("0");
        txtMonto5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto5ActionPerformed(evt);
            }
        });
        txtMonto5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto5KeyReleased(evt);
            }
        });
        panel.add(txtMonto5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 130, -1));

        jLabel12.setText("Billetes de S/. 10.00");
        panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 253, -1, -1));

        txtMonto6.setText("0");
        txtMonto6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto6ActionPerformed(evt);
            }
        });
        txtMonto6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto6KeyReleased(evt);
            }
        });
        panel.add(txtMonto6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, -1));

        jLabel13.setText("Billetes de S/. 20.00");
        panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 283, -1, -1));

        txtMonto7.setText("0");
        txtMonto7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto7ActionPerformed(evt);
            }
        });
        txtMonto7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto7KeyReleased(evt);
            }
        });
        panel.add(txtMonto7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 130, -1));

        jLabel14.setText("Billetes de S/. 50.00");
        panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 313, -1, -1));

        txtMonto8.setText("0");
        txtMonto8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto8ActionPerformed(evt);
            }
        });
        txtMonto8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto8KeyReleased(evt);
            }
        });
        panel.add(txtMonto8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 130, -1));

        jLabel15.setText("Billetes de S/. 100.00");
        panel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 343, -1, -1));

        txtMonto9.setText("0");
        txtMonto9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto9ActionPerformed(evt);
            }
        });
        txtMonto9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto9KeyReleased(evt);
            }
        });
        panel.add(txtMonto9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 130, -1));

        jLabel16.setText("Billetes de S/. 200.00");
        panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 373, -1, -1));

        txtMonto10.setText("0");
        txtMonto10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMonto10KeyReleased(evt);
            }
        });
        panel.add(txtMonto10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 130, -1));

        txtDirecto.setEnabled(false);
        txtDirecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDirectoKeyReleased(evt);
            }
        });
        panel.add(txtDirecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 110, -1));

        chkMonto.setText("Ingresar monto directamente");
        chkMonto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMontoItemStateChanged(evt);
            }
        });
        panel.add(chkMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 73, -1, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panel.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        logica_caja.procesar();
        dispose();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtMonto0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto0KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto0KeyReleased

    private void txtMonto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto1KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto1KeyReleased

    private void txtMonto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto2KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto2KeyReleased

    private void txtMonto3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto3KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto3KeyReleased

    private void txtMonto4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto4KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto4KeyReleased

    private void txtMonto5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto5KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto5KeyReleased

    private void txtMonto6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto6KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto6KeyReleased

    private void txtMonto7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto7KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto7KeyReleased

    private void txtMonto8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto8KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto8KeyReleased

    private void txtMonto9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto9KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto9KeyReleased

    private void txtMonto10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMonto10KeyReleased
        logica_caja.sumar();
    }//GEN-LAST:event_txtMonto10KeyReleased

    private void txtDirectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirectoKeyReleased
        logica_caja.ingresar_monto_directo();
    }//GEN-LAST:event_txtDirectoKeyReleased

    private void chkMontoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMontoItemStateChanged
        logica_caja.check_ingresar_monto_directo(evt);
    }//GEN-LAST:event_chkMontoItemStateChanged

    private void txtMonto0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto0ActionPerformed
        txtMonto1.requestFocus();
        txtMonto1.selectAll();
    }//GEN-LAST:event_txtMonto0ActionPerformed

    private void txtMonto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto1ActionPerformed
        txtMonto2.requestFocus();
        txtMonto2.selectAll();
    }//GEN-LAST:event_txtMonto1ActionPerformed

    private void txtMonto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto2ActionPerformed
        txtMonto3.requestFocus();
        txtMonto3.selectAll();
    }//GEN-LAST:event_txtMonto2ActionPerformed

    private void txtMonto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto3ActionPerformed
        txtMonto4.requestFocus();
        txtMonto4.selectAll();
    }//GEN-LAST:event_txtMonto3ActionPerformed

    private void txtMonto4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto4ActionPerformed
        txtMonto5.requestFocus();
        txtMonto5.selectAll();
    }//GEN-LAST:event_txtMonto4ActionPerformed

    private void txtMonto5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto5ActionPerformed
        txtMonto6.requestFocus();
        txtMonto6.selectAll();
    }//GEN-LAST:event_txtMonto5ActionPerformed

    private void txtMonto6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto6ActionPerformed
        txtMonto7.requestFocus();
        txtMonto7.selectAll();
    }//GEN-LAST:event_txtMonto6ActionPerformed

    private void txtMonto7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto7ActionPerformed
        txtMonto8.requestFocus();
        txtMonto8.selectAll();
    }//GEN-LAST:event_txtMonto7ActionPerformed

    private void txtMonto8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto8ActionPerformed
        txtMonto9.requestFocus();
        txtMonto9.selectAll();
    }//GEN-LAST:event_txtMonto8ActionPerformed

    private void txtMonto9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto9ActionPerformed
        txtMonto10.requestFocus();
        txtMonto10.selectAll();
    }//GEN-LAST:event_txtMonto9ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        logica_caja.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JCheckBox chkMonto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblSimbol;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JPanel panel;
    public javax.swing.JTextArea txtComentario;
    public javax.swing.JTextField txtDirecto;
    private javax.swing.JTextField txtMonto0;
    private javax.swing.JTextField txtMonto1;
    private javax.swing.JTextField txtMonto10;
    private javax.swing.JTextField txtMonto2;
    private javax.swing.JTextField txtMonto3;
    private javax.swing.JTextField txtMonto4;
    private javax.swing.JTextField txtMonto5;
    private javax.swing.JTextField txtMonto6;
    private javax.swing.JTextField txtMonto7;
    private javax.swing.JTextField txtMonto8;
    private javax.swing.JTextField txtMonto9;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
