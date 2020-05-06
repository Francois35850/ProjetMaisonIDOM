import java.util.Scanner;


public class Telephone {

	// boolean pour l'Ã©tat du tÃ©lÃ©phone : true quand le tÃ©lÃ©phone est utilisé
			private static boolean telActive = false;
			
			// scanner pour lire les commandes du joueur
			private static Scanner input = new Scanner(System.in);

			//telephone pour les fonctions
			private static ITelephone iphone;
			
			/**
			 * Fonction principale tÃ©lÃ©phone
			 */
			public static void utiliserTelephone() {
				
				// active le tÃ©lÃ©phone une premiere fois
				telActive = true;
				
				
				// boucle du tel
				while (telActive) {
					
					// Demande de la commande
					System.out.println("Entrez une commande ('help' pour la liste des commandes) :");
					String entree = input.nextLine();											
					
					
					// code en fonction de la commande
					switch(entree) {
					
					case "quitter" : // commande pour quitter le tel
						telActive = false;
						
					case "carte" : // commande pour afficher la carte			
						System.out.println("Tu veux savoir o� tu es ?");
						if(true) {
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
						}
						else {
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
						System.out.println("|        AUDITORIUM          |       |                           +    |");
						System.out.println("|                            |       |       CHAMBRE       |   WC 2   |");
						System.out.println("|                |-----------|       |                     |----------|");
						System.out.println("|                |           |       |      PARENTALE      |          |");
						System.out.println("|                |   WC 3            |                       DRESSING |");
						System.out.println("|                |                   |                                |");
						System.out.println("|                |           |       |                     |          |");
						System.out.println("|----------------|-----------|-------|---------------------|----------|");
						}
						break;
						
						
						
					case "connexion" : //commande pour voir l'Ã©tat des connexions 
						System.out.println("Problemes de connexion ?");
						int choix_connexion = input.nextInt();
						System.out.println("1 - Voir l'Ã©tat de la connexion wifi");
						System.out.println("2 - Changer l'Ã©tat de la connexion wifi");
						System.out.println("3 - Voir l'Ã©tat de la connexion gsm");
						System.out.println("4 - Changer l'Ã©tat de la connexion gsm");
						System.out.println("5 - Quitter l'application");
						System.out.println("6 - Quitter le téléphone");
						Connexion(choix_connexion,iphone );
						System.out.println("6 - Quitter le tÃ©lÃ©phone");
						Connexion(choix_connexion, iphone );
						break;
						
					case "course" : // commande pour ouvrir l'application course
						System.out.println("Bientot l'heure de manger ?");
						int choix_course = input.nextInt();
						System.out.println("1 - Aller faire ses courses tout seul");
						System.out.println("2 - Commander et aller retirer ses courses au drive");
						System.out.println("3 - Se faire livrer ses courses");
						System.out.println("4 - Regarder ses points de fidÃ©litÃ©");
						System.out.println("5 - Quitter l'application");
						System.out.println("6 - Quitter le tÃ©lÃ©phone");
						Course(choix_course);
						break;
				
					case "homekit" : // commande pour affiche l'application de la maison connectÃ©e
						System.out.println("Faire son choix :");
						int choix_homekit = input.nextInt();
						System.out.println("1 - Enceintes");
						System.out.println("2 - Lumières");
						System.out.println("3 - Frigo");
						System.out.println("4 - Jardin");
						System.out.println("5 - Prises");
						System.out.println("6 - Volets");
						System.out.println("7 - CVC");
						System.out.println("8 - Alarme");
						System.out.println("9 - Home cinéma");
						System.out.println("10 - Sam le chien");
						System.out.println("11 - Quitter l'application");
						System.out.println("12 - Quitter le tÃ©lÃ©phone");
						Homekit(choix_homekit);
						break;																						
						
					case "help" : // commande pour afficher la liste des commandes
						System.out.println("Besoin d'aide ?");
						System.out.println("   - carte : affiche la carte");
						System.out.println("   - musique : ouvrir l'application musique");
						System.out.println("   - messages : ouvrir l'application message");
						System.out.println("   - course : ouvrir l'application d'IntermarchÃ©");
						System.out.println("   - quitter : revenir en arriere ou quitter ");
						System.out.println("   - homekit : affiche l'application de votre maison connectÃ©e ");
						System.out.println("   - credits : voir les crÃ©dits");
						break;
						
						
					case "musique" : // commande pour ouvrir l'application musique
						System.out.println("Un peu de musique ?");
						int choix_musique = input.nextInt();
						System.out.println("1 - Jouer de la musique");
						System.out.println("2 - Se connecter à une enceinte");
						System.out.println("3 - Se connecter à plusieurs pièces");
						System.out.println("4 - Mettre de la musique dans toute la maison");
						System.out.println("5 - Quitter l'application");
						System.out.println("6 - Quitter le téléphone");
						Musique(choix_musique,iphone);
						System.out.println("6 - Quitter le tÃ©lÃ©phone");
						Musique(choix_musique,iphone);
						break;
						
					case "messages" : // commande pour ouvrir l'application message
						System.out.println("Envie de contacter quelqu'un");
						int choix_message = input.nextInt();
						System.out.println("1 - Passer un appel");
						System.out.println("2 - Faire un coronapéro");
						System.out.println("3 - Envoyer un message");
						System.out.println("4 - Quitter l'application");
						System.out.println("5 - Quitter le tÃ©lÃ©phone");
					
					case "credits" : // commande pour ouvrir les credits
						System.out.println("");	
						break;	
						
					default : // cas par dÃ©faut, cad commande invalide
						System.out.println("Hein ?");
						break;
						
				}
				
			}
			
			telActive = false;

		}
			
			

			//Application musique
			public static void Musique(int choix, ITelephone iphone) {
				if(choix==1) {}
				if(choix==2) {}
				if(choix==3) {}
				if(choix==4) {}
				if(choix==5) {}//break, on retourne au menu principal du tÃ©lÃ©phone
				if(choix==6) {telActive = false;}
				}

			//Application messages
			public static void Messages(int choix, ITelephone iphone) {
				if(choix==1) {}
				if(choix==2) {}
				if(choix==3) {}
				if(choix==4) {}//break, on retourne au menu principal du tÃ©lÃ©phone
				if(choix==5) {telActive = false;}
				}

			//Application Homekit
			public static void Homekit(int choix) {
				if(choix==1) {}
				if(choix==2) {}
				if(choix==3) {}
				if(choix==4) {}
				if(choix==5) {}
				if(choix==6) {}
				if(choix==7) {}
				if(choix==8) {}
				if(choix==9) {}
				if(choix==10) {}
				if(choix==11) {}//break, on retourne au menu principal du tÃ©lÃ©phone
				if(choix==12) {telActive = false;}
				}

			//Application connexion
			public static String Connexion(int choix, ITelephone iphone) {
				if(choix==1) {return ITelephone.getWifi(iphone);}
				if(choix==2) {return ITelephone.setWifi(iphone);}
				if(choix==3) {return ITelephone.getGsm(iphone);}
				if(choix==4) {return ITelephone.setGsm(iphone);}
				if(choix==5) {}//break, on retourne au menu principal du tÃ©lÃ©phone
				if(choix==6) {telActive = false;}
				return null;
				}
			
			//Application course
			public static void Course(int choix) {
				if(choix==1) {
					System.out.println("Besoin d'aide ?");}
				if(choix==2) {}
				if(choix==3) {}
				if(choix==4) {}
				if(choix==5) {}//break, on retourne au menu principal du tÃ©lÃ©phone
				if(choix==6) {telActive = false;}
			}

}
