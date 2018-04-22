package com.nw.webui.produccion;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/*import java.util.GregorianCalendar;*/
import java.util.Locale;

import java.io.*;
import java.util.List;
//import modelo.MetaTrimestral;
//import modelo.MetaTrimestralId;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.zkoss.lang.Strings;
import org.zkoss.poi.ss.usermodel.Cell;
import org.zkoss.zk.ui.Component;
/*import org.zkoss.zk.ui.Desktop;*/
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
//import org.zkoss.zk.ui.event.Event;
//import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
//import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Button;
//import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Datebox;
//import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
//import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Progressmeter;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
//import org.zkoss.zul.Window;
//import org.zkoss.zul.Vlayout;
import org.zkoss.util.media.Media;

/*import bsh.ParseException;*/

import com.nw.util.Sistema;
import com.nw.util.WorkingDirectory;
import com.nw.util.ExcelReadWrite;
/*import com.nw.model.BarcoCuba;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.Cuba;*/
import com.nw.model.BarcoDescarga;
import com.nw.model.EspecieTalla;
import com.nw.model.LimpiezaProceso;
import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaLote;
import com.nw.model.ProduccionCargaLote;
import com.nw.model.ProduccionDetalleLote;

import com.nw.model.Turno;
import com.nw.model.Usuario;
/*import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;*/
import com.nw.model.dao.impl.LimpiezaProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionCargaLoteDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
//import com.sun.xml.internal.bind.v2.TODO;

public class ProduccionCargaLoteWindow extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Declaracion de Objetos y Variables
	 */
	AnnotateDataBinder binder;
	@SuppressWarnings("unused")
	private int dias_permitidos_hacia_atras = 1;
	private int OPCION = Sistema.NUEVO;
	Listbox lbxTurno;
	Textbox txtId, txtDescripcion;
	Textbox txtNovedad, txtExaminar, txtNomArchivo, txtDiaProd, txtTurno;
	Textbox destTxt;
	Datebox dteFecReg;
	Vbox flist;
	Hbox hl;
	Button btnExaminar, btnCargarGrabar;

	Timestamp fechaConsulta1, fechaConsulta2;
	Progressmeter pm;
	// Spreadsheet spreadsheet;

	// Objetos Globales
	EspecieTalla especietalla;
	Turno turno;
	
	Produccion produccion;// es como la cabecera
	
	ProduccionArchivoCargaLote produccionArchivoCargaLote = new ProduccionArchivoCargaLote();
//	ProduccionDetalleLoteCajon produccionDetalleLoteCajon = new ProduccionDetalleLoteCajon();
	// ProduccionCargaLote produccioncarlote = new ProduccionCargaLote();
	private List<ProduccionCargaLote> produccionCargaLotes = new ArrayList<ProduccionCargaLote>();
	// esta lista se utilizara para obtener datos de especie talla
	//private List<ProduccionCargaLote> produccionCargaLotesDos = new ArrayList<ProduccionCargaLote>();
	private List<ProduccionDetalleLote> produccionDetalleLotes = new ArrayList<ProduccionDetalleLote>();

	List<EspecieTalla> listaEspcietalla = new ArrayList<EspecieTalla>();
//	List<CamaraCajon> listacamaracajon = new ArrayList<CamaraCajon>();
	
	// variables globales
	String fechaArchivo = "";
	String turnoArchivo = "";
	int EstadoPDLTC = 1;
	// instancia de clase q contiene metodo de guardar en tabla
	// ProduccionCargaLote
	ProduccionCargaLoteDAOJpaImpl produccionCargaLoteDAOJpaImpl = new ProduccionCargaLoteDAOJpaImpl();
	ProduccionDAOJpaImpl produccionDAOJpaImpl = new ProduccionDAOJpaImpl();
	boolean ValidarDatos = false;
	boolean Nuevo=false;
	// datos para actualizar
	boolean ActualizarArchivo = false;
	boolean TurnoSiguiente = false;
	Produccion glo_produccionActualizar = new Produccion();
	//ProduccionArchivoCargaLote glo_paclActualizar = new ProduccionArchivoCargaLote();
	List<ProduccionCargaLote> glo_listapclActualizar = new ArrayList<ProduccionCargaLote>();
	List<ProduccionDetalleLote> glo_listapdlActualizar = new ArrayList<ProduccionDetalleLote>();

	public ProduccionCargaLoteWindow() {

	}


	@Override
	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);
		comp.setVariable(comp.getId(), this, true);

		binder = new AnnotateDataBinder(comp);
		binder.loadAll();

		nuevo();
		iniciar();

	}
	
	public void iniciar()
	{
		nuevo();
		fechaConsulta1 = null;
		fechaConsulta2 = null;
		OPCION = Sistema.NUEVO;
		//this.produccionArchivoCargaLote = null;
		//flist=null;
		flist = new Vbox();
		ActualizarArchivo = false;
		fechaArchivo = "";
		turnoArchivo = "";		
		dteFecReg.setValue(new Date());
		
		glo_listapdlActualizar = null;		
		Nuevo=false;
		this.Nuevo=true;
		TurnoSiguiente = false;
		this.TurnoSiguiente=true;
		ValidarDatos = false;
		listaEspcietalla = new ArrayList<EspecieTalla>();
		
		turno = new Turno();
		this.turno = new Turno();
		//produccionCargaLotes = null;
		//produccionArchivoCargaLote = null;

///
		produccion = new Produccion();// es como la cabecera
		this.produccion = new Produccion();// es como la cabecera
		
		produccionArchivoCargaLote = new ProduccionArchivoCargaLote();
		this.produccionArchivoCargaLote = new ProduccionArchivoCargaLote();
		
		produccionCargaLotes = new ArrayList<ProduccionCargaLote>();
		this.produccionCargaLotes = new ArrayList<ProduccionCargaLote>();
		
		produccionDetalleLotes = new ArrayList<ProduccionDetalleLote>();
		this.produccionDetalleLotes = new ArrayList<ProduccionDetalleLote>();
		glo_produccionActualizar = new Produccion();
		glo_listapclActualizar = new ArrayList<ProduccionCargaLote>();
		glo_listapdlActualizar = new ArrayList<ProduccionDetalleLote>();
///
		binder.loadAll();
	}

	
	public void cargarTurnos() {
		lbxTurno.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);

		List<Turno> turnos = new TurnoDAOJpaImpl().getTurnos();

		for (Turno tur : turnos) {
			li = new Listitem();
			li.setValue(tur);
			new Listcell(tur.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);

	}

	/**
	 * Metodo onSelect asignar el item seleccionado de la lista en un objeto del
	 * tipo Turno
	 */
	public void onSelect$lbxTurno() {
		if (lbxTurno.getSelectedIndex() > 0) {
			turno = new Turno();
			turno = (Turno) lbxTurno.getSelectedItem().getValue();
		} else {
			turno = null;
		}
	}

	// BOTON btnExaminar
	public void onClick$btnExaminar() throws InterruptedException, IOException {
		try {

			// nuevo();
			Media media = Fileupload.get();

			System.out.println("media-->" + media.getName());
			flist = new Vbox();
			Hbox hl = new Hbox();
	
			hl.setSpacing("6px");
			hl.setClass("newFile");
			Progressmeter pm = new Progressmeter();
			hl.appendChild(pm);
			hl.appendChild(new Label(media.getName()));
			flist.appendChild(hl);
			@SuppressWarnings("unused")
			String filename = addItemMedia(media);
			boolean estado = consultarFormatoArchivo(media.getName());
			if (estado == true)
			{
				Sistema.mensaje("El formato del archivo es no es compatible de ser: (.xls)");
				return; 
			}
			txtExaminar.setValue(media.getName());
			txtNomArchivo.setValue(media.getName());

		} catch (Exception e) {
			System.out.println("paso esto -->" + e.getMessage());
		}
	}

	public Boolean comprobarsiesfecha(String fecha) {
		boolean vali = false;
		try {
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String fechafin = fecha.replace("-", "/");
			Date fechauno = df.parse(fechafin, new ParsePosition(0));
			System.out.println("res-->" + fechauno);
			if (fechauno != null) {
				return vali = true;
			}
			return vali;
		} catch (Exception e) {
			// TODO: handle exception
			return vali;
		}
	}

	public boolean compararFechas() throws InterruptedException {
		boolean estadoFecha = false;
		try {
			String fechafin = fechaArchivo;
			String fecArchivo = fechafin.replace("-", "/");
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy",
					new Locale("ES"));
			Date fechaEscogida = dteFecReg.getValue();
			String fechaEscogidaFinal = formateador.format(fechaEscogida);

			System.out.println("fechaActualArchivo-->" + fecArchivo);
			System.out
					.println("fechaSeleccionadaFinal-->" + fechaEscogidaFinal);

			if (fecArchivo.equals(fechaEscogidaFinal)) {
				estadoFecha = true;
				return estadoFecha;
			}
		} catch (Exception e) {
			System.out.println("paso esto -->" + e.toString());

		}
		return estadoFecha;
	}

	public boolean coprobarTurno() {
		boolean estadoTurno = false;
		// turnoArchivo
		if (turno != null) {
			String turnoActual = (String.valueOf(turno.getIdturno()).trim());
			String turnoArchivoSeleccionado = (turnoArchivo.trim());

			System.out.println("turnoActual-->" + turnoActual);
			System.out.println("fechaSeleccionadaFinal-->"
					+ turnoArchivoSeleccionado);

			if (turnoActual.equals(turnoArchivo)) {
				estadoTurno = true;
				return estadoTurno;
			} else {
				return estadoTurno;
			}
		} else
			return estadoTurno;
	}

	public boolean compararFecha() {
		boolean estadoFecha = true;
		try {
			if (dteFecReg.getValue() == null) {
				Sistema.mensaje("Debe de escoger una fecha.. Atencion ");
				estadoFecha = false;
				return estadoFecha;
			}

			Date fechaActual = new Date();
			Date fechaSeleccionada = dteFecReg.getValue();

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String fechaFormateadaActual = formato.format(fechaActual);
			String fechaFormateadaSeleccionada = formato
					.format(fechaSeleccionada);

			Date fechaActualFinal = formato.parse(fechaFormateadaActual);
			Date fechaSeleccionadaFinal = formato
					.parse(fechaFormateadaSeleccionada);
			System.out.println("fechaActualFinal-->" + fechaActualFinal);
			System.out.println("fechaSeleccionadaFinal-->"
					+ fechaSeleccionadaFinal);

			// Comparaciones
			

//MODIFICADO 01-04-2015			
//QUITADO PARA PERMITIR ACTUALIZAR UNA FECHA ANTERIOR A LA ACTUAL			
/*
			if (fechaSeleccionadaFinal.before(fechaActualFinal)) {

				Sistema.mensaje("La Fecha Seleccionada  es anterior a la Fecha Actual");
				estadoFecha = false;
				return estadoFecha;
			}
*/			
			
			
			estadoFecha = true;
			System.out.println("fecha ecogida es valida");
			return estadoFecha;

		} catch (Exception e) {
			System.out.println("paso esto -->" + e.toString());
		}
		return estadoFecha;
	}

	boolean EstadoIngreso = false;

	public void obtenerfechas() // throws InterruptedException
	{
		Date mifechahoy = dteFecReg.getValue();
		System.out.println("mifechamas1-->" + mifechahoy);
		// Aumentamos un dia a la fecha
		Calendar cal = Calendar.getInstance();
		cal.setTime(mifechahoy);
		cal.add(Calendar.DAY_OF_YEAR, 1); // Aumentamos un dia a la fecha
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fecha2 = formato.format(cal.getTime());
		String fecha1 = formato.format(mifechahoy);

		System.out.println("mifechamas1-->" + fecha2);
		System.out.println("mifecha-->" + fecha1);

		fechaConsulta1 = obtenerStringEnTime(fecha1);
		fechaConsulta2 = obtenerStringEnTime(fecha2);

	}

	@SuppressWarnings("unused")
	public Boolean consultarFormatoArchivo(String para_nombreArchivo) {
		String archivo;
		boolean estado = false;
		
		if (para_nombreArchivo.contains("xlsx")){
			nuevo();			
			//add
			iniciar();
			archivo="";			
			return estado = true;
			
		}
		else
		{
			return estado = false;
		}
				
	}

		
	@SuppressWarnings({ "unused", "rawtypes" })
	public void onClick$btnCargarGrabar() throws InterruptedException 
	{
			System.out.println("Inicia lectura y valicación del archivo");
			produccionArchivoCargaLote = new ProduccionArchivoCargaLote();

			OPCION = Sistema.NUEVO;
			binder.loadAll();
			System.out.println("//proceso de grabacion y validacion iniciado//");

			this.produccionArchivoCargaLote = produccionCargaLoteDAOJpaImpl.consultarid();// //////my
			
			if(flist.getChildren().size() == 0)
			{
				Sistema.mensaje("Seleccione archivo a subir");
				nuevo();
				iniciar();
				return;
			}	
			
			
			for (int i = 0; i < flist.getChildren().size(); i++) {

				Hbox hl = (Hbox) flist.getChildren().get(i);

				Progressmeter pm;
				pm =  null;
				pm = (Progressmeter) ((Hbox) flist.getChildren().get(i)).getChildren().get(0);

				if (pm.getValue() != 100) 
				{
					//Obtiene el nombre del archivo
					String nombreArchivo = ((Label) ((Hbox) flist.getChildren().get(i)).getChildren().get(1)).getValue();
					
					//Obtiene el directorio del archivo
					String fileName = WorkingDirectory.get().toString() + "\\upload\\" + nombreArchivo;
					System.out.println("fileName-->" + fileName);
					
					//Setea información en pantalla
					txtNovedad.setValue(txtNovedad.getValue() + "\n" + "Iniciando lecura de archivo " + nombreArchivo);

					//////////////////////////////////////////////////
					// TODO LINEA MAGICA... PARA LECTURA DE ARCHIVO //
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//TRANSFORMACION DEL ARCHIVO A UNA MATRIZ, LA CUAL ESTARA REFERENCIA A UN VECTOR (LISTA), POR CADA POSICIÓN//
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//Convierte toda la información del archivo excel en una arreglo de datos (Matriz), 
					//las filas de la matriz, es decir cada posición de la misma estara referencia a una posición 
					//de una lista, es por ella que la viriable sheetData (que contiene el vector), es de tipo List
					List sheetData;
					sheetData = null;
					sheetData = new ExcelReadWrite().readAllExcel(fileName, 0);

					//Inicamos que la lectura, transformación del archivo a un List fue exitosa
					txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "Lecura exitosa de archivo " + nombreArchivo + "\n");
					
					//Indicamos que va iniciar el proceso de formateo del archivo, el cual tiene como finalidad validar los datos del archivo
					txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "Iniciando formateo de archivo " + nombreArchivo);

					
					//Formateo del archivo, valida toda la información del archivo, en este caso ya es un sheetData,
					//en caso de encontrar algun problema con los datos del archivo, se devolvera un mensaje de error,
					//el cual sera retornado en la variable "nombrearchivoformateado", la mismas que mas abajo sera
					//evaluada.
					final String nombrearchivoformateado; 			
					nombrearchivoformateado = showExelData(sheetData, fileName, pm);
					System.out.println("nombrearchivoformateado-->"+ nombrearchivoformateado);

					
						//la variable "nombrearchivoformateado", contendra un mensaje de error, en caso
						//de que este exista al momento de validar el archivo.
						//////////////////////////////////////////////////////////////////////////////
						//INICIO DE COMPROBACION DE ERRORES SEGUN VARIABLE "nombrearchivoformateado"//
						//////////////////////////////////////////////////////////////////////////////
							if (nombrearchivoformateado.equals("sinfecha")) {
								Sistema.mensaje("no existe fecha valida en el archivo");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("sinturno")) {
								Sistema.mensaje("No existe un turno definido en el archivo: verifique  que el turno se encuentre en la celda 2");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("turno diferente")) {
								Sistema.mensaje("El turno definido en el archivo es diferente");
								nuevo();
								iniciar();
								return;
							}
							
							
							//MODIFICADO 01-04-2015			
							//QUITADO PARA PERMITIR ACTUALIZAR UNA FECHA ANTERIOR A LA ACTUAL			
							/*						
							if (nombrearchivoformateado.equals("fechaAnterior")) {
								Sistema.mensaje("La Fecha Seleccionada  es anterior a la Fecha Actual");
								nuevo();
								return;
							}
							*/
							
							if (nombrearchivoformateado.equals("fecha diferente")) {
								Sistema.mensaje("La fecha definida en el archivo es diferente a la escogida verfique el archivo");
								nuevo();
								iniciar();
								return;
							}
							

							//La fecha de producción indicada en el archivo supera el número de días permitidos hasta la fecha actual
							//maximo un dia atras
							if (nombrearchivoformateado.equals("superadias")) {
								Sistema.mensaje("La fecha de producción indicada en el archivo, no puede superar el número de días permitidos ("+ String.valueOf(dias_permitidos_hacia_atras) +") hasta la fecha actual");
								nuevo();
								iniciar();
								return;
							}
							
							
							
							//Este caso no existe, ya que se debe permitir actualizar con una misma fecha de producción y un mismo tuno
							if (nombrearchivoformateado.equals("ArchivoExiste")) {
								Sistema.mensaje("El archivo para esta producion ya existe: se debe anular la produccion para volver a cargar");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("codigonoExiste")) {
								Sistema.mensaje("El codigo Material no existe en el archivo: verifique que no tenga espacios en blanco la columna Cod Barco ");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("ArchivoCargado")) {
								Sistema.mensaje("El Archivo con esta fecha de produccion ya esta Cargado");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("fechaerronea")) {
								Sistema.mensaje("La fecha del archivo Columna B celda 2 no es correcta verifique que el formato sea de tipo texto y el fromato sea: (dd/mm/aaaa) ");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("loteMenor")) {
								Sistema.mensaje("Atención....... El valor del lote no puede ser igual o menor a Cero: Verifique la columna LOTE del archivo ");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("validarViaje")) {
								Sistema.mensaje("Atención....... verifique que los datos de la columna Viaje no contengan más de 4 caracteres");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("validarCodigo")) {
								Sistema.mensaje("Atención....... verifique que el Codigo de Barco en la BD no contengan mas de 4 caracteres");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("validarOrigen")) {
								Sistema.mensaje("Atención....... verifique que los datos de la columna Origen no contengan más de 20 caracteres");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("validarHsc")) {
								Sistema.mensaje("Atención ...... Celda Hsc no cumple el formato texto verifique el archivo");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("validarHic")) {
								Sistema.mensaje("Atención ...... Celda Hic no cumple el formato texto verifique el archivo");
								nuevo();
								iniciar();
								return;
							}
							
							if (nombrearchivoformateado.equals("loteyaExiste")) {
								Sistema.mensaje("Atención....... El archivo contiene lotes repetidos, corriga los datos en la columna Lote ");
								nuevo();
								iniciar();
								return;
							}

							
//Por Mescla							
//							if (nombrearchivoformateado.equals("BarcoEstiba")) {
//	//							Sistema.mensaje("Atención....... No se encuentra el BarcoEstibaCuba");
//								nuevo();
//								iniciar();
//								return;
//							}
//							
//							if (nombrearchivoformateado.equals("Cuba")) {
//								Sistema.mensaje("Atención....... La cuba no existe en la celda: POZO");
//								nuevo();
//								iniciar();
//								return;
//							}
							
							if (nombrearchivoformateado.equals("vacio")) {
								txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "Error en Formateo: campos vacios"+ nombreArchivo);
								nuevo();
								iniciar();
								return;
							}
						///////////////////////////////////////////////////////////////////////////
						//FIN DE COMPROBACION DE ERRORES SEGUN VARIABLE "nombrearchivoformateado"//
						///////////////////////////////////////////////////////////////////////////

						
						//Como la variable "nombrearchivoformateado", no coincidio con
						//ningun error en las condiciones anteriores, se continua con la
						//ejecución normal del programa	
							
						
						//Fue una actualización de un desglose existente segun su fecha y turno de producción	
						if (ActualizarArchivo == true) 
						{
							txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "ACTUALIZACION EXITOSA del archivo " + nombreArchivo);

							//Seteamos la novedad en el txt de la pantallas
							txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "\n\n");
							
							Sistema.mensaje("ACTUALIZACION EXITOSA del archivo ");
							nuevo();
							ActualizarArchivo=false;						
						}
						else
						{
							//Es una producción nueva  con un nuevo  turno, o es una producción que ya existe con un nuevo turno
							txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "CARGA EXITOSA del archivo " + nombreArchivo);
							
							//Seteamos la novedad en el txt de la pantallas
							txtNovedad.setValue(txtNovedad.getValue() + "\n"+ "\n\n");
							
							Sistema.mensaje("CARGA EXITOSA del archivo ");
							nuevo();							
						}

				}

			}
			
			iniciar();
			

	}

	///////////////////////////////////////
	//VALIDACION DE LOS DATOS DEL ARCHIVO//
	///////////////////////////////////////
	// sheetData.- Contiene todos los datos del archivo (es un matriz, la cual cada fila es referencia a una posición de una lista)
	// fileName.- Nombre del Archivo
	// 
	@SuppressWarnings({ "unused", "rawtypes" })	
	private String showExelData(List sheetData, String fileName, Progressmeter pm) throws InterruptedException 
	{
		//TODO Declaracion de Variables
		int indicecelda = 1; // 1
		int registro = 0;
		Cell cellDatos;
		int codVend;
		String año;
		int mes = 0;
		List list;
		String msgwrite = null;
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Se define la lista de variables de tipo celda (Cell), la cual van hacer creadas con el mismo orden según //
		//el orden de la columnas del archivo Excel																   //
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Cell celdaLote;
		Cell celdaEspecieTamano;
		Cell celdaPeso;
		Cell celdaBarcoProveedor;
		Cell celdaReg; // especial
		Cell celdaVia;
		Cell celdaOrigen;
		Cell celdaStatusPesca;
		Cell celdaCodigo;
		Cell celdacodigomaterial;
		//Nueva
		Cell celdaAlmacen;
		Cell celdaZFao;
		Cell celdaPoza;
		Cell celdaObservacion;
		
		Cell celdaOrdenFileteado;
		Cell celdaOrdenPrecocido;
		
		Cell celdaSalMin;
		Cell celdaSalMax;
		Cell celdaTemperatura;
		Cell celdaCurvas;
		
		Cell celdaCf;
		Cell celdaCr;
		Cell celdaRt;
		Cell celdaNumPes;

		Cell celdaCantidad;
		
		Cell celdaPed;
		Cell celdaItem;
		Cell celdaDestino;
		
		Cell celdaDestinos;
		Cell celdaFechaDescarga;
		Cell celdaHic;
		Cell celdaHsc;
//		Cell celdaCajon;
		//////////////////////////////////////////////////////////////
		//Fin de definición de las de variables de tipo celda (Cell)//
		//////////////////////////////////////////////////////////////
		
				
		/////////////////////////////////////////////////////////////////////////////////////////////
		//Se define la lista de variables segun el tipo de datos de las columnas del archivo excel //
		/////////////////////////////////////////////////////////////////////////////////////////////
		String lote;
		String especieTamano;
		Double peso;
		String barcoProveedor;
		Integer reg = 0; // especial
		String via;
		String origen;
		String statusPesca;
		String codigo;
		String codmaterial;
		
		String almacen;
		String Zfao;
		String poza;
		String observacion;
		
		String ordenFileteado;
		String ordenPrecocido;
		
		Double salMin=0.0;
		Double salMax=0.0;
		Double temp=0.0;
		Double tempCurvas=0.0;
		
		Double cf=0.0;
		Double cr=0.0;
		Double rt=0.0;
		Integer pescados=0;
		
		Double canti=0.0;
		
		String ped = "";
		Integer pedido=0;
		String item;
		String destino;
		
		String destinos;
		String fechaDescarga;
		String Hic;
		String Hsc;		
//		String cajon;
		//////////////////////////////////////////////////////////////////////////////////////////////////
		//Fin definición de lista de variables segun el tipo de datos de las columnas del archivo excel //
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//Validaciones (Fecha,Turno,Casos de Carga)
		boolean estadoCelda = true;

		//sheetData.- Sera como nuestra hoja de Excel dessde ahora en adelante
		
		//Obtiene los datos de la fila 0 de nuestro objeto "sheetData" (fila 1 en hoja de excel) y los almacena en una lista 
		List listDatos = (List) sheetData.get(0);// fila (FILA 1 En excel)
		
		//Obtiene el dato de los posición 0 del objeto tipo lista "listDatos" y lo convierte a String sin espacios
		//Ejmplo del dato obtenido: "CARGA ARCHIVO DESGLOSE TURNO 1", mirar en archivo excel (Columna A de la Fila 1) 
		String campo0 = listDatos.get(0).toString().trim();// posicion de columna (Columna A de la Fila 1 en Excel)
		
		//Vatiables para las posiciones de las columnas donde se encuentran la Fecha y el Turno
		int posicionFecha;
		int posicionTurno;
		
		//Obtiene los datos de la fila 0 de nuestro objeto "sheetData" (fila 2 en hoja de excel) y los almacena en una lista		
		List listaContieneFecha = (List) sheetData.get(1);

		//Seteamos las posociciones de las columnas donde se encuentran Fecha y el Turno
		posicionFecha = 0;
		posicionTurno = 1;

		
		
		//////////////////////////////////////////////////////////////
		// VALIDACIONES DE LA FECHA DE PRODUCCION DEL ARCHIVO EXCEL //
		//////////////////////////////////////////////////////////////
		
			//Valida si en la posición indicada de la lista posicionFecha = 0 (fila 2 Columna A en hoja de excel), existe un dato 
			if (listaContieneFecha.get(posicionFecha).toString().equals("")) 
			{
				//Muestra el mensaje en patalla indicando el error
				Sistema.mensaje("La fecha no se encuentra en la  celda 2 Columna A");
				//Termina la ejecución de la función y retorna el tipo de error
				return "sinfecha";
			}
		
			//Toma el dato en posición indicada de la lista posicionFecha = 0 (fila 2 Columna A en hoja de excel) 		
			fechaArchivo = listaContieneFecha.get(posicionFecha).toString().trim();// fecha de producción
				
			//Comprobamos el la variable fechaArchivo es un datos de tipo fecha correcto
			// Si esta correcta devolvera true
			// Si no es correcta devolvera false
			boolean fechaArchi = comprobarsiesfecha(fechaArchivo);
				
			//Verifica si la fecha es incorrecta
			if (fechaArchi == false) 
			{
				//Setea el mensaje de error
				String mensaje = "fechaerronea";
					
				//Ejecuta la funcion nuevo
				nuevo();
					
				//Retorna el error
				return mensaje;
			}
		
				
			boolean caso = compararFechas(); // archivo
			if (caso == false) {
				String mensaje = "fecha diferente";
				nuevo();
				return mensaje;
			}
				
			if (fechaArchivo.equals("")) 
			{
				return "sinfecha";
			}

			
			///////////////////////////////////////////////////////////////////////////////////////////////////
			//Validación de días transcurridos desde la fecha de producción del archivo hasta la fecha actual//
			///////////////////////////////////////////////////////////////////////////////////////////////////
			
			//Obtiene la fecha de producción del archivo en la variable fec 
			Timestamp fec = obtenerStringEnTime(fechaArchivo);

			//Obtiene la fecha actual del sistema en la variable fechaactual de tipo Date 
			Date fechaactual = (new java.sql.Timestamp(new Date().getTime()));
			System.out.println("La fecha actual es :" +fechaactual.toString());
			
			//Convierte la fecha de producción del archivo a tipo Date en la variable fechaaarchivo 
			Date fechaaarchivo = fec;			
			
			
			//Obtiene los días transcurridos desde la fecha de producción indicada en el achivo hasta la fecha actual
			//del sistema
			int dias = diferenciasDeFechas(fechaaarchivo, fechaactual);										
			System.out.println("Dias transcurridos:"+String.valueOf(dias)); 

			//Verifica acepta la pruducción de la carga según los días permitidos hacia atras
			//Nota.- Actualmente solo se puede cargar hasta 1 dia atras en función de la fecha actual
			if(dias > dias_permitidos_hacia_atras)
			{
				//envia el error a la función padre y retorna
				return "superadias";	
			}
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Fin de Vadlidación de días transcurridos desde la fecha de producción del archivo hasta la fecha actual//
			///////////////////////////////////////////////////////////////////////////////////////////////////////////

			txtDiaProd.setValue(fechaArchivo);
		/////////////////////////////////////////////////////////////////////
		// FIN DE VALIDACIONES DE LA FECHA DE PRODUCCION DEL ARCHIVO EXCEL //
		/////////////////////////////////////////////////////////////////////
		
		
		
		
		
		///////////////////////////////////////////////////////////
		// VALIDACIONES DEL TURNO DE PRODUCCION DEL ARCHIVO EXCEL //
		///////////////////////////////////////////////////////////

			//Obtiene los datos de la fila 1 de nuestro objeto "sheetData" (fila 2 en hoja de excel) y los almacena en una lista			
			List listaContieneTurno = (List) sheetData.get(1);

			//Valida si en la posición indicada de la lista posicionTurno = 1 del objeto lista "listaContieneTurno" (fila 2 Columna B en hoja de excel), existe un dato 					
			if (listaContieneTurno.get(posicionTurno).toString().equals("")) 
			{
				//Envia el mensaje de error a pantalla
				Sistema.mensaje("El turno no se encuentra en la  celda 2 Columna B");
				
				//Retorna el error
				return "sinturno";
			}
			
			
			//Convierte el dato de la posición indicada de la lista posicionTurno = 1 del objeto lista "listaContieneTurno" (fila 2 Columna B en hoja de excel) a double 		
			double turnoDouble = (Double.valueOf(listaContieneTurno.get(posicionTurno).toString().trim()));
			
			
			//Covierte la variable turnoDouble a String 
			turnoArchivo = String.valueOf((int) turnoDouble).trim();
			System.out.println("turnoArchivo-->" + turnoArchivo);
			//Verifica si la variable esta vacia
			if (turnoArchivo.equals("")) 
			{
				//Retorna el mensaje de error
				return "sinturno";
			}
			
			
			//Setea el turno en el txt
			txtTurno.setValue(turnoArchivo);
			
			//Toma el nombre del archivo
			String agencia = new ExcelReadWrite().readSeetName(fileName, 0);

			//Genera en un string la ruta del archivo a subir
			//campo0.- Tomado de la fila 1 colunma A del excel
			//agencia.- Nombre del archivo
			String dest;
			dest = WorkingDirectory.get().toString() + "\\upload\\" + campo0+ "_" + agencia + ".xls";
			
			
			//Comprueba si el turno del objeto sheetData (hoja excel excel) es el mismo turno indicado por el usuario en la pantalla
			boolean casoturno = coprobarTurno();
			if (casoturno == false) {
				String mensaje = "turno diferente";
				nuevo();
				return mensaje;
			}
		////////////////////////////////////////////////////////////////
		// FIN VALIDACIONES DEL TURNO DE PRODUCCION DEL ARCHIVO EXCEL //
		////////////////////////////////////////////////////////////////
	
		
		//Obtiene la fecha el objeto dteFecReg y lo asigna a un estring (fecha)
		String fecha = obtenerDateAString(dteFecReg.getValue());
		
		//Convierte la variable string fecha, a una variable a una variable tipo Timestamp y lo
		//asigna a la variable fecactu
		Timestamp fecactu = obtenerStringEnTime(fecha);
		
		/////////////////////////////////////////
		// TODO comprobacion de casos de carga //
		/////////////////////////////////////////
		//Creamos los nuevo objetos
		ProduccionArchivoCargaLote paclturn = new ProduccionArchivoCargaLote();
		Produccion loc_produccion = new Produccion();

		
		boolean estadocomp=true;
		
		//OJO// aqui se comprueba si hay produccion con la fecha y turno del archivo, en caso de no solo con fecha si no es asi entonces es nueva prod
		
		//Crea un objeto tipo List para consultar la producción, segun la fecha de produccion indicada en el acrhivo
		List<Produccion> producciones =  new ArrayList<Produccion>();

		////////////////////////////////////////////////////////////////////////////////////
		//Primer caso si es nueva producción, no existen produccion con la fecha indicada.//
		////////////////////////////////////////////////////////////////////////////////////

		//Se consulta si ya existe la producción en la tabla de producción con la fecha indicada, la cual esta indicada en la vaiable
		//tipo fecha "fec" 		
		producciones=produccionDAOJpaImpl.consultarfechaProduccion(fec);
		
		
		// consultarListasLotes();
		System.out.println("El tamaño de producciones es:"+producciones.size());

		//Si existe la producción
		if (producciones.size()> 0)
		{
			//Toma todos los lotes creados segun la fecha de producción y turno de la tabla produccionCargaLote
			//y los guarda en la lista de tipo global "glo_listapdlActualizar"			
			//BLOQUE 0
			//UN LOTE EN AMBOS TURNOS//
			
				//glo_listapdlActualizar = produccionCargaLoteDAOJpaImpl.consultarListaProduccionDetalleloteProduccionyTurno(producciones.get(0).getIdproduccion(),turno.getIdturno());
			
			//FIN UN LOTE EN AMBOS TURNOS//
			
			//Toma todos los lotes creados segun la fecha de producción de la tabla produccionCargaLote
			//y los guarda en la lista de tipo global "glo_listapdlActualizar"			
			glo_listapdlActualizar = produccionCargaLoteDAOJpaImpl.consultarListaProduccionDetalleloteByProduccion(producciones.get(0).getIdproduccion());
			
			System.out.println("El tamaño de glo_listapdlActualizar es:"+glo_listapdlActualizar.size());
		}
		else
		//No existe la producción	
		{
			System.out.println("El tamaño de glo_listapdlActualizar es vacio");
			
			glo_listapdlActualizar = null;
			
		}
		
		

				
		//No existe la producción
		if (producciones.size()<=0)
		{
			//Nueva producción
			this.Nuevo=true;
			//Nuevo Turno
			this.TurnoSiguiente=true;
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
		//Segundo caso comprobar si es el mismo turno y fecha, si es asi entonces es una actualizacion//
		////////////////////////////////////////////////////////////////////////////////////////////////
		else
		{
			
			//Consultamos si ya existe un producción cargada en la tabla "produccionArchivoCargaLotes" por la fecha de producción y el turno
			producciones = produccionDAOJpaImpl.consultarfechaTurnodeProduccion(fec,turno.getIdturno());
			
			///////////////////////////////////////////////
			//SI EXISTE LA FECHA DE PRODUCCION Y EL TURNO//
			///////////////////////////////////////////////
			//Verifica si encontro producciones con el turno inidicado en la tabla  "produccionArchivoCargaLotes
			if (producciones.size()>0)
			{
				/////////////////
				//ACTUALIZACION//
				/////////////////
				
				//Si encontro con la fecha y turno de producción
				
				//Recorremos las lista producciones y lo asignamos al objeto loc_produccion (de tipo Produccion)
				for (Produccion itempro : producciones) 
				{
					//Seteamos el objeto tipo loc_produccion (tipo Produccion),  con las prodicciones encontradas,
					//a medida que de la vuelta este objeto se sobreescibira, ya que es la misma produccion en todas
					//las vueltas que de el ciclo
					loc_produccion = itempro;
				}
				
				
				//Como es una actualizacion hacemos las validaciones de estado, se captura el estado en la variable "estado"
				// 0-cargada
				// 1-aperturada
				// 2-cerrada
				// 3-anulada								
				int estado=loc_produccion.getEstado();
				
				//Producción esta aperturada o cargada
				if (estado == 1 || estado == 0) 
				{
					//Es una actualización de archivo
					ActualizarArchivo = true;
					
					//consultarIdProducion(fec);
					
					//Asginamos a la variable global this.produccion, la producción enontrada 
					this.produccion= loc_produccion;
					
				}
				else 
					//Producción esta cerrada
					if (estado == 2)
					{
						
						//No es un nuevo turno
						TurnoSiguiente = false;
						
						//Indica que el archivo ya existe "ArchivoExiste"
						//Aunque esta variable no ejerce ninguna función
						estadocomp = false;					
					}
					else 
						//Producción esta anulada
						if (estado > 2)
						{							
							//Nueva producción
							Nuevo=true;
							
							//Nuevo turno
							TurnoSiguiente = true;
							
							//Aginamos al objeto global this.produccion, la producción tomada
							this.produccion= loc_produccion;
						}
			/////////////////////
			//FIN ACTUALIZACION//
			/////////////////////				
			}
			else
			{
				/////////////////////////////////////////////////////
				//SI EXISTE LA FECHA DE PRODUCCION Y ES NUEVO TURNO//
				/////////////////////////////////////////////////////

				//Tercer caso.- Nuevo turno el turno siguiente, en la fecha de producción encontrada
				
				//No es nuevo (porque encontro la fecha de producción)
				Nuevo=false;
				
				//Es un nuevo turno
				TurnoSiguiente = true;
				//Consultamos la producción por la fecha de producción en la tabla Produccion
				producciones=produccionDAOJpaImpl.consultarfechaProduccion(fec);
				
				//Tomamos la producción y lo setemos en el objeto globlal this.produccion 
				this.produccion= producciones.get(0);
				//////////////////////////////////////////////////////
				//FIN EXISTE LA FECHA DE PRODUCCION Y ES NUEVO TURNO//
				//////////////////////////////////////////////////////				
			}
		}

		

		
		//Valida si el aechivo ya existe
		//Aunq no se usa esta acción
//?		
//		if (estadocomp==false)
//		{
//			return "ArchivoExiste" ;
//		}

		

		
		
		//Verifica si esta actualizando una fecha anterior a la actual
		//Actualmente esta función de error no tiene ningún efecto 
		//ya en la función desde donde es llamada, debe permitir actualizar 
		//en fecha de producciones anteriores a la actual
//SI ES UNA FECHA ANTERIOR A LA ACTUAL, ENTONCES DA ERROR DE "fechaAnterior" y retorna para no continuar 		
//		if (ActualizarArchivo==false)
//		{
//			if (compararFecha() == false) {
//				return "fechaAnterior" ;
//			}
//		}
		


		//Iniciamos la variable con posicion 1		
		int posicionColumna = 1;
		
		// Se inicia en 3 para no copiar la cabecera del archivo
		for (int i = 3; i < sheetData.size(); i++) 
		{ 
			//xxx
			
			//AQUI VOY
			if (ValidarDatos == false && estadoCelda == true) 
			{
				list = (List) sheetData.get(i);
				
				if (list.size() > 5) 
				{
					if (list.get(0).toString() != ""
							&& list.get(3).toString() != ""
							&& list.get(4).toString() != ""
							&& list.get(8).toString() != ""
							&& list.get(9).toString() != "") 
					{

						celdaLote = (Cell) list.get(0);
						celdaEspecieTamano = (Cell) list.get(1);
						celdaPeso = (Cell) list.get(2);
						celdaBarcoProveedor = (Cell) list.get(3);
						celdaReg = (Cell) list.get(4);
						celdaVia = (Cell) list.get(5);
						celdaOrigen = (Cell) list.get(6);
						celdaStatusPesca = (Cell) list.get(7);
						celdaCodigo = (Cell) list.get(8);
						celdacodigomaterial = (Cell) list.get(9);
						
						celdaAlmacen=(Cell) list.get(10);
						 celdaZFao=(Cell) list.get(11);
						 
						 //Por Mezcla
						 //celdaPoza=(Cell) list.get(12);
						 
						 
						 celdaObservacion=(Cell) list.get(13);
						
						 celdaOrdenFileteado=(Cell) list.get(14);
						 celdaOrdenPrecocido=(Cell) list.get(15);
						
						 celdaSalMin=(Cell) list.get(16);
						 celdaSalMax=(Cell) list.get(17);
						 celdaTemperatura=(Cell) list.get(18);
						 celdaCurvas=(Cell) list.get(19);
						
						 celdaCf=(Cell) list.get(20);
						 celdaCr=(Cell) list.get(21);
						 celdaRt=(Cell) list.get(22);
						 celdaNumPes=(Cell) list.get(23);

						 celdaCantidad=(Cell) list.get(24);
						
						 celdaPed=(Cell) list.get(25);
						 celdaItem=(Cell) list.get(26);
						 celdaDestino=(Cell) list.get(27);
						
						 celdaDestinos=(Cell) list.get(28);
						 celdaFechaDescarga=(Cell) list.get(29);
						 celdaHic=(Cell) list.get(30);
						 celdaHsc=(Cell) list.get(31);
						
						
						
						// ///////////// GRABACION DE DATOS EN
						// TABLA////////////////////////////////////////////

						System.out.println("celdaCodigo-->" + celdaCodigo);
						Object objlote = celdaLote;
						Object objCodigoMaterial = celdacodigomaterial;
						Object objEspecieTamano = celdaEspecieTamano;
						Object objPeso = celdaPeso;
						Object objReg = celdaReg;
						Object objVia = celdaVia;
						Object objBarcoProveedor = celdaBarcoProveedor;
						Object objCodigo = celdaCodigo;
						Object objOrigen = celdaOrigen;
						Object objStatusPesca = celdaStatusPesca;
						
						Object objAlmacen = celdaAlmacen;
						Object objZFao= celdaZFao;
						
						//Por Mescla
						//Object objPoza= celdaPoza;
						
						Object objObservacion = celdaObservacion;
						
						Object objOrdenFileteado = celdaOrdenFileteado;
						Object objOrdenPrecocido = celdaOrdenPrecocido;
						
						Object objSalMin= celdaSalMin;
						Object objSalMax= celdaSalMax;
						Object objTemperatura= celdaTemperatura;
						Object objCurvas = celdaCurvas;
						
						Object objCf = celdaCf;
						Object objCr = celdaCr;
						Object objRt = celdaRt;
						Object objNumPes = celdaNumPes;

						Object ObjCantidad = celdaCantidad;
						
						Object objPed = celdaPed;
						Object objItem = celdaItem;
						Object objDestino = celdaDestino;
												
						Object objDestinos = celdaDestinos;
						Object objFechaDescarga = celdaFechaDescarga;
						Object objHic = celdaHic;
						Object objHsc =celdaHsc;
						
						
						switch (celdaLote.getCellType()) 
						{
							case HSSFCell.CELL_TYPE_NUMERIC:
								break;
							case HSSFCell.CELL_TYPE_STRING:
								System.out.println("Celda String " + " "+ celdaLote);
								estadoCelda = false;
								break;
							default:
								estadoCelda = false;
								break;
						}
						
						lote = String.valueOf(objlote).trim();

						codmaterial = String.valueOf(objCodigoMaterial).trim();
						especieTamano = String.valueOf(objEspecieTamano).trim();
						String pesoChar = String.valueOf(objPeso).trim();
						String registroChar = String.valueOf(objReg).trim();
						via = String.valueOf(objVia).trim();
						barcoProveedor = String.valueOf(objBarcoProveedor).trim();
						codigo = String.valueOf(objCodigo).replace(".0", "").trim();//.replace(" ", "");
						origen = String.valueOf(objOrigen).trim();
						statusPesca = String.valueOf(objStatusPesca).trim();
						
						almacen= String.valueOf(objAlmacen).replace(".0", "").trim();
						 Zfao= String.valueOf(objZFao).trim();
						 
						 //Por Mescla
						 //poza= String.valueOf(objPoza).trim();
						 
						 observacion= String.valueOf(objObservacion).trim();
						 
						 ordenFileteado= String.valueOf(objOrdenFileteado).trim();
						 ordenPrecocido= String.valueOf(objOrdenPrecocido).trim();
						 
						 if (objSalMin.toString()!=""){
						 salMin= Double.valueOf(String.valueOf(objSalMin).trim());
						 }else{ salMin=0.0;}
						 
						 if (objSalMax.toString()!=""){
						 salMax= Double.valueOf(String.valueOf(objSalMax).trim());
						 }else{ salMax=0.0;}
						 
						 if (objTemperatura.toString()!=""){
						 temp= Double.valueOf(String.valueOf(objTemperatura).trim());
						 }else{ temp=0.0;}
						 
						 if (objCurvas.toString()!=""){
						 tempCurvas= Double.valueOf(String.valueOf(objCurvas).trim());
						 }else{ tempCurvas=0.0;}
						 
						 if (objCf.toString() !=""){
						 cf= Double.valueOf(String.valueOf(objCf).trim());
						 }else{ cf=0.0;}
						 
						 if (objCr.toString() !=""){
						 cr= Double.valueOf(String.valueOf(objCr).trim());
						 }else{ cr=0.0;}
						 
						 if (objRt.toString() !=""){
						 rt= Double.valueOf(String.valueOf(objRt).trim());
						 }else{ rt=0.0;}
						 
						 if (objNumPes.toString()!=""){
						 double pesc=(Double.valueOf((String.valueOf(objNumPes).trim())));
						 pescados=(int) pesc;
						 }else{ pescados=0;}
						 
						 if (ObjCantidad.toString()!=""){
						 canti= Double.valueOf(String.valueOf(ObjCantidad).trim());
						 }else{ canti=0.0;}
//						 ped = = String.valueOf(obj )= String.valueOf(obj );
//						 pedido= String.valueOf(obj );
//						 item= String.valueOf(obj );
//						 destino= String.valueOf(obj );
						
						item = String.valueOf(objItem).trim();
						destino = String.valueOf(objDestino).trim();
						ped = String.valueOf(objPed).trim();
						System.out.println("i = " + i);
						registro = registro + 1;
						
						destinos= String.valueOf(objDestinos).trim();
						fechaDescarga= String.valueOf(objFechaDescarga).trim();
						Hic= String.valueOf(objHic).trim();
						Hsc= String.valueOf(objHsc).trim();

						
						///////////////////
						//Tomamos el lote//
						///////////////////
							//Toma el lote y lo convierte en Double
							Double lot = Double.valueOf(lote);
							
							//Reasigna la variable lot en la variable en la variable l tipo double   
							double l = lot;
							
							//Convierte la variable l tipo double en int y se almacena en la variable lo
							//Tenemos el lote en la variable lo tipo int
							int lo = (int) l;
							System.out.println("lo-->" + lo);
						////////////////////////
						//Fin de Toma del lote//
						///////////////////////

							
						Long idpcl;
						
						
						//TODO definicion de objetos prioncpales
						ProduccionCargaLote pcl = new ProduccionCargaLote();

//						for (ProduccionCargaLote itemPLC : glo_listapclActualizar) {
//								if (itemPLC.getIdlote().equals(lo)) {
//									idpcl = itemPLC.getIdproduccioncargalote();
//									pcl.setIdproduccioncargalote(idpcl);
//									//pcl.setProduccionArchivoCargaLote(produccionArchivoCargaLote);
//									pcl.setProduccionArchivoCargaLote(itemPLC.getProduccionArchivoCargaLote());
//									break;
//								}
//						}						
						 
						ProduccionDetalleLote pdl = new ProduccionDetalleLote();
						
						
						
						
						//agregado 1
						//Verifica si esta actualizando un desglose
						

///BLOQUE 1//
//UN LOTE EN AMBOS TURNOS//						
/*						
						if(ActualizarArchivo == true ) 
						{
*/
//FIN UN LOTE EN AMBOS TURNOS//	
						
						//Verifica si la lista actualizar no esta vacia para recorrerla
						if (glo_listapdlActualizar != null)
						{
							
							
							
							for (ProduccionDetalleLote itempdl : glo_listapdlActualizar) 
							{
								// V2. 0
								//CON ESTA LINEA PERMITE ACTUALIZAR EN UN TURNO ESPESIFICO (VERIFICA QUE SEA EL MISMO TURNO Y LOTE PARA HACER LA ACTUALIZACION)
								//if (String.valueOf(itempdl.getIdlote()).trim().equals(String.valueOf(lo).trim()) && String.valueOf(itempdl.getTurno()).equals(turnoArchivo) )
								
								// V1. 0
								//CON ESTA LINEA PERMITE ACTUALIZAR A CUALQUIER TURNO (SOLO VERIFICA QUE SEA EL MISMO LOTE PARA HACER LA ACTUALIZACION DEL LOTE EN EL TURNO INDICADO)
								if (String.valueOf(itempdl.getIdlote()).trim().equals(String.valueOf(lo).trim()))
								{
									
									//Busca el lote en la producción
									pdl = new ProduccionCargaLoteDAOJpaImpl().consultarListaProduccionDetalleloteProduccionyLote(producciones.get(0).getIdproduccion(),itempdl.getIdlote()).get(0);
									
									//Si no lo encuentra crea un nuevo objeto
									if (pdl == null)
									{
										pdl = new ProduccionDetalleLote();
									}	
									
									//Lo Actualiza
									pdl.setIdproducciondetallelote(itempdl.getIdproducciondetallelote());
									//pdl.setProduccion(this.produccion); //se lo seteo en laactualizacion aqui
									pdl.setProduccion(itempdl.getProduccion()); //se lo seteo en laactualizacion aqui

									// 0 = Desactivado
									// 1 = Activado
									// 2 = Afectado (Indicamos que fue afectado en una actualización para despues por descarte
									// asumir que los que no fueron afectados son los que deberan ser desactivado y los afectados
									// dejarlos como activados 1)
									pdl.setEstadoCarga(1);
									
									
									//BLOQUE 1.1//
									//UN LOTE EN AMBOS TURNOS//
										//Quedan como lostes afectados para despues asumir por descarte que estos son los que
										//deben de quedar como activos
										////ANTES pdl.setEstado(2);
									
									//pdl.setEstadoCarga(2);
									
									//FIN LOTE EN AMBOS TURNOS//	
									
									break;
								}
								else
								{
									//En un nuevo desglose que que esta subiendo
									//El lote queda activado por defecto
									// 0 = Desactivado
									// 1 = Activado
									// 2 = Afectado (Indicamos que fue afectado en una actualización para despues por descarte
									// asumir que los que no fueron afectados son los que deberan ser desactivado y los afectados
									// dejarlos como activados 1)
									
									
									//Quedan como lostes activados por defecto por ser nuevos
									//ANTES pdl.setEstado(1);
									pdl.setEstadoCarga(1);
								}
								
							}
							
							
						}
						else
						{
							pdl.setEstadoCarga(1);
						}
						//agregado 1

/*BLOQUE 2
 //UN LOTE EN AMBOS TURNOS//
  								
						}
				
						else
						{
							//En un nuevo desglose que que esta subiendo
							//El lote queda activado por defecto
							// 0 = Desactivado
							// 1 = Activado
							// 2 = Afectado (Indicamos que fue afectado en una actualización para despues por descarte
							// asumir que los que no fueron afectados son los que deberan ser desactivado y los afectados
							// dejarlos como activados 1)
							
							
							//Quedan como lostes activados por defecto por ser nuevos
							//ANTES pdl.setEstado(1);
							pdl.setEstadoCarga(1);
						}
//FIN UN LOTE EN AMBOS TURNOS//					
*/
					
						System.out.println("id produccio--->"+this.produccion.getIdproduccion());
						
						//pcl.setProduccionArchivoCargaLote(produccionArchivoCargaLote);

						double codmatdou = Double.valueOf(codmaterial.trim());
						int codigoMat = (int) codmatdou;
						boolean estadoEspecie = false;
						estadoEspecie = produccionDAOJpaImpl.consultarEspecie(codigoMat);
						
						if (estadoEspecie == false) {
							Sistema.mensaje("campo vacio en celda: " + (i + 1)+ " de la colunma: Codigo Material");

							String mensajeNuevo = "codigonoExiste";
							return mensajeNuevo;
						}

						EspecieTalla et = new EspecieTalla();
						
						et.setIdespecietalla(codigoMat);
						pdl.setEspecieTalla(et);
						
						listaEspcietalla.add(et);
						

						double rd;
						int pedFinal = 0;
						int itemFinal = 0;
						if (ped.trim() != "") 
						{
							double valorPed = Double.valueOf(ped.trim());
							pedFinal = (int) valorPed;
						}
						
						if (item.trim() != "") {
							double valorItem = Double.valueOf(item.trim());
							itemFinal = (int) valorItem;
						}
						
						Double registroDouble = Double.valueOf(registroChar.trim());
						rd = registroDouble;
						reg = (int) rd;
						
						BarcoDescarga bd = new BarcoDescarga();
						if(codigo.length()==1)
						{
							codigo="0"+codigo;
						}
						
						//Aqui
						bd = produccionDAOJpaImpl.consultarIdBarco(String.valueOf(reg),codigo.trim());
						if (bd == null) {
							Sistema.mensaje("El Registro del Barco_Descarga no existe en la celda: "
									+ (i + 1)+" o verifique que no tenga datos espacios el Cod_Barco");
							return "vacio";
						}
						
											
						pcl.setIdlote(lo);
						pcl.setEspecietalla(especieTamano);
						if (pesoChar.trim() !="")
						{	
							peso = Double.valueOf(pesoChar.trim());
							pcl.setPeso(peso);
							pdl.setPeso(peso);
						}
						if (lo<1){
							String mensajeNuevo = "loteMenor";
							return mensajeNuevo;
						}
						pdl.setIdlote(lo);
						pdl.setTurno(this.turno);						
						pdl.setBarcoDescarga(bd);
						pdl.setPedidocamara(pedFinal);
						pdl.setItemprograma(itemFinal);
						
						
						pcl.setRegistro(reg);
						//nueva validacion para que verificar el tamaño del dato  string a ingresar en esos campos caso contrario hacia rolback y no guarda
						if(via.length()>4){
							String mensajeNuevo = "validarViaje";
							return mensajeNuevo;
						}
						if(almacen.length()>5){
							String mensajeNuevo = "validar";
							return mensajeNuevo;
						}
//						if(codigo.length()>4){
//							almacen.substring(1, 5);
//						}
						if(observacion.length()>10){
							observacion.substring(1, 9);
						}
						if(Hic.length()>5){
							Hic.substring(1, 9);
							String mensajeNuevo = "validarHic";
							return mensajeNuevo;
						}
						if(Hsc.length()>5){
							Hsc.substring(1, 9);
							String mensajeNuevo = "validarHsc";
							return mensajeNuevo;
						}
						if(origen.length()>20){
							String mensajeNuevo = "validarOrigen";
							return mensajeNuevo;
						}
						
//Por Mescla						
//						Cuba cuba = new Cuba();
//						BarcoCuba bc = new BarcoCuba();
//						BarcoEstibaCuba bec = new BarcoEstibaCuba();
//						cuba= produccionCargaLoteDAOJpaImpl.obtenerCubaporNombre(poza.trim());
//						
//						if (cuba==null){
//							return "Cuba";
//						}else{							
//							bc = new BarcoCubaDAOJpaImpl().getBarcoCubaBarco(cuba.getIdcuba(),codigo.trim());
//						}
//						
//						
//						if (bc==null){
//							Sistema.mensaje("Atención....... No se encuentra el dato de la columna Poza celda: " + (i+1));
//									 
//							return "BarcoEstiba";
//						}
//						
//						
//						bec = produccionDAOJpaImpl.consultarBarcoEstibaCuba(bd.getIdbarcodescarga(), bc.getIdbarcocuba());
//						if (bec==null){
//							Sistema.mensaje("Atención....... No se encuentra el dato de la columna Poza celda: " + (i+1));
//							return "BarcoEstiba";
//						}else{
//							pdl.setBarcoEstibaCuba(bec);
//						}
						

						
						
						
						
						//TODO aumento de campos nuevos para PRODUCCION CARGA LOTE
						pcl.setAlmacen(almacen.trim());
						
						//Por Mescla
						//pcl.setPoza(poza.trim());
						
/*						
						if (observacion.trim() !="")
							pcl.setObservaciones(observacion.trim());
						if (ordenFileteado.trim() !="")
						pcl.setOrdenfileteado(ordenFileteado);
						if (ordenPrecocido.trim() !="")
							pcl.setOrdenprecocido(ordenPrecocido.trim());
*/

						pcl.setObservaciones(observacion.trim());
						pcl.setOrdenfileteado(ordenFileteado.trim());
						pcl.setOrdenprecocido(ordenPrecocido.trim());
						
						pcl.setSalmax(salMax);
						pcl.setSalmin(salMin);
						pcl.setTempcocina(temp);
						pcl.setTempcurva(tempCurvas);
						pcl.setCf(cf);
						pcl.setCr(cr);
						pcl.setRt(rt);
						pcl.setPescados(pescados);
						pcl.setCant(canti);
						pcl.setDestinoscliente((destinos).trim());						
						if (fechaDescarga.trim().length()==10){
							pcl.setFechadescarga(obtenerStringEnTime(fechaDescarga));
						}else{
							pcl.setFechadescarga(obtenerTime(fechaDescarga));
						}

						pcl.setHic(Hic);
						pcl.setHsc(Hsc);
						
						pcl.setViaje(via.trim());
						pcl.setCodigobarco(codigo.trim());
						pcl.setNombrebarco(barcoProveedor.trim());
						pcl.setOrigen(origen.trim());
						pcl.setStatuspesca(statusPesca.trim());
						pcl.setPedido(pedFinal);
						pcl.setItem(itemFinal);
						pcl.setDestinos((destino).trim());
						//aumento de campo destino en la tabla producciondetallelote
/*
						pdl.setAlmacen(almacen.trim());
						if (observacion.trim() !="")
							pdl.setObservaciones(observacion.trim());
						if (ordenFileteado.trim() !="")
							pdl.setOrdenfileteado(ordenFileteado.trim());
						if (ordenPrecocido.trim() !="")
							pdl.setOrdenprecocido(ordenPrecocido.trim());
*/
						pdl.setObservaciones(observacion.trim());
						pdl.setOrdenfileteado(ordenFileteado.trim());
						pdl.setOrdenprecocido(ordenPrecocido.trim());
						
						pdl.setSalmax(salMax);
						pdl.setSalmin(salMin);
						pdl.setTempcocina(temp);
						pdl.setTempcurva(tempCurvas);
						pdl.setCf(cf);
						pdl.setCr(cr);
						pdl.setRt(rt);
						pdl.setPescados(pescados);
						pdl.setCant(canti);
						pdl.setDestinoscliente((destinos).trim());
//						 
						if (fechaDescarga.trim().length()==10){
							pdl.setFechadescarga(obtenerStringEnTime(fechaDescarga.trim()));
						}else{
							pdl.setFechadescarga(obtenerTime(fechaDescarga.trim()));	
						}
						
						pdl.setHic((Hic.trim()));
						pdl.setHsc((Hsc.trim()));
						
						pdl.setStatuspesca(statusPesca.trim());
												
						
						pdl.setDestinos((destino).trim());
						pdl.setOrigen(origen.trim());
						pcl.setIdturno(Integer.valueOf(turno.getIdturno()));
						boolean existe=false;
//NEP					
						ProduccionDetalleLote rpdl = new ProduccionDetalleLote();
						
						//validacion para que no se inserten lotes repetido en el mismo archivo
						if (produccionCargaLotes.size()>0)
						{
							for (ProduccionDetalleLote pdls : produccionDetalleLotes) 
							{
								
								if(String.valueOf(pdls.getIdlote()).trim().equals(String.valueOf(pdl.getIdlote()).trim()))
								{
									existe=true;
									return "loteyaExiste";
								}
							}
						}
						produccionCargaLotes.add(pcl);
						produccionDetalleLotes.add(pdl);
						
					}

					else {

						if ((list.get(0).toString().equals("")
								&& list.get(1).toString().equals("")
								&& list.get(2).toString().equals("")
								&& list.get(3).toString().equals("")
								&& list.get(4).toString().equals("")
								&& list.get(5).toString().equals("")
								&& list.get(6).toString().equals("")
								&& list.get(7).toString().equals("")
								&& list.get(8).toString().equals("")
								&& list.get(9).toString().equals("")
								&& list.get(10).toString().equals("") && list
								.get(11).toString().equals("")))

						{
							break;
						} 
						else 
							{
								ValidarDatos(fileName.trim(), i);
							}
					}
				} 
				else 
					{
						break;
					}
			} 
			else 
				{
					String mensajeNuevo = "vacio";
					return mensajeNuevo;
				}
		}// fin segundo for
		
			GuardarProduccion();
			if(this.produccion.getIdproduccion()==null)
			{
				Sistema.mensaje("La carga del archivo presento un problema en idProduccion ");
				return "vacio";
			}
		int p = 0;
		for (ProduccionCargaLote pcloitem : produccionCargaLotes) {
			
			//if(ActualizarArchivo==false){
			pcloitem.setProduccionArchivoCargaLote(produccionArchivoCargaLote);
			//}
			
			//Aqui
			produccionCargaLoteDAOJpaImpl.saveOrUpdate(pcloitem);
			//ProduccionDetalleLote pdl = new ProduccionDetalleLote();
		
			System.out.println("id produccio--->"+this.produccion.getIdproduccion());
			// TODO
			
			p++;
		}
		
		
		ProduccionDetalleLote rdlc = new ProduccionDetalleLote();
		
		for (ProduccionDetalleLote itemPDL : produccionDetalleLotes) 
		{
			//if(ActualizarArchivo==false){
				itemPDL.setProduccion(this.produccion); //se lo seteo en laactualizacion aqui
			//}
			
				
//			//Busca el lote en la producción	
//			//rdlc = new ProduccionCargaLoteDAOJpaImpl().getProduccionDetalleLoteByProduccionDetalleLoteCajonIdRegresh(itemPDL.getProduccion().getIdproduccion(), itemPDL.getIdlote());
			List<ProduccionDetalleLote> lpdl = new ProduccionCargaLoteDAOJpaImpl().consultarUltimoLote(itemPDL.getIdlote(), (itemPDL.getProduccion().getIdproduccion() - dias_permitidos_hacia_atras) );
//			
//			//Si encontro el lote en la producción
//			//if (rdlc !=null)
			
			if (lpdl.size() > 0)
			{
				//Tomamos el 1er registro de la lista
				rdlc = new ProduccionCargaLoteDAOJpaImpl().getProduccionDetalleLoteByIdRegresh(lpdl.get(0).getIdproducciondetallelote());
				
				//Capturamos el objeto para tenerlos apuntado
				
				//ProduccionDetalleLote rdlc_act = new ProduccionDetalleLote();
				//Lo actuliza
				rdlc = ActProduccionDetalleLote(itemPDL, rdlc);
				
				//ACTUALIZAR
				new ProduccionCargaLoteDAOJpaImpl().saveOrUpdateProduccionDetalleLote(rdlc);
			}
			else
			{
				//CREAMOS EL NUEVO LOTE
				Long idproduc = new ProduccionCargaLoteDAOJpaImpl().guardarProduccionDetalleLote(itemPDL);	
			}

				
		}
		

		
		//Verifica si esta actualizando un desglose, para poder hacer la verificación de los lotes que no van hacer usados
		if(ActualizarArchivo == true ) 
		{
				
//CAMBIO - ESTADOS REEMPLAZAR POR EL NUEVO CAMPO DE ESTADO EN LAS LLAMADAS DE LAS FUNCIONES
			
			//Desactivamos los lotes que no fueron afectados (Se mantuvierón con estado 1)
			produccionCargaLoteDAOJpaImpl.DesactivarLotesNoAfectados(producciones.get(0).getIdproduccion(),turno.getIdturno());
			
			//Aqui
			//Activamos los lotes que fueron afectados (estado =  2)
			produccionCargaLoteDAOJpaImpl.ActivarLotesAfectados(producciones.get(0).getIdproduccion(),turno.getIdturno());			
		}
		
		
		return campo0 + "_" + agencia + ".xls";

	}
	
	public ProduccionDetalleLote ActProduccionDetalleLote(ProduccionDetalleLote pdl_excel, ProduccionDetalleLote pdl_base)
	{
		
		pdl_base.setProduccion(pdl_excel.getProduccion());
		pdl_base.setIdlote(pdl_excel.getIdlote());
		pdl_base.setIdcliente(pdl_excel.getIdcliente());
		pdl_base.setIdproducto(pdl_excel.getIdproducto());
		pdl_base.setEspecieTalla(pdl_excel.getEspecieTalla());
		pdl_base.setBarcoDescarga(pdl_excel.getBarcoDescarga());
		pdl_base.setRt(pdl_excel.getRt());
		pdl_base.setPedidocamara(pdl_excel.getPedidocamara());
		pdl_base.setItemprograma(pdl_excel.getItemprograma());
		pdl_base.setTurno(pdl_excel.getTurno());
		pdl_base.setPeso(pdl_excel.getPeso());
		pdl_base.setDestinos(pdl_excel.getDestinos());
		pdl_base.setOrigen(pdl_excel.getOrigen());
		pdl_base.setStatuspesca(pdl_excel.getStatuspesca());
		pdl_base.setOrdenfileteado(pdl_excel.getOrdenfileteado());
		pdl_base.setOrdenprecocido(pdl_excel.getOrdenprecocido());
		
		//mescla
		//pdl_base.setBarcoEstibaCuba(pdl_excel.getBarcoEstibaCuba());
		
		
		pdl_base.setAlmacen(pdl_excel.getAlmacen());
		pdl_base.setObservaciones(pdl_excel.getObservaciones());
		pdl_base.setSalmin(pdl_excel.getSalmin());
		pdl_base.setSalmax(pdl_excel.getSalmax());
		pdl_base.setTempcocina(pdl_excel.getTempcocina());
		pdl_base.setTempcurva(pdl_excel.getTempcurva());
		pdl_base.setCf(pdl_excel.getCf());
		pdl_base.setCr(pdl_excel.getCr());
		pdl_base.setPescados(pdl_excel.getPescados());
		pdl_base.setCant(pdl_excel.getCant());
		pdl_base.setDestinoscliente(pdl_excel.getDestinoscliente());
		pdl_base.setFechadescarga(pdl_excel.getFechadescarga());
		pdl_base.setHic(pdl_excel.getHic());
		pdl_base.setHsc(pdl_excel.getHsc());
		pdl_base.setEstado(pdl_excel.getEstado());
		pdl_base.setFirme(pdl_excel.getFirme());
		pdl_base.setSemifirme(pdl_excel.getSemifirme());
		pdl_base.setSuave(pdl_excel.getSuave());
		pdl_base.setPastoso(pdl_excel.getPastoso());
		pdl_base.setAbsaceite(pdl_excel.getAbsaceite());
		pdl_base.setAbsagua(pdl_excel.getAbsagua());
		pdl_base.setEstadoCarga(pdl_excel.getEstadoCarga());
		
		return pdl_base;
	}

	
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
			fechaInicial = df.parse(fechaInicioString);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String fechaFinalString = df.format(fechaFinal);
        try {
			fechaFinal = df.parse(fechaFinalString);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    
	public void ValidarDatos(String fileName, int i) {
		for (int j = 0; j <= 12; j++) {
			if (j == 1 || j == 4 || j == 5 || j == 9 || j == 10) {
				String especieTalla1 = new ExcelReadWrite().readExcel(fileName,
						0, i, j);
				if (especieTalla1.equals("")) {
					Sistema.mensaje("campo vacio en celda " + (i + 1)
							+ " columna " + (j + 1) + " ");
					ValidarDatos = true;
					nuevo();
					return;
				}
			}
		}
	}

	public void GuardarProduccion() throws InterruptedException 
	{
		// grabar cabecera
		String fecha = obtenerDateAString(dteFecReg.getValue());
		Timestamp mifecha = obtenerStringEnTime(fecha.trim());
		
		//Es un nueva produccion en un nuevo turno siguiente (la idea esque el programa cree automaticamente la nueva producción)
		if (ActualizarArchivo == false && Nuevo==true && TurnoSiguiente==true) {
			
			//Crea el objeto de la nueva producción
			Produccion prod = new Produccion();
			
			//Setea la nueva fecha de producción
			prod.setFechaproduccion(mifecha);
			
			//prod.setEstado(0);// uno es estado cargado
			//Setea el estado por defecto
						
			prod.setEstado(1);// estado que indica el día de producción aperturado
			
			//Guarda la nueva producción en la tabla producción
			this.produccion = produccionDAOJpaImpl.guardarCabeceraProduccionIdMax(prod);
			System.out.println("produccion max id-->"+ this.produccion.getIdproduccion());
			System.out.println("produccion max id-->" + prod.getEstado());
		}
		
		///////////////////////////////////////
		//GRABA la ProduccionArchivoCargaLote// 
		///////////////////////////////////////
		
		//Crea el nuevo objeto produccionArchivoCargaLote
		ProduccionArchivoCargaLote produccionArchivoCargaLote = new ProduccionArchivoCargaLote();
		
		//Setea el objeto produccionArchivoCargaLote con sus valores 
		produccionArchivoCargaLote.setProduccion(this.produccion);
		String fechaahora = obtenerDateAString(dteFecReg.getValue());
		Timestamp mifecha1 = obtenerStringEnTime(fechaahora);
		produccionArchivoCargaLote.setFechacarga(new java.sql.Timestamp(new Date().getTime()));
		produccionArchivoCargaLote.setFechaarchivo(mifecha1);
		produccionArchivoCargaLote.setNombrearchivo(txtNomArchivo.getValue());
		produccionArchivoCargaLote.setTurnoarchivo(Integer.valueOf(turno.getIdturno()));
		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		
		if (usuario==null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			//return;
			usu.setIdusuario("aaguirre");
		}
		
		produccionArchivoCargaLote.setUsuario(usu);
		ProduccionArchivoCargaLote locproduccionArchivoCargaLote = new ProduccionArchivoCargaLote();
		//Grabamos el objeto, el cual en la función que es llamada generara el id de la misma tabla tomando el ultimo + 1
		locproduccionArchivoCargaLote = produccionCargaLoteDAOJpaImpl.guardarCabeceraProduccionArchivoCargaLoteIdMax(produccionArchivoCargaLote);
		/////////////////////////////////////////////////////
		//Fin de grabación de producción archivo carga lote//
		/////////////////////////////////////////////////////

		//Aqui
		System.out.println("produccionArchivoCargaLote id max -->"+ this.produccionArchivoCargaLote.getIdproduccionarchivocargalote());
		
		if (ActualizarArchivo==false){
			this.produccionArchivoCargaLote=locproduccionArchivoCargaLote;
		}
		
	}
	
	public EspecieTalla llenarEspecieTalla() {
		EspecieTalla et = new EspecieTalla();
		for (EspecieTalla esptalla : listaEspcietalla) {
			et = esptalla;
		}

		return et;
	}

	public String obtenerDateAString(Date parafecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormateadaActual = formato.format(parafecha);

		return fechaFormateadaActual;
	}

	public Timestamp obtenerStringATime(String parafecha) {
		DateFormat df = DateFormat.getDateInstance();
		Timestamp mifecha = null;
		Date fecha = df.parse(parafecha, new ParsePosition(0));
		mifecha = new Timestamp(fecha.getTime());
		return mifecha;
	}

	public Timestamp obtenerStringEnTime(String f) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String parafecha = f.replace("-", "/");
		Timestamp mifecha = null;
		Date fecha = df.parse(parafecha, new ParsePosition(0));
		mifecha = new Timestamp(fecha.getTime());
		return mifecha;
	}
	public Timestamp obtenerTime(String f) {
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		//String parafecha = f.replace("-", "/");
		Timestamp mifecha = null;
		Date fecha = df.parse(f, new ParsePosition(0));
		mifecha = new Timestamp(fecha.getTime());
		return mifecha;
	}
	// TODO
	public Date obtenerStringEnhoy(String fecha) {
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		Date fecha1 = df.parse(fecha, new ParsePosition(0));
		return fecha1;
	}

	/**
	 * METODO PARA CONVERTIR FECHA STRIN EN DATE
	 * 
	 * @param fechaAFormatear
	 * @return
	 */
	public Timestamp obtenerFechaFormateada(String fechaAFormatear) {
		Date fecha = null;
		Timestamp ts = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fecha = formato.parse(fechaAFormatear);
			ts = new java.sql.Timestamp(fecha.getTime());
			System.out.println("fecha ts-->" + ts);
		} catch (Exception e) {
			System.out.println("paso lo soguiente convirtiendo la fecha-->"
					+ e.getMessage());
		}

		return ts;
	}
	
	public String obtenerHora(String fechaAFormatear) {
		Date fecha = null;
		Timestamp ts = null;
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		try {
			fecha = formato.parse(fechaAFormatear);
			ts = new java.sql.Timestamp(fecha.getTime());
			System.out.println("fecha ts-->" + ts);
		} catch (Exception e) {
			System.out.println("paso lo soguiente convirtiendo la fecha-->"
					+ e.getMessage());
		}

		return ts.toString();
	}

	public String addItemMedia(org.zkoss.util.media.Media media)
			throws IOException {
		txtNovedad.setValue(txtNovedad.getValue() + "\n Archivo -->"
				+ media.getName() + " ...Subiendo Archivo ");

		String fileName = WorkingDirectory.get().toString() + "\\upload\\"
				+ media.getName();
		// String fileName="\\upload\\"+media.getName();
		File dst = new File(fileName);
		// Media media = Fileupload.get();
		org.zkoss.io.Files.copy(dst, media.getStreamData());

		return fileName;

	}
	public Date DeStringADate(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strFecha = fecha;
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(strFecha);
			System.out.println(fechaDate.toString());
			return fechaDate;
		} catch (Exception ex) {
			ex.printStackTrace();
			return fechaDate;
		}
	}
	public void nuevo() {
		txtNovedad.setValue("");
		txtExaminar.setValue("");
		txtNomArchivo.setValue("");
		txtDiaProd.setValue("");
		txtTurno.setValue("");
		dteFecReg.setValue(new Date());
		especietalla = new EspecieTalla();
		turno = new Turno();
		produccion = new Produccion();// es como la cabecera
		produccionArchivoCargaLote = new ProduccionArchivoCargaLote();
//		produccionDetalleLoteCajon = new ProduccionDetalleLoteCajon();
		produccionCargaLotes = new ArrayList<ProduccionCargaLote>();
		//produccionCargaLotesDos = new ArrayList<ProduccionCargaLote>();
		produccionDetalleLotes = new ArrayList<ProduccionDetalleLote>();
		glo_produccionActualizar = new Produccion();
		//glo_paclActualizar = new ProduccionArchivoCargaLote();
		glo_listapclActualizar = new ArrayList<ProduccionCargaLote>();
		glo_listapdlActualizar = new ArrayList<ProduccionDetalleLote>();
		TurnoSiguiente = false;
		ActualizarArchivo=false;
		Nuevo=false;
		cargarTurnos();
	}

	@SuppressWarnings("unused")
	private String getSelectedDescripcion() throws WrongValueException {
		String name = txtDescripcion.getValue();
		if (Strings.isBlank(name)) {
			throw new WrongValueException(txtDescripcion,
					"No debe estar en blanco!");
		}
		return name;
	}

	public List<ProduccionCargaLote> getProduccionCargaLotes() {
		return produccionCargaLotes;
	}

	public void setProduccionCargaLotes(
			List<ProduccionCargaLote> produccionCargaLotes) {
		this.produccionCargaLotes = produccionCargaLotes;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(
			List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}


	
	//No se que finalidad tiene esta función al trabajar con
	//la tabla de LimpiezaProceso
	
	//Toma todos los lotes creados segun la fecha de producción de la tabla produccionCargaLote
	//a los guarda en la lista de tipo global "glo_listapdlActualizar"
	public void consultarListasLotes() 
	{
//			glo_listapclActualizar = produccionCargaLoteDAOJpaImpl.consultarProduccionCargalote();
		
			//Crea un nuevo objeto LimpiezaProceso 
			LimpiezaProceso lp = new LimpiezaProceso();
			
			//Toma el ultimo idlimpiezaproceso de la tabla LimpiezaProceso (ultimo limpieza proceso creado) 
			lp = new LimpiezaProcesoDAOJpaImpl().obtenerLimpiezaMax();
			
			//Toma todos los lotes creados segun la fecha de producción de la tabla produccionCargaLote 
			glo_listapdlActualizar = produccionCargaLoteDAOJpaImpl.consultarListaProduccionDetallelote(lp.getProduccion());

//			for (ProduccionCargaLote item: glo_listapclActualizar) {
//				glo_paclActualizar.setIdproduccionarchivocargalote(item.getProduccionArchivoCargaLote().getIdproduccionarchivocargalote());
//				break;
//			}
	}

}
