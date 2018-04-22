package com.nw.model.dao;

import com.nw.model.Proceso;

/**
 * Interfase para manejar los procesos
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-01-07
 */
public interface ProcesoDAO extends Dao{
	
	public Proceso getProcesoById(Integer id);

}
