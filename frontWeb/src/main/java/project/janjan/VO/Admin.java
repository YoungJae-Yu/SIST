package project.janjan.VO;

public class Admin {
	private int prdno;
	private String title;
	private String val;
	private int refno;
	private int ordno;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int prdno, String title, String val, int refno, int ordno) {
		super();
		this.prdno = prdno;
		this.title = title;
		this.val = val;
		this.refno = refno;
		this.ordno = ordno;
	}

	public int getPrdno() {
		return prdno;
	}

	public void setPrdno(int prdno) {
		this.prdno = prdno;
	}

	public Admin(int prdno) {
		super();
		this.prdno = prdno;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
	}
	public int getOrdno() {
		return ordno;
	}
	public void setOrdno(int ordno) {
		this.ordno = ordno;
	}
	
}
