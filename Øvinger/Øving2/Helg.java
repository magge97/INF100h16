package Øving2;

import java.util.Scanner;

public class Helg {

	public static void main(String[] args) {
		
		Scanner inn = new Scanner(System.in);
		
		// Les inn navn
		System.out.println("Hva heter du?: ");
		String navn = inn.nextLine();
		
		// Les inn aktivitet på loerdag og soendag
		System.out.println("Hva liker du best aa gjoere paa loerdager?: ");
		String loerdag = inn.nextLine();
		System.out.println("Hva liker du best aa gjoere paa soendager?: ");
		String soendag = inn.nextLine();
		
		// Skriv ut aktiviteter
		System.out.println("Hei " + navn + ". På loerdager liker du best aa " + loerdag.toLowerCase() + 
				". På soendager liker du best aa " + soendag.toLowerCase() + ".");
		
		inn.close();
	}

}
