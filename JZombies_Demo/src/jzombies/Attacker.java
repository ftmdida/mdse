package jzombies;

import static repast.simphony.essentials.RepastEssentials.GetTickCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class Attacker extends Agent{

	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	//private boolean moved;
	Defender defender;
	Request request;
	
	public Attacker(ContinuousSpace<Object> space, Grid<Object> grid) {
		this.space = space;
		this.grid = grid;
		
	}

	
	
	/**
	 *
	 * This is the step behavior.
	 * @method step
	 * here you can check your variables for statistics.
	 *  
	 */
	@ScheduledMethod(start = 1,
					 interval = 1)
	public void step() {
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		double timeDouble = GetTickCount();
		System.out.println(timeDouble+" "+this);
		request= new Request("19.2.1.11", "19.2.3.14", 113, "", Protocol.FTP);
		send(request);
	
	}

	
	
	@Override
	public void send(Request request) {
			
		try {
			request.data= new Scanner( new File("/Users/neda/Downloads/JZombies_Demo/src/jzombies/data.txt") ).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		defender.receive(request);
	}

	@Override
	public void receive(Request request) {
		defender.receive(request);
		
	}

	@Override
	public void connect(Agent agent) {
		defender = (Defender) agent;
		agent.connect(agent);
	}
	
	
}
	