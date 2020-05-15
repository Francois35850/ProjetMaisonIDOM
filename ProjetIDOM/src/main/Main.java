package main;
import java.util.*;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

import objets.Enceinte;
import objets.Frigo;

public class Main {

	// boolean pour l'état du jeu : true quand le jeu est en cours
	private static boolean gameActive = true;

	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);

	private ITelephone iPhone = ITelephone.newTelephone();

	// Ajout des objets
	private static Objets enceinte1 = new Enceinte("Enceinte salon", false);
	private static Objets frigo = new Frigo("Frigo",false);
	
	// Ajout des pièces
	private static Piece garage = new Piece("Garage",true);
	private static Piece cuisine = new Piece("Cuisine",true);
	private static Piece salon = new Piece("Salon",  true);
	private static Piece salle_a_manger = new Piece("Salle a manger",true);
	private static Piece buanderie = new Piece("Buanderie",true);
	private static Piece entree = new Piece("Entree",  true);
	private static Piece chambre1 = new Piece("Chambre de Régine", true);
	private static Piece chambre2 = new Piece("Chambre de David",  true);
	private static Piece chambre_parentale = new Piece("Chambre parentale",  false);
	private static Piece sdb1 = new Piece("Salle de bain",  true);
	private static Piece sdb2 = new Piece("Salle de bain", false);
	private static Piece bureau = new Piece("Bureau", true);
	private static Piece salle_de_jeux = new Piece("Salle de jeux",  false);
	private static Piece couloir = new Piece("Couloir", false);
	private static Piece grenier = new Piece("Grenier", false);
	private static Piece studio = new Piece("Studio",  false);
	private static Piece dressing = new Piece("Dressing", false);
	private static Piece toilettes = new Piece("Toilettes",  false);
	private static Piece jardin = new Piece("Jardin",  true);

	/**
	 * Fonction principale main
	 */
	public static void main(String[] args) {
		//Création des listes de pièces adjacentes
		Piece[] adjGarage = { buanderie, cuisine };
		Piece[] adjCuisine = { buanderie, garage, salle_a_manger };
		Piece[] adjBuanderie = { cuisine, garage };
		Piece[] adjSalleAManger = { salon, cuisine };
		Piece[] adjSalon = { salle_a_manger, entree, jardin, couloir };
		Piece[] adjEntree = { salon, chambre1, chambre2, sdb1, bureau };
		Piece[] adjChambre1 = { entree };
		Piece[] adjChambre2 = { entree };
		Piece[] adjSdB1 = { entree };
		Piece[] adjBureau = { entree };
		Piece[] adjCouloir = { salon, salle_de_jeux, grenier, studio, toilettes, chambre_parentale };
		Piece[] adjSdB2 = { chambre_parentale };
		Piece[] adjSalleDeJeux = { couloir };
		Piece[] adjChambreParentale = { couloir, sdb2, dressing };
		Piece[] adjStudio = { couloir };
		Piece[] adjToilettes = { couloir };
		Piece[] adjGrenier = { couloir };
		Piece[] adjDressing = { chambre_parentale };
		Piece[] adjJardin = { salon };
		
		// Création des listes d'objets
		Objets[] objSalon = {enceinte1};
		Objets[] objCuisine = {frigo};
		
		// Ajout des pièces adj et des objets
		garage.ajouterPiecesAdj(adjGarage);
		
		cuisine.ajouterPiecesAdj(adjCuisine);
		cuisine.ajouterObjets(objCuisine);
		
		buanderie.ajouterPiecesAdj(adjBuanderie);
		
		salle_a_manger.ajouterPiecesAdj(adjSalleAManger);
		
		salon.ajouterPiecesAdj(adjSalon);
		salon.ajouterObjets(objSalon);
		
		entree.ajouterPiecesAdj(adjEntree);
		
		chambre1.ajouterPiecesAdj(adjChambre1);
		
		chambre2.ajouterPiecesAdj(adjChambre2);
		
		sdb1.ajouterPiecesAdj(adjSdB1);
		
		bureau.ajouterPiecesAdj(adjBureau);
		
		couloir.ajouterPiecesAdj(adjCouloir);
		
		sdb2.ajouterPiecesAdj(adjSdB2);
		
		salle_de_jeux.ajouterPiecesAdj(adjSalleDeJeux);
		
		chambre_parentale.ajouterPiecesAdj(adjChambreParentale);
		
		studio.ajouterPiecesAdj(adjStudio);
		
		toilettes.ajouterPiecesAdj(adjToilettes);
		
		grenier.ajouterPiecesAdj(adjGrenier);
		
		dressing.ajouterPiecesAdj(adjDressing);
		
		jardin.ajouterPiecesAdj(adjJardin);
		

		Joueur.setPieceCourante(chambre_parentale);

		// Message de lancement du jeu
		System.out.println("Bienvenue !");
		System.out.println(" ");
		System.out.println(Joueur.getPieceCourante().toString());
		System.out.println(" ");

		// boucle du jeu
		while (gameActive) {

			// Demande de la commande
			System.out.println("Entrez une commande ('help' pour la liste des commandes) :");
			String entree = input.nextLine();
			entree = entree.toLowerCase();
			String[] entreeSplit = entree.split(" ");

			// code en fonction de la commande
			switch (entreeSplit[0].toUpperCase()) {
			case "QUITTER": // commande pour quitter le jeu
				gameActive = false;
				System.out.println("Jeu quitté");
				break;
			case "HELP": // commande pour afficher la liste des commandes
				System.out.println("Liste des commandes disponibles :");
				System.out.println("   - help : affiche cette liste");
				System.out.println("   - aller [nom de la pièce] : déplacement dans la pièce indiquée");
				System.out.println("     possible uniquement quand la pièce demandée est accessible");
				System.out.println("     depuis la pièce actuelle");
				System.out.println("   - téléphone : utilise le téléphone");
				System.out.println("   - utiliser [nom de l'objet] : utiliser un objet");
				System.out.println("   - inventaire : consulter l'inventaire");
				System.out.println("   - sortir : sortir de la maison depuis l'entrée");
				System.out.println("   - quitter : ferme le jeu");
				break;
			case "ALLER":
				Joueur.changerPiece(entreeSplit);
				break;
			case "TELEPHONE": // commande pour utiliser le téléphone
				Telephone.utiliserTelephone();
				break;
			case "UTILISER": // commande pour utiliser un objet
				String resObjet = "";
				resObjet = entreeSplit[1];
				if (entreeSplit.length > 2) {
					for (int i = 2; i < entreeSplit.length; i++) {
						resObjet += " ";
						resObjet += entreeSplit[i];
					}
				}
				Objets cherche = Joueur.StringtoObjet(resObjet);
				if (cherche!=null) {
					cherche.utiliserObjet();
				}
				else System.out.println("Cet objet n'est pas disponible ... \n");
				break;
			case "INVENTAIRE": // commande pour consulter l'inventaire
				Joueur.inventaireToString();
				break;
			case "SORTIR": // commande pour sortir de la maison depuis l'entrée
				if (Joueur.getPieceCourante().nom.compareToIgnoreCase("entree") == 0) {
					System.out.println("Vous êtes sorti de la maison");
					gameActive = false;
					System.out.println("Jeu terminé");
				}
				else System.out.println("Vous ne pouvez sortir que depuis l'entrée");
				break;
			default: // cas par défaut, cad commande invalide
				System.out.println("Commande invalide.");
				break;
			}

		}

	}


}
