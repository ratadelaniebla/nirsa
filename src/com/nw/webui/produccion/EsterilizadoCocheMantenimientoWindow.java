package com.nw.webui.produccion;

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

import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.EsterilizadoProcesoParadaCocheDAO;
import com.nw.model.dao.impl.EsterilizadoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
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
	private Datebox dteFechaProduccion;
	private Intbox intCocheId;
	private Listbox lbxAutoClaveParada, lbxTurnoLabor, lbxTurnoProduccion, lbxCliente;
	private Label lbCodigoValor, lbSequeciaCocheValor, lbCochesClienteValor;
//	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		lbxTurnoLabor.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoLabor);
		lbxTurnoProduccion.getItems().clear();
		new HelperView().cargarTurnos(lbxTurnoProduccion);
	}
	
	public void onClick$btnConsultar () {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		final EsterilizadoProcesoParadaCoche eppc = cargaAutoClaveParadaProduccion(produccion);
		if(eppc==null)
			Sistema.mensaje("El coche "+intCocheId.getValue()+" no se encuentra asigado.");
		cargaParadasConfiguradas(eppc, produccion);
		selectTurnoLabor(eppc);
		selectTurnoProduccion(eppc);
		obtenerClientes(eppc);
		cargaCodigoVideo();
		numerodeCochesProduccion(eppc==null?null:eppc.getEsterilizadoCoche()==null?null:eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
		numerodeCochesCliente();
		
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
				cargaCodigoVideo();
				numerodeCochesProduccion((ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue());
				numerodeCochesCliente();
			}
		});
	}
	
	private void consultar () {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		final EsterilizadoProcesoParadaCoche eppc = cargaAutoClaveParadaProduccion(produccion);
		if(eppc==null)
			Sistema.mensaje("El coche"+intCocheId.getValue()+" no se encuentra asigado.");
		cargaParadasConfiguradas(eppc, produccion);
		selectTurnoLabor(eppc);
		selectTurnoProduccion(eppc);
		obtenerClientes(eppc);
		cargaCodigoVideo();
		numerodeCochesProduccion(eppc==null?null:eppc.getEsterilizadoCoche()==null?null:eppc.getEsterilizadoCoche().getProduccionDetalleOrden());
		numerodeCochesCliente();
		
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
				cargaCodigoVideo();
				numerodeCochesProduccion((ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue());
				numerodeCochesCliente();
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
			lbxTurnoLabor.setSelectedIndex(0);
			lbxTurnoProduccion.setSelectedIndex(0);
			lbxCliente.getItems().clear();
			lbCodigoValor.setValue(null);
			if (produccion==null)
				Sistema.mensaje("La produccion "+dteFechaProduccion.getValue()+" no se encuentra configurada.");
			if (intCocheId.getValue()==null)
				Sistema.mensaje("Debe ingresar el numero del coche.");
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
				
				new Listcell(String.valueOf(produccionDetalleOrden.getCliente()) ).setParent(li);
				li.setParent(lbxCliente);
			}
			Sistema.setPosicionPrimerItem(lbxCliente);
			
			ProduccionDetalleOrden produccionDetalleOrden;
			for (Listitem liCliente :(List<Listitem>)lbxCliente.getItems()) {
				if (liCliente.getValue()==null) continue;
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
			lbCodigoValor.setValue(null);
			return;
		}
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)li.getValue();
		if (pdo==null) {
			lbCodigoValor.setValue(null);
			return;
		}
		lbCodigoValor.setValue(pdo.getProducto());
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
		Integer codBarra = listaEsterilizadoCoche.isEmpty()?0:listaEsterilizadoCoche.get(0).getCodbarra();
		lbCochesClienteValor.setValue(codBarra.toString());
	}
	
	public void onClick$btnGrabar() {
		Produccion produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		grabarAsignaCocheParada(cargaAutoClaveParadaProduccion(produccion));
		consultar();
	}
	
	private void grabarAsignaCocheParada(EsterilizadoProcesoParadaCoche eppc) {
		if (lbxAutoClaveParada.getSelectedItem().getValue()==null) {
			Sistema.mensaje("Debe seleccionar el campo Autoclave - Parada");
			return;
		}
		EsterilizadoProcesoParada esterilizadoProcesoParada = (EsterilizadoProcesoParada)lbxAutoClaveParada.getSelectedItem().getValue();
		
		if (lbxCliente.getSelectedItem().getValue()==null) {
			Sistema.mensaje("Debe seleccionar el campo Cliente");
			return;
		}
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxCliente.getSelectedItem().getValue();
		
		if (lbxTurnoLabor.getSelectedItem().getValue()==null) {
			Sistema.mensaje("Debe seleccionar el campo Turno Labor");
			return;
		}
		Turno turno = (Turno)lbxTurnoLabor.getSelectedItem().getValue();
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		/*************Guarda Coche*************/
		EsterilizadoCocheDAOJpaImpl ecDAO = new EsterilizadoCocheDAOJpaImpl();
		EsterilizadoCoche esterilizadoCoche = ecDAO.getEsterilizadoCoche(intCocheId.getValue(),
				eppc.getEsterilizadoCoche().getProduccionDetalleOrden().getIdproducciondetalleorden());
		esterilizadoCoche.setProduccionDetalleOrden(pdo);
		esterilizadoCoche.setTurno(turno);
		
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
			
			Sistema.mensaje("Se asignó el coche "+lbSequeciaCocheValor.getValue()+" en la autoclave "+esterilizadoProcesoParada.getAutoclave().getDescripcion()+", parada "+esterilizadoProcesoParada.getNumparada()+"...");
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
