package com.nw.util.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.nw.util.Sistema;

/**
 * Clase para ejecutar las operaciones JDBC de forma nativa sobre la base de datos
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-02-14
 */
public class Dao {

	private static Logger log = Logger.getLogger(Dao.class);

	/**
	 * Devuelve la conexión hacia la base de datos
	 * @return
	 */
	public Connection getDBConnection() {
		Connection dbConnection = null;
		Jdbc jdbc = new Jdbc();
 
		try {
			Class.forName( jdbc.getDriver() ) ;
			dbConnection = DriverManager.getConnection( jdbc.getUrl(), jdbc.getUser(), jdbc.getPassword() ) ;
			return dbConnection;
		}catch (Exception e) {
			log.error( Sistema.stack2string(e) );
		}
		return dbConnection;
	}

}
