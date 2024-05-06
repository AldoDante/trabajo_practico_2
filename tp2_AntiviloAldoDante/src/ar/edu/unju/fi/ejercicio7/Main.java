package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
    private static List<Producto> productos;
	
    public static void main(String[] args) {
    	
    	productos = precargarProductos();
    	
    	mostrarMenu();
    	sc.close();
    	
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
    /**
     * Menu con implemetacion de bloque try catch para salvar la entrada de una
     * letra por parte del usuario
     */
    private static void mostrarMenu() {
        boolean continuar = true;
        
        while (continuar) {
            try {
            	System.out.println("\n=== Menú ===\n");
                System.out.println("1. Mostrar productos");
                System.out.println("2. Mostrar productos faltantes");
                System.out.println("3. Incrementar precios");
                System.out.println("4. Mostrar productos de la categoria Electrohogar");
                System.out.println("5. Ordenar productos por precio descendente");
                System.out.println("6. Mostrar nombres de productos en mayusculas");
                System.out.println("7. Salir");
                System.out.print("\nIngrese su opción:\n ");
                
                int opcion = sc.nextInt();
                sc.nextLine();
                
                switch (opcion) {
                    case 1:
                        productos();
                        break;
                    case 2:
                        faltantes();
                        break;
                    case 3:
                        incrementarPrecios();
                        break;
                    case 4:
                        categoriaElectrohogar();
                        break;
                    case 5:
                        descendente();
                        break;
                    case 6:
                        mayusculas();
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("Chaito!...");
                        break;
                    default:
                        System.out.println("Opcion invalida, ingrese un numero valido");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número valido");
                sc.nextLine();
            }
        }
    }
    /**
     * Metodo que imprimime los productos que están en stock 
     * Utiliza un Consumer que toma un objeto de tipo Producto 
     * para imprimir cada producto si está en stock, tambien
     * se utiliza una expresion lambda donde p representa cada
     * elemento de tipo producto  
     * Estado del producto (true = en stock)
     */
    private static void productos() {
    	 System.out.println("\nProductos en Stock\n");
        Consumer<Producto> mostrarProductosConsumer = p -> {
            if (p.isEstado()) {
                System.out.println(p);
            }
        };
        productos.forEach(mostrarProductosConsumer);
    }
    
    /**
     * Metodo para imprimir los productos que estan con estado false
     * Se define un predicado que evalua el estado (true/false) Se filtran 
     * los productos de la lista productos usando el predicado definido 
     * Los productos que cumplan con la condición del predicado se recopilan 
     * en una nueva lista se define un Consumer y se lo utiliza para iterar
     * e imprimir la lista de false 
     */
    private static void faltantes() {
    	System.out.println("\nProductos Faltantes\n");
        Predicate<Producto> productosFaltantesPredicate = p -> !p.isEstado();
        List<Producto> productosFaltantes = productos.stream()
                .filter(productosFaltantesPredicate)
                .collect(Collectors.toList());

        Consumer<Producto> mostrarProductosConsumer = p -> System.out.println(p);
        productosFaltantes.forEach(mostrarProductosConsumer);
    }
    
    /**
     * Se define una función lambda que toma un producto como entrada y devuelve 
     * un producto con su precio incrementado en un 20%. Dentro de la función 
     * se calcula el nuevo precio multiplicando el precio actual por 1.20 y se 
     * actualiza el precio del producto. Luego se devuelve el producto 
     * con el precio incrementado. Se aplica la funcion a cada producto 
     * en la lista productos utilizando map de un Stream, devuelve un nuevo 
     * Stream que contiene los productos con los precios incrementados
     *  Luego, se recopilan en una lista utilizando Collectors.toList()
     *  se utiliza un consumer para iterar e imprimir cada producto
     */
    private static void incrementarPrecios() {
        Function<Producto, Producto> incrementarPrecioFunction = p -> {
            double nuevoPrecio = p.getPrecioUn() * 1.20;
            p.setPrecioUn(nuevoPrecio);
            return p;
        };

        List<Producto> productosIncrementados = productos.stream()
                .map(incrementarPrecioFunction)
                .collect(Collectors.toList());

        System.out.println("\nPrecios incrementados en 20%:\n");
        Consumer<Producto> mostrarProductosConsumer = p -> System.out.println(p);
        productosIncrementados.forEach(mostrarProductosConsumer);
    }
    /**
     * Se define un predicado que evalúa si un producto pertenece a la categoria "Electrohogar" 
     * y está en stock isEstado() true = en stock Se filtran los productos de la lista productos 
     * usando el predicado los que cumplan con la condicion se recopilan en una nueva lista se
     * define un consumer y se itera para imprimir los productos
     */
    private static void categoriaElectrohogar() {
    	
    	System.out.println("\nELECTROHOGAR en Stock\n");
        Predicate<Producto> electrohogarPredicate = p -> p.getCategoria() == Producto.Categoria.ELECTROHOGAR && p.isEstado();
        List<Producto> productosElectrohogar = productos.stream()
                .filter(electrohogarPredicate)
                .collect(Collectors.toList());

        Consumer<Producto> mostrarProductosConsumer = p -> System.out.println(p);
        productosElectrohogar.forEach(mostrarProductosConsumer);
    }
    
    /**
     * Se define un Comparator que compara los productos por su precio unitario 
     * en orden descendente mediante el método reversed que invierte el orden 
     * del comparador Se define un Consumer, se itera para imprimir cada producto
     */
    private static void descendente() {
        Comparator<Producto> precioDescendente = Comparator.comparing(Producto::getPrecioUn).reversed();
        productos.sort(precioDescendente);

        System.out.println("\nProductos por precio descendente:\n");
        Consumer<Producto> mostrarConsumer = p -> System.out.println(p);
        productos.forEach(mostrarConsumer);
    }
    /**
     * Se define una funcion lambda que toma un objeto Producto y devuelve su 
     * descripcion (nombre) convertida a mayusculas utilizando el metodo toUpperCase
     * Se aplica a cada producto en la lista productos esto devuelve un nuevo Stream 
     * que contiene las descripciones de los productos convertidas a mayusculas se 
     * recopilan estas descripciones en una lista utilizando Collectors.toList se
     * define un consumer y se itera
     */
    private static void mayusculas() {
        Function<Producto, String> mayusculasFunc = p -> p.getDescripcion().toUpperCase();
        List<String> nombresEnMayusculas = productos.stream()
                .map(mayusculasFunc)
                .collect(Collectors.toList());

        System.out.println("\nNombres en mayusculas:\n");
        Consumer<String> mostrarConsumer = nombre -> System.out.println(nombre);
        nombresEnMayusculas.forEach(mostrarConsumer);
    }
}
    