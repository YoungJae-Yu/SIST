package javaexp.a09_inherit.abstrac;

import java.util.ArrayList;

public class A02_CompanyAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ex) 
		상위 추상 클래스 Company 회사명, working() 공통, 
					earnMoney 돈을 버는 방법() 추상
		하위 실체 클래스 HyunDai, Samsung
		 */
		ArrayList<Company> jobs = new ArrayList<Company>();
		jobs.add(new HyunDai());
		jobs.add(new Samsung());
		for(Company js:jobs) {
			js.working();
			js.earnMoney();
		}
	}
}
abstract class Company{
	private String name;
	public Company(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void working() {
		System.out.println(name+" 사무실로..출근합니다..(월루기원)");
	}
	public abstract void earnMoney();
}
class HyunDai extends Company{

	public HyunDai() {
		super("현대자동차");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void earnMoney() {
		// TODO Auto-generated method stub
		System.out.println("1. 출근을 합니다..");
		System.out.println("2. 유튜브를 킵니다..");
		System.out.println("3. 돈을 벌어재낍니다..^~^");
	}
}
class Samsung extends Company{

	public Samsung() {
		super("샘숭전자");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void earnMoney() {
		// TODO Auto-generated method stub
		System.out.println("1. 출근을 합니다..");
		System.out.println("2. 커피를 뽑습니다..");
		System.out.println("3. 돈을 신나게 벌어재낍니다..^~^");
	}
}