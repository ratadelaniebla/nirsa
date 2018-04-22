package com.nw.model.dao;

import java.util.List;
import com.nw.model.Empleado;
//import com.nw.model.Barco;

public interface EmpleadoDAO extends Dao {

	public List<Empleado> getEmpleados();
}
