package ejercicio_Objetos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	/**
	 *
	 * 
	 * @author Carlos Rodríguez
	 * @version 1.0
	 * 
	 *          La mayoría de métodos del main tienen un nombre bastante entendible,
	 *          y al leerse pueden entenderse de por si, pero esplicaré algunas
	 *          funcionalidades
	 * 
	 * @param Este codigo trata sobre una carrera contrareloj entre dos personas.
	 *             Primero dará valor a un par de atributos de la clase coche
	 *             preguntando por consola(Nombre de piloto, Marca de coche),
	 *             apartir de ahi se realiza primero una contrareloj para el primer
	 *             piloto y luego para el segundo, una vez finalizada se podran
	 *             consultar los datos de dos formás posibles
	 */
	public static void main(String[] args) {
		// Creo un semáforo de salida, lo dejo en null un par de cosas porque más tarde
		// aprovecho el método para darle valor ya de paso
		Semaforo salida = new Semaforo(args, 5);
		Circuito pista = new Circuito();
		// Presentación y obtencion de datos de los pilotos a competir y creación de los
		// 2 'objetos' pilotos
		System.out.println(
				"Bienvenido a la carrera de coches por contrarreloj entre dos participantes,empecemos con el 1º ¿Cúal es su nombre?");
		String nombrePiloto1 = in.nextLine();
		System.out.println("¿Con qué coche vas a correr?");
		String marcaCoche1 = in.nextLine();
		Coche coche1 = new Coche(nombrePiloto1, marcaCoche1, 100, 20);
		System.out.println("Bienvenido 2º participante ¿Cúal es su nombre?");
		String nombrePiloto2 = in.nextLine();
		System.out.println("¿Con qué coche vas a correr?");
		String marcaCoche2 = in.nextLine();
		Coche coche2 = new Coche(nombrePiloto2, marcaCoche2, 100, 20);
		System.out.println("El circuito ya esta preparado para la carrera, empezaremos con el piloto nº 1 con nombre "
				+ coche1.getPiloto() + " y su coche " + coche1.getMarca() + "\n"
				+ "Colocaremos el coche en el inicio de la pista y empezaremos con el evento.");
		System.out.println(Arrays.toString(pista.getPista()));
		// Representación del semáforo de f1, la siguiente línea explica el
		// funcionamiento
		System.out.println(
				"Pulese 'enter' cuando estes preparado y vuelva a pulsar 'enter' en cuanto se ponga todo el semáforo en verde");
		in.nextLine();
		salida.actualizarSemaforo(" ⚪ ", " 🟢 ");
		// Mediante la siguiente variable se inicia un temporizador que no terminara
		// hasta que haya completado la pista
		long startTimeCoche1 = System.currentTimeMillis();
		in.nextLine();
		// Posicíon del coche para situarlo en la salida(luego he pensado que podría
		// haber sido un atributo de Circuito)
		int posicionCoche1 = 0;
		// La siguiente variable "nuevaPosicionCoche1"obtiene la posición de salida y va
		// a ser la que se pase como parámetro a los métodos de "Circuito" para poder
		// actualizar su posición en la pista(array)
		int nuevaPosicionCoche1 = coche1.aceleracionPrimera(posicionCoche1);
		// Con la siguiente llamada actualizo la posicion del coche en el array
		pista.actualizarSalida(nuevaPosicionCoche1);
		// Imprimo la pista actualizada
		System.out.println(Arrays.toString(pista.getPista()));
		System.out.println("Menudo arranque que ha tenido el piloto: " + coche1.getPiloto() + " ha conseguido avanzar "
				+ nuevaPosicionCoche1 + " metros, a ver que tal se le da la siguiente parte del circuito");
		pista.actualizarCoche(nuevaPosicionCoche1);
		System.out.println(Arrays.toString(pista.getPista()));
		int contador1 = 0;
		// Un while que hará que el coche se mueva hasta que llegue al final de la
		// pista(array)
		while (nuevaPosicionCoche1 < pista.getLongitud()) {
			// Contador para las estadísticas del final
			contador1++;
			nuevaPosicionCoche1 += coche1.avanzarHastaFinal(nuevaPosicionCoche1);
			pista.actualizarCoche(nuevaPosicionCoche1);
			// He impreso el array con una pausa de 100 msg entre cada movimiento del coche
			// asi le da una sensación mayor de videojuego
			try {
				System.out.println(Arrays.toString(pista.getPista()));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		// Variables que consigues obtener los milisegundos que ha tardado en completar
		// la pista, estas se utilizan en las estadísticas del final
		long endTimeCoche1 = System.currentTimeMillis();
		long tiempoTotal = endTimeCoche1 - startTimeCoche1;
		// Llamar al método toString para imprimir las características del piloto 1
		System.out.println("Características del piloto 1" + coche1);
		System.out.println(Arrays.toString(pista.getPista()));
		System.out.println("El piloto " + coche1.getPiloto() + " ha terminado su vuelta a la pista junto con su coche "
				+ coche1.getMarca());
		System.out.println(
				"Ahora vamos a comenzar con el piloto; " + coche2.getPiloto() + " con su coche " + coche2.getMarca());

		System.out.println(
				"Pulese 'enter' cuando estes preparado y vuelva a pulsar 'enter' en cuanto se ponga todo el semáforo en verde");
		in.nextLine();
		salida.actualizarSemaforo(" ⚪ ", " 🟢 ");
		long startTimeCoche2 = System.currentTimeMillis(); // Marcar el tiempo de inicio
		in.nextLine();
		int posicionCoche2 = 0;
		int nuevaPosicionCoche2 = coche2.aceleracionPrimera(posicionCoche2);
		pista.actualizarSalida(nuevaPosicionCoche2);
		System.out.println(Arrays.toString(pista.getPista()));
		System.out.println("Menudo arranque que ha tenido el piloto: " + coche2.getPiloto() + " ha conseguido avanzar "
				+ nuevaPosicionCoche2 + " metros, a ver que tal se le da la siguiente parte del circuito");

		pista.actualizarCoche(nuevaPosicionCoche2);
		System.out.println(Arrays.toString(pista.getPista()));
		int contador2 = 0;
		while (nuevaPosicionCoche2 < pista.getLongitud()) {
			contador2++;
			nuevaPosicionCoche2 += coche2.avanzarHastaFinal(nuevaPosicionCoche2);
			pista.actualizarCoche(nuevaPosicionCoche2);
			try {
				System.out.println(Arrays.toString(pista.getPista()));
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTimeCoche2 = System.currentTimeMillis(); // Marcar el tiempo de finalización
		long tiempoTotal2 = endTimeCoche2 - startTimeCoche2;
		System.out.println("Características del piloto 2" + coche2);
		System.out.println("El piloto " + coche2.getPiloto() + " ha terminado su vuelta a la pista junto con su coche "
				+ coche2.getMarca());

		System.out.println("\n\n¿Como quieres ver el resultado final?\n Esriba el número correspondiente:"
				+ "\n1. Contador creado en el while \n2. System.currentTimeMillis(); \n ");
		String elegir = in.nextLine();
		// He creado un swich para ver las estadísticas de dos formás diferentes,
		// recomiendo la 2º ya que influye también los msg q tardas en dar al enter en
		// el semaforo, mientras que la 1 es solo las veces que se repite cada while
		// hasta llegar al limite de pista
		switch (elegir) {
		case "1":
			if (contador1 < contador2) {
				System.out.println("Ha ganado el piloto: " + coche1.getPiloto() + ", con su coche " + coche1.getMarca()
						+ " y con un tiempo de: " + contador1 + "msg, " + "ha su rival el piloto: " + coche2.getPiloto()
						+ " con su coche " + coche2.getMarca() + " y con un tiempo de: " + /* tiempoTotal2 */contador2
						+ "msg");
			} else if (contador1 > contador2) {
				System.out.println("Ha ganado el piloto: " + coche2.getPiloto() + ", con su coche " + coche2.getMarca()
						+ " y con un tiempo de: " + contador2 + "msg, " + "ha su rival el piloto: " + coche1.getPiloto()
						+ " con su coche " + coche1.getMarca() + " y con un tiempo de: " + contador1 + "msg");
			} else {
				System.out.println("Ha empatado en tiempo el piloto: " + coche1.getPiloto() + " con su coche "
						+ coche1.getMarca() + " y con un tiempo de: " + contador1 + "msg, junto con el piloto: "
						+ coche2.getPiloto() + " con su coche " + coche2.getMarca() + " y con un tiempo de: "
						+ contador2);
			}
			break;

		case "2":
			if (tiempoTotal < tiempoTotal2) {
				System.out.println("Ha ganado el piloto: " + coche1.getPiloto() + ", con su coche " + coche1.getMarca()
						+ " y con un tiempo de: " + tiempoTotal + "msg, " + "ha su rival el piloto: "
						+ coche2.getPiloto() + " con su coche " + coche2.getMarca() + " y con un tiempo de: "
						+ tiempoTotal2 + "msg");
			} else if (tiempoTotal > tiempoTotal2) {
				System.out.println("Ha ganado el piloto: " + coche2.getPiloto() + ", con su coche " + coche2.getMarca()
						+ " y con un tiempo de: " + tiempoTotal2 + "msg, " + "ha su rival el piloto: "
						+ coche1.getPiloto() + " con su coche " + coche1.getMarca() + " y con un tiempo de: "
						+ tiempoTotal + "msg");
			} else {
				System.out.println("Ha empatado en tiempo el piloto: " + coche1.getPiloto() + " con su coche "
						+ coche1.getMarca() + " y con un tiempo de: " + tiempoTotal + "msg, junto con el piloto: "
						+ coche2.getPiloto() + " con su coche " + coche2.getMarca() + " y con un tiempo de: "
						+ tiempoTotal2);
			}
			break;

		}

	}
}
