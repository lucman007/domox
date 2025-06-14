package Controlador;

import comun.Common;
import Modelo.Dto.DtoImpresion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import Vista.Vista_config;

public class ControladorConfig {

    private Vista_config vista_config;
    private Common funciones;
    private Properties p;
    private File config_file;

    public ControladorConfig() {

    }

    public void iniciar() {
        this.vista_config = new Vista_config(this);
        this.funciones = new Common();
        funciones.abrir_ventana(vista_config);
        vista_config.chkPrint_ventas.setSelected(Common.PRINT_VENTAS);
        vista_config.chkPrintDialog_ventas.setSelected(Common.DIALOG_VENTAS);
        vista_config.chkDirectPrint_Ventas.setSelected(Common.PREVIEW_REPORT_VENTAS);
        vista_config.chkPrint_pedidos.setSelected(Common.PRINT_PEDIDOS);
        vista_config.chkPrintDialog_pedidos.setSelected(Common.DIALOG_PEDIDOS);
        vista_config.chkDirectPrint_Pedidos.setSelected(Common.PREVIEW_REPORT_PEDIDOS);
    }

    public void guardar_configuracion() {
        try {
            p = new Properties();
            this.config_file = new File("src/recursos/config.properties");

            p.setProperty("print_ventas", String.valueOf(vista_config.chkPrint_ventas.isSelected()));
            p.setProperty("printDialog_ventas", String.valueOf(vista_config.chkPrintDialog_ventas.isSelected()));
            p.setProperty("directPrint_ventas", String.valueOf(vista_config.chkDirectPrint_Ventas.isSelected()));

            p.setProperty("print_pedidos", String.valueOf(vista_config.chkPrint_pedidos.isSelected()));
            p.setProperty("printDialog_pedidos", String.valueOf(vista_config.chkPrintDialog_pedidos.isSelected()));
            p.setProperty("directPrint_pedidos", String.valueOf(vista_config.chkDirectPrint_Pedidos.isSelected()));

            OutputStream out = new FileOutputStream(config_file);
            p.store(out, "Configuracion de sistema Domox");
            out.close();
            funciones.loadProperties();

            JOptionPane.showMessageDialog(null, "Se guardaron las configuraciones");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void saveProperties(DtoImpresion datos) throws IOException {

    }

}
