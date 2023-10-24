package examen.clases;

import java.util.ArrayList;

public class FabricaDeGalletitas {

	private static final int TANDA = 10000;
	private static final int GRAMOS_TOTALES = 500;
	private ArrayList<Galletita> galletitasFabricadas;
	private ArrayList<Bolsa> bolsas;

	public FabricaDeGalletitas() {
		galletitasFabricadas = new ArrayList<>();
		bolsas = new ArrayList<Bolsa>();
		fabricarGalletitas();
	}

	private void fabricarGalletitas() {
		for (int g = 0; g < TANDA; g++) {
			galletitasFabricadas.add(new Galletita());
		}
	}

	public void envasar() {
	    int i = 0;
	    int size = galletitasFabricadas.size();

	    while (i < size) {
	        Bolsa b = new Bolsa(GRAMOS_TOTALES);

	        do {
	            embolsar(b, galletitasFabricadas.get(i));
	         
	            i++;
	        } while (b.estaVacia() && i < size);
	        estivar(b);
	    }
	    informarResultados(obtenerPesoRealPromedio()); 
	}

	private void estivar(Bolsa bolsa) {
		bolsas.add(bolsa);
	}

	private void embolsar(Bolsa bolsa, Galletita galletita) {
		bolsa.agregar(galletita);
	}

	public void informarResultados(double grDescartado) {
		System.out.println("Total Bolsas: " + bolsas.size());
		System.out.printf("Peso promedio real Galletitas x Bolsa: %6.2f0\n", obtenerPesoRealPromedio());
		System.out.printf("Kilos de descarte: %5.2f", grDescartado / 1000);
	}

	private double obtenerPesoRealPromedio() {
		// TODO implementar, el valor devuelto es solo para que compile
		// ESTA MAAAAAL
		double suma = 0, promedio = 0;
		for (int i = 0; i < bolsas.size(); i++) {
			suma += bolsas.get(i).getPesoNeto();
			i++;
			promedio = suma / i;
		}

		return promedio;
	}

}