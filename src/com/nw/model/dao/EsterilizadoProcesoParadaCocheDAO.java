package com.nw.model.dao;

import com.nw.model.EsterilizadoProcesoParadaCoche;

public interface EsterilizadoProcesoParadaCocheDAO extends Dao{
	public EsterilizadoProcesoParadaCoche obtieneCochesAsignadosProduccion(Long idproduccion, Integer intCocheId) ;
}
