package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import javax.swing.DefaultListModel;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
//import org.zkoss.zul.Checkbox;
//import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EspecialidadesProducto;
//import com.nw.model.EvisceradoProceso;
//import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EspecialidadesProcesoEnlatadoDAOJpaImpl;
//import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
//import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import org.zkoss.zk.ui.Sessions;

@SuppressWarnings("serial")
public class EspecialidadesProcesoEnlatadoInicioLlenado extends GenericForwardComposer {

	private Listbox lbxDiaProduccion,lbxOP,lbxLotes,lbxTurno;
	private Textbox txtProducto ,txtnlatas,txtLote;
	private Toolbarbutton btnGrabar;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	
	EspecialidadesProcesoEnlatadoDAOJpaImpl epedao = new EspecialidadesProcesoEnlatadoDAOJpaImpl();
	EspecialidadesProceso glo_especialidadesProceso = new EspecialidadesProceso();
	ProduccionDetalleLote glo_proDetLote = new ProduccionDetalleLote();
	EspecialidadesProcesoEnlatado epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
	Produccion produccion = new Produccion();
	Turno glo_turno = new Turno();
	TurnoDAOJpaImpl turnoDao = new TurnoDAOJpaImpl();
	EspecialidadesProcesoEnlatado actualizaresprocesosenlato = new EspecialidadesProcesoEnlatado();
	
	Double idprocesoAperturaCierre;
	Date fecha;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		//limpiarDatos();
		CargarDatos();
		obtenerturnos();
		actualizaresprocesosenlato=epedao.obtenerMaxEspecialidadProcesoEnlatado();
	}
	
	void CargarDatos() throws InterruptedException
	{
		try {
			
			lbxDiaProduccion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxDiaProduccion);
					
			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl().getProducciones();
			
			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				
				li.setParent(lbxDiaProduccion);
				
			}
			lbxDiaProduccion.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void obtenerturnos() {
		try {

			lbxTurno.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Turno());
			li.setParent(lbxTurno);

			List<Turno> listaTurno = turnoDao.getTurnos();

			for (Turno itenturno : listaTurno) {
				li = new Listitem();
				li.setValue(itenturno);

				new Listcell(String.valueOf(itenturno.getNombre()))
						.setParent(li);
				li.setParent(lbxTurno);
			}
			lbxTurno.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	void CargarDatosOp() throws InterruptedException
	{
		try {
			
			lbxOP.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new EspecialidadesProceso());
			li.setParent(lbxOP);
			
			List<EspecialidadesProceso> listaEspProc = epedao.getSeleccionEspecialidadesProceso(produccion.getIdproduccion());
			
			for (EspecialidadesProceso itemEP : listaEspProc) {
				li = new Listitem();
				li.setValue(itemEP);
				new Listcell(String.valueOf(itemEP.getIdespecialidadesproceso()) ).setParent(li);
				li.setParent(lbxOP);
				
			}
			lbxOP.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	
	
	void CargarLotes() throws InterruptedException
	{
		try {
			
			lbxLotes.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new ProduccionDetalleLote());
			li.setParent(lbxLotes);
			
			List<ProduccionDetalleLote> listaProDetLote = new ProduccionDAOJpaImpl().obtenerProduccionDetalleloteEspecialidades(produccion.getIdproduccion(), glo_turno.getIdturno()); 
		
			for (ProduccionDetalleLote itemEP : listaProDetLote) {
				li = new Listitem();
				li.setValue(itemEP);
				new Listcell(String.valueOf(itemEP.getIdlote()) ).setParent(li);
				li.setParent(lbxLotes);

			}
			lbxLotes.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void onSelect$lbxDiaProduccion() throws InterruptedException 
	{
		try {
			if (lbxDiaProduccion.getSelectedIndex() > 0) {
			produccion= (Produccion) lbxDiaProduccion
					.getSelectedItem().getValue();
			if (txtnlatas!=null){
				if(actualizaresprocesosenlato.getFechainicio()==null){
					Sistema.mensaje("Debe iniciar proceso de llenado");
				}
			}
			CargarDatosOp();
			if (lbxTurno != null){
			lbxTurno.focus();
			}else{
				lbxOP.focus();
			}
			}
			else{
				limpiarDatos();
			}
		} catch (Exception e) {
			System.out.println("Mensaje de error " + e.getMessage());
		}
	}
	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			glo_turno = new Turno();
			glo_turno = (Turno) lbxTurno.getSelectedItem().getValue();// asigno
			lbxLotes.focus();
			CargarLotes();
			lbxTurno.focus();

		} else {
			glo_turno = null;
			

		}
	}
	
	public void onSelect$lbxLotes(){
		
		if (glo_especialidadesProceso!= null && produccion!= null){
			glo_proDetLote = (ProduccionDetalleLote) lbxLotes
					.getSelectedItem().getValue();
			lbxOP.focus();
		}else{
			Sistema.mensaje("Seleccione un Lote");
		}
		
	}
	public void onSelect$lbxOP(){
		txtProducto.setValue("");
		if (glo_especialidadesProceso!= null && produccion!= null){
			glo_especialidadesProceso = (EspecialidadesProceso) lbxOP
					.getSelectedItem().getValue();
			if (lbxOP.getSelectedIndex()> 0){
				txtProducto.setText(glo_especialidadesProceso.getEspecialidadesReceta().getEspecialidadesProducto().getDescripcion());
			}
			if (actualizaresprocesosenlato !=null && txtLote != null){
				txtLote.setText(String.valueOf(actualizaresprocesosenlato.getProduccionDetalleLote().getIdlote()));
				txtnlatas.focus();
			}
		}else{
			Sistema.mensaje("Seleccione un proceso");
		}
	}
	
	
	
	public void onClick$btnGrabar() throws InterruptedException{
		
		if (lbxDiaProduccion.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
			return;
		}
		if (lbxOP.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido O/P .. no puede grabar");
			return;
		}
		
		if ((txtnlatas!=null)&& txtnlatas.getValue() =="" ){
			Sistema.mensaje("No se ha llenado el numero de latas .. no puede grabar");
			return;
		}
		if (txtnlatas==null){
			
			
		if (glo_especialidadesProceso!= null && produccion!= null ){
			Turno loc_turno = new Turno();
			loc_turno.setIdturno(1);
			epecialidadesprocesosenlato.setFechainicio(new java.sql.Timestamp(new Date().getTime()));
			epecialidadesprocesosenlato.setEspecialidadesProceso(glo_especialidadesProceso);
			epecialidadesprocesosenlato.setTurno(loc_turno);
			epecialidadesprocesosenlato.setProduccionDetalleLote(glo_proDetLote);
			Usuario usu = new Usuario();
			String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
			usu.setIdusuario(usuario);
			if (usuario==null || usuario.equals("")) {
				Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
				return;
				//usu.setIdusuario("aaguirre");
			}
			epecialidadesprocesosenlato.setUsuario(usu);

			epedao.guardarActualizarEPE(epecialidadesprocesosenlato);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		}
		else{
			Sistema.mensaje("Debe finaliar proceso de llenado");
		}

		}
		if (txtnlatas!=null){	
		if(actualizaresprocesosenlato.getTotal()==null){
			
			actualizaresprocesosenlato.setFechafin(new java.sql.Timestamp(new Date().getTime()));
			actualizaresprocesosenlato.setTotal(Integer.valueOf(txtnlatas.getValue()));
			epedao.guardarActualizarEPE(actualizaresprocesosenlato);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		}
		else{
			Sistema.mensaje("Debe iniciar un proceso de llenado primero");
		}
		}
		limpiarDatos();
	}
	
	
	void limpiarDatos()
	{
		
		 txtProducto.setValue("");
		 if(txtnlatas!=null){
			 txtnlatas.setValue("");
			 txtLote.setValue("");
		 }
		 if (lbxLotes!=null){
			 lbxLotes.getItems().clear();
			 lbxTurno.setSelectedIndex(0);
		 }
		lbxOP.getItems().clear();
		lbxDiaProduccion.setSelectedIndex(0);
		//chbRevisado.isChecked() = false;
		glo_especialidadesProceso = new EspecialidadesProceso();
		epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
		produccion = new Produccion();
		
		
	}
	
}
