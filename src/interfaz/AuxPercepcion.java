package interfaz;

import search.VectorCalles;

public class AuxPercepcion {
	private VectorCalles esquina;


	private String percepcion;
	
	
	public AuxPercepcion(VectorCalles esquina, String percepcion) {
		super();
		this.esquina = esquina;

		this.percepcion = percepcion;
	}
	
	public VectorCalles getEsquina() {
		return esquina;
	}
	public void setEsquina(VectorCalles esquina) {
		this.esquina = esquina;
	}

	public String getPercepcion() {
		return percepcion;
	}
	public void setPercepcion(String percepcion) {
		this.percepcion = percepcion;
	}
	
	
}
