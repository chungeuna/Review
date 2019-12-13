package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.htm")
	public String index() {
		//return "index.jsp"; 타일즈 적용 전 
		return "home.index"; // *.* > {1} > home .... {2} >  index 
		//폴더명.페이지명 
	}
}
