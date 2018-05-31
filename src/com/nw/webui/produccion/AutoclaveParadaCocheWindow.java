package com.nw.webui.produccion;

import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.Autoclave;
import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProceso;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EsterilizadoCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaCocheDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;
import com.nw.webui.HelperView;

/**
 * Controlador para gestionar los coches en la parada de autoclaves
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-04-03
 */

/**
 * 
 * @author Cls Mbaque
 * @version 2.0
 * @since 28/05/2018
 */
public class AutoclaveParadaCocheWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private Longbox txtCocheId;
	private Textbox txtCocheCliente, txtProduccion, txtCliente, txtCodigo;
	private Listbox lbxTurno, lbxAutoclave;
	private Intbox txtParada;
	private Toolbarbutton btnGrabar;
	
	private EsterilizadoCoche esterilizadoCoche;
	private EsterilizadoProceso esterilizadoProceso;
	private EsterilizadoProcesoParada esterilizadoProcesoParada;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		new HelperView().cargarTurnos(lbxTurno);
		new HelperView().cargarAutoclaves(lbxAutoclave);
		
		lbxAutoclave.addEventListener("onSelect", new EventListener(){
			public void onEvent(Event arg0) throws Exception {
				leerParada();
			}
		});
	}
	
	public void onClick$btnConsultar() throws Exception{
		buscarCoche();
	}
	
	public void onClick$btnGrabar() throws Exception{
		grabar();
	}
	
	private void limpiarCampos(){
		txtCocheCliente.setText("");
		txtProduccion.	setText("");
		txtCliente.		setText("");
		txtCodigo.		setText("");
		setEsterilizadoCoche(null);
		setEsterilizadoProceso(null);
		btnGrabar.setDisabled(true);
	}

	private void buscarCoche() {
		
		if (txtCocheId.getValue()==null)
			return;
		EsterilizadoProceso esterilizadoProceso = new EsterilizadoDAOJpaImpl().obtenerProcesoAperturaEsterilizadoAperturado();
		EsterilizadoCoche ec = new EsterilizadoCocheDAOJpaImpl().getEsterilizadoCocheByCodBarra(txtCocheId.getValue(), esterilizadoProceso.getIdesterilizadoproceso());
		if (ec != null){
			txtCocheCliente.setText(ec.getProduccionDetalleOrden().getOrden());
			txtProduccion.	setText(esterilizadoProceso.getFechareg().toString().substring(0,10));
			txtCliente.		setText(ec.getProduccionDetalleOrden().getCliente());
			txtCodigo.		setText(ec.getProduccionDetalleOrden().getItem().toString());
			txtParada.		setText("");
			
			setEsterilizadoCoche(ec);
			setEsterilizadoProceso(ec.getEsterilizadoProceso());
		}else{
			limpiarCampos();
			Sistema.mensaje("El coche no existe!");
		}
	}
	
	private void leerParada() {
		Autoclave autoclave = (Autoclave)lbxAutoclave.getSelectedItem().getValue();
		if (autoclave == null){
			Sistema.mensaje("Seleccione un autoclave...");
			return;
		}
		
		Long idproduccion = getEsterilizadoCoche().getProduccionDetalleOrden().getProduccion().getIdproduccion();
		
		EsterilizadoProcesoParada epp = new EsterilizadoProcesoParadaDAOJpaImpl().
				getEsterilizadoProcesoParada(idproduccion, autoclave.getIdautoclave());
		
		setEsterilizadoProcesoParada(epp);
		
		if (epp != null){
			txtParada.setRawValue(epp.getNumparada());
			btnGrabar.setDisabled(false);
		}else{
			btnGrabar.setDisabled(true);
			txtParada.setText("");
			Sistema.mensaje(String.format("El autoclave %s NO tiene una parada aperturada...", autoclave.getIdautoclave()));
		}
	}
	
	private void grabar() throws Exception {
		
		Turno turno = (Turno)lbxTurno.getSelectedItem().getValue();
		if (turno == null){
			Sistema.mensaje("Seleccione un turno...");
			return;
		}
		
		EsterilizadoProcesoParada epp = getEsterilizadoProcesoParada();
		EsterilizadoCoche ec = getEsterilizadoCoche();
		
		if ( new EsterilizadoProcesoParadaCocheDAOJpaImpl().isExiste(epp.getIdesterilizadoprocesoparada(), ec.getIdesterilizadocoche()) ){
			Sistema.mensaje("El coche ya se encuentra asignado a esta parada...");
			return;
		}else{
			
//			int res = Messagebox.show(String.format("Â¿Desea asignar el coche en la parada %s?", txtParada.intValue()), "Asignar coche", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
//			if(res==2)
//				Sistema.mensaje("El proceso ha sido cancelado...");
//			else{
				String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
				if (idUsuario==null) {
					Sistema.mensaje("Error. Usuario no logueado.");
					return;
				}
				Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
				
				EsterilizadoProcesoParadaCoche eppc = new EsterilizadoProcesoParadaCoche();
				
				eppc.setEsterilizadoProcesoParada(epp);
				eppc.setEsterilizadoCoche(ec);
				eppc.setEstado(1);
				eppc.setUsuario(usuario);
				eppc.setTurno(turno);
				eppc.setFechaingreso(new java.sql.Timestamp(new Date().getTime()));
				
				new EsterilizadoProcesoParadaCocheDAOJpaImpl().grabar(eppc);
				
				Sistema.mensaje("Se asignó el coche "+txtCocheId.getValue()+" en la parada "+txtParada.getValue()+"...");
				
				setEsterilizadoProcesoParada(null);
				limpiarCampos();
				limpiarObjetos();
//				Sistema.mensaje("Registro grabado correctamente...");
				
//			}
		}
	}
	
	private void limpiarObjetos(){
		Sistema.setPosicionPrimerItem(lbxTurno);
		Sistema.setPosicionPrimerItem(lbxAutoclave);
		txtParada.setText("");
	}

	public EsterilizadoCoche getEsterilizadoCoche() {
		return esterilizadoCoche;
	}

	public void setEsterilizadoCoche(EsterilizadoCoche esterilizadoCoche) {
		this.esterilizadoCoche = esterilizadoCoche;
	}

	public EsterilizadoProceso getEsterilizadoProceso() {
		return esterilizadoProceso;
	}

	public void setEsterilizadoProceso(EsterilizadoProceso esterilizadoProceso) {
		this.esterilizadoProceso = esterilizadoProceso;
	}

	public EsterilizadoProcesoParada getEsterilizadoProcesoParada() {
		return esterilizadoProcesoParada;
	}

	public void setEsterilizadoProcesoParada(
			EsterilizadoProcesoParada esterilizadoProcesoParada) {
		this.esterilizadoProcesoParada = esterilizadoProcesoParada;
	}

}

