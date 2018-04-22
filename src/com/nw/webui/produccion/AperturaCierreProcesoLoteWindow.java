package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EvisceradoDetalleProceso;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.EvisceradoProceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteCajonDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
/*import com.nw.model.dao.impl.UsuarioDAOJpaImpl;*/
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class AperturaCierreProcesoLoteWindow extends GenericForwardComposer {

	private Listbox lbxLote,lbxAperturaCierre, lbxFechaActiva, lbxTurnoProduccion;
	private Checkbox chbRevisado ;
	private Textbox txtDiasProduccion;
	private EvisceradoDetalleProcesoCocheDAOJpaImpl evisceradoDetalleProcesoCocheImpl = new EvisceradoDetalleProcesoCocheDAOJpaImpl();
	private ProcesoAperturaCierreDAOJpaImpl procesoAperturaCierreDAOImpl = new ProcesoAperturaCierreDAOJpaImpl();
	private EvisceradoProcesoDAOJpaImpl evisceradoProcesoImpl = new EvisceradoProcesoDAOJpaImpl();
	private EvisceradoDetalleProcesoDAOJpaImpl evisceradoDetalleProcesoImpl;	
	private ProcesoAperturaCierre procesoAperturaCierre;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private EvisceradoProceso evisceradoProceso;
	private EvisceradoDetalleProceso evisceradoDetalleProceso;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private ProduccionDetalleLote produccionDetalleLote;
	private Produccion produccion;
	private Turno turno;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		

//		cargarDatos();
		limpiarDatos();
		cargaListaFechaProduccionActiva();
		cargarTurnos();
//		cargarListaLote();
		
	}
	
	
	
	public void onSelect$lbxTurnoProduccion() {
		lbxLote.getItems().clear();
		lbxAperturaCierre.setSelectedIndex(0);
			if (lbxTurnoProduccion.getSelectedIndex() > 0) {
				// creando una nueva instancia del objeto turno paraasignarle un
				// item de la lista
				turno = new Turno();
				turno = (Turno) lbxTurnoProduccion.getSelectedItem().getValue();
				
				// System.out.println("valor nombre del item seleccionado -->"+
				// turno.getNombre());
			} else {
				turno = null;
				Sistema.mensaje("Se requiere el turno para los lotes");

			}

	}	
	
	public void cargaListaFechaProduccionActiva(){
		lbxFechaActiva.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxFechaActiva);
				
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaEviscerdo();
		
		for (Produccion bd : listaFecha) {
			li = new Listitem();
			li.setValue(bd);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
			
			new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
			li.setParent(lbxFechaActiva);
		}
		lbxFechaActiva.setSelectedIndex(0);
	}
	
	void cargarDatos() throws InterruptedException
	{
		try {

			evisceradoDetalleProcesoImpl = new EvisceradoDetalleProcesoDAOJpaImpl();
			
			procesoAperturaCierre = new ProcesoAperturaCierre();
			procesoAperturaCierre = new ProcesoAperturaCierreDAOJpaImpl().getSeleccionProcesoAperturaCierre(produccion.getIdproduccion().toString());
			
			///Sistema.getIdProduccionLimpiezaProceso();
			
			///txtDiasProduccion.setValue(procesoAperturaCierre.getFechaapertura().toString());
		
			evisceradoProceso = new EvisceradoProceso();
		    evisceradoProceso = evisceradoProcesoImpl.obtenerEvisceradoProceso(procesoAperturaCierre.getIdprocesoaperturacierre());
		    
//			
			cargarListaLote();
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}

	
	public void cargarTurnos() {
		lbxTurnoProduccion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoProduccion);

		List<Turno> turnos = new TurnoDAOJpaImpl().getTurnos();

		for (Turno tur : turnos) {
			li = new Listitem();
			li.setValue(tur);
			new Listcell(tur.getNombre()).setParent(li);
			li.setParent(lbxTurnoProduccion);
		}
		lbxTurnoProduccion.setSelectedIndex(0);

	}	
	public void cargarListaLote(){
		lbxLote.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleLote());
		li.setParent(lbxLote);


//		List <Area> area = new AreaDAOJpaImpl().getAreasDesperdicios();
//		for (Area o: area){
		//List<ProduccionDetalleLoteCajon> listaLote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelote(evisceradoProceso.getProduccion().getIdproduccion());
		
		//List<ProduccionDetalleLote> listaLote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelote(evisceradoProceso.getProduccion().getIdproduccion());
		List<ProduccionDetalleLote> listaLote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetalleloteEviscerado(produccion.getIdproduccion(), turno.getIdturno(), lbxAperturaCierre.getSelectedIndex());
		
		for (ProduccionDetalleLote bd : listaLote) {
			li = new Listitem();
			li.setValue(bd);
			EvisceradoDetalleProceso evisceradoDetalleProceso = new EvisceradoDetalleProceso();//lbxLote.getSelectedItem().getTooltiptext().toString()
			evisceradoDetalleProceso = new EvisceradoDetalleProcesoDAOJpaImpl().getEvisceradoDetalleProcesoIdidproducciondetallelotecajon(bd.getProduccionDetalleLoteCajons().get(0).getIdproducciondetallelotecajon().toString());
			try {
					li.setTooltiptext(bd.getProduccionDetalleLoteCajons().get(0).getIdproducciondetallelotecajon().toString());
					li.setId(bd.getProduccionDetalleLoteCajons().get(0).getEvisceradoDetalleProcesos().get(0).getIdevisceradodetalleproceso().toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				li.setTooltiptext("X");

			}
			if ((evisceradoDetalleProceso!=null) && evisceradoDetalleProceso.getEstado()==3){
				new Listcell(bd.getIdlote().toString()+" Reaperturado").setParent(li);
				li.setParent(lbxLote);
			}else{
				new Listcell(bd.getIdlote().toString()).setParent(li);
				li.setParent(lbxLote);
			}
			
		}
		lbxLote.setSelectedIndex(0);
	}
	
    public void onSelect$lbxFechaActiva() throws InterruptedException{
		lbxLote.getItems().clear();
		
		lbxLote.getItems().clear();
		lbxAperturaCierre.setSelectedIndex(0);
		
		if (lbxFechaActiva.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxFechaActiva.getSelectedItem().getValue();
			
			System.out.println("idproduccion-->"+ produccion.getIdproduccion());
			
			
			//Messagebox.show("el valor seleccionado es-->"+ );
		}else{
			produccion = null;
		}
    }
		
	public void onSelect$lbxLote()
	{
		if (lbxLote.getSelectedIndex()>0) {
//			produccionDetalleLoteCajon = new ProduccionDetalleLoteCajon();
//			produccionDetalleLoteCajon = (ProduccionDetalleLoteCajon) lbxLote.getSelectedItem().getValue();
			produccionDetalleLote = new ProduccionDetalleLote();
			produccionDetalleLote = (ProduccionDetalleLote) lbxLote.getSelectedItem().getValue();			
			//txtCajon.setValue(produccionDetalleLoteCajon.getCamaraCajon().getCajon().getIdcajon() );
			
			//System.out.println("valor del idcajon escogido -->"+produccionDetalleLoteCajon.getCamaraCajon().getCajon().getIdcajon());
		}else{
			//produccionDetalleLoteCajon = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una columna
			produccionDetalleLote = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una columna
		}
	}

	
	
	
	public void onSelect$lbxAperturaCierre() throws InterruptedException 
	{
		lbxLote.getItems().clear();
		if (lbxAperturaCierre.getSelectedItem().getIndex() > 0) 
		{
				cargarListaLote();			
		}
	}
	
	
//	public void onSelect$lbxAperturaCierre() throws InterruptedException 
//	{
//		try {
//			evisceradoDetalleProceso = new EvisceradoDetalleProceso();
//			evisceradoDetalleProceso = evisceradoDetalleProcesoImpl.getSeleccionEvisceradoDetalleProceso(evisceradoProceso.getProduccion().getIdproduccion(), ((ProduccionDetalleLote) lbxLote.getSelectedItem().getValue()).getIdproducciondetallelote());
//					
//			//if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) {
//			if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) {
//				
//				//if (evisceradoDetalleProceso != null) {
//				if (evisceradoDetalleProceso.getEstado() == 1) {
//					lbxAperturaCierre.setSelectedIndex(0);
//					Sistema.mensaje("Ya existe una APERTURA realizada");
//				}
//				
//			}
//			
//			if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {
//				//if (evisceradoDetalleProceso == null) {
//				if (evisceradoDetalleProceso.getEstado() == 0) {
//					lbxAperturaCierre.setSelectedIndex(0);
//					Sistema.mensaje("Ningun dato encontrado para el proceso de CIERRE");
//				}
//			}
//
//			System.out.println("El idproceso con su estado " + procesoAperturaCierre.getIdprocesoaperturacierre() + " -- " + procesoAperturaCierre.getEstado());
//
//		} catch (Exception e) {
//			System.out.println("Mensaje de error " + e.getMessage());
//
//		}
//		
//	}
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	void grabar() throws InterruptedException
	{

		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);
		 Usuario usu = new Usuario();
		usu.setIdusuario(usuario);
		
		
		//validaciones 
		if (usuario==null || usuario.equals("")) {
			//Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			usu.setIdusuario( "aaguirre");
		}
			
		if (lbxFechaActiva.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione fecha de Producción");
			return;
		}
		

		if (lbxTurnoProduccion.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione turno de Producción");
			return;
		}


		if (lbxAperturaCierre.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione acción de Apertura o Cierre");
			return;
		}

		
		if (lbxLote.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione un lote");
			return;
		}
			List<EvisceradoDetalleProceso> evdp = new EvisceradoDetalleProcesoDAOJpaImpl().getLotesAperturados(produccion.getIdproduccion(), produccionDetalleLote.getTurno().getIdturno());
		
			
		
				
		if (chbRevisado.isChecked() == true) {
			
			procesoAperturaCierre = new ProcesoAperturaCierre();
			
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 1)
			{ //Se pregunta si se seleccionó APERTURA
//				if (evisceradoDetalleProceso != null) {
//					Sistema.mensaje("Ya existe una APERTURA realizada");
//				}
//				else{
//					
//					
//					if (usuario==null || usuario.equals("")) 
//					{
//						Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
//						return;
//					}

				long lote=0;
				for (EvisceradoDetalleProceso edp : evdp) {
					
					if(edp.getIdevisceradodetalleproceso()>0)
					{
							lote=edp.getProduccionDetalleLoteCajon().getProduccionDetalleLote().getIdproducciondetallelote();
						
						 if(produccionDetalleLote.getIdproducciondetallelote()==lote)
						 {
							 Sistema.mensaje("Lote "+String.valueOf(lote)+" ya fue aperturado");
							 chbRevisado.setChecked(false);
							 lbxLote.setSelectedIndex(0);
								return;
						 }
						
					}
				}
				
				
					evisceradoDetalleProceso = new EvisceradoDetalleProceso();
					evisceradoProceso = new EvisceradoProcesoDAOJpaImpl().getEvisceradoProcesoIdProduccion(produccion.getIdproduccion().toString()); 
					
					
					
					
					evisceradoDetalleProceso.setEstado(1);
					evisceradoDetalleProceso.setEvisceradoProceso(evisceradoProceso);
					
					
					evisceradoDetalleProceso.setUsuario(usu);
					ProduccionDetalleLoteCajon produccionDetalleLoteCajon1 = new ProduccionDetalleLoteCajon();

					//new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotePrimero1(produccionDetalleLote.getIdproducciondetallelote());
					
					produccionDetalleLoteCajon1.setIdproducciondetallelotecajon(((ProduccionDetalleLote) lbxLote.getSelectedItem().getValue()).getProduccionDetalleLoteCajons().get(0).getIdproducciondetallelotecajon());
					//produccionDetalleLoteCajon = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotePrimero1(produccionDetalleLote.getIdproducciondetallelote());
					
					
					evisceradoDetalleProceso.setProduccionDetalleLoteCajon(produccionDetalleLoteCajon1);
					evisceradoDetalleProceso.setFechainicio(new java.sql.Timestamp(new Date().getTime()));
					evisceradoDetalleProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
					evisceradoDetalleProceso.setFechainiciorackeo(new java.sql.Timestamp(new Date().getTime()));					
					System.out.println("Valor de idevisceradoDetalleProceso ------> " + evisceradoDetalleProceso.getIdevisceradodetalleproceso());
					
					evisceradoDetalleProcesoImpl.guardarEvisceradoDetalleProceso(evisceradoDetalleProceso);
					
					lbxLote.getItems().clear();
					Sistema.mensaje("Lote APERTURADO correctamente");
					
				//}
			}
			
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) 
			{
				
//				if (evisceradoDetalleProceso == null) {
//					Sistema.mensaje("Ningun dato encontrado para el proceso de CIERRE");
//				}
//				else
//				{

					
					//Recuperar el evisceradoDetalleProceso por el idproducciondetallelotecajon
					evisceradoDetalleProceso = new EvisceradoDetalleProcesoDAOJpaImpl().getEvisceradoDetalleProcesoIdidproducciondetallelotecajon(lbxLote.getSelectedItem().getTooltiptext().toString());
					//evisceradoDetalleProceso = (EvisceradoDetalleProceso) lbxLote.getSelectedItem().getValue();

/*					evisceradoDetalleProceso.setUsuario(usu);*/
					evisceradoDetalleProceso.setEstado(0);
					evisceradoDetalleProceso.setFechafin(new java.sql.Timestamp(new Date().getTime()));
					
					evisceradoDetalleProcesoImpl.guardarEvisceradoDetalleProceso(evisceradoDetalleProceso);
					
					
					/*-----------ACTUALIZAR-LOS-PROMEDIOS-EN-TARA-Y-PESO----------------------*/
					
					double proTara =evisceradoDetalleProcesoCocheImpl.getPromedioSumatoriaTara();
					double proPeso = evisceradoDetalleProcesoCocheImpl.getPromedioSumatoriaPeso();
					
					System.out.println("Promedio de tara " + proTara); 
					System.out.println("Promedio de peso " + proPeso);
					
					for (EvisceradoDetalleProcesoCoche edpc : evisceradoDetalleProcesoCocheImpl.getEvisceradoTaraPesoCero()) {
						evisceradoDetalleProcesoCocheImpl = new EvisceradoDetalleProcesoCocheDAOJpaImpl();
						
						edpc.setIdevisceradodetalleprocesocoche(edpc.getIdevisceradodetalleprocesocoche());
						
						if (edpc.getTara() == 0) {
							edpc.setTara(proTara);
						}
						
						if (edpc.getPeso() == 0) {
							edpc.setPeso(proPeso);							
						}
						

						evisceradoDetalleProcesoCocheImpl.guardarEvisceradoDetalleProcesoCoche(edpc);
					}

					lbxLote.getItems().clear();
					Sistema.mensaje("Lote CERRADO correctamente");
					

				//}
			}
			
			if (lbxAperturaCierre.getSelectedItem().getIndex() == 3){
				//TODO
				//recuperamos el procceso anterior
				evisceradoDetalleProceso = new EvisceradoDetalleProcesoDAOJpaImpl().getEvisceradoDetalleProcesoIdidproducciondetallelotecajon(lbxLote.getSelectedItem().getTooltiptext().toString());
				
				evisceradoProceso = new EvisceradoProcesoDAOJpaImpl().getEvisceradoProcesoIdProduccion(produccion.getIdproduccion().toString()); 
				
				
				
				
				evisceradoDetalleProceso.setEstado(3);
				evisceradoDetalleProceso.setEvisceradoProceso(evisceradoProceso);
				
				
				evisceradoDetalleProceso.setUsuario(usu);
				ProduccionDetalleLoteCajon produccionDetalleLoteCajon1 = new ProduccionDetalleLoteCajon();

				//new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotePrimero1(produccionDetalleLote.getIdproducciondetallelote());
				
				produccionDetalleLoteCajon1.setIdproducciondetallelotecajon(((ProduccionDetalleLote) lbxLote.getSelectedItem().getValue()).getProduccionDetalleLoteCajons().get(0).getIdproducciondetallelotecajon());
				//produccionDetalleLoteCajon = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotePrimero1(produccionDetalleLote.getIdproducciondetallelote());
				
				
				evisceradoDetalleProceso.setProduccionDetalleLoteCajon(produccionDetalleLoteCajon1);
				evisceradoDetalleProceso.setFechafin(new java.sql.Timestamp(new Date().getTime()));
				
				
				System.out.println("Valor de idevisceradoDetalleProceso ------> " + evisceradoDetalleProceso.getIdevisceradodetalleproceso());
				
				evisceradoDetalleProcesoImpl.guardarEvisceradoDetalleProceso(evisceradoDetalleProceso);
				
				lbxLote.getItems().clear();
				Sistema.mensaje("Lote REAPERTURADO correctamente");
				
			}
			
			limpiarDatos();
		}
		else
			{
				Sistema.mensaje("Marque el Check de Revisado");
			}
	}
	
	
	void limpiarDatos() throws InterruptedException
	{
		lbxAperturaCierre.setSelectedIndex(0);
//		lbxLote.setSelectedIndex(0);
		//txtCajon.setValue("");
//		txtDiasProduccion.setValue("");
		chbRevisado.setChecked(false);
		
		
		
		cargarDatos();
		
		
	}
	
}
