package javaexp.a09_inherit;

public class A11_AbstractClass {
	public static void main(String[] args) {
		/*
		# 추상 클래스(Abstract Class)
		1. 추상 : 실체들 간에 공통되는 특성을 추출한 것을 말한다.
			삼성, 현대, LG ==> 회사
			새, 곤충, 물고기 ==> 동물
		2. 추상클래스
			실체 클래스들의 공통되는 필드와 공통 메소드 정의한 클래스
			추상적인 메서드를 선언하고, 하위클래스에서 이 메서드를 반드시(**)
			재정의하게 한 것을 말한다. ==> 추상메서드가 하나라도 있으면 추상클래스가 된다.
			공통내용(공통기능메서드) + 개별적으로 다른 기능 처리(추상메서드)
			
		3. 특징
			1) 일반 클래스와 거의 유사하고, 추상메서드가 있다.
			2) 추상메서드는 하위에서 반드시 재정의해야 하는 부분(다형성 처리 필요)
				- 하위클래스에서 추상메서드 강제화(컴파일에러발생)
			3) 추상클래스는 단족으로 객체생성을 하지 못한다.
				추상클래스 = new 상속받은실제객체(); 로만 객체 생성.
			4) 
		4. 단계별 진행 내용
			# 1단계
			1) 추상클래스 선언 : 재정의할 추상메서드 선언
			2) 위 추상클래스를 통해 상속받을 하위 실제 클래스
			3) 추상클래스 = 상위 클래스(다형성)
				참족변수.재정의메서드()
			# 2단계(1:1관계)
			4) 위 추상클래스와 상속실제 클래스를 1:1관계 처리..
				ex) 하나의 유닛밖에 없는 저그유저
					ZergUser
						Larba larba;(필드선언)
						Larba를 추상클래스(attack()추상메서드)로 해서
						하위에 여러가지 상속 유닛 Dron, Zerggling, HydraList
						makeUnit(Larba larba)
							this.larba = larba;
				ex) 하나의 부품밖에 없는 컴퓨터
					Computer
						Part part;(필드선언)
						Part를 추상클래스(showInfo()추상메서드)로 해서
						하위에 여러가지 상속 부품 Cpu, Ram, Ssd
						addPart(Part part)
							this.part = part;
				ex) 마트에서 하나의 구매품 사기
					Mart
						Product prod;(필드선언)
						Product 추상클래스(prodInfo()추상메서드)로 해서
						하위에 여러가지 판매 물건 Fruit, Food, Icecream...
						buyProduct(Product prod)
							this.prod = prod;
			# 3단계(1:다관계)
			5) 위 추상클래스와 상속실제 클래스를 1:다 관계를 포함한 처리
				ex) 여러개의 유닛을 가진 저그유저
					ZergUser
						ArrayList<Larba> units;(필드선언)
						makeUnit(Larba larba)
							units.add(larba); //유닛추가
				ex) 여러개의 부품을 가진 컴퓨터
					Computer
							ArrayList<Part> parts;(필드선언)
							addPart(Part part)
								parts.add(part); //부품추가
				ex) 여러개의 물건을 구매할 수 있는 마트
					Mart
						ArrayList<Product> buyList;(필드선언)
						buyProduct(Product prod)
							buyList.add(prod); //구매물품 추가.
						showBuyList()
							name마트에서 구매한 내역
							int tot = 0;
							for(Product prod:buyList){								
								prod.prodInfo();
								prod.getName()
								prod.getPrice()
								prod.getCnt()
								tot += prod.getPrce() * prod.getCnt();
							}
		 */
	}
}
