package javaexp.a09_inherit;

public class A09_PolyExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d1 = new NormalDuck();
		d1.flying();
		Duck d2 = new Mallard();
		d2.flying();
	}

}
class Duck{
	private String duck;

	public Duck(String duck) {
		this.duck = duck;
	}
	public void flying() {
		System.out.println(duck+"가 하늘을 날려고 한다!");
	}
	
}
class NormalDuck extends Duck {

	public NormalDuck() {
		super("맛있는 오리");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void flying() {
		// TODO Auto-generated method stub
		super.flying();
		System.out.println("맛있게 살쪄서 날지 못한다...");
	}
}
class Mallard extends Duck{
	public Mallard() {
		super("청동오리");
	}

	@Override
	public void flying() {
		// TODO Auto-generated method stub
		super.flying();
		System.out.println("힘좋은 청동오리는 자유롭게 하늘을 누빈다!");
	}
	
}