package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z02_vo.Car;
import a01_diexp.z02_vo.CarDriver;
import a01_diexp.z02_vo.Person;

public class DIExp18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di18.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Person obj = ctx.getBean("person", Person.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		obj.setName("홍길동");
		obj.setAge(25);
		System.out.println(obj.getName());
		Car c01 = ctx.getBean("car",Car.class);
		c01.setKind("SM5");
		c01.setCc(2500);
		c01.setMaxVel(220);
		CarDriver cardriver01 = 
				ctx.getBean("cardriver01",CarDriver.class);
		cardriver01.setCar(c01);
		cardriver01.setName("마길동");
		cardriver01.driving();
		ctx.close();
		System.out.println("종료");
	}

}
