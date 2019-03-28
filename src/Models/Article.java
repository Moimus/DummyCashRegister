package Models;

import org.json.simple.JSONObject;

public class Article extends Model
{
	public String name;
	public String gtin;
	public float price;
	public int count = 1;
	
	public Article(String Name, String GTIN, float Price)
	{
		name = Name;
		gtin = GTIN;
		price = Price;
	}

	@Override
	public Boolean Equals(Object other) 
	{
		Boolean isEqual = false;
		if(this.getClass().equals(other.getClass()))
		{
			Article otherArticle = (Article)other;
			if(this.name.equals(otherArticle.name) && this.gtin.equals(otherArticle.gtin) && this.price == otherArticle.price)
			{
				isEqual = true;
			}
		}
		return isEqual;
	}

	@Override
	public JSONObject ToJSON() 
	{
		JSONObject json = new JSONObject();
		json.put("Name", this.name);
		json.put("GTIN", this.gtin);
		json.put("Price", this.price);
		json.put("Count", this.count);
		return json;
	}

	@Override
	public String ToBin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ToHex() {
		// TODO Auto-generated method stub
		return null;
	}
}
