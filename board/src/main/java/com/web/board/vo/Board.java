package com.web.board.vo;
// com.web.board.vo.Board
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int no;
	private int refno;
	private int level;
	private int cnt;
	private String subject;
	private String content;
	private String writer;
	private int readcnt;
	private Date regdte;
	private Date uptdte;
	private List<String> fnames;
	private MultipartFile[] report;
	
	
	public MultipartFile[] getReport() {
		return report;
	}
	public void setReport(MultipartFile[] report) {
		this.report = report;
	}
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int no, int refno, String subject, String content, String writer, int readcnt, Date regdte,
			Date uptdte) {
		super();
		this.no = no;
		this.refno = refno;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.readcnt = readcnt;
		this.regdte = regdte;
		this.uptdte = uptdte;
	}

	public List<String> getFnames() {
		return fnames;
	}
	public void setFnames(List<String> fnames) {
		this.fnames = fnames;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
