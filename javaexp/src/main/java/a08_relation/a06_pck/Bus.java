package javaexp.a08_relation.a06_pck;

public class Bus {
//	접근제어자 private 외부에서 직접적인 접근이 안된다.
	private String driver;
	public int no;
	int num1;
	String target;
//	b1 = new Bus(); (O)
//	b1 = new Bus(7788); (X)
//	b1 = new Bus("서울행",9999); (O)
	public Bus(String target, int no, String driver) {
		this.target=target;
		this.no=no;
		this.driver=driver;
//		접근이 되는 생성자를 통해서 데이터 할당.
	}
	public void callInfo() {
		System.out.println("버스번호:"+no);
		System.out.println("목적지:"+target);
		System.out.println("버스기사:"+driver);
//		접근이 되는 기능 메서드를 통해서 driver의 내용 호출.
	}
	
	
	public Bus() {
		this.num1 = num1;
	}
	Bus(int num1) {
		this.num1 = num1;
	}
	public Bus(String name,int num1) {
		this.num1 = num1;
		this.target = name;
	}
	public void no() {}
	void target() {}
}
