package com.nwl.mapeo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.Seconds;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.CantidadLibra;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.EnvasadoProceso;
import com.nw.model.LimpiezaDetalleProcesoLote;
import com.nw.model.LimpiezaLinea;
import com.nw.model.LimpiezaProcesoLoteActivo;
import com.nw.model.LonjasLinea;
import com.nw.model.LonjasProceso;
import com.nw.model.Luthy;
import com.nw.model.LuthyMaquinaCerradoraEstandar;
import com.nw.model.MaquinaCerradora;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.OeeDetalleMediosConDefectoEnvasado;
import com.nw.model.OeeDetalleParada;
import com.nw.model.OeeParada;
import com.nw.model.Proceso;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Turno;
import com.nw.util.Sistema;

public class Util {

	final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String NEW_TEXT = "Nuevo";

	public static int diasDelMes(int mes, int year) {

		switch (mes) {
		case 1: // Enero
		case 3: // Marzo
		case 5: // Mayo
		case 7: // Julio
		case 8: // Agosto
		case 10: // Octubre
		case 12: // Diciembre
			return 31;
		case 4: // Abril
		case 6: // Junio
		case 9: // Septiembre
		case 11: // Noviembre
			return 30;
		case 2: // Febrero
			if (((year % 100 == 0) && (year % 400 == 0))
					|| ((year % 100 != 0) && (year % 4 == 0)))
				return 29; // A�o Bisiesto
			else
				return 28;
		default:
			throw new java.lang.IllegalArgumentException(
					"El mes debe estar entre 0 y 11");
		}
	}

	public static boolean validarDecimalBox(Decimalbox decimalBox,
			String mensaje) {
		try {
			if (decimalBox.getValue() == null
					|| decimalBox.getValue().compareTo(BigDecimal.ZERO) <= 0) {
				Sistema.mensaje(mensaje);
				decimalBox.setFocus(true);
				return false;
			}
		} catch (Exception e) {
			decimalBox.clearErrorMessage();
			Sistema.mensaje(mensaje);
			return false;
		}

		return true;
	}

	public static <T> void cargarLista(Class<T> clazz, List<T> list,
			Listbox listBox, String message, boolean showNewElement, String name) {//Class<T>
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		try {
			T e = clazz.newInstance();
			listitem.setValue(e);
			setDisplay(listitem, e, showNewElement, name);
		} catch (InstantiationException | IllegalAccessException e1) {//InstantiationException | IllegalAccessException e1
			listitem.setValue(null);//
			listitem.setTooltiptext(e1.getMessage());
		}
		listitem.setParent(listBox);
		if (list != null) {
			for (T e : list) {
				listitem = new Listitem();
				listitem.setValue(e);
				setDisplay(listitem, e, false, name);
				listitem.setParent(listBox);
			}
			listBox.setSelectedIndex(0);
		} else {
			if (message != null)
				Sistema.mensaje(message);
		}
	}

	private static <T> void setDisplay(Listitem listitem, T e,
			boolean showNewElement, String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		String display = "";
		switch (name) {
		case "EnvasadoProceso_Fechaproduccion":
			display = String.format("%s - %s", sdf.format(((EnvasadoProceso) e)
					.getProduccion().getFechaproduccion()),
					((EnvasadoProceso) e).getTurno().getIdturno());
			new Listcell(showNewElement ? "" : display).setParent(listitem);
			break;
		case "EnvasadoProceso_Fechareg":
			display = String.format("%s - %s #", sdf
					.format(((EnvasadoProceso) e).getFechareg()),
					((EnvasadoProceso) e).getTurno() == null ? ""
							: ((EnvasadoProceso) e).getTurno().getIdturno());
			new Listcell(showNewElement ? "" : display).setParent(listitem);
			break;
		case "OeeDetalleMediosConDefecto":
			OeeDetalleMediosConDefecto data = (OeeDetalleMediosConDefecto) e;
			if (data!=null) {
				display = String.format("%s  %s  %s", 
						data.getFechaRegistro() ,
						data.getCantidadDefectos(), 
						"lote->"); //data.getProduccionDetalleLote().getIdlote()
			}else{
				display = "";
			}
			new Listcell(showNewElement ? "Nuevo Defecto" : display)
					.setParent(listitem);
			break;
		case "OeeDetalleMediosConDefectoEnvasado":
			OeeDetalleMediosConDefectoEnvasado edmde = (OeeDetalleMediosConDefectoEnvasado) e;
			if (edmde.getOeeDetalleMediosConDefecto() == null){
				display = "";
			}else {
				display = String.format("%s-%s",
						edmde.getOeeDetalleMediosConDefecto()
								.getFechaHoraRegistro(), edmde
								.getOeeDetalleMediosConDefecto()
								.getOeeDefecto().getDescripcionDefecto());
			}
			new Listcell(showNewElement ? "Nuevo Defecto" : display)
					.setParent(listitem);
			break;
		case "OeeDetalleParada":
			OeeDetalleParada dp = (OeeDetalleParada) e;
			if (dp.getOeeParada() == null)
				display = "";
			else
				display = dp.getOeeParada().getDescripcionParada();
			new Listcell(showNewElement ? "Nueva Parada" : display)
					.setParent(listitem);
			break;
		case "OeeDefectos":
			OeeDefecto oed = (OeeDefecto) e;
			display = oed.getDescripcionDefecto();
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;
		case "Proceso":
			Proceso p = (Proceso) e;
			display = p.getDescripcionproceso();
			new Listcell(showNewElement ? "" : display).setParent(listitem);
			break;
		case "Parada":
			OeeParada oeep = (OeeParada) e;
			display = oeep.getDescripcionParada();
			new Listcell(showNewElement ? "Nuevo" : display)
					.setParent(listitem);
			break;
		case "TurnoBlanco":
			Turno turno = (Turno) e;
			display = turno.getNombre();
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;
		case "Turno":
			display = ((Turno) e).getNombre();
			new Listcell(display).setParent(listitem);
			break;
		case "LimpiezaLinea":
			LimpiezaLinea lili = (LimpiezaLinea) e;
			display = lili.getDescripcion();
			//new Listcell(showNewElement ? "Nuevo" : display).setParent(listitem);
			new Listcell(display).setParent(listitem);
			break;
		case "CantidadLibra":
			CantidadLibra cl = (CantidadLibra) e;
			display = cl.getDescripcion();
			new Listcell(showNewElement ? "Nuevo" : display)
					.setParent(listitem);
			break;
		case "MaquinaCerradora":
			MaquinaCerradora mc = (MaquinaCerradora) e;
			display = mc.getDescripcion();
			new Listcell(showNewElement ? "Nuevo" : display)
					.setParent(listitem);
			break;
		case "LuthyMaquina":
			LuthyMaquinaCerradoraEstandar lmce = (LuthyMaquinaCerradoraEstandar) e;
			if (lmce.getMaquinaCerradora() == null)
				display = "";
			else
				display = lmce.getMaquinaCerradora().getDescripcion();
			new Listcell(showNewElement ? "Nuevo" : display)
					.setParent(listitem);
			break;
		case "LonjasLinea":
			LonjasLinea ll = (LonjasLinea) e;
			display = ll.getDescripcion();
			new Listcell(showNewElement ? " " : display)
					.setParent(listitem);
			break;
		case "Luthy":
			Luthy luthy = (Luthy) e;
			display = String.valueOf(luthy.getNumeroluthy());
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;
		case "DescongeladoDetalleProceso":
			DescongeladoDetalleProceso ddp = (DescongeladoDetalleProceso) e;
			if (ddp.getProduccionDetalleLoteCajon() == null)
				display = "";
			else
				display = String.format("%s-%s", ddp
						.getProduccionDetalleLoteCajon().getCamaraCajon().getIdcamaracajon(),
						ddp.getProduccionDetalleLoteCajon().getProduccionDetalleLote()
								.getIdlote());
			new Listcell(showNewElement ? "Nuevo" : display)
					.setParent(listitem);
			break;
		case "ProduccionDetalleLote":
			ProduccionDetalleLote pdl = (ProduccionDetalleLote) e;
			
			if (pdl!=null) {
				if (pdl.getIdlote()!= null) {
					display = String.valueOf(pdl.getIdlote());
				}else{
					display = " ";
				}
			}
			//display = String.valueOf(pdl.getIdlote());
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;
		case "LimpiezaDetalleProcesoLote":
			LimpiezaDetalleProcesoLote ldl = (LimpiezaDetalleProcesoLote) e;
			
			if (ldl!=null) {
				if (ldl.getProduccionDetalleLote() != null){
					if (ldl.getProduccionDetalleLote().getIdlote()!= null) {
						display = String.valueOf(ldl.getProduccionDetalleLote().getIdlote());
					}else{
						display = " ";
					}
				}
				
			}
			//display = String.valueOf(pdl.getIdlote());
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;
			
		case "LimpiezaProcesoLoteActivo":
			LimpiezaProcesoLoteActivo ldla = (LimpiezaProcesoLoteActivo) e;
			
			if (ldla!=null) {
				if (ldla.getLimpiezaDetalleProcesoLote() != null) {
					if (ldla.getLimpiezaDetalleProcesoLote().getProduccionDetalleLote() != null){
						if (ldla.getLimpiezaDetalleProcesoLote().getProduccionDetalleLote().getIdlote()!= null) {
							display = String.valueOf(ldla.getLimpiezaDetalleProcesoLote().getProduccionDetalleLote().getIdlote());
						}else{
							display = " ";
						}
					}
				}
			}
			//display = String.valueOf(pdl.getIdlote());
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;		
		case "Produccion":
			Produccion pr = (Produccion) e;
			if (pr!=null) {
				if (pr.getFechaproduccion()!= null) {
					display = String.valueOf(sdf.format( pr.getFechaproduccion() ));
				}else{
					display = " ";
				}
			}else{
				display = " ";
			}
			
			new Listcell(showNewElement ? " " : display).setParent(listitem);
			break;	

		default:
			new Listcell(showNewElement ? "Nuevo" : "").setParent(listitem);
			break;
		}

	}
	
	
	public static <T> void cargarListbox(Object objeto, List<T> list,
			Listbox listBox, String message, boolean showNewElement){
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(objeto);
		setItemTextoFechaTurnoEnvasadoProceso(listitem, objeto, showNewElement);
		listitem.setParent(listBox);
		if (list != null) {
			for (Object obj : list) {
				listitem = new Listitem();
				listitem.setValue(obj);
				setItemTextoFechaTurnoEnvasadoProceso(listitem, obj, showNewElement);
				listitem.setParent(listBox);
			}
			listBox.setSelectedIndex(0);
		}  
	}
	
	
	private static  void setItemTextoFechaTurnoEnvasadoProceso(Listitem listitem, Object object,
			boolean showNewElement) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		String itemTexto = "";
		if (object != null) {
			itemTexto = String.format("%s - %s", sdf.format(((EnvasadoProceso) object)
					.getProcesoAperturaCierre().getFechaapertura()), "Turno"+" "+
					((EnvasadoProceso) object).getTurno().getIdturno());
			new Listcell(showNewElement ? "" : itemTexto).setParent(listitem);
		}
	}
	
	
	public static <T> void cargarListboxLonjasProceso(Object objeto, List<T> list,
			Listbox listBox, String message, boolean showNewElement){
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(objeto);
		setItemTextoFechaTurnoLonjasProceso(listitem, objeto, showNewElement);
		listitem.setParent(listBox);
		if (list != null) {
			for (Object obj : list) {
				listitem = new Listitem();
				listitem.setValue(obj);
				setItemTextoFechaTurnoLonjasProceso(listitem, obj, showNewElement);
				listitem.setParent(listBox);
			}
			listBox.setSelectedIndex(0);
		}  
	}
	
	private static  void setItemTextoFechaTurnoLonjasProceso(Listitem listitem, Object object,
			boolean showNewElement) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		String itemTexto = "";
		if (object != null) {
			itemTexto = String.format("%s - %s", sdf.format(((LonjasProceso) object)
					.getProduccion().getFechaproduccion()), "Turno"+" "+
					((LonjasProceso) object).getTurno().getIdturno());
			new Listcell(showNewElement ? "" : itemTexto).setParent(listitem);
		}
	}
	
	
	
	public static <T> void cargarListboxOeeMediosConDefecto(Object objeto, List<T> list,
			Listbox listBox, String message, boolean showNewElement){
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(objeto);
		setItemTextoOeeMediosConDefecto(listitem, objeto, showNewElement);
		listitem.setParent(listBox);
		if (list != null) {
			for (Object obj : list) {
				listitem = new Listitem();
				listitem.setValue(obj);
				setItemTextoOeeMediosConDefecto(listitem, obj, showNewElement);
				listitem.setParent(listBox);
			}
			listBox.setSelectedIndex(0);
		}  
	}
	
	private static  void setItemTextoOeeMediosConDefecto(Listitem listitem, Object object,
			boolean showNewElement) {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
		String itemTexto = "";
		if (object != null) {
			if (((OeeDetalleMediosConDefecto) object) .getProduccionDetalleLote() != null) {
				String hora = "";
				if (((OeeDetalleMediosConDefecto) object) .getFechaRegistro()!= null) {
					 hora = formatearFechaTimeAHora(((OeeDetalleMediosConDefecto) object) .getFechaHoraRegistro());//getFechaRegistro
				}else{
					hora = ".";
				}
				itemTexto = String.format("%s - %s", hora,  " "+
						((OeeDetalleMediosConDefecto) object).getCantidadDefectos() +
						   " " + ((OeeDetalleMediosConDefecto) object).getProduccionDetalleLote().getIdlote());
				//new Listcell(showNewElement ? "" : itemTexto).setParent(listitem);
				new Listcell(itemTexto).setParent(listitem);
			}
		}else{
			itemTexto = "Nuevo Defecto";
			//agregarItemNuevo(objeto, listBox, "Nuevo Defecto");
			//Listitem listitem = new Listitem();
			listitem.setValue(new OeeDetalleMediosConDefecto());
			new Listcell(itemTexto).setParent(listitem);
			
		}
	}
	
	public static <T> void agregarItemNuevo(Object objeto, Listbox listBox, String itemTexto){
		listBox.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(objeto);
		setItemTexto(listitem, objeto, itemTexto);
		listitem.setParent(listBox);
		listBox.setSelectedIndex(0);
	}
	
	
	private static void setItemTexto(Listitem listitem, Object object,String itemTexto) {
		if (object != null) {
			new Listcell(itemTexto).setParent(listitem);
		}
	}
	
	

	public static void alSeleccionarMes(Listbox listBox, DateStruct date,
			String message) {
		//if (listBox.getSelectedIndex() > 0) {
			//date.month = (String) listBox.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(date.month),
					date.year);
			days.add("");//este le agregue para cuando se ponga en nuevo el listbox
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			listBox.setModel(lml);
			
			/* setiar el dia actual en el listbox dia  */
			java.util.Calendar calActual = java.util.Calendar.getInstance();
			calActual.setTime(new Date());
			int dayValue 			= calActual.get(java.util.Calendar.DAY_OF_MONTH);
			listBox.setSelectedIndex(dayValue);
		/* } else {
			date.month = null;
			Sistema.mensaje(message);
		} */
	}
	
	public static void getSegundosListbox(Date fecha ,Listbox lbxSegundos){
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(fecha);
		int secondIndex = cal.get(java.util.Calendar.SECOND);
		ArrayList<String> days = new ArrayList<String>();
		days.add("");
		for (int i = 0; i <= 59; i++) {
			if (i==0) {
				days.add("00");
			}else{
				days.add(Integer.toString(i));
			}
		}
		ListModelList lml = new ListModelList(days);
		lbxSegundos.setModel(lml);
		lbxSegundos.setSelectedIndex(secondIndex);
	}

	public static DateStruct limpiarMesDiaHoraMin(Date fecha, Listbox mes,
			Listbox dia, Listbox hora, Listbox min) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(fecha);
		int year = cal.get(java.util.Calendar.YEAR);
		int monthIndex = cal.get(java.util.Calendar.MONTH) + 1 ; // rev+ 1;
		mes.setSelectedIndex(monthIndex);
		int hourIndex = cal.get(java.util.Calendar.HOUR_OF_DAY);
		hora.setSelectedIndex(hourIndex + 1);
		int minuteIndex = cal.get(java.util.Calendar.MINUTE);
		min.setSelectedIndex(minuteIndex + 1);// + 1 no se xq le suma 
		int dayValue = cal.get(java.util.Calendar.DAY_OF_MONTH);
		//TODO nose xq restaba un dia este man 
		int dayIndex = dayValue ; //- 1;
		ArrayList<String> days = new ArrayList<String>();
		int daysMonth = Util.diasDelMes(monthIndex, year);
		//le agrego una linea en blanco para poder encerar despues el listbox
		days.add("");
		for (int i = 1; i <= daysMonth; i++) {
			days.add(Integer.toString(i));
		}
		ListModelList lml = new ListModelList(days);
		dia.setModel(lml);
		dia.setSelectedIndex(dayIndex);

		return DateStruct.newInstance(//
				year,//
				(String) mes.getSelectedItem().getValue(), //
				String.valueOf(dayValue),//
				(String) hora.getSelectedItem().getValue(), //
				(String) min.getSelectedItem().getValue());
	}
	
	public static DateStruct limpiarMesDiaHoraMinSegundo(Date fecha , Listbox mes,
			Listbox dia, Listbox hora, Listbox min , Listbox lbxSegundo) {
		//Date fecha = new Date();
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(fecha);
		int year = cal.get(java.util.Calendar.YEAR);
		int monthIndex = cal.get(java.util.Calendar.MONTH) + 1 ; // rev+ 1;
		mes.setSelectedIndex(monthIndex);
		int hourIndex = cal.get(java.util.Calendar.HOUR_OF_DAY);
		hora.setSelectedIndex(hourIndex + 1);
		int minuteIndex = cal.get(java.util.Calendar.MINUTE);
		min.setSelectedIndex(minuteIndex + 1);// + 1 no se xq le suma 
		int dayValue = cal.get(java.util.Calendar.DAY_OF_MONTH);
		//TODO nose xq restaba un dia este man 
		int dayIndex = dayValue ; //- 1;
		ArrayList<String> days = new ArrayList<String>();
		int daysMonth = Util.diasDelMes(monthIndex, year);
		//le agrego una linea en blanco para poder encerar despues el listbox
		days.add("");
		for (int i = 1; i <= daysMonth; i++) {
			days.add(Integer.toString(i));
		}
		ListModelList lml = new ListModelList(days);
		dia.setModel(lml);
		dia.setSelectedIndex(dayIndex);
		
		//getSegundosListbox(lbxSegundo);
		int secondIndex = cal.get(java.util.Calendar.SECOND);
		ArrayList<String> seconds = new ArrayList<String>();
		seconds.add("");
		for (int i = 0; i <= 59; i++) {
		   seconds.add(Integer.toString(i));
		}
		ListModelList lmls = new ListModelList(seconds);
		lbxSegundo.setModel(lmls);
		lbxSegundo.setSelectedIndex(secondIndex + 1);
 
		return DateStruct.newInstance(//
				year,//
				(String) mes.getSelectedItem().getValue(), //
				 String.valueOf(dayValue),//
				(String) hora.getSelectedItem().getValue(), //
				(String) min.getSelectedItem().getValue(),
				String.valueOf(secondIndex)
				);
	}
	
	
	public static DateStruct getAnioProduccionMesDiaActual(Date fecha,Date fechaActual, Listbox mes,
			Listbox dia, Listbox hora, Listbox min) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(fecha);
		int year = cal.get(java.util.Calendar.YEAR);
		
		
		java.util.Calendar calActual = java.util.Calendar.getInstance();
		calActual.setTime(fechaActual);
		
		int monthIndex = calActual.get(java.util.Calendar.MONTH)  + 1 ; // revisar esto -> + 1;
		mes.setSelectedIndex(monthIndex);
		int hourIndex = calActual.get(java.util.Calendar.HOUR_OF_DAY);
		hora.setSelectedIndex(hourIndex + 1);
		int minuteIndex = calActual.get(java.util.Calendar.MINUTE);
		
		min.setSelectedIndex(minuteIndex + 1);// + 1  //TODO revisar esto cuando el min es 59
		int dayValue = calActual.get(java.util.Calendar.DAY_OF_MONTH);
		//TODO nose xq restaba un dia este man 
		int dayIndex = dayValue ; //- 1;
		ArrayList<String> days = new ArrayList<String>();
		int daysMonth = Util.diasDelMes(monthIndex, year);
		//le agrego una linea en blanco para poder encerar despues el listbox
		days.add("");
		for (int i = 1; i <= daysMonth; i++) {
			days.add(Integer.toString(i));
		}
		ListModelList lml = new ListModelList(days);
		dia.setModel(lml);
		dia.setSelectedIndex(dayIndex);

		return DateStruct.newInstance(//
				year,//
				(String) mes.getSelectedItem().getValue(), //
				String.valueOf(dayValue),//
				(String) hora.getSelectedItem().getValue(), //
				(String) min.getSelectedItem().getValue());
	}
	
	
	
	public static String fechaFormato(Timestamp fechaTimestamp ) {
		 String fecha = "";
		try {
			  fecha = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(fechaTimestamp);
		} catch (Exception e) {
			return fecha = e.getMessage();
		}
		
		return fecha;
	}
	

	public static DateStruct limpiarMesDiaHoraMin(Listbox mes, Listbox dia,
			Listbox hora, Listbox min) {
		return limpiarMesDiaHoraMin(new java.util.Date(), mes, dia, hora, min);
	}

	public static Listitem findItemByValue(Listbox listbox, Object needle) {
		if (listbox == null || needle == null) {
			return null;
		}
		for (Object each : listbox.getItems()) {
			Listitem item = (Listitem) each;
			Object value = item.getValue();
			if (needle.toString().equals(value.toString())) {
				return item;
			}
		}
		return null;
	}

	public static int findIndexItemByValue(Listbox listbox, Object needle) {
		int index = -1;
		if (listbox == null || needle == null) {
			index = -1;
		}
		for (Object each : listbox.getItems()) {
			Listitem item = (Listitem) each;
			Object value = item.getValue();
			if (needle.toString().equals(value.toString())) {
				index = item.getIndex();
			}
		}
		return index;
	}

	public static Timestamp toTimestamp(Date date) {
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
	
	public static Timestamp toTimestampWithSecond(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int cal_year = cal.get(Calendar.YEAR);
		int cal_month = cal.get(Calendar.MONTH) + 1;
		int cal_day = cal.get(Calendar.DAY_OF_MONTH);
		int cal_hour = cal.get(Calendar.HOUR_OF_DAY);
		int cal_minute = cal.get(Calendar.MINUTE);
		int cal_second = cal.get(Calendar.SECOND);
		String fechaString = cal_year + "-" + cal_month + "-" + cal_day + " "
				+ cal_hour + ":" + cal_minute + ":" + cal_second;
		return Timestamp.valueOf(fechaString);
	}

	public static Timestamp toTimestampZero(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		int cal_year = cal.get(Calendar.YEAR);
		int cal_month = cal.get(Calendar.MONTH) + 1;
		int cal_day = cal.get(Calendar.DAY_OF_MONTH);
		String fechaString = cal_year + "-" + cal_month + "-" + cal_day + " "
				+ "00:00:00";
		return Timestamp.valueOf(fechaString);
	}

	public static String getTotalTime(DateStruct fechaInicial,
			DateStruct fechaFinal) {

		DateTime start = new DateTime(fechaInicial.year,
				Integer.parseInt(fechaInicial.month),
				Integer.parseInt(fechaInicial.day),
				Integer.parseInt(fechaInicial.hour),
				Integer.parseInt(fechaInicial.minute), 0, 0);
		DateTime end = new DateTime(fechaFinal.year,
				Integer.parseInt(fechaFinal.month),
				Integer.parseInt(fechaFinal.day),
				Integer.parseInt(fechaFinal.hour),
				Integer.parseInt(fechaFinal.minute), 0, 0);

		Minutes min = Minutes.minutesBetween(start, end);
		int hourTemp = min.getMinutes() / 60;
		int minute = min.getMinutes() % 60;
		int day = hourTemp / 24;
		int hour = hourTemp % 24;

		return String.format("%s dias / %s horas / %s minutos ", day, hour,
				minute);
	}
	
	
	public static String getTotalTimeWithSecond(DateStruct fechaInicial,
			DateStruct fechaFinal) {

		DateTime start = new DateTime(fechaInicial.year,
				Integer.parseInt(fechaInicial.month),
				Integer.parseInt(fechaInicial.day),
				Integer.parseInt(fechaInicial.hour),
				Integer.parseInt(fechaInicial.minute), Integer.parseInt(fechaInicial.second), 0);
		DateTime end = new DateTime(fechaFinal.year,
				Integer.parseInt(fechaFinal.month),
				Integer.parseInt(fechaFinal.day),
				Integer.parseInt(fechaFinal.hour),
				Integer.parseInt(fechaFinal.minute), Integer.parseInt(fechaFinal.second), 0);
		
        Seconds second = Seconds.secondsBetween(start, end);
		Minutes min  = Minutes.minutesBetween(start, end);
		//int segundo = Math.abs( (Integer.parseInt(fechaFinal.second) - Integer.parseInt(fechaInicial.second)) ) ;//    min.getMinutes() % 3600;
		int segundo  = second.getSeconds() % 60;
		int hourTemp = min.getMinutes() / 60;
		int minute   = min.getMinutes() % 60;
		//int day    = hourTemp / 24;
		int hour     = hourTemp % 24;
        // %s dias/ 
		return String.format("%s horas/ %s min. / %s seg. ", hour,
				minute, segundo);
	}

	public static String formatearFecha(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
				.format(fechaTS);
		return fecha;
	}
	
	public static String formatearFechaTimeAHora(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("hh:mm:ss")
				.format(fechaTS);
		return fecha;
	}

	public static String formatearFechaYYYYMMDD(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("yyyy-MM-dd").format(fechaTS);
		return fecha;
	}

	public static String formatearFechaDDMMYYYY(Timestamp fechaTS) {
		String fecha = new SimpleDateFormat("dd/MM/YYYY").format(fechaTS);
		return fecha;
	}

	public static int validar24horas(DateStruct fechaInicial,
			DateStruct fechaFinal) {
		DateTime start = new DateTime(fechaInicial.year,
				Integer.parseInt(fechaInicial.month),
				Integer.parseInt(fechaInicial.day),
				Integer.parseInt(fechaInicial.hour),
				Integer.parseInt(fechaInicial.minute), 0, 0);
		DateTime end = new DateTime(fechaFinal.year,
				Integer.parseInt(fechaFinal.month),
				Integer.parseInt(fechaFinal.day),
				Integer.parseInt(fechaFinal.hour),
				Integer.parseInt(fechaFinal.minute), 0, 0);

		Minutes min = Minutes.minutesBetween(start, end);
		return min.getMinutes();
	}

	public static boolean timestampBefore(DateStruct fechai, DateStruct fechaf) {
		Timestamp ts1 = fechai.toTimestamp();
		Timestamp ts2 = fechaf.toTimestamp();

		return ts1.before(ts2);
	}

	public static boolean timestampEquals(DateStruct fechai, DateStruct fechaf) {
		Timestamp ts1 = fechai.toTimestamp();
		Timestamp ts2 = fechaf.toTimestamp();

		return ts1.equals(ts2);
	}

	/**
	 * @author Manuel
	 * 
	 */
	public static class DateStruct {

		public int year;
		public String month;
		public String day;
		public String hour;
		public String minute;
		public String second;

		public static DateStruct newInstance(int a, String m, String d,
				String h, String min) {
			DateStruct struct = new DateStruct();
			struct.year = a;
			struct.month = m;
			struct.day = d;
			struct.hour = h;
			struct.minute = min;
			return struct;
		}
		
		public static DateStruct newInstance(int a, String m, String d,
				String h, String min, String second) {
			DateStruct struct = new DateStruct();
			struct.year = a;
			struct.month = m;
			struct.day = d;
			struct.hour = h;
			struct.minute = min;
			struct.second = second;
			return struct;
		}

		/* se cabio este metodo xq este pana le suma una dia adicional al dia escogido
		 *  y los registros no se guardan correctamente */
		public Timestamp toTimestamp() {
			int dayInt = Integer.valueOf(day) ; // + 1;
			String fechaString = "";
			if (second != null) {
				fechaString = year + "-" + month + "-" + dayInt + " " + hour
						+ ":" + minute + ":"+second;
			}else{
				fechaString = year + "-" + month + "-" + dayInt + " " + hour
						+ ":" + minute + ":00";
			}
			
			/* String fechaString = year + "-" + month + "-" + dayInt + " " + hour
					+ ":" + minute + ":00"; */
			return Timestamp.valueOf(fechaString);
		}

		public boolean hasValue() {
			return (month != null && !month.isEmpty())//
					& (day != null && !day.isEmpty())//
					& (hour != null && !hour.isEmpty())//
					& (minute != null && !minute.isEmpty());
		}

		/* se cabio este metodo xq este pana le suma una dia adicional al dia escogido
		 *  y los registros no se guardan correctamente */
		public Timestamp toTimestampZero() {
			int dayInt = Integer.valueOf(day); // + 1;
			String fechaString = year + "-" + month + "-" + dayInt + " "
					+ "00:00:00";
			return Timestamp.valueOf(fechaString);
		}

	}
	
	
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
	
	public static boolean validarListboxFechaWithSecond( Listbox lbxMes, Listbox lbxDia,
			Listbox lbxHora, Listbox lbxMinuto, Listbox lbxSecond) {

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
		
		if ( lbxSecond.getSelectedIndex() == 0) {
			return true;
		}
		
		return false;
	}

}