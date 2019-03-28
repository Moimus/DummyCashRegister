package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Actions.DoneButtonAction;
import Actions.EnterButtonAction;
import Actions.NumButtonAction;
import Style.Dark;
import ViewModels.ViewModel;

public class MainView extends View
{
	Dark dark = new Dark();
	JPanel leftPanel;
	JPanel rightPanel;
	JTextArea codeField;
	JTextArea recipeField;
	JButton[] numPad = new JButton[10];
	
	public MainView(ViewModel child)
	{
		this.ChildViewModel = child;
		this.setLayout(new GridLayout());
		addPanels();
		addTextAreaRight();
		addTextAreaLeft();
		addEnterButton();
		addNumpad();
		addDoneButton();
		this.init(512, 512);
	}
	
	private void addPanels()
	{
		GridBagLayout gridbag = new GridBagLayout();
		
		leftPanel = dark.getJPanelBackground();
		rightPanel = dark.getJPanelForeground();
		leftPanel.setLayout(gridbag);
		rightPanel.setLayout(gridbag);
		this.add(leftPanel);
		this.add(rightPanel);
	}
	
	
	private void addTextAreaRight()
	{
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 0;
		int y = 0;
		con.ipadx = 1;
		con.ipady = 512;
		recipeField = dark.getJTextArea("");
		recipeField.setPreferredSize(new Dimension(250,250));

		con.gridx = x;
		con.gridy = y;
		rightPanel.add(recipeField,con);
		rightPanel.repaint();
	}
	
	private void addTextAreaLeft()
	{
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 1;
		int y = 0;
		con.ipadx = 1;
		con.ipady = 2;
		codeField = dark.getJTextArea("");
		codeField.setPreferredSize(new Dimension(64,64));

		con.gridx = x;
		con.gridy = y;
		leftPanel.add(codeField,con);
		leftPanel.repaint();
	}
	
	private void addNumpad()
	{
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		for(int n = 0; n < 10; n++)
		{
			JButton instance = dark.getJButton(String.valueOf(n), true);
			instance.setPreferredSize(new Dimension(64,64));
			numPad[n] = instance;
		}
		
		int x = 0;
		int y = 1;
		for(int n = 0; n < numPad.length; n++)
		{
			numPad[n].addActionListener(new NumButtonAction(this.ChildViewModel,Integer.parseInt(numPad[n].getText()),codeField));
			if(n == 3 || n == 6)
			{
				y++;
				x = 0;
			}
			else if(n == 9)
			{
				x = 1;
				y++;
			}
			
			
			con.gridx = x;
			con.gridy = y;
			leftPanel.add(numPad[n], con);
			x++;
		}
	}
	
	private void addEnterButton()
	{
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 1;
		int y = 9;
		con.gridx = x;
		con.gridy = y;
		JButton enterBtn = dark.getJButton("Enter", false);
		enterBtn.addActionListener(new EnterButtonAction(this.ChildViewModel,this.codeField,this.recipeField));
		//enterBtn.setPreferredSize(new Dimension(128,64));
		leftPanel.add(enterBtn,con);
	}
	
	private void addDoneButton()
	{
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 1;
		int y = 10;
		con.gridx = x;
		con.gridy = y;
		JButton enterBtn = dark.getJButton("Done", false);
		enterBtn.addActionListener(new DoneButtonAction(this.ChildViewModel));
		//enterBtn.setPreferredSize(new Dimension(128,64));
		leftPanel.add(enterBtn,con);
	}
}
