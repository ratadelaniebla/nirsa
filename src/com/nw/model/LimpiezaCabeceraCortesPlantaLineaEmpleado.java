package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_cabecera_cortes_planta_linea_empleados database table.
 * 
 */
@Entity
@Table(name="limpieza_cabecera_cortes_planta_linea_empleados")
@NamedQuery(name="LimpiezaCabeceraCortesPlantaLineaEmpleado.findAll", query="SELECT l FROM LimpiezaCabeceraCortesPlantaLineaEmpleado l")
public class LimpiezaCabeceraCortesPlantaLineaEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezacabeceracortesplantalineaempleados;
	private Timestamp fechareg;
	private LimpiezaProceso limpiezaProceso;
	private Usuario usuario;
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;

	public LimpiezaCabeceraCortesPlantaLineaEmpleado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezacabeceracortesplantalineaempleados() {
		return this.idlimpiezacabeceracortesplantalineaempleados;
	}

	public void setIdlimpiezacabeceracortesplantalineaempleados(Long idlimpiezacabeceracortesplantalineaempleados) {
		this.idlimpiezacabeceracortesplantalineaempleados = idlimpiezacabeceracortesplantalineaempleados;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
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


	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaCabeceraCortesPlantaLineaEmpleado")
	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado addLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().add(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setLimpiezaCabeceraCortesPlantaLineaEmpleado(this);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado removeLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().remove(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setLimpiezaCabeceraCortesPlantaLineaEmpleado(null);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}

}