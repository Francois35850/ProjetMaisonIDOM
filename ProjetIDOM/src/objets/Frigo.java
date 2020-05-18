package objets;

import java.util.Scanner;

import main.Joueur;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import objetsRamassables.Boisson;

public final class Frigo extends ObjetNonRamassable {

	private boolean ouvert;
	
	public Frigo(String nom, boolean ouvert) {
		super(nom);
		this.ouvert = ouvert;
	}

	@Override
	public String etat() {
		String res = "";
		if(ouvert) res+= " : ouvert";
		else res += " : fermé";
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - ouvrir\n  - fermer\n  - prendre à manger\n  - prendre à boire\n  - retour");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
				case "OUVRIR" : 
					if(ouvert) System.out.println("Le frigo est déjà ouvert.");
					else {ouvert = true; System.out.println("Vous ouvrez le frigo.");}
					break;
				case "FERMER" : 
					if(!ouvert) System.out.println("Le frigo est déjà fermé.");
					else {ouvert = false; System.out.println("Vous fermez le frigo.");}
					break;
				case "PRENDRE A MANGER" :
					if(!ouvert) System.out.println("Commencez par ouvrir le frigo.");
					else System.out.println("Vous avez pris de quoi manger, régalez vous !");
					break;
				case "PRENDRE A BOIRE" :
					if(!ouvert) System.out.println("Commencez par ouvrir le frigo.");
					else {
						System.out.println("Wow une bonne bière, parfait pour se désaltérer !");
						Joueur.addInventaire(new Boisson("biere"));
					}
					break;
				case "RETOUR" :
					this.setUtilisation(false);
					System.out.println("Vous arrêtez d'utiliser l'objet");
					break;
				default :
					System.out.println("La commande n'est pas valide");
					break;
			}
		}
		
	}

}