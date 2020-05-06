import java.util.*;

public class Piece {
	String nom;
	Boolean estAuRezDeC;
	List<Piece> piecesAdj;
	List<Objet> listeObjets;
	
	public Piece(String nom, List<Piece> piecesAdj, List<Objet> listeObjets, boolean etage) {
		this.nom = nom;
		this.piecesAdj = piecesAdj;
		this.listeObjets = listeObjets;
		estAuRezDeC = etage;
	}
	
	public void addObjets(Objet o) {
		listeObjets.add(o);
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
			res+="\nVous avez acc�s aux portes : ";
			ListIterator<Piece> itPiece = piecesAdj.listIterator();
			while(itPiece.hasNext()) {
				res+="\n - " + itPiece.next().nom;
			}
		}
		else res+= "\nVous avez accès à la porte " + piecesAdj.get(0).nom;
		return res;
	}

}
