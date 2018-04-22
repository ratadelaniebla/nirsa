package com.nw.webui.produccion;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.CalidadDetalleMuestreoCocina;
import com.nw.model.CalidadMuestreoCocina;
import com.nw.model.CoccionDetalleProcesoCoche;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CalidadMuestreoCocinaDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CalidadMuestreoCocinaWindow extends GenericForwardComposer{

	private Listbox lbxTurnoProduccion, lbxTurnoLabor, lbxFechaActiva;
	@SuppressWarnings("unused")
	private Toolbarbutton btnGrabar;
	private Textbox txtCoche,txtNumCoche,txtMuestrasxLote,txtMuestras,
	txtCocheLote,txtLote,txtCocina,txtCanastillas,txtPescadoLata,txtTemperatura;
	Date fechaActual = new Date();
	
	int idcoccionDetalleProceso;
	int muestraporlote = 0;
	
	Date fecha;
	Turno turno;
	Turno turnoLabor;
	String valorCocheCodigoBarra = "";
	DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG); //SHORT, MEDIUM, LONG, FULL
	Produccion produccion;
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	CoccionDetalleProcesoCoche coccionDetalleProcesoCoche;
	
	EvisceradoDetalleProcesoCoche edp = new EvisceradoDetalleProcesoCoche();
	CalidadMuestreoCocina cdmc = new CalidadMuestreoCocina();
	CalidadMuestreoCocina cmTc = new CalidadMuestreoCocina();
	CalidadDetalleMuestreoCocina calidadDMTC = new CalidadDetalleMuestreoCocina();
	 CalidadMuestreoCocinaDAOJpaImpl calidadMuestreoTCDAO = new CalidadMuestreoCocinaDAOJpaImpl();
	
	
	 List<CalidadDetalleMuestreoCocina> listacalidaddetalle = new ArrayList<CalidadDetalleMuestreoCocina>();
	 List<CalidadDetalleMuestreoCocina> listacalidadMuestreoCoche = new ArrayList<CalidadDetalleMuestreoCocina>();
	 
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		//cargaListaFechaProduccionActiva();
		//cargarListaTurno();
		cargarListaTurnoLabor();
		cargarLimpiarControles();
		
	}

	public void cargaListaFechaProduccionActiva(){
		lbxFechaActiva.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxFechaActiva);
				
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaCoccion();
		
		if (listaFecha.size()==0) {
			Sistema.mensaje("No existen producciones activas");
		}
		else
		{
			for (Produccion bd : listaFecha) {
				li = new Listitem();
				li.setValue(bd);
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Fecha --> " + dateFormat.format(bd.getFechaproduccion()));
				
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				li.setParent(lbxFechaActiva);
			}
			lbxFechaActiva.setSelectedIndex(0);
		}
	}
	
    public void onSelect$lbxFechaActiva() throws InterruptedException{
		
		if (lbxFechaActiva.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxFechaActiva.getSelectedItem().getValue();
			
			System.out.println("idproduccion-->"+ produccion.getIdproduccion());
			lbxTurnoProduccion.focus();
			//Messagebox.show("el valor seleccionado es-->"+ );
		}else{
			produccion = null;
		}
	}
	
	public void cargarListaTurno(){
		lbxTurnoProduccion.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurnoProduccion);
				
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		
		for (Turno bd : listaTurnos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getNombre()).setParent(li);
			li.setParent(lbxTurnoProduccion);
		}
		lbxTurnoProduccion.setSelectedIndex(0);
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
	
	public void onSelect$lbxTurnoProduccion() throws InterruptedException{
		txtCoche.setValue(""); 
		txtNumCoche.setValue("");
	//	txtCocheLote.setValue("");
		txtLote.setValue("");
		txtCocina.setValue("");
		txtCanastillas.setValue("");
		txtPescadoLata.setValue("");
		
		if (lbxTurnoProduccion.getSelectedIndex()>0) {
			turno = new Turno();
			turno = (Turno) lbxTurnoProduccion.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			//Messagebox.show("el valor seleccionado es-->"+ turno.getIdturno() +""+ turno.getNombre());
			txtCoche.focus();
		}else{
			turno = null;
		}
	}
	
	public void onSelect$lbxTurnoLabor() throws InterruptedException{
		txtCoche.setValue(""); 
		txtNumCoche.setValue("");
	//	txtCocheLote.setValue("");
		txtLote.setValue("");
		txtCocina.setValue("");
		txtCanastillas.setValue("");
		txtPescadoLata.setValue("");	
		
//		if (produccion == null) {
//			Sistema.mensaje("Debe escoger una fecha");
//			lbxTurnoLabor.setSelectedIndex(0);
//		}
//		else
//		{
			if (lbxTurnoLabor.getSelectedIndex()>0) {
				//vaciamos el objeto barcoDescarga creando una nueva instancia 
				turnoLabor = new Turno();
				turnoLabor = (Turno) lbxTurnoLabor.getSelectedItem().getValue();
				
//				txtCoche.setValue("");
//				txtCoche.focus();
				//Messagebox.show("el valor seleccionado es-->"+ turno.getIdturno() +""+ turno.getNombre());
			}else{
				turnoLabor = null;
				Sistema.mensaje("Se requiere el turno para los lotes");
				lbxTurnoLabor.focus();
//				lbxCajon.getItems().clear();
			}
//		}
	}
	
	public void onChanging$txtCoche(InputEvent event) throws InterruptedException, IOException{
		 System.out.println("valor es -->"+event.getValue());
		 valorCocheCodigoBarra = "";
		 valorCocheCodigoBarra = event.getValue().trim();
		 
		
		
	}
//public void onOK$txtCoche() 
//	{
//		buscaCoche();
//	}
	
	public void onClick$btnBuscaCoche(){
		buscaCoche();
			
	}
	
	public void buscaCoche()
	{
		try{

		    txtNumCoche.setValue("");
		//	txtCocheLote.setValue("");
			txtLote.setValue("");
			txtCocina.setValue("");
			txtCanastillas.setValue("");
			txtPescadoLata.setValue("");
		//	txtTemperatura.setValue("");

//			if (produccion == null || turno == null) {
//				Sistema.mensaje("Debe seleccionar la produccion y el turno del listado");
//			}
//			else
//			{
		 
			
			edp = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoDetalleProcesoCocheByCodBarra(Long.valueOf(valorCocheCodigoBarra));
			
			int muestra =0;
			
			
			 if (edp!=null) {
				 
				 List<CalidadDetalleMuestreoCocina>  coches= new ArrayList<CalidadDetalleMuestreoCocina>();
/*hn				 coches = new CalidadMuestreoCocinaDAOJpaImpl().
						getcalidadDetalleMuestreoCoche(edp.getIdevisceradodetalleprocesocoche());
*/
				 coches = new CalidadMuestreoCocinaDAOJpaImpl().
						 getcalidadDetalleMuestraCocinaCochesLote(edp.getEvisceradoDetalleProceso().getIdevisceradodetalleproceso());
				 
				 				 
				 
				 muestraporlote = coches.size();
				 
				 List<CalidadDetalleMuestreoCocina>  cochesCocina= new ArrayList<CalidadDetalleMuestreoCocina>();
//hn				 List<CalidadDetalleMuestreoCocina>  cochesLote= new ArrayList<CalidadDetalleMuestreoCocina>();
				 
				//usamos un objeto de consulta cdmc que es la cabecera
				cdmc=calidadMuestreoTCDAO.getCalidadMuestreoCociona(edp.getEvisceradoDetalleProceso().getEvisceradoProceso().getIdevisceradoproceso());
				
				if (cdmc==null) {
					muestra =0;
					
				}else{

					cochesCocina= new CalidadMuestreoCocinaDAOJpaImpl().getcalidadDetalleMustraCocina(cdmc.getIdcalidadmuestreococina());
				    muestra = cochesCocina.size();
				}
				
				 
				 edp.getEvisceradoDetalleProceso().getEvisceradoProceso().getIdevisceradoproceso();
						
				 txtCanastillas.setValue(String.valueOf( edp.getCanastillas()));
						txtNumCoche.setValue(String.valueOf(edp.getIdevisceradodetalleprocesocoche()));
				//		txtMuestrasxLote.setValue(String.valueOf(edp.getIdcochelote()));
						
						txtMuestrasxLote.setValue(String.valueOf(  muestraporlote ));
						txtMuestras.setValue(String.valueOf(muestra));
						
						
						txtCocina.setValue(String.valueOf(edp.getCocina().getDescripcion()));
						txtPescadoLata.setValue(String.valueOf(edp.getEvisceradoPescadosLata().getIdevisceradopescadoslata()));
						
						txtLote.setValue(String.valueOf(edp.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getProduccionDetalleLote().getIdlote()));
						
		
					
				}else{
					Sistema.mensaje("coche no encontrado");
					txtCoche.focus();
					return;
				}
				
		} catch (Exception e) {
			System.out.print("Error: "+e.getMessage());
		}
	}
	
	
	public boolean validarTexboxConDecimales()
    {
		 //Solo debe contener numeros enteros o decimales
	       /*
	* El caracter '\' sirve preceder a expresiones con
	valores de escape, así \\ equivale a \ o \{ equivale a { * El caracter '^' indica comienzo de una línea
	* El caracter '|' representa un O lógico
	*/
	  try {
		
		
		String input = "";
		input = txtTemperatura.getText().toString().replace(',', '.');
		System.out.println("Temperatura convertida --> " + input);
//	       Pattern p = Pattern.compile("^\\d+|^\\d+\\.?\\d+");
		Pattern p = Pattern.compile("^-?\\d+|^-?\\d+\\.?\\d+");
//			Pattern p= Pattern.compile("/^-?\d+(\.\d+)?$/");
	       Matcher m = p.matcher(input);
	       if ( !m.matches())
	       {
	    	   System.out.println("temp incorrecto");
	    	   //Sistema.mensaje("Digite una Temperatura con un solo punto");
	    	   return true;
	       }  
	       System.out.println("Número: " + input);
	       
	    } catch (Exception e) {
			System.out.println("paso esto-->"+e.toString());
			Sistema.mensaje("Debe ingresar una temperatura valida");
			return true;
		}
		return false;
    }
	
	
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}

	public void grabar() throws InterruptedException{
	
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);
		 Usuario usu = new Usuario();
				
		//validaciones 
		if (usuario==null || usuario.equals("")) {
			//Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			usuario = "aaguirre";
		}
			
		if (turnoLabor == null) {
			Sistema.mensaje("Debe de Seleccionar un Turno de la lista");
			return;
		}
	   // edp.getEvisceradoDetalleProceso().getEvisceradoProceso().getIdevisceradoproceso();
	    			
		if (edp == null) {
			
			Sistema.mensaje("Debe buscar un Coche");
			return;
		}
		//usamos un objeto de consulta cdmc que es la cabecera
		cdmc=calidadMuestreoTCDAO.getCalidadMuestreoCociona(edp.getEvisceradoDetalleProceso().getEvisceradoProceso().getIdevisceradoproceso());
		
		 if (cdmc==null){
		    //	Sistema.mensaje("no existe");
			 // creo la cabecera y asigno el detalle 
			
				usu.setIdusuario(usuario);
				cmTc.setUsuario(usu);
				cmTc.setTurno(turnoLabor);
				cmTc.setEvisceradoProceso(edp.getEvisceradoDetalleProceso().getEvisceradoProceso());				
//			  coccionDetalleProcesoCocheTemp.setCoccionDetalleProcesoCoche(coccionDetalleProcesoCoche); //idcoccionTemperatura
				cmTc.setFechareg(new java.sql.Timestamp(new Date().getTime()));				
				//se crea la cabecera
				CalidadMuestreoCocina calidadCabeceraMuestreoDevuelto = new CalidadMuestreoCocina();
				calidadCabeceraMuestreoDevuelto = calidadMuestreoTCDAO.guardarCalidadMuestreoCocina(cmTc);				
				//crear el detalle 
			//	double temperatura = Double.valueOf(txtTemperatura.getText().toString().replace(',', '.'));
			//	System.out.println("Valor tomado del txttemperatura --> "+ temperatura );
				//coccionDetalleProcesoCocheTemp.setIdcocciondetalleprocesocochetemperatura(coccionDetalleProcesoCoche.getIdcocciondetalleprocesocoche()); //ID
				usu.setIdusuario(usuario);
				//asigno la cabecera devuelta al detalle
				calidadDMTC.setCalidadMuestreoCocina(calidadCabeceraMuestreoDevuelto);
				calidadDMTC.setUsuario(usu);
		//		calidadDMTC.setTemperatura(temperatura); //Temperatura
				calidadDMTC.setTurno(turnoLabor);
				calidadDMTC.setEvisceradoDetalleProcesoCoche(edp);
//			  coccionDetalleProcesoCocheTemp.setCoccionDetalleProcesoCoche(coccionDetalleProcesoCoche); //idcoccionTemperatura
				calidadDMTC.setFechareg(new java.sql.Timestamp(new Date().getTime()));
				calidadDMTC.setNummuestralote(muestraporlote+1);
				calidadMuestreoTCDAO.guardarCalidadDetalleCocinas(calidadDMTC);
				 
		    }else{
		    	//System.out.println("si existe una cabecera");
		    	// solo graba el detalle
		    	
		    	//crear el detalle 
				usu.setIdusuario(usuario);
				//asigno la cabecera existente al detalle 
				calidadDMTC.setCalidadMuestreoCocina(cdmc);
				calidadDMTC.setUsuario(usu);
				calidadDMTC.setTurno(turnoLabor);
				calidadDMTC.setEvisceradoDetalleProcesoCoche(edp);
//			  coccionDetalleProcesoCocheTemp.setCoccionDetalleProcesoCoche(coccionDetalleProcesoCoche); //idcoccionTemperatura
				calidadDMTC.setFechareg(new java.sql.Timestamp(new Date().getTime()));
				calidadDMTC.setNummuestralote(muestraporlote+1);
				calidadMuestreoTCDAO.guardarCalidadDetalleCocinas(calidadDMTC); 	
		    }		    	
//		CoccionDetalleProcesoCocheTemperaturaDAOJpaImpl coccionDetalleProcesoCocheTempImpl = new CoccionDetalleProcesoCocheTemperaturaDAOJpaImpl();
//		CoccionDetalleProcesoCocheTemperatura coccionDetalleProcesoCocheTemp = new CoccionDetalleProcesoCocheTemperatura();
		
	
		
		System.out.println("Transaccion grabada");

		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		cargarLimpiarControles();
		txtCoche.focus();
		muestraporlote = 0;
	}
	
	public void cargarLimpiarControles(){
		
     //   txtDiaProduccion.setValue(""); 
		txtCoche.setValue(""); 
	    txtNumCoche.setValue("");
	//	txtCocheLote.setValue("");
		txtLote.setValue("");
		txtCocina.setValue("");
		txtCanastillas.setValue("");
		txtPescadoLata.setValue("");
		txtMuestrasxLote.setValue("");
		txtMuestras.setValue("");
		
//		lbxTurno.setSelectedIndex(0);
		
	}
	
	
	
}
