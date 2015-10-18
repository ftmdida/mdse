package jzombies;

import static repast.simphony.essentials.RepastEssentials.GetTickCount;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class Attacker extends Agent{

	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	//private boolean moved;
	Defender defender;
	
	
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
		
		
		double timeDouble = GetTickCount();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		int numberOfRequest= RandomHelper.nextIntFromTo(2, 100);
		String source;
		String destination="193.16.12.13";


			String data="/test/demo_form.asp?name1=value1&name2=value2";
			for (int i = 0; i < numberOfRequest; i++) {
				source="192.168.0." + i;
				send(new Request(source, destination, i, data, Protocol.HTTP));
				
				System.out.println("NumberOfRequest " + i +" "+timeDouble+" "+this);
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		
	}

	
	@Override
	public void send(Request request) {		
		defender.receive(request);
	}

	@Override
	public void receive(Request request) {
		
		
	}

	@Override
	public void connect(Agent agent) {
		defender = (Defender) agent;
		agent.connect(agent);
	}
	
	
}
	