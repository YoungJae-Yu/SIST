package javaexp.a09_inherit;

public class A05_Poly_Parts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer com01 = new Computer("삼성");
		com01.showPartsInfo();
		com01.addPart(new Cpu("i7 3.4GHZ"));
		com01.showPartsInfo();
		com01.addPart(new Ram("8G"));
		com01.showPartsInfo();
		com01.addPart(new Ssd("512GB"));
		com01.showPartsInfo();
		//addPart(String name)
		// Part part1 = new Cpu("i7 3.4GHZ")
		// Part part2 = new Ram("8G")
		//addPart(Part part)
		// ex) Ssd를 상속해서 추가하고 main()에서 호출해보세요..
	}
}
class Part{
	private String kind;
	private String spec;
	public Part(String kind, String spec) {
		this.kind = kind;
		this.spec = spec;
	}
	public void showInfo() {
		System.out.println("# 부품정보 #");
		System.out.println("부품명:"+kind);
		System.out.println("사양:"+spec);
	}
}
class Cpu extends Part{

	public Cpu(String spec) {
		super("CPU", spec);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		// 추가되는 기능을 처리하여 각 부품별로 동일한 메서드리지만
		// 다양한 기능적 처리를 할 수 있게 하였다.
		System.out.println("CPU는 컴퓨터의 핵심 부품으로 중앙처리를 한다.");
	}
}
class Ram extends Part{

	public Ram(String spec) {
		super("Ram메모리", spec);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("Ram메모리는 컴퓨터의 휘발성 메모리를 처리한다.");
	}
}
class Ssd extends Part{

	public Ssd(String spec) {
		super("Ssd저장소", spec);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("Ssd저장소는 데이터를 저장하는 곳이다.");
	}
}
// 1단계
// 1:1관계 구조 컴퓨터안에 다양한 하나의 부품을 장착가능하게 처리
class Computer{
	private String company;
	private Part part;
	public Computer(String company) {
		this.company = company;
	}
	public void addPart(Part part) {
		this.part = part;
		System.out.println("부품이 장착되었습니다.");
	}
	public void showPartsInfo() {
		System.out.println(company+"컴퓨터!");
		if(part!=null) {
			part.showInfo();
		}else {
			System.out.println("부품이 장착되지 않았습니다.");
		}
	}
}