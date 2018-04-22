package com.nw.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.avante.core.jpa.JPAPersistenceManager;
import com.nw.model.MaquinaCerradora;

@SuppressWarnings({"unchecked"})
public class MaquinaCerradoraDAOJpaImpl extends BaseDaoJpaImpl{
	
	@PersistenceContext
	private EntityManagerFactory emf;
    private EntityManager em;

    public MaquinaCerradoraDAOJpaImpl(){
    	emf = JPAPersistenceManager.getInstance().getEntityManagerFactory();
        em = emf.createEntityManager();   
    }
	
	public List<MaquinaCerradora>getMaquinasCerradora(){
		return em.createQuery("select l from MaquinaCerradora l order by l.idmaquinacerradora").getResultList();
	}
	
	//metodo creado por el proveeedor
	public List<MaquinaCerradora> getAll() {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT m ");
			sbuilder.append("FROM MaquinaCerradora m ");
			sbuilder.append("ORDER BY m.descripcion");
			return (List<MaquinaCerradora>) em.createQuery(sbuilder.toString())
					.getResultList();
		} catch (Exception e) {
			em.close();
			return null;
		}
	}
	
}
