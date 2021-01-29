package stigespill;

import java.util.Random;

public class Terning {
	
	private int verdi;
	
	public Terning() {
		this.verdi=0;
	}
	
	/**
	 * Triller en terning med verdier fra 1-6
	 * @return verdi av terning
	 */
	public int trillTerning() {
		Random tall = new Random();
		verdi = 1 + tall.nextInt(6);
		return verdi;
	}
	
	public int getVerdi() {
		return verdi;
	}

	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}

	

}
