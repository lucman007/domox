package Controlador;

import comun.Common;
import Modelo.Dao.DaoReportes;
import java.awt.Frame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import Vista.Vista_excel_import;

/**
 *
 * @author Luciano Ces
 */
public class ControladorExcelImport {

    private Vista_excel_import vista_import;
    private Common funciones;
    private File file;

    public ControladorExcelImport() {
    }

    public void iniciar() {
        Frame f = JOptionPane.getFrameForComponent(null);
        this.vista_import = new Vista_excel_import(f, true, this);
        this.funciones = new Common();
        funciones.abrir_dialogo(vista_import);
    }

    public void guardar() {
        vista_import.btnImportar.setText("Cargando...");
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un archivo");
        } else {
            DaoReportes im = new DaoReportes();
            try {
                im.importar(file.getAbsolutePath());
                vista_import.txtFile.setText("");
                file = null;
                vista_import.btnImportar.setText("Importar");
            } catch (InvalidFormatException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void seleccionar_archivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        file = chooser.getSelectedFile();
        if (file != null) {
            String ext = "";
            String archivo = file.getName();
            int i = archivo.lastIndexOf('.');
            if (i > 0) {
                ext = archivo.substring(i);
            }
            if (ext.equals(".xlsx")) {
                vista_import.txtFile.setText(archivo);
            } else {
                JOptionPane.showMessageDialog(null, "Archivo no permitido, asegúrese de que sea un documento de excel (.xlsx)");
                file = null;
            }
        }
    }
}
