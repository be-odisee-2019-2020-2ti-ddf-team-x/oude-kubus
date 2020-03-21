package gggModelViewControllerToegepast;

import java.awt.event.*;

public class Controller implements FocusListener {
	private Som model;
	private TekstView view;

	public Controller (Som model){
		this.model = model;
		view = new TekstView();
		view.setListener(this);
		model.addObserver(view);
		new SumTextFieldsMVC(view);
	}

	public void actionPerformed(ActionEvent e) {
	}

	public void focusGained(FocusEvent e) {
		// do nothing
	}

	public void focusLost(FocusEvent e) {
		model.setNumbers(view.getNumber1FieldValue(),view.getNumber2FieldValue());
	}
}
