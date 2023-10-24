package examen.clases;

import java.util.ArrayList;

public class Bolsa {
	private double pesoEstimado;
	private double pesoNeto;
	private ArrayList<Galletita> galletitas;
	// TODO completar ... aca quedan las galletitas de la bolsa;

	public Bolsa(int pesoEstimado) {
		setPesoEstimado(pesoEstimado);
		galletitas = new ArrayList<Galletita>();
	}

	public boolean estaLlena() {
		// TODO implementar, el valor devuelto es solo para que compile
		return pesoEstimado == pesoNeto;
	}

	public void agregar(Galletita galletita) {
		galletitas.add(galletita);
	}

	public boolean estaVacia() {
		// TODO implementar, el valor devuelto es solo para que compile
		return pesoNeto == 0;
	}

	public Galletita extraer() {
		// TODO implementar, el valor devuelto es solo para que compile
		return galletitas.remove(galletitas.size() - 1);
	}

	public double getPesoNeto() {
		return pesoNeto;
	}

	private double getPesoEstimado() {
		return pesoEstimado;
	}

	private void setPesoEstimado(double pesoEstimado) {
		this.pesoEstimado = pesoEstimado;
	}
}