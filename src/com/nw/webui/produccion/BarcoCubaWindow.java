package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.Barco;
import com.nw.model.BarcoCuba;
import com.nw.model.Cuba;
import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDAOJpaImpl;
import com.nw.model.dao.impl.CubaDAOJpaImpl;
import com.nw.temp.model.BarcoCubaEstado;
import com.nw.util.Sistema;
 

/**
 * 
 * @author Carlos Holguin
 * @since 19-06-2014
 * @version 1.0
 *
 */
public class BarcoCubaWindow extends GenericForwardComposer {

	 
	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	//Objetos zul
	Textbox txtNumBarco,txtNombreBarco,txtPropiedad,txtNomina;
	Listbox lbxCuba,lbxCubas,lbxBarco;
	Toolbarbutton btnGrabar,btnAgregarCuba,btnEliminarCuba;
	//Objetos
	//BarcoCuba barcoCuba;
	BarcoCubaEstado barcoCubaEstado;
	Barco barco;
	Cuba cuba;
	//Listados
	List<BarcoCuba> barcoCubas = new ArrayList<BarcoCuba>();
	private List<BarcoCubaEstado> barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
	List<Barco> barcos = new ArrayList<Barco>();
	List<Cuba> cubas = new ArrayList<Cuba>();
	
	//DAO
	BarcoDAOJpaImpl barcoDAOJpaImpl = new BarcoDAOJpaImpl();
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		 
		super.doAfterCompose(comp);
		comp.setVariable(comp.getId(), this, true);
		
		cargarListaBarcos();
		cargarCubas();
		
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}
	
	
	/**
	 * Metodo que asigna  un barco a un objeto Barco una ves que se ha seleccionado de la Lista
	 * @throws InterruptedException
	 */
	public void onSelect$lbxBarco() throws InterruptedException{
		selectBarco();
	}
	
	/**
	 * Metodo que asigna  una cuba a un objeto Cuba una ves que se ha seleccionado de la Lista
	 * @throws InterruptedException
	 */
	public void onSelect$lbxCuba() throws InterruptedException{
		selectCuba();
	}
	
	public void onClick$btnAgregarCuba(){
		agregarCuba();
	}
	
	/**
	 * Metodo que asigna  un barco cuba a un objeto barcoCuba una ves que se ha seleccionado de la Lista
	 * @throws InterruptedException
	 */
	public void onSelect$lbxCubas() throws InterruptedException{
		selectCubas();
	}
	
	public void onClick$btnGrabar(){
		grabar();
	}
	
	
	public void onClick$btnEliminarCuba() throws InterruptedException{
		//eliminarCubaIndividual();
		eliminarCubasGrupales();
	}
	
	
	
	////////////////////////////METODOS LOGICA DE NEGOCIO////////////////////////////////
	
	public void cargarListaBarcos(){
		barcos = new ArrayList<Barco>();
		lbxBarco.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Barco());
		li.setParent(lbxBarco);
		
		barcos = new BarcoDAOJpaImpl().getBarcos();
		for (Barco bd : barcos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell( bd.getNombre()+" "+bd.getNumbarco()).setParent(li);
			li.setParent(lbxBarco);
		}
		lbxBarco.setSelectedIndex(0);
	}

	public void cargarCubas(){
		cubas = new ArrayList<Cuba>();
		lbxCuba.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Cuba());
		li.setParent(lbxCuba);
		
		cubas = new CubaDAOJpaImpl().getCubas();
		for (Cuba cuba : cubas) {
			li = new Listitem();
			li.setValue(cuba);
			new Listcell( cuba.getNombrecuba()+" "+cuba.getEspecificacion()).setParent(li);
			li.setParent(lbxCuba);
		}
		lbxCuba.setSelectedIndex(0);
		
	}
	
	
	public void selectBarco(){
		if (lbxBarco.getSelectedIndex()>0) {
			//vaciamos el objeto barco creando una nueva instancia 
			barco = new Barco();
		    barco = (Barco) lbxBarco.getSelectedItem().getValue();//asigno el item barco seleccionado
		    limpiarCajas();
		    //asignar las propiedades del barco a las cajas
		    txtNombreBarco.setValue(barco.getNombre());
			txtNomina.setValue(barco.getIdnomina());
			txtNumBarco.setValue(barco.getNumbarco());
			txtPropiedad.setValue(barco.getBarcoPropiedad().getDescripcion()+"");
			//aki se debe cargar las cubas correspondientes en lbxCubas en base al barco escogido
			barcoCubas = new BarcoCubaDAOJpaImpl().getBarcosCubasPorBarco(barco.getIdbarco());
			System.out.println("tamano de lista de cubas encontradas->" + barcoCubas.size());
			
			barcosCubasEstados = getBarcosCubasEstado(this.barcoCubas);
			//cargarListaCubasBarco();
			//cargarListaCubasBarcosEstados(barcosCubasEstados);
			binder.loadAll();
		    
		}else{
			barco = null;
			limpiarCajas();
		}
	}
	
	
	public void selectCuba(){
		if (lbxCuba.getSelectedIndex()>0) {
			//vaciamos el objeto cuba creando una nueva instancia 
			cuba = new Cuba();
		    cuba = (Cuba) lbxCuba.getSelectedItem().getValue();//asigno el item cuba seleccionado
		    
		}else{
			cuba = null;
			 
		}
	}
	
	
	public void agregarCuba(){
		if (cuba==null) {
            Sistema.mensaje("Debe escoger una cuba");
            return;
		}
		
		BarcoCuba bc = new BarcoCuba(); 
		bc.setBarco(this.barco);
	    bc.setCuba(this.cuba);
		BarcoCubaEstado bce = new BarcoCubaEstado(bc, true, false);
		
		
		for (BarcoCubaEstado cub : barcosCubasEstados) {
			if (cub.getBarcoCuba().getCuba().getIdcuba()==this.cuba.getIdcuba()) {
				Sistema.mensaje("la Cuba ya ha sido asignada a la lista.. ");
				return;
			}
		}
		
		barcosCubasEstados.add(bce);
		System.out.println("tamano de lista barcocubas-->"+barcoCubas.size());
		binder.loadAll();
		//lbxCubas.setModel(new ListModelList(clientedao.getAll()));  
		
		//cargarListaCubasBarcosEstados(this.barcosCubasEstados);
	}
	
	public void selectCubas(){
		if (lbxCubas.getSelectedIndex()>0) {
			//vaciamos el objeto cuba creando una nueva instancia 
			barcoCubaEstado = new BarcoCubaEstado();
			barcoCubaEstado = (BarcoCubaEstado) lbxCubas.getSelectedItem().getValue();//asigno el item barcoCuba seleccionado
		    //System.out.println("valor del objeto bce escogido-->"+barcoCubaEstado.isEliminarCuba());
			
			//binder.loadAll();
		}else{
			barcoCubaEstado = null;
			 
		}
	}
	
	public void eliminarCubaIndividual() throws InterruptedException{
		
		if (this.barcoCubaEstado==null) {
			Sistema.mensaje("Debe escoger un elemento de la lista");
			return;
		}
		
		
		  String msj = "Esta seguro(a) que desea eliminar el registro --> "
					+ this.barcoCubaEstado.getBarcoCuba().getCuba().getNombrecuba()+ " "
				    + this.barcoCubaEstado.getBarcoCuba().getCuba().getEspecificacion()  +" ?"
					+ ", esta accion no podra deshacerse si se confirma";
		  
		  Integer resultado;
		  resultado = Messagebox.show( msj, "ATENCION..!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION);
		  
		  System.out.println("resultado escogido es -->"+resultado);
			// SI = 16
			// NO = 32
			if (resultado == 16)
			{			

				int res = new BarcoCubaDAOJpaImpl().delete(this.barcoCubaEstado.getBarcoCuba());
				
				if (res == 1)
				{
					Messagebox.show("No puede Eliminar el registro ya que se encuentra en uso", "Error", Messagebox.OK, Messagebox.ERROR);				
				}
				else
					{				
					   barcosCubasEstados.remove(this.barcoCubaEstado);
					   this.barcoCubaEstado = null;
					   barcoCubas = new ArrayList<BarcoCuba>();
					   barcoCubas = new BarcoCubaDAOJpaImpl().getBarcosCubas(barco.getIdbarco());
					   barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
					   barcosCubasEstados = getBarcosCubasEstado(this.barcoCubas);
					   binder.loadAll();
					   //cargarListaCubasBarcosEstados(this.barcosCubasEstados);
					}
			}		
		
		
	}
	
	public void eliminarCubasGrupales() throws InterruptedException{
		
		
		if (barcosCubasEstados.isEmpty()) {
			Sistema.mensaje("No existen registros en la lista");
			return;
		}
		
		if (barco==null) {
			Sistema.mensaje("Debe escoger un barco");
			return;
		}
		
		
		
		  //String msj = "Esta seguro(a) que desea eliminar los registros seleccionados ?, "\" esta accion no podra deshacerse si se confirma";
		  //String msj = "Esta seguro(a) que desea eliminar los registros seleccionados ?,\n esta accion no podra deshacerse si se confirma";
			String msj = "Esta seguro(a) que desea eliminar los registros seleccionados ?, esta accion no podra deshacerse si se confirma";

		  /*
		  String msj = "Esta seguro(a) que desea eliminar los registros seleccionados ?"
					+ "\" esta accion no podra deshacerse si se confirma";
		  */
		  
		  
		  
		  Integer resultado;
		  resultado = Messagebox.show( msj, "ATENCION..!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION);
		  
		  System.out.println("resultado escogido es -->"+resultado);
			// SI = 16
			// NO = 32
			if (resultado == 16)
			{			

				for (BarcoCubaEstado bce : barcosCubasEstados) {
					//System.out.println("valores estado eliminar-->"+bce.isEliminarCuba());
					//System.out.println("cuba q deberia eliminar-->"+bce.getBarcoCuba().getIdbarcocuba());
					   
					   if (bce.isEliminarCuba()) {
						   int res = new BarcoCubaDAOJpaImpl().delete(bce.getBarcoCuba());
							
							if (res == 1)
							{
								Messagebox.show("No se puede Eliminar el registro => "+bce.getBarcoCuba().getCuba().getNombrecuba()+ 
							    "ya que se encuentra en uso", "Error", 
								 Messagebox.OK, Messagebox.ERROR);				
							}
							else
								{				
								   //barcosCubasEstados.remove(bce);
								   //recargo la lista con los registros de la base de datos 
								
								   //this.barcoCubaEstado = null;
								   //cargarListaCubasBarcosEstados(this.barcosCubasEstados);
								}
					}
					
				}
				   barcoCubas = new ArrayList<BarcoCuba>();
				   barcoCubas = new BarcoCubaDAOJpaImpl().getBarcosCubasPorBarco(barco.getIdbarco());
				   barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
				   barcosCubasEstados = getBarcosCubasEstado(this.barcoCubas);
				   binder.loadAll();
				
			}		
		
		
	}
	
	
	
	/**
	 * asigno estado de false a una lista derivada de la lista barcosCubas
	 * con esto se que datos debo actualizar 
	 * @param barcosCubas
	 * @return
	 */
	public List<BarcoCubaEstado> getBarcosCubasEstado(List<BarcoCuba> barcosCubas){
		List<BarcoCubaEstado> barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
		//asigno false en estadoCuba para indicar que vienen de la base de datos
		for (BarcoCuba bc : barcosCubas) {
			barcosCubasEstados.add(new BarcoCubaEstado(bc,false, false));
		}
		
		return barcosCubasEstados;
	}
	
	
	
	
	public void grabar(){
		if (lbxBarco.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el Barco.. no puede grabar");
			return;
		}
		if (barcosCubasEstados.isEmpty()){
			Sistema.mensaje("No se ha ingresado el Detalle de Cubas.. no puede grabar");
			return;
		}
		
		
		new BarcoCubaDAOJpaImpl().saveOrUpdateBarcoCubaEstado(this.barcosCubasEstados);
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		//Debo limpiar la vista
		nuevoRegistroBarcoCuba();
	}
	
	public void limpiarCajas(){
		txtNombreBarco.setValue("");
		txtNomina.setValue("");
		txtNumBarco.setValue("");
		txtPropiedad.setValue(""); 
	}
	
	public void nuevoRegistroBarcoCuba(){
		
		barco=null;
		cuba=null;
	    barcoCubas = new ArrayList<BarcoCuba>();
	    barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
		limpiarCajas();
		lbxBarco.setSelectedIndex(0);
		lbxCuba.setSelectedIndex(0);
		binder.loadAll();
	}


	public List<BarcoCubaEstado> getBarcosCubasEstados() {
		return barcosCubasEstados;
	}


	public void setBarcosCubasEstados(List<BarcoCubaEstado> barcosCubasEstados) {
		this.barcosCubasEstados = barcosCubasEstados;
	}
	

}
