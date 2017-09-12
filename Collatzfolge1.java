/* Berechnet intern die Glieder von Colartsfolge vom gegebenen minimalem bis  maximalem Startwert
 * 
 * Gibt das Maximum und Anzahl der Folgenglieder bis ein Folgenglied mit Wert 1 erreicht wird.
 * 
 */


public class Collatzfolge1{
	public static void main (String[] args){
		
		int i = 0;
		int altGl = 0;  	// Altes Folgenglied
		int neuGl = 0;    // Neues Folgenglied
		int vonGl = 0;		// Wert des ersten Folgenglieds zum Start der Folge
		int glAnzMax = 0; // Maximaler Anzahl der Folgenglieder, die Berechnet werden sollen
		int rest = 0;			// Hilfsvariable, um gerade von ungeraden Zahlen zu unterscheiden
		
		if (args.length == 0){
		 System.out.println("Keine Eingabe von Parametern erfolgt ");
		 System.out.println("Nutzung: Collatzfolge1 <Startwert> <Anzahl> ");
		 System.out.println("Ausgabe: <Startwert> Folgeglied_2 Folgenglied_3 ... Folgenglied_Anzahl");
		 System.out.println(" ");
		 System.exit(0);
		}
		
		if (args.length == 2){
			
			vonGl = Integer.parseInt(args[0]);
			glAnzMax = Integer.parseInt(args[1]);
			
			
			for (i=0;i<glAnzMax;i++){
				
				if (i == 0){
					// Initialisieren des ersten Glieds mit Startwert
					neuGl = vonGl;
				}
				else{
					rest = altGl % 2;
					if (rest == 0){
						/* System.out.println("Die eingegebene Zahl ist gerade "); */
						neuGl = altGl/2;
					}
					else{
						neuGl = 3 * altGl + 1;
					}	
				}
				System.out.print(neuGl + " ");
				altGl = neuGl;
			}
		}
		else{
		 System.out.println("Zu wenig oder zu viele Parameter eingegeben. ");
		 System.out.println("Nutzung: Collatzfolge1 <Startwert> <Endwert> ");
		 System.out.println("Ausgabe: IndexFolge; Startwert; MaximalerWert; AnzahlBisEins");
		 System.out.println(" ");
		 System.exit(0);
		}
		System.out.println(" ");
	}
}