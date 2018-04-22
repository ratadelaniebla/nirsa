package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadNivelCuba;

public interface CalidadNivelCubaDAO extends Dao {

	public List<CalidadNivelCuba> getCalidadNivelCuba(Integer idpropiedad);
}
