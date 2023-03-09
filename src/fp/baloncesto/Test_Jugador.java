package fp.baloncesto;

import java.time.LocalDate;
public class Test_Jugador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jugador j = new Jugador("Aerial Powers", "Dal", Posiciones.F, 183, 71, 21.20099137, "US", LocalDate.of(1994, 1, 17), 23, "Michigan State");
		System.out.println(j);
		System.out.println(j.getFormatoCadena());
	}
}
