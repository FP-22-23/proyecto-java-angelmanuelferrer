package fp.baloncesto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import fp.utiles.Checkers;

public class FactoriaJugadores {
	public static Jugadores leerJugadores(String nombreFichero){
		Jugadores res=new Jugadores();
		try {
			List<String>líneas=Files.readAllLines(Paths.get(nombreFichero));
			líneas.remove(0);
			for (String línea:líneas) {
				res.añadirJugador(parsearJugador(línea));
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
		}
	
	private static Jugador parsearJugador(String línea){
		String [] trozos=línea.split(";");

		Checkers.check("La cadena no se trocea bien", trozos.length==17);

		String nombre=trozos[0].trim();
		String equipo=trozos[1].trim();
		Posiciones posicion=Posiciones.valueOf(trozos[2].replace("/", "").trim());
		Integer altura=Integer.valueOf(trozos[3].trim());
		Integer peso=Integer.valueOf(trozos[4].trim());
		Double imc=Double.valueOf(trozos[5].trim());
		String pais_nac=trozos[6].trim();
		LocalDate cumpleanyos=LocalDate.parse(trozos[7].trim(), DateTimeFormatter.ofPattern("MMMM d, yyyy", new Locale("en", "US")));
		Integer edad=Integer.valueOf(trozos[8].trim());
		String universidad=trozos[9].trim();
		Boolean allStar=Boolean.valueOf(trozos[10].trim());
		Integer partidos=Integer.valueOf(trozos[11].trim());
		Integer minutos=Integer.valueOf(trozos[12].trim());
		Integer rebotes=Integer.valueOf(trozos[13].trim());
		Integer asistencias=Integer.valueOf(trozos[14].trim()); 
		Integer robos=Integer.valueOf(trozos[15].trim());
		Integer puntos=Integer.valueOf(trozos[16].trim());
		

		
		return new Jugador(nombre, equipo, posicion , altura, peso, imc, pais_nac,
				 cumpleanyos, edad, universidad, allStar, partidos, minutos,
				 rebotes, asistencias, robos, puntos);
}
}

