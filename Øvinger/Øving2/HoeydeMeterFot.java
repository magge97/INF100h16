package Øving2;

import java.util.Scanner;

public class HoeydeMeterFot {

	public static void main(String[] args) {

		String resultatStreng = "";
		boolean GYLDIG = false;

		// Konverteringsenheter- og faktorer
		final int METRISK = 1;
		final int IMPERISK = 2;
		final double FOT_I_METER = 3.2808399;


		// Les inn navn
		Scanner inn = new Scanner(System.in);
		System.out.println("Hva heter du?: ");
		String navn = inn.nextLine();

		// Velg konverteringsretning
		System.out.println(
				"Skriv 1 for aa konvertere fra metriske enheter til imperiske. "
						+ "Skriv 2 for aa konvertere fra imperiske enheter til imperiske: ");
		int innEnhet = inn.nextInt();

		// Beregn resultat og lag streng
		if (innEnhet == METRISK){
			GYLDIG = true;
			
			System.out.println("Oppgi hoeyde i meter: ");
			double fot = FOT_I_METER*inn.nextDouble();

			resultatStreng = fot + "fot ";
		} 
		else if (innEnhet == IMPERISK){
			GYLDIG = true;
			
			System.out.println("Oppgi hoeyde i fot: ");
			double meter = inn.nextDouble()/FOT_I_METER;

			resultatStreng = meter + " meter";
		} 
		else {
			System.out.println("Ugyldig valg.");
		}


		// Skriv ut resultat
		if (GYLDIG == true){
		System.out.println("Hei " + navn + ". Din hoeyde er " + resultatStreng + ".");
		}
		
		inn.close();
	}

}
