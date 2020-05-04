package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCustodia extends SearchBasedAgentState{
	
    private HashMap esquinas;
    private List<VectorCalle> ubicacionActual;
    private List<VectorCalle> listaMultados;
    private Integer cantidadMultados;

    public EstadoAgenteCustodia() {
    	
    	esquinas = new HashMap();  //ESTO ES PROVISORIO CREO QUE LA INICIALIZACION NO ES ASÍ
    	ubicacionActual = new ArrayList<VectorCalle>();
    	listaMultados = new ArrayList<VectorCalle>();
		cantidadMultados = 0;
    	
        this.initState();
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		
	}

	public List<VectorCalle> getListaInfectados() {
		return listaMultados;
	}

	public Integer getCantidadMultados() {
		return cantidadMultados;
	}

}
