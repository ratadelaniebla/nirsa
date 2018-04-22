package com.nw.model.dao;

import java.util.List;

import com.nw.model.BarcoDescarga;

public interface BarcoDescargaDAO extends Dao {

	public List<BarcoDescarga> getBarcosDescarga();
	
	public void saveOrUpdate(BarcoDescarga barcodescarga);
}
