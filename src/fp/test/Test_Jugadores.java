package fp.test;

import fp.baloncesto.FactoriaJugadores;
import fp.baloncesto.Jugadores;

public class Test_Jugadores {
	public static void main(String[] args) {
		testLeerJugadores("data/WNBA Stats.csv");
	}
	
	
	public static void testLeerJugadores(String fichero) {
		Jugadores jugadores = FactoriaJugadores.leerJugadores(fichero);
		System.out.println(jugadores);
		//System.out.println("Test existen jugadores del ALL STAR \n" + jugadores.existenAllStar());
		//System.out.println("Test contar jugadores del Minnesota Timberwolves \n" + jugadores.contarJugadoresDeEquipo("MIN"));
		//System.out.println("Test jugadores de la posición GF \n" + jugadores.jugadoresDePosicion("GF"));
		//System.out.println("Test jugadores por universidad \n"+jugadores.jugadoresPorUniversidad());
		//System.out.println("Test puntos por posicion \n"+jugadores.puntosPorPosicion());
	}

}

	

