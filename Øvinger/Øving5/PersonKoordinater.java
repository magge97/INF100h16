package Øving5;

import java.io.*;
import java.util.*;

public class PersonKoordinater {

	public static void main(String[] args) {
		Scanner lesFil = new Scanner(System.in);
		int antallPersoner = 0;

		// Hent filnavn
		System.out.print("Hvilken fil skal leses inn? ");
		String filnavn = lesFil.nextLine();

		File innFil = new File(filnavn);

		boolean gyldigFil = true;
		boolean gyldigSyntaks = true;

		// Sjekk om fil eksisterer og om antall personer er oppgitt (og riktig
		// formatert)
		try {
			lesFil = new Scanner(innFil);
			antallPersoner = lesFil.nextInt();
		} catch (FileNotFoundException unntak) {
			System.out.println("Filen eksisterer ikke.");
			gyldigFil = false;
			lesFil.close();
		} catch (InputMismatchException unntak) {
			gyldigSyntaks = false;
			lesFil.close();
		}

		// Hent koordinater fra fil og skriv ut resultat
		if (gyldigSyntaks && antallPersoner > 1) {
			System.out.printf("%-10s %10.6s %10.6s%n", "Navn", "X", "Y");
			for (int linje = 1; linje <= antallPersoner; linje++) {
				String navn = lesFil.next();
				try {
					double x = lesFil.nextDouble();
					double y = lesFil.nextDouble();
					System.out.printf("%-10s %10.6f %10.6f%n", navn, x, y);
				} catch (InputMismatchException ugyldigVerdi) {
					System.out.println("Linje ikke formatert riktig.");
					break;
				}
			}
		} else if (gyldigFil) {
			System.out.println("Ugyldig syntaks eller verdier i tekstfil.");
		}
		lesFil.close();

	}

}
