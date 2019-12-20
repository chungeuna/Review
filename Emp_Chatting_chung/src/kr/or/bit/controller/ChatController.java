package kr.or.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@RequestMapping("/Chat-ws.do")
	public String chatView() {
		return "/WEB-INF/views/Chat-ws.jsp";
	}
}
