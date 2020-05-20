package objetsRamassables;

import main.ObjetRamassable;

public class Produit extends ObjetRamassable {
	
	public Produit(String nom) {
		super(nom);
	}

	@Override
	public void utiliserObjet() {
		System.out.println("Pour utiliser cet objet lancer la machine");
	}

}
