package fffModel2Views2xControlled;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

class Controller extends MouseAdapter 
implements ActionListener, MouseMotionListener {
private Kubus model;
private TekstView tekstView;
private GrafischeView grafischeView;
private JFrame frame;

private boolean opZijde;
private int startX, startY, startZijde;

public Controller( Kubus model ) {
	this.model = model;
	tekstView = new TekstView();
	tekstView.setListener( this );
	model.addObserver( tekstView );
	
	grafischeView = new GrafischeView();
	grafischeView.addMouseListener( this );
	grafischeView.addMouseMotionListener( this );
	model.addObserver( grafischeView );
	
	JPanel view = new JPanel();
	view.setLayout( new BorderLayout() );
	
	view.add( tekstView, BorderLayout.SOUTH );
	view.add( grafischeView, BorderLayout.CENTER );
	frame = new KubusApplicatie6( view );
}

public void actionPerformed( ActionEvent e ) {
	JTextField zijdeVak = (JTextField) e.getSource();
	String s = zijdeVak.getText();
	try {
	double zijde = Double.parseDouble( s );
	model.setZijde( zijde );
	}   
	catch( NumberFormatException ex ) {
	JOptionPane.showMessageDialog(
	frame, "Invoer " + s + " is geen getal",
	"Fout in invoer", JOptionPane.WARNING_MESSAGE );
	}
}

public void mousePressed( MouseEvent e ) {
	startZijde = (int) model.getZijde();
	int rechts = ( grafischeView.getWidth() + startZijde ) / 2;
	int boven = ( grafischeView.getHeight() - startZijde ) / 2;
	startX = e.getX();
	startY = e.getY();
	
	opZijde = isOpZijde( startX, startY, rechts, boven );
}

public void mouseReleased( MouseEvent e ) {
	opZijde = false;
}

public void mouseDragged( MouseEvent e ) {
	if( opZijde ) {
	int dX = e.getX() - startX;
	int nieuweZijde = startZijde + dX;
	if( nieuweZijde > 0 )
	model.setZijde( nieuweZijde );
	}
}

private boolean isOpZijde( int x, int y, int rechts, int boven ) {
	return x >= rechts - 3 && x <= rechts + 3 &&
	y >= boven && y <= boven + model.getZijde();
}

// niet gebruike methode uit MouseMotionListener
public void mouseMoved( MouseEvent e ) {}
}
