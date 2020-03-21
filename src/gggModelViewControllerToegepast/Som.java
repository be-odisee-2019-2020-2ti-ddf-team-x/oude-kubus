package gggModelViewControllerToegepast;

import java.util.Observable;

import javax.swing.JOptionPane;

class Som extends Observable {
	private int number1, number2;
  
  	public Som() {
  		setNumbers(0, 0);
    }

  	public Som(int n1, int n2) {
  		setNumbers(n1,n2);
    }

  	public Som(String n1str, String n2str) {
  		setNumbers(n1str, n2str);
    }

	public int getNumber1(){
		return this.number1;
	}
	
	public int getNumber2(){
		return this.number2;
	}
	
	public void setNumbers(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
		setChanged();
		notifyObservers();
	}

	public void setNumbers(String number1str, String number2str) {
		int n1,n2;
		try {
		    n1=Integer.parseInt(number1str);
		    n2=Integer.parseInt(number2str);
		    setNumbers(n1,n2);
		}
		catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Invoer is geen getal","Fout in invoer",JOptionPane.WARNING_MESSAGE);
		}
	}

	public int getSom(){
		return number1+number2;
	}
}