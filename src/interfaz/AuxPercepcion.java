package interfaz;

import search.VectorCalles;

public class AuxPercepcion {
	private VectorCalles esquina;
	private int numero_iteracion;
	private String percepcion;
	
	
	public AuxPercepcion(VectorCalles esquina, int numero_iteracion, String percepcion) {
		super();
		this.esquina = esquina;
		this.numero_iteracion = numero_iteracion;
		this.percepcion = percepcion;
	}
	
	public VectorCalles getEsquina() {
		return esquina;
	}
	public void setEsquina(VectorCalles esquina) {
		this.esquina = esquina;
	}
	public int getNumero_iteracion() {
		return numero_iteracion;
	}
	public void setNumero_iteracion(int numero_iteracion) {
		this.numero_iteracion = numero_iteracion;
	}
	public String getPercepcion() {
		return percepcion;
	}
	public void setPercepcion(String percepcion) {
		this.percepcion = percepcion;
	}
	
	
}
