package fp.baloncesto;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
		
	}