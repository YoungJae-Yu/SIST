package javaexp.a08_relation.vo;

public class Woman {
   private String wname;
   private int age;
   private String job;
   
   public Woman() {}
   
   public void addWoman() {
	   System.out.println("이름:"+wname);
	   System.out.println("나이:"+age);
	   System.out.println("직업:"+job);
	   System.out.println("여자가 등록되었습니다.");
	   }
   
   public Woman(String wname, int age, String job) {
      this.wname = wname;
      this.age = age;
      this.job = job;
   }
   public String getWname() {
      return wname;
   }
   public void setWname(String wname) {
      this.wname = wname;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public String getJob() {
      return job;
   }
   public void setJob(String job) {
      this.job = job;
   }
   
   
   
}

