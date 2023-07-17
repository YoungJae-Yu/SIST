package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z04_vo.Code;
import a01_diexp.z04_vo.Emp;

public class DIExp20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di20.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Code obj1 = ctx.getBean("code", Code.class);
		System.out.println("컨테이너의 객체호출:"+obj1);
		Emp obj2 = ctx.getBean("emp", Emp.class);
		System.out.println("컨테이너의 객체호출:"+obj2);
		obj2.setEname("홍길동(사원)");
		System.out.println(obj2.getEname());
		ctx.close();
		System.out.println("종료");
	}

}
