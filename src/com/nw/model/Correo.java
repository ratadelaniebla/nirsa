package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the correos database table.
 * 
 */
@Entity
@Table(name="correos")
public class Correo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcorreo;

	private String correo;

	private Integer estado;

	private Timestamp fechareg;

	private String idusuario;

	//bi-directional many-to-one association to CorreosPccParametro
	@OneToMany(mappedBy="correo")
	private List<CorreosPccParametro> correosPccParametros;

	public Correo() {
	}

	public Long getIdcorreo() {
		return this.idcorreo;
	}

	public void setIdcorreo(Long idcorreo) {
		this.idcorreo = idcorreo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public List<CorreosPccParametro> getCorreosPccParametros() {
		return this.correosPccParametros;
	}

	public void setCorreosPccParametros(List<CorreosPccParametro> correosPccParametros) {
		this.correosPccParametros = correosPccParametros;
	}

}