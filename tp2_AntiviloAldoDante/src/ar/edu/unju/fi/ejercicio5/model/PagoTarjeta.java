package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	
	private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;
    
    

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		montoPagado = monto + (monto * 0.15);
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("Nro de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
	}

}
