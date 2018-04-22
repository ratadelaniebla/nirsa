package com.nw.util;

public class Hora{
	private int hor;
	private int min;
	private int seg;
	
	public void setHora(String str) {
		hor = Integer.parseInt(str.substring(0, 2));
		min = Integer.parseInt(str.substring(3, 5));
		try {
			seg = Integer.parseInt(str.substring(6, 8));
		} catch (Exception e) {
			seg = 0;
		}
	}
		
	public int getHora() {
		return hor;
	}
	public int getMinutos() {
		return min;
	}
	public int getSegundos() {
		return seg;
	}
}
