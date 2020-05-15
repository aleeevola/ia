package interfaz;
/*
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * Use is subject to Apache 2.0 license terms.
 */


import com.teamdev.jxmaps.ControlPosition;

import com.teamdev.jxmaps.GeocoderCallback;
import com.teamdev.jxmaps.GeocoderRequest;
import com.teamdev.jxmaps.GeocoderResult;
import com.teamdev.jxmaps.GeocoderStatus;
import com.teamdev.jxmaps.InfoWindow;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.examples.PlacesSearchExample;
import com.teamdev.jxmaps.swing.MapView;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import search.AgenteCustodia;
import search.Ambiente;
import search.VectorCalles;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.text.DecimalFormat;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class MainAgenteCustodia extends MapView {
    
	public LatLng locationdefault;
	private static HashMap<VectorCalles,LatLng> coordenadas=new HashMap<VectorCalles,LatLng>();
	
	private static JFrame frame = new JFrame("Agente custodia");
	private static JPanel panelEstado=new JPanel();
	private static TablaActions tablaAcciones = new TablaActions();
	private static JTable tablaA;
	private static ArrayList<String> acciones=new ArrayList();
	private static JLabel multados = new JLabel();
	private static int numeroMultados = 0;
	
	public static Map map;
	
	public static Map getMapaAgente() {
		return map;
	}

	public static void setMapaAgente(Map mapaAgente) {
		MainAgenteCustodia.map = mapaAgente;
	}

	public MainAgenteCustodia() {
        
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    map = getMap();
                    
                    // Creating a map options object
                    MapOptions mapOptions = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    
                    // Updating visibility of the zoom control
                    mapOptions.setZoomControl(true);
                    // Updating visibility of the map type control
                    mapOptions.setMapTypeControl(false);
                    // Updating visibility of the street view control
                    mapOptions.setStreetViewControl(false);
                    
                    
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting the map center
                    map.setCenter(new LatLng(-31.611983, -60.673254));
                    // Setting initial zoom value
                    map.setZoom(15.0f);
                    
                   iniciarBusqueda();
             
                    
                }
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        final MainAgenteCustodia mapa = new MainAgenteCustodia();
        cargarMapa();
    	
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.add(sample, BorderLayout.WEST);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
		frame.add(mapa, BorderLayout.CENTER);
		
		
		cargarPanelEstado();
		
		frame.setVisible(true);
    }
    
    private static void cargarPanelEstado() {
    	JLabel NumMul = new JLabel();
    	NumMul.setText("Numero de mulados:");
		panelEstado.add(NumMul, BorderLayout.NORTH);
		multados = new JLabel();
		multados.setText("0");
		panelEstado.add(multados, BorderLayout.NORTH);
		panelEstado.setPreferredSize(new Dimension(200,800));
		
    	
		tablaA = new JTable(tablaAcciones);
		tablaA.setFillsViewportHeight(true);
		tablaA.setRowSelectionAllowed(true);
		tablaA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaA.setPreferredScrollableViewportSize(new Dimension (200,500));
		JScrollPane scrollPaneT = new JScrollPane(tablaA);
		
		panelEstado.add(scrollPaneT, BorderLayout.CENTER);
		
		
		
		frame.add(panelEstado, BorderLayout.EAST);
    }
    
    private static void iniciarBusqueda() {

    	AgenteCustodia agent = new AgenteCustodia();

        Ambiente environment = new Ambiente();

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }
    
   
    
    public static void trazarDesplazamiento(VectorCalles origen, VectorCalles destino) {
    	try {
    		LatLng esquinaOrigen=coordenadas.get(origen);
        	LatLng esquinaDestino=coordenadas.get(destino);
    	
	    	LatLng[] path = {esquinaOrigen,esquinaDestino};
	        // Creating a new polyline object
	        Polyline polyline = new Polyline(map);
	        // Initializing the polyline with created path
	        polyline.setPath(path);
	        // Creating a polyline options object
	        PolylineOptions options = new PolylineOptions();
	        // Setting stroke color value
	        options.setStrokeColor("#FF0000");
	        // Setting stroke opacity value
	        options.setStrokeOpacity(1.0);
	        // Setting stroke weight value
	        options.setStrokeWeight(2.0);
	        // Applying options to the polyline
	        polyline.setOptions(options);
        
    	}catch(Exception e){
    		System.out.println("Hay un error con una de estas dos calles");
    		System.out.println("--->"+origen.toString());
    		System.out.println("--->"+destino.toString());
    		return;
    	}
    }
    
    
    public static void agregarMultado(VectorCalles esquina) {
 	   
 	   Marker marker = new Marker(map);
        // Setting position of the marker to the result location
        marker.setPosition(coordenadas.get(esquina));
        marker.setIcon("http://maps.google.com/mapfiles/ms/micons/blue-dot.png");
        // Creating an information window
        InfoWindow infoWindow = new InfoWindow(map);
        // Putting the address and location to the content of the information window
        infoWindow.setContent("Fue multado! "+esquina.toString());
        // Moving the information window to the result location
       
        // Showing of the information window
        
        infoWindow.open(map, marker);
        
        numeroMultados++;
        multados.setText(String.valueOf(numeroMultados));
    }
    
    public static void agregarInfectado(VectorCalles esquina) {
  	   
  	   Marker marker = new Marker(map);
         // Setting position of the marker to the result location
         marker.setPosition(coordenadas.get(esquina));
         // Creating an information window
         marker.setIcon("http://maps.google.com/mapfiles/ms/micons/yellow-dot.png");
         InfoWindow infoWindow = new InfoWindow(map);
         marker.setVisible(true);
         // Putting the address and location to the content of the information window
         //infoWindow.setContent("Fue multado! "+esquina.toString());
         // Moving the information window to the result location
        
         // Showing of the information window
         
         //infoWindow.open(map, marker);
         
     }
    
    public static void agregarCalleCortada(VectorCalles esquina) {
   	   
   	   Marker marker = new Marker(map);
          // Setting position of the marker to the result location
          marker.setPosition(coordenadas.get(esquina));
          // Creating an information window
          marker.setIcon("http://maps.google.com/mapfiles/ms/micons/caution.png");
          InfoWindow infoWindow = new InfoWindow(map);
          marker.setVisible(true);
          // Putting the address and location to the content of the information window
          //infoWindow.setContent("Fue multado! "+esquina.toString());
          // Moving the information window to the result location
         
          // Showing of the information window
          
          //infoWindow.open(map, marker);
      }
    
    public void getLocation(VectorCalles esquina) {
    	
    	String esquinaOrigen=esquina.getCalleA()+" y "+esquina.getCalleB()+", Santa Fe, Argentina";

    	//System.out.println("enro");
    	final Map map = getMap();
    	// Creating a geocode request
        GeocoderRequest request = new GeocoderRequest();
        // Setting address to the geocode request
        request.setAddress(esquinaOrigen);
        // Geocoding position by the entered address
        getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
            @Override
            public void onComplete(GeocoderResult[] results, GeocoderStatus status) {

                if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                    GeocoderResult result = results[0];
                    LatLng origen = result.getGeometry().getLocation();
                    System.out.println(esquina.toString()+">"+origen);

                }
            }
        });
}
	public static void actualizarAccion(String accion) {
		acciones.add(accion);
		tablaAcciones.setTitulares(acciones);
		tablaAcciones.fireTableDataChanged();
	}
    
    private static void cargarMapa() {
    	coordenadas.put(new VectorCalles("Defensa","J.P.López"), new LatLng(-31.61353,-60.670341));
    	coordenadas.put(new VectorCalles("Echagüe","Pedro de Vega"), new LatLng(-31.615833,-60.673229));
    	coordenadas.put(new VectorCalles("Echagüe","Angel Cassanello"), new LatLng(-31.614037,-60.672713));
    	coordenadas.put(new VectorCalles("Almirante Brown","J.P.López"), new LatLng(-31.613731,-60.669974));
    	coordenadas.put(new VectorCalles("Almirante Brown","Angel Cassanello"), new LatLng(-31.614435,-60.671025));
    	coordenadas.put(new VectorCalles("Echagüe","Ricardo Aldao"), new LatLng(-31.614938,-60.672977));
    	coordenadas.put(new VectorCalles("Almirante Brown","Ricardo Aldao"), new LatLng(-31.615261,-60.671868));
    	coordenadas.put(new VectorCalles("Almirante Brown","Pedro de Vega"), new LatLng(-31.616013,-60.672836));
    	coordenadas.put(new VectorCalles("Talcahuano","Angel Cassanello"), new LatLng(-31.614267,-60.671656));
    	coordenadas.put(new VectorCalles("Talcahuano","J.P.López"), new LatLng(-31.61335,-60.671403));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Ricardo Aldao"), new LatLng(-31.614662,-60.674075));
    	coordenadas.put(new VectorCalles("Patricio Cullen","J.P.López"), new LatLng(-31.612901,-60.673531));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Angel Cassanello"), new LatLng(-31.613587,-60.674844));
    	coordenadas.put(new VectorCalles("Piedras","Ricardo Aldao"), new LatLng(-31.614246,-60.676155));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Ricardo Aldao"), new LatLng(-31.614416,-60.675136));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Pedro de Vega"), new LatLng(-31.615561,-60.674332));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Pedro de Vega"), new LatLng(-31.615342,-60.675404));
    	coordenadas.put(new VectorCalles("Antonia Godoy","J.P.López"), new LatLng(-31.612663,-60.674599));
    	coordenadas.put(new VectorCalles("Piedras","Pedro de Vega"), new LatLng(-31.615147,-60.676407));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Angel Cassanello"), new LatLng(-31.613807,-60.673778));
    	coordenadas.put(new VectorCalles("Tacuarí","J.P.López"), new LatLng(-31.612207,-60.676725));
    	coordenadas.put(new VectorCalles("Tacuarí","Ricardo Aldao"), new LatLng(-31.614027,-60.677228));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Ricardo Aldao"), new LatLng(-31.613778,-60.678312));
    	coordenadas.put(new VectorCalles("Piedras","J.P.López"), new LatLng(-31.612442,-60.675649));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Pedro de Vega"), new LatLng(-31.614713,-60.678549));
    	coordenadas.put(new VectorCalles("Piedras","Angel Cassanello"), new LatLng(-31.613346,-60.675902));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","J.P.López"), new LatLng(-31.611952,-60.677779));
    	coordenadas.put(new VectorCalles("Tacuarí","Angel Cassanello"), new LatLng(-31.61312,-60.676978));
    	coordenadas.put(new VectorCalles("Tacuarí","Pedro de Vega"), new LatLng(-31.614934,-60.677498));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Angel Cassanello"), new LatLng(-31.612878,-60.678045));
    	coordenadas.put(new VectorCalles("Dorrego","Ricardo Aldao"), new LatLng(-31.613556,-60.679456));
    	coordenadas.put(new VectorCalles("General Paz","J.P.López"), new LatLng(-31.611661,-60.679265));
    	coordenadas.put(new VectorCalles("General Paz","Ricardo Aldao"), new LatLng(-31.613325,-60.680593));
    	coordenadas.put(new VectorCalles("Almirante Brown","Juan Castelli"), new LatLng(-31.612075,-60.668318));
    	coordenadas.put(new VectorCalles("Almirante Brown","Riobamba"), new LatLng(-31.612667,-60.668912));
    	coordenadas.put(new VectorCalles("General Paz","Pedro de Vega"), new LatLng(-31.614128,-60.681226));
    	coordenadas.put(new VectorCalles("Dorrego","Angel Cassanello"), new LatLng(-31.612628,-60.679188));
    	coordenadas.put(new VectorCalles("Dorrego","Pedro de Vega"), new LatLng(-31.614466,-60.679732));
    	coordenadas.put(new VectorCalles("Almirante Brown","Hernandarias"), new LatLng(-31.612921,-60.669029));
    	coordenadas.put(new VectorCalles("General Paz","Angel Cassanello"), new LatLng(-31.612483,-60.679915));
    	coordenadas.put(new VectorCalles("Talcahuano","Hernandarias"), new LatLng(-31.612425,-60.671138));
    	coordenadas.put(new VectorCalles("Almirante Brown","Estanislao Zeballos"), new LatLng(-31.611309,-60.667553));
    	coordenadas.put(new VectorCalles("Talcahuano","Estanislao Zeballos"), new LatLng(-31.610617,-60.670642));
    	coordenadas.put(new VectorCalles("Riobamba","Estanislao Zeballos"), new LatLng(-31.611029,-60.668531));
    	coordenadas.put(new VectorCalles("Defensa","Juan Castelli"), new LatLng(-31.611741,-60.669829));
    	coordenadas.put(new VectorCalles("Talcahuano","Juan Castelli"), new LatLng(-31.611535,-60.670883));
    	coordenadas.put(new VectorCalles("Defensa","Estanislao Zeballos"), new LatLng(-31.610836,-60.669588));
    	coordenadas.put(new VectorCalles("Riobamba","Juan Castelli"), new LatLng(-31.611943,-60.668769));
    	coordenadas.put(new VectorCalles("Defensa","Hernandarias"), new LatLng(-31.612623,-60.670089));
    	coordenadas.put(new VectorCalles("Echagüe","Pje. Pujato"), new LatLng(-31.612628,-60.672319));
    	coordenadas.put(new VectorCalles("Echagüe","Hernandarias"), new LatLng(-31.612209,-60.672212));
    	coordenadas.put(new VectorCalles("Echagüe","Juan Castelli"), new LatLng(-31.611295,-60.671967));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Pje. Pujato"), new LatLng(-31.61241,-60.673392));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Hernandarias"), new LatLng(-31.611759,-60.674356));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Juan Castelli"), new LatLng(-31.610844,-60.674087));
    	coordenadas.put(new VectorCalles("Echagüe","Estanislao Zeballos"), new LatLng(-31.61039,-60.671714));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Hernandarias"), new LatLng(-31.611981,-60.673275));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Pje. Pujato"), new LatLng(-31.612187,-60.674464));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Estanislao Zeballos"), new LatLng(-31.610154,-60.672766));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Juan Castelli"), new LatLng(-31.611088,-60.673011));
    	coordenadas.put(new VectorCalles("Piedras","Hernandarias"), new LatLng(-31.611535,-60.675405));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Estanislao Zeballos"), new LatLng(-31.609937,-60.673845));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Hernandarias"), new LatLng(-31.611069,-60.677531));
    	coordenadas.put(new VectorCalles("Tacuarí","Hernandarias"), new LatLng(-31.611301,-60.676476));
    	coordenadas.put(new VectorCalles("Piedras","Estanislao Zeballos"), new LatLng(-31.609692,-60.674911));
    	coordenadas.put(new VectorCalles("Tacuarí","Estanislao Zeballos"), new LatLng(-31.609472,-60.675969));
    	coordenadas.put(new VectorCalles("Piedras","Pje. Pujato"), new LatLng(-31.611953,-60.675523));
    	coordenadas.put(new VectorCalles("Tacuarí","Pje. Pujato"), new LatLng(-31.611717,-60.676598));
    	coordenadas.put(new VectorCalles("Piedras","Juan Castelli"), new LatLng(-31.610613,-60.675160));
    	coordenadas.put(new VectorCalles("Tacuarí","Juan Castelli"), new LatLng(-31.61041,-60.676214));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Juan Castelli"), new LatLng(-31.61017,-60.67727));
    	coordenadas.put(new VectorCalles("Vélez Sarsfield","Estanislao Zeballos"), new LatLng(-31.609252,-60.677008));
    	coordenadas.put(new VectorCalles("General Paz","Juan Castelli"), new LatLng(-31.609982,-60.678085));
    	coordenadas.put(new VectorCalles("General Paz","Estanislao Zeballos"), new LatLng(-31.609121,-60.677643));
    	coordenadas.put(new VectorCalles("Almirante Brown","Alberti"), new LatLng(-31.607609,-60.666336));
    	coordenadas.put(new VectorCalles("Almirante Brown","Obispo Boneo"), new LatLng(-31.610387,-60.667103));
    	coordenadas.put(new VectorCalles("Almirante Brown","Obispo Príncipe"), new LatLng(-31.608415,-60.666555));
    	coordenadas.put(new VectorCalles("General Paz","Hernandarias"), new LatLng(-31.610856,-60.678574));
    	coordenadas.put(new VectorCalles("Almirante Brown","Espora"), new LatLng(-31.609227,-60.666938));
    	coordenadas.put(new VectorCalles("Almirante Brown","Cardenal Fasolino"), new LatLng(-31.60679,-60.666121));
    	coordenadas.put(new VectorCalles("Riobamba","Obispo Príncipe"), new LatLng(-31.608215,-60.667767));
    	coordenadas.put(new VectorCalles("Almirante Brown","Javier de la Rosa"), new LatLng(-31.604944,-60.665800));
    	coordenadas.put(new VectorCalles("Riobamba","Padre Genesio"), new LatLng(-31.605659,-60.667054));
    	coordenadas.put(new VectorCalles("Riobamba","Espora"), new LatLng(-31.60902,-60.667997));
    	coordenadas.put(new VectorCalles("Riobamba","Javier de la Rosa"), new LatLng(-31.604737,-60.666807));
    	coordenadas.put(new VectorCalles("Riobamba","Cardenal Fasolino"), new LatLng(-31.606579,-60.667324));
    	coordenadas.put(new VectorCalles("Riobamba","Alberti"), new LatLng(-31.607402,-60.66754));
    	coordenadas.put(new VectorCalles("Italia","Regimiento 12 de Infantería"), new LatLng(-31.604021,-60.665568));
    	coordenadas.put(new VectorCalles("Almirante Brown","Padre Genesio"), new LatLng(-31.605806,-60.666095));
    	coordenadas.put(new VectorCalles("Riobamba","Obispo Boneo"), new LatLng(-31.610104,-60.668283));
    	coordenadas.put(new VectorCalles("Riobamba","Regimiento 12 de Infantería"), new LatLng(-31.603823,-60.666551));
    	coordenadas.put(new VectorCalles("Defensa","Padre Genesio"), new LatLng(-31.605442,-60.668129));
    	coordenadas.put(new VectorCalles("Defensa","Cardenal Fasolino"), new LatLng(-31.606367,-60.668383));
    	coordenadas.put(new VectorCalles("Talcahuano","Obispo Boneo"), new LatLng(-31.609693,-60.670398));
    	coordenadas.put(new VectorCalles("Defensa","Obispo Príncipe"), new LatLng(-31.608011,-60.66883));
    	coordenadas.put(new VectorCalles("Defensa","Espora"), new LatLng(-31.6088,-60.669035));
    	coordenadas.put(new VectorCalles("Defensa","Obispo Boneo"), new LatLng(-31.609915,-60.669337));
    	coordenadas.put(new VectorCalles("Defensa","Regimiento 12 de Infantería"), new LatLng(-31.603574,-60.66766));
    	coordenadas.put(new VectorCalles("Defensa","Alberti"), new LatLng(-31.607184,-60.668604));
    	coordenadas.put(new VectorCalles("Defensa","Javier de la Rosa"), new LatLng(-31.604521,-60.667903));
    	coordenadas.put(new VectorCalles("Echagüe","Espora"), new LatLng(-31.608342,-60.671232));
    	coordenadas.put(new VectorCalles("Talcahuano","Alberti"), new LatLng(-31.606975,-60.669683));
    	coordenadas.put(new VectorCalles("Talcahuano","Obispo Príncipe"), new LatLng(-31.607793,-60.669893));
    	coordenadas.put(new VectorCalles("Talcahuano","Espora"), new LatLng(-31.60857,-60.670103));
    	coordenadas.put(new VectorCalles("Talcahuano","Javier de la Rosa"), new LatLng(-31.604282,-60.669009));
    	coordenadas.put(new VectorCalles("Echagüe","Obispo Príncipe"), new LatLng(-31.607509,-60.670994));
    	coordenadas.put(new VectorCalles("Talcahuano","Padre Genesio"), new LatLng(-31.605221,-60.669206));
    	coordenadas.put(new VectorCalles("Talcahuano","Cardenal Fasolino"), new LatLng(-31.606137,-60.669446));
    	coordenadas.put(new VectorCalles("Talcahuano","Regimiento 12 de Infantería"), new LatLng(-31.603374,-60.668744));
    	coordenadas.put(new VectorCalles("Echagüe","Obispo Boneo"), new LatLng(-31.609467,-60.671459));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Espora"), new LatLng(-31.608141,-60.672265));
    	coordenadas.put(new VectorCalles("Echagüe","Padre Genesio"), new LatLng(-31.604996,-60.670357));
    	coordenadas.put(new VectorCalles("Echagüe","Cardenal Fasolino"), new LatLng(-31.605939,-60.670617));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Obispo Boneo"), new LatLng(-31.60924,-60.67253));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Cardenal Fasolino"), new LatLng(-31.605708,-60.671577));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Obispo Príncipe"), new LatLng(-31.607306,-60.672011));
    	coordenadas.put(new VectorCalles("Echagüe","Alberti"), new LatLng(-31.606443,-60.670725));
    	coordenadas.put(new VectorCalles("Echagüe","Javier de la Rosa"), new LatLng(-31.60409,-60.67006));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Alberti"), new LatLng(-31.606239,-60.671735));
    	coordenadas.put(new VectorCalles("Echagüe","Regimiento 12 de Infantería"), new LatLng(-31.603171,-60.669803));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Espora"), new LatLng(-31.608004,-60.673322));
    	coordenadas.put(new VectorCalles("Juan Maciel","Alberti"), new LatLng(-31.606407,-60.672323));
    	coordenadas.put(new VectorCalles("Juan Maciel","Obispo Príncipe"), new LatLng(-31.607234,-60.672546));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Obispo Boneo"), new LatLng(-31.609009,-60.673586));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Alberti"), new LatLng(-31.606354,-60.672659));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Regimiento 12 de Infantería"), new LatLng(-31.602961,-60.67088));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Padre Genesio"), new LatLng(-31.6048,-60.671319));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Pje de Andrea"), new LatLng(-31.605225,-60.671442));
    	coordenadas.put(new VectorCalles("Patricio Cullen","Javier de la Rosa"), new LatLng(-31.603874,-60.671128));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Obispo Príncipe"), new LatLng(-31.607147,-60.673098));
    	coordenadas.put(new VectorCalles("Piedras","Obispo Boneo"), new LatLng(-31.608756,-60.674659));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Cardenal Fasolino"), new LatLng(-31.605505,-60.67264));
    	coordenadas.put(new VectorCalles("Piedras","Cardenal Fasolino"), new LatLng(-31.605289,-60.673715));
    	coordenadas.put(new VectorCalles("Piedras","Espora"), new LatLng(-31.607783,-60.674380));
    	coordenadas.put(new VectorCalles("Piedras","Obispo Príncipe"), new LatLng(-31.606933,-60.674160));
    	coordenadas.put(new VectorCalles("Piedras","Alberti"), new LatLng(-31.606111,-60.673951));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Javier de la Rosa"), new LatLng(-31.603661,-60.6722));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Pje de Andrea"), new LatLng(-31.605019,-60.672506));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Regimiento 12 de Infantería"), new LatLng(-31.602746,-60.671942));
    	coordenadas.put(new VectorCalles("Antonia Godoy","Padre Genesio"), new LatLng(-31.604589,-60.672408));
    	coordenadas.put(new VectorCalles("Piedras","Regimiento 12 de Infantería"), new LatLng(-31.602539,-60.673014));
    	coordenadas.put(new VectorCalles("Tacuarí","Obispo Boneo"), new LatLng(-31.608548,-60.675713));
    	coordenadas.put(new VectorCalles("Tacuarí","Cardenal Fasolino"), new LatLng(-31.605091,-60.674793));
    	coordenadas.put(new VectorCalles("Tacuarí","Alberti"), new LatLng(-31.605903,-60.674987));
    	coordenadas.put(new VectorCalles("Piedras","Javier de la Rosa"), new LatLng(-31.603462,-60.673244));
    	coordenadas.put(new VectorCalles("Piedras","Padre Genesio"), new LatLng(-31.604375,-60.673475));
    	coordenadas.put(new VectorCalles("Piedras","Pje de Andrea"), new LatLng(-31.604806,-60.673595));
    	coordenadas.put(new VectorCalles("Tacuarí","Espora"), new LatLng(-31.607586,-60.67546));
    	coordenadas.put(new VectorCalles("Tacuarí","Obispo Príncipe"), new LatLng(-31.60674,-60.67522));
    	coordenadas.put(new VectorCalles("Tacuarí","Pje de Andrea"), new LatLng(-31.604594,-60.674641));
    	coordenadas.put(new VectorCalles("General Paz","Obispo Príncipe"), new LatLng(-31.606524,-60.676215));
    	coordenadas.put(new VectorCalles("Tacuarí","Javier de la Rosa"), new LatLng(-31.603261,-60.674264));
    	coordenadas.put(new VectorCalles("General Paz","Cardenal Fasolino"), new LatLng(-31.604954,-60.675467));
    	coordenadas.put(new VectorCalles("General Paz","Alberti"), new LatLng(-31.605794,-60.675835));
    	coordenadas.put(new VectorCalles("Tacuarí","Regimiento 12 de Infantería"), new LatLng(-31.602339,-60.67402));
    	coordenadas.put(new VectorCalles("Tacuarí","Padre Genesio"), new LatLng(-31.604174,-60.674534));
    	coordenadas.put(new VectorCalles("General Paz","Javier de la Rosa"), new LatLng(-31.603087,-60.67488));
    	coordenadas.put(new VectorCalles("General Paz","Espora"), new LatLng(-31.60735,-60.676672));
    	coordenadas.put(new VectorCalles("General Paz","Obispo Boneo"), new LatLng(-31.608243,-60.67714));
    	coordenadas.put(new VectorCalles("General Paz","Padre Genesio"), new LatLng(-31.604046,-60.675168));
    	coordenadas.put(new VectorCalles("General Paz","Regimiento 12 de Infantería"), new LatLng(-31.602206,-60.674643));
    	coordenadas.put(new VectorCalles("Echagüe","J.P.López"), new LatLng(-31.613127,-60.672451));
}
    
    public static Double distancia(VectorCalles v1, VectorCalles v2) {
		
    	System.out.println("Vector A "+ v1.toString() + "     Vector B: "+ v2.toString());
    //	 LatLng locationA = coordenadas.get(v1);
    //	 LatLng locationb = coordenadas.get(v2);
    	 
    /*	 	Location locationa = new Location("punto A");
    	    locationA.setLatitude(latA);
    	    locationA.setLongitude(lngA);

    	    Location locationB = new Location("punto B");

    	    locationB.setLatitude(latB);
    	    locationB.setLongitude(lngB);

    	    float distance = locationA.distanceTo(locationB);
    */
    	    
    	    
    	    
    	    
  
    	        int Radius = 6371;// radio de la tierra en  kilÃ³metros
    	        double lat1 = coordenadas.get(v1).getLat();
    	        double lat2 = coordenadas.get(v2).getLng();
    	        double lon1 = coordenadas.get(v1).getLat();
    	        double lon2 = coordenadas.get(v2).getLng();
    	  /*      double dLat = Math.toRadians(lat2 - lat1);
    	        double dLon = Math.toRadians(lon2 - lon1);
    	        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
    	                + Math.cos(Math.toRadians(lat1))
    	                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
    	                * Math.sin(dLon / 2);
    	        double c = 2 * Math.asin(Math.sqrt(a));
    	       double valueResult = Radius * c;
    	        double km = valueResult / 1;
    	        DecimalFormat newFormat = new DecimalFormat("####");
    	        int kmInDec = Integer.valueOf(newFormat.format(km));
    	        double meter = valueResult % 1000;
    	        int meterInDec = Integer.valueOf(newFormat.format(meter));
    	      //  Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
    	       //         + " Meter   " + meterInDec);

    	        
    	        System.out.println("Valor distancia: "+ (Radius * c)/1000);
    	        return (Radius * c)/1000;
    	    
    	    
    	    
    	        if ((lat1 == lat2) && (lon1 == lon2)) {
    				return (double) 0;
    			}
    			else {
    				double theta = lon1 - lon2;
    				double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
    				dist = Math.acos(dist);
    				dist = Math.toDegrees(dist);
    				dist = dist * 60 * 1.1515;
    				System.out.println("Valor distancia: "+ dist);
    				return dist;
    	    */
    	        
    	        double dist = Math.sqrt(((lat1-lat2)*(lat1-lat2))+((lon1-lon2)*(lon1-lon2)));
    	        System.out.println("Valor distancia: "+ dist);
				return dist;
    			
    	       	
    	
 
    	
    }

    }
