package com.nw.webui.produccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
//import org.zkoss.zul.Listcell;
//import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import com.nw.model.CoccionDetalleProcesoCoche;
import com.nw.model.CoccionProceso;
import com.nw.model.Cuartochillroom;
import com.nw.model.Ducharociado;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.Produccion;
import com.nw.model.RociadoProceso;
import com.nw.model.Turno;
import com.nw.model.dao.impl.CoccionDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.CoccionProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ExcelDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.RociadoProcesoDAOJpaImpl;
//import com.nw.temp.model.ListaEmpleadosLinea;
import com.nw.temp.model.ListaLotesProduccion;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CoccionDetalleProcesoCochesControlWindow extends GenericForwardComposer {

	AnnotateDataBinder binder;
	
	private Listbox  lbxLista;
	private Datebox dteFecha, dteFecha1;

	private List<ListaLotesProduccion> listaLotesProduccion = new ArrayList<ListaLotesProduccion>();
	
	Date fechaActual = new Date();
	
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
	Produccion produccionb, produccionb1;
	CoccionDetalleProcesoCoche coccionDetalleProcesoCoche;
	RociadoProceso rociadoProceso;
	
	String valorCocheCodigoBarra = "";
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		//cargaListaFechaProduccionActiva((long) 0);
		
		cargarLimpiarControles();		
		
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();

	}
	

//	public void onBlur$dteFecha() {
//		// buscar la produccion en base a la fecha escogida
//		
//		if(dteFecha.getText()!=""){
//			produccionb = new Produccion();
//			produccionb = new ProduccionDAOJpaImpl().getProduccionByFecha(new Timestamp(dteFecha.getValue().getTime()));
//
//			if (produccionb == null) 
//			{
//				Sistema.mensaje("No existe una producción para la fecha escogida..");
//				dteFecha.setValue(null);
//				return;
//			}
//		}
//	}

	
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

		dteFecha.setText("");
	}
	
	
	
	
	
	
	
	public void onClick$btnNuevo() throws InterruptedException
	{
		produccionb = null;
		dteFecha.setText("");
		txtLoteu.setValue("");
		txProduccion.setValue("");
		txtInfCocina.setValue("");
		txtTotal.setValue("");
		txtReceptados.setValue("");
		txtPendientes.setValue("");
	}
	
	

	public void onClick$btnBuscar1()
	{
		listaLotesProduccion = null;
		if(dteFecha1.getText()!="")
		{
			produccionb1 = new Produccion();
			produccionb1 = new ProduccionDAOJpaImpl().getProduccionByFecha(new Timestamp(dteFecha1.getValue().getTime()));
		}
		
		
		ListaLotesProduccion llp = new ListaLotesProduccion();
		
		
		binder.loadAll();
	}
	

	
	public void onClick$btnNuevo1()
	{
		listaLotesProduccion = null;
		produccionb1 = null;
		binder.loadAll();
		lbxLista.setFocus(true);
	}
	
	
	
	public void onClick$btnBuscar()
	{
		//
		txProduccion.setValue("");
		txtInfCocina.setValue("");
		txtTotal.setValue("");
		txtReceptados.setValue("");
		txtPendientes.setValue("");

		
		if(dteFecha.getText()!="")
		{
			produccionb = new Produccion();
			produccionb = new ProduccionDAOJpaImpl().getProduccionByFecha(new Timestamp(dteFecha.getValue().getTime()));
		}	
		
//		if(dteFecha.getText().isEmpty())
//		{
//			Sistema.mensaje("No existe una producción para la fecha escogida..");
//			dteFecha.setValue(null);
//			return;
//		}
//		
//		produccionb = new Produccion();
//		produccionb = new ProduccionDAOJpaImpl().getProduccionByFecha(new Timestamp(dteFecha.getValue().getTime()));

		if (produccionb == null) 
		{
			Sistema.mensaje("No existe una producción para la fecha escogida..");
			dteFecha.setValue(null);
			dteFecha.setFocus(true);
			return;
		}		
		
		if (produccionb == null)
		{
			Sistema.mensaje("No existe produción selecciona o establecida para buscar");
			dteFecha.setValue(null);
			dteFecha.setFocus(true);
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
	         //    System.out.print("**'\n");	             
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

	
	
	
	public List<ListaLotesProduccion> getListaLotesProduccion() {
		return listaLotesProduccion;
	}


	public void setListaLotesProduccion(List<ListaLotesProduccion> listaLotesProduccion) {
		this.listaLotesProduccion = listaLotesProduccion;
	}
	
	


}
