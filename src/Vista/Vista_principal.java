package Vista;

import javax.swing.ImageIcon;
import Controlador.ControladorVentasAbrir;
import Controlador.ControladorVentasCerrar;
import Controlador.ControladorProductoCategorias;
import Controlador.ControladorCliente;
import Controlador.ControladorConfig;
import Controlador.ControladorVentasCredito;
import Controlador.ControladorVentasEgresos;
import Controlador.ControladorEmpleado;
import Controlador.ControladorExcelExport;
import Controlador.ControladorExcelImport;
import Controlador.ControladorMuestras;
import Controlador.ControladorPedido;
import Controlador.ControladorProducto;
import Controlador.ControladorVentas;
import Controlador.ControladorVentasOperaciones;
import Controlador.ControladorVentasResumen;

/**
 *
 * @author Li
 */
public class Vista_principal extends javax.swing.JFrame {

    public Vista_principal() {
        initComponents();
        setExtendedState(Vista_principal.MAXIMIZED_BOTH);
        setIconImage(new ImageIcon("src/recursos/iso.png").getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSesion = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuVentas = new javax.swing.JMenu();
        menuCaja = new javax.swing.JMenuItem();
        menuEgresos = new javax.swing.JMenuItem();
        menuPedidos = new javax.swing.JMenu();
        menuPedido = new javax.swing.JMenuItem();
        menuHistorial = new javax.swing.JMenuItem();
        productos = new javax.swing.JMenu();
        menuProductos = new javax.swing.JMenuItem();
        menuCategorias = new javax.swing.JMenuItem();
        Import = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        menuCliente = new javax.swing.JMenuItem();
        empleados = new javax.swing.JMenu();
        menuEmpleados = new javax.swing.JMenuItem();
        vendedores = new javax.swing.JMenu();
        menuMuestras = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        menuConfiguracion = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Domox v2.0");

        escritorio.setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(38, 166, 91));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido (a):");

        txtSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSesion.setForeground(new java.awt.Color(255, 255, 255));
        txtSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user-icon.png"))); // NOI18N
        txtSesion.setText("Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSesion)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuBar.setBackground(new java.awt.Color(0, 102, 102));
        menuBar.setForeground(new java.awt.Color(102, 102, 255));

        menuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/sales.png"))); // NOI18N
        menuVentas.setText("Caja");

        menuCaja.setText("Registrar venta");
        menuCaja.setPreferredSize(new java.awt.Dimension(137, 30));
        menuCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCajaActionPerformed(evt);
            }
        });
        menuVentas.add(menuCaja);

        menuBar.add(menuVentas);

        menuPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/pedido.png"))); // NOI18N
        menuPedidos.setText("Pedidos");

        menuPedido.setText("Nuevo pedido");
        menuPedido.setPreferredSize(new java.awt.Dimension(119, 30));
        menuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(menuPedido);

        menuHistorial.setText("Historial ");
        menuHistorial.setPreferredSize(new java.awt.Dimension(149, 30));
        menuHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistorialActionPerformed(evt);
            }
        });
        menuPedidos.add(menuHistorial);

        menuBar.add(menuPedidos);

        productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/items.png"))); // NOI18N
        productos.setText("Productos");

        menuProductos.setText("Gestionar productos");
        menuProductos.setPreferredSize(new java.awt.Dimension(107, 30));
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });
        productos.add(menuProductos);

        menuCategorias.setText("Categorías");
        menuCategorias.setPreferredSize(new java.awt.Dimension(167, 30));
        menuCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriasActionPerformed(evt);
            }
        });
        productos.add(menuCategorias);
        menuBar.add(productos);

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/customers_new.png"))); // NOI18N
        menuClientes.setText("Clientes");

        menuCliente.setText("Lista de clientes");
        menuCliente.setPreferredSize(new java.awt.Dimension(127, 30));
        menuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuCliente);

        menuBar.add(menuClientes);

        empleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/user.png"))); // NOI18N
        empleados.setText("Empleados");

        menuEmpleados.setText("Lista de empleados");
        menuEmpleados.setPreferredSize(new java.awt.Dimension(145, 30));
        menuEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmpleadosActionPerformed(evt);
            }
        });
        empleados.add(menuEmpleados);

        menuBar.add(empleados);


        menuSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/config.png"))); // NOI18N
        menuSistema.setText("Sistema");

        menuSalir.setText("Salir");
        menuSalir.setPreferredSize(new java.awt.Dimension(119, 30));
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuSistema.add(menuSalir);

        menuBar.add(menuSistema);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCajaActionPerformed
        ControladorVentas controladorVentas = new ControladorVentas();
        controladorVentas.iniciar();
    }//GEN-LAST:event_menuCajaActionPerformed

    private void menuResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResumenActionPerformed
        ControladorVentasResumen logica_resumen = new ControladorVentasResumen();
        logica_resumen.iniciar();
    }//GEN-LAST:event_menuResumenActionPerformed

    private void menuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPedidoActionPerformed
        ControladorPedido controladorPedido = new ControladorPedido();
        controladorPedido.iniciar();
    }//GEN-LAST:event_menuPedidoActionPerformed

    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        ControladorProducto controladorProducto = new ControladorProducto();
        controladorProducto.iniciar();
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClienteActionPerformed
        ControladorCliente controladorCliente = new ControladorCliente();
        controladorCliente.iniciar();
    }//GEN-LAST:event_menuClienteActionPerformed

    private void menuEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpleadosActionPerformed
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        controladorEmpleado.iniciar();
    }//GEN-LAST:event_menuEmpleadosActionPerformed

    private void menuHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistorialActionPerformed
        ControladorPedido controladorPedido = new ControladorPedido();
        controladorPedido.iniciar_historial();
    }//GEN-LAST:event_menuHistorialActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        dispose();
        new Vista_login().setVisible(true);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriasActionPerformed
        ControladorProductoCategorias logica_categoria = new ControladorProductoCategorias();
        logica_categoria.iniciar();
    }//GEN-LAST:event_menuCategoriasActionPerformed

    private void menuCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarCajaActionPerformed
        ControladorVentasCerrar logica_cierre = new ControladorVentasCerrar();
        logica_cierre.iniciar();
    }//GEN-LAST:event_menuCerrarCajaActionPerformed

    private void menuAbrirCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirCajaActionPerformed
        ControladorVentasAbrir logica_abrir = new ControladorVentasAbrir();
        logica_abrir.iniciar();
    }//GEN-LAST:event_menuAbrirCajaActionPerformed

    private void menuConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfiguracionActionPerformed
        ControladorConfig controladorConfig = new ControladorConfig();
        controladorConfig.iniciar();
    }//GEN-LAST:event_menuConfiguracionActionPerformed

    private void menuCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCreditoActionPerformed
        ControladorVentasCredito logica_credito = new ControladorVentasCredito();
        logica_credito.iniciar();
    }//GEN-LAST:event_menuCreditoActionPerformed

    private void ImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportActionPerformed
        ControladorExcelImport logica_import = new ControladorExcelImport();
        logica_import.iniciar();
    }//GEN-LAST:event_ImportActionPerformed

    private void menuEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEgresosActionPerformed
        ControladorVentasEgresos logica_egresos = new ControladorVentasEgresos();
        logica_egresos.iniciar();
    }//GEN-LAST:event_menuEgresosActionPerformed

    private void menuMuestrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMuestrasActionPerformed
        ControladorMuestras controladorMuestras = new ControladorMuestras();
        controladorMuestras.iniciar();
    }//GEN-LAST:event_menuMuestrasActionPerformed

    private void menuOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOperacionesActionPerformed
        ControladorVentasOperaciones logica_operaciones = new ControladorVentasOperaciones();
        logica_operaciones.iniciar();
    }//GEN-LAST:event_menuOperacionesActionPerformed

    private void menuExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportExcelActionPerformed
        ControladorExcelExport logica_export = new ControladorExcelExport();
        logica_export.iniciar();
    }//GEN-LAST:event_menuExportExcelActionPerformed

    private void menuReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteVentasActionPerformed
        ControladorExcelExport logica_export = new ControladorExcelExport();
        logica_export.exportar_ventas();
    }//GEN-LAST:event_menuReporteVentasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Import;
    public static javax.swing.JMenu empleados;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuAbrirCaja;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCaja;
    private javax.swing.JMenuItem menuCategorias;
    private javax.swing.JMenuItem menuCerrarCaja;
    private javax.swing.JMenuItem menuCliente;
    private javax.swing.JMenu menuClientes;
    public static javax.swing.JMenuItem menuConfiguracion;
    private javax.swing.JMenuItem menuCredito;
    private javax.swing.JMenuItem menuEgresos;
    private javax.swing.JMenuItem menuEmpleados;
    private javax.swing.JMenuItem menuExportExcel;
    private javax.swing.JMenuItem menuHistorial;
    private javax.swing.JMenuItem menuMuestras;
    private javax.swing.JMenuItem menuOperaciones;
    private javax.swing.JMenuItem menuPedido;
    private javax.swing.JMenu menuPedidos;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenuItem menuReporteVentas;
    private javax.swing.JMenuItem menuResumen;
    private javax.swing.JMenuItem menuSalir;
    public static javax.swing.JMenu menuSistema;
    public static javax.swing.JMenu menuVentas;
    public static javax.swing.JMenu productos;
    public javax.swing.JLabel txtSesion;
    public static javax.swing.JMenu vendedores;
    // End of variables declaration//GEN-END:variables
}
