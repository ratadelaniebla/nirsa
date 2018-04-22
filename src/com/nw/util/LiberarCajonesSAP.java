package com.nw.util;

import com.nw.util.MyDestinationData;
import com.nw.util.MyDestinationDataProvider;
import com.nw.util.Sistema;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.Environment;
import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;




public class LiberarCajonesSAP 
{
	
	
	public static String vMandante = "xx";
	public static String vtUsuario = "xx";
	public static String vClave = "xx";
	public static String vIdioma = "xx";
	public static String vIp = "xx";
	public static String vEntorno = "xx";	
	
	
	
    public final static String DESTINATION_NAME = "myDest";    


	// 1 = Linux
	// 2 = Windows    
	//static Integer so = 2;

	
	public static void ejecutar(Integer so) throws Exception
	{
		// TODO Auto-generated method stub
		
		/////////////////
		//LAMADA DE SAP//
		/////////////////
			// 1 = Linux
			// 2 = Windows
			if (so == 1)
			{
				llamarSAPUsandoLinux();
			}
			else
			{
				llamarSAPUsandoWindows();
			}
			
		/////////////////////
		//FIN LAMADA DE SAP//
		/////////////////////		
		
		
	}
	
	/////////////
	/// LINUX ///
	/////////////
	public static void Linuxconnect() throws Exception
	{

		try {
			MyDestinationData destData = new MyDestinationData(vMandante, vtUsuario, vClave, vIdioma, vIp, vEntorno);
 
			MyDestinationDataProvider provider = MyDestinationDataProvider.getInstance();
			provider.addDestination(DESTINATION_NAME, destData);
			Environment.registerDestinationDataProvider(provider);
 
			JCoDestination dest = JCoDestinationManager.getDestination(DESTINATION_NAME);
			System.out.println(dest.getAttributes());
			System.out.println("== 1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
    public static void Linuxstep3SimpleCall_Opcion1() throws JCoException
    {
        JCoDestination destination = JCoDestinationManager.getDestination(DESTINATION_NAME);
        
        //////////////////////////////////////
        //INICAMOS LA FUNCION RFC A EJECUTAR//
        //////////////////////////////////////
        JCoFunction function = destination.getRepository().getFunction("ZMM_PROCE_LOTES_NO_GRABA");
        /////////////////////////////////////////
        //FIN INDICACION FUNCION RFC A EJECUTAR//
        /////////////////////////////////////////

        
//        String pdocumento = "1984";
        
        /////////////////////////
        //PARAMETROS DE ENTRADA//
        /////////////////////////
//        function.getImportParameterList().setValue("VBELN",pdocumento);
//        function.getImportParameterList().setValue("VBTYP",2);
        /////////////////////////////
        //FIN PARAMETROS DE ENTRADA//
        ///////////////////////////
        
        try {
        	
        	/////////////////////////////
        	//SE EJECUTA LA FUNCION RFC//
        	/////////////////////////////
            function.execute(destination);
        	///////////////////////////////////
        	//FIN EJECUCION DE LA FUNCION RFC//
        	///////////////////////////////////

            
            
            /////////////////////////////////////////////////////////////////////////////
            // MOSTRAMOS EL RESULTADO EN CUEL FUE RETORNADO EN LA VARIABLE "RESPUESTA" //
            /////////////////////////////////////////////////////////////////////////////
//          Sistema.mensaje(function.getExportParameterList().getString("RESPUESTA"));
            System.out.println(function.getExportParameterList().getString("E_MENSAJE"));
            /////////////////////////////////////////////////////////////////////////////////
            // FIN MUESTRA  DEL RESULTADO EN CUEL FUE RETORNADO EN LA VARIABLE "RESPUESTA" //
            /////////////////////////////////////////////////////////////////////////////////
            
            Sistema.mensaje("RESPUESTA SAP: "+function.getExportParameterList().getString("E_MENSAJE"));
        }
        catch (JCoException ex) {
            if (ex.getKey().equals("CARR_NOT_FOUND")) {
            	Sistema.mensaje("NO EJECUTADO, Intente en otro momento");
            }
        }
        System.out.println();
     
    }	
    //////////////
    //FIN LINUX //
    /////////////
	
    
    
    
    
    ///////////
    //WINDOWS//
    ///////////
			/////////
			///JCO///
			/////////
			@SuppressWarnings("null")
			public static String LiberarSapPorjco() throws Exception 
			{
			
			JCO.Client client = null;
			JCO.Function funcion = null;
			//JCO.Table t_spfli = null;
			String t_spfli = "";
			
			
			
			// conexioncap    
			IRepository repositorio = null;
			IFunctionTemplate ftemplate = null;
			try {
			    client = JCO.createClient(vMandante,
							        		vtUsuario,
							        		vClave,
							        		vIdioma,
							        		vIp,
							        		vEntorno);
			
			    System.out.println("Paso 1");
			    
			    
			    
			    //Creando el repositorio para las funciones
			    repositorio = JCO.createRepository("MiRepositorio", client);
			    System.out.println("Paso 2");
			    
			    //Indicamos que funciones queremos utilizar
			    //ftemplate = repositorio.getFunctionTemplate("ZRCF_SPFLI_LIST".toUpperCase());
			    ftemplate = repositorio.getFunctionTemplate("ZMM_PROCE_LOTES_NO_GRABA".toUpperCase());
			    
			    
			    //Obtenemos la funcion del SAP
			    funcion = ftemplate.getFunction();
			    System.out.println("Paso 3");         
			 
			    //Pasamos parametros a la funcion
			 	//funcion.getImportParameterList().setValue(pdocumento, "VBELN");
			 	
			 	//int tipodoc;;
			 	//Solo Guias por defecto
			 	//tipodoc =  2;
			 	//System.out.println("Tipo de busqueda :"+String.valueOf(tipodoc));
			 	
			 	
//			 	funcion.getImportParameterList().setValue(tipodoc, "VBTYP");     	
			 	System.out.println("Paso 4");
			                         
			    //Ejecutamos la funcion
			    client.execute(funcion);
			    System.out.println("Paso 5");
			    
			    //Capturamos el parametro de Salida
			    //t_spfli = funcion.getTableParameterList().getTable("FLIGHT_LIST");
			    t_spfli = funcion.getExportParameterList().getString("E_MENSAJE");
			    System.out.println("Paso 6");
			    
			    
			} catch (Exception e) {
			    System.out.println("Error:" +e.getMessage());
			    e.printStackTrace();
			}
			
			System.out.println("Salida RFC :"+t_spfli);
			System.out.println("Paso 7");           
			
			
			return t_spfli;
			}	
			///////////	
			//FIN JCO//
			///////////	    
    ///////////////
    //FIN WINDOWS//
    ///////////////
    
    
    
//	public void onClick$btnGrabar1() throws Exception{

//	}
	
	
	public static void llamarSAPUsandoWindows() throws Exception
	{
		String respuesta = LiberarSapPorjco();
		String res_aux;
		res_aux = respuesta;
		System.out.println(res_aux);
		System.out.println("RESPUESTA RFC DE SAP :"+respuesta);	
		Sistema.mensaje("RESPUESTA RFC DE SAP :"+respuesta);	
	}
	

	public static void llamarSAPUsandoLinux() throws Exception
	{
		LiberarCajonesSAP.Linuxconnect();
		LiberarCajonesSAP.Linuxstep3SimpleCall_Opcion1();
	}
	
	
}
