package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Mart;
import a01_diexp.z01_vo.ShoppingMall;

public class DIExp13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di13.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Object obj = ctx.getBean("obj", Object.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		Mart m01 = ctx.getBean("m01", Mart.class);
		m01.buyList();
		ShoppingMall s01 = ctx.getBean("s01", ShoppingMall.class);
		s01.showMemberList();
		ctx.close();
		System.out.println("종료");
	}
}
