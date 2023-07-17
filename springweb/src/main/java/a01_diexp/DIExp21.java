package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z05_mvc.A01_Controller;
import a01_diexp.z05_mvc.A02_Service;
import a01_diexp.z05_mvc.Web_Controller;
import backendWeb.z01_vo.Dept;

public class DIExp21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di21.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Web_Controller obj = ctx.getBean("web_Controller", Web_Controller.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		for(Dept d:obj.getDeptList(new Dept())) {
			System.out.println(d.getDeptno()+"\t");
			System.out.println(d.getDname()+"\t");
			System.out.println(d.getLoc()+"\n");
		}
		A01_Controller a01_Controller = 
				ctx.getBean("a01_Controller",
						A01_Controller.class);
		System.out.println(a01_Controller.callCtrl());
		A02_Service a02_Service = 
				ctx.getBean("a02_Service",
						A02_Service.class);
		a02_Service.callService();
		
		
		
		ctx.close();
		System.out.println("종료");
	}

}
