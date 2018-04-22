package com.nw.webui.produccion;

import java.util.*;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

import com.nw.model.Camara;
import com.nw.model.dao.impl.CamaraDAOJpaImpl;
//import com.nw.produccion.dao.*;
import com.nw.util.*;
import com.nw.webui.produccion.impresion.CalidadImpresion;

public class CamaraCajonUbicacionImpresionWindow extends GenericForwardComposer{	

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CamaraCajonUbicacionImpresionWindow.class);

	public AreaMarco area;
	protected Window winCajonCamaraUbicacionImpresion; 
	protected Vbox vbxMain;	
	private Datebox dteFecha1, dteFecha2;
	private Intbox intbxCamara, intbxFila;
	private Listbox lbxCamaras;
	private String f1, f2;
	Date fechaActual = new Date();
	Camara camara;
 
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		dteFecha1.setValue(fechaActual);
		cargarListaCamaras();
	} 
	
	public CamaraCajonUbicacionImpresionWindow() {
		//super();
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	public void cargarListaCamaras(){
		lbxCamaras.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Camara());
		li.setParent(lbxCamaras);
		
		List<Camara> camaras = new CamaraDAOJpaImpl().getCamaras();
		for (Camara camara : camaras) {
			 li = new Listitem();
			 li.setValue(camara);
			 new Listcell("Camara->"+camara.getDescripcion()).setParent(li);
			 li.setParent(lbxCamaras);
		}
		lbxCamaras.setSelectedIndex(0);
		
	}
	
	
	public void onSelect$lbxCamaras(){
		
		if (lbxCamaras.getSelectedIndex()>0) {
			camara = new Camara();
			camara = (Camara) lbxCamaras.getSelectedItem().getValue();
			System.out.println("valor descripcion de la camara escogida es-->"+camara.getDescripcion());
			//debo de cargar las filas y columnas correspondientes a la camara
		}else{
			camara = null; //se vacia el objeto para q pueda validar de nuevo q debe escoger una camara
		}
	}
	
//	public void onCreate$winCalidadImpresionHistorialBarcosDescargados(Event event) throws Exception {
//
//		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
//		winCajonCamaraUbicacionImpresion.setWidth(area.ancho);
//		vbxMain.setWidth(area.anchoInterno);
//
//		dteFecha1.setValue(new Date());
//		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);			
//
//		dteFecha2.setValue(new Date());
//		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);			
//		
//	}


	/**
	 * Carga los barcos de descarga mediante JPA en el listbox respectivo
	 */	
	
	private void cambiarFormatoFecha(){		
		//Cambiamos a la fecha de fecha como esta configurada la base de datos
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_GUI);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_GUI);
		
		//'09-08-2013 00:00:00.000'
		f1 = dteFecha1.getAreaText().trim() + " 00:00:00.000";
		
		//'20-08-2013 23:59:59.000'
		f2 = dteFecha2.getAreaText().trim() + " 23:59:59.999";
	}
	
	private void RetornarFormatoFecha(){		
		//List <Barco> barco = new BarcoDescargaDAOJpaImpl().getBarcosDescargadosByEntreFechas(f1, f2);

		//Regresamos de la fecha como esta configurada la base de datos 
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);
	}	
	
	
	//Impresiones	
	public void onClick$btnCajonCamaraUbicacion(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
//		int fila = 1;
//		int idcamara = 1;
		
		if (camara==null) {
			Sistema.mensaje("Debe ingresar un numero de camara");
			return;
		}

		int idcamara = Integer.valueOf(String.valueOf( camara.getIdcamara()));
		
		//Ejecutamos el reporte CajonesCamaraUbicacion
		new CalidadImpresion().doImprimirCajonUbicacionCamara("CamaraCajonUbicacion.jasper", "logo_nirsa.gif", idcamara);
	}
	
	public void onClick$btnMovimientoCajones() throws SuspendNotAllowedException, JRException, InterruptedException{
		if (intbxCamara.getValue()==null) {
			Sistema.mensaje("Debe ingresar un numero de camara");
			return;
		}
		if (intbxFila.getValue()==null) {
			Sistema.mensaje("Debe ingresar un numero de fila");
			return;
		}
		int idcamara = intbxCamara.getValue();
		int fila = intbxFila.getValue();
		//Ejecutamos el reporte CajonesCamaraUbicacion
		//new CalidadImpresion().doImprimirMovimientosInventarioCamaraAtun("Movimiento_de_Invetario.jasper", "logo_nirsa.gif", fila, idcamara,dteFecha1.getValue(), dteFecha2.getValue());
		new CalidadImpresion().doImprimirMovimientosInventarioCamaraAtun("Movimiento_de_Invetario.jasper", "logo_nirsa.gif", idcamara,dteFecha1.getValue(), dteFecha2.getValue());
	}

	
}