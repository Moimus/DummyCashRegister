package ViewModels;

import java.util.ArrayList;

import Models.Article;
import Models.MainModel;
import Style.Dark;
import Views.MainView;

public class MainViewModel extends ViewModel
{
	public ArrayList<Article> articles = new ArrayList<Article>();
	
	
	public MainViewModel()
	{
		this.ChildModel = new MainModel();
		this.ParentView = new MainView(this);
		Dark theme = new Dark();	
	}

}
