package com.nw.webui.produccion;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Label;


import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;

import com.nw.model.Usuario;
import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDescargaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoEstibaCubaDAOJpaImpl;


import com.nw.temp.model.BarcoCubaEstado;
//import com.nw.temp.model.BarcoEstibaCubaEstado;
import com.nw.util.Sistema;
/**
 * 
 * @author Desarrollado por Leonardo Moya Paredes
 *
 */

public class BarcoDescargaWindow extends GenericForwardComposer {

	
	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	private Listbox lbxFechaActiva,lbxBarcoAperturado,lbxEstivaCubas,lbxBarcoCuba ;
	private Checkbox chbOrigen ;
	private Textbox txtRegistro,txtOrigen,txtFechaDescarga,txtFechaCierre ;
	private Datebox dteDesde,dteHasta;
	private Intbox ibxViaje;
	private Longbox lngOrdenFab;
	private Label sinOrigen,conOrigen; 


	
	BarcoDescarga barcoDescarga;
	BarcoDescarga actuPouchProceso = new BarcoDescarga();
	BarcoDescargaDAOJpaImpl barcoDescargaDaoIMP = new BarcoDescargaDAOJpaImpl();
	
	List<BarcoEstibaCuba> beestibacubas = new ArrayList<BarcoEstibaCuba>();
	BarcoCuba bc = new BarcoCuba();
	List<BarcoCuba> barcoCubas = new ArrayList<BarcoCuba>();
	List<BarcoCuba> barcoCubasBEC = new ArrayList<BarcoCuba>();
	Usuario usu = new Usuario();
	BarcoCuba barcoCuba;
	BarcoCubaEstado barcoCubaEstado;
	
	private List<BarcoCubaEstado> barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		comp.setVariable(comp.getId(), this, true);
		
		limpiarDatos();
//		if (dteDesde ==null ){
//			obtenerBarcos();
//		}
		
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}
	
	public void obtenerRegistro()
	{
		try {
			
			lbxBarcoAperturado.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new BarcoDescarga());
			li.setParent(lbxBarcoAperturado);
			Date desde =dteDesde.getValue();
			Date hasta =dteHasta.getValue();
			Timestamp td = new java.sql.Timestamp(desde.getTime());
			Timestamp th = new java.sql.Timestamp(hasta.getTime());
			List<BarcoDescarga> listaBacroDescarga = new BarcoDescargaDAOJpaImpl().getBarcoDescargaporFecha(td,th);
			
			for (BarcoDescarga bd : listaBacroDescarga) {
				li = new Listitem();
				li.setValue(bd);
				li.setParent(lbxBarcoAperturado);
				new Listcell(String.valueOf("("+bd.getRegistro()+") "+ bd.getBarco().getNombre()) ).setParent(li);
				li.setParent(lbxBarcoAperturado);
			}
			lbxBarcoAperturado.setSelectedIndex(0);
			
			

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void obtenerBarcos()
	{
		try {
			
			lbxBarcoAperturado.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new BarcoDescarga());
			li.setParent(lbxBarcoAperturado);
					
			List<BarcoDescarga> listaBacroDescarga = new BarcoDescargaDAOJpaImpl().getBarcosDescarga();
			
			for (BarcoDescarga bd : listaBacroDescarga) {
				li = new Listitem();
				li.setValue(bd);
				li.setParent(lbxBarcoAperturado);
				new Listcell(String.valueOf(bd.getBarco().getNombre()) ).setParent(li);
				li.setParent(lbxBarcoAperturado);
			}
			lbxBarcoAperturado.setSelectedIndex(0);
			
			

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void obtenerBarcoCuba()
	{
		try {
			
			lbxBarcoCuba.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new BarcoCuba());
			li.setParent(lbxBarcoCuba);
					
			List<BarcoCuba> listaBacroDescarga = new BarcoCubaDAOJpaImpl().getBarcoCubaporBarco(barcoDescarga.getBarco().getIdbarco());
			
			for (BarcoCuba bd : listaBacroDescarga) {
				li = new Listitem();
				li.setValue(bd);
				li.setParent(lbxBarcoCuba);
				new Listcell(String.valueOf(bd.getCuba().getNombrecuba()) ).setParent(li);
				li.setParent(lbxBarcoCuba);
			}
			lbxBarcoCuba.setSelectedIndex(0);
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void onSelect$lbxBarcoAperturado() throws InterruptedException{
		limpiarCajas();
		if (lbxBarcoAperturado.getSelectedIndex()>0) {
			barcoDescarga = new BarcoDescarga();
			barcoDescarga = (BarcoDescarga) lbxBarcoAperturado.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			if (barcoDescarga.getRegistro()!=null)
				txtRegistro.setValue(barcoDescarga.getRegistro());
			if (barcoDescarga.getIdordenfabricacion()!=null)
				lngOrdenFab.setValue(barcoDescarga.getIdordenfabricacion());
			if (barcoDescarga.getOrigen()!=null && txtOrigen!=null){				
				if(barcoDescarga.getOrigen()==1){
					txtOrigen.setValue("C/O");
				}else{
					txtOrigen.setValue("S/O");
				}
			}
			if (barcoDescarga.getViaje()!=null)
				ibxViaje.setValue(barcoDescarga.getViaje());
			if (barcoDescarga.getFechadescarga()!=null)
				//txtFechaDescarga.setValue(String.valueOf(barcoDescarga.getFechadescarga()));
				txtFechaDescarga.setValue(obtenerStringdeTime(barcoDescarga.getFechadescarga()));
			if (barcoDescarga.getFechacierre()!=null)
				txtFechaCierre.setValue(obtenerStringdeTime(barcoDescarga.getFechacierre()));
			if (chbOrigen!=null){
				if(barcoDescarga.getOrigen()==1){
					chbOrigen.setChecked(true);
					conOrigen.setVisible(true);
					sinOrigen.setVisible(false);
				}else{
					chbOrigen.setChecked(false);
					conOrigen.setVisible(false);
					sinOrigen.setVisible(true);
				}
				
			}
			
			if (dteDesde!=null ){
				obtenerBarcoCuba();
			}
			
			//TODO
			//metodos de la lista de estinbascubas
			cargarListas();
			barcosCubasEstados = getBarcosCubasEstado(barcoCubasBEC);
			binder.loadAll();
		}else{
			barcoDescarga = null;
			if (lbxBarcoCuba!=null){
				nuevoRegistroBarcoCuba();
			}
		}
	}
	
	public void cargarListas(){
		beestibacubas.clear();
		barcoCubas.clear();
		barcoCubasBEC.clear();
		barcosCubasEstados.clear();
		beestibacubas = new BarcoEstibaCubaDAOJpaImpl().getBarcoEstivaporBD(barcoDescarga.getIdbarcodescarga());
		barcoCubas = new BarcoCubaDAOJpaImpl().getBarcosCubasPorBarco(barcoDescarga.getBarco().getIdbarco());
		System.out.println("tamano de lista de cubas encontradas->" + barcoCubas.size());
		for (BarcoEstibaCuba bec : beestibacubas) {
			bc = new BarcoCubaDAOJpaImpl().getBarcoCuba(bec.getIdbarcocuba());
			barcoCubasBEC.add(bc);
		}
	}
	
	public void onClick$btnBuscar() throws InterruptedException{
		if (dteDesde!=null && dteHasta!=null){
			limpiarCajas();
			obtenerRegistro();
		}
	}
	
	
	
	public void onSelect$lbxBarcoCuba() throws InterruptedException{
		selectCuba();
	}
	
	public void onClick$btnAgregarCuba(){
		agregarCuba();
	}
	
	public void selectCuba(){
		if (lbxBarcoCuba.getSelectedIndex()>0) {
			//vaciamos el objeto cuba creando una nueva instancia 
			barcoCuba = new BarcoCuba();
		    barcoCuba = (BarcoCuba) lbxBarcoCuba.getSelectedItem().getValue();//asigno el item cuba seleccionado
		    
		}else{
			barcoCuba = null;
			 
		}
	}
	
	
	public void agregarCuba(){
		if (barcoCuba==null) {
            Sistema.mensaje("Debe escoger una cuba");
            return;
		}
		if (barcoDescarga==null) {
            Sistema.mensaje("Debe escoger un Barco");
            return;
		}

		for (BarcoCubaEstado cub : barcosCubasEstados) {
			if (cub.getBarcoCuba().getCuba().getIdcuba()==this.barcoCuba.getCuba().getIdcuba()) {
				Sistema.mensaje("la Cuba ya ha sido asignada a la lista.. ");
				return;
			}
		}
		

		BarcoEstibaCuba bec = new BarcoEstibaCuba();
		bec.setIdbarcocuba(barcoCuba.getIdbarcocuba());

		bec.setCapacidad(100);
		bec.setCardumenbrisa(50);
		bec.setCardumenplantado(0);
		bec.setEstadocombobox(1);
		bec.setZonafao(87);
		bec.setBarcoDescarga(barcoDescarga);
		
		//Valor por defecto para indicar que la cuba no esta aprobada
		bec.setEstadodescargacuba(0);
		beestibacubas.add(bec);
		
		BarcoCubaEstado bce = new BarcoCubaEstado(barcoCuba, true, false);
		
		barcosCubasEstados.add(bce);
		System.out.println("tamano de lista barcocubas-->"+barcosCubasEstados.size());
		System.out.println("tamano de lista barcocubas-->"+beestibacubas.size());
		binder.loadAll();

	}
	
	
	
	
	
	public void onChange$dteHasta() throws InterruptedException{
		validarFechas();
	}
	
	
	public void grabar()
	{	
		
		
		
//		if ((txtFechaCierre == null)||txtFechaCierre.getValue().equals("")){
//			Sistema.mensaje("No se ha ingresado la Fecha Cierre .. no puede grabar");
//			txtFechaCierre.focus();
//			return;
//		}
		
//		if ((txtFechaDescarga == null)||txtFechaDescarga.getValue().equals("")){
//			Sistema.mensaje("No se ha ingresado la Fecha Descarga .. no puede grabar");
//			txtFechaDescarga.focus();
//			return;
//		}
		
			if(chbOrigen.isChecked()==true){
				barcoDescarga.setOrigen(1);
			}else{
				barcoDescarga.setOrigen(0);
			}
			//barcoDescarga = new BarcoDescarga();
			barcoDescarga.setFechareg(new java.sql.Timestamp(new Date().getTime()));
			barcoDescarga.setRegistro(txtRegistro.getValue());
			
			barcoDescarga.setViaje(ibxViaje.getValue());
			//barcoDescarga.setFechadescarga((new Timestamp(txtFechaDescarga.getValue().getTime())));
			//barcoDescarga.setFechacierre((new Timestamp(txtFechaCierre.getValue().getTime())));
			barcoDescarga.setIdordenfabricacion((lngOrdenFab.getValue()));
			//barcoDescarga.setUsuario(usu);
			//TODO
			barcoDescargaDaoIMP.saveOrUpdate(barcoDescarga);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			//limpiarDatos();
		
		

//		limpiarDatos();	
//		
//		nuevoRegistroBarcoCuba();
		
	}
	public void limpiarCajas(){
		txtRegistro.setValue("");
		lngOrdenFab.setValue(null);
		if (txtOrigen!=null){
			txtOrigen.setValue("");
		}
		ibxViaje.setValue(null);
		txtFechaCierre.setValue("");
		txtFechaDescarga.setValue("");
		if (chbOrigen!=null){
			chbOrigen.setChecked(false);
			sinOrigen.setVisible(false);
			conOrigen.setVisible(false);
		}
	}
	void limpiarDatos()
	{
		if (lbxBarcoAperturado.getSelectedIndex()>=0){	
				lbxBarcoAperturado.setSelectedIndex(0);
			}

		if(lbxFechaActiva!=null){
			lbxFechaActiva.getItems().clear();
		}
			barcoDescarga = new BarcoDescarga();
			actuPouchProceso = new BarcoDescarga();
			
			
			
		
			limpiarCajas();
		
	}
	
	public List<BarcoCubaEstado> getBarcosCubasEstado(List<BarcoCuba> barcosCubas){
		List<BarcoCubaEstado> barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
		//asigno false en estadoCuba para indicar que vienen de la base de datos
		for (BarcoCuba bec : barcosCubas) {
			
			barcosCubasEstados.add(new BarcoCubaEstado(bec,false, false));
		}
		
		return barcosCubasEstados;
	}
	
	
	
	public void selectCubas(){
		if (lbxEstivaCubas.getSelectedIndex()>0) {
			barcoCubaEstado = new BarcoCubaEstado();
			barcoCubaEstado = (BarcoCubaEstado) lbxEstivaCubas.getSelectedItem().getValue();
		    
		}else{
			barcoCubaEstado = null;
			 
		}
	}
	
	public void onClick$btnEliminarCuba() throws InterruptedException{
		//eliminarCubaIndividual();
		eliminarCubasGrupales();
	}
	
	public void eliminarCubasGrupales() throws InterruptedException{
		
		
		if (barcosCubasEstados.isEmpty()) {
			Sistema.mensaje("No existen registros en la lista");
			return;
		}
		
		if (beestibacubas==null) {
			Sistema.mensaje("Debe escoger un barco");
			return;
		}
		
		  String msj = "Esta seguro(a) que desea eliminar los registros seleccionados ?, esta accion no podra deshacerse si se confirma";
		  
		  Integer resultado;
		  resultado = Messagebox.show( msj, "ATENCION..!!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION);
		  
		  System.out.println("resultado escogido es -->"+resultado);
			// SI = 16
			// NO = 32
			if (resultado == 16)
			{			
				int i=0;
				boolean estado=false;
				List<BarcoCubaEstado> LocbarcosCubasEstados = new ArrayList<BarcoCubaEstado>();
				LocbarcosCubasEstados.addAll(barcosCubasEstados);
				List<BarcoEstibaCuba> locbeestibacubas = new ArrayList<BarcoEstibaCuba>();
				locbeestibacubas.addAll(beestibacubas);
				for (BarcoCubaEstado bce : LocbarcosCubasEstados) {
					//System.out.println("valores estado eliminar-->"+bce.isEliminarCuba());
					//System.out.println("cuba q deberia eliminar-->"+bce.getBarcoCuba().getIdbarcocuba());
					   
					   if (bce.isEliminarCuba()) {
						   BarcoEstibaCuba locbec=new BarcoEstibaCuba();
							int res=0;
							

							for (BarcoEstibaCuba bec : locbeestibacubas) {
									locbec=locbeestibacubas.get(i);
								
								if (bec.getIdbarcocuba().equals(bce.getBarcoCuba().getIdbarcocuba())){
									res = new BarcoEstibaCubaDAOJpaImpl().delete(bec);
									
									break;
								}
							
							}
							
							if (res == 1)
							{
								Messagebox.show("No se puede Eliminar el registro => "+bce.getBarcoCuba().getCuba().getNombrecuba()+ 
							    "ya que se encuentra en uso", "Error", 
								 Messagebox.OK, Messagebox.ERROR);				
							}
							else
								{				
									Sistema.mensaje("Registro eliminado");
									beestibacubas.remove(locbec);
									barcosCubasEstados.remove(bce);
									estado=true;
								}
					}

					i++;
				}

				if (estado==false){	
					cargarListas();   
					barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
					barcosCubasEstados = getBarcosCubasEstado(this.barcoCubasBEC);
					
				   binder.loadAll();
				}
				System.out.println("tamano de lista barcocubas-->"+barcosCubasEstados.size());
				binder.loadAll();
			}		
		
		
	}
	public void onClick$btnGrabarEstibaCuba() throws InterruptedException{
		
		grabarEstibaCuba();
	}
	public void grabarEstibaCuba(){
		if (lbxBarcoAperturado.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el Barco.. no puede grabar");
			return;
		}
		if (usu==null || usu.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
			//usu.setIdusuario("aaguirre");
		}
		
		if (lbxBarcoAperturado.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el Barco.. no puede grabar");
			return;
		}
		

		if ((txtRegistro == null)||txtRegistro.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Registro.. no puede grabar");
			txtRegistro.focus();
			return;
		}
		

		if ((ibxViaje== null)||ibxViaje.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Viaje.. no puede grabar");
			ibxViaje.focus();
			return;
		}
		
		if ((lngOrdenFab== null)||lngOrdenFab.getValue().equals("")){
			Sistema.mensaje("No se ha ingresado el Orden Fababricación .. no puede grabar");
			lngOrdenFab.focus();
			return;
		}
//		if (lbxBarcoCuba.getSelectedIndex()<=0){
//			Sistema.mensaje("No se ha escogido la Cuba.. no puede grabar");
//			return;
//		}
		if (beestibacubas.isEmpty()){
			Sistema.mensaje("No se ha ingresado el Detalle de Cubas.. no puede grabar");
			return;
		}
		
		BarcoDescarga barcoDecarga = new BarcoDescarga();
		barcoDecarga = new BarcoDescargaDAOJpaImpl().consultarRegistro(txtRegistro.getValue(), barcoDescarga.getIdbarcodescarga());
		if (barcoDecarga!=null){
			Sistema.mensaje("Registro de Barco ya existe... no puede grabar");
			return;
		}
		grabar();
		new BarcoEstibaCubaDAOJpaImpl().saveOrUpdateBarcoEstivaCuba(this.beestibacubas);
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		//Debo limpiar la vista
		nuevoRegistroBarcoCuba();
	}
	
	public void nuevoRegistroBarcoCuba(){
		
		barcoCuba=new BarcoCuba();
		beestibacubas=new ArrayList<BarcoEstibaCuba>();
	    barcoCubas = new ArrayList<BarcoCuba>();
	    barcosCubasEstados = new ArrayList<BarcoCubaEstado>();
		limpiarCajas();
		lbxBarcoAperturado.setSelectedIndex(0);
		lbxBarcoCuba.getItems().clear();
		binder.loadAll();
	}
	
	public String obtenerStringdeTime(Timestamp f) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String fecha1 = df.format(f);
		return fecha1;
	}

	public void validarFechas(){
		if (dteDesde.getValue().after(dteHasta.getValue())){
			Sistema.mensaje("La fecha Desde no puede ser mayor a la fecha Hasta");
		}
	}
	
	public List<BarcoCubaEstado> getBarcosCubasEstados() {
		return barcosCubasEstados;
	}

	public void setBarcosCubasEstados(List<BarcoCubaEstado> barcosCubasEstados) {
		this.barcosCubasEstados = barcosCubasEstados;
	}
}
