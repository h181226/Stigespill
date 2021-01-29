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

	public int startTur(Terning terning) {
		int terningVerdi=0;
		int seksere=0;

		System.out.println("---------------------------------");
		System.out.println("Det er " + navn + " sin tur");
		System.out.println("Trykk enter for å trille");
		
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
			
			flyttEkstra = flyttOgSjekk(terningVerdi);
			
			if(flyttEkstra > 0) {
				flyttOmStige(flyttEkstra);
			}else if (flyttEkstra < 0) {
				flyttOmSlange(flyttEkstra);
			}
			
			
			
		} while (terningVerdi==6 && seksere<3);
		
		return brikke.getPosisjon();
	}

	private void flyttOmSlange(int flyttEkstra) {
		// TODO Auto-generated method stub
		
	}

	private void flyttOmStige(int flyttEkstra) {
		// TODO Auto-generated method stub
		
	}

	private int flyttOgSjekk(int terningVerdi) {
		brikke.setPosisjon(brikke.getPosisjon() + );
		
		
		return 0;
		
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
