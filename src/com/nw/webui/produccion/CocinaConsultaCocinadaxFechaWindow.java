package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.Produccion;
import com.nw.model.dao.impl.CocinaTrasladoCocheDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.temp.model.EvisceradoDetalleProcesoCocheEstado;
import com.nw.util.Sistema;

public class CocinaConsultaCocinadaxFechaWindow extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	 
	AnnotateDataBinder binder;
	
	//Objetos zul
	Listbox lbxCocina1,lbxCocina2,lbxProduccionFecha2,//lbxCocinada1 lbxCocinada2
	lbxOrigen,lbxDestino;
	Toolbarbutton btnRegresar, btnMover,btnGrabar;
	Textbox txtCocinada2,txtCocinada1;
	Datebox dteFecha;
	
	//Objetos
	Produccion produccion;
	Produccion produccionDestino;
	CocinaAperturaCierreDetalle cocinadaOrigen;
	CocinaAperturaCierreDetalle cocinadaDestino;
	
	//Listados
	List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCochesOrigenes = new ArrayList<EvisceradoDetalleProcesoCoche>();
	List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCochesDestinos = new ArrayList<EvisceradoDetalleProcesoCoche>();
	private List<EvisceradoDetalleProcesoCocheEstado>
	    evisceradoDetalleProcesoCocheEstadosOrdenOrigen = new ArrayList<EvisceradoDetalleProcesoCocheEstado>();
	
	private List<EvisceradoDetalleProcesoCocheEstado>
		evisceradoDetalleProcesoCocheEstadosOrdenDestino = new ArrayList<EvisceradoDetalleProcesoCocheEstado>();

	
	//variables
	
	Long numeroCocinaOrigen=(long) 0 ;
	Long numeroCocinaDestino=(long) 0 ;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setVariable(comp.getId(), this, true);
		
//		cargaListaFechaProduccionActivaDestino();
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}
	/****************************************************************************************/
	/**
	 * Metodos Vista
	 */
	

	public void onBlur$dteFecha() {
		// buscar la produccion en base a la fecha escogida
		
		if(dteFecha.getText()!=""){
			produccion = new Produccion();
			produccion = new ProduccionDAOJpaImpl()
					.getProduccionByFecha(new Timestamp(dteFecha.getValue()
							.getTime()));
			// consultarfechadeProduccion(new
			// Timestamp(dteFecha.getValue().getTime() ));
	
			if (produccion == null) {
				Sistema.mensaje("No existe una producción para la fecha escogida..");
				dteFecha.setValue(null);
				//lbxTurno.setSelectedIndex(0);
				return;
			}
			cargaListaCocinasPorProduccionDestino(produccion.getIdproduccion() );
		}
		
		
	}
	
	
    public void onSelect$lbxProduccionFecha2() throws InterruptedException{
    	seleccionarProduccionDestino();
	}   
	
    

    
    public void onSelect$lbxCocina2() throws InterruptedException{
    	seleccionarCocinaPorProduccionDestino();
	}   
    
    /***************************************** FIN **********************************************************************/
	/**
	 * Metodos Negocio y validaciones
	 */
	public void cargaListaFechaProduccionActivaDestino(){
		lbxProduccionFecha2.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxProduccionFecha2);
				
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaEviscerdo();
		
		for (Produccion bd : listaFecha) {
			li = new Listitem();
			li.setValue(bd);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
			new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
			li.setParent(lbxProduccionFecha2);
		}
		lbxProduccionFecha2.setSelectedIndex(0);
	}
	
	/**
	 * en base a la produccion de cargan las cocinas origen y destino 
	 */
	
	
	public void seleccionarProduccionDestino(){
		if (lbxProduccionFecha2.getSelectedIndex()>0) {
			produccionDestino = new Produccion();
			produccionDestino = (Produccion) lbxProduccionFecha2.getSelectedItem().getValue();

//			System.out.println("idproduccion-->"+ produccion.getIdproduccion());
			
			cargaListaCocinasPorProduccionDestino(produccionDestino.getIdproduccion() );
			 
		}else{
			produccionDestino = null;
			//limpiar los demas componentes
			lbxOrigen.getItems().clear();
			lbxDestino.getItems().clear();
			lbxCocina1.getItems().clear();
			lbxCocina2.getItems().clear();
			
			evisceradoDetalleProcesoCocheEstadosOrdenDestino = null;
			evisceradoDetalleProcesoCocheEstadosOrdenOrigen = null;
			cocinadaOrigen = null;
			cocinadaDestino = null;
			
		}
	}

	public void seleccionarProduccionDestino2(){
		if (lbxProduccionFecha2.getSelectedIndex()>0) {
			produccionDestino = new Produccion();
			produccionDestino = (Produccion) lbxProduccionFecha2.getSelectedItem().getValue();

//			System.out.println("idproduccion-->"+ produccion.getIdproduccion());
			
			cargaListaCocinasPorProduccionDestino(produccion.getIdproduccion() );
			 
		}else{
			produccion = null;
			//limpiar los demas componentes
			lbxOrigen.getItems().clear();
			lbxDestino.getItems().clear();
			lbxCocina1.getItems().clear();
			lbxCocina2.getItems().clear();
			
			evisceradoDetalleProcesoCocheEstadosOrdenDestino = null;
			evisceradoDetalleProcesoCocheEstadosOrdenOrigen = null;
			cocinadaOrigen = null;
			cocinadaDestino = null;
			
		}
	}
	
	
	/**
	 * -- 1.-COCINA: obtengo las cocinas en base al id de produccion(fecha) seleccionado 
		-- para mostrar las cocinas relacionadas a la misma 
		-- distinc por cocina ordenado por el id de cocina 
	 * @param idproduccion
	 */
//	public void cargaListaCocinasPorProduccionOrigen(Long idproduccion){
//		lbxCocina1.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new CocinaAperturaCierreDetalle());
//		li.setParent(lbxCocina1);
//				
//		List<CocinaAperturaCierreDetalle> listaFecha =
//				new CocinaTrasladoCocheDAOJpaImpl()
//		          .getCocinasAperturaCierreDetallePorFechaProduccion(idproduccion);
//		
//		for (CocinaAperturaCierreDetalle bd : listaFecha) {
//			li = new Listitem();
//			li.setValue(bd);
//			 
//			System.out.println("id cocinaaperturacierre --> " + bd);
////			new Listcell("No -> "+bd.getCocina().getIdcocina()+" "+ "Cocinada #:"+bd.getNumerococinada()).setParent(li);//Integer.valueOf(bd+"")+""
//			if (bd.getNumerococinadageneral()!=null){
//				new Listcell("No -> "+bd.getCocina().getIdcocina()+" "+ "(Cocinada"+bd.getNumerococinadageneral()+")").setParent(li);//Integer.valueOf(bd+"")+""
//			}else{
//				new Listcell("No -> "+bd.getCocina().getIdcocina()).setParent(li);//Integer.valueOf(bd+"")+""
//			}
//			
//			li.setParent(lbxCocina1);	
//			
//		 }
//		lbxCocina1.setSelectedIndex(0);
//	}
	
	public void cargaListaCocinasPorProduccionDestino(Long idproduccion){
		lbxCocina2.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new CocinaAperturaCierreDetalle());
		li.setParent(lbxCocina2);
				
		List<CocinaAperturaCierreDetalle> listaFecha =
				new CocinaTrasladoCocheDAOJpaImpl()
		          .getCocinasAperturaCierreDetallePorFechaProduccion1(idproduccion);
		
		
		for (CocinaAperturaCierreDetalle bd : listaFecha) {
			li = new Listitem();
			li.setValue(bd);
			 
			System.out.println("id cocinaaperturacierre destino--> " + bd);
			if (bd.getNumerococinadageneral()!=null){
				new Listcell("No -> "+bd.getCocina().getIdcocina()+" "+ "(Cocinada"+bd.getNumerococinadageneral()+")").setParent(li);//Integer.valueOf(bd+"")+""
			}else{
				new Listcell("No -> "+bd.getCocina().getIdcocina()).setParent(li);//Integer.valueOf(bd+"")+""
			}
//			new Listcell("No -> "+bd.getCocina().getIdcocina()).setParent(li); 
			li.setParent(lbxCocina2);		}
		lbxCocina2.setSelectedIndex(0);
	}
	
	
//	public void seleccionarCocinaPorProduccionOrigen(){
//
//		if (lbxCocina1.getSelectedIndex()>0) {
//			numeroCocinaOrigen = (long) 0;
//			//int numero=0;
//			 //numero= (Integer) lbxCocina1.getSelectedItem().getValue();
//			 
//			 CocinaAperturaCierreDetalle cacd = new CocinaAperturaCierreDetalle();
//			 cacd = (CocinaAperturaCierreDetalle) lbxCocina1.getSelectedItem().getValue();
//			 
//			 //numeroCocinaOrigen = (long) numero;
//			 numeroCocinaOrigen = (long) cacd.getCocina().getIdcocina();
//
//			System.out.println("idcocinaOrigen-->"+ numeroCocinaOrigen);
//			if (numeroCocinaOrigen==numeroCocinaDestino) {
//				if (numeroCocinaDestino==numeroCocinaOrigen) {
//					if(cacd.getNumerococinadageneral().equals(cocinadaDestino.getNumerococinadageneral())){
//					Sistema.mensaje("Las cocinas son iguales.. escoja una diferente");
//					lbxCocina1.setSelectedIndex(0);
//					//lbxCocinada1.getItems().clear();
//					lbxOrigen.getItems().clear();
//					return;
//					}
//				}
//			}
//			
//			//lleno la lista de detalles origen
//			seleccionarCocinadaOrigen();
//			
//			// esto ya no va
//			//cargar lo necesario en combo de cocinadas
//		    //cargaListaCocinadasPorProduccionYcocinaOrigen(produccion.getIdproduccion(), numeroCocinaOrigen);
//			 
//		}else{
//			numeroCocinaOrigen = null;
//			//lbxCocinada1.getItems().clear(); 
//			lbxOrigen.getItems().clear();
//		}
//		
//	}
	
	public void seleccionarCocinaPorProduccionDestino(){

		if (lbxCocina2.getSelectedIndex()>0) {
			numeroCocinaDestino = (long) 0;
			//int numero=0;
			 //numero= (Integer) lbxCocina1.getSelectedItem().getValue();
			 
			 CocinaAperturaCierreDetalle cacd = new CocinaAperturaCierreDetalle();
			 cacd = (CocinaAperturaCierreDetalle) lbxCocina2.getSelectedItem().getValue();
			 
			 //numeroCocinaDestino = (long) numero;
			 numeroCocinaDestino = (long) cacd.getCocina().getIdcocina();
			System.out.println("idcocinaDestino-->"+ numeroCocinaDestino);
			//if(produccion.getIdproduccion().equals(produccionDestino.getIdproduccion()) ){
			//	if (numeroCocinaDestino==numeroCocinaOrigen) 
				
					//if(cacd.getNumerococinadageneral().equals(cocinadaOrigen.getNumerococinadageneral()))								
					//lbxCocinada2.getItems().clear();
					//lbxDestino.getItems().clear();
				
					seleccionarCocinadaDestino();
				
			}
}

	
	
//	public void cargaListaCocinadasPorProduccionYcocinaOrigen(Long idproduccion, Long numerococina){
//		lbxCocinada1.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new CocinaAperturaCierreDetalle());
//		li.setParent(lbxCocinada1);
//				
//		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles =
//				new CocinaTrasladoCocheDAOJpaImpl()
//					.getCocinasAperturaCierreDetallePorProduccionCocina(idproduccion, numerococina);
//		
//		for (CocinaAperturaCierreDetalle cacd : cocinasAperturaCierreDetalles) {
//			li = new Listitem();
//			li.setValue(cacd);
//			 
//			System.out.println("numero cocinada --> " + cacd.getNumerococinada());
//			if (cacd.getEstado()==0) {
//				new Listcell("No -> "+cacd.getNumerococinada()+""+"C").setParent(li); 
//				li.setParent(lbxCocinada1);
//			}
//			if (cacd.getEstado()==1) {
//				new Listcell("No -> "+cacd.getNumerococinada()+""+"A").setParent(li); 
//				li.setParent(lbxCocinada1);
//			}
//			
//				
//		}
//		lbxCocinada1.setSelectedIndex(0);
//	}
	
//	public void cargaListaCocinadasPorProduccionYcocinaDestino(Long idproduccion, Long numerococina){
//		lbxCocinada2.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new CocinaAperturaCierreDetalle());
//		li.setParent(lbxCocinada2);
//				
//		List<CocinaAperturaCierreDetalle> cocinasAperturaCierreDetalles =
//				new CocinaTrasladoCocheDAOJpaImpl()
//					.getCocinasAperturaCierreDetallePorProduccionCocina(idproduccion, numerococina);
//		
//		for (CocinaAperturaCierreDetalle cacd : cocinasAperturaCierreDetalles) {
//			li = new Listitem();
//			li.setValue(cacd);
//			 
//			System.out.println("numero cocinada2 --> " + cacd.getNumerococinada());
//			if (cacd.getEstado()==0) {
//				new Listcell("No -> "+cacd.getNumerococinada()+""+"C").setParent(li);//Integer.valueOf(bd+"")+""
//				li.setParent(lbxCocinada2);
//			}
//			if (cacd.getEstado()==1) {
//				new Listcell("No -> "+cacd.getNumerococinada()+""+"A").setParent(li);//Integer.valueOf(bd+"")+""
//				li.setParent(lbxCocinada2);
//			};	
//		}
//		lbxCocinada2.setSelectedIndex(0);
//	}


	
	/**
	 * Seleccion de cocinadas Origen y Destino
	 */
	
	public void seleccionarCocinadaDestino(){
		if (lbxCocina2.getSelectedIndex()>0) { //anterior lbxCocinada2
			 
			cocinadaDestino = new CocinaAperturaCierreDetalle();
			cocinadaDestino = (CocinaAperturaCierreDetalle) lbxCocina2.getSelectedItem().getValue(); // anterior lbxCocinada2
			if(cocinadaDestino.getNumerococinadageneral()!=null){
				txtCocinada2.setText(cocinadaDestino.getNumerococinadageneral().toString());
			}else{
				txtCocinada2.setText(null);
			}
			System.out.println("idcocinaAperturaCierreDetalleDestino-->"+ cocinadaDestino.getIdcocinaaperturacierredetalle());
			//cargar la lista de orden Destino ...
			cargarListadoOrdenDestino(cocinadaDestino.getIdcocinaaperturacierredetalle());
			 
		}else{
			cocinadaDestino = null;
			lbxDestino.getItems().clear();
		}
	}
	
	 public void cargarListadoOrdenDestino(Long idcocinaAerturaCierre){
		 
		 evisceradoDetalleProcesoCochesDestinos = new ArrayList<EvisceradoDetalleProcesoCoche>();
		 evisceradoDetalleProcesoCochesDestinos = 
				 new CocinaTrasladoCocheDAOJpaImpl()
		 				.getEvisceradoDetalleProcesoCochePorCocina(idcocinaAerturaCierre);
		 //lleno la lista personalizada
		 evisceradoDetalleProcesoCocheEstadosOrdenDestino = new ArrayList<EvisceradoDetalleProcesoCocheEstado>();
		 evisceradoDetalleProcesoCocheEstadosOrdenDestino = getListadoCochesEstados(evisceradoDetalleProcesoCochesDestinos);
		 binder.loadAll();
		 
	 } 
	
	/**
	 * asigno estado de false a una lista derivada de la lista EvisceradoDetalleProcesoCoche
	 * con esto se que datos debo actualizar 
	 * @param evisceradoCoches
	 * @return
	 */
	public List<EvisceradoDetalleProcesoCocheEstado> getListadoCochesEstados(List<EvisceradoDetalleProcesoCoche> evisceradoCoches){
		List<EvisceradoDetalleProcesoCocheEstado> evisceradoDetalleProcesoCocheEstados = new ArrayList<EvisceradoDetalleProcesoCocheEstado>();
		//asigno false en estadoCoche para indicar que vienen de la base de datos
		int numeroregistro=0;
		for (EvisceradoDetalleProcesoCoche bc : evisceradoCoches) {
			if (bc.getIdcocheprincipal() == null){
				numeroregistro ++;
			}
			evisceradoDetalleProcesoCocheEstados.add(new EvisceradoDetalleProcesoCocheEstado(numeroregistro, bc,false, false));
		}
		
		return evisceradoDetalleProcesoCocheEstados;
	}


	/// ************* get y set *********************

	public List<EvisceradoDetalleProcesoCocheEstado> getEvisceradoDetalleProcesoCocheEstadosOrdenOrigen() {
		return evisceradoDetalleProcesoCocheEstadosOrdenOrigen;
	}

	public void setEvisceradoDetalleProcesoCocheEstadosOrdenOrigen(
			List<EvisceradoDetalleProcesoCocheEstado> evisceradoDetalleProcesoCocheEstadosOrdenOrigen) {
		this.evisceradoDetalleProcesoCocheEstadosOrdenOrigen = evisceradoDetalleProcesoCocheEstadosOrdenOrigen;
	}


	public List<EvisceradoDetalleProcesoCocheEstado> getEvisceradoDetalleProcesoCocheEstadosOrdenDestino() {
		return evisceradoDetalleProcesoCocheEstadosOrdenDestino;
	}


	public void setEvisceradoDetalleProcesoCocheEstadosOrdenDestino(
			List<EvisceradoDetalleProcesoCocheEstado> evisceradoDetalleProcesoCocheEstadosOrdenDestino) {
		this.evisceradoDetalleProcesoCocheEstadosOrdenDestino = evisceradoDetalleProcesoCocheEstadosOrdenDestino;
	}


	
}
