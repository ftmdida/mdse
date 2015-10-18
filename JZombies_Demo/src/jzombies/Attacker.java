package jzombies;

import static repast.simphony.essentials.RepastEssentials.GetTickCount;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class Attacker extends Agent {

	private ContinuousSpace<Object> space;
	private Grid<Object> grid;

	Defender defender;

	public Attacker(ContinuousSpace<Object> space, Grid<Object> grid) {
		this.space = space;
		this.grid = grid;

	}

	/**
	 *
	 * This is the step behavior.
	 * 
	 * @throws IOException
	 * @method step here you can check your variables for statistics.
	 * 
	 */
	@ScheduledMethod(start = 1, interval = 1)
	public void step() throws IOException {

	
		try {
			int numberOfRequest = RandomHelper.nextIntFromTo(2, 100);
			String source;
			String destination = "193.16.12.13";
			String data;
			String injectedTxtFile = "src" + File.separator.toString()
					+ "jzombies" + File.separator.toString() + "data.txt";

			File file = new File(injectedTxtFile);
			String path = file.getAbsolutePath();

			String body = new Scanner(new File(path)).useDelimiter("\\A")
					.next();
			data = "/test/demo_form.asp?name1=value1&name2=value2";

			for (int i = 0; i < numberOfRequest; i++) {
				
				source = "192.168.0." + i;
				this.sourceIP=source;
			
				send(new Request(source, destination, i, body, Protocol.HTTP));
			}
			
	
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
		defender = (Defender) agent;
		
		agent.connect(this);
	}

}
