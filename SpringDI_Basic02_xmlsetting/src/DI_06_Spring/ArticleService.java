package DI_06_Spring;

public class ArticleService {
	
	//사용자의 요청에 따라서 
	
	//글쓰기 ...
	
	//목록보기 ...
	
	//수정하기...
	
	//서비스를 하기 위해서는 DB작업 ... DAO단 
	//DAO 객체를 만드는 작업 
	//article 서비스는 dao에 의존한다 
	private ArticleDao articledao; //이 변수가 실 객체의 주소를 가지면 된다 
	public ArticleService(ArticleDao articledao) {
		this.articledao = articledao; //주소값 할당 
		System.out.println("ArticleService 생성자 함수 호출");
	}
	//글쓰기 서비스 
	public void write (Article article) {  //순수한  dependency 
		//write와 Article 
		//멤버필드가 있으면 연관 
		this.articledao.insert(article); 
	}
}
