package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.EnvasadoProceso;
import com.nw.model.Luthy;
import com.nw.model.LuthyMaquinaCerradoraEstandar;
import com.nw.model.MaquinaCerradora;
import com.nw.model.OeeDetalleParada;
import com.nw.model.OeeDetalleParadaEnvasado;
import com.nw.model.OeeEnvasadoCabeceraVelocidadMaquinaCerradora;
import com.nw.model.OeeEnvasadoDetalleVelocidadMaquinaCerradora;
import com.nw.model.OeeParada;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LuthyMaquinaCerradoraEstandarDAOJpaImpl;
import com.nw.model.dao.impl.MaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleParadaDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleParadaEnvasadoDAOJpaImpl;
import com.nw.model.dao.impl.OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeEnvasadoDetalleVelocidadMaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeParadaDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;

@SuppressWarnings("serial")
public class EnvasadoParadasWindow extends GenericForwardComposer {

	private Listbox lbxMaquinaCerradora;
	private Listbox lbxParadasCurso;
	private Listbox lbxParadas,lbxLuthy;
	private Listbox Mesi;
	private Listbox lbxDii;
	private Listbox lbxHio;
	private Listbox lbxMii;
	private Listbox Mesf;
	private Listbox lbxDif;
	private Listbox lbxHif;
	private Listbox lbxMif;
	private Textbox txtTotalTiempo;
	private Textbox txtObservacion;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;

	Usuario usuario = new Usuario();

	OeeParada oeeParada;
	OeeDetalleParada oeeDetalleParada;
	DescongeladoDetalleProceso descongeladoDetalleProceso;
	private DateStruct fechai;
	private DateStruct fechar;
	private MaquinaCerradora maquinaCerradora; 
	OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado;
	
	private EnvasadoProceso envasadoProceso;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarParadas(new OeeParadaDAOJpaImpl().getOeeParadaByIdProceso(13));
		//cargarMaquinaCerradora(new MaquinaCerradoraDAOJpaImpl().getAll());
		//lastStep();
		cargarParadasEnCurso();
		cargarDatos();
		/* obtiene el proceso activo(aperturado ) por el estado(1) y el id de proceso envasado(13)*/
	    envasadoProceso = new EnvasadoProcesoDAOJpaImpl().getEnvasadoProcesoAperturado();
	    if (envasadoProceso!=null) {
	    	cargarMaquinasCabeceras();
		}else{
			Sistema.mensaje("No Existe un proceso de Aperturado");
		}

	}
	
	/* se cargan las maquinas configuradas para el proceso de la clase OeeEnvasadoCabeceraVelocidadMaquinaCerradora */
	public void cargarMaquinasCabeceras(){
			  
		List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora>  maquinas = 
				new OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl()
						.getOeeEnvasadoDetalleVelocidadMaquinaCerradoras(
								envasadoProceso.getProcesoAperturaCierre().getIdprocesoaperturacierre());
		lbxMaquinaCerradora.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new MaquinaCerradora()); 
			li.setParent(lbxMaquinaCerradora);
			try {
				for (OeeEnvasadoCabeceraVelocidadMaquinaCerradora t : maquinas) {
					li = new Listitem();
					li.setValue(t.getMaquinaCerradora());
					new Listcell(t.getMaquinaCerradora().getDescripcion()).setParent(li);
					li.setParent(lbxMaquinaCerradora);
				}
			} catch (Exception e) {
				 e.printStackTrace();
				System.out.println("Error al cargar  listbox lbxMaquinaCerradora");
			}
			lbxMaquinaCerradora.setSelectedIndex(0);
	}
	
	private void lastStep() {
		cargarParadasEnCurso();
		limpiarDatos();
	}

	void limpiarDatos() {
		ChkEliminar.setChecked(false);
		fechai = Util.limpiarMesDiaHoraMin(Mesi, lbxDii, lbxHio, lbxMii);
		fechar = Util.limpiarMesDiaHoraMin(Mesf, lbxDif, lbxHif, lbxMif);
		lbxHif.setSelectedIndex(0);
		lbxMif.setSelectedIndex(0);
		txtObservacion.setValue("");
		txtTotalTiempo.setValue("");
		lbxParadasCurso.setSelectedIndex(0);
		lbxParadas.setSelectedIndex(0);
		lbxMaquinaCerradora.setSelectedIndex(0);
		lbxLuthy.setSelectedIndex(0);
		maquinaCerradora = null;
		luthy            = null;
		oeeParada 		 = null;
	}
	
	public void cargarDatos(){
		ChkEliminar.setChecked(false);
		fechai = Util.limpiarMesDiaHoraMin(Mesi, lbxDii, lbxHio, lbxMii);
		fechar = Util.limpiarMesDiaHoraMin(Mesf, lbxDif, lbxHif, lbxMif);
		lbxHif.setSelectedIndex(0);
		lbxMif.setSelectedIndex(0);
		txtObservacion.setValue("");
		txtTotalTiempo.setValue("");
		maquinaCerradora = null;
		luthy            = null;
		oeeParada 		 = null;
		lbxParadasCurso.setSelectedIndex(0);
		lbxParadas.setSelectedIndex(0);
	}

	public void cargarParadas(List<OeeParada> collection) {
		Util.cargarLista(OeeParada.class, //
				collection, //
				lbxParadas, null, false, "Parada");
	}

	private void cargarMaquinaCerradora(List<MaquinaCerradora> listcoleccion) {
		Util.cargarLista(MaquinaCerradora.class, listcoleccion,
				lbxMaquinaCerradora, null, false, "MaquinaCerradora");
	}

	private void cargarParadasEnCurso() {
		Util.cargarLista(OeeDetalleParada.class,
				new OeeDetalleParadaDAOJpaImpl().getParadasEnCurso(13),
				lbxParadasCurso, null, false, "OeeDetalleParada");
	}

	private boolean validarCampos() {
		if (lbxParadasCurso.getSelectedIndex() == 0
				&& lbxParadas.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione una parada");
			lbxParadas.setFocus(true);
			return false;
		}
		
		 if (Util.validarListboxFecha(lbxMii,lbxDii,lbxHio,lbxMii)) {
			  Sistema.mensaje("Seleccione bien la fecha ");
			  return false;
		    }

		if (lbxHif.getSelectedIndex() != 0 && lbxMif.getSelectedIndex() != 0) {
			int data = fechai.toTimestamp().compareTo(fechar.toTimestamp());
			if (data > 0) {
				Sistema.mensaje("Fecha Final debe ser mayor a la inicial");
				Mesf.setFocus(true);
				return false;
			} else {
				int total = Util.validar24horas(fechai, fechar);
				if (total > ((24 * 60) - 1) && total < 0) {
					Sistema.mensaje("No pude ser mayor a 24 horas");
					lbxMif.setFocus(true);
					return false;
				}
			}
		}
		
		if (!fechai.hasValue()) {
			Sistema.mensaje("Ingrese la fecha de inicio de parada completa");
			return false;
		}
		
		return true;
	}

	private boolean validarCamposDelete() {
		validarCampos();
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			return false;
		}
		return true;
	}

	public void onSelect$Mesi() throws InterruptedException {
		if (Mesi.getSelectedIndex() > 0) {
			fechai.month = (String) Mesi.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fechai.month),
					fechai.year);
			days.add("");
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			lbxDii.setModel(lml);
		} else {
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDii() throws InterruptedException {
		if (lbxDii.getSelectedIndex() > 0) {
			fechai.day = (String) lbxDii.getSelectedItem().getValue();
		} else {
			//fechai.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHio() throws InterruptedException {
		if (lbxHio.getSelectedIndex() > 0) {
			fechai.hour = (String) lbxHio.getSelectedItem().getValue();
		} else {
			//fechai.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMii() throws InterruptedException {
		if (lbxMii.getSelectedIndex() > 0) {
			fechai.minute = (String) lbxMii.getSelectedItem().getValue();
		} else {
			//fechai.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	public void onSelect$Mesf() throws InterruptedException {
		if (Mesf.getSelectedIndex() > 0) {
			fechar.month = (String) Mesf.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fechar.month),
					fechar.year);
			days.add("");
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			lbxDif.setModel(lml);
		} else {
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDif() throws InterruptedException {
		if (lbxDif.getSelectedIndex() > 0) {
			fechar.day = (String) lbxDif.getSelectedItem().getValue();
		} else {
			fechar.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHif() throws InterruptedException {
		if (lbxHif.getSelectedIndex() > 0) {
			fechar.hour = (String) lbxHif.getSelectedItem().getValue();
			txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));
		} else {
			//fechar.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMif() throws InterruptedException {
		if (lbxMif.getSelectedIndex() > 0) {
			fechar.minute = (String) lbxMif.getSelectedItem().getValue();
			txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));
		} else {
			//fechar.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	public void onSelect$lbxParadas() throws InterruptedException {
		if (lbxParadas.getSelectedIndex() > 0) {
			oeeParada = (OeeParada) lbxParadas.getSelectedItem().getValue();
		} else {
			Sistema.mensaje("Seleccionar parada");
			oeeParada = null;
		}
	}

	public void onSelect$lbxMaquinaCerradora() throws InterruptedException {
		if (lbxMaquinaCerradora.getSelectedIndex() > 0) { 
			maquinaCerradora = (MaquinaCerradora) lbxMaquinaCerradora
					.getSelectedItem().getValue();
			/* Cargar las luthys asociadas a la maquina cerradora */
             cargarLuthys();
			lbxLuthy.setSelectedIndex(0); 
		} else {
			Sistema.mensaje("Seleccione una maquina cerradora");
			maquinaCerradora = null;
			lbxLuthy.getItems().clear();
			luthy = null;
			 
		}
	}
	
	
	public void cargarLuthys(){
		
		List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> 
		listaluthys = new OeeEnvasadoDetalleVelocidadMaquinaCerradoraDAOJpaImpl()
			.getOeeEnvasadoDetalleVelocidadMaquinaCerradorasByMaquinaAndProcesoApertura(
					maquinaCerradora.getIdmaquinacerradora(), envasadoProceso.getProcesoAperturaCierre().getIdprocesoaperturacierre());
		
		lbxLuthy.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Luthy()); 
		li.setParent(lbxLuthy);
		//agregar um item en null q seria la maquina cerradora 
		Listitem limaquina = new Listitem();
		Luthy lu = new Luthy();
		lu.setIdluthy(0);
		limaquina.setValue(lu); 
		new Listcell("Maquina").setParent(limaquina);
		limaquina.setParent(lbxLuthy);
		
		try {
			for (OeeEnvasadoDetalleVelocidadMaquinaCerradora item : listaluthys) {
				li = new Listitem();
				li.setValue(item.getLuthy());
				new Listcell(item.getLuthy().getNumeroluthy()+"").setParent(li);
				li.setParent(lbxLuthy);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.out.println("Error al cargar  listbox lbxLuthy");
		}
	}
	
	
	Luthy luthy;
	public void onSelect$lbxLuthy() throws InterruptedException {
		if (lbxLuthy.getSelectedIndex() > 0) {
			luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
		} else {
			luthy = null;
		}
	}

	public void onSelect$lbxParadasCurso() throws InterruptedException {
		lbxParadas.setSelectedIndex(0);
		if (lbxParadasCurso.getSelectedIndex() > 0) {
			oeeDetalleParada = (OeeDetalleParada) lbxParadasCurso
					.getSelectedItem().getValue();
			DateStruct fecha1 = Util.limpiarMesDiaHoraMin(
					Util.toTimestamp(oeeDetalleParada.getFechaHoraInicio()),
					Mesi, lbxDii, lbxHio, lbxMii);
			fechai = fecha1;
			txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));
			txtObservacion.setValue(oeeDetalleParada.getObservacion());
			oeeDetalleParadaEnvasado = new OeeDetalleParadaEnvasadoDAOJpaImpl()
					.getByIdDetalleParada(oeeDetalleParada
							.getIdOeeDetalleParada());
			/* maquinaCerradora = oeeDetalleParadaEnvasado.getMaquinaCerradora();
			int index = Util.findIndexItemByValue(lbxMaquinaCerradora,
					maquinaCerradora);
			lbxMaquinaCerradora.setSelectedIndex(index);
			lbxMaquinaCerradora.setDisabled(true); */
			
			/* seleccionar  la maquina cerrradora de la lista */
			if (oeeDetalleParadaEnvasado != null) {
				if (oeeDetalleParadaEnvasado.getMaquinaCerradora() != null) {
					maquinaCerradora = oeeDetalleParadaEnvasado.getMaquinaCerradora();
					for (Object item : lbxMaquinaCerradora.getItems()) {
						Listitem         listitem 			  = (Listitem) item;
						MaquinaCerradora maquinaCerradoraItem = (MaquinaCerradora) listitem.getValue();
						if (maquinaCerradora.getIdmaquinacerradora().equals(maquinaCerradoraItem.getIdmaquinacerradora())) {
							lbxMaquinaCerradora.setSelectedItem(listitem);
							if (envasadoProceso!=null) {
								cargarLuthys();
							}
						}
					}
				}
			}
			
			if (oeeDetalleParadaEnvasado.getIdluthy() != null) {
				Luthy lu = new Luthy();
				lu.setIdluthy(oeeDetalleParadaEnvasado.getIdluthy());
				luthy =  lu;
				//asignar el luty correspondiente 
				for (Object item : lbxLuthy.getItems()) {
					Listitem         listitem 			  = (Listitem) item;
					Luthy Luthyitem = (Luthy) listitem.getValue();
					if (Luthyitem.getIdluthy() != null) {
						if (luthy.getIdluthy().intValue() == Luthyitem.getIdluthy().intValue()) {
							lbxLuthy.selectItem(listitem);
						}
					}
				}	
			}else{
				if (! lbxLuthy.getItems().isEmpty()) {
					lbxLuthy.setSelectedIndex(1);//se indica q es solo maquina
				}
			}
			
			
		   /*	oeeParada = oeeDetalleParada.getOeeParada();
			index = lbxParadas.getItems().indexOf(oeeParada);
			lbxParadas.setSelectedIndex(index); */
			
			/* se debe cargar en el listbox la parada correspondiente al detalle de parada*/
			if (oeeDetalleParada.getOeeParada() != null) {
				oeeParada = oeeDetalleParada.getOeeParada();
				for (Object item : lbxParadas.getItems()) {
					Listitem 	   listitem = (Listitem) item;
					OeeParada oeeParadaItem = (OeeParada) listitem.getValue();
					if (oeeParada.getIdOeeParada() .equals( oeeParadaItem.getIdOeeParada() )) {
						lbxParadas.setSelectedItem(listitem);
					}
				}
			} 

		} else {
			txtTotalTiempo.setValue("0");
			txtObservacion.setValue("");
			lbxMaquinaCerradora.setDisabled(false);
			oeeDetalleParada = null;
			luthy = null;
			lbxLuthy.getItems().clear();
			if (lbxMaquinaCerradora.getSelectedIndex()>0) {
				lbxMaquinaCerradora.setSelectedIndex(0);
			}
		}
	}

	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			EnvasadoProceso envasadoProceso = new EnvasadoProcesoDAOJpaImpl()
					.getEnvasadoProcesoAperturado();
			if (envasadoProceso != null) {
				
				if (maquinaCerradora == null) {
					 Sistema.mensaje("Escoja una maquina cerradora ");
					 return;
				}
				if (lbxLuthy.getSelectedIndex() == 0) {
					 Sistema.mensaje("Escoja un Luthy ");
					 return;
				}

				if (lbxParadasCurso.getSelectedIndex() == 0) {
					OeeDetalleParada oeeDetalleParada = new OeeDetalleParada();
					oeeDetalleParada.setProcesoAperturaCierre(envasadoProceso
							.getProcesoAperturaCierre());
					oeeDetalleParada.setFechaHoraInicio(fechai.toTimestamp());
					
					/*if (lbxHif.getSelectedIndex() == 0
							|| lbxMif.getSelectedIndex() == 0)
						oeeDetalleParada.setFechaHoraFin(null);
					else
						oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp()); */
					
					
					if (Mesf.getSelectedIndex() == 0){
						 Sistema.mensaje("Si va a cerrar Parada escoja el MES ");
						 return;
					}
					
					if (lbxDif.getSelectedIndex() == 0){
						 Sistema.mensaje("Si va a cerrar Parada escoja el DIA ");
						 return;
					}
					
					if (lbxHif.getSelectedIndex() == 0 && lbxMif.getSelectedIndex() > 0){
						 Sistema.mensaje("Si va a cerrar Parada escoja la hora de fin ");
						 return;
					}
					
					
					if (lbxHif.getSelectedIndex() > 0 && lbxMif.getSelectedIndex() == 0){
						 Sistema.mensaje("Si va a cerrar Parada escoja el minuto de fin ");
						 return;
					}
					
					if (lbxHif.getSelectedIndex() == 0 && lbxMif.getSelectedIndex() > 0){
						 Sistema.mensaje("Si va a cerrar Parada escoja la hora de fin ");
						 return;
					}
					
					if (lbxHif.getSelectedIndex() > 0 && lbxMif.getSelectedIndex() > 0){
						oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
						System.out.println("con hora fin");
					}
					else{
						oeeDetalleParada.setFechaHoraFin(null);
					}
					
					
					
					oeeDetalleParada.setFechaRegistro(new java.sql.Timestamp(
							new Date().getTime()));
					oeeDetalleParada.setUsuario(usuario);

					oeeDetalleParada.setProcesoAperturaCierre(envasadoProceso
							.getProcesoAperturaCierre());
					oeeDetalleParada.setOeeParada(oeeParada);
					oeeDetalleParada.setObservacion(txtObservacion.getValue());

					oeeDetalleParadaEnvasado = new OeeDetalleParadaEnvasado();
					oeeDetalleParadaEnvasado .setMaquinaCerradora(maquinaCerradora);
					if (luthy!=null) {
						if (luthy.getIdluthy().intValue()==0) {
							oeeDetalleParadaEnvasado .setIdluthy(null);
						}else{
							oeeDetalleParadaEnvasado .setIdluthy(luthy.getIdluthy());
						}
					}
					
					oeeDetalleParadaEnvasado .setOeeDetalleParada(oeeDetalleParada);
					oeeDetalleParadaEnvasado
							.setIdoeedetalleparadaenvasado(oeeDetalleParada
									.getIdOeeDetalleParada());
					new OeeDetalleParadaEnvasadoDAOJpaImpl()
							.saveOrUpdate(oeeDetalleParadaEnvasado);
				} else {
					
					if (oeeDetalleParada != null) {
						System.out.println("oeeDetalleParada dif de null ");
						/* DateStruct fechaFin = Util.limpiarMesDiaHoraMin(
								Util.toTimestamp(oeeDetalleParada.getFechaHoraFin()),
								Mesi, lbxDii, lbxHio, lbxMii);
						fechar = fechaFin; */
						
						oeeDetalleParada.setObservacion(txtObservacion.getValue());
						
						/* if (lbxHif.getSelectedIndex() == 0 ){
							System.out.println("hora fin index 0 ");
							oeeDetalleParada.setFechaHoraFin(null);
						}else{
							oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
						}
						
						if (lbxMif.getSelectedIndex() == 0 ){
							System.out.println("min fin index 0 ");
							oeeDetalleParada.setFechaHoraFin(null);
						}else{
							
							oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
						} */
						
						if (Mesf.getSelectedIndex() == 0){
							 Sistema.mensaje("Si va a cerrar Parada escoja el MES ");
							 return;
						}
						
						if (lbxDif.getSelectedIndex() == 0){
							 Sistema.mensaje("Si va a cerrar Parada escoja el DIA ");
							 return;
						}
						
						if (lbxHif.getSelectedIndex() > 0 && lbxMif.getSelectedIndex() == 0){
							 Sistema.mensaje("Si va a cerrar Parada escoja el minuto de fin ");
							 return;
						}
						
						if (lbxHif.getSelectedIndex() == 0 && lbxMif.getSelectedIndex() > 0){
							 Sistema.mensaje("Si va a cerrar Parada escoja la hora de fin ");
							 return;
						}
						
						if (lbxHif.getSelectedIndex() > 0 && lbxMif.getSelectedIndex() > 0){
							oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
							System.out.println("con hora fin");
						}
						else{
							oeeDetalleParada.setFechaHoraFin(null);
						}
						
						
						new OeeDetalleParadaDAOJpaImpl()
						.saveOrUpdate(oeeDetalleParada);
					}
					
					
					
				  /*	if (lbxHif.getSelectedIndex() == 0
							|| lbxMif.getSelectedIndex() == 0)
						oeeDetalleParada.setFechaHoraFin(null);
					else
						oeeDetalleParada.setObservacion(txtObservacion.getValue());
						oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
					new OeeDetalleParadaDAOJpaImpl()
							.saveOrUpdate(oeeDetalleParada); */
				}

				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
				lastStep();
			} else
				Sistema.mensaje("No existe proceso de Envasado activo");
		}
	}

	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCamposDelete()) {
			if (new OeeDetalleParadaEnvasadoDAOJpaImpl()
					.delete(oeeDetalleParadaEnvasado)) {
				if (new OeeDetalleParadaDAOJpaImpl().delete(oeeDetalleParada))
					Sistema.mensaje("Transaccion completada");
				else
					Sistema.mensaje("Registro Detalle Parada en uso");
			} else
				Sistema.mensaje("Registro Rackeo en uso");
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			lastStep();
		}
	}
}
