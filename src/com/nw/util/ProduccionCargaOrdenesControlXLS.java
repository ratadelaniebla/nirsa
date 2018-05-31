package com.nw.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.zkoss.poi.ss.usermodel.Cell;

import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaOrden;
import com.nw.model.ProduccionArchivoCargaOrdenDetalle;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;

public class ProduccionCargaOrdenesControlXLS {
	
	private final static int SEMANA = 1;
	private final static int PRODUCCION = 1;
	
	
	@SuppressWarnings("deprecation")
	public static HashMap<String, Object> procesaXLSCargaOrden(List<List<Cell>> sheetData, Date fechaInicial){
		List<Cell> filaSemana = sheetData.get(0);
		List<Cell> filaProduccion = sheetData.get(1);
		
		List<List<Cell>> turnos = new ArrayList<List<Cell>>();
		List<Cell> detalleTurno = new ArrayList<Cell>();
		
		HashMap<String, Object> datosXLS = new HashMap<String, Object>();
		
		String celda1, observacion = "";
		
		Double semana = 0.0;
		Date produccion = null;
		
		boolean turno = false;
		
		Double numeroTurno = 0.0;
		
		if (filaSemana != null) {
			try {
				semana = filaSemana.get(SEMANA).getNumericCellValue();
			}catch(Exception e) {
				if (Cell.CELL_TYPE_STRING == filaSemana.get(SEMANA).getCellType())
					semana = Double.parseDouble(filaSemana.get(SEMANA).getStringCellValue());
				else
					Sistema.mensaje("El formato de la celda SEMANA debe ser numérico");
				e.printStackTrace();
			}
		}
		if(filaProduccion != null) {
			try {
				produccion = filaProduccion.get(PRODUCCION).getDateCellValue();
				
				if (new SimpleDateFormat("dd-MM-yyyy").format(fechaInicial).compareTo(new SimpleDateFormat("dd-MM-yyyy").format(produccion))!=0) {
					Sistema.mensaje("La fecha producción no coincide con la del archivo xls");
					return null;	
				}
				
			} catch(Exception e){
				try{
				if (Cell.CELL_TYPE_STRING == filaProduccion.get(PRODUCCION).getCellType()) {
					produccion = new Date(filaProduccion.get(PRODUCCION).getStringCellValue());
				}else{
					Sistema.mensaje("El formato de la celda PRODUCCION debe ser fecha");
					return null;
				}
				}catch(Exception e2){
					Sistema.mensaje("El formato de la celda PRODUCCION es incorrecto, favor indique dd/mm/yyyy.");
					return null;
				}
			}
		}
			
		GregorianCalendar g = new GregorianCalendar();
		g.setTime(produccion);
		
		int cantidadSemana = g.get(java.util.Calendar.WEEK_OF_YEAR);
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		
		if (semana.intValue() != cantidadSemana){
			Sistema.mensaje("La semana correspondiente de la fecha "+ d.format(produccion)+" es "+cantidadSemana);
			return null;
		}
		boolean soloItem = true;
		HashMap<String, Object> keyTurno = new HashMap<String, Object>();
		for(int fila=0 ; sheetData.size() > fila ; fila++){
			celda1 = String.valueOf(extraeTipoDato(sheetData.get(fila).get(0)));
			if ( "turno".equalsIgnoreCase(celda1) ) {
				soloItem = true;
				numeroTurno =  Double.parseDouble( extraeTipoDato(sheetData.get(fila).get(1)).toString() );
				if ( !validaTurno(numeroTurno) ) {
					Sistema.mensaje("El turno "+numeroTurno.intValue()+" no se encuentra configurado.");
					return null;
				}else{
					if (!keyTurno.isEmpty())
						if (keyTurno.containsKey("TURNO"+numeroTurno)) {
							Sistema.mensaje("Se encontro duplicado un turno en la hoja de calculo.");
							return null;
						}
					keyTurno.put("TURNO"+numeroTurno, null);
				}
				
				turno=true;
				if (!turnos.isEmpty()) {
					datosXLS.put("TURNO_"+(numeroTurno.intValue()-1), turnos);
				}
					
					
				turnos = new ArrayList<List<Cell>>();
			}
			
			if (turno) {
				if (Cell.CELL_TYPE_BLANK == sheetData.get(fila).get(0).getCellType())
					soloItem = false;
				System.out.println(sheetData.get(fila).get(0));
				System.out.println(sheetData.get(fila).get(0).getCellType());
				if (!"turno".equalsIgnoreCase(celda1) && !"item".equalsIgnoreCase(celda1)) {
					if (Cell.CELL_TYPE_NUMERIC == sheetData.get(fila).get(0).getCellType() && soloItem) {
						detalleTurno.addAll(sheetData.get(fila));
						turnos.add(detalleTurno);
						detalleTurno = new ArrayList<Cell>();
					} else if (Cell.CELL_TYPE_STRING == sheetData.get(fila).get(0).getCellType()) {
						String celda = sheetData.get(fila).get(0).getStringCellValue();
						if (!"null".equals(celda))
							observacion = observacion + celda + "\n";
					} else if (Cell.CELL_TYPE_FORMULA == sheetData.get(fila).get(0).getCellType()) {
						String celda = sheetData.get(fila).get(0).getCellFormula();
						if (!"null".equals(celda))
							if ("NOW()".equalsIgnoreCase(celda)) {
								celda = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
								observacion = observacion + celda + "\n";
							}
					} else if (Cell.CELL_TYPE_NUMERIC == sheetData.get(fila).get(0).getCellType() && !observacion.isEmpty()) {
						Date celda = sheetData.get(fila).get(0).getDateCellValue();
						String sCelda = null;
						sCelda = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(celda);
						observacion = observacion + sCelda + "\n";
					}
					System.out.println(sheetData.get(fila).get(0)+" "+sheetData.get(fila).get(0).getCellType());
				}
			}
		}
		
		if ( !turnos.isEmpty() ) {
			datosXLS.put("TURNO_"+numeroTurno.intValue(), turnos);
		}
			
		
		datosXLS.put("semana", semana);
		datosXLS.put("produccion", extraeProduccion(new Timestamp(produccion.getTime())));
		datosXLS.put("observacion", observacion);
		
		return datosXLS;
	}
	
	private static boolean validaTurno(Double turno){
		Turno mTurno = new Turno();
		TurnoDAOJpaImpl turnoDAO= new TurnoDAOJpaImpl();
		mTurno = turnoDAO.getFindTurnoId(turno.intValue());
		if (mTurno!=null)
			return true;
		else
			return false;
		
	}
	
	public static ProduccionArchivoCargaOrdenDetalle validaInfoOrdenDetalle(List<Cell> listPacoDet) {
		
		ProduccionArchivoCargaOrdenDetalle pacoD = new ProduccionArchivoCargaOrdenDetalle();
		
		double ac;
		double ag;
		Integer cajas;
		String cliente;
		double crudo;
		String destino;
		double dre;
		String esp;
		String envase; 
		double fi;
		double fill;
		double flake;
//		Integer idturno;
		Integer item;
		double formato;
		Integer latas;
		double lomolimpio;
		String marca;
		Integer materialfer;
		Integer materialhal;
		double mesa;
		String observacion;
		String orden;
		Integer ordenfer;
		Integer ordenhal;
		String presentacion;		
		String producto;
		String ps;
		double ralladoempacado;
		double ren;
//		Boolean reproceso;
		String tapa;
		double ton;
		String video;
		boolean reproceso = false;
		String sReproceso;
			
			try {
				if (!validaCampoObligatorio(listPacoDet.get(0), "ITEM"))
					return null;
				item = (int) listPacoDet.get(0).getNumericCellValue();
				pacoD.setItem(item);
			} catch(Exception e) {
				Sistema.mensaje("El formato de la columna ITEM debe ser numérico. ["+listPacoDet.get(0)+"]");
				e.printStackTrace();
			}
			
			try {
				if (!validaCampoObligatorio(listPacoDet.get(1), "ORDEN"))
					return null;
				orden = listPacoDet.get(1).getStringCellValue();
				pacoD.setOrden(orden);
			} catch(Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(1).getCellType()) {
					orden = formatoCeldaDoubleToString(listPacoDet.get(1).getNumericCellValue());
					pacoD.setOrden(orden);
				} else
					Sistema.mensaje("El formato de la columna ORDEN debe ser texto. ["+listPacoDet.get(1)+"]");
			}
			//PS
			try {
				if (!validaCampoObligatorio(listPacoDet.get(2), "PS"))
					return null;
				ps = listPacoDet.get(2).getStringCellValue();
				pacoD.setPs(ps);
			} catch(Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(2).getCellType()) {
					ps = formatoCeldaDoubleToString(listPacoDet.get(2).getNumericCellValue());
					pacoD.setPs(ps);
				} else
				Sistema.mensaje("El formato de la columna PS debe ser numérico. ["+listPacoDet.get(2)+"]");
			}
			//CLIENTE
			if (!validaCampoObligatorio(listPacoDet.get(3), "CLIENTE"))
				return null;
			if (Cell.CELL_TYPE_STRING == listPacoDet.get(3).getCellType()) {
				cliente = listPacoDet.get(3).getStringCellValue();
				pacoD.setCliente(cliente);
			} else if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(3).getCellType()) {
				cliente = formatoCeldaDoubleToString(listPacoDet.get(3).getNumericCellValue());
				pacoD.setCliente(cliente);
			} else{
				Sistema.mensaje("El formato de la columna CLIENTE debe ser texto. ["+listPacoDet.get(3)+"]");
			}
			//MARCA
			try {
				if (!validaCampoObligatorio(listPacoDet.get(4), "MARCA"))
					return null;
				marca = listPacoDet.get(4).getStringCellValue();
				pacoD.setMarca(marca);
			} catch(Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(4).getCellType()) {
					marca = formatoCeldaDoubleToString(listPacoDet.get(4).getNumericCellValue());
					pacoD.setMarca(marca);
				} else {
					Sistema.mensaje("El formato de la columna MARCA debe ser texto. ["+listPacoDet.get(4)+"]");
					e.printStackTrace();
				}
			}
			//destino
			try {
				if (!validaCampoObligatorio(listPacoDet.get(5), "DESTINO"))
					return null;
				destino = listPacoDet.get(5).getStringCellValue();
				pacoD.setDestino(destino);
			} catch(Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(5).getCellType()) {
					destino= formatoCeldaDoubleToString(listPacoDet.get(5).getNumericCellValue());
					pacoD.setDestino(destino);
				} else {
					Sistema.mensaje("El formato de la columna DESTINO debe ser texto. ["+listPacoDet.get(5)+"]");
					e.printStackTrace();
				}
			}
			//PRODUCTO
			try {
				if (!validaCampoObligatorio(listPacoDet.get(6), "PRPDUCTO"))
					return null;
				producto = listPacoDet.get(6).getStringCellValue();
				pacoD.setProducto(producto);
			} catch(Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(6).getCellType()) {
					producto = formatoCeldaDoubleToString(listPacoDet.get(6).getNumericCellValue());
					pacoD.setProducto(producto);
				} else {
					Sistema.mensaje("El formato de la columna PRODUCTO debe ser texto. ["+listPacoDet.get(6)+"]");
					e.printStackTrace();
				}
			}
			//TAPA
			try {
				if (!validaCampoObligatorio(listPacoDet.get(7), "TAPA"))
					return null;
				tapa = listPacoDet.get(7).getStringCellValue();
				pacoD.setTapa(tapa);
			} catch (Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(7).getCellType()) {
					tapa = formatoCeldaDoubleToString(listPacoDet.get(7).getNumericCellValue());
					pacoD.setTapa(tapa);
				} else {
					Sistema.mensaje("El formato de la columna TAPA debe ser texto. ["+listPacoDet.get(7)+"]");
					e.printStackTrace();
				}
			}
			//envase
			try {
				if (!validaCampoObligatorio(listPacoDet.get(8), "ENVASE"))
					return null;
				envase = listPacoDet.get(8).getStringCellValue();
				pacoD.setEnvase(envase);
			} catch (Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(8).getCellType()) {
					envase = formatoCeldaDoubleToString(listPacoDet.get(8).getNumericCellValue());
					pacoD.setEnvase(envase);
				} else {
					Sistema.mensaje("El formato de la columna ENVASE debe ser texto. ["+listPacoDet.get(8)+"]");
					e.printStackTrace();
				}
			}
			//prese
			try {
				if (!validaCampoObligatorio(listPacoDet.get(9), "PRESENT"))
					return null;
				presentacion = listPacoDet.get(9).getStringCellValue();
				pacoD.setPresentacion(presentacion);
			} catch (Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(9).getCellType()) {
					presentacion = formatoCeldaDoubleToString(listPacoDet.get(9).getNumericCellValue());
					pacoD.setPresentacion(presentacion);
				} else {
					Sistema.mensaje("El formato de la columna PRESENT debe ser texto. ["+listPacoDet.get(9)+"]");
					e.printStackTrace();
				}
			}
			//DRE
			try {
				if (!validaCampoObligatorio(listPacoDet.get(10), "DRE"))
					return null;
				dre = listPacoDet.get(10).getNumericCellValue();
				pacoD.setDre(dre);
			}catch( Exception e) {
				Sistema.mensaje("El formato de la columna DRE debe ser numérico. ["+listPacoDet.get(10)+"]");
				e.printStackTrace();				
			}
			//FI
			try {
				if (!validaCampoObligatorio(listPacoDet.get(11), "FI"))
					return null;
				fi = listPacoDet.get(11).getNumericCellValue();
				pacoD.setFi(fi);
			} catch (Exception e) {
				Sistema.mensaje("El formato de la columna FI debe ser numérico. ["+listPacoDet.get(11)+"]");
				e.printStackTrace();
			}
			//ESP
			try {
				esp = listPacoDet.get(12).getStringCellValue();
				pacoD.setEsp(esp);
			} catch (Exception e) {
				if (Cell.CELL_TYPE_NUMERIC == listPacoDet.get(12).getCellType()) {
					esp = formatoCeldaDoubleToString( listPacoDet.get(12).getNumericCellValue() ) ;
					pacoD.setEsp(esp);
				} else {
					Sistema.mensaje("El formato de la columna ESP debe ser texto. ["+listPacoDet.get(12)+"]");
					e.printStackTrace();
				}
				
			}
			//AC
			try {
				if (!validaCampoObligatorio(listPacoDet.get(13), "AC"))
					return null;
				ac = listPacoDet.get(13).getNumericCellValue();
				pacoD.setAc(ac);
			} catch ( Exception e ) {
				Sistema.mensaje("El formato de la columna AC debe ser numérico. ["+listPacoDet.get(13)+"]");
				e.printStackTrace();
			}
			//AG
			try {
				if (!validaCampoObligatorio(listPacoDet.get(14), "AG"))
					return null;
				ag = listPacoDet.get(14).getNumericCellValue();
				pacoD.setAg(ag);
			} catch( Exception e) {
				Sistema.mensaje("El formato de la columna AG debe ser numérico. ["+listPacoDet.get(14)+"]");
				e.printStackTrace();
			}
			
			try {
				mesa = listPacoDet.get(15).getNumericCellValue();
				pacoD.setMesa(mesa);
			} catch( Exception e) {
				Sistema.mensaje("El formato de la columna MESA debe ser numérico. ["+listPacoDet.get(15)+"]");
				e.printStackTrace();
			}
			
			try {
				cajas = (int) listPacoDet.get(16).getNumericCellValue();
				pacoD.setCajas(cajas);
			} catch( Exception e ) {
				Sistema.mensaje("El formato de la columna CAJA debe ser numérico. ["+listPacoDet.get(16)+"]");
				e.printStackTrace();
			}
			
			try {
				ton = listPacoDet.get(17).getNumericCellValue();
				pacoD.setTon(ton);
			} catch( Exception e) {
				Sistema.mensaje("El formato de la columna TON debe ser numérico. ["+listPacoDet.get(17)+"]");
				e.printStackTrace();
			}
			
			try {
				materialfer = (int) listPacoDet.get(18).getNumericCellValue();
				pacoD.setMaterialfer(materialfer);
			} catch ( Exception e ) {
				Sistema.mensaje("El formato de la columna MATERIALFER debe ser numérico. ["+listPacoDet.get(18)+"]");
				e.printStackTrace();
			}
			
			try {
				materialhal = (int) listPacoDet.get(19).getNumericCellValue();
				pacoD.setMaterialhal(materialhal);
			} catch( Exception e ) {
				Sistema.mensaje("El formato de la columna MATERIALHAL debe ser numérico. ["+listPacoDet.get(19)+"]");
				e.printStackTrace();
			}
			
			try {
				ordenfer = (int) listPacoDet.get(20).getNumericCellValue();
				pacoD.setOrdenfer(ordenfer);
			} catch( Exception e) {
				Sistema.mensaje("El formato de la columna ordenfer debe ser numérico. ["+listPacoDet.get(20)+"]");
				e.printStackTrace();
			}
			
			try {
				ordenhal = (int) listPacoDet.get(21).getNumericCellValue();
				pacoD.setOrdenhal(ordenhal);
			} catch (Exception e) {
				Sistema.mensaje("El formato de la columna ordenfer debe ser numérico. ["+listPacoDet.get(21)+"]");
				e.printStackTrace();
			}
			
			try {
				video = listPacoDet.get(22).getStringCellValue();
				pacoD.setVideo(video);
			} catch ( Exception e ) {
				if ( Cell.CELL_TYPE_NUMERIC == listPacoDet.get(22).getCellType() ){
					video = formatoCeldaDoubleToString( listPacoDet.get(22).getNumericCellValue() );
					pacoD.setVideo(video);
				} else {
					Sistema.mensaje("El formato de la columna VIDEO debe ser texto. ["+listPacoDet.get(22)+"]");
					e.printStackTrace();
				}
			}
			
			//formato
			try {
//				if (!validaCampoObligatorio(listPacoDet.get(23), "Formato"))
//					return null;
				formato = listPacoDet.get(23).getNumericCellValue();
				pacoD.setFormato(formato);
			} catch( Exception e) {
				try {
					formato = Double.parseDouble(listPacoDet.get(23).getStringCellValue());
					pacoD.setFormato(formato);
					
				} catch (Exception e2) {
					Sistema.mensaje("El valor de la columna Formato debe ser numérico. ["+listPacoDet.get(23)+"]");
					e.printStackTrace();
				}
			}
			//luthi
			//cerradora
			//pres
			try {
				latas = (int)listPacoDet.get(27).getNumericCellValue();
				pacoD.setLatas(latas);
			} catch( Exception e ) {
				Sistema.mensaje("El formato de la columna LATAS debe ser numérico. ["+listPacoDet.get(27)+"]");
				e.printStackTrace();
			}
			
			try {
				fill = listPacoDet.get(28).getNumericCellValue();
				pacoD.setFill(fill);
			} catch(Exception e) {
				Sistema.mensaje("El formato de la columna FILL debe ser numérico. ["+listPacoDet.get(28)+"]");
				e.printStackTrace();
			}
			
			try {
				lomolimpio = listPacoDet.get(29).getNumericCellValue();
				pacoD.setLomolimpio(lomolimpio);
			} catch(Exception e) {
				Sistema.mensaje("El formato de la columna lomolimpio debe ser numérico. ["+listPacoDet.get(29)+"]");
				e.printStackTrace();
			}
			
			try {
				crudo = listPacoDet.get(30).getNumericCellValue();
				pacoD.setCrudo(crudo);
			} catch(Exception e){
				Sistema.mensaje("El formato de la columna CRUDO debe ser numérico. ["+listPacoDet.get(30)+"]");
				e.printStackTrace();
			}
			
			try {
				ren = listPacoDet.get(31).getNumericCellValue();
				pacoD.setRen(ren);
			} catch(Exception e){
				Sistema.mensaje("El formato de la columna REN debe ser numérico. ["+listPacoDet.get(31)+"]");
				e.printStackTrace();
			}
			
			try{
				flake = listPacoDet.get(32).getNumericCellValue();
				pacoD.setFlake(flake);
			} catch(Exception e){
				Sistema.mensaje("El formato de la columna FLAKE debe ser numérico. ["+listPacoDet.get(32)+"]");
				e.printStackTrace();
			}
			
			try{
				ralladoempacado = listPacoDet.get(33).getNumericCellValue();
				pacoD.setRalladoempacado(ralladoempacado);
			} catch(Exception e) {
				Sistema.mensaje("El formato de la columna FLAKE debe ser numérico. ["+listPacoDet.get(33)+"]");
				e.printStackTrace();
			}
			
			//vacio
			//sin nombre
			try {
				observacion = listPacoDet.get(36).getStringCellValue();
				pacoD.setObservacion(observacion);
			} catch (Exception e) {
				Sistema.mensaje("El formato de la columna OBSERVACION debe ser numérico. ["+listPacoDet.get(36)+"]");
				e.printStackTrace();
			}
			
			try {
				sReproceso = listPacoDet.get(37).getStringCellValue();
				if (sReproceso.equalsIgnoreCase("X"))
					reproceso = true;
				pacoD.setReproceso(reproceso);
			} catch (Exception e) {
				Sistema.mensaje("El valor de la columna REPROCESO debe ser X o vacio ["+listPacoDet.get(37)+"]");
				e.printStackTrace();
			}
			
		return pacoD;
	}
	
	private static boolean validaCampoObligatorio(Cell celda, String etiqueta) {
		if (celda != null){
			if (Cell.CELL_TYPE_BLANK == celda.getCellType()) {
				Sistema.mensaje("La informacion de la columna "+etiqueta+" es obligatoria.");
				return false;
			}else{
				return true;
			}
		} else {
			Sistema.mensaje("La informacion de la columna "+etiqueta+" es obligatoria.");
			return false;
		}
	}
	
	/**
	 * Valida que las filas de la hoja de calculos no se encuentre duplicada
	 * @param paco
	 * @return
	 */
	public static boolean validaInformacionUnica(ProduccionArchivoCargaOrden paco) {
		HashMap<String, Object> auxUnico = new HashMap<String, Object>();
		for (ProduccionArchivoCargaOrdenDetalle pacod: paco.getProduccionArchivoCargaOrdenDetalles()) {
			String idturno = pacod.getTurno().getIdturno().toString();
			String item = pacod.getItem().toString();
			String orden = pacod.getOrden();
			String idProduccion = paco.getProduccion().getIdproduccion().toString();
			String key = idturno.concat(item).concat(orden).concat(idProduccion);
			
			ProduccionDAOJpaImpl produccionDao = new ProduccionDAOJpaImpl();
			Date fechaproduccion = produccionDao.getProduccionById(paco.getProduccion().getIdproduccion()).getFechaproduccion();
			
			String fechaFormat = new SimpleDateFormat("dd/MM/yyyy").format(fechaproduccion);
			//validad que la informacion no se encuentre duplicada por produccion, turno, item y orden dentro de la hoja de calculos
			if (!auxUnico.isEmpty())
				if (auxUnico.containsKey(key)) {
					Sistema.mensaje("Se encontro un registro duplicado en las filas del archivo Excel:" +
							"..Produccion: "+fechaFormat+
							"..Turno: " +idturno+
							"..item: "+item+
							"..Orden: "+orden);
					return true;
				}
					
			auxUnico.put(key, null);
			
		}
		return false;
	}
	
	private static Object extraeTipoDato(Cell cell){
		try {
			if ( Cell.CELL_TYPE_FORMULA == cell.getCellType() ) 
				return (Object)cell.getCellFormula();
			if ( Cell.CELL_TYPE_NUMERIC == cell.getCellType() ) 
				return (Object)cell.getNumericCellValue();
			if ( Cell.CELL_TYPE_STRING == cell.getCellType() ) 
				return (Object)cell.getStringCellValue();
			if ( Cell.CELL_TYPE_BOOLEAN == cell.getCellType() ) 
				return (Object)cell.getBooleanCellValue();
			return (Object)cell.getDateCellValue();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Long extraeProduccion (Timestamp fechaProduccion) {
		
		ProduccionDAOJpaImpl produccionDao = new ProduccionDAOJpaImpl();
		long idProduccion=0;
		try {
			Produccion lProduccion = produccionDao.getProduccionPorFecha(fechaProduccion);
			if (lProduccion==null) {
					Produccion prod = new Produccion();
						prod.setFechaproduccion(fechaProduccion);
						prod.setEstado(4);
						idProduccion = produccionDao.saveOrUpdate(prod).getIdproduccion();
			}else{
				idProduccion = lProduccion.getIdproduccion();
			}
				
			
			return idProduccion;
		} catch(Exception e) {
			
		}
			
		return null;
	}
	
	private static String formatoCeldaDoubleToString(Double lValorCelda) {
		String lControl = Double.toString(lValorCelda);
		if (lControl.contains("E")) {
			DecimalFormat formatter = new DecimalFormat("#");
			formatter.setMaximumFractionDigits(0);
			lControl = formatter.format(lValorCelda).replaceAll("\\.", "");
		}
		if (lControl.indexOf(".")>0)
			if (lControl.subSequence(lControl.indexOf("."), lControl.length()).equals(".0"))
				lControl = lControl.substring(0, lControl.indexOf("."));
		return lControl;
	}

}
