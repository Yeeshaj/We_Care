package content_model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Util.DbManager;
import org.json.JSONArray;
import org.json.JSONObject;

import Beans.ApproveList;
import Beans.Organization;
import Beans.ViewStatus;

import java.sql.Blob;
import java.sql.Connection.*;
public class requestCM {

	public DbManager db=null;
	java.sql.Connection con=null;
	
	public boolean raiseRequestCM(String countryId,String stateId,String cityId,String ngo,String area,String description)
	{
		boolean status=true;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			int counter=0;
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("INSERT into TABLES.TRANSACTION values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps= con.prepareStatement(str.toString());
			
			 LocalDate date = LocalDate.now();
			
			
		long id=getMaxValue("TRANSACTION");
			ps.setLong(++counter, ++id);
			ps.setInt(++counter, 9);//raised_by bigint(10),
			ps.setString(++counter, String.valueOf(date));//created_at DATETIME,
			ps.setString(++counter, null);//updated_at DATETIME,
			ps.setString(++counter, null);//	updated_by bigint(10),
			ps.setString(++counter, "Open");//status varchar(10),
			ps.setInt(++counter, 0);//rowstate bigint(10),
			ps.setString(++counter,"fakepath" );//photo blob,
			ps.setString(++counter, description);//description varchar(100),
			ps.setInt(++counter, Integer.parseInt(cityId));//city bigint(10),
			ps.setInt(++counter, Integer.parseInt(stateId));//state bigint(10),
			ps.setInt(++counter, Integer.parseInt(countryId));//ccountry bigint(10),
			ps.setString(++counter, area);//area  varchar(100)
			ps.setString(++counter, ngo);//ngo
			ps.setLong(++counter, 0);//ngo
			System.out.println("Raise request"+ps);
			ps.execute();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				db.closeConnection();
		}
		return status;
	}
	public long getMaxValue(String tablename) throws SQLException
	{
		long data = 0;
		
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT max(transaction_id) as ID FROM TABLES.TRANSACTION");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				
				data=rs.getLong("ID");
				
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
				db.closeConnection();
		}
		return data;
	}
	public HashMap<Integer,String> retrieveCountry() throws SQLException
	{
		HashMap<Integer,String> data=null;
	
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.COUNTRY");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			data=new HashMap<>();
			while(rs.next())
			{
				
				data.put(Integer.parseInt(rs.getString("CountryId")), rs.getString("County"));
				
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
				db.closeConnection();
		}
		return data;
	}
	public JSONArray retrieveState(String countryId) throws SQLException
	{
		//JSONArray data=null;
		JSONArray  data=null;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.COUNTRYSTATE WHERE countryId="+countryId);
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			//data=new JSONArray();
			data=new JSONArray();
			while(rs.next())
			{
				String id=rs.getString("stateId");
				String name=rs.getString("State");
			//data.optString(id, name);
				data.put(id+"@"+name);
				
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
				db.closeConnection();
		}
		return data;
	}
	
	public JSONArray retrieveCity(String stateId) throws SQLException
	{
		//JSONArray data=null;
		JSONArray  data=null;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.STATECITY WHERE stateId="+stateId);
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			//data=new JSONArray();
			data=new JSONArray();
			while(rs.next())
			{
				String id=rs.getString("cityId");
				String name=rs.getString("City");
			//data.optString(id, name);
				data.put(id+"@"+name);
				
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
				db.closeConnection();
		}
		return data;
	}
	public JSONArray populateNGO(String countryId,String stateId,String cityId) throws SQLException
	{
		//JSONArray data=null;
		JSONArray  data=null;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.ORGANIZATION WHERE state="+stateId+" and city="+cityId+" and country="+countryId);
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			//data=new JSONArray();
			data=new JSONArray();
			while(rs.next())
			{
				String id=rs.getString("org_id");
				String name=rs.getString("org_name");
			//data.optString(id, name);
				data.put(id+"@"+name);
				
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
				db.closeConnection();
		}
		return data;
	}
	
	public ArrayList<ViewStatus> retrieveViewStatusList() throws SQLException
	{
		//JSONArray data=null;
		 ArrayList<ViewStatus>  data=null;
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.TRANSACTION t JOIN TABLES.organization o ON t.NGO=o.org_id   WHERE raised_by=9");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			//data=new JSONArray();
			data= new ArrayList<>();
			while(rs.next())
			{
				//, raised_by, created_at, updated_at, updated_by, status, rowstate, photo, description, city, state, country, area
				ViewStatus viewstatus=new ViewStatus();
				viewstatus.setTransaction_id(rs.getString("transaction_id"));
				viewstatus.setDescription(rs.getString("description"));
				viewstatus.setNGO(rs.getString("org_name"));
				viewstatus.setStatus(rs.getString("status"));
				data.add(viewstatus);
				
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
				db.closeConnection();
		}
		return data;
	}
	public ArrayList<String> login(String id,String password) throws SQLException
	{
		ArrayList<String> status=new ArrayList<String>();
		
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.USER_DETAILS  WHERE email='"+id+"' and password='"+password+"'");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			
			
			while(rs.next())
			{
			status.add(String.valueOf(rs.getString("id")));
			status.add(rs.getString("user_type"));
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
				db.closeConnection();
		}
		return status;
	}
	
	public JSONArray dashboard() throws SQLException
	{
	JSONArray data=new JSONArray();
		
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("SELECT count(*) as c FROM TABLES.USER_DETAILS ");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.put(rs.getString("c"));
			}
			
			//No of Org
			str=new StringBuffer();
			str.append("SELECT count(*) as c FROM TABLES.ORGANIZATION ");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.put(rs.getString("c"));
			}
			
			//No of request raised
			str=new StringBuffer();
			str.append("SELECT count(*) as c FROM TABLES.TRANSACTION ");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.put(rs.getString("c"));
			}
			
			//No of request approved
			str=new StringBuffer();
			str.append("SELECT count(*) as c FROM TABLES.TRANSACTION where status='closed' ");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.put(rs.getString("c"));
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
				db.closeConnection();
		}
		return data;
	}
	public HashMap<Integer,String> getUserForOrg() throws SQLException {
		HashMap<Integer,String> data=new HashMap<Integer,String>();
		
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("SELECT * from tables.user_details where org_id is null");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.put(Integer.parseInt(rs.getString("id")),rs.getString("name"));
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
				db.closeConnection();
		}
		return data;	
	}
	
	public ArrayList<ApproveList> approveRequestList(String userId) throws SQLException
	{
		 ArrayList<ApproveList> data=new  ArrayList<ApproveList>();
		
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("SELECT * FROM TABLES.TRANSACTION t JOIN TABLES.user_details u ON t.raised_by=u.id JOIN TABLES.ORGANIZATION o on t.ngo=o.org_id where status='Open' and alloted_to="+userId);
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			ApproveList ap=new ApproveList();
			ap.setRequestNo(rs.getString("raised_by"));
			ap.setDescription(rs.getString("description"));
			ap.setRaiseBy(rs.getString("u.name"));
			ap.setSentByOrg(rs.getString("o.org_name"));
			data.add(ap);
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
				db.closeConnection();
		}
		return data;
	}
	public ArrayList<Organization> orgList(String userId) throws SQLException
	{
		
		ArrayList<Organization> data=new ArrayList<Organization>();
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		ArrayList<String > orgLists=null;
		
		try
		{
			
			orgLists=user_org_list(userId);
			db=new DbManager();
			con=db.createConnection();
			//NO fo users
			StringBuffer str=new StringBuffer();
			str.append("SELECT *  FROM TABLES.ORGANIZATION ");
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			Organization org= new Organization();
			org.setOrg_id(rs.getString("org_id"));
			org.setOrg_name(rs.getString("org_name"));
			if(orgLists.contains(rs.getString("org_id")))
				org.setStatus("present");
			else
				org.setStatus("absent");
			data.add(org);
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
				db.closeConnection();
		}
		return data;
	}
	public boolean joinOrg(String userId,String orgId) throws SQLException
	{
		
		ArrayList<Organization> data=new ArrayList<Organization>();
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		
		try
		{
		
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("INSERT into TABLES.org_user_table values(?,?,?) ");
			ps= con.prepareStatement(str.toString());
			ps.setLong(1, getMaxValue("org_user_table")+1);
			ps.setLong(2, Long.parseLong(userId));
			ps.setLong(3,Long.parseLong(orgId));
			ps.setString(4,"Pending");
			ps.execute();
			
			
			
			
			
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
				db.closeConnection();
		}
		return true;
	}
	public boolean exitGroup(String userId,String orgId) throws SQLException
	{
		
		ArrayList<Organization> data=new ArrayList<Organization>();
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		
		try
		{
		
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("delete from TABLES.org_user_table where user_id= "+userId+" and org_id="+orgId);
			ps= con.prepareStatement(str.toString());
			
			ps.execute();
			
			
			
			
			
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
				db.closeConnection();
		}
		return true;
	}
	public ArrayList<String> user_org_list(String userId) throws SQLException
	{
		
		ArrayList<String> data=new ArrayList<String>();
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("SELECT *  FROM TABLES.org_user_table where user_id= "+userId);
			ps= con.prepareStatement(str.toString());
			rs=ps.executeQuery();
			while(rs.next())
			{
			data.add(rs.getString("org_id"));
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
				db.closeConnection();
		}
		return data;
	}
	public boolean creatUser(String usertype,String name,String email,String country,String state,String city,String password )
	{
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		try
		{
			db=new DbManager();
			int counter=0;
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			//id, name, address, user_type, rowstate, city, country, state, org_id, mobile_no, user_photo, area_name, created_at, email, password
			str.append("INSERT INTO TABLES.USER_DETAILS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps=con.prepareStatement(str.toString());
			ps.setLong(++counter,getMaxValue("USER_DETAILS")+1);
			ps.setString(++counter, name);
			ps.setString(++counter, null);
			ps.setString(++counter, usertype);
			ps.setLong(++counter, Long.parseLong(city));
			ps.setLong(++counter, Long.parseLong(country));
			ps.setLong(++counter, Long.parseLong(state));
			ps.setString(++counter, null);
			ps.setString(++counter, null);
			ps.setString(++counter, null);
			ps.setString(++counter, null);
			ps.setString(++counter, String.valueOf( LocalDate.now()));
			ps.setString(++counter, email);
			ps.setString(++counter, password);
			
			ps.execute();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public boolean requestAction (String requestId,String action) throws SQLException
	{
		
		ArrayList<Organization> data=new ArrayList<Organization>();
		java.sql.PreparedStatement ps=null;
		java.sql.ResultSet rs=null;
		
		try
		{
		
			db=new DbManager();
			con=db.createConnection();
			//NO of users
			StringBuffer str=new StringBuffer();
			str.append("UPDATE  TABLES.TRANSACTION  set status=? where transaction_id=? ");
			
			ps= con.prepareStatement(str.toString());
			if(action.equals("approve"))
			ps.setString(1, "Approved");
			else
				ps.setString(1, "Rejected");
			ps.setString(2, requestId);
			
			ps.execute();
			
			
			
			
			
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
				db.closeConnection();
		}
		return true;
	}
}
