package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	
	JUJUY(811611, 53219), SALTA(1441351,155488), TUCUMAN(1731820, 22524), CATAMARCA(429562, 102606), 
	LA_RIOJA(383865, 89680), SANTIAGO_DEL_ESTERO(1054028,136351);
	
	private int cantidadPoblacion;
    private double superficie;
    
    private Provincia(int cantidadPoblacion, double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}
	
	public double getSuperficie() {
		return superficie;
	}

	public double densidadPoblacional() {
	    return cantidadPoblacion / superficie;
	}    
    

}
