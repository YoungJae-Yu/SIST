package com.web.board.vo;
// com.web.board.vo.BoardFile
import java.util.Date;

public class BoardFile {
	private int no;
	private String fname;
	private String directory;
	private String info;
	private Date regdte;
	private Date uptdte;
	private String auth;
	//	  <!-- no, fname, info -->

	public BoardFile(int no, String fname, String directory, String info, Date regdte, Date uptdte, String auth) {
		super();
		this.no = no;
		this.fname = fname;
		this.directory = directory;
		this.info = info;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.auth = auth;
	}
	public BoardFile(int no, String fname, String info) {
		super();
		this.no = no;
		this.fname = fname;
		this.info = info;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public BoardFile() {
		super();
		// TODO Auto-generated constructor stub
	}
}
