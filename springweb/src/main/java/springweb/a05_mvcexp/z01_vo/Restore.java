package springweb.a05_mvcexp.z01_vo;

import java.util.Date;

public class Restore {
	private int no;
	private String content;
	private String filename;
	private Date regdte;
	private Date uptdte;
	public Restore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restore(int no, String content, String filename) {
		super();
		this.no = no;
		this.content = content;
		this.filename = filename;
	}
	public Restore(int no, String content, String filename, Date regdte, Date uptdte) {
		super();
		this.no = no;
		this.content = content;
		this.filename = filename;
		this.regdte = regdte;
		this.uptdte = uptdte;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
}
