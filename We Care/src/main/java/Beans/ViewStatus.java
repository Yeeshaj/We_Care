package Beans;

public class ViewStatus {

	String userId,country,city,state,description,created_at,last_updated_at,last_updated_by,status;
	String transaction_id,NGO;
	public String getUserId() {
		return userId;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getDescription() {
		return description;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getLast_updated_at() {
		return last_updated_at;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public String getStatus() {
		return status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public void setLast_updated_at(String last_updated_at) {
		this.last_updated_at = last_updated_at;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getNGO() {
		return NGO;
	}

	public void setNGO(String nGO) {
		NGO = nGO;
	}
}
