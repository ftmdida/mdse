package jzombies;

public enum Protocol {
	
	HTTP("http"), HTTPS("https"), FTP("ftp") , SSH("ssh");
	
	private String protocol;

	private Protocol(String s) {
		protocol = s;
	}

	public String getStatusCode() {
		return protocol;
	}
}
