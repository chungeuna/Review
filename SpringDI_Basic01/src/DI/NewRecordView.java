package DI;

public class NewRecordView {
	// 점수를 출력하는 클래스 
	private NewRecord record;
	public NewRecordView (int kor, int eng, int math) { //생성자 통해서 주입 -> 복합연관 (라이프 사이클이 같다) 
		record = new NewRecord(kor,eng,math);
	}
	public void print () {
		System.out.println(record.total() + "/" + record.avg());
	}
}
