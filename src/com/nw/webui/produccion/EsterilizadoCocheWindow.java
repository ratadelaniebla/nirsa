package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoControlPesoNetoCabecera;
import com.nw.model.EnvasadoDetalleProcesoCambio;
import com.nw.model.EnvasadoTamanoEnvase;
import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProceso;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.EsterilizadoTipoCoche;
import com.nw.model.MaquinaCerradora;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.EnvasadoControlPesoNetoCabeceraDAO;
import com.nw.model.dao.EnvasadoDetalleProcesoCambioDAO;
import com.nw.model.dao.EnvasadoTamanoEnvaseDAO;
import com.nw.model.dao.EsterilizadoTipoCocheDAO;
import com.nw.model.dao.impl.EnvasadoControlPesoNetoCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosDAOJpaimpl;
import com.nw.model.dao.impl.EnvasadoTamanoEnvaseDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoTipoCocheDAOJpaImpl;
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
	
	private Listbox lbxAutoClaveParadaProduccion, lbxTurnoLabor, lbxTurno, lbxCliente, lbxDescripcionEvase, lbxMCerradora, lbxTipoCoche;
	private Label lbProducto, lbCodigoVideoJet, lbSequeciaCoche, lbCocheCliente;
	private Datebox dteHoraSellado1raLata;
	private Toolbarbutton btnHoraSellado1raLata;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();

	EsterilizadoDAOJpaImpl	esterilizadoDAOimp	= new EsterilizadoDAOJpaImpl();
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargaAutoClaveParadaProduccion();
		
		lbxTurnoLabor.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoLabor);
		cargaTipoCoche();
		obtenerturnos();
		obtenerDescripcionEnvase();
		
		btnHoraSellado1raLata.addEventListener("onClick", new EventListener() {
			public void onEvent(Event arg0) throws Exception {
				dteHoraSellado1raLata.setValue(new Timestamp(System.currentTimeMillis()));
			}
		});
	}
	
	public void onClick$btnAutoClaveParadaProduccion() {
		Sistema.setPosicionPrimerItem(lbxTurno);
		Sistema.setPosicionPrimerItem(lbxTurnoLabor);
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
		lbProducto.setValue(null);
		lbCodigoVideoJet.setValue(null);
		lbSequeciaCoche.setValue(null);
		lbCocheCliente.setValue(null);;
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
	
	@SuppressWarnings("unchecked")
	private void obtenerDescripcionEnvase(){
		try {
			lbxDescripcionEvase.getItems().clear();
			Sistema.agregarListitemEnBlanco(lbxDescripcionEvase);
			
			EnvasadoTamanoEnvaseDAO eteDAO = new EnvasadoTamanoEnvaseDAOJpaImpl();
			
			Listitem li;
			
			for (EnvasadoTamanoEnvase ete : (List<EnvasadoTamanoEnvase>)eteDAO.getObjects(EnvasadoTamanoEnvase.class)) {
				li = new Listitem();
				li.setValue(ete);
				new Listcell(ete.getDescripcion()).setParent(li);
				li.setParent(lbxDescripcionEvase);
			}
			Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
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
				
				new Listcell(produccionDetalleOrden.getOrden()+" - "+produccionDetalleOrden.getCliente() ).setParent(li);
				li.setParent(lbxCliente);
			}
			
			Sistema.setPosicionPrimerItem(lbxCliente);			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void onSelect$lbxCliente() {
		ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		if(produccionDetalleOrden==null) {
			lbProducto.setValue(null);
			lbCodigoVideoJet.setValue(null);
			Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
			lbCocheCliente.setValue(null);
			lbSequeciaCoche.setValue(null);
			return;
		}
		lbProducto.setValue(produccionDetalleOrden.getProducto());
		EnvasadoDetalleProcesoCambioDAO edpcDAO = new EnvasadoDetalleProcesoCambiosDAOJpaimpl();
		EnvasadoDetalleProcesoCambio edpc = edpcDAO.getEnvasadoDetalleProcesoCambioById(produccionDetalleOrden.getIdproducciondetalleorden());
		lbCodigoVideoJet.setValue(edpc.getCodvideojet());
		cargarConsultas(produccionDetalleOrden);
		NumerodeCochesCliente(produccionDetalleOrden);
		cargaMaquinaCerradora(produccionDetalleOrden);
	}
	
	private void NumerodeCochesCliente(ProduccionDetalleOrden produccionDetalleOrden){
		
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?1:listaEsterilizadoCoche.get(0).getCodbarra()+1;
		lbSequeciaCoche.setValue(codBarra.toString());
	}
	
	private void cargarConsultas(ProduccionDetalleOrden produccionDetalleOrden){
		
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp
				.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion()
						, produccionDetalleOrden.getIdproducciondetalleorden());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?0:listaEsterilizadoCoche.size();
		lbCocheCliente.setValue(codBarra.toString());
	}
	
	private void cargaMaquinaCerradora(ProduccionDetalleOrden produccionDetalleOrden) {
		
		lbxMCerradora.getItems().clear();
		if (produccionDetalleOrden==null) {
			return;
		}
		if (produccionDetalleOrden.getProduccion()==null) {
			return;
		}
		
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		List<EnvasadoControlPesoNetoCabecera> ecpncLISTA = ecpncDAO.getByOrdenProduccion(produccionDetalleOrden.getProduccion().getIdproduccion());
		
		Sistema.agregarListitemEnBlanco(lbxMCerradora);
		Sistema.setPosicionPrimerItem(lbxMCerradora);
		Listitem li;
		for(EnvasadoControlPesoNetoCabecera ecpnc: ecpncLISTA) {
			li = new Listitem();
			li.setValue(ecpnc);
			li.setLabel(ecpnc.getMaquinaCerradora().getDescripcion());
			li.setParent(lbxMCerradora);
		}
		
	}
	
	private void cargaTipoCoche() {
		
		lbxTipoCoche.getItems().clear();
		
		EsterilizadoTipoCocheDAO etcDAO = new EsterilizadoTipoCocheDAOJpaImpl();
		@SuppressWarnings("unchecked")
		List<EsterilizadoTipoCoche> etcLISTA = etcDAO.getObjects(EsterilizadoTipoCoche.class);
		
		Sistema.agregarListitemEnBlanco(lbxTipoCoche);
		Sistema.setPosicionPrimerItem(lbxTipoCoche);
		Listitem li;
		for(EsterilizadoTipoCoche etc: etcLISTA) {
			li = new Listitem();
			li.setValue(etc);
			li.setLabel(etc.getDescripcion());
			li.setParent(lbxTipoCoche);
		}
		
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
		
		Turno turnoLabor = (Turno) lbxTurnoLabor.getSelectedItem().getValue();
		if (turnoLabor==null){
			Sistema.mensaje("No se ha escogido Turno Labor .. no puede grabar");
			return;
		}
		
		Turno turnoProduccion = (Turno) lbxTurno.getSelectedItem().getValue();
		if (turnoProduccion==null){
			Sistema.mensaje("No se ha escogido Turno Produccion .. no puede grabar");
			return;
		}
		
		ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		if (produccionDetalleOrden==null) {
			Sistema.mensaje("No se ha escogido el Cliente.. no puede grabar");
			return;
		}
		
		if (lbxCliente.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el Cliente .. no puede grabar");
			return;
		}

		EnvasadoTamanoEnvase envasadoTamanoEnvase = (EnvasadoTamanoEnvase)lbxDescripcionEvase.getSelectedItem().getValue();
		if (envasadoTamanoEnvase==null) {
			Sistema.mensaje("No se ha escogido una descripcion envase.. no puede grabar");
			return;
		}
		
		EnvasadoControlPesoNetoCabecera ecpnc = (EnvasadoControlPesoNetoCabecera) lbxMCerradora.getSelectedItem().getValue();
		if (ecpnc==null) {
			Sistema.mensaje("No se ha escogido Maquina Cerradora .. no puede grabar");
			return;
		}

		EsterilizadoTipoCoche esterilizadoTipoCoche = (EsterilizadoTipoCoche)lbxTipoCoche.getSelectedItem().getValue();
		if(esterilizadoTipoCoche==null) {
			Sistema.mensaje("No se ha escogido Tipo Coche .. no puede grabar");
			return;
		}
		
		if(dteHoraSellado1raLata==null){
			Sistema.mensaje("No se ha escogido Hora Sellado 1ra Lata (*) .. no puede grabar");
			return;
		}
		
		EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
		EsterilizadoProceso esterilizadoProceso = esterilizadoDAOimp.obtenerProcesoAperturaEsterilizado(esterilizadoProcesoParada.getProduccion().getFechaproduccion(), turnoProduccion.getIdturno());
		if (esterilizadoProceso == null){
			Sistema.mensaje("No se ha realizado la apertura para este turno .. no puede grabar");
			return;
		}
		
		EsterilizadoCoche esterilizadoCoche = grabar(produccionDetalleOrden,
				envasadoTamanoEnvase, 
				usuario, 
				turnoLabor, 
				ecpnc.getMaquinaCerradora(),
				dteHoraSellado1raLata.getValue(),
				esterilizadoTipoCoche,
				esterilizadoProceso);
		if (esterilizadoCoche != null)
			grabarAsignaCocheParada(esterilizadoCoche, esterilizadoProcesoParada, turnoLabor, usuario);
		
		limpiarDatos();
		
	}
	
	/**
	 * 
	 * @param produccionDetalleOrden
	 * @param envasadoTamanoEnvase
	 * @param usuario
	 * @param turno
	 * @param maquinaCerradora
	 * @param HoraSelladoLata
	 * @param esterilizadoTipoCoche
	 * @param esterilizadoProceso
	 * @return
	 */
	public EsterilizadoCoche grabar(Object... object) {	
		try {
			ProduccionDetalleOrden produccionDetalleOrden  = (ProduccionDetalleOrden)object[0];
			EnvasadoTamanoEnvase envasadoTamanoEnvase = (EnvasadoTamanoEnvase)object[1];
			Usuario usuario = (Usuario)object[2];
			Turno turno = (Turno)object[3];
			MaquinaCerradora maquinaCerradora = (MaquinaCerradora)object[4];
			Date horaSellado1raLata = (Date) object[5];
			EsterilizadoTipoCoche esterilizadoTipoCoche = (EsterilizadoTipoCoche) object[6];
			EsterilizadoProceso esterilizadoProceso = (EsterilizadoProceso) object[7];
			
			EsterilizadoCoche esterilizadoCoche = new EsterilizadoCoche();
			esterilizadoCoche.setEsterilizadoProceso(esterilizadoProceso);
			esterilizadoCoche.setProduccionDetalleOrden(produccionDetalleOrden);
			esterilizadoCoche.setEstado(1);
			esterilizadoCoche.setUsuario(usuario);
			esterilizadoCoche.setFechareg(new java.sql.Timestamp(new Date().getTime()));
			esterilizadoCoche.setTurno(turno);
			esterilizadoCoche.setFechainiciollenado(new java.sql.Timestamp(new Date().getTime()));
			esterilizadoCoche.setEnvasadoTamanoEnvase(envasadoTamanoEnvase);
			esterilizadoCoche.setMaquinaCerradora(maquinaCerradora);
			esterilizadoCoche.setHoraselladolata(new Timestamp(horaSellado1raLata.getTime()));
			esterilizadoCoche.setEsterilizadoTipoCoche(esterilizadoTipoCoche);
			
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
			
			Sistema.mensaje("Se asignó el coche "+lbSequeciaCoche.getValue()+" en la autoclave "+esterilizadoProcesoParada.getAutoclave().getDescripcion()+", parada "+esterilizadoProcesoParada.getNumparada()+"...");
		}
	}
	
	private void limpiarDatos() {
//		lbxCliente.setSelectedIndex(0);
		onSelect$lbxCliente();
//		lbProducto.setValue(null);
//		lbCodigoVideoJet.setValue(null);
//		lbCocheCliente.setValue(null);
//		lbSequeciaCoche.setValue(null);
		Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
//		lbxMCerradora.getItems().clear();
//		Sistema.setPosicionPrimerItem(lbxTipoCoche);
		dteHoraSellado1raLata.setValue(null);
	}
}
