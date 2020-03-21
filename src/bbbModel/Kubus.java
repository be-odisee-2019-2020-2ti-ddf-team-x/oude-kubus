package bbbModel;

class Kubus {
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
	}