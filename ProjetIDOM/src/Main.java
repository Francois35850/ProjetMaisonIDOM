
import java.util.Scanner;

public class Main {

	// boolean pour l'état du jeu : true quand le jeu est en cours
	private static boolean gameActive = true;

	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);

	/**
	 * Fonction principale main
	 */
	public static void main(String[] args) {

		// Message de lancement du jeu
		System.out.println("Bienvenue !");
		System.out.println(" ");

		// boucle du jeu
		while (gameActive) {

			// Demande de la commande
			System.out.println("Entrez une commande ('help' pour la liste des commandes) :");
			String entree = input.nextLine();
			String[] entreeSplit = entree.split(" ");

			// code en fonction de la commande
			switch (entreeSplit[0]) {
			case "quitter": // commande pour quitter le jeu
				gameActive = false;
				System.out.println("Jeu quitté");
				break;
			case "help": // commande pour afficher la liste des commandes
				System.out.println("Liste des commandes disponibles :");
				System.out.println("   - quitter : ferme le jeu");
				System.out.println("   - help : affiche cette liste");
				System.out.println("   - aller [nom de la pièce] : déplacement dans la pièce indiquée");
				System.out.println("     possible uniquement quand la pièce demandée est accessible");
				System.out.println("     depuis la pièce actuelle");
				break;
			case "aller":
				Joueur.changerPiece(entreeSplit[1]);
				break;
			case "telephone": //commande pour utiliser le telephone
				Telephone.utiliserTelephone(null);
			default: // cas par défaut, cad commande invalide
				System.out.println("Commande invalide.");
				break;
			}

		}

	}

}
