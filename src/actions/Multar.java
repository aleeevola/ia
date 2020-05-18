package actions;


import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import interfaz.MainAgenteCustodia;
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
		return new Double(1);
	}

	  /**
     * This method updates the agent state and the real world state.
     */
	@Override
	public EnvironmentState execute(AgentState ast, EnvironmentState est) {
		//en este recibe el ambiente 
		 	EstadoAmbiente environmentState = (EstadoAmbiente) est;
	        EstadoAgenteCustodia agState = ((EstadoAgenteCustodia) ast);

	      System.out.println("->"+agState.getUbicacionActual());
	      //Si la posicion actual se encuentra en la lista de ubicaciones de ciudadanos infectados que incumplen la cuarentena, se multa
	        if(agState.getListaInfectados().contains(agState.getUbicacionActual())){
	        	System.out.println("-> entro al if");
	        	
	        	MainAgenteCustodia.agregarMultado(agState.getUbicacionActual());
	        	MainAgenteCustodia.actualizarAccion(this.toString());
	        	
	        	agState.getListaInfectados().remove(agState.getUbicacionActual());
	        	agState.sumarMultado();
	        	
	        	environmentState.sumarMultado();
	        	environmentState.getListaInfectados().remove(agState.getUbicacionActual());
	        	
	        	return environmentState;
	        }
	        	
	        return null;
	}

	@Override
	public String toString() {
		 return "Multar";
	}

}
