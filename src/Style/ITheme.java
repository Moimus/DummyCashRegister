package Style;

import java.awt.Component;
import java.awt.Window.Type;

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

public interface ITheme 
{
	
	public JFrame getJFrame();
	public JPanel getJPanelBackground();
	public JPanel getJPanelForeground();
	public JMenuBar getJMenuBar();
	public JMenu getJMenu(String title);
	public JMenuItem getJMenuItem(String title);
	public JButton getJButton(String title,Boolean roundedCorners);
	public JRadioButton getJRadioButton(String title);
	public JCheckBox getJCheckbox(String title);
	public JSlider getJSlider();
	public JScrollBar getJScrollbar();
	public void init();
	public Component[] getAllComponents();
	public Component[] getComponentsOfType(Class<?> type);
	public JTextArea getJTextArea(String title);
	

}
