package search;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {
	int cont = 0;
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
		 List<VectorCalles> listaAux=new ArrayList<VectorCalles>();
		 List<VectorCalles> callesCortadas=new ArrayList<VectorCalles>();
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
		 //listaInfectados.add(new VectorCalles("Riobamba","Obispo Boneo"));
    	//listaInfectados.add(new VectorCalles("Tacuar�","Angel Cassanello"));
    	//listaInfectados.add(new VectorCalles("Tacuar�","Espora"));
		 //listaInfectados.add(new VectorCalles("Patricio Cullen","Obispo Pr�ncipe"));
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Juan Castelli"));
		 
		listaAux.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
		listaAux.add(new VectorCalles("Riobamba","Obispo Boneo"));
		listaAux.add(new VectorCalles("Talcahuano","Hernandarias"));
    	listaAux.add(new VectorCalles("Tacuar�","Angel Cassanello"));
    	listaAux.add(new VectorCalles("Antonia Godoy","J.P.L�pez"));
    	listaAux.add(new VectorCalles("Antonia Godoy","Hernandarias"));
    	listaAux.add(new VectorCalles("Echag�e","Ricardo Aldao"));
    	listaAux.add(new VectorCalles("Echag�e","Hernandarias"));
    	listaAux.add(new VectorCalles("Echag�e","Estanislao Zeballos"));
    	listaAux.add(new VectorCalles("Patricio Cullen","Juan Castelli"));
    	listaAux.add(new VectorCalles("Patricio Cullen","Obispo Pr�ncipe"));
    	listaAux.add(new VectorCalles("V�lez Sarsfield","J.P.L�pez"));
    	listaAux.add(new VectorCalles("Tacuar�","Juan Castelli"));
    	listaAux.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    	listaAux.add(new VectorCalles("Tacuar�","Espora"));
    	listaAux.add(new VectorCalles("General Paz","Cardenal Fasolino"));
    	listaAux.add(new VectorCalles("Defensa","Alberti"));
    	listaAux.add(new VectorCalles("Echag�e","Padre Genesio"));
    	listaAux.add(new VectorCalles("Piedras","Javier de la Rosa"));
    	listaAux.add(new VectorCalles("General Paz","Pedro de Vega"));
    	
    	
    	int i = (int) (Math.random() * 20);
    	int i2 = (int) (Math.random() * 20);
 /*   	
    	if(i2<5){
    		listaInfectados.add(listaAux.get(i));
    		//if(i>5) callesCortadas.add(listaAux.get(i+1));
    	} else {
    	//i2<5 es una condici�n arbitraria para que en algunas iteraciones se agreguen ciudadados-infectados y en otras no.
    	if(!callesCortadas.isEmpty())callesCortadas.remove(callesCortadas.get(0));
    	}
    
 */   	
    	if(cont==0) {
    		listaInfectados.add(new VectorCalles("Patricio Cullen","J.P.L�pez"));
    		listaInfectados.add(new VectorCalles("Almirante Brown","J.P.L�pez"));}
    	cont++;
    	if(cont==2) {
    		//listaInfectados.add(new VectorCalles("Patricio Cullen","J.P.L�pez"));
    		//listaInfectados.add(new VectorCalles("Almirante Brown","J.P.L�pez"));
    	}
    	else {
    		if(cont==6) {
    			//listaInfectados.add(new VectorCalles("V�lez Sarsfield","Hernandarias"));
    		}
    		else {
    			if(cont==7) {
    				//listaInfectados.add(new VectorCalles("Talcahuano","Juan Castelli"));
    			}
    		}
    	}
    	
    	
    	
    	perception.setInfectados((ArrayList<VectorCalles>) listaInfectados);
		perception.setCallesCortadas((ArrayList<VectorCalles>)callesCortadas);
		return perception;
	}
	
	 public String toString() {
	        return environmentState.toString();
	    }
	 
	
	//Este m�todo indica bajo qu� condici�n se considera que el agente ha fallado
    public boolean agentFailed(Action actionReturned) {
    	boolean failed = false;

    	//Notar que en este punto tenemos 3 posibilidades inmediatas:
    	//1 - Agregar al estado del ambiente el atributo que nos indica falla (energ�a)
    	//2 - Agregar un operador que se denomine "apagar" (que vendr� en "actionReturned")
    	//3 - Modificar GoalBasedAgentSimulator para que pase el AgentState en lugar de Action

        return failed;
    }
	
	
}
