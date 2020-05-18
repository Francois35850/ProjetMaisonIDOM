package main;
import java.util.*;

public class Piece {
	String nom;
	Boolean estAuRezDeC;
	List<Piece> piecesAdj;
	List<Objets> listeObjets;
	
	public Piece(String nom, boolean rdc) {
		this.nom = nom;
		this.piecesAdj = new ArrayList<Piece>();
		this.listeObjets = new ArrayList<Objets>();
		estAuRezDeC = rdc;
	}
	
	public void addObjets(ObjetNonRamassable o) {
		listeObjets.add(o);
	}
	
	public void ajouterPiecesAdj(Piece[] aAjouter) {
		for(int i = 0; i<aAjouter.length; i++) {
			piecesAdj.add(aAjouter[i]);
		}
	}
	
	public void ajouterObjets(Objets[] aAjouter) {
		for(int i = 0; i<aAjouter.length; i++) {
			listeObjets.add(aAjouter[i]);
		}
	}
	
	public void soustractObjets(ObjetNonRamassable o) {
		boolean retire = false;
		ListIterator<Objets> itObjet = listeObjets.listIterator();
		while (!retire | itObjet.hasNext()) {
			Objets next = itObjet.next();
			if (next == o) {
				itObjet.remove();
				retire = true;
			}
		}
	}
	
	public String toString() {
		String res = "\n";
		res+= "Vous vous trouvez dans la pièce " + this.nom + ".\nListe des objets présents : \n";
		ListIterator<Objets> itObjet = listeObjets.listIterator();
		while(itObjet.hasNext()) {
			res+= itObjet.next().toString();
		}
		if(piecesAdj.size()>1) {
			res+="\nVous avez accès aux portes : ";
			ListIterator<Piece> itPiece = piecesAdj.listIterator();
			while(itPiece.hasNext()) {
				res+="\n - " + itPiece.next().nom;
			}
		}
		else {
			ListIterator<Piece> pieceAdj = piecesAdj.listIterator();
			res+= "\nVous avez accès à la porte : " + pieceAdj.next().nom;
		}
		return res;
	}

	public List<Objets> getObjets() {
		return listeObjets;
	}
	
}
