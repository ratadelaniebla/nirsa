package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;


import com.nw.model.Produccion;

import com.nw.model.Usuario;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class ProduccionAperturaCierreAnulacionProcesoWindow extends GenericForwardComposer {

	private Listbox lbxAperturaCierre,lbxDiaProduccion;
	private Checkbox chbRevisado ;
	private Toolbarbutton btnGrabar;
	private Textbox txtEstado;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	Produccion produccion = new Produccion();

	Integer paraEstado;
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
			List<Produccion> listafechaProduccion = new ArrayList<Produccion>();
			if (lbxAperturaCierre.getSelectedIndex()==1){
				paraEstado=0;		
				listafechaProduccion = new ProduccionDAOJpaImpl().obtenerListaFechaProduccionAperturaCierre(paraEstado);
				paraEstado=1;
			}else if (lbxAperturaCierre.getSelectedIndex()==2){
				paraEstado=1;		
				listafechaProduccion = new ProduccionDAOJpaImpl().obtenerListaFechaProduccionAperturaCierre(paraEstado);
				paraEstado=2;
			}
			else if (lbxAperturaCierre.getSelectedIndex()==3){
				paraEstado=1;		
				listafechaProduccion = new ProduccionDAOJpaImpl().obtenerListaFechaProduccionAnular(paraEstado);
				paraEstado=3;
			}
			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				li.setParent(lbxDiaProduccion);
				
				produccion.setIdproduccion(bd.getIdproduccion());
			}
			lbxDiaProduccion.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}	
	}
	
	public void onSelect$lbxAperturaCierre() throws InterruptedException{
		
		if (lbxAperturaCierre.getSelectedIndex()>=0){
			cargarListaFecha();
		}
	}
	
	public void onSelect$lbxDiaProduccion() throws InterruptedException{
		
		if (lbxDiaProduccion.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxDiaProduccion.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			txtEstado.setValue(String.valueOf(produccion.getEstado()));
			
		}else{
			produccion = null;
			txtEstado.setValue("");
		}
	}
	
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	public void grabar()
	{	
		if (chbRevisado.isChecked() == true) {
		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		if (usuario==null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			//return;
			usu.setIdusuario("aaguirre");
		}
		if (lbxAperturaCierre.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha seleccionado la Apertura Cierre Anulacion.. no puede grabar");
			return;
		}
		
		
		if (lbxDiaProduccion.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
			return;
		}
		
		
		if ( produccion!= null ){

			//TODO
			produccion.setEstado(paraEstado);
			produccionImpl.saveOrUpdate(produccion);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			}	
		}
		else{
			Sistema.mensaje("Debe seleccionar todos los campos ");
		}
		
		limpiarDatos();
		
	}
	
	void limpiarDatos()
	{
			txtEstado.setValue("");
			lbxDiaProduccion.getItems().clear();
			produccion = new Produccion();
			paraEstado=0;
			chbRevisado.setChecked(false);
			lbxAperturaCierre.setSelectedIndex(0);
	}
	
}
