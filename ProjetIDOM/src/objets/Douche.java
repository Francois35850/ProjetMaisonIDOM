package objets;

import java.util.Scanner;

import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public class Douche extends ObjetNonRamassable {

	private boolean occupe;

	public Douche(String nom, Piece piece) {
		super(nom, piece);
		this.occupe = false;
	}

	@Override
	public String etat() {
		String res = "";
		if (occupe)
			res += " : occupée";
		else
			res += " : non occupée";
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - se rincer (3 mins)\n  - se laver (8 mins)\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
				case "SE RINCER":
					if(occupe) System.out.println("La douche est déjà occupée par quelqu'un");
					else {
						Main.ajoutTemps(3);
						System.out.println("Vous vous rincez sans savon, c'est mieux que rien");
					}
					break;
				case "SE LAVER":
					if(occupe) System.out.println("La douche est déjà occupée par quelqu'un");
					else {
						Main.ajoutTemps(3);
						System.out.println("Vous prenez une bonne douche, par contre vous chantez toujours aussi faux...");
					}
					break;
				case "RETOUR":
					this.setUtilisation(false);
					System.out.println("Vous arrêtez d'utilisez l'objet");
					break;
				default:
					System.out.println("La commande n'est pas valide");
					break;
			}
		}
	}

}
