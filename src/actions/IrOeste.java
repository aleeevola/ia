package actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import interfaz.MainAgenteCustodia;
import search.EstadoAgenteCustodia;
import search.EstadoAmbiente;
import search.VectorCalles;

public class IrOeste extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgenteCustodia agState = (EstadoAgenteCustodia) s;
        VectorCalles esquinaSiguiente = agState.getEsquinas().get(agState.getUbicacionActual()).get(1); //Get(1) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que está tienen asignado un "0" 
        if(esquinaSiguiente!=null && !agState.getListaCallesCortadas().contains(esquinaSiguiente)){
        	agState.setUbicacionActual(esquinaSiguiente);
        	return agState;
        }

        return null;
	}

	@Override
	public Double getCost() {
		return new Double(2);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);


        VectorCalles esquinaSiguiente = agState.getEsquinas().get(agState.getUbicacionActual()).get(1); //Get(1) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que está tienen asignado un "0" 
        if(esquinaSiguiente!=null && !agState.getListaCallesCortadas().contains(esquinaSiguiente)){
        	MainAgenteCustodia.trazarDesplazamiento(agState.getUbicacionActual(), esquinaSiguiente);
        	
        	
        	environmentState.setposicionAgenteCustodia(esquinaSiguiente);
        	agState.setUbicacionActual(esquinaSiguiente);
        	
        	return environmentState;
        }
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "IrOeste";
	}

}
