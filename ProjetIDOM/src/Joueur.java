import java.util.ArrayList;
import java.util.List;

public class Joueur {

	private Piece pieceCourante;
	private List<Objet> inventaire;

	public Joueur(Piece debut) {
		this.pieceCourante = debut; // TODO
		this.inventaire = new ArrayList<Objet>();
	}

	public List<Objet> getInventaire() {
		return this.inventaire;
	}

	public Piece getPieceCourante() {
		return this.pieceCourante;
	}

	public void addInventaire(Objet o) {
		this.inventaire.add(o);
	}

	public boolean removeInventaire(Objet o) {
		return this.inventaire.remove(o);
	}

	public static void changerPiece(String piece) {
		switch (piece.toLowerCase()) {
		case "":
			// TODO : fonction qui, avec le nom, trouve la classe de la pièce
			// TODO : si la pièce est dans la liste des pièces adjointes à la pièce
			// courante, changer de pièce
		default:
			System.out.println("Pièce mal écrite ou inconnue");
			break;
		}
	}
	
}
