package Models;

import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Lex.Tax;

public class Receipt extends Model
{
	public String ID;
	public String issuer;
	public Date issueDate;
	public Article[] articles;
	public float taxRate;
	public float priceGross;
	public float priceNet;
	
	public Receipt(String ID, String Issuer, Article[] Articles)
	{
		this.ID = ID;
		this.issuer = Issuer;
		this.issueDate = new Date();
		this.articles = Articles;
		taxRate = Tax.taxRate;
		this.calcGrossSum();
		this.calcNetSum();
		
	}
	
	private void calcGrossSum()
	{
		//TODO
		float sum = 0f;
		
		for(int n = 0; n < this.articles.length; n++)
		{
			sum += this.articles[n].price;
		}
		
		this.priceGross = sum;
		
	}
	
	private void calcNetSum()
	{
		//TODO
		float sum = 0f;
		sum = this.priceGross * this.taxRate;
		this.priceNet = sum;
	}

	@Override
	public Boolean Equals(Object other) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject ToJSON() 
	{
		JSONObject json = new JSONObject();
		json.put("ID", this.ID);
		json.put("Issuer", this.issuer);
		json.put("IssueDate", this.issueDate);
		JSONArray articlesArr = new JSONArray();
		for(int n = 0; n < this.articles.length; n++)
		{
			articlesArr.add(this.articles[n].ToJSON());
		}
		json.put("Articles",articlesArr);
		return json;
	}

	@Override
	public String ToHex() 
	{
		String binString ="";
		String JSONString = this.ToJSON().toJSONString();
		byte[] bytes = JSONString.getBytes();
		char[] chars = JSONString.toCharArray();
		StringBuilder hexStringBuilder = new StringBuilder();
		for(int n = 0; n < chars.length; n++)
		{
			hexStringBuilder.append(Integer.toHexString(chars[n]));
		}
		
		System.out.println(hexStringBuilder.toString());
		for(int n = 0; n < bytes.length; n++)
		{
			//Integer.toHexString(Integer.)
		}
		
		return null;
	}

	@Override
	public String ToBin() {
		// TODO Auto-generated method stub
		return null;
	}

}
