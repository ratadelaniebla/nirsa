package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadRespuestaPreguntaBpmclasificacion;


public interface CalidadRespuestaPreguntaBpmclasificacionDAO extends Dao {

	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions();

	public Integer getCalidadRespuestaPreguntaBpmclasificacionsBuscarPregunta(Long idcab, Integer idpre);
}
