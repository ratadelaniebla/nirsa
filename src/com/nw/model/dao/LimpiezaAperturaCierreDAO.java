package com.nw.model.dao;

import com.nw.model.ProcesoAperturaCierre;
import com.nw.model.Produccion;

/**
 * Interfase para manejar la apertura y el cierre de Limpieza (proceso_apertura_cierre y limpieza_proceso) 
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-05, 06, 07, 12, 13
 */
public interface LimpiezaAperturaCierreDAO extends Dao {
	public ProcesoAperturaCierre aperturar(Produccion produccion); 
	public void cerrar(ProcesoAperturaCierre procesoAperturaCierre); 
	public ProcesoAperturaCierre getActivo();
}
