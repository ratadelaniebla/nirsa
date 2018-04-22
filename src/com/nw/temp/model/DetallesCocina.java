package com.nw.temp.model;

/**
 * Esta clase personalizada permite seleccionar los item para eliminarlos 
 * segun los que se escojan y ademas permitira saber si son datos provenientes de la base de datos 
 * o si son nuevos y  con esto puedo determinar lo q tengo q modificar o guardar
 */
public class DetallesCocina {
	private Long idevisceradodetalleproceso;
	private Integer numerococinadageneral;
	private Integer idcocina;
	private Integer pedidocamara;
	private Integer idlote;
	private String observaciones;
	private String origen;
	private String nombrebarco;
	private String registro;
	private String destinos;
	private String especie;
	private String talla;	
	private String clasificacion;	
	
	
	private String temp_inicio_espina1;
	private String temp_inicio_espina2;
	private String temp_inicio_espina3;
	private String temp_inicio_espina4;

	private String temp_corte_espina1;
	private String temp_corte_espina2;
	private String temp_corte_espina3;
	private String temp_corte_espina4;

	private String temp_final_espina1;
	private String temp_final_espina2;
	private String temp_final_espina3;
	private String temp_final_espina4;
	

	private String Corte;
	private String Temperatura;
	
	
	private String Curva;	
	private String Hora_Inicio;	
	private String Hora_Fin;	
	private String Hora_RTD;
	
	
	private String rociado;
	private String choque_termico;
	private String ciclo;	
	private String chillroom;
	private String grafico;

	
	public DetallesCocina() 
	{	
	}
	
	//Long idevisceradodetalleproceso, 
	public DetallesCocina(Long idevisceradodetalleproceso, Integer numerococinadageneral, Integer idcocina, Integer pedidocamara,
			Integer idlote, String observaciones, String origen, String nombrebarco, String registro, String destinos,
			String especie, String talla, String clasificacion, 
			String temp_inicio_espina1,String temp_inicio_espina2,String temp_inicio_espina3,String temp_inicio_espina4,
			String temp_corte_espina1,String temp_corte_espina2,String temp_corte_espina3,String temp_corte_espina4,
			String temp_final_espina1,String temp_final_espina2,String temp_final_espina3,String temp_final_espina4,			
			String corte, String temperatura,
			String curva, String hora_inicio, String hora_fin, String 	hora_rtd,			
			String rociado, String choque_termico, 
			String ciclo, String chillroom, String grafico) 
	{		
		
		this.setNumerococinadageneral(numerococinadageneral);
		this.setIdcocina(idcocina);
		this.setPedidocamara(pedidocamara);
		this.setIdlote(idlote);
		this.setObservaciones(observaciones);
		this.setOrigen(origen);
		this.setNombrebarco(nombrebarco);
		this.setRegistro(registro);
		this.setDestinos(destinos);
		this.setEspecie(especie);
		this.setTalla(talla);
		this.setClasificacion(clasificacion);
		
		this.setTemp_inicio_espina1(temp_inicio_espina1);
		this.setTemp_inicio_espina2(temp_inicio_espina2);
		this.setTemp_inicio_espina3(temp_inicio_espina3);
		this.setTemp_inicio_espina4(temp_inicio_espina4);
		
		this.setTemp_corte_espina1(temp_corte_espina1);
		this.setTemp_corte_espina2(temp_corte_espina2);
		this.setTemp_corte_espina3(temp_corte_espina3);
		this.setTemp_corte_espina4(temp_corte_espina4);
		
		this.setTemp_final_espina1(temp_final_espina1);
		this.setTemp_final_espina2(temp_final_espina2);
		this.setTemp_final_espina3(temp_final_espina3);
		this.setTemp_final_espina4(temp_final_espina4);

		this.setCorte(corte);
		this.setTemperatura(temperatura);

		this.setCurva(curva);
		this.setHora_Inicio(hora_inicio);
		this.setHora_Fin(hora_fin);
		this.setHora_RTD(hora_rtd);
		
		this.setRociado(rociado);
		this.setChoque_termico(choque_termico);
		
		this.setCiclo(ciclo);
		this.setChillroom(chillroom);
		this.setGrafico(grafico);
		this.setIdevisceradodetalleproceso(idevisceradodetalleproceso);
	}

	
	
	public Integer getIdlote() 
	{
	 return idlote;
	}

	
	public void setIdlote(Integer idlote) 
	{
	 this.idlote = idlote;
	}


//	public Long getIdevisceradodetalleproceso() {
//		return idevisceradodetalleproceso;
//	}
//
//
//	public void setIdevisceradodetalleproceso(Long idevisceradodetalleproceso) {
//		this.idevisceradodetalleproceso = idevisceradodetalleproceso;
//	}


	public Integer getNumerococinadageneral() {
		return numerococinadageneral;
	}


	public void setNumerococinadageneral(Integer numerococinadageneral) {
		this.numerococinadageneral = numerococinadageneral;
	}


	public Integer getIdcocina() {
		return idcocina;
	}


	public void setIdcocina(Integer idcocina) {
		this.idcocina = idcocina;
	}


	public Integer getPedidocamara() {
		return pedidocamara;
	}


	public void setPedidocamara(Integer pedidocamara) {
		this.pedidocamara = pedidocamara;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getNombrebarco() {
		return nombrebarco;
	}


	public void setNombrebarco(String nombrebarco) {
		this.nombrebarco = nombrebarco;
	}


	public String getRegistro() {
		return registro;
	}


	public void setRegistro(String registro) {
		this.registro = registro;
	}


	public String getDestinos() {
		return destinos;
	}


	public void setDestinos(String destinos) {
		this.destinos = destinos;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getTalla() {
		return talla;
	}


	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getRociado() {
		return rociado;
	}

	public void setRociado(String rociado) {
		this.rociado = rociado;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Long getIdevisceradodetalleproceso() {
		return idevisceradodetalleproceso;
	}

	public void setIdevisceradodetalleproceso(Long idevisceradodetalleproceso) {
		this.idevisceradodetalleproceso = idevisceradodetalleproceso;
	}

	public String getChillroom() {
		return chillroom;
	}

	public void setChillroom(String chillroom) {
		this.chillroom = chillroom;
	}

	public String getGrafico() {
		return grafico;
	}

	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}

	public String getTemp_inicio_espina1() {
		return temp_inicio_espina1;
	}

	public void setTemp_inicio_espina1(String temp_inicio_espina1) {
		this.temp_inicio_espina1 = temp_inicio_espina1;
	}

	public String getTemp_inicio_espina2() {
		return temp_inicio_espina2;
	}

	public void setTemp_inicio_espina2(String temp_inicio_espina2) {
		this.temp_inicio_espina2 = temp_inicio_espina2;
	}

	public String getTemp_inicio_espina3() {
		return temp_inicio_espina3;
	}

	public void setTemp_inicio_espina3(String temp_inicio_espina3) {
		this.temp_inicio_espina3 = temp_inicio_espina3;
	}

	public String getTemp_inicio_espina4() {
		return temp_inicio_espina4;
	}

	public void setTemp_inicio_espina4(String temp_inicio_espina4) {
		this.temp_inicio_espina4 = temp_inicio_espina4;
	}

	public String getTemp_corte_espina1() {
		return temp_corte_espina1;
	}

	public void setTemp_corte_espina1(String temp_corte_espina1) {
		this.temp_corte_espina1 = temp_corte_espina1;
	}

	public String getTemp_corte_espina2() {
		return temp_corte_espina2;
	}

	public void setTemp_corte_espina2(String temp_corte_espina2) {
		this.temp_corte_espina2 = temp_corte_espina2;
	}

	public String getTemp_corte_espina3() {
		return temp_corte_espina3;
	}

	public void setTemp_corte_espina3(String temp_corte_espina3) {
		this.temp_corte_espina3 = temp_corte_espina3;
	}

	public String getTemp_corte_espina4() {
		return temp_corte_espina4;
	}

	public void setTemp_corte_espina4(String temp_corte_espina4) {
		this.temp_corte_espina4 = temp_corte_espina4;
	}

	public String getTemp_final_espina1() {
		return temp_final_espina1;
	}

	public void setTemp_final_espina1(String temp_final_espina1) {
		this.temp_final_espina1 = temp_final_espina1;
	}

	public String getTemp_final_espina2() {
		return temp_final_espina2;
	}

	public void setTemp_final_espina2(String temp_final_espina2) {
		this.temp_final_espina2 = temp_final_espina2;
	}

	public String getTemp_final_espina3() {
		return temp_final_espina3;
	}

	public void setTemp_final_espina3(String temp_final_espina3) {
		this.temp_final_espina3 = temp_final_espina3;
	}

	public String getTemp_final_espina4() {
		return temp_final_espina4;
	}

	public void setTemp_final_espina4(String temp_final_espina4) {
		this.temp_final_espina4 = temp_final_espina4;
	}

	public String getCurva() {
		return Curva;
	}

	public void setCurva(String curva) {
		Curva = curva;
	}

	public String getHora_Inicio() {
		return Hora_Inicio;
	}

	public void setHora_Inicio(String hora_Inicio) {
		Hora_Inicio = hora_Inicio;
	}

	public String getHora_Fin() {
		return Hora_Fin;
	}

	public void setHora_Fin(String hora_Fin) {
		Hora_Fin = hora_Fin;
	}

	public String getHora_RTD() {
		return Hora_RTD;
	}

	public void setHora_RTD(String hora_RTD) {
		Hora_RTD = hora_RTD;
	}

	public String getCorte() {
		return Corte;
	}

	public void setCorte(String corte) {
		Corte = corte;
	}

	public String getTemperatura() {
		return Temperatura;
	}

	public void setTemperatura(String temperatura) {
		Temperatura = temperatura;
	}

	public String getChoque_termico() {
		return choque_termico;
	}

	public void setChoque_termico(String choque_termico) {
		this.choque_termico = choque_termico;
	}


	 

}
