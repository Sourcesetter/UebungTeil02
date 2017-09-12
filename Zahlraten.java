/* Zahlraten
 * Nach der Eingabe einer Zahl ermittelt das Programm, ob die 
 * eingegebene Zahl mit der initialiserten Zahl uebereinstimmt.
 */

import javax.swing.JOptionPane;

public class Zahlraten{
	public static void main (String[] args){
		
		String eingabe;
		int geraten;
		
		eingabe = JOptionPane.showInputDialog("Raten Sie eine ganze Zahl zwischen 0 und 10 ");
		geraten = Integer.parseInt(eingabe);
		
		/* Bei Interzahlen duerfen keine Hochkomma nach den Caseanweisungen kommen */
		
		switch(geraten){
	  	case 4:
	  	case 5:
	  	case 7:
	  	case 8:
	  		JOptionPane.showMessageDialog(null, geraten + " ist knapp daneben!");
	  		break;
	  	case 6:
	  		JOptionPane.showMessageDialog(null, geraten + " ist der Treffer!");
	  		break;
	  	default:
	  	JOptionPane.showMessageDialog(null, geraten + " ist daneben!");
	  }
	}
}
