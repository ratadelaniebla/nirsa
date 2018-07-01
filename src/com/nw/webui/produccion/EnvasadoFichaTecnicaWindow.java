package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.EnvasadoProceso;
import com.nw.model.EnvasadoProveedorLata;
import com.nw.model.EnvasadoProveedorTapa;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.EnvasadoProveedorLataDAO;
import com.nw.model.dao.EnvasadoProveedorTapaDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoFichaTecnicaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProveedorLataDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProveedorTapaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;

/**
 * 
 * @author Cls Mbaque
 * @since 15/05/2018
 */
public class EnvasadoFichaTecnicaWindow extends GenericForwardComposer {

	//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoFillWindow.class);
	private static final long serialVersionUID = 1L;
	private static final Integer ESTADO = 1;
	
	AnnotateDataBinder binder;
	
	EnvasadoFichaTecnica eft;
	ProduccionDetalleOrden pdo;
	EnvasadoProceso envasadoProceso;
	Produccion produccion;
	Turno turno;
	
	Textbox txtProduccionTurno, txtProducto, txtObservacion;
	Listbox lbxTurnoLabor, lbxItemOrdenCLiente, lbxcvprot;
	
	Textbox txtFormato2, txtFormato, txtPNetoFormulado, txtAgua, txtAceite, txtCaldoVegetal, txtConcentracion, txtSal, txtDensidad, txtTrozo, txtLomo, txtRallado;
	Label   lbFormato2,  lbFormato,  lbPNetoFormulado,  lbAgua,  lbAceite,  lbCaldoVegetal,  lbConcentracion,  lbSal,  lbDensidad,  lbTrozo,  lbLomo, lbRallado;
	
	Textbox txtFillPlanificado, txtFill1, txtFill2, txtFillPromedio, txtPesoNeto, txtPesoDrenado, txtAguaAc, txtAceiteAg, txtEnvase, txtTapa;
	Label	lbFillPlanificado,  lbFill1,  lbFill2,  lbFillPromedio,  lbPesoNeto,  lbPesoDrenado,  lbAguaAc,  lbAceiteAg,  lbEnvase,  lbTapa;
	
	Textbox txtEspecie, txtTamEnvase, txtTipoTapa, txtFlakeMax, txtCantCajas, txtVideoJet, txtMaqLlenadora, txtMaqCerradora, txtFlake;
	Label   lbEspecie,  lbTamEnvase,  lbTipoTapa,  lbFlakeMax,  lbCantCajas,  lbVideoJet,  lbMaqLlenadora,  lbCerradora,  lbFlakes;
	
	Textbox txtProveedorLoteEnvase, txtProveedorLoteTapa;
	Label 	lbProveedorLoteEnvase, 	lbProveedorLoteTapa;
	
	Label 	lbProveedorEnvase,  lbProveedorTapa;
	Listbox lbxProveedorEnvase, lbxProveedorTapa;
	
	Label lbTurnoLabor, lbItemOrden, lbcvprot;
	
	Checkbox cbxEliminar;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		cargaInicial();
	}
	
	private void cargaInicial() {
		txtProduccionTurno.setValue(cargaProduccionTurno());
		cargaTurno();
		cargaItemOrden(turno.getIdturno(), produccion.getIdproduccion());
		cargaCVPROT();
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
		
		EnvasadoProcesoDAOJpaImpl epJpa = new EnvasadoProcesoDAOJpaImpl();
		envasadoProceso = epJpa.getEnvasadoProcesoByEstado(ESTADO);
		
		if (envasadoProceso==null) {
			Sistema.mensaje("No existe proceso activo.");
			return null;
		}
	
		fechaProduccion = envasadoProceso.getProduccion().getFechaproduccion();
		formatoProduccion = new SimpleDateFormat("dd/MM/yyyy").format(fechaProduccion);
			
		ProduccionDAOJpaImpl pJpa = new ProduccionDAOJpaImpl();
		this.produccion = pJpa.getProduccionById(envasadoProceso.getProduccion().getIdproduccion());
		
		if (produccion==null) {
			Sistema.mensaje("La produccion " + formatoProduccion + " no se encuentra configurada.");
			return null;
		}
		
		TurnoDAOJpaImpl tJpa = new TurnoDAOJpaImpl();
		this.turno = tJpa.getFindTurnoId(envasadoProceso.getTurno().getIdturno());
		
		if (turno.getIdturno() == null) {
			Sistema.mensaje("El turno " + envasadoProceso.getTurno().getNombre() + " no se encuentra configurada.");
			return null;
		}
		return formatoProduccion +" - "+turno.getNombre();
	}
	
	/**
	 * carga la informacion de la lista Turno Labor
	 */
	private void cargaTurno() {
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
		
		lbxItemOrdenCLiente.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionDetalleOrden());
		li.setParent(lbxItemOrdenCLiente);
		
		for (ProduccionDetalleOrden produccionDetalleOrden : listaProduccionDetalleOrden) {
			System.out.println(produccionDetalleOrden.getIdproducciondetalleorden());
			itemOrden = produccionDetalleOrden.getItem() 
					+ " - " + produccionDetalleOrden.getOrden()
					+ " - " + produccionDetalleOrden.getPs()
					+ " - " + produccionDetalleOrden.getCliente()
					+ " - " + produccionDetalleOrden.getMarca();
			li = new Listitem();
			li.setValue(produccionDetalleOrden);
			new Listcell(itemOrden).setParent(li);
			li.setParent(lbxItemOrdenCLiente);
		}
		lbxItemOrdenCLiente.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unchecked")
	public void onSelect$lbxItemOrdenCLiente() {

		pdo = (ProduccionDetalleOrden)lbxItemOrdenCLiente.getSelectedItem().getValue();

		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
		eft = eftDAO.getByOrden(pdo.getIdproducciondetalleorden());
		
		if (pdo.getIdproducciondetalleorden()!=null) {
			String pesoNeto = pdo.getPresentacion()
					.substring(pdo.getPresentacion().toUpperCase().indexOf("X")+2, pdo.getPresentacion().length());
			txtProducto.setValue(pdo.getProducto());
			txtPesoNeto.setValue(pesoNeto);
			txtPesoDrenado.setValue(String.valueOf(pdo.getDre()));
			txtAguaAc.setValue(String.valueOf(pdo.getAg()));
			txtAceiteAg.setValue(String.valueOf(pdo.getAc()));
			txtFormato.setValue(String.valueOf(pdo.getFormato()));
			txtFormato2.setValue(String.valueOf(pdo.getFormato()));
			txtEnvase.setValue(pdo.getEnvase());
			txtTapa.setValue(pdo.getTapa());
			txtFillPlanificado.setValue(String.valueOf(pdo.getFill()));
			txtEspecie.setValue(String.valueOf(pdo.getEsp()));
			txtTamEnvase.setValue(String.valueOf(pdo.getEnvase()));
			txtTipoTapa.setValue(String.valueOf(pdo.getTapa()));
			txtFlakeMax.setValue(String.valueOf(pdo.getFi()));
			txtCantCajas.setValue(String.valueOf(pdo.getCajas()));
			txtVideoJet.setValue(pdo.getVideo());
			txtMaqLlenadora.setValue(pdo.getLuthy());
			txtMaqCerradora.setValue(pdo.getCerradora());
			txtFlake.setValue(String.valueOf(pdo.getFlake()));
		} else {
			txtProducto.setValue(null);
			txtPesoNeto.setValue(null);
			txtPesoDrenado.setValue(null);
			txtAguaAc.setValue(null);
			txtAceiteAg.setValue(null);
			txtFormato.setValue(null);
			txtFormato2.setValue(null);
			txtEnvase.setValue(null);
			txtTapa.setValue(null);
			txtFillPlanificado.setValue(null);
			txtEspecie.setValue(null);
			txtTamEnvase.setValue(null);
			txtTipoTapa.setValue(null);
			txtFlakeMax.setValue(null);
			txtCantCajas.setValue(null);
			txtVideoJet.setValue(null);
			txtMaqLlenadora.setValue(null);
			txtMaqCerradora.setValue(null);
			txtFlake.setValue(null);
		}
		if (eft.getIdenvasadofichatecnica()==null) {
			txtFillPromedio.setValue(null);
			txtFill1.setValue(null);
			txtFill2.setValue(null);
			txtPNetoFormulado.setValue(null);
			txtAgua.setValue(null);
			txtAceite.setValue(null);
			lbxcvprot.setSelectedIndex(0);
			txtCaldoVegetal.setValue(null);
			txtConcentracion.setValue(null);
			txtSal.setValue(null);
			txtDensidad.setValue(null);
			txtTrozo.setValue(null);
			txtLomo.setValue(null);
			txtRallado.setValue(null);
			txtObservacion.setValue(null);
			txtProveedorLoteEnvase.setValue("");
			txtProveedorLoteTapa.setValue("");
			lbxProveedorEnvase.setSelectedIndex(0);
			lbxProveedorTapa.setSelectedIndex(0);
		} else {
			txtPNetoFormulado.setValue(String.valueOf(eft.getPesoNetoFormulado()));
			txtAgua.setValue(String.valueOf(eft.getAgua()));
			txtAceite.setValue(String.valueOf(eft.getAceite()));
			
			txtFillPromedio.setValue(String.valueOf(eft.getFillPromedio()));
			txtFill1.setValue(String.valueOf(eft.getFillRango1()));
			txtFill2.setValue(String.valueOf(eft.getFillRango2()));
			
			for(Listitem li : (List<Listitem>)lbxcvprot.getItems()) {
				if(eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
						.equals(((EnvasadoCaldoVegetalProteina)li.getValue()).getIdenvasadocaldovegetalproteina())){
					lbxcvprot.setSelectedItem(li);
					break;
				}
			}
			
			for(Listitem li : (List<Listitem>)lbxProveedorEnvase.getItems()) {
				if (eft.getEnvasadoProveedorLata()!=null)
					if(eft.getEnvasadoProveedorLata().getIdenvasadoproveedorlatas()
							.equals(((EnvasadoProveedorLata)li.getValue()).getIdenvasadoproveedorlatas())){
						lbxProveedorEnvase.setSelectedItem(li);
						break;
					}
			}
			
			for(Listitem li : (List<Listitem>)lbxProveedorTapa.getItems()) {
				if (eft.getEnvasadoProveedorTapa()!=null)
					if(eft.getEnvasadoProveedorTapa().getIdenvasadoproveedortapa()
							.equals(((EnvasadoProveedorTapa)li.getValue()).getIdenvasadoproveedortapa())){
						lbxProveedorTapa.setSelectedItem(li);
						break;
					}
			}
			
			txtCaldoVegetal.setValue(String.valueOf(eft.getCaldoVegetal()));
			txtConcentracion.setValue(String.valueOf(eft.getConcentracion()));
			txtSal.setValue(String.valueOf(eft.getSal()));
			txtDensidad.setValue(String.valueOf(eft.getDensidad()));
			txtTrozo.setValue(String.valueOf(eft.getTrozos()));
			txtLomo.setValue(String.valueOf(eft.getLomo()));
			txtRallado.setValue(String.valueOf(eft.getRallado()));
			txtProveedorLoteEnvase.setValue(String.valueOf(eft.getProveedorloteenvase()));
			txtProveedorLoteTapa.setValue(String.valueOf(eft.getProveedorlotetapa()));
			txtObservacion.setValue(String.valueOf(eft.getObservacion()));
		}
		
	}
	
	private void cargaCVPROT(){
		EnvasadoCaldoVegetalProteinaDAO ecvpDAO = new EnvasadoCaldoVegetalProteinaDAOJpaImpl();
		List<EnvasadoCaldoVegetalProteina> listECVP = ecvpDAO.getEnvasadoCaldoVegetalProteina();
		
		if (listECVP.isEmpty()) {
			Sistema.mensaje("No se encuentra configurado informacion para Caldo-Vegetal-Proteina.");
			return;
		}
		
		lbxcvprot.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoCaldoVegetalProteina());
		li.setParent(lbxcvprot);
		
		for (EnvasadoCaldoVegetalProteina ecvp : listECVP) {
			li = new Listitem();
			li.setValue(ecvp);
			new Listcell(ecvp.getDescripcion()).setParent(li);
			li.setParent(lbxcvprot);
		}
		
		lbxcvprot.setSelectedIndex(0);
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
		
		lbxProveedorEnvase.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoProveedorLata());
		li.setParent(lbxProveedorEnvase);
		
		for (EnvasadoProveedorLata epL : listEPL) {
			li = new Listitem();
			li.setValue(epL);
			new Listcell(epL.getDescripcion()).setParent(li);
			li.setParent(lbxProveedorEnvase);
		}
		
		lbxProveedorEnvase.setSelectedIndex(0);
		
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
	
	public void onClick$btnGrabar() {
		
		if(!validaCampos())
			return;
		
		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl(); 

		eft.setProduccionDetalleOrden(pdo);
		eft.setFillRango1(parseDouble(txtFill1.getValue()));
		eft.setFillRango2(parseDouble(txtFill2.getValue()));
		eft.setFillPromedio(parseDouble(txtFillPromedio.getValue()));
		eft.setPesoNetoFormulado(parseDouble(txtPNetoFormulado.getValue()));
		eft.setAgua(parseDouble(txtAgua.getValue()));
		eft.setAceite(parseDouble(txtAceite.getValue()));
		eft.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
		eft.setCaldoVegetal(parseDouble(txtCaldoVegetal.getValue()));
		eft.setConcentracion(parseDouble(txtConcentracion.getValue()));
		eft.setSal(parseDouble(txtSal.getValue()));
		eft.setDensidad(parseDouble(txtDensidad.getValue()));
		eft.setTrozos(parseDouble(txtTrozo.getValue()));
		eft.setLomo(parseDouble(txtLomo.getValue()));
		eft.setRallado(parseDouble(txtRallado.getValue()));
		eft.setProveedorloteenvase(txtProveedorLoteEnvase.getValue());
		eft.setProveedorlotetapa(txtProveedorLoteTapa.getValue());
		eft.setObservacion(txtObservacion.getValue());
		
		eft.setFechareg(new Timestamp(System.currentTimeMillis()));
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		eft.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		
		eft.setEnvasadoProveedorLata((EnvasadoProveedorLata)lbxProveedorEnvase.getSelectedItem().getValue());
		eft.setEnvasadoProveedorTapa((EnvasadoProveedorTapa)lbxProveedorTapa.getSelectedItem().getValue());
		
		eftDAO.updateEnvasadoFichaTecnica(eft);
		
		Sistema.mensaje("Cambios guardados exitosamente.");
		
		limpiaFormulario();
		
		binder.loadAll();
		
	}
	
	private void limpiaFormulario() {
		cargaInicial();
		txtPesoNeto.setValue(null);
		txtPesoDrenado.setValue(null);
		txtAguaAc.setValue(null);
		txtAceiteAg.setValue(null);
		txtFormato.setValue(null);
		txtFormato2.setValue(null);
		txtEnvase.setValue(null);
		txtTapa.setValue(null);
		txtFillPlanificado.setValue(null);
		txtEspecie.setValue(null);
		txtTamEnvase.setValue(null);
		txtTipoTapa.setValue(null);
		txtFlakeMax.setValue(null);
		txtCantCajas.setValue(null);
		txtVideoJet.setValue(null);
		txtMaqLlenadora.setValue(null);
		txtMaqCerradora.setValue(null);
		txtFlake.setValue(null);
		
		txtFill1.setValue(null);
		txtFill2.setValue(null);
		txtFillPromedio.setValue(null);
		txtPNetoFormulado.setValue(null);
		txtAgua.setValue(null);
		txtAceite.setValue(null);
		txtCaldoVegetal.setValue(null);
		txtConcentracion.setValue(null);
		txtSal.setValue(null);
		txtDensidad.setValue(null);
		txtTrozo.setValue(null);
		txtLomo.setValue(null);
		txtRallado.setValue(null);
		txtProveedorLoteEnvase.setValue("");
		txtProveedorLoteTapa.setValue("");
		txtObservacion.setValue(null);
		
		lbxProveedorEnvase.setSelectedIndex(0);
		lbxProveedorTapa.setSelectedIndex(0);
	}
	
	private boolean validaCampos() {
		List<Object> listaEtiquetas = new ArrayList<Object>();
		List<Object> camposNumericos = new ArrayList<Object>();
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTurnoLabor);
		listaEtiquetas.add(lbxTurnoLabor);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbItemOrden);
		listaEtiquetas.add(lbxItemOrdenCLiente);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbFill1);
		listaEtiquetas.add(txtFill1);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbFill2);
		listaEtiquetas.add(txtFill2);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPNetoFormulado);
		listaEtiquetas.add(txtPNetoFormulado);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbAgua);
		listaEtiquetas.add(txtAgua);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbAceite);
		listaEtiquetas.add(txtAceite);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbCaldoVegetal);
		listaEtiquetas.add(txtCaldoVegetal);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbConcentracion);
		listaEtiquetas.add(txtConcentracion);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbSal);
		listaEtiquetas.add(txtSal);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbDensidad);
		listaEtiquetas.add(txtDensidad);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTrozo);
		listaEtiquetas.add(txtTrozo);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbLomo);
		listaEtiquetas.add(txtLomo);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbRallado);
		listaEtiquetas.add(txtRallado);
		camposNumericos.add(listaEtiquetas);
		
		Label etiqueta;
		for (Object object : camposNumericos) {
			@SuppressWarnings("unchecked")
			List<Object> valores = (List<Object>) object;
			etiqueta = (Label) valores.get(0);
			if (valores.get(1) instanceof Textbox) {
				if (!validaCamposNumericos(etiqueta, (Textbox) valores.get(1)))
					return false;
			} else if (valores.get(1) instanceof Listbox) {
				if(!validaCamposLista(etiqueta, (Listbox) valores.get(1)))
					return false;
			}
		}
		return true;
	}

	private static boolean validaCamposNumericos(Label etiqueta, Textbox valor) {
		try {
			if (valor.getValue() == null ? true : valor.getValue().isEmpty() ? true : false) {
				Sistema.mensaje("Se debe agrega un valor para el campo "+ etiqueta.getValue());
				valor.setFocus(true);
				return false;
			} else if (parseDouble(valor.getValue()) < 0) {
				Sistema.mensaje("El campo " + etiqueta.getValue() + " no permite numeros negativos.");
				valor.setValue(null);
				valor.setFocus(true);
				return false;
			}
		} catch (Exception e) {
			Sistema.mensaje("El campo " + etiqueta.getValue() + " solo acepta numeros.");
			valor.setValue(null);
			valor.setFocus(true);
			return false;
		}
		return true;
	}
	
	private static boolean validaCamposLista(Label etiqueta, Listbox valor) {
		if (valor.getSelectedIndex() == 0) {
			Sistema.mensaje("Debe seleccionar un valor para el campo "+etiqueta.getValue()+".");
			return false;
		}
		return true;
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
					return new Double(0);
				}
			}
		}
	}
}


