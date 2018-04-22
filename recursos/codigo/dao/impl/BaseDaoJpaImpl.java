package com.wm.model.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.orm.ObjectRetrievalFailureException;
//import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.wm.model.dao.Dao;


/**
 * This class serves as the Base class for all other Daos - namely to hold
 * common methods that they might all use. Can be used for standard CRUD
 * operations.</p>
 *
 * <p><a href="BaseDaoJpaImpl.java.html"><i>View Source</i></a></p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * modified by <a href="mailto:ramzi.maalej@gmail.com">Ramzi Maâlej</a> to work with JPA.
 * 
 * @version 0.0.1//extends JpaDaoSupport
 */
public class BaseDaoJpaImpl implements Dao {
    protected final Log log = LogFactory.getLog(getClass());

    protected static String vDBMS = "MYSQL";//(String) Sessions.getCurrent().getAttribute(Sistema.PG_DBMS); 

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;
    
    /**
     * @see com.avante.model.dao.Dao#saveObject(java.lang.Object)
     */
    @Override
    public void saveObject(Object o) {
        em.persist(o);
    }

    public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
     * @see com.avante.model.dao.Dao#getObject(java.lang.Class, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
	@Override
    public Object getObject(Class clazz, Serializable id) {
        Object o = em.find(clazz, id);
        if (o == null) {
           // throw new ObjectRetrievalFailureException(clazz, id);
        }
        return o;
    }

    /**
     * @see com.avante.model.dao.Dao#getObjects(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
	@Override
    public List getObjects(Class clazz) {
    	return em.createQuery("select p from "+clazz.getSimpleName()+" p").getResultList();
    }

    /**
     * @see com.avante.model.dao.Dao#removeObject(java.lang.Class, java.io.Serializable)
     */
    @SuppressWarnings("unchecked")
	@Override
    public void removeObject(Class clazz, Serializable id) {
        em.remove(getObject(clazz, id));
    }

	/**
	 * @see com.avante.model.dao.Dao#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(Object o) {
		em.merge(o);
	}
}
