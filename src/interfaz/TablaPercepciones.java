package interfaz;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class TablaPercepciones extends AbstractTableModel{

	private List<AuxPercepcion> percepciones=new ArrayList();

	private String[] columnas = {"Percepcion","Esquina"};


	
	public List<AuxPercepcion> getPercepciones() {
		return percepciones;
	}

	public void setPercepciones(List<AuxPercepcion> licencias) {
		this.percepciones = licencias;
	}
	
	public String getColumnName(int indice) {
		return this.columnas[indice];
	}
	

	@Override 
	public int getColumnCount() {
		return this.columnas.length;
	}

	@Override
	public int getRowCount() {
		return this.percepciones.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object valor = null;
		
		switch(columnIndex) {
		case 0:

			valor = this.percepciones.get(rowIndex).getPercepcion();
			break;
		case 1:
			valor = this.percepciones.get(rowIndex).getEsquina();
			break;
		default:
			break;
		}
		return valor;
	}

}
