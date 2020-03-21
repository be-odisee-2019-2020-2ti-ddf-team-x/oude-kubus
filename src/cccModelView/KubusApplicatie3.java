package cccModelView;

import javax.swing.*;

public class KubusApplicatie3 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public KubusApplicatie3(){
		super();
		Kubus k = new Kubus(0);
		TekstView tekstView = new TekstView(k);
		setTitle("Kubusapplicatie3");
		setSize(360, 180);
		setContentPane(tekstView);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);   
	}

	public static void main(String[] args) {
		new KubusApplicatie3();
	}

}
