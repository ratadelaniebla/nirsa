package com.avante.core.jpa;
 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener; 
  
public class JPAPersistenceAppListener implements ServletContextListener {   
	public void contextInitialized(ServletContextEvent evt) {  
	}  
  
	public void contextDestroyed(ServletContextEvent evt) {      
		JPAPersistenceManager.getInstance().closeEntityManagerFactory();  
		}

}
 