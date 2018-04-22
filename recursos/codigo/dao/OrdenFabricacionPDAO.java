package com.wm.model.dao;

import java.util.List;

import com.wm.model.OrdenFabricacionP;

public interface OrdenFabricacionPDAO extends Dao{

	public OrdenFabricacionP OrdenFabricacionPJpaImpl();

	public void saveOrUpdate(OrdenFabricacionP ordenfabricacionp);

	public List<OrdenFabricacionP> getScrapOrdenProceso(long iOrdenFabricacion, int iidproceso);

	public Number getInfoMaxScrapId();	
	
}
