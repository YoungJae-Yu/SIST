package a01_diexp.z04_vo;
// backendWeb.z01_vo.Music
public class Music {
	private String mname;
	private String singer;
	private int  pubyear;
	public Music() {
		// TODO Auto-generated constructor stub
	}
	public Music(String mname, String singer, int pubyear) {
		this.mname = mname;
		this.singer = singer;
		this.pubyear = pubyear;
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
	public int getPubyear() {
		return pubyear;
	}
	public void setPubyear(int pubyear) {
		this.pubyear = pubyear;
	}
	
}
