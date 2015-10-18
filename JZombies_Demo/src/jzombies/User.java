package jzombies;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class User extends Agent{
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	Defender defender;
	Request request;
	
	public User(ContinuousSpace<Object> space, Grid<Object> grid) {
		this.space = space;
		this.grid = grid;
		
	}
	
	@Watch(watcheeClassName = "jzombies.Zombie", watcheeFieldNames = "moved", 
			query = "within_vn 1", whenToTrigger = WatcherTriggerSchedule.IMMEDIATE)
	public void run() {
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		double timeDouble = GetTickCount();
//		System.out.println(timeDouble+" "+this);
		request= new Request("19.2.1.11", "19.2.3.14", 113, "", Protocol.HTTP);

		send(request);

	}

	@Override
	public void send(Request request) {
		try {
			request.data= new Scanner( new File("/Users/neda/Downloads/JZombies_Demo/src/jzombies/Get.txt") ).useDelimiter("\\A").next();
			defender.receive(request);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void receive(Request request) {
		defender.send(request);
		
	}

	@Override
	public void connect(Agent agent) {
		defender = (Defender) agent;
		agent.connect(this);
	}
	
	
}
