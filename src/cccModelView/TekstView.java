package cccModelView;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TekstView extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Kubus theKubus;
	private JTextField zijdeVak, inhoudVak, oppervlakteVak;
	
	public TekstView(Kubus theKubus) {
		super();
		this.theKubus = theKubus;
		this.createGui();
	}
	
	private void createGui() {
		Box labelBox = Box.createVerticalBox();
		labelBox.add(new JLabel("Zijde"));
		labelBox.add(new JLabel("Inhoud"));
		labelBox.add(new JLabel("Oppervlakte"));

	    zijdeVak = new JTextField( 10 );
	    zijdeVak.addActionListener(this);
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
	
	public void actionPerformed(ActionEvent e) {
		String s = zijdeVak.getText();
		try {
			double zijde = Double.parseDouble(s);
			theKubus.setZijde(zijde);
			inhoudVak.setText(String.format("%12.2f", theKubus.getInhoud()));
			oppervlakteVak.setText(String.format("%12.2f", theKubus.getOppervlakte()));
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(this, "Invoer "+s+" is geen getal","Fout in invoer",JOptionPane.WARNING_MESSAGE);
		}
	}
}
