package javaexp.z01_JavaPro;

public class Z11_0417 {

	public static void main(String[] args) {
		
//      2023-04-17
//      [1단계:조별확인] 1:1관계 개념을 옆에 있는 조원과 함께 이해 했는지 확인하고 의견을 나누고 정리해보세요.
//         1) 1:1관계 객체를 선언하고 만드는 상황을 어떤 상황인지?
//      class의 선언에서 앞으로 사용될 객체를 내부에서 호출하여 사용하는 것을 말한다.
//      객체지향 프로그램에서 여러개의 객체를 사용하는 첫단계라고 할 수 있다.
//         2) 1:1관계 객체 처리할 수 있는지? yes
//         3) 다른 객체 추가 메서드 this.객체 = 객체를 이해하고 있는지? yes
//         4) if(참조==null) 코드는 언제 왜 사용하는지?
//            ==> 외부에서 입력받은 참조 데이터가 정상적으로 입력됐는지 확인하는 과정
//            null인 경우에는 값이 할당되지 않음을 의미
//         5) 위 내용을 이해 기반으로 커플매칭 사이트에서 Woman/Man 처리해보세요.
//      package javaexp.a08_relation.vo;
//
//      public class Man {
//         private String mname;
//         private int age;
//         private String job;
//
//         public Man() {}
//
//         
//         /*
//          * public void showManInfo() { System.out.println("이름:"+mname);
//          * System.out.println("나이:"+age); System.out.println("직업:"+job); }
//          */
//         
//         public Man(String mname, int age, String job) {
//            this.mname = mname;
//            this.age = age;
//            this.job = job;
//            System.out.println("이름:"+mname);
//            System.out.println("나이:"+age);
//            System.out.println("직업:"+job);
//            System.out.println(mname+"(남)객체 생성.");
//         }
//         public String getMname() {
//            return mname;
//         }
//         public void setMname(String mname) {
//            this.mname = mname;
//         }
//         public int getAge() {
//            return age;
//         }
//         public void setAge(int age) {
//            this.age = age;
//         }
//         public String getJob() {
//            return job;
//         }
//         public void setJob(String job) {
//            this.job = job;
//         }
//         
//      }
//
//
//      public class Woman {
//         private String wname;
//         private int age;
//         private String job;
//         
//         public Woman() {}
//         
//         /*
//          * public void showWomanInfo() { System.out.println("이름:"+wname);
//          * System.out.println("나이:"+age); System.out.println("직업:"+job); }
//          */
//         
//         public Woman(String wname, int age, String job) {
//            this.wname = wname;
//            this.age = age;
//            this.job = job;
//            System.out.println("이름:"+wname);
//            System.out.println("나이:"+age);
//            System.out.println("직업:"+job);
//            System.out.println(wname+"(여) 객체 생성.");
//         }
//         
//         public String getWname() {
//            return wname;
//         }
//         public void setWname(String wname) {
//            this.wname = wname;
//         }
//         public int getAge() {
//            return age;
//         }
//         public void setAge(int age) {
//            this.age = age;
//         }
//         public String getJob() {
//            return job;
//         }
//         public void setJob(String job) {
//            this.job = job;
//         }
//      }
//
//
//      public class Matching {
//
//         public static void main(String[] args) {
//
//            Man m1 = new Man("홍길동",25,"농부");      // 남자1명 m1 에 할당.
//            System.out.println("-----------------");
//            Woman w1 = new Woman("홍길순",21,"모델");      // 여자1명 w1 에 할당.
//            System.out.println("-----------------");
//            Matching match = new Matching();    
//            match.match();
//            match.addMan(m1);
//            match.addWoman(w1);
//            match.match();
//         }
//
//         private Man man;
//         private Woman woman;
//         
//         public Matching() {}
//         
//         public Matching(Woman woman) {
//            this.woman = woman;
//         }
//         
//         public Matching(Man man, Woman woman) {
//            this.man = man;
//            this.woman = woman;
//         }
//         
//         public void addWoman(Woman woman) {
//            this.woman = woman;
//            System.out.println(woman.getWname() + "(여)님이 사이트에 등록되었습니다.");
//         }
//         public void addMan(Man man) {
//            this.man = man;
//            System.out.println(man.getMname() + "(남)님이 사이트에 등록되었습니다.");
//         }
//         
//         public void match() {
//            if(man==null || woman==null) {
//                System.out.println("등록된 여성 혹은 남성이 없어서 매칭할 수 없습니다.");
//            }else{
//               System.out.println(man.getMname()+"님과 "+woman.getWname()+"님의 매칭이 성사되었습니다.");
//            }
//         }
//      }
      
//      --- 결과 ---
//      이름:홍길동
//      나이:25
//      직업:농부
//      홍길동(남)객체 생성.
//      -----------------
//      이름:홍길순
//      나이:21
//      직업:모델
//      홍길순(여) 객체 생성.
//      -----------------
//      등록된 여성 혹은 남성이 없어서 매칭할 수 없습니다.
//      홍길동(남)님이 사이트에 등록되었습니다.
//      홍길순(여)님이 사이트에 등록되었습니다.
//      홍길동님과 홍길순님의 매칭이 성사되었습니다.		
//		[1단계:개념] 1. 1:1 관계 객체 구현 순서를 예제를 통해 처리하세요.
//		ex) 필통 class, 필기구 class
		
		
		
//		[1단계:개념] 2. 객체형 배열의 처리 과정을 기본 예제와 함께 설명하세요.
//		[1단계:확인] 3. 아래의 2차원 데이터를 객체형 배열로 선언하고 출력하세요.
//		      1) 구매물건리스트(물건명,가격,구매갯수)
//		      2) 회원정보리스트(회원아이디, 패스워드, 회원명, 포인트, 권한)
//		[1단계:개념] 4. select 콤보박스의 속성을 각 속성값에 따른 기능적 차이와 함께 기술하세요.
//		[1단계:개념] 5. input의 속성에 따른 속성값을 차이를 기술하세요.
//		[1단계:확인] 6. 아래 사이트의 회원가입화면을 form요소객체를 table 안에서 적절히 활용하여 처리하세요.(css적용 제외)
//		      https://www.storyum.kr/story/main/contents.do?menuNo=500018&siteId=5
//		      에 (기본정보입력 항목)에 맞게 처리하세요
		
		
	}

}

