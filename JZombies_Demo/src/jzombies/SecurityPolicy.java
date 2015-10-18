package jzombies;

import java.util.List;

public class SecurityPolicy {
	EndPoint endPoint;
	String policy;
	List<Behavior> behavior;
	
	
	public EndPoint getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(EndPoint endPoint) {
		this.endPoint = endPoint;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	
	public List<Behavior> getBehavior() {
		return behavior;
	}
	public void setBehavior(List<Behavior> behavior) {
		this.behavior = behavior;
	}
	

}
