package com.nw.webui.produccion;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.*;

import com.nw.model.Barco;
import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoDescargaLugar;
import com.nw.model.BarcoDescargaMedioTransporte;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.CalidadBpmDesembarco;
import com.nw.model.CalidadPcc;
import com.nw.model.CalidadSensorialMp;
import com.nw.model.Cuba;
import com.nw.model.Mercante;
import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDescargaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDescargaLugarDAOJpaImpl;
import com.nw.model.dao.impl.BarcoEstibaCubaDAOJpaImpl;
import com.nw.model.dao.impl.CalidadBpmDesembarcoDAOJpaImpl;
import com.nw.model.dao.impl.CalidadPCCDAOJpaImpl;
import com.nw.model.dao.impl.CalidadSensorialMpDAOJpaImpl;
import com.nw.model.dao.impl.MercanteDAOJpaImpl;
import com.nw.model.dao.impl.SecuenciaDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
//import com.nw.produccion.dao.*;
import com.nw.util.*;
import com.nw.webui.produccion.model.BarcoCubaListModelItemRenderer;


public class CamaraBarcoDescargaWindow extends GenericForwardComposer{	

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CamaraBarcoDescargaWindow.class);

	public AreaMarco area;
	protected Window winCamaraBarcoDes; // autowired
	protected Vbox vbxMain;
	
	private Listbox lbxCubas, lbxBarco, lbxBarcoMercante, lbxLugarDescarga, lbxRecibido;
	@SuppressWarnings("unused")
	private Textbox txtNumBarco, txtRegistro, txtNumViaje, txtOrdenFabOP, txtBarcoMercante;
	@SuppressWarnings("unused")
	private Row RwBarcoMercante;
	
	protected Toolbarbutton btnGrabar;
	
	protected List<Cuba> lrespuestasgrupo1;
	
	private Checkbox chkCoSo; 
	
	BarcoDescarga cs;
	
	public CamaraBarcoDescargaWindow() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug("--> super()");
		}
	}
	
	
	public void inicio()
	{

		area = (AreaMarco)Sessions.getCurrent().getAttribute("areaMarco");
		winCamaraBarcoDes.setWidth(area.ancho);
		vbxMain.setWidth(area.anchoInterno);
		lbxBarco.getItems().clear();
		lbxBarcoMercante.getItems().clear();
		//RwBarcoMercante.setVisible(false);
		lbxCubas.getItems().clear();
		lbxLugarDescarga.getItems().clear();
		lbxRecibido.getItems().clear();
		cargarBarcos();
		cargarMercantes();
        cargarLugarDescarga();
		cargarRecibido();
		
		lbxBarcoMercante.addEventListener("onSelect", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				lbxBarco.getItems().clear();		
				lbxCubas.getItems().clear();
				txtNumBarco.setValue("");
				txtRegistro.setValue("");
				txtNumViaje.setValue("");
				txtOrdenFabOP.setValue("");				
				chkCoSo.setChecked(true);
				cargarBarcos();
				
//				if (((BarcoDescarga)lbxBarco.getSelectedItem().getValue()).getMercante() != null)	
//				{
//					RwBarcoMercante.setVisible(true);
//					txtBarcoMercante.setValue(((BarcoDescarga)lbxBarco.getSelectedItem().getValue()).getMercante().getDescripcionmercante());
//				}
				
			}
		});
		
		
		
		
		lbxBarco.addEventListener("onSelect", new org.zkoss.zk.ui.event.EventListener(){
			public void onEvent(Event event){
				lbxCubas.getItems().clear();
				txtNumBarco.setValue("");
				txtRegistro.setValue("");
				txtNumViaje.setValue("");
				txtOrdenFabOP.setValue("");	
				chkCoSo.setChecked(true);
					if (lbxBarco.getSelectedIndex() > 0)
					{
						mostrarBarco();
						buscarcubabarco();
						
//						if (((BarcoDescarga)lbxBarco.getSelectedItem().getValue()).getMercante() != null)	
//						{
//							RwBarcoMercante.setVisible(true);
//							txtBarcoMercante.setValue(((BarcoDescarga)lbxBarco.getSelectedItem().getValue()).getMercante().getDescripcionmercante());
//						}
						
					}
				}
		});
		
		
		//buscarcubabarco();
	}
	
	public void buscarcubabarco()
	{
	
		System.out.println((((Barco)lbxBarco.getSelectedItem().getValue()).getIdbarco()).toString());		
		List<BarcoCuba> lcuba = new BarcoCubaDAOJpaImpl().getBarcosCubas((((Barco)lbxBarco.getSelectedItem().getValue()).getIdbarco()));		
		lbxCubas.setModel(new ListModelList(lcuba));
		lbxCubas.setItemRenderer(new BarcoCubaListModelItemRenderer());	
	}
	
	
	public void onCreate$winCamaraBarcoDes(Event event) throws Exception {
		inicio();
		nuevo();
		chkCoSo.setChecked(true);
	}

	public void nuevo()
	{
		txtNumBarco.setValue("");
		txtRegistro.setValue("");
		txtNumViaje.setValue("");
		txtOrdenFabOP.setValue("");
	}
	
	/**
	 * Carga los barcos de descarga mediante JPA en el listbox respectivo
	 */
	private void cargarBarcos(){
		
//		int resultado = new SecuenciaDAOJpaImpl().getSiguienteId("Calidad_PCC", "idCalidadPCC");
//		System.out.println(resultado);
		//Sistema.mensaje("ok");
		Listitem li = new Listitem();
		li.setValue(new Barco());
		li.setParent(lbxBarco);

		List <Barco> barcos = new BarcoDAOJpaImpl().getBarcos();
		for (Barco o: barcos){
			li = new Listitem();
			li.setValue(o);
			
			if(o.getBarcoPropiedad().getIdpropiedad() ==  5)
			{
				new Listcell( o.getNombre()+" (Sub Barco)").setParent(li);
			}
			else
			{
				new Listcell( o.getNombre() ).setParent(li);	
			}
			
			li.setParent(lbxBarco);
		}
		Sistema.setPosicionPrimerItem(lbxBarco);
		mostrarBarco();
	}

	
	
	private void cargarMercantes(){
		Listitem li = new Listitem();
		li.setValue(new Mercante());
		li.setParent(lbxBarcoMercante);

		List <Mercante> mercante = new MercanteDAOJpaImpl().getMercantes();
		for (Mercante o: mercante){
			li = new Listitem();
			li.setValue(o);
			new Listcell( o.getDescripcionmercante()).setParent(li);
			li.setParent(lbxBarcoMercante);
		}
		lbxBarcoMercante.setSelectedIndex(0);
	}	
	
	
	/**
	 * 31-01-2018 carga lugar de descarga crh
	 */
	public void cargarLugarDescarga(){
		Listitem li = new Listitem();
		li.setValue(new BarcoDescargaLugar());
		li.setParent(lbxLugarDescarga);
		
		List<BarcoDescargaLugar> barcoDescargaLugars = new BarcoDescargaLugarDAOJpaImpl().getBarcoDescargaAll();
		for (BarcoDescargaLugar bdl : barcoDescargaLugars) {
			li = new Listitem();
			li.setValue(bdl);
			new Listcell(bdl.getDescripcion()).setParent(li);
			li.setParent(lbxLugarDescarga);
		}
		lbxLugarDescarga.setSelectedIndex(0);
	}
	
	public void cargarRecibido(){
		Listitem li = new Listitem();
		li.setValue(new BarcoDescargaMedioTransporte());
		li.setParent(lbxRecibido);
		
		List<BarcoDescargaMedioTransporte> barcoDescargaMedioTransportes = new BarcoDescargaLugarDAOJpaImpl().getBarcoDescargaMedioTransporteAll();
		for (BarcoDescargaMedioTransporte bdl : barcoDescargaMedioTransportes) {
			li = new Listitem();
			li.setValue(bdl);
			new Listcell(bdl.getDescripcion()).setParent(li);
			li.setParent(lbxRecibido);
		}
		lbxRecibido.setSelectedIndex(0);
	}
	
	
	private void mostrarBarco() {
		lbxCubas.getItems().clear();
		if ( lbxBarco.getSelectedIndex()>0 ){
			Barco o = (Barco) lbxBarco.getSelectedItem().getValue(); 
			txtNumBarco.setValue("" + o.getNumbarco());
		}
	}

	

	private void grabar(){

	try {
		
			if (txtRegistro.getValue().isEmpty())
			{
				Sistema.mensaje("Ingrese número de registro del barco");
				txtRegistro.setFocus(true);
				return;
			}

			if (txtNumViaje.getValue().isEmpty())
			{
				Sistema.mensaje("Ingrese número de viaje");
				txtNumViaje.setFocus(true);
				return;
			}			

			if (txtOrdenFabOP.getValue().isEmpty())
			{
				Sistema.mensaje("Ingrese Orden Fab-Comp");
				txtOrdenFabOP.setFocus(true);
				return;
			}				
						
			BarcoDescarga o = new BarcoDescarga();
					
			
			Barco barc = new Barco();
			barc.setIdbarco((((Barco)lbxBarco.getSelectedItem().getValue()).getIdbarco()));
			
			o.setRegistro(txtRegistro.getValue().trim());			
			
			List<BarcoDescarga> lbd = new BarcoDescargaDAOJpaImpl().getValidarIdBarcoRegistro(barc.getIdbarco(), txtRegistro.getValue().trim());
			if(lbd.size() > 0)
			{
				Sistema.mensajeError("Barco y Número de Registro ya se encuentran registrados");
				return;
			}
			
			lbd = new BarcoDescargaDAOJpaImpl().getValidarRegistro(txtRegistro.getValue().trim());
			if(lbd.size() > 0)
			{
				Sistema.mensajeError("Número de Registro ya existe");
				return;
			}			
			
			//Tomamos el mayor ID
			Long siguienteId = new SecuenciaDAOJpaImpl().getSiguienteId("barco_descarga", "idbarcodescarga");
			o.setIdbarcodescarga(siguienteId);

			o.setBarco(barc);
			o.setFechadescarga(new java.sql.Timestamp(new Date().getTime()));

			o.setViaje(Integer.valueOf(txtNumViaje.getValue().trim()));
			o.setIdordenfabricacion(Long.valueOf(Long.parseLong(txtOrdenFabOP.getValue().trim())));
			o.setOrigen((chkCoSo.isChecked()?1:0));
			o.setEstado(1);
			
			String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
			o.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
			o.setFechareg(new java.sql.Timestamp(new Date().getTime()));			
			
			//Verificamos si es un barco mercante seleccionado para grabar el id del barco mercante
			if (lbxBarcoMercante.getSelectedIndex() > 0)
			{			
				Mercante mercante = new Mercante();
				mercante.setIdmercante((((Mercante)lbxBarcoMercante.getSelectedItem().getValue()).getIdmercante()));
				o.setMercante(mercante);
			}			
					
			BarcoDescargaLugar 			 lugardescarga   = (BarcoDescargaLugar) lbxLugarDescarga.getSelectedItem().getValue();
			o.setBarcoDescargaLugar(lugardescarga);
			BarcoDescargaMedioTransporte recibido        = (BarcoDescargaMedioTransporte) lbxRecibido.getSelectedItem().getValue();
			o.setBarcoDescargaMedioTransporte(recibido);
			
			new BarcoDescargaDAOJpaImpl().saveNative(o); //saveOrUpdate
			
			CalidadPcc cpcc = new CalidadPcc();
			Long siguienteIdpcc = new SecuenciaDAOJpaImpl().getSiguienteId("calidad_pcc", "idcalidadpcc");
			cpcc.setIdcalidadpcc(siguienteIdpcc);
			cpcc.setEstado(1);
			cpcc.setBarcoDescarga(new BarcoDescargaDAOJpaImpl().getFindBarcoDescargabyId(siguienteId));
			cpcc.setTurno(1);
			new CalidadPCCDAOJpaImpl().saveNative(cpcc); //saveOrUpdate

			CalidadBpmDesembarco cbpm = new CalidadBpmDesembarco();
			Long siguienteIdbpm = new SecuenciaDAOJpaImpl().getSiguienteId("calidad_bpm_desembarco", "idbpmdesembarco");
			cbpm.setIdbpmdesembarco(siguienteIdbpm);
			cbpm.setEstado(1);
			cbpm.setFecha(new java.sql.Timestamp(new Date().getTime()));
			cbpm.setBarcoDescarga(new BarcoDescargaDAOJpaImpl().getFindBarcoDescargabyId(siguienteId));
			new CalidadBpmDesembarcoDAOJpaImpl().saveNative(cbpm); // saveOrUpdate 
			
			CalidadSensorialMp csmp = new CalidadSensorialMp();
			Long siguienteIdsmp = new SecuenciaDAOJpaImpl().getSiguienteId("calidad_sensorial_mp", "idcalidadsensorialmp");
			csmp.setIdcalidadsensorialmp(siguienteIdsmp);
			csmp.setEstado(1);
			csmp.setBarcoDescarga(new BarcoDescargaDAOJpaImpl().getFindBarcoDescargabyId(siguienteId));
			new CalidadSensorialMpDAOJpaImpl().saveNative(csmp); // saveOrUpdate

			
			//////////////////
			//GRABAR DETALLE//
			//////////////////
			BarcoEstibaCuba bec = new BarcoEstibaCuba();
			
			for( Iterator i = lbxCubas.getSelectedItems().iterator(); i.hasNext(); ){
				List fila = new LinkedList();
				Listitem li = (Listitem)i.next();
				List dato = li.getChildren();
				//dato.get(0).toString();
				
				System.out.println(((Listcell)dato.get(0)).getLabel());
				System.out.println(((Listcell)dato.get(0)).getTooltiptext());
				
				bec.setEstadocombobox(1);
/*				bec.setIdbarcoestibacuba(Integer.valueOf(((Listcell)dato.get(0)).getTooltiptext()));*/

				BarcoCuba bc = new BarcoCuba();
				//bc.setIdbarcocuba(Integer.valueOf(((Listcell)dato.get(0)).getTooltiptext()));
				//bec.setBarcoCuba(bc);
				
				bec.setIdbarcocuba(Long.valueOf(((Listcell)dato.get(0)).getTooltiptext()));
				//bec.setBarcoCuba(bc);

				bec.setCapacidad(100);
				bec.setCardumenbrisa(50);
				bec.setCardumenplantado(0);
				bec.setZonafao(87);
				bec.setBarcoDescarga(new BarcoDescargaDAOJpaImpl().getFindBarcoDescargabyId(siguienteId));
				
				//Valor por defecto para indicar que la cuba no esta aprobada
				bec.setEstadodescargacuba(0);
				
				new BarcoEstibaCubaDAOJpaImpl().saveOrUpdate(bec);
			}
			//////////////////////
			//FIN GRABAR DETALLE//
			//////////////////////

			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			inicio();
			nuevo();
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			String message1 = e.getCause().getMessage();
			Sistema.mensaje(message+' '+message1);
			return;	
		}
		
		
		
		
		
	}
	
	public void onClick$btnGrabar(Event event) throws Exception {

			
		if (lbxBarco.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione Barco");
			lbxBarco.focus();
			return;
		}
		
		if (lbxLugarDescarga.getSelectedIndex() == 0){
			Sistema.mensaje("Seleccione un Lugar de descarga");
			lbxLugarDescarga.focus();
			return;
		}
		
		if (lbxRecibido.getSelectedIndex() == 0){
			Sistema.mensaje("Seleccione donde se Recibio");
			lbxRecibido.focus();
			return;
		}

		
		//if (lbxBarcoMercante.getSelectedIndex() == 0 && RwBarcoMercante.isVisible())
//		if (lbxBarcoMercante.getSelectedIndex() == 0)
//		{			
//			Sistema.mensaje("Seleccione Barco Mercante");
//			lbxBarcoMercante.focus();
//			return;
//		}
		

		if( lbxCubas.getItemCount() == 0)
		{
			Sistema.mensaje("No existen Cubas asociadas al barco");
			return;
		}
		
		
		grabar();
		chkCoSo.setChecked(false);
		//recorrer 
		
/*		
		for (Iterator iter = lbxCubas.getItems().iterator(); iter.hasNext(); ) {
		    
			Listitem item = (Listitem) iter.next();
		    CalidadPreguntaBpmdesembarco pregunta = (CalidadPreguntaBpmdesembarco) item.getValue();
		    
		    CalidadRespuestaPreguntaBpmdesembarcoPK pk = new CalidadRespuestaPreguntaBpmdesembarcoPK();

		    
		    pk.setIdcalidadbpmdesembarco(cs.getIdbpmdesembarco());
		    pk.setIdpreguntacalidadbpmdesembarco(pregunta.getIdpreguntabpmdesembarco());
		    //pk.setIdpreguntacalidadbpmdesembarco(idpreguntacalidadbpmdesembarco)
		    
		    CalidadRespuestaPreguntaBpmdesembarco respuesta = new CalidadRespuestaPreguntaBpmdesembarco();
		    respuesta.setId(pk);
		    
		    respuesta.setCumplimiento(item.isSelected()?1:0);
		    
		    new CalidadRespuestaPreguntaBpmDesembarcoDAOJpaImpl().saveOrUpdate(respuesta);
		    
		}
		
		
		//Sistema.mensaje("Grabo " + ((CalidadRespuestaPreguntaBpmdesembarco)lrespuestasgrupo1.get(0)).getCalidadPreguntaBpmdesembarco().getPregunta());
				
*/		
	}
	
	public void onSelect$lbxPregBPM(Event event) throws Exception {
		
		
		
		//Sistema.mensaje(((CalidadPreguntaBpmdesembarco) event.equals(obj)).getPregunta());
		
	}
	
}
