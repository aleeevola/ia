package search;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoAmbiente extends EnvironmentState {
	
    private List<String> listaInfectados;
    private String posicionAgenteCustodia;
    private Integer cantidadMultados;
	
    public EstadoAmbiente() {
        
    	listaInfectados = new ArrayList<String>();
    	posicionAgenteCustodia = new String();
    	
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	//El estado inicial del estado del Ambiente; el escenario de entrada
    	String v1 = new String("Almirante Brown, Pedro De Vega");
    	
    	posicionAgenteCustodia = v1; 	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
    	
        String str = "";
        
        str += "Lista de posiciones ciudadanos-infectados que violan la cuarentena: {";
        for(String v : listaInfectados)
        	str+= v.toString() + ", ";
        str = str.substring(0,str.length()-2);
        str += "}\n";
        
        str += "Posición del agente: ";
        str += posicionAgenteCustodia.toString(); 

        return str;
    }

     public List<String> getListaInfectados(){
        return listaInfectados;
     }
     
     public void setListaInfectados(List<String> arg){
        listaInfectados = arg;
     }
    
     public String getposicionAgenteCustodia(){
        return posicionAgenteCustodia;
     }
     public void setposicionAgenteCustodia(String arg){
        posicionAgenteCustodia = arg;
     }

	public void sumarMultado() {
		cantidadMultados++;
		
	}
	

}