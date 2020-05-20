package main;

import java.util.*;
import java.util.Scanner;

import Main.DetecteurMouvement;
import Main.DetecteurOuverture;
import Main.DetecteurOuverturee;
import Main.Piece;
import objets.Armoire;
import objets.Canape;
import objets.Enceinte;
import objets.Fenetre;
import objets.Frigo;
import objets.Interrupteur;
import objets.LaveLinge;
import objets.PanneauDeCtrl;
import objets.Piscine;
import objets.Telecommande;
import objets.Television;
import objets.Volet;
import objetsRamassables.Gonflable;
import objetsRamassables.Linge;
import objetsRamassables.LiquideVaisselle;
import objetsRamassables.Produit;

public class Main {

	// boolean pour l'état du jeu : true quand le jeu est en cours
	private static boolean gameActive = true;
	
	private static int heure = 13;
	private static int minute = 05;
	
	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);

	private ITelephone iPhone = ITelephone.newTelephone();

	// Ajout des pièces
	private static Piece garage = new Piece("Garage", true);
	private static Piece cuisine = new Piece("Cuisine", true);
	private static Piece salon = new Piece("Salon", true);
	private static Piece salle_a_manger = new Piece("Salle a manger", true);
	private static Piece buanderie = new Piece("Buanderie", true);
	private static Piece entree = new Piece("Entree", true);
	private static Piece chambre1 = new Piece("Chambre de David", true);
	private static Piece chambre2 = new Piece("Chambre de Régine", true);
	private static Piece chambre_parentale = new Piece("Chambre parentale", false);
	private static Piece sdb1 = new Piece("Salle de bain", true);
	private static Piece sdb2 = new Piece("Salle de bain", false);
	private static Piece bureau = new Piece("Bureau", true);
	private static Piece salle_de_jeux = new Piece("Salle de jeux", false);
	private static Piece couloir = new Piece("Couloir", false);
	private static Piece grenier = new Piece("Grenier", false);
	private static Piece studio = new Piece("Studio", false);
	private static Piece dressing = new Piece("Dressing", false);
	private static Piece toilettes = new Piece("Toilettes", false);
	private static Piece jardin = new Piece("Jardin", true);
	private static Piece devant_maison = new Piece("Exterieur maison",true);

	// Ajout des objets
	private static Objets enceinteSalon = new Enceinte("Enceinte", false);
	private static Objets frigo = new Frigo("Frigo",false);
	private static Objets canapeSalon = new Canape("Canapé",false,true);
	private static Objets canapeSdJ = new Canape("Canapé",false,false);
	private static Objets televisionSalon = new Television("TV");
	private static Objets televisionSalleDeJeux = new Television("TV");
	private static Objets telecommandeSalon = new Telecommande("Télécommande",false,true,0,0);
	private static Objets telecommandeSalleDeJeux = new Telecommande("Télécommande",false,true,4,2);
	private static Objets interrupteurGarage = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurCuisine = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurSalon = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurSaM = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurBuanderie = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurEntree = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurChambre1 = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurChambre2 = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurChambreP = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurSdB1 = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurSdB2 = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurBureau = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurSdJ = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurCouloir = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurGrenier = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurStudio = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurDressing = new Interrupteur("Interrupteur", false);
	private static Objets interrupteurToilettes = new Interrupteur("Interrupteur", false);
	private static Piscine piscine = new Piscine("Piscine");
	private static Objets liquideVaisselle = new LiquideVaisselle("Liquide Vaisselle", piscine);
	private static Objets AnimauxGonflables = new Gonflable("Animaux Gonflables", piscine);
	private static Objets Panodectrl = new PanneauDeCtrl("Panneau de Controle", piscine);
	private static Fenetre fenetre_bureau = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_salon1 = new Fenetre("Fenêtre sud", false); 	
	private static Fenetre fenetre_salon2 = new Fenetre("Fenêtre est", false);
	private static Fenetre fenetre_ch1 = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_ch2 = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_chp = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_sallejeux = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_studio = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_cuisine = new Fenetre("Fenêtre", false);
	private static Fenetre fenetre_sallemanger = new Fenetre("Fenêtre", false);
	private static Volet volet_bureau = new Volet("Volet", false);
	private static Volet volet_salon1 = new Volet("Volet sud", false);
	private static Volet volet_salon2 = new Volet("Volet est", false);
	private static Volet volet_ch1 = new Volet("Volet", false);
	private static Volet volet_ch2 = new Volet("Volet", false);
	private static Volet volet_chp = new Volet("Volet", false);
	private static Volet volet_sallejeux = new Volet("Volet", false);
	private static Volet volet_studio = new Volet("Volet", false);
	private static Volet volet_cuisine = new Volet("Volet", false);
	private static Volet volet_sallemanger = new Volet("Volet", false);
	private static Armoire armoireDressing = new Armoire("Armoire", false);
	private static Produit pastilleLaveLinge = new Produit("Pastille lave linge");
	private static Linge lingeD = new Linge("Linge sale de David", false, chambre1.getNom());
	private static Linge lingeR = new Linge("Linge sale de Régine", false, chambre2.getNom());
	private static Linge lingeP = new Linge("Linge sale des parents", false, chambre_parentale.getNom());
	private static LaveLinge laveLinge = new LaveLinge("Lave linge");
	private static DetecteurMouvement detecteur_mouvement_entree = new DetecteurMouvement("detecteur mouvement entree",false,entree);
	private static DetecteurMouvement detecteur_mouvement_bureau = new DetecteurMouvement("detecteur mouvement bureau",false,bureau);
	private static DetecteurMouvement detecteur_mouvement_salon = new DetecteurMouvement("detecteur mouvement salon",false,salon);
	private static DetecteurMouvement detecteur_mouvement_garage = new DetecteurMouvement("detecteur mouvement garage",false,garage);
	private static DetecteurMouvement detecteur_mouvement_ch1 = new DetecteurMouvement("detecteur mouvement chambre David",true,chambre1);
	private static DetecteurMouvement detecteur_mouvement_ch2 = new DetecteurMouvement("detecteur mouvement chambre Régine",true,chambre2);
	private static DetecteurMouvement detecteur_mouvement_chp = new DetecteurMouvement("detecteur mouvement chp",true,chambre_parentale);
	private static DetecteurMouvement detecteur_mouvement_sdb_patentale = new DetecteurMouvement("detecteur mouvement sdb patentale",false,sdb2);
	private static DetecteurMouvement detecteur_mouvement_dressing = new DetecteurMouvement("detecteur mouvement dressing",false,dressing);
	private static DetecteurMouvement detecteur_mouvement_cuisine = new DetecteurMouvement("detecteur mouvement cuisine",false,cuisine);
	private static DetecteurMouvement detecteur_mouvement_studio = new DetecteurMouvement("detecteur mouvement studio",false,studio);
	private static DetecteurMouvement detecteur_mouvement_couloir = new DetecteurMouvement("detecteur mouvement couloir",false,couloir);
	private static DetecteurOuverture detecteur_ouverture_porte = new DetecteurOuverture("detecteur ouverture porte", false, entree);
	private static DetecteurOuverture detecteur_ouverture_bureau = new DetecteurOuverture("detecteur ouverture bureau", false, bureau);
	private static DetecteurOuverture detecteur_ouverture_salon1 = new DetecteurOuverture("detecteur ouverture salon fenêtre sud", false, salon); 	
	private static DetecteurOuverture detecteur_ouverture_salon2 = new DetecteurOuverture("detecteur ouverture salon fenêtre est", false, salon);
	private static DetecteurOuverture detecteur_ouverture_ch1 = new DetecteurOuverture("detecteur ouverture chambre David", false, chambre1);
	private static DetecteurOuverture detecteur_ouverture_ch2 = new DetecteurOuverture("detecteur ouverture chambre Régine", false, chambre2);
	private static DetecteurOuverture detecteur_ouverture_chp = new DetecteurOuverture("detecteur ouverture chambre parentale", false,, chambre1));
	private static DetecteurOuverture detecteur_ouverture_sallejeux = new DetecteurOuverturee("detecteur ouverture salle de jeux", false, chambre_parentale);
	private static DetecteurOuverture detecteur_ouverture_studio = new DetecteurOuverture("detecteur ouverture studio", false, studio);
	private static DetecteurOuverture detecteur_ouverture_cuisine = new DetecteurOuverture("detecteur ouverture cuisine", false, cuisine);
	private static DetecteurOuverture detecteur_ouverture_sallemanger = new DetecteurOuverture("detecteur ouverture salle � manger", false, salle_a_manger);
	private static Cam�ra("cam�ra devant la maison","Systeme defaillant, veuillez contacter le service maintenance !",0,devant_maison);
	private static Cam�ra("cam�ra du jardin","|---------------------------------------------------------------------|"\n"|                  |   / 	    	      |  ______ |                   |"\n"|                  |  /                 |  |    | |     []_[]         |"\n "|       /|         | /                  |  |    | |     ('v')         |"\n"|      / |         |/           |_| |_| |__|____|_|    / |||)         |"\n"|     /  |         /                                  (_=*;;          |"\n"|    /   |        /                                                   |"\n"|   /    |       /                                                    |"\n"|   |    |      /               _____________________________         |"\n"|   |    |     /              //|   |    |    |    |    |  //        _|"\n"|   |    |    /              // |   |    |    |    |    | //        / |"\n"|   |   /    /              //| |   |    |    |    |    |//        /  |"\n"|   |  /    /              // | |   |    |    |    |    //        /__/|"\n"|   | /    /              //| | |   |    |    |    |   //        //   |"\n"|   |/    /              // | | |   |    |    |    |  //        //    |"\n"|        /              //| | | |___|____|____|____|_//    ___________|"\n"|       /              // | | | /                   //    /  /  /  /  |"\n"|      /              //| | | |/                   //    /  /  /  /  /|"\n"|	    /              // | | | /                   //    /__/__/__/__/_|"\n"|    /              //| | | |/                   //    //           //|"\n"|   /              // | | | /                   //    //           // |"\n"|  /              //__|_|_|/___________________//                     |"\n              "| /                         										    |"\n"|/              													    |"\n"|---------------------------------------------------------------------|",1,jardin);
	private static Cam�ra("cam�ra de l'entr�e","|---------------------------------------------------------------------|"\n "|              |       |    				     |       |              |"\n"|              |       |      		         |       |              |"\n"|              |       |                       |       |              |"\n"|              |       |                       |       |              |"\n"|              |       |     _____________     |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |          _| |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |    |             |    |       |              |"\n"|              |       |____|_____________|____|       |              |"\n"|              |      /                         \\      |              |"\n"|              |     /                           \\     |              |"\n"|              |    /                             \\    |              |"\n"|	 		     |   /							     \\   |			     |"\n"|              |  /                                 \\  |              |"\n"|              | /                                   \\ |              |"\n"|______________|/        							    \\|______________|"\n"|                          										    |"\n"|               													    |"\n"|---------------------------------------------------------------------|",1,entree);

	
	// String de l'affichage de l'heure
	public static String affichageHeure() {
		if(minute<10) return heure + "h0" + minute;
		else return heure + "h" + minute;
	}
	
	// ajouter du temps (en minute)
	public static void ajoutTemps(int tempsSupp) {
		heure = heure + tempsSupp/60;
		minute = minute + tempsSupp%60;
		while(minute>=60) {
			minute = minute-60;
			heure++;
		}
	}
	
	// retirer du temps (en minute)
	public static void retirerTemps(int tempsSupp) {
		heure = heure - tempsSupp/60;
		minute = minute - tempsSupp%60;
		while(minute>=60) {
			minute = minute-60;
			heure++;
		}
	}
	
	public static int getHeure() {return heure;}
	public static int getMinute() {return minute;}
	
	/**
	 * Fonction principale main
	 */
	public static void main(String[] args) {
		// Création des listes de pièces adjacentes
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
		Objets[] objGarage = {interrupteurGarage};
		Objets[] objCuisine = {interrupteurCuisine,frigo,liquideVaisselle,fenetre_cuisine,volet_cuisine};
		Objets[] objBuanderie = {interrupteurBuanderie,laveLinge,pastilleLaveLinge};
		Objets[] objSalleAManger = {interrupteurSaM,fenetre_sallemanger,volet_sallemanger};
		Objets[] objSalon = {interrupteurSalon,enceinteSalon,canapeSalon,televisionSalon,telecommandeSalon,fenetre_salon1,fenetre_salon2,volet_salon1,volet_salon2};
		Objets[] objEntree = {interrupteurEntree};
		Objets[] objChambre1 = {interrupteurChambre1,fenetre_ch1,volet_ch1,lingeD};
		Objets[] objChambre2 = {interrupteurChambre2,fenetre_ch2,volet_ch2,lingeR};
		Objets[] objSdB1 = {interrupteurSdB1};
		Objets[] objBureau = {interrupteurBureau,fenetre_bureau,volet_bureau};
		Objets[] objCouloir = {interrupteurCouloir};
		Objets[] objSdB2 = {interrupteurSdB2};
		Objets[] objSalleDeJeux = {interrupteurSdJ,televisionSalleDeJeux,telecommandeSalleDeJeux,canapeSdJ,fenetre_sallejeux,volet_sallejeux};
		Objets[] objChambreParentale = {interrupteurChambreP,fenetre_chp,volet_chp,lingeP};
		Objets[] objStudio = {interrupteurStudio,fenetre_studio,volet_studio};
		Objets[] objToilettes = {interrupteurToilettes};
		Objets[] objGrenier = {interrupteurGrenier,AnimauxGonflables};
		Objets[] objDressing = {interrupteurDressing,armoireDressing};
		Objets[] objJardin = {piscine,Panodectrl};

		// Ajout des pièces adj et des objets
		garage.ajouterPiecesAdj(adjGarage);
		garage.ajouterObjets(objGarage);

		cuisine.ajouterPiecesAdj(adjCuisine);
		cuisine.ajouterObjets(objCuisine);

		buanderie.ajouterPiecesAdj(adjBuanderie);
		buanderie.ajouterObjets(objBuanderie);

		salle_a_manger.ajouterPiecesAdj(adjSalleAManger);
		salle_a_manger.ajouterObjets(objSalleAManger);

		salon.ajouterPiecesAdj(adjSalon);
		salon.ajouterObjets(objSalon);

		entree.ajouterPiecesAdj(adjEntree);
		entree.ajouterObjets(objEntree);

		chambre1.ajouterPiecesAdj(adjChambre1);
		chambre1.ajouterObjets(objChambre1);

		chambre2.ajouterPiecesAdj(adjChambre2);
		chambre2.ajouterObjets(objChambre2);

		sdb1.ajouterPiecesAdj(adjSdB1);
		sdb1.ajouterObjets(objSdB1);

		bureau.ajouterPiecesAdj(adjBureau);
		bureau.ajouterObjets(objBureau);

		couloir.ajouterPiecesAdj(adjCouloir);
		couloir.ajouterObjets(objCouloir);

		sdb2.ajouterPiecesAdj(adjSdB2);
		sdb2.ajouterObjets(objSdB2);

		salle_de_jeux.ajouterPiecesAdj(adjSalleDeJeux);
		salle_de_jeux.ajouterObjets(objSalleDeJeux);

		chambre_parentale.ajouterPiecesAdj(adjChambreParentale);
		chambre_parentale.ajouterObjets(objChambreParentale);

		studio.ajouterPiecesAdj(adjStudio);
		studio.ajouterObjets(objStudio);

		toilettes.ajouterPiecesAdj(adjToilettes);
		toilettes.ajouterObjets(objToilettes);

		grenier.ajouterPiecesAdj(adjGrenier);
		grenier.ajouterObjets(objGrenier);

		dressing.ajouterPiecesAdj(adjDressing);
		dressing.ajouterObjets(objDressing);

		jardin.ajouterPiecesAdj(adjJardin);
		jardin.ajouterObjets(objJardin);

		Joueur.setPieceCourante(chambre_parentale);

		// Message de lancement du jeu
		System.out.println("Bonjour !");
		System.out.println("Vous venez de vous réveiller, il est déjà " + affichageHeure() + "...");
		System.out.println(
				"Il va falloir se dépêcher, vous avez un rendez-vous à 18h30 et il vous faut partir de chez vous avant 18h15.");
		System.out.println(
				"Mais vous avez encore beaucoup à faire avant de sortir ! Voici la liste des tâches que vous devez accomplir :");
		System.out.println();
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
				System.out.println("   - prendre [nom de l'objet] : prendre un objet");
				System.out.println("   - inventaire : consulter l'inventaire");
				System.out.println("   - infos : consulter les informations sur la pièce");
				System.out.println("   - heure : consulter l'heure qu'il est");
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
				if (entreeSplit.length > 1) {
					String resObjet = "";
					resObjet = entreeSplit[1];
					if (entreeSplit.length > 2) {
						for (int i = 2; i < entreeSplit.length; i++) {
							resObjet += " ";
							resObjet += entreeSplit[i];
						}
					}
					Objets cherche = Joueur.StringtoObjet(resObjet);
					if (cherche != null) {
						cherche.utiliserObjet();
					} else
						System.out.println("Cet objet n'est pas disponible ... \n");
				}
				break;
			case "INVENTAIRE": // commande pour consulter l'inventaire
				Joueur.inventaireToString();
				break;
			case "INFOS":
				System.out.println(Joueur.getPieceCourante().toString());
				break;
			case "PRENDRE" :
				if (entreeSplit.length > 1) {
					String resObjet = "";
					resObjet = entreeSplit[1];
					if (entreeSplit.length > 2) {
						for (int i = 2; i < entreeSplit.length; i++) {
							resObjet += " ";
							resObjet += entreeSplit[i];
						}
					}
					Objets cherche = Joueur.StringtoObjet(resObjet);
					if (cherche != null && cherche instanceof ObjetRamassable) {
						Joueur.addInventaire((ObjetRamassable) cherche);
						Joueur.getPieceCourante().soustractObjets(cherche);
					} else
						System.out.println("Cet objet n'est pas disponible ... \n");
				}
				break;
			case "HEURE" :
				System.out.println("Il est " + affichageHeure() + ", Vous devez sortir de la maison avant 18h15");
				break;
			case "SORTIR": // commande pour sortir de la maison depuis l'entrée
				if (Joueur.getPieceCourante().getNom().compareToIgnoreCase("entree") == 0) {
					if(Joueur.getEtatVetements()==1) {
						System.out.println("Vous êtes sorti de la maison");
						gameActive = false;
						System.out.println("Jeu terminé");
					}
					else System.out.println("Vous ne pouvez pas sortir habillé comme ça...");
				} else
					System.out.println("Vous ne pouvez sortir que depuis l'entrée");
				break;
			default: // cas par défaut, cad commande invalide
				System.out.println("Commande invalide.");
				break;
			}

		}

	}


}
