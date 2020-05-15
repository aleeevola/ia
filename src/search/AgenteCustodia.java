package search;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import actions.IrEste;
import actions.IrNorte;
import actions.IrOeste;
import actions.IrSur;
import actions.Multar;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.solver.search.AStarSearch;
import frsf.cidisi.faia.solver.search.BreathFirstSearch;
import frsf.cidisi.faia.solver.search.DepthFirstSearch;
import frsf.cidisi.faia.solver.search.GreedySearch;
import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.Search;
import frsf.cidisi.faia.solver.search.UniformCostSearch;

public class AgenteCustodia extends SearchBasedAgent{
    public AgenteCustodia() {

        // The Agent Goal
        ObjetivoAgenteCustodia agGoal = new ObjetivoAgenteCustodia();

        // The Agent State
        EstadoAgenteCustodia agState = new EstadoAgenteCustodia();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        operators.addElement(new Multar());
        operators.addElement(new IrEste());
        operators.addElement(new IrOeste());	
        operators.addElement(new IrNorte());
        operators.addElement(new IrSur());
        

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
    	//DepthFirstSearch strategy = new DepthFirstSearch();     
    	
    	/**
         * Another search strategy examples:
         * 
         * Depth First Search:
         * DepthFirstSearch strategy = new DepthFirstSearch();
         
         //Breath First Search:
         BreathFirstSearch strategy = new BreathFirstSearch();
         /* 
         * Uniform Cost:
         * IStepCostFunction costFunction = new CostFunction();
         * UniformCostSearch strategy = new UniformCostSearch(costFunction);
         /* 
         * A Star Search:
         */ IStepCostFunction cost = new CostFunction();
          IEstimatedCostFunction heuristic = new Heuristic();
          AStarSearch strategy = new AStarSearch(cost, heuristic);
          
         /* Greedy Search:
         * IEstimatedCostFunction heuristic = new Heuristic();
         * GreedySearch strategy = new GreedySearch(heuristic);
         */

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        
        //searchSolver.setVisibleTree(Search.EFAIA_TREE); comenté esto para q no haga 1000 arboles cada vez que lo corro.

        // Set the Search searchSolver.
        this.setSolver(searchSolver);
        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(AgenteCustodia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }

}
