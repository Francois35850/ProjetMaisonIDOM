package main;
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

	public static List<Objet> getInventaire() {
		return inventaire;
	}

	public static Piece getPieceCourante() {
		return pieceCourante;
	}

	public static void setPieceCourante(Piece p) {
		pieceCourante = p;
	}

	public static void addInventaire(Objet o) {
		inventaire.add(o);
	}

	public static boolean removeInventaire(Objet o) {
		return inventaire.remove(o);
	}
	
	public static void inventaireToString() {
		String res = "";
		res+= "Dans votre inventaire, il y a : \n";
		ListIterator<Objet> itObjet = inventaire.listIterator();
		while(itObjet.hasNext()) {
			res+=" - ";
			res+= itObjet.next().toString();
			res+=" \n";
		}
		System.out.println(res);
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

	public static void changerPiece(String[] piece) {
		String resPiece = "";
		resPiece = piece[1];
		if (piece.length > 2) {
			for (int i = 2; i < piece.length; i++) {
				resPiece += " ";
				resPiece += piece[i];
			}
		}
		Piece deplacement = StringToPiece(resPiece);
		if (deplacement == null)
			System.out.println("Désolé je n'ai pas compris dans quelle pièce vous voulez aller...");
		else {
			setPieceCourante(deplacement);
			System.out.println(getPieceCourante().toString());
		}
	}
	
	public static Objet StringtoObjet(String o) {
		ListIterator<Objet> itInv = inventaire.listIterator();
		ListIterator<Objet> itPie = getPieceCourante().listeObjets.listIterator();
		boolean dispo = false;
		Objet ret = null;
		while (itInv.hasNext()&&!dispo) {
			Objet compare = itInv.next();
			if (compare.nom.equalsIgnoreCase(o)) {
				dispo = true;
				ret = compare;
			}
		}
		while (itPie.hasNext()&&!dispo) {
			Objet compare = itPie.next();
			if (compare.nom.equalsIgnoreCase(o)) {
				dispo = true;
				ret = compare;
			}
		}
		return ret;
	}

}
