package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z02_vo.Dept;
import a01_diexp.z02_vo.Member;
import a01_diexp.z02_vo.Music;

public class DIExp19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너 경로
		String path="a01_diexp\\di19.xml";
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(path);
		// DL(Dependency Lookup) 객체를 찾는 처리
		/*
		z03_vo
			Music, Dept, Member 복사해서 위치시키고
		해당 패키지에 있는 객체를 사용할 수 있게 처리한 후
		호출하세요
		 */
		// 객체 선언
		Music music = ctx.getBean("music", Music.class);
		Dept dept = ctx.getBean("dept", Dept.class);
		Member member = ctx.getBean("member", Member.class);
		
		// 값할당
		music.setMname("좋은날");
		music.setSinger("아이유");
		dept.setDname("IT개발");
		member.setPoint(5000);
		member.setName("홍길동");
		
		// 호출
		music.listening();
		dept.joining();
		member.showInfo();
		
		ctx.close();
		System.out.println("종료");
	}

}
