package springweb.a06_util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DonwloadCtrl {
	// download.do?fname=파일명
	@RequestMapping("download.do")
	public String download(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFile",fname);
		System.out.println("호출!!");
		return "downloadViewer";
	}
}
