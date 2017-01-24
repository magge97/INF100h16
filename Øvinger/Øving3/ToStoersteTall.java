package Øving3;

import java.util.Scanner;

public class ToStoersteTall {

	public static void main(String[] args) {

		// Les inn antall
		Scanner inn = new Scanner(System.in);

		System.out.println("Hvor mange tall skal leses inn (minst 2)?:");
		int antall = inn.nextInt();

		if (antall >= 2) {

			int stoerste = Integer.MIN_VALUE;
			int nestStoerste = Integer.MIN_VALUE;
			int verdi;

			// Les inn verdier
			for (int nummer = 1; nummer <= antall; nummer++) {

				System.out.println("Oppgi verdi " + nummer + ":");
				verdi = inn.nextInt();

				if (verdi > stoerste) {
					nestStoerste = stoerste;
					stoerste = verdi;

				} else if (verdi > nestStoerste) {
					nestStoerste = verdi;

				} else {
					nestStoerste = stoerste;
				}
			}

			// Skriv ut stoerste og nest stoerste verdi
			System.out.println("Stoerste: " + stoerste);
			if (nestStoerste == stoerste) {
				System.out.println("Ingen nest stoerste verdi.");
			} else {
				System.out.println("Nest stoerste: " + nestStoerste);
			}

		} else {

			System.out.println("Feil.");
		}

		inn.close();
	}
}
