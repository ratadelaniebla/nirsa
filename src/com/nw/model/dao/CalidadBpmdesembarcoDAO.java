package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadBpmDesembarco;

public interface CalidadBpmdesembarcoDAO extends Dao {

	public List<CalidadBpmDesembarco> getCalidadBpmDesembarcos();
	
	public CalidadBpmDesembarco getCalidadBpmDesembarcoById(Integer idbpmdesembarco);

	void saveOrUpdate(CalidadBpmDesembarco calidadbpmdesembarco);
	
}
