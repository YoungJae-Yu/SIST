package a01_diexp;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Gamer;
import a01_diexp.z01_vo.Monitor;
import a01_diexp.z01_vo.Sensor;
import a01_diexp.z01_vo.Student;

public class DIExp14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di14.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		Object obj = ctx.getBean("obj", Object.class);
		System.out.println("컨테이너의 객체호출:"+obj);
		
		Sensor sensor01 = ctx.getBean("sensor01",Sensor.class);
		System.out.println(sensor01.getAgent());
		for(String str:sensor01.getAgent()) {
			System.out.println(str);
		}
		System.out.println(sensor01.getAddInfo());
		// class Gamer
		// 		private Set<String> bead;
		// 		public void setPocket(Set<String> bead)
		// 		public Set<String> setPocket()
		// 		private Properties beadCnt; 구슬의 종류를 가지고 갯수 설정..
		//			set/get 선언 xml 에서 처리..
		
		//		xml에서 구슬을 저장하고,
		// 		main()에서 getPocket()을 통해 저장된 구슬을 확인하셍
		Gamer gamer01 = ctx.getBean("gamer01",Gamer.class);
		gamer01.showMyPocket();
		System.out.println(gamer01.getBeadCnt());
		// 프로퍼티스객체.stringPropertyNames() : 
		// 해당 프로퍼티의 key들을 가져온다.
		// 프로퍼티스객체.getProperty(key)
		// 키의 값을 가져온다.
		for(String key:gamer01.getBeadCnt().stringPropertyNames()) {
			String value = gamer01.getBeadCnt().getProperty(key);
			System.out.println( key+":"+value);
		}
		Monitor monitor = ctx.getBean("monitor",Monitor.class);
		System.out.println(monitor.getConfig());
		/*
		Student 클래스 선언
		 	private Map<String, Integer> records;
			로 set/get메서드 선언해서 호출하세요.
		*/
		Student student = ctx.getBean("student",Student.class);
		System.out.println(student.getRecords());
		ctx.close();
		System.out.println("종료");
	}
}
