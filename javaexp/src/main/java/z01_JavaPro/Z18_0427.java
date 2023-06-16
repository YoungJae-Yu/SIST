package javaexp.z01_JavaPro;

public class Z18_0427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		[1단계:개념] 6. Object의 메서드의 기능을 기술하세요.
		// hashCode() 10진수로 고유코드값을 가져온다.
		// toString() 으로 정의된 내용이 출력된다.
		// deplicated() 폐기될 예정
//		[2단계:확인] 7. 물건명, 가격, 갯수를 필드로 하는 Product클래스를 생성하고 사용하되, 
//		재정의하여 객체 생성 후, 참조 변수를 호출했을 때, 물건명/가격/갯수/총계를 출력할려면 처리해야 할 내용은?
		Product p = new Product("사과",3000,5);// 재정의 후 객체 할당
		System.out.println(p.toString()); // 참조변수 호출
//		[1단계:개념] 8. String의 비교연산자의 비교와 equals()처리 형식의 차이점에 대하여 기술하세요
		/*
		String n = "홍길동"; ==> 특정한 heap 영역에 위치 할당
        String n1 = new String("홍길동"); ==> 무조건 다른 위치(heap) 생성 및 할당
        heap주소값이 다르기떄문에 문자열은 같지만 stack영역의 데이터를 비교하는 비교연산자를 사용하면
        false가 나온다.
        이를 해결하려면 equals()를 사용해서 비교 해주어야 한다.
        */
//		[1단계:개념] 9. String 생성자의 주요 매개변수를 통한 처리 내용을 기술하세요
	   /*new String(byte[]) **
           최종프로젝트 활용(아이디를 잊었을 때, 임시비밀번호 생성
                         회사에서 최초사번과 임시비밀번호 발급)
         new String(char[]) ex) 랜덤값을 활용하여 비밀번호 생성 등 char[]아스키코드를 활용 가능하다
         new String("문자열")*/
//		[1단계:확인] 10. 임시비밀번호를 알파벳 대소문자 숫자를 조합해서 10자를 만드는 프로그램을 만드세요
	      char [] arr = new char[10];
	         for(int idx=0; idx<arr.length;idx++) {
	            int ranNum = (int)(Math.random()*62+48);
	            if(ranNum>57) ranNum +=7; // 58~64 65가 A
	            if(ranNum>90) ranNum +=6; // 91~96 97이 a
	            arr[idx] = (char)ranNum;
	         }
	         String str = new String(arr);
	         System.out.println("알파벳 대소문 숫자 임의:"+str);
//		[2단계:확인] 11. charAt()를 활용하여, 우리나라에서 가장 많은 성 1~10, 가장 많이 사용하는 이름 중간자, 가장 많이 사용하는 마지막자를 조합하여 임의의 이름 3개를 출력하세요
	         
	}

}
/*7번 예제*/
class Product{
	private String name;
	private int price;
	private int num;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "참조변수의 값!\n물건명:"+name+"\n가격:"+price+"\n갯수:"+num;
	}
	public Product(String name, int price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
}