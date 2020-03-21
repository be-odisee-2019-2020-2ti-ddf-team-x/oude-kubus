package dddModelViewController;

import java.awt.event.*;

import javax.swing.*;

public class Controller implements ActionListener {
	private Kubus model;
	private TekstView view;

	public Controller (Kubus model){
		this.model = model;
		view = new TekstView();
		view.setListener(this);
		model.addObserver(view);
		new KubusApplicatie4(view);
	}

	public void actionPerformed(ActionEvent e) {
		JTextField zijdeVak = (JTextField) e.getSource();
		String s = zijdeVak.getText();
		try {
			double zijde = Double.parseDouble(s);
			model.setZijde(zijde);
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(view, "Invoer "+s+" is geen getal","Fout in invoer",JOptionPane.WARNING_MESSAGE);
		}
	}
}
