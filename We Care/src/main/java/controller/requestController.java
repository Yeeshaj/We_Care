package controller;

import Util.DbManager;

public class requestController {
	
	public DbManager db=null;
	public requestController()
	{
		
	}
	public void raiseRequestController()
	{
		try
		{
			db.createConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
