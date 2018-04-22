package com.nw.webui.produccion;

import org.zkoss.zul.Checkbox;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.api.Label;
//import com.nw.model.BarcoCuba;
import com.nw.model.BarcoDescarga;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.BarcoEstibaCubaDetalleMezcla;
import com.nw.model.Cajon;
import com.nw.model.Camara;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.EspecieTalla;
import com.nw.model.TipoCaptura;
import com.nw.model.Turno;
import com.nw.model.Usuario;
//import com.nw.model.dao.impl.BarcoCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoEstibaCubaDAOJpaImpl;
import com.nw.model.dao.impl.BarcoEstibaCubaDetalleMezclaDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonUbicacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraDAOJpaImpl;
import com.nw.model.dao.impl.CamaraFilaColumnaDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;
import com.nw.util.Sistema;


public class CamaraCajonBarcoDescargaMantenimientoMesclaWindow extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	
	//Objetos zul
	Listbox lbxBarcoDescarga,lbxCajones,lbxCuba,lbxTipoCaptura,
	lbxCuba2, lbxCuba3, lbxCuba4, lbxCuba5, lbxCuba6, lbxProposito;   // lbxTurno
	Toolbarbutton btnGrabar,btnBuscarBarco,btnBuscarEspecieTalla;
	Datebox dteFecInicio,dteFecFin;
	Label lbInfoCajon,lbInfoEspecieTallaAnterior,lbInfoEspecieTallaActual;
	Textbox txtCajon,txtPesoNeto,txtTara,txtTicket,txtLoteCajonSap,txtEspecieTalla,txtZonaFao, txtLoteCamara, txtHaccp;
	
	Row r1, r2, r3, r4, r5, r6;
	
	Textbox txtPesoNetod;
	Doublebox dbbxPesoBrutod;
	private Checkbox ChkNuevoCajon;
	
    Doublebox dbbxPesoBruto;	
    Listbox lbxCamaras,lbxFilas,lbxColumnas, lbxCajonesDisponibles;
	
    
	//Objetos
	CamaraCajon camaraCajon = null;
	BarcoDescarga barcoDescarga = null;
	
	BarcoEstibaCuba barcoEstibaCuba = null;
	BarcoEstibaCuba barcoEstibaCuba2 = null;
	BarcoEstibaCuba barcoEstibaCuba3 = null;
	BarcoEstibaCuba barcoEstibaCuba4 = null;
	BarcoEstibaCuba barcoEstibaCuba5 = null;
	BarcoEstibaCuba barcoEstibaCuba6 = null;
	
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
		dteFecInicio.setValue(new Date());
		dteFecFin.setValue(new Date());
		cargarTurnos();
		cargarTiposCapturas();
		cargarListaCamaras();
		dteFecInicio.setFocus(true);
	}

	
	/********************************  Metodos vista ***********************************************/
	
	public void onClick$btnBuscarBarco(){
		
		txtTicket.setReadonly(false);
		txtLoteCajonSap.setReadonly(false);	
		//llamar al metodo que llena la lista de los barcos en barco_descarga
		
//		String f1;
//		f1 = dteFecInicio.getAreaText().trim() + " 00:00:00.000";
//		String f2;
//		f2 = dteFecFin.getAreaText().trim() + " 23:59:59.999";
		limpiarControlesSinCajon();
		txtCajon.setValue(null);
		lbxCajonesDisponibles.getItems().clear();
		camaraCajon = null;
		
		barcosDescargas = new ArrayList<BarcoDescarga>();
		barcosDescargas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getBarcoDescargaPorFechaDescarga(dteFecInicio.getValue(),  getAumentarUnDiaAFecha(dteFecFin.getValue()));
		 //lleno el listbox de barco descarga
		cargarBarcosDescargaPorFecha(barcosDescargas);
		
	}
	
	public void onSelect$lbxBarcoDescarga()
	{
		limpiarControlesSinCajon();
		txtCajon.setValue(null);
		lbxCajonesDisponibles.getItems().clear();
		camaraCajon = null;
		
		 seleccionarBarcoDescarga();
	}
	
	public void onSelect$lbxCuba(){
		 seleccionarBarcoEstibaCuba();
	}

	public void onSelect$lbxCuba2(){
		 seleccionarBarcoEstibaCuba2();
	}
	
	public void onSelect$lbxCuba3(){
		 seleccionarBarcoEstibaCuba3();
	}	
	
	public void onSelect$lbxCuba4(){
		 seleccionarBarcoEstibaCuba4();
	}	

	public void onSelect$lbxCuba5(){
		 seleccionarBarcoEstibaCuba5();
	}	

	public void onSelect$lbxCuba6(){
		 seleccionarBarcoEstibaCuba6();
	}	
	
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
	
	
	public void onClick$btnGrabar(){
		guardarEditar();
		txtTicket.setReadonly(false);
		txtLoteCajonSap.setReadonly(false);		
	}
	
	public void onChanging$dbbxPesoBruto(InputEvent event){
		 //System.out.println("valor peso bruto es -->"+event.getValue());
		 String valor = "";
		 valor = event.getValue();
		 peso = 0.00;
		 peso = Sistema.parseDouble(valor);
		 recalcularPesoNeto(peso);
		
	}

	public void onChanging$dbbxPesoBrutod(InputEvent event){
		 //System.out.println("valor peso bruto es -->"+event.getValue());
		 String valor = "";
		 valor = event.getValue();
		 pesod = 0.00;
		 pesod = Sistema.parseDouble(valor);
		 
			if (pesod < 0)
			{
				txtPesoNetod.setText("");
			}
			else
			{

				recalcularPesoNetod(pesod);	
			}

		

				
		 
	}	

	
	public void onSelect$lbxCajonesDisponibles()
	{
		txtTara.setValue(null);
		limpiarControlesSinCajon();
		
		if (lbxCajonesDisponibles.getSelectedIndex() > 0)		
		{
			//Crear nuevo cajón
			if (lbxCajonesDisponibles.getSelectedIndex() == 1)		
			{
				 camaraCajon = new CamaraCajon();
				 txtTara.setValue(String.valueOf(cajonconsultado.getTara()));
				 //el cajon se encuentra registrado			
				 String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
				
//				 txtTicket.setReadonly(true);
//				 txtLoteCajonSap.setReadonly(true);
//				
//				 txtTicket.setValue("1");
//				 txtLoteCajonSap.setValue("1");
				
				if (usuario==null || usuario.equals("")) 
				{
					Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
					return;
				}
				

				cargarListadoCubasBarcos(barcosEstibaCubas);
				cargarListadoCubasBarcos2(barcosEstibaCubas);
				cargarListadoCubasBarcos3(barcosEstibaCubas);
				cargarListadoCubasBarcos4(barcosEstibaCubas);
				cargarListadoCubasBarcos5(barcosEstibaCubas);
				cargarListadoCubasBarcos6(barcosEstibaCubas);

				r2.setVisible(true);
				r3.setVisible(true);
				r4.setVisible(true);
				r5.setVisible(true);
				r6.setVisible(true);				
				
				
			}
			else
			{
				//Toma los datos de un cajón existente
				CargarDatosCajon();	
			}
		}	
	}
	
	
	public void CargarDatosCajon()
	{
		 camaraCajon = new CamaraCajon();
		 camaraCajon = (CamaraCajon) lbxCajonesDisponibles.getSelectedItem().getValue();
		 
		 //camaraCajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCamaraCajonPorBarcoDescargaUnico(barcoDescarga, cajonconsultado.getIdcajon());
		System.out.println("Cajon selecconado :"+camaraCajon.getCajon().getIdcajon());
		//el cajon se encuentra registrado			
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		//System.out.println("valor de variable usuario-->"+usuario);
		
		if (usuario==null || usuario.equals("")) 
		{
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
		}
	
		camaraCajon.setFechaactualizacion(new Timestamp(new Date().getTime()));
		
		//System.out.println("idcamaracajon->"+camaraCajon.getIdcamaracajon());
		
		

		
	 	/////////////////////
	 	// MEZCLA DE CUBAS //
	 	/////////////////////
		barcoEstibaCuba = null;
		barcoEstibaCuba2 = null;
		barcoEstibaCuba3 = null;
		barcoEstibaCuba4 = null;
		barcoEstibaCuba5 = null;
		barcoEstibaCuba6 = null;
		
		r2.setVisible(true);
		r3.setVisible(true);
		r4.setVisible(true);
		r5.setVisible(true);
		r6.setVisible(true);
		

		cargarListadoCubasBarcos(barcosEstibaCubas);
		cargarListadoCubasBarcos2(barcosEstibaCubas);
		cargarListadoCubasBarcos3(barcosEstibaCubas);
		cargarListadoCubasBarcos4(barcosEstibaCubas);
		cargarListadoCubasBarcos5(barcosEstibaCubas);
		cargarListadoCubasBarcos6(barcosEstibaCubas);				
		
			String cubas ="";
			int i = 0; 
			/* Inicio Requerimiento Mezcla Cubas*/
//			if (camaraCajon.getBarcoEstibaCuba() == null)
//			{
				
				
				
				r2.setVisible(true);
				r3.setVisible(true);
				r4.setVisible(true);
				r5.setVisible(true);
				r6.setVisible(true);


				
				List <BarcoEstibaCubaDetalleMezcla> lis = new BarcoEstibaCubaDAOJpaImpl().getListBarcoEstibaCubasDetalleMezcaxIdCamaraCajon(camaraCajon.getIdcamaracajon());
				
				
				if (lis.size()>0)
				{
					for (BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla : lis) 
					{
						i++;
						if(i == 1)
						{
							System.out.println("barcoEstibaCubaDetalleMezcla.getCamaraCajon() :"+barcoEstibaCubaDetalleMezcla.getCamaraCajon().getIdcamaracajon());
							//cubas = cubas + " - ";
							posicionarCuba(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());
						}
						
						if(i == 2)
						{
							//cubas = cubas + " - ";
							posicionarCuba2(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());

						}
						
						if(i == 3)
						{
							//cubas = cubas + " - ";
							posicionarCuba3(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());
							r3.setVisible(true);
						}

						
						if(i == 4)
						{
							//cubas = cubas + " - ";
							posicionarCuba4(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());

						}
						
						
						if(i == 5)
						{
							//cubas = cubas + " - ";
							posicionarCuba5(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());
						}
						
						
						if(i == 6)
						{
							//cubas = cubas + " - ";
							posicionarCuba6(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba());
							
						}
						
						
//						cubas = cubas + new BarcoCubaDAOJpaImpl().getFindBarcobyId(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba().getIdbarcocuba()).getCuba().getNombrecuba();
//						txtCubaInfo.setValue(cubas); 
								
						//new BarcoCubaDAOJpaImpl().getFindBarcobyId(barcoEstibaCubaDetalleMezcla.getBarcoEstibaCuba().getIdbarcocuba()).getCuba().getNombrecuba());
					}
				}
				else
				{
					//txtCubaInfo.setValue(null);
					barcoEstibaCuba = null;
					lbxCuba.setSelectedIndex(0);
					
					if (camaraCajon.getBarcoEstibaCuba() != null)
					{
							//cubas = cubas + " - ";
						posicionarCuba(camaraCajon.getBarcoEstibaCuba());
					}
					
				}
//			}
//			else
//			{
//				
//				
//				//Llenamos solo una lista de cubas (barco sin mezcla)
//				posicionarUnaCuba();
////				BarcoCuba bc = new BarcoCuba();
////				bc = new BarcoCubaDAOJpaImpl().getFindBarcoCubaIdLong(camaraCajon.getBarcoEstibaCuba().getIdbarcocuba());
////				txtCubaInfo.setValue(bc.getCuba().getNombrecuba());
//			}
			
			
			
			txtLoteCamara.setValue(camaraCajon.getLotecamara());
			txtHaccp.setValue(camaraCajon.getLotehaccp());
			
	 	/////////////////////////
	 	// FIN MEZCLA DE CUBAS //
	 	/////////////////////////		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		posicionarTipoCaptura();
		
		//onSelect$lbxColumnas();

		//asginar los demas valores de camara_cajon
		txtPesoNeto.setValue(camaraCajon.getPesoneto()+"");		
		txtTara.setValue(camaraCajon.getTara()+"");
		txtTicket.setValue(camaraCajon.getTicket());
		lbInfoCajon.setValue(camaraCajon.getCajon().getIdcajon());
		dbbxPesoBruto.setValue(camaraCajon.getPesobruto());
		txtLoteCajonSap.setValue(camaraCajon.getLotecajonsap());
		txtEspecieTalla.setValue(camaraCajon.getEspecieTalla().getIdespecietalla()+"");
		txtZonaFao.setValue(camaraCajon.getZonafao());
		
		if (camaraCajon.getProposito() == null)
		{
			lbxProposito.setSelectedIndex(1);
		}
		else
		{
			if (camaraCajon.getProposito().equals("N/A") || camaraCajon.getProposito().isEmpty())
			{
				lbxProposito.setSelectedIndex(1);
			}
			else
			{
				if (camaraCajon.getProposito().equals("SIMPLE"))
				{
					lbxProposito.setSelectedIndex(2);
				}
				else
				{
					//DOBLE
					lbxProposito.setSelectedIndex(3);
				}
			}
		}
			
			
		
		
		lbInfoEspecieTallaActual.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());		
		lbInfoEspecieTallaAnterior.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre()+" "+camaraCajon.getEspecieTalla().getTalla().getNombre());
		
		camaraFilaColumna = new CamaraFilaColumna();
		camaraFilaColumna = camaraCajon.getCamaraFilaColumna();
		
		posicionarCamara();
		onSelect$lbxCamaras();
		
		posicionarColumna();
		onSelect$lbxColumnas();
		
		
		//VER AQUI
			//cargarListaFilasCamara();
			posicionarFila();
			onSelect$lbxFilas();		
		
	}
	
	
	
//	public void onChanging$txtCajon(InputEvent event){
//		 System.out.println("valor es -->"+event.getValue());
//		 buscarRegistroCamaraCajon();
//	}
	

	/********************************  Metodos Negocio ***********************************************/
	
	
	public void cargarBarcosDescargaPorFecha(List<BarcoDescarga> barcosDescargas){
		
		//llenar el listbox 
		// lbxBarcoDescarga
		
		lbxBarcoDescarga.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new CocinaAperturaCierreDetalle());
		li.setParent(lbxBarcoDescarga);
		
		for (BarcoDescarga bd : barcosDescargas) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell("("+ bd.getRegistro()+") " + "  " + bd.getBarco().getNombre()+" ").setParent(li); 
			li.setParent(lbxBarcoDescarga);		}
		lbxBarcoDescarga.setSelectedIndex(0);
	}
	
	public void seleccionarBarcoDescarga()
	{
		if (lbxBarcoDescarga.getSelectedIndex()>0) 
		{
			 
			 barcoDescarga = new BarcoDescarga();
			 barcoDescarga = (BarcoDescarga) lbxBarcoDescarga.getSelectedItem().getValue();
			 
				//aki debo cargar las cubas del barco aperturado con esto lleno la lista
				// pasos -> barco_estiba_cuba -> barco_cuba -> cuba
				barcosEstibaCubas = new ArrayList<BarcoEstibaCuba>();
				barcosEstibaCubas = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getBarcoEstibaCubaBarcoDescarga(barcoDescarga);
				
				
				
				cargarListadoCubasBarcos(barcosEstibaCubas);
				cargarListadoCubasBarcos2(barcosEstibaCubas);
				cargarListadoCubasBarcos3(barcosEstibaCubas);
				cargarListadoCubasBarcos4(barcosEstibaCubas);
				cargarListadoCubasBarcos5(barcosEstibaCubas);
				cargarListadoCubasBarcos6(barcosEstibaCubas);
				
				
			 
			 // esto ya no cargar los datos de la tabla camara_cajon en base al idbarcodescarga
			 // cargarInformacionCamaraCajon(barcoDescarga);
		}
		else
		{
			barcoDescarga = null;
		}
		
	}
	
	
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
	
		txtTicket.setReadonly(false);
		txtLoteCajonSap.setReadonly(false);
	
		String ca;
		ca =  txtCajon.getValue().trim();			 

		limpiarControlesSinCajon();
		lbxCajonesDisponibles.getItems().clear();

		//valido que exista informacion para la busqueda
		if (txtCajon.getValue()==null || txtCajon.getValue().equals("")) {
			Sistema.mensaje("Debe ingresar un numero de cajon");
			return;
		}
		
		if (barcoDescarga==null) {
			Sistema.mensaje("Debe seleccionar un Barco");
			return;
		}
		
		cajonconsultado = new Cajon();
		cajonconsultado = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
		if (cajonconsultado==null) {
			Sistema.mensaje("El cajón ingresado no es un cajon valido");
			return;
		}
		
		int res = 0;
		res = BuscarListaCajones();
		 
		 //if (camaraCajon==null)
		 //La Lista de Cajones esta vacia (No encontro ningún cajón)
		 if(res == 0)
		 {
			Sistema.mensaje("Asigne los demas valores para registrar el cajon");

			limpiarControlesSinCajon();			
			camaraCajon = new CamaraCajon();
			
			
			camaraCajon.setFechareg(new Timestamp(new Date().getTime()));
			txtTara.setValue(cajonconsultado.getTara()+"");
			
			txtCajon.setValue(ca);
			
			//nuevo cajón
			try {
				lbxCajonesDisponibles.setSelectedIndex(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			
			cargarListadoCubasBarcos(barcosEstibaCubas);
			cargarListadoCubasBarcos2(barcosEstibaCubas);
			cargarListadoCubasBarcos3(barcosEstibaCubas);
			cargarListadoCubasBarcos4(barcosEstibaCubas);
			cargarListadoCubasBarcos5(barcosEstibaCubas);
			cargarListadoCubasBarcos6(barcosEstibaCubas);

			r2.setVisible(true);
			r3.setVisible(true);
			r4.setVisible(true);
			r5.setVisible(true);
			r6.setVisible(true);			
			
			
			
		}

	}


	public int BuscarListaCajones(){
		txtTicket.setReadonly(false);
		txtLoteCajonSap.setReadonly(false);
		
		camaraCajones = new ArrayList<CamaraCajon>();
		//camaraCajones = new CajonDAOJpaImpl().getListadoCajones(txtCajon.getValue().trim());	 

		camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl(). getCamaraCajonRepetidosPorBarcoDescarga(barcoDescarga, cajonconsultado.getIdcajon());		
		 
		if (camaraCajones.size() == 0) {
			txtCajon.setValue(null);
			txtCajon.setFocus(true);
			//Sistema.mensaje("No existen cajones");
			return 0;
		}
		
		//System.out.println("TAMA====>"+String.valueOf(camaraCajones.size()));
		if (camaraCajones.size()>1) 
		{
			String mensaje = "Cajón :" +" "+camaraCajones.get(0).getCajon().getIdcajon()
					+" "+"repetido"+" "+camaraCajones.size()+" "+"veces.";
			
			Sistema.mensaje(mensaje + "");
		}
		
		lbxCajonesDisponibles.getItems().clear();
		
		//Item en blanco
		Listitem li = new Listitem();
		li.setValue(new CamaraCajon());
		li.setParent(lbxCajonesDisponibles);

		
		//Item Crear Nuevo cajón
		li = new Listitem();
		li.setValue(new CamaraCajon());
		new Listcell("CREAR NUEVO CAJÓN").setParent(li);
		li.setParent(lbxCajonesDisponibles);

		
		for (CamaraCajon camaraCajon : camaraCajones) {
			li = new Listitem();
			li.setValue(camaraCajon);
			String e = "Cajón "+camaraCajon.getCajon().getIdcajon()+" "+String.valueOf("Lote SAP "+camaraCajon.getLotecajonsap().toString())+" "+String.valueOf("P. Bruto "+camaraCajon.getPesobruto())+" "+String.valueOf("P. Neto "+camaraCajon.getPesoneto()+"  Estado "+camaraCajon.getEstado().toString());
			new Listcell(e).setParent(li);
			li.setParent(lbxCajonesDisponibles);
			
			
		}
		lbxCajonesDisponibles.setSelectedIndex(0);
		
		return 1;
		
	}

	

//		private static boolean isNumeric(String cadena){
//		  try {
//		         Integer.parseInt(cadena);
//		         return true;
//			  } catch (NumberFormatException nfe){
//			         return false;
//			  }
//		}
          

	
	public void guardarEditar()
	{
		
		if (barcoDescarga==null) 
		{
			Sistema.mensaje("No se ha escogido un registro de barco ");
			lbxBarcoDescarga.setFocus(true);
			return;
		}
		

		if (lbxCajonesDisponibles.getItems().size() > 0)
		{
			if (lbxCajonesDisponibles.getSelectedIndex() == 0)
			{
				Sistema.mensaje("Selecione cajón a modificar o cajón a crear de la lista de cajones disponibles ");
				lbxCajonesDisponibles.setFocus(true);
				return;
			}
		}		
		
		
		if (txtCajon.getValue()==null || txtCajon.getValue().equals("")) {
			Sistema.mensaje("No se ha ingresado un número de cajón..");
			txtCajon.setFocus(true);
			return;
		}		 
		
		

		if (lbxCuba.getSelectedIndex()==0 && lbxCuba2.getSelectedIndex()==0 && lbxCuba3.getSelectedIndex()==0 && lbxCuba4.getSelectedIndex()==0 && lbxCuba5.getSelectedIndex()==0 && lbxCuba6.getSelectedIndex()==0) 
		{
			Sistema.mensaje("No se ha escogido una cuba / mescla de cubas");
			lbxCuba.setFocus(true);
			return;
		}
		
		
		
//		if (lbxCuba.getSelectedIndex()==0) 
//		{
//			Sistema.mensaje("No se ha escogido una cuba ");
//			lbxCuba.setFocus(true);
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
			dbbxPesoBruto.setFocus(true);
			return;
		}
		
		Cajon cajon = new Cajon();
		cajon = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getCajonPorId(txtCajon.getValue().trim());
		if (cajon==null) {
			Sistema.mensaje("El cajón ingresado no es un cajon valido");
			return;
		}

		
		if (txtLoteCamara.getValue().isEmpty())
		{
			Sistema.mensaje("Debe ingresar el Lote Camara");
			txtLoteCamara.setFocus(true);
			return;
		}

		Integer lc, ban;
		ban = 0;
		
		
		try {
			lc = Integer.valueOf(txtLoteCamara.getValue());
		} catch (WrongValueException e) {
			// TODO Auto-generated catch block
			ban = 1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			ban = 1;
		}
		
		
		
		if (ban == 1)
		{
			Sistema.mensaje("Debe ingresar solo numeros en el Lote Camara");
			txtLoteCamara.setValue(null);
			txtLoteCamara.setFocus(true);
			return;
		}
		
		ban = 0;
		try {
			Integer.parseInt(txtLoteCamara.getValue().trim());
		} catch (WrongValueException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ban = 1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			ban = 1;
		}
		

		if (ban == 1)
		{
			Sistema.mensaje("Debe ingresar solo numeros enteros en el Lote Camara");
			txtLoteCamara.setValue(null);
			txtLoteCamara.setFocus(true);
			return;
		}
		
		
		
		if (txtHaccp.getValue().isEmpty())
		{
			Sistema.mensaje("Debe ingresar el Lote Hacc");
			txtHaccp.setFocus(true);
			return;
		}
		
		
		if (txtTicket.getValue().isEmpty())
		{
			Sistema.mensaje("Debe ingresar el Ticket");
			txtTicket.setFocus(true);
			return;
		}
		
		//VALIDAMOS QUE NO INGRESEN LETRAS EN EL TOKET Y LOTESAP
		boolean res = Sistema.isNumeric(txtTicket.getValue().trim());

		if (res == false)
		{
			Sistema.mensaje("El Ticket no puede tener letras ni espacios, ingrese solo números");
			txtTicket.setFocus(true);
			return;
		}		
		

		if (txtLoteCajonSap.getValue().isEmpty())
		{
			Sistema.mensaje("Debe ingresar el LoteSap");
			txtLoteCajonSap.setFocus(true);
			return;
		}		
		
		res = Sistema.isNumeric(txtLoteCajonSap.getValue().trim());
		
		if (res == false)
		{
			Sistema.mensaje("El LoteSap no puede tener letras ni espacios, ingrese solo números");
			txtLoteCajonSap.setFocus(true);
			return;
		}
		

		
				
		
		Integer idespecietalla = 0;
		if (txtEspecieTalla.getValue()==null || txtEspecieTalla.getValue().equals("")) {
			Sistema.mensaje("Debe ingresar un valor de especie talla para buscar");
			txtEspecieTalla.setFocus(true);
			return;
		}
		idespecietalla = Sistema.parseInt(txtEspecieTalla.getValue());
		
		EspecieTalla especieTalla = new EspecieTalla();
		especieTalla = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().getEspecieTallaPorId(idespecietalla);
		if (especieTalla==null) {
			Sistema.mensaje("No se ha encontrado la Especie-Talla consultada ");
			return;
		}
		
		if (lbxTipoCaptura.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione tipo de captura");
			lbxTipoCaptura.setFocus(true);
			return;
		}

		
		if (txtZonaFao.getValue().isEmpty())
		{
			Sistema.mensaje("Ingrese Zona Fao");
			txtZonaFao.setFocus(true);
			return;
		}		
		
		
		
		
		if (lbxProposito.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione Proposito");
			lbxProposito.setFocus(true);
			return;
		}
		
		
		if (lbxCamaras.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione camara");
			lbxCamaras.setFocus(true);
			return;
		}

		
		if (lbxColumnas.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione columna");
			lbxColumnas.setFocus(true);
			return;
		}


		if (lbxFilas.getSelectedIndex() == 0)
		{
			Sistema.mensaje("Seleccione fila");
			lbxFilas.setFocus(true);
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

		
		
		if (lbxCuba.getSelectedIndex()==0 && lbxCuba2.getSelectedIndex()==0 && lbxCuba3.getSelectedIndex()==0 && lbxCuba4.getSelectedIndex()==0 && lbxCuba5.getSelectedIndex()==0 && lbxCuba6.getSelectedIndex()==0) 
		{
			Sistema.mensaje("No se ha escogido una cuba / mescla de cubas");
			lbxCuba.setFocus(true);
			return;
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
    		 //System.out.println("encontro camara");
	    }
				
		if (camaraFilaColumna !=null) {
	    	 camaraCajon.setCamaraFilaColumna(camaraFilaColumna);
	    	  //System.out.println("encontro camarafilacolumna");
	    	  //System.out.println("idFilaColumnaObtenido-->"+camaraFilaColumna.getIdcamarafilacolumna());
	    	   
	         }		 
		
		
		//Es un nuevo cajón (select 0) o crea sea un nuevo cajón forzado (select 1)
		if(lbxCajonesDisponibles.getSelectedIndex() <= 1 )
		{
			camaraCajon.setEstado(0);	
		}	
		
		//NUEVO CAJÓN
		if(lbxCajonesDisponibles.getSelectedIndex() == 1)
		{
			camaraCajon.setFechareg(new java.sql.Timestamp(new Date().getTime()));
		}
		
		camaraCajon.setPesobruto(dbbxPesoBruto.getValue());
		camaraCajon.setPesoneto(Sistema.parseDouble( txtPesoNeto.getValue().trim() ));
		camaraCajon.setTara(Sistema.parseDouble(txtTara.getValue() ));
		camaraCajon.setTicket(txtTicket.getValue());
		camaraCajon.setLotecajonsap(txtLoteCajonSap.getValue());
		camaraCajon.setZonafao(txtZonaFao.getValue().trim());
		
		
		/*
		N/A
    	SIMPLE
    	DOBLE
    	*/
		
		if (lbxProposito.getSelectedIndex() == 1)
		{
			camaraCajon.setProposito("N/A");
		}
		else
		{
			if (lbxProposito.getSelectedIndex() == 2)
			{
				camaraCajon.setProposito("SIMPLE");
			}
			else
			{
				camaraCajon.setProposito("DOBLE");
			}
		}
		
		
	
		camaraCajon.setLotecamara(txtLoteCamara.getValue());
		camaraCajon.setLotehaccp(txtHaccp.getValue());
		
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		//System.out.println("valor de variable usuario-->"+usuario);
		
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
		
		ban = 0;
		CamaraCajon camaraCajonNuevo = new CamaraCajon();
		if(ChkNuevoCajon.isChecked())
		{
			if(txtPesoNetod.getText().isEmpty())
			{
				dbbxPesoBrutod.setFocus(true);
				Sistema.mensaje("Debe ingresar el peso bruto para el nuevo cajón");				
				return;
			}
			
			camaraCajonNuevo.setCodigoalmacen(camaraCajon.getCodigoalmacen());
			camaraCajonNuevo.setColumnapasillo(camaraCajon.getColumnapasillo());
			//camaraCajonNuevo.setEstado(camaraCajon.getEstado());
			camaraCajonNuevo.setEstado(1);
			camaraCajonNuevo.setFechaactualizacion(camaraCajon.getFechaactualizacion());
			camaraCajonNuevo.setFechaactualizacionmovimiento(camaraCajon.getFechaactualizacionmovimiento());
			camaraCajonNuevo.setFechareg(camaraCajon.getFechareg());
			camaraCajonNuevo.setFechaultimomovimiento(camaraCajon.getFechaultimomovimiento());
			
			//camaraCajonNuevo.setIdbarcoestibacuba2(camaraCajon.getIdbarcoestibacuba2());
			camaraCajonNuevo.setIdbarcoestibacuba2(null);
			
			camaraCajonNuevo.setIdmaterialanterior(camaraCajon.getIdmaterialanterior());
			camaraCajonNuevo.setLadopasillo(camaraCajon.getLadopasillo());
			camaraCajonNuevo.setLotecajonsap(camaraCajon.getLotecajonsap());
			camaraCajonNuevo.setLotecajonsapantesdenacionalizar(camaraCajon.getLotecajonsapantesdenacionalizar());
			camaraCajonNuevo.setObservacion(camaraCajon.getObservacion());			
			camaraCajonNuevo.setPesolibreutilizacion(camaraCajon.getPesolibreutilizacion());
						
			camaraCajonNuevo.setPesobruto(dbbxPesoBrutod.getValue());
			camaraCajonNuevo.setPesoneto(Sistema.parseDouble( txtPesoNetod.getValue().trim() ));
						
			camaraCajonNuevo.setProcesado(camaraCajon.getProcesado());
			camaraCajonNuevo.setTara(camaraCajon.getTara());
			camaraCajonNuevo.setTicket(camaraCajon.getTicket());
			camaraCajonNuevo.setTipotratamiento(camaraCajon.getTipotratamiento());
			camaraCajonNuevo.setUsuarioactualizacion(camaraCajon.getUsuarioactualizacion());
			camaraCajonNuevo.setUsuarioactualizacionmovimiento(camaraCajon.getUsuarioactualizacionmovimiento());
			camaraCajonNuevo.setUsuarioultimomovimiento(camaraCajon.getUsuarioultimomovimiento());
			camaraCajonNuevo.setZonafao(camaraCajon.getZonafao());
			
			/*
			N/A
	    	SIMPLE
	    	DOBLE
	    	*/
			
			if (lbxProposito.getSelectedIndex() == 1)
			{
				camaraCajonNuevo.setProposito("N/A");
			}
			else
			{
				if (lbxProposito.getSelectedIndex() == 2)
				{
					camaraCajonNuevo.setProposito("SIMPLE");
				}
				else
				{
					camaraCajonNuevo.setProposito("DOBLE");
				}
			}

				
			
			camaraCajonNuevo.setBarcoDescarga(camaraCajon.getBarcoDescarga());
			// camaraCajonNuevo.setBarcoEstibaCuba(camaraCajon.getBarcoEstibaCuba());
			camaraCajonNuevo.setCajon(camaraCajon.getCajon());
			camaraCajonNuevo.setCamaraArea(camaraCajon.getCamaraArea());
			camaraCajonNuevo.setCamaraCajonRegistroSap(camaraCajon.getCamaraCajonRegistroSap());

			
			camaraCajonNuevo.setCamara(camaraCajon.getCamara());
			camaraCajonNuevo.setCamaraFilaColumna(camaraCajon.getCamaraFilaColumna());
			
			camaraCajonNuevo.setEspecieTalla(camaraCajon.getEspecieTalla());
			camaraCajonNuevo.setTipoCaptura(camaraCajon.getTipoCaptura());
			camaraCajonNuevo.setTurno(camaraCajon.getTurno());
			camaraCajonNuevo.setUsuario(camaraCajon.getUsuario());
			
			camaraCajonNuevo.setLotecamara(camaraCajon.getLotecamara());
			camaraCajonNuevo.setLotehaccp(camaraCajon.getLotehaccp());
			
			camaraCajonNuevo.setBarcoEstibaCuba(null);
			
			
			ban = 1;
		}	

		camaraCajon.setBarcoEstibaCuba(null);
		
		CamaraCajon camaraCajon_pricipal = new CamaraCajon();
		camaraCajon_pricipal = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdateCamaraCajon(camaraCajon);
		regitrar_mezcla_de_cubas(camaraCajon_pricipal);
		
		
		
		//Verifica si graba el nuevo cajón (POR EJEMPLO USADO PARA PARTIR CAJONES)
		if(ban == 1)
		{
			CamaraCajon camaraCajon_partido = new CamaraCajon();
			camaraCajon_partido = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl().saveOrUpdateCamaraCajon(camaraCajonNuevo);
			regitrar_mezcla_de_cubas(camaraCajon_partido);
		}
		
		
		
		

		
		
		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);	
		limpiarControles();
		cargarLimpiarControles();
		
	}
	
	
	public void regitrar_mezcla_de_cubas(CamaraCajon camaraCajon)
	{
		
		////////////////////////
		//Combinación de cubas//
		////////////////////////
		//No es mescla de cubas, toma la cuba unica del cajón
		
			//Borramos las mescla de cubas
			List <BarcoEstibaCubaDetalleMezcla> lis = new BarcoEstibaCubaDAOJpaImpl().getListBarcoEstibaCubasDetalleMezcaxIdCamaraCajon(camaraCajon.getIdcamaracajon());
			System.out.println("Tamaño :"+lis.size());
			if (lis.size()>0)
			{
				for (BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla : lis) 
				{
					new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().delete(barcoEstibaCubaDetalleMezcla);
				}				
			}

			
			//Inserta la mescla de cubas
			
			// Cuba 1
			if (lbxCuba.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba();
				BarcoEstibaCubaDetalleMezcla bec1 = new BarcoEstibaCubaDetalleMezcla();
				bec1.setCamaraCajon(camaraCajon);
				bec1.setBarcoEstibaCuba(barcoEstibaCuba);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec1);
			}

			// Cuba 2
			if (lbxCuba2.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba2();
				BarcoEstibaCubaDetalleMezcla bec2 = new BarcoEstibaCubaDetalleMezcla();
				bec2.setCamaraCajon(camaraCajon);
				bec2.setBarcoEstibaCuba(barcoEstibaCuba2);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec2);
			}


			// Cuba 3
			if (lbxCuba3.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba3();
				BarcoEstibaCubaDetalleMezcla bec3 = new BarcoEstibaCubaDetalleMezcla();
				bec3.setCamaraCajon(camaraCajon);
				bec3.setBarcoEstibaCuba(barcoEstibaCuba3);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec3);
			}

			
			// Cuba 4
			if (lbxCuba4.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba4();
				BarcoEstibaCubaDetalleMezcla bec4 = new BarcoEstibaCubaDetalleMezcla();
				bec4.setCamaraCajon(camaraCajon);
				bec4.setBarcoEstibaCuba(barcoEstibaCuba4);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec4);
			}


			// Cuba 5
			if (lbxCuba5.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba5();
				BarcoEstibaCubaDetalleMezcla bec5 = new BarcoEstibaCubaDetalleMezcla();
				bec5.setCamaraCajon(camaraCajon);
				bec5.setBarcoEstibaCuba(barcoEstibaCuba5);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec5);
			}

			
			// Cuba 6			
			if (lbxCuba6.getSelectedIndex() > 0)  
			{
				seleccionarBarcoEstibaCuba6();
				BarcoEstibaCubaDetalleMezcla bec6 = new BarcoEstibaCubaDetalleMezcla();
				bec6.setCamaraCajon(camaraCajon);
				bec6.setBarcoEstibaCuba(barcoEstibaCuba6);
				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec6);
			}
		
		
		
		
//ORIGINAL		
//		//No es mescla de cubas, toma la cuba unica del cajón
//		if (camaraCajon.getBarcoEstibaCuba() != null)
//		{
//			if (barcoEstibaCuba!=null) // si se escogio una cuba del combo lo asigno a camara_cajon 
//			{
//				camaraCajon.setBarcoEstibaCuba(barcoEstibaCuba);
//			}
//		}
//		else
//		{
//			//Borramos las mescla de cubas
//			List <BarcoEstibaCubaDetalleMezcla> lis = new BarcoEstibaCubaDAOJpaImpl().getListBarcoEstibaCubasDetalleMezcaxIdCamaraCajon(camaraCajon.getIdcamaracajon());
//			if (lis.size()>0)
//			{
//				for (BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla : lis) 
//				{
//					new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().delete(barcoEstibaCubaDetalleMezcla);
//				}				
//			}
//
//			
//			//Inserta la mescla de cubas
//			
//			// Cuba 1
//			if (lbxCuba.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba();
//				BarcoEstibaCubaDetalleMezcla bec1 = new BarcoEstibaCubaDetalleMezcla();
//				bec1.setCamaraCajon(camaraCajon);
//				bec1.setBarcoEstibaCuba(barcoEstibaCuba);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec1);
//			}
//
//			// Cuba 2
//			if (lbxCuba2.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba2();
//				BarcoEstibaCubaDetalleMezcla bec2 = new BarcoEstibaCubaDetalleMezcla();
//				bec2.setCamaraCajon(camaraCajon);
//				bec2.setBarcoEstibaCuba(barcoEstibaCuba2);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec2);
//			}
//
//
//			// Cuba 3
//			if (lbxCuba3.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba3();
//				BarcoEstibaCubaDetalleMezcla bec3 = new BarcoEstibaCubaDetalleMezcla();
//				bec3.setCamaraCajon(camaraCajon);
//				bec3.setBarcoEstibaCuba(barcoEstibaCuba3);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec3);
//			}
//
//			
//			// Cuba 4
//			if (lbxCuba4.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba4();
//				BarcoEstibaCubaDetalleMezcla bec4 = new BarcoEstibaCubaDetalleMezcla();
//				bec4.setCamaraCajon(camaraCajon);
//				bec4.setBarcoEstibaCuba(barcoEstibaCuba4);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec4);
//			}
//
//
//			// Cuba 5
//			if (lbxCuba5.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba5();
//				BarcoEstibaCubaDetalleMezcla bec5 = new BarcoEstibaCubaDetalleMezcla();
//				bec5.setCamaraCajon(camaraCajon);
//				bec5.setBarcoEstibaCuba(barcoEstibaCuba5);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec5);
//			}
//
//			
//			// Cuba 6			
//			if (lbxCuba6.getSelectedIndex() > 0)  
//			{
//				seleccionarBarcoEstibaCuba6();
//				BarcoEstibaCubaDetalleMezcla bec6 = new BarcoEstibaCubaDetalleMezcla();
//				bec6.setCamaraCajon(camaraCajon);
//				bec6.setBarcoEstibaCuba(barcoEstibaCuba6);
//				new BarcoEstibaCubaDetalleMezclaDAOJpaImpl().saveOrUpdate(bec6);
//			}
//		}
		
		///////////////////////////
		//FinCombinación de cubas//
		///////////////////////////		
		
	}
	
	
	public void cargarListadoCubasBarcos(List<BarcoEstibaCuba> barcosEstibaCubas){
		
		lbxCuba.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba);		
			}
		lbxCuba.setSelectedIndex(0);
		
	}
	
	
	
	
	public void cargarListadoCubasBarcos2(List<BarcoEstibaCuba> barcosEstibaCubas){
		
		lbxCuba2.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba2);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba2);		
			}
		lbxCuba2.setSelectedIndex(0);
	}	
	
	

	public void cargarListadoCubasBarcos3(List<BarcoEstibaCuba> barcosEstibaCubas){
		
		lbxCuba3.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba3);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba3);		
			}
		lbxCuba3.setSelectedIndex(0);
	}	
	
	
	
	public void cargarListadoCubasBarcos4(List<BarcoEstibaCuba> barcosEstibaCubas)
	{		
		lbxCuba4.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba4);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba4);		
			}
		lbxCuba4.setSelectedIndex(0);
	}	
	
	
	
	
	public void cargarListadoCubasBarcos5(List<BarcoEstibaCuba> barcosEstibaCubas)
	{		
		lbxCuba5.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba5);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba5);		
			}
		lbxCuba5.setSelectedIndex(0);
	}	
	
	
	
	public void cargarListadoCubasBarcos6(List<BarcoEstibaCuba> barcosEstibaCubas)
	{		
		lbxCuba6.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new BarcoEstibaCuba());
		li.setParent(lbxCuba6);
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) {
				li = new Listitem();
				li.setValue(bec);
				 
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				//aki ir consultando 
				new Listcell( new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
				          .getCubaPorBarcoCuba(bec.getIdbarcocuba()).getCuba().getNombrecuba() +""  ).setParent(li);
				//new Listcell(""+bec.getIdbarcocuba()).setParent(li); 
				
			   li.setParent(lbxCuba6);		
			}
		lbxCuba6.setSelectedIndex(0);
	}	

	
	public void posicionarUnaCuba()
	{
		int pos = 0;
		
		//System.out.println("Besccc :"+camaraCajon.getBarcoEstibaCuba().getIdbarcoestibacuba());
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(camaraCajon.getBarcoEstibaCuba().getIdbarcoestibacuba()) ) 
			{
				lbxCuba.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	
	public void posicionarCuba(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;
		
		System.out.println("Besccc :"+barcoEstibaCuba.getIdbarcoestibacuba());
		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	

	public void posicionarCuba2(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba2.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	

	public void posicionarCuba3(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba3.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}

	
	
	public void posicionarCuba4(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba4.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	
	
	
	public void posicionarCuba5(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba5.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}

	
	
	
	public void posicionarCuba6(BarcoEstibaCuba barcoEstibaCuba)
	{
		int pos = 0;		
		for (BarcoEstibaCuba bec : barcosEstibaCubas) 
		{
			if (bec.getIdbarcoestibacuba().equals(barcoEstibaCuba.getIdbarcoestibacuba()) ) 
			{
				lbxCuba6.setSelectedIndex(pos+1);
			}
		    pos++;
		}
	}
	

	
	
	public void seleccionarBarcoEstibaCuba()
	{	 
		if (lbxCuba.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba = new BarcoEstibaCuba();
			 barcoEstibaCuba = (BarcoEstibaCuba) lbxCuba.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba = null;
		}		
	}

	
	public void seleccionarBarcoEstibaCuba2()
	{	 
		if (lbxCuba2.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba2 = new BarcoEstibaCuba();
			 barcoEstibaCuba2 = (BarcoEstibaCuba) lbxCuba2.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba2 = null;
		}		
	}
	

	public void seleccionarBarcoEstibaCuba3()
	{	 
		if (lbxCuba3.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba3 = new BarcoEstibaCuba();
			 barcoEstibaCuba3 = (BarcoEstibaCuba) lbxCuba3.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba3 = null;
		}		
	}

	
	
	public void seleccionarBarcoEstibaCuba4()
	{	 
		if (lbxCuba4.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba4 = new BarcoEstibaCuba();
			 barcoEstibaCuba4 = (BarcoEstibaCuba) lbxCuba4.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba4 = null;
		}		
	}

	
	public void seleccionarBarcoEstibaCuba5()
	{	 
		if (lbxCuba5.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba5 = new BarcoEstibaCuba();
			 barcoEstibaCuba5 = (BarcoEstibaCuba) lbxCuba5.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba5 = null;
		}		
	}
	

	
	public void seleccionarBarcoEstibaCuba6()
	{	 
		if (lbxCuba6.getSelectedIndex()>0) 
		{
			 barcoEstibaCuba6 = new BarcoEstibaCuba();
			 barcoEstibaCuba6 = (BarcoEstibaCuba) lbxCuba6.getSelectedItem().getValue();
		}
		else
		{
			barcoEstibaCuba6 = null;
		}		
	}
	
	
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
		lbxProposito.setSelectedIndex(0);
		dbbxPesoBruto.setValue(null);
		//listbox

		
		cargarListadoCubasBarcos(barcosEstibaCubas);
		cargarListadoCubasBarcos2(barcosEstibaCubas);
		cargarListadoCubasBarcos3(barcosEstibaCubas);
		cargarListadoCubasBarcos4(barcosEstibaCubas);
		cargarListadoCubasBarcos5(barcosEstibaCubas);
		cargarListadoCubasBarcos6(barcosEstibaCubas);		
		
		
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
		
		txtPesoNetod.setValue("");
		dbbxPesoBrutod.setValue(null);
		ChkNuevoCajon.setChecked(false);		
		
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
	

public void limpiarControlesSinCajon()
{
		txtPesoNeto.setValue("");
		txtEspecieTalla.setValue("");
		txtLoteCajonSap.setValue("");
		txtTara.setValue("");
		txtTicket.setValue("");
		dbbxPesoBruto.setValue(null);
		
		
		txtPesoNetod.setValue("");
		dbbxPesoBrutod.setValue(null);
		ChkNuevoCajon.setChecked(false);
		//listbox

		
		barcoEstibaCuba = null;
		barcoEstibaCuba2 = null;
		barcoEstibaCuba3 = null;
		barcoEstibaCuba4 = null;
		barcoEstibaCuba5 = null;
		barcoEstibaCuba6 = null;
		
		r2.setVisible(false);
		r3.setVisible(false);
		r4.setVisible(false);
		r5.setVisible(false);
		r6.setVisible(false);
		
//		lbxCuba.getItems().clear();
//		lbxCuba2.getItems().clear();
//		lbxCuba3.getItems().clear();
//		lbxCuba4.getItems().clear();
//		lbxCuba5.getItems().clear();
//		lbxCuba6.getItems().clear();		
		
		
//		cargarListadoCubasBarcos(barcosEstibaCubas);
//		cargarListadoCubasBarcos2(barcosEstibaCubas);
//		cargarListadoCubasBarcos3(barcosEstibaCubas);
//		cargarListadoCubasBarcos4(barcosEstibaCubas);
//		cargarListadoCubasBarcos5(barcosEstibaCubas);
//		cargarListadoCubasBarcos6(barcosEstibaCubas);				
		
		if(lbxCuba.getItems().size() > 0)
		{
			lbxCuba.setSelectedIndex(0);	
		}

		if(lbxCuba2.getItems().size() > 0)
		{
			lbxCuba2.setSelectedIndex(0);	
		}

		if(lbxCuba3.getItems().size() > 0)
		{
			lbxCuba3.setSelectedIndex(0);	
		}

		if(lbxCuba4.getItems().size() > 0)
		{
			lbxCuba4.setSelectedIndex(0);	
		}

		if(lbxCuba5.getItems().size() > 0)
		{
			lbxCuba5.setSelectedIndex(0);	
		}

		if(lbxCuba6.getItems().size() > 0)
		{
			lbxCuba6.setSelectedIndex(0);	
		}
		
		//lbxTurno.setSelectedIndex(0);

		if(lbxTipoCaptura.getItems().size() > 0)
		{
			lbxTipoCaptura.setSelectedIndex(0);	
		}

			
        txtZonaFao.setValue("");
        txtLoteCamara.setValue("");
        txtHaccp.setValue("");
        
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
		
	}	
	//este metodo se pensaba utilizar en primer instancia
	public void cargarInformacionCamaraCajon(BarcoDescarga barcoDescarga){
		
		camaraCajones = new ArrayList<CamaraCajon>();
		camaraCajones = new CamaraCajonBarcoDescargaMantenimientoDAOJpaImpl()
		 		.getCamaraCajonPorBarcoDescarga(barcoDescarga);
		 //System.out.println("tamano de lista camara cajon->"+camaraCajones.size());
		
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
			//System.out.println("valor descripcion de la camara escogida es-->"+camara.getDescripcion());
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
		
	    filasCamara = camaraFilaColumnaDAOJpaImpl.obtenerFilasConIdColumna(Integer.valueOf(String.valueOf(camara.getIdcamara()).trim()), columna.getColumna().trim()  );
				 
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
			//System.out.println("valor descripcion de la columna escogida es-->"+columna.getColumna());
			cargarListaFilasCamara();//llenamos las filas correspondientes a la columna 
		}else{
			columna = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger una columna
		}
	}
	
	
	public void onSelect$lbxFilas(){
		if (lbxFilas.getSelectedIndex()>0) {
			fila = new FilaCamara();
			fila = (FilaCamara) lbxFilas.getSelectedItem().getValue();
			//System.out.println("valor descripcion de la fila escogida es-->"+fila.getFila());
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
				//System.out.println("encontro el registro de tipo Captura");
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
	

	public void recalcularPesoNetod(Double pesoBrutod){
		
			
			////////////////////////////////////////////
			//Recaculamos el peso principal del cajón //
			////////////////////////////////////////////			
			//Bruto
			//dbbxPesoBruto.setValue(camaraCajon.getPesobruto() - pesoBrutod);
				
			////////////////////////////////////////////
			
			
			///////////////////////////////////////////
			//Calculamos el peso neto del nuevo cajón//
			///////////////////////////////////////////
			Double pesoNetod = 0.00;
			Double tara = 0.00;
			tara =  Sistema.parseDouble(txtTara.getValue());
			
			pesoNetod  = pesoBrutod - tara;
			
			if (pesoNetod < 0)
			{
				txtPesoNetod.setText("");
				
				dbbxPesoBruto.setValue(camaraCajon.getPesobruto());
				txtPesoNeto.setValue(camaraCajon.getPesoneto()+"");		
				txtTara.setValue(camaraCajon.getTara()+"");
			}
			else
			{
				txtPesoNetod.setValue(pesoNetod+"");

				dbbxPesoBruto.setValue( (camaraCajon.getPesoneto() - pesoNetod) + camaraCajon.getTara());
				
				//Neto
				String valor = "";
				valor = String.valueOf(dbbxPesoBruto.getValue());
				peso = 0.00;
				peso = Sistema.parseDouble(valor);
				recalcularPesoNeto(peso);					
			}
			
			
			
			//////////////////////////////////////////
		
	}
	
	
	public Date getAumentarUnDiaAFecha(Date fecha){
		Date fecha_aumentada = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DAY_OF_YEAR, 1); // Aumentamos un dia a la fecha
		fecha_aumentada= cal.getTime();
		//System.out.println("fecha aumentada->"+fecha_aumentada);
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
			//System.out.println("BUSCANDO "+c.getColumna().trim()+" == "+ camaraCajon.getCamaraFilaColumna().getIdcolumna().trim());
			//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
			if (c.getColumna().trim().equals(camaraCajon.getCamaraFilaColumna().getIdcolumna().trim())) 
			{
				//camaraFilaColumna.geti
				//System.out.println("encontro el registro de columna");
				lbxColumnas.setSelectedIndex(pos+1);
			}
		   pos++;
		}
	}
		


	public void posicionarFila()
	{

		//if ((camaraCajon.getCamaraFilaColumna()==null) ||camaraCajon.getCamaraFilaColumna().getIdfila()==0) {
		if ((camaraCajon.getCamaraFilaColumna()==null) ||camaraCajon.getCamaraFilaColumna().getIdfila()==null) {
			return;
		}
		int pos = 0;
		
				
		if (lbxColumnas.getSelectedIndex() > 0)
		{
			for (FilaCamara f : filasCamara) 
			{
				
//				System.out.println("Fila de lista :"+f.getFila());
//				System.out.println("Fila de objeto :"+String.valueOf((camaraCajon.getCamaraFilaColumna().getIdfila())));
				
				//System.out.println("id barco estiba cuba--> " + bec.getIdbarcoestibacuba());
				if (  String.valueOf(f.getFila()).equals(   String.valueOf((camaraCajon.getCamaraFilaColumna().getIdfila())))     ) 
				{
					//System.out.println("encontro el registro de fila");
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
					//System.out.println("encontro el registro de camara");
					lbxCamaras.setSelectedIndex(pos+1);
				}
			   pos++;
			}
		}

	
}
