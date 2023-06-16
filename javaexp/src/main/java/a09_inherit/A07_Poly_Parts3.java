package javaexp.a09_inherit;

public class A07_Poly_Parts3 {

	public static void main(String[] args) {

	}
}

class ComputerParts2{
	private String company;
	private Part part;
	public ComputerParts2(String company) {
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