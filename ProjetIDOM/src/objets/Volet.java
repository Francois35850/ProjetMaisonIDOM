package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public class Volet extends ObjetNonRamassable {

	// Attributs
	private boolean etat_volet;

	// Constructeur
	public Volet(String nom, boolean etat_volet) {
		super(nom);
		this.etat_volet = etat_volet;
	}

	public String etat() {
		String res = "";
		if (this.etat_volet == true) {
			res += " : ouvert";
		} else {
			res += " : fermé";
		}
		return res + "\n";
	}

	// fonction qui permet d'utiliser la fenetre
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner input = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation() == true) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - ouvrir le volet\n  - fermer le volet\n  - retour");
			String entree = input.nextLine();
			switch (entree) {
			case "OUVRIR":
				setEtat(true);
				break;
			case "FERMER":
				setEtat(false);
				break;
			case "RETOUR":
				this.setUtilisation(false);
				System.out.println("Vous arrêtez d'utiliser l'objet");
				break;
			default:
				System.out.println("La commande n'est pas valide");
				break;
			}
		}
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public boolean getEtat(Volet volet) {
		return this.etat_volet;
	}

	public void setEtat(boolean use) {
		this.etat_volet = use;
	}

}
