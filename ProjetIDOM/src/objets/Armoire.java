package objets;

import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public class Armoire extends ObjetNonRamassable {

	private boolean ouvert;

	public Armoire(String nom, Piece piece, boolean ouvert) {
		super(nom,piece);
		this.ouvert = ouvert;
	}

	@Override
	public String etat() {
		String res = "";
		if (ouvert)
			res += " : ouverte";
		else
			res += " : fermée";
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
					"Liste des actions possibles pour cet objet :\n  - ouvrir \n  - fermer\n  - se changer (5 min)\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
				case "OUVRIR" :
					if(ouvert) {
						System.out.println("L'armoire est déjà ouverte");
					}
					else {
						System.out.println("Vous ouvrez l'armoire");
						ouvert = true;
					}
					break;
				case "FERMER" :
					if(!ouvert) {
						System.out.println("L'armoire est déjà fermée");
					}
					else {
						System.out.println("Vous fermez l'armoire");
						ouvert = false;
					}
					break;
				case "SE CHANGER" :
					if(!ouvert) {
						System.out.println("Commencez par ouvrir l'armoire");
					}
					else {
						System.out.println("Quels vêtements voulez-vous enfiler ?\n  Tenue classique | Pyjama | Maillot de bain");
						String reponse = sc.nextLine();
						switch(reponse.toUpperCase()) {
							case "TENUE CLASSIQUE" :
								if(Joueur.getEtatVetements()==1) System.out.println("Vous êtes déjà habillé comme ça");
								else {
									Joueur.setEtatVetements(1);
									Main.ajoutTemps(5);
									System.out.println("Ca y est ! Vous n'êtes pas sur votre 31 mais c'est mieux que rien");
								}
								break;
							case "PYJAMA" :
								if(Joueur.getEtatVetements()==2) System.out.println("Vous êtes déjà en pyjama");
								else {
									Joueur.setEtatVetements(2);
									Main.ajoutTemps(5);
									System.out.println("Ca y est ! Vous pouvez aller faire un petit somme");
								}
								break;
							case "MAILLOT DE BAIN" :
								if(Joueur.getEtatVetements()==3) System.out.println("Vous êtes déjà en maillot de bain");
								else {
									Joueur.setEtatVetements(3);
									Main.ajoutTemps(5);
									System.out.println("Ca y est ! La piscine n'a qu'à bien se tenir");
								}
								break;
							default :
								System.out.println("Cette tenu n'existe pas");
								break;
						}
					}
					break;
				case "RETOUR":
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
