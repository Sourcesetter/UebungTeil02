/* Berechnet den ein Zahlendreieck bis zur eingegebenen Zahl
 * Die Eingabe erfolgt ueber die Kommandozeile
 */


public class Zahlendreieck{
	public static void main (String[] args){
		int i = 0;
		int j = 0;
		int counter = 0;
		int iHigh = 0;
		if (args.length == 0){
		 System.out.println("Keine Eingabe von Parametern erfolgt ");
		 System.out.println("Nutzung: Zahlendreieck <Zahl> ");
		 System.out.println(" ");
		 System.exit(0);
		}
		if (args.length == 1){
			iHigh = Integer.parseInt(args[0]);
			
			for(i=0; i <= iHigh; i++){
				counter=0;
				for(j=0; j <= i; j++){
					System.out.print(counter + " ");
					counter++;
				}
				System.out.println();
			}
		}
		else{
			System.out.println("Zu viele Parameter eingegeben ");
		 	System.out.println("Nutzung: Zahlendreieck <Zahl> ");
		  System.out.println(" ");
		 	System.exit(0);
		}
	}
}