package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/* 클라이언트 요청 
 * 1. 화면주세요(글쓰기, 로그인 화면) 			write.do 
 * 2. 처리해주세요(로그인 처리, 글쓰기 완료 처리)  writeok.do 
 * 
   /article/newArticle.do 요청 주소가 하나 
   (GET, POST 방식) 
   
   /article/newArticle.do >> G
    * ET >> 화면주세요
   /article/newArticle.do >> POST >> 처리하세요 
 */

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	//NewArticleController 는 article 서비스에 의존한다 (필요하다) 
	private ArticleService articleService;
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping(method = RequestMethod.GET) //화면 보여주기 
	public String form() {
		return "article/newArticleForm";
	}
	/* 1. 전통적인 방법으로 Client 데이터 받기 
	 * public String submit(HttpServletRequest request) { return null; } 
	 * 
	 * 2. spring 파라미터를  dto 타입으로 받기 
	 * 전제조건: input태그가 가지는 name 속성값이 클래스가 가지는 멤버필드 명과 같아야한다
	 * 
	 * submit() : 
	 * 1. 자동 dto 생성 
	 * NewArticleCommand newArticleCommand = new NewArticleCommand();
	 * 
	 * 2. 넘어온 파라미터 값을 setter로 자동 주입 : 객체는 ioc 컨테이너 안에 자동주입 
	 * id= "newArticleCommand" 
	 * 
	 * 코드가 없다 
	 * ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand",article);
		mv.setViewName("article/newArticleSubmitted");
		
		mv.addObject("newArticleCommand",article); 
		> 코드가 자동으로 돌아간다 
		데이터 담는 작업이 자동 실행된다 
		클래스 이름에서 앞글자만 소문자로 만든 것으로 N -> n 
		자동만든다 id="newArticleCommand"
		
		>> 내부적으로 forward 해서 view  >> newArticlecommand 이름 객체 
		
		완성본 
		
		3. 객체의 이름(키) 가 자동 생성되는게 싫다 > 정의하겠다 
		(@ModelAttribute("Articledata")
		NewArticleCommand Articledata = new NewArticleCommand();
	 */
	@RequestMapping(method = RequestMethod.POST) // 화면 처리하기 
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		articleService.writeArticle(command);
		//처리완료 
		return "article/newArticleSubmitted";	
	}
	/*public String submit(HttpServletRequest request) {
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		articleService.writeArticle(article);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand",article);
		mv.setViewName("article/newArticleSubmitted");
		return "article/newArticleSubmitted";
	}*/
	
}
