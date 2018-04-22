package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_calidad_grupo_maestro_subproducto database table.
 * 
 */
@Entity
@Table(name="limpieza_calidad_grupo_maestro_subproducto")
public class LimpiezaCalidadGrupoMaestroSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezacalidadgrupomaestrosubproducto;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaCalidadGrupoMaestroSubproducto")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaCalidadGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadgrupo")
	private LimpiezaCalidadGrupo limpiezaCalidadGrupo;

	//bi-directional many-to-one association to LimpiezaCalidadMaestroSubproducto
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadmaestrosubproducto")
	private LimpiezaCalidadMaestroSubproducto limpiezaCalidadMaestroSubproducto;


	public LimpiezaCalidadGrupoMaestroSubproducto() {
	}

	public Integer getIdlimpiezacalidadgrupomaestrosubproducto() {
		return this.idlimpiezacalidadgrupomaestrosubproducto;
	}

	public void setIdlimpiezacalidadgrupomaestrosubproducto(Integer idlimpiezacalidadgrupomaestrosubproducto) {
		this.idlimpiezacalidadgrupomaestrosubproducto = idlimpiezacalidadgrupomaestrosubproducto;
	}

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadGrupo getLimpiezaCalidadGrupo() {
		return this.limpiezaCalidadGrupo;
	}

	public void setLimpiezaCalidadGrupo(LimpiezaCalidadGrupo limpiezaCalidadGrupo) {
		this.limpiezaCalidadGrupo = limpiezaCalidadGrupo;
	}

	public LimpiezaCalidadMaestroSubproducto getLimpiezaCalidadMaestroSubproducto() {
		return this.limpiezaCalidadMaestroSubproducto;
	}

	public void setLimpiezaCalidadMaestroSubproducto(LimpiezaCalidadMaestroSubproducto limpiezaCalidadMaestroSubproducto) {
		this.limpiezaCalidadMaestroSubproducto = limpiezaCalidadMaestroSubproducto;
	}

}