package gggModelViewControllerToegepast;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TekstView extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;

	private JTextField number1Field, number2Field, sumField;
	private JLabel plusLabel, equalsLabel, uitlegLabel;
	
	public TekstView() {
		super();
		this.createGui();
	}
	
	private void createGui() {
		this.setLayout(new FlowLayout());
		
		number1Field = new JTextField(7);
		number1Field.setText("0");
		this.add(number1Field);
		
		plusLabel = new JLabel(" + ");
		this.add(plusLabel);
		
		number2Field = new JTextField(7);
		number2Field.setText("0");
		this.add(number2Field);
		
		equalsLabel = new JLabel(" = ");
		this.add(equalsLabel);
		
		sumField = new JTextField(7);
		sumField.setEditable(false);
		this.add(sumField);

		uitlegLabel = new JLabel("(ga uit tekstveld nadat u het veranderd hebt)");
		this.add(uitlegLabel);
	}
	
	public void setListener (FocusListener listener){
		number1Field.addFocusListener(listener);  // hiermee kan de controller zich melden
		number2Field.addFocusListener(listener);  // hiermee kan de controller zich melden
	}
	
	public void update(Observable o, Object arg) {
		Som model = (Som) o;
		number1Field.setText(Integer.toString(model.getNumber1()));
		number2Field.setText(Integer.toString(model.getNumber2()));
		sumField.setText(Integer.toString(model.getSom()));
	}
	
	public String getNumber1FieldValue(){
		return number1Field.getText();
	}

	public String getNumber2FieldValue(){
		return number2Field.getText();
	}
}
