package com.nw.webui.produccion;
 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoProceso;
import com.nw.model.Luthy;
import com.nw.model.MaquinaCerradora;
import com.nw.model.OeeDetalleParada;
import com.nw.model.OeeDetalleParadaEnvasado;
import com.nw.model.OeeEnvasadoCabeceraVelocidadMaquinaCerradora;
import com.nw.model.OeeEnvasadoDetalleVelocidadMaquinaCerradora;
import com.nw.model.OeeParada;
import com.nw.model.Produccion;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.MaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleParadaDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleParadaEnvasadoDAOJpaImpl;
import com.nw.model.dao.impl.OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeEnvasadoDetalleVelocidadMaquinaCerradoraDAOJpaImpl;
import com.nw.model.dao.impl.OeeParadaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;
//nw 8.2 mt
@SuppressWarnings("serial")
public class EnvasadoDetalleParadasWindow extends GenericForwardComposer {

	private Datebox dteFecha;
	private Listbox lbxFechaTurnoLabor;
	private Listbox lbxMaquina,lbxLuthy;
	private Listbox lbxParadasCurso;
	private Listbox lbxParadas;
	@SuppressWarnings("unused")
	private Toolbarbutton btnTomarTiempoi;
	private Listbox lbxMi;
	private Listbox lbxDi;
	private Listbox lbxHi;
	private Listbox lbxMin;
	@SuppressWarnings("unused")
	private Toolbarbutton btnSinTiempo;
	@SuppressWarnings("unused")
	private Toolbarbutton btnTomarTiempo;
	private Listbox lbxMr;
	private Listbox lbxDir;
	private Listbox lbxHir;
	private Listbox lbxMinr;
	private Textbox txtTotalTiempo;
	private Textbox txtObservacion;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;

	Usuario usuario = new Usuario();
	private DateStruct fechai;
	private DateStruct fechar;
	private OeeDetalleParada oeeDetalleParada;
	private OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado;
	private Produccion produccion;
	private EnvasadoProceso envasadoProceso;
	private OeeParada oeeParada;
	private MaquinaCerradora maquinaCerradora;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		limpiarDatos();
		cargarListas();
		fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		fechar = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
		cargarDatos();
		

	}

	void limpiarDatos() {
		ChkEliminar.setChecked(false);
		//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		//fechar = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
		txtObservacion.setValue("");
		txtTotalTiempo.setValue("");
		//dteFecha.setValue(new Date());
		if (lbxParadasCurso.getSelectedIndex()>0) {
			lbxParadasCurso.setSelectedIndex(0);
		}
		encerarLista();
	}
	
	
	public void cargarDatos(){
		ChkEliminar.setChecked(false);
		fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		fechar = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
		//lbxHif.setSelectedIndex(0);
		//lbxMif.setSelectedIndex(0);
		txtObservacion.setValue("");
		txtTotalTiempo.setValue("");
		maquinaCerradora = null;
		luthy            = null;
		oeeParada 		 = null;
		lbxParadasCurso.setSelectedIndex(0);
		lbxParadas.setSelectedIndex(0);
	}

	private void cargarListas() {
		   /* esto estaba asi pero no funcionaba */
		  /*Util.cargarLista(MaquinaCerradora.class,
				new MaquinaCerradoraDAOJpaImpl().getAll(), lbxMaquina,
				"Error al cargar data de Maquina Cerradora", false, ""); */
		 OeeDetalleParada oeeDetalleParada = new OeeDetalleParada();
		 Util.agregarItemNuevo(oeeDetalleParada,lbxParadasCurso,"Nueva Parada");
		
		/* Util.cargarLista(MaquinaCerradora.class, new MaquinaCerradoraDAOJpaImpl().getAll(),
					lbxMaquina, null, false, "MaquinaCerradora");*/
		 
		 Util.cargarLista(OeeParada.class,  
				 new OeeParadaDAOJpaImpl().getOeeParadaByIdProceso(13),  
					lbxParadas, null, false, "Parada");
	}
	
	private boolean validarCampos() {
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			return false;
		}
		
		if (lbxParadasCurso.getSelectedIndex() == 0
				&& lbxParadas.getSelectedIndex() == 0) {
			Sistema.mensaje("Seleccione una parada");
			lbxParadas.setFocus(true);
			return false;
		}
		
	    if (Util.validarListboxFecha(lbxMi,lbxDi,lbxHi,lbxMin)) {
			  Sistema.mensaje("Seleccione bien la fecha ");
			  return false;
		}

		if (lbxHir.getSelectedIndex() != 0 && lbxMinr.getSelectedIndex() != 0) {
			int data = fechai.toTimestamp().compareTo(fechar.toTimestamp());
			if (data > 0) {
				Sistema.mensaje("Fecha Final debe ser mayor a la inicial");
				lbxMr.setFocus(true);
				return false;
			} else {
				int total = Util.validar24horas(fechai, fechar);
				if (total > ((24 * 60) - 1) && total < 0) {
					Sistema.mensaje("No pude ser mayor a 24 horas");
					lbxMinr.setFocus(true);
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

	public void onSelect$lbxMi() throws InterruptedException {
		/*if (fechai != null) {
			Util.alSeleccionarMes(lbxMi, fechai, "Seleccione un mes");	
		} */
		
		if (lbxMi.getSelectedIndex() > 0) {
			fechai.month = (String) lbxMi.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fechai.month),
					fechai.year);
			days.add("");
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			lbxDi.setModel(lml);
		} else {
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDi() throws InterruptedException {
		if (lbxDi.getSelectedIndex() > 0) {
			if (fechai != null) {
				fechai.day = (String) lbxDi.getSelectedItem().getValue();
			}
		} else {
			//fechai.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			if (fechai != null) {
				fechai.hour = (String) lbxHi.getSelectedItem().getValue();
			}
		} else {
			//fechai.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			if (fechai != null) {
				fechai.minute = (String) lbxMin.getSelectedItem().getValue();
			}
		} else {
			//fechai.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	public void onSelect$lbxMr() throws InterruptedException {
		/*if (fechar != null) {
			Util.alSeleccionarMes(lbxMr, fechar, "Seleccione un mes");	
		} */
		
		if (lbxMr.getSelectedIndex() > 0) {
			fechar.month = (String) lbxMr.getSelectedItem().getValue();
			ArrayList<String> days = new ArrayList<String>();
			int daysMonth = Util.diasDelMes(Integer.parseInt(fechar.month),
					fechar.year);
			days.add("");
			for (int i = 1; i <= daysMonth; i++) {
				days.add(Integer.toString(i));
			}
			ListModelList lml = new ListModelList(days);
			lbxDir.setModel(lml);
			txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));
		} else {
			Sistema.mensaje("Seleccione un mes");
		}
		
	}

	public void onSelect$lbxDir() throws InterruptedException {
		if (lbxDir.getSelectedIndex() > 0) {
			if (fechar != null) {
				fechar.day = (String) lbxDir.getSelectedItem().getValue();
				txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));///
			}	
		} else {
			//fechar.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHir() throws InterruptedException {
		if (lbxHir.getSelectedIndex() > 0) {
			if (fechar != null) {
			    fechar.hour = (String) lbxHir.getSelectedItem().getValue();
				txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));///
			}
		} else {
			//fechar.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMinr() throws InterruptedException {
		if (lbxMinr.getSelectedIndex() > 0) {
			if (fechar != null) {
			    fechar.minute = (String) lbxMinr.getSelectedItem().getValue();
				txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));///
			}
		} else {
			//fechar.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	/*15-09-2017 correcion en este metodo : 
	 *  1.- para la seleccion del datebox se usa el onChange y tenia puesto un onSelect q no tenia ningun efecto 
	 *  2.- el objeto produccion cuando se escogia una fecha q no devolvia nada estaba en null y se enviaba 
	 *      asi a la siguiente consulta q provacaba un error y se caia el sistema   */
	public void onChange$dteFecha() throws InterruptedException {//onSelect$dteFecha onChange$dteFecha
		Date date = dteFecha.getValue();
		produccion = new ProduccionDAOJpaImpl().getProduccionByFecha(Util
				.toTimestamp(date));
		if (produccion != null) {
			List<EnvasadoProceso> envasadoProcesos = 
					new EnvasadoProcesoDAOJpaImpl()
			    			   .getEnvasadoProcesoByIdProduccion(produccion
			    						.getIdproduccion());
			EnvasadoProceso ep = null; 
			Util.cargarListbox(ep,
					envasadoProcesos , lbxFechaTurnoLabor,
					 "", false ); //Error al cargar data de Fecha EnvasadoProceso_Fechaproduccion
		}

	}

	public void onSelect$lbxFechaTurnoLabor() throws InterruptedException {
		if (lbxFechaTurnoLabor.getSelectedIndex() > 0) {
			envasadoProceso = (EnvasadoProceso) lbxFechaTurnoLabor
					.getSelectedItem().getValue();
			
		   /* Util.cargarLista(OeeDetalleParada.class,
					new OeeDetalleParadaDAOJpaImpl().findByIdPacAndIdProceso(
							envasadoProceso.getProcesoAperturaCierre()
									.getIdprocesoaperturacierre(), 13),
					lbxParadasCurso, "Error al cargar data de Detalle Parada",
					false, ""); */
			
			Util.cargarLista(OeeDetalleParada.class, 
					new OeeDetalleParadaDAOJpaImpl().findByIdPacAndIdProceso(
							envasadoProceso.getProcesoAperturaCierre()
									.getIdprocesoaperturacierre(), 13),  
							            lbxParadasCurso, null, true, "OeeDetalleParada");//true muestra nueva linea
		    if (envasadoProceso!=null) {
		    	cargarMaquinasCabeceras();
			}else{
				Sistema.mensaje("No Existe un proceso de Aperturado");
			}
			
		} else {
			Sistema.mensaje("Seleccione una Fecha/Turno Labor");
			envasadoProceso = null;
		}
	}

	/* se cargan las maquinas configuradas para el proceso de la clase OeeEnvasadoCabeceraVelocidadMaquinaCerradora */
	public void cargarMaquinasCabeceras(){
		List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora>  maquinas = 
				new OeeEnvasadoCabeceraVelocidadMaquinaCerradoraDAOJpaImpl()
						.getOeeEnvasadoDetalleVelocidadMaquinaCerradoras(
								envasadoProceso.getProcesoAperturaCierre().getIdprocesoaperturacierre());
		lbxMaquina.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new MaquinaCerradora()); 
			li.setParent(lbxMaquina);
			try {
				for (OeeEnvasadoCabeceraVelocidadMaquinaCerradora t : maquinas) {
					li = new Listitem();
					li.setValue(t.getMaquinaCerradora());
					new Listcell(t.getMaquinaCerradora().getDescripcion()).setParent(li);
					li.setParent(lbxMaquina);
				}
			} catch (Exception e) {
				 e.printStackTrace();
				System.out.println("Error al cargar  listbox lbxMaquinaCerradora");
			}
			lbxMaquina.setSelectedIndex(0);
	}
	
	
	public void onSelect$lbxParadas() throws InterruptedException {
		//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		//fechar = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
		if (lbxParadas.getSelectedIndex() > 0) {
			setOeeParada((OeeParada) lbxParadas.getSelectedItem().getValue());
		} else {
			Sistema.mensaje("Seleccionar parada");
			oeeParada = null;
		}
	}

	public void onSelect$lbxMaquina() throws InterruptedException {
		if (lbxMaquina.getSelectedIndex() > 0) {
			maquinaCerradora = (MaquinaCerradora) lbxMaquina.getSelectedItem()
					.getValue();
			/* Cargar las luthys asociadas a la maquina cerradora */
            cargarLuthys();
			lbxLuthy.setSelectedIndex(0); 
		} else {
			Sistema.mensaje("Seleccione una Maquina");
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
		 if (lbxParadasCurso.getSelectedIndex() > 0) {
			oeeDetalleParada = (OeeDetalleParada) lbxParadasCurso
					.getSelectedItem().getValue();
			 //OeeDetalleParadaEnvasado
			 oeeDetalleParadaEnvasado = new OeeDetalleParadaEnvasadoDAOJpaImpl()
					.getByIdDetalleParada(oeeDetalleParada
							.getIdOeeDetalleParada());
			
			/* seleccionar  la maquina cerrradora de la lista */
			if (oeeDetalleParadaEnvasado != null) {
				if (oeeDetalleParadaEnvasado.getMaquinaCerradora() != null) {
					maquinaCerradora = oeeDetalleParadaEnvasado.getMaquinaCerradora();
					for (Object item : lbxMaquina.getItems()) {
						Listitem         listitem 			  = (Listitem) item;
						MaquinaCerradora maquinaCerradoraItem = (MaquinaCerradora) listitem.getValue();
						if (maquinaCerradora.getIdmaquinacerradora().equals(maquinaCerradoraItem.getIdmaquinacerradora())) {
							lbxMaquina.setSelectedItem(listitem);
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
			
			//cagar la fecha hora inicio de la parada en curso 
			if (oeeDetalleParada.getFechaHoraInicio() != null) {
				fechai  = Util.limpiarMesDiaHoraMin(oeeDetalleParada.getFechaHoraInicio(),lbxMi,lbxDi,lbxHi,lbxMin);
				//Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
			}else{
				 lbxMi.setSelectedIndex(0); //lbxDi.setSelectedIndex(0);
				 lbxHi.setSelectedIndex(0); lbxMin.setSelectedIndex(0);
			}
			
			//cagar la fecha hora inicio de la parada en curso 
			if (oeeDetalleParada.getFechaHoraFin() != null) {
				fechar = Util.limpiarMesDiaHoraMin(oeeDetalleParada.getFechaHoraFin(),lbxMr,lbxDir,lbxHir,lbxMinr);
				//Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
			}else{
				 lbxMr.setSelectedIndex(0);  //lbxDir.setSelectedIndex(0);
				 lbxHir.setSelectedIndex(0); lbxMinr.setSelectedIndex(0);
			}
			
			txtObservacion.setValue(oeeDetalleParada.getObservacion());
			
			if (fechar != null) {
				txtTotalTiempo.setValue(Util.getTotalTime(fechai, fechar));
			}
			
		 }else{
			 encerarLista();
			 if (oeeDetalleParada.getFechaHoraInicio() != null) {
				 fechai  = Util.limpiarMesDiaHoraMin(oeeDetalleParada.getFechaHoraInicio(),lbxMi,lbxDi,lbxHi,lbxMin);
			 }
			 if (oeeDetalleParada.getFechaHoraFin() != null) {
					fechar = Util.limpiarMesDiaHoraMin(oeeDetalleParada.getFechaHoraFin(),lbxMr,lbxDir,lbxHir,lbxMinr);
			 }
			 
			 txtTotalTiempo.setValue("");
			 txtObservacion.setValue("");
			 oeeDetalleParada = null;
			 maquinaCerradora = null;
			 oeeParada = null;
			luthy = null;
			lbxLuthy.getItems().clear();
			if (lbxMaquina.getSelectedIndex()>0) {
				lbxMaquina.setSelectedIndex(0);
			}
		 }
	}
	
	
	public void encerarLista(){
		 /* como es una nueva los listbox de maquinas y de paradas deben estar sin seleccionar*/
		 if (lbxMaquina.getSelectedIndex()>0) {
			 lbxMaquina.setSelectedIndex(0);
		 }
		 if (lbxParadas.getSelectedIndex()>0) {
			 lbxParadas.setSelectedIndex(0);
		 }
		 /* encerar listbox Inicio*/
		 if (lbxMr.getSelectedIndex()>0) {
			 lbxMr.setSelectedIndex(0);
		 }
		 if (lbxDir.getSelectedIndex()>0) {
			 lbxDir.setSelectedIndex(0);
		 }
		 if (lbxHir.getSelectedIndex()>0) {
			lbxHir.setSelectedIndex(0);
		 }
		 if (lbxMinr.getSelectedIndex()>0) {
			lbxMinr.setSelectedIndex(0);
		 }
		 /* encerar listbox fin*/
		 if (lbxMi.getSelectedIndex()>0) {
			 lbxMi.setSelectedIndex(0);
		 }
		 if (lbxDi.getSelectedIndex()>0) {
			 lbxDi.setSelectedIndex(0);
		 }
		 if (lbxHi.getSelectedIndex()>0) {
			 lbxHi.setSelectedIndex(0);
		 }
		 if (lbxMin.getSelectedIndex()>0) {
			 lbxMin.setSelectedIndex(0);
		 }
		 
		 if (lbxLuthy.getSelectedIndex()>0) {
			 lbxLuthy.setSelectedIndex(0);
		 }
		
		maquinaCerradora = null;
		luthy            = null;
	}

	/* 18-09-2017 correcion .- este metodo no consideraba si era una nueva parada , no asignaba parada*/
	public void onClick$btnGrabar() throws InterruptedException {
		if (validarCampos()) {
			 //EnvasadoProceso envasadoProceso = new EnvasadoProcesoDAOJpaImpl()
				//	.getEnvasadoProcesoAperturado();
			
			if (this.envasadoProceso == null) {
				Sistema.mensajeError("Seleccione un Turno Labor !!!");
				return;
			}
			
			if (maquinaCerradora == null) {
				Sistema.mensajeError("Seleccione una maquina !!!");
				return;
			}
			
			if (lbxLuthy.getSelectedIndex() == 0) {
				 Sistema.mensaje("Escoja un Luthy ");
				 return;
			}
			
			if (oeeParada == null) {
				Sistema.mensajeError("Seleccione una parada !!!");
				return;
			}
		
			/* si es nueva parada */
			if (lbxParadasCurso.getSelectedIndex() == 0) {
				OeeDetalleParada oeeDetalleParada = new OeeDetalleParada();
				if (this.envasadoProceso != null) {
					oeeDetalleParada.setProcesoAperturaCierre(envasadoProceso
							.getProcesoAperturaCierre());
				}
				
				/* if (fechai==null) {
					Sistema.mensaje("Debe escoger Tiempo Inicio Parada");
					return;
				}*/
				
				oeeDetalleParada.setFechaHoraInicio(fechai.toTimestamp());

				if (lbxMr.getSelectedIndex() == 0 && lbxDir.getSelectedIndex() > 0 && lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0  ){
					 Sistema.mensaje("Si va a cerrar Parada escoja el MES ");
					 return;
				}
				
				if (lbxDir.getSelectedIndex() == 0 && lbxMr.getSelectedIndex() > 0 && lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja el DIA ");
					 return;
				}
				
				if (lbxHir.getSelectedIndex() == 0 && lbxMinr.getSelectedIndex() > 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja la hora de fin ");
					 return;
				}
				
				
				if (lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() == 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja el minuto de fin ");
					 return;
				}
				
				if (lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0){
					oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
					System.out.println("con hora fin");
				}
				else{
					oeeDetalleParada.setFechaHoraFin(null);
				}
				
				oeeDetalleParada.setObservacion(txtObservacion.getValue());
				oeeDetalleParada.setOeeParada(oeeParada);
				oeeDetalleParada.setFechaRegistro(new Timestamp(new Date().getTime()));
				oeeDetalleParada.setUsuario(usuario);
				
				oeeDetalleParada = new OeeDetalleParadaDAOJpaImpl().saveOrUpdate2(oeeDetalleParada);
				if (oeeDetalleParada != null) {
					oeeDetalleParadaEnvasado = new OeeDetalleParadaEnvasado();
					oeeDetalleParadaEnvasado.setOeeDetalleParada(oeeDetalleParada);
					oeeDetalleParadaEnvasado.setMaquinaCerradora(maquinaCerradora);
					if (luthy!=null) {
						if (luthy.getIdluthy().intValue()==0) {
							oeeDetalleParadaEnvasado .setIdluthy(null);
						}else{
							oeeDetalleParadaEnvasado .setIdluthy(luthy.getIdluthy());
						}
					}
					oeeDetalleParadaEnvasado = new OeeDetalleParadaEnvasadoDAOJpaImpl()
							.saveOrUpdate(oeeDetalleParadaEnvasado);
					
					Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
					limpiarDatos();
					if (envasadoProceso!=null) {
						Util.cargarLista(OeeDetalleParada.class, 
								new OeeDetalleParadaDAOJpaImpl().findByIdPacAndIdProceso(
										envasadoProceso.getProcesoAperturaCierre()
												.getIdprocesoaperturacierre(), 13),  
										            lbxParadasCurso, null, true, "OeeDetalleParada");
					}
					
				}else{
					Sistema.mensaje("Error al grabar !!!");
				}
				
				
				
			}else{/* si es parada existente */
				if (this.envasadoProceso != null) {
					oeeDetalleParada.setProcesoAperturaCierre(envasadoProceso
							.getProcesoAperturaCierre());
				}
				
				/* if (fechar != null) {
					oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
				} */
				
				if (lbxMr.getSelectedIndex() == 0 && lbxDir.getSelectedIndex() > 0 && lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0  ){
					 Sistema.mensaje("Si va a cerrar Parada escoja el MES ");
					 return;
				}
				
				if (lbxDir.getSelectedIndex() == 0 && lbxMr.getSelectedIndex() > 0 && lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja el DIA ");
					 return;
				}
				
				if (lbxHir.getSelectedIndex() == 0 && lbxMinr.getSelectedIndex() > 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja la hora de fin ");
					 return;
				}
				
				
				if (lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() == 0){
					 Sistema.mensaje("Si va a cerrar Parada escoja el minuto de fin ");
					 return;
				}
				
				if (lbxHir.getSelectedIndex() > 0 && lbxMinr.getSelectedIndex() > 0){
					oeeDetalleParada.setFechaHoraFin(fechar.toTimestamp());
					System.out.println("con hora fin");
				}
				else{
					oeeDetalleParada.setFechaHoraFin(null);
				}
				
				oeeDetalleParada.setFechaHoraInicio(fechai.toTimestamp());
				oeeDetalleParada.setObservacion(txtObservacion.getValue());
				oeeDetalleParada.setOeeParada(oeeParada);
				new OeeDetalleParadaDAOJpaImpl().saveOrUpdate(oeeDetalleParada);
				if (oeeDetalleParadaEnvasado!=null) {
					oeeDetalleParadaEnvasado.setOeeDetalleParada(oeeDetalleParada);
					oeeDetalleParadaEnvasado.setMaquinaCerradora(maquinaCerradora);
					if (luthy!=null) {
						if (luthy.getIdluthy().intValue()==0) {
							oeeDetalleParadaEnvasado .setIdluthy(null);
						}else{
							oeeDetalleParadaEnvasado .setIdluthy(luthy.getIdluthy());
						}
					}
					new OeeDetalleParadaEnvasadoDAOJpaImpl()
							.saveOrUpdate(oeeDetalleParadaEnvasado);
				}
				Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
				//limpiarDatos();
			}
			
		}
	}

	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCampos()) {
			if (oeeDetalleParadaEnvasado != null) {
				try {
					new OeeDetalleParadaEnvasadoDAOJpaImpl().delete(oeeDetalleParadaEnvasado);
					if (oeeDetalleParada!=null) {
						new OeeDetalleParadaDAOJpaImpl().delete(oeeDetalleParada);
					}
					Sistema.mensaje("Registro Eliminado");
					limpiarDatos();
					if (envasadoProceso!=null) {
						Util.cargarLista(OeeDetalleParada.class, 
								new OeeDetalleParadaDAOJpaImpl().findByIdPacAndIdProceso(
										envasadoProceso.getProcesoAperturaCierre()
												.getIdprocesoaperturacierre(), 13),  
										            lbxParadasCurso, null, true, "OeeDetalleParada");
					}
				} catch (Exception e) {
					 e.printStackTrace();
					 Sistema.mensaje("Paso esto :"+" "+e.getMessage());
				}
				
			}else{
				if (oeeDetalleParada!=null) {
					new OeeDetalleParadaDAOJpaImpl().delete(oeeDetalleParada);
					Sistema.mensaje("Registro Eliminado");
					limpiarDatos();
					
					if (envasadoProceso!=null) {
						Util.cargarLista(OeeDetalleParada.class, 
								new OeeDetalleParadaDAOJpaImpl().findByIdPacAndIdProceso(
										envasadoProceso.getProcesoAperturaCierre()
												.getIdprocesoaperturacierre(), 13),  
										            lbxParadasCurso, null, true, "OeeDetalleParada");
					}
				}
				
			}
			
			 
		}
	}

	public void onClick$btnTomarTiempoi() throws InterruptedException {
		if (oeeParada == null) {
			Sistema.mensaje("Debe escoger una Parada");
			return;
		}
		fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
	}

	public void onClick$btnSinTiempo() throws InterruptedException {
		if (lbxMr.getSelectedIndex()>0) {
			lbxMr.setSelectedIndex(0);
		}
		if (lbxDir.getSelectedIndex()>0) {
			lbxDir.setSelectedIndex(0);
		}
		if (lbxHir.getSelectedIndex()>0) {
			lbxHir.setSelectedIndex(0);
		}
		if (lbxMinr.getSelectedIndex()>0) {
			lbxMinr.setSelectedIndex(0);
		}
	}

	public void onClick$btnTomarTiempo() throws InterruptedException {
		if (oeeParada == null) {
			Sistema.mensaje("Debe escoger una Parada");
			return;
		}
		fechar = Util.limpiarMesDiaHoraMin(lbxMr, lbxDir, lbxHir, lbxMinr);
		//Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
	}

	public OeeParada getOeeParada() {
		return oeeParada;
	}

	public void setOeeParada(OeeParada oeeParada) {
		this.oeeParada = oeeParada;
	}
}
