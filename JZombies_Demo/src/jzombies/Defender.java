package jzombies;

import static repast.simphony.essentials.RepastEssentials.GetTickCount;

import java.util.ArrayList;
import java.util.List;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.graph.Network;
import repast.simphony.space.grid.Grid;
import repast.simphony.util.ContextUtils;
import repast.simphony.context.Context;

public class Defender extends Agent{
	private ContinuousSpace<Object> space;
	private Grid<Object> grid;
	//private boolean moved;
	ArrayList<Agent> connections;
	SecurityPolicyList listOfSecurityPolicy;
	
	public Defender(ContinuousSpace<Object> space, Grid<Object> grid) {
		
		connections = new ArrayList<Agent>();
		this.space = space;		
		this.grid = grid;
	}

	@ScheduledMethod(start = 1, interval = 1)
	public void step() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		double timeDouble = GetTickCount();
		System.out.println(timeDouble+" "+this);
	}

	@Override
	public void connect(Agent agent) {
		connections.add(agent);
	}

	@Override
	public void send(Request request) {		
		for (Agent agent : connections) {
			if(agent.getSourceIP() == request.getSourceIP()){
				agent.receive(request);
				break;
			}
			
		
		}
	}

	@Override
	public void receive(Request request) {
		
		
		
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
		
		
	}
}
