package Mock;

import Models.Article;

public class MockDB 
{
	public static Article[] articles = new Article[]
	{
			new Article("Arizona Diet Green Tea","0613008720728", 1.60f),
			new Article("24h Deodorant Bodyspray","5000228015874", 2.00f),
			new Article("Egg Cheese & Bacon","0051000063816", 2.39f),
			new Article("Tennessee Whiskey","0082184090466", 14.99f),
			new Article("Air Fresh Bathroom","0808829070330", 2.99f),
			new Article("Chips Nacho Cheese","0028400051439", 1.49f),
			new Article("Chocolate Bars","0692991702560", 2.39f)
	};
	
	public static Article getArticleByGTIN(String GTIN)
	{
		Article result = null;
		for(int n = 0; n < articles.length; n++)
		{
			if(articles[n].gtin.equals(GTIN))
			{
				result = articles[n];
			}
		}
		return result;
	}

}
