package javaexp.a08_relation;

import javaexp.a08_relation.vo.Mart;
import javaexp.a08_relation.vo.Product;

public class A05_ObjVsObjArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mart m01 = new Mart("행복마트");
		// 예외 내용 확인
		m01.buyList();
		// 예외 내용 확인2
		m01.buyProduct(new Product("사과",3000,2));
		m01.buyProdPlan("홍길동", 3);
		m01.buyProduct(new Product("오렌지",1200,2));
		m01.buyProduct(new Product("딸기",8800,6));
		m01.buyProduct(new Product("수박",1500,7));
		// 예외 내용 확인3
		m01.buyProduct(new Product("키위",3000,2));
		m01.buyList();

	}

}
