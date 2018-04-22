package com.nw.model.dao;

import java.util.List;

import com.nw.model.EspecieTalla;

public interface EspecieTallaDAO extends Dao {

	public List<EspecieTalla> getEspecieTalla();
	
	public List<EspecieTalla> getEspecieTalla(String condicion,  boolean checked);
}
