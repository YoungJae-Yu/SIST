package javaexp.z01_JavaPro;

import java.util.ArrayList;

public class Z15_0424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2번 예제 출력
		Food f1 = new Pizza();
		Food f2 = new Sandwich();
		Food f3 = new ChocolateMuffin();
		f1.eat();f1.taste();
		f2.eat();f2.taste();
		f3.eat();f3.taste();
//		3번 예제 출력
		DailyFoodSchedule d = new DailyFoodSchedule("홍길동");
		d.menu(f1);
		d.showMenu();
	}

}
//2023-04-19
//[1단계:개념] 1. 추상클래스와 일반 재정의 클래스의 차이점을 예제를 통해 기술하세요
/*
# 차이점
1. 상위 객체생성의 독립성
	일반 클래스는 가능하지만, 추상클래스는 불가능하다.
	ex) 추상클래스 참조 = new 추상클래스();(X)
2. 메서드의 재정의 강제성
	일반 클래스의 메서드는 재정의가 선택적이지만
	추상클래스의 추상메서드는 반드시 재정의 하여야 한다.
 */
abstract class Chicken{ //추상클래스
	private String name;
	public Chicken(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public abstract void kind();// 상속받는 하위에서 *반드시* 재정의 메서드
} // 위에 있는 abstract을 재정의하지 않으면 컴파일 에러. 추상클래스와 일반재정의클래스의 차이
class FriedChicken extends Chicken{
	FriedChicken(){
		super("프라이드치킨");
	}
	@Override
	public void kind() {
		// TODO Auto-generated method stub
		System.out.println("맛있는"+getName()+"이 되었습니다..");
		
	}
}
//[1단계:개념] 2. Food를 추상클래스로 선언하고, name(음식종류), eat()공통메서드 @@을 먹다,
//			   taste()추상메서드로 다양한 맛을 출력
//		       좋아하는음식 3가지를 실제클래스를 선언하여 출력하세요.
abstract class Food{
	private String name;
	public Food(String name) { // 음식의 종류
		this.name = name; 
	}
	public String getName() {
		return name;
	}
	public void eat() {
		System.out.print(name+"을(를) 먹다,"); // @@을 먹다 메서드
	}
	public abstract void taste(); // 추상메서드
}
class Pizza extends Food{
	
	public Pizza() {
		super("피자");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.println("모짜렐라 치즈와 올리브, 페퍼로니, 피망, 도우, 피자소스 등 풍미가득한 맛");	
	}	
}
class Sandwich extends Food{
	
	public Sandwich() {
		super("샌드위치");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void taste() {
		// TODO Auto-generated method stub
		// public으로 getName()으로 공통메서드를 통해 필드를 호출
		System.out.println("플랫위에 베이컨과 페퍼로니와 체다치즈를 올리고 올리브와 할라피뇨를 넣은 달콤하고 이색적인 맛");	
	}	
}
class ChocolateMuffin extends Food{
	
	public ChocolateMuffin() {
		super("초코머핀");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void taste() {
		// TODO Auto-generated method stub
		System.out.println("황금숙성비율로 반죽과 초콜릿의 조합을 이뤄낸 버섯모양의 머핀의 기분좋은 달콤한 맛");	
	}	
}
//[1단계:확인] 3. 위 내용을 DailyFoodSchedule로 1:다 관계로 먹는 사람과 일일 식사메뉴 
//				3개를 Food타입 리스트로 처리할 수 있게 기능메서드 선언하여 출력하세요.
class DailyFoodSchedule{
	private String name;
	private ArrayList<Food> fnames;
	public DailyFoodSchedule(String name) {
		this.name = name;
		fnames = new ArrayList<Food>();
	}
	public void menu(Food food) {
		fnames.add(food);
		System.out.println(name+"은(는) "+food.getName()+"을 먹는다!");
	}
	public void showMenu() {
		System.out.println(name+"의 오늘 식사 ~~");
		if(fnames.size()>=0) {
			for(Food f:fnames) {
				f.eat();
				f.taste();
			}
		}else {
			System.out.println("식사 메뉴가 선택되지 않았습니다.");
		}
	}
}
//[1단계:개념] 4. 인터페이스의 구성요소의 특징을 예제와 함께 선언하세요
/*
1. 필드 : public static final가 생략 (인터페이스.필드-독립적사용)
2. 재정의 추상메서드 : public abstract 생략 (하위객체를 통해서만 사용가능)
3. default 실제메서드 : 공통기능메서드 (하위객체를 통해서만 사용가능)
4. static 실제메서드 : 공통기능메서드(인터페이스.메서드()-독립적사용)
 */

interface Eat{//public static final 생략
	String EAT="먹다";
	void eat();//public abstract 생략
}// 디폴트 메서드, 정적 메서드 지원

//[1단계:확인] 5. FishingWay goFishing() 인터페이스를 선언하여, 상속받은 실제클래스를 2개를 선언하고,
//				실제클래스 Fisher에 이름과 인터페이스 FishingWay를 선언하고
//      		addFishingSkill() 할당하게 하면  해당 어부가 낙시하는 
//				goFishing()메서드를 호출하여 처리하세요.
/*
인터페이스 처리 2단계
FishingWay(goFishing())

SeaFishing 바다 낚시 기술을 가졌다.
RiverFishing 강가 낚시 기술을 가졌다.

Fisher
	FishingWay way;
	
	void addFishingSkill(FishingWay way(
		this.way = way; // 하위 실제객체에 따라. 처리될 내용할당.
		
	void goFishing()
		if(way!=null)
			way.goFishing()
		else
			낚시 기술이 없네요..
		
 */



























