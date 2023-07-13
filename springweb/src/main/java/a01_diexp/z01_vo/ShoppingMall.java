package a01_diexp.z01_vo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
	private String sname;
	private List<Member> mlist;
	public ShoppingMall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingMall(String sname) {
		this.sname = sname;
		mlist = new ArrayList<Member>();
	}
	public void showMemberList() {
		System.out.println(sname+"의 회원리스트");
		if(mlist.size()>0) {
			System.out.println("아이디\t패스워드\t이름\t권한\t포인트");
			for(Member mem:mlist) {
				System.out.print(mem.getId()+"\t");
				System.out.print(mem.getPass()+"\t");
				System.out.print(mem.getName()+"\t");
				System.out.print(mem.getAuth()+"\t");
				System.out.print(mem.getPass()+"\n");
			}
		}else {
			System.out.println("회원이 없네요..");
		}
		
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Member> getMlist() {
		return mlist;
	}
	public void setMlist(List<Member> mlist) {
		this.mlist = mlist;
	}
}
