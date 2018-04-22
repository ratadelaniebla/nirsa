package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadBpmClasificacion;

public interface CalidadBpmclasificacionDAO extends Dao {

	public List<CalidadBpmClasificacion> getCalidadBpmClasificacions();
	
	public CalidadBpmClasificacion getCalidadBpmClasificacionById(Integer idbpmclasificacion);

	void saveOrUpdate(CalidadBpmClasificacion calidadbpmclasificacion);
	
}
