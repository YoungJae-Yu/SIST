package javaexp.a12_collection;

import java.util.ArrayList;

public class A01_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
  # List 컬랙션 
      1. 특징 
           1) 인덱스로 관리
           2) 중복해서 객체 저장 기능 
      2. 구현 실제 클래스
          ArrayList
          Vector
          LinkedList
      3. 공통메서드
          1) *boolean add(추가할 객체): 제일 마지막에 추가
          2) void add(int indext, 추가객체): 특정한 위치에 추가 
          3) set(int index, 변경할 객쳬)
          4) boolean contains(요소 객체): 요소객체 있는지 여부
          5) *get(index): 특정위치에 있는 요소객체 가져오기 
          6) *boolean isEmpty(): 컬랙션이 비어 있는지 확인
          7) *int size(): 크기
          8) void clear(): 포함된 모든 객체 삭제
          9) remove(int index): 해당 위치의 객체 삭제
          10) boolean remove(Object o): 주어진 객체 삭제
          
       **/
      // 인터페이스 List = ArrayList 처리.. 
      ArrayList<String> flist = new ArrayList<String>();
      flist.add("사과");
      flist.add("수박");
      flist.add("참외");
      flist.add(0,"오렌지"); // 특정위치 추가 
      flist.set(1, "키위"); // 특정위치 변경
      System.out.println("있는지 여부:"+flist.contains("키위"));
      if(flist.isEmpty()) {
         System.out.println("없음.");
      }else {
         System.out.println("크기가:"+flist.size());
      }
      flist.remove(1); // 두번째 내용 삭제..
      System.out.println("현재 데이터 내용");
      for(int idx=0;idx<flist.size();idx++) {
         System.out.println(idx+1+")"+flist.get(idx));
      }
      flist.clear();
      System.out.println("비어 있는지?"+flist.isEmpty());   
      //ex) List<String>형태로 회원 3명의 아이디를 추가하고 
      //    1) 특정 회원을 1번째 위치에 추가
      //    1) 2번째 특정 회원을 변경처리 
      //    1) "himan"이 있는지 확인
      //    4) 마지막 회원을 삭제 처리 
      //    5) 전체 회원 리스트 출력..
      ArrayList<String> mlist = new ArrayList<String>();
      mlist.add("higirl2");
      mlist.add("sk99822");
      mlist.add("himan");
      mlist.add("atom11");
      mlist.add(0,"byeman"); //1번째 위치에 추가..
      System.out.println("himan이 있는지 여부:"+mlist.contains("himan"));
      mlist.remove(mlist.size()-1); //마지막 회원 삭제..
      for(int idx=0;idx<mlist.size();idx++) {
         System.out.println(idx+1+")"+mlist.get(idx));
      }
		//////////////////////////////////////////////////
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person("홍길동",23,"서울"));
		plist.add(new Person("김길동",24,"부산"));
		plist.add(new Person("박길동",27,"대구"));
		plist.add(new Person("이길동",26,"광주"));
		plist.add(new Person("황길동",25,"제주"));		
		Person p01 = plist.get(1);
		System.out.println("두번째 객체의 이름:"+p01.getName());
		System.out.println("다섯번째 객체의 이름:"+plist.get(4).getName());
		//ex) list forEach, for(int idx) 구문을 처리해보세요.
		System.out.println("이름\t나이\t사는곳");
		for(Person pt:plist) {
			System.out.print(pt.getName()+"\t");
			System.out.print(pt.getAge()+"\t");
			System.out.print(pt.getLoc()+"\n");
		}
		for(int idx=0;idx<plist.size();idx++) {
			Person p = plist.get(idx);
			System.out.print(p.getName()+"\t"); 
			System.out.print(p.getAge()+"\t"); 
			System.out.print(p.getLoc()+"\n"); 
		}
		
		// ex) Student 반, 번호, 이름, 점수 속성 VO ArrayList에 할당
		// 		3개 할당 후 , 마지막개체의 이름 호출, 첫번째 객체의 점수호출
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(new Student(1,1,"김민수",80));
		slist.add(new Student(1,2,"김황길",70));
		slist.add(new Student(1,3,"김득수",60));
		Student s01 = slist.get(2);
		System.out.println("마지막개체의 이름:"+s01.getName());
		System.out.println("첫번째객체의 점수:"+slist.get(0).getScore());
		System.out.println("반\t번호\t이름\t점수");
		for(Student st:slist) {
			System.out.print(st.getSclass()+"\t");
			System.out.print(st.getNum()+"\t");
			System.out.print(st.getName()+"\t");
			System.out.print(st.getScore()+"\n");
		}
	}

}
class Student{
	private int sclass;
	private int num;
	private String name;
	private int score;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int sclass, int num, String name, int score) {
		this.sclass = sclass;
		this.num = num;
		this.name = name;
		this.score = score;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		this.sclass = sclass;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

class Person{
	private String name;
	private int age;
	private String loc;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age, String loc) {
		this.name = name;
		this.age = age;
		this.loc = loc;
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
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}	
}