
import java.util.Scanner;

public class EnkelKryptering {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);

		// Les inn tekst som skal krypteres og noekkel-verdi
		System.out.println("Inn-tekst: ");
		String innTekst = inn.nextLine();

		System.out.println("Noekkel-verdi: ");
		int noekkel = inn.nextInt();

		final int TEGN_I_ALFABET = 26;
		
		String kryptertTekst = "";

		for (int i = 0; i < innTekst.length(); i++) {
			char tegn = innTekst.charAt(i);
			if ('a' <= tegn && tegn <= 'z') {
				// Krypter tegn
				int posisjon = (tegn + noekkel - 'a') % (TEGN_I_ALFABET); 
				
				tegn = (char) (posisjon + 'a');
				tegn += (posisjon < 0) ? TEGN_I_ALFABET : 0; // Negativ posisjon: start paa slutten av alfabet
				
			}
			kryptertTekst += tegn; 
		}

		System.out.printf("Ut-tekst: %s %n", kryptertTekst);

	}

}
