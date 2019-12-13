package DI_06_Spring;

//표준화 작업 (oracle, Mysql) 동일한 함수를 사용하게 한다 
//
public interface ArticleDao {
	void insert(Article article);
}
