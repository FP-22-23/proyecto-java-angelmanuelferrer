package fp.test;

import fp.baloncesto.FactoriaJugadores;
import fp.baloncesto.Jugadores;

public class Test_Factoria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLeerJugadores("data/WNBA Stats.csv");
	}
	
	public static void testLeerJugadores(String fichero) {
		System.out.println("TestLeerJugadores:");
		Jugadores jugadores = FactoriaJugadores.leerJugadores(fichero);
		System.out.println(jugadores);
	}
}
