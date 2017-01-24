package Øving4;

import java.util.Scanner;
import java.util.ArrayList;

public class Primtallutvalg {

	public static void main(String[] args) {

		// Les inn antall heltall som skal leses til tabell
		int antallElementer = hentHeltall(1, "Hvor mange verdier skal leses inn?");

		int[] heltall = new int[antallElementer];

		ArrayList<Integer> primtall = new ArrayList<>();
		ArrayList<Integer> andreTall = new ArrayList<>();

		int antallPrimtall = 0;
		int antallAndreTall = 0;
		
		// Les inn heltall til heltallstabellen
		Scanner inn = new Scanner(System.in);
		for (int i = 0; i < antallElementer; i++) {
			heltall[i] = hentHeltall(Integer.MIN_VALUE, "Oppgi verdi " + (i + 1) + ":");
		}
	
		/*
		 * Dersom primtall, legg til i primtallstabell.
		 * Dersom ikke primtall, legg til i tabell for andre tall.
		 */
		for (int verdi: heltall) {
			if (erPrimtall(verdi)){
				primtall.add(verdi);
			} else {
				andreTall.add(verdi);			
			}
		}
		
		// Skriv ut primtall og andre tall
		System.out.println("Primtall: ");
		skrivUtTabell(primtall);
		System.out.println("Andre tall: ");
		skrivUtTabell(andreTall);

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
	public static void skrivUtTabell (ArrayList<Integer> tabell) {
		// Skriv ut hvert element i gitt tabell
		for (int verdi: tabell){
			System.out.println(verdi);
		}
	}
	public static boolean erPrimtall (int heltall) {
		if (heltall < 2) { // Primtall maa vaere stoerre eller lik 2
			return false;
		}
		// Sjekk om tall >= 2 er primtall
		for (int i = 2; i <= heltall - 1; i++) {
			if (heltall % i == 0) { 
				return false;
			}
		}
		return true;
	}

}