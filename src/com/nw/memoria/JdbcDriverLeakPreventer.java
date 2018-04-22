package com.nw.memoria;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;

public class JdbcDriverLeakPreventer 
{

	  public void contextInitialized(ServletContextEvent sce) 
	  {
	    //Nothing to do
	  }
	 
	  public void contextDestroyed(ServletContextEvent sce) 
	  {
		  
	    ClassLoader applicationClassLoader = this.getClass().getClassLoader();
	    @SuppressWarnings("rawtypes")
		Enumeration driverEnumeration = DriverManager.getDrivers();
	    while (driverEnumeration.hasMoreElements()) 
	    {
	    	
	      Driver driver = (Driver) driverEnumeration.nextElement();
	      ClassLoader driverClassLoader = driver.getClass().getClassLoader();
	      if (driverClassLoader != null
	          && driverClassLoader.equals(applicationClassLoader))
	      {
	        try {
	          DriverManager.deregisterDriver(driver);
	        } catch (SQLException e) {
	          e.printStackTrace(); //TODO Replace with your exception handling
	        }
	      }
	    }
	  }	
	
}
