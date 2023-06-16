package javaexp.a08_relation.vo;

public class Matching {

   public static void main(String[] args) {

      Man m1 = new Man("홍길동",25,"농부");      // 남자1명 m1 에 할당.
      Woman w1 = new Woman("홍길순",21,"모델");      // 여자1명 w1 에 할당.
      Matching match = new Matching();    
      m1.addMan();
      w1.addWoman();
      match.match(m1, w1);
   }

   private Man man;
   private Woman woman;
   
   public Matching() {}
   
   public Matching(Woman woman) {
      this.woman = woman;
   }
   
   public Matching(Man man, Woman woman) {
      this.man = man;
      this.woman = woman;
   }
   public void match(Man man, Woman woman) {
	   if(man==null) {
	       System.out.println("남성이 없습니다");
	   }else if(woman == null) {
	       System.out.println("여성이 없습니다");
	   }else{
		   System.out.println(man.getMname()+"님과 "+woman.getWname()+"님의 매칭이 성사되었습니다.");
	   }
   }
}