package fp.baloncesto;

import java.util.Map;
import java.util.Set;

public interface IJugadores {
	
	public Boolean existenAllStar();
	
	public Integer contarJugadoresDeEquipo(String equipo);
	
	public Set<Jugador> jugadoresDePosicion(String posicion);
	
	public Map<String, Set<Jugador>> jugadoresPorUniversidad();
	
	public Map<Posiciones, Integer> puntosPorPosicion();
	
}
