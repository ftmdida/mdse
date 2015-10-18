package jzombies;


import static repast.simphony.essentials.RepastEssentials.GetTickCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.random.RandomHelper;
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
		int numberOfRequest= RandomHelper.nextIntFromTo(2, 100);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		double timeDouble = GetTickCount();
		String source;
		String destination="193.16.12.13";;
		String data="/test/demo_form.asp?name1=value1&name2=value2";
		for (int i = 0; i < numberOfRequest; i++) {
			source="192.165.0." + i;
			send(new Request(source, destination, i, data, Protocol.HTTP));			
			System.out.println("NumberOfRequest " + i +" "+timeDouble+" "+this);
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void send(Request request) {
//		try {
			//request.data= new Scanner( new File("/Users/neda/Downloads/JZombies_Demo/src/jzombies/Get.txt") ).useDelimiter("\\A").next();
			defender.receive(request);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
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
