package com.wm.model.dao;

import java.util.List;

import com.wm.model.OrdenFabricacionPL;

public interface OrdenFabricacionPLDAO extends Dao{

	public OrdenFabricacionPL OrdenFabricacionCocinaJpaImpl();

	public void saveOrUpdate(OrdenFabricacionPL ordenfabricacioncocina);

	public void grabarOactualizar(OrdenFabricacionPL ordenfabricacioncocina);	
	
	public OrdenFabricacionPL getInfoCocinasById(long iOrdenFabricacion,
			int iIdProceso, int iIdCocina, int iNroCocinada, String dFechaproceso);

	public List<OrdenFabricacionPL> getInfoCocinasByOrdenF(long iOrdenFabricacion,
			int iIdProceso, String dFechaproceso);

	 public Number getInfoTotalCocinadasByFId(int iNroCocina, int iNroCocinada,String dFechaproceso);
	
}
