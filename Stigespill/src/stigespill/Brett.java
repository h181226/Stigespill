package stigespill;

public class Brett {

	private Rute[] spillerBrett;

	public Rute[] getSpillerBrett() {
		return spillerBrett;
	}

	public void setSpillerBrett(Rute[] spillerBrett) {
		this.spillerBrett = spillerBrett;
	}

	/**
	 * Oppretter ett brett med en gitt størrelse
	 * 
	 * @param Størrelse på brettet
	 */
	public Brett(int antallRuter) {
		this.spillerBrett = new Rute[antallRuter];
	}
	
	/**
	 * Oppretter spillerbretter med alle rutene inkludert spesialrutene
	 */
	public void oppretteBrett() {
		//Oppretter alle ruter som standard ruter
		for (int i = 0; i < spillerBrett.length; i++) {
			spillerBrett[i] =  new Rute(i+1);
		}
		
		//Oppdaterer spesialrutene stiger
		spillerBrett[2 - 1].setFlyttAntallRuter(38-2);
		spillerBrett[4 - 1].setFlyttAntallRuter(14-4);
		spillerBrett[8 - 1].setFlyttAntallRuter(31-8);
		spillerBrett[21 - 1].setFlyttAntallRuter(42-21);
		spillerBrett[28 - 1].setFlyttAntallRuter(84-28);
		spillerBrett[36 - 1].setFlyttAntallRuter(44-36);
		spillerBrett[51 - 1].setFlyttAntallRuter(67-51);
		spillerBrett[71 - 1].setFlyttAntallRuter(91-71);
		spillerBrett[80 - 1].setFlyttAntallRuter(100-80);
		
		//Oppdaterer spesialrutene slanger
		spillerBrett[16 - 1].setFlyttAntallRuter(6-16);
		spillerBrett[47 - 1].setFlyttAntallRuter(26-47);
		spillerBrett[49 - 1].setFlyttAntallRuter(11-49);
		spillerBrett[56 - 1].setFlyttAntallRuter(53-56);
		spillerBrett[62 - 1].setFlyttAntallRuter(18-62);
		spillerBrett[64 - 1].setFlyttAntallRuter(60-64);
		spillerBrett[86 - 1].setFlyttAntallRuter(24-86);
		spillerBrett[92 - 1].setFlyttAntallRuter(73-92);
		spillerBrett[95 - 1].setFlyttAntallRuter(75-95);
		spillerBrett[98 - 1].setFlyttAntallRuter(78-98);
	}
}
