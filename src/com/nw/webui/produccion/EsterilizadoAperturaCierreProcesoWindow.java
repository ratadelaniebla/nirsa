package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.nw.model.EsterilizadoProceso;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EsterilizadoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;
import com.nw.webui.HelperView;


/**
 * 
 * @author Cls MBaque
 * @version 2.0 cambio de logica para poder ingresar aperturar procesos desde la
 *          fecha de registro.
 */
public class EsterilizadoAperturaCierreProcesoWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	/**
	 *Desarrollado Por Leonardo Moya Paredes 
	 * leofabricio.mp3@gmail.com
	 *
	 */
	private Label	lbFechaProduccion;
	private Datebox dteFechaProduccion;
	
	private Label	lbTurno,  lbAperturaCierre;
	private Listbox lbxTurno, lbxAperturaCierre, lbxFechaProduccion;
	
	private Checkbox chbRevisado ;
	
	private Grid gdApertura, gdCierre, gdTurno; 
	
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		new HelperView().cargarTurnos(lbxTurno);
	}
	
	public void onSelect$lbxAperturaCierre() {
		int iAperturaCierre = lbxAperturaCierre.getSelectedIndex();
		
		lbxFechaProduccion.getItems().clear();
		dteFechaProduccion.setValue(null);
		switch (iAperturaCierre) {
		case 1:
			gdApertura.setVisible(true);
			gdCierre.setVisible(false);
			gdTurno.setVisible(true);
			break;
		case 2:
			gdApertura.setVisible(false);
			gdCierre.setVisible(true);
			gdTurno.setVisible(false);
			cargarEsterilizadoProcesos();
			break;
		default:
			gdApertura.setVisible(false);
			gdCierre.setVisible(false);
			gdTurno.setVisible(false);
			lbxFechaProduccion.getItems().clear();
			break;
		}
	}
	
	public void onChange$dteFechaProduccion() {
		lbxTurno.setSelectedIndex(0);
	}
	
	/**
	 * carga los procesos aperturados
	 */
	private EsterilizadoProceso cargarEsterilizadoProceso(Date fecha, Integer idTurno) {
		try {
			EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
			return esterilizadoDAOimp.obtenerProcesoAperturaEsterilizado(fecha, idTurno);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	/**
	 * carga el proceso aperturados
	 */
	private EsterilizadoProceso obtenerProcesoAperturaEsterilizadoAperturado() {
		try {
			EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
			return esterilizadoDAOimp.obtenerProcesoAperturaEsterilizadoAperturado();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new EsterilizadoProceso();
		}
	}
	
	/**
	 * carga los procesos cerrados
	 */
	private void cargarEsterilizadoProcesos() {
		try {
			EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
			List<EsterilizadoProceso> listaEP = esterilizadoDAOimp.obtenerProcesoAperturaEsterilizados(1);
			
			Sistema.agregarListitemEnBlanco(lbxFechaProduccion);
			for (EsterilizadoProceso t: listaEP){
				Listitem li = new Listitem();
				li.setValue(t);
				new Listcell( formato.format(t.getFechareg()) +" - "+ t.getTurno().getNombre()).setParent(li);
				li.setParent(lbxFechaProduccion);
			}
			Sistema.setPosicionPrimerItem(lbxFechaProduccion);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private boolean validaCampos() {
		List<Object> listaEtiquetas = new ArrayList<Object>();
		List<Object> camposNumericos = new ArrayList<Object>();
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbAperturaCierre);
		listaEtiquetas.add(lbxAperturaCierre);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbFechaProduccion);
		if (lbxAperturaCierre.getSelectedIndex()==1) {
			listaEtiquetas.add(dteFechaProduccion);
			
			listaEtiquetas = new ArrayList<Object>(); 
			listaEtiquetas.add(lbTurno);
			listaEtiquetas.add(lbxTurno);
			camposNumericos.add(listaEtiquetas);
			
		} else if (lbxAperturaCierre.getSelectedIndex()==2) {
			listaEtiquetas.add(lbxFechaProduccion);
		}
		camposNumericos.add(listaEtiquetas);
		
		Label etiqueta;
		for (Object object : camposNumericos) {
			@SuppressWarnings("unchecked")
			List<Object> valores = (List<Object>) object;
			etiqueta = (Label) valores.get(0);
			if (valores.get(1) instanceof Listbox) {
				if(!validaCamposLista(etiqueta, (Listbox) valores.get(1)))
					return false;
			} else if (valores.get(1) instanceof Datebox) {
				if(!validaCamposFecha(etiqueta, (Datebox) valores.get(1)))
					return false;
			}
		}
		return true;
	}
	
	public void onClick$btnGrabar() throws InterruptedException{
	
		if(!validaCampos())
			return;
		
		if (!chbRevisado.isChecked()) {
			Sistema.mensaje("Debe confirmar para grabar la informacion...");
			return;
		}
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		Usuario usuario = new UsuarioDAOJpaImpl().getUser(idUsuario);
		
		EsterilizadoDAOJpaImpl esterilizadoDAOimp = new EsterilizadoDAOJpaImpl(); 
		
		ProcesoAperturaCierreDAOJpaImpl procesoAperturaCierreDAOImpl = new ProcesoAperturaCierreDAOJpaImpl();
		
		Proceso proceso = new ProcesoDAOJpaImpl().getProcesoById(6);
		
		Turno turno = (Turno) lbxTurno.getSelectedItem().getValue();
		
		EsterilizadoProceso esterilizadoProceso;
		
		if (lbxAperturaCierre.getSelectedIndex() == 1) {
			
			esterilizadoProceso = obtenerProcesoAperturaEsterilizadoAperturado();
			
			if (esterilizadoProceso.getIdesterilizadoproceso()!=null) {
				Sistema.mensaje("Ya existe un proceso aperturado para la fecha "
						+ formato.format(esterilizadoProceso.getFechareg())
						+ " - "
						+ esterilizadoProceso.getTurno().getNombre());
				return;
			} else {
			
				esterilizadoProceso = cargarEsterilizadoProceso(dteFechaProduccion.getValue(), turno.getIdturno());
			
				if (esterilizadoProceso!=null) {
					
					if (esterilizadoProceso.getProcesoAperturaCierre().getEstado().equals(1))
						Sistema.mensaje("Ya existe un proceso aperturado para la fecha "
								+ formato.format(esterilizadoProceso.getFechareg()));
					else if (esterilizadoProceso.getProcesoAperturaCierre().getEstado().equals(0))
						Sistema.mensaje("El proceso para la fecha " 
								+ formato.format(esterilizadoProceso.getFechareg())
								+ " ya fue aperturado.");
					return;
				}
			}
			ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierre();
			procesoAperturaCierre.setEstado(1);
			procesoAperturaCierre.setFechaapertura(new Timestamp(new Date().getTime()));
			procesoAperturaCierre.setProceso(proceso);
			
			// se persiste la informacion a la base de datos
			procesoAperturaCierre = procesoAperturaCierreDAOImpl.guardarAperturaCierre(procesoAperturaCierre);
			
			esterilizadoProceso = new EsterilizadoProceso();
			esterilizadoProceso.setFechareg(new Timestamp(dteFechaProduccion.getValue().getTime()));
			esterilizadoProceso.setProcesoAperturaCierre(procesoAperturaCierre);
			esterilizadoProceso.setTurno(turno);
			esterilizadoProceso.setUsuario(usuario);
			
			// se persiste la informacion a la base de datos
			esterilizadoDAOimp.guardarActualizarEsterilizadoProceso(esterilizadoProceso);
			
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			
			limpiarDatos();
		}

		if (lbxAperturaCierre.getSelectedIndex()==2) {
			if (lbxFechaProduccion.getItems().isEmpty()) {
				Sistema.mensaje("No existen procesos aperturado");
				return;
			}
			esterilizadoProceso = (EsterilizadoProceso)lbxFechaProduccion.getSelectedItem().getValue();
			esterilizadoProceso.getProcesoAperturaCierre().setFechacierre(new java.sql.Timestamp(new Date().getTime()));
			esterilizadoProceso.getProcesoAperturaCierre().setEstado(0);
			
			procesoAperturaCierreDAOImpl.guardarAperturaCierre(esterilizadoProceso.getProcesoAperturaCierre());
					
			Sistema.mensaje("Transaccion cerrada");
		}
		limpiarDatos();
	}
	
	void limpiarDatos() {
		lbxTurno.getItems().clear();
		new HelperView().cargarTurnos(lbxTurno);
		
		lbxAperturaCierre.setSelectedIndex(0);
		dteFechaProduccion.setValue(null);
		lbxFechaProduccion.getItems().clear();
		
		gdApertura.setVisible(false);
		gdCierre.setVisible(false);
		
		lbxTurno.setSelectedIndex(0);
		chbRevisado.setChecked(false);
	}
	
	private static boolean validaCamposLista(Label etiqueta, Listbox valor) {
		if (valor.getSelectedIndex() == 0) {
			Sistema.mensaje("Debe seleccionar un valor para el campo "+etiqueta.getValue()+".");
			return false;
		}
		return true;
	}
	
	private static boolean validaCamposFecha(Label etiqueta, Datebox valor) {
		if (valor.getValue() == null) {
			Sistema.mensaje("Debe seleccionar un valor para el campo "+etiqueta.getValue()+".");
			return false;
		}
		return true;
	}
	
}
