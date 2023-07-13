package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import backendWeb.z01_vo.Music;
import backendWeb.z01_vo.Person;
import backendWeb.z01_vo.Product;

public class DIExp11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di11.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Object obj = ctx.getBean("obj", Object.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		Person p01 = ctx.getBean("p01", Person.class);
		Product prod01 = ctx.getBean("prod01", Product.class);
		System.out.println("# 컨테이너 안에 객체 호출 p01 #");
		System.out.println(p01.getName());
		System.out.println(p01.getAge());
		System.out.println(p01.getLoc());
		System.out.println("# 물건객체 prod01 #");
		System.out.println(prod01.getName());
		System.out.println(prod01.getPrice());
		System.out.println(prod01.getCnt());
		Person p02 = ctx.getBean("p02", Person.class);
		System.out.println("#생성자 객체 선언#");
		System.out.println(p02.getName());
		System.out.println(p02.getLoc());
		System.out.println(p02.getAge());
		// ex) Music을 생성자에 의해 컨테이너에 선언/할당하고,
		//     main()에서 호출하세요.
		Music m01 = ctx.getBean("m01", Music.class);
		System.out.println(m01.getMname());
		System.out.println(m01.getSinger());
		System.out.println(m01.getPubyear());
		
		
		
		ctx.close();
		System.out.println("종료");
	}

}
