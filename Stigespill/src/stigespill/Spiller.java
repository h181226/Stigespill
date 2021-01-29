package stigespill;

import java.util.Scanner;

public class Spiller {

	private Scanner scanner = new Scanner(System.in);
	private String navn;
	private Brikke brikke;

	public Spiller(String navn, String farge) {
		this.navn=navn;
		this.brikke=new Brikke(farge);
	}

	public int startTur(Terning terning, Brett brett) {
		int terningVerdi=0;
		int seksere=0;

		System.out.println("---------------------------------");
		System.out.println("Det er " + navn + " sin tur");
		
		do {
			int flyttEkstra;
			// Kast terning og flytt brikken
			terningVerdi=terning.trillTerning();
			if (seksere == 3) {
				brikke.setPosisjon(0);
				System.out.println("Det var synd, du fikk 3 6ere og er flyttet tilbake til start");
				return brikke.getPosisjon();
			}else if(terningVerdi == 6) {
				seksere++;
				System.out.println("Du fikk " + terningVerdi + " ,trill igjen");
			}else{
				System.out.println("Du fikk " + terningVerdi);
			}
			
			flyttEkstra = flyttOgSjekk(terningVerdi, brett);
			
			if(flyttEkstra > 0) {
				flyttOmStige(flyttEkstra);
			}else if (flyttEkstra < 0) {
				flyttOmSlange(flyttEkstra);
			}
			
			
			
		} while (terningVerdi==6 && seksere<3);
		
		return brikke.getPosisjon();
	}

	private void flyttOmSlange(int flyttEkstra) {
		int posisjon = brikke.getPosisjon() + flyttEkstra;
		brikke.setPosisjon(posisjon);
		
		System.out.println("Du landet på en slange! Du er nå på rute: " + (posisjon+1));
	}

	private void flyttOmStige(int flyttEkstra) {
		int posisjon = brikke.getPosisjon() + flyttEkstra;
		brikke.setPosisjon(posisjon);
		
		System.out.println("Du landet på en stige! Du er nå på rute: " + (posisjon+1)); 
		
	}

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
