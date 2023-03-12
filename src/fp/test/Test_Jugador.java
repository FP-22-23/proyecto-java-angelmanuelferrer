package fp.test;

import java.time.LocalDate;

import fp.baloncesto.Jugador;
import fp.baloncesto.Posiciones;

public class Test_Jugador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jugador j1 = new Jugador("Aerial Powers", "Dal", Posiciones.F, 183, 71, 21.20099137, "US", LocalDate.of(1994, 1, 17), 23, 
				"Michigan State", false, 8, 173, 28, 12, 3, 93);
		Jugador j2 = new Jugador("Alana Beard", "Dal", Posiciones.GF, 185, 73, 21.32943755, "US", LocalDate.of(1982, 5, 14), 35, 
				"Duke", true, 30, 947, 101, 72, 63, 217);
		System.out.println(j1);
		System.out.println(j2.getFormatoCadena());
		System.out.println(j1.MismoEquipo(j2));
		System.out.println(j1.compareTo(j2));

	}
}
