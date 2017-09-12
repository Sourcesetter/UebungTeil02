/* Programm zur Ausgabe der Zeit */


import java.util.*;

public class Zeitausgabe{
	public static void main (String[] args){
		
	Calendar cal = Calendar.getInstance ();
    
  // Die Monate werden mit 0 (= Januar) beginnend gezaehlt!
  // (Die Tage im Monat beginnen dagegen mit 1)

  System.out.println( "Datum: " + cal.get( Calendar.DAY_OF_MONTH ) +
                      "." + (cal.get( Calendar.MONTH ) + 1 ) +
                      "." + cal.get( Calendar.YEAR ) );

  System.out.println( "Uhrzeit: " + cal.get( Calendar.HOUR_OF_DAY ) + ":" +
                      cal.get( Calendar.MINUTE ) + ":" +
                      cal.get( Calendar.SECOND ) + ":" +
                      cal.get( Calendar.MILLISECOND ) );
	}
}
