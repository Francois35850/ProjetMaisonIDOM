package main;

public abstract class Objet {
	String nom;

	public Objet(String nom) {
		this.nom = nom;
	}

	public abstract String etat();

	public String toString() {
		String res = "";
		res += nom + " " + this.etat();
		return res;
	}

}