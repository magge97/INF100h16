package Øving2;

public class Eval {

	public static void main(String[] args) {
		
		
		// Resultat: 12 (int), sum av heltall => int
		System.out.println(1 + 9 + 2); 
		
		// Resultat: 5 (int), heltallsdivisjon => int
		System.out.println(41 / 7); 
		
		// Resultat: 6 (int), rest av heltallsdivisjon => int
		System.out.println(41 % 7); 
		
		// Resultat: 5.857... (double), double/int (flytallsdivisjon) => double
		System.out.println(41.0 / 7); 
		
		// Resultat: -6 (int), alle variabler er heltall => int
		System.out.println(1 - 9 + 2); 
		
		// Resultat: -10.0 (double), en variabel er et flyttall => double
		System.out.println(1 - (9 + 2.0)); 
		
		// Resultat: 0 (int), alle variabler er heltall => int
		System.out.println(4 * 4 - 16); 
		
		// Resultat: 52.0 (double), en variabel er et flyttall => double
		System.out.println(-(88.0 / 22 * 3) + 8 * 8); 
		
	}

}
