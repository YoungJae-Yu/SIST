package springweb.a05_mvcexp.a02_service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springweb.a05_mvcexp.a03_dao.A04_FileUploadDao;
import springweb.a05_mvcexp.z01_vo.FileVo;
import springweb.a05_mvcexp.z01_vo.Restore;

@Service
public class A04_FileUploadService {
	@Autowired
	private A04_FileUploadDao dao;
	@Value("${user.upload}")
	private String path;
	public String uploadFile(FileVo vo) {
		String msg = "업로드 성공";
		int no = dao.getNo();
		for(MultipartFile mf:vo.getFileInfos()) {
			String fname = mf.getOriginalFilename();
			File f = new File(path+fname);
			try {
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				msg = "예외발생1:"+e.getMessage();
			} catch (IOException e) {
				msg = "예외발생2:"+e.getMessage();
			}
			if(msg.equals("업로드 성공")) {
				dao.insFileInfo(new Restore(no, vo.getContent(), fname));
			}
		}
		return msg;
	}
}
