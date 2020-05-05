package actions;


import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAgenteCustodia;
import search.EstadoAmbiente;


public class Multar extends SearchAction{

	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		EstadoAgenteCustodia agState = (EstadoAgenteCustodia) s;
        
        //Si la posicion actual se encuentra en la lista de ubicaciones de ciudadanos infectados que incumplen la cuarentena, se multa
        if(agState.getListaInfectados().contains(agState.getUbicacionActual())){
        	//Multamos al ciudadano y lo enviamos a su lugar de cuarentena
        	agState.sumarMultado();
        	//Sacamos la ubicación en la cual nos encontramos de la lista ubicaciones de ciudadanos infectados que incumplen la cuarentena
        	agState.getListaInfectados().remove(agState.getUbicacionActual());
        	
        	return agState;
        }
        	
        return null;
	}

	@Override
	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		 	EstadoAmbiente environmentState = (EstadoAmbiente) est;
	        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);

	      //Si la posicion actual se encuentra en la lista de ubicaciones de ciudadanos infectados que incumplen la cuarentena, se multa
	        if(agState.getListaInfectados().contains(agState.getUbicacionActual())){
	        	
	        	//Removemos la ubicacion del ciudadano que ya ha sido multado
	        	String vec = null;
	        	for(String v : environmentState.getListaInfectados())
	        		if(v.toString().equals(agState.getUbicacionActual().toString())) {
	        			vec = v;
	        	environmentState.sumarMultado();
	        	environmentState.getListaInfectados().remove(vec);}
	        	
	        	
	        	return environmentState;
	        }
	        	
	        return null;
	}

	@Override
	public String toString() {
		 return "Multar";
	}

}
