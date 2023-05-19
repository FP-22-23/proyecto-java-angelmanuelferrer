package fp.test;

import fp.baloncesto.FactoriaJugadores;
import fp.baloncesto.Jugadores;

public class Test_Jugadores {
	public static void main(String[] args) {
		Jugadores jugadores = testLeerJugadores("data/WNBA Stats.csv");
		
		// Entrega II
		/*
		System.out.println("\ntestExistenAllStar");
		System.out.println("================================");
		testExistenAllStar(jugadores); 
		
		System.out.println("\ntestContarJugadoresDeEquipo");
		System.out.println("================================");
		testContarJugadoresDeEquipo(jugadores,"MIN"); 
		
		System.out.println("\ntestJugadoresDePosicion");
		System.out.println("================================");
		testJugadoresDePosicion(jugadores,"GF"); 
		
		System.out.println("\ntestJugadoresPorUniversidad");
		System.out.println("================================");
		testJugadoresPorUniversidad(jugadores); 
		
		System.out.println("\ntestPuntosPorPosicion");
		System.out.println("================================");
		testPuntosPorPosicion(jugadores); 
		*/
		
		//Entrega III
		
		/*
		System.out.println("\ntestExistenAllStarStream");
		System.out.println("================================");
		testExistenAllStarStream(jugadores); 
		
		System.out.println("\ntestContarJugadoresDeEquipoStream");
		System.out.println("================================");
		testContarJugadoresDeEquipoStream(jugadores,"MIN"); 
		
		System.out.println("\ntestJugadoresDePosicionStream");
		System.out.println("================================");
		testJugadoresDePosicionStream(jugadores,"GF"); 
		
		System.out.println("\ntestMaximosPuntosEquipo");
		System.out.println("================================");
		testMaximosPuntosEquipo(jugadores,"MIN"); 
		
		System.out.println("\ntestJugadoresPosicionOrdenadosPuntos");
		System.out.println("================================");
		testJugadoresPosicionOrdenadosPuntos(jugadores,"F"); 
		
		System.out.println("\ntestJugadoresPorUniversidadStream");
		System.out.println("================================");
		testJugadoresPorUniversidadStream(jugadores); 
		
		System.out.println("\ntestPuntosPorPosicionStream");
		System.out.println("================================");
		testPuntosPorPosicionStream(jugadores); 

		System.out.println("\ntestMediaPuntosPorPosiciones");
		System.out.println("================================");
		testMediaPuntosPorPosiciones(jugadores); 
		
		System.out.println("\ntestMaximaEdadPorPosicion");
		System.out.println("================================");
		testMaximaEdadPorPosicion(jugadores); 
		
		System.out.println("\ntestNMejoresJugadoresPorEquipo");
		System.out.println("================================");
		testNMejoresJugadoresPorEquipo(jugadores, 3L); 
		
		System.out.println("\ntestEdadMaxima");
		System.out.println("================================");
		testEdadMaxima(jugadores); 
		*/
		
		
		
	}
	
	
	public static Jugadores testLeerJugadores(String fichero) {
		Jugadores jugadores = FactoriaJugadores.leerJugadores(fichero);
		return jugadores;
	}
	
	
	
	private static void testExistenAllStar(Jugadores jugadores) {
		try {
			String msg = String.format(
					"¿existen jugadores del ALL STAR? \n%s", 
					jugadores.existenAllStar());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testContarJugadoresDeEquipo(Jugadores jugadores, String equipo) {
		try {
			String msg = String.format(
					"Hay %d del equipo %s", 
					jugadores.contarJugadoresDeEquipo(equipo), equipo);
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testJugadoresDePosicion(Jugadores jugadores, String p) {
		try {
			String msg = String.format(
					"Los jugadores de la posicion %s son: \n%s",
					p ,jugadores.jugadoresDePosicion(p));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testJugadoresPorUniversidad(Jugadores jugadores) {
		try {
			String msg = String.format(
					"Jugadores ordenados por universidad: \n%s",
					jugadores.jugadoresPorUniversidad());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testPuntosPorPosicion(Jugadores jugadores) {
		try {
			String msg = String.format(
					"Los puntos por posicion son: \n%s",
					jugadores.jugadoresPorUniversidad());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	

	
	
	private static void testExistenAllStarStream(Jugadores jugadores) {
		try {
			String msg = String.format(
					"¿existen jugadores del ALL STAR? \n%s", 
					jugadores.existenAllStarStream());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testContarJugadoresDeEquipoStream(Jugadores jugadores, String equipo) {
		try {
			String msg = String.format(
					"Hay %d del equipo %s", 
					jugadores.contarJugadoresDeEquipoStream(equipo), equipo);
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testJugadoresDePosicionStream(Jugadores jugadores, String p) {
		try {
			String msg = String.format(
					"Los jugadores de la posicion %s son: \n%s",
					p ,jugadores.jugadoresDePosicionStream(p));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testMaximosPuntosEquipo(Jugadores jugadores, String p) {
		try {
			String msg = String.format(
					"Los maximos puntos del equipo %s son: \n%s",
					p ,jugadores.maximosPuntosEquipo(p));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testJugadoresPosicionOrdenadosPuntos(Jugadores jugadores, String p) {
		try {
			String msg = String.format(
					"Los jugadoresde la posicion %s ordenados según los puntos son: \n%s",
					p ,jugadores.jugadoresPosicionOrdenadosPuntos(p));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testJugadoresPorUniversidadStream(Jugadores jugadores) {
		try {
			String msg = String.format(
					"Jugadores ordenados por universidad: \n%s",
					jugadores.jugadoresPorUniversidadStream());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testPuntosPorPosicionStream(Jugadores jugadores) {
		try {
			String msg = String.format(
					"Los puntos por posicion son: \n%s",
					jugadores.jugadoresPorUniversidadStream());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testMediaPuntosPorPosiciones(Jugadores jugadores) {
		try {
			String msg = String.format(
					"La media de puntos por posicion es: \n%s",
					jugadores.mediaPuntosPorPosiciones());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testMaximaEdadPorPosicion(Jugadores jugadores) {
		try {
			String msg = String.format(
					"La mayor edad por posicion es: \n%s",
					jugadores.maximaEdadPorPosicion());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testNMejoresJugadoresPorEquipo(Jugadores jugadores, Long n) {
		try {
			String msg = String.format(
					"Los mejores %d jugadores de cada equipo son: \n%s",
					n,jugadores.nMejoresJugadoresPorEquipo(n));
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	private static void testEdadMaxima(Jugadores jugadores) {
		try {
			String msg = String.format(
					"La mayor edad de todas las posiciones es: \n%s",
					jugadores.edadMaxima());
			System.out.println(msg);
		} catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}		
	}
	
	
	
	
	
	
	
}

	

