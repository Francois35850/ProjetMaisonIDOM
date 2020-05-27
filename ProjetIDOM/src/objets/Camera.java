package objets;

import main.ObjetNonRamassable;
import main.Piece;

public class Camera extends ObjetNonRamassable {

	private String vue;
	private int etat;

	public Camera(String nom, Piece piece, String vue, int etat) {
		super(nom,piece);
		this.vue = vue;
		this.etat = etat;
	}

	public String etat() {
		String res = "";
		if (this.etat == 1) {
			res += " : caméra en fonctionnement";
		} else {
			res += " : caméra deffectueuse";
		}
		return res + "\n";
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public Piece getPosition() {
		return super.getPiece();
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub

	}

}
