package com.nw.temp.model;

import java.io.Serializable;

import javax.persistence.Column;


public class LoteTemp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int iddetmovimiento;	
	
	@Column(length=10)
    private String _firstName = "";

    public LoteTemp() {
    }
    
//    public LoteTemp(String firstName) {
//        _firstName = firstName;
//    }

    public String getFirstName() {
        return _firstName;
    }

	public void setFirstName(String firstname) {
		this._firstName = firstname;
	}  
	
//	public int getIddetmovimiento() {
//		return this.iddetmovimiento;
//	}
//
//	public void setIddetmovimiento(int iddetmovimiento) {
//		this.iddetmovimiento = iddetmovimiento;
//	}	


    
//    private String _firstName = "";
//    private String _lastName = "";
//    private int _age = 1;
//
//    public LoteTemp(String firstName, String lastName, int age) {
//        _firstName = firstName;
//        _lastName = lastName;
//        _age = age;
//    }
//
//    public String getFirstName() {
//        return _firstName;
//    }
//    public String getLastName() {
//        return _lastName;
//    }
//    public String getFullName() {
//        return _firstName + " " + _lastName;
//    }
//    public int getAge () {
//        return _age;
//    }
}