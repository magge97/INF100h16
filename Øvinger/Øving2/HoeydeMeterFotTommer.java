package Øving2;

import java.util.Scanner;

public class HoeydeMeterFotTommer {

	public static void main(String[] args) {

		String resultatStreng = "";
		boolean GYLDIG = false;

		// Konverteringsenheter- og faktorer
		final int METRISK = 1;
		final int IMPERISK = 2;
		final double FOT_I_METER = 3.2808399;
		final int TOMMER_I_FOT = 12;


		// Les inn navn
		Scanner inn = new Scanner(System.in);
		System.out.println("Hva heter du?: ");
		String navn = inn.nextLine();

		// Velg konverteringsretning
		System.out.println(
				"Skriv 1 for aa konvertere fra metriske enheter til imperiske. "
						+ "Skriv 2 for aa konvertere fra imperiske enheter til imperiske: ");


		// Sjekk om feil type 
		try{
			int innEnhet = inn.nextInt();

			// Beregn resultat og lag streng
			// Sjekk om feil heltallsverdi
			if (innEnhet == METRISK){
				GYLDIG = true;

				System.out.println("Oppgi hoeyde i meter: ");
				double fotFraMeter = FOT_I_METER * inn.nextDouble();
				int fot = (int) fotFraMeter;
				int tommer = (int) ((fotFraMeter%1) * TOMMER_I_FOT);

				resultatStreng = fot + " fot " + "og " + tommer + " tommer";
			} 
			else if (innEnhet == IMPERISK){
				GYLDIG = true;

				System.out.println("Oppgi hoeyde i fot: ");
				double fot = inn.nextInt();
				System.out.println("Oppgi hoeyde i tommer: ");
				double tommer = inn.nextInt();

				double meter = (fot + tommer/TOMMER_I_FOT)/FOT_I_METER;

				resultatStreng = meter + " meter";
			} 
			else {
				System.out.println("Ugyldig verdi");
			}

			// Skriv ut resultat
			if (GYLDIG == true){
				System.out.println("Hei " + navn + ". Din hoeyde er " + resultatStreng + ".");
			}
		} 
		catch(Exception e){
			System.out.println("Ugyldig verdi");
		}
		finally{
			inn.close();
		}

	}
}
