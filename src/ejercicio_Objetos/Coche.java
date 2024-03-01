package ejercicio_Objetos;

import java.util.Random;


public class Coche {
	static Random r = new Random();

	private String piloto;
	private String marca;
	private int velocidadMedia;
	private int aceleracion;

	public Coche(String piloto, String marca, int velocidadMedia, int aceleracion) {
		this.piloto = piloto;
		this.marca = marca;
		this.velocidadMedia = 100;
		this.aceleracion = 4;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public int getVelocidadMedia() {
		return velocidadMedia;
	}

	public void setVelocidadMedia(int velocidadMedia) {
		this.velocidadMedia = velocidadMedia;
	}

	public int getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(int aceleracion) {
		this.aceleracion = aceleracion;
	}
	
	// Método ToString de la clase Coche para pode imprimir el objeto con sus
	// atributos
	@Override
	public String toString() {
		return "Coche [piloto=" + piloto + ", marca=" + marca + ", velocidadMedia=" + velocidadMedia + ", aceleracion="
				+ aceleracion + "]";
	}

	/**
	 * @param Obtiene la <b>posicion</b> del empiece de la carrera
	 * @return Devuelve la <b>nueva posicion</b> actualizada después del arranque,
	 *         esta <b>posicion</b> sera una u ptra dependiendo del número aleatorio
	 *         obtenido
	 */
	public int aceleracionPrimera(int posicion) {
		int numR = r.nextInt(15);
		posicion = numR;
		if (numR < 7) {
			posicion = 3 + getAceleracion();
		} else if (numR < 12) {
			posicion = 6 + getAceleracion();
		} else {
			posicion = 9 + getAceleracion();
		}
		return posicion;
	}

	/**
	 * 
	 * @param recive la <b>posicion</b> actual del coche en el array
	 * @return devuelve la <b>nueva posicion</b> del coche creada mediante la resta de la
	 *         velocidad media y el numero aleatorio entre 90 y 100
	 */
	public int avanzarHastaFinal(int posicion) {
		// Numero aleatorio entre 90 y 100
		int numAleatorio = r.nextInt(90, 100);
		posicion = getVelocidadMedia() - numAleatorio;
		return posicion;
	}

}
