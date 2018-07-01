package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the esterilizado_proceso_parada database table.
 * 
 */
@Entity
@Table(name="esterilizado_proceso_parada")
@NamedQuery(name="EsterilizadoProcesoParada.findAll", query="SELECT e FROM EsterilizadoProcesoParada e")
public class EsterilizadoProcesoParada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idesterilizadoprocesoparada;
	private Integer blider;
	private Integer estado;
	private Timestamp fechareg;
	private Integer finproceso;
	private String flujoaguals;
	private Timestamp horacerradoventeo;
	private Timestamp horacerradoventeo2;
	private Timestamp horafinalenfriamiento;
	private Timestamp horafinproceso;
	private Timestamp horainicioproceso;
	private Timestamp horainiciovapor;
	private Timestamp horaregmanometro;
	private Timestamp horaregmanometro2;
	private Timestamp horasalida;
	private Timestamp horaselladolata;
	private String idusuariomod;
	private Long numerografica;
	private Integer numparada;
	private String presionmanometro;
	private String presionmanometro2;
	private String presionvaporpsi;
	private String temperaturacerradoventeo;
	private String temperaturacerradoventeo2;
	private String temperaturagrafica;
	private String temperaturagrafica2;
	private String temperaturainicial;
	private String temperaturamercurio;
	private String temperaturamercurio2;
	private String temperaturasalida;
	private Timestamp horadescarga;
	private Autoclave autoclave;
	private EsterilizadoProceso esterilizadoProceso;
	private Usuario usuario;
	private Produccion produccion;
	private List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches;
	private Turno turno;
	
	public EsterilizadoProcesoParada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdesterilizadoprocesoparada() {
		return this.idesterilizadoprocesoparada;
	}

	public void setIdesterilizadoprocesoparada(Long idesterilizadoprocesoparada) {
		this.idesterilizadoprocesoparada = idesterilizadoprocesoparada;
	}


	public Integer getBlider() {
		return this.blider;
	}

	public void setBlider(Integer blider) {
		this.blider = blider;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getHoracerradoventeo() {
		return this.horacerradoventeo;
	}

	public void setHoracerradoventeo(Timestamp horacerradoventeo) {
		this.horacerradoventeo = horacerradoventeo;
	}


	public Timestamp getHorainiciovapor() {
		return this.horainiciovapor;
	}

	public void setHorainiciovapor(Timestamp horainiciovapor) {
		this.horainiciovapor = horainiciovapor;
	}

	
	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}
	

	public Long getNumerografica() {
		return this.numerografica;
	}

	public void setNumerografica(Long numerografica) {
		this.numerografica = numerografica;
	}


	public Integer getNumparada() {
		return this.numparada;
	}

	public void setNumparada(Integer numparada) {
		this.numparada = numparada;
	}


	public String getPresionmanometro() {
		return this.presionmanometro;
	}

	public void setPresionmanometro(String presionmanometro) {
		this.presionmanometro = presionmanometro;
	}


	public String getTemperaturacerradoventeo() {
		return this.temperaturacerradoventeo;
	}

	public void setTemperaturacerradoventeo(String temperaturacerradoventeo) {
		this.temperaturacerradoventeo = temperaturacerradoventeo;
	}


	public String getTemperaturagrafica() {
		return this.temperaturagrafica;
	}

	public void setTemperaturagrafica(String temperaturagrafica) {
		this.temperaturagrafica = temperaturagrafica;
	}


	public String getTemperaturainicial() {
		return this.temperaturainicial;
	}

	public void setTemperaturainicial(String temperaturainicial) {
		this.temperaturainicial = temperaturainicial;
	}


	public String getTemperaturamercurio() {
		return this.temperaturamercurio;
	}

	public void setTemperaturamercurio(String temperaturamercurio) {
		this.temperaturamercurio = temperaturamercurio;
	}


	public Integer getFinproceso() {
		return finproceso;
	}


	public void setFinproceso(Integer finproceso) {
		this.finproceso = finproceso;
	}


	public String getFlujoaguals() {
		return flujoaguals;
	}


	public void setFlujoaguals(String flujoaguals) {
		this.flujoaguals = flujoaguals;
	}


	public Timestamp getHorafinalenfriamiento() {
		return horafinalenfriamiento;
	}


	public void setHorafinalenfriamiento(Timestamp horafinalenfriamiento) {
		this.horafinalenfriamiento = horafinalenfriamiento;
	}


	public Timestamp getHorafinproceso() {
		return horafinproceso;
	}


	public void setHorafinproceso(Timestamp horafinproceso) {
		this.horafinproceso = horafinproceso;
	}


	public Timestamp getHorainicioproceso() {
		return horainicioproceso;
	}


	public void setHorainicioproceso(Timestamp horainicioproceso) {
		this.horainicioproceso = horainicioproceso;
	}


	public Timestamp getHoraregmanometro()  {
		return horaregmanometro;
	}


	public void setHoraregmanometro(Timestamp horaregmanometro) {
		this.horaregmanometro = horaregmanometro;
	}


	public Timestamp getHorasalida() {
		return horasalida;
	}


	public void setHorasalida(Timestamp horasalida) {
		this.horasalida = horasalida;
	}


	public Timestamp getHoraselladolata() {
		return horaselladolata;
	}


	public void setHoraselladolata(Timestamp horaselladolata) {
		this.horaselladolata = horaselladolata;
	}


	public String getPresionvaporpsi() {
		return presionvaporpsi;
	}


	public void setPresionvaporpsi(String presionvaporpsi) {
		this.presionvaporpsi = presionvaporpsi;
	}


	public String getTemperaturasalida() {
		return temperaturasalida;
	}


	public void setTemperaturasalida(String temperaturasalida) {
		this.temperaturasalida = temperaturasalida;
	}

	
	public Timestamp getHoracerradoventeo2() {
		return horacerradoventeo2;
	}


	public void setHoracerradoventeo2(Timestamp horacerradoventeo2) {
		this.horacerradoventeo2 = horacerradoventeo2;
	}


	public Timestamp getHoraregmanometro2() {
		return horaregmanometro2;
	}


	public void setHoraregmanometro2(Timestamp horaregmanometro2) {
		this.horaregmanometro2 = horaregmanometro2;
	}


	public String getPresionmanometro2() {
		return presionmanometro2;
	}


	public void setPresionmanometro2(String presionmanometro2) {
		this.presionmanometro2 = presionmanometro2;
	}


	public String getTemperaturacerradoventeo2() {
		return temperaturacerradoventeo2;
	}


	public void setTemperaturacerradoventeo2(String temperaturacerradoventeo2) {
		this.temperaturacerradoventeo2 = temperaturacerradoventeo2;
	}


	public String getTemperaturagrafica2() {
		return temperaturagrafica2;
	}


	public void setTemperaturagrafica2(String temperaturagrafica2) {
		this.temperaturagrafica2 = temperaturagrafica2;
	}


	public String getTemperaturamercurio2() {
		return temperaturamercurio2;
	}


	public void setTemperaturamercurio2(String temperaturamercurio2) {
		this.temperaturamercurio2 = temperaturamercurio2;
	}


	public String getIdusuariomod() {
		return idusuariomod;
	}


	public void setIdusuariomod(String idusuariomod) {
		this.idusuariomod = idusuariomod;
	}


	public Timestamp getHoradescarga() {
		return horadescarga;
	}

	public void setHoradescarga(Timestamp horadescarga) {
		this.horadescarga = horadescarga;
	}


	//bi-directional many-to-one association to Autoclave
	@ManyToOne
	@JoinColumn(name="idautoclave")
	public Autoclave getAutoclave() {
		return this.autoclave;
	}

	public void setAutoclave(Autoclave autoclave) {
		this.autoclave = autoclave;
	}


	//bi-directional many-to-one association to EsterilizadoProceso
	@ManyToOne
	@JoinColumn(name="idesterilizadoproceso")
	public EsterilizadoProceso getEsterilizadoProceso() {
		return this.esterilizadoProceso;
	}

	public void setEsterilizadoProceso(EsterilizadoProceso esterilizadoProceso) {
		this.esterilizadoProceso = esterilizadoProceso;
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
		
	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}
	
	//bi-directional many-to-one association to EsterilizadoProcesoParadaCoche
	@OneToMany(mappedBy="esterilizadoProcesoParada")
	public List<EsterilizadoProcesoParadaCoche> getEsterilizadoProcesoParadaCoches() {
		return this.esterilizadoProcesoParadaCoches;
	}

	public void setEsterilizadoProcesoParadaCoches(List<EsterilizadoProcesoParadaCoche> esterilizadoProcesoParadaCoches) {
		this.esterilizadoProcesoParadaCoches = esterilizadoProcesoParadaCoches;
	}

	public EsterilizadoProcesoParadaCoche addEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().add(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoProcesoParada(this);

		return esterilizadoProcesoParadaCoch;
	}

	public EsterilizadoProcesoParadaCoche removeEsterilizadoProcesoParadaCoch(EsterilizadoProcesoParadaCoche esterilizadoProcesoParadaCoch) {
		getEsterilizadoProcesoParadaCoches().remove(esterilizadoProcesoParadaCoch);
		esterilizadoProcesoParadaCoch.setEsterilizadoProcesoParada(null);

		return esterilizadoProcesoParadaCoch;
	}

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
}