package DI2;

public class NewRecordView {
	// 점수를 출력하는 클래스 
	private NewRecord record;
	
	//1. [생성자]를 통해서 필요한 객체를 생성 or 주입 >> DI
	//2. 함수 특정한 자원의 주소만 넘겨준다 (함수로 필요한 객체를 주입받는다)->  setter 함수 를 통해서 
	
	public void print () {
		System.out.println(record.total() + "/" + record.avg());
	}

	public void setRecord(NewRecord record) {
		//함수의 파라미터로 객체의 주소값을 받는다  NewRecord 객체의 주소 
		//
		this.record = record;
	}
}
