package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import ViewModels.ViewModel;

public class NumButtonAction implements ActionListener
{
	ViewModel parent;
	int val = -1;
	JTextArea out;
	
	public NumButtonAction(ViewModel associatedViewModel, int value, JTextArea output)
	{
		val = value;
		out = output;
		parent = associatedViewModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		out.append(String.valueOf(val));
		System.out.println(this.getClass().getName() + " Action performed, val = " + val + "!");
		
	}

}
