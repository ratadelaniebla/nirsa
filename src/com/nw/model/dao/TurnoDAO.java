package com.nw.model.dao;

import com.nw.model.Turno;

public interface TurnoDAO extends Dao {
	void saveOrUpdate(Turno turno);
}
