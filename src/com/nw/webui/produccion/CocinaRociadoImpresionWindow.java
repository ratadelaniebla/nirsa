package com.nw.webui.produccion;

 
//import java.io.ByteArrayOutputStream;
//import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
import java.util.*;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;

import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.eclipse.persistence.internal.databaseaccess.Accessor;
//import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
//import org.eclipse.persistence.jpa.JpaEntityManager;
 
//import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

 
//import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.Turno;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
//import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.*;
import com.nw.webui.produccion.impresion.CalidadImpresion;
 

public class CocinaRociadoImpresionWindow extends GenericForwardComposer{	

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CocinaRociadoImpresionWindow.class);

	public AreaMarco area;
	protected Window winCocinaEntradaSalidaImpresion; 
	protected Vbox vbxMain;	
	private Datebox dteFecha1 ;
    private Listbox lbxTurno;
	Date fechaActual = new Date();
    
	Turno turno;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		dteFecha1.setValue(fechaActual);
		cargarListaTurno();
	} 
	
	public CocinaRociadoImpresionWindow() {
		//super();
		
		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	
	public void cargarListaTurno(){
		lbxTurno.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);
		//obtener los turnos existentes		
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		
		for (Turno bd : listaTurnos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);
	}
	
	
	public void onSelect$lbxTurno() throws InterruptedException{
		
		if (lbxTurno.getSelectedIndex()>0) {
			//vaciamos el objeto barcoDescarga creando una nueva instancia 
			turno = new Turno();
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
			//Messagebox.show("el valor seleccionado es-->"+ turno.getIdturno() +""+ turno.getNombre());
		}else{
			turno = null;
		}
	}
	
	
	//Impresiones	
	public void onClick$btnEntradaSalidaCocina() throws SuspendNotAllowedException, JRException, InterruptedException {
		if (turno == null) {
			Sistema.mensaje("Debe seleccionar un turno de la lista");
			return;
		}
		//Ejecutamos el reporte  
		new CalidadImpresion().doImprimirCocinaEntradaSalida("Reporte_Entrada_Salida_Cocina.jasper", "logo_nirsa.gif", turno.getIdturno(), dteFecha1.getValue()  );
	}
	
	
	
	public void onClick$btnMermaCocinaRociado() throws SuspendNotAllowedException, JRException, InterruptedException{
		 
		if (turno == null) {
			Sistema.mensaje("Debe seleccionar un turno de la lista");
			return;
		}
		//Ejecutamos el reporte  
		//new CalidadImpresion().doImprimirMermaCocinaRociado("CocinaRociadoMerma.jasper", "logo_nirsa.gif", turno.getIdturno(), dteFecha1.getValue());
	}
	
	
	public void onClick$btnExcelMermaCocinaRociado() throws SuspendNotAllowedException, JRException, InterruptedException, FileNotFoundException{
		 
		if (turno == null) {
			Sistema.mensaje("Debe seleccionar un turno de la lista");
			return;
		}
		//Ejecutamos el reporte  
		//new CalidadImpresion().doImprimirMermaCocinaRociado("CocinaRociadoMerma.jasper", "logo_nirsa.gif", turno.getIdturno(), dteFecha1.getValue());
     
	
	}
	
	
	

	
}