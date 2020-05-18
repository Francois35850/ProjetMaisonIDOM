package objetsRamassables;

import main.ObjetRamassable;

public class Pile extends ObjetRamassable {

	public Pile(String nom) {
		super(nom);
	}

	@Override
	public void utiliserObjet() {
		System.out.println("Vous ne pouvez pas utiliser cet objet. Il doit se mettre dans un objet électronique...");		
	}

}
