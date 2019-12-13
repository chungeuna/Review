package com.service;

import org.springframework.stereotype.Service;

import com.model.NewArticleCommand;

 
/* <context compoent scan> 
 * 있으면 그리고 클래스가 @Service 가지고 있다면 ... 자동 bean 생성 
 *  
 * 
 */
//@Service
public class ArticleService {
	
	public ArticleService () {
		System.out.println("Artilceservice 생성자 호출");
	}
	public void writeArticle(NewArticleCommand command) {
		//dao 객체 생성 
		// dao 객체가 가지는 insert 함수 호출 (command) 전달 
		System.out.println("글쓰기 작업 완료 " + command.toString());
	}
}
