package fp.baloncesto;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface IJugadores {
	
	public Boolean existenAllStar();
	
	public Integer contarJugadoresDeEquipo(String equipo);
	
	public Set<Jugador> jugadoresDePosicion(String posicion);
	
	public Map<String, Set<Jugador>> jugadoresPorUniversidad();
	
	public Map<Posiciones, Integer> puntosPorPosicion();
	
	public Boolean existenAllStarStream();
	
	public Integer contarJugadoresDeEquipoStream(String equipo);
	
	public Set<Jugador> jugadoresDePosicionStream(String posicion);
	
	public Integer maximosPuntosEquipo(String equipo);
	
	public SortedSet<Jugador> jugadoresPosicionOrdenadosPuntos(String posicion);
	
	public Map<String, Set<Jugador>> jugadoresPorUniversidadStream();
	
	public Map<Posiciones, Double> mediaPuntosPorPosiciones();
	
	public Map<Posiciones,Integer> maximaEdadPorPosicion();
	
	public SortedMap<String, Set<Jugador>> nMejoresJugadoresPorEquipo(Long n);
	
	public Integer edadMaxima();

}
