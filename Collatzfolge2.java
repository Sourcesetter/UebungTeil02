/* Berechnet intern die Glieder von mehreren Colartsfolge vom gegebenen minimalem bis  
 * maximalem Startwert.
 * 
 * 
 */

class Hilfetext{
	void ausgeben(){
		System.out.println("Nutzung: Collatzfolge2 <VonStartwert> <BisStartwert> ");
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
	


public class Collatzfolge2{
	public static void main (String[] args){
		
		int i = 0;
		/* Variablen zum Erzeugen einer Reihe */
		int altGl = 0;  	// Altes Folgenglied
		int neuGl = 0;    // Neues Folgenglied
		/* Variablen zum Abarbeiten aller Reihen */		
		int startGl = 0;	// Wert des ersten Folgenglieds zum Start der Folge
		int bisGl = 0;  	// Maximaler Wert des ersten Folgenglieds bis zu dem die Berechnung laufen soll
		Hilfetext h = new Hilfetext();
		Bereich b = new Bereich();
		Folgenglied gl = new Folgenglied();
		
		if (args.length == 0){
		 System.out.println("Keine Eingabe von Parametern erfolgt. ");
		 h.ausgeben();
		 System.exit(0);
		}
		
		if (args.length == 2){
			
			b.von = Integer.parseInt(args[0]);
			b.bis = Integer.parseInt(args[1]);
			
			
			if (!b.plausibel()){
				System.out.println("Collatzfolge2 stoppt.");
				System.out.println(" ");
				System.exit(0);
			}
			else{
			 /* System.out.println("Pruefwert-else " + b.plausibel());
			 */
			}
			
			startGl = b.von;
			bisGl = b.bis;
			
			while (startGl <= bisGl){   // Schleife mit startGl und bisGl gesteuert
				neuGl = startGl;
				i = 0; // i == 0 erster Duchlauf der Berechnung einer neuen Folge
	
				while (neuGl > 1){  // Schleifer mit neuGl und altGl gesteuert.
					if (i > 0){
						neuGl = gl.naechstes(altGl);
					}
					System.out.print(neuGl + " ");
					altGl = neuGl;
					i++;
				}
				startGl++;
				System.out.println(" ");
			}
		}
		else{
			System.out.println("Zu viele oder zu wenige Parameter eingegeben ");
			h.ausgeben();
			System.out.println("Collatzfolge2 stoppt.");
			System.out.println(" ");
			System.exit(0);
		}
		System.out.println(" ");
	}
}