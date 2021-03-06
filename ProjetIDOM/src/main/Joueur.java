package main;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Joueur {

	private static Piece pieceCourante;
	private static List<ObjetRamassable> inventaire;
	private static int etatVetements; // 1 -> habillé, 2 -> pyjama, 3 -> maillot de bain

	static {
		init();
	}

	private Joueur() {
	}

	private static void init() {
		pieceCourante = null;
		inventaire = new ArrayList<ObjetRamassable>();
		etatVetements = 2;
	}

	public static List<ObjetRamassable> getInventaire() {
		return inventaire;
	}

	public static Piece getPieceCourante() {
		return pieceCourante;
	}

	public static void setPieceCourante(Piece p) {
		pieceCourante = p;
	}
	
	public static int getEtatVetements() {
		return etatVetements;
	}
	
	public static void setEtatVetements(int etat) {
		etatVetements = etat;
	}

	public static void addInventaire(ObjetRamassable o) {
		if (inventaire.contains(o))
			System.out.println("Vous avez déjà cet objet dans votre inventaire.");
		else {
			inventaire.add(o);
			System.out.println("Vous avez récupéré l'objet " + o.getNom() + ".");
		}
	}

	public static void removeInventaire(ObjetRamassable o) {
		if (!inventaire.contains(o))
			System.out.println("Vous n'avez pas cet objet dans votre inventaire.");
		else {
			inventaire.remove(o);
			System.out.println("Vous avez utilisé l'objet " + o.getNom() + ".");
		}
	}
	
	public static void supprInv(String nomObj) {
		boolean trouve = false;
		ListIterator<ObjetRamassable> it = inventaire.listIterator();
		while(it.hasNext()&&!trouve) {
			ObjetRamassable obj = it.next();
			if(obj.getNom().compareToIgnoreCase(nomObj)==0) {
				removeInventaire(obj);
				trouve = true;
			}
		}
	}

	public static void inventaireToString() {
		String res = "";
		if (!inventaire.isEmpty()) {
			res += "Dans votre inventaire, il y a : \n";
			ListIterator<ObjetRamassable> itObjet = inventaire.listIterator();
			while (itObjet.hasNext()) {
				res += "";
				res += itObjet.next().toString();
			}
			System.out.println(res);
		} else
			System.out.println("Votre inventaire est vide...");
	}

	public static Piece StringToPiece(String nomPiece) {
		ListIterator<Piece> it = pieceCourante.getAdj().listIterator();
		while (it.hasNext()) {
			Piece nextPiece = it.next();
			if (nextPiece.getNom().compareToIgnoreCase(nomPiece) == 0)
				return nextPiece;
		}
		return null;
	}

	public static void changerPiece(String[] piece) {
		if (piece.length < 2) {
			System.out.println("Aucune pièce n'a été précisée.");
		} else {
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
				Main.ajoutTemps(1);
				setPieceCourante(deplacement);
				System.out.println(getPieceCourante().toString());
			}
		}
	}

	public static Objets StringtoObjet(String o) {
		ListIterator<ObjetRamassable> itInv = inventaire.listIterator();
		ListIterator<Objets> itPie = getPieceCourante().getObjets().listIterator();
		boolean dispo = false;
		Objets ret = null;
		while (itInv.hasNext() && !dispo) {
			Objets compare = itInv.next();
			if (compare.getNom().equalsIgnoreCase(o)) {
				dispo = true;
				ret = compare;
			}
		}
		while (itPie.hasNext() && !dispo) {
			Objets compare = itPie.next();
			if (compare.getNom().equalsIgnoreCase(o)) {
				dispo = true;
				ret = compare;
			}
		}
		return ret;
	}

}
