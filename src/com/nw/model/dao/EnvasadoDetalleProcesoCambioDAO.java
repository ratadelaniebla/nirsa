package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoDetalleProcesoCambio;

public interface EnvasadoDetalleProcesoCambioDAO extends Dao {
	
	EnvasadoDetalleProcesoCambio saveOrUpdate(EnvasadoDetalleProcesoCambio EnvasadoDetalleProcesoCambio);
	List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambioByIdEProceso(Long idenvasadoproceso);
	public EnvasadoDetalleProcesoCambio getEnvasadoDetalleProcesoCambioById(Long idproducciondetalleorden) ;
	public boolean delete(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio);
}
