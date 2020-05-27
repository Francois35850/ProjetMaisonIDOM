package objetsRamassables;

import java.util.ListIterator;

import main.Joueur;
import main.Main;
import main.ObjetRamassable;

public class Bouteille extends ObjetRamassable{
	
	public Bouteille(String nom) {
		super(nom);
	}

	private int verreVide() {
		int index = 0;
		ListIterator<ObjetRamassable> it = Joueur.getInventaire().listIterator();
		while(it.hasNext()) {
			ObjetRamassable suiv = it.next();
			if(suiv instanceof Verre) {
				Verre v = (Verre) suiv;
				if(!v.getRempli()) return index;
			}
			index++;
		}
		return -1;
	}
	
	@Override
	public void utiliserObjet() {
		int indexVerre = verreVide();
		String nomSplit[] = this.getNom().split(" ");
		if(indexVerre==-1) {
			System.out.println("Pour vous servir un verre il vous faut un verre vide");
		}
		else {
			String res = nomSplit[2];
			for(int i=3;i<nomSplit.length;i++) {
				res+= " " +nomSplit[i];
			}
			Joueur.getInventaire().remove(indexVerre);
			Joueur.addInventaire(new Verre("Verre de " + res, true, res));
			Main.ajoutTemps(1);
		}
	}
	

}
