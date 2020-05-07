import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Joueur {

	private static Piece pieceCourante;
	private List<Objet> inventaire;

	public Joueur(Piece debut) {
		this.pieceCourante = debut;
		this.inventaire = new ArrayList<Objet>();
	}

	public List<Objet> getInventaire() {
		return this.inventaire;
	}

	public static Piece getPieceCourante() {
		return pieceCourante;
	}
	
	public static void setPieceCourante(Piece p) {
		pieceCourante = p;
	}

	public void addInventaire(Objet o) {
		this.inventaire.add(o);
	}

	public boolean removeInventaire(Objet o) {
		return this.inventaire.remove(o);
	}
	
	public static Piece StringToPiece(String nomPiece) {
		ListIterator<Piece> it = pieceCourante.piecesAdj.listIterator();
		while(it.hasNext()) {
			Piece nextPiece = it.next();
			if(nextPiece.nom.compareToIgnoreCase(nomPiece)==0) return nextPiece;
		}
		return null;
	}

	public static void changerPiece(String piece) {
		Piece deplacement = StringToPiece(piece);
		if(deplacement == null) System.out.println("Désolé je n'ai pas compris dans quelle pièce vous voulez aller...");
		else {
			setPieceCourante(deplacement);
			System.out.println(getPieceCourante().toString());
		}
	}
	
}
