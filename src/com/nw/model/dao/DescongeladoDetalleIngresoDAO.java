package com.nw.model.dao;

import com.nw.model.DescongeladoDetalleProceso;
import com.nw.model.DescongeladoDetalleProcesoContraloria;
import com.nw.model.DescongeladoDetalleProcesoFinForzado;

public interface DescongeladoDetalleIngresoDAO extends Dao {
	
	void saveOrUpdate(DescongeladoDetalleProceso descongeladoDetalleProceso);

	void saveOrUpdateContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria);

	void saveOrUpdateDescongeladoDetalleProcesoFinForzado(
			DescongeladoDetalleProcesoFinForzado descongeladodetalleprocesofinforzado);

}
