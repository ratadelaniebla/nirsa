package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.DescongeladoProceso;
import com.nw.model.Parametro;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.dao.impl.DescongeladoProcesoDAOJpaImpl;
//import com.nw.model.dao.impl.DesperdicioHarinaParametroDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;


//DescongeladoAperturaCierre
@SuppressWarnings("serial")
public class DescongeladoAperturaCierreProcesoWindow extends GenericForwardComposer {

	private Listbox lbxDiaProduccion,lbxAperturaCierre;
	private Checkbox chbRevisado ;
	private Toolbarbutton btnGrabar;
	private ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	private Produccion produccion = new Produccion();
	private Parametro parametro;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private ProcesoAperturaCierreDAOJpaImpl procesoAperturaCierreDAOImpl;
	private DescongeladoProceso descongeladoProceso;
	private DescongeladoProcesoDAOJpaImpl descongeladoProcesoDAOImpl;
	private Double idprocesoAperturaCierre;
	private Date fecha;

	
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
			
			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl().getListaFechaProduccionUnoCeroDescongelado(lbxAperturaCierre.getSelectedIndex());
			
			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				li.setTooltiptext(bd.getIdproduccion().toString());
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				li.setParent(lbxDiaProduccion);
				
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
	}
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	public void grabar()
	{	
		if (chbRevisado.isChecked() == true) 
		{
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) { //Se pregunta si se seleccionó APERTURA
					procesoAperturaCierre = new ProcesoAperturaCierre();
					
					procesoAperturaCierre.setEstado(1);
					procesoAperturaCierre.setFechaapertura(new java.sql.Timestamp(new Date().getTime()));
					Proceso pr=new Proceso();
					pr.setIdproceso(5);
					procesoAperturaCierre.setProceso(pr);					

					//Guardar el idproceso y consultar el valor generado
					produccion.setIdproduccion(Long.valueOf( lbxDiaProduccion.getSelectedItem().getTooltiptext()));					
					descongeladoProceso.setProduccion(produccion);
					
					
					descongeladoProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
					descongeladoProceso.setProcesoAperturaCierre(procesoAperturaCierre);
					//descongeladoProceso.setSecuenciaidcocheglobal(0);
	
					descongeladoProcesoDAOImpl.saveOrUpdate(descongeladoProceso);
					lbxAperturaCierre.setSelectedIndex(0);
					chbRevisado.setChecked(false);
					
					CambiarModoAutomaticoBalanza();
					
					Sistema.mensaje("Proceso APERTURADO correctamente");
				}
			}
			
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {//Se pregunta si se seleccionó CIERRE
					procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl().getSeleccionProcesoAperturaCierreDescongelado(lbxDiaProduccion.getSelectedItem().getTooltiptext());
				
					procesoAperturaCierre.setEstado(0);
					procesoAperturaCierre.setFechacierre(new java.sql.Timestamp(new Date().getTime()));
					
					//Cerramos en Eviscerado
					procesoAperturaCierreDAOImpl.guardarprocesoAperturaCierre(procesoAperturaCierre);
					
					//Coccion proceso
					//long id = procesoAperturaCierre.getEvisceradoProcesos().get(0).getProduccion().getIdproduccion();
					//long id = produccion.getIdproduccion();
					
					lbxAperturaCierre.setSelectedIndex(0);
					chbRevisado.setChecked(false);
					
					
					Sistema.mensaje("Proceso CERRADO correctamente");
					
					CambiarModoAutomaticoBalanza();

			limpiarDatos();
			lbxAperturaCierre.setSelectedIndex(0);
			lbxDiaProduccion.getItems().clear();
		}
	}
	
	public void CambiarModoAutomaticoBalanza()
	{
		/*
		parametro = new Parametro();
		//Obtenemos el parametro para Habilitar o no el ingreso manual descongelado
		parametro = new DesperdicioHarinaParametroDAOJpaImpl().getParametroById("29");
		
		//Tabla de configuración de parametros
		parametro.setPermiso("N");
		
		//Actualizamos el estado del paramatro desactivado
		new DesperdicioHarinaParametroDAOJpaImpl().saveOrUpdate(parametro);
		*/				
	}
	

	
	void limpiarDatos()
	{
		procesoAperturaCierreDAOImpl = new ProcesoAperturaCierreDAOJpaImpl();
		descongeladoProceso = new DescongeladoProceso();
		descongeladoProcesoDAOImpl = new DescongeladoProcesoDAOJpaImpl();
	}
	
}
