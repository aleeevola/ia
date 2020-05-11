package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class EstadoAgenteCustodia extends SearchBasedAgentState{
	
	private HashMap<VectorCalles, List<VectorCalles>> esquinas=new HashMap<VectorCalles, List<VectorCalles>>();
    private VectorCalles ubicacionActual;
    private List<VectorCalles> listaInfectados;
    private List<VectorCalles> listaCallesCortadas;
    private Integer cantidadMultados;

    public EstadoAgenteCustodia() {
 
    	cargarMapa();
    	ubicacionActual = new VectorCalles();
    	listaInfectados = new ArrayList<VectorCalles>();
    	listaCallesCortadas = new ArrayList<VectorCalles>();
		cantidadMultados = 0;
    	
        this.initState();
    }


	@Override
	public boolean equals(Object obj) {
		//Define si dos estados son iguales
		//solo lo son cuando estan en la misma ubicacion, la lista de infectados es la misma 
		//y la cantidad de multados 
		EstadoAgenteCustodia estadoComparado= (EstadoAgenteCustodia) obj;
		
		Boolean ubicacion= this.ubicacionActual.equals(estadoComparado.getUbicacionActual());
		Boolean infectados=this.listaInfectados.equals(estadoComparado.getListaInfectados());
		Boolean cantMultados= this.cantidadMultados.equals(estadoComparado.getCantidadMultados());
		
		if (ubicacion && infectados && cantMultados){
			return true;
		}
		else return false;
	}

	@Override
	public SearchBasedAgentState clone() {
		// TODO hecho por ale revisar
		EstadoAgenteCustodia newEstadoAgente= new EstadoAgenteCustodia();
		
		//Estos son los que no cambian
		newEstadoAgente.setEsquinas(this.getEsquinas());
		newEstadoAgente.setListaCallesCortadas(this.getListaCallesCortadas());
		
		
		//estos son los que hay que clonar si o si
		ArrayList<VectorCalles> newListaInfectados= new ArrayList<VectorCalles>();
		for(VectorCalles infectado : this.getListaInfectados()) {
			newListaInfectados.add(infectado.clone());
		}
		newEstadoAgente.setListaInfectados(newListaInfectados);
		
		Integer newCantidadMultados = this.getCantidadMultados();
		newEstadoAgente.setCantidadMultados(newCantidadMultados);
		
		
		//este no se si es necesario clonar
		VectorCalles newUbicacionActual = this.getUbicacionActual().clone();
		newEstadoAgente.setUbicacionActual(newUbicacionActual);
		
		return newEstadoAgente;
	}

	@Override
	public void updateState(Perception p) {
		// TODO Auto-generated method stub
		PerceptionAgenteCustodia percepcion=(PerceptionAgenteCustodia) p;
		
		ArrayList<VectorCalles> newInfectados=percepcion.getInfectados();
		ArrayList<VectorCalles> newCallesCortadas=percepcion.getCallesCortadas();
		
		/*Si hay nuevos infectados los agrega a la lista, si es que 
		 * ya no estan
		 * */
		if(!newInfectados.isEmpty()) {
			for(VectorCalles infectado : newInfectados) {
				if(!this.getListaInfectados().contains(infectado)) {
					/*
					 * Añado nuevo infectado
					 * segun entiendo el contains usa el metodo equals
					 * (puede fallar eso xd) pero creo que lo hice bien*/
					this.getListaInfectados().add(infectado);
				}
			}
		}
		
		
		/*Si hay nuevas calles cortadas las agrega a la lista, si es que 
		 * ya no estan
		 * */
		if(!newCallesCortadas.isEmpty()) {
			for(VectorCalles newCalle : newCallesCortadas) {
				if(!this.getListaCallesCortadas().contains(newCalle)) {
					/*
					 * Añado la nueva calle cortada
					 * segun entiendo el contains usa el metodo equals
					 * (puede fallar eso xd) pero creo que lo hice bien*/
					this.getListaCallesCortadas().add(newCalle);
				}
			}
		}
	}

	

	@Override
	public String toString() {
		return "EstadoAgenteCustodia:\n	UbicacionActual=" + ubicacionActual + "\n	ListaInfectados=" + listaInfectados
				+ "\n	ListaCallesCortadas=" + listaCallesCortadas + "\n	CantidadMultados=" + cantidadMultados;
	}


	@Override
	public void initState() {
		// TODO Auto-generated method stub
		VectorCalles v1 = new VectorCalles("Almirante Brown","Pedro de Vega");
		listaCallesCortadas.add(new VectorCalles("Echagüe","Pedro de Vega")); //TODO si pongo aca las calles cortadas funciona, si las pongo en EstadoAmbiente.java no funciona
		ubicacionActual = v1; 
		cantidadMultados = 0;
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
	
	private void cargarMapa() {
		esquinas.put(new VectorCalles("Almirante Brown","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Echagüe","Pedro de Vega"), new VectorCalles("Almirante Brown","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Almirante Brown","Ricardo Aldao"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Angel Cassanello"), new VectorCalles("Almirante Brown","Pedro de Vega")));
		esquinas.put(new VectorCalles("Almirante Brown","Angel Cassanello"), Arrays.asList(null, new VectorCalles("Talcahuano","Angel Cassanello"), new VectorCalles("Almirante Brown","J.P.López"), new VectorCalles("Almirante Brown","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Almirante Brown","J.P.López"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Hernandarias"), new VectorCalles("Almirante Brown","Angel Cassanello")));
		esquinas.put(new VectorCalles("Defensa","J.P.López"), Arrays.asList(new VectorCalles("Almirante Brown","J.P.López"), null, null, null));
		esquinas.put(new VectorCalles("Talcahuano","Angel Cassanello"), Arrays.asList(new VectorCalles("Almirante Brown","Angel Cassanello"), new VectorCalles("Echagüe","Angel Cassanello"), new VectorCalles("Talcahuano","J.P.López"), null));
		esquinas.put(new VectorCalles("Talcahuano","J.P.López"), Arrays.asList(new VectorCalles("Defensa","J.P.López"), null, new VectorCalles("Talcahuano","Hernandarias"), null));
		esquinas.put(new VectorCalles("Echagüe","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Echagüe","Ricardo Aldao"), Arrays.asList(new VectorCalles("Almirante Brown","Ricardo Aldao"), null, null, new VectorCalles("Echagüe","Pedro de Vega")));
		esquinas.put(new VectorCalles("Echagüe","Angel Cassanello"), Arrays.asList(new VectorCalles("Talcahuano","Angel Cassanello"), new VectorCalles("Patricio Cullen","Angel Cassanello"), null, new VectorCalles("Echagüe","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Patricio Cullen","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Pedro de Vega"), new VectorCalles("Patricio Cullen","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Ricardo Aldao"), Arrays.asList(new VectorCalles("Echagüe","Ricardo Aldao"), null, new VectorCalles("Patricio Cullen","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Angel Cassanello"), Arrays.asList(new VectorCalles("Echagüe","Angel Cassanello"), new VectorCalles("Antonia Godoy","Angel Cassanello"), new VectorCalles("Patricio Cullen","J.P.López"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","J.P.López"), Arrays.asList(new VectorCalles("Echagüe","J.P.López"), null, new VectorCalles("Patricio Cullen","Pje Pujato"), null));
		esquinas.put(new VectorCalles("Antonia Godoy","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Piedras","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Ricardo Aldao"), Arrays.asList(new VectorCalles("Patricio Cullen","Ricardo Aldao"), null, null, new VectorCalles("Antonia Godoy","Pedro de Vega")));
		esquinas.put(new VectorCalles("Antonia Godoy","Angel Cassanello"), Arrays.asList(new VectorCalles("Patricio Cullen","Angel Cassanello"), new VectorCalles("Piedras","Angel Cassanello"), null, new VectorCalles("Antonia Godoy","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Antonia Godoy","J.P.López"), Arrays.asList(new VectorCalles("Patricio Cullen","J.P.López"), null, null, new VectorCalles("Antonia Godoy","Angel Cassanello")));
		esquinas.put(new VectorCalles("Piedras","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Tacuarí","Pedro de Vega"), new VectorCalles("Piedras","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Piedras","Ricardo Aldao"), Arrays.asList(new VectorCalles("Antonia Godoy","Ricardo Aldao"), null, new VectorCalles("Piedras","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("Piedras","Angel Cassanello"), Arrays.asList(new VectorCalles("Antonia Godoy","Angel Cassanello"), new VectorCalles("Tacuarí","Angel Cassanello"), new VectorCalles("Piedras","J.P.López"), null));
		esquinas.put(new VectorCalles("Piedras","J.P.López"), Arrays.asList(new VectorCalles("Antonia Godoy","J.P.López"), null, new VectorCalles("Piedras","Pje Pujato"), null));
		esquinas.put(new VectorCalles("Tacuarí","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Vélez Sarsfield","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Tacuarí","Ricardo Aldao"), Arrays.asList(new VectorCalles("Piedras","Ricardo Aldao"), null, null, new VectorCalles("Tacuarí","Pedro de Vega")));
		esquinas.put(new VectorCalles("Tacuarí","Angel Cassanello"), Arrays.asList(new VectorCalles("Piedras","Angel Cassanello"), new VectorCalles("Vélez Sarsfield","Angel Cassanello"), null, new VectorCalles("Tacuarí","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Tacuarí","J.P.López"), Arrays.asList(new VectorCalles("Piedras","J.P.López"), null, null, new VectorCalles("Tacuarí","Angel Cassanello")));
		esquinas.put(new VectorCalles("Vélez Sarsfield","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("Vélez Sarsfield","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Vélez Sarsfield","Ricardo Aldao"), Arrays.asList(new VectorCalles("Tacuarí","Ricardo Aldao"), null, new VectorCalles("Vélez Sarsfield","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("Vélez Sarsfield","Angel Cassanello"), Arrays.asList(new VectorCalles("Tacuarí","Angel Cassanello"), new VectorCalles("Dorrego","Angel Cassanello"), new VectorCalles("Vélez Sarsfield","J.P.López"), null));
		esquinas.put(new VectorCalles("Vélez Sarsfield","J.P.López"), Arrays.asList(new VectorCalles("Tacuarí","J.P.López"), null, new VectorCalles("Vélez Sarsfield","Hernandarias"), null));
		esquinas.put(new VectorCalles("Dorrego","Pedro de Vega"), Arrays.asList(null, new VectorCalles("General Paz","Pedro de Vega"), new VectorCalles("Dorrego","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Dorrego","Ricardo Aldao"), Arrays.asList(null, null, new VectorCalles("Dorrego","Angel Cassanello"), new VectorCalles("Dorrego","Pedro de Vega")));
		esquinas.put(new VectorCalles("Dorrego","Angel Cassanello"), Arrays.asList(new VectorCalles("Vélez Sarsfield","Angel Cassanello"), new VectorCalles("General Paz","Angel Cassanello"), null, new VectorCalles("Dorrego","Ricardo Aldao")));
		esquinas.put(new VectorCalles("General Paz","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("General Paz","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("General Paz","Ricardo Aldao"), Arrays.asList(new VectorCalles("Dorrego","Ricardo Aldao"), null, new VectorCalles("General Paz","Angel Cassanello"), new VectorCalles("General Paz","Pedro de Vega")));
		esquinas.put(new VectorCalles("General Paz","Angel Cassanello"), Arrays.asList(new VectorCalles("Dorrego","Angel Cassanello"), null, new VectorCalles("General Paz","J.P.López"), new VectorCalles("General Paz","Ricardo Aldao")));
		esquinas.put(new VectorCalles("General Paz","J.P.López"), Arrays.asList(null, null, new VectorCalles("General Paz","Hernandarias"), new VectorCalles("General Paz","Angel Cassanello")));
		esquinas.put(new VectorCalles("Almirante Brown","Hernandarias"), Arrays.asList(null, new VectorCalles("Defensa","Hernandarias"), new VectorCalles("Almirante Brown","Riobamba"), new VectorCalles("Almirante Brown","J.P.López")));
		esquinas.put(new VectorCalles("Almirante Brown","Riobamba"), Arrays.asList(null, new VectorCalles("Riobamba","Juan Castelli"), new VectorCalles("Almirante Brown","Juan Castelli"), new VectorCalles("Almirante Brown","Hernandarias")));
		esquinas.put(new VectorCalles("Almirante Brown","Juan Castelli"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Estanislao Zeballos"), new VectorCalles("Almirante Brown","Riobamba")));
		esquinas.put(new VectorCalles("Almirante Brown","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Riobamba","Estanislao Zeballos"), new VectorCalles("Almirante Brown","Obispo Boneo"), new VectorCalles("Almirante Brown","Juan Castelli")));
		esquinas.put(new VectorCalles("Riobamba","Juan Castelli"), Arrays.asList(new VectorCalles("Almirante Brown","Juan Castelli"), null, new VectorCalles("Río Bamba","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Riobamba","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Defensa","Estanislao Zeballos"), new VectorCalles("Riobamba","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Defensa","Hernandarias"), Arrays.asList(null, new VectorCalles("Talcahuano","Hernandarias"), null, new VectorCalles("Defensa","J.P.López")));
		esquinas.put(new VectorCalles("Defensa","Juan Castelli"), Arrays.asList(new VectorCalles("Riobamba","Juan Castelli"), null, null, new VectorCalles("Defensa","Hernandarias")));
		esquinas.put(new VectorCalles("Defensa","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Talcahuano","Estanislao Zeballos"), null, new VectorCalles("Defensa","Juan Castelli")));
		esquinas.put(new VectorCalles("Talcahuano","Hernandarias"), Arrays.asList(null, new VectorCalles("Echagüe","Hernandarias"), new VectorCalles("Talcahuano","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Talcahuano","Juan Castelli"), Arrays.asList(new VectorCalles("Defensa","Juan Castelli"), null, new VectorCalles("Talcahuano","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Talcahuano","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Echagüe","Estanislao Zeballos"), new VectorCalles("Talcahuano","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Echagüe","Pje. Pujato"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Pje. Pujato"), null, new VectorCalles("Echagüe","J.P.López")));
		esquinas.put(new VectorCalles("Echagüe","Hernandarias"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Hernandarias"), null, new VectorCalles("Echagüe","Pje. Pujato")));
		esquinas.put(new VectorCalles("Echagüe","Juan Castelli"), Arrays.asList(new VectorCalles("Talcahuano","Juan Castelli"), null, null, new VectorCalles("Echagüe","Hernandarias")));
		esquinas.put(new VectorCalles("Echagüe","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Estanislao Zeballos"), null, new VectorCalles("Echagüe","Juan Castelli")));
		esquinas.put(new VectorCalles("Patricio Cullen","Pje. Pujato"), Arrays.asList(new VectorCalles("Echagüe","Pje. Pujato"), new VectorCalles("Antonia Godoy","Pje. Pujato"), new VectorCalles("Patricio Cullen","Hernandarias"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Hernandarias"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Hernandarias"), new VectorCalles("Patricio Cullen","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Juan Castelli"), Arrays.asList(new VectorCalles("Echagüe","Juan Castelli"), null, new VectorCalles("Patricio Cullen","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Estanislao Zeballos"), new VectorCalles("Patricio Cullen","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Antonia Godoy","Pje. Pujato"), Arrays.asList(new VectorCalles("Patricio Cullen","Pje. Pujato"), null, null, new VectorCalles("Antonia Godoy","J.P.López")));
		esquinas.put(new VectorCalles("Antonia Godoy","Hernandarias"), Arrays.asList(null, new VectorCalles("Piedras","Hernandarias"), null, new VectorCalles("Antonia Godoy","Pje. Pujato")));
		esquinas.put(new VectorCalles("Antonia Godoy","Juan Castelli"), Arrays.asList(new VectorCalles("Patricio Cullen","Juan Castelli"), null, null, new VectorCalles("Antonia Godoy","Hernandarias")));
		esquinas.put(new VectorCalles("Antonia Godoy","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Piedras","Estanislao Zeballos"), null, new VectorCalles("Antonia Godoy","Juan Castelli")));
		esquinas.put(new VectorCalles("Piedras","Pje. Pujato"), Arrays.asList(null, new VectorCalles("Tacuarí","Pje. Pujato"), new VectorCalles("Piedras","Hernandarias"), null));
		esquinas.put(new VectorCalles("Piedras","Hernandarias"), Arrays.asList(null, new VectorCalles("Tacuarí","Hernandarias"), new VectorCalles("Piedras","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Piedras","Juan Castelli"), Arrays.asList(new VectorCalles("Antonia Godoy","Juan Castelli"), null, new VectorCalles("Piedras","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Piedras","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Tacuarí","Estanislao Zeballos"), new VectorCalles("Piedras","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Tacuarí","Pje. Pujato"), Arrays.asList(new VectorCalles("Piedras","Pje. Pujato"), null, null, new VectorCalles("Tacuarí","J.P.López")));
		esquinas.put(new VectorCalles("Tacuarí","Hernandarias"), Arrays.asList(null, new VectorCalles("Velez Sarfield","Hernandarias"), null, new VectorCalles("Tacuarí","Pje. Pujato")));
		esquinas.put(new VectorCalles("Tacuarí","Juan Castelli"), Arrays.asList(new VectorCalles("Piedras","Juan Castelli"), null, null, new VectorCalles("Tacuarí","Hernandarias")));
		esquinas.put(new VectorCalles("Tacuarí","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Velez Sarfield","Estanislao Zeballos"), null, new VectorCalles("Tacuarí","Juan Castelli")));
		esquinas.put(new VectorCalles("Velez Sarfield","Hernandarias"), Arrays.asList(null, new VectorCalles("General Paz","Hernandarias"), new VectorCalles("Velez Sarfield","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Velez Sarfield","Juan Castelli"), Arrays.asList(new VectorCalles("Tacuarí","Juan Castelli"), null, new VectorCalles("Velez Sarfield","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Velez Sarfield","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("General Paz","Estanislao Zeballos"), null, null));
		esquinas.put(new VectorCalles("General Paz","Hernandarias"), Arrays.asList(null, null, new VectorCalles("General Paz","Juan Castelli"), new VectorCalles("General Paz","J.P. López")));
		esquinas.put(new VectorCalles("General Paz","Juan Castelli"), Arrays.asList(new VectorCalles("Velez Sarfield","Juan Castelli"), null, new VectorCalles("General Paz","Estanislao Zeballos"), new VectorCalles("General Paz","Hernandarias")));
		esquinas.put(new VectorCalles("General Paz","Estanislao Zeballos"), Arrays.asList(null, null, new VectorCalles("General Paz","Obispo Boneo"), new VectorCalles("General Paz","Juan Castelli")));
		esquinas.put(new VectorCalles("Almirante Brown","Obispo Boneo"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Espora"), new VectorCalles("Almirante Brown","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Almirante Brown","Espora"), Arrays.asList(null, new VectorCalles("Riobamba","Espora"), new VectorCalles("Almirante Brown","Obispo Príncipe"), new VectorCalles("Almirante Brown","Obispo Boneo")));
		esquinas.put(new VectorCalles("Almirante Brown","Obispo Príncipe"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Alberti"), new VectorCalles("Almirante Brown","Espora")));
		esquinas.put(new VectorCalles("Almirante Brown","Alberti"), Arrays.asList(null, new VectorCalles("Riobamba","Alberti"), new VectorCalles("Almirante Brown","Cardenal Fasolino"), new VectorCalles("Almirante Brown","Obispo Príncipe")));
		esquinas.put(new VectorCalles("Almirante Brown","Cardenal Fasolino"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Padre Genesio"), new VectorCalles("Almirante Brown","Alberti")));
		esquinas.put(new VectorCalles("Almirante Brown","Padre Genesio"), Arrays.asList(null, new VectorCalles("Riobamba","Padre Genesio"), new VectorCalles("Almirante Brown","Javier de la Rosa"), new VectorCalles("Almirante Brown","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Almirante Brown","Javier de la Rosa"), Arrays.asList(null, null, new VectorCalles("Italia","Regimiento 12 de Infantería"), new VectorCalles("Almirante Brown","Padre Genesio")));
		esquinas.put(new VectorCalles("Italia","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Riobamba","Regimiento 12 de Infantería"), null, new VectorCalles("Almirante Brown","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Riobamba","Obispo Boneo"), Arrays.asList(new VectorCalles("Almirante Brown","Obispo Boneo"), null, new VectorCalles("Riobamba","Espora"), null));
		esquinas.put(new VectorCalles("Riobamba","Espora"), Arrays.asList(null, new VectorCalles("Defensa","Espora"), new VectorCalles("Riobamba","Obispo Príncipe"), null));
		esquinas.put(new VectorCalles("Riobamba","Obispo Príncipe"), Arrays.asList(new VectorCalles("Almirante Brown","Obispo Príncipe"), null, new VectorCalles("Riobamba","Alberti"), null));
		esquinas.put(new VectorCalles("Riobamba","Alberti"), Arrays.asList(null, new VectorCalles("Defensa","Alberti"), new VectorCalles("Riobamba","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Riobamba","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Almirante Brown","Cardenal Fasolino"), null, new VectorCalles("Riobamba","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Riobamba","Padre Genesio"), Arrays.asList(null, new VectorCalles("Defensa","Padre Genesio"), new VectorCalles("Riobamba","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Riobamba","Javier de la Rosa"), Arrays.asList(new VectorCalles("Almirante Brown","Javier de la Rosa"), null, new VectorCalles("Riobamba","Regimiento 12 de Infantería"), null));
		esquinas.put(new VectorCalles("Riobamba","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Defensa","Regimiento 12 de Infantería"), null, null));
		esquinas.put(new VectorCalles("Defensa","Obispo Boneo"), Arrays.asList(new VectorCalles("Riobamba","Obispo Boneo"), null, null, new VectorCalles("Defensa","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Defensa","Espora"), Arrays.asList(null, new VectorCalles("Talcahuano","Espora"), null, new VectorCalles("Defensa","Obispo Boneo")));
		esquinas.put(new VectorCalles("Defensa","Obispo Príncipe"), Arrays.asList(new VectorCalles("Riobamba","Obispo Príncipe"), null, null, new VectorCalles("Defensa","Espora")));
		esquinas.put(new VectorCalles("Defensa","Alberti"), Arrays.asList(null, new VectorCalles("Talcahuano","Alberti"), null, new VectorCalles("Defensa","Obispo Príncipe")));
		esquinas.put(new VectorCalles("Defensa","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Riobamba","Cardenal Fasolino"), null, null, new VectorCalles("Defensa","Alberti")));
		esquinas.put(new VectorCalles("Defensa","Padre Genesio"), Arrays.asList(null, new VectorCalles("Talcahuano","Padre Genesio"), null, new VectorCalles("Defensa","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Defensa","Javier de la Rosa"), Arrays.asList(new VectorCalles("Riobamba","Javier de la Rosa"), null, null, new VectorCalles("Defensa","Padre Genesio")));
		esquinas.put(new VectorCalles("Defensa","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Talcahuano","Regimiento 12 de Infantería"), null, new VectorCalles("Defensa","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Talcahuano","Obispo Boneo"), Arrays.asList(new VectorCalles("Defensa","Obispo Boneo"), null, new VectorCalles("Talcahuano","Espora"), null));
		esquinas.put(new VectorCalles("Talcahuano","Espora"), Arrays.asList(null, new VectorCalles("Echagüe","Espora"), new VectorCalles("Talcahuano","Obispo Príncipe"), null));
		esquinas.put(new VectorCalles("Talcahuano","Obispo Príncipe"), Arrays.asList(new VectorCalles("Defensa","Obispo Príncipe"), null, new VectorCalles("Talcahuano","Alberti"), null));
		esquinas.put(new VectorCalles("Talcahuano","Alberti"), Arrays.asList(null, new VectorCalles("Echagüe","Alberti"), new VectorCalles("Talcahuano","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Talcahuano","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Defensa","Cardenal Fasolino"), null, new VectorCalles("Talcahuano","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Talcahuano","Padre Genesio"), Arrays.asList(null, new VectorCalles("Echagüe","Padre Genesio"), new VectorCalles("Talcahuano","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Talcahuano","Javier de la Rosa"), Arrays.asList(new VectorCalles("Defensa","Javier de la Rosa"), null, new VectorCalles("Talcahuano","Regimiento 12 de Infantería"), null));
		esquinas.put(new VectorCalles("Talcahuano","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Echagüe","Regimiento 12 de Infantería"), null, null));
		esquinas.put(new VectorCalles("Echagüe","Obispo Boneo"), Arrays.asList(new VectorCalles("Talcahuano","Obispo Boneo"), null, null, new VectorCalles("Echagüe","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Echagüe","Espora"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Espora"), null, new VectorCalles("Echagüe","Obispo Boneo")));
		esquinas.put(new VectorCalles("Echagüe","Obispo Príncipe"), Arrays.asList(new VectorCalles("Talcahuano","Obispo Príncipe"), null, null, new VectorCalles("Echagüe","Espora")));
		esquinas.put(new VectorCalles("Echagüe","Alberti"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Alberti"), null, new VectorCalles("Echagüe","Obispo Príncipe")));
		esquinas.put(new VectorCalles("Echagüe","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Talcahuano","Cardenal Fasolino"), null, null, new VectorCalles("Echagüe","Alberti")));
		esquinas.put(new VectorCalles("Echagüe","Padre Genesio"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Padre Genesio"), null, new VectorCalles("Echagüe","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Echagüe","Javier de la Rosa"), Arrays.asList(new VectorCalles("Talcahuano","Javier de la Rosa"), null, null, new VectorCalles("Echagüe","Padre Genesio")));
		esquinas.put(new VectorCalles("Echagüe","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Regimiento 12 de Infantería"), null, new VectorCalles("Echagüe","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Patricio Cullen","Obispo Boneo"), Arrays.asList(new VectorCalles("Echagüe","Obispo Boneo"), null, new VectorCalles("Patricio Cullen","Espora"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Espora"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Espora"), new VectorCalles("Patricio Cullen","Obispo Príncipe"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Obispo Príncipe"), Arrays.asList(new VectorCalles("Echagüe","Obispo Príncipe"), null, null, null));
		esquinas.put(new VectorCalles("Patricio Cullen","Alberti"), Arrays.asList(null, null, new VectorCalles("Patricio Cullen","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Echagüe","Cardenal Fasolino"), null, new VectorCalles("Patricio Cullen","Pje de Andrea"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Pje de Andrea"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Pje de Andrea"), new VectorCalles("Patricio Cullen","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Padre Genesio"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Padre Genesio"), new VectorCalles("Patricio Cullen","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Javier de la Rosa"), Arrays.asList(new VectorCalles("Echagüe","Javier de la Rosa"), null, new VectorCalles("Patricio Cullen","Regimiento 12 de Infantería"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Regimiento 12 de Infantería"), null, null));
		esquinas.put(new VectorCalles("Juan Maciel","Obispo Príncipe"), Arrays.asList(new VectorCalles("Patricio Cullen","Obispo Príncipe"), null, new VectorCalles("Juan Maciel","Alberti"), null));
		esquinas.put(new VectorCalles("Juan Maciel","Alberti"), Arrays.asList(new VectorCalles("Patricio Cullen","Alberti"), null, null, new VectorCalles("Juan Maciel","Obispo Príncipe")));
		esquinas.put(new VectorCalles("Antonia Godoy","Obispo Boneo"), Arrays.asList(new VectorCalles("Patricio Cullen","Obispo Boneo"), null, null, new VectorCalles("Antonia Godoy","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Antonia Godoy","Espora"), Arrays.asList(null, new VectorCalles("Piedras","Espora"), null, new VectorCalles("Antonia Godoy","Obispo Boneo")));
		esquinas.put(new VectorCalles("Antonia Godoy","Obispo Príncipe"), Arrays.asList(new VectorCalles("Juan Maciel","Obispo Príncipe"), null, null, new VectorCalles("Antonia Godoy","Espora")));
		esquinas.put(new VectorCalles("Antonia Godoy","Alberti"), Arrays.asList(new VectorCalles("Juan Maciel","Alberti"), null, null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Patricio Cullen","Cardenal Fasolino"), null, null, new VectorCalles("Antonia Godoy","Alberti")));
		esquinas.put(new VectorCalles("Antonia Godoy","Pje de Andrea"), Arrays.asList(null, null, null, new VectorCalles("Antonia Godoy","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Antonia Godoy","Padre Genesio"), Arrays.asList(null, new VectorCalles("Piedras","Padre Genesio"), null, new VectorCalles("Antonia Godoy","Pje de Andrea")));
		esquinas.put(new VectorCalles("Antonia Godoy","Javier de la Rosa"), Arrays.asList(new VectorCalles("Patricio Cullen","Javier de la Rosa"), null, null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Piedras","Regimiento 12 de Infantería"), null, new VectorCalles("Antonia Godoy","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Piedras","Obispo Boneo"), Arrays.asList(new VectorCalles("Antonia Godoy","Obispo Boneo"), null, new VectorCalles("Piedras","Espora"), null));
		esquinas.put(new VectorCalles("Piedras","Espora"), Arrays.asList(null, new VectorCalles("Tacuarí","Espora"), new VectorCalles("Piedras","Obispo Príncipe"), null));
		esquinas.put(new VectorCalles("Piedras","Obispo Príncipe"), Arrays.asList(new VectorCalles("Antonia Godoy","Obispo Príncipe"), null, new VectorCalles("Piedras","Alberti"), null));
		esquinas.put(new VectorCalles("Piedras","Alberti"), Arrays.asList(null, new VectorCalles("Tacuarí","Alberti"), new VectorCalles("Piedras","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Piedras","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Antonia Godoy","Cardenal Fasolino"), null, new VectorCalles("Piedras","Pje de Andrea"), null));
		esquinas.put(new VectorCalles("Piedras","Pje de Andrea"), Arrays.asList(null, new VectorCalles("Tacuarí","Pje de Andrea"), new VectorCalles("Piedras","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Piedras","Padre Genesio"), Arrays.asList(null, new VectorCalles("Tacuarí","Padre Genesio"), new VectorCalles("Piedras","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Piedras","Javier de la Rosa"), Arrays.asList(new VectorCalles("Antonia Godoy","Javier de la Rosa"), null, new VectorCalles("Piedras","Regimiento 12 de Infantería"), null));
		esquinas.put(new VectorCalles("Piedras","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("Tacuarí","Regimiento 12 de Infantería"), null, null));
		esquinas.put(new VectorCalles("Tacuarí","Obispo Boneo"), Arrays.asList(new VectorCalles("Piedras","Obispo Boneo"), null, null, new VectorCalles("Tacuarí","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Tacuarí","Espora"), Arrays.asList(null, new VectorCalles("General Paz","Espora"), null, new VectorCalles("Tacuarí","Obispo Boneo")));
		esquinas.put(new VectorCalles("Tacuarí","Obispo Príncipe"), Arrays.asList(new VectorCalles("Piedras","Obispo Príncipe"), null, null, new VectorCalles("Tacuarí","Espora")));
		esquinas.put(new VectorCalles("Tacuarí","Alberti"), Arrays.asList(null, new VectorCalles("General Paz","Alberti"), null, new VectorCalles("Tacuarí","Obispo Príncipe")));
		esquinas.put(new VectorCalles("Tacuarí","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Piedras","Cardenal Fasolino"), null, null, new VectorCalles("Tacuarí","Alberti")));
		esquinas.put(new VectorCalles("Tacuarí","Pje de Andrea"), Arrays.asList(new VectorCalles("Piedras","Pje de Andrea"), null, null, new VectorCalles("Tacuarí","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Tacuarí","Padre Genesio"), Arrays.asList(null, new VectorCalles("General Paz","Padre Genesio"), null, new VectorCalles("Tacuarí","Pje de Andrea")));
		esquinas.put(new VectorCalles("Tacuarí","Javier de la Rosa"), Arrays.asList(new VectorCalles("Piedras","Javier de la Rosa"), null, null, new VectorCalles("Tacuarí","Padre Genesio")));
		esquinas.put(new VectorCalles("Tacuarí","Regimiento 12 de Infantería"), Arrays.asList(null, new VectorCalles("General Paz","Regimiento 12 de Infantería"), null, new VectorCalles("Tacuarí","Javier de la Rosa")));
		esquinas.put(new VectorCalles("General Paz","Obispo Boneo"), Arrays.asList(new VectorCalles("Tacuarí","Obispo Boneo"), null, new VectorCalles("General Paz","Espora"), new VectorCalles("General Paz","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("General Paz","Espora"), Arrays.asList(null, null, new VectorCalles("General Paz","Obispo Príncipe"), new VectorCalles("General Paz","Obispo Boneo")));
		esquinas.put(new VectorCalles("General Paz","Obispo Príncipe"), Arrays.asList(new VectorCalles("Tacuarí","Obispo Príncipe"), null, new VectorCalles("General Paz","Alberti"), new VectorCalles("General Paz","Espora")));
		esquinas.put(new VectorCalles("General Paz","Alberti"), Arrays.asList(null, null, new VectorCalles("General Paz","Cardenal Fasolino"), new VectorCalles("General Paz","Obispo Príncipe")));
		esquinas.put(new VectorCalles("General Paz","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Tacuarí","Cardenal Fasolino"), null, new VectorCalles("General Paz","Padre Genesio"), new VectorCalles("General Paz","Alberti")));
		esquinas.put(new VectorCalles("General Paz","Padre Genesio"), Arrays.asList(null, null, new VectorCalles("General Paz","Javier de la Rosa"), new VectorCalles("General Paz","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("General Paz","Javier de la Rosa"), Arrays.asList(new VectorCalles("Tacuarí","Javier de la Rosa"), null, new VectorCalles("General Paz","Regimiento 12 de Infantería"), new VectorCalles("General Paz","Padre Genesio")));
		esquinas.put(new VectorCalles("General Paz","Regimiento 12 de Infantería"), Arrays.asList(null, null, null, new VectorCalles("General Paz","Javier de la Rosa")));
		}
	
	private void cargarMapaReducido() {
		esquinas.put(new VectorCalles("Almirante Brown","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Echagüe","Pedro de Vega"), new VectorCalles("Almirante Brown","Ricardo Aldao"),  null));
		esquinas.put(new VectorCalles("Almirante Brown","Ricardo Aldao"), Arrays.asList(null, null, null, new VectorCalles("Almirante Brown","Pedro de Vega")));
		esquinas.put(new VectorCalles("Echagüe","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("Echagüe","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Echagüe","Ricardo Aldao"), Arrays.asList(new VectorCalles("Almirante Brown","Ricardo Aldao"), null, null, null));
	}

	public void sumarMultado() {
		cantidadMultados++;
	}
	
	public void setEsquinas(HashMap<VectorCalles, List<VectorCalles>> esquinas) {
		this.esquinas = esquinas;
	}


	public void setListaInfectados(List<VectorCalles> listaInfectados) {
		this.listaInfectados = listaInfectados;
	}


	public void setCantidadMultados(Integer cantidadMultados) {
		this.cantidadMultados = cantidadMultados;
	}


	public HashMap<VectorCalles, List<VectorCalles>> getEsquinas() {
		return esquinas;
	}

	public void setUbicacionActual(VectorCalles ubicacionActual) {
		this.ubicacionActual=ubicacionActual;
	}


	public List<VectorCalles> getListaCallesCortadas() {
		return listaCallesCortadas;
	}


	public void setListaCallesCortadas(List<VectorCalles> listaCallesCortadas) {
		this.listaCallesCortadas = listaCallesCortadas;
	}


}
