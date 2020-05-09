package actions;


import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import search.EstadoAgenteCustodia;
import search.EstadoAmbiente;
import search.VectorCalles;

public class Multar extends SearchAction{

	/**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
		//se utiliza cuando se esta generando el arbol de busqueda 
		EstadoAgenteCustodia agState = (EstadoAgenteCustodia) s;
        
        //Si la posicion actual se encuentra en la lista de ubicaciones 
		//de ciudadanos infectados que incumplen la cuarentena, se multa
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

	  /**
     * This method updates the agent state and the real world state.
     */
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		//en este recibe el ambiente 
		 	EstadoAmbiente environmentState = (EstadoAmbiente) est;
	        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);

	      //Si la posicion actual se encuentra en la lista de ubicaciones de ciudadanos infectados que incumplen la cuarentena, se multa
	        if(agState.getListaInfectados().contains(agState.getUbicacionActual())){
	        	
	        	//Removemos la ubicacion del ciudadano que ya ha sido multado
	        	VectorCalles vec = null;
	        	for(VectorCalles v : environmentState.getListaInfectados())
	        		if(v.equals(agState.getUbicacionActual())) {
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
