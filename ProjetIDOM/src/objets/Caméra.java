package objets;

public class Caméra extends ObjetNonRamassable{
	
	private String vue;
	private int etat;
	private Piece piece;

	public Caméra(String nom, String vue, int etat, Piece piece;) {
		super(nom);
		this.vue = vue;
		this.etat = etat;
		this.piece=piece;
	}
	
	public String etat() {
		String res = "";
		if(this.etat==1) {res+= " : camÃ©ra en fonctionnement";}
		else {res += " : camÃ©ra deffectueuse";}
		return res + "\n";
	}
	
	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public Piece getPosition() {return this.piece;}
	
}
