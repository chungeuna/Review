package kr.or.bit.action;

//로직 제어, 화면 전달, 경로 ... 설정 

public class ActionForward {
	private boolean isRedirect = false; //화면단 처리 여부 
	String path = null; //이동 경로 제어 
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
