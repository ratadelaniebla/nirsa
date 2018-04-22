package com.nw.model.dao;

//import java.util.List;
//import com.nw.model.DesperdicioDetalle;
import com.nw.model.DetalleLoteDesperdicio;

public interface DesperdicioHarinaDetalleLoteDesperdicioDAO extends Dao {

	void saveOrUpdate(DetalleLoteDesperdicio detallelotedesperdicio);

	DetalleLoteDesperdicio DetalleLoteDesperdicioById(String ID);

	
}
