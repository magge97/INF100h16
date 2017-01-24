package Øving5;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PersonAvstand {

	public static void main(String[] args) {
		Scanner lesFil = new Scanner(System.in);
		
		int antallPersoner = 0;

		// Hent filnavn
		System.out.print("Hvilken fil skal leses inn? ");
		String filnavn = lesFil.nextLine();

		File innFil = new File(filnavn);

		boolean gyldigFil = true;
		boolean gyldigSyntaks = true;

		// Sjekk om fil eksisterer og om antall personer er oppgitt (riktig
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

		// Les inn koordinater
		double[][] koordinater = new double[antallPersoner][2];
		String[] navn = new String[antallPersoner];

		for (int i = 0; i < antallPersoner; i++) {
			navn[i] = lesFil.next();
			try {
				koordinater[i][0] = lesFil.nextDouble(); // x-koordinat
				koordinater[i][1] = lesFil.nextDouble(); // y-koordinat
			} catch (InputMismatchException ugyldigVerdi) {
				gyldigSyntaks = false;
				break;
			}
		}

		// Beregn avstand mellom de ulike personene
		// og skriv ut resultat
		if (gyldigSyntaks && antallPersoner > 1) { // Minimum 2 personer
			System.out.printf("%-10s %-10s %10s%n", "Navn 1", "Navn 2", "Avstand");

			for (int i = 0; i < antallPersoner; i++) {
				for (int j = i + 1; j < antallPersoner; j++) {
					double xAvstand = koordinater[i][0] - koordinater[j][0];
					double yAvstand = koordinater[i][1] - koordinater[j][1];
					double avstand = Math.sqrt(Math.pow(xAvstand, 2) + Math.pow(yAvstand, 2));
					System.out.printf("%-10s %-10s %10f%n", navn[i], navn[j], avstand);
				}
			}
		} else if (gyldigFil){
			System.out.println("Ugyldig syntaks eller verdier i tekstfil.");
		}

		lesFil.close();

	}

}
