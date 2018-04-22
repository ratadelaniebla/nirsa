package com.nw.model.dao;

import com.nw.model.Luthy;

public interface LuthyDAO {

	void saveOrUpdate(Luthy luthy);
	Luthy getLuthyById(Integer idluthy);
}
