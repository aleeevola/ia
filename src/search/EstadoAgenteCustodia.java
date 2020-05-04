package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCustodia extends SearchBasedAgentState{
	
    private HashMap esquinas;
    private VectorCalles ubicacionActual;
    private List<VectorCalles> listaInfectados;
    private Integer cantidadMultados;

    public EstadoAgenteCustodia() {
    	
    	esquinas = cargarMapa();  //PUSE UN MÉTODO ABAJO DE TODO PARA INICIALIZAR EL HASHMAP - LINEA 70
    	ubicacionActual = new VectorCalles();
    	listaInfectados = new ArrayList<VectorCalles>();
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
	
	public VectorCalles getUbicacionActual() {
		return ubicacionActual;
	}

	public List<VectorCalles> getListaInfectados() {
		return listaInfectados;
	}

	public Integer getCantidadMultados() {
		return cantidadMultados;
	}
	
	private HashMap cargarMapa() {
		// TODO Auto-generated method stub
		return null;
	}


	public void sumarMultado() {
		cantidadMultados++;
	}

}
