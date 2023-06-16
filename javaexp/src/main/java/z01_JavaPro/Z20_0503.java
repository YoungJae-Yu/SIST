package javaexp.z01_JavaPro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Z20_0503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2023-05-03
//		[1단계:개념] 1. set객체의 특징을 예제를 통하여 기술하세요
		Set<String> set = new HashSet<String>();
		set.add("새우깡");// 특징 : 저장순서가 유지되지 않음.
		set.add("새우깡");//		 객체를 중복 저장 불가
		set.add("바나나킥");//      하나의 null만 저장 가능
		set.add("바나나킥");
		set.add("바나나킥");
		set.add("홈런볼");
		set.add("홈런볼");
		set.add("홈런볼");
		System.out.println("저장된 set과자");
		for(String snacks:set) {
			System.out.println(snacks);
		}
		/*출력
		저장된 set과자
		새우깡
		바나나킥
		홈런볼*/
		
//		[1단계:확인] 2. 사과, 바나나, 딸기, 오렌지, 수박을 랜덤으로 10회 Set 주머니에 넣었을 때, 들어간 과일의 종류를 출력하세요.
		String fruits[] = {"사과","바나나","딸기","오렌지","수박"};
		Set<String> set1 = new HashSet<String>();
		System.out.println("과일 10회 주머니에 넣다!");
		for(int cnt=0;cnt<10;cnt++) {
			int r = (int)(Math.random()*5);
			set1.add(fruits[r]);
		}
		System.out.println("과일의 종류");
		for(String fl:set1) {
			System.out.println(fl);
		}
		/*출력
		과일 10회 주머니에 넣다!
		과일의 종류
		수박
		오렌지
		사과
		바나나*/
		
//		[1단계:개념] 3. map객체의 특징을 기본 예제를 통하여 설명하세요
		//문자열key, 문자열value으로 설정 map 선언과 할당.
		  Map<String, String> map01 = new HashMap<String, String>();
		  map01.put("1000", "홍길동");
		  map01.put("1000", "김길동"); //키를 중복
		  map01.put("1001", "오길동"); 
		  map01.put("1002", "오길동"); //값을 중복
		  // map01.keySet() 키를 Set객체로 가져오는 메서드
		  for(String key:map01.keySet()) {
		     System.out.println(key+"\t");
		 // .get(key): 해당 key에 대한 값을 가져온다.
		     System.out.println(map01.get(key)+"\n");
		  }
		  /*출력
		  1002	
		  오길동

		  1001	
		  오길동

		  1000	
		  김길동*/
		  
//		[1단계:확인] 4. map으로 회원의 정보를 저장할려고 한다. 저장하고 저장된 정보를 호출할 때, 
//		  				동일한 id로 회원 정보를 입력하고 변경되는 회원 정보를 처리해보세요.
		    /*
		     * 1. 회원정보설정(아이디 제외)
		     * 2. class 정의(회원정보 설정) Member
		     * 3. Map<String, Member>
		     * 4. 회원등록
		     *    mem.put("himan",new Member("홍길동","관리자","7777"));
		     *    mem.put("girlman",new Member("홍길동","관리자","7777"));
		     * 5. 회원정보수정 : 마지막에 추가된 위에 선언된 key값.....
		     * 	  mem.put("himan",new Member("김길동","관리자","9999"));
		     */
        Map<String, Member> mems = new HashMap<String, Member>();
        //등록
        mems.put("himan", new Member("홍길동",25,"관리자",1000));
        mems.put("higirl", new Member("홍리나",27,"일반사용자",2000));
        mems.put("goodMan", new Member("박길동",28,"사용자",4000));
        //수정
        mems.put("himan", new Member("김길동",26,"일반사용자",3000));
        //삭제
        mems.remove("higirl");
        for(String id:mems.keySet()) {
        	Member m = mems.get(id);
        	System.out.print(id+"\t");
        	System.out.print(m.getName()+"\t");
        	System.out.print(m.getAuth()+"\t");
        	System.out.print(m.getPoint()+"\n");
        }
		  
		  
//		Map<String, Mumber>stdMap = new HashMap<String, Mumber>();  
//		stdMap.put("yy11", new Mumber("홍길동"));
//	    stdMap.put("yy11", new Mumber("김길동"));
//	    for(String ml:stdMap.keySet()) {
//	    	Mumber st = stdMap.get(ml);
//	         System.out.println("ID:"+ml);
//	         System.out.println(st.getName()+"\t");
//	    }//검토 필요
	    
//		[1단계:개념] 5. 입력처리하는 기본 객체와 출력 처리하는 기본 객체를 기본예제를 통해 설명하세요.
	    System.out.println("문자를 입력하세요.");
	    InputStream is01 = System.in;//InputStream 객체를 리턴하는 객체
		try {
			int data = is01.read();
			OutputStream os01 = System.out;//OutputStream객체를 리턴하는 객체
			System.out.print("입력내용:");
			os01.write(data);//write(dyte) : 코드값을 출력
			os01.flush();//자원해제
		}catch(IOException e) {
			e.printStackTrace();
		}
//		[1단계:확인] 6. c:\a01_javaexp\z01_fileExp\ 하위에 a1~a9폴드가 생성되고, 각 폴드에 show01.txt~show09.txt 파일을 생성해보세요.
//		[1단계:확인] 7. c:\a01_javaexp\z01_fileExp\a1\show01.txt에 입력받은 물건명/가격/갯수 정보를 저장하세요.
	}

}
class Member{
	private String name;
	private int age;
	private String auth;
	private int point;
	public Member(String name, int age, String auth, int point) {
		this.name = name;
		this.age = age;
		this.auth = auth;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}












