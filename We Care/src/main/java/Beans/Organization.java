package Beans;

import org.apache.struts.action.ActionForm;

public class Organization extends ActionForm{

	
	String org_id,user_id,rowstate,org_name,status;

	public String getOrg_id() {
		return org_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getRowstate() {
		return rowstate;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setRowstate(String rowstate) {
		this.rowstate = rowstate;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
