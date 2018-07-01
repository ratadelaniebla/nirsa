package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoControlPesoNetoCabecera;
import com.nw.model.EnvasadoDetalleProcesoCambio;
import com.nw.model.EnvasadoTamanoEnvase;
import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.EsterilizadoTipoCoche;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.EnvasadoControlPesoNetoCabeceraDAO;
import com.nw.model.dao.EnvasadoDetalleProcesoCambioDAO;
import com.nw.model.dao.EnvasadoTamanoEnvaseDAO;
import com.nw.model.dao.EsterilizadoProcesoParadaCocheDAO;
import com.nw.model.dao.EsterilizadoTipoCocheDAO;
import com.nw.model.dao.impl.EnvasadoControlPesoNetoCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosDAOJpaimpl;
import com.nw.model.dao.impl.EnvasadoTamanoEnvaseDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoTipoCocheDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;
import com.nw.webui.HelperView;

/**
 * 
 * @author Cls Mbaque
 * @version 1.0
 * @since 30/05/2018
 */
public class EsterilizadoCocheMantenimientoWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private Datebox dteFechaProduccion, dteHoraSellado1raLata;
	private Intbox intCocheId;
	private Listbox lbxAutoClaveParada, lbxTurnoLabor, lbxTurnoProduccion, lbxCliente, lbxDescripcionEvase, lbxTipoCoche, lbxMCerradora;
	private Label lbProducto, lbCodigoVideoJet, lbFechaProduccion, lbSequeciaCocheValor, lbCochesClienteValor;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Toolbarbutton btnHoraSellado1raLata;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		lbxTurnoLabor.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoLabor);
		lbxTurnoProduccion.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoProduccion);
		obtenerDescripcionEnvase();
		cargaTipoCoche();
		
		btnHoraSellado1raLata.addEventListener("onClick", new EventListener() {
			public void onEvent(Event arg0) throws Exception {
				dteHoraSellado1raLata.setValue(new Timestamp(System.currentTimeMillis()));
			}
		});
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
	
	@SuppressWarnings("unchecked")
	private void cargaDescripcionEnvase() {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		final EsterilizadoProcesoParadaCoche eppc = cargaAutoClaveParadaProduccion(produccion);
		
		EnvasadoTamanoEnvase ete;
		Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
		if (eppc==null || eppc.getEsterilizadoCoche()==null || eppc.getEsterilizadoCoche().getEnvasadoTamanoEnvase()==null)
			return;
		for (Listitem liSelect : (List<Listitem>)lbxDescripcionEvase.getItems()) {
			if (liSelect.getValue()==null) continue;
			ete = (EnvasadoTamanoEnvase)liSelect.getValue();
			if (ete.getIdenvasadotamanoenvase().equals(eppc.getEsterilizadoCoche().getEnvasadoTamanoEnvase().getIdenvasadotamanoenvase())) {
				lbxDescripcionEvase.setSelectedItem(liSelect);
				break;
			}
		}
	}
	
	public void onClick$btnConsultar () {
		consultar();
	}
	
	private void consultar () {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		final EsterilizadoProcesoParadaCoche eppc = cargaAutoClaveParadaProduccion(produccion);
		if (intCocheId.getValue()==null) {
			Sistema.mensaje("Debe ingresar el id del coche a consultar...");
			return;
		}
		if (produccion==null) {
			Sistema.mensaje("La produccion "+ dateFormat.format(dteFechaProduccion.getValue())+" no existe.");
			intCocheId.setValue(null);
			return;
		}
		if(eppc==null) { 
			Sistema.mensaje("El coche "+intCocheId.getValue()+" no se encuentra asigado.");
			intCocheId.setValue(null);
			intCocheId.setFocus(true);
			lbFechaProduccion.setValue(null);
		} else {
			lbFechaProduccion.setValue(dateFormat.format(dteFechaProduccion.getValue()));
		}
		cargaParadasConfiguradas(eppc, produccion);
		selectTurnoLabor(eppc);
		selectTurnoProduccion(eppc);
		cargaTipoCoche(eppc);
		cargaDescripcionEnvase();
		obtenerClientes(eppc);
		cargaCodigoVideo();
		numerodeCochesProduccion(eppc==null?null:eppc.getEsterilizadoCoche()==null?null:eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
		numerodeCochesCliente();
		cargaMaquinaCerradora(eppc);
		cargaHoraSelladoLata(eppc);
		
		lbxTurnoProduccion.addEventListener("onSelect", new EventListener(){
			public void onEvent(Event arg0) throws Exception {
				if (eppc==null) return;
				obtenerClientes(eppc);
				cargaCodigoVideo();
				numerodeCochesProduccion(eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
				numerodeCochesCliente();
			}
		});
		
		lbxCliente.addEventListener("onSelect", new EventListener(){
			public void onEvent(Event arg0) throws Exception {
				cargaDescripcionEnvase();
				cargaCodigoVideo();
				numerodeCochesProduccion((ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue());
				numerodeCochesCliente();
				cargaMaquinaCerradora((ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue());
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	private void cargaParadasConfiguradas(EsterilizadoProcesoParadaCoche eppc, Produccion produccion) {
		lbxAutoClaveParada.getItems().clear();
		if (eppc == null || produccion==null)
			return;
		EsterilizadoProcesoParadaDAOJpaImpl eppDAO = new EsterilizadoProcesoParadaDAOJpaImpl();
		List<EsterilizadoProcesoParada> listaEsterilizadoProcesoParada = eppDAO.getEsterilizadoProcesoParada(produccion.getIdproduccion());
		Listitem li;
		String descripcion = null;
		
		Sistema.agregarListitemEnBlanco(lbxAutoClaveParada);
		for(EsterilizadoProcesoParada epp : listaEsterilizadoProcesoParada) {
			li = new Listitem();
			li.setValue(epp);
			descripcion = epp.getAutoclave().getDescripcion() 
					+ "/"
					+ epp.getNumparada();
			li.setLabel(descripcion);
			li.setParent(lbxAutoClaveParada);
		}
		Sistema.setPosicionPrimerItem(lbxAutoClaveParada);
		EsterilizadoProcesoParada epp;
		for (Listitem liSelect : (List<Listitem>)lbxAutoClaveParada.getItems()) {
			if (liSelect.getValue()==null) continue;
			epp = (EsterilizadoProcesoParada)liSelect.getValue();
			if (epp.getIdesterilizadoprocesoparada().equals(eppc.getEsterilizadoProcesoParada().getIdesterilizadoprocesoparada())) {
				lbxAutoClaveParada.setSelectedItem(liSelect);
				break;
			}
		}
	}
	
	private EsterilizadoProcesoParadaCoche cargaAutoClaveParadaProduccion(Produccion produccion) {
		if (produccion == null || intCocheId.getValue()==null) {
			lbFechaProduccion.setValue(null);
			lbxAutoClaveParada.getItems().clear();
			lbxTurnoLabor.setSelectedIndex(0);
			lbxTurnoProduccion.setSelectedIndex(0);
			lbxCliente.getItems().clear();
			lbProducto.setValue(null);
			lbCodigoVideoJet.setValue(null);
			lbxDescripcionEvase.setSelectedIndex(0);
			lbSequeciaCocheValor.setValue(null);
			lbCochesClienteValor.setValue(null);
			lbxMCerradora.getItems().clear();
			lbxTipoCoche.setSelectedIndex(0);
			dteHoraSellado1raLata.setValue(null);
			return null;
		}
		EsterilizadoProcesoParadaCocheDAO eppcDAO = new EsterilizadoProcesoParadaCocheDAOJpaImpl();
		EsterilizadoProcesoParadaCoche  eppc = eppcDAO.obtieneCochesAsignadosProduccion(produccion.getIdproduccion(), intCocheId.getValue());
		return eppc;
	}
	
	@SuppressWarnings("unchecked")
	private void selectTurnoLabor(EsterilizadoProcesoParadaCoche eppc) {
		if (eppc==null) {
			Sistema.setPosicionPrimerItem(lbxTurnoLabor);
			return;
		}
		Turno turno;
		for (Listitem li : (List<Listitem>)lbxTurnoLabor.getItems()) {
			if (li.getValue()==null) continue;
			turno = (Turno)li.getValue();
			if (turno.getIdturno().equals(eppc.getEsterilizadoCoche().getTurno().getIdturno())) {
				lbxTurnoLabor.setSelectedItem(li);
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void selectTurnoProduccion(EsterilizadoProcesoParadaCoche eppc) {
		if (eppc==null) {
			Sistema.setPosicionPrimerItem(lbxTurnoProduccion);
			return;
		}
		Turno turno;
		for (Listitem li : (List<Listitem>)lbxTurnoProduccion.getItems()) {
			if (li.getValue()==null) continue;
			turno = (Turno)li.getValue();
			if (turno.getIdturno().equals(eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getTurno().getIdturno())) {
				lbxTurnoProduccion.setSelectedItem(li);
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void cargaTipoCoche(EsterilizadoProcesoParadaCoche eppc) {
		if (eppc==null) {
			Sistema.setPosicionPrimerItem(lbxTipoCoche);
			return;
		}
		EsterilizadoTipoCoche esterilizadoTipoCoche;
		for (Listitem li : (List<Listitem>)lbxTipoCoche.getItems()) {
			if (li.getValue()==null) continue;
			esterilizadoTipoCoche = (EsterilizadoTipoCoche)li.getValue();
			if (esterilizadoTipoCoche.getIdesterilizadotipocoche().equals(eppc.getEsterilizadoCoche().getEsterilizadoTipoCoche().getIdesterilizadotipocoche())) {
				lbxTipoCoche.setSelectedItem(li);
				break;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void obtenerClientes(EsterilizadoProcesoParadaCoche eppc){
		try {
			if (eppc==null) {
				lbxCliente.getItems().clear();
				return;
			}
			lbxCliente.getItems().clear();
			Listitem li;
			EsterilizadoProcesoParada esterilizadoProcesoParada = eppc.getEsterilizadoProcesoParada();
			if (esterilizadoProcesoParada==null) return;
			
			Produccion produccion = esterilizadoProcesoParada.getProduccion();
			if (produccion==null) return;
			
			Turno turno = (Turno)lbxTurnoProduccion.getSelectedItem().getValue();
			if (turno==null) return;
			
			EsterilizadoDAOJpaImpl	esterilizadoDAOimp	= new EsterilizadoDAOJpaImpl();
			Sistema.agregarListitemEnBlanco(lbxCliente);
			for (ProduccionDetalleOrden produccionDetalleOrden : esterilizadoDAOimp.obtenerListaClientesProduccionOrdenPedido(produccion.getIdproduccion(), turno.getIdturno())) {
				li = new Listitem();
				li.setValue(produccionDetalleOrden);
				new Listcell(produccionDetalleOrden.getOrden()+" - " +produccionDetalleOrden.getCliente()).setParent(li);
				li.setParent(lbxCliente);
			}
			Sistema.setPosicionPrimerItem(lbxCliente);
			
			ProduccionDetalleOrden produccionDetalleOrden;
			for (Listitem liCliente :(List<Listitem>)lbxCliente.getItems()) {
				if (liCliente.getValue()==null) {
					lbProducto.setValue(null);
					lbCodigoVideoJet.setValue(null);
					Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
					lbSequeciaCocheValor.setValue(null);
					lbCochesClienteValor.setValue(null);
					continue;
				}
				produccionDetalleOrden = (ProduccionDetalleOrden)liCliente.getValue();
				if (produccionDetalleOrden.getIdproducciondetalleorden().equals(eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getIdproducciondetalleorden())) {
					lbxCliente.setSelectedItem(liCliente);
					break;
				}
			}
					
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	private void cargaCodigoVideo() {
		Listitem li = lbxCliente.getSelectedItem();
		if (li==null) {
			lbProducto.setValue(null);
			lbCodigoVideoJet.setValue(null);
			lbxDescripcionEvase.setSelectedIndex(0);
			return;
		}
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)li.getValue();
		if (pdo==null) {
			lbProducto.setValue(null);
			lbCodigoVideoJet.setValue(null);
			lbxDescripcionEvase.setSelectedIndex(0);
			return;
		}
		lbProducto.setValue(pdo.getProducto());
		EnvasadoDetalleProcesoCambioDAO edpcDAO = new EnvasadoDetalleProcesoCambiosDAOJpaimpl();
		EnvasadoDetalleProcesoCambio edpc = edpcDAO.getEnvasadoDetalleProcesoCambioById(pdo.getIdproducciondetalleorden());
		
		lbCodigoVideoJet.setValue(edpc.getCodvideojet());
		cargaDescripcionEnvase();
	}
	
	private void numerodeCochesProduccion(ProduccionDetalleOrden produccionDetalleOrden){
		if (produccionDetalleOrden==null || lbxCliente.getSelectedItem()==null) {
			lbSequeciaCocheValor.setValue(null);
			return;
		}
		
		EsterilizadoDAOJpaImpl	esterilizadoDAOimp	= new EsterilizadoDAOJpaImpl();
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp.obtenerListaCochesporProduccion(produccionDetalleOrden.getProduccion().getIdproduccion());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?1:listaEsterilizadoCoche.get(0).getCodbarra()+1;
		lbSequeciaCocheValor.setValue(codBarra.toString());
	}
	
	public void numerodeCochesCliente(){
		EsterilizadoDAOJpaImpl	esterilizadoDAOimp	= new EsterilizadoDAOJpaImpl();
		Listitem li = lbxCliente.getSelectedItem();
		if (li==null) {
			lbCochesClienteValor.setValue(null);
			return;
		}
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)li.getValue();
		if (pdo==null) {
			lbCochesClienteValor.setValue(null);
			return;
		}
		
		List<EsterilizadoCoche> listaEsterilizadoCoche = esterilizadoDAOimp
				.obtenerListaCochesporProduccion(pdo.getProduccion().getIdproduccion(), pdo.getIdproducciondetalleorden());
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?0:listaEsterilizadoCoche.size();
		lbCochesClienteValor.setValue(codBarra.toString());
	}
	
	@SuppressWarnings("unchecked")
	private void cargaMaquinaCerradora(EsterilizadoProcesoParadaCoche eppc) {
		
		ProduccionDetalleOrden produccionDetalleOrden = eppc == null ? null
				: eppc.getEsterilizadoCoche() == null ? null : eppc.getEsterilizadoCoche().getProduccionDetalleOrden();

		lbxMCerradora.getItems().clear();
		if (produccionDetalleOrden==null) {
			return;
		}
		if (produccionDetalleOrden.getProduccion()==null) {
			return;
		}
		
		cargaMaquinaCerradora(produccionDetalleOrden);
		
		EnvasadoControlPesoNetoCabecera ecpnc;
		for(Listitem li: (List<Listitem>)lbxMCerradora.getItems()) {
			if (li.getValue()==null)continue;
			ecpnc = (EnvasadoControlPesoNetoCabecera)li.getValue();
			if (eppc.getEsterilizadoCoche().getMaquinaCerradora().getIdmaquinacerradora()
					.equals(ecpnc.getMaquinaCerradora().getIdmaquinacerradora()))
				lbxMCerradora.setSelectedItem(li);
		}
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
	
	private void cargaHoraSelladoLata(EsterilizadoProcesoParadaCoche eppc) {
		dteHoraSellado1raLata.setValue(eppc.getEsterilizadoCoche().getHoraselladolata());
	}
	
	public void onClick$btnGrabar() {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		if (produccion==null) {
			Sistema.mensaje("La produccion "+ dateFormat.format(dteFechaProduccion.getValue())+" no existe.");
			limpiarDatos();
			return;
		}
		grabarAsignaCocheParada(cargaAutoClaveParadaProduccion(produccion));
		consultar();
	}
	
	private void grabarAsignaCocheParada(EsterilizadoProcesoParadaCoche eppc) {
		
		if (lbxAutoClaveParada.getSelectedItem()==null) {
			Sistema.mensaje("Debe seleccionar el campo Autoclave - Parada");
			return;
		}
		EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxAutoClaveParada.getSelectedItem().getValue();
		if (esterilizadoProcesoParada==null) {
			Sistema.mensaje("Debe seleccionar el campo Autoclave - Parada");
			return;
		}
		
		if (lbxCliente.getSelectedItem().getValue()==null) {
			Sistema.mensaje("Debe seleccionar el campo Cliente");
			return;
		}
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		
		Turno turno = (Turno)lbxTurnoLabor.getSelectedItem().getValue();
		if (turno==null) {
			Sistema.mensaje("Debe seleccionar el campo Turno Labor");
			return;
		}
		
		EnvasadoTamanoEnvase ete = (EnvasadoTamanoEnvase)lbxDescripcionEvase.getSelectedItem().getValue();
		if (ete==null) {
			Sistema.mensaje("Debe seleccionar el campo Descripcion Envase");
			return;
		}
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
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
		
		/*************Guarda Coche*************/
		EsterilizadoCocheDAOJpaImpl ecDAO = new EsterilizadoCocheDAOJpaImpl();
		EsterilizadoCoche esterilizadoCoche = ecDAO.getEsterilizadoCoche(intCocheId.getValue(),
				eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getIdproducciondetalleorden());
		esterilizadoCoche.setProduccionDetalleOrden(pdo);
		esterilizadoCoche.setTurno(turno);
		esterilizadoCoche.setEnvasadoTamanoEnvase(ete);
		esterilizadoCoche.setMaquinaCerradora(ecpnc.getMaquinaCerradora());
		esterilizadoCoche.setHoraselladolata(new Timestamp(dteHoraSellado1raLata.getValue().getTime()));
		esterilizadoCoche.setEsterilizadoTipoCoche(esterilizadoTipoCoche);
		
		EsterilizadoDAOJpaImpl	esterilizadoDAOimp = new EsterilizadoDAOJpaImpl();
		esterilizadoDAOimp.guardarEsterilizadoCoche(esterilizadoCoche);
		
		/*************Guarda Asignacion Coche-Parada*************/
			eppc.setEsterilizadoProcesoParada(esterilizadoProcesoParada);
			eppc.setEsterilizadoCoche(esterilizadoCoche);
			eppc.setEstado(1);
			eppc.setUsuario(usuario);
			eppc.setTurno(turno);
//			eppc.setFechaingreso(new java.sql.Timestamp(new Date().getTime()));
			
			new EsterilizadoProcesoParadaCocheDAOJpaImpl().grabar(eppc);
			
			Sistema.mensaje("Se asignó el coche "+eppc.getEsterilizadoCoche().getCodbarra()+" en la autoclave "+esterilizadoProcesoParada.getAutoclave().getDescripcion()+", parada "+esterilizadoProcesoParada.getNumparada()+"...");
	}
	
	private void limpiarDatos() {
		intCocheId.setValue(null);
		lbxAutoClaveParada.getItems().clear();
		lbxTurnoLabor.setSelectedIndex(0);
		lbxTurnoProduccion.setSelectedIndex(0);
		lbxCliente.getItems().clear();
		lbProducto.setValue(null);
		lbCodigoVideoJet.setValue(null);
		lbCochesClienteValor.setValue(null);
		lbSequeciaCocheValor.setValue(null);
		Sistema.setPosicionPrimerItem(lbxDescripcionEvase);
		lbxMCerradora.getItems().clear();
		Sistema.setPosicionPrimerItem(lbxTipoCoche);
		dteHoraSellado1raLata.setValue(null);
	}
	
//	public void onSelect$lbxTurnoProduccion() {
//		if (eppc==null) return;
//		obtenerClientes(eppc);
//		cargaCodigoVideo();
//		numerodeCochesProduccion(eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
//		numerodeCochesCliente();
//	}
//	
//	public void onSelect$lbxCliente() {
//		cargaCodigoVideo();
//		numerodeCochesProduccion(eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
//		numerodeCochesCliente();
//	}
}
