package stigespill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Stigespill {
	private Brett brettet;
	private List<Spiller> spillere = new ArrayList<Spiller>();  
	private Terning terning;
	private Scanner scanner = new Scanner(System.in);
	

	/**
	 * Oppretter et nytt stigespillobjektet
	 * 
	 * 
	 */
	
	public Stigespill() {
		this.brettet = new Brett(100);
		this.terning = new Terning();
		
		
	}
	/**
	 * Metode som starter selve spillet.
	 */
	public void startSpill() {
		OpprettSpillere();
		boolean Vunnet = false;
		while(!Vunnet) {
			Vunnet = spillRunde();
		}
		
			sluttSpill();
		
	}
	/**
	 * Metode gjennomfører en runde
	 */
	private boolean spillRunde() {
		boolean spillFerdig = false;
		for(int i = 0; i < spillere.size(); i++) {
			int posisjon = spillere.get(i).startTur(terning, brettet);
			if(posisjon==99)
				return true;
		}
		return false;

	}
	/**
	 * Metode som avslutter spillet og bestemmer vinneren
	 */
	
	public void sluttSpill() {
		
		
		String vinner = spillere.stream()
								.filter(s -> s.getBrikke().getPosisjon() == 100)
								.map(s -> s.getNavn())
								.collect(Collectors.joining());
		System.out.println(vinner + ", Du har vunnet spillet!!");

		
			
		
	}

	/**
	 * Metode som oppretter spillere
	 */
	public void OpprettSpillere() {
		 
		String regex = "^[A-ZÆØÅa-zæøå ]+$";
		System.out.println("Antall spillere:");
		int antall = scanner.nextInt();
		
		while (( antall < 2) || (antall > 4)){
			System.out.println("Antall spillere må være mellom 2 og 4, skriv på nytt");
			antall = scanner.nextInt();
		}
		for (int i =1; i <= antall; i++) {
			System.out.println("Navn på spiller " + i +":");
			scanner.nextLine();
			String navn = scanner.nextLine();
			
			while(!navn.matches(regex)) {
				System.out.println("Ugyldig navn, prøv på nytt");
				navn = scanner.nextLine();	
			}
			

			System.out.println("Farge på brikke:");
			System.out.println("Oppgi 1:Blå 2:Rød 3:Grønn 4:Gul:");
			int svar = scanner.nextInt();
			
		String farge="";
			
			switch(svar) {
			case 1: farge="Blå"; break;
			case 2: farge="Rød"; break;
			case 3: farge="Grønn"; break;
			case 4: farge="Gul"; break;
			
			}
			Spiller spiller = new Spiller(navn, farge);
			spillere.add(spiller);
		}
		
	}
	/**
	 * Sjekker om spilleren har vunnet.
	 * @return returnerer true om spiller står på rute nr. 100
	 */
	
	public boolean ikkeVunnet() {
		return !spillere.stream()
						.anyMatch(s -> s.getBrikke().getPosisjon() == 100);
	}
	

	
	
}
