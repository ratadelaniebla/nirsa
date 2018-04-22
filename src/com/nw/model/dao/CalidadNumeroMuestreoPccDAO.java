package com.nw.model.dao;

import java.util.List;

import com.nw.model.CalidadNumeroMuestreoPcc;

public interface CalidadNumeroMuestreoPccDAO extends Dao {

	public List<CalidadNumeroMuestreoPcc> getCalidadNumeroMuestreoPcc(Integer idmuestro);
}
