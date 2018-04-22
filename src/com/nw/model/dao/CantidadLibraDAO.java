package com.nw.model.dao;

import com.nw.model.CantidadLibra;

public interface CantidadLibraDAO {

	CantidadLibra getCantidadLibraById(Integer id);

	void saveOrUpdate(CantidadLibra cantidadLibra);

}
