package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import javax.swing.DefaultListModel;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
//import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

//import com.nw.model.CoccionProceso;
//import com.nw.model.EspecialidadesProceso;
//import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EvisceradoProceso;
import com.nw.model.LimpiezaDetalleProcesoLote;
import com.nw.model.LonjasDetalleProcesoLote;
import com.nw.model.LonjasEspecietalla;
import com.nw.model.LonjasProceso;
//import com.nw.model.Proceso;
//import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
//import com.nw.model.ProduccionDetalleLote;
//import com.nw.model.RociadoProceso;
import com.nw.model.Turno;
import com.nw.model.Usuario;
//import com.nw.model.dao.impl.CoccionProcesoDAOJpaImpl;
//import com.nw.model.dao.impl.EspecialidadesProcesoEnlatadoDAOJpaImpl;
//import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LonjasProcesoDAOJpaImpl;
//import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
//import com.nw.model.dao.impl.RociadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Fecha;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class LonjasAperturaCierreLoteWindow_bk extends GenericForwardComposer {

	private Listbox lbxDiaProduccion, lbxOFabricacion, lbxTurno, lbxLote,
			lbxAperturaCierre;
	private Checkbox chbRevisado;
	private Toolbarbutton btnGrabar;
	private Textbox txtdiaJuliano, txtOFabricacion, txtCodLonjas, txtBarco;

	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	Produccion produccion = new Produccion();
	LonjasProceso lonjaProceso = new LonjasProceso();
	LonjasProceso actu_lonjaProceso = new LonjasProceso();
	LonjasDetalleProcesoLote lonjadpl = new LonjasDetalleProcesoLote();
	LonjasDetalleProcesoLote actu_lonjadpl = new LonjasDetalleProcesoLote();
	LonjasEspecietalla lonjaEt = new LonjasEspecietalla();

	List<LonjasProceso> lonjaProcesos = new ArrayList<LonjasProceso>();
	List<LimpiezaDetalleProcesoLote> listalote = new ArrayList<LimpiezaDetalleProcesoLote>();
	List<LonjasDetalleProcesoLote> listalotelonja = new ArrayList<LonjasDetalleProcesoLote>();
	Turno glo_turno = new Turno();
	LimpiezaDetalleProcesoLote limpdpl = new LimpiezaDetalleProcesoLote();

	LonjasProcesoDAOJpaImpl lonjasDAOImp = new LonjasProcesoDAOJpaImpl();
	
	TurnoDAOJpaImpl turnoDao = new TurnoDAOJpaImpl();


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
		cargarListaFecha();
		obtenerturnos();
		// cargarConsultas();
	}

	public void cargarDatos() {
//		if (lonjadpl.getLimpiezaDetalleProcesoLote() != null) {
//			actu_lonjadpl = lonjasDAOImp.obtenerLonjaDetpl(
//					produccion.getIdproduccion(), lonjadpl
//							.getLimpiezaDetalleProcesoLote()
//							.getProduccionDetalleLote().getIdlote());
//			txtCodLonjas.setValue(String.valueOf(actu_lonjadpl
//					.getCodigolonjas()));
//			txtCodLonjas.setReadonly(true);
//		}else{
//			actu_lonjadpl = lonjasDAOImp.obtenerLonjaDetpl(produccion.getIdproduccion(), limpdpl
//					.getProduccionDetalleLote().getIdlote());
			
		//}
	}

	public void cargarConsultasLotes() {
		try {

			if (lbxAperturaCierre.getSelectedIndex() > 0) {

				if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) {
					txtCodLonjas.setValue("");
					txtBarco.setValue("");
					listalote = new ArrayList<LimpiezaDetalleProcesoLote>();
					listalote = lonjasDAOImp.obtenerListaLotesenLimpieza(produccion.getIdproduccion(),glo_turno.getIdturno());

					lbxLote.getItems().clear();
					Listitem li = new Listitem();
					li.setValue(new LimpiezaDetalleProcesoLote());
					li.setParent(lbxLote);

					for (LimpiezaDetalleProcesoLote ldpl : listalote) {
						li = new Listitem();
						li.setValue(ldpl);
						new Listcell(String.valueOf(ldpl
								.getProduccionDetalleLote().getIdlote()))
								.setParent(li);
						li.setParent(lbxLote);
					}
					lbxLote.setSelectedIndex(0);

				} else if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {
					txtCodLonjas.setValue("");
					txtBarco.setValue("");
					listalotelonja = lonjasDAOImp
							.obtenerListaLotesenProcesoLonjas(produccion
									.getIdproduccion(),glo_turno.getIdturno());

					lbxLote.getItems().clear();
					Listitem li = new Listitem();
					li.setValue(new LonjasDetalleProcesoLote());
					li.setParent(lbxLote);

					for (LonjasDetalleProcesoLote listaLote : listalotelonja) {
						li = new Listitem();
						li.setValue(listaLote);

						new Listcell(String.valueOf(listaLote
								.getLimpiezaDetalleProcesoLote()
								.getProduccionDetalleLote().getIdlote()))
								.setParent(li);
						li.setParent(lbxLote);

					}
					lbxLote.setSelectedIndex(0);

				}
			} else {
				Sistema.mensaje("No se puede escojer lote.. seleccione Apertura/Cierre");
				lbxLote.getItems().clear();
			}

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
			System.out.println("produccion id --> "
					+ produccion.getIdproduccion());
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
			limpiarDatos();
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

				// glo_turno.setIdproduccion(itenturno.getIdproduccion());
			}
			lbxOFabricacion.setSelectedIndex(0);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void onSelect$lbxOFabricacion() throws InterruptedException {
		if (lbxOFabricacion.getSelectedIndex() > 0) {

			lonjaProceso = new LonjasProceso();
			lonjaProceso = (LonjasProceso) lbxOFabricacion.getSelectedItem()
					.getValue();
			lbxAperturaCierre.focus();
		} else {
			produccion = null;
		}
	}

	public void onSelect$lbxAperturaCierre() throws InterruptedException {
		if (lbxAperturaCierre.getSelectedIndex() > 0) {
			cargarConsultasLotes();
			lbxLote.focus();
		} else {
			lbxLote.getItems().clear();
			txtBarco.setText("");
			txtCodLonjas.setText("");
			limpdpl = null;
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
			glo_turno = (Turno) lbxTurno.getSelectedItem().getValue();// asigno
			lbxOFabricacion.focus();
		} else {
			glo_turno = null;
		}
	}

	public void onSelect$lbxLote() throws InterruptedException {
		
		if (lbxLote.getSelectedIndex() > 0) {
			limpdpl = new LimpiezaDetalleProcesoLote();

			if (limpdpl != null) {
				
				// barcodescarga seleccionado

				if (lbxAperturaCierre.getSelectedItem().getIndex() == 1) {
					limpdpl = (LimpiezaDetalleProcesoLote)
							lbxLote.getSelectedItem().getValue();//asigno el item
					
					txtBarco.setValue(String.valueOf(limpdpl
							.getProduccionDetalleLote().getBarcoDescarga()
							.getBarco().getIdbarco()));
					lonjaEt = lonjasDAOImp.obtenerLonjaEspecietalla(limpdpl
							.getProduccionDetalleLote().getEspecieTalla()
							.getIdespecietalla());
				} else if (lbxAperturaCierre.getSelectedItem().getIndex() == 2) {
					actu_lonjadpl = (LonjasDetalleProcesoLote) lbxLote
							.getSelectedItem().getValue();
					txtBarco.setValue(String.valueOf(actu_lonjadpl
							.getLimpiezaDetalleProcesoLote()
							.getProduccionDetalleLote().getBarcoDescarga()
							.getBarco().getIdbarco()));
					lonjaEt = lonjasDAOImp.obtenerLonjaEspecietalla(actu_lonjadpl
							.getLimpiezaDetalleProcesoLote()
							.getProduccionDetalleLote().getEspecieTalla()
							.getIdespecietalla());
					if (actu_lonjadpl.getCodigolonjas() != null ){
							txtCodLonjas.setValue(String.valueOf(actu_lonjadpl.getCodigolonjas()));
							txtCodLonjas.setReadonly(true);
							txtCodLonjas.focus();
						}
				}
			}
		} else {
			lonjaEt = null;
			txtBarco.setText("");
			txtCodLonjas.setText("");
		}
		
	}

	public void onClick$btnGrabar() throws InterruptedException {
		grabar();
	}

	public void grabar() {
		if (chbRevisado.isChecked() == true) {
		Usuario usu = new Usuario();
		String usuario = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		if (usuario == null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
			//usu.setIdusuario("aaguirre");
		}
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
		if (glo_turno.getIdturno() != null && produccion != null
				
				&& lbxAperturaCierre.getSelectedItem().getIndex() == 1) {

			lonjadpl.setLonjasProceso(lonjaProceso);
			lonjadpl.setLimpiezaDetalleProcesoLote(limpdpl);
			lonjadpl.setEstado(1);
			lonjadpl.setFechainicio(new java.sql.Timestamp(new Date().getTime()));
			lonjadpl.setUsuario(usu);
			lonjadpl.setCodigobarco(txtBarco.getValue());
			lonjadpl.setCodigolonjas(Integer.valueOf(txtCodLonjas.getValue()));
			lonjadpl.setTurno(glo_turno);
			lonjadpl.setLonjasEspecietalla(lonjaEt);

			// TODO
			lonjasDAOImp.guardarActualizarLonjasProcesoLote(lonjadpl);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			// limpiarDatos();
		} else if (lbxAperturaCierre.getSelectedItem().getIndex() == 2 && actu_lonjadpl.getIdlonjasdetalleprocesolote() != null) {
			actu_lonjadpl.setFechafin(new java.sql.Timestamp(new Date().getTime()));
			actu_lonjadpl.setEstado(0);
			//actu_lonjadpl.setLonjasEspecietalla(lonjaEt);

			// TODO
			lonjasDAOImp.guardarActualizarLonjasProcesoLote(actu_lonjadpl);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		} else {
			Sistema.mensaje("Debe Aperturar un lote");
		}

		limpiarDatos();
		}else
		{
			Sistema.mensaje("Debe seleccionar todos los campos ");
		}
	}

	void limpiarDatos() {

		txtBarco.setValue("");
		txtCodLonjas.setValue("");
		if(lbxTurno.getSelectedIndex() >= 0){
		lbxAperturaCierre.setSelectedIndex(0);
		
		}

		lbxLote.getItems().clear();
		lonjaProceso = new LonjasProceso();
		actu_lonjadpl = new LonjasDetalleProcesoLote();
		lonjaEt = new LonjasEspecietalla();

		listalote = new ArrayList<LimpiezaDetalleProcesoLote>();
		listalotelonja = new ArrayList<LonjasDetalleProcesoLote>();
		chbRevisado.setChecked(false);
		limpdpl = new LimpiezaDetalleProcesoLote();
		//cargarListaFecha();

	}

}
