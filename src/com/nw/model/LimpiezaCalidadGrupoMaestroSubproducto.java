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
@NamedQuery(name="LimpiezaCalidadGrupoMaestroSubproducto.findAll", query="SELECT l FROM LimpiezaCalidadGrupoMaestroSubproducto l")
public class LimpiezaCalidadGrupoMaestroSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezacalidadgrupomaestrosubproducto;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private LimpiezaCalidadGrupo limpiezaCalidadGrupo;
	private LimpiezaCalidadMaestroSubproducto limpiezaCalidadMaestroSubproducto;

	public LimpiezaCalidadGrupoMaestroSubproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezacalidadgrupomaestrosubproducto() {
		return this.idlimpiezacalidadgrupomaestrosubproducto;
	}

	public void setIdlimpiezacalidadgrupomaestrosubproducto(Integer idlimpiezacalidadgrupomaestrosubproducto) {
		this.idlimpiezacalidadgrupomaestrosubproducto = idlimpiezacalidadgrupomaestrosubproducto;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaCalidadGrupoMaestroSubproducto")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaCalidadGrupoMaestroSubproducto(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setLimpiezaCalidadGrupoMaestroSubproducto(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaCalidadGrupo
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadgrupo")
	public LimpiezaCalidadGrupo getLimpiezaCalidadGrupo() {
		return this.limpiezaCalidadGrupo;
	}

	public void setLimpiezaCalidadGrupo(LimpiezaCalidadGrupo limpiezaCalidadGrupo) {
		this.limpiezaCalidadGrupo = limpiezaCalidadGrupo;
	}


	//bi-directional many-to-one association to LimpiezaCalidadMaestroSubproducto
	@ManyToOne
	@JoinColumn(name="idlimpiezacalidadmaestrosubproducto")
	public LimpiezaCalidadMaestroSubproducto getLimpiezaCalidadMaestroSubproducto() {
		return this.limpiezaCalidadMaestroSubproducto;
	}

	public void setLimpiezaCalidadMaestroSubproducto(LimpiezaCalidadMaestroSubproducto limpiezaCalidadMaestroSubproducto) {
		this.limpiezaCalidadMaestroSubproducto = limpiezaCalidadMaestroSubproducto;
	}

}