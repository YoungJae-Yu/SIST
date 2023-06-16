//package javaexp.z01_JavaPro;
//
//public class Z13_0419 {
//	
//	public static void main(String[] args) {
//	2023-04-18
//	[1단계:조별] 1. 접근제어자에 이해와 구현
//	      1) 접근제어자의 4가지 이해하고 설명할 수 있는가? 
//			1) public : 외부패키지의 클래스에서도 접근가능
//			2) X (default) : 패키지가 같은 클래스에서 접근가능
//			3) protected : 상속관계에 있는 클래스에서만 사용할 수 있음. 외부패키지에서도 상속관계라면 접근 가능
//			4) private :   외부 클래스는 접근할 수 없음. (해당 클래스에서만 사용 가능)
//	      2) 접근제어자에 맞게 구현할 수 있는가? yes
//	      3) default와 protected의 상속관계 객체내에서 호출시 어떤 문제가 있고, 원인은 무엇인가?
//			문제 : 외부 패키지에 있을 시 default는 접근 불가
//			원인 : 외부 패키지 이기 떄문에
			/*
			# 상위관계 외부 패키지 클래스에서
				protected 접근제어자가 설정된 필드에 대하여
				객체 생성형식으로 호출하면 접근을 할 수 없고,
				반드시 상속관계에서 호출하는 형식으로 처리하여야 접근이 가능.
			*/


//      4) 아래 구조에 의해 접근제어자에 따른 호출 내용을 처리해 보자.
//      1) 패키지1/ 참외
//package javaexp.a08_relation.access.pck3;
//
//import javaexp.a08_relation.access.pck1.OrientalMelon;
//
//public class WaterMelon extends OrientalMelon {
//
//   public void fInfo1(){
//         OrientalMelon f = new OrientalMelon();
////         System.out.println("private:"+f.taste);
////         System.out.println("default(X):"+f.price);
////         System.out.println("protected:"+f.cnt);
//      // Oriental 클래스에 public 으로 선언된 변수에만 "객체 생성 후" 접근할 수 있다. 
//         System.out.println("public:"+f.store);
//      }
//      // 상속 클래스
//      public void fInfo2(){
////         System.out.println("private:"+taste);
////         System.out.println("default(X):"+price);
//               // 외부 패키지에 있는 상속관계에서 protected와 public은 접근 가능
//         System.out.println("protected:"+cnt);
//         System.out.println("public:"+store);
//      }
//}

//         / 사과, 바나나, 딸기
		//package javaexp.a08_relation.access.pck1;
		//
		//import javaexp.a08_relation.access.pck1.OrientalMelon;
		//
		//public class Apple{
		//
		//   public void fInfo1(){
//		         OrientalMelon f = new OrientalMelon();
//		         System.out.println("private:"+f.taste); // 접근불가
//		         System.out.println("default(X):"+f.price);
//		         System.out.println("protected:"+f.cnt);
//		         System.out.println("public:"+f.store);
//		      }

//         /멜론(참외상속)
//package javaexp.a08_relation.access.pck1;
//
//import javaexp.a08_relation.access.pck1.OrientalMelon;
//
//public class Melon extends OrientalMelon {
//
//   public void fInfo1(){
//         OrientalMelon f = new OrientalMelon();
//         System.out.println("private:"+f.taste);
//               // private, 직접적인 접근 불가
//         System.out.println("default(X):"+f.price);
//         System.out.println("protected:"+f.cnt);
//         System.out.println("public:"+f.store);
//      }
//      // 상속 클래스
//      public void fInfo2(){
//         System.out.println("private:"+taste);
//               // private, 상속 관계에서도 직접적인 접근 불가
//         System.out.println("default(X):"+price);
//         System.out.println("protected:"+cnt);
//         System.out.println("public:"+store);
//      }
//}
//      2) 패키지2/ 당근, 양파
		//package javaexp.a08_relation.access.pck2;
		//
		//import javaexp.a08_relation.access.pck1.OrientalMelon;
		//
		//public class WaterMelon{
		//
		//   public void fInfo1(){
//		         OrientalMelon f = new OrientalMelon();
//		         System.out.println("private:"+f.taste);
//		         System.out.println("default(X):"+f.price);
//		         System.out.println("protected:"+f.cnt);
//		 			public만 접근 가능.
//		         System.out.println("public:"+f.store);
//		      }
//      3) 패키지3/ 수박(참외상속)
//package javaexp.a08_relation.access.pck3;
//
//import javaexp.a08_relation.access.pck1.OrientalMelon;
//
//public class WaterMelon extends OrientalMelon {
//
//   public void fInfo1(){
//         OrientalMelon f = new OrientalMelon();
//         System.out.println("private:"+f.taste);
//         System.out.println("default(X):"+f.price);
//         System.out.println("protected:"+f.cnt);
//      // Oriental 클래스에 public 으로 선언된 변수에만 "객체 생성 후" 접근할 수 있다. 
//         System.out.println("public:"+f.store);
//      }
//      // 상속 클래스
//      public void fInfo2(){
//         System.out.println("private:"+taste);
//         System.out.println("default(X):"+price);
//               // 외부 패키지에 있는 상속관계에서 protected와 public은 접근 가능
//         System.out.println("protected:"+cnt);
//         System.out.println("public:"+store);
//      }
//}		
//	[1단계:개념] 2. this.필드, this()의 사용에 있어서 차이점을 예제로 기술하세요.
//		Product p02 = new Product("홍시",3500,5);
//		class Product{
//			String name;
//			int price;
//			int cnt;
//			public Product() {
//				System.out.println("객체 Product 생성:"+this);
//			}
//			
//			public Product(String name) {
//				this();
////				생성자가 overriding으로 여러개 선언되어 있을 때,
////				다른 생성자를 호출해서 데이터를 할당할 때, 사용된다.
////				- 호출시, 반드시 생성자 선언 첫라인에서 호출하여야 한다.
//				this.name = name; 
//				//this 클래스 안에서 객체를 지칭할 때, 이 객체가 가지고 있는 구성요소를 호출할 때, 주로 사용된다.
//				System.out.println("매개변수1 - 물건명:"+name);
//			}
//
//			public Product(String name, int price) {
//				this(name);
//				this.price = price;
//				System.out.println("매개변수2 - 가격:"+price);
//			}
//
//			public Product(String name, int price, int cnt) {
//				this(name, price);
//				this.cnt = cnt;
//				System.out.println("매개변수3 - 갯수:"+cnt);
//			}
//		}
//	[1단계:확인] 3. Team(팀명,승,무,패,승률)을 생성자의 매개변수(0~5)로 오버 로딩 선언하여 this()로 호출 처리하게 하세요
//		Team p01 = new Team("라이트닝",6,2,1);
//	}
//}
//class Team{
//	String tName;
//	int win;
//	int los;
//	int draw;
//	double winningRate;
//	public Team() {}
//	public Team(String tName) {
//		this();
//		this.tName = tName;
//		System.out.println("팀명:"+tName);
//	}
//	public Team(String tName, int win) {
//		this(tName);
//		this.win = win;
//		System.out.println("승:"+win);
//	}
//	public Team(String tName, int win, int los) {
//		this(tName, win);
//		this.los = los;
//		System.out.println("패:"+los);
//	}
//	public Team(String tName, int win, int los, int draw) {
//		this(tName, win, los);
//		this.draw = draw;
//		System.out.println("무:"+draw);
//		System.out.println("승률:"+(double)win/(win+los+draw)+"%");
//	}
//	public Team(String tName, int win, int los, int draw, int winningRate) {
//		this(tName, win, los, draw);
//		this.winningRate = winningRate;
//		
//	}
//
//}
		
//	[1단계:개념] 4. this, super의 차이를 상속관계에서 필드, 생성자, 메서드의 관점에서 예제를 통해 기술하세요.
//		Mname w1 = new Mname();
//		w1.working();
//	}
//}
//class study{
//	private String study;
//	public study(String study) {
//		this.study = study;// this 현재 클래스가 가지고 있는 멤버를 지칭
//	}
//	public void working() {
//		System.out.println(study+"공부중입니다.");
//	}
//}
//class Mname extends study{
//
//	public Mname() {
//		super("JAVA");//super 는 상위클래스가 가지고 있는 멤버를 지칭
//		
//	}
//	public void working() {
//		System.out.println("저는 ");
//		super.working();
//	}
//}
//	[1단계:개념] 5. 메서드 오버라이딩(overriding)을 메서드 오버로딩(overloading)과의 차이점을 기술해보세요.
//		오버라이딩 : 부모 클래스의 상속 메서드를 동일한 이름(매개변수)으로 다시 자식 클래스에서 재정의하는 것을 말한다.
//		오버로딩 : 자바의 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메소드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메소드를 정의할 수 있다.
