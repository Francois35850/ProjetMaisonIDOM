package objetsRamassables;

import main.Joueur;
import main.ObjetRamassable;
import objets.Piscine;

public class LiquideVaisselle extends ObjetRamassable{
	private Piscine p ;

	public LiquideVaisselle(String nom, Piscine pi) {
		super(nom);
		p = pi;
	}

	@Override
	public void utiliserObjet() {
		if(Joueur.getInventaire().contains(this) && Joueur.getPieceCourante().getNom().compareToIgnoreCase("jardin")==0) {
			System.out.println("Vous videz le liquide vaisselle dans la piscine \nC'est pas vraiment à cela que ça sert mais ça fait des bulles");
			p.setMousse(true);
			Joueur.removeInventaire(this);
		}
		else System.out.println("Vous ne pouvez pas faire cela");
	}

}
