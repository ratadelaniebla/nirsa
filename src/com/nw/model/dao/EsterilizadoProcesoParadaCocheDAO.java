package com.nw.model.dao;

import java.util.List;

import com.nw.model.EsterilizadoCoche;
import com.nw.model.EsterilizadoProcesoParada;
import com.nw.model.EsterilizadoProcesoParadaCoche;
import com.nw.model.Produccion;

public interface EsterilizadoProcesoParadaCocheDAO extends Dao{
	public EsterilizadoProcesoParadaCoche obtieneCochesAsignadosProduccion(Long idproduccion, Integer intCocheId) ;
	public List<EsterilizadoCoche> obtieneCochesAsignadosProduccion(Long idesterilizadoprocesoparada);
	public List<EsterilizadoProcesoParada> obtieneParadasAsignadosProduccion(Long idproduccion);
	public List<EsterilizadoProcesoParadaCoche> obtieneCochesAsignadosParada(Long idesterilizadoprocesoparada);
	public EsterilizadoProcesoParadaCoche obtieneCocheAsignadoParada(Long idesterilizadoprocesoparada);
	public List<Produccion> obtieneParadasAsignadasProduccion();
}
