package com.nw.webui.produccion;



import java.util.ArrayList;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.Cuba;
import com.nw.model.Produccion;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CubaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CubaCreacionWindow extends GenericForwardComposer {

	/**
	 * Desarrollado por Leonardo Moya Paredes
	 * leofabricio.mp3@gmail.com 
	 */
	
	private Listbox lbxCuba;
	private Textbox txtNombre,txtEspecificacion;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	Produccion produccion = new Produccion();
	
	Cuba cuba;
	List<Cuba> listaCubas = new ArrayList<Cuba>();
	CubaDAOJpaImpl cubaDaoIMP = new CubaDAOJpaImpl();
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
		obtenerCubas();
	}
	
	
	public void obtenerCubas()
	{
		try {
			
			lbxCuba.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxCuba);
					
			listaCubas = new CubaDAOJpaImpl().getCubas();
			
			for (Cuba bd : listaCubas) {
				li = new Listitem();
				li.setValue(bd);
				li.setParent(lbxCuba);
				new Listcell(String.valueOf(bd.getNombrecuba()) ).setParent(li);
				li.setParent(lbxCuba);
			}
			lbxCuba.setSelectedIndex(0);
			
			

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	//onChanging		
	public void onChange$txtNombre() { 
		if (listaCubas.size() >0){
			for (Cuba itemCuba: listaCubas) {
				if (itemCuba.getNombrecuba().equals(txtNombre.getValue())){
					Sistema.mensaje("El valor de Nombre de la Cuba ya existe... modifique el campo");
					txtNombre.focus();
				}
			}
		}
	}
	
	
	
	
	public void onSelect$lbxCuba() throws InterruptedException{
		limpiarCajas();
		if (lbxCuba.getSelectedIndex()>0) {
			cuba = new Cuba();
			cuba = (Cuba) lbxCuba.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			if (cuba.getEspecificacion()!=null)
				txtEspecificacion.setValue(cuba.getEspecificacion());
			if (cuba.getNombrecuba()!=null)
				//lngOrdenFab.setValue(barco.getIdordenfabricacion());
				txtNombre.setValue(cuba.getNombrecuba());
			

		}else{
			cuba = null;
		}
	}
	
	
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	public void grabar()
	{	
		
		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		if (usuario==null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			//return;
			//usu.setIdusuario("aaguirre");
		}
		
		if ((txtNombre == null)||txtNombre.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Registro.. no puede grabar");
			txtNombre.focus();
			return;
		}
		
		
		if ((txtEspecificacion== null)||txtEspecificacion.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Numero.. no puede grabar");
			txtEspecificacion.focus();
			return;
		}
		
		if ((cuba!=null) && cuba.getIdcuba()!=null){	
			//barco.setIdbarco(idbarco);
			cuba.setNombrecuba(txtNombre.getValue());
			cuba.setEspecificacion(txtEspecificacion.getValue());
			cubaDaoIMP.saveOrUpdate(cuba);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		}else
		{
			Cuba loc_Cuba = new Cuba();
			loc_Cuba = cubaDaoIMP.getMaxIdCuba();
			int idCuba=loc_Cuba.getIdcuba()+1;
			//TODO
			cuba =new Cuba();
			cuba.setIdcuba(idCuba);
			cuba.setNombrecuba(txtNombre.getValue());
			cuba.setEspecificacion(txtEspecificacion.getValue());
			cubaDaoIMP.saveCuba(cuba);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			//limpiarDatos();
		}
		limpiarDatos();	
	}
	public void limpiarCajas(){
		txtNombre.setValue("");
		txtEspecificacion.setValue("");
		
	}
	void limpiarDatos()
	{
		if (lbxCuba.getSelectedIndex()>=0){	
			lbxCuba.getItems().clear();
			obtenerCubas();
		}
			cuba = new Cuba();
			produccion = new Produccion();
		
			limpiarCajas();
		
	}
	
}
