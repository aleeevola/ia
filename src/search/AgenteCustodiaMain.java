package search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AgenteCustodiaMain {

    public static void main(String[] args) throws PrologConnectorException {
    	AgenteCustodia agent = new AgenteCustodia();

        Ambiente environment = new Ambiente();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
