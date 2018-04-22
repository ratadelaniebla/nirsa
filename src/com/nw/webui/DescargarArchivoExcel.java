package com.nw.webui;

import java.io.ByteArrayOutputStream;
//import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.apache.poi.xssf.usermodel.XSSFDataFormat;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.*;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.zkoss.poi.xssf.usermodel.XSSFRow;

//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DataFormat;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.DataFormat;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.zkoss.poi.ss.usermodel.CellStyle;
import org.zkoss.poi.xssf.usermodel.XSSFCellStyle;
import org.zkoss.poi.xssf.usermodel.XSSFDataFormat;
import org.zkoss.poi.xssf.usermodel.XSSFRow;
import org.zkoss.poi.xssf.usermodel.XSSFSheet;
import org.zkoss.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Filedownload;

import com.nw.model.dao.impl.ExcelDAOJpaImpl;
import com.nw.util.Sistema;


public class DescargarArchivoExcel {
	

	private void setDataFormat(HSSFWorkbook workbook, HSSFSheet sheet, int index, String format){
		HSSFDataFormat fmt = workbook.createDataFormat();
		HSSFCellStyle textStyle = workbook.createCellStyle();
		//textStyle.setDataFormat(fmt.getFormat("@")); // TXT
		textStyle.setDataFormat(fmt.getFormat(format));
		sheet.setDefaultColumnStyle(index, textStyle);
	}
	
	
	
	private void setDataFormatXSSF(XSSFWorkbook workbook, XSSFSheet sheet, int index, String format){
		XSSFDataFormat fmt = workbook.createDataFormat();
		XSSFCellStyle textStyle = workbook.createCellStyle();
		//textStyle.setDataFormat(fmt.getFormat("@")); // TXT
		textStyle.setDataFormat(fmt.getFormat(format));
		sheet.setDefaultColumnStyle(index, textStyle);
	}	
	/**
	 * MÃ©todo para descargar el archivo Excel
	 * @author carper
	 * @param nombreArchivo
	 * @param workbook
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void descargaExcel(String nombreArchivo, HSSFWorkbook workbook) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			workbook.write(baos);
			AMedia amedia = new AMedia(nombreArchivo+".xls", "xls", "application/file", baos.toByteArray());
			Filedownload.save(amedia);
		}finally {
			baos.close();
		}
	}
	
	
	
	
	@SuppressWarnings("unused")
	private void descargaExcelXSSF(String nombreArchivo, XSSFWorkbook workbook) throws IOException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			workbook.write(baos);
			AMedia amedia = new AMedia(nombreArchivo+".xlsx", "xlsx", "application/file", baos.toByteArray());
			Filedownload.save(amedia);
		}finally {
			baos.close();
		}
	}	
	
	
	
	/**
	 * Descarga un archivo Excel con datos de desperdicio
	 * @author carper 
	 * 2014-02-06
	 * @param fechaProduccion
	 * @param turno
	 * @throws Exception
	 */
	public void getDesperdicio(String fechaProduccion, int turno) throws Exception{
		List <Object[]> lista = new ExcelDAOJpaImpl().getDatosDesperdicio(fechaProduccion, turno);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");
		
		setDataFormat(workbook, sheet, 2, Sistema.FORMATO_FECHA_DMY);
        
		HSSFRow rowhead = sheet.createRow(0);
		rowhead.createCell(0).setCellValue("Id desperdicio");
		rowhead.createCell(1).setCellValue("Lugar");
		rowhead.createCell(2).setCellValue("Fecha produccion");
		rowhead.createCell(3).setCellValue("Area");
		rowhead.createCell(4).setCellValue("Lugar");
		rowhead.createCell(5).setCellValue("Sub Producto");
		rowhead.createCell(6).setCellValue("Linea");
		rowhead.createCell(7).setCellValue("Peso neto");
		rowhead.createCell(8).setCellValue("Lote");
		rowhead.createCell(9).setCellValue("Hora de Registro");

		int i = 1;
		for (Object[] l: lista){
			HSSFRow row = sheet.createRow(i++);
			row.createCell(0).setCellValue( (Long)		l[0] ); // Id desperdicio detalle
			row.createCell(1).setCellValue( (Integer)	l[1] );	// Lugar detalle
			row.createCell(2).setCellValue( (Date)		l[2] );	// Fecha produccion
			row.createCell(3).setCellValue( (String) 	l[3] );	//Area
			row.createCell(4).setCellValue( (String) 	l[4] );	//Lugar
			row.createCell(5).setCellValue( (String) 	l[5] );	//Sub Producto
			row.createCell(6).setCellValue( (Integer)	l[6] );	//Linea
			row.createCell(7).setCellValue( (Double) 	l[7] );	//Peso neto
			row.createCell(8).setCellValue( (String) 	l[8] );	//Lotes
			
			row.createCell(9).setCellValue( (String) 	l[9] );	//Hora de Registro
		    //row.createCell(9).setCellValue( (java.sql.Time) l[9] );	//Hora de Registro
		}
		descargaExcel("desperdicio", workbook);
	}

	
	
	public void getPagosPesos(String fechaProduccion, int turno, int... mesa) throws Exception{

		List <Object[]> lista;
//		if (mesa.length == 1)
//			lista = new ExcelDAOJpaImpl().getDatosLimpieza(formato, fechaProduccion, turno, mesa[0]); // Tres parámetros
//		else
			lista = new ExcelDAOJpaImpl().getDatosPesos(fechaProduccion, turno); // Dos parámetros

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");

		setDataFormat(workbook, sheet, 0, Sistema.FORMATO_FECHA_DMY);
		setDataFormat(workbook, sheet, 4, Sistema.FORMATO_FECHA_DMY_HMS);
		
		HSSFRow rowhead = sheet.createRow(0);
		
		rowhead.createCell(0).setCellValue("fechapro");
		rowhead.createCell(1).setCellValue("turno");
		rowhead.createCell(2).setCellValue("mesa");
		rowhead.createCell(3).setCellValue("codtra");
		rowhead.createCell(4).setCellValue("hordes");
		rowhead.createCell(5).setCellValue("horhas");
		rowhead.createCell(6).setCellValue("especi");
		rowhead.createCell(7).setCellValue("tipoli");
		rowhead.createCell(8).setCellValue("codlim");
		rowhead.createCell(9).setCellValue("canast");
		rowhead.createCell(10).setCellValue("cannor");
		rowhead.createCell(11).setCellValue("canext");
		rowhead.createCell(12).setCellValue("peso");
		rowhead.createCell(13).setCellValue("pesope");
		rowhead.createCell(14).setCellValue("timeep");
		rowhead.createCell(15).setCellValue("empnue");
		rowhead.createCell(16).setCellValue("usring");
		rowhead.createCell(17).setCellValue("fecing");
		rowhead.createCell(18).setCellValue("horing");
		rowhead.createCell(19).setCellValue("usract");
		rowhead.createCell(20).setCellValue("fecact");
		rowhead.createCell(21).setCellValue("horact");
		
		int i = 1;
		for (Object[] l: lista){
			System.out.println("Contando :"+String.valueOf(i));
			HSSFRow row = sheet.createRow(i++);
							
			row.createCell(0).	setCellValue( (String) 	l[0] );		// Fecha produccion
			row.createCell(1).	setCellValue( (String)  l[1] ); 	// turno
			row.createCell(2).	setCellValue( (String)  l[2] ); 	// mesa
			row.createCell(3).	setCellValue( (String) 	l[3] ); 	// usuario
			row.createCell(4).	setCellValue( (String) 	l[4] );		// Fecha registro
			row.createCell(5).	setCellValue( (String)  l[5] );		// ubicacion
			row.createCell(6).	setCellValue( (String) 	l[6] );		// Codigo empleado
			row.createCell(7).	setCellValue( (String) 	l[7] );		// Empleado
			row.createCell(8).	setCellValue( (String)  l[8] );		// Lote
			row.createCell(9).	setCellValue( (String) 	l[9] );		// Especie
			row.createCell(10).	setCellValue( (String) 	l[10] );	// Talla			
	    	row.createCell(11).	setCellValue( (String) 	l[11] );	// Peso lomo
	    	row.createCell(12).	setCellValue( (String)	l[12] );	// Tipo			
			row.createCell(13).	setCellValue( (String)	l[13] );	// Peso total
			row.createCell(14).	setCellValue( (String)	l[14] );	// Tarjeta
			row.createCell(15).	setCellValue( (String)  l[15] );	// Lote
			row.createCell(16).	setCellValue( (String) 	l[16] );	// Especie
			row.createCell(17).	setCellValue( (String) 	l[17] );	// Talla			
	    	row.createCell(18).	setCellValue( (String) 	l[18] );	// Peso lomo
	    	row.createCell(19).	setCellValue( (String)	l[19] );	// Tipo			
			row.createCell(20).	setCellValue( (String)	l[20] );	// Peso total
			row.createCell(21).	setCellValue( (String)	l[21] );	// Tarjeta
			
		}
		descargaExcel("Pagos", workbook);
	}	
	
	/**
	 * Descarga un archivo Excel con datos de limpieza
	 * @author carper 
	 * 2014-02-06
	 * @param fechaProduccion
	 * @param turno
	 * @param mesa
	 * @throws Exception
	 */
	public void getLimpieza(int formato, String fechaProduccion, int turno, int... mesa) throws Exception
	{
		List <Object[]> lista;
		if (mesa.length == 1)
			lista = new ExcelDAOJpaImpl().getDatosLimpieza(formato, fechaProduccion, turno, mesa[0]); // Tres parámetros
		else
			lista = new ExcelDAOJpaImpl().getDatosLimpieza(formato, fechaProduccion, turno); // Dos parámetros

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");

		setDataFormat(workbook, sheet, 0, Sistema.FORMATO_FECHA_DMY);
		setDataFormat(workbook, sheet, 4, Sistema.FORMATO_FECHA_DMY_HMS);
		
		HSSFRow rowhead = sheet.createRow(0);
		rowhead.createCell(0).setCellValue("Fecha produccion");
		rowhead.createCell(1).setCellValue("Turno");
		rowhead.createCell(2).setCellValue("Mesa");
		rowhead.createCell(3).setCellValue("Usuario");
		rowhead.createCell(4).setCellValue("Fecha registro");
		rowhead.createCell(5).setCellValue("Ubicacion");
		rowhead.createCell(6).setCellValue("Codigo empleado");
		rowhead.createCell(7).setCellValue("Nombre");
		rowhead.createCell(8).setCellValue("Lote");
		rowhead.createCell(9).setCellValue("PesoLote");
		rowhead.createCell(10).setCellValue("Especie");
		rowhead.createCell(11).setCellValue("Talla");
		
    	//2 Columnas de pesos
    	if(formato == 1 || formato == 3 || formato == 4)
    	{
    		rowhead.createCell(12).setCellValue("Peso lomo");
    		rowhead.createCell(13).setCellValue("Peso rallado");
    	}
    	else
    		// 1 Columna de Peso y otra de indicación
    		{
	    		rowhead.createCell(12).setCellValue("Peso");
	    		rowhead.createCell(13).setCellValue("Tipo");
    		}

    		
		rowhead.createCell(14).setCellValue("Peso total");
		
    	if(formato == 4)
    	{
    		rowhead.createCell(15).setCellValue("Bandejas Rallado");
    		rowhead.createCell(16).setCellValue("Tarjeta");
    	}
    	else
    	{
    		rowhead.createCell(15).setCellValue("Tarjeta");	
    	}
		
		
		int i = 1;
		for (Object[] l: lista){
			
			HSSFRow row = sheet.createRow(i++);
							
			row.createCell(0).	setCellValue( (Date) 	l[0] );		// Fecha produccion
			row.createCell(1).	setCellValue( (Integer) l[1] ); 	// turno
			row.createCell(2).	setCellValue( (Integer) l[2] ); 	// mesa
			row.createCell(3).	setCellValue( (String) 	l[3] ); 	// usuario
			row.createCell(4).	setCellValue( (Date) 	l[4] );		// Fecha registro
			row.createCell(5).	setCellValue( (Integer) l[5] );		// ubicacion
			row.createCell(6).	setCellValue( (String) 	l[6] );		// Codigo empleado
			row.createCell(7).	setCellValue( (String) 	l[7] );		// Empleado
			row.createCell(8).	setCellValue( (Integer) l[8] );		// Lote
			row.createCell(9).	setCellValue( (Double) l[9] );		// PesoLote
			row.createCell(10).	setCellValue( (String) 	l[10] );	// Especie
			row.createCell(11).	setCellValue( (String) 	l[11] );	// Talla
			
			
	    	//2 Columnas de pesos
	    	if(formato == 1 || formato == 3 || formato == 4)
	    	{
	    		//row.createCell(12).	setCellValue( (Double)	l[12] );	// Peso rallado
	    		if (l[12] == null)
	    		{
	    			row.createCell(12).	setCellValue( (String) 	" " );	// Peso lomo
	    		}
	    		else
	    		{
	    			row.createCell(12).	setCellValue( (Double) 	l[12] );	// Peso lomo	
	    		}
	    		
	    		
	    		if (l[13] == null)
	    		{
	    			row.createCell(13).	setCellValue( (String)	" " );	// Peso rallado
	    		}
	    		else
	    		{
	    			row.createCell(13).	setCellValue( (Double)	l[13] );	// Peso rallado	
	    		}
	    		
	    		
	    		
	    		
	    	}
	    	else
	    		// 1 Columna de Peso y otra de indicación
	    		{
	    			row.createCell(12).	setCellValue( (Double) 	l[12] );	// Peso lomo
	    			row.createCell(13).	setCellValue( (String)	l[13] );	// Tipo	
	    		}
			
			row.createCell(14).	setCellValue( (Double)	l[14] );	// Peso total
			
			

			//Colunma que agrega en número de Bandejas de Rallado
	    	if(formato == 4)
	    	{
	    		if (l[15] == null)
	    		{
	    			row.createCell(15).	setCellValue( (String) 	" "  );	//Bandejas Rallado	
	    		}
	    		else
	    		{
	    			row.createCell(15).	setCellValue( (Integer) l[15] );	//Bandejas Rallado	
	    		}
				
	    		row.createCell(16).	setCellValue( (String)	l[16] );	// Tarjeta
	    	}
	    	else
	    	{
	    		row.createCell(15).	setCellValue( (String)	l[15] );	// Tarjeta	
	    	}
			
		}
		descargaExcel("limpieza", workbook);
	}



	
	
	public void getPonchadas(String fechaProduccion1, String fechaProduccion2, Integer tipo) throws Exception
	{
		List <Object[]> lista;
		
		// 1= Fileletado/Panza
		// 2= Despellejado
		
//		if(tipo == 1)
//		{
//			//Fileletado/Panza
			lista = new ExcelDAOJpaImpl().getDatosPonchadas(fechaProduccion1, fechaProduccion2); // Dos parámetros
//		}
//		else
//		{
//			//Despellejado
//			lista = new ExcelDAOJpaImpl().getDatosPonchadasDespellejado(fechaProduccion1, fechaProduccion2); // Dos parámetros
//		}
			

		if (lista.size() > 65536)
		{
	        XSSFWorkbook workbook = new XSSFWorkbook(); 
	        XSSFSheet sheet = workbook.createSheet("Hoja1");


        
	        
	        
//	        setDataFormatXSSF(workbook, sheet, 0, Sistema.FORMATO_FECHA_DMY);	        
//	        setDataFormatXSSF(workbook, sheet, 13, Sistema.FORMATO_FECHA_DMY_HMS);
			XSSFRow rowhead = sheet.createRow(0);	

			
		
			
			rowhead.createCell(0).setCellValue("Fecha produccion");
			rowhead.createCell(1).setCellValue("Turno");
			rowhead.createCell(2).setCellValue("CodigoEvolution");
			rowhead.createCell(3).setCellValue("Cedula");
			rowhead.createCell(4).setCellValue("Nombre");
			rowhead.createCell(5).setCellValue("Tipo");
			rowhead.createCell(6).setCellValue("Corte");
			rowhead.createCell(7).setCellValue("Descripcion");
			rowhead.createCell(8).setCellValue("Especificacion");
			
			rowhead.createCell(9).setCellValue("NumPonchada_normal");
			rowhead.createCell(10).setCellValue("NumPonchada_extra");
			
			rowhead.createCell(11).setCellValue("Linea");
	    	rowhead.createCell(12).setCellValue("Ubicacion");
	    	rowhead.createCell(13).setCellValue("FechaRegistro");

			
			
			int i = 1;
			for (Object[] l: lista)
			{
				
				XSSFRow row = sheet.createRow(i++);

				row.createCell(0).	setCellValue( (String) 	l[0] );		// Fecha produccion
				row.createCell(1).	setCellValue( (Integer) l[1] ); 	// turno
				row.createCell(2).	setCellValue( (String)  l[2] ); 	// codevolution
				row.createCell(3).	setCellValue( (String) 	l[3] ); 	// cedula
				row.createCell(4).	setCellValue( (String) 	l[4] );		// nombres
				row.createCell(5).	setCellValue( (String)  l[5] );		// tipo
				row.createCell(6).	setCellValue( (String) 	l[6] );		// corte
				row.createCell(7).	setCellValue( (String) 	l[7] );		// descripcion
				row.createCell(8).	setCellValue( (String)  l[8] );		// especificacion
				
				row.createCell(9).	setCellValue( (Integer) l[9] );		// numponchadanormal
				row.createCell(10).	setCellValue( (Integer) l[10] );	// numponchadaextra
				
				row.createCell(11).	setCellValue( (Integer) l[11] );	// linea
				
				try {
					row.createCell(12).	setCellValue( (Integer) l[12] );	// ubicacion
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
				row.createCell(13).	setCellValue( (String) 	l[13] );	// Fecha registro
			}			
			
			
			descargaExcelXSSF("Ponchadas", workbook);			
			
			
//            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
//            workbook.write(out);
//            out.close();
			
			
	        
		}
		else
		{
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Hoja1");
			setDataFormat(workbook, sheet, 0, Sistema.FORMATO_FECHA_DMY);
			setDataFormat(workbook, sheet, 13, Sistema.FORMATO_FECHA_DMY_HMS);
			HSSFRow rowhead = sheet.createRow(0);
			
			rowhead.createCell(0).setCellValue("Fecha produccion");
			rowhead.createCell(1).setCellValue("Turno");
			rowhead.createCell(2).setCellValue("CodigoEvolution");
			rowhead.createCell(3).setCellValue("Cedula");
			rowhead.createCell(4).setCellValue("Nombre");
			rowhead.createCell(5).setCellValue("Tipo");
			rowhead.createCell(6).setCellValue("Corte");
			rowhead.createCell(7).setCellValue("Descripcion");
			rowhead.createCell(8).setCellValue("Especificacion");
			
			rowhead.createCell(9).setCellValue("NumPonchada_normal");
			rowhead.createCell(10).setCellValue("NumPonchada_extra");
			
			rowhead.createCell(11).setCellValue("Linea");
	    	rowhead.createCell(12).setCellValue("Ubicacion");
	    	rowhead.createCell(13).setCellValue("FechaRegistro");

			
			
			int i = 1;
			for (Object[] l: lista)
			{
				
				HSSFRow row = sheet.createRow(i++);
						
				
				row.createCell(0).	setCellValue( (String) 	l[0]);		// Fecha produccion
				row.createCell(1).	setCellValue( (Integer) l[1] ); 	// turno
				row.createCell(2).	setCellValue( (String)  l[2] ); 	// codevolution
				row.createCell(3).	setCellValue( (String) 	l[3] ); 	// cedula
				row.createCell(4).	setCellValue( (String) 	l[4] );		// nombres
				row.createCell(5).	setCellValue( (String)  l[5] );		// tipo
				row.createCell(6).	setCellValue( (String) 	l[6] );		// corte
				row.createCell(7).	setCellValue( (String) 	l[7] );		// descripcion
				row.createCell(8).	setCellValue( (String)  l[8] );		// especificacion
				
				row.createCell(9).	setCellValue( (Integer) l[9] );		// numponchadanormal
				row.createCell(10).	setCellValue( (Integer) l[10] );	// numponchadaextra
				
				row.createCell(11).	setCellValue( (Integer) l[11] );	// linea
				
				try {
					row.createCell(12).	setCellValue( (Integer) l[12] );	// ubicacion
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
				row.createCell(13).	setCellValue( (String) 	l[13] );	// Fecha registro
			}
			
			descargaExcel("Ponchadas", workbook);			
		}
		
		
		
		
		
		
		
		
		

	}
	
	
	
	

	public void getCalidadPcc1(long calidadPccId) throws Exception{
		String nombre_archivo = "";
		List <Object[]> lista = new ExcelDAOJpaImpl().getDatosCalidadPcc1(calidadPccId);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");
		
		setDataFormat(workbook, sheet, 6, Sistema.FORMATO_FECHA_DMY_HMS);
		setDataFormat(workbook, sheet, 7, Sistema.FORMATO_FECHA_DMY_HMS);

		//Formatear columnas numéricas
		for (int i=13; i<=18; i++)
			setDataFormat(workbook, sheet, i, "0.00");
        
		HSSFRow rowhead = sheet.createRow(0);
		
		rowhead.createCell( 0).setCellValue("barco");
		rowhead.createCell( 1).setCellValue("numbarco");
		rowhead.createCell( 2).setCellValue("nummuestreo");
		
		rowhead.createCell( 3).setCellValue("muestreo");
		rowhead.createCell( 4).setCellValue("lote camara");
		
		rowhead.createCell( 5).setCellValue("haccp");
		
		rowhead.createCell( 6).setCellValue("fecha descarga");
		rowhead.createCell( 7).setCellValue("fecha inicio descarga");

		rowhead.createCell( 8).setCellValue("fecha");
		rowhead.createCell( 9).setCellValue("hora");
		
		rowhead.createCell(10).setCellValue("registro");
		rowhead.createCell(11).setCellValue("idcalidadpcc");
		rowhead.createCell(12).setCellValue("nombrecuba");
		rowhead.createCell(13).setCellValue("especie");
		rowhead.createCell(14).setCellValue("talla");
		rowhead.createCell(15).setCellValue("idtalla");
		rowhead.createCell(16).setCellValue("temperatura");
		rowhead.createCell(17).setCellValue("sal");
		rowhead.createCell(18).setCellValue("histamina");
		rowhead.createCell(19).setCellValue("nitrogeno");
		rowhead.createCell(20).setCellValue("ph");
		rowhead.createCell(21).setCellValue("idespecietalla");
		rowhead.createCell(22).setCellValue("viaje");
		rowhead.createCell(23).setCellValue("ojos");
		rowhead.createCell(24).setCellValue("agallas");
		rowhead.createCell(25).setCellValue("piel");
		rowhead.createCell(26).setCellValue("dano");
		rowhead.createCell(27).setCellValue("olor");
		rowhead.createCell(28).setCellValue("sabor");
		rowhead.createCell(29).setCellValue("salida");
		rowhead.createCell(30).setCellValue("salidasal");
		rowhead.createCell(31).setCellValue("salidahistamina");
		rowhead.createCell(32).setCellValue("salidaph");
		rowhead.createCell(33).setCellValue("salidanitrogeno");
		rowhead.createCell(34).setCellValue("salidaojos");
		rowhead.createCell(35).setCellValue("salidaagalla");
		rowhead.createCell(36).setCellValue("salidapiel");
		rowhead.createCell(37).setCellValue("salidadano");
		rowhead.createCell(38).setCellValue("salidaolor");
		rowhead.createCell(39).setCellValue("salidasabor");
		rowhead.createCell(40).setCellValue("codigoqm");
		
	
		int i = 1;
		for (Object[] l: lista)
		{
			HSSFRow row = sheet.createRow(i++);
			//nombre_archivo = String.valueOf((Date) l[1]);
			
			for (int j=0; j<41; j++)
			{
				if (j==6 || j==7) 
				{
					row.createCell(6).setCellValue( (Date) l[6] );	// Fecha descarga
					row.createCell(7).setCellValue( (Date) l[7] );	// Fecha inicio descarga 
					//row.createCell(6).setCellValue( (Date) l[6] );	// Emision
					
				}
				if (j>=17 && j<=21)
				{
						String campo = l[j].toString();
							
						//System.out.println("Dato :"+campo);
						//if (campo.length()>0)
						if(campo.trim().equals("-"))	
							row.createCell(j).setCellValue( "" ); // Columnas numéricas
						else
								row.createCell(j).setCellValue(Sistema.parseDouble(campo) ); // Columnas enteros y decimales
				}
					else
						if (j==3)
							row.createCell(j).setCellValue(Sistema.parseInt(l[j].toString())); // Columnas numéricas
						else
							
							try 
							{
							  row.createCell(j).setCellValue( l[j].toString() ); //El resto de los campos son String 
							} 
							catch (Exception e) 
							{
								// TODO Auto-generated catch block
								row.createCell(j).setCellValue(""); //El resto de los campos son String
							}
				
			}
		}
/*		
		if(nombre_archivo == null)
		{
			nombre_archivo = "CalidadPcc1 - "+" "+nombre_archivo;			
		}
		else
		{
			nombre_archivo = "CalidadPcc1";
		}
*/
		//+" - " +nombre_archivo
		descargaExcel("CalidadPcc1", workbook);
	}

	public void getDescongeladoPesoCajon(String fecha1, String fecha2) throws Exception{
		List <Object[]> lista = new ExcelDAOJpaImpl().getDatosDescongeladoPesoCajon(fecha1, fecha2);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");
		
		setDataFormat(workbook, sheet, 1, Sistema.FORMATO_FECHA_DMY_HMS);
        
		HSSFRow rowhead = sheet.createRow(0);
		rowhead.createCell(0).setCellValue("NumRegistro");
		rowhead.createCell(1).setCellValue("Fecha");
		rowhead.createCell(2).setCellValue("Usuario");
		rowhead.createCell(3).setCellValue("Turno");
		rowhead.createCell(4).setCellValue("Peso");
		rowhead.createCell(5).setCellValue("Tara");
		rowhead.createCell(6).setCellValue("Cajon");

		int i = 1;
		for (Object[] l: lista){
			HSSFRow row = sheet.createRow(i++);
			row.createCell(0).setCellValue( (Long)		l[0] ); // Id Registro
			row.createCell(1).setCellValue( (Date)		l[1] );	// Fecha
			row.createCell(2).setCellValue( (String)	l[2] );	// Usuario
			row.createCell(3).setCellValue( (Integer) 	l[3] );	// Turno
			row.createCell(4).setCellValue( (Double) 	l[4] );	// Peso
			row.createCell(5).setCellValue( (Double) 	l[5] );	// Tara
			row.createCell(6).setCellValue( (String) 	l[6] );	// Id.Cajon
		}
		descargaExcel("descongeladopesocajon", workbook);
	}

	public void getDescongeladoPesoCajon2(String fecha1, String fecha2) throws Exception{
		List <Object[]> lista = new ExcelDAOJpaImpl().getDatosDescongeladoPesoCajon2(fecha1, fecha2);

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Hoja1");
		
		setDataFormat(workbook, sheet, 2, Sistema.FORMATO_FECHA_DMY_HMS);
        
		HSSFRow rowhead = sheet.createRow(0);
		rowhead.createCell(0).setCellValue("NumRegistro");
		rowhead.createCell(1).setCellValue("Cajon");
		rowhead.createCell(2).setCellValue("Fecha");
		rowhead.createCell(3).setCellValue("Usuario");
		rowhead.createCell(4).setCellValue("Turno");
		rowhead.createCell(5).setCellValue("Peso_Bruto_Descongelado");
		rowhead.createCell(6).setCellValue("Tara");
		rowhead.createCell(7).setCellValue("Peso_Neto_Descongelado");
		rowhead.createCell(8).setCellValue("Peso_Camara");
		rowhead.createCell(9).setCellValue("Peso_Merma");


		int i = 1;
		for (Object[] l: lista){
			HSSFRow row = sheet.createRow(i++);
			row.createCell(0).setCellValue( (Long)		l[0] ); // Id Registro
			row.createCell(1).setCellValue( (String) 	l[1] );	// Id.Cajon
			row.createCell(2).setCellValue( (Date)		l[2] );	// Fecha
			row.createCell(3).setCellValue( (String)	l[3] );	// Usuario
			row.createCell(4).setCellValue( (Integer) 	l[4] );	// Turno
			row.createCell(5).setCellValue( (Double) 	l[5] );	// Peso_Bruto_D
			row.createCell(6).setCellValue( (Double) 	l[6] );	// Tara
			row.createCell(7).setCellValue( (Double) 	l[7] );	// Peso_Neto_D
			row.createCell(8).setCellValue( (Double) 	l[8] );	// Peso_Tara_C
			row.createCell(9).setCellValue( (Double) 	l[9] );	// Peso_Merma
		}
		descargaExcel("descongeladopesocajon", workbook);
	}

	
}
