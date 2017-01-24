package Semoppg3;

import Semoppg3.Posisjon;

import java.util.Scanner;

public class LabyrintVandring {

	public static void main(String[] args) {

		char[][] labyrint = { { '*', '*', '*', '*' }, { '*', ' ', ' ', '*' }, { '*', ' ', '*', '*' },
				{ '*', 's', '*', '*' }, { '*', '*', '*', '*' }, };

		char tegn = 's'; //
		Posisjon s = finnPosisjon(labyrint, 's'); // Finn posisjon til 's' i
													// labyrint

		boolean avslutt = false;
		skrivUtTabell(labyrint);

		while (!avslutt) {
			// Les inn retning 'tegn' skal flyttes til.
			Scanner inn = new Scanner(System.in);
			System.out.println("Hvor vil du gaa? Skriv nord, soer, vest eller oest for aa gaa i respektiv retning, "
					+ "eller avslutt for aa avslutte.");
			String retning = inn.nextLine();

			/*
			 * Gaa i spesifisert retning. Gi feilmelding dersom vei er blokkert.
			 * Avslutt dersom brukeren skrev "avslutt".
			 */
			if (s.kanGaaTil(retning, labyrint)) {
				s.gaaTil(retning, labyrint, tegn);
				skrivUtTabell(labyrint);
			} else if (!retning.equals("avslutt")) {
				System.out.println("Veien er blokkert.");
			} else {
				avslutt = true;
			}
		}

	}

	public static void skrivUtTabell(char[][] tabell) {
		// Skriver ut tabell
		for (int y = 0; y < tabell.length; y++) {
			for (int x = 0; x < tabell[0].length; x++) {
				System.out.print(tabell[y][x]);
			}
			System.out.println();
		}
	}

	public static Posisjon finnPosisjon(char[][] tabell, char tegn) {
		int[] posisjon = new int[2]; // Tabell som holder x- og y-koordinat til
										// 'tegn'

		/*
		 * Finner posisjon til spesifisert tegn. Forutsetter at tegn forekommer
		 * bare én gang.
		 */
		for (int y = 0; y < tabell.length; y++) {
			for (int x = 0; x < tabell[0].length; x++) {
				if (tabell[y][x] == tegn) {
					return new Posisjon(x, y);
				}
			}
		}
		return null;
	}

}
