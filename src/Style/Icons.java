package Style;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Icons 
{
	public ImageIcon radioButtonChecked;
	public ImageIcon radioButtonUnchecked;
	public ImageIcon checkBoxChecked;
	public ImageIcon checkBoxUnchecked;
	
	public Icons(Theme theme)
	{
		try
		{
			radioButtonChecked = new ImageIcon(scaleImage(theme.radioButtonCheckedPath,24,24));
			radioButtonUnchecked = new ImageIcon(scaleImage(theme.radioButtonUnCheckedPath,24,24));
			checkBoxChecked = new ImageIcon(scaleImage(theme.checkBoxCheckedPath,24,24));
			checkBoxUnchecked = new ImageIcon(scaleImage(theme.checkBoxUnCheckedPath,24,24));
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}

	}
	
	private Image scaleImage(String path, int scaleX, int scaleY)
	{
		Image result = null;
		BufferedImage bufferedImage;

		try 
		{
			bufferedImage = ImageIO.read(new File(path));
			
			result = bufferedImage;

			result = result.getScaledInstance(scaleX, scaleY, BufferedImage.SCALE_SMOOTH);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}

}
