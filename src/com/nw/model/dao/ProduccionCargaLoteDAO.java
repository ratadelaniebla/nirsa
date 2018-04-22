package com.nw.model.dao;

import com.nw.model.ProduccionCargaLote;
import com.nw.model.ProduccionDetalleLote;

public interface ProduccionCargaLoteDAO extends Dao {

	void saveOrUpdate(ProduccionCargaLote produccionCargaLote);

	void saveOrUpdateProduccionDetalleLote(
			ProduccionDetalleLote producciondetallelote);
	

}
