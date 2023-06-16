package javaexp.a10_exception;

public class A11_UserException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rd = (int) (Math.random()*2)+1;
		System.out.println("나온 수:"+rd);
		try {
			if(rd == 1) {
				throw new User02Exception("랜덤수가 1인 경우에 예외 던지기");
			}
		}catch(User02Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
// ex) User02Exception으로 예외 클래스를 사용자 정의로 선언하고
//	main()에서 임의의 수(Math.random()- 1~2가 발생할 때,
//	1인 경우 예외 객체를 던져 처리되게 하세요..
class User02Exception extends Exception{
	User02Exception(String errMsg){
		super("예외! 1이 나왔습니다.");
	}
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		return msg;
	}
	// 여러가지 처리할 기능적인 메서드...
}
