package main;

import java.util.Scanner;

public class Telephone {

	// boolean pour l'Ã©tat du tÃ©lÃ©phone : true quand le tÃ©lÃ©phone est utilisé
	private static boolean telActive = false;

	// scanner pour lire les commandes du joueur
	private static Scanner in1 = new Scanner(System.in);

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
			String entree = in1.nextLine();

			// code en fonction de la commande
			switch (entree.toLowerCase()) {

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

			case "musique":
				String nomPiece = Joueur.getPieceCourante().getNom();
				if (nomPiece.compareToIgnoreCase("Salon") == 0) {
					Main.enceinteSalon.utiliserObjet();
				} else if (nomPiece.compareToIgnoreCase("Salle de jeux") == 0) {
					Main.enceinteSdj.utiliserObjet();
				} else
					System.out.println("Il n'y a pas d'enceinte dans cette pièce");
				break;

			case "homekit": // commande pour affiche l'application de la maison connectÃ©e
				System.out.println("Faire son choix (entrez un nombre):");
				System.out.println("1 - Auto (Gère les volets en fonction de l'heure de la journée)");
				System.out.println("2 - Etat des volets");
				System.out.println("3 - Etat des lumières");
				System.out.println("4 - AquaControl");
				System.out.println("5 - Caméra");
				System.out.println("6 - Quitter l'application");
				System.out.println("7 - Quitter le téléphone");
				Scanner hmk = new Scanner(System.in);
				String choix_homekit = hmk.nextLine();
				Homekit(choix_homekit);
				break;

			case "messages": // commande pour ouvrir l'application message
				System.out.println("Entrez un nombre : ");
				System.out.println("1 - Regarder ses messages");
				System.out.println("2 - Quitter l'application");
				System.out.println("3 - Quitter le téléphone");
				Scanner msg = new Scanner(System.in);
				String choix_message = msg.nextLine();
				Messages(choix_message);
				break;

			case "help": // commande pour afficher la liste des commandes
				System.out.println("Besoin d'aide ?");
				System.out.println("   - carte : affiche la carte");
				System.out.println("   - musique : ouvrir l'application musique");
				System.out.println("   - messages : ouvrir l'application message");
				System.out.println("   - homekit : affiche l'application de votre maison connectÃ©e ");
				System.out.println("   - quitter : revenir en arriere ou quitter ");
				break;

			default:
				System.out.println("La commande n'est pas valide");
				break;

			}

		}

		telActive = false;

	}

	// Application messages
	public static void Messages(String choix_message) {
		if (choix_message.compareTo("1")==0) {
			System.out.println("Choisissez le message souhaité (Entrez le nom du contact) : ");
			System.out.println(" Boulot - 26/05/2020 - Le boss s'est encor...");
			System.out.println(" Régine - 24/05/2020 - Tuu peux v...");
			System.out.println(" David - 21/05/2020 - Salut papa, ça se...");
			System.out.println(" Ma petite femme - 20/05/2020 - Il faudrait aller...");
			@SuppressWarnings("resource")
			Scanner in2 = new Scanner(System.in);
			String entree2 = in2.nextLine();
			switch (entree2.toUpperCase()) {
			case "BOULOT":
				System.out.println(
						"Boulot - 26/05/2020 - 13h12 :\n Le boss s'est encore bloqué dans les toilettes ... Comment tu fais d'habitude pour le faire sortir ?");
				break;
			case "REGINE":
				System.out.println("Régine - 24/05/2020 - 3h02 :\n Tuu peux vnir me chetcher ? jme sen pas bizen");
				break;
			case "DAVID":
				System.out.println(
						"David - 21/05/2020 - 15h34 :\n Salut papa, ça serait possible d'aller chez Anthony ce soir apres les cours stp ?");
				break;
			case "MA PETITE FEMME":
				System.out.println(
						"Ma petite femme - 20/05/2020 - 16h23 :\n Il faudrait aller chercher les pots de fleurs qu'il y a chez mes parents pour les donner au voisin ? Si t'as le temps d'y passer ça serait super. Bisous chérie <3");
				break;
			default: 
				System.out.println("La commande n'est pas valide");
				break;
			}
		}
		else if (choix_message.compareTo("2")==0) {
		} 
		else if (choix_message.compareTo("3")==0) {
			telActive = false;
		}
		else System.out.println("La commande n'est pas valide, je sors de l'application");
	}

	// Application Homekit
	public static void Homekit(String choix) {
		if (choix.compareTo("1")==0) {
			if (Main.isDay()) {
				Main.volet_bureau.setEtat(true);
				Main.volet_salon1.setEtat(true);
				Main.volet_salon2.setEtat(true);
				Main.volet_ch1.setEtat(true);
				Main.volet_ch2.setEtat(true);
				Main.volet_chp.setEtat(true);
				Main.volet_studio.setEtat(true);
				Main.volet_sallejeux.setEtat(true);
				Main.volet_cuisine.setEtat(true);
				Main.volet_sallemanger.setEtat(true);
				System.out.println("Il fait jour, tous les volets s'ouvrent");
			}
			else {
				Main.volet_bureau.setEtat(false);
				Main.volet_salon1.setEtat(false);
				Main.volet_salon2.setEtat(false);
				Main.volet_ch1.setEtat(false);
				Main.volet_ch2.setEtat(false);
				Main.volet_chp.setEtat(false);
				Main.volet_studio.setEtat(false);
				Main.volet_sallejeux.setEtat(false);
				Main.volet_cuisine.setEtat(false);
				Main.volet_sallemanger.setEtat(false);
				System.out.println("Il fait nuit, tous les volets se ferment");
			}
		} else if (choix.compareTo("2")==0) {
			System.out.println("Etat des volets roulants :");
			System.out.print(Main.volet_bureau.toString());
			System.out.print(Main.volet_salon1.toString());
			System.out.print(Main.volet_salon2.toString());
			System.out.print(Main.volet_ch1.toString());
			System.out.print(Main.volet_ch2.toString());
			System.out.print(Main.volet_chp.toString());
			System.out.print(Main.volet_sallejeux.toString());
			System.out.print(Main.volet_studio.toString());
			System.out.print(Main.volet_cuisine.toString());
			System.out.print(Main.volet_sallemanger.toString());
			
//		} else if (choix.compareTo("3")==0) {
//			System.out.println("Etat des détecteurs de mouvement :");
//			System.out.println(Main.detecteur_mouvement_ch1.toString());
//			System.out.println(Main.detecteur_mouvement_ch2.toString());
//			System.out.println(Main.detecteur_mouvement_chp.toString());
//			System.out.println(Main.detecteur_mouvement_sdb_patentale.toString());
//			System.out.println(Main.detecteur_mouvement_dressing.toString());
//			System.out.println(Main.detecteur_mouvement_cuisine.toString());
//			System.out.println(Main.detecteur_mouvement_studio.toString());
//			System.out.println(Main.detecteur_mouvement_couloir.toString());
//			System.out.println("Etat des détecteurs d'ouverture :");
//			System.out.println(Main.detecteur_ouverture_bureau.toString());
//			System.out.println(Main.detecteur_ouverture_salon1.toString());
//			System.out.println(Main.detecteur_ouverture_salon2.toString());
//			System.out.println(Main.detecteur_ouverture_ch1.toString());
//			System.out.println(Main.detecteur_ouverture_ch2.toString());
//			System.out.println(Main.detecteur_ouverture_chp.toString());
//			System.out.println(Main.detecteur_ouverture_sallejeux.toString());
//			System.out.println(Main.detecteur_ouverture_studio.toString());
//			System.out.println(Main.detecteur_ouverture_cuisine.toString());
//			System.out.println(Main.detecteur_ouverture_sallemanger.toString());
			
		} else if (choix.compareTo("3")==0) {
			System.out.println("Etat des lumières :");
			System.out.print(Main.interrupteurGarage.toString());
			System.out.print(Main.interrupteurCuisine.toString());
			System.out.print(Main.interrupteurSalon.toString());
			System.out.print(Main.interrupteurSaM.toString());
			System.out.print(Main.interrupteurBuanderie.toString());
			System.out.print(Main.interrupteurEntree.toString());
			System.out.print(Main.interrupteurChambre1.toString());
			System.out.print(Main.interrupteurChambre2.toString());
			System.out.print(Main.interrupteurChambreP.toString());
			System.out.print(Main.interrupteurSdB1.toString());
			System.out.print(Main.interrupteurSdB2.toString());
			System.out.print(Main.interrupteurBureau.toString());
			System.out.print(Main.interrupteurSdJ.toString());
			System.out.print(Main.interrupteurCouloir.toString());
			System.out.print(Main.interrupteurGrenier.toString());
			System.out.print(Main.interrupteurStudio.toString());
			System.out.print(Main.interrupteurDressing.toString());
			System.out.print(Main.interrupteurToilettes.toString());
			System.out.println("Voulez vous modifier les états ?\n - oui\n - non\n");
			@SuppressWarnings("resource")
			Scanner in4 = new Scanner(System.in);
			String entree3 = in4.nextLine();
			switch (entree3) {
			case "oui":
				System.out.println("Choisissez une piece");
				System.out.println(
						"Liste des pieces disponibles :\n RDC :\n  salon\n  garage\n  cuisine\n  salle a manger\n  buanderie\n  entree\n  chambre1\n  chambre2\n  sdb1\n  bureau\n R+1 :\n  chambre parentale\n  sdb2\n  studio\n  salle de jeux\n  dressing\n  toilettes\n  grenier\n  couloir\n");
				Scanner in5 = new Scanner(System.in);
				String entree4 = in5.nextLine();
				switch (entree4) {
				// RDC
				case "salon":
					Main.interrupteurSalon.setLumiere(!Main.interrupteurSalon.getLumiere());
					break;
				case "garage":
					Main.interrupteurGarage.setLumiere(!Main.interrupteurGarage.getLumiere());
					break;
				case "cuisine":
					Main.interrupteurCuisine.setLumiere(!Main.interrupteurCuisine.getLumiere());
					break;
				case "salle a manger":
					Main.interrupteurSaM.setLumiere(!Main.interrupteurSaM.getLumiere());
					break;
				case "sdb1":
					Main.interrupteurSdB1.setLumiere(!Main.interrupteurSdB1.getLumiere());
					break;
				case "buanderie":
					Main.interrupteurBuanderie.setLumiere(!Main.interrupteurBuanderie.getLumiere());
					break;
				case "entree":
					Main.interrupteurEntree.setLumiere(!Main.interrupteurEntree.getLumiere());
					break;
				case "chambre1":
					Main.interrupteurChambre1.setLumiere(!Main.interrupteurChambre1.getLumiere());
					break;
				case "chambre2":
					Main.interrupteurChambre2.setLumiere(!Main.interrupteurChambre2.getLumiere());
					break;
				// R+1
				case "chambre parentale":
					Main.interrupteurChambreP.setLumiere(!Main.interrupteurChambreP.getLumiere());
					break;
				case "sdb2":
					Main.interrupteurSdB2.setLumiere(!Main.interrupteurSdB2.getLumiere());
					break;
				case "salle de jeux":
					Main.interrupteurSdJ.setLumiere(!Main.interrupteurSdJ.getLumiere());
					break;
				case "studio":
					Main.interrupteurStudio.setLumiere(!Main.interrupteurStudio.getLumiere());
					break;
				case "grenier":
					Main.interrupteurGrenier.setLumiere(!Main.interrupteurGrenier.getLumiere());
					break;
				case "couloir":
					Main.interrupteurCouloir.setLumiere(!Main.interrupteurCouloir.getLumiere());
					break;
				case "toilettes":
					Main.interrupteurToilettes.setLumiere(!Main.interrupteurToilettes.getLumiere());
					break;
				case "dressing":
					Main.interrupteurDressing.setLumiere(!Main.interrupteurDressing.getLumiere());
					break;
				default: // cas par dÃ©faut, cad commande invalide
					System.out.println("La commande n'est pas valide");
					break;
				}

			case "non":
				break;
			default: // cas par dÃ©faut, cad commande invalide
				System.out.println("La commande n'est pas valide");
				break;
			}
			
		} else if (choix.compareTo("4")==0) {
			boolean utilise = true;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			while (utilise) {
				System.out.println("Liste des actions possibles sur la piscine :\n - lumiere\n - ouvrir\n - alarme\n - retour");
				String input = sc.nextLine();
				switch (input.toUpperCase()) {
				case "LUMIERE":
					Main.piscine.setLum(!Main.piscine.getLum());
					if (Main.piscine.getLum()) {
						System.out.println("Vous allumez la lumière de la piscine");
						main.Main.PPsucces4 = true;
					}
					else {
						System.out.println("Vous eteignez la lumière de la piscine");
						main.Main.PPsucces4 = false;
					}
					break;
				case "OUVRIR":
					if (Main.piscine.getOuverture()) {
						System.out.println("La piscine est déjà ouverte");
					}
					else System.out.println("Vous ouvrez la piscine");
					main.Main.PPsucces2 = true;
					Main.piscine.setOuverture(true);
					break;
				case "ALARME":
					Main.piscine.setSecu(!Main.piscine.getSecu());
					if (Main.piscine.getSecu()) {
						System.out.println("Vous activez l'alarme de la piscine");
						main.Main.PPsucces3 = false;
					}
					else System.out.println("Vous désactivez l'alarme de la piscine");
					main.Main.PPsucces3 = true;
					break;
				case "RETOUR":
					utilise = false;
					System.out.println("Vous quittez l'appli");
					break;
				default:
					System.out.println("La commande n'est pas valide");
					break;
				}
			}
		} else if (choix.compareTo("5")==0) {
			System.out.println(Main.camera_entree.toString());
			System.out.println(Main.camera_jardin.toString());
			System.out.println(Main.camera_devant_maison.toString());
			System.out.println("\nVos caméras ont l'air d'être mal en point et ça fait seulement 6 mois que vous les avez mises en place ...\nVous n'auriez peut-être pas dû acheter de l'entrée de gamme");
		} else if (choix.compareTo("6")==0) {
		} // break, on retourne au menu principal du tÃ©lÃ©phone
		else if (choix.compareTo("7")==0) {
			telActive = false;
		} else
			System.out.println("Choix non disponible");

	}
}
