package thp.parcial.clases;

import java.util.ArrayList;

public class Tren {
	private int nroTren;
	private ArrayList<Vagon> vagones;
	
	public Tren(int nroTren) {
		this.nroTren = nroTren;
		vagones = new ArrayList<>();
	}
	
	public void agregarVagones(int cantidad, TipoVagon tipo) {
		for (int i = 0 ; i < cantidad ; i++) {
			vagones.add(new Vagon(tipo));
		}
	}
	
	public int eliminarVagonesVacios() {
		int eliminados = 0;
		int index = 0;
		while (index < vagones.size()) {
			if (vagones.get(index).estaVacio()) {
				vagones.remove(index);
				eliminados++;
			} else {
				index++;
			}
		}
		return eliminados;
	}
	
	public int getNroTren() {
		return nroTren;
	}
	
	public int cantidadVagones() {
		return vagones.size();
	}
	
	public double cargarVagones(double cantidadCarga) {
		int index = 0; 
		while (index < vagones.size() && cantidadCarga > 0) {
			Vagon vagon = vagones.get(index);
			if (!vagon.estaLleno()) {				
				cantidadCarga = vagon.cargarVagon(cantidadCarga);
			}
			index++;
		}
		return cantidadCarga;
	}

	public double capacidadTotal() {
		double capacidadTotal = 0;
		for (Vagon vagon: vagones) {
			capacidadTotal += vagon.capacidadVagon();
		}
		return capacidadTotal;
	}
	
	public double capacidadLibre() {
		double capacidadLibre = 0;
		for (Vagon vagon: vagones) {
			capacidadLibre += vagon.capacidadLibre();
		}
		return capacidadLibre;
	}
	
}