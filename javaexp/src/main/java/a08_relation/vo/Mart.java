package javaexp.a08_relation.vo;

public class Mart {
	private String mname;
	private Product[] pArry;
	private String buyer;
	private int bIdx;//구매 index
	public Mart() {
		// TODO Auto-generated constructor stub
	}
	public Mart(String mname) {
		this.mname = mname;
	}
//	구매 갯수와 구매자 처리 메서드
	
//	# 1:다 관계에서 배열로 다중 객체를 선언할 때는 배열자체가 초기에
//	크기를 설정하여 처리하여야 하는 부분이 있고, 한번 크기가 설정된
//	배열을 다시 객체 생성하기 전까지는 변경이 불가능하여 아래와 같이
//	추가할 때, 로직이 필요로 하다.
	public void buyProdPlan(String buyer, int cnt) {
		this.buyer = buyer;//구매자
		pArry = new Product[cnt];//구매할 물건의 종류 갯수 지정
		bIdx = 0;//구매자에 따라 구매 종류 갯수 초기화.
		System.out.println(buyer+"가 물건 "+cnt+"종을 "+mname+"에서 구매하기로 했습니다!");
	}
//	단위 구매 내용 처리
	public void buyProduct(Product prod) {
		
	  if(pArry != null) { // pArry.length nullpointer 예외 방지 목적.		
		
		System.out.println(buyer+"가 "+mname+"에서 물건을 구매하다!");
		int cnt = pArry.length;
//		구매하는 물건의 index가 구매할 갯수보다 작야아 한다.
		if(bIdx < cnt) {
			pArry[bIdx]=prod;
			System.out.println((bIdx+1)+"번째 물건 "+prod.getName());
			System.out.println("를(을) "+prod.getCnt()+"개 구매하다!");
			bIdx++;
			if(bIdx == cnt) {
				System.out.println("구매할 종류 갯수("+cnt+")가 완료되었습니다.");
			}
		}else {
			System.out.println("구매할 종류 갯수("+cnt+")더 이상 구매불가합니다.");
		}
	  }else {
		  System.out.println("구매자와 구매할 갯수를 입력 처리 필요합니다!");
		  System.out.println("buyProdPlan(구매자명,구매종류갯수)호출 필요!");
	  }
	}
	public void buyList() {
		if(pArry != null) {
			System.out.println(buyer+"가 "+mname+"에서 구매한 물건 정보!");
			System.out.println("총 종류 갯수:"+pArry.length+"종");
			System.out.println("물건명\t가격\t갯수\t단위계");
			int tot = 0;
			for(Product prod:pArry) {
				tot+=prod.totBuyInfo();
			}
			System.out.println("총 구매 비용:"+tot);
		}else {
			checkValid();
		}

	}
	// 외부 사용 필요없어서 private 현재 클래스에서 내부적으로
	// 호출..
	private void checkValid() {
		System.out.println("구매자와 구매할 갯수를 입력 처리 필요합니다!");
		System.out.println("buyProdPlan(구매자명,구매종류갯수)호출 필요!");
	}
	
}
