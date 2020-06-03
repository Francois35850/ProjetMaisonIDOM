package objets;

import main.ObjetNonRamassable;
import main.Piece;

public class Camera extends ObjetNonRamassable {

	
	private int etat;

	public Camera(String nom, Piece piece, String vue, int etat) {
		super(nom,piece);
		this.etat = etat;
	}

	public String etat() {
		String res = "";
		if (this.etat == 1) {
			res += " : caméra en fonctionnement";
		} else {
			res += " : caméra défectueuse";
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

	}

}
