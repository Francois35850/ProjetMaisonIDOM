package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.Objets;
import main.Piece;

public class Television extends ObjetNonRamassable {

	private List<String> chaines;

	public Television(String nom, Piece piece) {
		super(nom,piece);
		chaines = new ArrayList<String>();
		// ajout des chaines TV de [0 à 8]
		chaines.add("TF1");
		chaines.add("France 2");
		chaines.add("France 3");
		chaines.add("Canal +");
		chaines.add("France 5");
		chaines.add("M6");
		chaines.add("Arte");
		chaines.add("C8");
		chaines.add("W9");
	}

	private int indiceTelecommande(List<Objets> objetsPieceC) {
		int res = 0;
		ListIterator<Objets> it = objetsPieceC.listIterator();
		while (it.hasNext()) {
			if (it.next() instanceof Telecommande)
				return res;
			else
				res++;
		}
		return -1;
	}

	@Override
	public String etat() {
		int indT = indiceTelecommande(Joueur.getPieceCourante().getObjets());
		Telecommande t = (Telecommande) Joueur.getPieceCourante().getObjets().get(indT);
		String res = "";
		if (t.getAllumee()) {
			if (t.getSon())
				res += " : allumée, son activé, chaîne : ";
			else
				res += " : allumée, muet, chaîne : ";
			res += chaines.get(t.getChaine());
		} else {
			res += " : éteinte";
		}
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		int indT = indiceTelecommande(Joueur.getPieceCourante().getObjets());
		Telecommande t = (Telecommande) Joueur.getPieceCourante().getObjets().get(indT);
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n - regarder tv (le temps va varier selon la chaine, faites attention ...)\n - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "REGARDER TV":
				if (t.getChaine() == 0) {
					System.out.println("Vous êtes sur TF1");
					System.out.println("Vous regardez Tfou pendant 15 mins");
					Main.ajoutTemps(15);
				}
				if (t.getChaine() == 1) {
					System.out.println("Vous êtes sur France 2");
					System.out.println("Vous regardez les news pendant 30 mins");
					Main.ajoutTemps(30);
				}
				if (t.getChaine() == 2) {
					System.out.println("Vous êtes sur France 3");
					System.out.println("Vous regardez 46000% Sport pendant 37 mins");
					Main.ajoutTemps(37);
				}
				if (t.getChaine() == 3) {
					System.out.println("Vous êtes sur Canal +");
					System.out.println("Vous regardez Validé pendant 51 mins");
					Main.ajoutTemps(51);
				}
				if (t.getChaine() == 4) {
					System.out.println("Vous êtes sur France 5");
					System.out.println("Vous regardez le magazine de la santé pendant 42 mins");
					Main.ajoutTemps(42);
				}
				if (t.getChaine() == 5) {
					System.out.println("Vous êtes sur M6");
					System.out.println("Vous regardez télé-achat pendant 2 mins");
					Main.ajoutTemps(2);
				}
				if (t.getChaine() == 6) {
					System.out.println("Vous êtes sur ARTE");
					System.out.println("Vous regardez un passionnant documentaire sur les arbres à spaghettis pendant 1 heure");
					main.Objectifs.getObjectif("Regarder un documentaire sur la télé du salon").setSucces(true);
					Main.ajoutTemps(60);
				}
				if (t.getChaine() == 7) {
					System.out.println("Vous êtes sur C8");
					System.out.println("Vous regardez Touche Pas à Mon Poste faire encore polémique pendant 20 mins");
					Main.ajoutTemps(20);
				}
				if (t.getChaine() == 8) {
					System.out.println("Vous êtes sur W9");
					System.out.println("Vous regardez les Marseillais à Belle-île ... \n ... \n ... \n ... \nMince, vous n'avez pas vu le temps passer ! Vous sortez d'une transe de 5 heures");
					Main.ajoutTemps(300);
				}
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

}
