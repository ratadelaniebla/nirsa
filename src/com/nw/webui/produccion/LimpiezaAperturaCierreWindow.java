package com.nw.webui.produccion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import com.nw.model.LimpiezaProceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.impl.LimpiezaAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;


public class LimpiezaAperturaCierreWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	
	private Listbox lbxDiasProduccion,lbxTurno;
	private Listbox lbxAperturaCierre;
	private Checkbox chkRevisado;

	Produccion produccion;// = new Produccion();
	Turno turno = new Turno();
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		cargarProducciones();
		cargarListaTurno();
	}
	
	private void cargarProducciones() throws InterruptedException{
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxDiasProduccion);

		for (Produccion p: new ProduccionDAOJpaImpl().getProducciones()){
			li = new Listitem();
			li.setValue(p);
			new Listcell( p.getFechaproduccion().toString().substring(0,10) ).setParent(li);
			li.setParent(lbxDiasProduccion);
		}
		lbxDiasProduccion.setSelectedIndex(0);
		onSelect$lbxDiasProduccion();
	}
	
	public void cargarListaTurno(){
		lbxTurno.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);
				
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		
		for (Turno bd : listaTurnos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);

	}
	
	public void onSelect$lbxDiasProduccion() throws InterruptedException{
		
		if (lbxDiasProduccion.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxDiasProduccion.getSelectedItem().getValue();

			lbxTurno.setFocus(true);

		}else{
			produccion = null;
		}
	}
	
	public void onSelect$lbxTurno() throws InterruptedException{
		
		if (produccion == null) {
			Sistema.mensaje("Debe escoger una fecha");
			lbxTurno.setSelectedIndex(0);
		}
		else
		{
			if (lbxTurno.getSelectedIndex()>0) {
				//vaciamos el objeto barcoDescarga creando una nueva instancia 
				turno = new Turno();
				turno = (Turno) lbxTurno.getSelectedItem().getValue();
				lbxAperturaCierre.setFocus(true);
				
			}else{
				turno = null;
				Sistema.mensaje("Se requiere el turno para los lotes");
				lbxTurno.getItems().clear();
			}
		}
	}
	
	public void onClick$btnGrabar() throws Exception{
		if (chkRevisado.isChecked()){

//			Produccion produccion = (Produccion)lbxDiasProduccion.getSelectedItem().getValue();
			int accion = Sistema.parseInt((String)lbxAperturaCierre.getSelectedItem().getValue());
			ProcesoAperturaCierre proceso = new LimpiezaAperturaCierreDAOJpaImpl().getActivo();
			LimpiezaProceso lp=null;
			boolean activo=false;
			if (proceso != null){
				lp= new LimpiezaProceso();
				lp = new LimpiezaAperturaCierreDAOJpaImpl().getLimpiezaProcesoIdProduccion(produccion.getIdproduccion(), turno);
				activo=true;
			}
			LimpiezaProceso locLp= new LimpiezaProceso();
			
			
			String mensaje = "Proceso [%s] con fecha [%s] y turno [%s] %s";

			
			if (accion == 1){ // Aperturar
				locLp = new LimpiezaAperturaCierreDAOJpaImpl().getLimpiezaProcesoRegistrado(produccion.getIdproduccion(), turno);
				if (locLp!=null){
					Sistema.mensaje("Proceso ya fue aperturado");
					return;
				}
				
				if (lp != null )
					Sistema.mensaje(String.format(mensaje, lp.getIdlimpiezaproceso(),  obtenerDateAString(lp.getProduccion().getFechaproduccion()).toString().substring(0,10), lp.getTurno().getIdturno(), "ya está aperturado y se encuentra ACTIVO" ));
//					Sistema.mensaje(String.format(mensaje, lp.getIdlimpiezaproceso(),  obtenerStringEnhoy(lp.getProduccion().getFechaproduccion().toString()).toString().substring(0,10), lp.getTurno().getIdturno(), "ya está aperturado y se encuentra ACTIVO" ));
				
				
				else{
					
					////////MODIFICADO////////
					////////11-03-2015////////
//					if(activo){
//						Sistema.mensaje("Ya existe un proceso activo");
//						return;
//					}
					/////FIN MODIFICADO///////
					////////11-03-2015////////
										
					
					//Al Aperturar o cerrar el proceso, se indique que este registro
					//es del proceso = 4 (lineas/limpieza)
//					ProcesoAperturaCierre pac = new LimpiezaAperturaCierreDAOJpaImpl().aperturarProduccionTurno(produccion,turno);
					lp = new LimpiezaAperturaCierreDAOJpaImpl().aperturarProduccionTurno(produccion,turno);
					if (lp !=null)
//						Sistema.mensaje(String.format(mensaje, pac.getIdprocesoaperturacierre(), pac.getFechaapertura().toString().substring(0,10), "fue APERTURADO correctamente" ));
						Sistema.mensaje(String.format(mensaje, lp.getIdlimpiezaproceso(), obtenerDateAString(lp.getProduccion().getFechaproduccion()).toString().substring(0,10), lp.getTurno().getIdturno(), "fue APERTURADO correctamente" ));
					else
						Sistema.mensaje("No se pude aperturar el proceso...");
					chkRevisado.setChecked(false);
				}
			}else{
				if (lp != null){

					 int cochessintara;
					 
					 
					 cochessintara = new LimpiezaAperturaCierreDAOJpaImpl().getNumCochesSinTara(produccion.getIdproduccion(),turno.getIdturno());
/*					 muestraporlotemuesstras = muesxlote;*/

					 if (cochessintara > 0){
						Sistema.mensaje("NO PUEDE CERRAR..EXISTEN COCHES SIN TARAR");
						return;
					 }
					 
					//Preguntar si desea cerrar...
					new LimpiezaAperturaCierreDAOJpaImpl().cerrar(lp.getProcesoAperturaCierre());
//					Sistema.mensaje(String.format(mensaje, lp.getProcesoAperturaCierre().getProceso().getDescripcionproceso(), lp.getProcesoAperturaCierre().getFechaapertura().toString().substring(0,10), "fue CERRADO correctamente" ));
					Sistema.mensaje(String.format(mensaje, lp.getIdlimpiezaproceso(), obtenerDateAString(lp.getProduccion().getFechaproduccion()).toString().substring(0,10), lp.getTurno().getIdturno(), "fue CERRADO correctamente" ));
					chkRevisado.setChecked(false);
					
					
					////////////////////
					//Reajustar Tallas//
					////////////////////
					
					//REAJUSTAMOS LAS TALLAS DE LOS COCHES DEL PROCESO QUE SE ESTA CERRANDO//
					//Sistema.mensaje("lp.getIdlimpiezaproceso() :"+lp.getIdlimpiezaproceso());
					new LimpiezaDetalleProcesoCocheDAOJpaImpl().ReajustarTallasPorProceso(lp.getIdlimpiezaproceso());
					//FIN REAJUSTAMOS LAS TALLAS DE LOS COCHES DEL PROCESO QUE SE ESTA CERRANDO//					
					
				}else
					Sistema.mensaje("No hay un proceso Aperturado...");
			}
		}else
			Sistema.mensaje("Revise antes de grabar");
	}


	
	public String obtenerDateAString(Date parafecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateadaActual = formato.format(parafecha);

		return fechaFormateadaActual;
	}
}
