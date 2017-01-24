
import java.util.Scanner;

public class TerningSimulering {

	public static void main (String[] args) {

		// Les inn verdier
		System.out.println("Oppgi verdien som terningens verdi skal vaere " 
				+ "hoeyere eller lik (heltall fra 1 til 6): ");
		int minsteVerdi = lesHeltall(1, 6);

		System.out.println("Oppgi antall terningkast (positivt heltall): " );
		int antallKast = lesHeltall(1, Integer.MAX_VALUE);

		// Simuler kast med innleste verdier
		int gyldigeKast = simulerKast(minsteVerdi, antallKast);

		double sannsynlighet = (double) gyldigeKast / (double) antallKast;

		// Skriv ut resultat
		System.out.println("Terningens verdi var stoerre eller lik " + minsteVerdi + " " 
				+ gyldigeKast + " av " + antallKast + " ganger.");
		System.out.printf("p(v >= %d) = %.5f %n", minsteVerdi, sannsynlighet);

	}

	private static int simulerKast(int minsteVerdi, int antallKast) {

		int tilfeldigTall = 0;
		int gyldigeKast = 0;

		// Generer kast 
		for (int kast = 1; kast <= antallKast; kast++) {
			tilfeldigTall = (int) (1 + 6 * Math.random()); 
			if (tilfeldigTall >= minsteVerdi){
				gyldigeKast++;
			}
		}
		return gyldigeKast;
	}

	private static int lesHeltall(int minimum, int maksimum) {

		// Les inn verdi helt til den er paa spesifisert intervall
		while (true) { 
			Scanner inn = new Scanner(System.in);
			if (inn.hasNextInt()) {
				int innlest = inn.nextInt();
				if (minimum <= innlest && innlest <= maksimum){
					int gyldigVerdi = innlest; 
					return gyldigVerdi;
				}
			}
			// ellers: innlest verdi er ikke på spesifisert intervall
			// eller av feil type, skriv ut feilmelding
			System.out.println("Ugyldig verdi! Proev på nytt: ");
		} 
	}
}
