package com.nw.util.dao;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.nw.util.Sistema;

/**
 * Clase que realiza la conexion a la base de datos de forma nativa
 * @author carper CARLOS JULIO PEREZ QUIZHPE carlosjulioperez@gmail.com claro 099 3208265
 * 2014-02-14
 */
public class Jdbc {

	private static Logger log = Logger.getLogger(Jdbc.class);

	private String driver;
	private String url;
	private String user;
	private String password;
	
	/**
	 * Setea la clase con los datos especificados en jdbc.properties
	 */
	public Jdbc() {
		
		try {
			InputStream propertiesInputStream = Jdbc.class.getClassLoader().getResourceAsStream("conexion.properties");
	        Properties properties = new Properties();
	        properties.load(propertiesInputStream);

			driver 		= properties.getProperty("driver");
			url			= properties.getProperty("url");
			user 		= properties.getProperty("user");
			password 	= properties.getProperty("password");
					
		} catch (Exception e) {
			e.printStackTrace();
			String mensaje = Sistema.stack2string(e); 
			log.error(mensaje);
		}
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

}
