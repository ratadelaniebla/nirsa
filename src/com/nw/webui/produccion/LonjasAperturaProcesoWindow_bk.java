package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.LonjasProceso;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.dao.impl.LonjasProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Fecha;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class LonjasAperturaProcesoWindow_bk extends GenericForwardComposer {

	private Listbox lbxDiaProduccion, lbxOFabricacion, lbxTurno;
	private Checkbox chbRevisado;
	private Toolbarbutton btnGrabar;
	private Textbox txtdiaJuliano;
	private Intbox intbxOFabricacion;

	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	Produccion produccion = new Produccion();
	TurnoDAOJpaImpl turnoDao = new TurnoDAOJpaImpl();
	Turno glo_turno = new Turno();

	LonjasProceso lonjaProceso = new LonjasProceso();
	LonjasProceso actu_lonjaProceso = new LonjasProceso();
	LonjasProcesoDAOJpaImpl lonjasDAOImp = new LonjasProcesoDAOJpaImpl();

	List<LonjasProceso> lonjaProcesos = new ArrayList<LonjasProceso>();

	ProcesoAperturaCierre procesoAperturaCierre;
	ProcesoAperturaCierreDAOJpaImpl procesoAperturaCierreDAOImpl;
	ProcesoAperturaCierreDAOJpaImpl pacdao = new ProcesoAperturaCierreDAOJpaImpl();

	/**
	 * 
	 */

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
		cargarListaFecha();
		obtenerturnos();
		cargarConsultas(); //este metodo consulta si existe una apertura realizada
	}

	public void cargarConsultas() {
		try {

		//	actu_lonjaProceso = pacdao.obtenerProcesoAperturaLonjas();

//			if (lbxOFabricacion == null
//					&& actu_lonjaProceso.getIdlonjasproceso() != null) {
//				Sistema.mensaje("No se puede realizar una Aprtura.. ya existe una iniciada ");
//				limpiarDatos();
//				lbxDiaProduccion.getItems().clear();
//				return;
//			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void cargarListaFecha() {
		try {

			lbxDiaProduccion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxDiaProduccion);

			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl()
					.getListaFechaProduccionActiva();

			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Fecha --> "
						+ dateFormat.format(bd.getFechaproduccion()));
				new Listcell(dateFormat.format(bd.getFechaproduccion()))
						.setParent(li);
				li.setParent(lbxDiaProduccion);

				produccion.setIdproduccion(bd.getIdproduccion());
			}
			lbxDiaProduccion.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void onSelect$lbxDiaProduccion() throws InterruptedException {

		if (lbxDiaProduccion.getSelectedIndex() > 0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxDiaProduccion.getSelectedItem()
					.getValue();

			String x;
			x = Integer.toString(new Fecha().getDiasTranscurridos(produccion
					.getFechaproduccion()));
			txtdiaJuliano.setValue(x);
			lbxTurno.focus();
			if (lbxOFabricacion != null) {
				obtenerOfabricacion();
			}
		} else {
			produccion = null;
		}
	}

	public void obtenerOfabricacion() {
		try {

			lbxOFabricacion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new LonjasProceso());
			li.setParent(lbxOFabricacion);
			// TODO
			lonjaProcesos = lonjasDAOImp
					.obtenerSeleccionLonjasProceso(produccion.getIdproduccion());

			for (LonjasProceso itenlp : lonjaProcesos) {
				li = new Listitem();
				li.setValue(itenlp);

				new Listcell(String.valueOf(itenlp.getOrdenfabricacion()))
						.setParent(li);
				li.setParent(lbxOFabricacion);

			}
			lbxOFabricacion.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void onSelect$lbxOFabricacion() throws InterruptedException {
		if (lbxOFabricacion.getSelectedIndex() > 0) {

			 //asignar la opcion q se escoja al objeto 
			actu_lonjaProceso = (LonjasProceso) lbxOFabricacion.getSelectedItem().getValue();
			
		} else {
			produccion = null;
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

				// glo_turno.setIdproduccion(itenturno.getIdproduccion());
			}
			lbxTurno.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			glo_turno = new Turno();
			glo_turno = (Turno) lbxTurno.getSelectedItem().getValue();
			if (intbxOFabricacion!=null){
				intbxOFabricacion.focus();
			}else{
				lbxOFabricacion.focus();
			}
			
		} else {
			glo_turno = null;
		}
	}

	public void onClick$btnGrabar() throws InterruptedException {
		grabar();
	}

	public void grabar() {
		if (chbRevisado.isChecked() == true) {
//			Usuario usu = new Usuario();
//			String usuario = (String) Sessions.getCurrent().getAttribute(
//					"usuario");
//			usu.setIdusuario(usuario);
//			if (usuario == null || usuario.equals("")) {
//				Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
//				// return;
//				usu.setIdusuario("aaguirre");
//			}
			if ((lbxOFabricacion != null)
					&& lbxOFabricacion.getSelectedIndex() <= 0) {
				// glo_especialidadesProceso.setIdespecialidadesproceso(Long.valueOf(Integer.valueOf(txtProducto.getValue())));
				Sistema.mensaje("No se ha seleccionado la O.Fabricacion.. no puede grabar");
				return;
			}

			if (lbxDiaProduccion.getSelectedIndex() <= 0) {
				Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
				return;
			}

			if (lbxTurno.getSelectedIndex() <= 0) {
				Sistema.mensaje("No se ha escogido Dia Producto .. no puede grabar");
				return;
			}
			
			if ((intbxOFabricacion!= null  ) && intbxOFabricacion.getValue()==null) {
			    Sistema.mensaje("Debe ingresar una orden de fabricación .. no puede grabar");
				return;
		      }
			
			
			if (glo_turno.getIdturno() != null && produccion != null
				&& lbxOFabricacion == null	) {

				procesoAperturaCierre = new ProcesoAperturaCierre();
				ProcesoAperturaCierre loc_procesoAperturaCierre = new ProcesoAperturaCierre();
				procesoAperturaCierre.setEstado(1);
				Proceso proceso = new Proceso();
				proceso.setIdproceso(9);//el proceso 9 en lonjas 
				procesoAperturaCierre.setProceso(proceso);
				procesoAperturaCierre.setFechaapertura(new java.sql.Timestamp(
						new Date().getTime()));

				loc_procesoAperturaCierre = pacdao
						.guardarAperturaCierre(procesoAperturaCierre);
				lonjaProceso = new LonjasProceso();

				lonjaProceso.setProduccion(produccion);
				lonjaProceso.setFechareg(new java.sql.Timestamp(new Date()
						.getTime()));
				lonjaProceso.setTurno(glo_turno);
				lonjaProceso
						.setProcesoAperturaCierre(loc_procesoAperturaCierre);
				lonjaProceso.setDiajuliano(Integer.valueOf(txtdiaJuliano
						.getValue()));
				lonjaProceso.setOrdenfabricacion(Long.valueOf(intbxOFabricacion
						.getValue()));
				// TODO
				lonjasDAOImp.guardarActualizarLonjasProceso(lonjaProceso);
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
				// limpiarDatos();
			} else {
				Sistema.mensaje("Debe seleccionar todos los campos ");
			}

			if ((actu_lonjaProceso != null) && 
					 actu_lonjaProceso.getIdlonjasproceso() != null) {
				actu_lonjaProceso.getProcesoAperturaCierre().setEstado(0);
				actu_lonjaProceso.getProcesoAperturaCierre().setFechacierre(new java.sql.Timestamp(
						new Date().getTime()));
				//procesoAperturaCierre.setEstado(0);
				//procesoAperturaCierre.setFechaapertura(actu_lonjaProceso
					//	.getProcesoAperturaCierre().getFechaapertura());
//				procesoAperturaCierre.setFechacierre(new java.sql.Timestamp(
//						new Date().getTime()));
				//procesoAperturaCierre.setLonjasProcesos(lonjaProcesos);
//				procesoAperturaCierre
//						.setIdprocesoaperturacierre(actu_lonjaProceso
//								.getProcesoAperturaCierre()
//								.getIdprocesoaperturacierre());
				pacdao.guardarAperturaCierre(actu_lonjaProceso.getProcesoAperturaCierre());

				Sistema.mensaje("Transaccion cerrada");
			}
		} else {
			Sistema.mensaje("Debe seleccionar todos los campos ");
		}

		limpiarDatos();
	}

	void limpiarDatos() {
		if (intbxOFabricacion != null) {
			intbxOFabricacion.setText("");
		}else {
			if(lbxOFabricacion.getSelectedIndex() >= 0) {
				lbxOFabricacion.setSelectedIndex(0);}
		}
		if (lbxDiaProduccion.getSelectedIndex() >= 0) {
			lbxTurno.setSelectedIndex(0);
		}

		
		txtdiaJuliano.setValue("");
		lonjaProceso = new LonjasProceso();
		//glo_turno = new Turno();
		procesoAperturaCierre = new ProcesoAperturaCierre();
		produccion = new Produccion();
		chbRevisado.setChecked(false);
		cargarListaFecha();

	}

}
