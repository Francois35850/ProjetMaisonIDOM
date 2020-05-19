package main;

public abstract class ObjetRamassable extends Objets {
	
	public ObjetRamassable(String nom) {
		super(nom);
	}
	
	public String getNom() {return super.getNom();}

	public String toString() {
		String res = " - ";
		res += super.getNom();
		res += "\n";
		return res;
	}
	
}
