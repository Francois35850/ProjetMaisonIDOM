package main;

public abstract class Objet {
	String nom;
	boolean ramasserPos;

	public Objet(String nom) {
		this.nom = nom;
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
}