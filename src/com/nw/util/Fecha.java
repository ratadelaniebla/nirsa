package com.nw.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import org.joda.time.*;

/**
 * Clase para manipular fechas
 * @author haroldnav
 */
public class Fecha {

	Calendar cal;
	
	public Fecha(){
		cal = new GregorianCalendar();
	}

	public Fecha(Date fecha){
		cal  = new GregorianCalendar();
		cal.setTime(fecha);		
	}

	public Fecha(String miFecha){
		int ano = Integer.parseInt(miFecha.substring(0, 4));
		int mes = Integer.parseInt(miFecha.substring(5, 7));
		int dia = Integer.parseInt(miFecha.substring(8, 10));
		cal = new GregorianCalendar(ano, mes-1, dia);
	}
	
	/*
	 *  Devuelve la representacion String de una fecha "Date" pero sin las horas ni minutos.
	 */
	public Date toDate(){
		return cal.getTime();
	}
	
	/**
	 *  Devuelve la fecha "Date" en formato String yyyy-mm-dd
	 */
	public String toCadena(){
		
	    int ano = getAno();
	    int mes = getMes(); // enero comienza desde cero.
	    int dia = getDia();
	    
	    String smes = Integer.toString(mes);
	    String sdia = Integer.toString(dia);
	    
	    // Si el mes o el dia es de un digito, anteponer el 0 para concatenarlo.
		String str = 	ano+ "/" + 
						(smes.length()==1 ? "0"+smes: smes) + "/" +
						(sdia.length()==1 ? "0"+sdia: sdia); 
		return str;
	}
	
	/**
	 * Devuelve un objeto Date pero agregado con la hora actual del sistema
	 * @return fechaActual (Date, Fecha actual del sistema)
	 */
	public java.util.Date getDateFull(){
		java.sql.Time loTimHora = new java.sql.Time(System.currentTimeMillis());
		Hora h = new Hora();
		h.setHora(loTimHora.toString());
		return new DateTime(getAno(),getMes(),getDia(),h.getHora(),h.getMinutos(),h.getSegundos(),0).toDate();
	}
	
	/**
	 * Devuelve un objeto Date pero agregado con la hora especificada por el usuario
	 */
	public Date getDateFull(String hora){
		Hora h = new Hora();
		h.setHora(hora);
		return new DateTime(getAno(),getMes(),getDia(),h.getHora(),h.getMinutos(),h.getSegundos(),0).toDate();
	}

	/**
	 * Devuelve la fecha correcta con las horas y minutos pasados.
	 * @param hor
	 * @param min
	 * @return
	 */
	public Date getDateFull(int hor, int min){
		DateTime miFecha = new DateTime(getAno(), getMes(), getDia(), hor, min, 0, 0);
		return miFecha.toDate();
	}

	/**
	 * Devuelve el String del Timestamp de la fecha y hora del constructor en formato <b>aaaa-mm-dd hh:mm:ss</b>
	 * @return String del Timestamp de la fecha y hora del constructor en formato <b>aaaa-mm-dd hh:mm:ss</b>
	 */
	public String strGetFecha(){
		return new Timestamp(cal.getTimeInMillis()).toString();
	}

	public String strGetFechaDateTime(){
		return new DateTime(cal.getTime()).toString();
	}
	
	
	//aaaa-mm-dd hh:mm:ss.SSS
	public Date getTimestampToDate(String str){
		int ano = Sistema.parseInt(str.substring(0, 4));
		int mes = Sistema.parseInt(str.substring(5, 7));
		int dia = Sistema.parseInt(str.substring(8, 10));
		int hor = Sistema.parseInt(str.substring(11, 13));
		int min = Sistema.parseInt(str.substring(14, 16));
		int seg = Sistema.parseInt(str.substring(17, 19));
		int mil = Sistema.parseInt(str.substring(20, 23));
		
		return new DateTime(ano, mes, dia, hor, min, seg, mil).toDate();
	}
	
	/*
	 * Devuelve el String hora (hh:mm:ss) de la fecha dada
	 */
	public String getStrHora(){
		return ((java.sql.Time)new java.sql.Time(cal.getTime().getTime())).toString();
	}
	
	/*
	 * Devuelve el ano de la fecha enviada al constructor 
	 */
	public int getAno(){
		return cal.get(Calendar.YEAR);
	}
	
	/*
	 * Devuelve el mes de la fecha enviada al constructor
	 */
	public int getMes(){
		return cal.get(Calendar.MONTH)+1;
	}

	/*
	 * Devuelve el dia de la fecha enviada al constructor
	 */
	public int getDia(){
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getHora(){
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinutos(){
		return cal.get(Calendar.MINUTE);
	}
	
	/**
	 * Calcula los dias transcurridos desde 1 enero hasta la fecha especificada 
	 * @author carper
	 * @param dteFecha (Date, Fecha especificada)
	 * @return dias (int, Dias transcurridos desde 1 enero hasta la fecha especificada 
	 */
	public int getDiasTranscurridos(Date dteFecha){
		Fecha f = new Fecha(dteFecha);
		
		DateTime start = new DateTime(f.getAno(), 1, 1, 0, 0, 0, 0);
		DateTime end = new DateTime(f.getAno(), f.getMes(), f.getDia(), 0, 0, 0, 0);
		
		Days days = Days.daysBetween(start, end);
		return  days.getDays()+1;
	}
	
	/**
	 * Calcula los minutos transcurridos entre dos fechas especificadas
	 * @param dteFechaInicial (Date, Fecha inicial)
	 * @param dteFechaFinal (Date, Fecha final)
	 * @return minutos (int, Numero de minutos transcurridos entre las dos fechas)
	 */
	public int getMinutosTranscurridos(Date dteFechaInicial, Date dteFechaFinal){
		Fecha fIni = new Fecha(dteFechaInicial);
		Fecha fFin = new Fecha(dteFechaFinal);
		
		DateTime start = new DateTime(fIni.getAno(), fIni.getMes(), fIni.getDia(), fIni.getHora(), fIni.getMinutos(), 0, 0);
		DateTime end = new DateTime(fFin.getAno(), fFin.getMes(), fFin.getDia(), fFin.getHora(), fFin.getMinutos(), 0, 0);

		Minutes min = Minutes.minutesBetween(start, end);
		return min.getMinutes();
	}
	
	public Timestamp ConvertirFechaTimestamp(String FechaString){
		Timestamp FechaTimestamp = null;
		try{
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		FechaTimestamp = new Timestamp(sdf.parse(FechaString).getTime());
		}
		catch(ParseException pex){
			System.out.println("Error al tratar de convertir la fecha al tipo java.sql.Timestamp");
			System.err.println(pex.getMessage());
		}
		return FechaTimestamp;
		}
	
	public Timestamp ConvertirFechaTimestamp(String FechaString,String fmtfecha){
		Timestamp FechaTimestamp = null;
		try{
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		SimpleDateFormat sdf = new SimpleDateFormat(fmtfecha);
		FechaTimestamp = new Timestamp(sdf.parse(FechaString).getTime());
		}
		catch(ParseException pex){
			System.out.println("Error al tratar de convertir la fecha al tipo java.sql.Timestamp");
			System.err.println(pex.getMessage());
		}
		return FechaTimestamp;
		}
}