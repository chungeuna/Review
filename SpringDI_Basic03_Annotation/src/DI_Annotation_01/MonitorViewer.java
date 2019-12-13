package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

public class MonitorViewer {
	
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
	@Autowired //by type > IOC 컨테이너 안에서 Recorder란 타입을 찾는다 // 객체가 있으면 자동 주소 주입  
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	/* <property name="recorder">
		<ref bean="recorder"/>
	</property> 
	 */
}
