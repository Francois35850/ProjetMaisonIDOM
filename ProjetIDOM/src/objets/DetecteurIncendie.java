package objets;

import main.ObjetNonRamassable;

public class DetecteurIncendie extends ObjetNonRamassable {

	private int etat;
	private int pile;

	public DetecteurIncendie(String nom, int etat, int pile) {
		super(nom);
		this.etat = etat;
		this.pile = pile;
	}

	public String etat() {
		String res = "";
		if (this.etat == 1) {
			res += " : incendie en cours";
		} else {
			res += " : pas de fumée";
		}
		return res + "\n";
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public void setEtat(int use) {
		this.etat = use;
	}

	public void getBatterie() {
		if (this.pile == 0) {
			System.out.println("Batterie du détecteur incendie vide");
		} else {
			System.out.println("Batterie du détecteur incendie pleine");
		}
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub

	}

}
