package thp.parcial.clases;

import java.util.ArrayList;

public class Ferroviaria {
	private static final int LARGO_MAXIMO = 30;
	
	private int ultimoNro;
	private ArrayList<Tren> trenes;
	
	public Ferroviaria() {
		ultimoNro = 0;
		trenes = new ArrayList<>();
	}
	
	private Tren buscarTren(int nroTren) {
		Tren buscado = null;
		int index = 0;
		while (index < trenes.size() && buscado == null) {
			if (trenes.get(index).getNroTren() == nroTren) {
				buscado = trenes.get(index);
			}
			index++;
		}
		return buscado;
	}
	
	public int crearFormacion() {
		int nroTren = ++ultimoNro;
		trenes.add(new Tren(nroTren));
		return nroTren;	 
	}
	
	public Resultado agregarVagones(int nroTren, int cantNuevosVagones, TipoVagon tipoVagon) {
		Resultado resultado = Resultado.CANT_VAGONES_INVALIDA;
		if (cantNuevosVagones > 0 && cantNuevosVagones <= LARGO_MAXIMO) {
			Tren tren = buscarTren(nroTren);
			if (tren == null) {
				resultado = Resultado.NO_EXISTE_TREN;
			} else if (tren.cantidadVagones() + cantNuevosVagones <= LARGO_MAXIMO) {
				tren.agregarVagones(cantNuevosVagones, tipoVagon);
				resultado = Resultado.AGREGADO_OK;
			}
		}
		return resultado;
	}
	
	public boolean cargarTren(int nroTren, double cantidadCarga) {
		boolean pudoCargar = false;
		if (cantidadCarga > 0) {
			Tren tren = buscarTren(nroTren);
			if (tren != null && tren.capacidadLibre() >= cantidadCarga) {
				tren.cargarVagones(cantidadCarga);
				pudoCargar = true;			
			}
		}
		return pudoCargar;
	}
	
	public int sacarVagonesVacios(int nroTren) {
		int vagonesEliminados = -1;
		Tren tren = buscarTren(nroTren);
		if (tren != null) {
			vagonesEliminados = tren.eliminarVagonesVacios();
		}
		return vagonesEliminados;
	}
	
	public void listarCapacidadDisponible() {
		if (trenes.size() > 0) {
			System.out.println("Capacidad Disponible en Cada Tren:");
			for (Tren tren : trenes) {
				double porcentaje = 100.0 * tren.capacidadLibre() / tren.capacidadTotal();
				System.out.println("Tren: " + tren.getNroTren()
						+ "  Espacio Libre: " + String.format("%.2f", porcentaje) + "%");
			}
		}
		else {
			System.out.println("No hay trenes cargados.");
		}
	}

}