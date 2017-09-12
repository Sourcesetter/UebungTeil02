package Nuesse;
/* 5 Schiffbruechige sitzen auf einer Insel mit einem Haufen Nuesse
 * Der erste wacht morgens auf teilt die Nuesse in 5 Teile, stellt fest
 * dass eine Nuss zu viel ist. Wirft die eine Nuss ins Meer nimmt seinen
 * Teil und erkundet die Insel.
 * Der Zweite wacht auf, teilt die Nuesse in 5 Teile ...
 * Dies bis zum Fuenften.
 * Wie viele Nuesse muessen minimal vorhanden gewesen sein, das
 * dieses Verfahren moeglich gewesen ist?
 * 
 * 
 */

import java.util.*;

class Hilfetext{
	void ausgeben(){
		System.out.println("Nutzung: Nuss  <BisStartwert> ");
		System.out.println("Ausgabe: ");
		System.out.println("Anzahl Nuesse fuer 5 Schiffbruechige, ... ");
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

class Nussstapel{
	/* Klasse zum Berechnen , ob die Groesse des Nussstapels 
	 * ausreichend ist.
	*/
	boolean reichtF5(int anzNuesse){
		int alt;   // Variable 
		int i;     // Variable 
		int neu = anzNuesse;
		for(i=0;i<5;i++){
			alt = neu;
			if(alt%5.0 == 1){
				neu = (alt-1)/5;	
			}
			else{
				return(false);
			}
		}
		return(true);
	}
}



public class Nuss{
	public static void main (String[] args){
		
	
		Calendar cal = Calendar.getInstance ();
		Calendar calE = Calendar.getInstance ();
		
		
		/* Variablen zum Erzeugen einer Reihe */
		/* Variablen zum Abarbeiten aller Reihen */		
		int startGl = 0;	// Wert des ersten Folgenglieds zum Start der Folge
		int bisGl = 0;  	// Maximaler Wert des ersten Folgenglieds bis zu dem die Berechnung 
		                  // laufen soll
		Hilfetext h = new Hilfetext();
		Bereich b = new Bereich();
		Nussstapel gl = new Nussstapel();
		
		
		if (args.length == 0){
		 System.out.println("Keine Eingabe von Parametern erfolgt. ");
		 h.ausgeben();
		 System.exit(0);
		}
		
		if (args.length == 1){
			  // Die Monate werden mit 0 (= Januar) beginnend gezaehlt!
  			// (Die Tage im Monat beginnen dagegen mit 1)

  			System.out.println( "Datum: " + cal.get( Calendar.DAY_OF_MONTH ) +
                      "." + (cal.get( Calendar.MONTH ) + 1 ) +
                      "." + cal.get( Calendar.YEAR ) );

  			  System.out.println( "Uhrzeit-Start: " + cal.get( Calendar.HOUR_OF_DAY ) + ":" +
                      cal.get( Calendar.MINUTE ) + ":" +
                      cal.get( Calendar.SECOND ) + ":" +
                      cal.get( Calendar.MILLISECOND ) );
			
			
			
			
			b.von = 6;
			b.bis = Integer.parseInt(args[0]);
			
			
			if (!b.plausibel()){
				System.out.println("Nuss stoppt.");
				System.out.println(" ");
				System.exit(0);
			}
			
			startGl = b.von;
			bisGl = b.bis;
			System.out.println("Anz1");
			while (startGl <= bisGl){   // Schleife mit startGl und bisGl gesteuert
				if(gl.reichtF5(startGl)){
					System.out.print(startGl + " ");
				}
				startGl+=5;
			}
		}
		else{
			System.out.println("Zu viele oder zu wenige Parameter eingegeben ");
			h.ausgeben();
			System.out.println("Nuss stoppt.");
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