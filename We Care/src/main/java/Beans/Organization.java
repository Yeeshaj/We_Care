package Beans;

public class Organization {

	
	int org_id,user_id,rowstate,org_name;

	public int getOrg_id() {
		return org_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getRowstate() {
		return rowstate;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}

	public int getOrg_name() {
		return org_name;
	}

	public void setOrg_name(int org_name) {
		this.org_name = org_name;
	}
}
