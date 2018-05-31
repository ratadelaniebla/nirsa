package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.EnvasadoDetalleProcesoCambio;
import com.nw.model.EnvasadoDetalleProcesoCambiosLuthy;
import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.EnvasadoMotivoCambio;
import com.nw.model.EnvasadoProceso;
import com.nw.model.EnvasadoProveedorLata;
import com.nw.model.EnvasadoProveedorTapa;
import com.nw.model.Luthy;
import com.nw.model.MaquinaCerradora;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoDetalleProcesoCambioDAO;
import com.nw.model.dao.EnvasadoDetalleProcesoCambiosLuthyDAO;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.EnvasadoMotivoCambioDAO;
import com.nw.model.dao.EnvasadoProveedorLataDAO;
import com.nw.model.dao.EnvasadoProveedorTapaDAO;
import com.nw.model.dao.LuthyDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosDAOJpaimpl;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosLuthyDAOJpaimpl;
import com.nw.model.dao.impl.EnvasadoFichaTecnicaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoMotivoCambioDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProveedorLataDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProveedorTapaDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
import com.nw.model.dao.impl.MaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;


/**
 * 
 * @author Cls Mbaque
 * @since 17/04/2018
 */
public class EnvasadoDetalleProcesoCambiosMantenimientoWindow extends GenericForwardComposer{
	
	private static final long serialVersionUID = 1L;
	
	AnnotateDataBinder binder;
	
	Datebox dteFechaProduccion;
	
	Textbox txtNetoFormulado, txtSalmuera, txtConcentracion, txtDensidad, txtFormato;
	Textbox txtTapa, txtPresentacion, txtCodVideoJet, txtPNeto, txtDestino, txtObservacion;
	Label	txtOrden, txtProducto, txtMarca;
	Listbox lbxTurnoProduccion, lbxItemOrdenFillPresentacion;
	Listbox lbxTurnoLabor, lbxItemOrden, lbxMSelladora, lbxLuthy, lbxLista, lbxTipoProteina, lbxMotivoCambio;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;

	Textbox txtH2O, txtAceite, txtProteina, txtDrenado, txtFlakes, txtLatas;
	Checkbox chkEliminar;
	
	Label 	lbFill1,  lbFill2,  lbFillPromedio;
	Textbox txtFill1, txtFill2, txtFillPromedio;
	
	Label 	lbProveedorLata,  lbProveedorTapa;
	Listbox lbxProveedorLata, lbxProveedorTapa;
	
	private Produccion produccion;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		cargarListaTurnoLabor();
		cargalbxTipoProteina();
		cargaMotivoCambio();
		cargaProveedorTapa();
		cargaProveedorLata();
		binder.loadAll();
	}
	
	public void onChange$dteFechaProduccion(){
		produccion = new ProduccionDAOJpaImpl().getProduccionByFechaDate(dteFechaProduccion.getValue());
		List<EnvasadoProceso> listEProceso = new ArrayList<EnvasadoProceso>();
		if (produccion==null) {
			Sistema.mensaje("No existe una produccion configurada para la fecha seleccionada.");
			return;
		}
		listEProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoByIdProduccion(produccion.getIdproduccion());
		
		if(listEProceso.isEmpty()) {
			Sistema.mensaje("No existe configuracion para la fecha seleccionada.");
			return;
		}
			
		cargaTurno(listEProceso);
		cargaInfoMSelladora();
		cargaLuthy();
		
	}
	
	private  void cargaTurno(List<EnvasadoProceso> listEProceso) {
			
		lbxTurnoProduccion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProceso());
		li.setParent(lbxTurnoProduccion);
		
		for (EnvasadoProceso eProceso : listEProceso) {
			li = new Listitem();
			li.setValue(eProceso);
			new Listcell(eProceso.getTurno().getNombre()).setParent(li);
			li.setParent(lbxTurnoProduccion);
		}
		
		lbxTurnoProduccion.setSelectedIndex(0);
	}
	
	public void onSelect$lbxTurnoProduccion() {
		
		cargaItemOdenFillPresentacion();
		
	}
	
	private void cargaItemOdenFillPresentacion() {
		EnvasadoProceso eProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		if  (eProceso.getIdenvasadoproceso()==null) {
			lbxItemOrdenFillPresentacion.getItems().clear();
			return;
		}
		
		EnvasadoDetalleProcesoCambioDAO edpcDAO= new EnvasadoDetalleProcesoCambiosDAOJpaimpl();
		ProduccionDetalleOrdenDAO pdoDAO= new ProduccionDetalleOrdenDAOJpaImpl();
				
		List<EnvasadoDetalleProcesoCambio> listEdpCambio = edpcDAO.getEnvasadoDetalleProcesoCambioByIdEProceso(eProceso.getIdenvasadoproceso());
		ProduccionDetalleOrden pdo = new ProduccionDetalleOrden();
		
		StringBuilder label;
		lbxItemOrdenFillPresentacion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoDetalleProcesoCambio());
		li.setParent(lbxItemOrdenFillPresentacion);
		
		li = new Listitem();
		li.setValue(new EnvasadoDetalleProcesoCambio());
		li.setParent(lbxItemOrdenFillPresentacion);
		li.setLabel("- NUEVO -");
		
		for (EnvasadoDetalleProcesoCambio edpc : listEdpCambio) {
			li = new Listitem(); 
			li.setValue(edpc);
			pdo = pdoDAO.obtieneDetalleOrdenById(edpc.getProduccionDetalleOrden().getIdproducciondetalleorden());
			label = new StringBuilder();
			label.append(pdo.getItem()).append(" - ").append(pdo.getOrden()).append(" - ").append(edpc.getFillPromedio()).append(" - ").append(pdo.getProducto()); 
			new Listcell(label.toString()).setParent(li);
			li.setParent(lbxItemOrdenFillPresentacion);
		}
		if (!lbxItemOrdenFillPresentacion.getItems().isEmpty())
			lbxItemOrdenFillPresentacion.setSelectedIndex(0);
	}

	public void onSelect$lbxItemOrdenFillPresentacion() {
		int index=0;
		int cont=1;
		EnvasadoDetalleProcesoCambio edpc = (EnvasadoDetalleProcesoCambio)lbxItemOrdenFillPresentacion.getSelectedItem().getValue();
		EnvasadoProceso eProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
		if  (edpc.getIdenvasadodetalleprocesocambios()==null) {
			limpiarFormulario();
			return;
		}
			
		ProduccionDetalleOrdenDAO pdoJpa = new ProduccionDetalleOrdenDAOJpaImpl();
		List<ProduccionDetalleOrden> listPdo = pdoJpa.obtieneDetalleOrdenByProduccionTurno(
													eProceso.getTurno().getIdturno(),
													eProceso.getProduccion().getIdproduccion());
		if (listPdo.isEmpty()) {
			Sistema.mensaje("No existe informacion procesada del Detalle Orden");
			return;
		}
		StringBuilder label;
		lbxItemOrden.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrden);
		
		for (ProduccionDetalleOrden pdo : listPdo) {
			li = new Listitem();
			li.setValue(pdo);
			label = new StringBuilder();
			label.append(pdo.getItem()).append(" - ").append(pdo.getOrden()+ " - " + pdo.getCliente());
			new Listcell(label.toString()).setParent(li);
			li.setParent(lbxItemOrden);
			System.out.println(edpc.getProduccionDetalleOrden().getIdproducciondetalleorden()+"--"+pdo.getIdproducciondetalleorden());
			if(edpc.getProduccionDetalleOrden().getIdproducciondetalleorden().equals(pdo.getIdproducciondetalleorden()))
				index=cont;
			cont++;
		}
		cont=1;
		lbxItemOrden.setSelectedIndex(index);
		
		lbxTurnoLabor.setSelectedIndex(edpc.getTurno().getIdturno());
		
		cargaInfoDefecto();
	}
	
	private void cargarListaTurnoLabor(){
		lbxTurnoLabor.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoLabor);
		
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		for (Turno turno : listaTurnos) {
			 li = new Listitem();
			 li.setValue(turno);
			 new Listcell(turno.getNombre()).setParent(li);
			 li.setParent(lbxTurnoLabor);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	private void cargaInfoDefecto() {
 		EnvasadoDetalleProcesoCambio edpc = (EnvasadoDetalleProcesoCambio)lbxItemOrdenFillPresentacion.getSelectedItem().getValue();
 		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();

 		if(edpc.getIdenvasadodetalleprocesocambios()==null)
 			return;
 		if(pdo.getIdproducciondetalleorden()==null)
 			return;
 		
 		if (edpc.getEnvasadoCaldoVegetalProteina()==null)
 			edpc.setEnvasadoCaldoVegetalProteina(new EnvasadoCaldoVegetalProteina());

 		txtFill1.setValue(String.valueOf(edpc.getFillRango1()));
		txtFill2.setValue(String.valueOf(edpc.getFillRango2()));
		txtFillPromedio.setValue(String.valueOf(edpc.getFillPromedio()));
 		txtNetoFormulado.setValue(String.valueOf(edpc.getPesonetoformulado()));
 		txtSalmuera.setValue(String.valueOf(edpc.getSal()));
 		txtConcentracion.setValue(String.valueOf(edpc.getConcentracion()));
 		txtFormato.setValue(String.valueOf(edpc.getFormato()));
 		txtDensidad.setValue(String.valueOf(edpc.getDensidad()));
 		
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtMarca.setValue(pdo.getMarca());
		seleccionaMCerradora(edpc.getMaquinaCerradora().getIdmaquinacerradora());
		cargaLuthyConfigurado(edpc.getEnvasadoDetalleProcesoCambiosLuthies());
		
		if (edpc.getEnvasadoProveedorLata()!=null)
			cargaEnvasadoLata(edpc.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas());
		else
			lbxProveedorLata.setSelectedIndex(0);
		
		if (edpc.getEnvasadoProveedorTapa()!=null)
			cargaEnvasadoTapa(edpc.getEnvasadoProveedorTapa().getIdenvasadoproveedortapa());
		else
			lbxProveedorTapa.setSelectedIndex(0);
		txtH2O.setValue(String.valueOf(edpc.getAg()));
		txtAceite.setValue(String.valueOf(edpc.getAc()));
		cargaTipoProteinaConfigurado(edpc.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina());
		txtProteina.setValue(String.valueOf(edpc.getPorcentajeproteina()));
		txtCodVideoJet.setValue(edpc.getCodvideojet());
		txtTapa.setValue(pdo.getTapa());
		txtPresentacion.setValue(pdo.getPresentacion());
		txtDrenado.setValue(String.valueOf(edpc.getDre()));
		txtFlakes.setValue(String.valueOf(edpc.getFlake()));
		txtCodVideoJet.setValue(pdo.getVideo());
		txtPNeto.setValue(edpc.getPesoneto());
		txtDestino.setValue(pdo.getDestino());
		txtLatas.setValue(String.valueOf(edpc.getLatas()));
		
		seleccionaMes(obtieneFechaCambio(edpc.getFechacambio(), Calendar.MONTH)+1);
		seleccionaDia(obtieneFechaCambio(edpc.getFechacambio(), Calendar.DAY_OF_MONTH));
		seleccionaHora(obtieneFechaCambio(edpc.getFechacambio(), Calendar.HOUR_OF_DAY));
		seleccionaMinuto(obtieneFechaCambio(edpc.getFechacambio(), Calendar.MINUTE));
		
		cargaMotivoCambioConfigurado(edpc.getEnvasadoMotivoCambio().getIdenvasadomotivocambios());
		txtObservacion.setValue(edpc.getObservacion());
	}
	
	public void onSelect$lbxItemOrden() {
//		EnvasadoDetalleProcesoCambio edpc = (EnvasadoDetalleProcesoCambio)lbxItemOrdenFillPresentacion.getSelectedItem().getValue();
 		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
 		
// 		if(edpc.getIdenvasadodetalleprocesocambios()==null)
// 			return;
 		if(pdo.getIdproducciondetalleorden()==null)
 			return;
 		
 		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
		EnvasadoFichaTecnica eft = eftDAO.getByOrden(pdo.getIdproducciondetalleorden());
		
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtMarca.setValue(pdo.getProducto());
		
		txtFill1.setValue(String.valueOf(eft.getFillRango1()));
		txtFill2.setValue(String.valueOf(eft.getFillRango2()));
		txtFillPromedio.setValue(String.valueOf(eft.getFillPromedio()));
		
		txtNetoFormulado.setValue(String.valueOf(eft.getPesoNetoFormulado()));
		txtH2O.setValue(String.valueOf(eft.getAgua()));
		txtAceite.setValue(String.valueOf(eft.getAceite()));
		txtProteina.setValue(String.valueOf(eft.getCaldoVegetal()));
		txtSalmuera.setValue(String.valueOf(eft.getSal()));
		txtConcentracion.setValue(String.valueOf(eft.getConcentracion()));
		txtDensidad.setValue(String.valueOf(eft.getDensidad()));
		
		//crga maquina selladora
		//carga luthy
		txtTapa.setValue(pdo.getTapa());
		txtPresentacion.setValue(pdo.getProducto());
		txtDrenado.setValue(String.valueOf(pdo.getDre()));
		txtFlakes.setValue(String.valueOf(pdo.getFlake()));
		txtCodVideoJet.setValue(pdo.getVideo());
		
		String pNeto = pdo.getPresentacion();
		if (pNeto!=null)
			if(pNeto.toUpperCase().contains("X"))
				txtPNeto.setValue(pNeto.substring(pNeto.indexOf("X")+2, pNeto.length()));
		
		txtDestino.setValue(pdo.getDestino());
		txtLatas.setValue(String.valueOf(pdo.getLatas()));

		txtObservacion.setValue(null);
	}
	
	/**
	 * carga la informacion de las maquina cerradoras a la lista M. Selladora
	 */
	private void cargaInfoMSelladora() {
		
		List<MaquinaCerradora> listaMCerradora = new MaquinaCerradoraDAOJpaImpl().getAll();
		
		if (listaMCerradora.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para maquina cerradora.");
			return;
		}
			
		lbxMSelladora.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new MaquinaCerradora());
		li.setParent(lbxMSelladora);
		
		for (MaquinaCerradora mCerradora : listaMCerradora) {
			li = new Listitem();
			li.setValue(mCerradora);
			new Listcell(mCerradora.getDescripcion()).setParent(li);
			li.setParent(lbxMSelladora);
		}
		
		lbxMSelladora.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaMCerradora(Integer idmaquinacerradora) {
		int index=0;
		for(Listitem li : (List<Listitem>)lbxMSelladora.getItems()) {
			if (idmaquinacerradora.equals(((MaquinaCerradora)li.getValue()).getIdmaquinacerradora())) {
				lbxMSelladora.setSelectedIndex(index);
				break;
			}
			index++;
		}
	}
	
	/**
	 * carga la informacion de Luthy en la lista Luthy
	 */
	private void cargaLuthy() {
		
		List<Luthy> listaLuthy = new LuthyDAOJpaImpl().getAll();
		
		if (listaLuthy.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion Luthy.");
			return;
		}
			
		lbxLuthy.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Luthy());
		li.setParent(lbxLuthy);
		
		for (Luthy luthy : listaLuthy) {
			li = new Listitem();
			li.setValue(luthy);
			new Listcell(luthy.getNumeroluthy().toString()).setParent(li);
			li.setParent(lbxLuthy);
		}
		
		lbxLuthy.setSelectedIndex(0);
	}
	
	public void onClick$btnEliminarItem() throws InterruptedException {
		lbxLista.getItems().clear();
		onClick$btnEliminar();
		binder.loadComponent(lbxLista);
	}
	/**
	 * Agrega los Luthy que se van a configurar
	 * @throws InterruptedException
	 */
	public void onClick$btnAgregarItem() throws InterruptedException{
		try {
			binder.loadComponent(lbxLista);
			
			Luthy luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
			
			Listitem li = new Listitem();
			
			li = new Listitem();
			li.setValue(new EnvasadoDetalleProcesoCambiosLuthy());
			
			//agrega cell al Listitem
			if (luthy.getNumeroluthy()==null) {
				Sistema.mensaje("Por favor seleccione un Luthy.");
				return;
			}
				
			Listcell listcellLuthy = new Listcell(luthy.getNumeroluthy().toString());
			listcellLuthy.setId(luthy.getIdluthy().toString());
			listcellLuthy.setParent(li);
			listcellLuthy.setValue(luthy);
			
			Checkbox cbxLuthy = new Checkbox();
			cbxLuthy.setChecked(false);
			cbxLuthy.setId("check"+luthy.getIdluthy());
			Listcell listcellCeck =new Listcell();
			listcellCeck.appendChild(cbxLuthy);
			listcellCeck.setParent(li);
			
			//agrega cell al Listitem
			li.setParent(lbxLista);
			
			lbxLuthy.setSelectedIndex(0);
			
			lbxLista.setVisible(true);
			
		} catch (Exception e) {
			if (e.getMessage()!=null)
				if (e.getMessage().contains("Not unique in the new ID")) {
					Sistema.mensaje("El Luthi "+lbxLuthy.getSelectedItem().getLabel()+" ya se encuentra agregado. Por favor seleccione otro Luthy.");
					lbxLuthy.setSelectedIndex(0);
					return;
				}
					
			Sistema.mensaje("Ocurrio un error no  esperado al cargar la informacion de los Luthy seleccionados.");
			e.printStackTrace();
		}
	}
	
	private void cargaLuthyConfigurado(List<EnvasadoDetalleProcesoCambiosLuthy> lsitaEdpcL){
		binder.loadComponent(lbxLista);
		
		LuthyDAO luthyDAO = new LuthyDAOJpaImpl();
		Luthy luthy = new Luthy();
		lbxLista.getItems().clear();
		
		for (EnvasadoDetalleProcesoCambiosLuthy eDPCL : lsitaEdpcL) {
			Listitem li = new Listitem();
			luthy = luthyDAO.getLuthyById(eDPCL.getLuthy().getIdluthy());
			Listcell listcellLuthy = new Listcell( luthy.getNumeroluthy().toString() );
			listcellLuthy.setId(luthy.getIdluthy().toString());
			listcellLuthy.setValue(luthy);
			listcellLuthy.setParent(li);
			
			Checkbox cbxLuthy = new Checkbox();
			cbxLuthy.setChecked(false);
			cbxLuthy.setId("check"+luthy.getIdluthy());
			Listcell listcellCeck =new Listcell();
			listcellCeck.appendChild(cbxLuthy);
			listcellCeck.setParent(li);
			
			li.setValue(eDPCL);
			li.setParent(lbxLista);
		}
		
		
		lbxLuthy.setSelectedIndex(0);
		
		lbxLista.setVisible(true);
		
		binder.loadComponent(lbxLista);
		
	}
	
	/**
	 * carga la informacion de tipo proteina que se encuentre configurada en la tabla.
	 */
	public void cargalbxTipoProteina() {
		EnvasadoCaldoVegetalProteinaDAO etpDAO = new EnvasadoCaldoVegetalProteinaDAOJpaImpl();
		List<EnvasadoCaldoVegetalProteina> listaEnvasadoCaldoVegetalProteina = etpDAO.getEnvasadoCaldoVegetalProteina();
		
		if (listaEnvasadoCaldoVegetalProteina.isEmpty()) {
			Sistema.mensaje("No se encuentra configuracion para Tipos de proteina.");
			return;
		}
			
		lbxTipoProteina.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoCaldoVegetalProteina());
		li.setParent(lbxTipoProteina);
		
		for (EnvasadoCaldoVegetalProteina ecvp : listaEnvasadoCaldoVegetalProteina) {
			li = new Listitem();
			li.setValue(ecvp);
			new Listcell(ecvp.getDescripcion()).setParent(li);
			li.setParent(lbxTipoProteina);
		}
		
		lbxTipoProteina.setSelectedIndex(0);
	}
	
	private void cargaMotivoCambio() {
		EnvasadoMotivoCambioDAO edpcDAO = new EnvasadoMotivoCambioDAOJpaImpl();
		List<EnvasadoMotivoCambio> listaEdpc = edpcDAO.getAll();
		
		lbxMotivoCambio.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoMotivoCambio());
		li.setParent(lbxMotivoCambio);
		
		for (EnvasadoMotivoCambio envasadoMotivoCambio : listaEdpc) {
			li = new Listitem();
			li.setValue(envasadoMotivoCambio);
			new Listcell(envasadoMotivoCambio.getDescripcion()).setParent(li);
			li.setParent(lbxMotivoCambio);
		}
		
		if (listaEdpc.isEmpty()) {
			Sistema.mensaje("Error. No existen motivos configurados en el sitema.");
			return;
		}
		lbxMotivoCambio.setSelectedIndex(0);
		
	}
	
	private void cargaProveedorTapa() {
		EnvasadoProveedorTapaDAO ecvpDAO = new EnvasadoProveedorTapaDAOJpaImpl();
		List<EnvasadoProveedorTapa> listEPT = ecvpDAO.getEnvasadoProveedorTapa();
		
		if (listEPT.isEmpty()) {
			Sistema.mensaje("No se encuentra configurado informacion para Caldo-Vegetal-Proteina.");
			return;
		}
		
		lbxProveedorTapa.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProveedorTapa());
		li.setParent(lbxProveedorTapa);
		
		for (EnvasadoProveedorTapa ept : listEPT) {
			li = new Listitem();
			li.setValue(ept);
			new Listcell(ept.getDescripcion()).setParent(li);
			li.setParent(lbxProveedorTapa);
		}
		
		lbxProveedorTapa.setSelectedIndex(0);
		
	}
	
	private void cargaProveedorLata() {
		EnvasadoProveedorLataDAO ecvpDAO = new EnvasadoProveedorLataDAOJpaImpl();
		List<EnvasadoProveedorLata> listEPL = ecvpDAO.getEnvasadoProveedorLata();
		
		if (listEPL.isEmpty()) {
			Sistema.mensaje("No se encuentra configurado informacion para Caldo-Vegetal-Proteina.");
			return;
		}
		
		lbxProveedorLata.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProveedorLata());
		li.setParent(lbxProveedorLata);
		
		for (EnvasadoProveedorLata epL : listEPL) {
			li = new Listitem();
			li.setValue(epL);
			new Listcell(epL.getDescripcion()).setParent(li);
			li.setParent(lbxProveedorLata);
		}
		
		lbxProveedorLata.setSelectedIndex(0);
		
	}
	
	/**
	 * carga el tipo proteina que se encuentre configurado para cambio en fill weigth 
	 */
	@SuppressWarnings("unchecked")
	public void cargaTipoProteinaConfigurado(Integer idTipoProteina) {
		int index=0;
		for(Listitem li : (List<Listitem>)lbxTipoProteina.getItems()) {
			if (idTipoProteina!=null)
				if (idTipoProteina.equals(((EnvasadoCaldoVegetalProteina)li.getValue()).getIdenvasadocaldovegetalproteina())) {
					lbxTipoProteina.setSelectedIndex(index);
					break;
				}
			index++;
		}
	}
	
	/**
	 * carga la informacion del motivo que se encuentre configurado para el cambio Fill Weigth.
	 * @param Idenvasadomotivocambios
	 */
	@SuppressWarnings("unchecked")
	public void cargaMotivoCambioConfigurado(Long Idenvasadomotivocambios) {
		
		int index=0;
		
		if (Idenvasadomotivocambios==null) {
			lbxMotivoCambio.setSelectedIndex(0);
			return;
		}
		for(Listitem li : (List<Listitem>)lbxMotivoCambio.getItems()) {
			if (Idenvasadomotivocambios.equals(((EnvasadoMotivoCambio)li.getValue()).getIdenvasadomotivocambios())) {
				lbxMotivoCambio.setSelectedIndex(index);
				break;
			}
			index++;
		}
	}
	
	/**
	 * carga el proveedor lata que se encuentre configurado para cambio en fill weigth 
	 */
	@SuppressWarnings("unchecked")
	public void cargaEnvasadoLata(Integer idEnvasadoLata) {
		int index=0;
		for(Listitem li : (List<Listitem>)lbxProveedorLata.getItems()) {
			if (idEnvasadoLata!=null)
				if (idEnvasadoLata.equals(((EnvasadoProveedorLata)li.getValue()).getIdenvasadoproveedorlatas())) {
					lbxProveedorLata.setSelectedIndex(index);
					break;
				}
			index++;
		}
	}
	
	/**
	 * carga el proveedor lata que se encuentre configurado para cambio en fill weigth 
	 */
	@SuppressWarnings("unchecked")
	public void cargaEnvasadoTapa(Integer idEnvasadoTapa) {
		int index=0;
		for(Listitem li : (List<Listitem>)lbxProveedorTapa.getItems()) {
			if (idEnvasadoTapa!=null)
				if (idEnvasadoTapa.equals(((EnvasadoProveedorTapa)li.getValue()).getIdenvasadoproveedortapa())) {
					lbxProveedorTapa.setSelectedIndex(index);
					break;
				}
			index++;
		}
	}
	
	/**
	 * elimina el listcell que se encuentre chekeado
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	public void onClick$btnEliminar() throws InterruptedException{
		try {
			List<Listitem> listLuthy = lbxLista.getItems();
			List<Listitem> luthysEliminado = new ArrayList<Listitem>();
			for (Listitem listitem : listLuthy) {
				Listcell cellCheck = (Listcell)listitem.getChildren().get(1);
				Checkbox checkLuthy = (Checkbox)cellCheck.getChildren().get(0);
				if (checkLuthy.isChecked())
					luthysEliminado.add(listitem);
			}
			 for(Listitem item : luthysEliminado)
				 lbxLista.getItems().remove(item);
			 if (listLuthy.size()<1)
				 lbxLista.setVisible(false);
			 binder.loadComponent(lbxLista);
		} catch(Exception e) {
			Sistema.mensaje("Ocurrio un error no esperado al intentar eliminar un Luthy seleccionado.");
			e.printStackTrace();
		}
	}
	
	/**
	 * carga los dias que contiene el mes seleccionado.
	 */
	public void onSelect$lbxMes(){
		cargaDiasMesSeleccionado();
	}
	
	private void cargaDiasMesSeleccionado(){
		int anio = Calendar.getInstance().get(Calendar.YEAR) - 1900;
		String mes="";
		lbxDias.getItems().clear();
		if (lbxMes.getSelectedItem().getValue()==null)
			return;
		mes = lbxMes.getSelectedItem().getValue().toString();
		Calendar c = new GregorianCalendar(anio, Integer.parseInt(mes)-1, 1);
		int dias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		Listitem li = new Listitem();
		li.setValue(new Integer("0"));
		li.setParent(lbxDias);
		
		for (int i=1 ; dias>=i ; i++) {
			li = new Listitem();
			li.setValue(i);
			new Listcell(String.valueOf(i)).setParent(li);
			li.setParent(lbxDias);
		}
		
		lbxDias.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaDia(int dia) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxDias.getItems()) {
			if ( (Integer)listitem.getValue() == dia )
				break;
			index++;
		}
		lbxDias.setSelectedIndex(index);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaMes(int mes) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxMes.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == mes )
					break;
			index++;
		}
		lbxMes.setSelectedIndex(index);
		
		cargaDiasMesSeleccionado();
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaHora(int hora) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxHoras.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == hora )
					break;
			index++;
		}
		lbxHoras.setSelectedIndex(index);
	}
	
	@SuppressWarnings("unchecked")
	private void seleccionaMinuto(int minuto) {
		int index=0;
		for (Listitem listitem : (List<Listitem>)lbxMinutos.getItems()) {
			if (listitem.getValue() != null)
				if ( Integer.valueOf(listitem.getValue().toString()) == minuto )
					break;
			index++;
		}
		lbxMinutos.setSelectedIndex(index);
	}

	private static int obtieneFechaCambio(Timestamp fechaCambio, int typeCalendar){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(fechaCambio.getTime()));
		return c.get(typeCalendar);
	}
	
	private Timestamp obtieneFechaRegistro() {
		String dia ="";
		String mes ="";
		String hora ="";
		String min ="";
		String mensaje = new String();
		
		if (lbxMinutos.getSelectedItem().getValue()!=null)
			min = lbxMinutos.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Minuto.";
		
		if(lbxHoras.getSelectedItem().getValue()!=null)
			hora = lbxHoras.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Hora.";
		
		if (lbxDias.getSelectedItem()!=null && lbxDias.getSelectedItem().getValue()!=null) {
			if (!"0".equals(lbxDias.getSelectedItem().getValue().toString()))
				dia = lbxDias.getSelectedItem().getValue().toString();
			else
				mensaje="Por favor seleccione un valor para Dia.";
		} else
			mensaje="Por favor seleccione un valor para Dia.";
		
		if (lbxMes.getSelectedItem().getValue()!=null)
			mes = lbxMes.getSelectedItem().getValue().toString();
		else
			mensaje="Por favor seleccione un valor para Mes.";
		
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		
		int second = Calendar.getInstance().get(Calendar.SECOND);

		String fechaCambio = anio+"-"+mes+"-"+dia+" "+hora+":"+min+":"+second;
		if (!mensaje.isEmpty()) {
			Sistema.mensaje(mensaje);
			return null;
		} else 
			return Timestamp.valueOf(fechaCambio);
	}

	public void onBlur$txtFill1() {
		Double fill1 = parseDouble(txtFill1.getValue());
		Double fill2 = parseDouble(txtFill2.getValue());
		Double promedio = (fill1+fill2)/2;
		txtFillPromedio.setValue(String.valueOf(promedio));
	}
	
	public void onBlur$txtFill2() {
		onBlur$txtFill1();
	}
	
	public void onClick$btnGrabarBot() {
		onClick$btnGrabar();
	}
	
	@SuppressWarnings("unchecked")
	public void onClick$btnGrabar() {
		try {
			EnvasadoDetalleProcesoCambioDAO daoJpa = new EnvasadoDetalleProcesoCambiosDAOJpaimpl(); 
			EnvasadoDetalleProcesoCambio edpc; 
			EnvasadoDetalleProcesoCambiosLuthy edpcL;
			EnvasadoDetalleProcesoCambiosLuthyDAO edpcLDAO = new EnvasadoDetalleProcesoCambiosLuthyDAOJpaimpl(); 
			List<EnvasadoDetalleProcesoCambiosLuthy> listaEdpcL = new ArrayList<EnvasadoDetalleProcesoCambiosLuthy>();
			
			
			//se extrae EnvasadoDetalleProcesoCambio para enlazar el id que se va a modificar.
			edpc = (EnvasadoDetalleProcesoCambio)lbxItemOrdenFillPresentacion.getSelectedItem().getValue();
			if(edpc.getIdenvasadodetalleprocesocambios()==null) {
				if (lbxItemOrdenFillPresentacion.getSelectedIndex()!=1) {
					Sistema.mensaje("Debe seleccionar un valor para el campo Item-Orden-Fill-Presentacion");
					return;
				}
			}
			
			//carga la informacion de EnvasadoProceso para enlazar con EnvasadoDetalleProcesoCambio
			EnvasadoProceso envasadoProceso = (EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue();
			edpc.setEnvasadoProceso(envasadoProceso);
			
			//se extrae ProduccionDetalleOrden para enlazar el id con EnvasadoDetalleProcesoCambio
			ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden) lbxItemOrden
					.getSelectedItem().getValue();
			if(produccionDetalleOrden.getIdproducciondetalleorden()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Item - Orden");
				return;
			}
			//prepara la informacion de la cabecera
			edpc.setProduccionDetalleOrden(produccionDetalleOrden);
			
			Turno turno = (Turno)lbxTurnoLabor.getSelectedItem().getValue();
			if (turno.getIdturno()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Turno Labor.");
				return;
			}
			edpc.setTurno(turno);
			
			MaquinaCerradora maquinaCerradora = (MaquinaCerradora) lbxMSelladora.getSelectedItem().getValue();
			if (maquinaCerradora.getIdmaquinacerradora()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo M. Cerradora");
				return;
			}
			edpc.setMaquinaCerradora(maquinaCerradora);
			
			//valida la informacion del usuario logueado
			String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
			if (idUsuario==null) {
				Sistema.mensaje("Error. Usuario no logueado.");
				return;
			}
			edpc.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
			
			//prepara la informacion del detalle
			if (lbxLista.getItems().isEmpty()) {
				Sistema.mensaje("Se debe agregar Luthy.");
				return;					
			}
			
			edpcLDAO.eliminaCambiosLuthy(edpc.getEnvasadoDetalleProcesoCambiosLuthies());
			
			for (Listitem listitem : (List<Listitem>)lbxLista.getItems()) {
				Listcell cellCheck = (Listcell)listitem.getChildren().get(0);
				if (cellCheck.getId()!=null) {
					edpcL = (EnvasadoDetalleProcesoCambiosLuthy)listitem.getValue();
					edpcL.setLuthy((Luthy)cellCheck.getValue());
					edpcL.setEnvasadoDetalleProcesoCambio(edpc);
					listaEdpcL.add(edpcL);
				}
			}
			edpc.setEnvasadoDetalleProcesoCambiosLuthies(listaEdpcL);
			
			EnvasadoCaldoVegetalProteina ecvp = (EnvasadoCaldoVegetalProteina)lbxTipoProteina.getSelectedItem().getValue();
			if (ecvp.getIdenvasadocaldovegetalproteina()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Tipo Proteina");
				return;
			}
			edpc.setEnvasadoCaldoVegetalProteina(ecvp);
			
			EnvasadoProveedorLata epl = (EnvasadoProveedorLata)lbxProveedorLata.getSelectedItem().getValue();
			if (epl.getIdenvasadoproveedorlatas()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Proveedor Lata");
				return;
			}
			edpc.setEnvasadoProveedorLata(epl);
			
			EnvasadoProveedorTapa ept = (EnvasadoProveedorTapa)lbxProveedorTapa.getSelectedItem().getValue();
			if (ept.getIdenvasadoproveedortapa()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Proveedor Tapa");
				return;
			}
			edpc.setEnvasadoProveedorTapa(ept);
			
			try {
				if (txtH2O.getValue()==null?true:txtH2O.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %H2O");
					txtH2O.setFocus(true);
					return;
				} else if(parseDouble(txtH2O.getValue()) < 0){
					Sistema.mensaje("El campo %H2O no permite numeros negativos.");
					txtH2O.setValue(null);
					txtH2O.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %H2O solo acepta numeros.");
				txtH2O.setValue(null);
				txtH2O.setFocus(true);
				return;
			}
			edpc.setAg(parseDouble(txtH2O.getValue()));//H2O = ag
			
			try {
				if (txtAceite.getValue()==null?true:txtAceite.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Aceite");
					txtAceite.setFocus(true);
					return;
				} else if(parseDouble(txtAceite.getValue()) < 0){
					Sistema.mensaje("El campo %Aceite no permite numeros negativos.");
					txtAceite.setValue(null);
					txtAceite.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Aceite solo acepta numeros.");
				txtAceite.setValue(null);
				txtAceite.setFocus(true);
				return;
			}
			edpc.setAc(parseDouble(txtAceite.getValue()));
			try {
				if (txtProteina.getValue()==null?true:txtProteina.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Proteina");
					txtProteina.setFocus(true);
					return;
				} else if(parseDouble(txtProteina.getValue()) < 0){
					Sistema.mensaje("El campo %Proteina no permite numeros negativos.");
					txtProteina.setValue(null);
					txtProteina.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Proteina solo acepta numeros.");
				txtProteina.setValue(null);
				txtProteina.setFocus(true);
				return;
			}	
			edpc.setPorcentajeproteina(parseDouble(txtProteina.getValue()));//aceite = AC
			
			if (txtCodVideoJet.getValue()==null?true:txtCodVideoJet.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Se debe agrega un valor para el campo Cod. Video Jet");
				txtCodVideoJet.setFocus(true);
				return;
			}else if (txtCodVideoJet.getValue().isEmpty()) {
				Sistema.mensaje("Se debe agrega un valor para el campo Cod. Video Jet");
				txtCodVideoJet.setFocus(true);
				return;
			}
			edpc.setCodvideojet(txtCodVideoJet.getValue());
			
			//tapa =visual
			//presentacion=producto visual
			try {
				if (txtDrenado.getValue()==null?true:txtDrenado.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo Drenado");
					txtDrenado.setFocus(true);
					return;
				} else if(parseDouble(txtDrenado.getValue()) < 0){
					Sistema.mensaje("El campo Drenado no permite numeros negativos.");
					txtDrenado.setValue(null);
					txtDrenado.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo Drenado solo acepta numeros.");
				txtDrenado.setValue(null);
				txtDrenado.setFocus(true);
				return;
			}	
			edpc.setDre(parseDouble(txtDrenado.getValue()));
			try {
				if (txtFlakes.getValue()==null?true:txtFlakes.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Flakes");
					txtFlakes.setFocus(true);
					return;
				} else if(parseDouble(txtFlakes.getValue()) < 0){
					Sistema.mensaje("El campo %Flakes no permite numeros negativos.");
					txtFlakes.setValue(null);
					txtFlakes.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo #Flakes solo acepta numeros.");
				txtFlakes.setValue(null);
				txtFlakes.setFocus(true);
				return;
			}
			edpc.setFlake(parseDouble(txtFlakes.getValue()));
			
			if (txtPNeto.getValue()==null?true:txtPNeto.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Se debe agrega un valor para el campo P. Neto");
				txtPNeto.setFocus(true);
				return;
			}
			edpc.setPesoneto(txtPNeto.getValue());
			//destino=visual
			try{
				if (txtLatas.getValue()==null?true:txtLatas.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo #Latas");
					txtLatas.setFocus(true);
					return;
				} else if(parseDouble(txtLatas.getValue()) < 0){
					Sistema.mensaje("El campo Latas no permite numeros negativos.");
					txtLatas.setValue(null);
					txtLatas.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo #Latas solo acepta numeros.");
				txtLatas.setValue(null);
				txtLatas.setFocus(true);
				return;
			}
			edpc.setLatas(parseDouble(txtLatas.getValue()));
			
			
			try {
				if (txtFill1.getValue()==null?true:txtFill1.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo "+lbFill1.getValue());
					txtFill1.setFocus(true);
					return;
				} else if(parseDouble(txtFill1.getValue()) < 0){
					Sistema.mensaje("El campo "+lbFill1.getValue()+" no permite numeros negativos.");
					txtFill1.setValue(null);
					txtFill1.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo "+lbFill1.getValue()+" solo acepta numeros.");
				txtFill1.setValue(null);
				txtFill1.setFocus(true);
				return;
			}
			edpc.setFillRango1(parseDouble(txtFill1.getValue()));
			
			try {
				if (txtFill2.getValue()==null?true:txtFill2.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo "+lbFill2.getValue());
					txtFill2.setFocus(true);
					return;
				} else if(parseDouble(txtFill2.getValue()) < 0){
					Sistema.mensaje("El campo "+lbFill2.getValue()+" no permite numeros negativos.");
					txtFill2.setValue(null);
					txtFill2.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo "+lbFill2.getValue()+" solo acepta numeros.");
				txtFill2.setValue(null);
				txtFill2.setFocus(true);
				return;
			}
			edpc.setFillRango2(parseDouble(txtFill2.getValue()));
			
			edpc.setFillPromedio(parseDouble(txtFillPromedio.getValue()));
			
			
			try {
				if (txtNetoFormulado.getValue()==null?true:txtNetoFormulado.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo P. Neto Formulado (g.)");
					txtNetoFormulado.setFocus(true);
					return;
				} else if(parseDouble(txtLatas.getValue()) < 0){
					Sistema.mensaje("El campo P. Neto Formulado (g.) no permite numeros negativos.");
					txtNetoFormulado.setValue(null);
					txtNetoFormulado.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo P. Neto Formulado (g.) solo acepta numeros.");
				txtNetoFormulado.setValue(null);
				txtNetoFormulado.setFocus(true);
				return;
			}
			edpc.setPesonetoformulado(parseDouble(txtNetoFormulado.getValue()));
			
			try {
				if (txtSalmuera.getValue()==null?true:txtSalmuera.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Salmuera");
					txtSalmuera.setFocus(true);
					return;
				} else if(parseDouble(txtSalmuera.getValue()) < 0){
					Sistema.mensaje("El campo %Salmuera no permite numeros negativos.");
					txtSalmuera.setValue(null);
					txtSalmuera.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Salmuera solo acepta numeros.");
				txtSalmuera.setValue(null);
				txtSalmuera.setFocus(true);
				return;
			}
			edpc.setSal(parseDouble(txtSalmuera.getValue()));
			
			try {
				if (txtConcentracion.getValue()==null?true:txtConcentracion.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo %Conc. CV");
					txtConcentracion.setFocus(true);
					return;
				} else if(parseDouble(txtConcentracion.getValue()) < 0){
					Sistema.mensaje("El campo %Conc. CV no permite numeros negativos.");
					txtConcentracion.setValue(null);
					txtConcentracion.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo %Conc. CV solo acepta numeros.");
				txtConcentracion.setValue(null);
				txtConcentracion.setFocus(true);
				return;
			}
			edpc.setConcentracion(parseDouble(txtConcentracion.getValue()));
			
			try {
				if (txtFormato.getValue()==null?true:txtFormato.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo Formato");
					txtFormato.setFocus(true);
					return;
				} else if(parseDouble(txtFormato.getValue()) < 0){
					Sistema.mensaje("El campo Formato no permite numeros negativos.");
					txtFormato.setValue(null);
					txtFormato.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo Formato solo acepta numeros.");
				txtFormato.setValue(null);
				txtFormato.setFocus(true);
				return;
			}
			edpc.setFormato(parseDouble(txtFormato.getValue()));
			
			try {
				if (txtDensidad.getValue()==null?true:txtDensidad.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Se debe agrega un valor para el campo Densidad");
					txtDensidad.setFocus(true);
					return;
				} else if(parseDouble(txtDensidad.getValue()) < 0){
					Sistema.mensaje("El campo Densidad no permite numeros negativos.");
					txtDensidad.setValue(null);
					txtDensidad.setFocus(true);
					return;
				}
			} catch(Exception e) {
				Sistema.mensaje("El campo Densidad solo acepta numeros.");
				txtDensidad.setValue(null);
				txtDensidad.setFocus(true);
				return;
			}
			edpc.setDensidad(parseDouble(txtDensidad.getValue()));
			
			Timestamp fechaRegistro = obtieneFechaRegistro();
			if (fechaRegistro==null)
				return;
			edpc.setFechacambio(fechaRegistro);
			edpc.setFechareg(new Timestamp(System.currentTimeMillis()));
			
			EnvasadoMotivoCambio emc = (EnvasadoMotivoCambio) lbxMotivoCambio.getSelectedItem().getValue();
			if (emc.getIdenvasadomotivocambios()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el motivo del cambio.");
				return;
			}
			edpc.setEnvasadoMotivoCambio(emc);
			
			edpc.setObservacion(txtObservacion.getValue());
			
			verificaCambiosValorInicial(edpc);
			
			List<EnvasadoDetalleProcesoCambiosLuthy> edpcl = daoJpa.saveOrUpdate(edpc).getEnvasadoDetalleProcesoCambiosLuthies();
			
			cargaLuthyConfigurado(edpcl);
			
			Sistema.mensaje("Cambios guardados exitosamente.");
			
//			limpiarFormulario(); 
			cargaItemOdenFillPresentacion();
			selecionaItemOrdenFillPresentacion();
			binder.loadAll();
		} catch(Exception e) {
			Sistema.mensaje("Ocurrio un error al intentar guardar la informacion.");
			e.printStackTrace();
			
		}
	}
	
	
	private boolean verificaCambiosValorInicial(EnvasadoDetalleProcesoCambio edpc) {
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden) lbxItemOrden.getSelectedItem()
				.getValue();

		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
		EnvasadoFichaTecnica eft = eftDAO.getByOrden(pdo.getIdproducciondetalleorden());

		edpc.setCodvideojetcambio(
				verificaCambios(edpc.getCodvideojet(), pdo.getVideo()));
		edpc.setFillRango1Cambio(
				verificaCambios(edpc.getFillRango1(), eft.getFillRango1()));
		edpc.setFillRango2Cambio(
				verificaCambios(edpc.getFillRango2(), eft.getFillRango2()));
		edpc.setFillPromedioCambio(
				verificaCambios(edpc.getFillPromedio(), eft.getFillPromedio()));
		edpc.setPesonetoformuladocambio(
				verificaCambios(edpc.getPesonetoformulado(), eft.getPesoNetoFormulado()));
		edpc.setFlakecambio(
				verificaCambios(edpc.getFlake(), pdo.getFlake()));
		edpc.setAgcambio(
				verificaCambios(edpc.getAg(), eft.getAgua()));
		edpc.setAccambio(
				verificaCambios(edpc.getAc(), eft.getAceite()));
		edpc.setEnvasadocaldovegetalproteinacambio(
				verificaCambios(edpc.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina(),eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()));
		edpc.setPorcentajeproteinacambio(
				verificaCambios(edpc.getPorcentajeproteina(), eft.getCaldoVegetal()));
		edpc.setSalcambio(
				verificaCambios(edpc.getSal(), eft.getSal()));
		edpc.setConcentracioncambio(
				verificaCambios(edpc.getConcentracion(), eft.getConcentracion()));
		edpc.setFormatocambio(
				verificaCambios(edpc.getFormato(), pdo.getFormato()));
		edpc.setDensidadcambio(
				verificaCambios(edpc.getDensidad(), eft.getDensidad()));
		edpc.setEnvasadoproveedorlatascambio(
				verificaCambios(edpc.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas(), eft.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas()));
		edpc.setEnvasadoproveedortapacambio(
				verificaCambios(edpc.getEnvasadoProveedorTapa().getIdenvasadoproveedortapa(), eft.getEnvasadoProveedorTapa().getIdenvasadoproveedortapa()));
		
		return false;
	}
	
	private boolean verificaCambios(Object valorInicial, Object valorCambio) {
		if (valorInicial==null&&valorCambio==null)
			return false;
		if (valorInicial==null&&valorCambio!=null)
			return true;
		if (valorInicial!=null&&valorCambio==null)
			return true;
		
		if (valorInicial.equals(valorCambio))
			return false;
		else 
			return true;
	}
	
	@SuppressWarnings("unchecked")
	private void selecionaItemOrdenFillPresentacion(){
		List<Listitem> listaLI = (List<Listitem>)lbxItemOrdenFillPresentacion.getItems();
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
		int index=0;
		for(Listitem li : listaLI) {
			EnvasadoDetalleProcesoCambio edpc = (EnvasadoDetalleProcesoCambio) li.getValue();
			if(edpc.getProduccionDetalleOrden()!=null)
				if (edpc.getProduccionDetalleOrden().getIdproducciondetalleorden().equals(pdo.getIdproducciondetalleorden()))
					break;
			index++;
		}
		lbxItemOrdenFillPresentacion.setSelectedIndex(index);
	}
	
	public void onClick$btnEliminarAll(){
		if(!chkEliminar.isChecked()) {
			Sistema.mensaje("Debe confirmar para poder eliminar.");
			return;
		}
		
		EnvasadoDetalleProcesoCambio edpc = (EnvasadoDetalleProcesoCambio)lbxItemOrdenFillPresentacion.getSelectedItem().getValue();
		if(edpc.getIdenvasadodetalleprocesocambios()==null) {
			Sistema.mensaje("Debe seleccionar un valor Item-Orden-Fill-Presentacion para eliminar.");
			return;
		}
		
		EnvasadoDetalleProcesoCambioDAO edpcDAO = new  EnvasadoDetalleProcesoCambiosDAOJpaimpl();
		
		EnvasadoDetalleProcesoCambiosLuthyDAO edpcLDAO = new  EnvasadoDetalleProcesoCambiosLuthyDAOJpaimpl();
		
		if (!edpcLDAO.eliminaCambiosLuthy(edpc.getEnvasadoDetalleProcesoCambiosLuthies())) {
			Sistema.mensaje("Registro en uso");
			return;
		}
			
		
		if (edpcDAO.delete(edpc)) {
			Sistema.mensaje("Formato Eliminado");
			limpiarFormulario();
		} else {
			Sistema.mensaje("Registro en uso");
			return;
		}
			
	}
	
	/**
	 * carga la informacion del campo Item - Orden bajo los parametros idTurno, IdProduccion
	 * @param idturno
	 * @param idproduccion
	 */
	public void cargaItemOrden(Integer idturno, Long idproduccion) {

		ProduccionDetalleOrdenDAO pdoDAOJpa = new ProduccionDetalleOrdenDAOJpaImpl();
		
		List<ProduccionDetalleOrden> listaProduccionDetalleOrden = pdoDAOJpa
				.obtieneDetalleOrdenByProduccionTurno(idturno, idproduccion);
		
		String itemOrden;
		
//		if (listaProduccionDetalleOrden.isEmpty()) {
//			Sistema.mensaje("No existe informacion Item-Orden para la produccion " + txtProduccionTurno.getValue());
//			return;
//		}
		
		lbxItemOrden.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrden);
		
		for (ProduccionDetalleOrden produccionDetalleOrden : listaProduccionDetalleOrden) {
			itemOrden = produccionDetalleOrden.getItem() + " - " + produccionDetalleOrden.getOrden();
			li = new Listitem();
			li.setValue(produccionDetalleOrden);
			new Listcell(itemOrden).setParent(li);
			li.setParent(lbxItemOrden);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	private void limpiarFormulario() {
		
		if(lbxItemOrdenFillPresentacion.getSelectedIndex()==1) {
			
			lbxItemOrdenFillPresentacion.setSelectedIndex(1);
			cargaItemOrden( ((EnvasadoProceso)lbxTurnoProduccion.getSelectedItem().getValue()).getTurno().getIdturno(), produccion.getIdproduccion());
		}else {
			cargaItemOdenFillPresentacion();
			binder.loadComponent(lbxItemOrdenFillPresentacion);
			if (!lbxItemOrden.getItems().isEmpty())
				lbxItemOrden.setSelectedIndex(0);
		}
			
		lbxTurnoLabor.setSelectedIndex(0);
		
		txtFill1.setValue(null);
		txtFill2.setValue(null);
		txtFillPromedio.setValue(null);
		
		txtNetoFormulado.setValue(null);
 		txtSalmuera.setValue(null);
 		txtConcentracion.setValue(null);
 		txtFormato.setValue(null);
 		txtDensidad.setValue(null);
 		
		txtOrden.setValue(null);
		txtProducto.setValue(null);
		txtMarca.setValue(null);
		lbxMSelladora.setSelectedIndex(0);
		lbxLista.getItems().clear();
		lbxLista.setVisible(false);
		lbxTipoProteina.setSelectedIndex(0);
		lbxProveedorLata.setSelectedIndex(0);
		lbxProveedorTapa.setSelectedIndex(0);
		txtCodVideoJet.setValue(null);
		txtH2O.setValue(null);
		txtAceite.setValue(null);
		txtProteina.setValue(null);
		txtTapa.setValue(null);
		txtPresentacion.setValue(null);
		txtDrenado.setValue(null);
		txtFlakes.setValue(null);
		txtCodVideoJet.setValue(null);
		txtPNeto.setValue(null);
		txtDestino.setValue(null);
		txtLatas.setValue(null);
		lbxMes.setSelectedIndex(0);
		lbxDias.getItems().clear();
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);
		txtObservacion.setValue(null);
		lbxMotivoCambio.setSelectedIndex(0);
		chkEliminar.setChecked(false);
	}
	
	/**
	 * valida el valor del punto o la coma para el tipo de dato Double
	 * @param valor
	 * @return
	 */
	private static Double parseDouble(String valor) {
		try {
			//retorna el valor recibido
			return Double.valueOf(valor);
		} catch(Exception e){
			try {
				//retorna el valor reemplazando el punto por la coma.
				if (valor !=null)
					if (!valor.isEmpty())
						return new Double(valor.replaceAll("\\.", ","));
				return Double.valueOf(valor);
			}catch(Exception e1) {
				try {
					if (valor !=null)
						if (!valor.isEmpty())
							return new Double(valor.replaceAll(",", "\\."));
					return Double.valueOf(valor);
				}catch(Exception e2) {
//					e.printStackTrace();
					return new Double("");
				}
			}
		}
	}
}


