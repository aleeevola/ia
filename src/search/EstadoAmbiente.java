package search;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private List<VectorCalles> listaInfectados;
    private List<VectorCalles> listaCallesCortadas;
    private VectorCalles posicionAgenteCustodia;
    private Integer cantidadMultados;
	
    public EstadoAmbiente() {
        
    	listaInfectados = new ArrayList<VectorCalles>();
    	listaCallesCortadas = new ArrayList<VectorCalles>();
    	posicionAgenteCustodia = new VectorCalles();
    	cantidadMultados=0;
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	//El estado inicial del estado del Ambiente; el escenario de entrada
    	VectorCalles v1 = new VectorCalles("Almirante Brown","Pedro de Vega");
    	posicionAgenteCustodia = v1; 	
    	
    	listaInfectados.add(new VectorCalles("Almirante Brown","Ricardo Aldao"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Angel Cassanello"));
    	//listaInfectados.add(new VectorCalles("Tacuarí","Espora"));
    	//listaInfectados.add(new VectorCalles("Almirante Brown","Juan Castelli"));
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
    	
        String str = "";
        
        str += "Lista de posiciones ciudadanos-infectados que violan la cuarentena: {";
        for(VectorCalles v : listaInfectados)
        	str+= v.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicionAgenteCustodia.toString(); 

        return str;
    }

     public List<VectorCalles> getListaInfectados(){
        return listaInfectados;
     }
     
     public void setListaInfectados(List<VectorCalles> arg){
        listaInfectados = arg;
     }
    
     public VectorCalles getposicionAgenteCustodia(){
        return posicionAgenteCustodia;
     }
     public void setposicionAgenteCustodia(VectorCalles arg){
        posicionAgenteCustodia = arg;
     }

	public void sumarMultado() {
		cantidadMultados++;
		
	}

	public List<VectorCalles> getListaCallesCortadas() {
		return listaCallesCortadas;
	}

	public void setListaCallesCortadas(List<VectorCalles> listaCallesCortadas) {
		this.listaCallesCortadas = listaCallesCortadas;
	}
	
	

}