package search;


import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjetivoAgenteCustodia extends GoalTest{

	@Override
	public boolean isGoalState(AgentState agentState) {
		EstadoAgenteCustodia estado = (EstadoAgenteCustodia) agentState;

		 if(estado.getListaInfectados().isEmpty() || 
		        	 estado.getCantidadMultados()>4){
		        		return true;      
		        }
		        else return false;
	}

}
