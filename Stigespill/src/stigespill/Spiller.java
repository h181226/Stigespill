package stigespill;

import java.util.Scanner;

public class Spiller {
	
	private Scanner scanner = new Scanner(System.in);
	private String navn;
	private Brikke brikke;
	
	public Spiller(String navn, Brett brett, String farge) {
		this.navn=navn;
		this.brikke=new Brikke(brett, farge, 0);
	}
	
	public void startTur(Terning terning) {
		int terningVerdi=0;
		int seksere=0;
		
		System.out.println("---------------------------------");
		System.out.println("Det er " + navn + " sin tur");
		System.out.println("Trykk enter for å trille");
			if(scanner.hasNextLine()) {
				terning.trillTerning();
				terningVerdi = terning.getVerdi();
				System.out.println("Du fikk " +  terningVerdi);
	
	while (terningVerdi==6 && seksere<3){
		System.out.println("***triller på nytt***");
		seksere++;
		terning.trillTerning();
		terningVerdi=6+terning.getVerdi();
		System.out.println("Du fikk " + terning.getVerdi());
	}
	
	if(seksere==3) {
		System.out.println("Du fikk 3 seksere på rad " + navn + " må tilbake til start");
		terningVerdi = 0;
		brikke.setPosisjon(0);
	}
	
	else {
		brikke.setPosisjon(terningVerdi+brikke.getPosisjon());
	}
	
	System.out.println("Du er nå på rute " + brikke.getPosisjon());
	scanner.nextLine();	
	
	}	
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
