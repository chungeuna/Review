package DI;

public class Program {

	public static void main(String[] args) {
		NewRecordView view = new NewRecordView(100, 80, 90);
		view.print();
	}
}
//뉴 레코드 뷰는 뉴레코드에 의존한다 
//