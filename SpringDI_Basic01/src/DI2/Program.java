package DI2;

public class Program {

	public static void main(String[] args) {
		NewRecordView view = new NewRecordView();
		//필요하다면 
		NewRecord record = new NewRecord(100, 50, 70);
		view.setRecord(record); //필요한 객체의 주소 주입 (injection) 
		view.print();
		//함수는 필요에 의해서 호출하므로 더 유연하다
		//POINT: 함수는 필요에 의해 호출이 가능하다 - 한줄 정리!!! 
		//스프링 -> setter로 주입하는 것을 선호한다 
		
	 //멤버 필드가 있다면 의존관계가  아니다 
		//의무적으로 가져간다 > 생성자 
		// 필요에 의해서 가져간다 > setter 함수 
	 //안에서  > 복합 
	 //세터 >  밖에서 집합
	 //
	}
}
