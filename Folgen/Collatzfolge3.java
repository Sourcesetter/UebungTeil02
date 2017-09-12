package Folgen;
/* Berechnet Maximalwerte und Anzahl-bis-1 von mehreren Colartsfolge 
   vom gegebenen minimalem bis maximalem Startwert.
 * 
 * 
 */

import java.util.*;

class Hilfetext {
	void ausgeben(){
		System.out.println("Nutzung: Collatzfolge3 <VonStartwert> <BisStartwert> ");
		System.out.println("Ausgabe: ");
		System.out.println("VonStartwert Folgenglied_2 Folgenglied_3 ... ");
		System.out.println("VonStartwert+1 Folgenglied_2 Folgenglied_3 ... ");
		System.out.println("...");
		System.out.println("BisStartwert Folgenglied_2 Folgenglied_3 ... ");
		System.out.println(" ");
	}
}

class Bereich{
	int von;
	int bis;
	
	boolean plausibel(){
		int fehler = 0;
		if (von <= 1){
			System.out.println("Von-Wert groesser 1 waehlen.");
			fehler++;
		}
		if (bis <= 1){
			System.out.println("Bis-Wert groesser 1 waehlen.");
		
			fehler++;	
		}
		if (von >= bis){
			System.out.println("Von-Wert kleiner Bis-Wert waehlen.");
			fehler++;	
		}
		if (fehler == 0){
			return true;
		}
		else{
			System.out.println("Klasse Pruefen meldet: Eingaben nicht pausibel.");
			return false;
		}
	}
}

class Folgenglied{
	/* Klasse zum Berechnen des des naechsten Folgenglieds einer Collatzfolge 
	*/
	int naechstes(int folgenGl){
		int rest;  // Variable zum Pruefen, ob eine Zahl gerade oder ungerade ist.	
						
		rest = folgenGl % 2;
	 	if (rest == 0){
			/* System.out.println("Die eingegebene Zahl ist gerade "); */
			return(folgenGl/2);
	 	}
	 	else {
			return(3 * folgenGl + 1);
	 	}
	}
}



public class Collatzfolge3{
	public static void main (String[] args){
		
		boolean testmodus = false;  // bei testmodus = true wird die Folge selbst mit ausgegeben 
		int i = 0;
		
		Calendar cal = Calendar.getInstance ();
		Calendar calE = Calendar.getInstance ();
		
		
		/* Variablen zum Erzeugen einer Reihe */
		int altGl = 0;  	// Altes Folgenglied
		int neuGl = 0;    // Neues Folgenglied
		/* Variablen zum Abarbeiten aller Reihen */		
		int startGl = 0;	// Wert des ersten Folgenglieds zum Start der Folge
		int bisGl = 0;  	// Maximaler Wert des ersten Folgenglieds bis zu dem die Berechnung 
		                  // laufen soll
		int maxGl = 0;	  // Folgenglied mit dem maximalen Wert der Folge
		Hilfetext h = new Hilfetext();
		Bereich b = new Bereich();
		Folgenglied gl = new Folgenglied();
		
		if (args.length == 0){
		 System.out.println("Keine Eingabe von Parametern erfolgt. ");
		 h.ausgeben();
		 System.exit(0);
		}
		
		if (args.length == 2){
			  // Die Monate werden mit 0 (= Januar) beginnend gezaehlt!
  			// (Die Tage im Monat beginnen dagegen mit 1)

  			System.out.println( "Datum: " + cal.get( Calendar.DAY_OF_MONTH ) +
                      "." + (cal.get( Calendar.MONTH ) + 1 ) +
                      "." + cal.get( Calendar.YEAR ) );

  			System.out.println( "Uhrzeit-Start: " + cal.get( Calendar.HOUR_OF_DAY ) + ":" +
                      cal.get( Calendar.MINUTE ) + ":" +
                      cal.get( Calendar.SECOND ) + ":" +
                      cal.get( Calendar.MILLISECOND ) );
			
			
			
			
			b.von = Integer.parseInt(args[0]);
			b.bis = Integer.parseInt(args[1]);
			
			
			if (!b.plausibel()){
				System.out.println("Collatzfolge3 stoppt.");
				System.out.println(" ");
				System.exit(0);
			}
			
			startGl = b.von;
			bisGl = b.bis;
			System.out.println("St;Max;Anz1");
			while (startGl <= bisGl){   // Schleife mit startGl und bisGl gesteuert
				System.out.print(startGl + ";");
				neuGl = startGl;
				maxGl = startGl;
				i = 0; // i == 0 erster Duchlauf der Berechnung einer neuen Folge
	
				while (neuGl > 1){  // Schleifer mit neuGl und altGl gesteuert.
					if (i > 0){
						neuGl = gl.naechstes(altGl);
					}
					if(testmodus) {System.out.print(neuGl + " ");}
					
					/* Maximum Zwischenspeichern */
					if (neuGl > maxGl){ 
						maxGl = neuGl;
					}
					altGl = neuGl;
					i++;
				}
				startGl++;
				if(testmodus) {System.out.println(" ");}
				System.out.println(maxGl + ";" + i);
			}
		}
		else{
			System.out.println("Zu viele oder zu wenige Parameter eingegeben ");
			h.ausgeben();
			System.out.println("Collatzfolge3 stoppt.");
			System.out.println(" ");
			System.exit(0);
		}
		System.out.println(" ");
		 System.out.println( "Uhrzeit-Ende: " + calE.get( Calendar.HOUR_OF_DAY ) + ":" +
                      calE.get( Calendar.MINUTE ) + ":" +
                      calE.get( Calendar.SECOND ) + ":" +
                      calE.get( Calendar.MILLISECOND ) );
			
	}
}
