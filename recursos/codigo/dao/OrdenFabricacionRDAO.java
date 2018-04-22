package com.wm.model.dao;

import java.util.List;

import com.wm.model.OrdenFabricacionP;
import com.wm.model.OrdenFabricacionR;

public interface OrdenFabricacionRDAO extends Dao{

	public OrdenFabricacionR OrdenFabricacionRJpaImpl();

	public void saveOrUpdate(OrdenFabricacionR ordenfabricacionr);

	public List<OrdenFabricacionR> getRecursosOrdenProceso(long iOrdenFabricacion,
			int iidproceso);

}
