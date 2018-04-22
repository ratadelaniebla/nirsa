package com.nw.model.dao;

import com.nw.model.LimpiezaProceso;

/**
 * Interfase para manejar la entidad LimpiezaProceso (limpieza_proceso) 
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-16, 18
 */
public interface LimpiezaProcesoDAO extends Dao {

	public LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(Long procesoAperturaCierreId, Long vip);


	LimpiezaProceso getLimpiezaProcesoByProcesoAperturaCierreId(
			Long procesoAperturaCierreId);

	
}
