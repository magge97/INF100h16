
import java.util.Scanner;

public class Romertall {

	public static void main(String[] args) {

		Scanner inn = new Scanner(System.in);

		System.out.println("Oppgi romertall: ");
		String romertall = inn.nextLine();

		int total = 0;

		while (!romertall.isEmpty()) {

			int lengde = romertall.length();

			// Omgjoer romertall til desimaltall
			int tegn = romertallTegnVerdi(romertall.charAt(0));  
			int nesteTegn = (romertall.length() > 1) ? 
					romertallTegnVerdi(romertall.charAt(1)) : 0;

			if (nesteTegn > tegn){
				total += (nesteTegn - tegn);
				romertall = romertall.substring(2, lengde); // Fjern de to foerste tegnene
			} else {
				total += tegn; 
				romertall = romertall.substring(1, lengde);// Fjern det foerste tegnene
			}

		}
		System.out.printf("Verdien i desimaltall er: %d %n", total);
	}

	public static int romertallTegnVerdi(char tegn) {

		switch (tegn) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

}
