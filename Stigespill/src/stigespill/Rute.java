package stigespill;

public class Rute {
	
	private int nummer;
	private int flyttAntallRuter;
	
	public Rute(int nummer) {
		this.nummer = nummer;
		flyttAntallRuter = 0;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getFlyttAntallRuter() {
		return flyttAntallRuter;
	}

	public void setFlyttAntallRuter(int flyttAntallRuter) {
		this.flyttAntallRuter = flyttAntallRuter;
	}
	
	

}
