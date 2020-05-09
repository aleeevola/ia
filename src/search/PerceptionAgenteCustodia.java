package search;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PerceptionAgenteCustodia extends Perception{
    public static int UNKNOWN_PERCEPTION = -1;   

	private ArrayList<VectorCalles> callesCortadas;
	private ArrayList<VectorCalles> infectados;

    public  PerceptionAgenteCustodia() {
    	// TODO COMPLETAR No se que va! 
    	//Aquí crearimos los objetos, listas, arrays que componen la percepción
    	//suciedad = UNKNOWN_PERCEPTION;
    	//
    	callesCortadas= new ArrayList<VectorCalles>();
    	infectados= new ArrayList<VectorCalles>();
    }

    public PerceptionAgenteCustodia(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method initializa a perception of the agent.
     */
	@Override
	public void initPerception(Agent agentIn, Environment environmentIn) {
		// TODO Auto-generated method stub
		// TODO COMPLETAR ! @aleeevola
		AgenteCustodia agent = (AgenteCustodia) agentIn;
        Ambiente environment = (Ambiente) environmentIn;
        EstadoAmbiente environmentState = environment.getEnvironmentState();
        
        //Aquí creamos la percepción inicial del agente
        //Pimero chequeamos que la habitación en la que está el agente está sucia
        //supongo que tenemos que chequear lista de infectados y calles cortadas
        //pero no estan inicializadas en EstadoAmbiente
        ArrayList<VectorCalles> infectados=(ArrayList<VectorCalles>) environmentState.getListaInfectados();
        ArrayList<VectorCalles> callesCortadas=(ArrayList<VectorCalles>) environmentState.getListaCallesCortadas();
        
        //no se si esto es asi x en el ejemplo de la aspiradora es distinto
        this.setInfectados(infectados);
        this.setCallesCortadas(callesCortadas);
        //TODO TERMINAR
	}

	public ArrayList<VectorCalles> getCallesCortadas() {
		return callesCortadas;
	}

	public void setCallesCortadas(ArrayList<VectorCalles> callesCortadas) {
		this.callesCortadas = callesCortadas;
	}

	public ArrayList<VectorCalles> getInfectados() {
		return infectados;
	}

	public void setInfectados(ArrayList<VectorCalles> infectados) {
		this.infectados = infectados;
	}

	@Override
	public String toString() {
		return "PerceptionAgenteCustodia:\n	[callesCortadas=" + callesCortadas + "] \n 	[infectados=" + infectados + "]";
	}

	

	
}
