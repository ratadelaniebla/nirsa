package com.nw.model.dao;

public interface SecuenciaDAO extends Dao {

	public Long getSiguienteId(String tabla, String campo);
}
