package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadPreguntaBpmclasificacion;

public interface CalidadPreguntaBpmclasificacionDAO extends Dao {

	public List<CalidadPreguntaBpmclasificacion> getCalidadPreguntaBpmclasificacions();
	
	public CalidadPreguntaBpmclasificacion getCalidadPreguntaBpmclasificacionByIdGrupoPregunta(String idGrupoPregunta);
	
	public List<CalidadPreguntaBpmclasificacion> getListCalidadPreguntaBpmclasificacionByIdGrupoPregunta(String idGrupoPregunta);	
	
}
