package main;

import java.util.*;
import java.util.Scanner;

import objets.DetecteurMouvement;
import objets.DetecteurOuverture;
import objets.Douche;
import objets.Armoire;
import objets.Camera;
import objets.Canape;
import objets.Commode;
import objets.Enceinte;
import objets.Fenetre;
import objets.Frigo;
import objets.Instrument;
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
	private static int endHeure = 18;
	private static int endMinute = 15;

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
	private static Piece devant_maison = new Piece("Exterieur maison", true);

	// Ajout des objets
	private static Enceinte enceinteSalon = new Enceinte("Enceinte", salon, false);
	private static Frigo frigo = new Frigo("Frigo", cuisine, false);
	private static Canape canapeSalon = new Canape("Canapé", salon, false, true);
	private static Canape canapeSdJ = new Canape("Canapé", salle_de_jeux, false, false);
	private static Television televisionSalon = new Television("TV", salon);
	private static Television televisionSalleDeJeux = new Television("TV", salle_de_jeux);
	private static Telecommande telecommandeSalon = new Telecommande("Télécommande", salon, false, true, 0, 0);
	private static Telecommande telecommandeSalleDeJeux = new Telecommande("Télécommande", salle_de_jeux, false, true,
			4, 2);
	private static Interrupteur interrupteurGarage = new Interrupteur("Interrupteur", garage, false);
	private static Interrupteur interrupteurCuisine = new Interrupteur("Interrupteur", cuisine, false);
	private static Interrupteur interrupteurSalon = new Interrupteur("Interrupteur", salon, false);
	private static Interrupteur interrupteurSaM = new Interrupteur("Interrupteur", salle_a_manger, false);
	private static Interrupteur interrupteurBuanderie = new Interrupteur("Interrupteur", buanderie, false);
	private static Interrupteur interrupteurEntree = new Interrupteur("Interrupteur", entree, false);
	private static Interrupteur interrupteurChambre1 = new Interrupteur("Interrupteur", chambre1, false);
	private static Interrupteur interrupteurChambre2 = new Interrupteur("Interrupteur", chambre2, false);
	private static Interrupteur interrupteurChambreP = new Interrupteur("Interrupteur", chambre_parentale, false);
	private static Interrupteur interrupteurSdB1 = new Interrupteur("Interrupteur", sdb1, false);
	private static Interrupteur interrupteurSdB2 = new Interrupteur("Interrupteur", sdb2, false);
	private static Interrupteur interrupteurBureau = new Interrupteur("Interrupteur", bureau, false);
	private static Interrupteur interrupteurSdJ = new Interrupteur("Interrupteur", salle_de_jeux, false);
	private static Interrupteur interrupteurCouloir = new Interrupteur("Interrupteur", couloir, false);
	private static Interrupteur interrupteurGrenier = new Interrupteur("Interrupteur", grenier, false);
	private static Interrupteur interrupteurStudio = new Interrupteur("Interrupteur", studio, false);
	private static Interrupteur interrupteurDressing = new Interrupteur("Interrupteur", dressing, false);
	private static Interrupteur interrupteurToilettes = new Interrupteur("Interrupteur", toilettes, false);
	private static Piscine piscine = new Piscine("Piscine", jardin);
	private static Objets liquideVaisselle = new LiquideVaisselle("Liquide Vaisselle", piscine);
	private static Objets AnimauxGonflables = new Gonflable("Animaux Gonflables", piscine);
	private static Objets Panodectrl = new PanneauDeCtrl("Panneau de Controle", jardin, piscine);
	private static Fenetre fenetre_bureau = new Fenetre("Fenêtre", bureau, false);
	private static Fenetre fenetre_salon1 = new Fenetre("Fenêtre sud", salon, false);
	private static Fenetre fenetre_salon2 = new Fenetre("Fenêtre est", salon, false);
	private static Fenetre fenetre_ch1 = new Fenetre("Fenêtre", chambre1, false);
	private static Fenetre fenetre_ch2 = new Fenetre("Fenêtre", chambre2, false);
	private static Fenetre fenetre_chp = new Fenetre("Fenêtre", chambre_parentale, false);
	private static Fenetre fenetre_sallejeux = new Fenetre("Fenêtre", salle_de_jeux, false);
	private static Fenetre fenetre_studio = new Fenetre("Fenêtre", studio, false);
	private static Fenetre fenetre_cuisine = new Fenetre("Fenêtre", cuisine, false);
	private static Fenetre fenetre_sallemanger = new Fenetre("Fenêtre", salle_a_manger, false);
	private static Volet volet_bureau = new Volet("Volet", bureau, false);
	private static Volet volet_salon1 = new Volet("Volet sud", salon, false);
	private static Volet volet_salon2 = new Volet("Volet est", salon, false);
	private static Volet volet_ch1 = new Volet("Volet", chambre1, false);
	private static Volet volet_ch2 = new Volet("Volet", chambre2, false);
	private static Volet volet_chp = new Volet("Volet", chambre_parentale, false);
	private static Volet volet_sallejeux = new Volet("Volet", salle_de_jeux, false);
	private static Volet volet_studio = new Volet("Volet", studio, false);
	private static Volet volet_cuisine = new Volet("Volet", cuisine, false);
	private static Volet volet_sallemanger = new Volet("Volet", salle_a_manger, false);
	private static Armoire armoireDressing = new Armoire("Armoire", dressing, false);
	private static Produit pastilleLaveLinge = new Produit("Pastille lave linge");
	private static Linge lingeD = new Linge("Linge sale de David", false, chambre1.getNom());
	private static Linge lingeR = new Linge("Linge sale de Régine", false, chambre2.getNom());
	private static Linge lingeP = new Linge("Linge sale des parents", false, chambre_parentale.getNom());
	private static LaveLinge laveLinge = new LaveLinge("Lave linge", buanderie);
	private static Douche douche_sdb1 = new Douche("Douche", sdb1);
	private static Douche douche_sdb2 = new Douche("Douche", sdb2);
	private static Instrument piano = new Instrument("Piano", studio, false, true);
	private static Instrument guitare = new Instrument("Guitare", studio, true, false);
	private static Instrument basse = new Instrument("Basse", studio, true, true);
	private static Instrument batterie = new Instrument("Batterie", studio, false, true);
	private static Instrument violon = new Instrument("Violon", studio, true, false);
	private static Commode commode_entree = new Commode("Commode", entree);
	private static Commode commode_SaM = new Commode("Commode", salle_a_manger);

	// Création des détecteurs
	private static DetecteurMouvement detecteur_mouvement_entree = new DetecteurMouvement("Détecteur mouvement entree",
			entree, false);
	private static DetecteurMouvement detecteur_mouvement_bureau = new DetecteurMouvement("Détecteur mouvement bureau",
			bureau, false);
	private static DetecteurMouvement detecteur_mouvement_salon = new DetecteurMouvement("Détecteur mouvement salon",
			salon, false);
	private static DetecteurMouvement detecteur_mouvement_garage = new DetecteurMouvement("Détecteur mouvement garage",
			garage, false);
	private static DetecteurMouvement detecteur_mouvement_ch1 = new DetecteurMouvement(
			"Détecteur mouvement chambre David", chambre1, true);
	private static DetecteurMouvement detecteur_mouvement_ch2 = new DetecteurMouvement(
			"Détecteur mouvement chambre Régine", chambre2, true);
	private static DetecteurMouvement detecteur_mouvement_chp = new DetecteurMouvement("Détecteur mouvement chp",
			chambre_parentale, true);
	private static DetecteurMouvement detecteur_mouvement_sdb_patentale = new DetecteurMouvement(
			"Détecteur mouvement sdb patentale", sdb2, false);
	private static DetecteurMouvement detecteur_mouvement_dressing = new DetecteurMouvement(
			"Détecteur mouvement dressing", dressing, false);
	private static DetecteurMouvement detecteur_mouvement_cuisine = new DetecteurMouvement(
			"Détecteur mouvement cuisine", cuisine, false);
	private static DetecteurMouvement detecteur_mouvement_studio = new DetecteurMouvement("Détecteur mouvement studio",
			studio, false);
	private static DetecteurMouvement detecteur_mouvement_couloir = new DetecteurMouvement(
			"Détecteur mouvement couloir", couloir, false);
	// private static DetecteurOuverture detecteur_ouverture_porte = new
	// DetecteurOuverture("Détecteur ouverture porte", false, entree);
	private static DetecteurOuverture detecteur_ouverture_bureau = new DetecteurOuverture("Détecteur ouverture bureau",
			bureau, false, fenetre_bureau);
	private static DetecteurOuverture detecteur_ouverture_salon1 = new DetecteurOuverture(
			"Détecteur ouverture salon fenêtre sud", salon, false, fenetre_salon1);
	private static DetecteurOuverture detecteur_ouverture_salon2 = new DetecteurOuverture(
			"Détecteur ouverture salon fenêtre est", salon, false, fenetre_salon2);
	private static DetecteurOuverture detecteur_ouverture_ch1 = new DetecteurOuverture(
			"Détecteur ouverture chambre David", chambre1, false, fenetre_ch1);
	private static DetecteurOuverture detecteur_ouverture_ch2 = new DetecteurOuverture(
			"Détecteur ouverture chambre Régine", chambre2, false, fenetre_ch2);
	private static DetecteurOuverture detecteur_ouverture_chp = new DetecteurOuverture(
			"Détecteur ouverture chambre parentale", chambre_parentale, false, fenetre_chp);
	private static DetecteurOuverture detecteur_ouverture_sallejeux = new DetecteurOuverture(
			"Détecteur ouverture salle de jeux", salle_de_jeux, false, fenetre_sallejeux);
	private static DetecteurOuverture detecteur_ouverture_studio = new DetecteurOuverture("Détecteur ouverture studio",
			studio, false, fenetre_studio);
	private static DetecteurOuverture detecteur_ouverture_cuisine = new DetecteurOuverture(
			"Détecteur ouverture cuisine", cuisine, false, fenetre_cuisine);
	private static DetecteurOuverture detecteur_ouverture_sallemanger = new DetecteurOuverture(
			"Détecteur ouverture salle à manger", salle_a_manger, false, fenetre_sallemanger);
	private static Camera camera_devant_maison = new Camera("Caméra devant la maison", devant_maison,
			"Systeme defaillant, veuillez contacter le service maintenance !", 0);
	private static Camera camera_jardin = new Camera("Caméra du jardin", jardin,
			"|---------------------------------------------------------------------|\n|                  |   / 	    	      |  ______ |                   |\n|                  |  /                 |  |    | |     []_[]         |\n |       /|         | /                  |  |    | |     ('v')         |\n|      / |         |/           |_| |_| |__|____|_|    / |||)         |\n|     /  |         /                                  (_=*;;          |\n|    /   |        /                                                   |\n|   /    |       /                                                    |\n|   |    |      /               _____________________________         |\n|   |    |     /              //|   |    |    |    |    |  //        _|\n|   |    |    /              // |   |    |    |    |    | //        / |\n|   |   /    /              //| |   |    |    |    |    |//        /  |\n|   |  /    /              // | |   |    |    |    |    //        /__/|\n|   | /    /              //| | |   |    |    |    |   //        //   |\n|   |/    /              // | | |   |    |    |    |  //        //    |\n|        /              //| | | |___|____|____|____|_//    ___________|\n|       /              // | | | /                   //    /  /  /  /  |\n|      /              //| | | |/                   //    /  /  /  /  /|\n|	    /              // | | | /                   //    /__/__/__/__/_|\n|    /              //| | | |/                   //    //           //|\n|   /              // | | | /                   //    //           // |\n|  /              //__|_|_|/___________________//                     |\n              | /                         										    |\n|/              													    |\n|---------------------------------------------------------------------|",
			1);
	private static Camera camera_entree = new Camera("Caméra de l'entrée", entree,
			"|---------------------------------------------------------------------|\n |              |       |    				     |       |              |\n|              |       |      		         |       |              |\n|              |       |                       |       |              |\n|              |       |                       |       |              |\n|              |       |     _____________     |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |          _| |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |    |             |    |       |              |\n|              |       |____|_____________|____|       |              |\n|              |      /                         \\      |              |\n|              |     /                           \\     |              |\n|              |    /                             \\    |              |\n|	 		     |   /							     \\   |			     |\n|              |  /                                 \\  |              |\n|              | /                                   \\ |              |\n|______________|/        							    \\|______________|\n|                          										    |\n|               													    |\n|---------------------------------------------------------------------|",
			1);
	// private static DetecteurIncendie(tecteur incendie,);
	// private static DetecteurIncendie(tecteur incendie,);

	// Initialisation boolean succes
	public static boolean PPsucces1 = false, PPsucces2 = false, PPsucces3 = false, PPsucces4 = false, PPsucces6 = false,
			PPsucces7 = false;
	public static boolean LPsucces1 = false, LPsucces2 = false, LPsucces3 = false;

	// String de l'affichage de l'heure
	public static String affichageHeure(int heu, int min) {
		if (min < 10)
			return heu + "h0" + min;
		else
			return heu + "h" + min;
	}

	// ajouter du temps (en minute)
	public static void ajoutTemps(int tempsSupp) {
		heure = heure + tempsSupp / 60;
		minute = minute + tempsSupp % 60;
		while (minute >= 60) {
			minute = minute - 60;
			heure++;
		}
	}

	// retirer du temps (en minute)
	public static void retirerTemps(int tempsSupp) {
		heure = heure - tempsSupp / 60;
		minute = minute - tempsSupp % 60;
		while (minute >= 60) {
			minute = minute - 60;
			heure++;
		}
	}

	public static void checkTime() {
		if (heure == endHeure && minute >= endMinute || heure > endHeure) {
			System.out.println(
					"Vous êtes en retard !!! \nVous n'avez pas réussi à accomplir vos objectifs à temps ! \n G A M E  O V E R ");
			gameActive = false;
		}
	}

	public static int getHeure() {
		return heure;
	}

	public static int getMinute() {
		return minute;
	}

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
		Objets[] objGarage = { interrupteurGarage };
		Objets[] objCuisine = { interrupteurCuisine, frigo, liquideVaisselle, fenetre_cuisine, volet_cuisine };
		Objets[] objBuanderie = { interrupteurBuanderie, laveLinge, pastilleLaveLinge };
		Objets[] objSalleAManger = { interrupteurSaM, fenetre_sallemanger, volet_sallemanger, commode_SaM };
		Objets[] objSalon = { interrupteurSalon, enceinteSalon, canapeSalon, televisionSalon, telecommandeSalon,
				fenetre_salon1, fenetre_salon2, volet_salon1, volet_salon2 };
		Objets[] objEntree = { interrupteurEntree, commode_entree };
		Objets[] objChambre1 = { interrupteurChambre1, fenetre_ch1, volet_ch1, lingeD };
		Objets[] objChambre2 = { interrupteurChambre2, fenetre_ch2, volet_ch2, lingeR };
		Objets[] objSdB1 = { interrupteurSdB1, douche_sdb1 };
		Objets[] objBureau = { interrupteurBureau, fenetre_bureau, volet_bureau };
		Objets[] objCouloir = { interrupteurCouloir };
		Objets[] objSdB2 = { interrupteurSdB2, douche_sdb2 };
		Objets[] objSalleDeJeux = { interrupteurSdJ, televisionSalleDeJeux, telecommandeSalleDeJeux, canapeSdJ,
				fenetre_sallejeux, volet_sallejeux };
		Objets[] objChambreParentale = { interrupteurChambreP, fenetre_chp, volet_chp, lingeP };
		Objets[] objStudio = { interrupteurStudio, fenetre_studio, volet_studio, guitare, piano, violon, batterie,
				basse };
		Objets[] objToilettes = { interrupteurToilettes };
		Objets[] objGrenier = { interrupteurGrenier, AnimauxGonflables };
		Objets[] objDressing = { interrupteurDressing, armoireDressing };
		Objets[] objJardin = { piscine, Panodectrl };

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
		System.out.println("Vous venez de vous réveiller, il est déjà " + affichageHeure(heure, minute) + "...");
		System.out.println(
				"Il va falloir se dépêcher, vous avez un rendez-vous et il vous faut partir de chez vous avant "
						+ affichageHeure(endHeure, endMinute));
		System.out.println(
				"Mais vous avez encore beaucoup à faire avant de sortir ! Voici la liste des tâches que vous devez accomplir :");
		System.out.println();
		System.out.println("Voici la liste des objectifs :");
		Objectifs.listObjectifs();
		System.out.println(Joueur.getPieceCourante().toString());
		System.out.println(" ");

		// boucle du jeu
		while (gameActive) {

			// Objectifs
			Objectifs.getObjectif("Organiser une pool party")
					.setSucces(PPsucces1 && PPsucces2 && PPsucces3 && PPsucces4 && PPsucces6 && PPsucces7);
			Objectifs.getObjectif("Laver le linge de la famille").setSucces(LPsucces1 && LPsucces2 && LPsucces3);

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
				System.out.println("   - aller [nom de la pièce] (1 min) : déplacement dans la pièce indiquée");
				System.out.println("     possible uniquement quand la pièce demandée est accessible");
				System.out.println("     depuis la pièce actuelle");
				System.out.println("   - téléphone : utilise le téléphone");
				System.out.println("   - utiliser [nom de l'objet] : utiliser un objet");
				System.out.println("   - prendre [nom de l'objet] (1 min) : prendre un objet");
				System.out.println("   - inventaire : consulter l'inventaire");
				System.out.println("   - infos : consulter les informations sur la pièce");
				System.out.println("   - heure : consulter l'heure qu'il est");
				System.out.println("   - sortir : sortir de la maison depuis l'entrée");
				System.out.println("   - objectifs : affiche la liste des objectifs");
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
					Objets cherche = Joueur.StringtoObjet(resObjet);
					if (cherche != null && cherche instanceof ObjetRamassable) {
						if (Joueur.getPieceCourante().estEclaire()) {
						ajoutTemps(1);
						Joueur.addInventaire((ObjetRamassable) cherche);
						Joueur.getPieceCourante().soustractObjets(cherche);
						}
						else System.out.println("Vous savez que l'objet est dans cette pièce mais vous ne le voyez pas, il fait trop sombre ...");
					} else
						System.out.println("Cet objet n'est pas disponible ... \n");
				}
				break;
			case "HEURE":
				System.out.println("Il est " + affichageHeure(heure, minute) + ", Vous devez sortir de la maison avant "
						+ affichageHeure(endHeure, endMinute));
				break;
			case "SORTIR": // commande pour sortir de la maison depuis l'entrée
				if (Joueur.getPieceCourante().getNom().compareToIgnoreCase("entree") == 0) {
					if (Joueur.getEtatVetements() == 1) {
						if (Objectifs.allObjectifsComplets()) {
							System.out.println(
									"Vous avez accompli tout ce que vous aviez à faire avant de sortir \nEt vous êtes à l'heure !\nVous sortez de la maison\nAprès seulement quelques pas dehors, vous recevez un message indiquant : 'Le confinement vient d'être déclaré, il est nécessaire de rester chez soi'\nVous n'aviez pas tellement envie d'aller à ce rendez-vous de toute manière ...\nVous franchissez la porte d'entrée dans l'autre sens");
							gameActive = false;
							System.out.println("Jeu terminé");
						} else {
							System.out.println("Vous n'avez pas rempli tous les objectifs.");
						}
					} else
						System.out.println("Vous ne pouvez pas sortir habillé comme ça...");
				} else
					System.out.println("Vous ne pouvez sortir que depuis l'entrée");
				break;
			case "OBJECTIFS":
				System.out.println("Voici la liste des objectifs :");
				Objectifs.listObjectifs();
				break;
			default: // cas par défaut, cad commande invalide
				System.out.println("Commande invalide.");
				break;
			}

			checkTime();
		}

	}

}
