package HTTP;

import Mock.MockDB;
import Models.Article;

public class HTTP 
{
	
	public static Article getArticle(String GTIN)
	{
		Article result = null;
		//TODO hook up 2 real db
		result = MockDB.getArticleByGTIN(GTIN);
		
		return result;
		
	}

}
