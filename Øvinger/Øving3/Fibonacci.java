package Øving3;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {


		Scanner inn = new Scanner(System.in);

		// Les inn maksverdi for Fibonacci-tall
		System.out.println("Oppgi hoeyeste tall som Fibonacci-tall kan vaere likt: ");
		int maksverdi = inn.nextInt();

		// Skriv ut Fibonacci-tallene dersom maks-verdien er gyldig ( >= 0 )
		if (maksverdi >= 0) {

			System.out.println("Fibonnaci-tall 0: 0");

			int fib1 = 0;
			int fib2  = 1;
			int fibonacci = -999;

			for (int nummer = 1; fibonacci < maksverdi; nummer++) {
				if (nummer == 1 || nummer == 2){
					fibonacci = 1;
				} else {
					fib1 = fib2;
					fib2 = fibonacci;
					fibonacci = fib1 + fib2;
				}

				// Skriv ut Fibonacci-tallet til nåværende nummer
				// dersom Fibonacci-tallet ikke overskrider maks-verdien
				if (fibonacci <= maksverdi) {
					System.out.println("Fibonacci-tall " + nummer + " = " + fibonacci);
				}

			}

		} else {
			// Gi feilmelding dersom maks-verdi er ugyldig ( < 0) 
			System.out.println("Feil! Maks-verdi maa minst vaere lik null.");

		}

		inn.close();
	}

}
