package com.nw.util;

import java.util.Vector;
import java.util.StringTokenizer;
 
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Filedownload;

public class GenerarExcel {

	/**
     * Para escribir el contenido de una celda.
     *
     * @param row Row.
     * @param i posicion en la fila.
     * @param value texto a escribir.
     * @param style estilo de la celda.
     */
    public void createCell(Row row, int i, String value, CellStyle style) {
        Cell cell = row.createCell(i);
        value = value+" ";
        cell.setCellValue(value);
        // si no hay estilo, no se aplica
        if (style != null)
            cell.setCellStyle(style);
    }
    //-------------
 
    /**
     * Crea una hoja Excel con el contenido especificado.
     * @param v Vector con los datos a escribir en la hoja.
     * @param namesheet nombre de la hoja.
     * @param filename path del fichero donde se escribe.
     */
    public void crearExcel(Vector v, String namesheet, String filename)
            throws Exception {
        try {
            Workbook wb = new HSSFWorkbook();
            // Workbook wb = new XSSFWorkbook();
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet(namesheet);
            int filas = v.size();
            for (int i = 0; i < filas; i++) {
                String fila = (String) v.elementAt(i);
                StringTokenizer st = new StringTokenizer(fila, ",");
                Row row = sheet.createRow((short) i);
                int j = 0;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    // para la cabecera, la primera fila, aplicamos un estilo (negrita y color de fondo azul)
                    if (i == 0) {
                        CellStyle style = wb.createCellStyle();
                        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
                        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                        Font font = wb.createFont();
                        // font.setFontHeightInPoints((short)10);
                        font.setFontName("Courier New");
                        // font.setItalic(true);
                        // font.setStrikeout(true);
                        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
                        font.setColor(IndexedColors.WHITE.getIndex());
                        style.setFont(font);
                        createCell(row, j, token, style);
                    } else
                    {
                        createCell(row, j, token, null);
                    }
                    j = j + 1;
 
                }
 
            }
 
            // Asignar automaticamente el tamaño de las celdas en funcion del contenido
            for (int i = 0; i < filas; i++) {
                sheet.autoSizeColumn((short) i);
            }
            // Escribir el fichero.
           // FileOutputStream fileOut = new FileOutputStream(filename);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try {
            	wb.write(bos);  //
                //  AMedia amedia = new AMedia("libro.xlsx", "xls", "application/file", out.toByteArray());
                AMedia amedia = new AMedia(filename+".xls", "xls", "application/file",bos.toByteArray());
                Filedownload.save(amedia);
            } finally {
                bos.close();
            }
//            wb.write(fileOut);
//            fileOut.close();
 
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // ------------------
    
    /**
     * Para probar el correcto funcionamiento de la clase.
     * @param args argumentos de entrada.
     */
//    public static void main(String[] args) {
//        try {
// 
//            //Datos a escribir
//            Vector v = new Vector();
//            v.addElement("IDENTIFICADOR ,ID_CODIGO ,ESTADO ,DESCRIPCION");
//            v.addElement("34567,CODIGO_00,Critica,Esto es un texto muy largo \r\n Esto es un texto muy largo");
//            v.addElement("34568,CODIGO_01,Baja,Esto es un texto muy largo \r\n Esto es un texto muy largo");
//            v.addElement("34569,CODIGO_02,Media,Esto es un texto muy largo \r\n Esto es un texto muy largo");
// 
//            // Generar el fichero
//            //GenerarExcel.crearExcel(v, "Ejemplo", "C:/Users/Usuario/Documents/proyectos_indigo/Contable1.0/WebContent/demo.xls");
//            Date fechacatual = new Date();
//            String dateString = fechacatual.toString();
//            String nombre = "" , var = "";
//            String nombre2 = "thgf:fdfdf:ffe";
//            System.out.println(" 1. " + dateString);
//            //SimpleDateFormat format = new SimpleDateFormat("EEE-MMM-dd-yyyy-HH:mm:ss");
//            SimpleDateFormat format = new SimpleDateFormat("MMM-dd-yyyy-HH:mm:ss");
//            System.out.println(" 3. " + format.format(fechacatual));
//            nombre= format.format(fechacatual);
//            System.out.println("nombre->"+nombre);
//            var = nombre2.replace(":", "");
//            System.out.println("nuevo nombre2->"+nombre2);
//            System.out.println("var->"+var);
//            System.out.println("[ Generado fichero. ]");
// 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    // ----
	
}
