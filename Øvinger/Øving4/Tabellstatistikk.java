package Øving4;


import java.util.Scanner;

public class Tabellstatistikk {

	public static void main(String[] args) {

		// Les inn n flytall i en tabell
		int antallElementer = hentHeltall(1, "Hvor mange verdier skal leses inn?");

		double[] flyttall = new double[antallElementer];
		for (int i = 0; i < antallElementer; i++) {
			flyttall[i] = hentFlyttallNummer(i + 1, "Oppgi verdi " + (i + 1) + ":"); 
		}

		// Skriv ut tabellen med flyttall
		System.out.println("Tabell: ");
		for (double verdi: flyttall) {
			System.out.println(verdi);
		}

		// Skriv ut beregninger
		System.out.println("Snitt: " + snitt(flyttall));
		System.out.println("Varians: " + varians(flyttall));
		System.out.println("Standardavvik: " + standardavvik(flyttall));
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

	public static double hentFlyttallNummer(int nummer, String beOmVerdi) {
		System.out.println(beOmVerdi);
		// Les inn flyttall som returneres til flyttallstabellen
		while (true) {
			Scanner inn = new Scanner(System.in);
			if (inn.hasNextDouble()) {
				double innlest = inn.nextDouble();
				return innlest;
			}
			System.out.println("Ugyldig! " + beOmVerdi);
		}

	}

	public static double snitt(double[] tabell) {
		double sum = 0;
		// Summer alle elementene i tabell
		for (double x: tabell) {
			sum += x;
		}
		return sum / tabell.length;
	}

	public static double varians(double[] tabell) {
		double snitt = snitt(tabell);
		double sum = 0;
		// Beregn og returner varians
		for (double x: tabell) {
			sum += Math.pow(x - snitt, 2);
		}
		return sum / tabell.length; 
	}

	public static double standardavvik(double[] tabell) {
		return Math.sqrt(varians(tabell));
	}

}
