package com.nw.model.dao;

import java.util.List;

import com.nw.model.Volqueta;

public interface VolquetaDAO extends Dao {
	public List<Volqueta> getListVolquetas();
	void saveOrUpdate(Volqueta volqueta);
}
