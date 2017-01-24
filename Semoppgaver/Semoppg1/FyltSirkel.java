
import java.util.Scanner;

public class FyltSirkel {

	public static void main(String[] args) {

		final int MINIMUM_RADIUS = 1;

		int radius = hentRadius(MINIMUM_RADIUS, "Oppgi radius (minst " + MINIMUM_RADIUS + "): "); 

		// Tegn sirkel med innlest radius
		for (int y = -radius; y <= radius + 1; y++) { 
			for (int x = -radius; x <= radius + 1; x++) {
				System.out.print( x*x + y*y <= (radius + .3) * (radius + .3) ? "**" : "  "); //Legger til .3 for forfining av sirkel
			}
			System.out.println(""); 
		}

	}

	public static int hentRadius(int minimumRadius, String beOmRadius) {

		System.out.println(beOmRadius);

		// Les inn radius helt til den er stoerre enn eller lik minimum radius 
		while (true) {
			Scanner inn = new Scanner(System.in);
			if (inn.hasNextInt()){
				int radius = inn.nextInt(); 
				if (radius >= minimumRadius) {
					return radius; 
				}	
			} 
			// ellers: radius < minimum radius eller feil type, skriv ut feilmelding
			System.out.println("Ugyldig! " + beOmRadius);
		}
	}

}
