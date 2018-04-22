package com.nw.webui.produccion;



import java.awt.Button;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import com.nw.model.Empleado;
import com.nw.model.Parametro;
import com.nw.model.Produccion;
import com.nw.model.Cocina;
import com.nw.model.dao.impl.ParametroDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.CocinaDAOJpaImpl;
import com.nw.util.Fecha;
import com.nw.util.Sistema;
import com.nw.webui.produccion.impresion.CalidadImpresion;

@SuppressWarnings("serial")
public class CoccionLecturaImagenesImpresionWindow extends GenericForwardComposer {

	Cocina cocina;
	
	private Listbox lbxCocina,lbxCocinada;
	private Datebox dteFecha;
	@SuppressWarnings("unused")
	private Button btnGrabar;
	@SuppressWarnings("unused")
	private Checkbox chbCerrarTodo;
	Date fechaActual = new Date();
//	LimpiezaLinea limpiezaLinea;
	Empleado empleado=new Empleado();
	Parametro parametro = new Parametro();
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		super.doAfterCompose(comp);
		//new HelperView().cargarProducciones(lbxProduccion);
		
		cargarListaCocina();
		
	}
	
	public void cargarListaCocina(){
		lbxCocina.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Cocina());
		li.setParent(lbxCocina);
				System.out.println("Entro a cargar");
		List<Cocina> listaTurnos = new CocinaDAOJpaImpl().getCocinas();
		
		for (Cocina bd : listaTurnos) {
			li = new Listitem();
			li.setValue(bd);
			new Listcell(bd.getIdcocina().toString()).setParent(li);
			li.setParent(lbxCocina);
		}
		lbxCocina.setSelectedIndex(0);
	}
	
	public void consultarParametro(){
		parametro= new ParametroDAOJpaImpl().getParametroById("12");
	}
	
//	public void cargarListaLinea(){
//		lbxCocinada.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new LimpiezaLinea());
//		li.setParent(lbxCocinada);
//				
//		List<LimpiezaLinea> listaLineas = new LimpiezaLineaDAOJpaImpl().getLimpiezaLineas();
//		
//		for (LimpiezaLinea bd : listaLineas) {
//			li = new Listitem();
//			li.setValue(bd);
//			new Listcell(bd.getDescripcion()).setParent(li);
//			li.setParent(lbxCocinada);
//		}
//		lbxCocinada.setSelectedIndex(0);
//	}
	
//	public void cargarListaEmpleados(){
//		lbxEmpleado.getItems().clear();
//		Listitem li = new Listitem();
//		li.setValue(new Empleado());
//		li.setParent(lbxEmpleado);
//				
//		List<Empleado> listaEmpleado = new EmpleadoDAOJpaImpl().getEmpleados2();		
//		for (Empleado empleado : listaEmpleado) {
//			li = new Listitem();
//			li.setValue(empleado);
//			new Listcell(empleado.getCodpersona()+" "+empleado.getNombres()).setParent(li);
//			li.setParent(lbxEmpleado);
//		}
//		lbxEmpleado.setSelectedIndex(0);
//	}
	
	public void onSelect$lbxCocina() throws InterruptedException{
		 
		if (lbxCocina.getSelectedIndex()>0) {
			//vaciamos el objeto barcoDescarga creando una nueva instancia 
			cocina = new Cocina();
			cocina = (Cocina) lbxCocina.getSelectedItem().getValue();
			
			
		}else{
			cocina = null;
		}
	}
	
	
	
//	public void onSelect$lbxEmpleado() throws InterruptedException{
//		 
//		if (lbxEmpleado.getSelectedIndex()>0) {
//			//vaciamos el objeto barcoDescarga creando una nueva instancia 
//			empleado = new Empleado();
//			empleado = (Empleado) lbxEmpleado.getSelectedItem().getValue();
//			
//		}else{
//			empleado = null;
//		}
//	}
	
	
	//Impresiones	
	public void onClick$btnGrafica(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
	
		if(validar()==false){
			return;
		}
		this.cocina.getIdcocina();
		Timestamp dia = new Timestamp(dteFecha.getValue().getTime());
        Produccion p;
        new Fecha().ConvertirFechaTimestamp(dia.toString());
        //Produccion p = (Produccion)lbxProduccion.getSelectedItem().getValue();
        p= new ProduccionDAOJpaImpl().consultarfechadeProduccionReporte(dia);
        if(p.getIdproduccion()==null){
        	Sistema.mensaje("Produccion no encontrada");
        	return;
        }
        consultarParametro();
        String nombreReporte=parametro.getDescripcionparametro()+obtenerDateAString(p.getFechaproduccion()).toString().substring(0, 10)+"_"+cocina.getIdcocina()+"_"+lbxCocinada.getSelectedIndex()+".jpg";
		new CalidadImpresion().doImprimirCocinaGrafica("ReporteGrafica.jasper", "logo_nirsa.gif", cocina.getIdcocina(),p.getFechaproduccion(),p.getIdproduccion(),lbxCocinada.getSelectedIndex(),nombreReporte); //
	}
	
	public String obtenerDateAString(Date parafecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateadaActual = formato.format(parafecha);

		return fechaFormateadaActual;
	}
	
//	public void onClick$btnDespellejadas(Event event) throws SuspendNotAllowedException, JRException, InterruptedException {
//		if(validar()==false){
//			return;
//		}
//		int turno = this.cocina.getIdcocina();
//		//Ejecutamos el reporte CajonesCamaraUbicacion
//		
//		Timestamp dia = new Timestamp(dteFecha.getValue().getTime());
//        Produccion p;
//        new Fecha().ConvertirFechaTimestamp(dia.toString());
//        //Produccion p = (Produccion)lbxProduccion.getSelectedItem().getValue();
//        p= new ProduccionDAOJpaImpl().consultarfechadeProduccionReporte(dia);
////		new CalidadImpresion().doImprimirPonchadas("PonchadasDespellejada.jasper", "logo_nirsa.gif", turno,p.getFechaproduccion(),p.getIdproduccion(),empleado.getCodpersona(),limpiezaLinea.getIdlimpiezalinea()); //
//		
//		
//	}
	
	
	
	public boolean validar(){
		if (dteFecha.getValue()==null){
			Sistema.mensaje("Debe escoger una Fecha");
			return false;
		}
		if (cocina==null) {
			Sistema.mensaje("Debe escoger una Cocina");
			return false;
		}
		if (lbxCocinada.getSelectedIndex()==0) {
			Sistema.mensaje("Debe escoger una Cocinada");
			return false;
		}
		return true;
	}
}
