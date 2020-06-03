package objets;

import java.util.Scanner;

import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public class TableMixage extends ObjetNonRamassable {

	public TableMixage(String nom, Piece piece) {
		super(nom, piece);
	}

	@Override
	public String etat() {
		return "\n";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - faire un mix (25 mins)\n  - écouter (4 mins)\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "FAIRE UN MIX":
				System.out.println("Vous n'arrivez pas à la cheville du DJ de votre dernier camping...");
				Main.ajoutTemps(25);
				break;
			case "ECOUTER":
				System.out.println("Vous écoutez votre dernier mix, c'était vraiment pas bon...");
				Main.ajoutTemps(25);
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
