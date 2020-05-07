import java.util.*;
import java.util.Scanner;

public class Main {

	// boolean pour l'état du jeu : true quand le jeu est en cours
	private static boolean gameActive = true;

	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);

	private ITelephone iPhone = ITelephone.newTelephone();

	private static Piece garage = new Piece("Garage", null, true);
	private static Piece cuisine = new Piece("Cuisine", null, true);
	private static Piece salon = new Piece("Salon", null, true);
	private static Piece salle_a_manger = new Piece("Salle à manger", null, true);
	private static Piece buanderie = new Piece("Buanderie", null, true);
	private static Piece entree = new Piece("Entree", null, true);
	private static Piece chambre1 = new Piece("Chambre de Régine", null, true);
	private static Piece chambre2 = new Piece("Chambre de David", null, true);
	private static Piece chambre_parentale = new Piece("Chambre parentale", null, false);
	private static Piece sdb1 = new Piece("Salle de bain", null, true);
	private static Piece sdb2 = new Piece("Salle de bain", null, false);
	private static Piece bureau = new Piece("Bureau", null, true);
	private static Piece salle_de_jeux = new Piece("Salle de jeux", null, false);
	private static Piece couloir = new Piece("Couloir", null, false);
	private static Piece grenier = new Piece("Grenier", null, false);
	private static Piece studio = new Piece("Studio", null, false);
	private static Piece dressing = new Piece("Dressing", null, false);
	private static Piece toilettes = new Piece("Toilettes", null, false);
	private static Piece jardin = new Piece("Jardin", null, true);

	/**
	 * Fonction principale main
	 */
	public static void main(String[] args) {
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
		garage.ajouterPiecesAdj(adjGarage);
		cuisine.ajouterPiecesAdj(adjCuisine);
		buanderie.ajouterPiecesAdj(adjBuanderie);
		salle_a_manger.ajouterPiecesAdj(adjSalleAManger);
		salon.ajouterPiecesAdj(adjSalon);
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
			switch (entreeSplit[0]) {
			case "quitter": // commande pour quitter le jeu
				gameActive = false;
				System.out.println("Jeu quitté");
				break;
			case "help": // commande pour afficher la liste des commandes
				System.out.println("Liste des commandes disponibles :");
				System.out.println("   - quitter : ferme le jeu");
				System.out.println("   - help : affiche cette liste");
				System.out.println("   - telephone : utilise le téléphone");
				System.out.println("   - aller [nom de la pièce] : déplacement dans la pièce indiquée");
				System.out.println("     possible uniquement quand la pièce demandée est accessible");
				System.out.println("     depuis la pièce actuelle");
				break;
			case "aller":
				Joueur.changerPiece(entreeSplit);
				break;
			case "telephone": // commande pour utiliser le téléphone
				Telephone.utiliserTelephone();
				break;
			default: // cas par défaut, cad commande invalide
				System.out.println("Commande invalide.");
				break;
			}

		}

	}


}
