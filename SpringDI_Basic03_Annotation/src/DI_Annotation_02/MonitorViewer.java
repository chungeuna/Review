package DI_Annotation_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
	@Autowired //by type > IOC 컨테이너 안에서 Recorder란 타입을 찾는다 // 객체가 있으면 자동 주소 주입  
	@Qualifier("recorder_1")
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setter 주입 성공" + recorder);
	}
	//일반함수 
	@Autowired
	@Qualifier("recorder_2")
	public void Gmethod(Recorder rec) {	
		System.out.println("Gmethod(rec): " + rec);
	}
}
