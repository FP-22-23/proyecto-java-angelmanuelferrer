package fp.baloncesto;

import java.time.LocalDate;

import fp.utiles.Checkers;


public class Jugador {

	private String nombre;
	private String equipo;
	private Integer altura;
	private Integer peso;
	private Double imc;
	private String pais_nac;
	private LocalDate cumpleanyos;
	private Integer edad;
	private String universidad;
	
	
	public Jugador(String nombre, String equipo, Posiciones posocion, Integer altura, Integer peso, Double imc,
			String pais_nac, LocalDate cumpleanyos, Integer edad, String universidad) {
		Checkers.checkNoNull(nombre, equipo, posocion, altura, peso, imc,
				pais_nac, cumpleanyos, edad, universidad);
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
	
	

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", equipo=" + equipo + ", altura=" + altura + ", peso=" + peso + ", imc="
				+ imc + ", pais_nac=" + pais_nac + ", cumpleanyos=" + cumpleanyos + ", edad=" + edad + ", universidad="
				+ universidad + ", getEdadActual()=" + getEdadActual() + ", getJoven()=" + getJoven() + "]";
	}
	
	public String getFormatoCadena() {
		return getNombre() +" nacido en "+getPais_nac()+", universidad "+ getUniversidad()+", equipo "+getEquipo()+", "+getEdad()+" años de edad"+"("+getCumpleanyos()+")"+ ", (" + getAltura()+" cm, "+getPeso()+" kg, "+getImc()+")" + "";
	}
		
	
}
