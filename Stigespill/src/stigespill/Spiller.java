package stigespill;

import java.util.Scanner;

public class Spiller {

	private Scanner scanner = new Scanner(System.in);
	private String navn;
	private Brikke brikke;

	/**
	 * Oppretter en spiller og en brikke tilhørende spilleren
	 * @param navn
	 * @param farge
	 */
	public Spiller(String navn, String farge) {
		this.navn=navn;
		this.brikke=new Brikke(farge);
	}

	/**
	 * Triller terningen og sjekker om spilleren får en 6er eller allerede fått tre 6ere. 
	 * Kaller deretter på metoder for å flytte brikken
	 * @param terning
	 * @param brett
	 * @return
	 */
	public int startTur(Terning terning, Brett brett) {
		int terningVerdi=0;
		int antallSeksere=0;

		System.out.println("---------------------------------");
		System.out.println("Det er " + navn + " sin tur");
		
		do {
			int flyttEkstra;
			// Kast terning og flytt brikken
			terningVerdi=terning.trillTerning();
			
			//Oppdaterer "antallSeksere" hvis spilleren triller en 6er
			if(terningVerdi == 6) {
				antallSeksere++;
				System.out.println("Du fekk terningkast 6");
			}
			
			if (antallSeksere == 3) {
				brikke.setPosisjon(0);
				System.out.println("Det var synd, du fikk 3 6ere og er flyttet tilbake til start");
				return brikke.getPosisjon();
			}
			
			flyttEkstra = flyttOgSjekk(terningVerdi, brett);
			
			if(flyttEkstra > 0) {
				flyttOmStige(flyttEkstra);
			}else if (flyttEkstra < 0) {
				flyttOmSlange(flyttEkstra);
			}	
			
		} while (terningVerdi==6);
		
		return brikke.getPosisjon();
	}

	/**
	 * Hvis spilleren er på en rute med slange flyttes spilleren tilbake gitt antall ruter
	 * @param flyttEkstra, antall ruter brikken skal flyttes
	 */
	private void flyttOmSlange(int flyttEkstra) {
		int posisjon = brikke.getPosisjon() + flyttEkstra;
		brikke.setPosisjon(posisjon);
		
		System.out.println("Du landet på en slange! Du er nå på rute: " + (posisjon+1));
	}

	/**
	 * Hvis spilleren er på en rute med stige flyttes spilleren frem gitt antall ruter
	 * @param flyttEkstra, antall ruter brikken skal flyttes
	 */
	private void flyttOmStige(int flyttEkstra) {
		int posisjon = brikke.getPosisjon() + flyttEkstra;
		brikke.setPosisjon(posisjon);
		
		System.out.println("Du landet på en stige! Du er nå på rute: " + (posisjon+1)); 
		
	}

	/**
	 * Flytter brikken til spilleren ett gitt antall ruter og sjekker om ruten er en slange- eller stigerute
	 * @param terningVerdi
	 * @param brett
	 * @return antall ruter brikken skal flyttes i tillegg (rute med slange eller stige)
	 */
	private int flyttOgSjekk(int terningVerdi, Brett brett) {
		int posisjon = brikke.getPosisjon() + terningVerdi;
		if(posisjon > 99) {
			System.out.println("Du endte over 100 og står i ro");
			return 0;
		}
		brikke.setPosisjon(posisjon);
		System.out.println("Du er nå på rute: " + (posisjon+1));
		
		return brett.getSpillerBrett()[posisjon].getFlyttAntallRuter();
	}

	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public Brikke getBrikke() {
		return brikke;
	}


	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}
}
