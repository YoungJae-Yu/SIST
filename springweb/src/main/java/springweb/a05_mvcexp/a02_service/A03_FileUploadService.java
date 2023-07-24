package springweb.a05_mvcexp.a02_service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class A03_FileUploadService {
	@Value("${user.upload}")
	private String path;
	public String upload(MultipartFile[] files, 
						String title) {
		String msg = "업로드 성공";
		for(MultipartFile mf:files) {
			File f = new File(path+mf.getOriginalFilename());
			try {
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				msg = "에러 발생:"+e.getMessage();
			} catch (IOException e) {
				msg = "에러 발생:"+e.getMessage();
			}
		}
		return msg;
	}
}
