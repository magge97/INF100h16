package Semoppg2;



public class YatzyEnkel {

	public static void main(String[] args) {

		int totalPoeng = 0;
		int poengRunde = 0;
		int antallRunder = 5;

		for (int runde = 0; runde < antallRunder; runde++) {
			System.out.println("Runde " + (runde + 1));

			// Generer terningverdier
			int[] terningverdier = terningkast();
			skrivTerningVerdier(terningverdier);

			// Bergen poeng for runde og legg til total
			poengRunde = poengForTerninger(terningverdier);
			System.out.printf("Poeng: %2d %n---------%n", poengRunde);
			totalPoeng += poengRunde;
		}

		System.out.println("Total: " + totalPoeng);

	}

	public static int poengForTerninger(int[] terningverdier) {

		int[] poengsum = new int[7];
		int maksPoeng = 0;

		// Finn poengsummen til hver av terningverdiene 1-6
		// (sum = antall av terningverdi * terningverdi)
		for (int verdi : terningverdier) {
			poengsum[verdi] += verdi;
		}
		// Finn stoerste poengsum
		for (int poeng : poengsum) {
			if (poeng > maksPoeng) {
				maksPoeng = poeng;
			}
		}
		return maksPoeng;
	}

	public static int[] terningkast() {

		int[] terningVerdier = new int[5];

		// Generer 5 tilfeldige terningverdier
		for (int kast = 0; kast < 5; kast++) {
			terningVerdier[kast] = (int) (1 + 6 * Math.random());
		}
		return terningVerdier;
	}

	public static void skrivTerningVerdier(int[] terningverdier) {

		int nummer = 1;

		// Skriv ut alle terningverdiene
		for (int verdi : terningverdier) {
			System.out.println("Terning " + (nummer++) + ": " + verdi);
		}
	}

}
