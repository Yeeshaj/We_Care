package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.ForwardAction;

import Constants.Constants;
import content_model.requestCM;

public class MainAction  extends Action
{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) 
	{ 
		ActionForward forward=null;
		String subaction=request.getParameter("subaction");
		if(subaction.equals("raiseRequest"))
			{
			forward=raiseRequest(mapping,form,request,response);
			}
	
		if(forward!=null)
		return forward;
		else
			return mapping.findForward(Constants.SUCCESS);
		
	}

	private ActionForward raiseRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request,  HttpServletResponse response) {
		requestCM rcm=new requestCM();
		rcm.raiseRequestCM();
		return mapping.findForward("raiseRequest");
	}
}
