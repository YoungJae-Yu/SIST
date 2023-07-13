package a01_diexp.z01_vo;

import java.util.ArrayList;
import java.util.List;
// a01_diexp.z01_vo.Mart
public class Mart {
	private String mname;
	private List<Product> plist;
	public Mart() {
		// TODO Auto-generated constructor stub
	}
	public Mart(String mname) {
		this.mname = mname;
		plist = new ArrayList<Product>();
	}
	public void buyList() {
		System.out.println(mname+"에서 구매한 물품?");
		if(plist.size()>0) {
			int tot=0;
			System.out.println("물건명\t가격\t갯수");
			for(Product prod:plist) {
				System.out.print(prod.getName()+"\t");
				System.out.print(prod.getPrice()+"\t");
				System.out.print(prod.getCnt()+"\n");
				tot += prod.getPrice()*prod.getCnt();
			}
			System.out.println("총비용:"+tot);
		}else {
			System.out.println("구매한 물건이 없네요..");
		}
		
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	
}
