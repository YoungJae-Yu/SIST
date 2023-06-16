package javaexp.a09_inherit.vo;

public class Father {
   String shape="통통하다";
   private int age=30; // 접근제어자 private 직접외부에서 접근할 수 없음.
   void running() {
      System.out.println("빠르게 달린다.");
   }
   void addAge(int age) {// 간접적으로 추가하거나
	   age+=age;
   }
   int getAge() {// 간접적으로 호출가능..
	   return age;
   }
}