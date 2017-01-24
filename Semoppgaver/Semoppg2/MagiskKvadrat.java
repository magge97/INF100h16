package Semoppg2;

import java.util.Scanner;

public class MagiskKvadrat {

	public static void main(String[] args) {

		int sidelengde = 4; 
		// Sumformel for rekke, kolonne og diagonal i magisk kvadrat
		int sumMagisk = sidelengde * (1 + sidelengde * sidelengde) / 2;

		// Tabell for verdier i kvadrat
		int[][] kvadrat = new int[sidelengde][sidelengde];

		// Tabell for å sjekke forekomst av tall (true dersom tall er i kvadrat)
		boolean[] forekomstTall = new boolean[kvadrat.length * kvadrat.length + 1];
		forekomstTall[0] = true;

		System.out.println("Fyll inn kvadratets verdier: ");

		// Les inn tall til kvadratet
		Scanner inn = new Scanner(System.in);
		
		for (int kol = 0; kol < sidelengde; kol++) { // kolonne
			for (int rad = 0; rad < sidelengde; rad++) { // rad
				System.out.println("Plass " + (rad + 1) + ", " + (kol + 1));
				int tall = inn.nextInt();
				kvadrat[rad][kol] = tall;
				// Sjekk om verdi er innenfor gyldighetsområde til magisk kvadrat
				if (0 < tall && tall < forekomstTall.length) {
					forekomstTall[kvadrat[rad][kol]] = true; // innlest tall i gyldighetsområde
				} 
			}
		}
		// Skriv ut om innlest kvadrat er et magisk kvadrat eller ikke
		if (erMagiskKvadrat(kvadrat, forekomstTall, sumMagisk)) {
			System.out.println("Dette er et magisk kvadrat.");
		} else {
			System.out.println("Dette er ikke et magisk kvadrat.");
		}

	}

	public static boolean erMagiskKvadrat(int[][] kvadrat, boolean[] forekomstTall, int sumMagisk) {
		// Sjekker om alle betingelser for magisk kvadrat er oppfyllt
		if (alleTallForekommer(forekomstTall) 
				&& sumRad(kvadrat, sumMagisk) 
				&& sumKolonne(kvadrat, sumMagisk)
				&& sumDiagonal(kvadrat, sumMagisk)) {
			return true;
		}
		return false;
	}

	public static boolean sumDiagonal(int[][] kvadrat, int sumMagisk) {

		int sumDiagonal = 0;
		
		// Sum tall i diagonal (0,0) -> (sidelengde - 1, sidelengde - 1)
		for (int i = 0; i < kvadrat.length; i++) {
			sumDiagonal += kvadrat[i][i];
		}
		if (sumDiagonal != sumMagisk) { // Sjekk om sum er gyldig
			return false;
		}

		// Sum tall i diagonal (sidelengde - 1, 0) -> (0, sidelengde - 1)
		sumDiagonal = 0;
		for (int kol = 0; kol < kvadrat.length; kol++) {
			sumDiagonal += kvadrat[kvadrat.length - 1 - kol][kol];
		}
		if (sumDiagonal != sumMagisk) { // Sjekk om sum er gyldig
			return false;
		}
		return true;
	}

	public static boolean sumKolonne(int[][] kvadrat, int sumMagisk) {
		
		// Finn sum til hver kolonne
		for (int kol = 0; kol < kvadrat.length; kol++) {
			int sumKolonne = 0;
			for (int rad = 0; rad < kvadrat.length; rad++) {
				sumKolonne += kvadrat[kol][rad];
			}
			if (sumKolonne != sumMagisk) { // Sjekk om sum er gyldig
				return false;
			}
		}
		return true;
	}

	public static boolean sumRad(int[][] kvadrat, int sumMagisk) {
		// Finn sum til hver rad
		for (int rad = 0; rad < kvadrat.length; rad++) {
			int sumRad = 0;
			for (int kol = 0; kol < kvadrat.length; kol++) {
				sumRad += kvadrat[kol][rad];
			}
			if (sumRad != sumMagisk) { // Sjekk om sum er gyldig
				return false;
			}
		}
		return true;
	}

	public static boolean alleTallForekommer(boolean[] forekomstTall) {
		// Sjkker om alle tall til magisk kvadrat forekommer
		for (boolean tall : forekomstTall) {
			if (tall == false) {
				return false;
			}
		}
		return true;
	}

}
