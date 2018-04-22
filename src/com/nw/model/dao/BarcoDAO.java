package com.nw.model.dao;

import java.util.List;

import com.nw.model.Barco;

public interface BarcoDAO extends Dao {

	public List<Barco> getBarcos();
}
