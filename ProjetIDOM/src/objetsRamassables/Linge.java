package objetsRamassables;

import main.Joueur;
import main.Main;
import main.ObjetRamassable;
import main.Objets;

public class Linge extends ObjetRamassable{

	private String piece;
	private boolean propre;
	
	public Linge(String nom, boolean propre, String piece) {
		super(nom);
		this.propre = propre;
		this.piece = piece;
	}

	@Override
	public void utiliserObjet() {
		if(!propre) {
			System.out.println("Ce linge doit être amené au lave linge");
		}
		else if(Joueur.getPieceCourante().getNom().compareToIgnoreCase(piece)==0) {
			Main.ajoutTemps(1);
			System.out.println("Vous avez déposé le linge propre dans la pièce");
			if (piece.compareToIgnoreCase("Chambre parentale")==0) {
				Main.LPsucces1 = true;
			}
			else if (piece.compareToIgnoreCase("Chambre de David")==0) {
				Main.LPsucces2 = true;
			}
			else {
				Main.LPsucces3 = true;
			}
			Objets obj[] = {this};
			Joueur.getPieceCourante().ajouterObjets(obj);
			Joueur.removeInventaire(this);
		}
		else {
			System.out.println("Ce linge propre ne doit pas être déposé dans cette pièce");
		}
	}

	
}
