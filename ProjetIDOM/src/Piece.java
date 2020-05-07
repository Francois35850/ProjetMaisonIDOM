import java.util.*;

public class Piece {
	String nom;
	Boolean estAuRezDeC;
	List<Piece> piecesAdj;
	List<Objet> listeObjets;
	
	public Piece(String nom, List<Objet> listeObjets, boolean rdc) {
		this.nom = nom;
		this.piecesAdj = new ArrayList<Piece>();
		this.listeObjets = listeObjets;
		estAuRezDeC = rdc;
	}
	
	public void addObjets(Objet o) {
		listeObjets.add(o);
	}
	
	public void ajouterPiecesAdj(Piece[] aAjouter) {
		for(int i = 0; i<aAjouter.length; i++) {
			piecesAdj.add(aAjouter[i]);
		}
	}
	
	public void soustractObjets(Objet o) {
		boolean retire = false;
		ListIterator<Objet> itObjet = listeObjets.listIterator();
		while (!retire | itObjet.hasNext()) {
			Objet next = itObjet.next();
			if (next == o) {
				itObjet.remove();
				retire = true;
			}
		}
	}
	
	public String toString() {
		String res = "";
		res+= "Vous vous trouvez dans la pi�ce " + this.nom + ".\n Liste des objets pr�sents : \n";
		ListIterator<Objet> itObjet = listeObjets.listIterator();
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

}
