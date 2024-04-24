package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
			
	private int codigo;
    private String descripcion;
    private double precioUn;
    private origenFabricacion origenF;
    private categoria categoria;
    
	public enum origenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto(int codigo, String descripcion, double precioUn, origenFabricacion origenF,
			ar.edu.unju.fi.ejercicio1.model.Producto.categoria categoria) {
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

	public origenFabricacion getOrigenF() {
		return origenF;
	}

	public void setOrigenF(origenFabricacion origenF) {
		this.origenF = origenF;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUn=" + precioUn + ", origenF="
				+ origenF + ", categoria=" + categoria + "]";
	}
	
	

}
