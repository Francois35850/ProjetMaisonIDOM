package main;

public abstract class Objets {

	private String nom;
	
	public Objets(String nom) {
		this.nom = nom;
	}
	
	public abstract void utiliserObjet();
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String newNom) {
		this.nom = newNom;
	}
}
