package DI3;

//vo,dto,domain과 같은 개념을 갖는 클래스 (데이터를 담을 수 있는 클래스) 
public class NewRecord implements Record{
	private int kor;
	private int eng;
	private int math;
	
	public NewRecord() {}
	public NewRecord(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	//필요시 함수 추가 
	@Override
	public int total() {
		return this.kor + this.eng + this.math;
	}
	@Override
	public float avg() {
		return total()/3.0f;
	}
	//두가지 함수 별도로 추가 
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
}
