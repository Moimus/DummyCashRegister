package QR;

import java.awt.image.BufferedImage;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRGen 
{
	public static BufferedImage generateQRCode(String Content)
	{
		BufferedImage out = null;
		
		try
		{
			QRCodeWriter writer = new QRCodeWriter();
			BitMatrix matrix = writer.encode(Content, BarcodeFormat.QR_CODE, 512, 512);
			out = MatrixToImageWriter.toBufferedImage(matrix);
		}
		catch(Exception e)
		{
			
		}
		
		return out;
	}
}
