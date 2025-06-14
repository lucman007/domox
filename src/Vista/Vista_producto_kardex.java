package Vista;

import java.awt.event.KeyEvent;
import comun.Helper_shortcuts;

/**
 *
 * @author Li
 */
public class Vista_producto_kardex extends javax.swing.JDialog {

    public Vista_producto_kardex(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape").dialog_putKeys();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kardex de producto");

        mainPanel.setBackground(new java.awt.Color(43, 112, 72));
        mainPanel.setPreferredSize(new java.awt.Dimension(1060, 410));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaInventario);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 870, 280));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seguimiento de entradas y salidas de producto:");
        mainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, -1, -1));

        btnCancelar.setText("Listo");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        mainPanel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, 100, 30));

        txtProducto.setEditable(false);
        mainPanel.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    public javax.swing.JTable tablaInventario;
    public javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
