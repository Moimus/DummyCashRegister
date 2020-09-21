package ViewModels;

import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;

import Models.MainModel;
import QR.HexColorCode;
import QR.QRGen;
import Views.MainView;
import Views.QRView;

public class QRViewModel extends ViewModel
{
	public String qrContent;
	HexColorCode hexColorCode;
	public BufferedImage qrImage;
	public BufferedImage hexColorImage;
	
	public QRViewModel(String QRContent)
	{
		//this.ChildModel = new MainModel();
		this.qrContent = QRContent;
		this.qrImage = QRGen.generateQRCode(qrContent);
		this.ParentView = new QRView(this);

	}
	
	public QRViewModel(String QRContent, boolean hex)
	{
		//this.ChildModel = new MainModel();
		this.qrContent = QRContent;
		hexColorCode = new HexColorCode(QRContent);
		this.hexColorImage = hexColorCode.codeImage;
		this.qrImage = QRGen.generateQRCode(qrContent);
		this.ParentView = new QRView(this, true);

	}

}
