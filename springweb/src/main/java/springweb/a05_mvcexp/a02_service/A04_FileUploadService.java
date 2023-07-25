package springweb.a05_mvcexp.a02_service;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
		boolean isFirst = true;
		int no = 0;
		for(MultipartFile mf:vo.getFileInfos()) {
			String fname = mf.getOriginalFilename();
			if(fname!=null&&!fname.equals("")) {
				File f = new File(path+fname);
				try {
					mf.transferTo(f);
				} catch (IllegalStateException e) {
					msg = "예외발생1:"+e.getMessage();
				} catch (IOException e) {
					msg = "예외발생2:"+e.getMessage();
				}
				if(msg.equals("업로드 성공")) {
					if(isFirst) {
						no = dao.getNo();
						isFirst=false;
					}
					dao.insFileInfo(new Restore(no, vo.getContent(), fname));
				}
			}else {
				msg = "파일이 첨부되지 않았습니다.";
				System.out.println(fname);
			}
		}
		return msg;
	}
	public List<Restore> restoreList(){
		return dao.restoreList();
	}
}
