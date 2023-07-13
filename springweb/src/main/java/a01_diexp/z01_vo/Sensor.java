package a01_diexp.z01_vo;

import java.util.Properties;
import java.util.Set;
// a01_diexp.z01_vo.Sensor
// setAgent(Set<String> agent)
// setAddInfo(Properties addInfo)
public class Sensor {
	// Set, Properties 선언..
	private Set<String> agent;
	private Properties addInfo;

	public Set<String> getAgent() {
		return agent;
	}
	public void setAgent(Set<String> agent) {
		this.agent = agent;
	}
	public Properties getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(Properties addInfo) {
		this.addInfo = addInfo;
	}
	
}
