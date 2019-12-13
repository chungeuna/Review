package com.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/* create table photo(
 * name 
 * age 
 * image >> 업로드한 파일명 : kglim.jpg, b.png  
 * 이미지의 이름은 자동으로 들어가진 않는다 
 * )
 * 
 * 
 */
public class Photo {
	private String name; 
	private int age;
	private String image;  //업로드한 파일 객체에서 별도로 추출(setter 설정) 
	
	//POINT /////////////////////////////////////////////////////////////////////////////
	private CommonsMultipartFile file; //POINT 변수명과 input 태그 파일 name 과 같아야한다  > 자동으로 
	//POINT 변수명과 
	//<input type="file" name="file" > 
	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	
	
} 
