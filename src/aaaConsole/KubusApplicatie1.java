package aaaConsole;

import java.io.*;

public class KubusApplicatie1 {

	public static void main(String[] args) {
		BufferedReader toetsenbord = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Geef de zijde van de kubus aub: ");
		try {
			String s = toetsenbord.readLine();
			double zijde = Double.parseDouble(s);
		     double inhoud = zijde * zijde * zijde;
		     System.out.println( "Inhoud = " + inhoud );
		     double oppervlakte = 6 * zijde * zijde;
		     System.out.println( "Oppervlakte = " + oppervlakte );		
		} 
		catch (IOException e){
			System.out.println("Fout bij het inlezen van het toetsenbord");
		}
		catch (NumberFormatException e){
			System.out.println("Fout bij het inlezen van het toetsenbord");
		}
		
	}

}
