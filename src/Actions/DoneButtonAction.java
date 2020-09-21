package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import HTTP.HTTP;
import Models.Article;
import Models.Receipt;
import QR.HexColorCode;
import ViewModels.MainViewModel;
import ViewModels.QRViewModel;
import ViewModels.ViewModel;
import Views.QRView;

public class DoneButtonAction implements ActionListener
{
	ViewModel parent;
	JTextArea in;
	JTextArea out;
	
	public DoneButtonAction(ViewModel associatedViewModel)
	{
		parent = associatedViewModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		//TODO Add USer constants to reciept
		MainViewModel par = (MainViewModel)parent;
		Article[] art = par.articles.toArray(new Article[par.articles.size()]);
		Receipt rec = new Receipt("-1","Mr Normie" , art);
		
		for(int n = 0; n < rec.articles.length; n++)
		{
			System.out.println(rec.articles[n].name);		
		}
		System.out.println(rec.priceGross);
		System.out.println(rec.priceNet);
		System.out.println(rec.ToJSON().toJSONString());
		//rec.ToHex();
		QRViewModel qrView = new QRViewModel(rec.ToJSON().toJSONString()); //TODO

	}

}