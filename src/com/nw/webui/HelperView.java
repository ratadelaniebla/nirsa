package com.nw.webui;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.nw.model.Autoclave;
import com.nw.model.BarcoDescarga;
import com.nw.model.LimpiezaLinea;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaTipo;
import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLote;
import com.nw.model.Turno;
import com.nw.model.dao.impl.AutoClaveDAOJpaImpl;
import com.nw.model.dao.impl.BarcoDescargaDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaAperturaCierreDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaLineaDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaProcesoDAOJpaImpl;
import com.nw.model.dao.impl.LimpiezaTipoDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDAOJpaImpl;
import com.nw.model.dao.impl.ProduccionDetalleLoteDAOJpaImpl;
import com.nw.model.dao.impl.TurnoDAOJpaImpl;
import com.nw.util.Sistema;

public class HelperView {

	/**
	 * Carga los barcos de descarga en el listbox especificado
	 * @param lbxBarco
	 */
	public void cargarBarcos(Listbox lbxBarco){
		Sistema.agregarListitemEnBlanco(lbxBarco);
		for (BarcoDescarga b: new BarcoDescargaDAOJpaImpl().getBarcosDescarga()){
			Listitem li = new Listitem();
			li.setValue(b);
			new Listcell( b.getBarco().getNombre()).setParent(li);
			li.setParent(lbxBarco);
		}
		Sistema.setPosicionPrimerItem(lbxBarco);
	}

	/**
	 * Carga las líneas de limpieza (mesas) en el listbox especificado
	 * @param lbxMesa
	 */
	public void cargarLimpiezaLineas(Listbox lbxMesa){
		lbxMesa.getItems().clear();
		Sistema.agregarListitemEnBlanco(lbxMesa);
		for (LimpiezaLinea l: new LimpiezaLineaDAOJpaImpl().getLimpiezaLineas()){
			Listitem li = new Listitem();
			li.setValue(l);
			new Listcell( l.getDescripcion()).setParent(li);
			li.setParent(lbxMesa);
		}
		Sistema.setPosicionPrimerItem(lbxMesa);
	}
	
	/**
	 * Carga los lotes en el listbox especificado
	 * @param lbxLote
	 */
//	public void cargarLotes(Listbox lbxLote){
//		Sistema.agregarListitemEnBlanco(lbxLote);
//		for (ProduccionDetalleLote p: new ProduccionDetalleLoteDAOJpaImpl().getLotes() ){
//			Listitem li = new Listitem();
//			li.setValue(p);
//			new Listcell( "" + p.getIdlote() ).setParent(li);
//			li.setParent(lbxLote);
//		}
//		Sistema.setPosicionPrimerItem(lbxLote);
//	}

	/**
	 * Carga los lotes aperturados en el listbox especificado
	 * @param lbxLote
	 */
	public void cargarLotesAperturados(Listbox lbxLote){
		Sistema.agregarListitemEnBlanco(lbxLote);
		for (ProduccionDetalleLote p: new ProduccionDetalleLoteDAOJpaImpl().getLotesAperturados() ){
			Listitem li = new Listitem();
			li.setValue(p);
			new Listcell( "" + p.getIdlote() ).setParent(li);
			li.setParent(lbxLote);
		}
		Sistema.setPosicionPrimerItem(lbxLote);
	}
	
	/**
	 * Carga las producciones en el listbox especificado
	 * @param lbxProduccion
	 */
	public void cargarProducciones(Listbox lbxProduccion){
		Sistema.agregarListitemEnBlanco(lbxProduccion);
		for (Produccion p: new ProduccionDAOJpaImpl().getProducciones()){
			Listitem li = new Listitem();
			li.setValue(p);
			new Listcell( p.getFechaproduccion().toString().substring(0,10) ).setParent(li);
			li.setParent(lbxProduccion);
		}
		Sistema.setPosicionPrimerItem(lbxProduccion);
	}
	
	/**
	 * Carga los tipos de limpieza en el listbox especificado
	 * @param lbxTipoLimpieza
	 */
	public void cargarTiposLimpieza(Listbox lbxTipoLimpieza){
		Sistema.agregarListitemEnBlanco(lbxTipoLimpieza);
		for (LimpiezaTipo p: new LimpiezaTipoDAOJpaImpl().getLimpiezaTipo() ){
			Listitem li = new Listitem();
			li.setValue(p);
			new Listcell(p.getDescripcion()).setParent(li);
			li.setParent(lbxTipoLimpieza);
		}
		Sistema.setPosicionPrimerItem(lbxTipoLimpieza);
	}

	public void cargarAutoclaves(Listbox lbxAutoclave){
		Sistema.agregarListitemEnBlanco(lbxAutoclave);
		for (Autoclave t: new AutoClaveDAOJpaImpl().getFindAutoClaveAll()){
			Listitem li = new Listitem();
			li.setValue(t);
			new Listcell( t.getDescripcion()).setParent(li);
			li.setParent(lbxAutoclave);
		}
		Sistema.setPosicionPrimerItem(lbxAutoclave);
	}
	/**
	 * Carga los turnos en el listbox especificado
	 * @param lbxTurno
	 */
	public void cargarTurnos(Listbox lbxTurno){
		Sistema.agregarListitemEnBlanco(lbxTurno);
		for (Turno t: new TurnoDAOJpaImpl().getTurnos()){
			Listitem li = new Listitem();
			li.setValue(t);
			new Listcell( t.getIdturno().toString()+" "+t.getNombre()).setParent(li);
			li.setParent(lbxTurno);
		}
		Sistema.setPosicionPrimerItem(lbxTurno);
	}
	
	/**
	 * Muestra la fecha del proceso de limpieza activo y devuelve el objeto LimpiezaProceso
	 * @param txtDiaProduccion
	 * @return
	 */
	public LimpiezaProceso getLimpiezaProceso(Textbox txtDiaProduccion){
		LimpiezaProceso limpiezaProceso = null;
		ProcesoAperturaCierre procesoAperturaCierre = new LimpiezaAperturaCierreDAOJpaImpl().getActivo();
		
		if (procesoAperturaCierre != null){
			txtDiaProduccion.setText(procesoAperturaCierre.getFechaapertura().toString().substring(0,10) );
			//Sale del proceso apertura cierre activo
			limpiezaProceso = new LimpiezaProcesoDAOJpaImpl().getLimpiezaProcesoByProcesoAperturaCierreId(procesoAperturaCierre.getIdprocesoaperturacierre());
		}
		return limpiezaProceso; 
	}
}
