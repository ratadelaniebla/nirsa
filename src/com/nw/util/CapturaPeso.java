package com.nw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.Socket;
import java.text.DecimalFormat;

public class CapturaPeso {

	public CapturaPeso() {
	}
	
	
	public double getPesoByIpAndPuerto(String ipbalanza, int puerto){
		
		  DecimalFormat df;
		  BufferedReader in = null;
		  Socket skt;	
		//CapturarPeso cp =  new CapturarPeso();
		////////////////////////btnPeso.setDisabled(true);
		//Activamos la bandera 
		Integer bandera=1;
		Integer contador = 0;
		 
		double pesoneto = 0.00;
		@SuppressWarnings("unused")
		String pesoGlobal = "";
		//BufferedReader in = null;
	    
		String peso = "";
		try {
			//////Socket skt = new Socket("192.198.20.81", 10001); //selecciono direccion y puerto del servidor
			 
			skt = new Socket( ipbalanza,puerto);
			try {
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				Sistema.mensaje("No se puedo accesar a la balanza");
			}
	        skt.setSoTimeout(1000); //tiempo de espera de respuesta
	        String trama = "";
	        
	        String medida = "";
	        String estable = "";
	        
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
		        	 pesoneto = 0.00;
		        	  
		         }
		        	 
	             //txtLote.setValue(peso.replace('.',',').trim());
	             medida = trama.substring(9, 11);
	             estable = trama.substring(11, 12);
	             System.out.println(trama); // Read one line and output it
	             System.out.println(trama.length());
	             System.out.println(peso);
	             System.out.println(medida);
	             System.out.println(estable);  ///"M" en movimiento, "Z" en cero, " " generalmente estable
	             System.out.print("**'\n");	             
	           }

	           
		       //Peso neto
		       //////////vpesoneto = (Double.valueOf(peso.trim()) - pesogabetas);
	           if(contador >= 2)
	           {
	        	   //Asignamos el peso neto
		        	  pesoneto = (Double.valueOf(peso) );
	        	   
	        	   //double d = 1.234567;
		             df = new DecimalFormat("#####.##");
		             System.out.print(df.format(peso));
		             
		        	 //Verifica si el peso no es negativo
		             //txtPeso.setValue(String.valueOf(df.format(pesoneto)).replace(',','.').trim());
		             //pesoGlobal = String.valueOf(df.format(pesoneto)).replace(',','.').trim();
		             //txtPeso.setValue
		             pesoGlobal = String.valueOf( (BigDecimal.valueOf(pesoneto)) );
			         in.close();
			         /////////break; 
	           }
	           //////////////btnPeso.setDisabled(false);
	    }
	          in.close();
	 
	        skt.close();
	   }
	   catch(Exception e) {
	    	  //txtpeso.setValue(peso);
	    	    
	    	 pesoGlobal=peso.toString().trim();
	    	 
	    	  //e.printStackTrace();
	    	  System.out.println("Exepcion.!");
	    	 // Sistema.mensaje("No se puede obtener un peso valido");
	    	  //Verificamos si hay basura		  
	          if(peso.toString().trim().equals("&&&&&&&"))
	          {
	        	  //txtPeso.setValue(" ");
	        	  //pesoGlobal = "";
	        	  
	          }
		         else
		         {
			         if(peso.toString().trim().equals("0.0"))
			         {
			        	 //txtPeso.setValue("0.0");
			        	 pesoGlobal = "0.0";
			        	 pesoneto = 0.00;
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
				//txtPeso.setValue(null);
				//txtPeso.setFocus(true);
				pesoGlobal = null;
				pesoneto = 0.00;
				return pesoneto;
			}
	    	  
	    	 return pesoneto;
	     }
		
		return pesoneto;
	}


 
	
}
