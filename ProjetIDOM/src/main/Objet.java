package main;

public abstract class Objet {
	String nom;
	boolean utilisationEnCours;
	boolean ramasserPos;

	public Objet(String nom, boolean ramasserPos) {
		this.nom = nom;
		this.ramasserPos = ramasserPos;
		utilisationEnCours = false;
	}
	
	public void ramasser() {
		if (ramasserPos) {
			Joueur.addInventaire(this);
			Joueur.getPieceCourante().soustractObjets(this);
		}
		else {
			System.out.println("Vous ne pouvez pas ramasser cet objet");
		}
	}

	public abstract String etat();

	public String toString() {
		String res = "";
		res += nom + " " + this.etat();
		return res;
	}
	
	public abstract void utiliserObjet();
	
	public boolean getUtilisation() {return utilisationEnCours;}
	
	public void setUtilisation(boolean use) {this.utilisationEnCours = use;}
	
	public String getNom() {return nom;}
}