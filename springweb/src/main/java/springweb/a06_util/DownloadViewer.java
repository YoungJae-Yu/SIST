package springweb.a06_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


@Component("downloadViewer")
public class DownloadViewer extends AbstractView {
	// 다운로드할 파일의 위치 경로
	@Value("${user.upload}")
	private String path;
	
	public String getPath() {
		return path;
	}
	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model,
			HttpServletRequest req,
			HttpServletResponse res)
			throws Exception {
	// 1. 다운로드할 파일
	// 		1) client 요청 파일명 ==> controller
	// 		2) controller 다운로드뷰를 호출 파일명을 전달 모델
	// 		3) 다운로드 뷰에서는 모델명과 설정 경로를 통해서
	//      		파일객체를 생성..
	// 1) 파일명 가져오기.
	String fileName = (String)model.get("downloadFile");
	// 2) 파일 객체 생성//
	File file = new File(path+fileName);
	// 2. response객체를 통해서 client에 전달하기 위해 설정.
	// 		1) contentType(파일전송전용)
	res.setContentType("application/download;charset=utf-8");
	//		2) 파일의 길이를 위한 contentLengthLong
	res.setContentLengthLong(file.length());
	// 		3) 파일의 정보를 위해 setHeader 부분 설정
	// 			 - 한글 엔코딩(공백에 대한 변경 포함) + ==> ""
	fileName = URLEncoder.encode(
			fileName, "utf-8").replaceAll("\\+", "");
	//  		 - 파일명 지정 filename="파일명"
	res.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
	res.setHeader("Content-Transfer-Encoding", "binary");
	// 3. 파일을 보내기 위해
	//     File ==> FileInputStream ==> response
	//     의 OuputStream에 복사에서 전달
	FileInputStream fis = new FileInputStream(file);
	OutputStream out = res.getOutputStream();
	FileCopyUtils.copy(fis, out);
	// 4. 마지막으로 response buffer를 flush하고 자원해제
	out.flush();
		
	}
	
		
}
