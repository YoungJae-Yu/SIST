package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import backendWeb.z01_vo.Calculator;
import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Music;
import backendWeb.z01_vo.Person;
import backendWeb.z01_vo.Product;

public class DIExp15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di15.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Object obj = ctx.getBean("obj", Object.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		Person p01 = ctx.getBean("p01",Person.class);
		Product prod1 = ctx.getBean("prod1",Product.class);
		Product prod2 = ctx.getBean("prod2",Product.class);
		System.out.println(p01.getName());
		System.out.println(prod1.getName());
		System.out.println(prod2.getName());
		Dept dept = ctx.getBean("dept",Dept.class);
		Calculator calcu = ctx.getBean("calcu",Calculator.class);
		System.out.println(dept.getDeptno()+"\t"+dept.getDname()+"\t"+dept.getLoc());
		System.out.println(calcu.getNum01()+"\t"+calcu.getCal()+"\t"+calcu.getNum02()+"\t"+calcu.getTot());
		Music m1 = ctx.getBean("m1",Music.class);
		Music m2 = ctx.getBean("m2",Music.class);
		Music m3 = ctx.getBean("m3",Music.class);
		System.out.println(m1.getMname()+"\t"+m1.getSinger()+"\t"+m1.getPubyear());
		System.out.println(m2.getMname()+"\t"+m2.getSinger()+"\t"+m2.getPubyear());
		System.out.println(m3.getMname()+"\t"+m3.getSinger()+"\t"+m3.getPubyear());
		
		ctx.close();
		System.out.println("종료");
	}

}
