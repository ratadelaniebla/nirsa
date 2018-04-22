package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoDetalleProcesoCambio;

public interface CopyOfEnvasadoDetalleProcesoCambioLuthyDAO extends Dao {
	
	void saveOrUpdate(EnvasadoDetalleProcesoCambio EnvasadoDetalleProcesoCambio);
	List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambioByIdEProceso(Long idenvasadoproceso);
}
