package anagrafica;

import java.time.LocalDate;

public class Bimbo {
	private String nome,cognome,cf,luogoNascita;
	private LocalDate Birthday;

	public Bimbo(String nome, String cognome, String cf, String luogo, LocalDate anno) {
	this.nome = nome;
	this.cognome= cognome;
	this.cf = cf;
	this.luogoNascita = luogo;
	this.Birthday = anno;
	}

	public Bimbo() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public LocalDate getBirthday() {
		return Birthday;
	}

	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}

}
