package jzombies;

public interface Connection {
	void connect(Agent agent);
	void send(Request request);
	void receive(Request request);
}
