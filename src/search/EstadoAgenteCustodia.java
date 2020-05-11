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
					 * A�ado nuevo infectado
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
					 * A�ado la nueva calle cortada
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
		listaCallesCortadas.add(new VectorCalles("Echag�e","Pedro de Vega")); //TODO si pongo aca las calles cortadas funciona, si las pongo en EstadoAmbiente.java no funciona
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
		esquinas.put(new VectorCalles("Almirante Brown","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Echag�e","Pedro de Vega"), new VectorCalles("Almirante Brown","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Almirante Brown","Ricardo Aldao"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Angel Cassanello"), new VectorCalles("Almirante Brown","Pedro de Vega")));
		esquinas.put(new VectorCalles("Almirante Brown","Angel Cassanello"), Arrays.asList(null, new VectorCalles("Talcahuano","Angel Cassanello"), new VectorCalles("Almirante Brown","J.P.L�pez"), new VectorCalles("Almirante Brown","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Almirante Brown","J.P.L�pez"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Hernandarias"), new VectorCalles("Almirante Brown","Angel Cassanello")));
		esquinas.put(new VectorCalles("Defensa","J.P.L�pez"), Arrays.asList(new VectorCalles("Almirante Brown","J.P.L�pez"), null, null, null));
		esquinas.put(new VectorCalles("Talcahuano","Angel Cassanello"), Arrays.asList(new VectorCalles("Almirante Brown","Angel Cassanello"), new VectorCalles("Echag�e","Angel Cassanello"), new VectorCalles("Talcahuano","J.P.L�pez"), null));
		esquinas.put(new VectorCalles("Talcahuano","J.P.L�pez"), Arrays.asList(new VectorCalles("Defensa","J.P.L�pez"), null, new VectorCalles("Talcahuano","Hernandarias"), null));
		esquinas.put(new VectorCalles("Echag�e","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Echag�e","Ricardo Aldao"), Arrays.asList(new VectorCalles("Almirante Brown","Ricardo Aldao"), null, null, new VectorCalles("Echag�e","Pedro de Vega")));
		esquinas.put(new VectorCalles("Echag�e","Angel Cassanello"), Arrays.asList(new VectorCalles("Talcahuano","Angel Cassanello"), new VectorCalles("Patricio Cullen","Angel Cassanello"), null, new VectorCalles("Echag�e","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Patricio Cullen","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Pedro de Vega"), new VectorCalles("Patricio Cullen","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Ricardo Aldao"), Arrays.asList(new VectorCalles("Echag�e","Ricardo Aldao"), null, new VectorCalles("Patricio Cullen","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Angel Cassanello"), Arrays.asList(new VectorCalles("Echag�e","Angel Cassanello"), new VectorCalles("Antonia Godoy","Angel Cassanello"), new VectorCalles("Patricio Cullen","J.P.L�pez"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","J.P.L�pez"), Arrays.asList(new VectorCalles("Echag�e","J.P.L�pez"), null, new VectorCalles("Patricio Cullen","Pje Pujato"), null));
		esquinas.put(new VectorCalles("Antonia Godoy","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Piedras","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Ricardo Aldao"), Arrays.asList(new VectorCalles("Patricio Cullen","Ricardo Aldao"), null, null, new VectorCalles("Antonia Godoy","Pedro de Vega")));
		esquinas.put(new VectorCalles("Antonia Godoy","Angel Cassanello"), Arrays.asList(new VectorCalles("Patricio Cullen","Angel Cassanello"), new VectorCalles("Piedras","Angel Cassanello"), null, new VectorCalles("Antonia Godoy","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Antonia Godoy","J.P.L�pez"), Arrays.asList(new VectorCalles("Patricio Cullen","J.P.L�pez"), null, null, new VectorCalles("Antonia Godoy","Angel Cassanello")));
		esquinas.put(new VectorCalles("Piedras","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Tacuar�","Pedro de Vega"), new VectorCalles("Piedras","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Piedras","Ricardo Aldao"), Arrays.asList(new VectorCalles("Antonia Godoy","Ricardo Aldao"), null, new VectorCalles("Piedras","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("Piedras","Angel Cassanello"), Arrays.asList(new VectorCalles("Antonia Godoy","Angel Cassanello"), new VectorCalles("Tacuar�","Angel Cassanello"), new VectorCalles("Piedras","J.P.L�pez"), null));
		esquinas.put(new VectorCalles("Piedras","J.P.L�pez"), Arrays.asList(new VectorCalles("Antonia Godoy","J.P.L�pez"), null, new VectorCalles("Piedras","Pje Pujato"), null));
		esquinas.put(new VectorCalles("Tacuar�","Pedro de Vega"), Arrays.asList(null, new VectorCalles("V�lez Sarsfield","Pedro de Vega"), null, null));
		esquinas.put(new VectorCalles("Tacuar�","Ricardo Aldao"), Arrays.asList(new VectorCalles("Piedras","Ricardo Aldao"), null, null, new VectorCalles("Tacuar�","Pedro de Vega")));
		esquinas.put(new VectorCalles("Tacuar�","Angel Cassanello"), Arrays.asList(new VectorCalles("Piedras","Angel Cassanello"), new VectorCalles("V�lez Sarsfield","Angel Cassanello"), null, new VectorCalles("Tacuar�","Ricardo Aldao")));
		esquinas.put(new VectorCalles("Tacuar�","J.P.L�pez"), Arrays.asList(new VectorCalles("Piedras","J.P.L�pez"), null, null, new VectorCalles("Tacuar�","Angel Cassanello")));
		esquinas.put(new VectorCalles("V�lez Sarsfield","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("V�lez Sarsfield","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("V�lez Sarsfield","Ricardo Aldao"), Arrays.asList(new VectorCalles("Tacuar�","Ricardo Aldao"), null, new VectorCalles("V�lez Sarsfield","Angel Cassanello"), null));
		esquinas.put(new VectorCalles("V�lez Sarsfield","Angel Cassanello"), Arrays.asList(new VectorCalles("Tacuar�","Angel Cassanello"), new VectorCalles("Dorrego","Angel Cassanello"), new VectorCalles("V�lez Sarsfield","J.P.L�pez"), null));
		esquinas.put(new VectorCalles("V�lez Sarsfield","J.P.L�pez"), Arrays.asList(new VectorCalles("Tacuar�","J.P.L�pez"), null, new VectorCalles("V�lez Sarsfield","Hernandarias"), null));
		esquinas.put(new VectorCalles("Dorrego","Pedro de Vega"), Arrays.asList(null, new VectorCalles("General Paz","Pedro de Vega"), new VectorCalles("Dorrego","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Dorrego","Ricardo Aldao"), Arrays.asList(null, null, new VectorCalles("Dorrego","Angel Cassanello"), new VectorCalles("Dorrego","Pedro de Vega")));
		esquinas.put(new VectorCalles("Dorrego","Angel Cassanello"), Arrays.asList(new VectorCalles("V�lez Sarsfield","Angel Cassanello"), new VectorCalles("General Paz","Angel Cassanello"), null, new VectorCalles("Dorrego","Ricardo Aldao")));
		esquinas.put(new VectorCalles("General Paz","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("General Paz","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("General Paz","Ricardo Aldao"), Arrays.asList(new VectorCalles("Dorrego","Ricardo Aldao"), null, new VectorCalles("General Paz","Angel Cassanello"), new VectorCalles("General Paz","Pedro de Vega")));
		esquinas.put(new VectorCalles("General Paz","Angel Cassanello"), Arrays.asList(new VectorCalles("Dorrego","Angel Cassanello"), null, new VectorCalles("General Paz","J.P.L�pez"), new VectorCalles("General Paz","Ricardo Aldao")));
		esquinas.put(new VectorCalles("General Paz","J.P.L�pez"), Arrays.asList(null, null, new VectorCalles("General Paz","Hernandarias"), new VectorCalles("General Paz","Angel Cassanello")));
		esquinas.put(new VectorCalles("Almirante Brown","Hernandarias"), Arrays.asList(null, new VectorCalles("Defensa","Hernandarias"), new VectorCalles("Almirante Brown","Riobamba"), new VectorCalles("Almirante Brown","J.P.L�pez")));
		esquinas.put(new VectorCalles("Almirante Brown","Riobamba"), Arrays.asList(null, new VectorCalles("Riobamba","Juan Castelli"), new VectorCalles("Almirante Brown","Juan Castelli"), new VectorCalles("Almirante Brown","Hernandarias")));
		esquinas.put(new VectorCalles("Almirante Brown","Juan Castelli"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Estanislao Zeballos"), new VectorCalles("Almirante Brown","Riobamba")));
		esquinas.put(new VectorCalles("Almirante Brown","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Riobamba","Estanislao Zeballos"), new VectorCalles("Almirante Brown","Obispo Boneo"), new VectorCalles("Almirante Brown","Juan Castelli")));
		esquinas.put(new VectorCalles("Riobamba","Juan Castelli"), Arrays.asList(new VectorCalles("Almirante Brown","Juan Castelli"), null, new VectorCalles("R�o Bamba","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Riobamba","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Defensa","Estanislao Zeballos"), new VectorCalles("Riobamba","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Defensa","Hernandarias"), Arrays.asList(null, new VectorCalles("Talcahuano","Hernandarias"), null, new VectorCalles("Defensa","J.P.L�pez")));
		esquinas.put(new VectorCalles("Defensa","Juan Castelli"), Arrays.asList(new VectorCalles("Riobamba","Juan Castelli"), null, null, new VectorCalles("Defensa","Hernandarias")));
		esquinas.put(new VectorCalles("Defensa","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Talcahuano","Estanislao Zeballos"), null, new VectorCalles("Defensa","Juan Castelli")));
		esquinas.put(new VectorCalles("Talcahuano","Hernandarias"), Arrays.asList(null, new VectorCalles("Echag�e","Hernandarias"), new VectorCalles("Talcahuano","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Talcahuano","Juan Castelli"), Arrays.asList(new VectorCalles("Defensa","Juan Castelli"), null, new VectorCalles("Talcahuano","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Talcahuano","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Echag�e","Estanislao Zeballos"), new VectorCalles("Talcahuano","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Echag�e","Pje. Pujato"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Pje. Pujato"), null, new VectorCalles("Echag�e","J.P.L�pez")));
		esquinas.put(new VectorCalles("Echag�e","Hernandarias"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Hernandarias"), null, new VectorCalles("Echag�e","Pje. Pujato")));
		esquinas.put(new VectorCalles("Echag�e","Juan Castelli"), Arrays.asList(new VectorCalles("Talcahuano","Juan Castelli"), null, null, new VectorCalles("Echag�e","Hernandarias")));
		esquinas.put(new VectorCalles("Echag�e","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Estanislao Zeballos"), null, new VectorCalles("Echag�e","Juan Castelli")));
		esquinas.put(new VectorCalles("Patricio Cullen","Pje. Pujato"), Arrays.asList(new VectorCalles("Echag�e","Pje. Pujato"), new VectorCalles("Antonia Godoy","Pje. Pujato"), new VectorCalles("Patricio Cullen","Hernandarias"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Hernandarias"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Hernandarias"), new VectorCalles("Patricio Cullen","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Juan Castelli"), Arrays.asList(new VectorCalles("Echag�e","Juan Castelli"), null, new VectorCalles("Patricio Cullen","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Estanislao Zeballos"), new VectorCalles("Patricio Cullen","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Antonia Godoy","Pje. Pujato"), Arrays.asList(new VectorCalles("Patricio Cullen","Pje. Pujato"), null, null, new VectorCalles("Antonia Godoy","J.P.L�pez")));
		esquinas.put(new VectorCalles("Antonia Godoy","Hernandarias"), Arrays.asList(null, new VectorCalles("Piedras","Hernandarias"), null, new VectorCalles("Antonia Godoy","Pje. Pujato")));
		esquinas.put(new VectorCalles("Antonia Godoy","Juan Castelli"), Arrays.asList(new VectorCalles("Patricio Cullen","Juan Castelli"), null, null, new VectorCalles("Antonia Godoy","Hernandarias")));
		esquinas.put(new VectorCalles("Antonia Godoy","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Piedras","Estanislao Zeballos"), null, new VectorCalles("Antonia Godoy","Juan Castelli")));
		esquinas.put(new VectorCalles("Piedras","Pje. Pujato"), Arrays.asList(null, new VectorCalles("Tacuar�","Pje. Pujato"), new VectorCalles("Piedras","Hernandarias"), null));
		esquinas.put(new VectorCalles("Piedras","Hernandarias"), Arrays.asList(null, new VectorCalles("Tacuar�","Hernandarias"), new VectorCalles("Piedras","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Piedras","Juan Castelli"), Arrays.asList(new VectorCalles("Antonia Godoy","Juan Castelli"), null, new VectorCalles("Piedras","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Piedras","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Tacuar�","Estanislao Zeballos"), new VectorCalles("Piedras","Obispo Boneo"), null));
		esquinas.put(new VectorCalles("Tacuar�","Pje. Pujato"), Arrays.asList(new VectorCalles("Piedras","Pje. Pujato"), null, null, new VectorCalles("Tacuar�","J.P.L�pez")));
		esquinas.put(new VectorCalles("Tacuar�","Hernandarias"), Arrays.asList(null, new VectorCalles("Velez Sarfield","Hernandarias"), null, new VectorCalles("Tacuar�","Pje. Pujato")));
		esquinas.put(new VectorCalles("Tacuar�","Juan Castelli"), Arrays.asList(new VectorCalles("Piedras","Juan Castelli"), null, null, new VectorCalles("Tacuar�","Hernandarias")));
		esquinas.put(new VectorCalles("Tacuar�","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("Velez Sarfield","Estanislao Zeballos"), null, new VectorCalles("Tacuar�","Juan Castelli")));
		esquinas.put(new VectorCalles("Velez Sarfield","Hernandarias"), Arrays.asList(null, new VectorCalles("General Paz","Hernandarias"), new VectorCalles("Velez Sarfield","Juan Castelli"), null));
		esquinas.put(new VectorCalles("Velez Sarfield","Juan Castelli"), Arrays.asList(new VectorCalles("Tacuar�","Juan Castelli"), null, new VectorCalles("Velez Sarfield","Estanislao Zeballos"), null));
		esquinas.put(new VectorCalles("Velez Sarfield","Estanislao Zeballos"), Arrays.asList(null, new VectorCalles("General Paz","Estanislao Zeballos"), null, null));
		esquinas.put(new VectorCalles("General Paz","Hernandarias"), Arrays.asList(null, null, new VectorCalles("General Paz","Juan Castelli"), new VectorCalles("General Paz","J.P. L�pez")));
		esquinas.put(new VectorCalles("General Paz","Juan Castelli"), Arrays.asList(new VectorCalles("Velez Sarfield","Juan Castelli"), null, new VectorCalles("General Paz","Estanislao Zeballos"), new VectorCalles("General Paz","Hernandarias")));
		esquinas.put(new VectorCalles("General Paz","Estanislao Zeballos"), Arrays.asList(null, null, new VectorCalles("General Paz","Obispo Boneo"), new VectorCalles("General Paz","Juan Castelli")));
		esquinas.put(new VectorCalles("Almirante Brown","Obispo Boneo"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Espora"), new VectorCalles("Almirante Brown","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Almirante Brown","Espora"), Arrays.asList(null, new VectorCalles("Riobamba","Espora"), new VectorCalles("Almirante Brown","Obispo Pr�ncipe"), new VectorCalles("Almirante Brown","Obispo Boneo")));
		esquinas.put(new VectorCalles("Almirante Brown","Obispo Pr�ncipe"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Alberti"), new VectorCalles("Almirante Brown","Espora")));
		esquinas.put(new VectorCalles("Almirante Brown","Alberti"), Arrays.asList(null, new VectorCalles("Riobamba","Alberti"), new VectorCalles("Almirante Brown","Cardenal Fasolino"), new VectorCalles("Almirante Brown","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("Almirante Brown","Cardenal Fasolino"), Arrays.asList(null, null, new VectorCalles("Almirante Brown","Padre Genesio"), new VectorCalles("Almirante Brown","Alberti")));
		esquinas.put(new VectorCalles("Almirante Brown","Padre Genesio"), Arrays.asList(null, new VectorCalles("Riobamba","Padre Genesio"), new VectorCalles("Almirante Brown","Javier de la Rosa"), new VectorCalles("Almirante Brown","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Almirante Brown","Javier de la Rosa"), Arrays.asList(null, null, new VectorCalles("Italia","Regimiento 12 de Infanter�a"), new VectorCalles("Almirante Brown","Padre Genesio")));
		esquinas.put(new VectorCalles("Italia","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Riobamba","Regimiento 12 de Infanter�a"), null, new VectorCalles("Almirante Brown","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Riobamba","Obispo Boneo"), Arrays.asList(new VectorCalles("Almirante Brown","Obispo Boneo"), null, new VectorCalles("Riobamba","Espora"), null));
		esquinas.put(new VectorCalles("Riobamba","Espora"), Arrays.asList(null, new VectorCalles("Defensa","Espora"), new VectorCalles("Riobamba","Obispo Pr�ncipe"), null));
		esquinas.put(new VectorCalles("Riobamba","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Almirante Brown","Obispo Pr�ncipe"), null, new VectorCalles("Riobamba","Alberti"), null));
		esquinas.put(new VectorCalles("Riobamba","Alberti"), Arrays.asList(null, new VectorCalles("Defensa","Alberti"), new VectorCalles("Riobamba","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Riobamba","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Almirante Brown","Cardenal Fasolino"), null, new VectorCalles("Riobamba","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Riobamba","Padre Genesio"), Arrays.asList(null, new VectorCalles("Defensa","Padre Genesio"), new VectorCalles("Riobamba","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Riobamba","Javier de la Rosa"), Arrays.asList(new VectorCalles("Almirante Brown","Javier de la Rosa"), null, new VectorCalles("Riobamba","Regimiento 12 de Infanter�a"), null));
		esquinas.put(new VectorCalles("Riobamba","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Defensa","Regimiento 12 de Infanter�a"), null, null));
		esquinas.put(new VectorCalles("Defensa","Obispo Boneo"), Arrays.asList(new VectorCalles("Riobamba","Obispo Boneo"), null, null, new VectorCalles("Defensa","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Defensa","Espora"), Arrays.asList(null, new VectorCalles("Talcahuano","Espora"), null, new VectorCalles("Defensa","Obispo Boneo")));
		esquinas.put(new VectorCalles("Defensa","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Riobamba","Obispo Pr�ncipe"), null, null, new VectorCalles("Defensa","Espora")));
		esquinas.put(new VectorCalles("Defensa","Alberti"), Arrays.asList(null, new VectorCalles("Talcahuano","Alberti"), null, new VectorCalles("Defensa","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("Defensa","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Riobamba","Cardenal Fasolino"), null, null, new VectorCalles("Defensa","Alberti")));
		esquinas.put(new VectorCalles("Defensa","Padre Genesio"), Arrays.asList(null, new VectorCalles("Talcahuano","Padre Genesio"), null, new VectorCalles("Defensa","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Defensa","Javier de la Rosa"), Arrays.asList(new VectorCalles("Riobamba","Javier de la Rosa"), null, null, new VectorCalles("Defensa","Padre Genesio")));
		esquinas.put(new VectorCalles("Defensa","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Talcahuano","Regimiento 12 de Infanter�a"), null, new VectorCalles("Defensa","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Talcahuano","Obispo Boneo"), Arrays.asList(new VectorCalles("Defensa","Obispo Boneo"), null, new VectorCalles("Talcahuano","Espora"), null));
		esquinas.put(new VectorCalles("Talcahuano","Espora"), Arrays.asList(null, new VectorCalles("Echag�e","Espora"), new VectorCalles("Talcahuano","Obispo Pr�ncipe"), null));
		esquinas.put(new VectorCalles("Talcahuano","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Defensa","Obispo Pr�ncipe"), null, new VectorCalles("Talcahuano","Alberti"), null));
		esquinas.put(new VectorCalles("Talcahuano","Alberti"), Arrays.asList(null, new VectorCalles("Echag�e","Alberti"), new VectorCalles("Talcahuano","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Talcahuano","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Defensa","Cardenal Fasolino"), null, new VectorCalles("Talcahuano","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Talcahuano","Padre Genesio"), Arrays.asList(null, new VectorCalles("Echag�e","Padre Genesio"), new VectorCalles("Talcahuano","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Talcahuano","Javier de la Rosa"), Arrays.asList(new VectorCalles("Defensa","Javier de la Rosa"), null, new VectorCalles("Talcahuano","Regimiento 12 de Infanter�a"), null));
		esquinas.put(new VectorCalles("Talcahuano","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Echag�e","Regimiento 12 de Infanter�a"), null, null));
		esquinas.put(new VectorCalles("Echag�e","Obispo Boneo"), Arrays.asList(new VectorCalles("Talcahuano","Obispo Boneo"), null, null, new VectorCalles("Echag�e","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Echag�e","Espora"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Espora"), null, new VectorCalles("Echag�e","Obispo Boneo")));
		esquinas.put(new VectorCalles("Echag�e","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Talcahuano","Obispo Pr�ncipe"), null, null, new VectorCalles("Echag�e","Espora")));
		esquinas.put(new VectorCalles("Echag�e","Alberti"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Alberti"), null, new VectorCalles("Echag�e","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("Echag�e","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Talcahuano","Cardenal Fasolino"), null, null, new VectorCalles("Echag�e","Alberti")));
		esquinas.put(new VectorCalles("Echag�e","Padre Genesio"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Padre Genesio"), null, new VectorCalles("Echag�e","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Echag�e","Javier de la Rosa"), Arrays.asList(new VectorCalles("Talcahuano","Javier de la Rosa"), null, null, new VectorCalles("Echag�e","Padre Genesio")));
		esquinas.put(new VectorCalles("Echag�e","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Patricio Cullen","Regimiento 12 de Infanter�a"), null, new VectorCalles("Echag�e","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Patricio Cullen","Obispo Boneo"), Arrays.asList(new VectorCalles("Echag�e","Obispo Boneo"), null, new VectorCalles("Patricio Cullen","Espora"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Espora"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Espora"), new VectorCalles("Patricio Cullen","Obispo Pr�ncipe"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Echag�e","Obispo Pr�ncipe"), null, null, null));
		esquinas.put(new VectorCalles("Patricio Cullen","Alberti"), Arrays.asList(null, null, new VectorCalles("Patricio Cullen","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Echag�e","Cardenal Fasolino"), null, new VectorCalles("Patricio Cullen","Pje de Andrea"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Pje de Andrea"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Pje de Andrea"), new VectorCalles("Patricio Cullen","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Padre Genesio"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Padre Genesio"), new VectorCalles("Patricio Cullen","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Javier de la Rosa"), Arrays.asList(new VectorCalles("Echag�e","Javier de la Rosa"), null, new VectorCalles("Patricio Cullen","Regimiento 12 de Infanter�a"), null));
		esquinas.put(new VectorCalles("Patricio Cullen","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Antonia Godoy","Regimiento 12 de Infanter�a"), null, null));
		esquinas.put(new VectorCalles("Juan Maciel","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Patricio Cullen","Obispo Pr�ncipe"), null, new VectorCalles("Juan Maciel","Alberti"), null));
		esquinas.put(new VectorCalles("Juan Maciel","Alberti"), Arrays.asList(new VectorCalles("Patricio Cullen","Alberti"), null, null, new VectorCalles("Juan Maciel","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("Antonia Godoy","Obispo Boneo"), Arrays.asList(new VectorCalles("Patricio Cullen","Obispo Boneo"), null, null, new VectorCalles("Antonia Godoy","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Antonia Godoy","Espora"), Arrays.asList(null, new VectorCalles("Piedras","Espora"), null, new VectorCalles("Antonia Godoy","Obispo Boneo")));
		esquinas.put(new VectorCalles("Antonia Godoy","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Juan Maciel","Obispo Pr�ncipe"), null, null, new VectorCalles("Antonia Godoy","Espora")));
		esquinas.put(new VectorCalles("Antonia Godoy","Alberti"), Arrays.asList(new VectorCalles("Juan Maciel","Alberti"), null, null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Patricio Cullen","Cardenal Fasolino"), null, null, new VectorCalles("Antonia Godoy","Alberti")));
		esquinas.put(new VectorCalles("Antonia Godoy","Pje de Andrea"), Arrays.asList(null, null, null, new VectorCalles("Antonia Godoy","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Antonia Godoy","Padre Genesio"), Arrays.asList(null, new VectorCalles("Piedras","Padre Genesio"), null, new VectorCalles("Antonia Godoy","Pje de Andrea")));
		esquinas.put(new VectorCalles("Antonia Godoy","Javier de la Rosa"), Arrays.asList(new VectorCalles("Patricio Cullen","Javier de la Rosa"), null, null, null));
		esquinas.put(new VectorCalles("Antonia Godoy","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Piedras","Regimiento 12 de Infanter�a"), null, new VectorCalles("Antonia Godoy","Javier de la Rosa")));
		esquinas.put(new VectorCalles("Piedras","Obispo Boneo"), Arrays.asList(new VectorCalles("Antonia Godoy","Obispo Boneo"), null, new VectorCalles("Piedras","Espora"), null));
		esquinas.put(new VectorCalles("Piedras","Espora"), Arrays.asList(null, new VectorCalles("Tacuar�","Espora"), new VectorCalles("Piedras","Obispo Pr�ncipe"), null));
		esquinas.put(new VectorCalles("Piedras","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Antonia Godoy","Obispo Pr�ncipe"), null, new VectorCalles("Piedras","Alberti"), null));
		esquinas.put(new VectorCalles("Piedras","Alberti"), Arrays.asList(null, new VectorCalles("Tacuar�","Alberti"), new VectorCalles("Piedras","Cardenal Fasolino"), null));
		esquinas.put(new VectorCalles("Piedras","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Antonia Godoy","Cardenal Fasolino"), null, new VectorCalles("Piedras","Pje de Andrea"), null));
		esquinas.put(new VectorCalles("Piedras","Pje de Andrea"), Arrays.asList(null, new VectorCalles("Tacuar�","Pje de Andrea"), new VectorCalles("Piedras","Padre Genesio"), null));
		esquinas.put(new VectorCalles("Piedras","Padre Genesio"), Arrays.asList(null, new VectorCalles("Tacuar�","Padre Genesio"), new VectorCalles("Piedras","Javier de la Rosa"), null));
		esquinas.put(new VectorCalles("Piedras","Javier de la Rosa"), Arrays.asList(new VectorCalles("Antonia Godoy","Javier de la Rosa"), null, new VectorCalles("Piedras","Regimiento 12 de Infanter�a"), null));
		esquinas.put(new VectorCalles("Piedras","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("Tacuar�","Regimiento 12 de Infanter�a"), null, null));
		esquinas.put(new VectorCalles("Tacuar�","Obispo Boneo"), Arrays.asList(new VectorCalles("Piedras","Obispo Boneo"), null, null, new VectorCalles("Tacuar�","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("Tacuar�","Espora"), Arrays.asList(null, new VectorCalles("General Paz","Espora"), null, new VectorCalles("Tacuar�","Obispo Boneo")));
		esquinas.put(new VectorCalles("Tacuar�","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Piedras","Obispo Pr�ncipe"), null, null, new VectorCalles("Tacuar�","Espora")));
		esquinas.put(new VectorCalles("Tacuar�","Alberti"), Arrays.asList(null, new VectorCalles("General Paz","Alberti"), null, new VectorCalles("Tacuar�","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("Tacuar�","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Piedras","Cardenal Fasolino"), null, null, new VectorCalles("Tacuar�","Alberti")));
		esquinas.put(new VectorCalles("Tacuar�","Pje de Andrea"), Arrays.asList(new VectorCalles("Piedras","Pje de Andrea"), null, null, new VectorCalles("Tacuar�","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("Tacuar�","Padre Genesio"), Arrays.asList(null, new VectorCalles("General Paz","Padre Genesio"), null, new VectorCalles("Tacuar�","Pje de Andrea")));
		esquinas.put(new VectorCalles("Tacuar�","Javier de la Rosa"), Arrays.asList(new VectorCalles("Piedras","Javier de la Rosa"), null, null, new VectorCalles("Tacuar�","Padre Genesio")));
		esquinas.put(new VectorCalles("Tacuar�","Regimiento 12 de Infanter�a"), Arrays.asList(null, new VectorCalles("General Paz","Regimiento 12 de Infanter�a"), null, new VectorCalles("Tacuar�","Javier de la Rosa")));
		esquinas.put(new VectorCalles("General Paz","Obispo Boneo"), Arrays.asList(new VectorCalles("Tacuar�","Obispo Boneo"), null, new VectorCalles("General Paz","Espora"), new VectorCalles("General Paz","Estanislao Zeballos")));
		esquinas.put(new VectorCalles("General Paz","Espora"), Arrays.asList(null, null, new VectorCalles("General Paz","Obispo Pr�ncipe"), new VectorCalles("General Paz","Obispo Boneo")));
		esquinas.put(new VectorCalles("General Paz","Obispo Pr�ncipe"), Arrays.asList(new VectorCalles("Tacuar�","Obispo Pr�ncipe"), null, new VectorCalles("General Paz","Alberti"), new VectorCalles("General Paz","Espora")));
		esquinas.put(new VectorCalles("General Paz","Alberti"), Arrays.asList(null, null, new VectorCalles("General Paz","Cardenal Fasolino"), new VectorCalles("General Paz","Obispo Pr�ncipe")));
		esquinas.put(new VectorCalles("General Paz","Cardenal Fasolino"), Arrays.asList(new VectorCalles("Tacuar�","Cardenal Fasolino"), null, new VectorCalles("General Paz","Padre Genesio"), new VectorCalles("General Paz","Alberti")));
		esquinas.put(new VectorCalles("General Paz","Padre Genesio"), Arrays.asList(null, null, new VectorCalles("General Paz","Javier de la Rosa"), new VectorCalles("General Paz","Cardenal Fasolino")));
		esquinas.put(new VectorCalles("General Paz","Javier de la Rosa"), Arrays.asList(new VectorCalles("Tacuar�","Javier de la Rosa"), null, new VectorCalles("General Paz","Regimiento 12 de Infanter�a"), new VectorCalles("General Paz","Padre Genesio")));
		esquinas.put(new VectorCalles("General Paz","Regimiento 12 de Infanter�a"), Arrays.asList(null, null, null, new VectorCalles("General Paz","Javier de la Rosa")));
		}
	
	private void cargarMapaReducido() {
		esquinas.put(new VectorCalles("Almirante Brown","Pedro de Vega"), Arrays.asList(null, new VectorCalles("Echag�e","Pedro de Vega"), new VectorCalles("Almirante Brown","Ricardo Aldao"),  null));
		esquinas.put(new VectorCalles("Almirante Brown","Ricardo Aldao"), Arrays.asList(null, null, null, new VectorCalles("Almirante Brown","Pedro de Vega")));
		esquinas.put(new VectorCalles("Echag�e","Pedro de Vega"), Arrays.asList(null, null, new VectorCalles("Echag�e","Ricardo Aldao"), null));
		esquinas.put(new VectorCalles("Echag�e","Ricardo Aldao"), Arrays.asList(new VectorCalles("Almirante Brown","Ricardo Aldao"), null, null, null));
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
