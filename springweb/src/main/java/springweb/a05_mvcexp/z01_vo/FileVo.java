package springweb.a05_mvcexp.z01_vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVo {
	private MultipartFile[] fileInfos;
	private String content;
	public FileVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileVo(MultipartFile[] fileInfos, String content) {
		super();
		this.fileInfos = fileInfos;
		this.content = content;
	}
	public MultipartFile[] getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(MultipartFile[] fileInfos) {
		this.fileInfos = fileInfos;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
