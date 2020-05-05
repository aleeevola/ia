package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCustodia extends SearchBasedAgentState{
	
    private HashMap<String, List<String>> esquinas=new HashMap<String, List<String>>();;
    private String ubicacionActual;
    private List<String> listaInfectados;
    private Integer cantidadMultados;

    public EstadoAgenteCustodia() {
 
    	cargarMapa();  
    	ubicacionActual = new String();
    	listaInfectados = new ArrayList<String>();
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
	
	public String getUbicacionActual() {
		return ubicacionActual;
	}

	public List<String> getListaInfectados() {
		return listaInfectados;
	}

	public Integer getCantidadMultados() {
		return cantidadMultados;
	}
	
	private void cargarMapa() {
																	//este,oeste,norte,sur
		esquinas.put("Almirante Brown, Pedro de Vega", Arrays.asList("0","Almirante Brown, Ricardo Aldao","Echagüe, Pedro de Vega","0"));
		esquinas.put("Almirante Brown,  Ricardo Aldao", Arrays.asList("0","0","Almirante Brown, Angel Cassanello","Almirante Brown, Pedro de Vega"));
		esquinas.put("Almirante Brown, Angel Cassanello", Arrays.asList("0","Talcahuano, Angel Cassanello","Almirante Brown, J.P.López","Almirante Brown,  Ricardo Aldao"));
		esquinas.put("Almirante Brown, J.P.López", Arrays.asList("0","0","Almirante Brown, Hernandarias","Almirante Brown, Angel Cassanello"));
		esquinas.put("Defensa, J.P.López", Arrays.asList("Almirante Brown, J.P.López","0","0","0"));
		esquinas.put("Talcahuano, Angel Cassanello", Arrays.asList("Almirante Brown, Angel Cassanello","Echagüe, Angel Cassanello","Talcahuano, J.P.López","0"));
		esquinas.put("Talcahuano, J.P.López", Arrays.asList("Defensa, J.P.López","0","Talcahuano, Hernandarias","0"));
		esquinas.put("Echagüe, Pedro de Vega", Arrays.asList("0","Patricio Cullen, Pedro de Vega","0","0"));
		esquinas.put("Echagüe, Ricardo Aldao", Arrays.asList("Almirante Brown,  Ricardo Aldao","0","0","Echagüe, Pedro de Vega"));
		esquinas.put("Echagüe, Angel Cassanello", Arrays.asList("Talcahuano, Angel Cassanello","Patricio Cullen, Angel Cassanello","0","Echagüe, Ricardo Aldao"));
		esquinas.put("Patricio Cullen, Pedro de Vega", Arrays.asList("0","Antonia Godoy, Pedro de Vega","Patricio Cullen, Ricardo Aldao","0"));
		esquinas.put("Patricio Cullen, Ricardo Aldao", Arrays.asList("Echagüe, Ricardo Aldao","0","Patricio Cullen, Angel Cassanello","0"));
		esquinas.put("Patricio Cullen, Angel Cassanello", Arrays.asList("Echagüe, Angel Cassanello","Antonia Godoy, Angel Cassanello","Patricio Cullen, J.P.López","0"));
		esquinas.put("Patricio Cullen, J.P.López", Arrays.asList("Echagüe, J.P.López","0","Patricio Cullen, Pje Pujato","0"));
		esquinas.put("Antonia Godoy, Pedro de Vega", Arrays.asList("0","Piedras, Pedro de Vega","0","0"));
		esquinas.put("Antonia Godoy, Ricardo Aldao", Arrays.asList("Patricio Cullen, Ricardo Aldao","0","0","Antonia Godoy, Pedro de Vega"));
		esquinas.put("Antonia Godoy, Angel Cassanello", Arrays.asList("Piedras, Angel Cassanello","Patricio Cullen, Angel Cassanello","0","Antonia Godoy, Ricardo Aldao"));
		esquinas.put("Antonia Godoy, J.P.López", Arrays.asList("Patricio Cullen, J.P.López","0","0","Antonia Godoy, Angel Cassanello"));
		esquinas.put("Piedras, Pedro de Vega", Arrays.asList("0","Tacuarí, Pedro de Vega","Piedras, Ricardo Aldao","0"));
		esquinas.put("Piedras, Ricardo Aldao", Arrays.asList("Antonia Godoy, Ricardo Aldao","0","Piedras, Angel Cassanello","0"));
		esquinas.put("Piedras, Angel Cassanello", Arrays.asList("Antonia Godoy, Angel Cassanello","Tacuarí, Angel Cassanello","Piedras, J.P.López","0"));
		esquinas.put("Piedras, J.P.López", Arrays.asList("Antonia Godoy, J.P.López","0","Piedras, Pje Pujato","0"));
		esquinas.put("Tacuarí, Pedro de Vega", Arrays.asList("0","Vélez Sarsfield, Pedro de Vega","0","0"));
		esquinas.put("Tacuarí, Ricardo Aldao", Arrays.asList("Piedras, Ricardo Aldao","0","0","Tacuarí, Pedro de Vega"));
		esquinas.put("Tacuarí, Angel Cassanello", Arrays.asList("Piedras, Angel Cassanello","Vélez Sarsfield, Angel Cassanello","0","Tacuarí, Ricardo Aldao"));
		esquinas.put("Tacuarí, J.P.López", Arrays.asList("Piedras, J.P.López","0","0","Tacuarí, Angel Cassanello"));
		esquinas.put("Vélez Sarsfield, Pedro de Vega", Arrays.asList("0","0","Vélez Sarsfield, Ricardo Aldao","0"));
		esquinas.put("Vélez Sarsfield, Ricardo Aldao", Arrays.asList("Tacuarí, Ricardo Aldao","0","Vélez Sarsfield, Angel Cassanello","0"));
		esquinas.put("Vélez Sarsfield, Angel Cassanello", Arrays.asList("Tacuarí, Angel Cassanello","Dorrego, Angel Cassanello","Vélez Sarsfield, J.P.López","0"));
		esquinas.put("Vélez Sarsfield, J.P.López", Arrays.asList("Tacuarí, J.P.López","0","Vélez Sarsfield, Hernandarias","0"));
		esquinas.put("Dorrego, Pedro de Vega", Arrays.asList("0","General Paz, Ricardo Aldao","Dorrego, Ricardo Aldao","0"));
		esquinas.put("Dorrego, Ricardo Aldao", Arrays.asList("0","0","Dorrego, Angel Cassanello","Dorrego, Pedro de Vega"));
		esquinas.put("Dorrego, Angel Cassanello", Arrays.asList("Vélez Sarsfield, Angel Cassanello","General Paz, Angel Cassanello","0","Dorrego, Ricardo Aldao"));
		esquinas.put("General Paz, Pedro de Vega", Arrays.asList("0","0","General Paz, Ricardo Aldao","0"));
		esquinas.put("General Paz, Ricardo Aldao", Arrays.asList("Dorrego, Ricardo Aldao","0","General Paz, Angel Cassanello","General Paz, Pedro de Vega"));
		esquinas.put("General Paz, Angel Cassanello", Arrays.asList("General Paz, Dorrego","0","General Paz, J.P.López","General Paz, Ricardo Aldao"));
		esquinas.put("General Paz, J.P.López", Arrays.asList("0","0","General Paz, Hernandarias","General Paz, Angel Cassanello"));
		esquinas.put("Almirante Brown, Hernandarias", Arrays.asList("Almirante Brown, Juan Castelli","Defensa, Hernandarias","Almirante Brown, Riobamba","Almirante Brown, J.P.López"));
		esquinas.put("Almirante Brown, Riobamba", Arrays.asList("0","0","Riobamba, Juan Castelli","0"));
		esquinas.put("Almirante Brown, Juan Castelli", Arrays.asList("0","0","Almirante Brown, Estanislao Zeballos","Almirante Brown, Hernandarias"));
		esquinas.put("Almirante Brown, Estanislao Zeballos", Arrays.asList("0","Riobamba, Estanislao Zeballos","Almirante Brown, Obispo Boneo","Almirante Brown, Juan Castelli"));
		esquinas.put("Riobamba, Juan Castelli", Arrays.asList("Almirante Brown, Juan Castelli","0","Río Bamba, Estanislao Zeballos","0"));
		esquinas.put("Riobamba, Estanislao Zeballos", Arrays.asList("0","Defensa, Estanislao Zeballos","Riobamba, Obispo Boneo","0"));
		esquinas.put("Defensa, Hernandarias", Arrays.asList("0","Talcahuano, Hernandarias","0","Defensa, J.P.López"));
		esquinas.put("Defensa, Juan Castelli", Arrays.asList("Riobamba, Juan Castelli","0","0","Defensa, Hernandarias"));
		esquinas.put("Defensa, Estanislao Zeballos", Arrays.asList("0","Talcahuano, Estanislao Zeballos","0","Defensa, Juan Castelli"));
		esquinas.put("Talcahuano, Hernandarias", Arrays.asList("0","Echagüe, Hernandarias","Talcahuano, Juan Castelli","0"));
		esquinas.put("Talcahuano, Juan Castelli", Arrays.asList("Defensa, Juan Castelli","0","Talcahuano, Estanislao Zeballos","0"));
		esquinas.put("Talcahuano, Estanislao Zeballos", Arrays.asList("0","Echagüe, Estanislao Zeballos","Talcahuano, Obispo Boneo","0"));
		esquinas.put("Echagüe, Pje. Pujato", Arrays.asList("0","Patricio Cullen, Pje. Pujato","0","Echagüe, J.P.López"));
		esquinas.put("Echagüe, Hernandarias", Arrays.asList("0","Patricio Cullen, Hernandarias","0","Echagüe, J.P. López"));
		esquinas.put("Echagüe, Juan Castelli", Arrays.asList("Talcahuano, Juan Castelli","0","0","Echagüe, Hernandarias"));
		esquinas.put("Echagüe, Estanislao Zeballos", Arrays.asList("0","Patricio Cullen, Estanislao Zeballos","0","Echagüe, Juan Castelli"));
		esquinas.put("Patricio Cullen, Pje. Pujato", Arrays.asList("Echagüe, Pje. Pujato","Antonia Godoy, Pje. Pujato","Patricio Cullen, Hernandarias","0"));
		esquinas.put("Patricio Cullen, Hernandarias", Arrays.asList("0","Antonia Godoy, Hernandarias","Patricio Cullen, Juan Castelli","0"));
		esquinas.put("Patricio Cullen, Juan Castelli", Arrays.asList("Echagüe, Juan Castelli","0","Patricio Cullen, Estanislao Zeballos","0"));
		esquinas.put("Patricio Cullen, Estanislao Zeballos", Arrays.asList("0","Antonia Godoy, Estanislao Zeballos","Patricio Cullen, Obispo Boneo","0"));
		esquinas.put("Antonia Godoy, Pje. Pujato", Arrays.asList("Patricio Cullen, Pje. Pujato","0","0","Antonia Godoy, J.P.López"));
		esquinas.put("Antonia Godoy, Hernandarias", Arrays.asList("0","Piedras, Hernandarias","0","Antonia Godoy, J.P. López"));
		esquinas.put("Antonia Godoy, Juan Castelli", Arrays.asList("Patricio Cullen, Juan Castelli","0","0","Antonia Godoy, Hernandarias"));
		esquinas.put("Antonia Godoy, Estanislao Zeballos", Arrays.asList("0","Piedras, Estanislao Zeballos","0","Antonia Godoy, Juan Castelli"));
		esquinas.put("Piedras, Pje. Pujato", Arrays.asList("0","Tacuarí, Pje. Pujato","Piedras, Hernandarias","0"));
		esquinas.put("Piedras, Hernandarias", Arrays.asList("0","Tacuarí, Hernandarias","Piedras, Juan Castelli","0"));
		esquinas.put("Piedras, Juan Castelli", Arrays.asList("Antonia Godoy, Juan Castelli","0","Piedras, Estanislao Zeballos","0"));
		esquinas.put("Piedras, Estanislao Zeballos", Arrays.asList("0","Tacuarí, Estanislao Zeballos","Piedras, Obispo Boneo","0"));
		esquinas.put("Tacuarí, Pje. Pujato", Arrays.asList("Piedras, Pje. Pujato","0","0","Tacuarí, J.P.López"));
		esquinas.put("Tacuarí, Hernandarias", Arrays.asList("0","Velez Sarfield, Hernandarias","0","Tacuarí, J.P. López"));
		esquinas.put("Tacuarí, Juan Castelli", Arrays.asList("Piedras, Juan Castelli","0","0","Tacuarí, Hernandarias"));
		esquinas.put("Tacuarí, Estanislao Zeballos", Arrays.asList("0","Velez Sarfield, Estanislao Zeballos","0","Tacuarí, Juan Castelli"));
		esquinas.put("Velez Sarfield, Hernandarias", Arrays.asList("0","General Paz, Hernandarias","Velez Sarfield, Juan Castelli","0"));
		esquinas.put("Velez Sarfield, Juan Castelli", Arrays.asList("Tacuarí, Juan Castelli","0","Velez Sarfield, Estanislao Zeballos","0"));
		esquinas.put("Velez Sarfield, Estanislao Zeballos", Arrays.asList("0","General Paz, Estanislao Zeballos","0","0"));
		esquinas.put("General Paz, Hernandarias", Arrays.asList("0","0","General Paz, Juan Castelli","General Paz, J.P. López"));
		esquinas.put("General Paz, Juan Castelli", Arrays.asList("0","0","General Paz, Estanislao Zeballos","General Paz, Hernandarias"));
		esquinas.put("General Paz, Estanislao Zeballos", Arrays.asList("0","0","General Paz, Obispo Boneo","General Paz, Juan Castelli"));
		esquinas.put("Almirante Brown, Obispo Boneo", Arrays.asList("0","0","Almirante Brown, Espora","Almirante Brown, Estanislao Zeballos"));
		esquinas.put("Almirante Brown, Espora", Arrays.asList("0","Riobamba,Espora","Almirante Brown, Obispo Príncipe","Almirante Brown, Obispo Boneo"));
		esquinas.put("Almirante Brown, Obispo Príncipe", Arrays.asList("0","0","Almirante Brown, Alberti","Almirante Brown, Espora"));
		esquinas.put("Almirante Brown, Alberti", Arrays.asList("0","Riobamba, Alberti","Almirante Brown, Cardenal Fasolino","Almirante Brown, Obispo Príncipe"));
		esquinas.put("Almirante Brown, Cardenal Fasolino", Arrays.asList("0","0","Almirante Brown, Padre Genesio","Almirante Brown, Alberti"));
		esquinas.put("Almirante Brown, Padre Genesio", Arrays.asList("0","Riobamba, Padre Genesio","Almirante Brown, Javier de la Rosa","Almirante Brown, Cardenal Fasolino"));
		esquinas.put("Almirante Brown, Javier de la Rosa", Arrays.asList("0","0","Italia, Regimiento 12 de Infantería","Almirante Brown, Padre Genesio"));
		esquinas.put("Riobamba, Obispo Boneo", Arrays.asList("Almirante Brown, Obispo Boneo","0","Riobamba, Espora","0"));
		esquinas.put("Riobamba, Espora", Arrays.asList("0","Defensa, Espora","Riobamba, Obispo Príncipe","0"));
		esquinas.put("Riobamba, Obispo Príncipe", Arrays.asList("Almirante Brown, Obispo Príncipe","0","Riobamba, Alberti","0"));
		esquinas.put("Riobamba, Alberti", Arrays.asList("0","Defensa, Alberti","Riobamba, Cardenal Fasolino","0"));
		esquinas.put("Riobamba, Cardenal Fasolino", Arrays.asList("Almirante Brown, Cardenal Fasolino","0","Riobamba, Padre Genesio","0"));
		esquinas.put("Riobamba, Padre Genesio", Arrays.asList("0","Defensa, Padre Genesio","Riobamba, Javier de la Rosa","0"));
		esquinas.put("Riobamba, Javier de la Rosa", Arrays.asList("0","0","Riobamba, Regimiento 12 de Infantería","0"));
		esquinas.put("Riobamba, Regimiento 12 de Infantería", Arrays.asList("0","Defensa, Regimiento 12 de Infantería","0","0"));
		esquinas.put("Defensa, Obispo Boneo", Arrays.asList("Riobamba, Obispo Boneo","0","0","Defensa, Estanislao Zeballos"));
		esquinas.put("Defensa,Espora", Arrays.asList("0","Talcahuano,Espora","0","Defensa, Obispo Boneo"));
		esquinas.put("Defensa, Obispo Príncipe", Arrays.asList("Riobamba,Obispo Príncipe","0","0","Defensa, Espora"));
		esquinas.put("Defensa, Alberti", Arrays.asList("0","Talcahuano, Alberti","0","Defensa, Obispo Príncipe"));
		esquinas.put("Defensa, Cardenal Fasolino", Arrays.asList("Riobamba, Cardenal Fasolino","0","0","Defensa, Alberti"));
		esquinas.put("Defensa, Padre Genesio", Arrays.asList("0","Talcahuano, Padre Genesio","0","Defensa, Cardenal Fasolino"));
		esquinas.put("Defensa, Javier de la Rosa", Arrays.asList("0","0","0","Defensa, Padre Genesio"));
		esquinas.put("Defensa, Regimiento 12 de Infantería", Arrays.asList("0","Talcahuano, Regimiento 12 de Infantería","0","Defensa, Javier de la Rosa"));
		esquinas.put("Talcahuano, Obispo Boneo", Arrays.asList("Defensa, Obispo Boneo","0","Talcahuano, Espora","0"));
		esquinas.put("Talcahuano, Espora", Arrays.asList("0","Echagüe, Espora","Talcahuano, Obispo Príncipe","0"));
		esquinas.put("Talcahuano, Obispo Príncipe", Arrays.asList("Defensa,Obispo Príncipe","0","Talcahuano, Alberti","0"));
		esquinas.put("Talcahuano, Alberti", Arrays.asList("0","Echagüe, Alberti","Talcahuano, Cardenal Fasolino","0"));
		esquinas.put("Talcahuano, Cardenal Fasolino", Arrays.asList("Defensa, Cardenal Fasolino","0","Talcahuano, Padre Genesio","0"));
		esquinas.put("Talcahuano, Padre Genesio", Arrays.asList("0","Echagüe, Padre Genesio","Talcahuano, Javier de la Rosa","0"));
		esquinas.put("Talcahuano, Javier de la Rosa", Arrays.asList("0","0","Talcahuano, Regimiento 12 de Infantería","0"));
		esquinas.put("Talcahuano, Regimiento 12 de Infantería", Arrays.asList("0","Echagüe, Regimiento 12 de Infantería","0","0"));
		esquinas.put("Echagüe, Obispo Boneo", Arrays.asList("Talcahuano, Obispo Boneo","0","0","Echagüe, Estanislao Zeballos"));
		esquinas.put("Echagüe, Espora", Arrays.asList("0","Patricio Cullen, Espora","0","Echagüe, Obispo Boneo"));
		esquinas.put("Echagüe, Obispo Príncipe", Arrays.asList("Talcahuano, Obispo Príncipe","0","0","Echagüe, Espora"));
		esquinas.put("Echagüe, Alberti", Arrays.asList("0","Patricio Cullen, Alberti","0","Echagüe, Obispo Príncipe"));
		esquinas.put("Echagüe, Cardenal Fasolino", Arrays.asList("Talcahuano, Cardenal Fasolino","0","0","Echagüe, Alberti"));
		esquinas.put("Echagüe, Padre Genesio", Arrays.asList("0","Patricio Cullen, Padre Genesio","0","Echagüe, Cardenal Fasolino"));
		esquinas.put("Echagüe, Javier de la Rosa", Arrays.asList("0","0","0","Echagüe, Padre Genesio"));
		esquinas.put("Echagüe, Regimiento 12 de Infantería", Arrays.asList("0","Patricio Cullen, Regimiento 12 de Infantería","0","Echagüe, Javier de la Rosa"));
		esquinas.put("Patricio Cullen, Obispo Boneo", Arrays.asList("Echagüe, Obispo Boneo","0","Patricio Cullen, Espora","0"));
		esquinas.put("Patricio Cullen,Espora", Arrays.asList("0","Antonia Godoy,Espora","Patricio Cullen, Obispo Príncipe","0"));
		esquinas.put("Patricio Cullen, Obispo Príncipe", Arrays.asList("Echagüe,Obispo Príncipe","0","0","0"));
		esquinas.put("Patricio Cullen, Alberti", Arrays.asList("Echagüe, Alberti","0","Patricio Cullen, Cardenal Fasolino","0"));
		esquinas.put("Patricio Cullen, Cardenal Fasolino", Arrays.asList("Echagüe, Cardenal Fasolino","0","Patricio Cullen, Pje de Andrea","0"));
		esquinas.put("Patricio Cullen, Pje de Andrea", Arrays.asList("0","Antonia Godoy, Pje de Andrea","Patricio Cullen, Padre Genesio","0"));
		esquinas.put("Patricio Cullen, Padre Genesio", Arrays.asList("0","Antonia Godoy, Padre Genesio","Patricio Cullen, Javier de la Rosa","0"));
		esquinas.put("Patricio Cullen, Javier de la Rosa", Arrays.asList("Echagüe, Javier de la Rosa","0","Patricio Cullen, Regimiento 12 de Infantería","0"));
		esquinas.put("Patricio Cullen, Regimiento 12 de Infantería", Arrays.asList("0","Antonia Godoy, Regimiento 12 de Infantería","0","0"));
		esquinas.put("Juan Maciel, Obispo Príncipe", Arrays.asList("Patricio Cullen, Obispo Príncipe","0","Juan Maciel, Alberti","0"));
		esquinas.put("Juan Maciel, Alberti", Arrays.asList("Patricio Cullen, Alberti","0","0","Juan Maciel, Obispo Príncipe"));
		esquinas.put("Antonia Godoy, Obispo Boneo", Arrays.asList("Patricio Cullen, Obispo Boneo","0","0","Antonia Godoy, Estanislao Zeballos"));
		esquinas.put("Antonia Godoy, Espora", Arrays.asList("0","Piedras, Espora","0","Antonia Godoy, Obispo Boneo"));
		esquinas.put("Antonia Godoy, Obispo Príncipe", Arrays.asList("Juan Maciel, Obispo Príncipe","0","0","Antonia Godoy, Espora"));
		esquinas.put("Antonia Godoy, Alberti", Arrays.asList("Juan Maciel, Alberti","0","0","0"));
		esquinas.put("Antonia Godoy, Cardenal Fasolino", Arrays.asList("Patricio Cullen, Cardenal Fasolino","0","0","Antonia Godoy, Alberti"));
		esquinas.put("Antonia Godoy, Pje de Andrea", Arrays.asList("0","0","0","Antonia Godoy, Cardenal Fasolino"));
		esquinas.put("Antonia Godoy, Padre Genesio", Arrays.asList("0","Piedras, Padre Genesio","0","Antonia Godoy, Pje de Andrea"));
		esquinas.put("Antonia Godoy, Javier de la Rosa", Arrays.asList("0","0","0","0"));
		esquinas.put("Antonia Godoy, Regimiento 12 de Infantería", Arrays.asList("0","Piedras, Regimiento 12 de Infantería","0","Antonia Godoy, Javier de la Rosa"));
		esquinas.put("Piedras, Obispo Boneo", Arrays.asList("Antonia Godoy, Obispo Boneo","0","Piedras, Espora","0"));
		esquinas.put("Piedras, Espora", Arrays.asList("0","Tacuarí, Espora","Piedras, Obispo Príncipe","0"));
		esquinas.put("Piedras, Obispo Príncipe", Arrays.asList("Antonia Godoy, Obispo Príncipe","0","Piedras, Alberti","0"));
		esquinas.put("Piedras, Alberti", Arrays.asList("0","Tacuarí, Alberti","Piedras, Cardenal Fasolino","0"));
		esquinas.put("Piedras, Cardenal Fasolino", Arrays.asList("Antonia Godoy, Cardenal Fasolino","0","Piedras, Pje de Andrea","0"));
		esquinas.put("Piedras, Pje de Andrea", Arrays.asList("0","Tacuarí, Pje de Andrea","Piedras, Padre Genesio","0"));
		esquinas.put("Piedras, Padre Genesio", Arrays.asList("0","Tacuarí, Padre Genesio","Piedras, Javier de la Rosa","0"));
		esquinas.put("Piedras, Javier de la Rosa", Arrays.asList("0","0","Piedras, Regimiento 12 de Infantería","0"));
		esquinas.put("Piedras, Regimiento 12 de Infantería", Arrays.asList("0","Tacuarí, Regimiento 12 de Infantería","0","0"));
		esquinas.put("Tacuarí, Obispo Boneo", Arrays.asList("Piedras, Obispo Boneo","0","0","Tacuarí, Estanislao Zeballos"));
		esquinas.put("Tacuarí, Espora", Arrays.asList("0","General Paz, Espora","0","Tacuarí, Obispo Boneo"));
		esquinas.put("Tacuarí, Obispo Príncipe", Arrays.asList("Piedras, Obispo Príncipe","0","0","Tacuarí, Espora"));
		esquinas.put("Tacuarí, Alberti", Arrays.asList("0","General Paz, Alberti","0","Tacuarí, Obispo Príncipe"));
		esquinas.put("Tacuarí, Cardenal Fasolino", Arrays.asList("Piedras, Cardenal Fasolino","0","0","Tacuarí, Alberti"));
		esquinas.put("Tacuarí, Pje de Andrea", Arrays.asList("Piedras, Pje de Andrea","0","0","Tacuarí, Cardenal Fasolino"));
		esquinas.put("Tacuarí, Padre Genesio", Arrays.asList("0","General Paz, Padre Genesio","0","Tacuarí, Pje de Andrea"));
		esquinas.put("Tacuarí, Javier de la Rosa", Arrays.asList("0","0","0","Tacuarí, Padre Genesio"));
		esquinas.put("Tacuarí, Regimiento 12 de Infantería", Arrays.asList("0","General Paz, Regimiento 12 de Infantería","0","Tacuarí, Javier de la Rosa"));
		esquinas.put("General Paz, Obispo Boneo", Arrays.asList("Tacuarí, Obispo Boneo","0","General Paz, Espora","General Paz, Estanislao Zeballos"));
		esquinas.put("General Paz, Espora", Arrays.asList("0","0","General Paz, Obispo Príncipe","General Paz, Obispo Boneo"));
		esquinas.put("General Paz, Obispo Príncipe", Arrays.asList("Tacuarí, Obispo Príncipe","0","General Paz, Alberti","General Paz, Espora"));
		esquinas.put("General Paz, Alberti", Arrays.asList("0","0","General Paz, Cardenal Fasolino","General Paz, Obispo Príncipe"));
		esquinas.put("General Paz, Cardenal Fasolino", Arrays.asList("Tacuarí, Cardenal Fasolino","0","General Paz, Padre Genesio","General Paz, Alberti"));
		esquinas.put("General Paz, Padre Genesio", Arrays.asList("0","0","General Paz, Javier de la Rosa","General Paz, Cardenal Fasolino"));
		esquinas.put("General Paz, Javier de la Rosa", Arrays.asList("Tacuarí, Javier de la Rosa","0","General Paz, Regimiento 12 de Infantería","General Paz, Padre Genesio"));
		esquinas.put("General Paz, Regimiento 12 de Infantería", Arrays.asList("0","0","0","General Paz, Javier de la Rosa"));
		
	}


	public void sumarMultado() {
		cantidadMultados++;
	}

}
