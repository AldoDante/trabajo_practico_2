package ar.edu.unju.fi.ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	
	/**
	 * Declaro scanner y efemerides fuera del metodo main
	 * para que puedan ser accedidas desde cualquier metodo
	 */
	
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
					case 2: mostrarEfe();
						break;
					case 3: eliminarEfe();
						break;
					case 4: modificarEfe();
						break;
					case 5: System.out.println("\nChaito!...");
						break;
					default: System.err.println("\nSeleccione una opcion del menu");
			}
			
					
			
		} while (opcion!=5);		
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
	 * metodo para crear una efemerides
	 * con ingreso de datos por usuario
	 * se realiza un control del rango de
	 * meses luego se le resta 1 a la variable
	 * que capturo el dato para que coincida con 
	 * las posiciones de los enumerados que comienzan 
	 * en cero
	 */
		
	private static void crearEfe () {
		try {
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
		
		} catch (InputMismatchException e) {
			System.err.println("Tipo de dato incorrecto");
			sc.nextLine();
		}
	} 
	
	private static void mostrarEfe() {
		
		if (efemerides.isEmpty()) {
			System.out.println("\nLista Vacia");
		} else {
			System.out.println("\nEfemerides\n");
			for (Efemeride efemeridesLista : efemerides) {
				System.out.println(efemeridesLista);
				}
		}
	}
	
	/**
	 * Metodo para eliminar efemerides primero controla
	 * si la lista esta vacia luego se ingresa el codigo
	 * compara si existe para borrarlo o avisar al usuario
	 * que dicho codigo no existe
	 */
	private static void eliminarEfe() {
	    if (efemerides.isEmpty()) {
	        System.out.println("Efemerides vacía");
	    } else {
	        System.out.println("Ingrese el codigo a eliminar:");
	        int eliminar = sc.nextInt();

	        Iterator<Efemeride> iterator = efemerides.iterator();
	        boolean encontrar = false;
	        while (iterator.hasNext()) {
	            Efemeride elemento = iterator.next();
	            if (elemento.getCodigo() == eliminar) {
	                iterator.remove();
	                System.out.println("\nEfemeride eliminada");
	                encontrar = true;
	                break; 
	            }
	        }
	        if (!encontrar) {
	            System.out.println("\nNo existe el codigo");
	        }
	    }
	}
	
	/**
	 * Metodo para modificar efemerides realiza
	 *  el control de que la lista no este vacia
	 *  luego se ingresa el codigo, compara si el 
	 *  codigo existe para luego pedir el re ingreso
	 *  de los datos
	 */
	private static void modificarEfe() {
	    try {
	        if (efemerides.isEmpty()) {
	            System.out.println("Efemerides vacía");
	        } else {
	            System.out.println("Ingrese el código a modificar:");
	            int modificar = sc.nextInt();
	            boolean encontrar = false;

	            Iterator<Efemeride> iterator = efemerides.iterator();
	            while (iterator.hasNext()) {
	                Efemeride elemento = iterator.next();
	                if (elemento.getCodigo() == modificar) {
	                    encontrar = true;
	                    System.out.println("\nIngrese nuevo código:");
	                    int nuevoCod = sc.nextInt();
	                    System.out.println("Ingrese nuevo mes (número del 1 al 12):");
	                    int nuevoMes = sc.nextInt();
	                    while (nuevoMes < 1 || nuevoMes > 12) {
	                        System.out.println("Número de mes incorrecto. Intente nuevamente:");
	                        nuevoMes = sc.nextInt();
	                    }
	                    Mes mes = Mes.values()[nuevoMes - 1];
	                    System.out.println("\nIngrese el día:");
	                    int nuevoDia = sc.nextInt();
	                    sc.nextLine();
	                    System.out.println("\nIngrese el detalle:");
	                    String nuevoDetalle = sc.nextLine();

	                    elemento.setCodigo(nuevoCod);
	                    elemento.setMes(mes);
	                    elemento.setDia(nuevoDia);
	                    elemento.setDetalle(nuevoDetalle);
	                    System.out.println("\nModificado correctamente.");
	                    break; 
	                }
	            }
	            if (!encontrar) {
	                System.out.println("Código no encontrado.");
	            }
	        }
	    } catch (InputMismatchException e) {
	        System.err.println("Tipo de dato incorrecto.");
	        sc.nextLine();
	    }
	}
}
