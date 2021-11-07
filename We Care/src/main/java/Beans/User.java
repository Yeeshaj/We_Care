package Beans;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {

	String user_id,name,country,state,city,address,area,phone_no,user_type,org_id,rowstate;
	String user_name,mobile_no;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getOrg_id() {
		return org_id;
	}

	public String getRowstate() {
		return rowstate;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public void setRowstate(String rowstate) {
		this.rowstate = rowstate;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	
}
