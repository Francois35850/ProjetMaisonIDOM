package objets;

import java.util.Scanner;

import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public class Instrument extends ObjetNonRamassable {

	private boolean accorde;
	private boolean corde;

	public Instrument(String nom, Piece piece, boolean corde, boolean accorde) {
		super(nom, piece);
		this.accorde = accorde;
	}

	@Override
	public String etat() {
		if (!corde)
			return "\n";
		else {
			if (accorde)
				return " : accordé\n";
			else
				return " : accordé\n";
		}
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - jouer (15 mins)\n  - accorder (5 mins)\n  - s'enregistrer (50 mins)\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "JOUER":
				if (corde && accorde || !corde) {
					if (this.getNom().compareToIgnoreCase("Guitare") == 0)
						System.out.println("Vous jouez comme un dieu !");
					else
						System.out.println("Il n'est jamais trop tard pour prendre des cours...");
					Main.ajoutTemps(15);
				}
				else {
					System.out.println("Vous commencez à jouer mais vous rendez rapidement compte que cet instrument n'est pas accordé !");
					Main.ajoutTemps(2);
				}
				break;
			case "ACCORDER":
				if (corde && accorde)
					System.out.println("Cet instrument est déjà accordé");
				else if (corde && !accorde) {
					System.out.println("Vous accordez cet instrument");
					Main.ajoutTemps(5);
				} else
					System.out.println("Cet instrument n'est pas accordable");
				break;
			case "S'ENREGISTRER":
				System.out.println("Vous enregistrez quelques notes mais sans grande conviction...");
				Main.ajoutTemps(50);
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
		sc.close();
		sc2.close();
	}

}
