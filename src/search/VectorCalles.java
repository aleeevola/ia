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

	public boolean equals(Object arg0) {
		if(((VectorCalles)arg0).getCalleA()==calleA && ((VectorCalles)arg0).getCalleB()==calleB) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		String hash = calleA+calleB;
		return hash.hashCode();
	}

	@Override
	protected VectorCalles clone() {
		VectorCalles newVectorCalles = new VectorCalles();
		newVectorCalles.setCalleA(this.getCalleA());
		newVectorCalles.setCalleB(this.getCalleB());
		return newVectorCalles;
	}
	
	

}
