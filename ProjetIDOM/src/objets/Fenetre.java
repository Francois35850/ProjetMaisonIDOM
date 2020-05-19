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
	
	//fonction qui initialise les fenetre de la maison
	public static void initialisationFenetreMaison(){
		Fenetre fenetre_bureau = new Fenetre("fenetre_bureau", false, false);
		Fenetre fenetre_salon1 = new Fenetre("fenetre__salon1", false, false);
		Fenetre fenetre_salon2 = new Fenetre("fenetre__salon2", false, false);
		Fenetre fenetre_ch1 = new Fenetre("fenetre_ch1", false, false);
		Fenetre fenetre_ch2 = new Fenetre("fenetre_ch2", false, false);
		Fenetre fenetre_chp = new Fenetre("fenetre_chp", false, false);
		Fenetre fenetre_sallejeux = new Fenetre("fenetre_sallejeux", false, false);
		Fenetre fenetre_studio = new Fenetre("fenetre_studio", false, false);
		Fenetre fenetre_cuisine = new Fenetre("fenetre_cuisine", false, false);
		Fenetre fenetre_sallemanger = new Fenetre("fenetre_sallemanger", false, false);
	}
	
	//fonction qui retourne l'état de la fenetre 		
	public String etat()	{
		String res ="";
		if(this.etat_fenetre==true) {res+=" : ouvert";}
		else {res+=" : fermé";}
		return res + "\n";
	}
	

	//fonction qui permet d'utiliser la fenetre 			
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()==true){
			System.out.println("Liste des actions possibles pour cet objet :\n  - ouvrir la fenetre/le volet\n  - fermer la fenetre/le volet\n  - retour");
			String entree = input.nextLine();
			switch (entree) {
			case "OUVRIR":
				setEtat(true);
				break;
			case "FERMER":
				setEtat(false);
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
	
	public boolean getEtat(Fenetre fenetre) {return this.etat_fenetre;}
	
	public void setEtat(boolean use) {this.etat_fenetre = use;}
	

}
