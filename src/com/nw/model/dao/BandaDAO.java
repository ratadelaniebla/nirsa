package com.nw.model.dao;

import java.util.List;

import com.nw.model.Banda;


public interface BandaDAO extends Dao {
	public List<Banda> getListBandas();
}
