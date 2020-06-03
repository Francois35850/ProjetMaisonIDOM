package objets;

import main.ObjetNonRamassable;
import main.Piece;

public class DetecteurOuverture extends ObjetNonRamassable {

	private boolean ouverture;
	private Fenetre fenetre;

	public DetecteurOuverture(String nom,Piece piece, boolean ouverture, Fenetre fenetre) {
		super(nom,piece);
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
		if (fenetre.getEtat()) { 
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

	}
}
