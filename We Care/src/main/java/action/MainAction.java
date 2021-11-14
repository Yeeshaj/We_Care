package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.ForwardAction;
import org.apache.struts2.json.annotations.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

import Beans.Country;
import Beans.Organization;
import Beans.User;
import Beans.ViewStatus;
import Constants.Constants;
import Util.Utilites;
import content_model.requestCM;

import java.*;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
public class MainAction  extends Action
{
	User user=null;
	HttpSession session=null;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) 
	{ 
		ActionForward forward=null;
		
		String subaction=request.getParameter("subaction");
		
		if(subaction.equals("raiseRequest"))
			{
			forward=raiseRequest(mapping,form,request,response);
			
			}
		else if (subaction.equals("dashboard"))
		{
			forward=dashboard(mapping,form,request,response);
		}
		else if(subaction.equals("login"))
		{
			login(mapping,form,request,response);
			forward=dashboard(mapping, form, request, response);
		}
		else if(subaction.equals("retrieveState"))
		{
			retrieveState(mapping,form,request,response);
		}
		else if(subaction.equals("retrieveCity"))
		{
			retrieveCity(mapping,form,request,response);
		}
		else if(subaction.equals("populateNGO"))
		{
			populateNGO(mapping,form,request,response);
		}
		else if(subaction.equals("viewRequest"))
		{
			forward=viewRequest(mapping,form,request,response);
		}
		else if(subaction.equals("approveRequest"))
		{
			forward=approveRequestList(mapping,form,request,response);
		}
		else if(subaction.equals("orgList"))
		{
			forward=orgList(mapping,form,request,response);
		}
		else if(subaction.equals("logout"))
		{
			forward=logout(mapping,form,request,response);
		}
	
		if(forward!=null)

			return forward;
		else
		return mapping.findForward(Constants.SUCCESS);
		
		
		
	}

	private ActionForward raiseRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		try
		{
			boolean status=false;
			 user=(User) form;
		requestCM rcm=new requestCM();
		//rcm.raiseRequestCM();
		HashMap<Integer,String> countryLists=rcm.retrieveCountry();
		ArrayList<Country> countryList = new ArrayList<Country>();
		String countryId=request.getParameter("countryId");
		String cityId=request.getParameter("cityId");
		String stateId=request.getParameter("stateId");
		String ngo=request.getParameter("ngo");
		String area=request.getParameter("area");
		/*
		 * String photopath=request.getParameter("photo");
		 * 
		 * if(Utilites.hasValue(photopath)) { File photo=new File(photopath); }
		 */
        
        String description=request.getParameter("description");
      
	if(Utilites.hasValue(ngo) && Utilites.hasValue(countryId)&& Utilites.hasValue(cityId)&& Utilites.hasValue(stateId) && Utilites.hasValue(area)&&Utilites.hasValue(description) )
	{
		
		status=rcm.raiseRequestCM(countryId,stateId,cityId,ngo,area,description);
	}
	if(status)
	{
		user.setMessage("Request Raised Successfully");
		dashboard(mapping, form, request, response);
	}
	else
	{
		if(countryLists!=null)
		{
			for (Entry<Integer, String> mapElement : countryLists.entrySet()) {
	            int key = mapElement.getKey();
	            String value=mapElement.getValue();
	            countryList.add(new Country(String.valueOf(key), value));
	       }
		}
		user.setCountryList(countryList);
		request.setAttribute("countryList", countryList);
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward("raiseRequest");
	}
	private JSONArray retrieveState(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		JSONArray data=null;
		PrintWriter out=null;
		
		try
		{
			 data=new JSONArray();
			String countryId=request.getParameter("countryId");
			requestCM rcm=new requestCM();
			data=rcm.retrieveState(countryId);
			JSONArray d=new JSONArray();
			
			 out = response.getWriter();
			 out.println(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
		return data;
	}
	private JSONArray retrieveCity(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		JSONArray data=null;
		PrintWriter out=null;
		
		try
		{
			 data=new JSONArray();
			String countryId=request.getParameter("stateId");
			requestCM rcm=new requestCM();
			data=rcm.retrieveCity(countryId);
			JSONArray d=new JSONArray();
			
			 out = response.getWriter();
			 out.println(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
		return data;
	}
	private JSONArray populateNGO(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		JSONArray data=null;
		PrintWriter out=null;
		
		try
		{
			 data=new JSONArray();
			String countryId=request.getParameter("countryId");
			String cityId=request.getParameter("cityId");
			String stateId=request.getParameter("stateId");
			requestCM rcm=new requestCM();
			data=rcm.populateNGO(countryId,stateId,cityId);
			JSONArray d=new JSONArray();
			
			 out = response.getWriter();
			 out.println(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
		return data;
	}
	private ActionForward viewRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		ArrayList<ViewStatus> data=null;
		 user=(User) form;
		try
		{
			
			requestCM rcm=new requestCM();
			data=rcm.retrieveViewStatusList();
			user.setViewStatusList(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward("viewStatus");
	}
	private ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		
		 user=(User) form;
		 PrintWriter out=null;
		 long userid=0;
		try
		{
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			requestCM rcm=new requestCM();
			userid=rcm.login(id, password);
			if(userid!=0)
			{
				user.setUser_id(String.valueOf(userid));				
				session = request.getSession();
				session.setAttribute("id", userid);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward(Constants.SUCCESS);
		}
	
	private ActionForward dashboard(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		
		 user=(User) form;
		 
		try
		{
			
			requestCM rcm=new requestCM();
			JSONArray data=new JSONArray();
			data=rcm.dashboard();
			if(data!=null)
			{
				
				user.setNo_of_users(String.valueOf(data.getInt(0)));
				user.setNo_of_org(String.valueOf(data.getInt(1)));
				user.setNo_of_request_raised(String.valueOf(data.getInt(2)));
				user.setNo_of_requests_solved(String.valueOf(data.getInt(3)));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward(Constants.SUCCESS);
		}
	
	private ActionForward approveRequestList(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		
		 user=(User) form;
		 
		try
		{
			
			requestCM rcm=new requestCM();
			JSONArray data=new JSONArray();
			data=rcm.approveRequestList();
			if(data!=null)
			{
				
				user.setNo_of_users(String.valueOf(data.getInt(0)));
				user.setNo_of_org(String.valueOf(data.getInt(1)));
				user.setNo_of_request_raised(String.valueOf(data.getInt(2)));
				user.setNo_of_requests_solved(String.valueOf(data.getInt(3)));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward(Constants.SUCCESS);
		}
	
	private ActionForward orgList(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		
		 user=(User) form;
		 ArrayList<Organization>data=new ArrayList<Organization>();
		try
		{
			
			requestCM rcm=new requestCM();
		
			data=rcm.orgList();
			user.setOrgList(data);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward("orgList");
		}
	
	private ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		
		
		
		try
		{
			
			session.removeAttribute("id");
			session.invalidate();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return mapping.findForward("logout");
		}
}
