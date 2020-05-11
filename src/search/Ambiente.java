package search;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

	public Ambiente() {
        // Create the environment state
        this.environmentState = new EstadoAmbiente();
    }
	
	public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
	
	@Override
	public Perception getPercept() {
		// TODO REVISAR 
		
		PerceptionAgenteCustodia perception = new PerceptionAgenteCustodia();
		
		 List<VectorCalles> listaInfectados=new ArrayList<VectorCalles>();
    	listaInfectados.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Angel Cassanello"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Espora"));
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    	perception.setInfectados((ArrayList<VectorCalles>) listaInfectados);
		/*
		 * No se como implementarlo xq segun entiendo para mi son aleatorias las percepciones*/
		
		return perception;
	}
	
	 public String toString() {
	        return environmentState.toString();
	    }
	 
	
	//Este método indica bajo qué condición se considera que el agente ha fallado
    public boolean agentFailed(Action actionReturned) {
    	boolean failed = false;

    	//Notar que en este punto tenemos 3 posibilidades inmediatas:
    	//1 - Agregar al estado del ambiente el atributo que nos indica falla (energía)
    	//2 - Agregar un operador que se denomine "apagar" (que vendrá en "actionReturned")
    	//3 - Modificar GoalBasedAgentSimulator para que pase el AgentState en lugar de Action

        return failed;
    }
	
	
}
