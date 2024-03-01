package ejercicio_Objetos;

import java.util.Arrays;
import java.util.Random;

public class Semaforo {
	
	//Atributos
	private String[] lucesSemaforo;
	private int longitudSemaforo;
	
	//Constructor
	public Semaforo( String[] lucesSemaforo, int longitudLuces) {
		this.longitudSemaforo = 5;
		this.lucesSemaforo = new String[longitudLuces];
		Arrays.fill(this.lucesSemaforo, "__");
	}

	//Getters y Setters

	public String[] getLucesSemaforo() {
		return lucesSemaforo;
	}

	public void setLucesSemaforo(String[] lucesSemaforo) {
		this.lucesSemaforo = lucesSemaforo;
	}

	public int getlongitudSemaforo() {
		return longitudSemaforo;
	}

	public void setlongitudSemaforo(int longitudLuces) {
		this.longitudSemaforo = longitudLuces;
	}

	/**
	 * He querido representar unsemáforo de la F1
	 * 
	 * @param colorApagado   String de un emoticono que representa el semáforo
	 *                       apagado
	 * @param colorEncendido String de un emoticono que representa el semáforo
	 *                       encendido He estado haciendo pruebas con los emoticones
	 *                       de las luces, al final lo he utilizado como parámetros
	 *                       para cambiarlo más comodamente desde el Main
	 * 
	 *                       No devuelve nada puesto que al final la funcionalidad
	 *                       es verlo por pantalla
	 * 
	 */
	public void actualizarSemaforo(String colorApagado, String colorEncendido) {
		Random r = new Random();
		//El primer for sirve para las luces "rojas" del semáforo
		for (int i = 0; i < lucesSemaforo.length; i++) {
			// Quería ver como puedo imprimir algo por pantalla pero teniendo una espera, y
			// gpt me ha sorprendido con este código tan sencillo de entender
			try {
				lucesSemaforo[i] = colorApagado;
				System.out.print(lucesSemaforo[i]);
				Thread.sleep(600); // Cada línea del codigo en el try tarda 6100 milisegundos en ejecutarse
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		try {
			System.out.println();
			Thread.sleep(r.nextInt(800, 2200)); // Al ser un semáforo de f1 nunca tiene una cifra exacta de tiempo en la
												// que se pone todo el semáforo en verde
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Con el siguiente for se muestran las luces "verdes" a la vez
		for (int i = 0; i < lucesSemaforo.length; i++) {
			lucesSemaforo[i] = colorEncendido;
			System.out.print(lucesSemaforo[i]);
		}
	}
	
}
