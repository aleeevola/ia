package search;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import interfaz.MainAgenteCustodia;

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
		//incrementa el numero de iteracion para agregarlo en la tabla y saber cuando se da cada percepcion.

		PerceptionAgenteCustodia perception = new PerceptionAgenteCustodia();
		
		 List<VectorCalles> listaInfectados=new ArrayList<VectorCalles>();
		 //List<VectorCalles> listaAux=new ArrayList<VectorCalles>();
		 List<VectorCalles> callesCortadas=new ArrayList<VectorCalles>();
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
		 //listaInfectados.add(new VectorCalles("Riobamba","Obispo Boneo"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Angel Cassanello"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Espora"));
		 //listaInfectados.add(new VectorCalles("Patricio Cullen","Obispo Príncipe"));
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Juan Castelli"));
		 
		/*listaAux.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
		listaAux.add(new VectorCalles("Riobamba","Obispo Boneo"));
		listaAux.add(new VectorCalles("Talcahuano","Hernandarias"));
    	listaAux.add(new VectorCalles("Tacuarí","Angel Cassanello"));
    	listaAux.add(new VectorCalles("Antonia Godoy","J.P.López"));
    	listaAux.add(new VectorCalles("Antonia Godoy","Hernandarias"));
    	listaAux.add(new VectorCalles("Echagüe","Ricardo Aldao"));
    	listaAux.add(new VectorCalles("Echagüe","Hernandarias"));
    	listaAux.add(new VectorCalles("Echagüe","Estanislao Zeballos"));
    	listaAux.add(new VectorCalles("Patricio Cullen","Juan Castelli"));
    	listaAux.add(new VectorCalles("Patricio Cullen","Obispo Príncipe"));
    	listaAux.add(new VectorCalles("Vélez Sarsfield","J.P.López"));
    	listaAux.add(new VectorCalles("Tacuarí","Juan Castelli"));
    	listaAux.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    	listaAux.add(new VectorCalles("Tacuarí","Espora"));
    	listaAux.add(new VectorCalles("General Paz","Cardenal Fasolino"));
    	listaAux.add(new VectorCalles("Defensa","Alberti"));
    	listaAux.add(new VectorCalles("Echagüe","Padre Genesio"));
    	listaAux.add(new VectorCalles("Piedras","Javier de la Rosa"));
    	listaAux.add(new VectorCalles("General Paz","Pedro de Vega"));
    	
    	
    	int i = (int) (Math.random() * 20);
    	int i2 = (int) (Math.random() * 20);
 /*   	
    	if(i2<5){
    		listaInfectados.add(listaAux.get(i));
    		//if(i>5) callesCortadas.add(listaAux.get(i+1));
    	} else {
    	//i2<5 es una condición arbitraria para que en algunas iteraciones se agreguen ciudadados-infectados y en otras no.
    	if(!callesCortadas.isEmpty())callesCortadas.remove(callesCortadas.get(0));
    	}
    
 */   	
    	if(cont==0) {
    		//listaInfectados.add(new VectorCalles("Patricio Cullen","J.P.López"));
    		//listaInfectados.add(new VectorCalles("Almirante Brown","J.P.López"));
    		}
    	cont++;
    	switch (cont) {
    	case 2:
    		break;
    	case 9:
    		listaInfectados.add(new VectorCalles("Tacuar�","Espora"));
    		callesCortadas.add(new VectorCalles("Defensa","Estanislao Zeballos"));
    		break;
    	case 11:
    		listaInfectados.add(new VectorCalles("Patricio Cullen","Hernandarias"));
    		break;
    	case 15:
    		listaInfectados.add(new VectorCalles("Defensa","Juan Castelli"));
    		break;
    	case 18:
    		listaInfectados.add(new VectorCalles("Echag�e","Estanislao Zeballos"));
    		break;
    	case 20:
			callesCortadas.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    		break;
    	}
    	/*if(cont==2) {
    		//listaInfectados.add(new VectorCalles("Tacuarí","Angel Cassanello"));
    
    		//listaInfectados.add(new VectorCalles("Patricio Cullen","J.P.López"));
    		//listaInfectados.add(new VectorCalles("Almirante Brown","J.P.López"));
    	}
    	else {
    		if(cont==16) {
    			
    			listaInfectados.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    			//listaInfectados.add(new VectorCalles("Vélez Sarsfield","Hernandarias"));
    		}
    		else {
    			if(cont==10) {
   				  listaInfectados.add(new VectorCalles("Tacuarí","Espora"));
   				  callesCortadas.add(new VectorCalles("Defensa","Estanislao Zeballos"));
    				//listaInfectados.add(new VectorCalles("Talcahuano","Juan Castelli"));
    			}
    			else {
    				if(cont==20) {
    					listaInfectados.add(new VectorCalles("Echagüe","Estanislao Zeballos"));
    					callesCortadas.add(new VectorCalles("Defensa","Juan Castelli"));
    				}
    				else {
    					if(cont==13) {
    						listaInfectados.add(new VectorCalles("Patricio Cullen","Hernandarias"));
    					}
    				}
    			}
    		}
    	}
    	
    	*/
    	
    	perception.setInfectados((ArrayList<VectorCalles>) listaInfectados);
		perception.setCallesCortadas((ArrayList<VectorCalles>)callesCortadas);
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
