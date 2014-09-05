package Web;

public class WebUtil {
	
	public static Integer GetIdFromQueryString(String queryString)
	{
		String[] queryStringArray = null;
		String strId = null;
		Integer id = 0;
		
		if (queryString != null && queryString != "")
		{
			queryStringArray = queryString.split("=");
		
			if (queryStringArray.length > 1)		
				strId = queryStringArray[1];
		}
		
		try
		{
			id = Integer.parseInt(strId);
			
			id = id < 0 ? 0 : id;
		}
		catch(NumberFormatException ex)
		{
			id = 0;
		}
		
		return id;
	}

}
