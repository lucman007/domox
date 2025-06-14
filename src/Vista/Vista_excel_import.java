package Vista;

import java.awt.event.KeyEvent;
import comun.Helper_shortcuts;
import Controlador.ControladorExcelImport;

/**
 *
 * @author Luciano Ces
 */
public class Vista_excel_import extends javax.swing.JDialog {

    private final ControladorExcelImport logica_import;

    public Vista_excel_import(java.awt.Frame parent, boolean modal, ControladorExcelImport logica_import) {
        super(parent, modal);
        initComponents();
        new Helper_shortcuts(this, KeyEvent.VK_ESCAPE, "escape").dialog_putKeys();
        this.logica_import = logica_import;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        txtFile = new javax.swing.JTextField();
        btnSubirArchivo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Importar productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(43, 112, 72));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 140, -1));

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jPanel1.add(btnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 140, -1));

        txtFile.setEditable(false);
        jPanel1.add(txtFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 350, -1));

        btnSubirArchivo.setBackground(new java.awt.Color(0, 255, 102));
        btnSubirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/file.png"))); // NOI18N
        btnSubirArchivo.setBorderPainted(false);
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubirArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 50, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Selecciona un archivo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        logica_import.guardar();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirArchivoActionPerformed
        logica_import.seleccionar_archivo();
    }//GEN-LAST:event_btnSubirArchivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnImportar;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtFile;
    // End of variables declaration//GEN-END:variables
}
