package content_model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import Util.DbManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class requestCM {

	public DbManager db=null;
	Connection con=null;
	public void raiseRequestCM()
	{
		try
		{
			con=db.createConnection();
			retrieveCountry();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
	public JSONObject retrieveCountry() throws SQLException
	{
		JSONObject data=null;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.COUNTRY");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
				data.put(rs.getString(0), rs.getString(1));
			}
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
				ps.close();
			if(rs!=null)
				rs.close();
			if(con!=null)
				con.close();
		}
		return data;
	}
}
