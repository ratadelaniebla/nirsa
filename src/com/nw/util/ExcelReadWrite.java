package com.nw.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.zkoss.poi.hssf.usermodel.HSSFSheet;
//import org.zkoss.poi.hssf.usermodel.HSSFWorkbook;

import org.zkoss.poi.ss.usermodel.Cell;
import org.zkoss.poi.ss.usermodel.DateUtil;
import org.zkoss.poi.ss.usermodel.Row;
import org.zkoss.poi.ss.usermodel.Sheet;
import org.zkoss.poi.ss.usermodel.Workbook;
import org.zkoss.poi.ss.usermodel.WorkbookFactory;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.util.media.Media;

public class ExcelReadWrite {

    public String readExcel(String excel_file, int hoja, int tupla, int colum) {

        String cellData = new String();

        try{
///////////////////////USANDO CLASE JXL.//////////////////////////////////////////////        	
//            Workbook workbook = Workbook.getWorkbook(new File(excel_file));     
//            //Gets the sheet
//            Sheet sheet = workbook.getSheet(sheet_name);
//            /* Reads cell data*/
//            Cell cell = sheet.getCell(cell_num);
//            cellData = cell.getContents();
//            workbook.close();
////////////////////////////////////////////////////////////////////////////////////
        	
            InputStream inp = new FileInputStream(excel_file);
            //InputStream inp = new FileInputStream("workbook.xlsx");

            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(hoja);
            Row row = sheet.getRow(tupla);
            Cell cell = row.getCell(colum);
            cellData = cell.toString();
            System.out.println("valor de el archivo"+cellData);
            return cellData;
//            System.out.println(cellData);
//            System.out.println(cell.getCellType());
//            if (cell == null){
////            	System.out.println("ENT");
////                cell = row.createCell(colum);
////                cell.setCellType(Cell.CELL_TYPE_STRING);
////                cell.setCellValue("a test");
////            }
//            	//return "";
//            }
        }

        catch(Exception e)
        {
        	
            System.out.println("readExcel ->"+e);
        }
        return cellData;
       
    }
    
    
    
    public List<List<Cell>> readAllExcel(String excel_file, int hoja) {

        String cellData = new String();
        List<List<Cell>> sheetData = new ArrayList<List<Cell>>();
        //FileInputStream fis = null;
        
        try{        	
            InputStream inp = new FileInputStream(excel_file);
            //InputStream inp = new FileInputStream("workbook.xlsx");
        
            //0, 2, 3
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(hoja);
            
//            Row row = sheet.getRow(tupla);
//            Cell cell = row.getCell(colum);
                        
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext(); ) {
              Row row = rit.next();
              
              List<Cell> data = new  ArrayList<Cell>();
              for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext(); ) {
                Cell cell = cit.next();                
               	System.out.println(cell.toString());
               	data.add(cell);
                // do something here
              }
              sheetData.add(data);
            }
            
        }

        catch(Exception e)
        {
            System.out.println("readExcel ->"+e);
            e.printStackTrace();
        }
        //showExelData(sheetData);
        return sheetData;
       
    }
    
    /**
     * Metodo que recibe un objeto media obtenido del archivo de excel
     * 17-09-2014
     * @param mediaExcel
     * @param hoja
     * @return
     */
    public List<List<Cell>> readAllExcelMedia(Media mediaExcel, int hoja) {
       
        List<List<Cell>> sheetData = new ArrayList<List<Cell>>();
        
        try{        	
            Workbook wb = WorkbookFactory.create(mediaExcel.getStreamData());
            Sheet sheet = wb.getSheetAt(hoja);
                        
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext(); ) {
              Row row = rit.next();
              
              List<Cell> data = new  ArrayList<Cell>();
              for (Iterator<Cell> cit = row.cellIterator(); cit.hasNext(); ) {
                Cell cell = cit.next();                
               	//System.out.println(cell.toString());
               	data.add(cell);
                // do something here
              }
              sheetData.add(data);
            }
            
        }

        catch(Exception e)
        {
            System.out.println("readExcel ->"+e);
        }
        //showExelData(sheetData);
        return sheetData;
       
    }
    
    
    public String readExcelMedia(Media mediaexcel, int hoja, int tupla, int colum) {

        String cellData = new String();

        try{
            //InputStream inp = new FileInputStream(excel_file);
            //InputStream inp = new FileInputStream("workbook.xlsx");
        	InputStream inp = mediaexcel.getStreamData();

            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(hoja);
            Row row = sheet.getRow(tupla);
            Cell cell = row.getCell(colum);
            cellData = cell.toString();
            System.out.println("valor de el archivo"+cellData);
            return cellData;
 
        }

        catch(Exception e)
        {
        	e.printStackTrace();
            System.out.println("error readExcel ->"+e);
        }
        return cellData;
       
    }
    
    
 
    
    
    
    public Sheet readAllExcelMediaSheet(Media mediaExcel, int hoja) {
    	 Sheet sheet = null ;
	        try{        	
	            Workbook wb = WorkbookFactory.create(mediaExcel.getStreamData());
	              sheet = wb.getSheetAt(hoja);
	        }
	        catch(Exception e)
	        {
	            System.out.println("Error asignando contenido readAllExcelMediaSheet ->"+e);
	        }
        return sheet  ;
       
    }
    
    
    
    private  static void showExelData(List sheetData) {
    	        //
    	        // Iterates the data and print it out to the console.
    	        //
        for (int i = 0; i < sheetData.size(); i++) {
        	List list = (List) sheetData.get(i);
    	    for (int j = 0; j < list.size(); j++) {
    	          Cell cell = (Cell) list.get(j);
    	          
    	            switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getRichStringCellValue().getString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(cell.getDateCellValue());
                        } else {
                            System.out.print(cell.getNumericCellValue());
                        }
                        break;
                   
                    default:
                        System.out.println();
    	            }

    	          
    	          
    	          if (j < list.size() - 1) {
    	               System.out.print(", ");
    	          }
    	    }
    	    System.out.println("");
        }
    }
    
    
    
    public String readSeetName(String excel_file, int hoja) {
    	
    	 String sheetName = new String();
         try{
        	
            InputStream inp = new FileInputStream(excel_file);
            //InputStream inp = new FileInputStream("workbook.xlsx");

            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(hoja);
            sheetName = sheet.getSheetName();
         }
         
         catch(Exception e)
         {
            System.out.println("readSheetName ->"+e);
         }
        
		//showExelData(sheetData);
         return sheetName;
           
    }
    
    
    public static Workbook createXls(String pathFile) {
        // Se crea el libro
        XSSFWorkbook libro = new XSSFWorkbook();

        // Se crea una hoja dentro del libro
        org.zkoss.poi.xssf.usermodel.XSSFSheet hoja = libro.createSheet();

        // Se crea una fila dentro de la hoja
        //HSSFRow fila = hoja.createRow(0);

        // Se crea una celda dentro de la fila
        //HSSFCell celda = fila.createCell((short) 0);

        // Se crea el contenido de la celda y se mete en ella.
        //HSSFRichTextString texto = new HSSFRichTextString("hola mundo");
        //celda.setCellValue(texto);

        // Se salva el libro.
        Workbook wb = null;
        try {
            FileOutputStream elFichero = new FileOutputStream(pathFile);
            libro.write(elFichero);
            elFichero.close();
            
            InputStream inp = new FileInputStream(pathFile);
            //InputStream inp = new FileInputStream("workbook.xlsx");

            //0, 2, 3
            wb = WorkbookFactory.create(inp);
          
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return wb;
    }

    
    
    
    public String writeExcel(Workbook wb, String excel_file, int hoja, int tupla, int colum, String value)
    {
        String cellData = new String();
        try{
///////////////////////USANDO CLASE JXL.//////////////////////////////////////////////               	
//            Workbook target_workbook = Workbook.getWorkbook(new File(excel_file));
//            WritableWorkbook workbook = Workbook.createWorkbook(new File(excel_file), target_workbook);
//
//            target_workbook.close();
//
//            WritableSheet sheet = workbook.getSheet(sheet_name);
//
//            jxl.write.Number number = new jxl.write.Number(column, row, value);
//            sheet.addCell(number);
//
//            workbook.write();
//
//            workbook.close();
//////////////////////////////////////////////////////////////////////////////////////////                       
            //InputStream inp = new FileInputStream(excel_file);
            //InputStream inp = new FileInputStream("workbook.xlsx");

            //0, 2, 3
            //Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(hoja);
            
            Row row = sheet.getRow(tupla);
            if (row == null)
            row = sheet.createRow(tupla);
            
            Cell cell = row.getCell(colum);                        
            if (cell == null)
            cell = row.createCell(colum);
            
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(value);
              
           // return "Proceso de escrituro EXITOSO";
            return value;
            // Write the output to a file
//            FileOutputStream fileOut = new FileOutputStream(excel_file);
//            wb.write(fileOut);
//            fileOut.close();

        }
        catch(Exception e)
        {
            System.out.println("writeExcel ->"+e);
            return "ERROR: Problema con la escritura en el nuevo archivo" ;
        }
    }
    
    public void saveExcel(Workbook wb, String excel_file)
    {
       
        try{                                          
            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream(excel_file);
            wb.write(fileOut);
            fileOut.close();

        }
        catch(Exception e)
        {
            System.out.println("writeExcel ->"+e);
        }
    }

}




