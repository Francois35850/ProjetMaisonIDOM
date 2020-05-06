import java.util.ArrayList;
import java.util.List;

public class NPC {
	private Piece pieceActuelle;
	private List<Objet> inventaire;
	
	public NPC(Piece act) {
		pieceActuelle = act;
		this.inventaire = new ArrayList<Objet>();
	}
	
	public List<Objet> getInventaire() {
		return this.inventaire;
	}

	public Piece getPieceCourante() {
		return this.pieceActuelle;
	}

	public void addInventaire(Objet o) {
		this.inventaire.add(o);
	}

	public boolean removeInventaire(Objet o) {
		return this.inventaire.remove(o);
	}

	public void changerPiece(Piece piece) {
		pieceActuelle = piece;
	}

}
