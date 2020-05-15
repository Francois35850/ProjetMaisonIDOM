package objets;

import main.ObjetRamassable;

public class Pile extends ObjetRamassable {

	public Pile(String nom) {
		super(nom);
	}

	@Override
	public void utiliserObjet() {
		System.out.println("Vous ne pouvez pas utiliser cet objet.");		
	}

}
