package ar.edu.unju.fi.ejercicio4.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	
	private String nombre;
    private String apellido;
    private Calendar fechaNac;
    private String nacionalidad;
    private Double estatura;
    private Double peso;
    private Posicion posicionJugador;
    
    public Jugador() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    public Jugador(String nombre, String apellido, Calendar fechaNac, String nacionalidad, Double estatura, Double peso,
			Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicionJugador = posicion;
	}
    
    

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Calendar getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public Double getEstatura() {
		return estatura;
	}



	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}



	public Double getPeso() {
		return peso;
	}



	public void setPeso(Double peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicionJugador;
	}



	public void setPosicion(Posicion posicion) {
		this.posicionJugador = posicion;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaNac.getTime());
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaFormateada + ", nacionalidad="
				+ nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicionJugador=" + posicionJugador
				+ "]";
	}



	public int calcularEdad() {
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        return edad;
    }
}
