package dd2ModelViewController;

import javax.swing.*;

public class KubusApplicatie4 extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public KubusApplicatie4(JPanel view){
		super();
		setTitle("Kubusapplicatie4");
		setSize(360, 180);
		setContentPane(view);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);   
	}

	public static void main(String[] args) {
		Kubus model = new Kubus(0);  // het model is gegeven
		new Controller(model); // de controller moet de views creëren, inclusief de omvattende frame
	}

}
