package com.nw.model.dao;

import com.nw.model.LimpiezaDetallePesoDespellejado;
import com.nw.model.LimpiezaDetallePesoDespellejadoT;

public interface LimpiezaDetallePesoDespellejadoDAO extends Dao {

	void saveOrUpdate(LimpiezaDetallePesoDespellejado limpiezadetallepesodespellejado);

	void saveOrUpdateT(
			LimpiezaDetallePesoDespellejadoT limpiezadetallepesodespellejado);
}
