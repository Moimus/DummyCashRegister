package QR;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

public class HexColorCode 
{
	public ArrayList<Color> colorCode;
	public BufferedImage codeImage;
	
	public HexColorCode(String HexColorString)
	{
		colorCode = encodeHexString(HexColorString);
		codeImage = toBufferedImage(colorCode);
	}
	
	//TODO Add code padding
	private ArrayList<Color> encodeHexString(String in)
	{
		ArrayList<String> HexChunks = new ArrayList<String>();
		ArrayList<Color> colorCode = new ArrayList<Color>();
		int pointer = 0;
		String chunk = "";
		while(pointer < in.length())
		{

			try
			{
				chunk = in.substring(pointer, pointer + 3);
				char[] chunkChars = chunk.toCharArray();
				StringBuilder sb = new StringBuilder();
				for(int n = 0; n < chunkChars.length; n++)
				{
					sb.append(Integer.toHexString(chunkChars[n]));
				}
				HexChunks.add(sb.toString());
				//System.out.println("encoding to hex -> " + chunk);
				pointer += 3;
			}
			catch(Exception e)
			{
				//System.out.println("encoding to hex -> shit happened");
				e.printStackTrace();
				chunk = null;
				break;
			}

		}
		
		for(int n = 0; n < HexChunks.size(); n++)
		{
			colorCode.add(Color.decode("#" + HexChunks.get(n)));
		}
		
		return colorCode;
		
	}
	
	private BufferedImage toBufferedImage(ArrayList<Color> colorList)
	{
		int pixelSize = 8;
		int imageSize = 500;
		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_ARGB);
		int x = 0;
		int y = 0;
		
		int lineCounter = 0;
		for(int n = 0; n < colorList.size(); n++)
		{
			if (x != 20 * pixelSize) 
			{
				for(int i = 0; i < pixelSize; i++)
				{
					for(int j = 0; j < pixelSize; j++)
					{
						image.setRGB(x + i, y + j, colorList.get(n).getRGB());
					}
				}
				x += pixelSize;
			}
			else
			{
				for(int i = 0; i < pixelSize; i++)
				{
					for(int j = 0; j < pixelSize; j++)
					{
						image.setRGB(x + i, y + j, colorList.get(n).getRGB());
					}
				}
				y += pixelSize;
				x = 0;
			}
		}
		
		return image;
	}
}
