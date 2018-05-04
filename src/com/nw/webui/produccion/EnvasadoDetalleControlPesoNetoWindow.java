package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.EnvasadoControlNetoCorteDetalle;
import com.nw.model.EnvasadoControlPesoNetoCabecera;
import com.nw.model.EnvasadoControlPesoNetoDetalle;
import com.nw.model.EnvasadoLineaCerradora;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoControlNetoCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoNetoCabeceraDAO;
import com.nw.model.dao.EnvasadoLineaCerradoraDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlNetoCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoNetoCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoLineaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleOrdenDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
import com.nw.util.Sistema;

/**
 * 
 * @author Cls Mbaque
 * @since 18/04/2018
 */
public class EnvasadoDetalleControlPesoNetoWindow extends GenericForwardComposer {

//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoNetoWindow.class);
	private static final long serialVersionUID = 1L;
	private static final Integer ESTADO = 1;
	
	private Long idenvasadocontrolpesonetocabecera;
	
	AnnotateDataBinder binder;
	
	EnvasadoProceso envasadoProceso;
	Produccion produccion;
	Turno turno;
	
	Textbox txtProduccionTurno, txtOrden, txtProducto, txtCliente, txtObservacion;
	Listbox lbxTurnoLabor, lbxItemOrden, lbxLineaCerradora, lbxcvprot, lbxCorte;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	Textbox txtPesoEnvase, txtPLomos, txtTrozos, txtRallado, txtAgua, txtAceite, txtprot, txtcv, txtPesoneto;
	Label lbTurnoLabor, lbItemOrden, lbLineaCerradora, lbcvprot, lbPesoEnvase, lbPLomos, lbTrozos, lbRallado, lbAgua, lbAceite, lbprot, lbcv, lbCorte, lbPesoneto;
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		
		cargaInicial();
		
		binder.loadAll();
	}
	
	private void cargaInicial() {
		txtProduccionTurno.setValue(cargaProduccionTurno());
		cargaTurno();
		cargaItemOrden(turno.getIdturno(), produccion.getIdproduccion());
		cargaLineaCerradora();
		cargaCVPROT();
		cargaCorte();
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
		lbxItemOrden.setSelectedIndex(0);
	}
	
	@SuppressWarnings("unchecked")
	public void onSelect$lbxItemOrden() throws InterruptedException{
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
		txtOrden.setValue(pdo.getOrden());
		txtProducto.setValue(pdo.getProducto());
		txtCliente.setValue(pdo.getCliente());
		
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		EnvasadoControlPesoNetoCabecera ecpnc = ecpncDAO.getByProduccionTurnoOrden(
				envasadoProceso.getIdenvasadoproceso(), pdo.getIdproducciondetalleorden());
		idenvasadocontrolpesonetocabecera = ecpnc.getIdenvasadocontrolpesonetocabecera();
		
		if (idenvasadocontrolpesonetocabecera !=null) {
			txtOrden.setValue(pdo.getOrden());
			txtProducto.setValue(pdo.getProducto());
			txtCliente.setValue(pdo.getCliente());
			
			for(Listitem li : (List<Listitem>)lbxLineaCerradora.getItems()) {
				if(ecpnc.getEnvasadoLineaCerradora().getIdenvasadolineacerradora()
						.equals(((EnvasadoLineaCerradora)li.getValue()).getIdenvasadolineacerradora())){
					lbxLineaCerradora.setSelectedItem(li);
					break;
				}
			}
			
			txtPesoEnvase.setValue(String.valueOf(ecpnc.getPesoenvase()));
			txtPLomos.setValue(String.valueOf(ecpnc.getProcentajelomos()));
			txtTrozos.setValue(String.valueOf(ecpnc.getProcentajetrozos()));
			txtRallado.setValue(String.valueOf(ecpnc.getProcentajerallado()));
			txtAgua.setValue(String.valueOf(ecpnc.getAgua()));
			txtAceite.setValue(String.valueOf(ecpnc.getAceite()));
			
			for(Listitem li : (List<Listitem>)lbxcvprot.getItems()) {
				if(ecpnc.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
						.equals(((EnvasadoCaldoVegetalProteina)li.getValue()).getIdenvasadocaldovegetalproteina())){
					lbxcvprot.setSelectedItem(li);
					break;
				}
			}
			
			txtprot.setValue(String.valueOf(ecpnc.getProteina()));
			txtcv.setValue(String.valueOf(ecpnc.getCaldovegetal()));
			txtPesoneto.setValue(null);
			lbxMes.setSelectedIndex(0);
			lbxDias.getItems().clear();
			lbxHoras.setSelectedIndex(0);
			lbxMinutos.setSelectedIndex(0);
			txtObservacion.setValue(ecpnc.getObservacion());
			
			
//			seleccionaMes(obtieneFechaCambio(ecpnc.getFechareg(), Calendar.MONTH)+1);
//			seleccionaDia(obtieneFechaCambio(ecpnc.getFechareg(), Calendar.DAY_OF_MONTH));
//			seleccionaHora(obtieneFechaCambio(ecpnc.getFechareg(), Calendar.HOUR_OF_DAY));
//			seleccionaMinuto(obtieneFechaCambio(ecpnc.getFechareg(), Calendar.MINUTE));
			
		} else {
			lbxLineaCerradora.setSelectedIndex(0);
			txtPesoEnvase.setValue(null);
			txtPLomos.setValue(null);
			txtTrozos.setValue(null);
			txtRallado.setValue(null);
			txtAgua.setValue(null);
			txtAceite.setValue(null);
			lbxcvprot.setSelectedIndex(0);
			txtprot.setValue(null);
			txtcv.setValue(null);
			txtPesoneto.setValue(null);
			lbxMes.setSelectedIndex(0);
			lbxDias.getItems().clear();
			lbxHoras.setSelectedIndex(0);
			lbxMinutos.setSelectedIndex(0);
			txtObservacion.setValue(null);
		}
	}
	
	private void cargaLineaCerradora() {
		EnvasadoLineaCerradoraDAO elcDAO = new EnvasadoLineaCerradoraDAOJpaImpl();
		List<EnvasadoLineaCerradora> listELC = elcDAO.getEnvasadoLineaCerradoraAll();
		
		if (listELC.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para Linea Cerradora.");
			return;
		}
		
		lbxLineaCerradora.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoLineaCerradora());
		li.setParent(lbxLineaCerradora);
		
		for (EnvasadoLineaCerradora elc : listELC) {
			li = new Listitem();
			li.setValue(elc);
			new Listcell(elc.getNumeroenvasadolineacerradora().toString()).setParent(li);
			li.setParent(lbxLineaCerradora);
		}
		
		lbxLineaCerradora.setSelectedIndex(0);
		
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
	
	private void cargaCorte() {
		EnvasadoControlNetoCorteCabeceraDAO ecnccDAO = new EnvasadoControlNetoCorteCabeceraDAOJpaImpl();
		
		List<EnvasadoControlNetoCorteDetalle> listaEcncd = ecnccDAO
				.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso())
				.getEnvasadoControlNetoCorteDetalles();
		
		if (listaEcncd != null) {
			if (listaEcncd.isEmpty()) {
				Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
				return;
			}
		} else if (listaEcncd == null) {
			Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
			return;
		}
		
		lbxCorte.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new EnvasadoControlNetoCorteDetalle());
		li.setParent(lbxCorte);
		
		
		Collections.sort(listaEcncd, new Comparator<EnvasadoControlNetoCorteDetalle>() 		
		{
			@Override
			public int compare(EnvasadoControlNetoCorteDetalle o1, EnvasadoControlNetoCorteDetalle o2) {
				return new Integer(o1.getCorte()).compareTo(o2.getCorte());
			}
		});
		
		
		String hora, minuto;
		for (EnvasadoControlNetoCorteDetalle ecfcd : listaEcncd) {
			li = new Listitem();
			li.setValue(ecfcd);
			System.out.println(ecfcd.getCorte());
			hora = ecfcd.getHora()<=9?"0"+ecfcd.getHora():ecfcd.getHora().toString();
			minuto = ecfcd.getMinuto()<=9?"0"+ecfcd.getMinuto():ecfcd.getMinuto().toString();
			
			new Listcell(ecfcd.getCorte()+" -> "+hora+":"+minuto)
				.setParent(li);
			li.setParent(lbxCorte);
		}
		
		lbxCorte.setSelectedIndex(0);
	}
	
	public void onClick$btnGrabar() {
		
		EnvasadoControlPesoNetoCabeceraDAO ecpncDAO = new EnvasadoControlPesoNetoCabeceraDAOJpaImpl();
		EnvasadoControlPesoNetoCabecera ecpnc = new EnvasadoControlPesoNetoCabecera();
		
		if(!validaCampos())
			return;
		
		if (idenvasadocontrolpesonetocabecera!=null)
			ecpnc.setIdenvasadocontrolpesonetocabecera(idenvasadocontrolpesonetocabecera);
		ecpnc.setEnvasadoProceso(envasadoProceso);
		ecpnc.setTurno(((Turno)lbxTurnoLabor.getSelectedItem().getValue()));
		ecpnc.setProduccionDetalleOrden((ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue());
		
		ecpnc.setEnvasadoLineaCerradora((EnvasadoLineaCerradora)lbxLineaCerradora.getSelectedItem().getValue());
		ecpnc.setPesoenvase(parseDouble(txtPesoEnvase.getValue()));
		ecpnc.setProcentajelomos(parseDouble(txtPLomos.getValue()));
		ecpnc.setProcentajetrozos(parseDouble(txtTrozos.getValue()));
		ecpnc.setProcentajerallado(parseDouble(txtRallado.getValue()));
		ecpnc.setAgua(parseDouble(txtAgua.getValue()));
		ecpnc.setAceite(parseDouble(txtAceite.getValue()));
		ecpnc.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
		ecpnc.setProteina(parseDouble(txtprot.getValue()));
		ecpnc.setCaldovegetal(parseDouble(txtcv.getValue()));
		
		Timestamp fechaRegistro = obtieneFechaRegistro();
		if (fechaRegistro==null)
			return;
		ecpnc.setFechareg(new Timestamp(System.currentTimeMillis()));
		ecpnc.setObservacion(txtObservacion.getValue());
		//valida la informacion del usuario logueado
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		ecpnc.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		
		if (guardaDetalle(ecpnc)==null) {
			Sistema.mensaje("Error al guardar el detalle de la informacion.");
			return;
		}
		
		ecpnc.getEnvasadoControlPesoNetoDetalles().get(0).setFecharegusuario(fechaRegistro);
		
		EnvasadoControlNetoCorteDetalle envasadoControlNetoCorteDetalle = (EnvasadoControlNetoCorteDetalle)lbxCorte.getSelectedItem().getValue();
		ecpnc.getEnvasadoControlPesoNetoDetalles().get(0).setEnvasadoControlNetoCorteDetalle(envasadoControlNetoCorteDetalle);
		
		if (!isEnvasadoProcesoActivo()) {
			Sistema.mensaje("El registro de envasado proceso se ha cerrado durante su modificacion.");
			return;
		}
		
		if(ecpncDAO.updateEnvasadoControlPesoNetoCabecera(ecpnc)==null) {
			Sistema.mensaje("Error al guardar la informacion.");
			return;
		}
		
		Sistema.mensaje("Cambios guardados exitosamente.");
		
		limpiaFormulario();
		
		binder.loadAll();
		
	}
	
	private void limpiaFormulario() {
		cargaInicial();
		txtOrden.setValue(null);
		txtProducto.setValue(null);
		txtCliente.setValue(null);
//		lineaCerradora
		txtPesoEnvase.setValue(null);
		txtPLomos.setValue(null);
		txtTrozos.setValue(null);
		txtRallado.setValue(null);
		txtAgua.setValue(null);
		txtAceite.setValue(null);
//		listaproteina
		txtprot.setValue(null);
		txtcv.setValue(null);
		txtPesoneto.setValue(null);
		lbxMes.setSelectedIndex(0);
		lbxDias.getItems().clear();
		lbxHoras.setSelectedIndex(0);
		lbxMinutos.setSelectedIndex(0);
		txtObservacion.setValue(null);
		
	}
	private EnvasadoControlPesoNetoDetalle guardaDetalle(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		EnvasadoControlPesoNetoDetalle ecpnd = new EnvasadoControlPesoNetoDetalle();
		ecpnd.setEnvasadoControlPesoNetoCabecera(envasadoControlPesoNetoCabecera);
		ecpnd.setFechareg(envasadoControlPesoNetoCabecera.getFechareg());
		ecpnd.setFecharegusuario(new Timestamp(System.currentTimeMillis()));
		
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return null;
		}
		
		ecpnd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		ecpnd.setPesoneto(parseDouble(txtPesoneto.getValue()));
		
		envasadoControlPesoNetoCabecera.setEnvasadoControlPesoNetoDetalles(Arrays.asList(ecpnd));
		
		return ecpnd;
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
		listaEtiquetas.add(lbxItemOrden);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbLineaCerradora);
		listaEtiquetas.add(lbxLineaCerradora);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPesoEnvase);
		listaEtiquetas.add(txtPesoEnvase);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPLomos);
		listaEtiquetas.add(txtPLomos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbTrozos);
		listaEtiquetas.add(txtTrozos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbRallado);
		listaEtiquetas.add(txtRallado);
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
		listaEtiquetas.add(lbcvprot);
		listaEtiquetas.add(lbxcvprot);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbprot);
		listaEtiquetas.add(txtprot);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPLomos);
		listaEtiquetas.add(txtPLomos);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbcv);
		listaEtiquetas.add(txtcv);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbCorte);
		listaEtiquetas.add(lbxCorte);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbPesoneto);
		listaEtiquetas.add(txtPesoneto);
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
	
	private boolean isEnvasadoProcesoActivo(){
		
		EnvasadoProcesoDAOJpaImpl epDAOJpa = new EnvasadoProcesoDAOJpaImpl();
		EnvasadoProceso envasadoProceso = epDAOJpa.getEnvasadoProcesoByEstado(ESTADO);
		
		if (this.envasadoProceso.getIdenvasadoproceso() != envasadoProceso.getIdenvasadoproceso())
			return false;
		else
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
					return new Double("");
				}
			}
		}
	}
}


