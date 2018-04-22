package com.wm.model.dao;

import java.sql.Timestamp;
import java.util.Date;


import com.wm.model.OrdenFabricacionC;

public interface OrdenFabricacionCDAO extends Dao{

	public OrdenFabricacionC OrdenFabricacionCJpaImpl();
 
	public void createNewOrdenFabricacionC(long iordenfabricacion, int iidproceso,
			Timestamp dhorainicio, Timestamp dhorafin, String vestado,
			String vobservaciones);

	public void saveOrupdateOrdenFabricacionC(long iordenfabricacion, int iidproceso,
			Timestamp dhorainicio, Timestamp dhorafin, String vestado,
			String vobservaciones);

	public OrdenFabricacionC getOrdenProceso(long iOrdenFabricacion, int iidproceso);

	public void saveOrUpdate(OrdenFabricacionC ordenfabricacionc);

}
