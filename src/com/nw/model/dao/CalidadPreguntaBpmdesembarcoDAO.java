package com.nw.model.dao;

import java.util.List;
import com.nw.model.CalidadPreguntaBpmdesembarco;

public interface CalidadPreguntaBpmdesembarcoDAO extends Dao {

	public List<CalidadPreguntaBpmdesembarco> getCalidadPreguntaBpmdesembarcos();
	
	public CalidadPreguntaBpmdesembarco getCalidadPreguntaBpmdesembarcoByIdGrupoPregunta(String idGrupoPregunta);
	
	public List<CalidadPreguntaBpmdesembarco> getListCalidadPreguntaBpmdesembarcoByIdGrupoPregunta(String idGrupoPregunta);	
	
}
