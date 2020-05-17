package search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
		
		if(node.getAction().toString().equals("Multar")) 
			return 0;
		else 
			return node.getAction().getCost();
			//return node.getCost();
        //return ((EstadoAgenteCustodia) node.getAgentState()).getVisitedCellsCount();
    }
}