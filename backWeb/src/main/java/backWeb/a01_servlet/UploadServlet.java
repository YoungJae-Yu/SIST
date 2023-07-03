package backWeb.a01_servlet;



import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("## 파일 업로드 #");
	      	String uploadPath = "C:\\Users\\user\\git\\web19\\backendWeb\\src\\main\\webapp\\z01_upload"; // 파일 저장 경로 설정

	      	String writer = request.getParameter("writer");
	      	String content = request.getParameter("content");
	      	System.out.println("작성자:"+writer);
	      	System.out.println("내용:"+content);
	      	
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }

	        for (Part part : request.getParts()) {
	            String fileName = getSubmittedFileName(part);
	            if (fileName != null && !fileName.isEmpty()) {
	                part.write(uploadPath + File.separator + fileName);
	            }
	        }
	        response.getWriter().println("File uploaded successfully.");
	    }
	    // Part에서 파일 이름을 추출하기 위한 메서드
	    private String getSubmittedFileName(Part part) {
	        String contentDisposition = part.getHeader("content-disposition");
	        if (contentDisposition != null && !contentDisposition.isEmpty()) {
	            String[] elements = contentDisposition.split(";");
	            for (String element : elements) {
	                if (element.trim().startsWith("filename")) {
	                    return element.substring(element.indexOf('=') + 1).trim()
	                            .replace("\"", "");
	                }
	            }
	        }
	        return null;
	    }
	}