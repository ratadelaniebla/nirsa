package com.nw.model.dao;

import java.math.BigDecimal;
import java.util.List;

import com.nw.model.CalidadIncidencia;

public interface CalidadIncidenciasDAO extends Dao{

	//public void grabar(CalidadPcc o);
	public void saveOrUpdate(CalidadIncidencia calidadincidencia);

	public List<CalidadIncidencia> getCalidadIncidencias(Integer IdFormato, Long idbarcoestibacuba, BigDecimal Idmuestra);
}
