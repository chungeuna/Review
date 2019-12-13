package com.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.model.Photo;


@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "image/image";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submit(Photo photo, HttpServletRequest request) throws IOException{
		/* 1. Photo 타입으로 받는다 (DTO) 
		 * 1.1 자동화 <input 태그의 name 속성 값이 .. dto의 멤버필드명과 같다 
		 * 1.2 submit(Phto photo) 자동화 
		 * Photo photo = new Photo();
		 * photo.setName("홍길동");
		 * photo.setAge(10);
		 * photo.setImage("업로드한 파일명 "); //자동 주입이 안된다  
		 * CommonsMultipartFile file에서 파일 이름을 추출해서 
		 * photo.setImage()은 함수의 로직으로 처리 
		 * 
		 * private CommonsMultipartFile file;
		 * public CommonsMultipartFile getFile() { return file; }
  		   public void setFile(CommonsMultipartFile file) { this.file = file; }
  		   
  		    별도의 추가 작업 : 파일 이름, 파일 크기, 원본 이름 
  		    코드 작업 
		 */
		CommonsMultipartFile imagefile = photo.getFile(); //파일 정보가 다 넘어간다 
		System.out.println("겟 네임 : "+imagefile.getName());
		System.out.println("콘텐츠 타입 : "+imagefile.getContentType());
		System.out.println("오리지널 이름 : " + imagefile.getOriginalFilename());
		System.out.println("파일크기 " + imagefile.getBytes().length);
		//Point 
		photo.setImage(imagefile.getName());  //디비에 파일명이 넘어간다   
		
		//실 파일 업로드(write 작업 : 웹 서버의 특정경로에 File write) /////////////////
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); 
		//경로와 파일명을 조합해야한다 
		String fpath = path + "\\" + filename;
		// C:\\smartWeb .... \\a.jpg 
		//실제 쓰기 작업 
		FileOutputStream fs = new FileOutputStream(fpath); //파일 생성하고
		//자동으로 파일을 만든다 
		fs.write(imagefile.getBytes());
		fs.close();
		///////////////////////////////////////////////////////////
		
		//만약에 DB 작업 필요하다면 
		//BoardDao = new BoardDao();
		//dao.inset(photo)
		
		
		//실제로 하는 작업은 아파치 톰캣 이미지 경로에 올리는것까지 
		return "image/image";
	}
}
