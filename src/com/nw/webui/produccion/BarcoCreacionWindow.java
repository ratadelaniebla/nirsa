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

import com.nw.model.Barco;
import com.nw.model.Produccion;
import com.nw.model.BarcoPropiedad;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.BarcoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class BarcoCreacionWindow extends GenericForwardComposer {

	/**
	 * Desarrollado por Leonardo Moya Paredes
	 * leofabricio.mp3@gmail.com 
	 */
	
	private Listbox lbxBarco,lbxPropiedad;
	//private Toolbarbutton btnGrabar;
	private Textbox txtNombre,txtNumero,txtNomina;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	Produccion produccion = new Produccion();
	
	Barco barco;
	List<Barco> listaBacos = new ArrayList<Barco>();
	BarcoDAOJpaImpl barcoDaoIMP = new BarcoDAOJpaImpl();
	BarcoPropiedad barcoPropiedad = new BarcoPropiedad();
	
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
		obtenerBarcos();
		obtenerPropietario();
	}
	
	
	public void obtenerBarcos()
	{
		try {
			
			lbxBarco.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxBarco);
					
			listaBacos = new BarcoDAOJpaImpl().getBarcos();
			
			for (Barco bd : listaBacos) {
				li = new Listitem();
				li.setValue(bd);
				li.setParent(lbxBarco);
				new Listcell(String.valueOf(bd.getNombre()) ).setParent(li);
				li.setParent(lbxBarco);
			}
			lbxBarco.setSelectedIndex(0);
			
			

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	public void obtenerPropietario(){
		try {
			
			lbxPropiedad.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new BarcoPropiedad());
			li.setParent(lbxPropiedad);
					
			List<BarcoPropiedad> listaPropietario= barcoDaoIMP.getPropietarios();
			
			for (BarcoPropiedad itenturno : listaPropietario) {
				li = new Listitem();
				li.setValue(itenturno);
				
				new Listcell(String.valueOf(itenturno.getDescripcion()) ).setParent(li);
				li.setParent(lbxPropiedad);
				
			}
			lbxPropiedad.setSelectedIndex(0);
			
			

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void onChange$txtNumero() { 
		if (listaBacos.size() >0){
			for (Barco itemBarco: listaBacos) {
				if (itemBarco.getNumbarco().equals(txtNumero.getValue())){
					Sistema.mensaje("El valor de numero de Barco ya existe... modifique el campo");
					txtNumero.focus();
				}
			}
		}
	}
	
	public void onChange$txtNombre() { 
		if (txtNombre.getValue().equals("")){
			Sistema.mensaje("El valor del Nombre de Barco no debe esta vacio... modifique el campo");
			txtNombre.focus();
		}else{
			txtNombre.setValue(txtNombre.getValue().toUpperCase());
		}
			
		
	}
	public void onSelect$lbxPropiedad() throws InterruptedException{
		if (lbxPropiedad.getSelectedIndex()>0) {
			barcoPropiedad = new BarcoPropiedad();
			barcoPropiedad = (BarcoPropiedad) lbxPropiedad.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
		}else{
			barcoPropiedad=null;
		}
	}
	
	
	public void onSelect$lbxBarco() throws InterruptedException{
		limpiarCajas();
		if (lbxBarco.getSelectedIndex()>0) {
			barco = new Barco();
			barco = (Barco) lbxBarco.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			if (barco.getIdnomina()!=null)
				txtNomina.setValue(barco.getIdnomina());
			if ((barco.getBarcoPropiedad()!=null) && barco.getBarcoPropiedad().getIdpropiedad()!=null){
//				if(barco.getBarcoPropiedad().getIdpropiedad()==1){
//					lbxPropiedad.setSelectedIndex(1);
//				}else if(barco.getBarcoPropiedad().getIdpropiedad()==2){
//					lbxPropiedad.setSelectedIndex(2);
//				}else if(barco.getBarcoPropiedad().getIdpropiedad()==3){
//					lbxPropiedad.setSelectedIndex(3);
//				}else if(barco.getBarcoPropiedad().getIdpropiedad()==4){
//					lbxPropiedad.setSelectedIndex(4);
//				}else if(barco.getBarcoPropiedad().getIdpropiedad()==5){
//					lbxPropiedad.setSelectedIndex(5);
//				}
				lbxPropiedad.setSelectedIndex(barco.getBarcoPropiedad().getIdpropiedad());
				barcoPropiedad = (BarcoPropiedad) lbxPropiedad.getSelectedItem().getValue();
				//lngOrdenFab.setValue(barco.getIdordenfabricacion());
			}else{
				lbxPropiedad.setSelectedIndex(0);
			}
			if (barco.getNombre()!=null)
				txtNombre.setValue(barco.getNombre());
			if (barco.getNumbarco()!=null)
				txtNumero.setValue(barco.getNumbarco());

		}else{
			barco = null;
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
		
		if (lbxPropiedad.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido la Propiedad.. no puede grabar");
			return;
		}
		if ((txtNombre == null)||txtNombre.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Registro.. no puede grabar");
			txtNombre.focus();
			return;
		}
		
//		if ((txtNomina == null)||txtNomina.getValue().equals("")){
//			Sistema.mensaje("No se ha ingresado el Nomina.. no puede grabar");
//			txtNomina.focus();
//			return;
//		}
		if ((txtNumero== null)||txtNumero.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Numero.. no puede grabar");
			txtNumero.focus();
			return;
		}
		
		if ((barco!=null) && barco.getIdbarco()!=null){	

//			if ((barcoPropiedad!=null)&&barcoPropiedad.getIdpropiedad()==null){
//				barcoPropiedad = (BarcoPropiedad) lbxPropiedad.getSelectedItem().getValue();
//			}
			
			//barco.setIdbarco(idbarco);
			barco.setIdnomina(txtNomina.getValue());
			barco.setNombre(txtNombre.getValue());
			barco.setNumbarco(txtNumero.getValue());
			barco.setBarcoPropiedad(barcoPropiedad);
			barcoDaoIMP.saveOrUpdate(barco);
			Sistema.mensaje("Los datos han sido Actualizados");
		}else
		{
			Barco loc_barco = new Barco();
			loc_barco = barcoDaoIMP.getMaxIdBarco();
			int idbarco=loc_barco.getIdbarco()+1;
			//TODO
			barco = new Barco();
			barco.setIdbarco(idbarco);
			barco.setIdnomina(txtNomina.getValue());
			barco.setNombre(txtNombre.getValue());
			barco.setNumbarco(txtNumero.getValue());
			barco.setBarcoPropiedad(barcoPropiedad);
			barcoDaoIMP.saveBarco(barco);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			//limpiarDatos();
		}
		
		

		limpiarDatos();	
		
		
		
	}
	public void limpiarCajas(){
		txtNombre.setValue("");
		txtNomina.setValue("");
		txtNumero.setValue("");
		if (lbxPropiedad.getSelectedIndex()>=0){	
			lbxPropiedad.setSelectedIndex(0);
		}
	}
	void limpiarDatos()
	{
		
			barco = new Barco();
			produccion = new Produccion();
			limpiarCajas();
			obtenerBarcos();
	}
	
}
