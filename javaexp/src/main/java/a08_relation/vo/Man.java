package javaexp.a08_relation.vo;

public class Man {
   private String mname;
   private int age;
   private String job;

   public Man() {}
   
   public void addMan() {
	   System.out.println("이름:"+mname);
	   System.out.println("나이:"+age);
	   System.out.println("직업:"+job);
	   System.out.println("남자가 등록되었습니다.");
	   }
   
   public Man(String mname, int age, String job) {
      this.mname = mname;
      this.age = age;
      this.job = job;
   }
   public String getMname() {
      return mname;
   }
   public void setMname(String mname) {
      this.mname = mname;
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