package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import javax.swing.DefaultListModel;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
//import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EspecialidadesIncidencia;
import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EspecialidadesProceso;
//import com.nw.model.EvisceradoProceso;
import com.nw.model.EspecialidadesIncidenciaEnlatado;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
//import com.nw.model.ProduccionDetalleLote;
//import com.nw.model.ProduccionDetalleLoteCajon;
//import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EspecialidadesProcesoEnlatadoDAOJpaImpl;
//import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
//import com.nw.model.dao.impl.TurnoDAOJpaImpl;
//import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.util.Sistema;
import org.zkoss.zk.ui.Sessions;

@SuppressWarnings("serial")
public class EspecialidadesProcesoEnlatadoIncidencia extends
		GenericForwardComposer {

	private Listbox lbxDiaProduccion, lbxOP, lbxIncidencia;
	private Textbox txtProducto, txtnlatas, txtDetlleIncidencia,
			txtDetlleObservacion;
	private Toolbarbutton btnGrabar;
	private Checkbox chbRevisado;

	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	ProcesoAperturaCierreDAOJpaImpl pacdao = new ProcesoAperturaCierreDAOJpaImpl();
	EspecialidadesProcesoEnlatadoDAOJpaImpl epedao = new EspecialidadesProcesoEnlatadoDAOJpaImpl();
	EspecialidadesProceso glo_especialidadesProceso = new EspecialidadesProceso();
	EspecialidadesProcesoEnlatado epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
	EspecialidadesProceso especialidadesProceso = new EspecialidadesProceso();
	List<EspecialidadesProceso> especialidadesProcesos = new ArrayList<EspecialidadesProceso>();
	Produccion produccion = new Produccion();
	ProcesoAperturaCierre procesoAperturaCierre = new ProcesoAperturaCierre();
	EspecialidadesIncidenciaEnlatado espcialidadprocesoenlatado = new EspecialidadesIncidenciaEnlatado();
	List<EspecialidadesIncidencia> epecialidadincidencias = new ArrayList<EspecialidadesIncidencia>();
	EspecialidadesIncidencia epecialidadincidencia = new EspecialidadesIncidencia();
	Double idprocesoAperturaCierre;
	Date fecha;

	EspecialidadesIncidenciaEnlatado actualiza_eie = new EspecialidadesIncidenciaEnlatado();

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		CargarDatos();
		// cargarConsultas();
		CargarIncidentes();
		// limpiarDatos();
	}

	public void cargarConsultas() {
		try {

			// procesoAperturaCierre=pacdao.getSeleccionProcesoAperturaCierreEspecialidades();
			actualiza_eie = epedao.obtenerActualizarespecilidadIE(
					epecialidadesprocesosenlato
							.getIdespecialidadesprocesollenado(), produccion
							.getIdproduccion());

			// txtProduccion.setValue(procesoAperturaCierre.getFechaapertura().toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}

	}

	void CargarDatos() throws InterruptedException {
		try {

			lbxDiaProduccion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxDiaProduccion);

			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl()
					.getProducciones();

			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				new Listcell(dateFormat.format(bd.getFechaproduccion()))
						.setParent(li);

				li.setParent(lbxDiaProduccion);

				produccion = bd;
			}
			lbxDiaProduccion.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	void CargarIncidentes() throws InterruptedException {
		try {

			lbxIncidencia.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new EspecialidadesProceso());
			li.setParent(lbxIncidencia);

			// List<Produccion> listafechaProduccion = new
			// ProduccionDAOJpaImpl().getProducciones();
			epecialidadincidencias = epedao.obtenerEspecidadesProceso();
			for (EspecialidadesIncidencia ep : epecialidadincidencias) {
				li = new Listitem();
				li.setValue(ep);

				new Listcell(String.valueOf(ep.getIdespecialidadesincidencia()))
						.setParent(li);

				li.setParent(lbxIncidencia);
			}
			lbxIncidencia.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	void CargarDatosOp() throws InterruptedException {
		try {

			lbxOP.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new EspecialidadesProceso());
			li.setParent(lbxOP);

			List<EspecialidadesProceso> listaEspProc = epedao
					.getSeleccionEspecialidadesProceso(produccion
							.getIdproduccion());

			for (EspecialidadesProceso itemEP : listaEspProc) {
				li = new Listitem();
				li.setValue(itemEP);
				new Listcell(
						String.valueOf(itemEP.getIdespecialidadesproceso()))
						.setParent(li);
				li.setParent(lbxOP);
			}
			lbxOP.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void onSelect$lbxOP() {

		if (lbxOP.getSelectedIndex() > 0) {

			glo_especialidadesProceso = (EspecialidadesProceso) lbxOP
					.getSelectedItem().getValue();
			if (glo_especialidadesProceso != null && produccion != null) {
				// if(lbxOP.getSelectedItem().getIndex()>0)
				System.out.println("el dato descripcin-->"
						+ glo_especialidadesProceso.getEspecialidadesReceta()
								.getEspecialidadesProducto().getDescripcion());
				txtProducto.setText(String.valueOf(""
						+ glo_especialidadesProceso.getEspecialidadesReceta()
								.getEspecialidadesProducto().getDescripcion()));
				epecialidadesprocesosenlato = epedao
						.obtenerNumeroLatas(glo_especialidadesProceso
								.getIdespecialidadesproceso());
				lbxIncidencia.focus();
				if(epecialidadesprocesosenlato!=null)
				txtnlatas.setText(String.valueOf(epecialidadesprocesosenlato
						.getTotal()));
			} else {
				glo_especialidadesProceso = null;
				Sistema.mensaje("Seleccione un proceso");
			}
			// txtCajon.setValue(produccionDetalleLoteCajon.getCamaraCajon().getCajon().getIdcajon()
			// );

			// System.out.println("valor del idcajon escogido -->"+glo_especialidadesProceso.getIdespecialidadesproceso());
			// }else{
			// glo_especialidadesProceso = null;// se vacia el objeto para q
			// pueda validar de nuevo q debe escoger una columna
		}
		else
		{
			txtnlatas.setValue("");								// validar de nuevo q debe escoger
			txtProducto.setValue("");	
		}

	}

	public void onSelect$lbxDiaProduccion() throws InterruptedException {
		try {
			if(lbxDiaProduccion.getSelectedIndex() > 0){
				CargarDatosOp();
				lbxOP.focus();
			}
			else{
				limpiarDatos();
				lbxOP.getItems().clear();
			}

		} catch (Exception e) {
			System.out.println("Mensaje de error " + e.getMessage());
		}

	}

	public void onSelect$lbxIncidencia() throws InterruptedException {

		if (lbxIncidencia.getSelectedIndex() > 0) {

			epecialidadincidencia = (EspecialidadesIncidencia) lbxIncidencia
					.getSelectedItem().getValue();
			cargarConsultas();
			if ((actualiza_eie!=null) && actualiza_eie.getIdespecialidadesincidenciaenlatado()!=null){
				txtDetlleObservacion.focus();
			}else{
				btnGrabar.focus();
			}
				
		} else {
			epecialidadincidencia = null;// se vacia el objeto para q pueda
											// una columna
		}

		try {
			// CargarIncidentes();
			txtDetlleIncidencia.setText(epecialidadincidencia.getDescripcion());

		} catch (Exception e) {
			System.out.println("Mensaje de error " + e.getMessage());
		}

	}

	public void onClick$btnGrabar() throws InterruptedException {
		// grabar();

		if (lbxDiaProduccion.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
			return;
		}
		if (lbxOP.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido O/P .. no puede grabar");
			return;
		}
		if (lbxIncidencia.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido la Incidencia .. no puede grabar");
			return;
		}
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		if (usuario == null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			 return;
			//usu.setIdusuario("aaguirre");
		}
		if ((actualiza_eie == null)) {
			EspecialidadesIncidenciaEnlatado loc_espcialidadprocesoenlatado = new EspecialidadesIncidenciaEnlatado();
			if (glo_especialidadesProceso != null && produccion != null) {
				// loc_espcialidadprocesoenlatado=epedao.obtenerUltimoIDespecilidadIE();
				// if (loc_espcialidadprocesoenlatado==null){
				// espcialidadprocesoenlatado.setIdespecialidadesincidenciaenlatado(1);
				// }
				// else {
				// espcialidadprocesoenlatado=loc_espcialidadprocesoenlatado;
				// }
				loc_espcialidadprocesoenlatado
						.setEspecialidadesProcesoEnlatado(epecialidadesprocesosenlato);
				loc_espcialidadprocesoenlatado
						.setFechainicio(new java.sql.Timestamp(new Date()
								.getTime()));
				loc_espcialidadprocesoenlatado.setEstado(1);
				loc_espcialidadprocesoenlatado
						.setEspecialidadesIncidencia(epecialidadincidencia);
				loc_espcialidadprocesoenlatado.setObservaciones(txtDetlleObservacion.getValue());
				epedao.guardarActualizarespcialidadprocesoenlatado(loc_espcialidadprocesoenlatado);

				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);

				limpiarDatos();
			} else {
				Sistema.mensaje("Debe seleccionar todos los campos ");
			}
		} else {
			Sistema.mensaje("Incidencia ya se encuentra registrada");
		}
		if ((actualiza_eie!=null) && actualiza_eie.getIdespecialidadesincidenciaenlatado()!= null){
			if (chbRevisado.isChecked() == true ) {
	
				actualiza_eie.setFechafin(new java.sql.Timestamp(new Date()
						.getTime()));
				actualiza_eie.setEstado(2);
				//actualiza_eie.setObservaciones(txtDetlleObservacion.getValue());
				epedao.guardarActualizarespcialidadprocesoenlatado(actualiza_eie);
				Sistema.mensaje("Fin de incidencia registrado");
				
			}
			else{
				Sistema.mensaje("No se ha escogido finalizar incidencia.. no puede grabar");
			}
		}
		limpiarDatos();
	}

	void limpiarDatos() throws InterruptedException {
		
		txtProducto.setValue("");
		txtnlatas.setValue("");
		txtDetlleIncidencia.setValue("");
		txtDetlleObservacion.setValue("");
		//lbxOP.getItems().clear();
		lbxOP.setSelectedIndex(0);
		//lbxDiaProduccion.getItems().clear();
		lbxIncidencia.setSelectedIndex(0);
		chbRevisado.setChecked(false);
		// chbRevisado.isChecked() = false;
		//glo_especialidadesProceso = new EspecialidadesProceso();
		epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
		//produccion = new Produccion();
		actualiza_eie = new EspecialidadesIncidenciaEnlatado();
		espcialidadprocesoenlatado = new EspecialidadesIncidenciaEnlatado();
		epecialidadincidencia = new EspecialidadesIncidencia();
		lbxOP.focus();
		//CargarDatos();
	}

}
