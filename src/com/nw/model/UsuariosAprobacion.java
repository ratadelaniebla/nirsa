package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios_aprobacion database table.
 * 
 */
@Entity
@Table(name="usuarios_aprobacion")
public class UsuariosAprobacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idaprobacionusuario;

	private Boolean accesoaprobacion;

	private Boolean accesorevision;

	private Boolean accesoverificado;

	private Integer estado;

	private Integer idarea;

	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="usuariosAprobacion")
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public UsuariosAprobacion() {
	}

	public Integer getIdaprobacionusuario() {
		return this.idaprobacionusuario;
	}

	public void setIdaprobacionusuario(Integer idaprobacionusuario) {
		this.idaprobacionusuario = idaprobacionusuario;
	}

	public Boolean getAccesoaprobacion() {
		return this.accesoaprobacion;
	}

	public void setAccesoaprobacion(Boolean accesoaprobacion) {
		this.accesoaprobacion = accesoaprobacion;
	}

	public Boolean getAccesorevision() {
		return this.accesorevision;
	}

	public void setAccesorevision(Boolean accesorevision) {
		this.accesorevision = accesorevision;
	}

	public Boolean getAccesoverificado() {
		return this.accesoverificado;
	}

	public void setAccesoverificado(Boolean accesoverificado) {
		this.accesoverificado = accesoverificado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getIdarea() {
		return this.idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}