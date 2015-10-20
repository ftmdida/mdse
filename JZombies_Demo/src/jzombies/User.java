package jzombies;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class User extends Agent {
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	Defender defender;
	

	public User(ContinuousSpace<Object> space, Grid<Object> grid, String sourceIP) {
		super(sourceIP);
		this.space = space;
		this.grid = grid;
		

	}

	@ScheduledMethod(start = 1, interval = 50)
	public void step() {
	//	int numberOfRequest = RandomHelper.nextIntFromTo(2, 100);

		//String source;
//		String destination = "193.16.12.13";
//		
//		String data = "/test/demo_form.asp?name1=value1&name2=value2";
//		for (int i = 0; i < numberOfRequest; i++) {
//			//source = "192.165.0." + i;
//			send(new Request(source, destination, i, data, Protocol.HTTP));
//			//System.out.println(this.getSourceIP());
		
//		}
		
		String data = "/test/demo_form.asp?name1=value1&name2=value2";
		send(new Request(this.getSourceIP(), defender.getSourceIP(),Protocol.HTTP.getStatusCode() , data, Protocol.HTTP));
		
	}

	@Override
	public void send(Request request) {
		defender.receive(request);
	}

	@Override
	public void receive(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(Agent agent) {
		// TODO Auto-generated method stub
		defender = (Defender) agent;
		agent.connect(this);
	}

}
