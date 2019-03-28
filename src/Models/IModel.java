package Models;
import org.json.simple.JSONObject;;

public interface IModel 
{
	public Boolean Equals(Object other);
	public JSONObject ToJSON();
	public String ToBin();
	public String ToHex();
}
