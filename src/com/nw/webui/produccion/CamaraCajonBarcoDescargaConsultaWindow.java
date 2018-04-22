package com.nw.webui.produccion;

import org.zkoss.zul.Checkbox;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.api.Label;

import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.BarcoEstibaCubaDetalleMezcla;
import com.nw.model.Cajon;
import com.nw.model.Camara;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.EspecieTalla;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.TipoCaptura;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDescargaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoEstibaCubaDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonEstadoJpaImpl;
import com.nw.model.dao.impl.CamaraCajonUbicacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraDAOJpaImpl;
import com.nw.model.dao.impl.CamaraFilaColumnaDAOJpaImpl;
import com.nw.model.dao.impl.DescongeladoDetalleProcesoTemperaturaDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteCajonDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;
import com.nw.util.Sistema;


public class CamaraCajonBarcoDescargaConsultaWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	
	//Objetos zul
	Listbox lbxCajones,lbxTipoCaptura;   // lbxTurno
	// lbxCuba,
	//lbxBarcoDescarga
	Toolbarbutton btnGrabar,btnBuscarBarco,btnBuscarEspecieTalla,btnConfirmar;
	//Datebox dteFecInicio,dteFecFin;
	Label lbInfoCajon,lbInfoEspecieTallaAnterior,lbInfoEspecieTallaActual;
	Textbox txtCajon,txtPesoNeto,txtTara,txtTicket,txtLoteCajonSap,txtEspecieTalla,txtZonaFao, txtEstado, txtRegistro, txtCuba, txtCubaInfo, txtLoteCamara,
	txtHaccp;
	
	Checkbox ChkConfirmar, btnConfirmare;
	
	//Textbox txtPesoNetod;
	//Doublebox dbbxPesoBrutod;
	//private Checkbox ChkNuevoCajon;
	
    Doublebox dbbxPesoBruto;	
    Listbox lbxCamaras,lbxFilas,lbxColumnas, lbxCajonesDisponibles;
	
    
	//Objetos
	CamaraCajon camaraCajon = null;
	BarcoDescarga barcoDescarga = null;
	BarcoEstibaCuba barcoEstibaCuba = null;
	EspecieTalla especieTalla = null;
	Turno turno = null;
	Cajon cajonconsultado = new Cajon();
	TipoCaptura tipoCaptura = null;
	Camara camara;
	FilaCamara fila;
	ColumnaCamara columna;
	
	
	//Listados
	List<CamaraCajon> camaraCajones = null;
	List<BarcoDescarga> barcosDescargas = null;
	List<BarcoEstibaCuba> barcosEstibaCubas = null;
	List<Turno> turnos = null;
	List<TipoCaptura> tipoCapturas = null;
	List<Camara> camaras = new CamaraDAOJpaImpl().getCamara();	
	CamaraFilaColumnaDAOJpaImpl camaraFilaColumnaDAOJpaImpl = new CamaraFilaColumnaDAOJpaImpl();
	CamaraCajonDAOJpaImpl camaraCajonDAOJpaImpl = new CamaraCajonDAOJpaImpl();
	CamaraCajonUbicacionDAOJpaImpl camaraCajonUbicacionDAOJpaImpl = new CamaraCajonUbicacionDAOJpaImpl();
	
	CamaraFilaColumna camaraFilaColumna; 
	//lista de columnas en q se llenara seguna la camara seleecionada
	List<ColumnaCamara> columnasCamara = new ArrayList<ColumnaCamara>();
	List<FilaCamara> filasCamara = new ArrayList<FilaCamara>();
	//variables 
	Double peso = 0.00;
	Double pesod = 0.00;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
//		dteFecInicio.setFormat("dd/MM/yyyy");
//		dteFecFin.setFormat("dd/MM/yyyy");
//		
//		dteFecInicio.setValue(new Date());
//		dteFecFin.setValue(new Date());
		
		tomarfechas();
        
		cargarTurnos();
		cargarTiposCapturas();
		cargarListaCamaras();
		txtCajon.setFocus(true);
	}
	
	public void tomarfechas()
	{
//		Calendar c1 = GregorianCalendar.getInstance();
//		c1.add(Calendar.DATE, -365);
//		Date fecha = c1.getTime();
//		System.out.println(fecha);
//
//		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println("Fecha actual1: " + formatoDeFecha.format(fecha));
//		String f1 = String.valueOf(formatoDeFecha.format(fecha));
//		System.out.println("Fecha actual1: " + f1);
//
//		
//		Calendar c2 = GregorianCalendar.getInstance();
//		c2.add(Calendar.DATE, 0);
//		Date fecha2 = c2.getTime();
//		System.out.println(fecha2);
//
//		SimpleDateFormat formatoDeFecha2 = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println("Fecha actual2: " + formatoDeFecha2.format(fecha2));
//		String f2 = String.valueOf(formatoDeFecha2.format(fecha2));
//		System.out.println("Fecha actual2: " + f2);
//		
//		dteFecInicio.setFormat("dd/MM/yyyy");
//		dteFecInicio.setText(f1);
//		
//		dteFecFin.setFormat("dd/MM/yyyy");
//        dteFecFin.setText(f2);
	}

	
	/********************************  Metodos vista ***********************************************/
	
//	public void onClick$btnBuscarBarco(){
//		//llamar al metodo que llena la lista de los barcos en barco_descarga
//	
////		String f1;
////		f1 = dteFecInicio.getAreaText().trim() + " 00:00:00.000";
////		String f2;
////		f2 = dteFecFin.getAreaText().trim() + " 23:59:59.999";
//
//
////TEMP.		
//		limpiarControlesSinCajon();
//
//		
//		txtCajon.setValue(null);
//		lbxCajonesDisponibles.getItems().clear();
//		camaraCajon = null;
//		
//		barcosDescargas = new ArrayList<BarcoDescarga>();
//		barcosDescargas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getBarcoDescargaPorFechaDescarga(dteFecInicio.getValue(),  getAumentarUnDiaAFecha(dteFecFin.getValue()));
//		 //lleno el listbox de barco descarga
//		cargarBarcosDescargaPorFecha(barcosDescargas);
//		
//	}
	
//	public void onSelect$lbxBarcoDescarga()
//	{
//		limpiarControlesSinCajon();
//		txtCajon.setValue(null);
//		lbxCajonesDisponibles.getItems().clear();
//		camaraCajon = null;
//		
//		 seleccionarBarcoDescarga();
//	}
	
//	public void onSelect$lbxCuba(){
//		 seleccionarBarcoEstibaCuba();
//	}
	
//	public void onSelect$lbxTurno(){
//		 seleccionarTurno();
//	}
	
	public void onSelect$lbxTipoCaptura(){
		 seleccionarTipoCaptura();
	}
	
	public void onClick$btnBuscarCajon(){
		buscarRegistroCamaraCajon();
	}
	
	public void onClick$btnBuscarEspecieTalla(){
		buscarRegistroEspecieTalla();
	}


	public void onClick$btnConfirmadp() throws ParseException
	{
		if (ChkConfirmar.isChecked())
		{
			if (lbxCajonesDisponibles.getItems().size() > 0)
			{	if (lbxCajonesDisponibles.getSelectedIndex() > 0)
				{
					ProduccionDetalleLoteCajon pdlc = new ProduccionDetalleLoteCajon();
					//Verifica sies un caj�n con estado de Devoluci�n al proveedor
					if(camaraCajon.getEstado() == 7)
					{
						//Consulta si el caj�n fue usado en una producci�m	
						pdlc = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(camaraCajon.getIdcamaracajon());
						
						//Valida si no fue usado en una producci�n para poder hacer la habiltaci�n
						if (pdlc == null)
						{
							camaraCajon.setEstado(0);
							new CamaraCajonDAOJpaImpl().saveOrUpdate(camaraCajon);
							Sistema.mensaje("La transacci�n ha sido grabada!");
							onSelect$lbxCajonesDisponibles();
							txtEstado.setFocus(true);
							return;
						}
						else
							//Caj�n fue usado en una producci�n	
							{
								String mensaje;
								mensaje = "CAJON NO PUEDE SER HABILITADO : ";
								Timestamp f = pdlc.getProduccionDetalleLote().getProduccion().getFechaproduccion();
								Date fecha = f;
								SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
								String prod = String.valueOf(formatoDeFecha.format(fecha));
	
								String lote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(pdlc.getCamaraCajon().getIdcamaracajon()).getProduccionDetalleLote().getIdlote().toString();
								mensaje = mensaje +" Usado en la producci�n del :"+prod;
								mensaje = mensaje+ " En el lote : "+lote;
								mensaje = mensaje+ " Turno : "+pdlc.getProduccionDetalleLote().getTurno().getIdturno().toString();
							
								Sistema.mensaje(mensaje);
								return;
							}
					}
					else
					{
						Sistema.mensaje("ERROR.- Esta opci�n solo es disponible para cajones con estado de Devolucion al proveedor para poder habilitar");
					}
				}
			}
			else
			{
				Sistema.mensaje("Debe buscar el caj�n devuelto al proveedor y luego confirmar la habilitaci�n");
				return;
			}
		}
		else
		{
			Sistema.mensaje("Debe confirmar la habilitaci�n del caj�n por Devoluci�n al proveedor");
		}
		//cajonconsultado.
	}	
	
	
	
	public void onClick$btnConfirmar() throws ParseException
	{
		if (ChkConfirmar.isChecked())
		{
			if (lbxCajonesDisponibles.getItems().size() > 0)
			{	if (lbxCajonesDisponibles.getSelectedIndex() > 0)
				{
					ProduccionDetalleLoteCajon pdlc = new ProduccionDetalleLoteCajon();
					//Verifica sies un caj�n con estado en venta
					if(camaraCajon.getEstado() == 6)
					{
						//Consulta si el caj�n fue usado en una producci�m	
						pdlc = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(camaraCajon.getIdcamaracajon());
						
						//Valida si no fue usado en una producci�n para poder hacer la habiltaci�n
						if (pdlc == null)
						{
							camaraCajon.setEstado(0);
							new CamaraCajonDAOJpaImpl().saveOrUpdate(camaraCajon);
							Sistema.mensaje("La transacci�n ha sido grabada!");
							onSelect$lbxCajonesDisponibles();
							txtEstado.setFocus(true);
							return;
						}
						else
							//Caj�n fue usado en una producci�n	
							{
								String mensaje;
								mensaje = "CAJON NO PUEDE SER HABILITADO : ";
								Timestamp f = pdlc.getProduccionDetalleLote().getProduccion().getFechaproduccion();
								Date fecha = f;
								SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
								String prod = String.valueOf(formatoDeFecha.format(fecha));
	
								String lote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(pdlc.getCamaraCajon().getIdcamaracajon()).getProduccionDetalleLote().getIdlote().toString();
								mensaje = mensaje +" Usado en la producci�n del :"+prod;
								mensaje = mensaje+ " En el lote : "+lote;
								mensaje = mensaje+ " Turno : "+pdlc.getProduccionDetalleLote().getTurno().getIdturno().toString();
							
								Sistema.mensaje(mensaje);
								return;
							}
					}
					else
					{
						Sistema.mensaje("ERROR.- Esta opci�n solo es disponible para cajones con estado en venta que se desean habilitar");
					}
				}
			}
			else
			{
				Sistema.mensaje("Debe buscar el caj�n vendido y luego confirmar la habilitaci�n");
				return;
			}
		}
		else
		{
			Sistema.mensaje("Debe confirmar la habilitaci�n del caj�n Vendido");
		}
		//cajonconsultado.
	}	
	
	
	
	
	
	public void onClick$btnConfirmare() throws ParseException
	{
		if (ChkConfirmar.isChecked())
		{
			if (lbxCajonesDisponibles.getItems().size() > 0)
			{	if (lbxCajonesDisponibles.getSelectedIndex() > 0)
				{
					ProduccionDetalleLoteCajon pdlc = new ProduccionDetalleLoteCajon();
					//Verifica si es un caj�n con estado eliminado
					if(camaraCajon.getEstado() == -1)
					{
						//Consulta si el caj�n fue usado en una producci�m	
						pdlc = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(camaraCajon.getIdcamaracajon());
						
						//Valida si no fue usado en una producci�n para poder hacer la habiltaci�n
						if (pdlc == null)
						{
							camaraCajon.setEstado(0);
							new CamaraCajonDAOJpaImpl().saveOrUpdate(camaraCajon);
							Sistema.mensaje("La transacci�n ha sido grabada!");
							onSelect$lbxCajonesDisponibles();
							txtEstado.setFocus(true);
							return;
						}
						else
							//Caj�n fue usado en una producci�n	
							{
								String mensaje;
								mensaje = "CAJON NO PUEDE SER HABILITADO : ";
								Timestamp f = pdlc.getProduccionDetalleLote().getProduccion().getFechaproduccion();
								Date fecha = f;
								SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
								String prod = String.valueOf(formatoDeFecha.format(fecha));
	
								String lote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(pdlc.getCamaraCajon().getIdcamaracajon()).getProduccionDetalleLote().getIdlote().toString();
								mensaje = mensaje +" Usado en la producci�n del :"+prod;
								mensaje = mensaje+ " En el lote : "+lote;
								mensaje = mensaje+ " Turno : "+pdlc.getProduccionDetalleLote().getTurno().getIdturno().toString();
							
								Sistema.mensaje(mensaje);
								return;
							}
					}
					else
					{
						Sistema.mensaje("ERROR.- Esta opci�n solo es disponible para cajones con estado eliminado que se desean habilitar");
					}
				}
			}
			else
			{
				Sistema.mensaje("Debe buscar el caj�n vendido y luego confirmar la habilitaci�n");
				return;
			}
		}
		else
		{
			Sistema.mensaje("Debe confirmar la habilitaci�n del caj�n Eliminado");
		}
		//cajonconsultado.
	}	
	
	
	
	
	
	public void onClick$btnGrabar(){
		guardarEditar();
	}
	
	public void onChanging$dbbxPesoBruto(InputEvent event){
		 System.out.println("valor peso bruto es -->"+event.getValue());
		 String valor = "";
		 valor = event.getValue();
		 peso = 0.00;
		 peso = Sistema.parseDouble(valor);
		 recalcularPesoNeto(peso);
		
	}

//	public void onChanging$dbbxPesoBrutod(InputEvent event){
//		 System.out.println("valor peso bruto es -->"+event.getValue());
//		 String valor = "";
//		 valor = event.getValue();
//		 pesod = 0.00;
//		 pesod = Sistema.parseDouble(valor);
//		 recalcularPesoNetod(pesod);
//		
//	}	

	public void onSelect$lbxCajonesDisponibles() throws ParseException{
		limpiarControlesSinCajon();
		if (lbxCajonesDisponibles.getSelectedIndex() > 0)
		{
			CargarDatosCajon();
		}	
	}
	
	
	public void CargarDatosCajon() throws ParseException
	{
		 camaraCajon = new CamaraCajon();
		 camaraCajon = (CamaraCajon) lbxCajonesDisponibles.getSelectedItem().getValue();
		 
		 
			//////////////////////////////
//		 barcoDescarga = new BarcoDescarga();
//		 barcoDescarga = camaraCajon.getBarcoDescarga();
//		 
//		//aki debo cargar las cubas del barco aperturado con esto lleno la lista
//		// pasos -> barco_estiba_cuba -> barco_cuba -> cuba
//		barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
//		//aki debo cargar las cubas del barco aperturado con esto lleno la lista
//		// pasos -> barco_estiba_cuba -> barco_cuba -> cuba
//		barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
//		barcosEstibaCubas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getBarcoEstibaCubaBarcoDescarga(barcoDescarga);
		//////////////////////////////
		//cargarListadoCubasBarcos(barcosEstibaCubas);
		
		 
		 
		 	/////////////////////
		 	// MEZCLA DE CUBAS //
		 	/////////////////////
		 
				String cubas ="";
				int i = 0; 
				/* Inicio Requerimiento Mezcla Cubas*/
				if (camaraCajon.getBarcoEstibaCuba() == null)
				{
					List <BarcoEstibaCubaDetalleMezcla> lis = new BarcoEstibaCubaDAOJpaImpl().getListBarcoEstibaCubasDetalleMezcaxIdCamaraCajon(camaraCajon.getIdcamaracajon());
					if (lis.size()>0)
					{
						for (BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla : lis) 
						{
							i++;
							if(i > 1)
							{
								cubas = cubas + " - ";
							}
							cubas = cubas + new BarcoCubaDAOJpaImpl().getFindBarcobyId(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba().getIdbarcocuba()).getCuba().getNombrecuba();
							txtCubaInfo.setValue(cubas); 
									
							//new BarcoCubaDAOJpaImpl().getFindBarcobyId(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba().getIdbarcocuba()).getCuba().getNombrecuba());
						}
					}
					else
					{
						txtCubaInfo.setValue(null);
					}
				}
				else
				{
					BarcoCuba bc = new BarcoCuba();
					bc = new BarcoCubaDAOJpaImpl().getFindBarcoCubaIdLong(camaraCajon.getBarcoEstibaCuba().getIdbarcocuba());
					txtCubaInfo.setValue(bc.getCuba().getNombrecuba());
				}
				txtLoteCamara.setValue(camaraCajon.getLotecamara());
				txtHaccp.setValue(camaraCajon.getLotehaccp());
				
		 	/////////////////////////
		 	// FIN MEZCLA DE CUBAS //
		 	/////////////////////////

				
				
				
		
		
		 //camaraCajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCamaraCajonPorBarcoDescargaUnico(barcoDescarga, cajonconsultado.getIdcajon());
	
		//el cajon se encuentra registrado			
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);
		
		if (usuario==null || usuario.equals("")) 
		{
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
		}
		
		camaraCajon.setFechaactualizacion(new Timestamp(new Date().getTime()));
		
		System.out.println("idcamaracajon->"+camaraCajon.getIdcamaracajon());
		
		//posicionarCuba();
		posicionarTipoCaptura();
		
		//onSelect$lbxColumnas();

		//asginar los demas valores de camara_cajon
		txtEstado.setValue(new CamaraCajonEstadoJpaImpl().getFindCamaraCajonEstadoId(camaraCajon.getEstado()).getDescripcionestado().trim()+"\n");

		ProduccionDetalleLoteCajon pdlc = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(camaraCajon.getIdcamaracajon());
		
		
		
		if (camaraCajon.getEstado() == 4)
		{
			Timestamp f = pdlc.getProduccionDetalleLote().getProduccion().getFechaproduccion();

			Date fecha = f;
			System.out.println(fecha);
	
			SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
			String prod = String.valueOf(formatoDeFecha.format(fecha));
			
			String lote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(camaraCajon.getIdcamaracajon()).getProduccionDetalleLote() .getIdlote().toString();
			txtEstado.setValue(txtEstado.getValue()+"\n"+"Usado en la producci�n del :"+prod+"\n");
			txtEstado.setValue("\n"+txtEstado.getValue()+"\n"+"En el lote : "+lote+"\n");
			
			txtEstado.setValue("\n"+txtEstado.getValue()+"\n"+"Turno : "+pdlc.getProduccionDetalleLote().getTurno().getIdturno());
		}	



		
		
		
		
		if (camaraCajon.getEstado() == 3)
		{
			DescongeladoDetalleProceso ddp = new DescongeladoDetalleProcesoTemperaturaDAOJpaImpl().getDescongeladoDetalleProcesoByIdProDetLotCajon(pdlc.getIdproducciondetallelotecajon().toString());
			
			
			
			Timestamp f = ddp.getProduccionDetalleLoteCajon().getProduccionDetalleLote().getProduccion().getFechaproduccion();
			Date fecha = f;
			SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
			String prod = String.valueOf(formatoDeFecha.format(fecha));


			Timestamp f1 = ddp.getHoraingreso();
			Date fecha1 = f1;
			SimpleDateFormat formatoDeFecha1 = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
			String recep = String.valueOf(formatoDeFecha1.format(fecha1));
			
			txtEstado.setValue(txtEstado.getValue()+"\n"+"Receptado el :"+recep+"\n");
			
			String lote = new ProduccionDetalleLoteCajonDAOJpaImpl().getidLoteProduccionDetallelotebyIdcamaraCajon(ddp.getProduccionDetalleLoteCajon().getCamaraCajon().getIdcamaracajon()).getProduccionDetalleLote().getIdlote().toString();
			txtEstado.setValue(txtEstado.getValue()+"\n"+"Usado en la producci�n del :"+prod+"\n");
			txtEstado.setValue("\n"+txtEstado.getValue()+"\n"+"En el lote : "+lote+"\n");
			
			txtEstado.setValue("\n"+txtEstado.getValue()+"\n"+"Turno : "+ddp.getProduccionDetalleLoteCajon().getProduccionDetalleLote().getTurno().getIdturno().toString());
		}	
		
		
		
		txtPesoNeto.setValue(camaraCajon.getPesoneto()+"");		
		txtTara.setValue(camaraCajon.getTara()+"");
		txtTicket.setValue(camaraCajon.getTicket());
		lbInfoCajon.setValue(camaraCajon.getCajon().getIdcajon());
		dbbxPesoBruto.setValue(camaraCajon.getPesobruto());
		txtLoteCajonSap.setValue(camaraCajon.getLotecajonsap());
		txtEspecieTalla.setValue(camaraCajon.getEspecieTalla().getIdespecietalla()+"");
		txtZonaFao.setValue(camaraCajon.getZonafao());
		lbInfoEspecieTallaActual.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());		
		lbInfoEspecieTallaAnterior.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());
		
		camaraFilaColumna = new CamaraFilaColumna();
		camaraFilaColumna = camaraCajon.getCamaraFilaColumna();
		
		posicionarCamara();
		onSelect$lbxCamaras();
		
		posicionarColumna();
		onSelect$lbxColumnas();
		
		
		
		posicionarFila();
		onSelect$lbxFilas();		
	}
	
	
	
//	public void onChanging$txtCajon(InputEvent event){
//		 System.out.println("valor es -->"+event.getValue());
//		 buscarRegistroCamaraCajon();
//	}
	

	/********************************  Metodos Negocio ***********************************************/
	
	
//	public void cargarBarcosDescargaPorFecha(List<BarcoDescarga> barcosDescargas){
//		
//		//llenar el listbox 
//		// lbxBarcoDescarga
//		
//		lbxBarcoDescarga.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new CocinaAperturaCierreDetalle());
//		li.setParent(lbxBarcoDescarga);
//		
//		for (BarcoDescarga bd : barcosDescargas) {
//			li = new Listitem();
//			li.setValue(bd);
//			new Listcell("("+ bd.getRegistro()+") " + "  " + bd.getBarco().getNombre()+" ").setParent(li); 
//			li.setParent(lbxBarcoDescarga);		}
//		lbxBarcoDescarga.setSelectedIndex(0);
//	}
	
//	public void seleccionarBarcoDescarga(){
//		if (lbxBarcoDescarga.getSelectedIndex()>0) {
//			 
//			 barcoDescarga = new BarcoDescarga();
//			 barcoDescarga = (BarcoDescarga) lbxBarcoDescarga.getSelectedItem().getValue();
//			 
//				//aki debo cargar las cubas del barco aperturado con esto lleno la lista
//				// pasos -> barco_estiba_cuba -> barco_cuba -> cuba
//				barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
//				barcosEstibaCubas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
//				                            .getBarcoEstibaCubaBarcoDescarga(barcoDescarga);
//				
//				cargarListadoCubasBarcos(barcosEstibaCubas);
//			 
//			 // esto ya no cargar los datos de la tabla camara_cajon en base al idbarcodescarga
//			 // cargarInformacionCamaraCajon(barcoDescarga);
//		}else{
//			barcoDescarga = null;
//		}
//		
//	}
	
	
//	public void seleccionarTurno(){
//		if (lbxTurno.getSelectedIndex()>0) {
//			 turno = new Turno();
//			 turno = (Turno) lbxTurno.getSelectedItem().getValue();
//		}else{
//			turno = null;
//		}
//	}
	
	public void seleccionarTipoCaptura()
	{
		 
		if (lbxTipoCaptura.getSelectedIndex()>0) 
		{
			 tipoCaptura = new TipoCaptura();
			 tipoCaptura = (TipoCaptura) lbxTipoCaptura.getSelectedItem().getValue();
		}
		else
		{
			tipoCaptura = null;
		}
		
	}
	
public void buscarRegistroCamaraCajon(){
		String ca;
		ca =  txtCajon.getValue().trim();			 
		ChkConfirmar.setChecked(false);
		
		limpiarControlesSinCajon();
		lbxCajonesDisponibles.getItems().clear();

		//valido que exista informacion para la busqueda
		if ((txtCajon.getValue()==null || txtCajon.getValue().trim().isEmpty()) && (txtRegistro.getValue()==null || txtRegistro.getValue().trim().isEmpty())) 
		{
			Sistema.mensaje("Debe ingresar un numero de cajon o registro del barco");
			return;
		}
		
		
		
//		if (barcoDescarga==null) {
//			Sistema.mensaje("Debe seleccionar un Barco");
//			return;
//		}
		
		if (txtCajon.getText().trim().isEmpty() == false)
		{
			cajonconsultado = new Cajon();
			cajonconsultado = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
			if (cajonconsultado==null) {
				Sistema.mensaje("No exite caj�n que este regitrado en los ultimos 100 movimientos");
				return;
			}
		}
		
		int res = 0;
		res = BuscarListaCajones();
		
		//if (txtCajon.getText().trim().isEmpty() == false && txtRegistro.getText().trim().isEmpty() && txtCuba.getText().trim().isEmpty())
		 //if (camaraCajon==null)
		 //La Lista de Cajones esta vacia (No encontro ning�n caj�n)
		if (txtCajon.getText().trim().isEmpty() == false)
		{
			 if(res == 0)
			 {
				Sistema.mensaje("No se encontraron cajones con la par�metros  indicados");
	
				limpiarControlesSinCajon();			
				camaraCajon = new CamaraCajon();
				
				camaraCajon.setFechareg(new Timestamp(new Date().getTime()));
				txtTara.setValue(cajonconsultado.getTara()+"");
				
				txtCajon.setValue(ca);
			}
		}

	}


	public int BuscarListaCajones(){
		camaraCajones = new ArrayList<CamaraCajon>();
		//camaraCajones = new CajonDAOJpaImpl().getListadoCajones(txtCajon.getValue().trim());	 

		BarcoCuba bc1 = new BarcoCuba();
		bc1 =  null;
		
		String sc = "";
		
		BarcoDescarga db = new BarcoDescarga();
		
		if (txtCajon.getText().trim().isEmpty() && txtRegistro.getText().trim().isEmpty() == false  && txtCuba.getText().trim().isEmpty())
		{
			camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCamaraCajonRepetidosPor3Id("", txtRegistro.getText().trim(), "");			
		}	
		else
		{
			if (txtRegistro.getText().isEmpty() == false &&  txtCuba.getText().trim().isEmpty() == false)
			{
				db = new BarcoDescargaDAOJpaImpl().consultarporRegistro(txtRegistro.getText());
				
				if (db !=null)
				{
					bc1 = new BarcoCubaDAOJpaImpl().getBarcoCubaporIdBarco(db.getBarco().getIdbarco(), txtCuba.getText().toUpperCase().trim());
				}
				
				
				if(bc1 != null)
				{
					sc = String.valueOf(bc1.getIdbarcocuba()).trim();
				}
				else
				{
					sc = "0";
				}
				
				System.out.println("getIdbarcocuba() "+sc);
			}
			camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCamaraCajonRepetidosPor3Id(cajonconsultado.getIdcajon(), txtRegistro.getText().trim(), sc.toUpperCase().trim());
		}

		
		
		
		
				
		 
		if (camaraCajones.size() == 0) {
//			txtCajon.setValue(null);
//			txtCajon.setFocus(true);
			Sistema.mensaje("No existen cajones");
			return 0;
		}
		
		System.out.println("TAMA====>"+String.valueOf(camaraCajones.size()));
		
		if (txtRegistro.getText().trim().isEmpty() == false && txtCajon.getText().trim().isEmpty() && txtCuba.getText().trim().isEmpty())
		{
			if (camaraCajones.size()>1) 
			{
				String mensaje = "Encontrado"+" "+camaraCajones.size()+" "+"cajones";
				
				Sistema.mensaje(mensaje + "");
			}
		}
		else
		{
			if (camaraCajones.size()>1) 
			{
				String mensaje = "Caj�n :" +" "+camaraCajones.get(0).getCajon().getIdcajon()
						+" "+"encontrado"+" "+camaraCajones.size()+" "+"veces.";
				
				Sistema.mensaje(mensaje + "");
			}
		}
		
		lbxCajonesDisponibles.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new CamaraCajon());
		li.setParent(lbxCajonesDisponibles);
	 
		
		for (CamaraCajon camaraCajon : camaraCajones) {
			li = new Listitem();
			li.setValue(camaraCajon);
			
			String e;
			
			//String e = "Caj�n "+camaraCajon.getCajon().getIdcajon()+" "+String.valueOf("Lote SAP "+camaraCajon.getLotecajonsap().toString())+" "+String.valueOf("P. Bruto "+camaraCajon.getPesobruto())+" "+String.valueOf("P. Neto "+camaraCajon.getPesoneto()+"  Estado "+camaraCajon.getEstado().toString());
			
			try 
			{
				
				if (txtRegistro.getText().trim().isEmpty() == false && txtCajon.getText().trim().isEmpty() && txtCuba.getText().trim().isEmpty())
				{
					e = camaraCajon.getCajon().getIdcajon().toString().trim()+" - "+camaraCajon.getBarcoDescarga().getRegistro().trim()+" - "+new CamaraCajonEstadoJpaImpl().getFindCamaraCajonEstadoId(camaraCajon.getEstado()).getAbreviao().trim();					
				}
				else
				{
					e = camaraCajon.getBarcoDescarga().getRegistro().trim()+" - "+new CamaraCajonEstadoJpaImpl().getFindCamaraCajonEstadoId(camaraCajon.getEstado()).getAbreviao().trim();			
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				e = camaraCajon.getCajon().getIdcajon().toString().trim()+" - "+camaraCajon.getBarcoDescarga().getRegistro()+" - "+" Estado: Sin estado";
			}
			
			
			new Listcell(e).setParent(li);
			li.setParent(lbxCajonesDisponibles);
			
			
		}
		lbxCajonesDisponibles.setSelectedIndex(0);
		
		return 1;
		
	}

	
	
	
	public void guardarEditar(){
		
		 
		if (txtCajon.getValue()==null || txtCajon.getValue().equals("")) {
			Sistema.mensaje("No se ha ingresado un n�mero de caj�n..");
			return;
		}
		
		if (barcoDescarga==null) {
			Sistema.mensaje("No se ha escogido un registro de barco ");
			return;
		}
		 
		
//		if (lbxCuba.getSelectedIndex()==0) {
//			Sistema.mensaje("No se ha escogido una cuba ");
//			return;
//		}
		 
		
//		if (lbxTurno.getSelectedIndex()==0) {
//			Sistema.mensaje("No se ha escogido un turno.. ");
//			return;
//		}
		
//		if (barcoEstibaCuba==null) {
//			Sistema.mensaje("No se ha escogido una cuba ");
//			return;
//		}
//		
		
		if (dbbxPesoBruto.getValue()==null) {
			Sistema.mensaje("No se ha establecido un Peso Bruto..");
			return;
		}
		
		Cajon cajon = new Cajon();
		cajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
		if (cajon==null) {
			Sistema.mensaje("El caj�n ingresado no es un cajon valido");
			return;
		}
		
		
		Integer idespecietalla = 0;
		if (txtEspecieTalla.getValue()==null || txtEspecieTalla.getValue().equals("")) {
			Sistema.mensaje("Debe ingresar un valor de especie talla para buscar");
			return;
		}
		idespecietalla = Sistema.parseInt(txtEspecieTalla.getValue());
		
		EspecieTalla especieTalla = new EspecieTalla();
		especieTalla = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getEspecieTallaPorId(idespecietalla);
		if (especieTalla==null) {
			Sistema.mensaje("No se ha encontrado la Especie-Talla consultada ");
			return;
		}
		
		lbInfoEspecieTallaActual.setValue(especieTalla.getEspecie().getNombre()+
				" "+especieTalla.getTalla().getNombre());
		
		if (especieTalla!=null) {//si se busco una nueva especie la asigno a camara cajon 
			camaraCajon.setEspecieTalla(especieTalla);
		}
		if (turno!=null) {// si se escogio un turno del combo lo asigno a camara cajon
			camaraCajon.setTurno(turno);
		}
		if (tipoCaptura!=null) { // si se escogio un tipo captura del combo lo asigno a camara cajon
			camaraCajon.setTipoCaptura(tipoCaptura);
		}
		
		if (barcoEstibaCuba!=null) { // si se escogio una cuba del combo lo asigno a camara_cajon
			camaraCajon.setBarcoEstibaCuba(barcoEstibaCuba);
		}
		
		if (barcoDescarga!=null) {
			camaraCajon.setBarcoDescarga(barcoDescarga);
		}
    
		if (cajon!=null) {
			camaraCajon.setCajon(cajon);
		} 
		
		Camara camaraconbillete = new Camara();
		if (camara==null) {
			camaraconbillete.setIdcamara((long) 99);
			camaraCajon.setCamara(camaraconbillete);	
			camara=camaraconbillete;
		}
		
		// validar en el caso de guardar si el cajon q se digito es valido
		// es decir si el cajon no consta en la tabla camara_cajon se debe buscar 
		// en la tabla cajon 
				
		CamaraFilaColumna camaraFila = new CamaraFilaColumna();
		if (camaraFilaColumna== null) {
			camaraFila.setIdcamarafilacolumna((long) 4635);
			camaraCajon.setCamaraFilaColumna(camaraFila);
		}
		
		 String columna ="";
			if (this.columna != null) {
				  columna = this.columna.getColumna().trim();
			}
			
			int filanum =0;
			if (this.fila!= null) {
				filanum = this.fila.getFila();
			}
			
		//consultamos en base a fila y columna el id de camara_fila_columna
		camaraFilaColumna = camaraFilaColumnaDAOJpaImpl.getIdFilaColumna2(camara.getIdcamara(),filanum,columna);
		if (camara!=null) {
    		camaraCajon.setCamara(camara);
    		 System.out.println("encontro camara");
	    }
				
		if (camaraFilaColumna !=null) {
	    	 camaraCajon.setCamaraFilaColumna(camaraFilaColumna);
	    	  System.out.println("encontro camarafilacolumna");
	    		System.out.println("idFilaColumnaObtenido-->"+camaraFilaColumna.getIdcamarafilacolumna());
	    	   
	         }		 
		
		if(lbxCajonesDisponibles.getSelectedIndex() <= 0)
		{
			camaraCajon.setEstado(0);	
		}	
		
		
		camaraCajon.setPesobruto(dbbxPesoBruto.getValue());
		camaraCajon.setPesoneto(Sistema.parseDouble( txtPesoNeto.getValue().trim() ));
		camaraCajon.setTara(Sistema.parseDouble(txtTara.getValue() ));
		camaraCajon.setTicket(txtTicket.getValue());
		camaraCajon.setLotecajonsap(txtLoteCajonSap.getValue());
		camaraCajon.setZonafao(txtZonaFao.getValue().trim());
	
		
		
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);
		
		Usuario usu = new Usuario();
		String usuariograbar = (String) Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuariograbar);
		if (usuariograbar == null || usuariograbar.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			 return;
		}
		
		if (camaraCajon.getIdcamaracajon()==null) {
			camaraCajon.setUsuario(usu);
		}
		
//		
		
		int ban = 0;
		CamaraCajon camaraCajonNuevo = new CamaraCajon();
//		if(ChkNuevoCajon.isChecked())
//		{
//			if(txtPesoNetod.getText().isEmpty())
//			{
//				Sistema.mensaje("Debe ingresar el peso neto para el nuevo caj�n");
//				txtPesoNetod.setFocus(true);
//				return;
//			}
//			
//			camaraCajonNuevo.setCodigoalmacen(camaraCajon.getCodigoalmacen());
//			camaraCajonNuevo.setColumnapasillo(camaraCajon.getColumnapasillo());
//			camaraCajonNuevo.setEstado(camaraCajon.getEstado());
//			camaraCajonNuevo.setFechaactualizacion(camaraCajon.getFechaactualizacion());
//			camaraCajonNuevo.setFechaactualizacionmovimiento(camaraCajon.getFechaactualizacionmovimiento());
//			camaraCajonNuevo.setFechareg(camaraCajon.getFechareg());
//			camaraCajonNuevo.setFechaultimomovimiento(camaraCajon.getFechaultimomovimiento());
//			camaraCajonNuevo.setIdbarcoestibacuba2(camaraCajon.getIdbarcoestibacuba2());
//			camaraCajonNuevo.setIdmaterialanterior(camaraCajon.getIdmaterialanterior());
//			camaraCajonNuevo.setLadopasillo(camaraCajon.getLadopasillo());
//			camaraCajonNuevo.setLotecajonsap(camaraCajon.getLotecajonsap());
//			camaraCajonNuevo.setLotecajonsapantesdenacionalizar(camaraCajon.getLotecajonsapantesdenacionalizar());
//			camaraCajonNuevo.setObservacion(camaraCajon.getObservacion());			
//			camaraCajonNuevo.setPesolibreutilizacion(camaraCajon.getPesolibreutilizacion());
//						
//			camaraCajonNuevo.setPesobruto(dbbxPesoBrutod.getValue());
//			camaraCajonNuevo.setPesoneto(Sistema.parseDouble( txtPesoNetod.getValue().trim() ));
//						
//			camaraCajonNuevo.setProcesado(camaraCajon.getProcesado());
//			camaraCajonNuevo.setTara(camaraCajon.getTara());
//			camaraCajonNuevo.setTicket(camaraCajon.getTicket());
//			camaraCajonNuevo.setTipotratamiento(camaraCajon.getTipotratamiento());
//			camaraCajonNuevo.setUsuarioactualizacion(camaraCajon.getUsuarioactualizacion());
//			camaraCajonNuevo.setUsuarioactualizacionmovimiento(camaraCajon.getUsuarioactualizacionmovimiento());
//			camaraCajonNuevo.setUsuarioultimomovimiento(camaraCajon.getUsuarioultimomovimiento());
//			camaraCajonNuevo.setZonafao(camaraCajon.getZonafao());
//			camaraCajonNuevo.setBarcoDescarga(camaraCajon.getBarcoDescarga());
//			camaraCajonNuevo.setBarcoEstibaCuba(camaraCajon.getBarcoEstibaCuba());
//			camaraCajonNuevo.setCajon(camaraCajon.getCajon());
//			camaraCajonNuevo.setCamaraArea(camaraCajon.getCamaraArea());
//			camaraCajonNuevo.setCamaraCajonRegistroSap(camaraCajon.getCamaraCajonRegistroSap());
//
//			
//			camaraCajonNuevo.setCamara(camaraCajon.getCamara());
//			camaraCajonNuevo.setCamaraFilaColumna(camaraCajon.getCamaraFilaColumna());
//			
//			camaraCajonNuevo.setEspecieTalla(camaraCajon.getEspecieTalla());
//			camaraCajonNuevo.setTipoCaptura(camaraCajon.getTipoCaptura());
//			camaraCajonNuevo.setTurno(camaraCajon.getTurno());
//			camaraCajonNuevo.setUsuario(camaraCajon.getUsuario());
//			
//			ban = 1;
//		}	
		
		new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdate(camaraCajon);
		
		//Verifica si graba el nuevo caj�n
		if(ban == 1)
		{
			new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdate(camaraCajonNuevo);
		}	
		
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);	
		limpiarControles();
		cargarLimpiarControles();
		
	}
	
	
//	public void cargarListadoCubasBarcos(List<BarcoEstibaCuba> barcosEstibaCubas){
//		
//		lbxCuba.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new BarcoEstibaCuba());
//		li.setParent(lbxCuba);
//		
//		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
//				li = new Listitem();
//				li.setValue(bec);
//				 
//				System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//				//aki ir consultando 
//				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
//				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
//				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
//				
//			   li.setParent(lbxCuba);		
//			}
//		lbxCuba.setSelectedIndex(0);
//		
//	}
	
	
//	public void posicionarCuba(){
//		
//		int pos = 0;
//		
//		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
//			//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
//			if (bec.getIdbarcoestibacuba().equals(camaraCajon.getBarcoEstibaCuba().getIdbarcoestibacuba()) ) {
//				System.out.println("encontro el registro de barco estiba cuba");
//				lbxCuba.setSelectedIndex(pos+1);
//			}
//		    pos++;
//		}
//	}
	
	
//	public void seleccionarBarcoEstibaCuba(){
//	 
//		if (lbxCuba.getSelectedIndex()>0) {
//			 
//			 barcoEstibaCuba = new BarcoEstibaCuba();
//			 barcoEstibaCuba = (BarcoEstibaCuba) lbxCuba.getSelectedItem().getValue();
//			 System.out.println("id barco estiba cuba->"+barcoEstibaCuba.getIdbarcocuba());
//			  
//		}else{
//			barcoEstibaCuba = null;
//		}
//		
//	}
	
	
	public void buscarRegistroEspecieTalla(){
		
		
		//buscar el valor q se ingresa en un metodo q me devuelva el objeto para 
		// poderlo asginar al objeto camara_cajon
		Integer idespecietalla = 0;
		if (txtEspecieTalla.getValue()==null || txtEspecieTalla.getValue().equals("")) {
			Sistema.mensaje("Debe ingresar un valor de especie talla para buscar");
			return;
		}
		idespecietalla = Sistema.parseInt(txtEspecieTalla.getValue());
		
		especieTalla = new EspecieTalla();
		especieTalla = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getEspecieTallaPorId(idespecietalla);
		if (especieTalla==null) {
			Sistema.mensaje("No se ha encontrado la Especie-Talla consultada ");
			return;
		}
		lbInfoEspecieTallaActual.setValue(especieTalla.getEspecie().getNombre()+
				" "+especieTalla.getTalla().getNombre());
		
	}
	
	
	public void limpiarControles(){
		
		txtCajon.setValue("");
		txtPesoNeto.setValue("");
		txtEspecieTalla.setValue("");
		txtLoteCajonSap.setValue("");
		txtTara.setValue("");
		txtTicket.setValue("");
		txtZonaFao.setValue("");
		dbbxPesoBruto.setValue(null);
		//listbox
//		lbxCuba.setSelectedIndex(0);
		//lbxTurno.setSelectedIndex(0);
		lbxTipoCaptura.setSelectedIndex(0);

//		lbxCuba.getItems().clear();
//		lbxTurno.getItems().clear();
//		lbxTipoCaptura.getItems().clear();
		//label
		lbInfoCajon.setValue("");
		lbInfoEspecieTallaActual.setValue("");
		lbInfoEspecieTallaAnterior.setValue("");
		
		camaraCajones = new ArrayList<CamaraCajon>();
		lbxCajonesDisponibles.getItems().clear();
		
//		txtPesoNetod.setValue("");
//		dbbxPesoBrutod.setValue(null);
//		ChkNuevoCajon.setChecked(false);		
		
		if (camara!=null) {
			lbxCamaras.setSelectedIndex(0);
		}
		
		if (columna!=null) {
			lbxColumnas.setSelectedIndex(0);
		}
		
		if (fila!=null) {
			lbxFilas.setSelectedIndex(0);
		}
	
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		
	}
	

public void limpiarControlesSinCajon(){
		ChkConfirmar.setChecked(false);
		txtPesoNeto.setValue("");
		txtEspecieTalla.setValue("");
		txtLoteCajonSap.setValue("");
//		txtRegistro.setValue("");
//		txtCuba.setValue("");
		
		txtTara.setValue("");
		txtTicket.setValue("");
		txtCubaInfo.setValue("");
		
		txtLoteCamara.setValue("");
		txtHaccp.setValue("");
		
		
		txtEstado.setValue(null);
		dbbxPesoBruto.setValue(null);
		
		
//		txtPesoNetod.setValue("");
//		dbbxPesoBrutod.setValue(null);
//		ChkNuevoCajon.setChecked(false);
		//listbox
		
//		if(lbxCuba.getItems().size() > 0)
//		{
//			lbxCuba.setSelectedIndex(0);	
//		}
		
		//lbxTurno.setSelectedIndex(0);

		if(lbxTipoCaptura.getItems().size() > 0)
		{
			lbxTipoCaptura.setSelectedIndex(0);	
		}

			
		
		
        txtZonaFao.setValue("");
		//label
		lbInfoCajon.setValue("");
		lbInfoEspecieTallaActual.setValue("");
		lbInfoEspecieTallaAnterior.setValue("");
		
		if (lbxColumnas.getSelectedIndex()>0) 
		{
			lbxColumnas.setSelectedIndex(0);
		}
		
		if (lbxCamaras.getSelectedIndex()>0) 
		{
			lbxCamaras.setSelectedIndex(0);
		}
		
		if (lbxFilas.getSelectedIndex()>0) 
		{
			lbxFilas.setSelectedIndex(0);
		}
		
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		tomarfechas();
		
	}


	//este metodo se pensaba utilizar en primer instancia
	public void cargarInformacionCamaraCajon(BarcoDescarga barcoDescarga){
		
		camaraCajones = new ArrayList<CamaraCajon>();
		camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
		 		.getCamaraCajonPorBarcoDescarga(barcoDescarga);
		 System.out.println("tamano de lista camara cajon->"+camaraCajones.size());
		
		 //cargar el listado de cajones
		 
	}
	
	public void cargarTurnos(){
		turnos = new ArrayList<Turno>();
		turnos = new TurnoDAOJpaImpl().getTurnos();
		turno = new Turno();
		turno = turnos.get(0); // asigno el primer turno
		
		//llenar el listbox de turnos
		
//		lbxTurno.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new Turno());
//		li.setParent(lbxTurno);
//		
//		for (Turno bec : turnos) {
//				li = new Listitem();
//				li.setValue(bec);
//				new Listcell(bec.getIdturno()+" "+bec.getNombre()).setParent(li); 
//				
//			   li.setParent(lbxTurno);		
//			}
//		lbxTurno.setSelectedIndex(0);
		
	}
	
	
	public void cargarTiposCapturas(){
		
		List<TipoCaptura> tipoCapturas = new ArrayList<TipoCaptura>();
		tipoCapturas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getTiposCapturas();
		this.tipoCapturas = new ArrayList<TipoCaptura>();
		
		for (TipoCaptura tc : tipoCapturas) {
			if ( !(tc.getIdtipocaptura().trim().equals("ZZ")) ) {
				this.tipoCapturas.add(tc);
			}
		}
		
		//llenar el listbox de lbxTipoCaptura
		
		lbxTipoCaptura.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new TipoCaptura());
		li.setParent(lbxTipoCaptura);
		
		for (TipoCaptura bec : this.tipoCapturas) {
				li = new Listitem();
				li.setValue(bec);
				new Listcell(bec.getIdtipocaptura()+" "+bec.getDescripcion()).setParent(li); 
				
			   li.setParent(lbxTipoCaptura);		
			}
	 
		
	}
	
	
	public void cargarListaCamaras(){
		lbxCamaras.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Camara());
		li.setParent(lbxCamaras);
		
		//List<Camara> camaras = new CamaraDAOJpaImpl().getCamara();
		for (Camara camara : camaras) {
			 li = new Listitem();
			 li.setValue(camara);
			 new Listcell("Camara->"+camara.getDescripcion()).setParent(li);
			 li.setParent(lbxCamaras);
		}
		lbxCamaras.setSelectedIndex(0);
		
	}

	
	public void onSelect$lbxCamaras(){
		
		lbxFilas.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new FilaCamara());
		li.setParent(lbxFilas);		
	    filasCamara = null;
	    
		if (lbxCamaras.getSelectedIndex()>0) {
			camara = new Camara();
			camara = (Camara) lbxCamaras.getSelectedItem().getValue();
			System.out.println("valor descripcion de la camara escogida es-->"+camara.getDescripcion());
			//debo de cargar las filas y columnas correspondientes a la camara
			//cargarListaFilasCamara();
			cargarListaColumnasCamara();
		}else{
			camara = null; //se vacia el objeto para q pueda validar de nuevo q debe escoger una camara
		}
	}
	
	public void cargarListaColumnasCamara(){
		lbxColumnas.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ColumnaCamara());
		li.setParent(lbxColumnas);

		columnasCamara = camaraFilaColumnaDAOJpaImpl.obtenerColumnas2(Integer.valueOf(String.valueOf(camara.getIdcamara()).trim()) );
//				
//				camaraFilaColumnaDAOJpaImpl.getCamaraColumnas
//				(Integer.valueOf( String.valueOf(camara.getIdcamara()) ));
		for (ColumnaCamara columna : columnasCamara) 
		{
			 li = new Listitem();
			 li.setValue(columna);
			 new Listcell("Columna->"+columna.getColumna().trim()).setParent(li);
			 li.setParent(lbxColumnas);
		}
		lbxColumnas.setSelectedIndex(0);
		
	}
	
	
	public void cargarListaFilasCamara(){
		lbxFilas.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new FilaCamara());
		li.setParent(lbxFilas);
		
	    filasCamara = 
		camaraFilaColumnaDAOJpaImpl.obtenerFilasConIdColumna(Integer.valueOf(String.valueOf(camara.getIdcamara()).trim()), columna.getColumna().trim()  );
				 
		for (FilaCamara fila : filasCamara) {
			 li = new Listitem();
			 li.setValue(fila);
			 new Listcell("Fila->"+fila.getFila()).setParent(li);
			 li.setParent(lbxFilas);
		}
		lbxFilas.setSelectedIndex(0);
		
	}
	
	public void onSelect$lbxColumnas(){
		if (lbxColumnas.getSelectedIndex()>0) {
			//columna = new CamaraFilaColumna();
			columna = new ColumnaCamara();
			columna = new ColumnaCamara();
			columna = (ColumnaCamara) lbxColumnas.getSelectedItem().getValue();
			System.out.println("valor descripcion de la columna escogida es-->"+columna.getColumna());
			cargarListaFilasCamara();//llenamos las filas correspondientes a la columna 
		}else{
			columna = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una columna
		}
	}
	
	
	public void onSelect$lbxFilas(){
		if (lbxFilas.getSelectedIndex()>0) {
			fila = new FilaCamara();
			fila = (FilaCamara) lbxFilas.getSelectedItem().getValue();
			System.out.println("valor descripcion de la fila escogida es-->"+fila.getFila());
		}else{
			fila = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una fila
		}
	}
	
	
	
	
	
	
//	public void posicionarTurno(){
//		int pos = 0;
//		for (Turno turno : turnos) {
//			if (turno.getIdturno()==camaraCajon.getTurno().getIdturno() ) {
//				System.out.println("encontro el registro de turno");
//				lbxTurno.setSelectedIndex(pos+1);
//			}
//		    pos++;
//		}
//	 }
	
	public void posicionarTipoCaptura(){
		
		int pos = 0;
		
		for (TipoCaptura tc : tipoCapturas) {
			if (tc.getIdtipocaptura().trim().equals(camaraCajon.getTipoCaptura().getIdtipocaptura().trim()) ) {
				System.out.println("encontro el registro de tipo Captura");
				lbxTipoCaptura.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	
	public void recalcularPesoNeto(Double pesoBruto){
		
		Double pesoNeto = 0.00;
		Double tara = 0.00;
		tara =  Sistema.parseDouble(txtTara.getValue());
		
		pesoNeto  = pesoBruto - tara;
		txtPesoNeto.setValue(pesoNeto+"");
		
	}
	

//	public void recalcularPesoNetod(Double pesoBrutod){
//		
//		Double pesoNetod = 0.00;
//		Double tara = 0.00;
//		tara =  Sistema.parseDouble(txtTara.getValue());
//		
//		pesoNetod  = pesoBrutod - tara;
//		txtPesoNetod.setValue(pesoNetod+"");
//		
//	}
	
	
	public Date getAumentarUnDiaAFecha(Date fecha){
		Date fecha_aumentada = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DAY_OF_YEAR, 1); // Aumentamos un dia a la fecha
		fecha_aumentada= cal.getTime();
		System.out.println("fecha aumentada->"+fecha_aumentada);
		return fecha_aumentada;
	}
	
	
	public void cargarLimpiarControles(){
//		
//		if (lbxCajones.getSelectedIndex()>0 ) {
//			lbxCajones.setSelectedIndex(0);
//		}
		//lbxBarcoDescarga.setSelectedIndex(0);
		
	//	barcoDescarga = null;
		camaraCajon = null;
		camaraFilaColumna = null;
		camara = null;
		
		//limpiar las listas de camara , columnas y filas 
		
		if (lbxColumnas.getSelectedIndex()>0 ) {
			lbxColumnas.setSelectedIndex(0);
		}
		
		if (lbxCamaras.getSelectedIndex()>0 ) {
			lbxCamaras.setSelectedIndex(0);
		}
		
		if (lbxFilas.getSelectedIndex()>0 ) {
			lbxFilas.setSelectedIndex(0);
		}
		
		columnasCamara = new ArrayList<ColumnaCamara>();
		filasCamara = new ArrayList<FilaCamara>();
		
		
	}

	

	public void posicionarColumna(){
		
		
		//||camaraCajon.getCamaraFilaColumna().getIdcolumna()==null
		if ((camaraCajon.getCamaraFilaColumna()==null)) 
		{		
			return;
		}
				
		int pos = 0;
		for (ColumnaCamara c : columnasCamara) 
		{
			System.out.println("BUSCANDO "+c.getColumna().trim()+" == "+ camaraCajon.getCamaraFilaColumna().getIdcolumna().trim());
			//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
			if (c.getColumna().trim().equals(camaraCajon.getCamaraFilaColumna().getIdcolumna().trim())) 
			{
				//camaraFilaColumna.geti
				System.out.println("encontro el registro de columna");
				lbxColumnas.setSelectedIndex(pos+1);
			}
		   pos++;
		}
	}
		


	public void posicionarFila(){
		
		
		
		if ((camaraCajon.getCamaraFilaColumna()==null) ||camaraCajon.getCamaraFilaColumna().getIdfila()==0) {

			return;
		}
		int pos = 0;
		
		
		if (lbxColumnas.getSelectedIndex() > 0)
		{
			for (FilaCamara f : filasCamara) {
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				if (f.getFila()==((camaraCajon.getCamaraFilaColumna().getIdfila()))) {
					System.out.println("encontro el registro de fila");
					lbxFilas.setSelectedIndex(pos+1);
				}
			   pos++;
			}
		}
		
	}



	public void posicionarCamara(){
		
		if ((camaraCajon.getCamara()==null) || camaraCajon.getCamara().getIdcamara()==null) {
			lbxCamaras.setSelectedIndex(0);
			return;
		}
		
			int pos = 0;
			for (Camara c : camaras) {
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				if (c.getIdcamara().equals(camaraCajon.getCamara().getIdcamara()) ) {
					System.out.println("encontro el registro de camara");
					lbxCamaras.setSelectedIndex(pos+1);
				}
			   pos++;
			}
		}

	
}
