package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	private MemberDao memberdao;

	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//회원가입 페이지 > url 매핑 작업 
	//view 리턴하는 형태로 
	@RequestMapping(value="join.htm", method=RequestMethod.GET)
	public String join() {
	//	return "join.jsp";
		return "joinus.join";
	}
	//회원가입 처리 
	@RequestMapping(value="join.htm", method=RequestMethod.POST)
	public String join(Member member) {
		System.out.println(member.toString());
		try {
			memberdao.insert(member);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		//주의 사항 : 
		// joinus 폴더에 묶여 있기 때문에 
		// /index.htm
		//요청 주소 ... 아래처럼 
		return "redirect:/index.htm";
	}
}
