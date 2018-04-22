package com.nw.model.dao;

import java.util.List;

import com.nw.model.LimpiezaDetalleProcesoLote;

public interface LimpiezaDetalleProcesoLoteDAO extends Dao {

	void saveOrUpdate(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote);

	List<LimpiezaDetalleProcesoLote> getLotesNoUsados(Integer vturno,Long pidproduccion);

	LimpiezaDetalleProcesoLote LimpiezaDetalleProcesoLoteById(String id);


	LimpiezaDetalleProcesoLote LimpiezaDetalleProcesoLoteByIdProduccionDetalleLote(Long id);
	
}
