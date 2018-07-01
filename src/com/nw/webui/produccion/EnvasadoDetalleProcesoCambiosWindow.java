package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.EnvasadoMotivoCambioDAO;
import com.nw.model.dao.EnvasadoProveedorLataDAO;
import com.nw.model.dao.EnvasadoProveedorTapaDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoDetalleProcesoCambiosDAOJpaimpl;
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
public class EnvasadoDetalleProcesoCambiosWindow extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
	private static final Integer ESTADO = 1; 
	AnnotateDataBinder binder;
	
	Textbox txtNetoFormulado, txtSalmuera, txtConcentracion, txtDensidad;
	
	Label txtProduccionTurno, txtProducto, txtOrden, txtMarca;
	Textbox txtCodVideoJet, txtFormato, txtTapa, txtPresentacion, txtPNeto, txtDestino, txtObservacion;
	Listbox lbxTurnoLabor, lbxItemOrden, lbxMSelladora, lbxLuthy, lbxLista, lbxTipoProteina, lbxMotivoCambio;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	Textbox txtH2O, txtAceite, txtProteina, txtDrenado, txtFlakes, txtLatas;
	
	Label 	lbFill1,  lbFill2,  lbFillPromedio;
	Textbox txtFill1, txtFill2, txtFillPromedio;
	
	Label 	lbProveedorLata,  lbProveedorTapa;
	Listbox lbxProveedorLata, lbxProveedorTapa;
	
	//se carga con el metodo cargaProduccionTurno()
	private Turno turno;
	//se carga con el metodo cargaProduccionTurno()
	private Produccion produccion;
	
	private EnvasadoProceso envasadoProceso;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		String cargaProduccionTurno = cargaProduccionTurno();
		if (cargaProduccionTurno==null)
			return;
		
		txtProduccionTurno.setValue(cargaProduccionTurno());
		cargaInfoInicial();
		
		binder.loadAll();
	}
	
	public void cargaInfoInicial(){
		cargarListaTurnoLabor();
		cargaItemOrden(turno.getIdturno(), produccion.getIdproduccion());
		cargaInfoMSelladora();
		cargaLuthy();
		cargalbxTipoProteina();
		cargaMotivoCambio();
		cargaProveedorTapa();
		cargaProveedorLata();
	}
	
	/**
	 * se encarga de realizar las primeras validaciones en el zul y Carga&Valida
	 * la informacion de produccion y turno
	 * 
	 * @return
	 */
	private String cargaProduccionTurno(){
		Date fechaProduccion;
		String formatoProduccion;
		envasadoProceso = cargaEnvasadoProceso();
		if (envasadoProceso==null) {
			Sistema.mensaje("No existe proceso activo.");
			return null;
		}
	
		fechaProduccion = envasadoProceso.getProduccion().getFechaproduccion();
		formatoProduccion = new SimpleDateFormat("dd/MM/yyyy").format(fechaProduccion);
			
		this.produccion = cargaProduccion(envasadoProceso);
		if (produccion==null) {
			Sistema.mensaje("La produccion " + formatoProduccion + " no se encuentra configurada.");
			return null;
		}
		
		this.turno = cargaTurno(envasadoProceso);
		if (turno == null) {
			Sistema.mensaje("El turno " + envasadoProceso.getTurno().getNombre() + " no se encuentra configurada.");
			return null;
		}
		return formatoProduccion +" - "+turno.getNombre();
	}
	
	/**
	 * 
	 */
	public void cargarListaTurnoLabor(){
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
		
		if (listaProduccionDetalleOrden.isEmpty()) {
			Sistema.mensaje("No existe informacion Item-Orden para la produccion " + txtProduccionTurno.getValue());
			return;
		}
		
		lbxItemOrden.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrden);
		
		for (ProduccionDetalleOrden produccionDetalleOrden : listaProduccionDetalleOrden) {
			itemOrden = produccionDetalleOrden.getItem() 
					+ " - " + produccionDetalleOrden.getOrden()
					+ " - " + produccionDetalleOrden.getPs()
					+ " - " + produccionDetalleOrden.getCliente()
					+ " - " + produccionDetalleOrden.getMarca();
			
			li = new Listitem();
			li.setValue(produccionDetalleOrden);
			new Listcell(itemOrden).setParent(li);
			li.setParent(lbxItemOrden);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	/**
	 * carga la informacion de los campos Orden y Producto
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	public void onSelect$lbxItemOrden() throws InterruptedException{
		try {
			ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden) lbxItemOrden
					.getSelectedItem().getValue();
			
			EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
			EnvasadoFichaTecnica eft = eftDAO.getByOrden(produccionDetalleOrden.getIdproducciondetalleorden());
			
			lbxProveedorLata.setSelectedIndex(0);
			for(Listitem li : (List<Listitem>)lbxProveedorLata.getItems()) {
				if (eft.getEnvasadoProveedorLata()!=null)
					if(eft.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas()
							.equals(((EnvasadoProveedorLata)li.getValue()).getIdenvasadoproveedorlatas())){
						lbxProveedorLata.setSelectedItem(li);
						break;
					}
			}
			
			lbxProveedorTapa.setSelectedIndex(0);
			for(Listitem li : (List<Listitem>)lbxProveedorTapa.getItems()) {
				if (eft.getEnvasadoProveedorTapa()!=null)
					if(eft.getEnvasadoProveedorTapa().getIdenvasadoproveedortapa()
							.equals(((EnvasadoProveedorTapa)li.getValue()).getIdenvasadoproveedortapa())){
						lbxProveedorTapa.setSelectedItem(li);
						break;
					}
			}
			
			if (eft.getIdenvasadofichatecnica()==null) {
				txtFill1.setValue(null);
				txtFill2.setValue(null);
				txtFillPromedio.setValue(null);
				
				txtNetoFormulado.setValue(null);
				txtH2O.setValue(null);
				txtAceite.setValue(null);
				txtProteina.setValue(null);
				txtSalmuera.setValue(null);
				txtConcentracion.setValue(null);
				txtDensidad.setValue(null);
			} else {
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
			}
			
			if (produccionDetalleOrden.getIdproducciondetalleorden()!=null) {
				
				txtOrden.setValue(produccionDetalleOrden.getOrden());
				txtProducto.setValue(produccionDetalleOrden.getProducto());
				txtMarca.setValue(produccionDetalleOrden.getMarca());
				txtFormato.setValue(String.valueOf(produccionDetalleOrden.getFormato()));
				
				txtTapa.setValue(produccionDetalleOrden.getTapa());
				txtPresentacion.setValue(produccionDetalleOrden.getProducto());
				txtDrenado.setValue(String.valueOf(produccionDetalleOrden.getDre()));
				txtFlakes.setValue(String.valueOf(produccionDetalleOrden.getFlake()));
				txtCodVideoJet.setValue(produccionDetalleOrden.getVideo());
				
				for(Listitem li : (List<Listitem>)lbxTipoProteina.getItems()) {
					if (eft.getEnvasadoCaldoVegetalProteina()!=null) {
						if(eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
								.equals(((EnvasadoCaldoVegetalProteina)li.getValue()).getIdenvasadocaldovegetalproteina())){
							lbxTipoProteina.setSelectedItem(li);
							break;
						}
					} else {
						lbxTipoProteina.setSelectedIndex(0);
					}
				}
				
				
				String pNeto = produccionDetalleOrden.getPresentacion();
				if (pNeto!=null)
					if(pNeto.toUpperCase().contains("X"))
						txtPNeto.setValue(pNeto.substring(pNeto.indexOf("X")+2, pNeto.length()));

				txtDestino.setValue(produccionDetalleOrden.getDestino());
				txtLatas.setValue(null);
			} else {
				txtOrden.setValue(null);
				txtProducto.setValue(null);
				txtMarca.setValue(null);
				txtH2O.setValue(null);
				txtAceite.setValue(null);
				txtTapa.setValue(null);
				txtPresentacion.setValue(null);
				txtDrenado.setValue(null);
				txtFlakes.setValue(null);
				txtCodVideoJet.setValue(null);
				txtPNeto.setValue(null);
				txtDestino.setValue(null);
				txtLatas.setValue(null);
				txtFill1.setValue(null);
				txtFill2.setValue(null);
				txtFillPromedio.setValue(null);
				txtNetoFormulado.setValue(null);
				txtSalmuera.setValue(null);
				txtConcentracion.setValue(null);
				txtFormato.setValue(null);
				lbxTipoProteina.setSelectedIndex(0);
				txtDensidad.setValue(null);
			}
			
		
		} catch (Exception e) {
			Sistema.mensaje("Ocurrio un error no  esperado al cargar la informacion de Orden y Producto");
			System.out.println("Mensaje de error " + e.getMessage());
		}
	}
	
	/**
	 * carga la informacion de las maquina cerradoras a la lista M. Selladora
	 */
	public void cargaInfoMSelladora() {
		
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
	
	/**
	 * carga la informacion de Luthy en la lista Luthy
	 */
	public void cargaLuthy() {
		
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
//	public void onSelect$lbxLuthy() throws InterruptedException{
	public void onClick$btnAgregarItem() throws InterruptedException{
		try {
			binder.loadComponent(lbxLista);
			
			Luthy luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
			
			Listitem li = new Listitem();
//			li.setValue(new Luthy());
//			li.setParent(lbxLista);
			
			li = new Listitem();
			li.setValue(luthy);
			
			//agrega cell al Listitem
			if (luthy.getNumeroluthy()==null) {
				Sistema.mensaje("Por favor seleccione un Luthy.");
				return;
			}
				
			Listcell listcellLuthy = new Listcell(luthy.getNumeroluthy().toString());
			listcellLuthy.setId(luthy.getIdluthy().toString());
			listcellLuthy.setValue(luthy);
			listcellLuthy.setParent(li);
			
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
	/**
	 * elimina el listcell que se encuentre chekeado
	 * @throws InterruptedException
	 */
	public void onClick$btnEliminar() throws InterruptedException{
		try {
			 @SuppressWarnings("unchecked")
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
			EnvasadoDetalleProcesoCambio edpc = new EnvasadoDetalleProcesoCambio(); 
			EnvasadoDetalleProcesoCambiosLuthy edpcL;
			
			ProduccionDetalleOrden produccionDetalleOrden = (ProduccionDetalleOrden) lbxItemOrden
					.getSelectedItem().getValue();
			
			//prepara la informacion de la cabecera
			
			edpc.setProduccionDetalleOrden(produccionDetalleOrden);
			edpc.setEnvasadoProceso(envasadoProceso);
			
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
			
			edpc.setEnvasadoDetalleProcesoCambiosLuthies(new ArrayList<EnvasadoDetalleProcesoCambiosLuthy>());
			for (Listitem listitem : (List<Listitem>)lbxLista.getItems()) {
				Listcell cellCheck = (Listcell)listitem.getChildren().get(0);
				if (cellCheck.getId()!=null) {
					edpcL = new EnvasadoDetalleProcesoCambiosLuthy();
					edpcL.setLuthy((Luthy)cellCheck.getValue());
					edpcL.setEnvasadoDetalleProcesoCambio(edpc);
					edpc.addEnvasadoDetalleProcesoCambiosLuthy(edpcL);
				}
			}
			
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
			edpc.setAc(parseDouble(txtAceite.getValue()));//aceite = AC
			
			EnvasadoCaldoVegetalProteina envasadoCaldoVegetalProteina = (EnvasadoCaldoVegetalProteina) lbxTipoProteina.getSelectedItem().getValue();
			if (envasadoCaldoVegetalProteina.getIdenvasadocaldovegetalproteina()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Tipo Proteina");
				return;
			}
			edpc.setEnvasadoCaldoVegetalProteina(envasadoCaldoVegetalProteina);
			
			EnvasadoProveedorLata epl = (EnvasadoProveedorLata) lbxProveedorLata.getSelectedItem().getValue();
			if (epl.getIdenvasadoproveedorlatas()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Envasado de Latas");
				return;
			}
			edpc.setEnvasadoProveedorLata(epl);
			
			EnvasadoProveedorTapa ept = (EnvasadoProveedorTapa) lbxProveedorTapa.getSelectedItem().getValue();
			if (ept.getIdenvasadoproveedortapa()==null) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Envasado de Tapa");
				return;
			}
			edpc.setEnvasadoProveedorTapa(ept);
			
			try {
				if (txtProteina.getValue()==null?true:txtProteina.getValue().isEmpty()?true:false) {
					Sistema.mensaje("Debe seleccionar un valor para el campo %Proteina");
					txtProteina.setFocus(true);
					return;
				} else if(parseDouble(txtProteina.getValue()) < 0){
					Sistema.mensaje("Debe seleccionar un valor para el campo %Proteina");
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
			edpc.setPorcentajeproteina(parseDouble(txtProteina.getValue()));
			
			if (txtCodVideoJet.getValue()==null?true:txtCodVideoJet.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Debe seleccionar un valor para el campo Cod. Video Jet");
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
			edpc.setDre(parseDouble(txtDrenado.getValue()));//drenado = DRE
			
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
				Sistema.mensaje("El campo %Flakes solo acepta numeros.");
				txtFlakes.setValue(null);
				txtFlakes.setFocus(true);
				return;
			}
			edpc.setFlake(parseDouble(txtFlakes.getValue()));
			
			if (txtPNeto.getValue()==null?true:txtPNeto.getValue().isEmpty()?true:false) {
				Sistema.mensaje("Debe seleccionar un valor para el campo P. Neto");
				txtPNeto.setFocus(true);
				return;
			}
			edpc.setPesoneto(txtPNeto.getValue());
			//destino=visual
			try {
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
				Sistema.mensaje("El campo Latas solo acepta numeros.");
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
				} else if(parseDouble(txtNetoFormulado.getValue()) < 0){
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
			
			if (!isEnvasadoProcesoActivo()) {
				Sistema.mensaje("El registro de envasado proceso se ha cerrado durante su modificacion.");
				return;
			}
			
			verificaCambiosValorInicial(edpc);
			
			daoJpa.saveOrUpdate(edpc);
			
			Sistema.mensaje("Cambios guardados exitosamente.");
			
			limpiarFormulario(); 
			
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
		if (edpc.getEnvasadoCaldoVegetalProteina()!=null)
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
		if (edpc.getEnvasadoProveedorLata()!=null)
			edpc.setEnvasadoproveedorlatascambio(
					verificaCambios(edpc.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas(), eft.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas()));
		if (edpc.getEnvasadoProveedorTapa()!=null)
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
	
	
	/*********************************************************************************/
	/*******************************UTILIDADES****************************************/
	/*********************************************************************************/
	private boolean isEnvasadoProcesoActivo(){
		
		EnvasadoProcesoDAOJpaImpl epDAOJpa = new EnvasadoProcesoDAOJpaImpl();
		EnvasadoProceso envasadoProceso = epDAOJpa.getEnvasadoProcesoByEstado(ESTADO);
		
		if (this.envasadoProceso.getIdenvasadoproceso() != envasadoProceso.getIdenvasadoproceso())
			return false;
		else
			return true;
	}
	
	public void onSelect$lbxMes(){
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
	
	private EnvasadoProceso cargaEnvasadoProceso(){
		EnvasadoProcesoDAOJpaImpl epJpa = new EnvasadoProcesoDAOJpaImpl();
		return epJpa.getEnvasadoProcesoByEstado(ESTADO);
	}
	
	private Produccion cargaProduccion(EnvasadoProceso ep) {
		ProduccionDAOJpaImpl pJpa = new ProduccionDAOJpaImpl();
		return pJpa.getProduccionById(ep.getProduccion().getIdproduccion());
	}
	
	private Turno cargaTurno(EnvasadoProceso ep) {
		TurnoDAOJpaImpl tJpa = new TurnoDAOJpaImpl();
		return tJpa.getFindTurnoId(ep.getTurno().getIdturno());
	}
	
	private void limpiarFormulario() {
		//Limpia Texto
		txtOrden.setValue("");
		txtProducto.setValue("");
		txtMarca.setValue(null);
		txtTapa.setValue("");
		txtPresentacion.setValue("");
		txtDestino.setValue("");
		txtObservacion.setValue("");
		txtCodVideoJet.setValue("");
		txtPNeto.setValue("");
		
		txtNetoFormulado.setValue(null);
		txtFill1.setValue(null);
		txtFill2.setValue(null);
		txtFillPromedio.setValue(null);
		txtSalmuera.setValue(null);
		txtConcentracion.setValue(null);
		txtFormato.setValue(null);
		txtDensidad.setValue(null);
		
		lbxTurnoLabor.getItems().clear();
		lbxItemOrden.getItems().clear();
		lbxMSelladora.getItems().clear();
		lbxLuthy.getItems().clear();
		lbxLista.getItems().clear();
		lbxLista.setVisible(false);
		lbxTipoProteina.setSelectedIndex(0);
		lbxProveedorLata.setSelectedIndex(0);
		lbxProveedorTapa.setSelectedIndex(0);
		
		lbxMes.setSelectedIndex(0);
		lbxDias.setSelectedIndex(0);
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);

//		Checkbox cbxLuthy;
		
		//Limpia Double
		txtFlakes.setValue(null);
		txtLatas.setValue(null);
		txtH2O.setValue(null);
		txtAceite.setValue(null);
		txtDrenado.setValue(null);
		txtProteina.setValue(null);
		
		cargaInfoInicial();
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

