package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tmp_tara database table.
 * 
 */
@Entity
@Table(name="tmp_tara")
public class TmpTara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idtmptara;

	private String idcajon;

	private Integer tara;

	public TmpTara() {
	}

	public Integer getIdtmptara() {
		return this.idtmptara;
	}

	public void setIdtmptara(Integer idtmptara) {
		this.idtmptara = idtmptara;
	}

	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}

	public Integer getTara() {
		return this.tara;
	}

	public void setTara(Integer tara) {
		this.tara = tara;
	}

}