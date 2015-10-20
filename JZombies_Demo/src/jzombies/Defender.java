package jzombies;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.engine.watcher.Watch;
import repast.simphony.engine.watcher.WatcherTriggerSchedule;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class Defender extends Agent{
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	private boolean moved;
	ArrayList<Agent> connections;
	
	public Defender(ContinuousSpace<Object> space, Grid<Object> grid, String sourceIP) {
		super(sourceIP);
		connections = new ArrayList<Agent>();
		this.space = space;	
		this.grid = grid;
	}

	@Watch(watcheeClassName = "jzombies.Zombie", watcheeFieldNames = "moved", 
			query = "within_vn 1", whenToTrigger = WatcherTriggerSchedule.IMMEDIATE)
	public void run() {
//		// get the grid location of this Human
//		GridPoint pt = grid.getLocation(this);
//
//		// use the GridCellNgh class to create GridCells for
//		// the surrounding neighborhood.
//		GridCellNgh<Zombie> nghCreator = new GridCellNgh<Zombie>(grid, pt,
//				Zombie.class, 1, 1);
//		List<GridCell<Zombie>> gridCells = nghCreator.getNeighborhood(true);
//		SimUtilities.shuffle(gridCells, RandomHelper.getUniform());
//
//		GridPoint pointWithLeastZombies = null;
//		int minCount = Integer.MAX_VALUE;
//		for (GridCell<Zombie> cell : gridCells) {
//			if (cell.size() < minCount) {
//				pointWithLeastZombies = cell.getPoint();
//				minCount = cell.size();
//			}
//		}
//		
//		if (energy > 0) {
//			moveTowards(pointWithLeastZombies);
//		} else {
//			energy = startingEnergy;
//		}
	}
	
	
	@Override
	public void connect(Agent agent) {
		connections.add(agent);
	}

	@Override
	public void send(Request request) {
		// TODO Auto-generated method stub
		
		for (Agent agent : connections) {
			if(agent.getSourceIP() == request.getSourceIP()){
				agent.receive(request);
				break;
			}
		}
	}

	@Override
	public void receive(Request request) {
		
		SecurityPolicyList listOfSecurityPolicy= new SecurityPolicyList();
		listOfSecurityPolicy.a
//		List<SecurityPolicy> securityPolicies= listOfSecurityPolicy.getSecurityPolicy();
//		for (SecurityPolicy securityPolicy : securityPolicies) {
//			for (Behavior behavior : securityPolicy.getBehavior()) {
//				for (Conditions condition : behavior.getCondition()) {
//					if(condition.checkProtocol(request.getProtocol())){
//						for (Agent agent : connections) {							
//							if(agent.getSourceIP() == request.getSourceIP()){
//														
//	
//							}
//							
//						
//						}
//					}
//					else{
//						if(condition.checkHttpRequestBody(request.getData())){
//							
//							
//
//							
//						}
//						else {
//							
//						}
//					}
//				
//				}
//			}
//		}
//
//		
//	}
}

	

		
		
	

