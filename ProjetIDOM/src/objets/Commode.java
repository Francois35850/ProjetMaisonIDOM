package objets;

import java.util.Scanner;

import main.Joueur;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import main.Objets;
import main.Piece;

public class Commode extends ObjetNonRamassable {

	private boolean ouvert;
	private ObjetRamassable objets[];

	public Commode(String nom, Piece piece, ObjetRamassable objets[]) {
		super(nom, piece);
		this.objets = objets;
		ouvert = false;
	}

	@Override
	public String etat() {
		return "\n";
	}

	private void afficherObjetsInside() {
		String res = "Le tiroir de la commode est ouvert";
		if (objets.length == 0)
			res += ", il est vide";
		else {
			res += ", il contient :";
			for (int i = 0; i < objets.length - 1; i++) {
				res += objets[i].getNom() + ", ";
			}
			res += objets[objets.length - 1].getNom();
		}
		System.out.println(res);
	}

	private void supprList(ObjetRamassable obj) {
		if(objets.length!=0) {
			for(int i=0; i< objets.length; i++) {
				if(objets[i] == obj) {
					
				}
			}
		}
	}
	
	private ObjetRamassable strToObjet(String resObjet) {
		if(objets.length==0) return null;
		else {
			for(int i=0; i<objets.length; i++) {
				if(objets[i].getNom().compareToIgnoreCase(resObjet)==0) return objets[i];
			}
		}
		return null;
	}
	
	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		if (ouvert)
			afficherObjetsInside();
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - ouvrir\n  - fermer\n  - prendre [nom de l'objet] (1 min)\n  - retour");
			String input = sc.nextLine();
			String[] entreeSplit = input.split(" ");
			switch (entreeSplit[0].toUpperCase()) {
			case "OUVRIR":
				if (ouvert) {
					System.out.println("Le tiroir de la commode est déjà ouvert");
					afficherObjetsInside();
				}
				else {
					System.out.println("Vous ouvrez le tiroir de la commode");
					ouvert = true;
					afficherObjetsInside();
				}
			case "FERMER":
				if (!ouvert)
					System.out.println("Le tiroir de la commode est déjà fermé");
				else {
					System.out.println("Vous fermez le tiroir de la commode");
					ouvert = false;
				}
			case "PRENDRE":
				if (entreeSplit.length > 1) {
					String resObjet = "";
					resObjet = entreeSplit[1];
					if (entreeSplit.length > 2) {
						for (int i = 2; i < entreeSplit.length; i++) {
							resObjet += " ";
							resObjet += entreeSplit[i];
						}
					}
					ObjetRamassable cherche = strToObjet(resObjet);
					if (cherche != null) {
						Joueur.addInventaire(cherche);
						supprList(cherche);
					} else
						System.out.println("Cet objet n'est pas disponible dans la commode ... \n");
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
