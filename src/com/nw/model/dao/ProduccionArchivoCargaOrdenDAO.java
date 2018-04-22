package com.nw.model.dao;

import com.nw.model.ProduccionArchivoCargaOrden;


public interface ProduccionArchivoCargaOrdenDAO extends Dao {
	
	public void saveObject(ProduccionArchivoCargaOrden produccionArchivoCargaOrden);
	public void updateObject(ProduccionArchivoCargaOrden produccionArchivoCargaOrden);
	public ProduccionArchivoCargaOrden archivoCargaOrdenPorID(Long idproduccionarchivocargaorden);
}
