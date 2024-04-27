package ar.edu.unju.fi.ejercicio4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	ArrayList <Jugador> jugadores = new ArrayList<>();

	public static void main(String[] args) {
		
		 int opcion;
	        do {
	            menu();
	            opcion = leerOpcion();
	            sc.nextLine(); 

	            switch (opcion) {
	                case 1:
	                   // alta();
	                    break;
	                case 2:
	                   // mostrar();
	                    break;
	                case 3:
	                    //modificar();
	                    break;
	                case 4:
	                    //eliminar();
	                    break;
	                case 5:
	                    System.out.println("Chaito!...");
	                    break;
	                default:
	                    System.out.println("Opcion no valida.");
	            }
	        } while (opcion != 5);
	    }
	/**
	 * 	Metodo que imprime en consola las opciones del menu
	 */
	private static void menu() {
        System.out.println("\nMENU:\n");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar la posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.print("\nIngrese una opción: ");

	}
	
	/**
	 * metodo para leer la opcion del switch con control
	 * de excepciones
	 * @return retorna cero para ingresar por el default
	 * del switch en caso de ingresar un caracter distinto
	 * a un nro 
	 */
	private static int leerOpcion() {
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {
			sc.next();
			return 0;
		}
	}

}
