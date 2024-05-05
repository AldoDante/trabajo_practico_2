package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {
	
	
	
    public static void main(String[] args) {
    	
    	List<Producto> productos = precargarProductos();
    	
    	
    	
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
}
    