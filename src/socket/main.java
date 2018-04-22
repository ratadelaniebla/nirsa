package socket;
import java.io.*;
import java.net.*;

public class main {
	BufferedReader in = null;
	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		
		try {
	         Socket skt = new Socket("192.198.20.246", 10001); //selecciono direccion y puerto del servidor
	         skt.setSoTimeout(1000); //tiempo de espera de respuesta
	         String trama = "";
	         String peso = "";
	         String medida = "";
	         String estable = "";
	         BufferedReader in = new BufferedReader(new
	        
	         InputStreamReader(skt.getInputStream()));
	         System.out.print("Received string: '");
	       
              while(true){
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
            }
	         //in.close();
	      }
	      catch(Exception e) {
	         System.out.print("Whoops! It didn't work!\n");
	      }
	}
}