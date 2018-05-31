package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.Autoclave;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.LimpiezaProceso;
import com.nw.model.Parametro;
import com.nw.model.Usuario;
import com.nw.model.dao.AutoClaveDAO;
import com.nw.model.dao.LimpiezaProcesoDAO;
import com.nw.model.dao.impl.AutoClaveDAOJpaImpl;
import com.nw.model.dao.impl.EsterilizadoProcesoParadaDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;

/**
 * Controlador para gestionar la parada de autoclaves
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-03-23, 27, 30, 31
 */
/**
 * 
 * @author Cls Mbaque
 * @version 2.0
 * @since 22/05/2018
 */
public class AutoclaveParadaWindow extends GenericForwardComposer {
	
	private static final String PARAMETRO_LIMIT = "1352";
	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	private Listbox lbxProduccion;
	private Listbox lbxAperturaCierre;
	private Listbox lbxAutoclave;

	private Intbox txtParada;
	
	private Checkbox cbxConfirmar;
	
	SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
		
		cargarEsterilizadosProceso();
		
	}
	
	public void onClick$btnActualizar() {
		lbxProduccion.getItems().clear();
		cargarEsterilizadosProceso();
		onSelect$lbxProduccion();
	}
	
	/**
	 * presenta la N ultimas producciones de limpieza proceso
	 */
	public void cargarEsterilizadosProceso() {
		Sistema.agregarListitemEnBlanco(lbxProduccion);
		
		Parametro parametro = new ParametroDAOJpaImpl().getParametroById(PARAMETRO_LIMIT);
		Double limit= 0.0;
		if (parametro!=null)
			limit = parametro.getValor();
		
		LimpiezaProcesoDAO lpDAO = new LimpiezaProcesoDAOJpaImpl();
		for (LimpiezaProceso limpiezaProceso: lpDAO.obtieneLimpiezaProcesoNUltimos(limit.intValue())) {
				Listitem li = new Listitem();
				li.setValue(limpiezaProceso);
				new Listcell( sdt.format(limpiezaProceso.getProduccion().getFechaproduccion())).setParent(li);
				li.setParent(lbxProduccion);
		}
		Sistema.setPosicionPrimerItem(lbxProduccion);
	}
	
	
	public void onSelect$lbxProduccion() {
		lbxAperturaCierre.setSelectedIndex(0);
		lbxAutoclave.getItems().clear();
		txtParada.setValue(null);
		cbxConfirmar.setChecked(false);
	}
	/**
	 * presenta las autoclaves configuradas en la B/D
	 */
	public void onSelect$lbxAperturaCierre() {

		lbxAutoclave.getItems().clear();
		txtParada.setValue(null);
		Sistema.agregarListitemEnBlanco(lbxAutoclave);
		
		String iAperturaCierre = (String)lbxAperturaCierre.getSelectedItem().getValue();
		
		if (iAperturaCierre==null)
			return;
		
		LimpiezaProceso lp = (LimpiezaProceso)lbxProduccion.getSelectedItem().getValue();
		
		if (lp==null)
			return;
		
		AutoClaveDAO acDAO = new AutoClaveDAOJpaImpl();
		
		if(iAperturaCierre.equals("1")) {
			for (Autoclave autoClave: (List<Autoclave>)acDAO.obtieneAutoClavesDisponibles(lp.getProduccion().getIdproduccion())) {
				Listitem li = new Listitem();
				li.setValue(autoClave);
				new Listcell( autoClave.getDescripcion()).setParent(li);
				li.setParent(lbxAutoclave);
			}
		} else if(iAperturaCierre.equals("0")){
			for (Autoclave autoClave: (List<Autoclave>)acDAO.obtieneAutoClavesOcupados(lp.getProduccion().getIdproduccion())) {
				Listitem li = new Listitem();
				li.setValue(autoClave);
				new Listcell( autoClave.getDescripcion()).setParent(li);
				li.setParent(lbxAutoclave);
			}
		}
		
		Sistema.setPosicionPrimerItem(lbxAutoclave);
	}
	
	public void onClick$btnConsultar() throws Exception {
		
		LimpiezaProceso ep = (LimpiezaProceso)lbxProduccion.getSelectedItem().getValue();
		Autoclave autoclave = (Autoclave)lbxAutoclave.getSelectedItem().getValue();
		if (ep !=null && autoclave != null){
			
			EsterilizadoProcesoParada epp = new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada(ep.getProduccion().getIdproduccion(), autoclave.getIdautoclave());

			// Apertura de parada
			if ( Sistema.parseInt((String)lbxAperturaCierre.getSelectedItem().getValue()) == 1 ){
				if (epp != null)
					Sistema.mensaje(String.format("Ya está aperturada la parada %s del autoclave %s para este proceso...", epp.getNumparada(), autoclave.getIdautoclave() ));
				else{
					Integer parada = new EsterilizadoProcesoParadaDAOJpaImpl().getSiguienteParada(ep.getProduccion().getIdproduccion(), autoclave.getIdautoclave());
					txtParada.setRawValue(parada);
				}
			}else{ // Cierre de parada
				if (epp != null)
					txtParada.setRawValue(epp.getNumparada());
				else
					Sistema.mensaje(String.format("El autoclave %s NO tiene una parada aperturada...", autoclave.getIdautoclave()));
			}
		}else
			txtParada.setRawValue("");
	}
	
	public void onSelect$lbxAutoclave() throws Exception {
		onClick$btnConsultar();
	}
	
	public void onClick$btnGrabar() throws Exception{
		if (txtParada.getText().length() == 0){
			Sistema.mensaje("NO hay una parada especificada...");
			return;
		}
		
		LimpiezaProceso ep = (LimpiezaProceso)lbxProduccion.getSelectedItem().getValue();
		Autoclave autoclave = (Autoclave)lbxAutoclave.getSelectedItem().getValue();
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		if (ep != null) {
			int accion = Sistema.parseInt((String)lbxAperturaCierre.getSelectedItem().getValue());
			if (accion == 1) {
//				int res = Messagebox.show(String.format("¿Desea aperturar el autoclave con la parada %s?", txtParada.intValue()), "Grabar parada", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
				if(!cbxConfirmar.isChecked())
					Sistema.mensaje("Debe confirmar para grabar la informacion...");
				else{
					EsterilizadoProcesoParada epp = new EsterilizadoProcesoParada();
					Integer parada = new EsterilizadoProcesoParadaDAOJpaImpl().getSiguienteParada(ep.getProduccion().getIdproduccion(), autoclave.getIdautoclave());
					epp.setNumparada(parada);
					epp.setAutoclave(autoclave);
					epp.setProduccion(ep.getProduccion());
					epp.setEstado(1);
					epp.setUsuario(usuario);
					epp.setFechareg(new Timestamp(System.currentTimeMillis()));
					new EsterilizadoProcesoParadaDAOJpaImpl().grabar(epp);
					txtParada.setRawValue("");
					Sistema.mensaje("Parada "+parada+" aperturada correctamente...");
					onSelect$lbxAperturaCierre();
					cbxConfirmar.setChecked(false);
				}
			} else {
//				int res = Messagebox.show(String.format("�Desea cerrar la parada %s del autoclave %s?", txtParada.intValue(), autoclave.getIdautoclave()), "Grabar parada", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
				if(!cbxConfirmar.isChecked())
					Sistema.mensaje("Debe confirmar para grabar la informacion...");
				else{
					EsterilizadoProcesoParada epp = new EsterilizadoProcesoParadaDAOJpaImpl().getEsterilizadoProcesoParada(ep.getProduccion().getIdproduccion(), autoclave.getIdautoclave());
					epp.setEstado(2);
					new EsterilizadoProcesoParadaDAOJpaImpl().grabar(epp);
					txtParada.setRawValue("");
					Sistema.mensaje("Parada cerrada correctamente...");
					onSelect$lbxAperturaCierre();
					cbxConfirmar.setChecked(false);
				}
			}
		}
	}
}
