package objets;

public class Cam�ra extends ObjetNonRamassable{
	
	private String vue;
	private int etat;
	private Piece piece;

	public Cam�ra(String nom, String vue, int etat, Piece piece;) {
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
	
}
