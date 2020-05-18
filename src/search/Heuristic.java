package search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import interfaz.MainAgenteCustodia;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoAgenteCustodia agState = (EstadoAgenteCustodia) node.getAgentState();
        Double minDistance = 0.0;
        if(!agState.getListaInfectados().isEmpty()) {
        minDistance = MainAgenteCustodia.distancia(agState.getListaInfectados().get(0), agState.getUbicacionActual());}
		
        for(VectorCalles vc: agState.getListaInfectados()) {
			double d = MainAgenteCustodia.distancia(vc, agState.getUbicacionActual());
			if(d < minDistance) {
				minDistance=d;
			}

		}
        
         return minDistance;
    }
}
