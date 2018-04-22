package com.wm.model.dao;

import java.util.List;

import com.wm.model.Dominios;

public interface DominiosDAO {

	List<Dominios> getRecursos();

	List<Dominios> getCocinas();

	List<Dominios> getCocinadas();

	List<Dominios> getMesas();

	List<Dominios> getFactor();	
	
	List<Dominios> getCamaras();

	List<Dominios> getProcesosNebulizado();

	Dominios getItemRecursoById(int itemId);

	Dominios getItemCocinaById(int itemId);

	Dominios getItemCocinadasById(int itemId);

	Dominios getItemMesasById(int itemId);

	Dominios getItemCamaraById(int itemId);

	Dominios getItemProcNebulizadoById(int itemId);

	List<Dominios> getMateriales();

	Dominios getMaterialById(int itemId);

	List<Dominios> getLineasProduccion();

	Dominios getLineasProduccionById(int itemId);

	
}
