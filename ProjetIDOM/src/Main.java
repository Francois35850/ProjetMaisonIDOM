
import java.util.Scanner;

public class Main {
	
	private static boolean gameActive = true;
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Bienvenue !");
		System.out.println(" ");
		
		
		while (gameActive) {
			
			System.out.println("Entrez une commande ('help' pour la liste des commandes) :");
			String entree = input.nextLine();
			
			switch(entree) {
			case "quitter" :
				gameActive = false;
				System.out.println("Jeu quitté");
				break;
			case "help" :
				System.out.println("Liste des commandes disponibles :");
				System.out.println("   - quitter : ferme le jeu");
				System.out.println("   - help : affiche cette liste");
				break;
			default :
				System.out.println("Commande invalide.");
				break;
			}
			
		}

	}

}
