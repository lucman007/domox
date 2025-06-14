package comun;

import Modelo.Dao.DaoPedido;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static Vista.Vista_principal.escritorio;

/**
 *
 * @author Luciano Ces
 */
public class Common {

    public static ArrayList<JInternalFrame> registro_de_ventanas;
    public static int idempleado;
    public static String sesion;
    private final int num_ventanas = 14;
    private File config_file;
    private Properties p;
    public static boolean PRINT_VENTAS;
    public static boolean DIALOG_VENTAS;
    public static boolean PREVIEW_REPORT_VENTAS;
    public static boolean PRINT_PEDIDOS;
    public static boolean DIALOG_PEDIDOS;
    public static boolean PREVIEW_REPORT_PEDIDOS;

    public Common() {

    }

    public void configuracion_inicial() {
        registro_de_ventanas = new ArrayList<>();
        eliminar_historial();
        iniciar_ventanas();
        loadProperties();
    }

    public void loadProperties() {
        this.config_file = new File("src/recursos/config.properties");
        p = new Properties();

        try {
            InputStream in = new FileInputStream(config_file);
            p.load(in);
            PRINT_VENTAS = Boolean.valueOf(p.getProperty("print_ventas"));
            DIALOG_VENTAS = Boolean.valueOf(p.getProperty("printDialog_ventas"));
            PREVIEW_REPORT_VENTAS = Boolean.valueOf(p.getProperty("directPrint_ventas"));

            PRINT_PEDIDOS = Boolean.valueOf(p.getProperty("print_pedidos"));
            DIALOG_PEDIDOS = Boolean.valueOf(p.getProperty("printDialog_pedidos"));
            PREVIEW_REPORT_PEDIDOS = Boolean.valueOf(p.getProperty("directPrint_pedidos"));

            in.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void eliminar_historial() {
        DaoPedido func = new DaoPedido();
        func.eliminar_historial();
    }

    //----------- Funciones para ventanas del sistema ----------
    private void iniciar_ventanas() {
        for (int i = 0; i < num_ventanas; i++) {
            registro_de_ventanas.add(null);
        }
    }

    private void traer_al_frente(int index) {
        JInternalFrame form = registro_de_ventanas.get(index);
        form.toFront();
        try {
            form.setSelected(true);
        } catch (PropertyVetoException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void crear_nueva_ventana(JInternalFrame form, int index) {
        //abrir ventana
        escritorio.add(form);
        Dimension e = escritorio.getSize();
        Dimension f = form.getSize();
        form.setLocation((e.width - f.width) / 2, (e.height - f.height) / 2);
        form.show();
        //almacenar ventana recientemente abierta
        registro_de_ventanas.set(index, form);
    }

    public void cerrar_ventana_previa(String ventana_a_cerrar) {
        for (int i = 0; i <= 14; i++) {
            if (registro_de_ventanas.get(i).getClass().getSimpleName().equals(ventana_a_cerrar)) {
                if (registro_de_ventanas.get(i).isVisible()) {
                    JInternalFrame form = registro_de_ventanas.get(i);
                    form.dispose();
                }
                break;
            }
        }
    }

    public void abrir_ventana(JInternalFrame internalFrame) {
        for (int i = 0; i <= num_ventanas; i++) {
            if (registro_de_ventanas.get(i) == null) {
                crear_nueva_ventana(internalFrame, i);
                break;
            }
            if (registro_de_ventanas.get(i).getClass().getSimpleName().equals(internalFrame.getClass().getSimpleName())) {
                if (registro_de_ventanas.get(i).isVisible()) {
                    traer_al_frente(i);
                } else {
                    crear_nueva_ventana(internalFrame, i);
                }
                break;
            }
        }

    }

    //----------- Funciones de validación ----------
    public static void validar_entero(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public static void validar_decimal(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }

    public static void aMayus(java.awt.event.KeyEvent evt) {
        Character caracter = evt.getKeyChar();
        if (Character.isLetter(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }

    public static String aDecimal(Double num) {
        BigDecimal _num = new BigDecimal(num);
        return _num.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    }

    //----------- Funciones de tablas ----------
    public void ocultar_columnas(Integer[] cols, JTable tabla) {
        for (Integer col : cols) {
            tabla.getColumnModel().getColumn(col).setMaxWidth(0);
            tabla.getColumnModel().getColumn(col).setMinWidth(0);
            tabla.getColumnModel().getColumn(col).setPreferredWidth(0);
        }
    }

    public static JTable no_edit_table(JTable tabla) {
        tabla = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla.setFocusable(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        return tabla;
    }

    public void abrir_dialogo(JDialog form) {
        Dimension e = escritorio.getSize();
        Dimension d = form.getSize();
        form.setLocation((e.width - d.width) / 2, (e.height - d.height) / 2);
        form.setVisible(true);
    }

    public static void configurar_calendario(com.toedter.calendar.JDateChooser dateChooser) {
        dateChooser.setDate(new java.util.Date());
        dateChooser.setMaxSelectableDate(new java.util.Date());
        //dateChooser.getJCalendar().setTodayButtonVisible(true);
        dateChooser.getJCalendar().setWeekOfYearVisible(false);
        dateChooser.getJCalendar().setDecorationBackgroundVisible(false);
    }

}
