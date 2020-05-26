package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public final class Enceinte extends ObjetNonRamassable {

	private boolean allumer;
	private boolean jouerMusique;
	private String listMusics[] = { "Céline Dion - Pour que tu m'aimes encore", "Jul - On m'appelle l'OVNI",
			"Michael Jackson - Billie Jean", "Mylène Farmer - Sans contrefaçon", "Patrick Sébastien - Les sardines",
			"Six Nine - Aulos", "Magic System - Zouglou Dance", "Drake - Started from the bottom" };
	private int musiqueActive; // (de 0 à 7)

	public Enceinte(String nom,Piece piece, boolean allumer) {
		super(nom,piece);
		this.allumer = allumer;
		this.jouerMusique = false;
		musiqueActive = 1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String etat() {
		String res = "";
		if (allumer) {
			res += " : allumé";
			if (jouerMusique)
				res += ", musique allumée (" + listMusics[musiqueActive] + ")";
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
					"Liste des actions possibles pour cet objet :\n  - allumer\n  - éteindre\n  - jouer musique\n  - changer musique (2 mins)\n  - retour");
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
					System.out.println("La musique se lance avec " + listMusics[musiqueActive]);
					if (Joueur.getPieceCourante().getNom() == "Salon")
						Main.PPsucces1 = true;
				}
				break;
			case "CHANGER MUSIQUE":
				if (!allumer)
					System.out.println("Commencez par allumer l'enceinte");
				else if (!jouerMusique)
					System.out.println("L'enceinte ne diffuse pas de musique");
				else {
					System.out.println(
							"Quel chanteur souhaitez-vous entendre ?\n Céline Dion | Jul | Michael Jackson | Mylène Farmer | Patrick Sébastien | Six Nine | Magic System | Drake");
					String reponse = sc2.nextLine();
					switch (reponse.toUpperCase()) {
					case "CELINE DION":
						if (musiqueActive == 0)
							System.out.println("Vous écoutez déjà Céline ! Quelle voix !");
						else {
							musiqueActive = 0;
							Main.ajoutTemps(2);
							System.out.println(
									"Vous écouter : " + listMusics[musiqueActive] + ", un régal pour les oreilles");
						}
						break;
					case "JUL":
						if (musiqueActive == 1)
							System.out.println("Vous écoutez déjà Jujujul !");
						else {
							musiqueActive = 1;
							Main.ajoutTemps(2);
							System.out.println("Vous écouter : " + listMusics[musiqueActive]
									+ ", quoi de mieux pour s'ambiancer ?");
						}
						break;
					case "MICHAEL JACKSON":
						if (musiqueActive == 2)
							System.out.println("Vous écoutez déjà Michael Jackson !");
						else {
							musiqueActive = 2;
							Main.ajoutTemps(2);
							System.out.println("Vous écouter : " + listMusics[musiqueActive]
									+ ", n'hésitez pas à lâcher un petit pas de dance");
						}
						break;
					case "MYLENE FARMER":
						if (musiqueActive == 3)
							System.out.println("Vous écoutez déjà Mylène Farmer !");
						else {
							musiqueActive = 3;
							Main.ajoutTemps(2);
							System.out.println("Vous écouter : " + listMusics[musiqueActive]
									+ ", vous vous surprenez même à fredonner les paroles");
						}
						break;
					case "PATRICK SEBASTIEN":
						if (musiqueActive == 4)
							System.out.println("Vous écoutez déjà Patrick Sébastien !");
						else {
							musiqueActive = 4;
							Main.ajoutTemps(2);
							System.out.println("Vous écouter : " + listMusics[musiqueActive]
									+ ", puis vous vous mettez à sauter...");
						}
						break;
					case "SIX NINE":
						if (musiqueActive == 5)
							System.out.println("Vous écoutez déjà 6ix 9ine !");
						else {
							musiqueActive = 5;
							Main.ajoutTemps(2);
							System.out.println(
									"Vous écouter : " + listMusics[musiqueActive] + ", un de ses meilleurs feat");
						}
						break;
					case "MAGIC SYSTEM":
						if (musiqueActive == 6)
							System.out.println("Vous écoutez déjà Magic System !");
						else {
							musiqueActive = 6;
							Main.ajoutTemps(2);
							System.out.println(
									"Vous écouter : " + listMusics[musiqueActive] + ", ça vous remonte le moral !");
						}
						break;
					case "DRAKE":
						if (musiqueActive == 7)
							System.out.println("Vous écoutez déjà Drake !");
						else {
							musiqueActive = 7;
							Main.ajoutTemps(2);
							System.out.println("Vous écouter : " + listMusics[musiqueActive] + ", posé !");
						}
						break;
					default:
						System.out.println("Vous ne portez pas cet artiste dans votre coeur je vous rappelle...");
						break;
					}
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
