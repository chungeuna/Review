package DI3;

import java.util.Scanner;

public class NewRecordView implements RecordView{
	// 점수를 출력하는 클래스 
	private NewRecord record;
	
	//1. [생성자]를 통해서 필요한 객체를 생성 or 주입 >> DI
	//2. 함수 특정한 자원의 주소만 넘겨준다 (함수로 필요한 객체를 주입받는다)->  setter 함수 를 통해서 
	@Override
	public void print () {
		System.out.println(record.total() + "/" + record.avg());
	}
	
	//3. 인터페이스 활용 (다형성) 
	public void setRecord(Record record) {  //함수의 파라미터를 인터페이스로 사용
		//레코드 인터페이스를 구현하는 모든 자식요소가 들어올 수 있다 
		//다형성 적용
		//자식 것은 못보기 때문에 
		//인터페이스 타입으로 받으면 set함수는 접근 못함
		this.record = (NewRecord)record;
	}
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("kor:");
		record.setKor(sc.nextInt());
		System.out.println("eng:");
		record.setEng(sc.nextInt());
		System.out.println("math:");
		record.setMath(sc.nextInt());
	}
}
