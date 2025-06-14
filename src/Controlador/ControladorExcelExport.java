package Controlador;

import Modelo.Dao.DaoReportes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Luciano Ces
 */
public class ControladorExcelExport {

    DaoReportes daoReportes = new DaoReportes();

    public ControladorExcelExport() {
    }

    public void iniciar() {
        exportar();
    }

    private void exportar() {
        String nombreArchivo = "inventario.xlsx";
        String rutaArchivo = "E:\\Escritorio\\" + nombreArchivo;
        String hoja = "Hoja1";

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        //cabecera de la hoja de excel
        String[] header = new String[]{"Código", "Nombre", "Características", "Categoría", "Precio", "Por mayor", "Stock"};
        //contenido de la hoja de excel
        ArrayList<String[]> document = daoReportes.reporte_inventario();

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        //generar los datos para el documento
        for (int i = 0; i <= document.size(); i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < header.length; j++) {
                if (i == 0) {//para la cabecera
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente
                    cell.setCellValue(header[j]);//se añade el contenido
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    if (j == 4 || j == 5 || j == 6) {
                        if (!String.valueOf(document.get(i - 1)[j]).equals("null")) {
                            cell.setCellValue(Double.parseDouble(document.get(i - 1)[j]));//se añade el contenido si es double
                        }
                    } else {
                        cell.setCellValue(document.get(i - 1)[j]);//se añade el contenido si es string
                    }

                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exportar_ventas() {
        String nombreArchivo = "ventas.xlsx";
        String rutaArchivo = "E:\\Escritorio\\" + nombreArchivo;
        String hoja = "Hoja1";

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        //cabecera de la hoja de excel
        String[] header = new String[]{"Venta N°", "Fecha/Hora", "Cliente", "Importe", "Tipo de pago", "Comprobante", "N° Comp."};
        //contenido de la hoja de excel
        ArrayList<String[]> document = daoReportes.reporte_ventas();

        //poner negrita a la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        //generar los datos para el documento
        for (int i = 0; i <= document.size(); i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < header.length; j++) {
                if (i == 0) {//para la cabecera
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente
                    cell.setCellValue(header[j]);//se añade el contenido
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    if (j == 0 || j == 3) {
                        if (!String.valueOf(document.get(i - 1)[j]).equals("null")) {
                            cell.setCellValue(Double.parseDouble(document.get(i - 1)[j]));//se añade el contenido si es double
                        }
                    } else {
                        cell.setCellValue(document.get(i - 1)[j]);//se añade el contenido si es string
                    }

                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
