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
		esquinas.put("Almirante Brown, Pedro de Vega", Arrays.asList("0","Almirante Brown, Ricardo Aldao","Echag�e, Pedro de Vega","0"));
		esquinas.put("Almirante Brown,  Ricardo Aldao", Arrays.asList("0","0","Almirante Brown, Angel Cassanello","Almirante Brown, Pedro de Vega"));
		esquinas.put("Almirante Brown, Angel Cassanello", Arrays.asList("0","Talcahuano, Angel Cassanello","Almirante Brown, J.P.L�pez","Almirante Brown,  Ricardo Aldao"));
		esquinas.put("Almirante Brown, J.P.L�pez", Arrays.asList("0","0","Almirante Brown, Hernandarias","Almirante Brown, Angel Cassanello"));
		esquinas.put("Defensa, J.P.L�pez", Arrays.asList("Almirante Brown, J.P.L�pez","0","0","0"));
		esquinas.put("Talcahuano, Angel Cassanello", Arrays.asList("Almirante Brown, Angel Cassanello","Echag�e, Angel Cassanello","Talcahuano, J.P.L�pez","0"));
		esquinas.put("Talcahuano, J.P.L�pez", Arrays.asList("Defensa, J.P.L�pez","0","Talcahuano, Hernandarias","0"));
		esquinas.put("Echag�e, Pedro de Vega", Arrays.asList("0","Patricio Cullen, Pedro de Vega","0","0"));
		esquinas.put("Echag�e, Ricardo Aldao", Arrays.asList("Almirante Brown,  Ricardo Aldao","0","0","Echag�e, Pedro de Vega"));
		esquinas.put("Echag�e, Angel Cassanello", Arrays.asList("Talcahuano, Angel Cassanello","Patricio Cullen, Angel Cassanello","0","Echag�e, Ricardo Aldao"));
		esquinas.put("Patricio Cullen, Pedro de Vega", Arrays.asList("0","Antonia Godoy, Pedro de Vega","Patricio Cullen, Ricardo Aldao","0"));
		esquinas.put("Patricio Cullen, Ricardo Aldao", Arrays.asList("Echag�e, Ricardo Aldao","0","Patricio Cullen, Angel Cassanello","0"));
		esquinas.put("Patricio Cullen, Angel Cassanello", Arrays.asList("Echag�e, Angel Cassanello","Antonia Godoy, Angel Cassanello","Patricio Cullen, J.P.L�pez","0"));
		esquinas.put("Patricio Cullen, J.P.L�pez", Arrays.asList("Echag�e, J.P.L�pez","0","Patricio Cullen, Pje Pujato","0"));
		esquinas.put("Antonia Godoy, Pedro de Vega", Arrays.asList("0","Piedras, Pedro de Vega","0","0"));
		esquinas.put("Antonia Godoy, Ricardo Aldao", Arrays.asList("Patricio Cullen, Ricardo Aldao","0","0","Antonia Godoy, Pedro de Vega"));
		esquinas.put("Antonia Godoy, Angel Cassanello", Arrays.asList("Piedras, Angel Cassanello","Patricio Cullen, Angel Cassanello","0","Antonia Godoy, Ricardo Aldao"));
		esquinas.put("Antonia Godoy, J.P.L�pez", Arrays.asList("Patricio Cullen, J.P.L�pez","0","0","Antonia Godoy, Angel Cassanello"));
		esquinas.put("Piedras, Pedro de Vega", Arrays.asList("0","Tacuar�, Pedro de Vega","Piedras, Ricardo Aldao","0"));
		esquinas.put("Piedras, Ricardo Aldao", Arrays.asList("Antonia Godoy, Ricardo Aldao","0","Piedras, Angel Cassanello","0"));
		esquinas.put("Piedras, Angel Cassanello", Arrays.asList("Antonia Godoy, Angel Cassanello","Tacuar�, Angel Cassanello","Piedras, J.P.L�pez","0"));
		esquinas.put("Piedras, J.P.L�pez", Arrays.asList("Antonia Godoy, J.P.L�pez","0","Piedras, Pje Pujato","0"));
		esquinas.put("Tacuar�, Pedro de Vega", Arrays.asList("0","V�lez Sarsfield, Pedro de Vega","0","0"));
		esquinas.put("Tacuar�, Ricardo Aldao", Arrays.asList("Piedras, Ricardo Aldao","0","0","Tacuar�, Pedro de Vega"));
		esquinas.put("Tacuar�, Angel Cassanello", Arrays.asList("Piedras, Angel Cassanello","V�lez Sarsfield, Angel Cassanello","0","Tacuar�, Ricardo Aldao"));
		esquinas.put("Tacuar�, J.P.L�pez", Arrays.asList("Piedras, J.P.L�pez","0","0","Tacuar�, Angel Cassanello"));
		esquinas.put("V�lez Sarsfield, Pedro de Vega", Arrays.asList("0","0","V�lez Sarsfield, Ricardo Aldao","0"));
		esquinas.put("V�lez Sarsfield, Ricardo Aldao", Arrays.asList("Tacuar�, Ricardo Aldao","0","V�lez Sarsfield, Angel Cassanello","0"));
		esquinas.put("V�lez Sarsfield, Angel Cassanello", Arrays.asList("Tacuar�, Angel Cassanello","Dorrego, Angel Cassanello","V�lez Sarsfield, J.P.L�pez","0"));
		esquinas.put("V�lez Sarsfield, J.P.L�pez", Arrays.asList("Tacuar�, J.P.L�pez","0","V�lez Sarsfield, Hernandarias","0"));
		esquinas.put("Dorrego, Pedro de Vega", Arrays.asList("0","General Paz, Ricardo Aldao","Dorrego, Ricardo Aldao","0"));
		esquinas.put("Dorrego, Ricardo Aldao", Arrays.asList("0","0","Dorrego, Angel Cassanello","Dorrego, Pedro de Vega"));
		esquinas.put("Dorrego, Angel Cassanello", Arrays.asList("V�lez Sarsfield, Angel Cassanello","General Paz, Angel Cassanello","0","Dorrego, Ricardo Aldao"));
		esquinas.put("General Paz, Pedro de Vega", Arrays.asList("0","0","General Paz, Ricardo Aldao","0"));
		esquinas.put("General Paz, Ricardo Aldao", Arrays.asList("Dorrego, Ricardo Aldao","0","General Paz, Angel Cassanello","General Paz, Pedro de Vega"));
		esquinas.put("General Paz, Angel Cassanello", Arrays.asList("General Paz, Dorrego","0","General Paz, J.P.L�pez","General Paz, Ricardo Aldao"));
		esquinas.put("General Paz, J.P.L�pez", Arrays.asList("0","0","General Paz, Hernandarias","General Paz, Angel Cassanello"));
		esquinas.put("Almirante Brown, Hernandarias", Arrays.asList("Almirante Brown, Juan Castelli","Defensa, Hernandarias","Almirante Brown, Riobamba","Almirante Brown, J.P.L�pez"));
		esquinas.put("Almirante Brown, Riobamba", Arrays.asList("0","0","Riobamba, Juan Castelli","0"));
		esquinas.put("Almirante Brown, Juan Castelli", Arrays.asList("0","0","Almirante Brown, Estanislao Zeballos","Almirante Brown, Hernandarias"));
		esquinas.put("Almirante Brown, Estanislao Zeballos", Arrays.asList("0","Riobamba, Estanislao Zeballos","Almirante Brown, Obispo Boneo","Almirante Brown, Juan Castelli"));
		esquinas.put("Riobamba, Juan Castelli", Arrays.asList("Almirante Brown, Juan Castelli","0","R�o Bamba, Estanislao Zeballos","0"));
		esquinas.put("Riobamba, Estanislao Zeballos", Arrays.asList("0","Defensa, Estanislao Zeballos","Riobamba, Obispo Boneo","0"));
		esquinas.put("Defensa, Hernandarias", Arrays.asList("0","Talcahuano, Hernandarias","0","Defensa, J.P.L�pez"));
		esquinas.put("Defensa, Juan Castelli", Arrays.asList("Riobamba, Juan Castelli","0","0","Defensa, Hernandarias"));
		esquinas.put("Defensa, Estanislao Zeballos", Arrays.asList("0","Talcahuano, Estanislao Zeballos","0","Defensa, Juan Castelli"));
		esquinas.put("Talcahuano, Hernandarias", Arrays.asList("0","Echag�e, Hernandarias","Talcahuano, Juan Castelli","0"));
		esquinas.put("Talcahuano, Juan Castelli", Arrays.asList("Defensa, Juan Castelli","0","Talcahuano, Estanislao Zeballos","0"));
		esquinas.put("Talcahuano, Estanislao Zeballos", Arrays.asList("0","Echag�e, Estanislao Zeballos","Talcahuano, Obispo Boneo","0"));
		esquinas.put("Echag�e, Pje. Pujato", Arrays.asList("0","Patricio Cullen, Pje. Pujato","0","Echag�e, J.P.L�pez"));
		esquinas.put("Echag�e, Hernandarias", Arrays.asList("0","Patricio Cullen, Hernandarias","0","Echag�e, J.P. L�pez"));
		esquinas.put("Echag�e, Juan Castelli", Arrays.asList("Talcahuano, Juan Castelli","0","0","Echag�e, Hernandarias"));
		esquinas.put("Echag�e, Estanislao Zeballos", Arrays.asList("0","Patricio Cullen, Estanislao Zeballos","0","Echag�e, Juan Castelli"));
		esquinas.put("Patricio Cullen, Pje. Pujato", Arrays.asList("Echag�e, Pje. Pujato","Antonia Godoy, Pje. Pujato","Patricio Cullen, Hernandarias","0"));
		esquinas.put("Patricio Cullen, Hernandarias", Arrays.asList("0","Antonia Godoy, Hernandarias","Patricio Cullen, Juan Castelli","0"));
		esquinas.put("Patricio Cullen, Juan Castelli", Arrays.asList("Echag�e, Juan Castelli","0","Patricio Cullen, Estanislao Zeballos","0"));
		esquinas.put("Patricio Cullen, Estanislao Zeballos", Arrays.asList("0","Antonia Godoy, Estanislao Zeballos","Patricio Cullen, Obispo Boneo","0"));
		esquinas.put("Antonia Godoy, Pje. Pujato", Arrays.asList("Patricio Cullen, Pje. Pujato","0","0","Antonia Godoy, J.P.L�pez"));
		esquinas.put("Antonia Godoy, Hernandarias", Arrays.asList("0","Piedras, Hernandarias","0","Antonia Godoy, J.P. L�pez"));
		esquinas.put("Antonia Godoy, Juan Castelli", Arrays.asList("Patricio Cullen, Juan Castelli","0","0","Antonia Godoy, Hernandarias"));
		esquinas.put("Antonia Godoy, Estanislao Zeballos", Arrays.asList("0","Piedras, Estanislao Zeballos","0","Antonia Godoy, Juan Castelli"));
		esquinas.put("Piedras, Pje. Pujato", Arrays.asList("0","Tacuar�, Pje. Pujato","Piedras, Hernandarias","0"));
		esquinas.put("Piedras, Hernandarias", Arrays.asList("0","Tacuar�, Hernandarias","Piedras, Juan Castelli","0"));
		esquinas.put("Piedras, Juan Castelli", Arrays.asList("Antonia Godoy, Juan Castelli","0","Piedras, Estanislao Zeballos","0"));
		esquinas.put("Piedras, Estanislao Zeballos", Arrays.asList("0","Tacuar�, Estanislao Zeballos","Piedras, Obispo Boneo","0"));
		esquinas.put("Tacuar�, Pje. Pujato", Arrays.asList("Piedras, Pje. Pujato","0","0","Tacuar�, J.P.L�pez"));
		esquinas.put("Tacuar�, Hernandarias", Arrays.asList("0","Velez Sarfield, Hernandarias","0","Tacuar�, J.P. L�pez"));
		esquinas.put("Tacuar�, Juan Castelli", Arrays.asList("Piedras, Juan Castelli","0","0","Tacuar�, Hernandarias"));
		esquinas.put("Tacuar�, Estanislao Zeballos", Arrays.asList("0","Velez Sarfield, Estanislao Zeballos","0","Tacuar�, Juan Castelli"));
		esquinas.put("Velez Sarfield, Hernandarias", Arrays.asList("0","General Paz, Hernandarias","Velez Sarfield, Juan Castelli","0"));
		esquinas.put("Velez Sarfield, Juan Castelli", Arrays.asList("Tacuar�, Juan Castelli","0","Velez Sarfield, Estanislao Zeballos","0"));
		esquinas.put("Velez Sarfield, Estanislao Zeballos", Arrays.asList("0","General Paz, Estanislao Zeballos","0","0"));
		esquinas.put("General Paz, Hernandarias", Arrays.asList("0","0","General Paz, Juan Castelli","General Paz, J.P. L�pez"));
		esquinas.put("General Paz, Juan Castelli", Arrays.asList("0","0","General Paz, Estanislao Zeballos","General Paz, Hernandarias"));
		esquinas.put("General Paz, Estanislao Zeballos", Arrays.asList("0","0","General Paz, Obispo Boneo","General Paz, Juan Castelli"));
		esquinas.put("Almirante Brown, Obispo Boneo", Arrays.asList("0","0","Almirante Brown, Espora","Almirante Brown, Estanislao Zeballos"));
		esquinas.put("Almirante Brown, Espora", Arrays.asList("0","Riobamba,Espora","Almirante Brown, Obispo Pr�ncipe","Almirante Brown, Obispo Boneo"));
		esquinas.put("Almirante Brown, Obispo Pr�ncipe", Arrays.asList("0","0","Almirante Brown, Alberti","Almirante Brown, Espora"));
		esquinas.put("Almirante Brown, Alberti", Arrays.asList("0","Riobamba, Alberti","Almirante Brown, Cardenal Fasolino","Almirante Brown, Obispo Pr�ncipe"));
		esquinas.put("Almirante Brown, Cardenal Fasolino", Arrays.asList("0","0","Almirante Brown, Padre Genesio","Almirante Brown, Alberti"));
		esquinas.put("Almirante Brown, Padre Genesio", Arrays.asList("0","Riobamba, Padre Genesio","Almirante Brown, Javier de la Rosa","Almirante Brown, Cardenal Fasolino"));
		esquinas.put("Almirante Brown, Javier de la Rosa", Arrays.asList("0","0","Italia, Regimiento 12 de Infanter�a","Almirante Brown, Padre Genesio"));
		esquinas.put("Riobamba, Obispo Boneo", Arrays.asList("Almirante Brown, Obispo Boneo","0","Riobamba, Espora","0"));
		esquinas.put("Riobamba, Espora", Arrays.asList("0","Defensa, Espora","Riobamba, Obispo Pr�ncipe","0"));
		esquinas.put("Riobamba, Obispo Pr�ncipe", Arrays.asList("Almirante Brown, Obispo Pr�ncipe","0","Riobamba, Alberti","0"));
		esquinas.put("Riobamba, Alberti", Arrays.asList("0","Defensa, Alberti","Riobamba, Cardenal Fasolino","0"));
		esquinas.put("Riobamba, Cardenal Fasolino", Arrays.asList("Almirante Brown, Cardenal Fasolino","0","Riobamba, Padre Genesio","0"));
		esquinas.put("Riobamba, Padre Genesio", Arrays.asList("0","Defensa, Padre Genesio","Riobamba, Javier de la Rosa","0"));
		esquinas.put("Riobamba, Javier de la Rosa", Arrays.asList("0","0","Riobamba, Regimiento 12 de Infanter�a","0"));
		esquinas.put("Riobamba, Regimiento 12 de Infanter�a", Arrays.asList("0","Defensa, Regimiento 12 de Infanter�a","0","0"));
		esquinas.put("Defensa, Obispo Boneo", Arrays.asList("Riobamba, Obispo Boneo","0","0","Defensa, Estanislao Zeballos"));
		esquinas.put("Defensa,Espora", Arrays.asList("0","Talcahuano,Espora","0","Defensa, Obispo Boneo"));
		esquinas.put("Defensa, Obispo Pr�ncipe", Arrays.asList("Riobamba,Obispo Pr�ncipe","0","0","Defensa, Espora"));
		esquinas.put("Defensa, Alberti", Arrays.asList("0","Talcahuano, Alberti","0","Defensa, Obispo Pr�ncipe"));
		esquinas.put("Defensa, Cardenal Fasolino", Arrays.asList("Riobamba, Cardenal Fasolino","0","0","Defensa, Alberti"));
		esquinas.put("Defensa, Padre Genesio", Arrays.asList("0","Talcahuano, Padre Genesio","0","Defensa, Cardenal Fasolino"));
		esquinas.put("Defensa, Javier de la Rosa", Arrays.asList("0","0","0","Defensa, Padre Genesio"));
		esquinas.put("Defensa, Regimiento 12 de Infanter�a", Arrays.asList("0","Talcahuano, Regimiento 12 de Infanter�a","0","Defensa, Javier de la Rosa"));
		esquinas.put("Talcahuano, Obispo Boneo", Arrays.asList("Defensa, Obispo Boneo","0","Talcahuano, Espora","0"));
		esquinas.put("Talcahuano, Espora", Arrays.asList("0","Echag�e, Espora","Talcahuano, Obispo Pr�ncipe","0"));
		esquinas.put("Talcahuano, Obispo Pr�ncipe", Arrays.asList("Defensa,Obispo Pr�ncipe","0","Talcahuano, Alberti","0"));
		esquinas.put("Talcahuano, Alberti", Arrays.asList("0","Echag�e, Alberti","Talcahuano, Cardenal Fasolino","0"));
		esquinas.put("Talcahuano, Cardenal Fasolino", Arrays.asList("Defensa, Cardenal Fasolino","0","Talcahuano, Padre Genesio","0"));
		esquinas.put("Talcahuano, Padre Genesio", Arrays.asList("0","Echag�e, Padre Genesio","Talcahuano, Javier de la Rosa","0"));
		esquinas.put("Talcahuano, Javier de la Rosa", Arrays.asList("0","0","Talcahuano, Regimiento 12 de Infanter�a","0"));
		esquinas.put("Talcahuano, Regimiento 12 de Infanter�a", Arrays.asList("0","Echag�e, Regimiento 12 de Infanter�a","0","0"));
		esquinas.put("Echag�e, Obispo Boneo", Arrays.asList("Talcahuano, Obispo Boneo","0","0","Echag�e, Estanislao Zeballos"));
		esquinas.put("Echag�e, Espora", Arrays.asList("0","Patricio Cullen, Espora","0","Echag�e, Obispo Boneo"));
		esquinas.put("Echag�e, Obispo Pr�ncipe", Arrays.asList("Talcahuano, Obispo Pr�ncipe","0","0","Echag�e, Espora"));
		esquinas.put("Echag�e, Alberti", Arrays.asList("0","Patricio Cullen, Alberti","0","Echag�e, Obispo Pr�ncipe"));
		esquinas.put("Echag�e, Cardenal Fasolino", Arrays.asList("Talcahuano, Cardenal Fasolino","0","0","Echag�e, Alberti"));
		esquinas.put("Echag�e, Padre Genesio", Arrays.asList("0","Patricio Cullen, Padre Genesio","0","Echag�e, Cardenal Fasolino"));
		esquinas.put("Echag�e, Javier de la Rosa", Arrays.asList("0","0","0","Echag�e, Padre Genesio"));
		esquinas.put("Echag�e, Regimiento 12 de Infanter�a", Arrays.asList("0","Patricio Cullen, Regimiento 12 de Infanter�a","0","Echag�e, Javier de la Rosa"));
		esquinas.put("Patricio Cullen, Obispo Boneo", Arrays.asList("Echag�e, Obispo Boneo","0","Patricio Cullen, Espora","0"));
		esquinas.put("Patricio Cullen,Espora", Arrays.asList("0","Antonia Godoy,Espora","Patricio Cullen, Obispo Pr�ncipe","0"));
		esquinas.put("Patricio Cullen, Obispo Pr�ncipe", Arrays.asList("Echag�e,Obispo Pr�ncipe","0","0","0"));
		esquinas.put("Patricio Cullen, Alberti", Arrays.asList("Echag�e, Alberti","0","Patricio Cullen, Cardenal Fasolino","0"));
		esquinas.put("Patricio Cullen, Cardenal Fasolino", Arrays.asList("Echag�e, Cardenal Fasolino","0","Patricio Cullen, Pje de Andrea","0"));
		esquinas.put("Patricio Cullen, Pje de Andrea", Arrays.asList("0","Antonia Godoy, Pje de Andrea","Patricio Cullen, Padre Genesio","0"));
		esquinas.put("Patricio Cullen, Padre Genesio", Arrays.asList("0","Antonia Godoy, Padre Genesio","Patricio Cullen, Javier de la Rosa","0"));
		esquinas.put("Patricio Cullen, Javier de la Rosa", Arrays.asList("Echag�e, Javier de la Rosa","0","Patricio Cullen, Regimiento 12 de Infanter�a","0"));
		esquinas.put("Patricio Cullen, Regimiento 12 de Infanter�a", Arrays.asList("0","Antonia Godoy, Regimiento 12 de Infanter�a","0","0"));
		esquinas.put("Juan Maciel, Obispo Pr�ncipe", Arrays.asList("Patricio Cullen, Obispo Pr�ncipe","0","Juan Maciel, Alberti","0"));
		esquinas.put("Juan Maciel, Alberti", Arrays.asList("Patricio Cullen, Alberti","0","0","Juan Maciel, Obispo Pr�ncipe"));
		esquinas.put("Antonia Godoy, Obispo Boneo", Arrays.asList("Patricio Cullen, Obispo Boneo","0","0","Antonia Godoy, Estanislao Zeballos"));
		esquinas.put("Antonia Godoy, Espora", Arrays.asList("0","Piedras, Espora","0","Antonia Godoy, Obispo Boneo"));
		esquinas.put("Antonia Godoy, Obispo Pr�ncipe", Arrays.asList("Juan Maciel, Obispo Pr�ncipe","0","0","Antonia Godoy, Espora"));
		esquinas.put("Antonia Godoy, Alberti", Arrays.asList("Juan Maciel, Alberti","0","0","0"));
		esquinas.put("Antonia Godoy, Cardenal Fasolino", Arrays.asList("Patricio Cullen, Cardenal Fasolino","0","0","Antonia Godoy, Alberti"));
		esquinas.put("Antonia Godoy, Pje de Andrea", Arrays.asList("0","0","0","Antonia Godoy, Cardenal Fasolino"));
		esquinas.put("Antonia Godoy, Padre Genesio", Arrays.asList("0","Piedras, Padre Genesio","0","Antonia Godoy, Pje de Andrea"));
		esquinas.put("Antonia Godoy, Javier de la Rosa", Arrays.asList("0","0","0","0"));
		esquinas.put("Antonia Godoy, Regimiento 12 de Infanter�a", Arrays.asList("0","Piedras, Regimiento 12 de Infanter�a","0","Antonia Godoy, Javier de la Rosa"));
		esquinas.put("Piedras, Obispo Boneo", Arrays.asList("Antonia Godoy, Obispo Boneo","0","Piedras, Espora","0"));
		esquinas.put("Piedras, Espora", Arrays.asList("0","Tacuar�, Espora","Piedras, Obispo Pr�ncipe","0"));
		esquinas.put("Piedras, Obispo Pr�ncipe", Arrays.asList("Antonia Godoy, Obispo Pr�ncipe","0","Piedras, Alberti","0"));
		esquinas.put("Piedras, Alberti", Arrays.asList("0","Tacuar�, Alberti","Piedras, Cardenal Fasolino","0"));
		esquinas.put("Piedras, Cardenal Fasolino", Arrays.asList("Antonia Godoy, Cardenal Fasolino","0","Piedras, Pje de Andrea","0"));
		esquinas.put("Piedras, Pje de Andrea", Arrays.asList("0","Tacuar�, Pje de Andrea","Piedras, Padre Genesio","0"));
		esquinas.put("Piedras, Padre Genesio", Arrays.asList("0","Tacuar�, Padre Genesio","Piedras, Javier de la Rosa","0"));
		esquinas.put("Piedras, Javier de la Rosa", Arrays.asList("0","0","Piedras, Regimiento 12 de Infanter�a","0"));
		esquinas.put("Piedras, Regimiento 12 de Infanter�a", Arrays.asList("0","Tacuar�, Regimiento 12 de Infanter�a","0","0"));
		esquinas.put("Tacuar�, Obispo Boneo", Arrays.asList("Piedras, Obispo Boneo","0","0","Tacuar�, Estanislao Zeballos"));
		esquinas.put("Tacuar�, Espora", Arrays.asList("0","General Paz, Espora","0","Tacuar�, Obispo Boneo"));
		esquinas.put("Tacuar�, Obispo Pr�ncipe", Arrays.asList("Piedras, Obispo Pr�ncipe","0","0","Tacuar�, Espora"));
		esquinas.put("Tacuar�, Alberti", Arrays.asList("0","General Paz, Alberti","0","Tacuar�, Obispo Pr�ncipe"));
		esquinas.put("Tacuar�, Cardenal Fasolino", Arrays.asList("Piedras, Cardenal Fasolino","0","0","Tacuar�, Alberti"));
		esquinas.put("Tacuar�, Pje de Andrea", Arrays.asList("Piedras, Pje de Andrea","0","0","Tacuar�, Cardenal Fasolino"));
		esquinas.put("Tacuar�, Padre Genesio", Arrays.asList("0","General Paz, Padre Genesio","0","Tacuar�, Pje de Andrea"));
		esquinas.put("Tacuar�, Javier de la Rosa", Arrays.asList("0","0","0","Tacuar�, Padre Genesio"));
		esquinas.put("Tacuar�, Regimiento 12 de Infanter�a", Arrays.asList("0","General Paz, Regimiento 12 de Infanter�a","0","Tacuar�, Javier de la Rosa"));
		esquinas.put("General Paz, Obispo Boneo", Arrays.asList("Tacuar�, Obispo Boneo","0","General Paz, Espora","General Paz, Estanislao Zeballos"));
		esquinas.put("General Paz, Espora", Arrays.asList("0","0","General Paz, Obispo Pr�ncipe","General Paz, Obispo Boneo"));
		esquinas.put("General Paz, Obispo Pr�ncipe", Arrays.asList("Tacuar�, Obispo Pr�ncipe","0","General Paz, Alberti","General Paz, Espora"));
		esquinas.put("General Paz, Alberti", Arrays.asList("0","0","General Paz, Cardenal Fasolino","General Paz, Obispo Pr�ncipe"));
		esquinas.put("General Paz, Cardenal Fasolino", Arrays.asList("Tacuar�, Cardenal Fasolino","0","General Paz, Padre Genesio","General Paz, Alberti"));
		esquinas.put("General Paz, Padre Genesio", Arrays.asList("0","0","General Paz, Javier de la Rosa","General Paz, Cardenal Fasolino"));
		esquinas.put("General Paz, Javier de la Rosa", Arrays.asList("Tacuar�, Javier de la Rosa","0","General Paz, Regimiento 12 de Infanter�a","General Paz, Padre Genesio"));
		esquinas.put("General Paz, Regimiento 12 de Infanter�a", Arrays.asList("0","0","0","General Paz, Javier de la Rosa"));
		
	}


	public void sumarMultado() {
		cantidadMultados++;
	}

}
