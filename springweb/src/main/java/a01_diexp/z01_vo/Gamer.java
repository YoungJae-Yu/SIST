package a01_diexp.z01_vo;

import java.util.Properties;
import java.util.Set;

public class Gamer {
	private Set<String> bead;
	private Properties beadCnt;
	public Set<String> getPocket() {
		return bead;
	}
	public void setPocket(Set<String> bead) {
		this.bead = bead;
	}
	public void showMyPocket() {
		System.out.println("내 주머니에 있는 구슬들");
		if(bead!=null) {
			for(String bd:bead) {
				System.out.println(bd);
			}
		}else {
			System.out.println("구슬이 없네요.");
		}
	}
	public Properties getBeadCnt() {
		return beadCnt;
	}
	public void setBeadCnt(Properties beadCnt) {
		this.beadCnt = beadCnt;
	}

}
