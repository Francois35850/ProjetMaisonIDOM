import java.util.*;

public class Piece {
	String nom;
	List<Piece> piecesAdj;
	List<Objet> listeObjets;
	
	public Piece(String nom, List<Piece> piecesAdj, List<Objet> listeObjets) {
		this.nom = nom;
		this.piecesAdj = piecesAdj;
		this.listeObjets = listeObjets;
	}
	
	public String toString() {
		String res = "";
		res+= "Vous vous trouvez dans la pièce " + this.nom + ".\n Liste des objets présents : \n";
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
		return res;
	}

}
