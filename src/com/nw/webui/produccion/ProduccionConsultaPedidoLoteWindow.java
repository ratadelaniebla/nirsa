package com.nw.webui.produccion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.nw.model.Produccion;
import com.nw.model.ProduccionArchivoCargaLote;
import com.nw.model.ProduccionCargaLote;
import com.nw.model.Turno;
import com.nw.model.dao.impl.ProduccionCargaLoteDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;

public class ProduccionConsultaPedidoLoteWindow extends GenericForwardComposer {
 
	private static final long serialVersionUID = 1L;
	Listbox lbxTurno,lbxFechaActiva,lbxCargaLotes;
	Toolbarbutton btnBuscar;
	Textbox txtFecha;

	//objetos y listados
	Produccion produccion;
	Turno turno;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargaListaFecha();
		cargarListaTurnoProduccion();
	}
	
	public void onClick$btnBuscar(){
		cargarProduccionArchivoCargaLoteMaxima();
	}
	
	
	
	public void cargaListaFecha(){
		lbxFechaActiva.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Produccion());
		li.setParent(lbxFechaActiva);
				
		List<Produccion> listaFecha = new ProduccionDAOJpaImpl().getListaFechaProduccionActivaDescongelado();
		
		if (listaFecha.size()==0) {
			Sistema.mensaje("No existen producciones activas");
		}
		else
		{
			for (Produccion bd : listaFecha) {
				li = new Listitem();
				li.setValue(bd);
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				new Listcell(dateFormat.format(bd.getFechaproduccion())).setParent(li);
				li.setParent(lbxFechaActiva);
			}
			lbxFechaActiva.setSelectedIndex(0);
		}

	}
	
	
	public void cargarListaTurnoProduccion(){
		lbxTurno.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new Turno());
		li.setParent(lbxTurno);
				
		List<Turno> listaTurnos = new TurnoDAOJpaImpl().getTurnos();
		
		for (Turno t : listaTurnos) {
			li = new Listitem();
			li.setValue(t);
			new Listcell(t.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		lbxTurno.setSelectedIndex(0);

	}
	
	
	public void onSelect$lbxFechaActiva() throws InterruptedException{
		
		if (lbxFechaActiva.getSelectedIndex()>0) {
			produccion = new Produccion();
			produccion = (Produccion) lbxFechaActiva.getSelectedItem().getValue();//asigno el item barcodescarga seleccionado
			System.out.println("produccion id --> " + produccion.getIdproduccion());

		}else{
			produccion = null;
		}
	}
	
	public void onSelect$lbxTurno() throws InterruptedException{
		
		if (produccion == null) {
			Sistema.mensaje("Debe escoger una fecha");
			lbxTurno.setSelectedIndex(0);
		}
		else
		{
			if (lbxTurno.getSelectedIndex()>0) {
				turno = new Turno();
				turno = (Turno) lbxTurno.getSelectedItem().getValue();
			}else{
				turno = null;
				 			
			}
		}
	}
	
	
	public void cargarProduccionArchivoCargaLoteMaxima(){
		
		if (turno ==null) {
			Sistema.mensaje("Debe escoger un turno..");
			return;
		}
		if (produccion==null) {
			Sistema.mensaje("Debe escoger una fecha");
			return;
		}
		
		ProduccionArchivoCargaLote paclmax = new ProduccionArchivoCargaLote();
		paclmax = new ProduccionCargaLoteDAOJpaImpl().consultarIdPorFechaTurno(produccion, turno);
		if (paclmax==null) {
			Sistema.mensaje("No existe Archivo Carga Lote..");
			return;
		}
		
		System.out.println("id produccion Archivo Maximo ->"+paclmax.getIdproduccionarchivocargalote());
		ProduccionArchivoCargaLote paclfinal = new ProduccionArchivoCargaLote();
		paclfinal = new ProduccionCargaLoteDAOJpaImpl().consultarProduccionArchivo(paclmax.getIdproduccionarchivocargalote());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		txtFecha.setValue(dateFormat.format(paclfinal.getFechacarga()).toString());
		
		//cargar listado de produccion carga lote en base al id de archivo carga lote
		List <ProduccionCargaLote> produccionCargasLotes = new ArrayList<ProduccionCargaLote>();
		produccionCargasLotes = new ProduccionCargaLoteDAOJpaImpl().getProduccionCargaloteByIdArchivoCargaLote(paclmax);
		System.out.println("tamano lista consultada->"+produccionCargasLotes.size());
		llenarListaLotes(produccionCargasLotes);
		
	}
	
	
	
//	<listheader label="PEDIDO" width="80px" />
//	<listheader label="LOTES" width="80px" />
//	<listheader label="DESTINOS" width="68px" />
//	<listheader label="BARCO" width="68px" />
//	<listheader label="REGISTRO" width="80px" />
//	<listheader label="VIAJE" width="78px" />
//	<listheader label="ESTATUS" width="68px" />
//	<listheader label="COD BARCO" width="68px" />
//	<listheader label="TEXT MATERIAL" width="78px" />
//	<listheader label="TOTAL PESO" width="68px" />
	
	public void llenarListaLotes(List<ProduccionCargaLote> produccionCargasLotes){
		 
		lbxCargaLotes.getItems().clear();
		Listitem li = new Listitem();
		li.setValue(new ProduccionCargaLote());
		li.setParent(lbxCargaLotes);
		
		for (ProduccionCargaLote pcl : produccionCargasLotes) {
			li = new Listitem();
			li.setValue(pcl);
			new Listcell(pcl.getPedido()+"").setParent(li);
			new Listcell(pcl.getEspecietalla()+"").setParent(li);
			new Listcell(pcl.getIdlote()+"").setParent(li);
			new Listcell(pcl.getNombrebarco()+"").setParent(li);
			new Listcell(pcl.getRegistro()+"").setParent(li);
			
		 
			
			li.setParent(lbxCargaLotes);
		}
		lbxCargaLotes.setSelectedIndex(0);
		
	}
	
	
}
