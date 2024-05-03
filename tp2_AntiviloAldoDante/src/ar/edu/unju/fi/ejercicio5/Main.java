package ar.edu.unju.fi.ejercicio5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;



public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Producto> productos = new ArrayList<>();
	    
	public static void main(String[] args) {
		
		 // Precarga de productos
        	precargarProductos();

         // Mostrar menú de opciones al usuario
        	mostrarMenu();

        sc.close();
    }
	
	private static void precargarProductos() {
		productos.add(new Producto(1,"Cafetera", 50000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false));
	    productos.add(new Producto(2, "Taladro", 100000.0, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
	    productos.add(new Producto(3, "Celular", 250000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
	    productos.add(new Producto(4, "Monitor", 150000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
	    productos.add(new Producto(1,"Licuadora", 75000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(2, "Teclado", 45000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
	    productos.add(new Producto(3, "Mouse", 35000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	    productos.add(new Producto(4, "Soldadora", 350000.0, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
	    productos.add(new Producto(3, "Tostadora", 20000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(4, "Amoladora", 450000.0, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
	}
	
	private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine(); 
                switch (opcion) {
                    case 1:
                        //mostrarProductos();
                        break;
                    case 2:
                        //realizarCompra();
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número válido.");
                sc.nextLine(); 
                opcion = 0; 
            }
        } while (opcion != 3);
    }
	
}
	
