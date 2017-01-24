package Semoppg3;

import java.io.*;
import java.util.*;

public class LabyrintSkattejakt {

	public static void main(String[] args) {

		char[][] labyrint = lesLabyrintFraFil();

		boolean gyldigLabyrint = (labyrint == null) ? false : true;
		boolean avslutt = false;

		char tegn = 's';
		Posisjon s = finnPosisjon(labyrint, tegn);
		
		Scanner inn = new Scanner(System.in);
		String retning = " ";

		while (!avslutt && gyldigLabyrint) {
			System.out.println("Spiller-gull: " + s.hentGull());
			System.out.println("Labyrint: ");
			skrivUtTabell(labyrint);

			System.out.println("Hvor vil du gaa? Skriv nord, soer, vest eller oest for aa gaa i respektiv retning, "
					+ "eller avslutt for aa avslutte.");
			retning = inn.nextLine();

			/*
			 * Sjekk om retning blokkert. Gaa dersom ikke blokkert.
			 */
			if (s.kanGaaTil(retning, labyrint)) {
				s.gaaTil(retning, labyrint, tegn);
			} else if (!retning.equals("avslutt")) {
				System.out.println("Veien er blokkert.");
			} else {
				avslutt = true;
			}

		}
	}

	public static char[][] lesLabyrintFraFil() {
		Scanner inn = new Scanner(System.in);

		// Les filbane
		System.out.println("Oppgi filbane: ");
		String filbane = inn.nextLine();
		File fil = new File(filbane);

		try {
			inn = new Scanner(fil);
			inn.useDelimiter("\n");
			int xLengde = inn.nextInt(); // Antall kolonner i labyrint
			int yLengde = inn.nextInt(); // Antall rader i labyrint

			// Labyrint må ha minst én rad og én kolonne
			if (xLengde < 1 || yLengde < 1) {
				System.out.println("Ugyldig format.");
				return null;
			}

			char[][] labyrint = new char[yLengde][xLengde];

			// Les labyrint fra tekstfil
			for (int y = 0; y < yLengde; y++) {
				String linje = inn.next();
				for (int x = 0; x < xLengde; x++) {
					labyrint[y][x] = linje.charAt(x);
				}
			}
			return labyrint;

		} catch (FileNotFoundException unntak) {
			System.out.println("Fil eksisterer ikke.");
		} catch (StringIndexOutOfBoundsException unntak) {
			System.out.println("Ugyldig format.");
		} catch (InputMismatchException unntak) {
			System.out.println("Ugyldig format.");
		}

		return null;

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
		return new Posisjon(0, 0);
	}

}
