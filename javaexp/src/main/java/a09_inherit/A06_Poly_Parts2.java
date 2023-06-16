package javaexp.a09_inherit;

public class A06_Poly_Parts2 {

	public static void main(String[] args) {

		ComputerParts com1 = new ComputerParts("조립");
//		com1.showPartsInfo();
		com1.addPart(new Cpu("AMD"));
		com1.addPart(new Ram("16G"));
		com1.addPart(new GraphicCard("GTX 3060ti"));
		com1.showPartsInfo();
	}
}
class GraphicCard extends Part{

	public GraphicCard(String spec) {
		super("그래픽카드", spec);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("그래필 카드는 컴퓨터의 동적 화면을 처리 빠르게 합니다.");
	}
	
}
/////////////////////////////
/*
2단계 : 실무적 구조
1:다관계 처리 구조
컴퓨터안에 여러 부품들을 장착 가능할 수 있도록 
 */
class ComputerParts{
	private String company;
	private Part[] parts;
	private int idx;
	// 컴퓨터를 생성할 때, 제조사와 부품 3개를 장착할 수 있게 배열로 선언.
	public ComputerParts(String company) {
		this.company = company;
		parts = new Part[3];
	}
	// 부품을 장착처리하는 처리 
	// 외부에서 호출할 때, 처리 형태
	// com.addPart(new Cpu());
	// com.addPart(new Ram());
	// com.addPart(new Ssd());
	// com.addPart(new Cpu());
	// Part part = new Cpu(); 형태로 다형성을 처리하는 상속구조가 되어있기 때문이다.
	public void addPart(Part part) {
		// 3개 이상은 장착되지 못하게 처리 : 배열은 크기가 초기에
		// 고정형으로 생성이 되기 때문이다..
		if(idx<3) {
			// parts[idx] = part;
			// parts[0] = new Cpu();
			// parts[1] = new Ram();
			// parts[2] = new Ssd();
			this.parts[idx++] = part;
			System.out.println("부품이 장착되었습니다.");
		}else {
			System.out.println("더 이상 부품을 장착할 수 없습니다.");
		}
	}
	public void showPartsInfo() {
		System.out.println(company+"컴퓨터!");
		// parts에 부품 하나라도 추가되어 있을 때..
		if(parts[0]!=null) {
			// 반복문을 통해서 parts안에 담겨 있는 객체를 
			// 하나씩 가져와서 처리
			// 1개만 담고, 호출할 때..
			// Part[] parts = new Part[3];
			// Part[] parts = {null, null, null};
			// Part[] parts = {new Cpu(), null, null};
			for(Part part:parts) {
				if(part!=null) // 실제 객체가 할당되어 있을 때만
					part.showInfo();// 재정의된 메서드를 호출
			}
		}else {
			System.out.println("부품이 장착되지 않았습니다.");
		}
	}
}