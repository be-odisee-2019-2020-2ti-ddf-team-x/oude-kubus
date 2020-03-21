package dd2ModelViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class TekstView extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JTextField zijdeVak, inhoudVak, oppervlakteVak;
	
	public TekstView() {
		super();
		this.createGui();
	}
	
	private void createGui() {
		Box labelBox = Box.createVerticalBox();
		labelBox.add(new JLabel("Zijde"));
		labelBox.add(new JLabel("Inhoud"));
		labelBox.add(new JLabel("Oppervlakte"));

	    zijdeVak = new JTextField( 10 );
	    // zijdeVak.addActionListener(this);  is nu aan de controller
	    inhoudVak = new JTextField( 10 );
	    inhoudVak.setEditable( false );
	    oppervlakteVak = new JTextField( 10 );
	    oppervlakteVak.setEditable( false );
	    
	    Box tekstvakBox = Box.createVerticalBox();
	    tekstvakBox.add( zijdeVak );
	    tekstvakBox.add( inhoudVak );
	    tekstvakBox.add( oppervlakteVak );
	    
	    Box totaalBox = Box.createHorizontalBox();
	    totaalBox.add( labelBox );
	    totaalBox.add( Box.createHorizontalStrut( 20 ) );
	    totaalBox.add( tekstvakBox );

	    setBorder( new EmptyBorder( 20, 20, 20, 20 ) );
	    add( totaalBox );
	}
	
	public void setListener (ActionListener listener){
		zijdeVak.addActionListener(listener);  // hiermee kan de controller zich melden
	}

	/*
	public void update(Observable o, Object arg) {
		Kubus model = (Kubus) o;
		inhoudVak.setText(String.format("%12.2f", model.getInhoud()));
		oppervlakteVak.setText(String.format("%12.2f", model.getOppervlakte()));
	}
	 */

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Kubus model = (Kubus) evt.getNewValue();
		inhoudVak.setText(String.format("%12.2f", model.getInhoud()));
		oppervlakteVak.setText(String.format("%12.2f", model.getOppervlakte()));
	}
}
