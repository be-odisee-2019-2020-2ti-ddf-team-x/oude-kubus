package gggModelViewControllerToegepast;

import javax.swing.*;

public class SumTextFieldsMVC extends JFrame {
	
	static final long serialVersionUID=20080721;

	public SumTextFieldsMVC(JPanel view){
		super();
		setTitle("Som");
		setSize(360, 100);
		setContentPane(view);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);   
	}
	
	public static void main(String[] args) {
		Som model = new Som();  // het model is gegeven
		new Controller(model); // de controller moet de views creëren, inclusief de omvattende frame
	}
}
