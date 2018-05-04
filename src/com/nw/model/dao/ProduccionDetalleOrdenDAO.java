package com.nw.model.dao;

import java.util.List;

import com.nw.model.ProduccionDetalleOrden;


public interface ProduccionDetalleOrdenDAO extends Dao {
	
	public boolean saveObject(ProduccionDetalleOrden produccionDetalleOrden);
	public void updateObject(ProduccionDetalleOrden produccionDetalleOrden);
	public ProduccionDetalleOrden existeDetalleOrden(Integer idturno, Long idproduccion, Integer item, String orden);
	public List<ProduccionDetalleOrden> obtieneDetalleOrdenByProduccionTurno(Integer idturno, Long idproduccion);
	public ProduccionDetalleOrden obtieneDetalleOrdenById(Integer idproducciondetalleorden);
}
