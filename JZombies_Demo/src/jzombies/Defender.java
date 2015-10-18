package jzombies;

import java.util.ArrayList;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.grid.Grid;

public class Defender extends Agent{
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	private boolean moved;
	ArrayList<Agent> connections;
	
	public Defender(ContinuousSpace<Object> space, Grid<Object> grid) {
		
		connections = new ArrayList<Agent>();
		this.space = space;	
		this.grid = grid;
	}

	@ScheduledMethod(start = 1, interval = 1)
	public void step() {
	}

	@Override
	public void connect(Agent agent) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
		this.send(request);
		
	}
}

	
		
//		List<SecurityPolicy> securityPolicies= listOfSecurityPolicy.getSecurityPolicy();
//		for (SecurityPolicy securityPolicy : securityPolicies) {
//			for (Behavior behavior : securityPolicy.getBehavior()) {
//				for (Conditions condition : behavior.getCondition()) {
//					if(!condition.checkProtocol(request.getProtocol())){
//						for (Agent agent : connections) {							
//							if(agent.getSourceIP() == request.getSourceIP()){
//														
////								Object obj=agent;
////								Context<Object> context = ContextUtils.getContext(obj);
////								
////								Network<Object> net = (Network<Object>)context.getProjection("infection network");						
////								net.addEdge(this, agent);
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
		
		
	

