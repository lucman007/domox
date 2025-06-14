package Vista;

import Controlador.ControladorConfig;

public class Vista_config extends javax.swing.JInternalFrame {

    private final ControladorConfig controladorConfig;

    public Vista_config(ControladorConfig controladorConfig) {
        initComponents();
        this.controladorConfig = controladorConfig;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        chkPrint_ventas = new javax.swing.JCheckBox();
        chkPrintDialog_ventas = new javax.swing.JCheckBox();
        chkDirectPrint_Ventas = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        chkPrint_pedidos = new javax.swing.JCheckBox();
        chkDirectPrint_Pedidos = new javax.swing.JCheckBox();
        chkPrintDialog_pedidos = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Configuración");
        setMinimumSize(new java.awt.Dimension(450, 520));
        setPreferredSize(new java.awt.Dimension(450, 490));

        jPanel2.setBackground(new java.awt.Color(43, 158, 91));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 520));
        jPanel2.setPreferredSize(new java.awt.Dimension(1060, 520));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 160, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puedes configurar opciones de aplicación para este dispositivo:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(43, 124, 63));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Módulo de ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        chkPrint_ventas.setForeground(new java.awt.Color(255, 255, 255));
        chkPrint_ventas.setText("Habilitar impresión");

        chkPrintDialog_ventas.setForeground(new java.awt.Color(255, 255, 255));
        chkPrintDialog_ventas.setText("Mostrar diálogo de impresión");

        chkDirectPrint_Ventas.setForeground(new java.awt.Color(255, 255, 255));
        chkDirectPrint_Ventas.setText("Previsualizar documento antes de imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkPrint_ventas)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkPrintDialog_ventas)
                            .addComponent(chkDirectPrint_Ventas))
                        .addGap(0, 127, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkPrint_ventas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(chkDirectPrint_Ventas)
                .addGap(18, 18, 18)
                .addComponent(chkPrintDialog_ventas)
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 370, 140));

        jPanel3.setBackground(new java.awt.Color(43, 124, 63));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Módulo de pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        chkPrint_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        chkPrint_pedidos.setText("Habilitar impresión");

        chkDirectPrint_Pedidos.setForeground(new java.awt.Color(255, 255, 255));
        chkDirectPrint_Pedidos.setText("Previsualizar documento antes de imprimir");

        chkPrintDialog_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        chkPrintDialog_pedidos.setText("Mostrar diálogo de impresión");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkPrint_pedidos)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkPrintDialog_pedidos)
                            .addComponent(chkDirectPrint_Pedidos))
                        .addGap(0, 127, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkPrint_pedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(chkDirectPrint_Pedidos)
                .addGap(18, 18, 18)
                .addComponent(chkPrintDialog_pedidos)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 370, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        controladorConfig.guardar_configuracion();
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    public javax.swing.JCheckBox chkDirectPrint_Pedidos;
    public javax.swing.JCheckBox chkDirectPrint_Ventas;
    public javax.swing.JCheckBox chkPrintDialog_pedidos;
    public javax.swing.JCheckBox chkPrintDialog_ventas;
    public javax.swing.JCheckBox chkPrint_pedidos;
    public javax.swing.JCheckBox chkPrint_ventas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
