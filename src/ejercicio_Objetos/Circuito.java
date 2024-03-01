package ejercicio_Objetos;

import java.util.Arrays;

public class Circuito {
	private String representacionCoche;
	private int longitud;
	private String[] pista;

	//Constructor
	public Circuito() {
		this.representacionCoche = "🚗";
		this.longitud = 60;
		this.pista = new String[longitud];
		Arrays.fill(this.pista, "__");
		this.pista[0] = representacionCoche;
	}

	//Getters y Setters
	public String getrepresentacionCoche() {
		return representacionCoche;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String[] getPista() {
		return pista;
	}

	public void setPista(String[] pista) {
		this.pista = pista;
	}
	/**
	 * Este método solamente se utiliza al comenzar la contrareloj, pues es solo para la salida
	 * @param Pasa por parámetro la poscion del coche que es la primera del array y lo actualiza en el array de la pista
	 */
	public void actualizarSalida(int posicion) {
		pista[0] = "__";
		pista[posicion] = "🚗";
	}

	// Método ToString de la clase Circuito para pode imprimir el objeto con sus
	// atributos
	@Override
	public String toString() {
		return "Circuito [representacion=" + representacionCoche + ", longitud=" + longitud + ", pista="
				+ Arrays.toString(pista) + "]";
	}

	/**
	 * Este método actualiza el emoticono del coche en la pista(array) y vuelve a
	 * dejar por defecto los demás espacios en "__", se asegura de que el coche no
	 * supere el límite de la pista
	 * 
	 * @param recibe por parámetro la poscion nueva del coche, la posicion que
	 *               recive es la suma de todas las posiciones, así puedo asegurarme
	 *               cuando superará el límite de la pista
	 * 
	 */
	public void actualizarCoche(int posicion) {
		boolean encontrado = false;
		// While para poder salir del for una vez se encuentre el coche en la pista y
		// restablecer el valor donde estaba por el "__"
		while (!encontrado) {
			for (int i = 0; i < pista.length; i++) {
				if (pista[i].equals(representacionCoche)) {
					pista[i] = "__";
					encontrado = true;
				}
			}
		}
		// Actualizamos la posicion del coche si esa posicion es menor a la longitud
		if (posicion < getLongitud()) {
			pista[posicion] = representacionCoche; // Actualizar la posición del coche
		} else {
			pista[pista.length - 1] = representacionCoche; // Actualizar la posición del coche
		}

	}
	
}
