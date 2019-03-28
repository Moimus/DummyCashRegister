package Style;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.Window.Type;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public abstract class Theme implements ITheme
{
	//Colors
	public Color DarkPrimaryColor;
	public Color LightPrimaryColor;
	public Color PrimaryColor;
	public Color Text_Icons;
	public Color AccentColor;
	public Color PrimaryText;
	public Color SecondaryText;
	public Color DividerColor;
	
	//Fonts
	public Font PrimaryFont;
	
	//Icons
	Icons icons;
	
	//Paths
	public String radioButtonCheckedPath;
	public String radioButtonUnCheckedPath;
	public String checkBoxCheckedPath;
	public String checkBoxUnCheckedPath;
	
	//ComponentLists
	public ArrayList<Component> allComponents = new ArrayList<Component>();
	
	
	@Override
	public void init() 
	{
		UIManager.put("Menu.selectionBackground", this.AccentColor);
		UIManager.put("MenuItem.selectionBackground", this.AccentColor);
		icons = new Icons(this);
	}
	
	/**
	 * Gets a styled JFrame
	 * @return styled JFrame
	 * */	
	@Override
	public JFrame getJFrame() 
	{
		JFrame result = new JFrame();
		
		result.setBackground(DarkPrimaryColor);
		
		return result;
	}
	
	/**
	 * Gets a styled JPanel
	 * @return styled JPanel
	 * */	
	@Override
	public JPanel getJPanelBackground() 
	{
		JPanel result = new JPanel();
		
		result.setBackground(DarkPrimaryColor);
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JPanel
	 * @return styled JPanel
	 * */	
	@Override
	public JPanel getJPanelForeground() 
	{
		JPanel result = new JPanel();
		
		result.setBackground(LightPrimaryColor);
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JMenuBar
	 * @return styled JMenuBar
	 * */	
	@Override
	public JMenuBar getJMenuBar() 
	{
		JMenuBar result = new JMenuBar();
		
		result.setBackground(LightPrimaryColor);
		result.setBorder(BorderFactory.createEmptyBorder());
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JMenu
	 * @param title displayed text
	 * @return styled JMenu
	 * */
	@Override
	public JMenu getJMenu(String title) 
	{
		JMenu result = new JMenu();
		
		//Color
		result.setForeground(PrimaryText);
		
		//Text
		result.setFont(PrimaryFont);
		result.setText(title);
		
		//Layout
		result.setBorder(BorderFactory.createEmptyBorder());
		result.getPopupMenu().setBorder(null);
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JMenuItem
	 * @param title displayed text
	 * @return styled JMenuItem
	 * */
	@Override
	public JMenuItem getJMenuItem(String title) 
	{
		JMenuItem result = new JMenuItem() 
		{
			@Override
			protected void paintBorder(Graphics g) 
			{

			}
			

		};
		
		
		//Color
		result.setForeground(PrimaryText);
		result.setBackground(LightPrimaryColor);
		
		//Text
		result.setFont(PrimaryFont);
		result.setText(title);
		
		//Layout
		result.setBorder(BorderFactory.createEmptyBorder());
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JMenuItem
	 * @param text displayed text
	 * @return styled JMenuItem
	 * */
	@Override
	public JTextArea getJTextArea(String text) 
	{
		JTextArea result = new JTextArea() 
		{
			@Override
			protected void paintBorder(Graphics g) 
			{

			}
			

		};
		
		//Color
		result.setForeground(PrimaryText);
		result.setBackground(LightPrimaryColor);
		
		//Text
		result.setFont(PrimaryFont);
		result.setText(text);
		result.setLineWrap(true);
		result.setWrapStyleWord(true);
		
		//Layout
		result.setBorder(BorderFactory.createEmptyBorder());
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JButton
	 * @param title displayed text
	 * @param roundedCorners true sets Buttons corners to rounded
	 * @return styled JButton
	 * */
	@Override
	public JButton getJButton(String title, Boolean roundedCorners)
	{
		JButton result = new JButton(title);
		
		//result.setBorder(BorderFactory.createEmptyBorder());
		result.setFont(PrimaryFont);
		result.setBackground(LightPrimaryColor);
		result.addFocusListener(new FocusListener() 
		{
			
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				result.setBackground(LightPrimaryColor);
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) 
			{
				result.setBackground(LightPrimaryColor);
				
			}
			
		});
		result.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				result.setBackground(AccentColor);
				super.mouseEntered(e);
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				result.setBackground(LightPrimaryColor);
				super.mouseExited(e);
			}
		});
		result.setBorderPainted(false);
		result.setForeground(PrimaryText);
		result.setFocusPainted(false);
		allComponents.add(result);
		
		return result;
	}
	
	/**
	 * Gets a styled JRadioButton
	 * @param title displayed text
	 * @return styled JRadioButton
	 * */
	@Override
	public JRadioButton getJRadioButton(String title) 
	{
		JRadioButton result = new JRadioButton(title);
		result.setBorder(BorderFactory.createEmptyBorder());
		result.setFocusPainted(false);
		result.setFont(PrimaryFont);
		result.setForeground(PrimaryText);
		result.setOpaque(false);
		result.setIcon(this.icons.radioButtonUnchecked);
		result.setSelectedIcon(this.icons.radioButtonChecked);
		
		return result;
	}
	
	/**
	 * Gets a styled JCheckbox
	 * @param title displayed text
	 * @return styled JCheckbox
	 * */
	@Override
	public JCheckBox getJCheckbox(String title) 
	{
		JCheckBox result = new JCheckBox(title);
		result.setBorder(BorderFactory.createEmptyBorder());
		result.setFocusPainted(false);
		result.setFont(PrimaryFont);
		result.setForeground(PrimaryText);
		result.setOpaque(false);
		result.setIcon(this.icons.checkBoxUnchecked);
		result.setSelectedIcon(this.icons.checkBoxChecked);
		return result;
	}
	
	
	//TODO
	@Override
	public JSlider getJSlider() 
	{
		JSlider result = new JSlider();
		result.setOpaque(false);
		
		return result;
	}
	
	//TODO
	@Override
	public JScrollBar getJScrollbar() 
	{

		return null;
	}
	
	/**
	 * Gets all components 
	 * NOTE: Doesn't work on JMenuItems
	 * 
	 * @return Array containing result
	 * */	
	@Override
	public Component[] getAllComponents() 
	{
		Component[] result = new Component[allComponents.size()];
		for(int n = 0; n < allComponents.size(); n++)
		{
			result[n] = allComponents.get(n);
		}
		
		return result;
	}
	
	/**
	 * Gets all components matching the parameters type 
	 * NOTE: Doesn't work on JMenuItems
	 * 
	 * @param type Class extending java.awt.Component
	 * @return Array containing filtered result
	 * */
	@Override //TODO doesn't work on JMenuItems
	public Component[] getComponentsOfType(Class<?> type) 
	{
		Component[] arr = getAllComponents();
		ArrayList<Component> filteredList = new ArrayList<Component>();
		for (Component comp : arr) 
		{
			if(comp.getClass() == type)
			{
				filteredList.add(comp);
			}
		}
		
		Component[] result = new Component[filteredList.size()];
		for(int n = 0; n < filteredList.size(); n++)
		{
			result[n] = filteredList.get(n);
		}
		
		return result;
	}
}
