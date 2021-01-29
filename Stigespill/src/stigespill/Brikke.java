package stigespill;

public class Brikke {
	
	private String farge;
	private int posisjon;
	
	public Brikke (String farge, int posisjon) {
		this.farge=farge;
		this.posisjon=0;
	}
	
	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}


	public int getPosisjon() {
		return posisjon;
	}

	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}
}
