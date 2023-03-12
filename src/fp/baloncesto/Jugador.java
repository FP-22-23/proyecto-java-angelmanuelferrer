package fp.baloncesto;

import java.time.LocalDate;

import fp.utiles.Checkers;


public class Jugador implements Comparable<Jugador>{

	private String nombre;
	private String equipo;
	private Integer altura;
	private Integer peso;
	private Double imc;
	private String pais_nac;
	private LocalDate cumpleanyos;
	private Integer edad;
	private String universidad;
	private Boolean allStar;
	private Integer partidos;
	private Integer minutos;
	private Integer rebotes;
	private Integer asistencias;
	private Integer robos;
	private Integer puntos;
	
	
	
	public Jugador(String nombre, String equipo,Posiciones posicion ,Integer altura, Integer peso, Double imc, String pais_nac,
			LocalDate cumpleanyos, Integer edad, String universidad, Boolean allStar, Integer partidos, Integer minutos,
			Integer rebotes, Integer asistencias, Integer robos, Integer puntos) {
		Checkers.checkNoNull(nombre, equipo, posicion, altura, peso, imc,
				pais_nac, cumpleanyos, edad, universidad, allStar, partidos, minutos, rebotes, asistencias, robos, puntos);
		Checkers.check("La fecha del cumpleaños es posterior a la actual", cumpleanyos.isBefore(LocalDate.now()));
		this.nombre = nombre;
		this.equipo = equipo;
		this.altura = altura;
		this.peso = peso;
		this.imc = imc;
		this.pais_nac = pais_nac;
		this.cumpleanyos = cumpleanyos;
		this.edad = edad;
		this.universidad = universidad;
		this.allStar = allStar;
		this.partidos = partidos;
		this.minutos = minutos;
		this.rebotes = rebotes;
		this.asistencias = asistencias;
		this.robos = robos;
		this.puntos = puntos;
	}


	
	public Jugador(String nombre, Integer altura, Integer peso, Double imc,
			LocalDate cumpleanyos, Integer edad) {
		Checkers.check("La fecha del cumpleaños es posterior a la actual", cumpleanyos.isBefore(LocalDate.now()));
		Checkers.checkNoNull(nombre, altura, peso, imc, cumpleanyos, edad);
		this.nombre = nombre;
		this.equipo = null;
		this.altura = altura;
		this.peso = peso;
		this.imc = imc;
		this.pais_nac = null;
		this.cumpleanyos = cumpleanyos;
		this.edad = edad;
		this.universidad = null;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEquipo() {
		return equipo;
	}


	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public Integer getPeso() {
		return peso;
	}


	public void setPeso(Integer peso) {
		this.peso = peso;
	}


	public Double getImc() {
		return imc;
	}


	public void setImc(Double imc) {
		this.imc = imc;
	}


	public String getPais_nac() {
		return pais_nac;
	}


	public void setPais_nac(String pais_nac) {
		this.pais_nac = pais_nac;
	}


	public LocalDate getCumpleanyos() {
		return cumpleanyos;
	}


	public void setCumpleanyos(LocalDate cumpleanyos) {
		this.cumpleanyos = cumpleanyos;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getUniversidad() {
		return universidad;
	}


	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	public Boolean getAllStar() {
		return allStar;
	}


	public void setAllStar(Boolean allStar) {
		this.allStar = allStar;
	}

	
	public Integer getPartidos() {
		return partidos;
	}


	public void setPartidos(Integer partidos) {
		this.partidos = partidos;
	}


	public Integer getMinutos() {
		return minutos;
	}


	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}


	public Integer getRebotes() {
		return rebotes;
	}


	public void setRebotes(Integer rebotes) {
		this.rebotes = rebotes;
	}


	public Integer getAsistencias() {
		return asistencias;
	}


	public void setAsistencias(Integer asistencias) {
		this.asistencias = asistencias;
	}


	public Integer getRobos() {
		return robos;
	}


	public void setRobos(Integer robos) {
		this.robos = robos;
	}


	public Integer getPuntos() {
		return puntos;
	}


	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}


	public Integer getEdadActual() {
		Integer edad = LocalDate.now().getYear() - getCumpleanyos().getYear() - 1;
		
		if (getCumpleanyos().getMonthValue() < LocalDate.now().getMonthValue()) {
			edad = LocalDate.now().getYear() - getCumpleanyos().getYear();
		}
		else if(getCumpleanyos().getMonthValue() == LocalDate.now().getMonthValue() && getCumpleanyos().getDayOfMonth() <= LocalDate.now().getDayOfMonth()) {
			edad = LocalDate.now().getYear() - getCumpleanyos().getYear();
		}
		return edad;
	}
	
	public Boolean getJoven() {
		Boolean res = false;
		if (getEdad() <= 25) {
			res = true;
		}
		return res;
	}
	
	public Boolean getMismoEquipo(Jugador j) {
		Boolean res = false;
		if (getEquipo().equals(j.equipo)) {
			res = true;
		}
		return res;
	}
	
	public int compareTo(Jugador j) {
		int x;
		x = getPuntos().compareTo(j.getPuntos());
		if (x == 0) {
			x = getAsistencias().compareTo(j.getAsistencias());
			if (x==0) {
				x = getRobos().compareTo(j.getRobos());
				if (x==0) {
					x = getRebotes().compareTo(j.getRebotes());
				}
			}
		}
		return x;
	}
	

	@Override
	public String toString() {
		return "Jugador [getNombre()=" + getNombre() + ", getEquipo()=" + getEquipo() + ", getAltura()=" + getAltura()
				+ ", getPeso()=" + getPeso() + ", getImc()=" + getImc() + ", getPais_nac()=" + getPais_nac()
				+ ", getCumpleanyos()=" + getCumpleanyos() + ", getEdad()=" + getEdad() + ", getUniversidad()="
				+ getUniversidad() + ", getAllStar()=" + getAllStar() + ", getPartidos()=" + getPartidos()
				+ ", getMinutos()=" + getMinutos() + ", getRebotes()=" + getRebotes() + ", getAsistencias()="
				+ getAsistencias() + ", getRobos()=" + getRobos() + ", getPuntos()=" + getPuntos()
				+ ", getEdadActual()=" + getEdadActual() + ", getJoven()=" + getJoven() + "]";
	}


	public String getFormatoCadena() {
		return getNombre() +" nacido en "+getPais_nac()+", universidad "+ getUniversidad()+", equipo "+getEquipo()+", "+getEdad()+" años de edad"+"("+getCumpleanyos()+")"+ ", (" + getAltura()+" cm, "+getPeso()+" kg, "+getImc()+")" + "";
	}
		
	
}
