package actions;


import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import interfaz.MainAgenteCustodia;
import search.EstadoAgenteCustodia;
import search.EstadoAmbiente;
import search.VectorCalles;

public class IrEste extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		// TODO Auto-generated method stub
		EstadoAgenteCustodia agState = (EstadoAgenteCustodia) s;
		//System.out.println(agState.getUbicacionActual());
		//System.out.println(agState.getEsquinas().get(agState.getUbicacionActual()));
        VectorCalles esquinaSiguiente = (agState.getEsquinas().get(agState.getUbicacionActual())).get(0); //Get(0) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que est� tienen asignado null 
        //System.out.println("EsquinaSiguiente"+esquinaSiguiente);
        if(esquinaSiguiente!=null && !agState.getListaCallesCortadas().contains(esquinaSiguiente)){
        	agState.setUbicacionActual(esquinaSiguiente);
        	return agState;
        }

        return null;
	}

	@Override
	public Double getCost() {
		return new Double(10);
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		EstadoAmbiente environmentState = (EstadoAmbiente) est;
        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);


        VectorCalles esquinaSiguiente = agState.getEsquinas().get(agState.getUbicacionActual()).get(0); //Get(0) porque el orden de las esquinas siguientes es "Este,Oeste,Norte,Sur"
        //Las direcciones en las que no pueden moverse el agente desde la esquina en la que est� tienen asignado un "0" 
        if(esquinaSiguiente!=null && !agState.getListaCallesCortadas().contains(esquinaSiguiente)){
      
        	MainAgenteCustodia.trazarDesplazamiento(agState.getUbicacionActual(), esquinaSiguiente);
        	MainAgenteCustodia.actualizarAccion(this.toString()+" -> "+esquinaSiguiente.toString());
        	
        	environmentState.setposicionAgenteCustodia(esquinaSiguiente);
        	agState.setUbicacionActual(esquinaSiguiente);
        	
        	return environmentState;
        }
        return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "IrEste";
	}

}
