package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z06_callMvc.A01_Controller;
import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Emp;

public class DIExp22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di22.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		// z06_callMvc
            
		// 해당 클래스 3개를 만들어
		// di22.xml에서 객체화하여  특정 메서드가
		// 호출되게 하세요..
		A01_Controller a01_Controller = ctx.getBean("a01_Controller", A01_Controller.class);
		for(Emp d:a01_Controller.getEmpList(new Emp())) {
			System.out.print(d.getEname()+"\t");
			System.out.print(d.getJob()+"\t");
			System.out.print(d.getEmpno()+"\n");
		}
		
		
		
		ctx.close();
		System.out.println("종료");
		
	}

}
