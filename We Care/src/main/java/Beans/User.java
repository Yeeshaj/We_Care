package Beans;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {

	String user_id,name,country,state,city,address,area,phone_no,user_type,org_id,rowstate;
	String user_name,mobile_no;
	String countryName,countryId;
	String message=" ";
	String email,password;
	ArrayList<ViewStatus> viewStatusList;
	String no_of_users="",no_of_org="",no_of_request_raised="",no_of_requests_solved="";
	ArrayList<Organization> orgList;
	public String getCountryName() {
		return countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	ArrayList<Country> countryList=new ArrayList<>();

	public ArrayList<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<Country> countryList) {
		this.countryList = countryList;
	}

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

	public String getEmail() {
		return email;
	}

	public ArrayList<Organization> getOrgList() {
		return orgList;
	}

	public void setOrgList(ArrayList<Organization> orgList) {
		this.orgList = orgList;
	}

	public String getNo_of_users() {
		return no_of_users;
	}

	public String getNo_of_org() {
		return no_of_org;
	}

	public String getNo_of_request_raised() {
		return no_of_request_raised;
	}

	public String getNo_of_requests_solved() {
		return no_of_requests_solved;
	}

	public void setNo_of_users(String no_of_users) {
		this.no_of_users = no_of_users;
	}

	public void setNo_of_org(String no_of_org) {
		this.no_of_org = no_of_org;
	}

	public void setNo_of_request_raised(String no_of_request_raised) {
		this.no_of_request_raised = no_of_request_raised;
	}

	public void setNo_of_requests_solved(String no_of_requests_solved) {
		this.no_of_requests_solved = no_of_requests_solved;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRowstate(String rowstate) {
		this.rowstate = rowstate;
	}

	public ArrayList<ViewStatus> getViewStatusList() {
		return viewStatusList;
	}

	public void setViewStatusList(ArrayList<ViewStatus> viewStatusList) {
		this.viewStatusList = viewStatusList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
