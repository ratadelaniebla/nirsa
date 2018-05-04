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
@NamedQuery(name="Correo.findAll", query="SELECT c FROM Correo c")
public class Correo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcorreo;
	private String correo;
	private Integer estado;
	private Timestamp fechareg;
	private String idusuario;
	private List<CorreosPccParametro> correosPccParametros;

	public Correo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CorreosPccParametro
	@OneToMany(mappedBy="correo")
	public List<CorreosPccParametro> getCorreosPccParametros() {
		return this.correosPccParametros;
	}

	public void setCorreosPccParametros(List<CorreosPccParametro> correosPccParametros) {
		this.correosPccParametros = correosPccParametros;
	}

	public CorreosPccParametro addCorreosPccParametro(CorreosPccParametro correosPccParametro) {
		getCorreosPccParametros().add(correosPccParametro);
		correosPccParametro.setCorreo(this);

		return correosPccParametro;
	}

	public CorreosPccParametro removeCorreosPccParametro(CorreosPccParametro correosPccParametro) {
		getCorreosPccParametros().remove(correosPccParametro);
		correosPccParametro.setCorreo(null);

		return correosPccParametro;
	}

}