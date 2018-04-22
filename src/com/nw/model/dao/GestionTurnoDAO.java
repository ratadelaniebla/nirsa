package com.nw.model.dao;


//import java.util.List;
//import com.nw.model.BarcoEstibaCuba;
//import com.nw.model.Cajon;
import com.nw.model.GestionTurno;


public interface GestionTurnoDAO extends Dao {

	void saveOrUpdate(GestionTurno gestionturno);

	GestionTurno getGestionTurnoByProduccionTurno(String f1, Integer idturno);

}
