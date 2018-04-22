package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadRespuestaPreguntaBpmdesembarco;

public interface CalidadRespuestaPreguntaBpmdesembarcoDAO extends Dao {

	public List<CalidadRespuestaPreguntaBpmdesembarco> getCalidadRespuestaPreguntaBpmdesembarcos();

	public Integer getCalidadRespuestaPreguntaBpmdesembarcosBuscarPregunta(Long idcab, Integer idpre);
}
