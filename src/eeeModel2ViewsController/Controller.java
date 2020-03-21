package eeeModel2ViewsController;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener {
	private Kubus model;
	private TekstView tekstView;
	private GrafischeView grafischeView;

	public Controller (Kubus model){
		this.model = model;
		tekstView = new TekstView();
		tekstView.setListener(this);
		model.addObserver(tekstView);
		
	    grafischeView = new GrafischeView();
	    model.addObserver( grafischeView );
	    
	    JPanel view = new JPanel();
	    view.setLayout( new BorderLayout() );
	    view.add( tekstView, BorderLayout.SOUTH );
	    view.add( grafischeView, BorderLayout.CENTER );
		
		new KubusApplicatie5(view);
	}

	public void actionPerformed(ActionEvent e) {
		JTextField zijdeVak = (JTextField) e.getSource();
		String s = zijdeVak.getText();
		try {
			double zijde = Double.parseDouble(s);
			model.setZijde(zijde);
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(tekstView, "Invoer "+s+" is geen getal","Fout in invoer",JOptionPane.WARNING_MESSAGE);
		}
	}
}
