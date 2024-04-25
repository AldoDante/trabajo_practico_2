package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
			
	private int codigo;
    private String descripcion;
    private Double precioUn;
    private OrigenFabricacion origenF;
    private Categoria categoria;
    
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto(int codigo, String descripcion, Double precioUn, OrigenFabricacion origenF,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUn = precioUn;
		this.origenF = origenF;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUn() {
		return precioUn;
	}

	public void setPrecioUn(double precioUn) {
		this.precioUn = precioUn;
	}

	public OrigenFabricacion getOrigenF() {
		return origenF;
	}

	public void setOrigenF(OrigenFabricacion origenF) {
		this.origenF = origenF;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUn=" + precioUn + ", origenF="
				+ origenF + ", categoria=" + categoria + "]";
	}
	
	

}
