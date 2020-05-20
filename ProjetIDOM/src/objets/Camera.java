package objets;

import main.ObjetNonRamassable;
import main.Piece;

public class Camera extends ObjetNonRamassable{
	
	private String vue;
	private int etat;
	private Piece piece;

	public Camera(String nom, String vue, int etat, Piece piece) {
		super(nom);
		this.vue = vue;
		this.etat = etat;
		this.piece=piece;
	}
	
	public String etat() {
		String res = "";
		if(this.etat==1) {res+= " : caméra en fonctionnement";}
		else {res += " : caméra deffectueuse";}
		return res + "\n";
	}
	
	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public Piece getPosition() {return this.piece;}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub
		
	}
	
}
