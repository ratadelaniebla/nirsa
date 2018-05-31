package com.nw.model.dao;

import java.util.List;

import com.nw.model.Autoclave;

public interface AutoClaveDAO extends Dao {
	public List<Autoclave> getFindAutoClaveAll();
	public List<Autoclave> obtieneAutoClavesDisponibles(Long idproduccion);
	public List<Autoclave> obtieneAutoClavesOcupados(Long idproduccion);
}
