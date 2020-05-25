package objets;

import main.ObjetNonRamassable;
import main.Piece;
import main.Joueur;
import main.NPC;

public class DetecteurMouvement extends ObjetNonRamassable {

	private boolean detection;
	private Piece piece;

	public DetecteurMouvement(String nom, boolean detection, Piece piece) {
		super(nom);
		this.detection = detection;
		this.piece = piece;
	}

	public String etat() {
		String res = "";
		if (this.detection == true) {
			res += " : détection en cours";
		} else {
			res += " : pas de détection";
		}
		return res + "\n";
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public void setEtat() {
		if (Joueur.getPieceCourante() == this.piece) {
			this.detection = true;
		} else {
			this.detection = false;
		}
	}

	public boolean getEtat() {
		return this.detection;   //TODO illias tu veux dire this.detection ?
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub

	}

}
