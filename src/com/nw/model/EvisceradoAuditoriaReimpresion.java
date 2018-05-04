package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the eviscerado_auditoria_reimpresion database table.
 * 
 */
@Entity
@Table(name="eviscerado_auditoria_reimpresion")
@NamedQuery(name="EvisceradoAuditoriaReimpresion.findAll", query="SELECT e FROM EvisceradoAuditoriaReimpresion e")
public class EvisceradoAuditoriaReimpresion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idevisceradoauditoriareimpresion;
	private Timestamp fechareg;
	private EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche;
	private Usuario usuario;

	public EvisceradoAuditoriaReimpresion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdevisceradoauditoriareimpresion() {
		return this.idevisceradoauditoriareimpresion;
	}

	public void setIdevisceradoauditoriareimpresion(Long idevisceradoauditoriareimpresion) {
		this.idevisceradoauditoriareimpresion = idevisceradoauditoriareimpresion;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idevisceradodetalleprocesocoche")
	public EvisceradoDetalleProcesoCoche getEvisceradoDetalleProcesoCoche() {
		return this.evisceradoDetalleProcesoCoche;
	}

	public void setEvisceradoDetalleProcesoCoche(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoche) {
		this.evisceradoDetalleProcesoCoche = evisceradoDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}