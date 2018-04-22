package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.util.*;

import net.sf.jasperreports.engine.JRException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

//import com.nw.produccion.dao.*;
import com.nw.util.*;
import com.nw.webui.produccion.impresion.CalidadImpresion;


public class CamaraImpresionHistorialBarcosDescargadosWindow extends GenericForwardComposer{	

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CamaraImpresionHistorialBarcosDescargadosWindow.class);

	public AreaMarco area;
	protected Window winCamaraImpresionHistorialBarcosDescargados; // autowired
	protected Vbox vbxMain;	
	private Datebox dteFecha1, dteFecha2;
	private String f1, f2;
/*	protected Toolbarbutton btnGrabar;*/

	
	public CamaraImpresionHistorialBarcosDescargadosWindow() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	public void onCreate$winCamaraImpresionHistorialBarcosDescargados(Event event) throws Exception {

		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		winCamaraImpresionHistorialBarcosDescargados.setWidth(area.ancho);
		vbxMain.setWidth(area.anchoInterno);
		//cargarBarcosDescarga();

		dteFecha1.setValue(new Date());
		dteFecha1.setFormat(Sistema.FORMATO_FECHA_DMY);			

		dteFecha2.setValue(new Date());
		dteFecha2.setFormat(Sistema.FORMATO_FECHA_DMY);			
		
	}


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
	public void onClick$btnCamaraHistorialBarcosDescargados(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
		cambiarFormatoFecha();
		
        Timestamp f1c = Timestamp.valueOf(f1);
        Timestamp f2c = Timestamp.valueOf(f2);
		
		//Ejecutamos el reporte
		new CalidadImpresion().doImprimirHistorialBarcosDescargas("CamaraHistorialBarcosDescargados.jasper","logo_nirsa.gif", f1c, f2c);
		
		RetornarFormatoFecha();
	}

	
}