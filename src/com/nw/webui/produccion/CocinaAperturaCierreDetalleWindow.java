package com.nw.webui.produccion;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.Cocina;
import com.nw.model.CocinaAperturaCierreDetalle;
import com.nw.model.Produccion;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CocinaDAOJpaImpl;
import com.nw.model.dao.impl.CocinaAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CocinaAperturaCierreDetalleWindow extends GenericForwardComposer {

	/**
	 * Desarrollado por Leonardo Moya Paredes
	 * leofabricio.mp3@gmail.com 
	 */
	
	private Listbox lbxCocina,lbxFechaActiva,lbxOpciones;
	//private Toolbarbutton btnGrabar;
	Textbox txtCocinada;
	boolean estadoCerrar;
	Cocina cocina;
	Produccion produccion;
	CocinaAperturaCierreDetalle cocinaACD = new CocinaAperturaCierreDetalle();
	CocinaDAOJpaImpl cocinaDaoIMP = new CocinaDAOJpaImpl();
	CocinaAperturaCierreDAOJpaImpl cocinaDetDaoIMP = new CocinaAperturaCierreDAOJpaImpl();
	List<Object> lista = new ArrayList<Object>();
	
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		limpiarDatos();
		obtenerOpciones();
		
		cargaListaFechaProduccionActiva();
	}
	
	public void cargaListaFechaProduccionActiva(){
		lbxFechaActiva.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxFechaActiva);
				
		//List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActiva();
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaEviscerdo();
		
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
	
	public void obtenerOpciones(){
		
		lista.add("Abrir");
		lista.add("Cerrar");
		lista.add("Reapertura");
		lista.add("Finalizar Cocinada");
		Listitem li = new Listitem();
		li.setValue(new Object());
		li.setParent(lbxOpciones);
		
		try {
			
			for (Object opcion : lista) {
				li = new Listitem();
				li.setValue(opcion);
				li.setParent(lbxOpciones);
				new Listcell(String.valueOf(opcion.toString()) ).setParent(li);
				li.setParent(lbxOpciones);
			}
			lbxOpciones.setSelectedIndex(0);
		} catch (Exception e) {
			System.out.println("paso esto-->");
		}
	}
	public void obtenerCocinas()
	{
		try {
			//Long num=(long) 0;
			lbxCocina.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxCocina);
			//caso 1 abrir se carga la lista concocinas con estado 1
			if (lbxOpciones.getSelectedIndex()==1){	
				List<Cocina> listaCocinas = new CocinaDAOJpaImpl().obtenerCocinas(produccion);
				//List<CocinaAperturaCierreDetalle> listaCocinas = cocinaDetDaoIMP.obtenerCocinasAbrir(produccion);
//				cargarCocinada();
				for (Cocina cocina : listaCocinas) {
					Long nu=(long) 1;
					nu= nu+cocinaDetDaoIMP.obtenerTotalCocinas(cocina.getIdcocina(), produccion);
					li = new Listitem();
					li.setValue(cocina);
					li.setParent(lbxCocina);
//					new Listcell(String.valueOf(cocina.getDescripcion()+" (cocinada "+nu+")")).setParent(li);
					new Listcell(String.valueOf(cocina.getDescripcion())).setParent(li);
					li.setParent(lbxCocina);
				}
				lbxCocina.setSelectedIndex(0);
				//TODO
				//caso 2 cerrar se carga la lista cocinaDetalleProceso con estado 1
			}else if (lbxOpciones.getSelectedIndex()==2){
				List<CocinaAperturaCierreDetalle> listaCocinas = cocinaDetDaoIMP.obtenerCocinasDetalle(produccion);
				
				for (CocinaAperturaCierreDetalle cocinaDet : listaCocinas) {
					estadoCerrar=false;
					li = new Listitem();
					li.setValue(cocinaDet);
					li.setParent(lbxCocina);
//					if(cocinaDet.getEstado()==3){
//						new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion()+" (Reaperturado" +cocinaDet.getNumerococinada()+")") ).setParent(li);
//					}else{
//						new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion()+" (cocinada "+cocinaDet.getNumerococinada()+")") ).setParent(li);
//					}
					new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion())).setParent(li);
					//new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion())+" (cocinada "+cocinaDet.getNumerococinada()+")" ).setParent(li);
					li.setParent(lbxCocina);
				}
				lbxCocina.setSelectedIndex(0);
			}else if (lbxOpciones.getSelectedIndex()==3){
				//caso 3 repeaturar abrir  se carga la lista cocinaDetalleProceso con estado_cocinada 0y 1
				List<CocinaAperturaCierreDetalle> listaCocinas = cocinaDetDaoIMP.obtenerCocinasReaperturar(produccion);
				
				for (CocinaAperturaCierreDetalle cocinaDet : listaCocinas) {
					li = new Listitem();
					li.setValue(cocinaDet);
					li.setParent(lbxCocina);
//					new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion())+" (cocinada "+cocinaDet.getNumerococinada()+")" ).setParent(li);
					new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion())).setParent(li);
					li.setParent(lbxCocina);
				}
				lbxCocina.setSelectedIndex(0);
				
			}
			else if (lbxOpciones.getSelectedIndex()==4){
				//caso 4 repeaturar cerrar se carga la lista cocinaDetalleProceso con estado_cocinada 0y 1
				List<CocinaAperturaCierreDetalle> listaCocinas = cocinaDetDaoIMP.obtenerFinalizarCocinada(produccion);
				
				for (CocinaAperturaCierreDetalle cocinaDet : listaCocinas) {
					//num=cocinaDetDaoIMP.obtenerTotalCocinas(cocinaDet.getCocina().getIdcocina(),produccion);
					li = new Listitem();
					li.setValue(cocinaDet);
					li.setParent(lbxCocina);
//					if(cocinaDet.getEstado()==3){
////						new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion()+" Reaperturado") ).setParent(li);
//						
//					}else{
////						new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion()+" (cocinada "+cocinaDet.getNumerococinada()+")") ).setParent(li);
//					}
					new Listcell(String.valueOf(cocinaDet.getCocina().getDescripcion())).setParent(li);
					li.setParent(lbxCocina);
				}
				lbxCocina.setSelectedIndex(0);
				
			}

		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	
	public void onSelect$lbxFechaActiva() throws InterruptedException{
		
		if (lbxFechaActiva.getSelectedIndex()<=0) {
			limpiarDatos();
			produccion=null;
			txtCocinada.setValue(null);
		}else{
			produccion = new Produccion();
			produccion= (Produccion) lbxFechaActiva.getSelectedItem().getValue();
//			cargarCocinada();
		}
	}
	
	public void cargarCocinada(){
		
//		CocinaAperturaCierreDetalle loc_cocinaACD;
		List<CocinaAperturaCierreDetalle> cocinas = new ArrayList<CocinaAperturaCierreDetalle>();
//		loc_cocinaACD=cocinaDetDaoIMP.obtenerCocinaMaxNumero(produccion, cocina);
		if(produccion!=null){
			cocinas=cocinaDetDaoIMP.obtenerCocinaNumero1(produccion);
//			if((loc_cocinaACD!=null)&& loc_cocinaACD.getNumerococinadageneral()!=null){
//				txtCocinada.setText(String.valueOf(loc_cocinaACD.getNumerococinadageneral()+1));	
//			}else{
//				txtCocinada.setText(String.valueOf(1));
//			}
			if(cocinas!=null){
				txtCocinada.setValue(String.valueOf(cocinas.size()+1));
			}
		}
		
	}
	
	public void onSelect$lbxOpciones() throws InterruptedException{
		if (produccion==null){
			Sistema.mensaje("No se ha escogido la Fecha de Produccion.. no puede continuar");
			limpiarDatos();
			return;
		}
		if (lbxOpciones.getSelectedIndex()>0) {
			obtenerCocinas();
			
		}else{
			lbxCocina.getItems().clear();
			cocina = null;
		}
	}
	
	public void onSelect$lbxCocina() throws InterruptedException{
		
		if (lbxOpciones.getSelectedIndex()==1) {
			if (lbxCocina.getSelectedIndex()>=1) {
				cocina = new Cocina();
				cocina = (Cocina) lbxCocina.getSelectedItem().getValue();
			}
			if(cocina.getIdcocina()!=99 || cocina.getIdcocina()!=88){
				cargarCocinada();
			}
			
			
			
		}else 
		if (lbxOpciones.getSelectedIndex()>=1) {
			cocinaACD  = new CocinaAperturaCierreDetalle();
			cocinaACD = (CocinaAperturaCierreDetalle) lbxCocina.getSelectedItem().getValue();
			if(cocinaACD.getNumerococinadageneral()!=null)
			txtCocinada.setText(String.valueOf(cocinaACD.getNumerococinadageneral()));
		}else{
			cocinaACD=null;
			Sistema.mensaje("Debe escoger una cocina");
		}
	}
	
	
	
	public void onClick$btnGrabar() throws InterruptedException{
		grabar();
	}
	
	public void grabar()
	{	
		
		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		
		if (lbxFechaActiva.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido la Fecha de Produccion.. no puede grabar");
			lbxFechaActiva.focus();
			return;
		}
		
		if (lbxOpciones.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido Abrir/Cerrar/Habilitar.. no puede grabar");
			lbxOpciones.focus();
			return;
		}
		
		if (lbxCocina.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido la Cocina.. no puede grabar");
			return;
		}
		
		
		if (usuario==null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
//			usu.setIdusuario("aaguirre");
		}
		
		CocinaAperturaCierreDetalle loc_cocina = new CocinaAperturaCierreDetalle();
//		CocinaAperturaCierreDetalle loc_cocinada = new CocinaAperturaCierreDetalle();
//		CocinaAperturaCierreDetalle loc_cocinaACD = new CocinaAperturaCierreDetalle();
		int numero=0;
		List<CocinaAperturaCierreDetalle> cocinas = new ArrayList<CocinaAperturaCierreDetalle>();
		List<CocinaAperturaCierreDetalle> listCocinaACD = new ArrayList<CocinaAperturaCierreDetalle>();
		cocinas=cocinaDetDaoIMP.obtenerCocinaMaxNumero1(produccion, cocina);
//		CocinaAperturaCierreDetalle cocinas = new CocinaAperturaCierreDetalle();
		listCocinaACD = cocinaDetDaoIMP.obtenerCocinaNumero1(produccion);
		
//		if ((loc_cocinaACD!=null)&& loc_cocinaACD.getNumerococinada()!=null){
//			numero=loc_cocinaACD.getNumerococinada()+1;
//		}else{
//			numero=1;
//		}
		if (cocinas!=null){
			numero=cocinas.size()+1;
		}
		
		if (lbxOpciones.getSelectedIndex()==1){
			loc_cocina.setCocina(cocina);
			
			loc_cocina.setHorainicio(new java.sql.Timestamp(new Date().getTime()));
			loc_cocina.setProduccion(produccion);
			loc_cocina.setEstado(1);
			if(cocina.getIdcocina().equals(99) || cocina.getIdcocina().equals(88)){
				Sistema.mensaje("no registra");
			}else{
				loc_cocina.setNumerococinada(numero);
				loc_cocina.setNumerococinadageneral(listCocinaACD.size()+1);
			}
			
			loc_cocina.setEstadococinada(0);
			loc_cocina.setUsuario(usu);
			
			cocinaDetDaoIMP.saveOrUpdate(loc_cocina);
			//TODO
			
			//cocina.setEstado(1);
			//cocinaDaoIMP.saveOrUpdate(cocina);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		
		}else if (lbxOpciones.getSelectedIndex()==2){
			loc_cocina= cocinaACD;
			loc_cocina.setHorafin(new java.sql.Timestamp(new Date().getTime()));
			loc_cocina.setProduccion(produccion);
			loc_cocina.setEstadococinada(1);
			//loc_cocina.setNumero(numero);
			
			loc_cocina.setEstado(2);
			cocinaDetDaoIMP.saveOrUpdate(loc_cocina);
//			cocina=cocinaACD.getCocina();
//			cocina.setEstado(0);
//			cocinaDaoIMP.saveOrUpdate(cocina);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		
		}else if (lbxOpciones.getSelectedIndex()==3){
			loc_cocina= cocinaACD;
			loc_cocina.setHorafin(new java.sql.Timestamp(new Date().getTime()));
			//loc_cocina.setProduccion(produccion);
			//loc_cocina.setNumero(numero);
			loc_cocina.setEstado(3);
			cocinaDetDaoIMP.saveOrUpdate(loc_cocina);
//			cocina=loc_cocina.getCocina();
//			cocina.setEstado(1);
//			cocinaDaoIMP.saveOrUpdate(cocina);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		
		}
		else if (lbxOpciones.getSelectedIndex()==4){
			loc_cocina= cocinaACD;
			//loc_cocina.setProduccion(produccion);
			//loc_cocina.setNumero(numero);
			loc_cocina.setEstado(4);
			loc_cocina.setEstadococinada(2);
			loc_cocina.setFechafincocinada(new java.sql.Timestamp(new Date().getTime()));
			cocinaDetDaoIMP.saveOrUpdate(loc_cocina);
//			cocina=loc_cocina.getCocina();
//			cocina.setEstado(0);
//			
//			cocinaDaoIMP.saveOrUpdate(cocina);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
		
		}
		

		limpiarDatos();	
		
		
		
	}
	
	void limpiarDatos()
	{
		if (lbxOpciones.getSelectedIndex()>=0){	
				lbxOpciones.setSelectedIndex(0);
			}
		lbxCocina.getItems().clear();
		cocina = new Cocina();
		cocinaACD = new CocinaAperturaCierreDetalle();
		lbxFechaActiva.focus();
		cargarCocinada();
	}
	
}
