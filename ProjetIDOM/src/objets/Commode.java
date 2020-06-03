package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import main.Piece;
import objetsRamassables.Bouteille;
import objetsRamassables.Cle;
import objetsRamassables.Verre;

public class Commode extends ObjetNonRamassable {

	private boolean ouvert;
	private List<ObjetRamassable> objets;

	public Commode(String nom, Piece piece) {
		super(nom, piece);
		ouvert = false;
		objets = new ArrayList<ObjetRamassable>();
		init();
	}

	private void init() {
		if (super.getPiece().getNom().compareToIgnoreCase("Entree") == 0) {
			objets.add(new Cle("Clé porte d'entrée"));
		}
		if (super.getPiece().getNom().compareToIgnoreCase("Salle a manger") == 0) {
			objets.add(new Bouteille("Bouteille de vin rouge"));
			objets.add(new Bouteille("Bouteille de vin blanc"));
			objets.add(new Bouteille("Bouteille de cognac"));
			objets.add(new Verre("Verre vide", false, null));
			objets.add(new Verre("Verre vide", false, null));
			objets.add(new Verre("Verre vide", false, null));
		}
	}

	@Override
	public String etat() {
		if (ouvert) {
			if (objets.isEmpty())
				return " : ouverte, vide\n";
			else
				return " : ouvert, pleine\n";
		} else
			return " : fermée\n";
	}

	private void afficherObjetsInside() {
		String res = "La commode est ouverte";
		if (objets.isEmpty())
			res += ", elle est vide";
		else {
			res += ", elle contient : ";
			ListIterator<ObjetRamassable> it = objets.listIterator();
			while (it.hasNext()) {
				ObjetRamassable suiv = it.next();
				if (it.hasNext())
					res += suiv.getNom() + ", ";
				else
					res += suiv.getNom();
			}
		}
		System.out.println(res);
	}

	private void supprList(ObjetRamassable obj) {
		objets.remove(obj);
	}
	
	private void ajoutList(ObjetRamassable obj) {
		objets.add(obj);
	}

	private ObjetRamassable strToObjet(String resObjet,List<ObjetRamassable> list) {
		if (list.isEmpty())
			return null;
		else {
			ListIterator<ObjetRamassable> it = list.listIterator();
			while (it.hasNext()) {
				ObjetRamassable suiv = it.next();
				if (suiv.getNom().compareToIgnoreCase(resObjet) == 0)
					return suiv;
			}
		}
		return null;
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		if (ouvert)
			afficherObjetsInside();
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - ouvrir\n  - fermer\n  - prendre [nom de l'objet] (1 min)\n  - deposer [nom de l'objet] (1 min)\n  - retour");
			String input = sc.nextLine();
			String[] entreeSplit = input.split(" ");
			switch (entreeSplit[0].toUpperCase()) {
			case "OUVRIR":
				if (ouvert) {
					System.out.println("La commode est déjà ouverte");
					afficherObjetsInside();
				} else {
					System.out.println("Vous ouvrez la commode");
					ouvert = true;
					afficherObjetsInside();
				}
				break;
			case "FERMER":
				if (!ouvert)
					System.out.println("La commode est déjà fermée");
				else {
					System.out.println("Vous fermez la commode");
					ouvert = false;
				}
				break;
			case "PRENDRE":
				if (ouvert) {
					if (entreeSplit.length > 1) {
						String resObjet = "";
						resObjet = entreeSplit[1];
						if (entreeSplit.length > 2) {
							for (int i = 2; i < entreeSplit.length; i++) {
								resObjet += " ";
								resObjet += entreeSplit[i];
							}
						}
						ObjetRamassable cherche = strToObjet(resObjet,objets);
						if (cherche != null) {
							Joueur.addInventaire(cherche);
							supprList(cherche);
							Main.ajoutTemps(1);
						} else
							System.out.println("Cet objet n'est pas disponible dans la commode... \n");
					} else
						System.out.println("Vous n'avez pas précisé quel objet prendre...");
				}
				else System.out.println("Commencez par ouvrir la commode");
				break;
			case "DEPOSER":
				if (ouvert) {
					if (entreeSplit.length > 1) {
						String resObjet = "";
						resObjet = entreeSplit[1];
						if (entreeSplit.length > 2) {
							for (int i = 2; i < entreeSplit.length; i++) {
								resObjet += " ";
								resObjet += entreeSplit[i];
							}
						}
						ObjetRamassable cherche = strToObjet(resObjet,Joueur.getInventaire());
						if (cherche != null) {
							Joueur.removeInventaire(cherche);
							ajoutList(cherche);
							Main.ajoutTemps(1);
						} else
							System.out.println("Cet objet n'est pas disponible dans la commode... \n");
					} else
						System.out.println("Vous n'avez pas précisé quel objet prendre...");
				}
				else System.out.println("Commencez par ouvrir la commode");
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
