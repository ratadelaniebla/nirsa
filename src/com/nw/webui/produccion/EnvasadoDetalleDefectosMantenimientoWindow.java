package com.nw.webui.produccion;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EnvasadoProceso;
import com.nw.model.Especie;
import com.nw.model.EspecieTalla;
import com.nw.model.Luthy;
import com.nw.model.LuthyMaquinaCerradoraEstandar;
import com.nw.model.OeeDefecto;
import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.OeeDetalleMediosConDefectoEnvasado;
import com.nw.model.OeeDetalleMediosConDefectoLimpieza;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Talla;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EnvasadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LuthyDAOJpaImpl;
import com.nw.model.dao.impl.LuthyMaquinaCerradoraEstandarDAOJpaImpl;
import com.nw.model.dao.impl.OeeDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoDAOJpaImpl;
import com.nw.model.dao.impl.OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;
import com.nwl.mapeo.Util;
import com.nwl.mapeo.Util.DateStruct;


//10.3 
@SuppressWarnings("serial")
public class EnvasadoDetalleDefectosMantenimientoWindow extends
		GenericForwardComposer {
	Usuario usuario = new Usuario();

	private Datebox dteFechaLabor;
	private Listbox lbxTurno;
	private Listbox lbxLuthy;
	private Listbox lbxMaquinaCerradora;
	private Listbox lbxDefecto;
	private Listbox lbxlistaDefecto;
	private Textbox txtProduccionTurno;
	private Listbox lbxLote;
	@SuppressWarnings("unused")
	private Toolbarbutton btnActualizarLotes;
	private Textbox txtEspecieTalla;
	private Intbox intLatas;
	@SuppressWarnings("unused")
	private Toolbarbutton btnTomarTiempoi;
	private Listbox lbxMi;
	private Listbox lbxDi;
	private Listbox lbxHi;
	private Listbox lbxMin;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Checkbox ChkEliminar;
	@SuppressWarnings("unused")
	private Toolbarbutton btnEliminar;

	private DateStruct fechai;

	private Produccion produccion;

	private Turno turno;

	private ProduccionDetalleLote lote;

	private EnvasadoProceso envasadoProceso;

	private Luthy luthy;

	private OeeDefecto defecto;

	private Date fechaLabor;

	private LuthyMaquinaCerradoraEstandar maquinaCerradoraEstandar;

	private OeeDetalleMediosConDefectoEnvasado oeeDetalleMediosConDefectoEnvasado;

	private OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		String usuarioSession = (String) Sessions.getCurrent().getAttribute(
				"usuario");
		usuario.setIdusuario(usuarioSession);
		cargarListas();
		limpiarDatos();
		intLatas.setValue(0);
	}

	//onChange
	public void onBlur$dteFechaLabor() throws InterruptedException {
		fechaLabor = dteFechaLabor.getValue();
		//limpiarDatos();
	}
	
	public void onSelect$lbxTurno() throws InterruptedException {
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
			
			if (fechaLabor == null) {
				Sistema.mensaje("Debe escoger una fecha");
				lbxTurno.setSelectedIndex(0);
				turno = null;
				txtProduccionTurno.setValue("");
				return;
			}
			 
			envasadoProceso = new EnvasadoProcesoDAOJpaImpl()
					.getEnvasadoProcesoByDateAndTurno( Util.toTimestamp(fechaLabor), turno.getIdturno());
			if (envasadoProceso == null) {
				Sistema.mensaje("No existe un proceso de envasado para la fecha y turno escogidos");
				lbxTurno.setSelectedIndex(0);
				turno = null;
				txtProduccionTurno.setValue("");
				return;
			}
				produccion = envasadoProceso.getProduccion();  // new ProduccionDAOJpaImpl() .getProduccionById(envasadoProceso .getLimpiezaProceso().getIdproduccion());
				//turno = new TurnoDAOJpaImpl().findById(envasadoProceso .getLimpiezaProceso().getIdturno());
				String valueProduccionTurno = String.format("%s - %s", Util
						.formatearFechaDDMMYYYY(produccion
								.getFechaproduccion()), turno.getIdturno());
				txtProduccionTurno.setValue(valueProduccionTurno);
			 
			cargarLote();
		} else {
			turno = null;
			txtProduccionTurno.setValue("");
			//Sistema.mensaje("Seleccione un Turno");
			encerarListbox();
			limpiarDatos();
			if (lbxLote.getSelectedIndex() > 0) {
				lbxLote.setSelectedIndex(0);
				lote = null;
			}
		}
	}
	
	public void onSelect$lbxMi() throws InterruptedException {
		//Util.alSeleccionarMes(lbxMi, fechai, "Seleccione un mes");
		if (lbxMi.getSelectedIndex() > 0) {
			fechai.month = (String) lbxMi.getSelectedItem().getValue();
			Util.alSeleccionarMes(lbxDi, fechai, "Seleccione un mes");
		}else{
			fechai.month = null;
			Sistema.mensaje("Seleccione un mes");
		}
	}

	public void onSelect$lbxDi() throws InterruptedException {
		if (lbxDi.getSelectedIndex() > 0) {
			fechai.day = (String) lbxDi.getSelectedItem().getValue();
		} else {
			fechai.day = null;
			Sistema.mensaje("Seleccione un dia");
		}
	}

	public void onSelect$lbxHi() throws InterruptedException {
		if (lbxHi.getSelectedIndex() > 0) {
			fechai.hour = (String) lbxHi.getSelectedItem().getValue();
		} else {
			fechai.hour = null;
			Sistema.mensaje("Seleccione una hora");
		}
	}

	public void onSelect$lbxMin() throws InterruptedException {
		if (lbxMin.getSelectedIndex() > 0) {
			fechai.minute = (String) lbxMin.getSelectedItem().getValue();
		} else {
			fechai.minute = null;
			Sistema.mensaje("Seleccione un minuto");
		}
	}

	/* seleccion de hora-defecto */
	public void onSelect$lbxDefecto() throws InterruptedException {
		if (lbxDefecto.getSelectedIndex() > 0) {
			oeeDetalleMediosConDefectoEnvasado = (OeeDetalleMediosConDefectoEnvasado) lbxDefecto.getSelectedItem().getValue();
			if (lbxLote.getSelectedIndex() > 0) {
				lbxLote.setSelectedIndex(0);
				lote = null;
			}
			buscarLoteActual();
			buscarDefectoActual();
			if (oeeDetalleMediosConDefectoEnvasado.getOeeDetalleMediosConDefecto().getCantidadDefectos() != null) {
				intLatas.setValue(oeeDetalleMediosConDefectoEnvasado.getOeeDetalleMediosConDefecto().getCantidadDefectos());
			}
		} else {
			oeeDetalleMediosConDefectoEnvasado = null;
			//Sistema.mensaje("Seleccione un elemento hora-defecto");
			limpiarDatos();
			//deseleccionar los defectos 
			if (lbxlistaDefecto.getSelectedIndex() > 0) {
				lbxlistaDefecto.setSelectedIndex(0);
				defecto = null;
			}
			if (lbxLote.getSelectedIndex() > 0) {
				lbxLote.setSelectedIndex(0);
				lote = null;
			}
			
			
			
		}
	}
	
	public void onSelect$lbxlistaDefecto() throws InterruptedException {
		if (lbxlistaDefecto.getSelectedIndex() > 0) {
			defecto = (OeeDefecto) lbxlistaDefecto.getSelectedItem().getValue();
		} else {
			defecto = null;
			Sistema.mensaje("Seleccione un defecto");
		}
	}

	public void onSelect$lbxLuthy() throws InterruptedException {
		if (lbxLuthy.getSelectedIndex() > 0) {
			luthy = (Luthy) lbxLuthy.getSelectedItem().getValue();
			lbxMaquinaCerradora.getItems().clear();
			maquinaCerradoraEstandar = null;
			Util.cargarLista(LuthyMaquinaCerradoraEstandar.class,
					new LuthyMaquinaCerradoraEstandarDAOJpaImpl()
							.getMceByLuthy(luthy.getIdluthy()),
					lbxMaquinaCerradora,
					"Error al cargar data de Maquina cerradora", false,
					"LuthyMaquina");
			/* limpiar listbox hora-defecto*/
			lbxDefecto.getItems().clear();
			oeeDetalleMediosConDefectoEnvasado = null;
			oeeDetalleMediosConDefecto         = null;
			if (lbxlistaDefecto.getSelectedIndex() >0 ) { 
				lbxlistaDefecto.setSelectedIndex(0);
				defecto = null;
			}
		} else {
			luthy = null;
			txtProduccionTurno.setValue("");
			encerarListbox();
			limpiarDatos();
			Sistema.mensaje("Seleccione un Luthy");
		}
	}

	public void onSelect$lbxMaquinaCerradora() throws InterruptedException {
		if (lbxMaquinaCerradora.getSelectedIndex() > 0) {
			maquinaCerradoraEstandar = (LuthyMaquinaCerradoraEstandar) lbxMaquinaCerradora
					.getSelectedItem().getValue();
			cargarHoraDefecto();
		} else {
			maquinaCerradoraEstandar = null;
			//Sistema.mensaje("Seleccione una Maquina");
			encerarListbox();
			limpiarDatos();
			if (lbxLote.getSelectedIndex() > 0) {
				lbxLote.setSelectedIndex(0);
				lote = null;
			}
		}
	}

	public void onSelect$lbxLote() throws InterruptedException {
		if (lbxLote.getSelectedIndex() > 0) {
			lote = (ProduccionDetalleLote) lbxLote.getSelectedItem().getValue();
			
			/*EspecieTalla especieTalla = new EspecieTallaDAOJpaImpl()
					.getById(lote.getIdespecietalla());
			Especie especie = new EspecieDAOJpaImpl().getById(especieTalla
					.getIdespecie());
			Talla talla = new TallaDAOJpaImpl().getById(especieTalla
					.getIdtalla()); */
			
			EspecieTalla especieTalla = lote.getEspecieTalla();
			Especie 	 especie 	  = especieTalla.getEspecie();
			Talla		 talla 		  =  especieTalla.getTalla();
			
			txtEspecieTalla.setValue(String.format("%s %s",
					especie.getNombre(), talla.getNombre()));
			//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
			if (produccion != null) {
				fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(), new Date(),lbxMi, lbxDi, lbxHi, lbxMin);	
			}else{
				Sistema.mensaje("No existe un proceso de envasado para la fecha y turno escogidos");
			}
		} else {
			lote = null;
			Sistema.mensaje("Seleccione un Lote");
		}
	}



	/*public void onClick$dteFechaLabor() throws InterruptedException {
		fechaLabor = dteFechaLabor.getValue();
		limpiarDatos();
	}*/

	public void onClick$btnGrabar() throws InterruptedException {
			
			if (envasadoProceso == null) {
				Sistema.mensaje("No existe un proceso de envasado para la fecha y turno escogidos");
				return;
			}
		
			if (defecto == null) {
			   Sistema.mensaje("Seleccione un defecto");
			   return;
		    }
		
		   /* if (fechai==null) {
			   Sistema.mensaje("No se ha tomado una fecha - hora de defecto ");
			   return;
		    } */
		    
			if (Util.validarListboxFecha(lbxMi,lbxDi,lbxHi,lbxMin)) {
				 Sistema.mensaje("Seleccione bien la fecha..");
				 return;
			}
		    
			if (intLatas == null ){
				Sistema.mensaje("Debe ingresar una cantidad");
				return;
			}
			
			if ( intLatas.getValue() == null){
				Sistema.mensaje("Debe ingresar una cantidad.");
				return;
			}
			
			if ( intLatas.getValue() <= 0){
				Sistema.mensaje("Debe ingresar una cantidad.");
				return;
			}
		
			if (oeeDetalleMediosConDefectoEnvasado != null) {
				  /* actualizar registro */
		    	   System.out.println("ACTUALIZAR  .......................................");
		    	    oeeDetalleMediosConDefecto =  oeeDetalleMediosConDefectoEnvasado.getOeeDetalleMediosConDefecto();
					oeeDetalleMediosConDefecto.setCantidadDefectos(intLatas.getValue());
					//oeeDetalleMediosConDefecto.setEmpleado(null);
					oeeDetalleMediosConDefecto.setFechaHoraRegistro(fechai.toTimestamp());
					//oeeDetalleMediosConDefecto.setFechaRegistro(new java.sql.Timestamp( new Date().getTime()));
					oeeDetalleMediosConDefecto.setOeeDefecto(defecto);
					oeeDetalleMediosConDefecto.setProcesoAperturaCierre(envasadoProceso.getProcesoAperturaCierre());
					if (lote != null) {
						oeeDetalleMediosConDefecto.setProduccionDetalleLote(lote);
					}
					oeeDetalleMediosConDefecto.setUsuario(usuario);
					oeeDetalleMediosConDefecto = new OeeDetalleMediosConDefectoDAOJpaImpl() 
					       .saveOrUpdate(oeeDetalleMediosConDefecto);
		    	   
			}else{
				/* nuevo registro */  
			    System.out.println("NUEVO REGISTRO  ......................................");
			    if (lote == null) {
				   Sistema.mensaje("Seleccione un lote");
				   return;
			    }
			    
			    oeeDetalleMediosConDefecto =  new OeeDetalleMediosConDefecto();
				oeeDetalleMediosConDefecto.setCantidadDefectos(intLatas.getValue());
				//oeeDetalleMediosConDefecto.setEmpleado(null);
				oeeDetalleMediosConDefecto.setFechaHoraRegistro(fechai.toTimestamp());
				oeeDetalleMediosConDefecto.setFechaRegistro(new java.sql.Timestamp( new Date().getTime()));
				oeeDetalleMediosConDefecto.setOeeDefecto(defecto);
				oeeDetalleMediosConDefecto.setProcesoAperturaCierre(envasadoProceso.getProcesoAperturaCierre());
				oeeDetalleMediosConDefecto.setProduccionDetalleLote(lote);
				oeeDetalleMediosConDefecto.setUsuario(usuario);
				oeeDetalleMediosConDefecto = new OeeDetalleMediosConDefectoDAOJpaImpl() 
				       .saveOrUpdate(oeeDetalleMediosConDefecto);
                /* grabar en tabla defecto_envasado */
				oeeDetalleMediosConDefectoEnvasado = new OeeDetalleMediosConDefectoEnvasado();
				oeeDetalleMediosConDefectoEnvasado.setLuthy(luthy);
				oeeDetalleMediosConDefectoEnvasado.setMaquinaCerradora(maquinaCerradoraEstandar.getMaquinaCerradora());
				oeeDetalleMediosConDefectoEnvasado
						.setOeeDetalleMediosConDefecto(oeeDetalleMediosConDefecto);
				new OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl()
						.saveOrUpdate(oeeDetalleMediosConDefectoEnvasado);
				encerarListbox();
				limpiarDatos();
				if (lbxLote.getSelectedIndex() > 0) {
					lbxLote.setSelectedIndex(0);
					lote = null;
				}
			}
			
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		 
	}

	public void onBlur$intLatas() throws InterruptedException {
		intLatas.clearErrorMessage();
	}

	public void onClick$btnTomarTiempoi() throws InterruptedException {
		if (intLatas == null ){
			Sistema.mensaje("Debe ingresar una cantidad");
			return;
		}
		
		if ( intLatas.getValue() == null){
			Sistema.mensaje("Debe ingresar una cantidad.");
			return;
		}
		
		if ( intLatas.getValue() <= 0){
			Sistema.mensaje("Debe ingresar una cantidad.");
			return;
		}
		
		if (produccion == null) {
			Sistema.mensaje("No existe un proceso de envasado para la fecha y turno escogidos");
			return;
		}
	 
	    fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(), new Date(),lbxMi, lbxDi, lbxHi, lbxMin);	
		 
	}

	public void onClick$btnActualizarLotes() throws InterruptedException {
		
		if (produccion == null) {
			Sistema.mensaje("No existe un proceso de envasado para la fecha y turno escogidos");
			return;
		}
	 
	    fechai = Util.getAnioProduccionMesDiaActual(produccion.getFechaproduccion(), new Date(),lbxMi, lbxDi, lbxHi, lbxMin);	
		cargarLote();
		//lbxlistaDefecto.setDisabled(true);
		txtEspecieTalla.setValue("");
		intLatas.setValue(0);
		
		/*if (produccion != null)
			Util.limpiarMesDiaHoraMin(produccion.getFechaproduccion(), lbxMi,
					lbxDi, lbxHi, lbxMin); */
	}

	private void cargarLote() {
		if (turno != null && produccion != null)
			Util.cargarLista(
					ProduccionDetalleLote.class,
					new ProduccionDetalleLoteDAOJpaImpl()
					    .getProduccionDetallelote(  produccion.getIdproduccion() , turno.getIdturno()),
					lbxLote, "Error al cargar data de Lote", true,
					"ProduccionDetalleLote"); //getLotes
	}

	void limpiarDatos() {
		//fechai = Util.limpiarMesDiaHoraMin(lbxMi, lbxDi, lbxHi, lbxMin);
		txtEspecieTalla.setValue("");
		intLatas.setValue(0);
	}
	
	public void encerarListbox() {
		
		if (lbxLuthy.getSelectedIndex() >0 ) {
			lbxLuthy.setSelectedIndex(0);
			luthy = null;
		}
		lbxMaquinaCerradora.getItems().clear();
		maquinaCerradoraEstandar = null;
		/* limpiar listbox hora-defecto*/
		lbxDefecto.getItems().clear();
		oeeDetalleMediosConDefectoEnvasado = null;
		oeeDetalleMediosConDefecto         = null;
		
		if (lbxlistaDefecto.getSelectedIndex() >0 ) {
			lbxlistaDefecto.setSelectedIndex(0);
			defecto = null;
		}
		
	}
	

	private void cargarListas() {
		Util.cargarLista(Turno.class, new TurnoDAOJpaImpl().getTurnos(),
				lbxTurno, "Error al cargar data de Turnos", true, "TurnoBlanco");
		Util.cargarLista(Luthy.class, new LuthyDAOJpaImpl().getAll(), lbxLuthy,
				"Error al cargar data de Luthy", true, "Luthy");
	 
		
		Util.cargarLista(OeeDefecto.class,
				new OeeDefectoDAOJpaImpl().findByIdproceso(13), lbxlistaDefecto,
				"Error al cargar data de Defectos", true, "OeeDefectos");  

	}

	/* private boolean validarCampos() {
		if (intLatas != null && intLatas.getValue() <= 0) {
			Sistema.mensaje("El campo #Latas debe ser mayor a cero");
			return false;
		}
		return true;
	} */

	private void cargarHoraDefecto() {
		if (envasadoProceso != null && maquinaCerradoraEstandar != null) {
			Long    idPac     = envasadoProceso.getProcesoAperturaCierre().getIdprocesoaperturacierre();
			Integer idMaquina = maquinaCerradoraEstandar.getMaquinaCerradora().getIdmaquinacerradora();
			List<OeeDetalleMediosConDefectoEnvasado> lista  
					= new OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl().findByIdPacAndIdMaquina(idPac, idMaquina);
			cargarListboxHoraDefectos(lista);
			/* Util.cargarLista(OeeDetalleMediosConDefectoEnvasado.class,
					new OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl()
							.findByIdPacAndIdMaquina(idPac, idMaquina),
						 lbxDefecto, "Error al cargar data de Defectos", false,
					"OeeDetalleMediosConDefectoEnvasado"); */
		}
	}
	
	
	public void cargarListboxHoraDefectos(List<OeeDetalleMediosConDefectoEnvasado> lista ){
		
		lbxDefecto.getItems().clear();
		Listitem listitem = new Listitem();
		listitem.setValue(new OeeDetalleMediosConDefectoLimpieza());
		new Listcell("Nuevo Registro").setParent(listitem);
		listitem.setParent(lbxDefecto);
		
		for (OeeDetalleMediosConDefectoEnvasado e : lista) {
			listitem = new Listitem();
			listitem.setValue(e);
			String display  = " ";
			
			OeeDetalleMediosConDefectoEnvasado edmde = (OeeDetalleMediosConDefectoEnvasado) e;
			if (edmde.getOeeDetalleMediosConDefecto() == null){
				display = "";
			}else {
				display = String.format("%s - %s",
						edmde.getOeeDetalleMediosConDefecto()
								.getFechaHoraRegistro(), edmde
								.getOeeDetalleMediosConDefecto()
								.getOeeDefecto().getDescripcionDefecto());
			}
			
			new Listcell(display) .setParent(listitem);
			listitem.setParent(lbxDefecto);
		}
		
		lbxDefecto.setSelectedIndex(0);
	}
	
	
	public void buscarLoteActual(){
		/* buscar el lote q tiene actualmente  */
		if (oeeDetalleMediosConDefectoEnvasado != null) {
			if (oeeDetalleMediosConDefectoEnvasado.getOeeDetalleMediosConDefecto() != null) {
				 System.out.println("Idproducciondetallelote escogido ->" + oeeDetalleMediosConDefectoEnvasado
						 	 	.getOeeDetalleMediosConDefecto().getProduccionDetalleLote().getIdproducciondetallelote() );
                /* búsqueda dentro del listbox*/
                  for (Object item : lbxLote.getItems()) {
                       Listitem         listitem                  = (Listitem) item;
                       ProduccionDetalleLote proDetLote 	  = (ProduccionDetalleLote) listitem.getValue();
                       if(proDetLote != null){
                    		   //System.out.println("Idproducciondetallelote listbox ->" + LimpDetProLote.getProduccionDetalleLote().getIdproducciondetallelote() );
                    	        System.out.println("Idproducciondetallelote listbox ->" + proDetLote.getIdproducciondetallelote() );
                    	        if (oeeDetalleMediosConDefectoEnvasado
                            		     .getOeeDetalleMediosConDefecto()
                            		         .getProduccionDetalleLote()
                            		         	.getIdproducciondetallelote()
                            		         		.equals(proDetLote.getIdproducciondetallelote())) {
                            	    System.out.println("Idproducciondetallelote encontrado ->" + proDetLote.getIdproducciondetallelote() );
                            	    lbxLote.setSelectedItem(listitem);
                            	    lote = proDetLote;
                            	   
                            	    EspecieTalla especieTalla = proDetLote.getEspecieTalla();
	                       			Especie especie           = especieTalla.getEspecie();
	                       			Talla talla     		  =  especieTalla.getTalla();
	                       			
	                       			txtEspecieTalla.setValue(String.format("%s %s",
	                       					especie.getNombre(), talla.getNombre()));
                               }
                         
                       } 
                  }
			}
		}
	}
	
	
	public void buscarDefectoActual(){
		/* buscar el lote q tiene actualmente  */
		if (oeeDetalleMediosConDefectoEnvasado != null) {
			if (oeeDetalleMediosConDefectoEnvasado.getOeeDetalleMediosConDefecto() != null) {
				// System.out.println("Id ooeedefectoenvasado ->" + oeeDetalleMediosConDefectoEnvasado
					//	 	 	.getOeeDetalleMediosConDefecto().getOeeDefecto().getIdOeeDefectos());
                /* búsqueda dentro del listbox*/
                  for (Object item : lbxlistaDefecto.getItems()) {
                       Listitem         listitem                      = (Listitem) item;
                       OeeDefecto 		oeeDefectoItem 	     		  = (OeeDefecto) listitem.getValue();
                       if(oeeDefectoItem != null){
                               if (oeeDetalleMediosConDefectoEnvasado
                            		     .getOeeDetalleMediosConDefecto()
                            		         .getOeeDefecto().getIdOeeDefectos()
                            		         		.equals(oeeDefectoItem.getIdOeeDefectos())) {
                            	   // System.out.println("getIdOeeDefectos encontrado ->" + oeeDefectoItem.getIdOeeDefectos() );
                            	    lbxlistaDefecto.setSelectedItem(listitem);
                            	    defecto = oeeDefectoItem;
                               }
                         
                       } 
                  }
			}
		}
	}
	
	

	public void onClick$btnEliminar() throws InterruptedException {
		if (validarCamposDelete()) {
			
			if (oeeDetalleMediosConDefectoEnvasado==null) {
				Sistema.mensaje("No existe un defecto seleccionado para eliminar");
				return;
			}
			
			try {
				    new OeeDetalleMediosConDefectoEnvasadoDaoJpaImpl()
				        .delete(oeeDetalleMediosConDefectoEnvasado);
					new OeeDetalleMediosConDefectoDAOJpaImpl()
						.delete(oeeDetalleMediosConDefecto);
					
					Sistema.mensaje("Transaccin completada");
				
			} catch (Exception e) {
			   e.printStackTrace();
			   Sistema.mensaje("Registro en uso");
			}
			
			 
				
		}
	}

	private boolean validarCamposDelete() {
		//validarCampos();
		if (!ChkEliminar.isChecked()) {
			Sistema.mensaje("Seleccione revisado");
			ChkEliminar.setFocus(true);
			return false;
		}

		return true;
	}
}
