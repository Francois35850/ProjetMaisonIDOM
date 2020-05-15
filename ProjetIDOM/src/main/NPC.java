package main;
import java.util.ArrayList;
import java.util.List;

public class NPC {
	private Piece pieceActuelle;
	private List<ObjetNonRamassable> inventaire;
	
	public NPC(Piece act) {
		pieceActuelle = act;
		this.inventaire = new ArrayList<ObjetNonRamassable>();
	}
	
	public List<ObjetNonRamassable> getInventaire() {
		return this.inventaire;
	}

	public Piece getPieceCourante() {
		return this.pieceActuelle;
	}

	public void addInventaire(ObjetNonRamassable o) {
		this.inventaire.add(o);
	}

	public boolean removeInventaire(ObjetNonRamassable o) {
		return this.inventaire.remove(o);
	}

	public void changerPiece(Piece piece) {
		pieceActuelle = piece;
	}

}
