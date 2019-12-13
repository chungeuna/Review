package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
	
	//	ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
	//insert 작업 
	//	MySqlArticleDao articledao = new MySqlArticleDao();
	/*	OracleArticleDao articledao = new OracleArticleDao(); //오라클로 바꼈을 때 뒤에 코드가 안 바뀐다 (변수명도 동일하게)
		ArticleService articleservice = new ArticleService(articledao);
		
		Article article = new Article();
		articleservice.write(article); */
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		Article article = context.getBean("article",Article.class);
		ArticleService articleservice = context.getBean("articleservice",ArticleService.class);
		articleservice.write(article);
		
	}
}
