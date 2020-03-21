package eeeModel2ViewsController;

import java.util.Observable;

class Kubus extends Observable {
	  private double zijde;
	  
	  public Kubus( double zijde ) {
	    this.zijde = zijde;
	  }
	  
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
	  
	  public double getZijde(){
		  return zijde;
	  }
	}