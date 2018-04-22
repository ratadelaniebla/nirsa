/**
 * 
 */
package com.nw.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.nw.model.OeeDetalleMediosConDefecto;
import com.nw.model.OeeDetalleMediosConDefectoLimpieza;
import com.nw.model.dao.OeeDetalleMediosConDefectoDAO;

 
@SuppressWarnings("unchecked")
public class OeeDetalleMediosConDefectoDAOJpaImpl extends BaseDaoJpaImpl
		implements OeeDetalleMediosConDefectoDAO {
	public OeeDetalleMediosConDefectoDAOJpaImpl() {
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectoByIds(
			long idprocesoaperturacierre, int idproceso) {
		StringBuilder sbuilder = new StringBuilder();
		try {
			sbuilder.append("SELECT odp ");
			sbuilder.append("FROM ProcesoAperturaCierre pac, OeeDetalleMediosConDefecto odp, ProduccionDetalleLote pdl ");
			sbuilder.append("WHERE odp.procesoAperturaCierre.idprocesoaperturacierre = pac.idprocesoaperturacierre ");
			sbuilder.append("AND odp.produccionDetalleLote.idproducciondetallelote = pdl.idproducciondetallelote ");
			sbuilder.append("AND pac.idprocesoaperturacierre = :idprocesoaperturacierre ");
			sbuilder.append("AND pac.proceso.idproceso =:idproceso ");
			sbuilder.append("ORDER BY odp.fechaRegistro, odp.cantidadDefectos");
			return (List<OeeDetalleMediosConDefecto>) em
					.createQuery(sbuilder.toString())
					.setParameter("idprocesoaperturacierre",
							idprocesoaperturacierre)
					.setParameter("idproceso", idproceso)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			em.close();
		}
	}
	
	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoByIdProcesoAperturaAndLimpiezaLinea(
			long idprocesoaperturacierre, int idlimpiezalinea) {
		List<OeeDetalleMediosConDefectoLimpieza> lista = new ArrayList<>();
		try {
			String sql = "  Select omcdl " +
						 "  From OeeDetalleMediosConDefectoLimpieza omcdl , OeeDetalleMediosConDefecto omcd " +
						 "   where omcdl.oeeDetalleMediosConDefecto.idOeeDetalleMediosConDefecto = omcd.idOeeDetalleMediosConDefecto  " +
						 "    and  omcd.procesoAperturaCierre.idprocesoaperturacierre =:idprocesoaperturacierre   " +
						 "     and   omcdl.limpiezaLinea.idlimpiezalinea =:idlimpieza order by omcdl.idOeeDetalleMediosConDefectoLimpieza	";
			
			 lista = (List<OeeDetalleMediosConDefectoLimpieza>) em
					.createQuery(sql)
					.setParameter("idprocesoaperturacierre", idprocesoaperturacierre)
					.setParameter("idlimpieza", idlimpiezalinea)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return lista;
		}finally{
			em.close();
		}
		return lista;
	}
	

	public OeeDetalleMediosConDefecto saveOrUpdate(OeeDetalleMediosConDefecto detallemedioscondefecto) {
		EntityTransaction t = em.getTransaction();
		OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto = new OeeDetalleMediosConDefecto();
		try {
			t.begin();
			oeeDetalleMediosConDefecto = em.merge(detallemedioscondefecto);
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	   return oeeDetalleMediosConDefecto;
	}
	
	
	public void saveOrUpdateDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza detallemedioscondefectolimpieza) {
		EntityTransaction t = em.getTransaction();
		 
		try {
			t.begin();
			  em.merge(detallemedioscondefectolimpieza);
			t.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (t.isActive()) {
				t.rollback();
			}
		} finally {
			em.close();
		}
	  
	}

	public int delete(OeeDetalleMediosConDefecto defecto) {
		int res = 0;
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				OeeDetalleMediosConDefecto def = em.find(
						OeeDetalleMediosConDefecto.class,
						defecto.getIdOeeDetalleMediosConDefecto());
				em.remove(def);
				t.commit();
				res = 0;
		 }catch (RuntimeException e) {
			 res = 1;
				e.printStackTrace();
				if (t.isActive()) {
					t.rollback();
				}
			 
		} finally {
			em.close();
		}
		
	  return res;	
	}
	
	public int deleteDefectoLimpieza(OeeDetalleMediosConDefectoLimpieza defecto) {
		int res = 0;
		EntityTransaction t = em.getTransaction();
		try {
				t.begin();
				OeeDetalleMediosConDefectoLimpieza def = em.find(
						OeeDetalleMediosConDefectoLimpieza.class,
						defecto.getIdOeeDetalleMediosConDefectoLimpieza());
				em.remove(def);
				t.commit();
				res = 0;
		 }catch (RuntimeException e) {
			 res = 1;
				e.printStackTrace();
				if (t.isActive()) {
					t.rollback();
				}
			 
		} finally {
			em.close();
		}
		
	  return res;	
	}

}