package com.nw.webui.produccion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.BarcoCuba;
import com.nw.model.BarcoEstibaCuba;
import com.nw.model.CamaraCajon;
import com.nw.model.Parametro;
import com.nw.model.EspecieTalla;
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.ProduccionCargaLote;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.ProduccionDetalleLoteCajon;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.util.Sistema;


@SuppressWarnings({"unchecked"})
public class EtiquetaImpresion {
	
	private static final String 	IMPRESORA_ZEBRA_IP 		= "192.198.20.185";
/*	private static final String 	IMPRESORA_ZEBRA_IP 		= "192.198.20.165";*/
	private static final int 		IMPRESORA_ZEBRA_PUERTO	= 9100;
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;
    private Parametro parametro;

    public EtiquetaImpresion(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();
    }
    

    public void imprimirEtiquetaEvisceradoDetalleProcesoCoche(Long id, String TipoImpresion) throws UnknownHostException, IOException
    {
		System.out.println("Salida impresión tipo: "+TipoImpresion+" id "+id.toString());
		
		//TODO 0 EJEMPLO DE TX JPA
    	EntityTransaction tx = null;
    	try{

    		tx = em.getTransaction();
    		tx.begin();
    		
	    	EvisceradoDetalleProcesoCoche o = em.find(EvisceradoDetalleProcesoCoche.class, id);
	    	
			if (o != null){
				
				//Sistema.mensaje("Aquiii "+id.toString());
				
				ProduccionDetalleLoteCajon pdlc = o.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon();
				ProduccionDetalleLote pdl = pdlc.getProduccionDetalleLote();
				CamaraCajon cc = pdlc.getCamaraCajon();
				
				EspecieTalla et = em.find(EspecieTalla.class, cc.getEspecieTalla().getIdespecietalla());

				String especie, talla;
				
/*				especie = String.valueOf(et.getEspecie().getNombre().substring(0, 10));*/
				especie = String.valueOf(et.getEspecie().getNombre());
				if (especie.length() > 10) {
					especie = especie.substring(0, 10);
				}
				
				talla = String.valueOf(et.getTalla().getNombre());
				
				
				
				////////////////////////////////////////
				//Si el barco no tiene mezcla de cubas//
				////////////////////////////////////////
				BarcoEstibaCuba b = new BarcoEstibaCuba();
				BarcoCuba bc  = new BarcoCuba(); 
				
				if(cc.getBarcoEstibaCuba() != null)
				{
					//Buscamos el nombre la cuba del barco
					b = em.find(BarcoEstibaCuba.class, cc.getBarcoEstibaCuba().getIdbarcoestibacuba());
					
					/* POR MESCLA DE CUBAS*/
					bc = em.find(BarcoCuba.class,b.getIdbarcocuba());
				}
				//////////////////////////////////////////
				//Fin el barco no tiene mezcla de cubas//
				/////////////////////////////////////////
				
				
				
				List <ProduccionCargaLote> pcls = em.createQuery(
						"select pcl from ProduccionCargaLote pcl where pcl.produccionArchivoCargaLote.produccion.idproduccion = " + 
								pdl.getProduccion().getIdproduccion()).getResultList();
	
				// Leer el primero de la lista
				ProduccionCargaLote pcl = pcls.get(0);
				
				DateFormat sdf = new SimpleDateFormat(Sistema.FORMATO_FECHA_DMY);
    		
		    	Socket clientSocket = new Socket(IMPRESORA_ZEBRA_IP, IMPRESORA_ZEBRA_PUERTO);
			    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
//			    StringBuilder sb = new StringBuilder();
//			    sb.append("^XA "); 
//			    sb.append(String.format("^FO220,100 ^BY3 ^BCR,100,Y,N,N ^FD %s ^FS ", id)); 
//			    sb.append(String.format("^FO170,100^ADR,24,15^FD %s ^FS ", sdf.format( o.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getFechaproduccion()))); 
//			    sb.append(String.format("^FO170,600^ADR,24,15^FD %s ^FS ", o.getIdcoche() )); 
//			    sb.append(String.format("^FO140,100^ADR,24,15^FD %s ^FS ", pdl.getBarcoDescarga().getBarco().getNombre() )); 
////			    sb.append(String.format("^FO140,600^ADR,24,15^FD %s ^FS ", cc.getBarcoEstibaCuba().getBarcoCuba().getCuba().getNombrecuba())); 
//			    sb.append(String.format("^FO140,600^ADR,24,15^FD %s ^FS ", bc.getCuba().getNombrecuba()));
//			    sb.append(String.format("^FO110,100^ADR,24,15^FD %s ^FS ", et.getEspecie().getNombre() + " " + et.getTalla().getNombre() )); 
//			    sb.append(String.format("^FO110,600^ADR,24,15^FD %s ^FS ", pdl.getIdlote() )); 
//			    sb.append(String.format("^FO80,100^ADR,24,15^FD %s ^FS ", ( pcl.getDestinos()==null ? "No definido" :  pcl.getDestinos() ))); 
//			    sb.append(String.format("^FO50,100^ADR,24,15^FD %s ^FS ", ( pcl.getOrigen()==null ? "No definido" :  pcl.getOrigen() ))); 
//			    sb.append(String.format("^FO20,100^ADR,24,15^FD %s ^FS ", Sistema.parseDouble(""+o.getPeso()) ));
//			    sb.append(String.format("^FO20,600^ADR,24,15^FD %s ^FS ", Sistema.parseDouble(""+o.getTara()) )); 
//			    sb.append("^XZ ");
//			    
////
			    
				//Obtenemos la posición desde donde se imprimira la etiqueta
				parametro = new ParametroDAOJpaImpl().getParametroById("8");
			    //Integer fila = Integer.valueOf(String.valueOf(parametro.getValor()));	
				
				//Convetimos un double y extraemos la parte entera
			    int fila = (int) Math.floor(parametro.getValor());

				
			    StringBuilder sb = new StringBuilder();
			    
			    //sb.append(String.format("^FO220,%s ^BY3 ^BCR,100,Y,N,N ^FD %s ^FS ", fila, String.valueOf(id).trim()));
			       String codigo;
			       codigo = String.valueOf(o.getCodbarra()).trim();

			       int totcanastillas = 0;
			       int totadicionales = 0;
			       
			       if (o.getPescadoadicional()>0){
			    	   totcanastillas = o.getCanastillas()+1;
			    	   totadicionales = o.getPescadoadicional();
			       }
			       else {
			    	   totcanastillas = o.getCanastillas();
			    	   totadicionales = 0;
			       }
			       
			       
			       int totpescados = ((o.getEvisceradoPescadosLata().getCantidad())*(o.getCanastillas())) + totadicionales;
			       
			       //Integer fila = 865;
			       //int fila =  (865);
			       String fecha;
			       
/*			       fecha = o.getFechareg().toString();*/
			       Integer hora,minuto;
			       hora = o.getFechareg().getHours();
			       minuto = o.getFechareg().getMinutes();
			       String horas,minutos;
			       horas = hora.toString();
			       minutos = minuto.toString();
			       
			       if (hora < 10){
			    	   horas = "0"+horas;
			       }
			       
			       if (minuto < 10){
			    	   minutos = "0"+minutos;
			       }
			       

			       
			       fecha = horas + ":" + minutos;
			       
			       sb.append("^XA "); 
			       sb.append(String.format("^FO220,%s ^BY3 ^BCR,100,Y,N,N ^FD %s ^FS ", fila, String.valueOf(codigo))); 

			       
			       
			       try 
			       {
					sb.append(String.format("^FO265,%s^ADR,24,15^FD %s ^FS ",  fila+350,  o.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon().getCamaraCajon().getTipoCaptura().getDescripcion().trim() ));
			       } 
			       catch (Exception e) 
			       {
					// TODO Auto-generated catch block
					//e.printStackTrace();
			       }

			       
			       			       
			       sb.append(String.format("^FO220,%s^ADR,24,15^FD %s ^FS ",  fila+350,  TipoImpresion )); 

			       sb.append(String.format("^FO220,%s^ADR,24,15^FD %s ^FS ",  fila+500,  o.getIdcochelote())); 
			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila,   sdf.format( o.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getFechaproduccion()))); 
			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila+350,  o.getEvisceradoPescadosLata().getEspecificacion())); 
			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila+500,  totcanastillas+"-"+ totpescados )); 
			       //sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila+500,  o.getIdcoche() )); 

                   sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ",  fila,   pdl.getBarcoDescarga().getBarco().getNombre() ));   

                   

   				////////////////////////////////////////
   				//Si el barco no tiene mezcla de cubas//
   				////////////////////////////////////////                   
	   				if(cc.getBarcoEstibaCuba() != null)
	   				{
	                    /* POR MESCLA DE CUBAS*/
	 			       sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ", fila+500, bc.getCuba().getNombrecuba()));
	   				}
	   			////////////////////////////////////////////
	   			//Fin si el barco no tiene mezcla de cubas//
	   			////////////////////////////////////////////                   
	   				
   				
   				
                   
			       
/*			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila,  et.getEspecie().getNombre().substring(0, 10) + " " + et.getTalla().getNombre() ));*/ 
			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila,  String.valueOf(especie) + " " + String.valueOf(talla) )); 
/*			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila,  et.getEspecie().getNombre() + " " + et.getTalla().getNombre() ));*/ 
			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila+500, pdl.getIdlote() )); 
			       sb.append(String.format("^FO80,%s^ADR,24,15^FD %s ^FS ",  fila,  ( pdl.getDestinos()==null ? "No definido" :  pdl.getDestinos() )));
/*			       sb.append(String.format("^FO80,%s^ADR,24,15^FD %s ^FS ",  fila,  ( pdl.getDestinos()==null ? "No definido" :  pdl.getDestinos().substring(0, 20) )));*/ 
			       sb.append(String.format("^FO50,%s^ADR,24,15^FD %s ^FS ",  fila,  ( pdl.getOrigen()==null ? "No definido" :  pdl.getOrigen() ))); 
			       sb.append(String.format("^FO50,%s^ADR,24,15^FD %s ^FS ",  fila+300,  fecha)); 
			       sb.append(String.format("^FO50,%s^ADR,24,15^FD %s ^FS ",  fila+500,  (String.valueOf(o.getCocinaAperturaCierreDetalle().getCocina().getIdcocina() +"/"+String.valueOf(o.getCocinaAperturaCierreDetalle().getNumerococinadageneral()))))); 
			       sb.append(String.format("^FO20,%s^ADR,24,15^FD %s ^FS ",  fila,  Sistema.parseDouble(""+o.getPeso()) ));
			       sb.append(String.format("^FO20,%s^ADR,24,15^FD %s ^FS ",  fila+500, Sistema.parseDouble(""+o.getTara()) )); 
			       sb.append("^XZ ");			    
////		
			       
			       //sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ",  fila+500, cc.getBarcoEstibaCuba().getBarcoCuba().getCuba().getNombrecuba())); 
			       //sb.append(String.format("^FO140,600^ADR,24,15^FD %s ^FS ", bc.getCuba().getNombrecuba()));			       
			    
			    outToServer.writeBytes( sb.toString() );
			    clientSocket.close();
	    	}else
	    		Sistema.mensaje("Identificación de coche de proceso de Eviscerado no encontrado...");
    	
			tx.commit();
    	}catch(Exception ex) {
    		if(tx != null && tx.isActive()) tx.rollback();
    	}finally {
    		em.close();
    	}
	}		
		
		
//		//TODO 0 EJEMPLO DE TX JPA
//    	EntityTransaction tx = null;
//    	try{
//
//    		tx = em.getTransaction();
//    		tx.begin();
//    		
//	    	EvisceradoDetalleProcesoCoche o = em.find(EvisceradoDetalleProcesoCoche.class, id);
//	    	
//			if (o != null){
//				
//				//Sistema.mensaje("Aquiii "+id.toString());				
//				ProduccionDetalleLoteCajon pdlc = o.getEvisceradoDetalleProceso().getProduccionDetalleLoteCajon();
//				ProduccionDetalleLote pdl = pdlc.getProduccionDetalleLote();
//				CamaraCajon cc = pdlc.getCamaraCajon();
//				
//				EspecieTalla et = em.find(EspecieTalla.class, cc.getEspecieTalla().getIdespecietalla());
//				
//				//Buscamos el nombre la cuba del barco
//				BarcoEstibaCuba b = em.find(BarcoEstibaCuba.class, cc.getBarcoEstibaCuba().getIdbarcoestibacuba()); 
//				BarcoCuba bc = em.find(BarcoCuba.class,b.getIdbarcocuba());
//				
//				
//				List <ProduccionCargaLote> pcls = em.createQuery(
//						"select pcl from ProduccionCargaLote pcl where pcl.produccionArchivoCargaLote.produccion.idproduccion = " + 
//								pdl.getProduccion().getIdproduccion()).getResultList();
//	
//				// Leer el primero de la lista
//				ProduccionCargaLote pcl = pcls.get(0);
//				
//				DateFormat sdf = new SimpleDateFormat(Sistema.FORMATO_FECHA_DMY);
//    		
//		    	Socket clientSocket = new Socket(IMPRESORA_ZEBRA_IP, IMPRESORA_ZEBRA_PUERTO);
//			    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
//		
//			    
//				//Obtenemos la posición desde donde se imprimira la etiqueta
//				parametro = new ParametroDAOJpaImpl().getParametroById("8");
//			    //Integer fila = Integer.valueOf(String.valueOf(parametro.getValor()));	
//				
//				//Convetimos un double y extraemos la parte entera
//			    int fila = (int) Math.floor(parametro.getValor());
//
//				
//			    StringBuilder sb = new StringBuilder();
//			    
//			       String codigo;
//			       codigo = String.valueOf(o.getCodbarra()).trim();
//
//			       int totcanastillas = 0;
//			       int totadicionales = 0;
//			       
//			       if (o.getPescadoadicional()>0){
//			    	   totcanastillas = o.getCanastillas()+1;
//			    	   totadicionales = o.getPescadoadicional();
//			       }
//			       else {
//			    	   totcanastillas = o.getCanastillas();
//			    	   totadicionales = 0;
//			       }
//			       
//			       
//			       int totpescados = ((o.getEvisceradoPescadosLata().getCantidad())*(o.getCanastillas())) + totadicionales;
//			       
//			       sb.append("^XA "); 
//			       sb.append(String.format("^FO220,%s ^BY3 ^BCR,100,Y,N,N ^FD %s ^FS ", fila, String.valueOf(codigo))); 
//			       sb.append(String.format("^FO220,%s^ADR,24,15^FD %s ^FS ",  fila+500,  o.getIdcochelote())); 
//			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila,   sdf.format( o.getEvisceradoDetalleProceso().getEvisceradoProceso().getProduccion().getFechaproduccion()))); 
//			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila+350,  o.getEvisceradoPescadosLata().getEspecificacion())); 
//			       sb.append(String.format("^FO170,%s^ADR,24,15^FD %s ^FS ",  fila+500,  totcanastillas+"-"+ totpescados )); 
//
//			       if(TipoImpresion.equals("P"))
//                   {
//                      sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ",  fila,   "PRUEBA" ));
//                   } 
//                   else
//                   {
//                      sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ",  fila,   pdl.getBarcoDescarga().getBarco().getNombre() ));   
//                   }
//
//			       sb.append(String.format("^FO140,%s^ADR,24,15^FD %s ^FS ", fila+500, bc.getCuba().getNombrecuba()));			
//			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila,  et.getEspecie().getNombre() + " " + et.getTalla().getNombre() )); 
//			       sb.append(String.format("^FO110,%s^ADR,24,15^FD %s ^FS ",  fila+500, pdl.getIdlote() )); 
//			       sb.append(String.format("^FO80,%s^ADR,24,15^FD %s ^FS ",  fila,  ( pdl.getDestinos()==null ? "No definido" :  pdl.getDestinos() ))); 
//			       sb.append(String.format("^FO50,%s^ADR,24,15^FD %s ^FS ",  fila,  ( pdl.getOrigen()==null ? "No definido" :  pdl.getOrigen() ))); 
//			       sb.append(String.format("^FO50,%s^ADR,24,15^FD %s ^FS ",  fila+500,  o.getCocina().getIdcocina())); 
//			       sb.append(String.format("^FO20,%s^ADR,24,15^FD %s ^FS ",  fila,  Sistema.parseDouble(""+o.getPeso()) ));
//			       sb.append(String.format("^FO20,%s^ADR,24,15^FD %s ^FS ",  fila+500, Sistema.parseDouble(""+o.getTara()) )); 
//			       sb.append("^XZ ");			    
//			    
//			    outToServer.writeBytes( sb.toString() );
//			    clientSocket.close();
//	    	}else
//	    		Sistema.mensaje("Identificación de coche de proceso de Eviscerado no encontrado...");
//    	
//			tx.commit();
//    	}catch(Exception ex) {
//    		if(tx != null && tx.isActive()) tx.rollback();
//    	}finally {
//    		em.close();
//    	}
//	}
    
}
