package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	
	 private double montoPagado;
	 private LocalDate fechaPago;	 

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		 montoPagado = monto - (monto * 0.10);
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
	}
	
}

