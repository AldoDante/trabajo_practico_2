package ar.edu.unju.fi.ejercicio4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList <Jugador> jugadores = new ArrayList<>();

	public static void main(String[] args) {
		
		 int opcion;
	        do {
	            menu();
	            opcion = leerOpcion();
	            sc.nextLine(); 

	            switch (opcion) {
	                case 1:
	                    alta();
	                    break;
	                case 2:
	                	mostrar();
	                    break;
	                case 3:
	                    modificar();
	                    break;
	                case 4:
	                    eliminar();
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
	
	 /**
     * Metodo para el manejo de excepciones en el ingreso de las
     * opciones de los enumerados, se implemento un if con un rango
     * de 1 a 4 el enumerado Posicion posee 4
     * elementos  
     */
    private static int opcionEnum() {
    	int opcion;
    	do {
            System.out.print("\nIngrese una opción:\n");
            try {
                opcion = sc.nextInt();
                
                if (opcion < 1 || opcion > 4) {
                    throw new IllegalArgumentException();
                }
                return opcion;
            } catch (InputMismatchException e) {
                System.err.println("Ingrese un número válido.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println("Ingrese una opción válida.");
            }
        } while (true);
    }
    
    /**
     * Metodo para mostrar el menu de enumerados
     */
    private static void mostrarPosicion() {
        System.out.println("\nPosicion\n");
        int i = 0;
        for (Posicion posiciones : Posicion.values()) {
            i++;
            System.out.println(i + " - " + posiciones);
        }
    }
    
    /**
     *     
     */
    private static void alta () {
    			System.out.println("\nAlta de Jugador");
				System.out.println("\nNombre");
				String nombre = sc.nextLine();
				System.out.println("\nApellido");
				String apellido = sc.nextLine();						
				System.out.println("Ingrese la fecha de nacimiento (formato dd/mm/yyyy):");
		        Calendar fechaNac = null;
		        boolean formatoCorrecto = false;

		        while (!formatoCorrecto) {
		            String fechaStr = sc.nextLine();
		            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		            fechaNac = Calendar.getInstance();
		            try {
		                fechaNac.setTime(formatoFecha.parse(fechaStr));
		                formatoCorrecto = true;
		            } catch (ParseException e) {
		                System.err.println("Formato de fecha incorrecto. Intente nuevamente:");
		            }
		        }								
				System.out.print("\nNacionalidad: ");
				String nacionalidad = sc.nextLine();
				
				try {
					System.out.print("\nEstatura: ");
					double estatura = sc.nextDouble();
					System.out.print("\nPeso: ");
					double peso = sc.nextDouble();
					sc.nextLine();					
					mostrarPosicion();					       
					int opcionPosicion = opcionEnum();
					Posicion posicionJugador = Posicion.values()[opcionPosicion - 1];
					
					Jugador jugador = new Jugador(nombre, apellido, fechaNac, nacionalidad, estatura, peso, posicionJugador);
					jugadores.add(jugador);
					System.out.println("\nJugador Creado Exitosamente");
					
				} catch (InputMismatchException e) {
					System.err.println("Ingrese Numeros para altura y peso use coma decimal si lo necesita");
					sc.nextLine();
				}
			
    }
    
    private static void mostrar() {
        
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
        	System.out.println("\nListado de Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }
    
   /**
    * 
    */
    private static void modificar() {
        if (jugadores.isEmpty()) {
            System.out.println("\nLista de Jugadores vacia");
        } else {
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = sc.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            boolean encontrado = false;
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    mostrarPosicion();
                    int opcionPosicion = opcionEnum();
                    Posicion nuevaPosicion = Posicion.values()[opcionPosicion - 1];
                    jugador.setPosicion(nuevaPosicion);
                    System.out.println("\nPosicion modificada correctamente.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("\nNo se encontro al jugador.");
            }
        }
    }
    /**
     * 
     */
    private static void eliminar() {
        System.out.println("\nEliminar Jugador:");
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        } else {
        	System.out.print("Ingrese el nombre del jugador: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el apellido del jugador: ");
            String apellido = sc.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            boolean encontrado = false;
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    iterator.remove();
                    System.out.println("Jugador eliminado correctamente.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("\nNo se encontro al jugador.");
            }
        }
        

}
}