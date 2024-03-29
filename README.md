# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor: Ángel Manuel Ferrer Álvarez   uvus:FBG8620


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.baloncesto**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **WNBA Stats.csv**: Archivo csv que contiene datos de diferentes partidas de ajedrez.
    
## Estructura del *dataset*

El dataset original WNBA Player stats Season 2016-2017 se puede obtener de la URL [https://www.kaggle.com/datasets/jinxbe/wnba-player-stats-2017](https://www.kaggle.com/datasets/jinxbe/wnba-player-stats-2017). Originalmente tiene 32 columnas y cada fila contiene datos sobre un jugador de la NBA. El dataset usado en este proyecto tiene 17 columna, 16 se han tomado del dataset original, y una, el allStar, se han generado de forma aleatoria. A continuación se describen las 17 columnas del dataset:

* **name**: de tipo String,  indica el nombre del jugador.
* **team**: de tipo String, indica el equipo del jugador.
* **pos**: de tipo String, indica la posición del jugador.
* **height**: de tipo Integer, contiene la altura del jugador.
* **weight**: de tipo Integer, tiene el peso del jugador.
* **bmi**: de tipo Double, contiene el indice de masa corporal del jugador.
* **birth_place**: de tipo String, tiene el lugar de nacimiento del jugador. 
* **birth_date**: de tipo fecha, contiene la fecha del cumpleaños del jugador.
* **age**: de tipo Integer, indica la edad del jugador.
* **college**: de tipo String. Indica la universidad del jugador.
* **allStar**: de tipo Boolean. Indica si el jugador ha jugado algún all Star.
* **games played**: de tipo Integer, contiene los partidos jugados del jugador.
* **min**: de tipo Integer, contiene los minutos jugados del jugador.
* **reb**: de tipo Integer, contiene el número de rebotes cogidos por el jugador.
* **ast**: de tipo Integer, contiene las asistencias del jugador.
* **stl**: de tipo Integer, contiene los robos de balón del jugador.
* **pts**: de tipo Integer, contiene los puntos metidos por el jugador.




## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Jugador
Representa un jugador de la NBA.
**Propiedades**:

- _nombre_, de tipo _String_, consultable y modificable.  Indica el nombre del jugador.
- _equipo_, de tipo _String_, consultable y modificable. Indica el equipo del jugador.
- _posicion_, de tipo _Posiciones_, consultable y modificable. Indica la posición del jugador.
- _altura_, de tipo _Integer_, consultable y modificable. Contiene la altura del jugador.
- _peso_, de tipo _Integer_, consultable y modificable. Tiene el peso del jugador.
- _imc_, de tipo _Double_, consultable y modificable. Contiene el indice de masa corporal del jugador.
- _paisnac_, de tipo _String_, consultable y modificable. Tiene el lugar de nacimiento del jugador. 
- _cumpleanyos_, de tipo _LocalDate_, consultable y modificable. Contiene la fecha del cumpleaños del jugador.
- _edad_, de tipo _Integer_, consultable y modificable. Indica la edad del jugador.
- _universidad_, de tipo _String_, consultable y modificable. Indica la universidad del jugador
- _allStar_, de tipo _Boolean_, consultable y modificable. Indica si el jugador ha jugado algún all Star.
- _partidos_, de tipo _Integer_, consultable y modificable. Contiene los partidos jugados del jugador.
- _minutos_, de tipo _Integer_, consultable y modificable. Contiene los minutos jugados del jugador.
- _rebotes_, de tipo _Integer_, consultable. Contiene el número de rebotes cogidos por el jugador.
- _asistencias_, de tipo _Integer_, consultable y modificable. Contiene las asistencias del jugador.
- _robos_, de tipo _Integer_, consultable y modificable.  Contiene los robos de balón del jugador.
- _puntos_, de tipo _Integer_, consultable y modificable.  Contiene los puntos metidos por el jugador.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Jugador``` a partir de los siguientes parámetros: ```String nombre, Integer altura, Integer peso, Double imc, LocalDate cumpleanyos, Integer edad```.

**Restricciones**:
 
- R1: No puede haber ningun parámetro con valor nulo.
- R2: El cumpleaños no puede ser posterior a la fecha actual.

***Criterio de igualdad**: Dos jugadores estan en el mismo equipo si sus equipos son iguales.

**Criterio de orden natural**: Compara los puntos de dos jugadores, si estos son iguales compara las asistencias, si también son iguales compara los robos y si también son iguales compara los rebotes.

#### Tipos auxiliares

- Estadisticas, record. Contiene las siguientes propiedades: -rebotes, tipo Integer.-asistencias, tipo Integer.-robos, tipo Integer.-puntos, tipo Integer.

**Otras operaciones**:
- _Integer edadActual()_: Devuelve la edad actual del jugador.
- _Boolean Joven()_: Devuelve true si la edad actual del jugador es menor o igual a 25.

### Factoría - FactoriaJugadores
Clase de factoría pra construir objetos de tipo Jugadores.
- Jugadores leerJugadores(String nomfich): Crea un objeto de tipo Jugadores a partir de los datos del csv.

### Tipo Contenedor - Jugadores
Clase contenedora de los objetos de tipo Jugador.

**Propiedades**:
- jugadores, de tipo Set<Jugador>, consultable. Conjunto de Jugadores.

**Constructores**: 
- C1: Constructor por defecto. Creal un objeto de tipo Jugadores sin ningun jugador almacenado.
- C2: Constructor con un parámetro de tipo Set<Jugador>. Crea un objeto de tipo Jugadores con los jugadores incluidos en el conjunto dado como parámetro.

**Criterio de igualdad**: Dos jugadores son iguales si lo son sus propiedades jugadores.

**Otras operaciones**:

- void numeroElementos(): Devuelve el número de jugadores.
- void añadirJugador(Jugador jugador): Añade el jugador a jugadores.
- void añadirColeccionElementos(Collection<Jugador> coleccion): Añade todos los jugadores de la colección a jugadores.
- void eliminarElemento(Jugador j): Elimina el Jugador j de los jugadores.
- Boolean existenAllStar(): Devuelve true si el objeto Jugadores contiene algún Jugador con allStar true.
- Integer contarJugadoresDeEquipo(String equipo): Devuelve el número de jugadores que contiene el objeto Jugadores que estan en ese equipo.
- Set<Jugador> jugadoresDePosicion(String posicion): Devuelve los jugadores que tienen esa posición.
- Map<String, Set<Jugador>> jugadoresPorUniversidad(): Devuelve un map en el que las claves son las universidades y los valores los jugadores que pertenecen a esas universidades.
- Map<Posiciones, Integer> puntosPorPosicion(): Devuelve un map en el que las claves son las posiciones y los valores el total de puntos marcados por esas posiciones.
- Boolean existenAllStarStream(): Lo mimo que esxistenAllStar() pero con Streams.
- Integer contarJugadoresDeEquipoStream(String equipo): Lo mismo que contarJugadoresDeEquipo(String equipo) pero con Streams.
- Set<Jugador> jugadoresDePosicionStream(String posicion): Lo mismo que jugadoresDePosicion(String posicion) pero con Streams.
- Integer maximosPuntosEquipo(String equipo): Devuelve los maximos puntos de un equipo dado.
- SortedSet<Jugador> jugadoresPosicionOrdenadosPuntos(String posicion): Devuelve un SortedSet del tipo base con los jugadores de la posición dada ordenados segun los puntos.
- Map<String, Set<Jugador>> jugadoresPorUniversidadStream(): Hace lo mismo que jugadoresPorUniversidad pero usando Streams.
- Map<Posiciones, Double> mediaPuntosPorPosiciones(): Crea un Map donde las claves son las posiciones y los valores son la media de los puntos que marcan todos los jugadores de esa posición.
- Map<Posiciones,Integer> maximaEdadPorPosicion(): Crea un Mao donde las claves son las posiciones y los valores la mayor edad de un jugador con esa posición.
- SortedMap<String, Set<Jugador>> nMejoresJugadoresPorEquipo(Long n): Crea un SortedMap donde las claves son los equipos y los valores una colección de los n mejores jugadores valorando primero los puntos, luego las asistencias, luego los robos y por último los rebotes.
- edadMaxima(): Devuelve la edad máxima de todas las posiciones utilizando un Map ya creado anteriormente.


