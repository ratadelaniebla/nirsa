package com.nw.model.dao.impl;

import java.util.List;

import com.nw.model.ProduccionArchivoCargaOrdenDetalle;
import com.nw.model.dao.ProduccionArchivoCargaOrdenDetalleDAO;

public class ProduccionArchivoCargaOrdenDetalleDAOJpaImpl extends BaseDaoJpaImpl implements ProduccionArchivoCargaOrdenDetalleDAO{

	@Override
	public boolean existeArchivoCargaOrdenDetalle(Integer idturno, Integer item, String orden, Long idproduccion) {
		if (archivoCargaOrdenDetalles(idturno, item, orden, idproduccion).isEmpty())
			return false;
		return true;
	}
	/**
	 * verifica si que el turno, item, orden, produccion sean unicos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProduccionArchivoCargaOrdenDetalle> archivoCargaOrdenDetalles(Integer idturno, Integer item, String orden, Long idproduccion) {
		
		String sql = "SELECT a FROM ProduccionArchivoCargaOrdenDetalle a " +
				"where a.turno.idturno	= :turno " +
				"and a.item 		= :item " +
				"and a.orden 		= :orden "+
				"and a.produccionArchivoCargaOrden.produccion.idproduccion = :idproduccion ";
		return (List<ProduccionArchivoCargaOrdenDetalle>) em.createQuery(sql)
				.setParameter("turno", idturno)
				.setParameter("item", item)
				.setParameter("orden", orden)
				.setParameter("idproduccion", idproduccion).getResultList();
	}
}
