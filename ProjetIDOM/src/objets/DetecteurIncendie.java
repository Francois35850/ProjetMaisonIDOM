package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public class DetecteurIncendie extends ObjetNonRamassable {

	private int etat;
	private int pourcentage_pile;
	private int pile;

	public DetecteurIncendie(String nom, int etat, int pourcentage_pile, int pile) {
		super(nom);
		this.etat = etat;
		this.pile=pile;
		this.pourcentage_pile = pourcentage_pile;
	}

	public String etat() {
		String res = "";
		if (this.etat == 1) {
			res += " : incendie en cours";
		} else {
			res += " : pas de fumée d�tect�e";
		}
		return res + "\n";
	}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}

	public void setEtat(int use) {this.etat = use;}
	
	public int getPourcentage() {return this.pourcentage_pile;}
	
	public int getPile() {return this.pile;}

	public void getBatterie() {
		if (this.pile == 0) {System.out.println("Batterie du détecteur incendie vide");} 
		else {System.out.println("Batterie du détecteur incendie � :" + getPile() + "%");}
	}

	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner input = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()==true){
			System.out.println("Liste des actions possibles pour cet objet :\n  - voir pourcentage batterie\n  - changer la pile \n  - retour");
			String entree = input.nextLine();
			switch (entree.toUpperCase()) {
				case "VOIR POURCENTAGE BATTERIE":
					getBatterie();
				case "CHANGER LA PILE" :
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
	
}
