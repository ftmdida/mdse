package jzombies;

public class Request {
	String sourceIP;
	String destinationIP;
	int port;
	String data;
	Protocol protocol;
	
	
	public Request(String sourceIP, String destinationIP, int port,
			String data, Protocol protocol) {
		this.sourceIP = sourceIP;
		this.destinationIP = destinationIP;
		this.port = port;
		this.data = data;
		this.protocol = protocol;
	}


	public String getSourceIP(){
		return sourceIP;
	}


	public String getDestinationIP() {
		return destinationIP;
	}


	public void setDestinationIP(String destinationIP) {
		this.destinationIP = destinationIP;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Protocol getProtocol() {
		return protocol;
	}


	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}


	public void setSourceIP(String sourceIP) {
		this.sourceIP = sourceIP;
	}
}
