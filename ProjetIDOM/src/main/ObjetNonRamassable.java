package main;

public abstract class ObjetNonRamassable extends Objets {
	boolean utilisationEnCours;

	public ObjetNonRamassable(String nom) {
		super(nom);
		utilisationEnCours = false;
	}

	public abstract String etat();

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public boolean getUtilisation() {return utilisationEnCours;}
	
	public void setUtilisation(boolean use) {this.utilisationEnCours = use;}
	
	public String getNom() {return super.getNom();}
}