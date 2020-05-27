package objetsRamassables;

import main.ObjetRamassable;

public class Cle extends ObjetRamassable{

	public Cle(String nom) {
		super(nom);
	}

	@Override
	public void utiliserObjet() {
		System.out.println("Cet objet sert à ouvrir une porte");		
	}
	

}
