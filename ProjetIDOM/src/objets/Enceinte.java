package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.ObjetNonRamassable;

public final class Enceinte extends ObjetNonRamassable {

	private boolean allumer;
	private boolean jouerMusique;
	private String listMusics[] = { "Céline Dion - Pour que tu m'aimes encore", "Jul - On m'appelle l'OVNI",
			"Michael Jackson - Billie Jean", "Mylène Farmer - Sans contrefaçon", "Patrick Sébastien - Les sardines" };
	private int musiqueActive; // (de 1 à 7)

	public Enceinte(String nom, boolean allumer) {
		super(nom);
		this.allumer = allumer;
		this.jouerMusique = false;
		musiqueActive = 2;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String etat() {
		String res = "";
		if (allumer) {
			res += " : allumé";
			if (jouerMusique)
				res += ", musique allumée";
			else
				res += ", musique éteinte";
		} else
			res += ": éteinte";
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - allumer\n  - éteindre\n  - jouer musique\n  - changer musique\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "ALLUMER":
				if (allumer)
					System.out.println("L'enceinte est déjà allumée");
				else {
					allumer = true;
					System.out.println("L'enceintre s'est allumée");
				}
				break;
			case "ETEINDRE":
				if (!allumer)
					System.out.println("L'enceinte est déjà éteinte");
				else {
					allumer = false;
					jouerMusique = false;
					System.out.println("L'enceintre s'est éteinte");
				}
				break;
			case "JOUER MUSIQUE":
				if (!allumer)
					System.out.println("Commencez par allumer l'enceinte");
				else if (jouerMusique)
					System.out.println("La musique est déjà lancée");
				else {
					jouerMusique = true;
					System.out.println("Voila du bon gros Jul, parfait pour s'ambiancer un peu !");
				}
				break;
			case "CHANGER MUSIQUE":
				if (!allumer)
					System.out.println("Commencez par allumer l'enceinte");
				else if (!jouerMusique)
					System.out.println("L'enceinte ne diffuse pas de musique");
				else {
					System.out.println(
							"Quel chanteur souhaitez-vous entendre ?\n Céline Dion | Jul | Michael Jackson | Mylène Farmer | Patrick Sébastien | Six Nine | Magic System");
					String reponse = sc2.nextLine();
					switch (reponse.toUpperCase()) {
					case "CELINE DION":
					case "JUL":
					case "MICHAEL JACKSON":
					case "MYLENE FARMER":
					case "PATRICK SEBASTIEN":
					case "SIX NINE":
					case "MAGIC SYSTEM":
					case "DRAKE":
					default:
						System.out.println("Vous ne portez pas cet artiste dans votre coeur je vous rappelle...");
						break;
					}
				}
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
