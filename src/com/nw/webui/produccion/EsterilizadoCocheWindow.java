package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProceso;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;
import com.nw.webui.HelperView;

/**
 * 
 * @author Cls Mbaque
 * @version 2.0
 * @since 24/05/2018
 */
public class EsterilizadoCocheWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	/**
	 *Desarrollado Por Leonardo Moya Paredes 
	 * leofabricio.mp3@gmail.com
	 *
	 */
	
	private Listbox lbxAutoClaveParadaProduccion, lbxTurnoLabor, lbxTurno,lbxCliente;
	private Label txtCodigo, ibxIdCodigo, ibxCocheCliente;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();

	EsterilizadoDAOJpaImpl	esterilizadoDAOimp	= new EsterilizadoDAOJpaImpl();
	EsterilizadoProceso		esteProceso 		= new EsterilizadoProceso();
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargaAutoClaveParadaProduccion();
		
		lbxTurnoLabor.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoLabor);
		
		obtenerturnos();
	}
	
	public void onClick$btnAutoClaveParadaProduccion() {
		lbxTurno.setSelectedIndex(0);
		obtenerClientes();
		limpiarDatos();
		lbxAutoClaveParadaProduccion.getItems().clear();
		cargaAutoClaveParadaProduccion();
	}
	
	private void cargaAutoClaveParadaProduccion() {
		lbxAutoClaveParadaProduccion.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxAutoClaveParadaProduccion);
		Listitem li;
		String descripcion;
		
		
		for (EsterilizadoProcesoParada esterilizadoProcesoParada : new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada()) {
			li = new Listitem();
			li.setValue(esterilizadoProcesoParada);
			
			descripcion = esterilizadoProcesoParada.getAutoclave().getDescripcion() 
					+ "/"
					+ esterilizadoProcesoParada.getNumparada()
					+ " - "
					+ dateFormat.format(esterilizadoProcesoParada.getProduccion().getFechaproduccion());
			
			new Listcell(descripcion).setParent(li);
			
			li.setParent(lbxAutoClaveParadaProduccion);
		}
		Sistema.setPosicionPrimerItem(lbxAutoClaveParadaProduccion);
	}
	
	public void onSelect$lbxDiaProduccion() throws InterruptedException{
		Sistema.setPosicionPrimerItem(lbxTurno);
		lbxCliente.getItems().clear();
		txtCodigo.setValue(null);
		ibxIdCodigo.setValue(null);
		ibxCocheCliente.setValue(null);;
	}
	
	public void obtenerturnos(){
		try {
			lbxTurno.getItems().clear();
			Sistema.agregarListitemEnBlanco(lbxTurno);
			
			TurnoDAOJpaImpl	turnoDao = new TurnoDAOJpaImpl();
			
			Listitem li;
			
			for (Turno itenturno : turnoDao.getTurnos()) {
				li = new Listitem();
				li.setValue(itenturno);
				new Listcell(String.valueOf(itenturno.getNombre()) ).setParent(li);
				li.setParent(lbxTurno);
			}
			Sistema.setPosicionPrimerItem(lbxTurno);
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void onSelect$lbxTurno() throws InterruptedException{
		obtenerClientes();
	}
	
	public void obtenerClientes(){
		try {
			lbxCliente.getItems().clear();
			Listitem li;
			Sistema.agregarListitemEnBlanco(lbxCliente);
			EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxAutoClaveParadaProduccion.getSelectedItem().getValue();
			if (esterilizadoProcesoParada==null) return;
			
			Produccion produccion = esterilizadoProcesoParada.getProduccion();
			if (produccion==null) return;
			
			Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
			if (turno==null) return;
			
			for (ProduccionDetalleOrden produccionDetalleOrden : esterilizadoDAOimp.obtenerListaClientesProduccionOrdenPedido(produccion.getIdproduccion(), turno.getIdturno())) {
				li = new Listitem();
				li.setValue(produccionDetalleOrden);
				
				new Listcell(String.valueOf(produccionDetalleOrden.getCliente()) ).setParent(li);
				li.setParent(lbxCliente);
			}
			
			Sistema.setPosicionPrimerItem(lbxCliente);			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void onSelect$lbxCliente() throws InterruptedException{
		ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		if(produccionDetalleOrden==null) return;
		txtCodigo.setValue(produccionDetalleOrden.getProducto());
		cargarConsultas(produccionDetalleOrden);
		NumerodeCochesCliente(produccionDetalleOrden);
	}
	
	public void NumerodeCochesCliente(ProduccionDetalleOrden produccionDetalleOrden){
		
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?1:listaEsterilizadoCoche.get(0).getCodbarra()+1;
		ibxIdCodigo.setValue(codBarra.toString());
	}
	
	public void cargarConsultas(ProduccionDetalleOrden produccionDetalleOrden){
		
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp
				.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion()
						, produccionDetalleOrden.getIdproducciondetalleorden());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?0:listaEsterilizadoCoche.get(0).getCodbarra();
		ibxCocheCliente.setValue(codBarra.toString());
	}
	
	public void onClick$btnGrabar() throws InterruptedException{
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxAutoClaveParadaProduccion.getSelectedItem().getValue();
		if (esterilizadoProcesoParada == null){
			Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
			return;
		}
		
		ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		if (produccionDetalleOrden==null) {
			Sistema.mensaje("No se ha escogido el Cliente.. no puede grabar");
			return;
		}
		
		Turno turnoProduccion = (Turno) lbxTurno.getSelectedItem().getValue();
		if (turnoProduccion==null){
			Sistema.mensaje("No se ha escogido Turno Produccion .. no puede grabar");
			return;
		}
		
		Turno turnoLabor = (Turno) lbxTurnoLabor.getSelectedItem().getValue();
		if (turnoLabor==null){
			Sistema.mensaje("No se ha escogido Turno Labor .. no puede grabar");
			return;
		}
		
		if (lbxCliente.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el Cliente .. no puede grabar");
			return;
		}
						
		EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
		esteProceso = esterilizadoDAOimp.obtenerProcesoAperturaEsterilizado(esterilizadoProcesoParada.getProduccion().getFechaproduccion(), turnoProduccion.getIdturno());
		if (esteProceso == null){
			Sistema.mensaje("No se ha realizado la apertura para este turno .. no puede grabar");
			return;
		}
		
		EsterilizadoCoche esterilizadoCoche = grabar(produccionDetalleOrden, usuario, turnoLabor);
		if (esterilizadoCoche != null)
			grabarAsignaCocheParada(esterilizadoCoche, esterilizadoProcesoParada, turnoLabor, usuario);
		
		limpiarDatos();
		
	}
	
	public EsterilizadoCoche grabar(ProduccionDetalleOrden produccionDetalleOrden, Usuario usuario, Turno turno) {	
		try {
			EsterilizadoCoche esterilizadoCoche = new EsterilizadoCoche();
			esterilizadoCoche.setEsterilizadoProceso(esteProceso);
			esterilizadoCoche.setProduccionDetalleOrden(produccionDetalleOrden);
			esterilizadoCoche.setEstado(1);
			esterilizadoCoche.setUsuario(usuario);
			esterilizadoCoche.setFechareg(new java.sql.Timestamp(new Date().getTime()));
			esterilizadoCoche.setTurno(turno);
			esterilizadoCoche.setFechainiciollenado(new java.sql.Timestamp(new Date().getTime()));
			
			List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp
					.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion());
			Integer codBarra = listaEsterilizadoCoche.isEmpty()?0:listaEsterilizadoCoche.get(0).getCodbarra();
			esterilizadoCoche.setCodbarra(codBarra+1);
			esterilizadoCoche = esterilizadoDAOimp.guardarEsterilizadoCoche(esterilizadoCoche);
			Sistema.mensaje("TRANSACCION_GRABADA.. # COCHE ASIGNADO = " + codBarra);
			
			return esterilizadoCoche;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void grabarAsignaCocheParada(EsterilizadoCoche esterilizadoCoche, EsterilizadoProcesoParada esterilizadoProcesoParada, Turno turno, Usuario usuario) {
		
		if ( new EsterilizadoProcesoParadaCocheDAOJpaImpl()
				.isExiste(esterilizadoProcesoParada.getIdesterilizadoprocesoparada(), esterilizadoCoche.getIdesterilizadocoche()) ) {
			Sistema.mensaje("El coche ya se encuentra asignado a esta parada...");
			return;
		}else{
			EsterilizadoProcesoParadaCoche eppc = new EsterilizadoProcesoParadaCoche();
			
			eppc.setEsterilizadoProcesoParada(esterilizadoProcesoParada);
			eppc.setEsterilizadoCoche(esterilizadoCoche);
			eppc.setEstado(1);
			eppc.setUsuario(usuario);
			eppc.setTurno(turno);
			eppc.setFechaingreso(new java.sql.Timestamp(new Date().getTime()));
			
			new EsterilizadoProcesoParadaCocheDAOJpaImpl().grabar(eppc);
			
			Sistema.mensaje("Se asignó el coche "+ibxIdCodigo.getValue()+" en la autoclave "+esterilizadoProcesoParada.getAutoclave().getDescripcion()+", parada "+esterilizadoProcesoParada.getNumparada()+"...");
		}
	}
	
	void limpiarDatos() {
		lbxCliente.setSelectedIndex(0);
		esteProceso = new EsterilizadoProceso();
		txtCodigo.setValue(null);
		ibxCocheCliente.setValue(null);
		ibxIdCodigo.setValue(null);
	}
}
