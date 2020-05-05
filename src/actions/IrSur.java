package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAgenteCustodia;
import search.EstadoAmbiente;

public class IrSur extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgenteCustodia agState = (EstadoAgenteCustodia) s;
        String esquinaSiguiente = agState.getEsquinas().get(agState.getUbicacionActual()).get(3); //Get(3) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que está tienen asignado un "0" 
        if(!esquinaSiguiente.equals("0")){
        	agState.setUbicacionActual(esquinaSiguiente);
        	return agState;
        }
        
        return null;
	}

	@Override
	public Double getCost() {
		return new Double(1);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);

        
        String esquinaSiguiente = agState.getEsquinas().get(agState.getUbicacionActual()).get(3); //Get(3) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que está tienen asignado un "0" 
        if(!esquinaSiguiente.equals("0")){
        	environmentState.setposicionAgenteCustodia(esquinaSiguiente);
        	
        	return environmentState;
        }
      
		return null;
	}

	@Override
	public String toString() {
		return "IrSur";
	}

}
