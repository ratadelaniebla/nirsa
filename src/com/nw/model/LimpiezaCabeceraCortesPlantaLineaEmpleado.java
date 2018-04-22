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
public class LimpiezaCabeceraCortesPlantaLineaEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezacabeceracortesplantalineaempleados;

	private Timestamp fechareg;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaCabeceraCortesPlantaLineaEmpleado")
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;

	public LimpiezaCabeceraCortesPlantaLineaEmpleado() {
	}

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

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
	}

}