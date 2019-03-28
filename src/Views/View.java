package Views;

import java.awt.Component;

import javax.swing.JFrame;

import ViewModels.ViewModel;

public abstract class View extends JFrame
{
	public ViewModel ChildViewModel;
	
	protected void init(int sizeX, int sizeY)
	{
		System.out.println(this.getClass().getName() + " init!");
		this.setVisible(true);
		this.pack();
		this.setSize(sizeX, sizeY);
	}

}
