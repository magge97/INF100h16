package Semoppg2;

import java.util.Scanner;

public class YatzyToSpiller {
	
	public static void main(String[] args) {
		
		int poengRunde = 0;
		int antallRunder = 5;
		int antallSpillere = 2;
		int[] totalPoeng = new int[antallSpillere];
		
		String[] navnSpillere = new String[antallSpillere]; 
		
		// Les inn navn til spillere
		for (int i = 0; i < antallSpillere; i++) {
			System.out.println("Oppg navn til spiller " + (i + 1) + ": ");
			Scanner inn = new Scanner(System.in);
			navnSpillere[i] = inn.nextLine();
		}

		for (int runde = 0; runde < antallRunder; runde++) {
			for (int spiller = 0; spiller < antallSpillere; spiller++) {
				System.out.println("Runde " + (runde + 1));
				System.out.println("Det er " + navnSpillere[spiller] + " sin tur.");
				
				// Generer terningverdier
				int[] terningverdier = terningkast();
				skrivTerningVerdier(terningverdier);

				// Omkast dersom ønsket av bruker
				for (int i = 1; i <= 2; i++) { 
					System.out.println("Omkast " + i + ". Skriv terningnummer (1-5) for aa kaste om, "
							+ "eller 0 for aa beholde terningene som de er: ");
					int terningNummer = lesHeltall(0, 5);
					if (terningNummer == 0) { 
						break; // gaa til neste runde
					} else { // terningnummer: 1-5
						terningverdier[terningNummer - 1] = (int)(1 + 6 * Math.random());
						skrivTerningVerdier(terningverdier);
					}
				}

				// Bergen poeng for runde og legg til total
				poengRunde = poengForTerninger(terningverdier);
				System.out.printf("Poeng: %2d %n---------%n", poengRunde);
				totalPoeng[spiller] += poengRunde;
			}
		}
		
		// Finn stoerste poengsum og om vi har vinner eller uavgjort
		String vinner = navnSpillere[0];
		int forrige = 0;
		int stoerste = 0;
		boolean uavgjort = false;
		
		for (int spiller = 0; spiller < antallSpillere; spiller++){
			System.out.println(navnSpillere[spiller] + " har " + totalPoeng[spiller] + " poeng.");
			uavgjort = false; // Poengsummene til alle spillerne maa vaere like for uavgjort
			if (totalPoeng[spiller] > stoerste) { // Sjekk om ny vinner 
				stoerste = totalPoeng[spiller];
				vinner = navnSpillere[spiller];
			} else if (totalPoeng[spiller] == totalPoeng[spiller - 1]){ // Sjekk om uavgjort
				uavgjort = true;
			}
		}
		
		// Skriv ut vinner, eller om uavgjort
		if (uavgjort) {
			System.out.println("Uavgjort.");
		} else {
			System.out.println(vinner + " vant.");
		}
		
	}

	public static int poengForTerninger (int[] terningverdier) {

		int[] poengsum = new int[7];
		int maksPoeng = 0;

		// Finn poengsummen til hver av terningverdiene 1-6
		// (sum = antall av terningverdi * terningverdi)
		for (int verdi : terningverdier) {
			poengsum[verdi] += verdi;
		}
		// Finn stoerste poengsum
		for (int poeng : poengsum) {
			if (poeng > maksPoeng) {
				maksPoeng = poeng;
			}
		}
		return maksPoeng;
	}

	public static int[] terningkast () {

		int[] terningVerdier = new int[5];

		// Generer 5 tilfeldige terningverdier
		for (int kast = 0; kast < 5; kast++) {
			terningVerdier[kast] = (int) (1 + 6 * Math.random());
		}
		return terningVerdier;
	}

	public static void skrivTerningVerdier (int[] terningverdier) {

		int nummer = 1;

		// Skriv ut alle terningverdiene
		for (int verdi : terningverdier) {
			System.out.println("Terning " + (nummer++) + ": " + verdi);
		}
	}

	private static int lesHeltall(int minimum, int maksimum) {

		// Les inn verdi helt til den er paa spesifisert intervall
		while (true) { 
			Scanner inn = new Scanner(System.in);
			if (inn.hasNextInt()) {
				int innlest = inn.nextInt();
				if (minimum <= innlest && innlest <= maksimum){
					int gyldigVerdi = innlest; 
					return gyldigVerdi;
				}
			}
			// ellers: innlest verdi er ikke på spesifisert intervall
			// eller av feil type, skriv ut feilmelding
			System.out.println("Ugyldig verdi! Proev på nytt: ");
		} 
	}
}
