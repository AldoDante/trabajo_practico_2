package ar.edu.unju.fi.ejercicio1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	
		/**
		 * Declaro sacanner y listaProductos fuera del metodo main para que
		 * puedan ser accedidas desde cualquier metodo dentro de la clase main
		 */
	 	private static ArrayList<Producto> listaProductos = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        
	    	
	    	int opcion;
	        do {	        	
	        	System.out.println("\nMenú:\n");
		        System.out.println("1 - Crear Producto");
		        System.out.println("2 - Mostrar productos");
		        System.out.println("3 - Modificar producto");
		        System.out.println("4 - Salir");
		        System.out.print("\nIngrese su opción: ");
		        
	            opcion = leerOpcion();
	            
	            switch (opcion) {
	                case 1:
	                    crearProducto();
	                    break;
	                case 2:
	                    mostrarProductos();
	                    break;
	                case 3:
	                    //modificarProducto();
	                    break;
	                case 4:
	                    System.out.println("Chaito!");
	                    break;
	                default:
	                    System.err.println("\nOpción no válida.");
	            }
	        } while (opcion != 4);
	    }
	    
	    /**
	     * Medodo que lee un entero con manejo de excepciones
	     * para advertir al usurario que ingreso una letra
	     * o un numero fuera del rango de opciones, ante una
	     * excepcion retorna cero para ingresar al default del switch
	     * @return
	     */
	    private static int leerOpcion() {
	        try {
	            return scanner.nextInt();
	        } catch (InputMismatchException e) {
	            scanner.next();
	            return 0;
	        }
	    }
	   
	     /**
	     * Metodo para el manejo de excepciones en el ingreso de las
	     * opciones de los enumerados, se implemento un if con un rango
	     * de 1 a 4 debido a que OrigenFabricacion y Categoria poseen 4
	     * elementos  
	     */
	    private static int opcionEnum() {
	    	int opcion;
	    	do {
	            System.out.print("\nIngrese una opción:\n");
	            try {
	                opcion = scanner.nextInt();
	                
	                if (opcion < 1 || opcion > 4) {
	                    throw new IllegalArgumentException();
	                }
	                return opcion;
	            } catch (InputMismatchException e) {
	                System.err.println("Ingrese un número válido.");
	                scanner.nextLine();
	            } catch (IllegalArgumentException e) {
	                System.err.println("Ingrese una opción válida.");
	            }
	        } while (true);
	    }
	    
	    
	    /**
	     * Metodo para la creacion del producto con el ingreso
	     * de datos por el usuario y eleccion de una lista de enumerados
	     * paises y categorias 
	     */
	    private static void crearProducto() {
	    	
	    	try {
	        System.out.println("\nCreando nuevo producto:");
	        System.out.print("Ingrese el código: ");
	        int codigo = scanner.nextInt();
	        scanner.nextLine();
	        
	        System.out.print("Ingrese la descripción: ");
	        String descripcion = scanner.nextLine();
	        
	        System.out.print("Ingrese el precio unitario: ");
	        double precioUn = scanner.nextDouble();
	        
	        System.out.println("\nEscoja el origen de fabricación:\n");
	        
	        int i=0;
	        for (OrigenFabricacion origenes : OrigenFabricacion.values()) {
	        	i++;
	        	System.out.println(i+" - "+origenes);
	        }
	        //mostrarOpcionesEnum(Producto.OrigenFabricacion.values());
	        
	        int opcionOrigen = opcionEnum();
	        Producto.OrigenFabricacion origen = Producto.OrigenFabricacion.values()[opcionOrigen - 1];
	        
	        System.out.println("\nEscoja la categoría:\n");
	        
	        int k=0;
	        for (Categoria origenes : Categoria.values()) {
	        	k++;
	        	System.out.println(k+" - "+origenes);
	        }
	        
	        //mostrarOpcionesEnum(Producto.categoria.values());
	        
	        
	        int opcionCategoria = opcionEnum();
	        Producto.Categoria categoria = Producto.Categoria.values()[opcionCategoria - 1];
	        
	        Producto producto = new Producto(codigo, descripcion, precioUn, origen, categoria);
	        listaProductos.add(producto);     
	       
	        System.out.println("Producto creado exitosamente.");
	    	} catch (Exception e) {
                System.err.println("\nTipo de dato no valido");
                scanner.nextLine();
            }
	    }    	      
}
