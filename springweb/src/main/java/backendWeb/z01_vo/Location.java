package backendWeb.z01_vo;


public class Location {
	private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_province;
	private String country_id;
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public Location(String street_addres, String city) {
		this.street_address = street_addres;
		this.city = city;
	}
	public Location(int location_id, String street_addres, String postal_code, String city, String state_province,
			String country_id) {
		this.location_id = location_id;
		this.street_address = street_addres;
		this.postal_code = postal_code;
		this.city = city;
		this.state_province = state_province;
		this.country_id = country_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_addres(String street_addres) {
		this.street_address = street_addres;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	
}
