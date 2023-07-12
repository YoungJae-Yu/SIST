package backWeb.z01_vo;

public class Music {
	private String mname;
	private String singer;
	private int pubuyear;
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(String mname, String singer, int pubuyear) {
		super();
		this.mname = mname;
		this.singer = singer;
		this.pubuyear = pubuyear;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getPubuyear() {
		return pubuyear;
	}
	public void setPubuyear(int pubuyear) {
		this.pubuyear = pubuyear;
	}
	
}
