package javaexp.a08_relation.vo;

public class Cpu {
	private String company;
	private String spec;
	// Cpu cp01 = new Cpu("애플","M2 12core")
	public Cpu(String company, String spec) {
		this.company = company;
		this.spec = spec;
	}
	public void showInt() {
		System.out.println("#CPU정보#");		
		System.out.println("제조사:"+company+"\n사양:"+spec);		
	}
	
	public Cpu() {
		// TODO Auto-generated constructor stub
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}	
}
