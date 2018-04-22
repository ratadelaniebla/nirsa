package com.nw.model.dao;
import java.util.List;

import com.nw.model.CajonDetalleMuestreo;

public interface CajonDetalleMuestreoDAO extends Dao{

	void saveOrUpdate(CajonDetalleMuestreo cajondetallemuestreo);

	public List<CajonDetalleMuestreo> getListCajonDetalleMuestreoById(String id);
}