package com.nw.model.dao;


import com.nw.model.CamaraDetalleBanda;;

public interface CamaraDetalleBandaDAO extends Dao {
	
	public void saveOrUpdate(CamaraDetalleBanda camaradetallebanda);

	public CamaraDetalleBanda CamaraDetalleBandaByID(String id);
}
