package main;

public abstract class ObjetNonRamassable extends Objets {
	boolean utilisationEnCours;
	private Piece piece;

	public ObjetNonRamassable(String nom,Piece piece) {
		super(nom);
		utilisationEnCours = false;
		this.piece = piece;
	}

	public abstract String etat();

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public boolean getUtilisation() {return utilisationEnCours;}
	
	public void setUtilisation(boolean use) {this.utilisationEnCours = use;}
	
	public String getNom() {return super.getNom();}
	
	public Piece getPiece() {return piece;}
}