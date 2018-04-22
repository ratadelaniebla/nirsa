package com.nw.model.dao;

import java.util.List;

import com.nw.model.ProduccionDetalleLote;

public interface ProducccionDetalleLoteDAO extends Dao {
	
	void saveOrUpdate(ProduccionDetalleLote produccionDetalleLote);

	List<ProduccionDetalleLote> getLotesAperturados();

	List<ProduccionDetalleLote> getLotes(Integer vturno, Long pidproducciondetallelot);

	List<ProduccionDetalleLote> getLotesCerrados(Long vip);

	List<ProduccionDetalleLote> getLotesCarryOver(Integer vturno,Long pidproducciondetallelot);

	List<ProduccionDetalleLote> getLotesPorProduccionTurnoYLote(Integer vturno,
			Long pidprod, Integer idlote);	
	
}
