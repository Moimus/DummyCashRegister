package Views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import QR.HexColorCode;
import Style.Dark;
import ViewModels.QRViewModel;
import ViewModels.ViewModel;

public class QRView extends View
{
	JPanel qrPanel;
	Dark dark = new Dark();
	
	public QRView(ViewModel child)
	{
		this.ChildViewModel = child;
		this.setLayout(new GridLayout());
		addPanels();
		addQRCode(((QRViewModel)this.ChildViewModel).qrImage);
		this.init(512, 512);
	}
	
	public QRView(ViewModel child, boolean hex)
	{
		this.ChildViewModel = child;
		this.setLayout(new GridLayout());
		addPanels();
		addHexColorCode();
		this.init(512, 512);
	}
	
	private void addPanels()
	{
		GridBagLayout gridbag = new GridBagLayout();
		qrPanel = dark.getJPanelBackground();
		qrPanel.setLayout(gridbag);
		this.add(qrPanel);
	}
	
	private void addQRCode(BufferedImage QRCode)
	{
		ImageIcon qr = new ImageIcon(QRCode);
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 0;
		int y = 0;
		con.gridx = x;
		con.gridy = y;
		this.qrPanel.add(new JLabel(qr), con);
	}
	
	private void addHexColorCode() 
	{
		ImageIcon hex = new ImageIcon(((QRViewModel)this.ChildViewModel).hexColorImage);
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		int x = 0;
		int y = 0;
		con.gridx = x;
		con.gridy = y;
		this.qrPanel.add(new JLabel(hex), con);
	}
	

}
