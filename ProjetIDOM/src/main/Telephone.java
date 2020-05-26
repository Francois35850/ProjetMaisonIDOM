package main;

import main.Main;
import objets.DetecteurMouvement;
import objets.DetecteurOuverture
import objets.Camera;
import objets.Volet;
import java.util.Scanner;

public class Telephone {

	// boolean pour l'Ã©tat du tÃ©lÃ©phone : true quand le tÃ©lÃ©phone est utilisé
	private static boolean telActive = false;

	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);

	// telephone pour les fonctions
	private static ITelephone iphone;
	private static Enceinte enceinte_telephone;

	/**
	 * Fonction principale tÃ©lÃ©phone
	 */
	public static void utiliserTelephone() {

		// active le tÃ©lÃ©phone une premiere fois
		telActive = true;

		System.out.println("Vous sortez votre téléphone");
		// boucle du tel
		while (telActive) {

			// Demande de la commande
			System.out.println("Menu du téléphone ('help' pour la liste des commandes) :");
			String entree = input.nextLine();

			// code en fonction de la commande
			switch (entree) {

			case "quitter": // commande pour quitter le tel
				telActive = false;
				System.out.println("Vous rangez votre téléphone");
				break;

			case "carte": // commande pour afficher la carte
				System.out.println("Tu veux savoir où tu es ?");
				if (Joueur.getPieceCourante().estAuRdc()) {
					System.out.println("|---------------------------------------------------------------------|");
					System.out.println("|                                                                     |");
					System.out.println("|                                                                     |");
					System.out.println("|                             JARDIN                                  |");
					System.out.println("|                                                                     |");
					System.out.println("|                                                                     |");
					System.out.println("|                                                                     |");
					System.out.println("|------------------------------------|-------------|------------------|");
					System.out.println("|                             |_ VERS|             |                  |");
					System.out.println("|                               |_R+1|             |                  |");
					System.out.println("|              SALON              |_ |   CHAMBRE   |     CHAMBRE      |");
					System.out.println("|                                   ||      1      |        2         |");
					System.out.println("|                                    |             |                  |");
					System.out.println("|------:  :------------------|       |             |        |---------|");
					System.out.println("|                            |       |             |        |         |");
					System.out.println("|                            |       |--:  :-------|--:  :--|   SDB 1 |");
					System.out.println("|       SALLE A MANGER                                            +   |");
					System.out.println("|                                          ENTREE               WC 1  |");
					System.out.println("|                            |       |                      |         |");
					System.out.println("|------:  :------|-----------|-------|       |----:  :------|---------|");
					System.out.println("|                |                   |       |                        |");
					System.out.println("|                                    |       |                        |");
					System.out.println("|     CUISINE          BUANDERIE     |       |        BUREAU          |");
					System.out.println("|                |                   |       |                        |");
					System.out.println("|                |                   |       |                        |");
					System.out.println("|------:  :------|------:  :---------|-;  ;--|------------------------|");
					System.out.println("|                                    |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|              GARAGE                |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|                                    |                                |");
					System.out.println("|------------------------------------|--------------------------------|");
				} else {
					System.out.println("|----------------------------|-------|--------------------------------|");
					System.out.println("|                            ||_VERS |                                |");
					System.out.println("|                            |  |_RDC|                                |");
					System.out.println("|                            |    |_ |                                |");
					System.out.println("|       SALLE DE JEUX        |      ||            GRENIER             |");
					System.out.println("|                                                                     |");
					System.out.println("|                                                                     |");
					System.out.println("|                            |       |                                |");
					System.out.println("|----------------------------|       |---------------------|----------|");
					System.out.println("|                                                          |          |");
					System.out.println("|                                                              SDB 2  |");
					System.out.println("|           STUDIO           |       |                           +    |");
					System.out.println("|                            |       |       CHAMBRE       |   WC 2   |");
					System.out.println("|                |-----------|       |                     |----------|");
					System.out.println("|                |           |       |      PARENTALE      |          |");
					System.out.println("|                |   WC 3            |                       DRESSING |");
					System.out.println("|                |                   |                                |");
					System.out.println("|                |           |       |                     |          |");
					System.out.println("|----------------|-----------|-------|---------------------|----------|");
				}
				break;

			case "connexion": // commande pour voir l'Ã©tat des connexions
				System.out.println("Problemes de connexion ?");
				System.out.println("1 - Voir l'Ã©tat de la connexion wifi");
				System.out.println("2 - Changer l'Ã©tat de la connexion wifi");
				System.out.println("3 - Voir l'Ã©tat de la connexion gsm");
				System.out.println("4 - Changer l'Ã©tat de la connexion gsm");
				System.out.println("5 - Quitter l'application");
				System.out.println("6 - Quitter le téléphone");
				int choix_connexion = input.nextInt();
				Connexion(choix_connexion, iphone);
				break;
				
			case "musique": // commande pour ouvrir l'application musique
				enceinte_telephone.utiliserObjet();
				break;

			case "homekit": // commande pour affiche l'application de la maison connectÃ©e
				System.out.println("Faire son choix :");
				System.out.println("1 - Scénarios");
				System.out.println("2 - Volets");
				System.out.println("3 - Alarme");
				System.out.println("4 - Lumières");
				System.out.println("5 - Caméra");
				
				
				
				System.out.println("6 - Quitter l'application");
				System.out.println("7 - Quitter le tÃ©lÃ©phone");
				
				//System.out.println("7 - CVC");
				//System.out.println("4 - Jardin");
				System.out.println("9 - Home cinéma");
				System.out.println("10 - Sam le chien");
				
				int choix_homekit = input.nextInt();
				Homekit(choix_homekit);
				break;

			case "help": // commande pour afficher la liste des commandes
				System.out.println("Besoin d'aide ?");
				System.out.println("   - carte : affiche la carte");
				System.out.println("   - connexion : affiche les options de connexion");
				System.out.println("   - musique : ouvrir l'application musique");
				System.out.println("   - messages : ouvrir l'application message");
				System.out.println("   - quitter : revenir en arriere ou quitter ");
				System.out.println("   - homekit : affiche l'application de votre maison connectÃ©e ");
				System.out.println("   - credits : voir les crÃ©dits");
				break;

			
			
			case "messages": // commande pour ouvrir l'application message
				System.out.println("Envie de contacter quelqu'un");
				System.out.println("1 - Regarder ses messages");
				System.out.println("2 - Faire un coronapéro");
				System.out.println("3 - Quitter l'application");
				System.out.println("4 - Quitter le tÃ©lÃ©phone");
				int choix_message = input.nextInt();
				Messages(choix_message, iphone);
				break;

			case "credits": // commande pour ouvrir les credits
				System.out.println("");
				break;

			default: // cas par dÃ©faut, cad commande invalide
				System.out.println("La commande n'est pas valide");
				break;

			}

		}

		telActive = false;

	}

	// Application messages
	public static void Messages(int choix, ITelephone iphone) {
		if (choix == 1) {
			System.out.println("Choisissez le message souhaité :");
			System.out.println(" Boulot - 26/05/2020 - La mission de cet...");
			System.out.println(" Régine - 24/05/2020 - ");
			System.out.println(" David - 21/05/2020 - Salut papa, �a se...");
			System.out.println(" Ma petite femme - 20/05/2020 - Il faudrait aller...");
			String entree2 = input.nextLine();
			switch (entree2.toUpperCase()) {
			case "BOULOT" :
				System.out.println("Boulot - 26/05/2020 - 13h12 :\n La mission de cet aprem se fera � . La bas il y a déja la cliente qui d'attend vers 14h30.");
				break;
			case "REGINE" :
				System.out.println("Régine - 24/05/2020 - :/n ");
				break;	
			case "DAVID" :
				System.out.println("David - 21/05/2020 - 15h34 :\n Salut papa, �a serait possible d'aller chez Anthony ce soir apres les cours stp ?");
				break;
			case "MA PETITE FEMME" :
				System.out.println("Ma petite femme - 20/05/2020 - 16h23 :\n Il faudrait aller chercher les pots de fleurs qu'il y a chez mes parents pour les donner au voisin ? Si t'as le temps d'y passer �a serait super. Bisous chérie <3");
				break;
			}
		}
		if (choix == 2) {
		}
		if (choix == 3) {
		} // break, on retourne au menu principal du tÃ©lÃ©phone
		if (choix == 4) {
			telActive = false;
		}
	}

	// Application Homekit
	public static void Homekit(int choix) {
		if (choix == 1) {
			System.out.println("Liste des actions possibles :"\n + "nuit\n depart\n" + "salle cinema"\n);
			String entree1 = input.nextLine();
			switch (entree1) {
			case "nuit" : 
				interrupteurGarage.setLumiere(false);
				interrupteurSalon.setLumiere(false);
				interrupteurCuisine.setLumiere(false);
				interrupteurSaM.setLumiere(false);
				interrupteurBuanderie.setLumiere(false);
				interrupteurEntree.setLumiere(false);
				interrupteurChambre1.setLumiere(false);
				interrupteurChambre2.setLumiere(false);
				interrupteurChambreP.setLumiere(false);
				interrupteurSdB1.setLumiere(false);
				interrupteurSdB2.setLumiere(false);
				interrupteurBureau.setLumiere(false);
				interrupteurSdJ.setLumiere(false);
				interrupteurCouloir.setLumiere(false);
				interrupteurGrenier.setLumiere(false);
				interrupteurStudio.setLumiere(false);
				interrupteurDressing.setLumiere(false);
				interrupteurToilettes.setLumiere(false);
				volet_bureau.setEtat(false);
				volet_salon1.setEtat(false);
				volet_salon2.setEtat(false);
				volet_ch1.setEtat(false);
				volet_ch2.setEtat(false);
				volet_chp.setEtat(false);
				volet_studio.setEtat(false);
				volet_sallejeux.setEtat(false);
				volet_cuisine.setEtat(false);
				volet_sallemanger.setEtat(false);
				System.out.println("Vous vous trouvez dans le noir complet, Bonne nuit");
				break;
			
			case "depart": 
				
				System.out.println("L'alarme est active, vous pouvez partir en toute sérénité");
				break;
				
			case "salle cinema":
				System.out.println("La salle de jeux est maintenant prete, votre film vous attend déja");
				break;
			}
		}
		if (choix == 2) {
			System.out.println("Etat des volets roulants :");
			System.out.println(volet_bureau.toString());
			System.out.println(volet_salon1.toString());
			System.out.println(volet_salon2.toString());
			System.out.println(volet_ch1.toString());
			System.out.println(volet_ch2.toString());
			System.out.println(volet_chp.toString());
			System.out.println(volet_sallejeux.toString());
			System.out.println(volet_studio.toString());
			System.out.println(volet_cuisine.toString());
			System.out.println(volet_sallemanger.toString());
		}
		if (choix == 3) {
			System.out.println("Etat des détecteurs de mouvement :");
			System.out.println(detecteur_mouvement_ch1.toString());
			System.out.println(detecteur_mouvement_ch2.toString());
			System.out.println(detecteur_mouvement_ch.toString());
			System.out.println(detecteur_mouvement_sdb_patentale.toString());
			System.out.println(detecteur_mouvement_dressing.toString());
			System.out.println(detecteur_mouvement_cuisine.toString());
			System.out.println(detecteur_mouvement_studio.toString());
			System.out.println(detecteur_mouvement_couloir.toString());
			System.out.println("Etat des détecteurs d'ouverture :");
			System.out.println(detecteur_ouverture_bureau.toString());
			System.out.println(detecteur_ouverture_salon1.toString());
			System.out.println(detecteur_ouverture_salon2.toString());
			System.out.println(detecteur_ouverture_ch1.toString());
			System.out.println(detecteur_ouverture_ch2.toString());
			System.out.println(detecteur_ouverture_chp.toString());
			System.out.println(detecteur_ouverture_sallejeux.toString());
			System.out.println(detecteur_ouverture_studio.toString());
			System.out.println(detecteur_ouverture_cuisine.toString());
			System.out.println(detecteur_ouverture_sallemanger.toString());	
		}
		if (choix == 4) {
			System.out.println("Etat des lumières :");
			System.out.println(interrupteurGarage.toString());
			System.out.println(interrupteurCuisine.toString());
			System.out.println(interrupteurSalon.toString());
			System.out.println(interrupteurSaM.toString());
			System.out.println(interrupteurBuanderie.toString());
			System.out.println(interrupteurEntree.toString());
			System.out.println(interrupteurChambre1.toString());
			System.out.println(interrupteurChambre2.toString());
			System.out.println(interrupteurChambreP.toString());
			System.out.println(interrupteurSdB1.toString());
			System.out.println(interrupteurSdB2.toString());
			System.out.println(interrupteurBureau.toString());
			System.out.println(interrupteurSdJ.toString());
			System.out.println(interrupteurCouloir.toString());
			System.out.println(interrupteurGrenier.toString());
		    System.out.println(interrupteurStudio.toString());
			System.out.println(interrupteurDressing.toString());
			System.out.println(interrupteurToilettes.toString());
		}
		if (choix == 5) {
			System.out.println(camera_entree.toString());
			System.out.println(camera_jardin.toString());
			System.out.println(camera_devant_maison.toString());
		}
		if (choix == 6) {
		} // break, on retourne au menu principal du tÃ©lÃ©phone
		if (choix == 7) {
			telActive = false;
		}
	}

	// Application connexion
	public static String Connexion(int choix, ITelephone iphone) {
		if (choix == 1) {
			return ITelephone.getWifi(iphone);
		}
		if (choix == 2) {
			return ITelephone.setWifi(iphone);
		}
		if (choix == 3) {
			return ITelephone.getGsm(iphone);
		}
		if (choix == 4) {
			return ITelephone.setGsm(iphone);
		}
		if (choix == 5) {
		} // break, on retourne au menu principal du tÃ©lÃ©phone
		if (choix == 6) {
			telActive = false;
		}
		return null;
	}


}
