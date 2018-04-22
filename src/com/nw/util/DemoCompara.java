package com.nw.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.util.Date;
//import static javax.swing.JOptionPane.showInputDialog;

public class DemoCompara {
	public static void main(String args[]) throws Exception {
		DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
		String str1 = "02/01/18"; // showInputDialog(“Ingrese primera fecha”);
									// // Formato “dd/mm/aa”
		Date date1 = f.parse(str1);
		String str2 = "10/01/18";// showInputDialog(“Ingrese segunda fecha”);
									// // Formato “dd/mm/aa”
		Date date2 = f.parse(str2);
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		System.out.println("Fecha Inicial: " + f.format(cal1.getTime())
				+ "\t Fecha Final: " + f.format(cal2.getTime()));
		String str3 = "04/01/18"; // showInputDialog(“Ingrese fecha a
									// comprobar:”); // Formato “dd/mm/aa”
		Date date3 = f.parse(str3);
		Calendar cal3 = new GregorianCalendar();
		cal3.setTime(date3);

		if (cal3.after(cal1) && cal3.before(cal2)) {
			System.out.println(f.format("La fecha " + cal3.getTime())
					+ " esta dentro del rango");
		} else {
			System.out.println("La fecha " + f.format(cal3.getTime())
					+ " esta fuera del rango");
		}

	}
}