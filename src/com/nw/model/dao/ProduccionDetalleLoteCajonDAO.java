package com.nw.model.dao;


//import java.util.List;

import com.nw.model.ProduccionDetalleLoteCajon;

public interface ProduccionDetalleLoteCajonDAO extends Dao {

	ProduccionDetalleLoteCajon getidLoteProduccionDetallelotePrimero1(Long id);

	void saveOrUpdate(ProduccionDetalleLoteCajon produccion);


	//void saveOrUpdate(ProduccionDetalleLoteCajon produccionDetalleLoteCajon);


//	ProduccionDetalleLoteCajon getidLoteProduccionDetallelotePrimero1(Long id);
//
//
//	List<ProduccionDetalleLote> getidLoteProduccionDetallelote(Long id);
}
