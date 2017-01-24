package Øving5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilLinjer {

	public static void main(String[] args) throws FileNotFoundException {

		// Les inn filnavn
		Scanner inn = new Scanner(System.in);
		System.out.print("Filnavn: ");
		String filnavn = inn.nextLine();
		
		File inputFile = new File(filnavn);
		
		try {
			inn = new Scanner(inputFile);	
		} catch (FileNotFoundException unntak) {
			inn.close();
			System.out.println("Filen eksisterer ikke.");
		}
		
		// Les linje og skriv ut linjenummer, antall tegn og innhold
		int linjeNummer = 1;
		while (inn.hasNextLine()) {
			String linje = inn.nextLine();
			System.out.printf("%d (%d tegn): %s %n", linjeNummer++, linje.length(), linje);
		}
		inn.close();
	}
}
