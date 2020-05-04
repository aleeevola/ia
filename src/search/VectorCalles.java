package search;

public class VectorCalles {
	private String calleA;
	private String calleB;
	
	public VectorCalles() {
		
	}
	
	public VectorCalles(String A, String B) {
		this.calleA = A;
		this.calleB = B;
	}

	public String getCalleA() {
		return calleA;
	}

	public void setCalleA(String calleA) {
		this.calleA = calleA;
	}

	public String getCalleB() {
		return calleB;
	}

	public void setCalleB(String calleB) {
		this.calleB = calleB;
	}
	
	public String toString() {
		String resultado = "(" + calleA + ", " + calleB + ")";
		return resultado;
	}

}
