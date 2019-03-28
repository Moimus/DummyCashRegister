package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import HTTP.HTTP;
import Models.Article;
import ViewModels.MainViewModel;
import ViewModels.ViewModel;

public class EnterButtonAction implements ActionListener
{
	ViewModel parent;
	JTextArea in;
	JTextArea out;
	
	public EnterButtonAction(ViewModel associatedViewModel, JTextArea source, JTextArea output)
	{
		in = source;
		out = output;
		parent = associatedViewModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		//TODO Article search in DB
		Article gtin2Article = HTTP.getArticle(in.getText());
		out.append("\n" + gtin2Article.name + "--" + gtin2Article.price);
		in.setText("");
		((MainViewModel)parent).articles.add(gtin2Article);
	}

}
