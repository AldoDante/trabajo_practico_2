package ar.edu.unju.fi.ejercicio7.model;

public class Producto {
	
	private int codigo;
    private String descripcion;
    private Double precioUn;
    private OrigenFabricacion origenF;
    private Categoria categoria;
    private boolean estado;
    
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	public Producto(int codigo, String descripcion, Double precioUn, OrigenFabricacion origenF, Categoria categoria,
			boolean estado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUn = precioUn;
		this.origenF = origenF;
		this.categoria = categoria;
		this.estado = estado;
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

	public Double getPrecioUn() {
		return precioUn;
	}

	public void setPrecioUn(Double precioUn) {
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUn=" + precioUn + ", origenF="
				+ origenF + ", categoria=" + categoria + ", estado=" + estado + "]";
	}

	
}
