package fp.baloncesto;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Jugadores implements IJugadores{
	
		//Atributos
		
		private Set<Jugador> jugadores;
		
		
		
		//Constructores
		 
		
		public Jugadores() {
			this.jugadores = new HashSet<Jugador>();
		}
		
		public Jugadores(Set<Jugador> jugadores) {
			this.jugadores = jugadores;
		}
		
		public Jugadores(Stream<Jugador> stream) {
			this.jugadores = stream.collect(Collectors.toSet());
		}
		
		
		// Criterio de igualdad y representación como cadena
		
		
		@Override
		public int hashCode() {
			return Objects.hash(jugadores);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Jugadores other = (Jugadores) obj;
			return Objects.equals(jugadores, other.jugadores);
		}
		

		public String toString() {
			return "Jugadores [jugadores=" + jugadores + "]";
		}

		
		
		
		// Métodos 
		
		// Bucles
		
		public void numeroElementos() {
			this.jugadores.size();
		}
		
		public void añadirJugador(Jugador jugador) {
			this.jugadores.add(jugador);
		}
		
		public void añadirColeccionElementos(Collection<Jugador> coleccion) {
			this.jugadores.addAll(coleccion);
		}
		
		public void eliminarElemento(Jugador j) {
			this.jugadores.remove(j);
		}

		public Boolean existenAllStar() {
			Boolean res = false;
			for (Jugador jugador:jugadores) {
				if(jugador.getAllStar() == true) {
					res = true;
					break;
				}
			}
			return res;
		}

		public Integer contarJugadoresDeEquipo(String equipo) {
			Integer contador = 0;
			for (Jugador jugador:jugadores) {
				if(jugador.getEquipo().equals(equipo)) {
					contador++;
				}
			}
			return contador;
		}

		public Set<Jugador> jugadoresDePosicion(String posicion) {
			Set<Jugador> seleccionados = new HashSet<Jugador>();
			for (Jugador jugador:jugadores) {
				if (jugador.getPosicion().toString().equals(posicion)) {
					seleccionados.add(jugador);
				}
			}
			return seleccionados;
		}

		public Map<String, Set<Jugador>> jugadoresPorUniversidad() {
			Set<Jugador> seleccionados = new HashSet<Jugador>();
			Map<String, Set<Jugador>> res = new HashMap<>();
			for(Jugador jugador:jugadores) {
				if (res.containsKey(jugador.getUniversidad())) {
					seleccionados = res.get(jugador.getUniversidad());
					seleccionados.add(jugador);
					res.put(jugador.getUniversidad(), seleccionados);
				}
				else{
					seleccionados.clear();
					seleccionados.add(jugador);
					res.put(jugador.getUniversidad(), seleccionados);
				}
			}
			return res;
		}

		public Map<Posiciones, Integer> puntosPorPosicion() {
			Integer puntos = 0;
			Map<Posiciones, Integer> res = new HashMap<>();
			for(Jugador jugador:jugadores) {
				if(res.containsKey(jugador.getPosicion())) {
					puntos = res.get(jugador.getPosicion()) + jugador.getPuntos();
					res.put(jugador.getPosicion(), puntos);
				}
				else {
					res.put(jugador.getPosicion(), jugador.getPuntos());
				}
			}
			return res;
		}
		
		
		// Streams
		
		public Boolean existenAllStarStream() {
			Boolean res = true;
			jugadores.stream()
			.anyMatch(x-> x.getAllStar().equals(true));
			return res;
		}
		
		public Integer contarJugadoresDeEquipoStream(String equipo) {
			Long res = jugadores.stream()
					.filter(t-> t.getEquipo().equals(equipo))
					.count();
			return res.intValue();
		}
		
		public Set<Jugador> jugadoresDePosicionStream(String posicion) {
			return jugadores.stream()
					.filter(t-> t.getPosicion().toString().equals(posicion))
					.collect(Collectors.toSet());
		}
		
		public Integer maximosPuntosEquipo(String equipo) {
			return jugadores.stream()
					.filter(t-> t.getEquipo().equals(equipo))
					.max(Comparator.comparing(Jugador::getPuntos))
					.get().getPuntos();
		}
		
		public SortedSet<Jugador> jugadoresPosicionOrdenadosPuntos(String posicion) {
		    Comparator<Jugador> cmp = Comparator.comparing(Jugador::getPuntos)
		            .thenComparing(Comparator.naturalOrder()).reversed();
		    return jugadores.stream()
		            .filter(t -> t.getPosicion().toString().equals(posicion))
		            .collect(Collectors.toCollection(() -> new TreeSet<>(cmp)));
		}

		
		
		public Map<String, Set<Jugador>> jugadoresPorUniversidadStream() {
			return jugadores.stream()
					.collect(Collectors.groupingBy(
							Jugador::getUniversidad,
							Collectors.mapping(Function.identity(), Collectors.toSet())));
		}
		
		public Map<Posiciones, Double> mediaPuntosPorPosiciones(){
			return jugadores.stream()
					.collect(Collectors.groupingBy(Jugador::getPosicion, Collectors.collectingAndThen(Collectors.toList(), x-> x.stream()
							.mapToDouble(Jugador::getPuntos).average().getAsDouble())));
		}
		
		public Map<Posiciones,Integer> maximaEdadPorPosicion(){
			
			return jugadores.stream()
					.collect(Collectors.groupingBy(Jugador::getPosicion, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(
							Jugador::getEdad)), x-> x.get().getEdad())));		
		}
		
		public SortedMap<String, Set<Jugador>> nMejoresJugadoresPorEquipo(Long n){
			Comparator<Jugador> cmp = Comparator.comparingInt(Jugador::getPuntos)
					.thenComparingInt(Jugador::getAsistencias)
				    .thenComparingInt(Jugador::getRobos)
				    .thenComparingInt(Jugador::getRebotes);

			return jugadores.stream()
					.collect(Collectors.groupingBy(Jugador::getEquipo,TreeMap::new,Collectors.collectingAndThen(
							Collectors.toList(), x-> x.stream().sorted(cmp.reversed()).limit(n).collect(Collectors.toSet()))));
							
		}
		public Integer edadMaxima() {
			Map<Posiciones,Integer> aux = maximaEdadPorPosicion();
			return aux.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
			
		}
		
		
	}