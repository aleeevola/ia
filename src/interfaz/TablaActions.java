package interfaz;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


public class TablaActions extends AbstractTableModel{

	private List<String> action=new ArrayList();
	private String[] columnas = {"Acciónes"};
	

	
	public List<String> getTitulares() {
		return action;
	}

	public void setTitulares(List<String> licencias) {
		this.action = licencias;
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
		return this.action.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Object valor = null;
		
		switch(columnIndex) {
		case 0:
			valor = this.action.get(rowIndex);
			break;
		default:
			break;
		}
		return valor;
	}

}
