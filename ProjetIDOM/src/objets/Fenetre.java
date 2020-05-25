package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public class Fenetre extends ObjetNonRamassable{

	// scanner pour lire les commandes du joueur
	private static Scanner input = new Scanner(System.in);
	
	//Attributs
	private boolean etat_fenetre;

	//Constructeur
	public Fenetre(String nom, boolean etat_fenetre) {
		super(nom);
		this.etat_fenetre=etat_fenetre;
	}	
	
	//fonction qui retourne l'état de la fenetre 		
	public String etat()	{
		String res ="";
		if(this.etat_fenetre==true) {res+=" : ouvert";}
		else {res+=" : fermée";}
		return res + "\n";
	}
	

	//fonction qui permet d'utiliser la fenetre 			
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()==true){
			System.out.println("Liste des actions possibles pour cet objet :\n  - ouvrir\n  - fermer\n  - retour");
			String entree = input.nextLine();
			switch (entree.toUpperCase()) {
			case "OUVRIR":
				if(!etat_fenetre) {
					System.out.println("Vous avez ouvert la fenêtre");
					setEtat(true);
				}
				else System.out.println("La fenêtre est déjà ouverte");
				break;
			case "FERMER":
				if(etat_fenetre) {
					System.out.println("Vous avez fermé la fenêtre");
					setEtat(false);
				}
				else System.out.println("La fenêtre est déjà fermée");
				break;
			case "RETOUR" :
				this.setUtilisation(false);
				System.out.println("Vous arrêtez d'utiliser l'objet");
				break;	
			default :
				System.out.println("La commande n'est pas valide");
				break;
			}
		}
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public boolean getEtat() {return this.etat_fenetre;}
	
	public void setEtat(boolean use) {this.etat_fenetre = use;}
	

}
