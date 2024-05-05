package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
    private static List<Producto> productos;
	
    public static void main(String[] args) {
    	
    	productos = precargarProductos();
    	System.out.println(productos);
    	mostrarMenu();
    	
    	
    	}
    
    private static List<Producto> precargarProductos() {
        List<Producto> productos = new ArrayList<>();
        
        productos.add(new Producto(1,"Cafetera", 50000.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, false));
	    productos.add(new Producto(2, "Taladro", 100000.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true));
	    productos.add(new Producto(3, "Celular", 250000.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
	    productos.add(new Producto(4, "Monitor", 150000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.INFORMATICA, false));
	    productos.add(new Producto(5,"Licuadora", 75000.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(6, "Teclado", 45000.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
	    productos.add(new Producto(7, "Mouse", 35000.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	    productos.add(new Producto(8, "Soldadora", 350000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
	    productos.add(new Producto(9, "Tostadora", 20000.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(10, "Amoladora", 450000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
	    productos.add(new Producto(11, "Barra de sonido", 45000.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
	    productos.add(new Producto(12, "MousePAD", 35000.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	    productos.add(new Producto(13, "Nivel", 350000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
	    productos.add(new Producto(14, "MultiProcesadora", 20000.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	    productos.add(new Producto(15, "Pinza", 450000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.HERRAMIENTAS, false));
        
        return productos;
    }
    
    private static void mostrarMenu() {
        boolean continuar = true;
        
        while (continuar) {
            try {
            	System.out.println("=== Menú ===");
                System.out.println("1. Mostrar productos");
                System.out.println("2. Mostrar productos faltantes");
                System.out.println("3. Incrementar precios");
                System.out.println("4. Mostrar productos de la categoria Electrohogar");
                System.out.println("5. Ordenar productos por precio descendente");
                System.out.println("6. Mostrar nombres de productos en mayúsculas");
                System.out.println("7. Salir");
                System.out.print("Ingrese su opción: ");
                
                int opcion = sc.nextInt();
                sc.nextLine();
                
                switch (opcion) {
                    case 1:
                        //productos();
                        break;
                    case 2:
                        //faltantes();
                        break;
                    case 3:
                        //incrementarPrecios();
                        break;
                    case 4:
                        //categoriaElectrohogar();
                        break;
                    case 5:
                        //descendente();
                        break;
                    case 6:
                        //mayusculas();
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("Chaito!...");
                        break;
                    default:
                        System.out.println("Opcion invalida, ingrese un numero valido.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número valido.");
                sc.nextLine();
            }
        }
    }
    
    
}
    