package com.nw.model.dao;

import java.util.List;

import com.nw.model.Luthy;

public interface LuthyDAO {

	void saveOrUpdate(Luthy luthy);
	Luthy getLuthyById(Integer idluthy);
	public List<Luthy> getAll();
}
