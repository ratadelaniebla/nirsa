package com.nw.model.dao;

import java.util.List;

import com.nw.model.BarcoCuba;

public interface BarcoCubaDAO extends Dao {


	public List<BarcoCuba> getBarcosCubas(Integer id);
}
