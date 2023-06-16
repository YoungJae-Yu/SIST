package javaexp.a08_relation.vo;

public class MusicVO {
	// 필드는 접근제어자를 private 선언(직접 접근이 안되고 간접접근 처리)
	private String title;
	private String name;
	private int year;
//	생성자나 메서드의 접근제어자는 public
	public MusicVO() {
		// TODO Auto-generated constructor stub
	}
	public MusicVO(String title, String name, int year) {
		this.title = title;
		this.name = name;
		this.year = year;
	}
	
}
