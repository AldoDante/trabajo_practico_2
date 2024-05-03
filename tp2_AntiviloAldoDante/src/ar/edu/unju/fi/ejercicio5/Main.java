package ar.edu.unju.fi.ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;


public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Producto> productos = new ArrayList<>();
	    
	public static void main(String[] args) {		
		 
        	precargarProductos();
        
        	mostrarMenu();

        sc.close();
    }
	/**
	 * 
	 */
	private static void precargarProductos() {
		productos.add(new Producto(1,"Cafetera", 50000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false));
	    productos.add(new Producto(2, "Taladro", 100000.0, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
	    productos.add(new Producto(3, "Celular", 250000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
	    productos.add(new Producto(4, "Monitor", 150000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
	    productos.add(new Producto(5,"Licuadora", 75000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(6, "Teclado", 45000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
	    productos.add(new Producto(7, "Mouse", 35000.0, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
	    productos.add(new Producto(8, "Soldadora", 350000.0, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
	    productos.add(new Producto(9, "Tostadora", 20000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(10, "Amoladora", 450000.0, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
	}
	
	private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenu de opciones:\n");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("\nSeleccione una opcion:\n ");
            try {
                opcion = sc.nextInt();
                sc.nextLine(); 
                switch (opcion) {
                    case 1:
                    	mostrarProductos();
                        break;
                    case 2:
                        realizarCompra();
                        break;
                    case 3:
                        System.out.println("Chaito!...");
                        break;
                    default:
                        System.out.println("Opcion No valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Ingrese un numero valido.");
                sc.nextLine(); 
                opcion = 0; 
            }
        } while (opcion != 3);
    }
	
	/**
	 * 
	 */
	
	private static void mostrarProductos() {
	    System.out.println("\nListado de productos en Stock:\n");
	    for (Producto producto : productos) {
	        if (producto.isEstado()) {
	            System.out.println(producto);
	        }
	    }
	}
	/**
	 * 
	 */
	private static void realizarCompra() {
		mostrarProductos();	   
	    ArrayList<Producto> productosSeleccionados = new ArrayList<>();	    
	   	    
	    boolean continuarSeleccionando = true;
	    
	    while (continuarSeleccionando) {
	        System.out.print("\nSeleccione El codigo del producto (0 para terminar): ");
	        int indiceProd = sc.nextInt();
	        sc.nextLine();
	        
	        if (indiceProd == 0) {	        	
	            continuarSeleccionando = false;
	            
	        } else if (indiceProd > 0 && indiceProd <= productos.size()) {
	            Producto seleccion = productos.get(indiceProd - 1);
	            
	            if (seleccion.isEstado()) {	                
	            	productosSeleccionados.add(seleccion);
	                System.out.println("\nProducto: " + seleccion.getDescripcion() +" $"+seleccion.getPrecioUn() + " agregado");
	            
	            } else {
	                System.out.println("El producto seleccionado no está disponible.");
	            }
	        } else {
	            System.out.println("Índice de producto inválido.");
	        }
	    }
	    if (productosSeleccionados.isEmpty()) {
	        System.out.println("Compra Canelada.");
	        return;
	    }
	   
	    double montoTotal = 0.0;
	    
	    for (Producto producto : productosSeleccionados) {
	        montoTotal += producto.getPrecioUn();
	    }

	  
	    System.out.println("\nOpciones de pago:");
	    System.out.println("1 - Pago en efectivo");
	    System.out.println("2 - Pago con tarjeta");
	    System.out.print("\nSeleccione una opción de pago: ");
	    
	    int opcionPago = sc.nextInt();
	    sc.nextLine();

	
	    switch (opcionPago) {
	        case 1:
	            Pago pagoEfectivo = new PagoEfectivo(montoTotal, LocalDate.now());
	            pagoEfectivo.realizarPago(montoTotal);
	            pagoEfectivo.imprimirRecibo();
	            break;
	        case 2:
	            System.out.print("Ingrese el número de tarjeta: ");
	            String numeroTarjeta = sc.nextLine();
	            Pago pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), montoTotal);
	            pagoTarjeta.realizarPago(montoTotal);
	            pagoTarjeta.imprimirRecibo();
	            break;
	        default:
	            System.out.println("Opción de pago inválida.");
	            break;
	    }
	}
}
	
