package objets;

import main.ObjetNonRamassable;
import objets.Fenetre;

public class DetecteurOuverture extends ObjetNonRamassable {

	private boolean ouverture;
	private Fenetre fenetre;

	public DetecteurOuverture(String nom, boolean ouverture, Fenetre fenetre) {
		super(nom);
		this.ouverture = ouverture;
		this.fenetre = fenetre;
	}

	public String etat() {
		String res = "";
		if (this.ouverture == true) {
			res += " : détecteur ouvert";
		} else {
			res += " : détecteur fermé";
		}
		return res + "\n";
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public void setEtat() {
		if (Fenetre.getEtat(this.fenetre) == true) {  //TODO 
			this.ouverture = true;
		} else {
			this.ouverture = false;
		}
	}

	public boolean getEtat(DetecteurOuverture detecteurOuverture) {
		return this.ouverture;
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub

	}
}
