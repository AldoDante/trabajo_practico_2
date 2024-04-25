package ar.edu.unju.fi.ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList <Efemeride> efemerides = new ArrayList <>();
	
	public static void main(String[] args) {
		
		int opcion;
		do {
			
			System.out.println("\nMenu\n");
			System.out.println("1 – Crear efeméride");
			System.out.println("2 – Mostrar efemérides");
			System.out.println("3 – Eliminar efeméride");
			System.out.println("4 – Modificar efeméride");
			System.out.println("5 – Salir");
			
			System.out.print("\nIngrese su opción: ");
			opcion = leerOpcion();
			
			switch (opcion) {
					
					case 1: crearEfe();
						break;
					case 2: // mostrarEfe
						break;
					case 3: // eliminarEfe
						break;
					case 4: // modificarEfe
						break;
					default: System.err.println("\nSeleccione una opcion del menu");
			}
			
					
			
		} while (opcion!=5);		
	}
	
	
	private static int leerOpcion() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            return 0;
        }
    }
	
	
		
		
		
	private static void crearEfe () {
		
		System.out.println("\nIngrese Codigo");
		int codigo = sc.nextInt();
		
		System.out.println("\nIngrese el Mes[numeros del 1 - 12]");
		int numMes = sc.nextInt();
		
		while (numMes < 1 || numMes > 12) {
            System.out.println("Número de mes incorrecto");
            numMes = sc.nextInt();
        }
		
		Mes mes = Mes.values()[numMes -1];
		
		System.out.println("\nIngrese el dia");
		int dia = sc.nextInt();
		sc.nextLine();
		System.out.println("\nIngrese el detalle");
		String detalle = sc.nextLine();
		
		Efemeride efe = new Efemeride(codigo, mes, dia, detalle);
		efemerides.add(efe);
		System.out.println("\nEfemerides Creada");
		System.out.println(efe);
		
	} 
	
	
}
