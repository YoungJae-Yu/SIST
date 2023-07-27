package springweb.a05_mvcexp.z01_vo;

public class Region {
	private int region_id;
	private String region_name;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(int region_id, String region_name) {
		super();
		this.region_id = region_id;
		this.region_name = region_name;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
}
