package ar.edu.unju.fi.ejercicio3;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {

		/**
		 * Guardar datos en un array
		 */		
		Provincia[] provincias = Provincia.values();

		/**
		 * Mostrar cada enum con su respectiva información 
		 * incluyendo la densidad poblacional
		 */

		for (Provincia provincia : provincias) {
			System.out.println("Provincia: " + provincia);
			System.out.println("Cantidad de población: " + provincia.getCantidadPoblacion());
			System.out.println("Superficie: " + provincia.getSuperficie() + " km cuad");
			System.out.println("Densidad poblacional: " + provincia.densidadPoblacional() + " hab/km cuad");
			System.out.println();
		}
	}
}
