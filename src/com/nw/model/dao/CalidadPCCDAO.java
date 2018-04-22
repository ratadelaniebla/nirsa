package com.nw.model.dao;

import com.nw.model.CalidadPcc;

public interface CalidadPCCDAO extends Dao{

	public void grabar(CalidadPcc o);
	public void saveOrUpdate(CalidadPcc calidadpcc);
	public CalidadPcc CalidadPccById(String IDCalidadPcc);
}
