package com.nw.webui.produccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.BarcoDescarga;
import com.nw.model.Camara;
import com.nw.model.CamaraArea;
import com.nw.model.CamaraCajon;
import com.nw.model.CamaraFilaColumna;
import com.nw.model.dao.impl.CamaraCajonDAOJpaImpl;
import com.nw.model.dao.impl.CamaraCajonUbicacionDAOJpaImpl;
import com.nw.model.dao.impl.CamaraFilaColumnaDAOJpaImpl;
import com.nw.temp.model.ColumnaCamara;
import com.nw.temp.model.FilaCamara;
import com.nw.util.Sistema;


public class CamaraConsultaMovimientoWindow extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290240201391703339L;
	
	
	/**
	 * Declaracion de Objetos y Variables
	 */
	//private Window winAsigCamara;
	
	private Datebox dteFecReg; 
	//private Listbox lbxCajones;
	private Textbox txtCamaras,txtFilas,txtColumnas, txtCamaraArea;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Textbox txtObs,txtDescOrd, txtCajon;
	//Checkbox chkEst;
	private Label lbCamara, LblFila;
	Date fechaActual = new Date();
	
	//objetos globales
	BarcoDescarga barcoDescarga;
	//Cajon cajon;
	CamaraCajon camaraCajon;
	Camara camara;
	FilaCamara fila;
	ColumnaCamara columna;
//	CamaraFilaColumna fila;
//	CamaraFilaColumna columna;
	//este objeto permitira obtener el id de la fila y columna escogida en la tabla camara_fila_columna
	CamaraFilaColumna camaraFilaColumna; 
	
	List<ColumnaCamara> columnasCamara = new ArrayList<ColumnaCamara>();
	List<FilaCamara> filasCamara = new ArrayList<FilaCamara>();
	
	CamaraArea camaraarea;
	//instancia del Dao CamaraCajon  y CamaraCajonUbicacion
	CamaraCajonDAOJpaImpl camaraCajonDAOJpaImpl = new CamaraCajonDAOJpaImpl();
	CamaraCajonUbicacionDAOJpaImpl camaraCajonUbicacionDAOJpaImpl = new CamaraCajonUbicacionDAOJpaImpl();
	CamaraFilaColumnaDAOJpaImpl camaraFilaColumnaDAOJpaImpl = new CamaraFilaColumnaDAOJpaImpl();
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		dteFecReg.setValue(fechaActual);
		//cargarListaBarcoDescarga();
		//obtenerC();
//		cargarListaCajonesEstadoUnoCamaraCajon();
//		cargarCamaraAreas();
//		cargarListaCamaras();
	}
	

	
	public void onCreate$winAsigCamaraConsulta(Event event) throws Exception {
	
		
	}


	
	public void onClick$btnBuscarCajon() throws InterruptedException 
	{
		txtDescOrd.setValue("");
		limpiar();
		
		if(txtCajon.getValue().isEmpty())
		{
			txtCajon.setFocus(true);
			Sistema.mensaje("Ingrese numero de cajón");
			return;
		}
		
		camaraCajon = new CamaraCajon();		
		camaraCajon = new CamaraCajonDAOJpaImpl().getCamaraCajonId(txtCajon.getValue());
		
		if(camaraCajon == null)
		{
			txtCajon.setFocus(true);
			txtCajon.setValue(null);
			limpiar();			
			Sistema.mensaje("Número de cajón no existe o no esta disponible");
			return;			
		}
		
		/////////////////////////////////////////////////////
		//Cajón encontrado y cargamos sus datos en pantalla//
		/////////////////////////////////////////////////////
		txtDescOrd.setValue("");
		txtDescOrd.setValue(camaraCajon.getEspecieTalla().getEspecie().getNombre());
		txtDescOrd.setValue(txtDescOrd.getValue()+ "\n"+ camaraCajon.getBarcoDescarga().getBarco().getNombre());
		
		tipoCamara();
		/////////////////////////////////////////////////////////
		//Fin Cajón encontrado y cargamos sus datos en pantalla//
		/////////////////////////////////////////////////////////
		
	}	
	
	
	
	
	public void obtenerC()
	{
		String columna = "A";
		
		List<FilaCamara> filas = camaraFilaColumnaDAOJpaImpl.obtenerFilasConIdColumna(1, columna);
		for (FilaCamara f : filas) {
			System.out.println("fillaaa obtenida-->"+ f.getFila());
		}
	}
	

/*	
	public void cargarListaCajonesEstadoUnoCamaraCajon(){
		lbxCajones.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new CamaraCajon());
		li.setParent(lbxCajones);
		
		List<CamaraCajon> cajones = new CamaraCajonDAOJpaImpl().getCajonesEnCamaraCajonDisponibles();
		for (CamaraCajon cajon : cajones) {
			 li = new Listitem();
			 li.setValue(cajon);
			 new Listcell(cajon.getCajon().getIdcajon()).setParent(li);
			 li.setParent(lbxCajones);
		}
		lbxCajones.setSelectedIndex(0);
		
	}
*/
	
/*
	public void onSelect$lbxCajones() throws InterruptedException{
		txtDescOrd.setValue("");
		if (lbxCajones.getSelectedIndex()>0) {
		    //vaciamos el objeto cajon creando una nueva instancia
			camaraCajon = new CamaraCajon();
			camaraCajon = (CamaraCajon) lbxCajones.getSelectedItem().getValue(); //asigno  al objeto cajon el item seleccionado
			System.out.println("id camaraCajon Escogido es -->" + camaraCajon.getIdcamaracajon());
			System.out.println("id barcoDescarga Escogido es -->" + camaraCajon.getBarcoDescarga().getIdbarcodescarga());
			txtDescOrd.setValue("");
			
			String resultado = camaraCajonDAOJpaImpl.obtenerDescripcionEspecieBarco(camaraCajon.getCajon().getIdcajon());
			List<Object[]> resul2 = camaraCajonDAOJpaImpl.obtenerEspecieTallaDescripcion(camaraCajon.getCajon().getIdcajon());
			
			for (Object[] obj : resul2) {
				txtDescOrd.setValue( String.valueOf(obj[0]) +""+ String.valueOf(obj[1]));
			}
			txtDescOrd.setValue(txtDescOrd.getValue()+ "\n"+ resultado);			
			tipoCamara();
		}else{
			camaraCajon = null;// se vacia el objeto para q pueda validar de nuevo q debe escoger un  cajon
		}
	}
*/
	
	public void limpiar()
	{
		txtDescOrd.setValue(null);
		txtCamaraArea.setValue(null);
		txtCamaras.setValue(null);
		txtColumnas.setValue(null);
		txtFilas.setValue(null);
		txtObs.setValue(null);		
	}

	
	
	
	
	/**
	 * Metodo Grabar del boton btnGrabar
	 * @throws InterruptedException
	 */
/*	
	public void onClick$btnRefrescar() throws InterruptedException{
		cargarListaCajonesEstadoUnoCamaraCajon();
		limpiar();
	}
	
*/
	
    public void tipoCamara(){
    	//No esta vacio y metio un número de cajón
		if (txtCajon.getValue().isEmpty() == false)			
		{
			txtCamaraArea.setValue(camaraCajon.getCamaraArea().getDescripcioncamaraarea());
			txtObs.setValue(camaraCajon.getCamaraCajonUbicacions().get(camaraCajon.getCamaraCajonUbicacions().size()-1).getObservaciones());
			
//			txtCamaras.setValue(camaraCajon.getCamara().getDescripcion().toString());
//			txtColumnas.setValue(camaraCajon.getCamaraFilaColumna().getIdcolumna());
//			txtFilas.setValue(camaraCajon.getCamaraFilaColumna().getIdfila().toString());

			//camara;
			if(camaraCajon.getCamaraArea().getIdcamaraarea() ==4) //Cámara
			{
				txtCamaras.setValue(camaraCajon.getCamara().getDescripcion().toString());
				txtColumnas.setValue(camaraCajon.getCamaraFilaColumna().getIdcolumna());
				txtFilas.setValue(camaraCajon.getCamaraFilaColumna().getIdfila().toString());								
			}			
			
			//PreCamara;
			if(camaraCajon.getCamaraArea().getIdcamaraarea() ==1) //Cámara
			{
				txtCamaras.setValue(camaraCajon.getCamara().getDescripcion().toString());
				txtColumnas.setValue(null);
				txtFilas.setValue(null);				
			}

			
			//Es fuera, por lo tanto no necesitamos la camara;
			if(camaraCajon.getCamaraArea().getIdcamaraarea() ==3 || camaraCajon.getCamaraArea().getIdcamaraarea() == 5) //Fuera o Producción
			{
				txtCamaras.setValue(null);
				txtColumnas.setValue(null);
				txtFilas.setValue(null);				

				lbCamara.setValue("Sin Cámara :");
			}
			else
			{
				lbCamara.setValue(camaraCajon.getCamaraArea().getDescripcioncamaraarea());	
			}

			
			//Es Pasillo, por lo tanto no es fila sino lado;
			if(camaraCajon.getCamaraArea().getIdcamaraarea()==2)//Pasillo
			{
				txtCamaras.setValue(camaraCajon.getCamara().getDescripcion().toString());
				txtColumnas.setValue(camaraCajon.getColumnapasillo());
				txtFilas.setValue(camaraCajon.getLadopasillo());
				
				LblFila.setValue("Lado :");
			}
			else
			{
				LblFila.setValue("Fila :");
			}
		}
		else
		{
			lbCamara.setValue("Sin Cámara :");
		}		
	}
    	
}
