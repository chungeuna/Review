package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeController implements Controller {
	
	public NoticeController() {
		System.out.println("[NoticeController]");
	}
	
	//injection : xml, annotation 
	private NoticeDao noticedao;
	
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//검색처리 
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("p");
		
		//디폴트 값 
		int page = 1;
		String field = "TITLE";
		String query = "%%";
		
		//조건처리 
		if(_page != null && _page.equals("")) {
			page = Integer.parseInt(_page);
		}
		if(_field != null && _field.equals("")) {
			field = _field;
		}
		if(_query != null && _query.equals("")) {
			query = _query;
		}
		//DAO단 처리 
		List<Notice> list = noticedao.getNotices(page, field, query);
		//spring  > ModelAndView  or model 객체 제공 
		ModelAndView  mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("notice.jsp");
		return mv;
	}

}
