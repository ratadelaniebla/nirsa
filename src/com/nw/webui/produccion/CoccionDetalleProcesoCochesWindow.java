package com.nw.webui.produccion;

//import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.CoccionDetalleProcesoCoche;
import com.nw.model.CoccionProceso;
import com.nw.model.Cuartochillroom;
import com.nw.model.Ducharociado;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.Produccion;
import com.nw.model.RociadoDetalleProcesoCoche;
import com.nw.model.RociadoProceso;
import com.nw.model.Turno;
import com.nw.model.Usuario;
//import com.nw.model.dao.impl.CalidadInicienciasDAOJpaImpl;
import com.nw.model.dao.impl.CoccionDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.CoccionProcesoDAOJpaImpl;
import com.nw.model.dao.impl.CuartochillroomDAOJpaImpl;
import com.nw.model.dao.impl.DucharociadoDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.ExcelDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.RociadoDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.RociadoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.model.dao.impl.UsuarioDAOJpaImpl;
//import com.nw.temp.model.DetallesCocina;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CoccionDetalleProcesoCochesWindow extends GenericForwardComposer {

	private Integer bandera2 = 0;
	private Listbox  lbxTurnoLabor,lbxDuchaRociado,lbxCuartoChillroon, lbxFechaActiva;// lbxArea;
	private Toolbarbutton btnGrabar;
	private Decimalbox txtTemperatura;
	private Textbox txtDiaProduccion,txtCoche,txtNumCoche, txtFechaActiva, txtTurnoProduccion,
	txtCocheLote,txtLote,txtCocina,txtCanastillas,txtPescadoLata/*txtCapturaPeso,*/; //txtPeso
	Date fechaActual = new Date();
	private Label lblDuchaRociado; 
	
	private Textbox txProduccion, txtLoteu,
	txtInfCocina,
	txtTotal,
	txtReceptados,
	txtPendientes;
	
	Date fecha;
	Long idproduccion;
	Turno turno;
	Turno turnoLabor;
	Ducharociado duchaRociado;
	Cuartochillroom cuartochillroom;
	Double pesoneto ;
	String pesoGlobal;
	
	private DecimalFormat df;
	private BufferedReader in;
	private Socket skt;		

	private Integer bandera=0;
	private double pesogabetas = 0.0;
	private double vpesoneto = 0.0;
	private double vpesoretenido = 0.0;
	private CoccionProceso coccionProceso;
	
	EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	List<EvisceradoDetalleProcesoCoche> listEdpc= new ArrayList<EvisceradoDetalleProcesoCoche>();
	DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG); //SHORT, MEDIUM, LONG, FULL
	Produccion produccion;
	Produccion produccionb;
	CoccionDetalleProcesoCoche coccionDetalleProcesoCoche;
	RociadoProceso rociadoProceso;
	
	String valorCocheCodigoBarra = "";
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		cargaListaFechaProduccionActiva((long) 0);
		
		//cargarListaTurno();
		cargarListaTurnoLabor();
		//cargaListaFechaProduccionActiva();
		cargarLimpiarControles();
		//lbxArea.setSelectedIndex(0);
		cargarListaCuarto();
		cargarListaRociado();
		//lbxDuchaRociado.setSelectedIndex(0);
		//lbxCuartoChillroon.setSelectedIndex(0);
		
		
		
		
		txtCoche.setDisabled(true);
		
	}
	

	/**
	 * LEE UNA CADENA DE TEXTO Y ASIGNA CADA CARACTER A UNA VARIABLE GLOBAL (valorCoche)
	 * y esta es a su vez la cual interactua en el resto de metodos de busqueda 
	 * observacion : en una pc o tablet se dispara rapido apenas se escribe un caracter
	 * en el hand held uno puede escribir el codigo y luego dar click en la tecla enter
	 * o en el boton "Done" del navegador , o al dar click en otro lado de la pantalla
	 * despues de leer el codigo 
	 * @param event
	 * @throws InterruptedException
	 * @throws IOException
	 */
//	public void onChanging$txtCoche(InputEvent event) throws InterruptedException, IOException{
//		 System.out.println("valor es -->"+event.getValue());
//		  valorCocheCodigoBarra = "";
//		 valorCocheCodigoBarra = event.getValue().trim();
//		 
//		 System.out.println("**********valor de coche Ingresado ->"+valorCocheCodigoBarra);
//		 
//		 //txtPeso.setValue("1.0");
//		 
////		 pesoGlobal="1.23";
//		 if(!valorCocheCodigoBarra.equals("")){
//			 //onClick$btnGrabar();
//			 grabar();
//		 }
//	}
	
	
	
	
//  public void onSelect$lbxArea() throws InterruptedException{
//
//	  cargarLimpiarControles();
//		if (lbxArea.getSelectedIndex()>0) 
//		{
//			//Cocción -> Cargar Rociado
//			if (lbxArea.getSelectedIndex()==1) 
//			{
//				cargarListaRociado();
//				lblDuchaRociado.setValue("Ducha Rociado");
//			}
//				//Rociado -> Chill Romm
//				else
//				{
//					cargarListaCuarto();
//					lblDuchaRociado.setValue("Cuarto ChillRoom");
//				}
//			
//			
//			txtCoche.setFocus(true);
//		}
//		else
//		{
//				lblDuchaRociado.setValue("Sin Area");
//				lbxDuchaRociado.getItems().clear();
//		}
//	}
	
  
	public void cargarListaCuarto(){
		lbxCuartoChillroon.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Cuartochillroom());
		li.setParent(lbxCuartoChillroon);
				
		List<Cuartochillroom> listaCuartos = new CuartochillroomDAOJpaImpl().getCuartochillRomm();
		
		for (Cuartochillroom cc : listaCuartos) {
			li = new Listitem();
			li.setValue(cc);
			new Listcell(cc.getDescripcion()).setParent(li);
			li.setParent(lbxCuartoChillroon);
		}
		lbxCuartoChillroon.setSelectedIndex(0);
	}  
	
	public void cargarListaTurnoLabor(){
		lbxTurnoLabor.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoLabor);
				
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		
		for (Turno bd : listaTurnos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getNombre()).setParent(li);
			li.setParent(lbxTurnoLabor);
		}
		lbxTurnoLabor.setSelectedIndex(0);
	}
	
	
	public void onSelect$lbxTurnoLabor() throws InterruptedException{
		txtCoche.setValue(""); 
//		txtNumCoche.setValue("");
//		txtCocheLote.setValue("");
//		txtLote.setValue("");
//		txtCocina.setValue("");
//		txtCanastillas.setValue("");
//		txtPescadoLata.setValue("");
//		txtPeso.setValue("");	
//		txtFechaActiva.setValue("");
//		txtTurnoProduccion.setValue("");
	//	txtPeso.setValue(null);
		pesoGlobal = "";

		if (lbxTurnoLabor.getSelectedIndex()>0) {
			//vaciamos el objeto barcoDescarga creando una nueva instancia 
			turnoLabor = new Turno();
			turnoLabor = (Turno) lbxTurnoLabor.getSelectedItem().getValue();
//			lbxArea.setFocus(true);
		}
	}
	
	public void cargarListaRociado(){
		lbxDuchaRociado.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Ducharociado());
		li.setParent(lbxDuchaRociado);
				
		List<Ducharociado> listaDucha = new DucharociadoDAOJpaImpl().getTurnos();
		
		for (Ducharociado bd : listaDucha) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getDescripcion()).setParent(li);
			li.setParent(lbxDuchaRociado);
		}
		lbxDuchaRociado.setSelectedIndex(0);
	}
	
	public void onSelect$lbxDuchaRociado() throws InterruptedException{
		
		txtTemperatura.setText("");
		txtTemperatura.setReadonly(true);
		
		if (lbxDuchaRociado.getSelectedIndex()>0) 
		{
			txtCoche.setDisabled(false); // activamos el coche
			//Coccion -> Sale ha ducha
			duchaRociado = new Ducharociado();
			duchaRociado = (Ducharociado) lbxDuchaRociado.getSelectedItem().getValue();
			//desactivamos el lisbtox de chilrom
			cuartochillroom = null;
			//lbxCuartoChillroon.setDisabled(true);
			lbxCuartoChillroon.setSelectedIndex(0);
			txtCoche.setFocus(true);
			System.out.println("escogio ducha rociado ->"+duchaRociado.getDescripcion());
		}
		else
			{
				txtCoche.setDisabled(true); // desactivamos el coche
				duchaRociado = null;
				
			}
		
	}
	
	
	public void onSelect$lbxCuartoChillroon() throws InterruptedException{
		
		txtTemperatura.setText("");
		txtTemperatura.setReadonly(false);

		
		if (lbxCuartoChillroon.getSelectedIndex()>0) 
		{
			txtCoche.setDisabled(false); // activamos el coche
			//Ducha-> Sale al ChillRoom
			cuartochillroom = new Cuartochillroom();
			cuartochillroom = (Cuartochillroom) lbxCuartoChillroon.getSelectedItem().getValue();
			//desactivamos el lisbtox de ducharociado
			duchaRociado = null;
			//lbxDuchaRociado.setDisabled(true);
			lbxDuchaRociado.setSelectedIndex(0);
			txtCoche.setFocus(true);
			System.out.println("escogio ducha cuartochillroom ->"+cuartochillroom.getDescripcion());
		}
		else
			{
				txtCoche.setDisabled(true); // desactivamos el coche
				cuartochillroom = null;
			}
		
	}
	
	
	
	public int buscaCocheCoccion(String accion)
	{
		
		if(accion.equals("B"))
		{
			pesoGlobal ="";
		}
/*		produccion= new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEDPCochePorCodBarra2(Long.valueOf(valorCocheCodigoBarra));*/

		produccion = evisceradoDetalleProcesoCoche.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getProduccion();		
		
		if(produccion==null){
			Sistema.mensaje("Coche no disponible");
			return 1;
		}else{
			coccionProceso = new CoccionProcesoDAOJpaImpl().getCoccionProcesoIdProduccion(produccion.getIdproduccion().toString());
			
		}
				
//				evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCoche();
//				List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
//				
//
//				lista  = new CoccionDetalleProcesoCocheDAOJpaImpl()
//				   .ListarCoccionDetalleProcesoCocheCoccion1
//				         (Long.valueOf(String.valueOf(valorCocheCodigoBarra).trim()));
				
//				if (lista.size() == 0)
//				{
//
//					Sistema.mensaje("Coche no disponible");
//					//txtCoche.setValue(""); //null
//					//txtPeso.setValue("");
//					pesoGlobal = "";
//					txtCoche.setText("");
//					//txtCoche.focus();
//					txtCoche.setFocus(true);
//					onClick$btnLimpiarCoche();
//					onClick$btnLimpiarCoche();
//					
//					produccion = null;
//					turno = null;
//					
//					return 1;
//				}
//				
//				
//				for (EvisceradoDetalleProcesoCoche item : lista) {
//					
////					txtCanastillas.setValue(item.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getIdproduccion().toString());
//			 		
//					//Obtenemos la produccion
//					produccion = new Produccion();
//					produccion = new ProduccionDAOJpaImpl().getProduccionById(item.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getIdproduccion());
////					txtFechaActiva.setValue(null);
//					
//					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////					txtFechaActiva.setValue(dateFormat.format(produccion.getFechaproduccion()));
//
//					
//					turno = new Turno();
//					turno = new TurnoDAOJpaImpl().getFindTurnoId(item.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getTurno().getIdturno());
////					txtTurnoProduccion.setValue(turno.getIdturno().toString());
//					
//					
//					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
//					System.out.println(item.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getIdproduccion().toString());
//					
//					//Obtenemos objeto pot el IdProduccion 
//					coccionProceso = new CoccionProcesoDAOJpaImpl().getCoccionProcesoIdProduccion(item.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getIdproduccion().toString());
//					
//					if (item.getIdcochedia() != null) {
////						txtNumCoche.setValue(String.valueOf(item.getIdcocheglobal()));
//					}
//					
////					txtNumCoche.setValue(item.getIdevisceradodetalleprocesocoche().toString());
////					txtCocheLote.setValue(String.valueOf(item.getIdcoche().toString()));
////					
////					txtCocina.setValue(String.valueOf(item.getCocina().getDescripcion()));
////					txtPescadoLata.setValue(String.valueOf(item.getEvisceradoPescadosLata().getIdevisceradopescadoslata()));
////					
////					txtLote.setValue(String.valueOf(item.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getIdlote()));
//					
//					evisceradoDetalleProcesoCoche = item;
//	
//					
//				}
			
				lbxDuchaRociado.focus();
				
				return 0;
	}

	
	
    public void onSelect$lbxFechaActiva() throws InterruptedException{
    	produccionb = null;
    	txtLoteu.setValue("");
		txProduccion.setValue("");
		txtInfCocina.setValue("");
		txtTotal.setValue("");
		txtReceptados.setValue("");
		txtPendientes.setValue("");

		txtLoteu.setFocus(true);
    	
		if (lbxFechaActiva.getSelectedIndex()>0) {
			produccionb = new Produccion();
			produccionb = (Produccion) lbxFechaActiva.getSelectedItem().getValue();
			
		}else{
			produccionb = null;
		}
	}
	
	
	
	
	
	public void cargaListaFechaProduccionActiva(Long vproduccion) throws InterruptedException
	{
		int ubi = 0, pos = 0;
		lbxFechaActiva.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxFechaActiva);
				
		//List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActiva();
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaEviscerdo();
		
		for (Produccion bd : listaFecha) 
		{		
			pos ++;
			li = new Listitem();
			li.setValue(bd);
			
			if (bd.getIdproduccion().toString().equals(vproduccion.toString()))
			{
				ubi = pos;	
			}
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
			li.setParent(lbxFechaActiva);
		}
		
		//Encontro la ubicacion
		if (ubi > 0)
		{
			lbxFechaActiva.setSelectedIndex(ubi);
			onSelect$lbxFechaActiva();
		}
		else
		{
			lbxFechaActiva.setSelectedIndex(0);	
		}
		
	}
	
	
	public void onClick$btnNuevo() throws InterruptedException
	{
		cargaListaFechaProduccionActiva((long) 0);
		txtLoteu.setValue("");
		txProduccion.setValue("");
		txtInfCocina.setValue("");
		txtTotal.setValue("");
		txtReceptados.setValue("");
		txtPendientes.setValue("");
		lbxFechaActiva.setFocus(true);
	}
	
	
	
	
	
	public void onClick$btnBuscar()
	{
		//
		txProduccion.setValue("");
		txtInfCocina.setValue("");
		txtTotal.setValue("");
		txtReceptados.setValue("");
		txtPendientes.setValue("");

		if (lbxFechaActiva.getSelectedIndex() == 0)
		{
			Sistema.mensaje("No existe produción selecciona o establecida para buscar");
			lbxFechaActiva.setFocus(true);
			return;
		}
		
		Integer lote;
		
		try {
			lote = Integer.valueOf(txtLoteu.getValue());
		} catch (WrongValueException e) {
			// TODO Auto-generated catch block
			txtLoteu.setValue("");
			Sistema.mensaje("Ingrese un numero de lote correcto");
			return;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			txtLoteu.setValue("");
			Sistema.mensaje("Ingrese un numero de lote correcto");
			return;
		}
		
				
		
		if (produccionb != null)
		{
			System.out.println("produccionb.getIdproduccion() :"+produccionb.getIdproduccion());
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			txProduccion.setValue((dateFormat.format(produccionb.getFechaproduccion())).toString());
			
			List <Object[]> lista;
			lista = new ExcelDAOJpaImpl().getDetallesLote(produccionb.getIdproduccion(), lote);
			
			for (Object[] l: lista)
			{
				txtInfCocina.setValue((String)l[3]);
				txtTotal.setValue(((Long)l[2]).toString());
				txtReceptados.setValue(((Long)l[4]).toString());
				txtPendientes.setValue(((Long)l[5]).toString());
			}			
		}
		else
		{
			Sistema.mensaje("No existe una fecha de producción activa asociada al lote");
			return;
		}
			

			

		
	}
	
	
	public void onClick$btnLimpiarCoche()
	{
		txtTemperatura.setText("");
		txtCoche.focus();
		txtCoche.setText("");
	}

	public int onClick$btnBuscaCoche(){
		
		if (lbxTurnoLabor.getSelectedIndex() == 0)
		{
			Sistema.mensajeError("Seleccion turno de producción");
			lbxTurnoLabor.setFocus(true);
			return 1;
		}

//		if (lbxArea.getSelectedIndex() == 0)
//		{
//			Sistema.mensajeError("Seleccione Area (Cocción/Rociado)");
//			lbxArea.setFocus(true);
//			return 1;
//		}	
		
		
		if (txtCoche.getValue().isEmpty())
		{
			Sistema.mensajeError("Ingrese número de coche");
			txtCoche.setFocus(true);
			return 1;
		}		
		
//		if(lbxArea.getSelectedIndex() == 1)
//		{
//			buscaCocheCoccion("B");
//			//txtPeso.setFocus(true);			
//		}
//		else
//		{
//			buscaCocheRocioado("B");
//			//txtPeso.setFocus(true);
//		}
		
		return 0;
	}


	public int buscaCocheRocioado(String accion)
	{
		if(accion.equals("B"))
		{
//			txtNumCoche.setValue("");
//			txtCocheLote.setValue("");
//			txtLote.setValue("");
//			txtCanastillas.setValue("");
//			txtPescadoLata.setValue("");
			 
			//txtPeso.setValue("");
			pesoGlobal="";
			
		}
		
/*		produccion= new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEDPCochePorCodBarra(Long.valueOf(valorCocheCodigoBarra));*/

		produccion = evisceradoDetalleProcesoCoche.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getProduccion();		
		
		if(produccion==null){
			Sistema.mensaje("Coche no disponible");
			return 1;
		}else{
			//TODO
			rociadoProceso = new RociadoProcesoDAOJpaImpl().getRociadoProcesoIdProduccion(produccion.getIdproduccion().toString());
//			coccionProceso = new CoccionProcesoDAOJpaImpl().getCoccionProcesoIdProduccion(produccion.getIdproduccion().toString());
		}
				
//				evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCoche();
//				coccionDetalleProcesoCoche = new CoccionDetalleProcesoCoche();
//				List<CoccionDetalleProcesoCoche> lista = new ArrayList<CoccionDetalleProcesoCoche>();
//				
////				lista  = new CoccionDetalleProcesoCocheDAOJpaImpl()
////				        .ListarCoccionDetalleProcesoCoche4
////				             (Long.valueOf(String.valueOf(txtCoche.getValue()).trim()));
//				
//				lista  = new CoccionDetalleProcesoCocheDAOJpaImpl()
//		        .ListarCoccionDetalleProcesoCoche5
//		             (Long.valueOf(String.valueOf(valorCocheCodigoBarra).trim()));	
//				
//
//				if (lista.size() == 0)
//				{
//				
//					Sistema.mensaje("Coche no disponible");
//					//txtCoche.setValue(""); //null
//					//txtPeso.setValue("");
//					pesoGlobal="";
//					txtCoche.setText("");
//					//txtCoche.focus();
//					txtCoche.setFocus(true);
//					onClick$btnLimpiarCoche();
//					onClick$btnLimpiarCoche();
//					
//					return 1;
//				}
//				
//				for (CoccionDetalleProcesoCoche item : lista) 
//				{
//					//Obtenemos la produccion
//					produccion = new Produccion();
//					produccion = new ProduccionDAOJpaImpl().getProduccionById(item.getCoccionProceso().getProduccion().getIdproduccion());
////					txtFechaActiva.setValue(null);
//					
//					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
////					txtFechaActiva.setValue(dateFormat.format(produccion.getFechaproduccion()));
//
//					turno = new Turno();
//					turno = new TurnoDAOJpaImpl().getFindTurnoId(item.getEvisceradoDetalleProcesoCoche().getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getTurno().getIdturno());
////					txtTurnoProduccion.setValue(turno.getIdturno().toString());					
//					
//					rociadoProceso = new RociadoProcesoDAOJpaImpl().getRociadoProcesoIdProduccion(item.getCoccionProceso().getProduccion().getIdproduccion().toString());
//	
////					txtCanastillas.setValue(String.valueOf(item.getEvisceradoDetalleProcesoCoche().getCanastillas()));
////					txtNumCoche.setValue(String.valueOf(item.getEvisceradoDetalleProcesoCoche().getIdevisceradodetalleprocesocoche()));
////					txtCocheLote.setValue(String.valueOf(item.getEvisceradoDetalleProcesoCoche().getIdcoche()));
////					txtPescadoLata.setValue(String.valueOf(item.getEvisceradoDetalleProcesoCoche().getEvisceradoPescadosLata().getIdevisceradopescadoslata()));					
////					txtLote.setValue(String.valueOf(item.getEvisceradoDetalleProcesoCoche().getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getIdlote()));
////					
////					txtCocina.setValue(item.getEvisceradoDetalleProcesoCoche().getCocina().getDescripcion());
//				
//					
//					evisceradoDetalleProcesoCoche = item.getEvisceradoDetalleProcesoCoche();					
//				}
//				
				return 0;
				
	}

	
	public void onClick$btnPeso() throws InterruptedException, IOException{
		TomarPeso();
		//TomarPeso();
	}
		//CAPTURAR LA TARA
		

//		//Verifica si el ingreso manual no esta activado
//		if(parametro.getPermiso().equals("S"))
//		{
//			Sistema.mensaje("Opción no disponible mientras este activado el ingreso manual de peso");
//			return;
//		}		

	public void TomarPeso() throws InterruptedException, IOException{
		//CapturarPeso cp =  new CapturarPeso();
		////////////////////////btnPeso.setDisabled(true);
		//Activamos la bandera 
		bandera=1;
		Integer contador = 0;
///		txtPeso.setValue(null);
		//BufferedReader in = null;
		
	   	pesogabetas = 0.0;
	   	vpesoneto = 0.0;
	   	vpesoretenido = 0.0;		
		
		String peso = "";
		try {
			//////Socket skt = new Socket("192.198.20.81", 10001); //selecciono direccion y puerto del servidor
	        skt = new Socket("192.198.20.144", 10001);
			//skt = new Socket("192.198.20.239", 10001);
	        skt.setSoTimeout(1000); //tiempo de espera de respuesta
	        String trama = "";
	        
	        String medida = "";
	        String estable = "";
	        
	        //BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        System.out.print("Received string: '");
	        
	        bandera=1;
           // while(true && contador <= 10){
	        while(true && bandera ==1 ){ 	
	        
	        contador = contador + 1;	        
	        //btnPeso.setDisabled(true);
            
             try{
           	  
           	  System.out.println(skt.isConnected());
             }
             catch(Exception e){
           	  System.out.println(e.toString()); 
             }
             
              for(;;){
           	 if(in.ready()) //espera trama en buffer
           	   break;
           	 if(skt.isConnected())  ///consulta equipo conectado (puerto abierto)
           	   break;
           	 else{
           	   in.close();
           	   System.out.print("cierro socket'");
           	   //btnPeso.setDisabled(false);
           	 }
              }
               System.out.print("Contador = "+ contador.toString());
	           System.out.print("salida'");
	           trama = in.readLine();
	           
	           //verifico trama correcta
	           if(trama.length()>11)
	           { 
	             peso = trama.substring(1, 9);
	             System.out.println(peso.replace('.',',').trim());
	             
		    	 //Verificamos si hay basura		  
		         if(peso.toString().trim().equals("&&&&&&&"))
		         {
		        	 //txtPeso.setValue(" ");
		        	 pesoGlobal = "";
		         }

		        	 
	             //txtLote.setValue(peso.replace('.',',').trim());
	             medida = trama.substring(9, 11);
	             estable = trama.substring(11, 12);
	             System.out.println(trama); // Read one line and output it
	             System.out.println(trama.length());
	             System.out.println(peso);
	             System.out.println(medida);
	             System.out.println(estable);  ///"M" en movimiento, "Z" en cero, " " generalmente estable
	            // System.out.print("**'\n");	             
	           }

	           
		       //Peso neto
		       //////////vpesoneto = (Double.valueOf(peso.trim()) - pesogabetas);
	           if(contador >= 5)
	           {
	        	   bandera = 0;
	        	   
	        	   //Cacular peso de gabetas
	        	   //pesogabetas = ((Integer.valueOf(txtGaveta.getText().trim())) * 2.2);
	        	   
	        	     System.out.println("Asignando Peso");	        	   
		   			 //Si hay peso retenido, entonces calculamos la diferencia
	        	        
				         if(peso.toString().trim().equals("0.0"))
				         {
				        	 //txtPeso.setValue("0.0");
				        	 pesoGlobal="0.0";
				         }
				         else
					          {

				        	 //txtPeso.setValue(peso.trim());
				        	 pesoGlobal=peso.trim();
			
					        	 //Peso neto
					        	 //vpesoneto = (Double.valueOf(peso) - pesogabetas);
				        	 	vpesoneto = (Double.valueOf(peso));
			
					             //double d = 1.234567;
					             df = new DecimalFormat("#####.##");
					             System.out.print(df.format(vpesoneto));
					             
					        	 //Verifica si el peso no es negativo
					             //txtPeso.setValue(String.valueOf(df.format(vpesoneto)).replace(',','.').trim());	
					             pesoGlobal = String.valueOf(df.format(vpesoneto)).replace(',','.').trim();
					          }
			         		         
				         
			         bandera = 0; 
			         in.close();
			         /////////break; 
	           }
	           //////////////btnPeso.setDisabled(false);
        }
	    in.close();
	    bandera = 0; 

	      }
	      catch(Exception e) {
	    	  
	    	  //e.printStackTrace();
	    	  System.out.println("Exepcion.!");
	    	  Sistema.mensaje("No se puede obtener un peso valido");
	    	  //Verificamos si hay basura		  
	          if(peso.toString().trim().equals("&&&&&&&"))
	          {
	        	 // txtPeso.setValue(" ");
	        	  pesoGlobal="";
	        	  
	          }
		         else
		         {
			         if(peso.toString().trim().equals("0.0"))
			         {
			        	 //txtPeso.setValue("0.0");
			        	 pesoGlobal = "0.0";
			         }
		         }
	          
	    	  bandera = 0;
	          //System.out.print("Whoops! It didn't work!\n");
	          //peso = "";
	    	  try {
				in.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
	      }
		
	}
	
	
	public void capturarPeso()
	{
		//Sistema.mensaje("Debo capturar Peso");
		
		//Verifica si el ingreso manual no esta activado
		//Obtenemos el parametro para Habilitar o no el ingreso manual de peso en desperdicio
//		parametro = new ParametroDAOJpaImpl().getParametroById("1");
//		
//		if(parametro.getPermiso().equals("S"))
//		{
//			Sistema.mensaje("Opción no disponible mientras este activado el ingreso manual de peso");
//			return;
//		}		
		
		
		//CapturarPeso cp =  new CapturarPeso();
		////////////////////////btnPeso.setDisabled(true);
		//Activamos la bandera 
		Integer bandera=1;
		Integer contador = 0;
		 
		pesoneto = 0.00;
		//txtPeso.setValue("");
		pesoGlobal = "";
		//BufferedReader in = null;
	    
		String peso = "";
		try {
			//////Socket skt = new Socket("192.198.20.81", 10001); //selecciono direccion y puerto del servidor
//	        skt = new Socket("192.198.20.239", 10001);
	        skt = new Socket("192.198.20.144", 10001);
			skt.setSoTimeout(1000); //tiempo de espera de respuesta
	        String trama = "";
	        
	        String medida = "";
	        String estable = "";
	        
	        //BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        
	        
	        bandera=1;
           // while(true && contador <= 10){
	        while(true && bandera ==1 ){ 	
	        
	        contador = contador + 1;	        
	        //btnPeso.setDisabled(true);
            
             try{
           	  
           	  System.out.println(skt.isConnected());
             }
             catch(Exception e){
           	  System.out.println(e.toString()); 
             }
             
              for(;;){
           	 if(in.ready()) //espera trama en buffer
           	   break;
           	 if(skt.isConnected())  ///consulta equipo conectado (puerto abierto)
           	   break;
           	 else{
           	   in.close();
           	   System.out.print("cierro socket'");
           	   //btnPeso.setDisabled(false);
           	 }
              }
               System.out.print("Contador = "+ contador.toString());
	           System.out.print("salida'");
	           trama = in.readLine();
	           
	           //verifico trama correcta
	           if(trama.length()>11)
	           { 
	             peso = trama.substring(1, 9);
	             System.out.println(peso.replace('.',',').trim());
	             
		    	 //Verificamos si hay basura		  
		         if(peso.toString().trim().equals("&&&&&&&"))
		         {
		        	 //txtPeso.setValue(" ");
		        	 pesoGlobal = "";
		        	  
		         }
		        	 
	             //txtLote.setValue(peso.replace('.',',').trim());
	             medida = trama.substring(9, 11);
	             estable = trama.substring(11, 12);
	             System.out.println(trama); // Read one line and output it
	             System.out.println(trama.length());
	             System.out.println(peso);
	             System.out.println(medida);
	             System.out.println(estable);  ///"M" en movimiento, "Z" en cero, " " generalmente estable
	            // System.out.print("**'\n");	             
	           }

	           
		       //Peso neto
		       //////////vpesoneto = (Double.valueOf(peso.trim()) - pesogabetas);
	           if(contador >= 200)
	           {
	        	   //Asignamos el peso neto
		        	  pesoneto = (Double.valueOf(peso) );
	        	   
	        	   //double d = 1.234567;
		             df = new DecimalFormat("#####.##");
		             System.out.print(df.format(peso));
		             
		        	 //Verifica si el peso no es negativo
		             //txtPeso.setValue(String.valueOf(df.format(pesoneto)).replace(',','.').trim());
		             pesoGlobal = String.valueOf(df.format(pesoneto)).replace(',','.').trim();

			         in.close();
			         /////////break; 
	           }
	           //////////////btnPeso.setDisabled(false);
        }
	          in.close();
	 

	      }
	      catch(Exception e) {
	    	  
	    	  //e.printStackTrace();
	    	  System.out.println("Exepcion.!");
	    	  Sistema.mensaje("No se puede obtener un peso valido");
	    	  //Verificamos si hay basura		  
	          if(peso.toString().trim().equals("&&&&&&&"))
	          {
	        	  //txtPeso.setValue(" ");
	        	  pesoGlobal = "";
	        	  
	          }
		         else
		         {
			         if(peso.toString().trim().equals("0.0"))
			         {
			        	 //txtPeso.setValue("0.0");
			        	 pesoGlobal = "0.0";
			         }
		         }
	          
	    	 // bandera = 0;
	          //System.out.print("Whoops! It didn't work!\n");
	          //peso = "";
	    	  try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     }
	}


	public void onClick$btnGrabar() throws InterruptedException, IOException
	{
		if (txtCoche.getValue()==null||txtCoche.getValue().trim().equals("")) {
			Sistema.mensaje("Debe ingresar un numero de coche");
			return;
		}
		  //asginacion peso de prueba
		  //pesoGlobal="1.23";
		  valorCocheCodigoBarra = "";
			 valorCocheCodigoBarra = txtCoche.getValue().trim();
			 
			 System.out.println("**********valor de coche Ingresado ->"+valorCocheCodigoBarra);
		
		grabar();
	}
	
	public void grabar() throws InterruptedException, IOException
	{
		
       //lbxArea.getSelectedIndex() == 0
		//System.out.println("coccionProceso-->"+duchaRociado.getDescripcion());
		//System.out.println("rociadoProceso-->"+cuartochillroom.getDescripcion());
		
		if (duchaRociado == null && cuartochillroom ==null)
		{
			Sistema.mensajeError("Seleccione un Cuarto Chillroom o Ducha Rociado)"); //Area
			return;
			
		}
		else
			{
			
			
//				//BUSCAR COCHE//
//				if (lbxTurnoLabor.getSelectedIndex() == 0)
//				{
//					Sistema.mensajeError("Seleccion turno de producción");
//					lbxTurnoLabor.setFocus(true);
//				}
//	
//				if (lbxArea.getSelectedIndex() == 0)
//				{
//					Sistema.mensajeError("Seleccione Area (Cocción/Rociado)");
//					lbxArea.setFocus(true);
//				}	
//				
//				
//				if (txtCoche.getValue().isEmpty())
//				{
//					Sistema.mensajeError("Ingrese número de coche");
//					txtCoche.setFocus(true);
//				}		
//	
//				
//				if(lbxArea.getSelectedIndex() == 1)
//				{
//					buscaCocheCoccion();					
//					
//					
//					txtPeso.setFocus(true);			
//				}
//				else
//				{
//					buscaCocheRocioado();
//					txtPeso.setFocus(true);
//				}
//				//FIN BUSCAR COCHE//
			
			
//			if (txtCoche.getValue()==null || txtCoche.getValue().equals("")) {
//				Sistema.mensaje("Debe ingresar un registro de coche");
//				return;
//			}
			
				evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoDetalleProcesoCocheByCodBarra(Long.valueOf(valorCocheCodigoBarra));
				if(evisceradoDetalleProcesoCoche!=null){
					if(evisceradoDetalleProcesoCoche.getIdcocheprincipal()!=null){
						listEdpc = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getListaEvisceradoDetalleProcesoCocheByCodBarra(evisceradoDetalleProcesoCoche.getIdcocheprincipal());
					}else{
						listEdpc = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getListaEvisceradoDetalleProcesoCocheByCodBarra(evisceradoDetalleProcesoCoche.getIdevisceradodetalleprocesocoche());
					}
				}
				
				if (evisceradoDetalleProcesoCoche==null){
					Sistema.mensaje("coche no existe");
					return;
				}
			
			
				//GRABAR//
				if (duchaRociado!=null)  //lbxArea.getSelectedIndex() == 1 coccion
				{
					if (valorCocheCodigoBarra.equals("")) {
						 
						//txtPeso.setValue("");
						pesoGlobal="";
						Sistema.mensaje("no existe un número de coche para buscar");
						return;
					}
					
					
					int res = buscaCocheCoccion("G");					
					//Verifica si existio un problema al buscar el coche// 
					if(res ==1)
					{
						return;
					}
					
					grabarRociado();			
				}
				//else
				if(cuartochillroom != null)
				{
					
					if (valorCocheCodigoBarra.equals("")) {
						//txtPeso.setValue("");
						pesoGlobal="";
						Sistema.mensaje("no existe un número de coche para buscar");
						return;
					}
					
					int res = buscaCocheRocioado("G");
					//Verifica si existio un problema al buscar el coche// 
					if(res ==1)
					{
						return;
					}
					
					grabarChillRoom();			
				}
				//FIN GRABAR//
			}
		

		String dato;
		dato = txtTemperatura.getText();

		onClick$btnLimpiarCoche();
		onClick$btnLimpiarCoche();
		
		
		if (bandera2 == 0)
		{
			txtTemperatura.setText(dato);			
		}
			

		
	}
	
	
	public void grabarRociado() throws InterruptedException, IOException{
		
		CoccionDetalleProcesoCocheDAOJpaImpl coccionDetalleProcesoCocheImpl = new CoccionDetalleProcesoCocheDAOJpaImpl();
		CoccionDetalleProcesoCoche coccionDetalleProcesoCoche = new CoccionDetalleProcesoCoche();
		
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);

		
		if (turnoLabor == null) {
			Sistema.mensaje("Debe de Seleccionar un Turno Labor de la lista");
			return;
		}
		
//		if (txtCoche.getValue().isEmpty())
//		{
//			Sistema.mensaje("Ingrese un coche valido");
//			txtCoche.setFocus(true);
//			return;
//		}	
		
		if (valorCocheCodigoBarra.isEmpty())
		{
			Sistema.mensaje("Ingrese un coche valido");
			txtCoche.setFocus(true);
			return;
		}	
		
		
		if (produccion == null) {
			Sistema.mensaje("Ingrese un coche valido");
			txtCoche.setFocus(true);
			return;
		}
		

			
		
		
		if (duchaRociado == null) {
			Sistema.mensaje("Debe de Seleccionar una ducha de la lista");
			return;
		}
		
		
		
		
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
/*		lista=new CoccionDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche(Long.valueOf(valorCocheCodigoBarra));*/
		lista=new CoccionDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche2(evisceradoDetalleProcesoCoche.getIdevisceradodetalleprocesocoche());
		if (lista.size()>0){
			Sistema.mensaje("coche ya registrado");
			return;
		}
		TomarPeso();
/*		pesoGlobal="25.1";*/
		if (pesoGlobal.isEmpty()) { //(txtPeso.getText()
			//txtPeso.setValue(null);
			pesoGlobal ="";
			Sistema.mensaje("coche ya registrado"+" "+ valorCocheCodigoBarra);
			//txtPeso.setFocus(true);
			return;
		}
		
		 
		
		if (Double.valueOf(pesoGlobal) <= 0.0) { //Double.valueOf(txtPeso.getText()) 	 
			//txtPeso.setValue(null);
			pesoGlobal="";
			Sistema.mensaje("El peso obtenido es igual a Cero.. ");
			//txtPeso.setFocus(true);
			return;
		}	
		
		for (EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche : listEdpc) 
		{

			double todasCanastilla=calcularTotalCanastilla();
			double canastillas = evisceradoDetalleProcesoCoche.getCanastillas();
			
			coccionDetalleProcesoCoche.setCoccionProceso(coccionProceso); //setear idcoccion
			coccionDetalleProcesoCoche.setEvisceradoDetalleProcesoCoche(evisceradoDetalleProcesoCoche);

			
			usuario = (String)Sessions.getCurrent().getAttribute("usuario");
			Usuario u = new Usuario();
			if (usuario==null) {
				usuario="aaguirre";
			}
			u.setIdusuario(usuario);		
			coccionDetalleProcesoCoche.setIdusuario(usuario);
			coccionDetalleProcesoCoche.setFechareg(new java.sql.Timestamp(new Date().getTime())); 
			coccionDetalleProcesoCoche.setDucharociadoBean(duchaRociado);
			coccionDetalleProcesoCoche.setTurno(turnoLabor);
/*			coccionDetalleProcesoCoche.setPeso(Double.valueOf(pesoGlobal.trim()));*/
			coccionDetalleProcesoCoche.setPeso(calcularPeso(canastillas,todasCanastilla));
			
			coccionDetalleProcesoCocheImpl.guardarCoccionProcesoCoche(coccionDetalleProcesoCoche);
		}
		System.out.println("Transaccion grabada");

		
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA+" "+valorCocheCodigoBarra);
		
		txtCoche.setValue(null);
		cargarLimpiarControles();
		onClick$btnLimpiarCoche();
		txtCoche.focus();
		txtCoche.setFocus(true);
		
		
	}
	
	public boolean comprobarCocheRociado(){
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
		lista=new CoccionDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche(Long.valueOf(valorCocheCodigoBarra));
		if (lista.size()>0){
//			Sistema.mensaje("coche ya registrado");
			return false;
		}else{
			return true;
		}
	}

	public double calcularTotalCanastilla(){
    	double totalCanastilla=0;
    		
    	for (EvisceradoDetalleProcesoCoche itemEviscerado : listEdpc) {
    		
    		totalCanastilla=totalCanastilla+itemEviscerado.getCanastillas();
		}
    	return totalCanastilla;
    }
	
    public double calcularPeso(double canastilla,double totcana){
    	
    	Double pesito;
    	
    	try {
			pesito = Double.valueOf(pesoGlobal.trim());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return 0.0;
		}
    	
/*    	if ((!txtPeso.getValue().equals(""))){*/
       	if ((!pesito.equals("")))
       	{
    		
/*    		double valorTara= ((canastilla* Double.valueOf(txtPeso.getValue()))/totcana);*/
    		double valorTara= ((canastilla* pesito)/totcana);
    		valorTara = Math.round(valorTara*1e2)/1e2;
    		return valorTara;
    	}
       	else
       	{
    		return 0.0;
    	}
    }

	
	public void cargarLimpiarControles(){
//		txtCoche.setValue(""); 
//		txtNumCoche.setValue("");
//		txtCocheLote.setValue("");
//		txtLote.setValue("");
//		txtCocina.setValue("");
//		txtCanastillas.setValue("");
//		txtPescadoLata.setValue("");
//		txtFechaActiva.setValue(null); 
//		txtTurnoProduccion.setValue(null);
		
		//txtPeso.setValue("");
		pesoGlobal="";
		
//		if (lbxArea.getSelectedIndex()==1) 
//		{
//			//cargarListaRociado();
//			lblDuchaRociado.setValue("Ducha Rociado");
//		}
//		//Rociado -> Chill Romm
//		else
//			{
//				//cargarListaCuarto();
//				lblDuchaRociado.setValue("Cuarto ChillRoom");
//			}		
		
		
		produccion = null;
	}

	


	public void grabarChillRoom() throws InterruptedException, IOException
	{
		
		bandera2 = 0;
		
		RociadoDetalleProcesoCoche rociadoDetalleProcesoCoche = new RociadoDetalleProcesoCoche();
		RociadoDetalleProcesoCocheDAOJpaImpl rociadoDetalleProcesoCocheImpl = new RociadoDetalleProcesoCocheDAOJpaImpl();

		String usuario = "";
		
		if (turnoLabor == null) {
			Sistema.mensaje("Debe de Seleccionar un Turno de la lista");
			return;
		}
		
//		if (txtCoche.getValue().isEmpty())
//		{
//			Sistema.mensaje("Ingrese un coche valido");
//			txtCoche.setFocus(true);
//			return;
//		}	
		
		
		if (valorCocheCodigoBarra.isEmpty())
		{
			Sistema.mensaje("Ingrese un coche valido");
			txtCoche.setFocus(true);
			return;
		}	
		
		if (produccion == null) {
			Sistema.mensaje("Debe de Seleccionar la fecha de la lista");
			return;
		}
		

		
		
 		
					
		if (cuartochillroom == null) {
			Sistema.mensaje("Debe seleccionar un cuarto de la lista");
			return;
		}
		
//		if (evisceradoDetalleProcesoCoche==null){
//			evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoDetalleProcesoCocheByCodBarra(Long.valueOf(valorCocheCodigoBarra));
//				if (evisceradoDetalleProcesoCoche==null){
//					Sistema.mensaje("coche no existe");
//					return;
//				}
//		}
		
		List<EvisceradoDetalleProcesoCoche> lista = new ArrayList<EvisceradoDetalleProcesoCoche>();
//		lista=new CoccionDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche(Long.valueOf(valorCocheCodigoBarra));

/*		lista = new RociadoDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche(Long.valueOf(valorCocheCodigoBarra));*/

		lista = new RociadoDetalleProcesoCocheDAOJpaImpl().ListarRociadoDetalleProcesoCoche2(evisceradoDetalleProcesoCoche.getIdevisceradodetalleprocesocoche());

		
		if (lista.size()>0){
			Sistema.mensaje("coche ya registrado"+" "+ valorCocheCodigoBarra);
			return;
		}
		//TODO
		TomarPeso();
		
/*		pesoGlobal="25.1";*/
		if (pesoGlobal.isEmpty()) { //(txtPeso.getText()
			//txtPeso.setValue(null);
			pesoGlobal ="";
			Sistema.mensaje("No se ha obtenido un peso de la balanza"); // Debe registrar un peso
			//txtPeso.setFocus(true);
			return;
		}
		
		
		System.out.println("pesoGlobal :"+pesoGlobal);
		
		try {
			
			Double salida = Double.valueOf(pesoGlobal);
			
			if (Double.valueOf(pesoGlobal) <= 0.0) 
			{ //Double.valueOf(txtPeso.getText()) 	 
				//txtPeso.setValue(null);
				pesoGlobal="";
				Sistema.mensaje("El peso obtenido es igual a Cero..");
				//txtPeso.setFocus(true);
				return;
			}			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}
		

		Long vproduccion = null;
		String vlote = "";	
		for (EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche : listEdpc) 
		{
			vlote = evisceradoDetalleProcesoCoche.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getIdlote().toString();
			vproduccion = evisceradoDetalleProcesoCoche.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getProduccion().getIdproduccion();
			////////////////////
			//txtTemperatura//
			///////////////////
			//Verifica si el objeto esta vacio
			if(txtTemperatura.getText().toString().isEmpty() == false) 
			{
				//Valor Cuantitativo que se registrara en la tabla de incidencias
				rociadoDetalleProcesoCoche.setTemperatura(Double.valueOf(txtTemperatura.getText().toString().replace(',', '.')));
				
			}
			
			
			
			
			double todasCanastilla=calcularTotalCanastilla();
			double canastillas = evisceradoDetalleProcesoCoche.getCanastillas();
			
			rociadoDetalleProcesoCoche.setRociadoProceso(rociadoProceso);

			usuario = (String)Sessions.getCurrent().getAttribute("usuario");
			Usuario u = new Usuario();
			if (usuario==null) {
				usuario="aaguirre";
			}
			u.setIdusuario(usuario);		
			rociadoDetalleProcesoCoche.setUsuario(u);
			
			rociadoDetalleProcesoCoche.setEvisceradoDetalleProcesoCoche(evisceradoDetalleProcesoCoche);
/*			rociadoDetalleProcesoCoche.setPeso(Double.valueOf(pesoGlobal.trim())); // txtPeso.getValue()*/
			rociadoDetalleProcesoCoche.setPeso(calcularPeso(canastillas,todasCanastilla));
			
			rociadoDetalleProcesoCoche.setFechareg(new java.sql.Timestamp(new Date().getTime())); // Es la fecha actual?
			rociadoDetalleProcesoCoche.setCuartochillroom(cuartochillroom);
			rociadoDetalleProcesoCoche.setTurno(turnoLabor);
			
			usuario = (String)Sessions.getCurrent().getAttribute("usuario");
			System.out.println("valor de variable usuario-->"+usuario);
			
	//		//validaciones 
	//		if (usuario==null || usuario.equals("")) {
	//			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
	//			return;
	//		}
			
			if (usuario==null) {
				usuario="aaguirre";
			}
			
			rociadoDetalleProcesoCoche.setUsuario(new UsuarioDAOJpaImpl().getUser(usuario));
			
	//		Usuario u = new Usuario();
	//		u.setIdusuario(usuario);		
	//		rociadoDetalleProcesoCoche.setUsuario(u);		
			
			rociadoDetalleProcesoCocheImpl.guardarRociadoDetalleProcesoCoche(rociadoDetalleProcesoCoche);
		}
		
		System.out.println("Transaccion grabada");
		
		
		
		if(comprobarCocheRociado())
		{
			Sistema.mensaje("Coche Registrado, Verificar Coche "+valorCocheCodigoBarra);			
		}
		else
		{
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA+" "+valorCocheCodigoBarra);
			bandera2 = 1;
		}
		
		cargaListaFechaProduccionActiva(vproduccion);		
		
		txtCoche.setValue(null);
		cargarLimpiarControles();
		onClick$btnLimpiarCoche();

		
		txtCoche.focus();
		txtCoche.setFocus(true);

		txtLoteu.setValue(vlote);
		onClick$btnBuscar();
		
	}	
}
