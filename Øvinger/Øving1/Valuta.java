package Øving1;
/**
* INF 100 HOESTEN 2016
* OEving 1, Oppgaave 4
* 
* Omrekning til Euro fraa norske kroner.
*/
public class Valuta {

 public static void main(String[] args) {

   // Sett beloep i NOK og valutakurs
   double nok = 750.00;
   double eurKurs = 9.46;
   double usdKurs = 5.00;
 
   // Rekn ut beloep
   double eur = nok/eurKurs;
   double USD = nok/usdKurs;

   // Skriv ut resultatet
   System.out.println("Med kurs " + eurKurs + " er " + nok + " kroner verdt " + eur + " Euro");
   System.out.println("Med kurs " + usdKurs + " er " + nok + " kroner verdt " + USD + " USD");
   
 }
}
