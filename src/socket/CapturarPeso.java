package socket;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import com.nw.util.Sistema;

import java.io.*;
import java.net.*;



public class CapturarPeso extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private static Log logger = LogFactory.getLog(CapturarPeso.class);
	BufferedReader in = null;

	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		
	}

	//Lista Cajones que Harina Receptara = 3
	@SuppressWarnings("unused")
	public String Carpturar()	throws IOException, IOException
	{

		String peso = "";
		try {
			
	        Socket skt = new Socket("192.198.20.246", 10001); //selecciono direccion y puerto del servidor
	        skt.setSoTimeout(1000); //tiempo de espera de respuesta
	        String trama = "";
	        
	        String medida = "";
	        String estable = "";
	        
	        BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	        System.out.print("Received string: '");

	        Integer contador = 0;
           // while(true && contador <= 10){
	        while(true){ 	
            contador = contador + 1;
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
           	 }
              }
               System.out.print("Contador = "+ contador.toString());
	           System.out.print("salida'");
	           trama = in.readLine();
	           if(trama.length()>11){ //verifico trama correcta
	             peso = trama.substring(1, 9);
	             medida = trama.substring(9, 11);
	             estable = trama.substring(11, 12);
	             System.out.println(trama); // Read one line and output it
	             System.out.println(trama.length());
	             System.out.println(peso);
	             System.out.println(medida);
	             System.out.println(estable);  ///"M" en movimiento, "Z" en cero, " " generalmente estable
	             System.out.print("**'\n");
	           }
	           
//	           if(contador <= 299 )
//	           {
	        	   //peso = String.valueOf(contador);
//		           System.out.print("Trama = "+ trama);  
//		           System.out.print("Peso devuelo = "+ peso);
		           return peso;	           
//	           }
	           
           }
	       //in.close();

	      }
	      catch(Exception e) {
	         //System.out.print("Whoops! It didn't work!\n");
	         //peso = "";
	         Sistema.mensaje("No se puede leer la balanza");
	      }
		//return peso; 
		
		return peso;
	}	
}