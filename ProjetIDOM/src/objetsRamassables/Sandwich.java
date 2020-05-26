package objetsRamassables;

import main.Joueur;
import main.Main;
import main.ObjetRamassable;

public class Sandwich extends ObjetRamassable{

	public Sandwich(String nom) {
		super(nom);
	}

	@Override
	public void utiliserObjet() {
		if(Joueur.getInventaire().contains(this)) {
			Main.ajoutTemps(10);
			System.out.println("Vous dévorez votre sandwich en 10 mins");
			System.out.println("Burrrrp ! Il manquait juste une feuille de salade");
			Joueur.removeInventaire(this);
		}
		else System.out.println("Pas dans l'inventaire");
	}

}
