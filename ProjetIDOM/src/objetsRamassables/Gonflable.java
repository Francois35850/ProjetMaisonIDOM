package objetsRamassables;

import main.Joueur;
import main.Main;
import main.ObjetRamassable;
import objets.Piscine;

public class Gonflable extends ObjetRamassable{
	private Piscine p ;

	public Gonflable (String nom, Piscine pi) {
		super(nom);
		p = pi;
	}

	@Override
	public void utiliserObjet() {
		if(Joueur.getInventaire().contains(this) && Joueur.getPieceCourante().getNom().compareToIgnoreCase("jardin")==0 && p.getOuverture()) {
			Main.ajoutTemps(10);
			System.out.println("Vous gonflez les jouets pendant 10 mins");
			System.out.println("Vous jetez les animaux gonflables dans la piscine");
			p.setAmb(true);
			Joueur.removeInventaire(this);
		}
		else System.out.println("Vous ne pouvez pas faire cela");
	}

}
