import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Joueur {

	private static Piece pieceCourante;
	private static List<Objet> inventaire;

	static {
		init();
	}

	private Joueur() {
	}

	private static void init() {
		pieceCourante = null;
		inventaire = new ArrayList<Objet>();
	}

	public List<Objet> getInventaire() {
		return inventaire;
	}

	public static Piece getPieceCourante() {
		return pieceCourante;
	}

	public static void setPieceCourante(Piece p) {
		pieceCourante = p;
	}

	public void addInventaire(Objet o) {
		inventaire.add(o);
	}

	public boolean removeInventaire(Objet o) {
		return inventaire.remove(o);
	}

	public static Piece StringToPiece(String nomPiece) {
		ListIterator<Piece> it = pieceCourante.piecesAdj.listIterator();
		while (it.hasNext()) {
			Piece nextPiece = it.next();
			if (nextPiece.nom.compareToIgnoreCase(nomPiece) == 0)
				return nextPiece;
		}
		return null;
	}

	public static void changerPiece(String piece) {
		Piece deplacement = StringToPiece(piece);
		if (deplacement == null)
			System.out.println("Désolé je n'ai pas compris dans quelle pièce vous voulez aller...");
		else {
			setPieceCourante(deplacement);
			System.out.println(getPieceCourante().toString());
		}
	}

}
