package com.nw.webui.produccion;

import java.io.IOException;
import java.text.DateFormat;
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
import com.nw.model.EvisceradoDetalleProcesoCoche;
import com.nw.model.Produccion;
import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.CoccionDetalleProcesoCocheDAOJpaImpl;
import com.nw.model.dao.impl.CocinaAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.EvisceradoDetalleProcesoCocheDAOJpaImpl;
import com.nw.util.Sistema;

@SuppressWarnings("serial")
public class CoccionAsignacionDetalleProcesoCochesWindow extends GenericForwardComposer {


	private Textbox txtCocinada, txtCocheCocina, txtCoche;
	Date fechaActual = new Date();
	private Listbox lbxCocina;
	
	Date fecha;
	Long idproduccion;
	Turno turno;
	Double pesoneto ;
	String pesoGlobal;
	
	EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	List<EvisceradoDetalleProcesoCoche> listEdpc= new ArrayList<EvisceradoDetalleProcesoCoche>();
	CocinaAperturaCierreDAOJpaImpl cocinaDetDaoIMP = new CocinaAperturaCierreDAOJpaImpl();
	EvisceradoDetalleProcesoCocheDAOJpaImpl evisceradoDetalleProcesoCocheDAOJpaImpl = new EvisceradoDetalleProcesoCocheDAOJpaImpl();
	DateFormat df3 = DateFormat.getDateInstance(DateFormat.LONG); //SHORT, MEDIUM, LONG, FULL
	Produccion produccion;
	Cocina cocina;
	CocinaAperturaCierreDetalle cocinaACD = new CocinaAperturaCierreDetalle();
	
	String valorCocheCodigoBarra = "";
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		cargarLimpiarControles();
		cargarCocinas();
	}



	public void onSelect$lbxCocina() {
		txtCocinada.setText("");
		txtCocheCocina.setText("");
		
		if (lbxCocina.getSelectedIndex() > 0) {
			Long id  = Long.valueOf(lbxCocina.getSelectedItem().getId());	
			//EvisceradoDetalleProcesoCoche lis = evisceradoDetalleProcesoCocheDAOJpaImpl.getEvisceradoDetalleProcesoCocheId(id);
			CocinaAperturaCierreDetalle lis = new CoccionDetalleProcesoCocheDAOJpaImpl().getCocinaAperturaCierreDetalleById(id);

			// vaciamos el objeto creando una nueva instancia
			cocinaACD  = new CocinaAperturaCierreDetalle();
			//cocinaACD = (CocinaAperturaCierreDetalle) lbxCocina.getSelectedItem().getValue();
			cocinaACD = lis;
			cocina=cocinaACD.getCocina();
			
			if(cocinaACD.getNumerococinadageneral()!=null){				
				txtCocinada.setValue(cocinaACD.getNumerococinadageneral().toString());
			}
			else
				{
					txtCocinada.setValue(null);
				}

			
			if (cocinaACD==null)
			{
				Sistema.mensaje("Escoja una Cocina");
				return;
			}

			//CocinaAperturaCierreDetalle lis =
			int numcocina = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getTotalCochesEnCocina(lis.getIdcocinaaperturacierredetalle()).size();
			txtCocheCocina.setValue("" + numcocina);
			txtCoche.setFocus(true);
		} else {
			cocina = null;
		}
	}
	
	
	
	
	
    public void onClick$btnActualizarCocinas(){
        cargarCocinas();
        cocina=null;
    }

    
	public void cargarCocinas()
	{
		txtCocinada.setText("");
		txtCocheCocina.setText("");

		lbxCocina.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Cocina());
		li.setParent(lbxCocina);

		List<Object[]> results = cocinaDetDaoIMP.obtenerCocinasReaperturarCerrar1();

		for (Object[] result : results) {
			Long id = (Long) result[0];
		    int cocina = ((Number) result[1]).intValue();
		    
			li = new Listitem();
			//li.setValue(cocinaDet);
			li.setParent(lbxCocina);
			li.setId(id.toString());
			//new Listcell("No -> "+String.valueOf(cocinaDet.getCocina().getDescripcion())+" "+ "(Cocinada"+String.valueOf(cocinaDet.getNumerococinadageneral())+")").setParent(li);//Integer.valueOf(bd+"")+""
			new Listcell("No -> "+String.valueOf(cocina)).setParent(li);//Integer.valueOf(bd+"")+""
			li.setParent(lbxCocina);
		}
		lbxCocina.setSelectedIndex(0);
	}
	
	
	public void onClick$btnLimpiarCoche(){

		txtCoche.focus();
		txtCoche.setText("");
	}


	public void onClick$btnGrabar() throws InterruptedException, IOException
	{
		
		if (lbxCocina.getSelectedIndex() == 0)
		{
			lbxCocina.setFocus(true);
			Sistema.mensaje("Debe seleccionar una cocina");
			return;
		}	
		
		if (txtCoche.getValue()==null||txtCoche.getValue().trim().equals("")) 
		{
			txtCoche.setFocus(true);
			Sistema.mensaje("Debe ingresar un numero de coche");
			return;
		}
		valorCocheCodigoBarra = "";
		valorCocheCodigoBarra = txtCoche.getValue().trim();
			 
		System.out.println("**********valor de coche Ingresado ->"+valorCocheCodigoBarra);
		
		grabar();
	}
	
	public void grabar() throws InterruptedException, IOException
	{
//				evisceradoDetalleProcesoCoche = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getEvisceradoDetalleProcesoCocheByCodBarra(Long.valueOf(valorCocheCodigoBarra));
//				if(evisceradoDetalleProcesoCoche!=null){
//					if(evisceradoDetalleProcesoCoche.getIdcocheprincipal()!=null){
//						listEdpc = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getListaEvisceradoDetalleProcesoCocheByCodBarra(evisceradoDetalleProcesoCoche.getIdcocheprincipal());
//					}else{
//						listEdpc = new EvisceradoDetalleProcesoCocheDAOJpaImpl().getListaEvisceradoDetalleProcesoCocheByCodBarra(evisceradoDetalleProcesoCoche.getIdevisceradodetalleprocesocoche());
//					}
//				}
//				
//				if (evisceradoDetalleProcesoCoche==null){
//					Sistema.mensaje("coche no existe");
//					return;
//				}
//			
//			
//				if (valorCocheCodigoBarra.equals("")) 
//				{
//					pesoGlobal="";
//					Sistema.mensaje("no existe un número de coche para buscar");
//					return;
//				}
		grabarRegistro();			

		onSelect$lbxCocina();
		onClick$btnLimpiarCoche();
		onClick$btnLimpiarCoche();
		
	}
	
	
	public void grabarRegistro() throws InterruptedException, IOException{
		
		valorCocheCodigoBarra =  txtCoche.getText().trim();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		System.out.println("valor de variable usuario-->"+usuario);

		if (valorCocheCodigoBarra.isEmpty())
		{
			Sistema.mensaje("Ingrese un coche valido");
			txtCoche.setFocus(true);
			return;
		}	
		
		
		EvisceradoDetalleProcesoCoche evisceradodetalleprocesocoche = new EvisceradoDetalleProcesoCoche();
		
		try {
			evisceradodetalleprocesocoche = new CoccionDetalleProcesoCocheDAOJpaImpl().VerificarCocheReceptadoEnCocina11(Long.valueOf(valorCocheCodigoBarra));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(evisceradodetalleprocesocoche == null)
		{
			Sistema.mensaje("coche no existe en el proceso actual");
			return;
		}


		//Verifica si el coche fue receptado anteriormente 
		if(evisceradodetalleprocesocoche.getFecharegrecepcocheconica() != null)			
		{
			Sistema.mensaje("Coche ya fue receptado en Cocina :"+evisceradodetalleprocesocoche.getCocinaAperturaCierreDetalle().getCocina().getDescripcion()+" cocinada :"+evisceradodetalleprocesocoche.getCocinaAperturaCierreDetalle().getNumerococinadageneral().toString());
			return;
		}

		
		usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		Usuario u = new Usuario();
		u.setIdusuario(usuario);		
		evisceradodetalleprocesocoche.setIdusuariorecepcocheconica(u.getIdusuario());
		evisceradodetalleprocesocoche.setFecharegrecepcocheconica(new java.sql.Timestamp(new Date().getTime()));		
		evisceradodetalleprocesocoche.setIdcocinarecepcocheconica(cocinaACD.getCocina().getIdcocina());
		evisceradodetalleprocesocoche.setIdcocinaaperturacierredetallerecepcocheconica(cocinaACD.getIdcocinaaperturacierredetalle());
		
		
		try {
			new EvisceradoDetalleProcesoCocheDAOJpaImpl().saveOrUpdate(evisceradodetalleprocesocoche);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		
		System.out.println("Transaccion grabada");

		Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA+" "+valorCocheCodigoBarra);
		txtCoche.setValue(null);
		cargarLimpiarControles();
		onClick$btnLimpiarCoche();
		onSelect$lbxCocina();
		txtCoche.focus();
		txtCoche.setFocus(true);
	}
	
	
	public void cargarLimpiarControles(){
		produccion = null;
	}


}
