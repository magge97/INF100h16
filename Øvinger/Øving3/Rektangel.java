package Øving3;

import java.util.Scanner;

public class Rektangel {

	public static void main(String[] args){
		
		Scanner inn = new Scanner(System.in);
		
		// Les inn hoeyde
		System.out.println("Oppgi hoeyde (minst 1): ");
		int hoeyde = inn.nextInt();
		
		// Sjekk om gyldig hoeyde (minst 1)
		if (hoeyde >= 1) {
			// Les inn bredde
			System.out.println("Oppgi bredde (minst 1): ");
			int bredde = inn.nextInt();
			
			// Sjekk om gyldig bredde (minst 1)
			if (bredde >= 1) {
				// Skriv ut fyllt rektangel 
				for (int y = 1; y <= hoeyde; y++) {
					for (int x = 1; x <= bredde; x++) {
						System.out.print("*");
					}
					System.out.println("");
				}
			} else {
				System.out.println("Feil! Bredde maa minst vaere lik 1.");
			}
			
		} else {
			System.out.println("Feil! Hoeyde maa minst vaere lik 1.");
		}
		
		inn.close();
	}

}
