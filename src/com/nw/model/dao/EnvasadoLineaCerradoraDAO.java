package com.nw.model.dao;

import java.util.List;

import com.nw.model.EnvasadoLineaCerradora;

public interface EnvasadoLineaCerradoraDAO {
	
	public EnvasadoLineaCerradora getEnvasadoLineaCerradora(Integer id);
	
	public List<EnvasadoLineaCerradora> getEnvasadoLineaCerradoraAll();
}
