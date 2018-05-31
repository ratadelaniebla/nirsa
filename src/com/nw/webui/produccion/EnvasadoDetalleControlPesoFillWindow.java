package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Group;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.nw.model.EnvasadoCaldoVegetalProteina;
import com.nw.model.EnvasadoControlFillCorteDetalle;
import com.nw.model.EnvasadoControlPesoFillCabecera;
import com.nw.model.EnvasadoControlPesoFillDetalle;
import com.nw.model.EnvasadoFichaTecnica;
import com.nw.model.EnvasadoLineaCerradora;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Luthy;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleOrden;
import com.nw.model.Turno;
import com.nw.model.dao.EnvasadoCaldoVegetalProteinaDAO;
import com.nw.model.dao.EnvasadoControlFillCorteCabeceraDAO;
import com.nw.model.dao.EnvasadoControlPesoFillCabeceraDAO;
import com.nw.model.dao.EnvasadoFichaTecnicaDAO;
import com.nw.model.dao.LuthyDAO;
import com.nw.model.dao.MaquinaCerradoraDAO;
import com.nw.model.dao.ProduccionDetalleOrdenDAO;
import com.nw.model.dao.impl.EnvasadoCaldoVegetalProteinaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlFillCorteCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoControlPesoFillCabeceraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoFichaTecnicaDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoLineaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
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
public class EnvasadoDetalleControlPesoFillWindow extends GenericForwardComposer {

	private static final int valorMaximoPesoFill = 10016;
	//	private static Log logger = LogFactory.getLog(EnvasadoDetalleControlPesoFillWindow.class);
	private static final long serialVersionUID = 1L;
	private static final String SELECT = "select";
	private static final Integer ESTADO = 1;
	
	private Long idenvasadocontrolpesofillcabecera;
	
	AnnotateDataBinder binder;
	
	EnvasadoControlPesoFillCabecera ecpfc;
	EnvasadoProceso envasadoProceso;
	Produccion produccion;
	Turno turno;
	Group gpPeso;
	Label txtOrden, txtProducto, txtCliente;
	Textbox txtVideoJet, txtProduccionTurno, txtObservacion;
	Listbox lbxTurnoLabor, lbxItemOrden, lbxLuthy, lbxLineaCerradora, lbxcvprot, lbxCorte;
	Listbox lbxMes, lbxDias, lbxHoras, lbxMinutos;
	Textbox txtPesoEnvase, txtPLomos, txtTrozos, txtRallado, txtAgua, txtAceite, txtprot, txtcv, txtTaraEnvase;
	Label lbVideoJet, lbTurnoLabor, lbItemOrden, lbLuthy, lbLineaCerradora, lbcvprot, lbPesoEnvase, lbPLomos, lbTrozos, lbRallado, lbAgua, lbAceite, lbprot, lbcv, lbPesofill, lbTaraEnvase, lbCorte, lbLista;
	Checkbox cbxEliminar;
	
	Rows rsCorte;
	
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
		cargaLuthy();
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
	public void onSelect$lbxItemOrden() {
		
		ProduccionDetalleOrden pdo = (ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue();
		
		if (pdo.getIdproducciondetalleorden()!=null) {
			txtOrden.setValue(pdo.getOrden());
			txtProducto.setValue(pdo.getProducto());
			txtCliente.setValue(pdo.getCliente());
			txtVideoJet.setValue(pdo.getVideo());
		} else {
			txtOrden.setValue(null);
			txtProducto.setValue(null);
			txtCliente.setValue(null);
			txtVideoJet.setValue(null);
		}
		
		EnvasadoFichaTecnicaDAO eftDAO = new EnvasadoFichaTecnicaDAOJpaImpl();
		EnvasadoFichaTecnica eft = eftDAO.getByOrden(pdo.getIdproducciondetalleorden());
		
		if (eft.getIdenvasadofichatecnica()!=null) {
			txtPesoEnvase.setValue(String.valueOf(eft.getPesoNetoFormulado()));
			txtPLomos.setValue(String.valueOf(eft.getLomo()));
			txtTrozos.setValue(String.valueOf(eft.getTrozos()));
			txtRallado.setValue(String.valueOf(eft.getRallado()));
			txtAgua.setValue(String.valueOf(eft.getAgua()));
			txtAceite.setValue(String.valueOf(eft.getAceite()));
			for(Listitem li : (List<Listitem>)lbxcvprot.getItems()) {
				if(eft.getEnvasadoCaldoVegetalProteina()!=null)
					if(eft.getEnvasadoCaldoVegetalProteina().getIdenvasadocaldovegetalproteina()
							.equals(((EnvasadoCaldoVegetalProteina)li.getValue()).getIdenvasadocaldovegetalproteina())){
						lbxcvprot.setSelectedItem(li);
						break;
					}
			}
			
			txtprot.setValue(String.valueOf(eft.getCaldoVegetal()));
			txtcv.setValue(String.valueOf(eft.getConcentracion()));
			
		} else {
			txtPesoEnvase.setValue(null);
			txtPLomos.setValue(null);
			txtTrozos.setValue(null);
			txtRallado.setValue(null);
			txtAgua.setValue(null);
			txtAceite.setValue(null);
			lbxcvprot.setSelectedIndex(0);
			txtprot.setValue(null);
			txtcv.setValue(null);
		}
		
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		ecpfc = ecpfcDAO.getByProduccionTurnoOrden(
				envasadoProceso.getIdenvasadoproceso(), pdo.getIdproducciondetalleorden());
		idenvasadocontrolpesofillcabecera = ecpfc.getIdenvasadocontrolpesofillcabecera();
		
		if (idenvasadocontrolpesofillcabecera !=null) {
			
			for(Listitem li : (List<Listitem>)lbxLuthy.getItems()) {
				if(ecpfc.getLuthy().getIdluthy()
						.equals(((Luthy)li.getValue()).getIdluthy())){
					lbxLuthy.setSelectedItem(li);
					break;
				}
			}
			
			for(Listitem li : (List<Listitem>)lbxLineaCerradora.getItems()) {
				if(ecpfc.getEnvasadoLineaCerradora().getIdenvasadolineacerradora()
						.equals(((EnvasadoLineaCerradora)li.getValue()).getIdenvasadolineacerradora())){
					lbxLineaCerradora.setSelectedItem(li);
					break;
				}
			}
			txtTaraEnvase.setValue(String.valueOf(ecpfc.getTara()));
			rsCorte.getChildren().clear();
			cargaListaCorte();
			lbxMes.setSelectedIndex(0);
			lbxDias.getItems().clear();
			lbxHoras.setSelectedIndex(0);
			lbxMinutos.setSelectedIndex(0);
			txtObservacion.setValue(ecpfc.getObservacion());
		} else {
			lbxLuthy.setSelectedIndex(0);
			lbxLineaCerradora.setSelectedIndex(0);
			txtTaraEnvase.setValue(null);
			rsCorte.getChildren().clear();
			cargaListaCorte();
			lbxMes.setSelectedIndex(0);
			lbxDias.getItems().clear();
			lbxHoras.setSelectedIndex(0);
			lbxMinutos.setSelectedIndex(0);
			txtObservacion.setValue(null);
		}
		cargaCorte();
	}
	
	
	private void cargaLuthy() {
		LuthyDAO elcDAO = new LuthyDAOJpaImpl();
		List<Luthy> listLuthy = elcDAO.getAll();
		
		if (listLuthy.isEmpty()) {
			Sistema.mensaje("No se encuentra configurada informacion para Luthy.");
			return;
		}
		
		lbxLuthy.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Luthy());
		li.setParent(lbxLuthy);
		
		for (Luthy luthy : listLuthy) {
			li = new Listitem();
			li.setValue(luthy);
			new Listcell(luthy.getNumeroluthy().toString()).setParent(li);
			li.setParent(lbxLuthy);
		}
		
		lbxLuthy.setSelectedIndex(0);
	}
	
	
	private void cargaLineaCerradora() {
		MaquinaCerradoraDAO elcDAO = new EnvasadoLineaCerradoraDAOJpaImpl();
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
	
	private void cargaListaCorte() {
		double numero = new ParametroDAOJpaImpl().findById(valorMaximoPesoFill).getValor();
		for (int i=0; i<numero ; i++)
			onClick$btnAgregarItem();
	}
	
	private int cont=1;
	
	public void onClick$btnAgregarItem() {
		Row row = new Row();
		Checkbox cbxCorteItem;
		Intbox tbxCorteItem;
		
		cbxCorteItem = new Checkbox();
		cbxCorteItem.setChecked(false);
		cbxCorteItem.setWidth("10px");
		cbxCorteItem.setParent(row);
		
		tbxCorteItem = new Intbox();
		tbxCorteItem.setTabindex(cont);
		tbxCorteItem.setParent(row);
		
		row.setValue(null);
		row.setParent(rsCorte);
		
		cont = cont+1;
	}
	
	@SuppressWarnings("unchecked")
	public void onClick$btnEliminarItem() {

		List<Row> rowsElimina = new ArrayList<Row>();
		
		if (rsCorte.getChildren().isEmpty()) {
			Sistema.mensaje("No existen elementos seleccionados para eliminar.");
			return;
		}
		
		if (!cbxEliminar.isChecked()) {
			Sistema.mensaje("Debe confirmar para eliminar los elementos seleccionados.");
			return;
		}
		
		for (Row r :(List<Row>)rsCorte.getChildren()) {
			Checkbox cbx = (Checkbox)r.getChildren().get(0);
			
			if (cbx.isChecked())
				rowsElimina.add(r);
		}
		
		for (Row r : rowsElimina)
			rsCorte.removeChild(r);
		
		binder.loadComponent(rsCorte);
	}
	
	private Listbox cargaCorte() {
		
		lbxCorte.getItems().clear();
		
		EnvasadoControlFillCorteCabeceraDAO ecfccDAO = new EnvasadoControlFillCorteCabeceraDAOJpaImpl();
		
		List<EnvasadoControlFillCorteDetalle> listaEcfcd = ecfccDAO
				.obtieneByIdEnvasadoProceso(envasadoProceso.getIdenvasadoproceso())
				.getEnvasadoControlFillCorteDetalles();
		
		if (listaEcfcd != null) {
			if (listaEcfcd.isEmpty()) {
				Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
				return new Listbox();
			}
		} else if (listaEcfcd == null) {
			Sistema.mensaje("No se encuentra configurado informacion para la configuracion de cortes.");
			return new Listbox();
		}
		
//		Listbox listbox = new Listbox(); 
		lbxCorte.setMold(SELECT);
		Listitem li = new Listitem();
		li.setValue(new EnvasadoControlFillCorteDetalle());
		li.setParent(lbxCorte);
		
		Collections.sort(listaEcfcd, new Comparator<EnvasadoControlFillCorteDetalle>() 		
		{
			@Override
			public int compare(EnvasadoControlFillCorteDetalle o1, EnvasadoControlFillCorteDetalle o2) {
				return new Integer(o1.getCorte()).compareTo(o2.getCorte());
			}
		});
		
		String hora, minuto;
		
		List<EnvasadoControlPesoFillDetalle> listaEcpfd;
		
		for (EnvasadoControlFillCorteDetalle ecfcd : listaEcfcd) {
			li = new Listitem();
			li.setValue(ecfcd);
			hora = ecfcd.getHora()<=9?"0"+ecfcd.getHora():ecfcd.getHora().toString();
			minuto = ecfcd.getMinuto()<=9?"0"+ecfcd.getMinuto():ecfcd.getMinuto().toString();
			
			listaEcpfd = new ArrayList<>();
			
			if(ecpfc!=null)
				if (ecpfc.getEnvasadoControlPesoFillDetalles()!=null)
					for (EnvasadoControlPesoFillDetalle ecpfd : ecpfc.getEnvasadoControlPesoFillDetalles())
						if (ecfcd.getIdenvasadocontrolfillcortedetalle()
								.equals(ecpfd.getEnvasadoControlFillCorteDetalle().getIdenvasadocontrolfillcortedetalle()))
							listaEcpfd.add(ecpfd);
			 
			new Listcell(ecfcd.getCorte()+" ("+listaEcpfd.size()+")"+" -> "+hora+":"+minuto)
				.setParent(li);
			li.setParent(lbxCorte);
		}
		
		lbxCorte.setSelectedIndex(0);
		return lbxCorte;
	}
	
	public void onClick$btnGrabarBot() {
		onClick$btnGrabar();
	}
	
	public void onClick$btnGrabar() {
		
		EnvasadoControlPesoFillCabeceraDAO ecpfcDAO = new EnvasadoControlPesoFillCabeceraDAOJpaImpl();
		EnvasadoControlPesoFillCabecera ecpfc = new EnvasadoControlPesoFillCabecera();
		
		if(!validaCampos())
			return;
		
		if (idenvasadocontrolpesofillcabecera!=null)
			ecpfc.setIdenvasadocontrolpesofillcabecera(idenvasadocontrolpesofillcabecera);
		ecpfc.setEnvasadoProceso(envasadoProceso);
		ecpfc.setTurno(((Turno)lbxTurnoLabor.getSelectedItem().getValue()));
		ecpfc.setProduccionDetalleOrden((ProduccionDetalleOrden)lbxItemOrden.getSelectedItem().getValue());
		
		ecpfc.setLuthy((Luthy)lbxLuthy.getSelectedItem().getValue());
		ecpfc.setEnvasadoLineaCerradora((EnvasadoLineaCerradora)lbxLineaCerradora.getSelectedItem().getValue());
//		ecpfc.setPesoenvase(parseDouble(txtPesoEnvase.getValue()));
//		ecpfc.setProcentajelomos(parseDouble(txtPLomos.getValue()));
//		ecpfc.setProcentajetrozos(parseDouble(txtTrozos.getValue()));
//		ecpfc.setProcentajerallado(parseDouble(txtRallado.getValue()));
//		ecpfc.setAgua(parseDouble(txtAgua.getValue()));
//		ecpfc.setAceite(parseDouble(txtAceite.getValue()));
//		ecpfc.setEnvasadoCaldoVegetalProteina((EnvasadoCaldoVegetalProteina)lbxcvprot.getSelectedItem().getValue());
//		ecpfc.setProteina(parseDouble(txtprot.getValue()));
//		ecpfc.setCaldovegetal(parseDouble(txtcv.getValue()));
		
//		Timestamp fechaRegistro = obtieneFechaRegistro();
//		if (fechaRegistro==null)
//			return;
		ecpfc.setTara(parseDouble(txtTaraEnvase.getValue()));
		ecpfc.setFechareg(new Timestamp(System.currentTimeMillis()));
		ecpfc.setObservacion(txtObservacion.getValue());
		//valida la informacion del usuario logueado
		String idUsuario = (String) Sessions.getCurrent().getAttribute("usuario");
		if (idUsuario==null) {
			Sistema.mensaje("Error. Usuario no logueado.");
			return;
		}
		ecpfc.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
		
		List<EnvasadoControlPesoFillDetalle> listaEcpfd = obtieneDetallesPesoFill(ecpfc, idUsuario);
		
		if (listaEcpfd==null) {
			Sistema.mensaje("Error al guardar el detalle de la informacion.");
			return;
		} else if (listaEcpfd.isEmpty()) {
			Sistema.mensaje("Debe Agregar valores para Peso Fill.");
			return;
		}
			
		ecpfc.setEnvasadoControlPesoFillDetalles(listaEcpfd);

		if (!isEnvasadoProcesoActivo()) {
			Sistema.mensaje("El registro de envasado proceso se ha cerrado durante su modificacion.");
			return;
		}
		
		if(ecpfcDAO.updateEnvasadoControlPesoFillCabecera(ecpfc)==null) {
			Sistema.mensaje("Error al guardar la informacion.");
			return;
		}
		
		Sistema.mensaje("Cambios guardados exitosamente.");
		
//		limpiaFormulario();
		/*** carga formulario ***/
		onSelect$lbxItemOrden();
		rsCorte.getChildren().clear();
		cargaListaCorte();
		/************************/
		
		binder.loadAll();
		
	}
	
	private List<EnvasadoControlPesoFillDetalle> obtieneDetallesPesoFill(EnvasadoControlPesoFillCabecera ecpfc, String idUsuario) {
		try {
			List<EnvasadoControlPesoFillDetalle> listaCpfd = new ArrayList<EnvasadoControlPesoFillDetalle>();
			EnvasadoControlPesoFillDetalle cpfd; 
			
			@SuppressWarnings("unchecked")
			List<Row> listaLbxPesoFill = (List<Row>)rsCorte.getChildren();
			
			for (Row listitem : listaLbxPesoFill) {
				
				Intbox txtPesoFill = (Intbox)listitem.getChildren().get(1);
				
				
				if (txtPesoFill.getValue()==null) {
					continue;
				}
				
				cpfd = new EnvasadoControlPesoFillDetalle();
				cpfd.setEnvasadoControlPesoFillCabecera(ecpfc);
				cpfd.setEnvasadoControlFillCorteDetalle((EnvasadoControlFillCorteDetalle)lbxCorte.getSelectedItem().getValue());
				cpfd.setPesofill(txtPesoFill.getValue());
//				cpfd.setFecharegusuario(fechaRegistro);
				cpfd.setFechareg(new Timestamp(System.currentTimeMillis()));
				cpfd.setUsuario(new UsuarioDAOJpaImpl().getUser(idUsuario));
				
				listaCpfd.add(cpfd);
			}
		
			return listaCpfd;
		} catch( Exception e) {
			return null;
		}
	}
//	private void limpiaFormulario() {
//		cargaInicial();
//		txtOrden.setValue(null);
//		txtProducto.setValue(null);
//		txtCliente.setValue(null);
////		lineaCerradora
//		txtPesoEnvase.setValue(null);
//		txtPLomos.setValue(null);
//		txtTrozos.setValue(null);
//		txtRallado.setValue(null);
//		txtAgua.setValue(null);
//		txtAceite.setValue(null);
////		listaproteina
//		txtprot.setValue(null);
//		txtcv.setValue(null);
//		rsCorte.getChildren().clear();
//		lbxMes.setSelectedIndex(0);
//		lbxDias.getItems().clear();
//		lbxHoras.setSelectedIndex(0);
//		lbxMinutos.setSelectedIndex(0);
//		txtTaraEnvase.setValue(null);
//		txtObservacion.setValue(null);
//		
//	}
	
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
		listaEtiquetas.add(lbLuthy);
		listaEtiquetas.add(lbxLuthy);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbLineaCerradora);
		listaEtiquetas.add(lbxLineaCerradora);
		camposNumericos.add(listaEtiquetas);
		
		listaEtiquetas = new ArrayList<Object>(); 
		listaEtiquetas.add(lbCorte);
		listaEtiquetas.add(lbxCorte);
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


