package com.nw.model.dao;

import com.nw.model.LimpiezaDetalleProcesoLote;
import com.nw.model.LimpiezaProceso;
import com.nw.model.LimpiezaTipo;
import com.nw.model.ProduccionDetalleLote;

/**
 * Interfase para manejar la apertura y el cierre de Limpieza (proceso_apertura_cierre y limpieza_proceso) 
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-05, 06, 07, 12, 13, 18, 19
 */
public interface LoteAperturaCierreDAO extends Dao {
	public LimpiezaDetalleProcesoLote aperturar(LimpiezaProceso limpiezaProceso, ProduccionDetalleLote produccionDetalleLote, LimpiezaTipo limpiezatipo);
	public LimpiezaDetalleProcesoLote getActivo(ProduccionDetalleLote produccionDetalleLote);
	public void cerrar(ProduccionDetalleLote produccionDetalleLote);
	void reaperturar(ProduccionDetalleLote produccionDetalleLote);
	LimpiezaDetalleProcesoLote anular(LimpiezaProceso limpiezaProceso,ProduccionDetalleLote produccionDetalleLote);
	void saveOrUpdate(LimpiezaDetalleProcesoLote limpiezadetalleprocesolote);

}
