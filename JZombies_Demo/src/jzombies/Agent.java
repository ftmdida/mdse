package jzombies;



public abstract class Agent implements Connection {
	String sourceIP;
	

	public Agent(String sourceIP) {
		this.sourceIP=sourceIP;
	}


	public String getSourceIP(){
		return sourceIP;
	}
	
}
