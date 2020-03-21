package eeeModel2ViewsController;

import java.awt.*;
import java.util.*;
import javax.swing.*;

class GrafischeView extends JPanel implements Observer {

	// Uitleg over deze werkwijze: http://java.sun.com/products/jfc/tsc/articles/painting/ (en Laan)
	
	private static final long serialVersionUID = 1L;
	private int zijde;
	  
	  public void paintComponent( Graphics g ) {
	    super.paintComponent( g );
	    if ( zijde > 0) 
	      tekenKubus( g );
	  }
	  
	  private void tekenKubus( Graphics g ) {
	    int links = (int)( getWidth() - zijde ) / 2;
	    int boven = (int)( getHeight() - zijde ) / 2;
	    // voorkant kubus
	    g.drawRect( links, boven, zijde, zijde );
	    // achterkant kubus
	    g.setColor( Color.LIGHT_GRAY );
	    int deltaX = zijde / 2;
	    int deltaY = zijde / 4;
	    g.drawRect( links + deltaX, boven - deltaY, zijde, zijde );
	    // schuine lijnen
	    g.drawLine( links, boven, links + deltaX, boven - deltaY );
	    g.drawLine( links + zijde, boven, links + zijde + deltaX, boven - deltaY );
	    g.drawLine( links, boven + zijde, links + deltaX, boven + zijde - deltaY );
	    g.drawLine( links + zijde, boven + zijde, links + zijde + deltaX, boven + zijde - deltaY );
	  }

	  public void update( Observable o, Object arg ) {
	    Kubus model = (Kubus) o;
	    zijde =  (int)model.getZijde();
	    repaint();
	  }
	}