package dddModelViewController;

import java.util.Observable;

 /**
 * De Kubus klasse modelleert een real world kubus
 * 
 * @author Hans Vandenbogaerde
 * 
 */
public class Kubus extends Observable {
	  /**
	 * de lengte van de zijde van de kubus
	 */
	private double zijde;
	  
	  /**
	 * @param zijde de lengte van de zijde van de kubus
	 */
	public Kubus( double zijde ) {
	    this.zijde = zijde;
	  }
	  
	  /**
	 * berekent de inhoud van de kubus
	 * 
	 * @return de inhoud van de kubus
	 */
	public double getInhoud() {
	    return zijde * zijde * zijde;
	  }
	  
	  public double getOppervlakte() {
	    return 6 * zijde * zijde;
	  }

	  public void setZijde(double z) {
			this.zijde=z;
			setChanged();
			notifyObservers();
	  }
	}