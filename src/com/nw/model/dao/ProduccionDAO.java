package com.nw.model.dao;

import java.util.List;

import com.nw.model.Produccion;
import com.nw.model.ProduccionDetalleLoteCajon;

public interface ProduccionDAO extends Dao {
	Produccion saveOrUpdate(Produccion produccion);

	List<Produccion> getProducciones();

	void guardarPrducionDetlotCajon(ProduccionDetalleLoteCajon pdlCajon);
}
