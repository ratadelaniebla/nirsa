package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.CoccionProceso;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.EvisceradoProceso;
import com.nw.model.Parametro;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.RociadoProceso;
import com.nw.model.dao.impl.CoccionProcesoDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.RociadoProcesoDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class AperturaCierreProcesoEvisceradoWindow extends GenericForwardComposer {

	private Listbox lbxDiaProduccion,lbxAperturaCierre;
	private Checkbox chbRevisado ;
	private Toolbarbutton btnGrabar;
	
	private ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	private Produccion produccion = new Produccion();
	
	private ProcesoAperturaCierre procesoAperturaCierre;
	private ProcesoAperturaCierreDAOJpaImpl procesoAperturaCierreDAOImpl;
	private EvisceradoProceso evisceradoProceso;
	private EvisceradoProcesoDAOJpaImpl evisceradoProcesoDAOImpl;
	private CoccionProceso coccionProceso;
	private RociadoProceso rociadoProceso;
	private List<Produccion> producciones = new ArrayList<Produccion>();
	
	private List<EvisceradoDetalleProcesoCoche> lEvisceradoDetalleProcesoCoche = new ArrayList<EvisceradoDetalleProcesoCoche>(); 
	
	private List<ProcesoAperturaCierre> lProcesoAperturaCierre = new ArrayList<ProcesoAperturaCierre>();
	
	Double idprocesoAperturaCierre;
	Date fecha;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
	}
	
	
	public void cargarListaFecha()
	{
		try {
			
			lbxDiaProduccion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxDiaProduccion);
			
			
			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl().getListaFechaProduccionUnoCero(lbxAperturaCierre.getSelectedIndex());
			
			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				li.setTooltiptext(bd.getIdproduccion().toString());
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				li.setParent(lbxDiaProduccion);
				
				//produccion.setIdproduccion(bd.getIdproduccion());
			}
			lbxDiaProduccion.setSelectedIndex(0);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void onSelect$lbxFechaActiva() throws InterruptedException{
		
		if (lbxDiaProduccion.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxDiaProduccion.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			//Messagebox.show("el valor seleccionado es-->"+ turno.getIdturno() +""+ turno.getNombre());
			System.out.println("produccion id --> " + produccion.getIdproduccion());

			lbxAperturaCierre.focus();

		}else{
			produccion = null;
		}
	}
	

	
	public void onSelect$lbxDiaProduccion() 
	{
		//lbxAperturaCierre.setSelectedIndex(0);
		chbRevisado.setChecked(false);		
	}
	
	public void onSelect$lbxAperturaCierre() throws InterruptedException 
	{
		//lbxAperturaCierre.setSelectedIndex(0);
		chbRevisado.setChecked(false);
		lbxDiaProduccion.getItems().clear();

		if (lbxAperturaCierre.getSelectedIndex() > 0)
		{
			cargarListaFecha();
		}
		
//		try {
//			
//			procesoAperturaCierre = new ProcesoAperturaCierre();
//			procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl().getSeleccionProcesoAperturaCierre(produccion.getIdproduccion().toString());
//			
//			//if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) {
//			if (lbxAperturaCierre.getSelectedIndex() == 1) {
//				if (procesoAperturaCierre != null) {
//					Sistema.mensaje("Ya existe una APERTURA realizada");
//					lbxAperturaCierre.setSelectedIndex(0);
//					chbRevisado.setChecked(false);
//				}
//			}
//			
//			if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {
//
//				if (procesoAperturaCierre == null) {
//					lbxAperturaCierre.setSelectedIndex(0);
//					chbRevisado.setChecked(false);
//
//					Sistema.mensaje("Ningun dato encontrado para el proceso de CIERRE");
//				}
//				
//				//System.out.println("El idproceso con su estado " + procesoAperturaCierre.getIdprocesoaperturacierre() + " -- " + procesoAperturaCierre.getEstado());
//			}
//
//		} catch (Exception e) {
//			System.out.println("Mensaje de error " + e.getMessage());
//		}
		
		
	}
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	public void grabar()
	{	
		if (chbRevisado.isChecked() == true) {
			
			
//				if (procesoAperturaCierre != null) {
//					lbxAperturaCierre.setSelectedIndex(0);
//					chbRevisado.setChecked(false);
//
//					Sistema.mensaje("Ya existe una APERTURA realizada");
//				}
//				else{
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) { //Se pregunta si se seleccionó APERTURA
					RociadoProcesoDAOJpaImpl rociadoProcesoImpl = new RociadoProcesoDAOJpaImpl();
					CoccionProcesoDAOJpaImpl coccionProcesoImpl = new CoccionProcesoDAOJpaImpl();
					coccionProceso = new CoccionProceso();
					rociadoProceso = new RociadoProceso();

					procesoAperturaCierre = new ProcesoAperturaCierre();
					
					procesoAperturaCierre.setEstado(1);
					procesoAperturaCierre.setFechaapertura(new java.sql.Timestamp(new Date().getTime()));
					Proceso pr=new Proceso();
					pr.setIdproceso(3);
					procesoAperturaCierre.setProceso(pr);					
					//Guardar el idproceso y consultar el valor generado
					
					
					produccion.setIdproduccion(Long.valueOf( lbxDiaProduccion.getSelectedItem().getTooltiptext()));					
					evisceradoProceso.setProduccion(produccion);
					
					
					evisceradoProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
					evisceradoProceso.setProcesoAperturaCierre(procesoAperturaCierre);
					evisceradoProceso.setSecuenciaidcocheglobal(0);
	
					
					
					coccionProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
					coccionProceso.setProduccion(produccion);
					coccionProceso.setEstado(1);
//					coccionProceso.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
					
					rociadoProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
					rociadoProceso.setProduccion(produccion);
					rociadoProceso.setEstado(1);
//					rociadoProceso.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
					
					evisceradoProcesoDAOImpl.guardarevisceradoProceso(evisceradoProceso);
					coccionProcesoImpl.saveOrUpdate(coccionProceso);
					rociadoProcesoImpl.saveOrUpdate(rociadoProceso);
					
					lbxAperturaCierre.setSelectedIndex(0);
					chbRevisado.setChecked(false);
					
					Sistema.mensaje("Proceso APERTURADO correctamente");
				}
			}
			
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {//Se pregunta si se seleccionó CIERRE
//				if (procesoAperturaCierre == null) {
//					
//					lbxAperturaCierre.setSelectedIndex(0);
//					chbRevisado.setChecked(false);
//					
//					Sistema.mensaje("Ningun dato encontrado para el proceso de CIERRE");
//				}
//				else{
				//NUEVOS METODOS PARA EVICERAADO
				List<EvisceradoDetalleProcesoCoche> eDPCoches = new ArrayList<EvisceradoDetalleProcesoCoche>();
				eDPCoches= new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoCochesaCerrar();
				
				if (eDPCoches.size()>0){
					Sistema.mensaje("Debe cerrar los coches que estan activos ");
					return;
				}
					procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl().getSeleccionProcesoAperturaCierre(lbxDiaProduccion.getSelectedItem().getTooltiptext());
				
					procesoAperturaCierre.setEstado(0);
					procesoAperturaCierre.setFechacierre(new java.sql.Timestamp(new Date().getTime()));
/*					Proceso pr=new Proceso();
					pr.setIdproceso(3);
					procesoAperturaCierre.setProceso(pr);*/
					
					//Cerramos en Eviscerado
					procesoAperturaCierreDAOImpl.guardarprocesoAperturaCierre(procesoAperturaCierre);
					
					//Coccion proceso
					long id = procesoAperturaCierre.getEvisceradoProcesos().get(0).getProduccion().getIdproduccion();
					
					//Cerramos en CoccionProceso
					CoccionProceso coccionproceso = new CoccionProceso();
					coccionproceso = new CoccionProcesoDAOJpaImpl().getCoccionProcesoIdProduccion(String.valueOf(id));
					coccionproceso.setEstado(0);
					new CoccionProcesoDAOJpaImpl().saveOrUpdate(coccionproceso);
					
					//Cerramos en RociadoProceso
					RociadoProceso rociadoproceso = new RociadoProceso();
					rociadoproceso = new RociadoProcesoDAOJpaImpl().getRociadoProcesoIdProduccion(String.valueOf(id));
					rociadoproceso.setEstado(0);
					new RociadoProcesoDAOJpaImpl().saveOrUpdate(rociadoproceso);					
					//NUEVOS METODOS PARA EVICERAADO
					//TODO
					producciones= produccionImpl.getListaFechaProduccionUnoCero(2);
					if (producciones.isEmpty()){
						Parametro parametro = new Parametro();
						parametro=new ParametroDAOJpaImpl().getParametroById("9");
						parametro.setValor(0);
						new ParametroDAOJpaImpl().saveOrUpdate(parametro);
					}
					
					lbxAperturaCierre.setSelectedIndex(0);
					chbRevisado.setChecked(false);
					
					
					Sistema.mensaje("Proceso CERRADO correctamente");
				//}
			//}

			limpiarDatos();
			lbxAperturaCierre.setSelectedIndex(0);
			lbxDiaProduccion.getItems().clear();

			/////////////////////////////////////////
			// ANULACION DE COCHES DE CONTINGENCIA //
			/////////////////////////////////////////
			
			//Obtine lista de procesos de eviscerado aperturados
			lProcesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl().obtenerProcesoAperturaCierreEvicerado();
			
			//No existen procesos aperturados (todos cerrados)
			if(lProcesoAperturaCierre.size() == 0)
			{
				//Obtenemos la lista de coches de contingemcia tarados para se anulados
				lEvisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCocheDAOJpaImpl().ListaCochesTaradosContingencia();
				
				//Recorremos la lista de coches de contingencia para anularlos
				for (EvisceradoDetalleProcesoCoche bd : lEvisceradoDetalleProcesoCoche) 
				{
					//Procedemos anular todo los coches de contingencia
					EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche =  new EvisceradoDetalleProcesoCoche();
					evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoDetalleProcesoCocheByNumMuestra(bd.getIdevisceradodetalleprocesocoche());
					
					//Encontro un objeto valido	
					if(evisceradoDetalleProcesoCoche != null)
					{
						//Esta disponible
						if (evisceradoDetalleProcesoCoche.getEstadouso() == 0)
						{
							//Anulamos la secuencia de contingencia
							evisceradoDetalleProcesoCoche.setEstadouso(3);
							new EvisceradoDetalleProcesoCocheDAOJpaImpl().saveOrUpdate(evisceradoDetalleProcesoCoche);
						}
					}
					
				}
				
			}
			/////////////////////////////////////////////
			// FIN ANULACION DE COCHES DE CONTINGENCIA //
			/////////////////////////////////////////////
			 
			
		}
	}
	
	void limpiarDatos()
	{
		//lbxAperturaCierre.setSelectedIndex(0);
//		lbxDiaProduccion.setSelectedIndex(0);
		//chbRevisado.isChecked() = false;
		
		procesoAperturaCierreDAOImpl = new ProcesoAperturaCierreDAOJpaImpl();
		evisceradoProceso = new EvisceradoProceso();
		evisceradoProcesoDAOImpl = new EvisceradoProcesoDAOJpaImpl();
		
		///cargarListaFecha();
		
	}
	
}
