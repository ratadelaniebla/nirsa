package com.wm.model.dao;

import com.wm.model.OrdenFabricacionL;

public interface OrdenFabricacionLDAO extends Dao {

	public OrdenFabricacionL getNewOrdenFabricacionL();

	public void saveOrUpdate(OrdenFabricacionL ordenfabricacionl);

	public OrdenFabricacionL getMedioByIdAndOP(long iOrdenFabricacion, int iIdProceso,String vIdMedio);

	public OrdenFabricacionL getMedioByIdAndFOP(int iIdProceso, String vIdMedio, String dFProduccion);

	public Number getTotalCarrosProcesadosEviscerado(int iIdProceso, String dFechaproceso);	
	
	public Number getTotalCarrosEvisceradoxLote(int iIdProceso, long iOrdenFabricacion);
	
	public Number getTotalCarrosCoccionxLote(int iIdProceso, long iOrdenFabricacion);	

	public Number getTotalCarrosNebulizadoxLote(int iIdProceso, long iOrdenFabricacion);

	public Number getTotalCarrosAsignacionxLote(int iIdProceso, long iOrdenFabricacion);
	
}
