package com.nw.model.dao;

import java.util.List;

import com.nw.model.ProduccionArchivoCargaOrdenDetalle;

public interface ProduccionArchivoCargaOrdenDetalleDAO extends Dao {
	public boolean existeArchivoCargaOrdenDetalle(Integer idturno, Integer item, String orden, Long idproduccion);
	public List<ProduccionArchivoCargaOrdenDetalle> archivoCargaOrdenDetalles(Integer idturno, Integer item, String orden, Long idproduccion);
}
