package com.nw.model.dao;


import java.util.List;

import com.nw.model.EvisceradoDetalleProcesoCoche;

public interface EvisceradoDetalleProcesoCocheDAO extends Dao {

	EvisceradoDetalleProcesoCoche saveOrUpdate(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche);
	List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches(Long idevisceradodetalleproceso);
	
}
