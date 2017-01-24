package Øving4;

import java.util.Scanner;

public class Poengtabell {

	public static void main(String[] args) {
		
		// Les inn antall deltakere
		int antallDeltakere = hentHeltall(1, "Oppgi antall deltakere (minst 1): ");
		
		String[] deltakerListe = new String[antallDeltakere];
		int[] poengsum = new int[antallDeltakere];
		
		// Hent navn og poengsum til deltakerne
		for (int i = 0; i < antallDeltakere; i++) {
			deltakerListe[i] = hentNavn(i + 1);
			poengsum[i] = hentPoengsum(deltakerListe[i]);
		}

		// Skriv ut navn paa alle deltakere og tilhoerene poengsum
		System.out.println("Deltakere og scores: ");
		for (int i = 0; i < antallDeltakere; i++) {
			skrivUtNavnOgPoeng(deltakerListe[i], poengsum[i]);
		}
		
	}

	public static void skrivUtNavnOgPoeng (String navn, int poeng) {
		// Skriv ut navn og poeng
		System.out.printf("%10s ", navn);
		for (int i = 0; i < poeng; i ++) {
			System.out.print("|");
		}
		System.out.printf(" (%d)%n", poeng);
	}

	public static String hentNavn (int deltaker) {	
		System.out.println("Oppgi navn paa deltaker " + deltaker + ":");
		Scanner inn = new Scanner(System.in);
		String navn = inn.nextLine();
		return navn;
	}
	
	public static int hentPoengsum (String navn) {
		String beOmPoengsum = "Oppgi score til " + navn + " (heltall):";
		int poengsum = hentHeltall(Integer.MIN_VALUE, beOmPoengsum);
		return poengsum;
	}
	
	public static int hentHeltall(int minimum, String beOmVerdi) {
		System.out.println(beOmVerdi);

		// Les inn heltall helt til gyldig
		while (true) {
			Scanner inn = new Scanner(System.in);
			if (inn.hasNextInt()){
				int innlest = inn.nextInt(); 
				if (innlest >= minimum) { // Gyldighetsbetingelse for heltall
					return innlest; 
				}	
			} 
			System.out.println("Ugyldig verdi! " + beOmVerdi);
		}
	}
}
