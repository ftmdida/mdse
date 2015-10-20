package jzombies;

import java.util.ArrayList;
import java.util.List;

public class SecurityPolicyList {
	List<SecurityPolicy> securityPolicy;
	List<Behavior>  behavior;
	List<Conditions> condition;
	
	public SecurityPolicyList(){
		buildSecurityPolicyList();
		securityPolicy = new ArrayList<SecurityPolicy>();
//		behavior = new ArrayList<Behavior>();
//		condition = new ArrayList<Conditions>();
	}
	
	public List<SecurityPolicy> getSecurityPolicy() {
		return securityPolicy;
	}
	public void setSecurityPolicy(List<SecurityPolicy> securityPolicy) {
		this.securityPolicy = securityPolicy;
	}
	public List<Behavior> getBehavior() {
		return behavior;
	}
	public void setBehavior(List<Behavior> behavior) {
		this.behavior = behavior;
	}
	public List<Conditions> getCondition() {
		return condition;
	}
	public void setCondition(List<Conditions> condition) {
		this.condition = condition;
	}
	Conditions con1 = new Conditions();
	
	public void buildSecurityPolicyList(){
		SecurityPolicy sp1 = new SecurityPolicy();
		sp1.se
	}
	
}
