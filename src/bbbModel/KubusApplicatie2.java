package bbbModel;

import java.io.*;

class KubusApplicatie2 {
	  public static void main( String[] args ) {
	    BufferedReader toetsenbord = 
	      new BufferedReader(
	        new InputStreamReader( System.in )
	    );

	    System.out.print( "Geef de zijde van de kubus: ");
	    try {
	      String s = toetsenbord.readLine();
	      Kubus kubus = new Kubus( Double.parseDouble( s ) );
	      
	      System.out.println( "Inhoud = " + kubus.getInhoud() );
	      System.out.println( "Oppervlakte = " + kubus.getOppervlakte() );
	    }
	    catch( IOException e ) {
	      System.out.println( "Fout bij lezen van toetsenbord" );
	    }
	    catch( NumberFormatException e ) {
	      System.out.println( "Fout in ingevoerde getal" );
	    }
	  }
	}