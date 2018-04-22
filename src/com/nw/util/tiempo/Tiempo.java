package com.nw.util.tiempo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.util.HoraCadena;
import com.nw.util.Sistema;
 
 

/**
 *  Copyright 2017 Nirsa. All rights reserved.
 *
 *  @author crholguin on 07/09/2017.
 *  Checkin Date   : 	 16/10/2017.
 *
 *  
 *  @Objetivo      : Manejo de fechas , conversiones , llenado de listbox con fechas(anio , mes , dia , hora, min)
 *             
 *                
 *
 */
public class Tiempo {
	
	public Tiempo() {
	}

	public static int diasDelMes(int mes, int anio)
	{
		switch(mes)
		{
			case 1:  // Enero
			case 3:  // Marzo
			case 5:  // Mayo
			case 7:  // Julio
			case 8:  // Agosto
			case 10:  // Octubre
			case 12: // Diciembre
			return 31;
			
			case 4:  // Abril
			case 6:  // Junio
			case 9:  // Septiembre
			case 11: // Noviembre
			return 30;
			
			case 2:  // Febrero
			if ( ((anio%100 == 0) && (anio%400 == 0)) || ((anio%100 != 0) && (anio%  4 == 0))  )
			return 29;  // Año Bisiesto
			else
			return 28;
		}
		return 0;
	}	
	
	
	public Listbox cargarDias(Listbox lbxDia, int dias)
	{
		lbxDia.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxDia);
		int i;
		for (i=1; i<=dias; i++)
		{
			Listitem li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxDia);
		}
		Sistema.setPosicionPrimerItem(lbxDia);
		return lbxDia;
	}	
	
	
	@SuppressWarnings("deprecation")
	public Listbox cargarMinutos(Listbox lbxMes, int tipo)
	{
		lbxMes.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxMes);
		int i;
		for (i=0; i<=59; i++)
		{
			Listitem li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxMes);
		}
		
		if (tipo == 1){
			//Sistema.setPosicionPrimerItem(lbxMi);
			lbxMes.setSelectedIndex(new Timestamp(new Date().getTime()).getMinutes()+1);
		}
		else {
			//Selecionar po base
		}
		return lbxMes;
	}
	
	
	@SuppressWarnings("deprecation")
	public Listbox cargarHoras(Listbox lbxHora, int tipo)
	{
		lbxHora.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxHora);
		int i;
		for (i=0; i<=23; i++)
		{
			Listitem li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxHora);
		}
		
		if (tipo == 1){
			//Sistema.setPosicionPrimerItem(lbxH);
			lbxHora.setSelectedIndex(new Timestamp(new Date().getTime()).getHours()+1);			
		}
		else {
			//Seleccionar por base
		}

	   return lbxHora;
	}	
	
	
	public Timestamp ArmarCadena(int LbxtM, int lbxD, int lbxH, int lbxMi, int anoi)
	{
		//int anoi = anoactual;
		
		//int mesi = LbxtM.getSelectedItem().getIndex();
		int mesi = LbxtM;
		
		//int diai  = lbxD.getSelectedItem().getIndex();
		int diai  = lbxD;
		
		//int horai = lbxH.getSelectedItem().getIndex()-1;
		int horai = lbxH-1;
		
		//int mini  = lbxMi.getSelectedItem().getIndex()-1;
		int mini  = lbxMi-1;
				
		String cmesi;
		if (String.valueOf(mesi).length() ==  1){
			cmesi = "0"+String.valueOf(mesi);
		}
		else {
			cmesi = String.valueOf(mesi);
		}

		String cdiai;
		if (String.valueOf(diai).length() ==  1) {
			cdiai = "0"+String.valueOf(diai);
		}
		else{
			cdiai = String.valueOf(diai);
		}

		
		String chorai;
		if (String.valueOf(horai).length() ==  1){
			chorai = "0"+String.valueOf(horai);
		}
		else{
			chorai = String.valueOf(horai);
		}

		String cmini;
		if (String.valueOf(mini).length() ==  1){
			cmini = "0"+String.valueOf(mini);
		}
		else {
			cmini = String.valueOf(mini);
		}
		
		String f;
		//f = String.valueOf(anoi)+"-"+String.valueOf(cmesi)+"-"+cdiai+" "+chorai+":"+cmini+":00.00";
		f = anoi+"-"+String.valueOf(cmesi)+"-"+cdiai+" "+chorai+":"+cmini+":00.00";
		
		Timestamp fecha = Timestamp.valueOf(f);
		
	   return fecha;
	}	
	
	
	
	
	
	
	/**
	 *  
	 * Devuelve el total de minutos transcurridos entre fechas y el anio
	 * actual que se recibe como tipo Date 
	 * @param anioActual
	 * @param mesInicial
	 * @param diaInicial
	 * @param horaInicial
	 * @param minutoInicial
	 * @param mesFinal
	 * @param diaFinal
	 * @param horaFinal
	 * @param minutoFinal
	 * @return
	 */
	public HoraCadena getMinutosEntreFechaHora( Date anioActual    ,
										 int  mesInicial    ,
									     int  diaInicial    , 
									     int  horaInicial   ,
									     int  minutoInicial ,
									    
									     int  mesFinal      ,
									     int  diaFinal      ,
									     int  horaFinal     ,
									     int  minutoFinal     ){
		int minutosTotales = 0;
		HoraCadena horaCadena = new HoraCadena();
		try {
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(anioActual);
			int year = cal.get(java.util.Calendar.YEAR);
			
			DateTime start = new DateTime(year,
										  mesInicial,
										  diaInicial,
										  horaInicial,
										  minutoInicial, 0, 0);
			
			DateTime end   = new DateTime(year,
										  mesFinal,
										  diaFinal,
										  horaFinal,
										  minutoFinal, 0, 0);

			Minutes min = Minutes.minutesBetween(start, end);			
			
			
			minutosTotales = min.getMinutes() % 60;
			int hourTemp   = min.getMinutes() / 60;
			int minute     = min.getMinutes() % 60;
			int day        = hourTemp / 24;
			int hour       = hourTemp % 24;

			String cadena       =  String.format("%s dias : %s horas : %s min. ", day, hour, minute);
			String horaMinTexto =  String.format(" %s : %s  ", hour, minute);
			System.out.println("minutos sin desgloze ->   " + min.getMinutes());
			System.out.println("cadena completa      ->   " + cadena);
			System.out.println("minutosTotales       ->   " + minutosTotales);
			
			horaCadena.setHoraTexto(cadena);
			horaCadena.setHora(hourTemp);
			horaCadena.setMin( min.getMinutes());
			horaCadena.setHoraMinutoTexto(horaMinTexto);
			return  horaCadena;  
			
		} catch (Exception e) {
			 e.printStackTrace();
			 return  null; //0;
		}
		 
	}
	
	/**
	 * Transforma una cantidad de minutos y los devuelve en una cadena de texto 
	 * expresada en dias:horas:minutos   
	 * @param minutos
	 * @return
	 */
	public String getCadenaHoraMinuto(int minutos){
		int hourTemp   = minutos  / 60;
		int minute     = minutos  % 60;
		int day        = hourTemp / 24;
		int hour       = hourTemp % 24;

		String cadena       =  String.format("%s dias : %s horas : %s minutos ", day, hour, minute);
		String horaMinTexto =  String.format(" %s : %s  ", hour, minute);
		System.out.println("cadena completa      ->   " + cadena);
		System.out.println("horaMinTexto         ->   " + horaMinTexto);
		
		return cadena;
	}
	
	
	
	/* Manejo de fechas basado en lo del proveedor pero con los ajustes correspondientes  */
	
	public static class DateStruct {

		public int year;
		public String month;
		public String day;
		public String hour;
		public String minute;

		public static DateStruct newInstance(int anio, String mes, String dia,
				String hora, String min) {
			DateStruct struct = new DateStruct();
			struct.year = anio;
			struct.month = mes;
			struct.day = dia;
			struct.hour = hora;
			struct.minute = min;
			return struct;
		}

		/* se cabio este metodo xq este pana le suma una dia adicional al dia escogido
		 *  y los registros no se guardan correctamente */
		public Timestamp toTimestamp() {
			int dayInt = Integer.valueOf(day) ; // + 1;
			String fechaString = year + "-" + month + "-" + dayInt + " " + hour + ":" + minute + ":00";
			return Timestamp.valueOf(fechaString);
		}

		public boolean hasValue() {
			return (month != null && !month.isEmpty()) 
					& (day != null && !day.isEmpty()) 
					& (hour != null && !hour.isEmpty()) 
					& (minute != null && !minute.isEmpty());
		}

	 
		public Timestamp toTimestampZero() {
			int dayInt = Integer.valueOf(day); 
			String fechaString = year + "-" + month + "-" + dayInt + " " + "00:00:00";
			return Timestamp.valueOf(fechaString);
		}

	}
	
	public int getAnioDate(Date fecha){
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(fecha);
		int anio 			= calendar.get(java.util.Calendar.YEAR);
		return anio;
	}
	
	public int getAnioTimestamp(Timestamp fecha){
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(fecha);
		int anio 			= calendar.get(java.util.Calendar.YEAR);
		return anio;
	}
	
	
	public static void cargarDiasAlSeleccionarMes(Listbox listBoxDias, DateStruct fecha ) {
			 
			ArrayList<String> days = new ArrayList<String>();
			listBoxDias.getItems().clear();
			int daysMonth = diasDelMes(Integer.parseInt(fecha.month), fecha.year);
			days.add(""); 
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			listBoxDias.setModel(lml);
			
			/* setiar el dia actual en el listbox dia  */
			java.util.Calendar calActual = java.util.Calendar.getInstance();
			calActual.setTime(new Date());
			int dayValue 			= calActual.get(java.util.Calendar.DAY_OF_MONTH);
			listBoxDias.setSelectedIndex(dayValue);
	}
	
	
	public  DateStruct getAnioMesDiaActual(Date    fechaProduccion,
											     Date    fechaActual, 
											     Listbox mes,
											     Listbox dia, 
											     Listbox hora, 
											     Listbox min) {
		
		java.util.Calendar calActual = java.util.Calendar.getInstance();
		calActual.setTime(fechaActual);
		
		/* si la fecha fechaProduccion es null entonces se trabaja el anio 
		 *  solo con la fecha actual del sistema */
		int year = 0;
		if (fechaProduccion == null) {
			year = calActual.get(java.util.Calendar.YEAR);
		}else{
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(fechaProduccion);
			year = cal.get(java.util.Calendar.YEAR);
		}
		
		int monthIndex = calActual.get(java.util.Calendar.MONTH)  + 1 ;  
		mes.setSelectedIndex(monthIndex);
		
		int hourIndex = calActual.get(java.util.Calendar.HOUR_OF_DAY);
		hora.setSelectedIndex(hourIndex + 1);
		
		int minuteIndex = calActual.get(java.util.Calendar.MINUTE);
		min.setSelectedIndex(minuteIndex + 1); //probar con eso uno sumado
		
		int dayValue 			= calActual.get(java.util.Calendar.DAY_OF_MONTH);
		int dayIndex 			= dayValue ;  
		ArrayList<String> days  = new ArrayList<String>();
		
		int daysMonth = diasDelMes(monthIndex, year);//Util.
		//le agrego una linea en blanco para poder encerar despues el listbox
		days.add("");
		for (int i = 1; i <= daysMonth; i++) {
			days.add(Integer.toString(i));
		}
		/* llenar los dias en el listbox */
		ListModelList lml = new ListModelList(days);
		dia.setModel(lml);
		/* setear el dia actual */
		dia.setSelectedIndex(dayIndex);

		return DateStruct.newInstance( 
				year, 
				(String) mes.getSelectedItem().getValue(),  
				String.valueOf(dayValue), 
				(String) hora.getSelectedItem().getValue(),  
				(String) min.getSelectedItem().getValue());
	}
	
	
	public DateStruct getFechaFinal(   Date fechaActual  ,
									   Listbox mes,
									   Listbox dia, 
									   Listbox hora, 
									   Listbox min){
		
		java.util.Calendar calActual = java.util.Calendar.getInstance();
		calActual.setTime(fechaActual);
		 
		int year = calActual.get(java.util.Calendar.YEAR);
		
		return DateStruct.newInstance( 
				year, 
				(String) mes.getSelectedItem().getValue(),  
			     String.valueOf( dia.getSelectedItem().getValue() ), 
				(String) hora.getSelectedItem().getValue(),  
				(String) min.getSelectedItem().getValue());
		
	}
	
	public DateStruct getFechaInicial(   Date fechaActual  ){

	java.util.Calendar calActual = java.util.Calendar.getInstance();
	calActual.setTime(fechaActual);
	
	int year = calActual.get(java.util.Calendar.YEAR);
	int month = calActual.get(java.util.Calendar.MONTH)  + 1 ;
	int day = calActual.get(java.util.Calendar.DAY_OF_MONTH);
	int hour = calActual.get(java.util.Calendar.HOUR_OF_DAY);
	int minute = calActual.get(java.util.Calendar.MINUTE);
	 
	
	return DateStruct.newInstance( 
		 year, 
		 String.valueOf(  month ),  
		 String.valueOf( day  ), 
		 String.valueOf( hour),  
		 String.valueOf( minute ));
	
	}
	
	public   String formatearFecha(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
				.format(fechaTS);
		return fecha;
	}
	
	public   String formatearFechaTimeAHora(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("hh:mm:ss")
				.format(fechaTS);
		return fecha;
	}

	public   String formatearFechaYYYYMMDD(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("yyyy-MM-dd").format(fechaTS);
		return fecha;
	}

	public  String formatearFechaDDMMYYYY(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("dd/MM/YYYY").format(fechaTS);
		return fecha;
	}
	
	public  Timestamp toTimestamp(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int cal_year = cal.get(Calendar.YEAR);
		int cal_month = cal.get(Calendar.MONTH) + 1;
		int cal_day = cal.get(Calendar.DAY_OF_MONTH);
		int cal_hour = cal.get(Calendar.HOUR_OF_DAY);
		int cal_minute = cal.get(Calendar.MINUTE);
		String fechaString = cal_year + "-" + cal_month + "-" + cal_day + " "
				+ cal_hour + ":" + cal_minute + ":00";
		return Timestamp.valueOf(fechaString);
	}
	
	public  Timestamp toTimestampTS(Timestamp date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int cal_year = cal.get(Calendar.YEAR);
		int cal_month = cal.get(Calendar.MONTH) + 1;
		int cal_day = cal.get(Calendar.DAY_OF_MONTH);
		int cal_hour = cal.get(Calendar.HOUR_OF_DAY);
		int cal_minute = cal.get(Calendar.MINUTE);
		String fechaString = cal_year + "-" + cal_month + "-" + cal_day + " "
				+ cal_hour + ":" + cal_minute + ":00";
		return Timestamp.valueOf(fechaString);
	}
	
	public   boolean timestampBefore(DateStruct fechai, DateStruct fechaf) {
		Timestamp ts1 = fechai.toTimestamp();
		Timestamp ts2 = fechaf.toTimestamp();

		return ts1.before(ts2);
	}
	
	public   boolean timestampAfter(DateStruct fechai, DateStruct fechaf) {
		Timestamp ts1 = fechai.toTimestamp();
		Timestamp ts2 = fechaf.toTimestamp();

		return ts1.after(ts2);
	}

	public   boolean timestampEquals(DateStruct fechai, DateStruct fechaf) {
		Timestamp ts1 = fechai.toTimestamp();
		Timestamp ts2 = fechaf.toTimestamp();

		return ts1.equals(ts2);
	}
	
	/*   ====================================================================================   */
	/*     									  VALIDACIONES    							        */
	/*   ====================================================================================   */
	
	public static boolean validarObjetoFecha(DateStruct fecha){
		if (fecha==null) {
			return true;
		}
		if (fecha.month ==null) {
			return true;
		}
		
		if (fecha.day ==null) {
			return true;
		}
		
		if (fecha.hour ==null) {
			return true;
		}
		
		if (fecha.minute ==null) {
			return true;
		}
		
		return false;
	}
	
	public static boolean validarPropiedadObjetoFecha(DateStruct fecha){
		 
		if (fecha.month == null || fecha.day == null || fecha.hour == null  ) {
			return true;
		}
		 
		return false;
	 }	
	
	
	public static boolean validarListboxFecha( Listbox lbxMes, Listbox lbxDia,
										Listbox lbxHora, Listbox lbxMinuto) {
		
		if (lbxMes.getSelectedIndex() == 0) {
			return true;
		}
		
		if (lbxDia.getSelectedIndex() == 0) {
			return true;
		}
		
		if (lbxHora.getSelectedIndex() == 0) {
			return true;
		}
		
		if ( lbxMinuto.getSelectedIndex() == 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * valida que si solo se escoje un item y los demas no son seleccionados
	 * retorna un true indicando q no esta correca la seleccion
	 * @param lbxMes
	 * @param lbxDia
	 * @param lbxHora
	 * @param lbxMinuto
	 * @return
	 */
	public static boolean validarListboxFechaFin( Listbox lbxMes,  Listbox lbxDia,
												  Listbox lbxHora, Listbox lbxMinuto) {

		/* 1 ) si se escoje solo el mes y los demas estan sin seleccionar  */
		if (lbxMes.getSelectedIndex()     	   > 0   && 
			lbxDia.getSelectedIndex()    	 == 0   && 
			lbxHora.getSelectedIndex()   	== 0   && 
			lbxMinuto.getSelectedIndex()   == 0  ) {
			return true;
		}
		
		/* 2 ) si se escoje solo el dia y los demas estan sin seleccionar  */
		if (lbxDia.getSelectedIndex()     	   > 0   && 
			lbxMes.getSelectedIndex()    	 == 0   && 
			lbxHora.getSelectedIndex()   	== 0   && 
			lbxMinuto.getSelectedIndex()   == 0  ) {
			return true;
		}
		
		/* 3 ) si se escoje solo la hora  y los demas estan sin seleccionar  */
		if (lbxHora.getSelectedIndex()     		> 0   && 
			lbxMes.getSelectedIndex()   	 == 0   && 
			lbxDia.getSelectedIndex()   	== 0   && 
			lbxMinuto.getSelectedIndex()   == 0  ) {
			return true;
		}
		
		/* 4 ) si se escoje solo el minuto  y los demas estan sin seleccionar  */
		if (lbxMinuto.getSelectedIndex()     	> 0   && 
			lbxMes.getSelectedIndex()   	 == 0   && 
			lbxDia.getSelectedIndex()   	== 0   && 
			lbxHora.getSelectedIndex()    == 0  ) {
			return true;
		}
		
		
	   return false;
	}
	
	
	public static boolean validarListboxFechaFinItemMayorIndexCero( Listbox lbxMes,  Listbox lbxDia,
			  Listbox lbxHora, Listbox lbxMinuto) {

		/* si se escoje cualquiera de los listbox de fecha fin   */
		if (lbxMes.getSelectedIndex()     > 0   || 
		lbxDia.getSelectedIndex()    	 > 0   || 
		lbxHora.getSelectedIndex()   	> 0   || 
		lbxMinuto.getSelectedIndex()   > 0  ) {
			return true ;
		}
		
		return false;
	 }

	
	public static boolean validarListboxFechaFinValida( Listbox lbxMes,  Listbox lbxDia,
			  Listbox lbxHora, Listbox lbxMinuto) {
	
		/* si se escoje una fecha valida es decir todos los listbox son mayores a indice cero  */
		if (lbxMes.getSelectedIndex()     	   > 0   && 
			lbxDia.getSelectedIndex()    	 > 0   && 
			lbxHora.getSelectedIndex()   	> 0   && 
			lbxMinuto.getSelectedIndex()   > 0  ) {
			return true;
		}

	  return false;
		
	}
	
	
	
	
	
	
}
