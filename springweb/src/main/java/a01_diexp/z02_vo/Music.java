package a01_diexp.z02_vo;

import org.springframework.stereotype.Component;

// backendWeb.z01_vo.Music
@Component
public class Music {
	private String mname;
	private String singer;
	private int  pubyear;
	public Music() {
		// TODO Auto-generated constructor stub
	}
	public void listening() {
		if(mname!=null) {
			System.out.println(singer+"의 "+mname+"를 듣고있다.");
		}else {
			System.out.println("음악을 재생시켜주세요!");
		}
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
