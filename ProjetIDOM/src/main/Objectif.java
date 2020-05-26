package main;

public class Objectif {

	private String nom;
	private boolean succes, displayed;

	public Objectif(String nom, boolean succes) {
		this.nom = nom;
		this.succes = succes;
		this.displayed = false;
	}

	public void setSucces(boolean s) {
		this.succes = s;
		if (s)
			this.displaySucces();
	}

	public boolean estRempli() {
		return this.succes;
	}

	public String getNom() {
		return this.nom;
	}

	public String toString() {
		return this.nom;
	}

	private void displaySucces() {
		if (!this.displayed)
			System.out.println("Vous avez rempli l'objectif : " + this.toString() + " !");
		this.displayed = true;
	}

}