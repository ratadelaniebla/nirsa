package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import javax.swing.DefaultListModel;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
//import org.zkoss.zul.ListModel;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesProcesoEnlatado;
//import com.nw.model.EspecialidadesProceso;
import com.nw.model.EspecialidadesProducto;
import com.nw.model.EspecialidadesReceta;
//import com.nw.model.EvisceradoProceso;
import com.nw.model.Proceso;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
//import com.nw.model.ProduccionDetalleLote;
//import com.nw.model.Turno;
import com.nw.model.Usuario;
import com.nw.model.dao.impl.EspecialidadesProcesoEnlatadoDAOJpaImpl;
//import com.nw.model.dao.impl.EvisceradoProcesoDAOJpaImpl;
import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
//import com.nw.model.dao.impl.TurnoDAOJpaImpl;
//import com.nw.model.dao.impl.ProcesoAperturaCierreDAOJpaImpl;
import com.nw.util.Sistema;
import org.zkoss.zk.ui.Sessions;


@SuppressWarnings("serial")
public class EspecialidadesProcesoEnlatadoApertura extends GenericForwardComposer {

	private Listbox lbxDiaProduccion,lbxOP,lbxProducto;
	private Textbox txtProducto ,txtnlatas,txtOP;
	private Toolbarbutton btnGrabar;
	private Checkbox chbRevisado ;
	
	ProduccionDAOJpaImpl produccionImpl = new ProduccionDAOJpaImpl();
	ProcesoAperturaCierreDAOJpaImpl pacdao= new ProcesoAperturaCierreDAOJpaImpl();	
	EspecialidadesProcesoEnlatadoDAOJpaImpl epedao = new EspecialidadesProcesoEnlatadoDAOJpaImpl();
	EspecialidadesProceso glo_especialidadesProceso = new EspecialidadesProceso();
	EspecialidadesProcesoEnlatado epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
	EspecialidadesProceso especialidadesProceso = new EspecialidadesProceso();
	EspecialidadesProceso actu_especialidadesProceso = new EspecialidadesProceso();
	Produccion produccion = new Produccion();
	ProcesoAperturaCierre procesoAperturaCierre= new ProcesoAperturaCierre();
	EspecialidadesProducto producto = new EspecialidadesProducto();
	EspecialidadesReceta epecialidadesRecete = new EspecialidadesReceta();
	
	Double idprocesoAperturaCierre;
	Date fecha;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		CargarDatos();
		cargarConsultas();
		
		//limpiarDatos();
	}
	public void cargarConsultas(){
		try {
			
			procesoAperturaCierre=pacdao.obtenerProcesoAperturaCierreEspecialidades();
			
			actu_especialidadesProceso= epedao.obtenerActualizarEspecidadesProceso(procesoAperturaCierre.getIdprocesoaperturacierre());
			//txtProduccion.setValue(procesoAperturaCierre.getFechaapertura().toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	void CargarDatos() throws InterruptedException
	{
		try {
			
			lbxDiaProduccion.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new Produccion());
			li.setParent(lbxDiaProduccion);
					
			List<Produccion> listafechaProduccion = new ProduccionDAOJpaImpl().getProducciones();
			
			for (Produccion bd : listafechaProduccion) {
				li = new Listitem();
				li.setValue(bd);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				
				li.setParent(lbxDiaProduccion);
				
				//produccion= bd;
			}
			lbxDiaProduccion.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	 
	void CargarDatosOp() throws InterruptedException
	{
		try {
			
			lbxOP.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new EspecialidadesProceso());
			li.setParent(lbxOP);
			
			List<EspecialidadesProceso> listaEspProc = epedao.getSeleccionEspecialidadesProceso(produccion.getIdproduccion());
			
			for (EspecialidadesProceso itemEP : listaEspProc) {
				li = new Listitem();
				li.setValue(itemEP);
				new Listcell(String.valueOf(itemEP.getOrdenproduccion()) ).setParent(li);
				li.setParent(lbxOP);
				
				//glo_especialidadesProceso=itemEP;
				
				
				//produccion.setIdproduccion(itemEP);itemEP.getDescripcion())).setParent(li);
			}
			//lbxDiaProduccion.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	void CargarDatosProducto() throws InterruptedException
	{
		try {
			
			lbxProducto.getItems().clear();
			Listitem li = new Listitem();
			li.setValue(new EspecialidadesProducto());
			li.setParent(lbxProducto);
			
			List<EspecialidadesProducto> listaProducto = epedao.getSeleccionEspecialidadesProducto();
			
			for (EspecialidadesProducto itemEP : listaProducto) {
				li = new Listitem();
				li.setValue(itemEP);
				new Listcell(String.valueOf(itemEP.getDescripcion()) ).setParent(li);
				li.setParent(lbxProducto);

			}
			lbxProducto.setSelectedIndex(0);
			
			
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
	}
	
	public void onSelect$lbxOP(){
		if (glo_especialidadesProceso!= null && produccion!= null){
			if(lbxOP.getSelectedItem().getIndex()>0)
				glo_especialidadesProceso = (EspecialidadesProceso) lbxOP
				.getSelectedItem().getValue();
				txtProducto.setText(glo_especialidadesProceso.getEspecialidadesReceta().getEspecialidadesProducto().getDescripcion());
				
		}else{
			Sistema.mensaje("Seleccione un proceso");
		}
		
	}
	
	public void onSelect$lbxProducto(){
		if (glo_especialidadesProceso!= null && produccion!= null){
			if(lbxProducto.getSelectedItem().getIndex()>0)
				producto = (EspecialidadesProducto) lbxProducto
				.getSelectedItem().getValue();
			epecialidadesRecete = epedao.getSeleccionEspecialidadesReceta(producto.getIdespecialidadesproducto());
				//txtProducto.setText(glo_especialidadesProceso.getEspecialidadesReceta().getEspecialidadesProducto().getDescripcion());
				
		}else{
			Sistema.mensaje("Seleccione un Producto");
		}
		
	}
	//
	public void onSelect$lbxDiaProduccion() throws InterruptedException 
	{
		try {
			if (txtProducto==null && lbxProducto !=null){
				
				CargarDatosProducto();
				if (actu_especialidadesProceso.getIdespecialidadesproceso() != null)
				{
					Sistema.mensaje("No se puede iniciar una Apertura debe finalizar la  anterior ");
					limpiarDatos();
				}
			}
			produccion= (Produccion) lbxDiaProduccion
					.getSelectedItem().getValue();
			CargarDatosOp();
		
		} catch (Exception e) {
			System.out.println("Mensaje de error " + e.getMessage());
		}
	}
	
	public void onClick$btnGrabar() throws InterruptedException{
		//grabar();
		if (chbRevisado.isChecked() == true){
		Usuario usu = new Usuario();
		String usuario = (String)Sessions.getCurrent().getAttribute("usuario");
		usu.setIdusuario(usuario);
		if (usuario==null || usuario.equals("")) {
			Sistema.mensaje("No se ha autenticado el usuario.. no puede grabar");
			return;
			//usu.setIdusuario("aaguirre");
		}
		if ((lbxProducto!=null)&& producto.getDescripcion() == null  ){
			//glo_especialidadesProceso.setIdespecialidadesproceso(Long.valueOf(Integer.valueOf(txtProducto.getValue())));
			Sistema.mensaje("No se ha ingresado el Producto.. no puede grabar");
			return;
		}
		
		
		if (lbxDiaProduccion.getSelectedIndex()<=0){
			Sistema.mensaje("No se ha escogido el dia de produccion.. no puede grabar");
			return;
		}
		
//		if (lbxProducto.getSelectedIndex()<=0){
//			Sistema.mensaje("No se ha escogido Dia Producto .. no puede grabar");
//			return;
//		}
		if (produccion!= null && procesoAperturaCierre==null){
			
			procesoAperturaCierre= new ProcesoAperturaCierre();
			ProcesoAperturaCierre loc_procesoAperturaCierre= new ProcesoAperturaCierre();
			procesoAperturaCierre.setEstado(1);
			procesoAperturaCierre.setFechaapertura(new java.sql.Timestamp(new Date().getTime()));
			
			loc_procesoAperturaCierre = pacdao.guardarAperturaCierre(procesoAperturaCierre);
			especialidadesProceso = new EspecialidadesProceso();
			
			especialidadesProceso.setUsuario(usu);
			especialidadesProceso.setProduccion(produccion);
			especialidadesProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
			especialidadesProceso.setProcesoAperturaCierre(loc_procesoAperturaCierre);
			especialidadesProceso.setOrdenproduccion(Long.valueOf(txtOP.getValue()));
			//TODO

			//especialidadesProceso.setEspecialidadesReceta(glo_especialidadesProceso.getEspecialidadesReceta());
			especialidadesProceso.setEspecialidadesReceta(epecialidadesRecete);
			epedao.guardarActualizarEspecialidadesProceso(especialidadesProceso);
			Sistema.mensaje(Sistema.MSG_TRANSACCION_GRABADA);
			//limpiarDatos();
		}
		else{
			Sistema.mensaje("Debe seleccionar todos los campos ");
		}
		if (procesoAperturaCierre.getIdprocesoaperturacierre()!=null) {
			if (lbxOP.getSelectedIndex()<=0){
				Sistema.mensaje("No se ha escogido O/P .. no puede grabar");
				return;
			}
			
		if (glo_especialidadesProceso.getIdespecialidadesproceso()!= null && procesoAperturaCierre!=null && actu_especialidadesProceso!=null  ){
			procesoAperturaCierre.setEstado(0);
			procesoAperturaCierre.setFechacierre(new java.sql.Timestamp(new Date().getTime()));
			Proceso loc_proceso = new Proceso();
			loc_proceso.setIdproceso(7);
			procesoAperturaCierre.setProceso(loc_proceso);
			pacdao.guardarAperturaCierre(procesoAperturaCierre);
			
			actu_especialidadesProceso.setUsuario(usu);
			actu_especialidadesProceso.setProduccion(produccion);
			//TODO
			
//			especialidadesProceso.setIdusuario(usu.getIdusuario());
//			especialidadesProceso.setIdproduccion(produccion.getIdproduccion());
			
			actu_especialidadesProceso.setFechareg(new java.sql.Timestamp(new Date().getTime()));
			actu_especialidadesProceso.setEspecialidadesReceta(glo_especialidadesProceso.getEspecialidadesReceta());
			
			//especialidadesProceso.setProcesoAperturaCierre(loc_procesoAperturaCierre);
			epedao.guardarActualizarEPE(epecialidadesprocesosenlato);
			Sistema.mensaje("Transaccion cerrada");
		}
		}
		limpiarDatos();
		}else{
			Sistema.mensaje("No se ha escogido todos los datos .. no puede grabar");
		}
	}
	
	void limpiarDatos()
	{
		if (txtProducto!=null){
		 txtProducto.setValue("");
		 lbxOP.getItems().clear();
		}
		else
		{
			lbxProducto.getItems().clear();
			txtOP.setValue("");
		}
		 //txtnlatas.setValue("");
		
		lbxDiaProduccion.setSelectedIndex(0);
		
		glo_especialidadesProceso = new EspecialidadesProceso();
		epecialidadesprocesosenlato = new EspecialidadesProcesoEnlatado();
		produccion = new Produccion();
		chbRevisado.setChecked(false);
		
	}
	
}
