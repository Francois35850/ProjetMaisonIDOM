package objetsRamassables;

import main.Joueur;
import main.Main;
import main.ObjetRamassable;

public class Boisson extends ObjetRamassable{

	public Boisson(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserObjet() {
		if(Joueur.getInventaire().contains(this)) {
			Main.ajoutTemps(2);
			System.out.println("Ah ça fait du bien !");
			Joueur.removeInventaire(this);
		}
		else System.out.println("Pas dans l'inventaire");
	}

}
