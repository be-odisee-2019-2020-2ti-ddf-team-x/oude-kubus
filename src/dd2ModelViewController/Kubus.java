package dd2ModelViewController;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
* De Kubus klasse modelleert een real world kubus
*
* @author Hans Vandenbogaerde
*
*/
// java.util.Observable is deprecated sinds Java 9
// werk via java.beans.PropertyChangeSupport-object
// public class Kubus extends Observable {
public class Kubus {

    /**
     * het PropertyChangeSupport-object dat de observers zal beheren
     */
    private PropertyChangeSupport propertyChangeSupport;

    private double zijde;

    /**
    * @param zijde de lengte van de zijde van de kubus
    */
    public Kubus( double zijde ) {
        this.zijde = zijde;
        this.propertyChangeSupport = new PropertyChangeSupport(this);  // init
    }

    /**
     * Voeg een propertyChangeListenr toe aan de propertyChangeSupport
     * @param propertyChangeListener die toe te voegen is
     */
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener){
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
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
       // we hebben enkel interesse in de nieuwe kubus straks, dus oldValue = null is aanvaardbaar
       propertyChangeSupport.firePropertyChange("kubus", null, this); // gewijzigd
     }
   }