package Style;
import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class Dark extends Theme
{
	public Dark()
	{

		this.DarkPrimaryColor = new Color(32, 37, 41);
		this.LightPrimaryColor = new Color(50, 56, 61);
		this.AccentColor = new Color(42,203,185);
		this.PrimaryText = new Color(220,220,220);
		this.PrimaryFont = new Font("Consolas", Font.PLAIN, 16);
		this.radioButtonCheckedPath = "src/Themes/Dark/Icons/Radiobutton_checked.png";
		this.radioButtonUnCheckedPath = "src/Themes/Dark/Icons/Radiobutton_unchecked.png";
		this.checkBoxCheckedPath = "src/Themes/Dark/Icons/CheckBox_checked.png";
		this.checkBoxUnCheckedPath = "src/Themes/Dark/Icons/CheckBox_unchecked.png";
		init();		
		
	}
}
