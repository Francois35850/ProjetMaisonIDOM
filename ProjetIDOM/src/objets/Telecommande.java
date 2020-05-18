package objets;

import java.util.*;
import main.Joueur;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import main.Objets;
import main.Piece;

public class Telecommande extends ObjetNonRamassable {

	private int nombrePiles;
	private boolean allumee;
	private boolean sonActive;
	private int chaineActive;
	
	public Telecommande(String nom, boolean allumee, boolean sonActive, int chaineActive,int nombrePiles) {
		super(nom);
		this.nombrePiles = nombrePiles;
		this.allumee = allumee;
		this.sonActive = sonActive;
		this.chaineActive = chaineActive;
	}

	@Override
	public String etat() {
		return "\n";
	}
	
	public void verificationPiles() {
		ListIterator<ObjetRamassable> it = Joueur.getInventaire().listIterator();
		int indexP1 = -1;
		int indexP2 = -1;
		int index = 0;
		while(it.hasNext()) {
			ObjetRamassable suivant = it.next();
			if(suivant.getNom().compareToIgnoreCase("Pile télécommande 1")==0) indexP1 = index;
			else if(suivant.getNom().compareToIgnoreCase("Pile télécommande 2")==0) indexP2 = index;
			else index++;
		}
		if(indexP1!= -1 && indexP2!=-1) {
			if(indexP1>indexP2) {
				Joueur.getInventaire().remove(indexP1);
				Joueur.getInventaire().remove(indexP2);
				System.out.println("Vous utilisez les 2 piles de la télécommande");
				nombrePiles = 2;
			}
			else {
				Joueur.getInventaire().remove(indexP2);
				Joueur.getInventaire().remove(indexP1);
				System.out.println("Vous utilisez les 2 piles de la télécommande");
				nombrePiles = 2;
			}
		}
		else if(indexP1!=-1) {Joueur.getInventaire().remove(indexP1); System.out.println("Vous utilisez la pile 1 de la télécommande");nombrePiles++;}
		else if(indexP2!=-1) {Joueur.getInventaire().remove(indexP2); System.out.println("Vous utilisez la pile 2 de la télécommande");nombrePiles++;}
	}
	
	@Override
	public void utiliserObjet() {
		verificationPiles();
		if(nombrePiles==2) {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - allumer TV\n  - éteindre TV\n  - mute\n  - changer chaine\n  - retour");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
				case "ALLUMER TV" :
					if(allumee) System.out.println("La télévision est déjà allumée");
					else {allumee = true; System.out.println("Vous avez allumé la télévision");}
					break;
				case "ETEINDRE TV" : 
					if(!allumee) System.out.println("La télévision est déjà éteinte");
					else {allumee = false; System.out.println("Vous avez éteint la télévision");}
					break;
				case "MUTE" :
					if(!allumee) System.out.println("Commencez par allumer la télévision");
					else {
						if(sonActive) {System.out.println("Vous avez éteint le son"); sonActive = false;}
						else {System.out.println("Vous avez allumé le son"); sonActive = true;}
					}
					break;
				case "CHANGER CHAINE" :
					if(!allumee) System.out.println("Commencez par allumer la télévision");
					else {
						System.out.print("Entrez le numéro de la chaîne (entre 1 et 9) : ");
						Scanner sc2 = new Scanner(System.in);
						int newChaine = sc2.nextInt();
						if(newChaine<10 && newChaine>0) {
							chaineActive = newChaine-1;
							System.out.println("Vous avez mis la " + newChaine);
						}
						else System.out.println("Vous n'avez pas accès à cette chaîne...");
					}
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
		else if(nombrePiles ==1){
			System.out.println("Il vous manque encore 1 pile pour pouvoir utiliser la télécommande...");
		}
		else {
			System.out.println("Vous avez perdu les 2 piles de la télécommande... Retrouvez les pour pouvoir l'utiliser");
		}
	}
	
	public boolean getAllumee() {return allumee;}
	public boolean getSon() {return sonActive;}
	public int getChaine() {return chaineActive;}
	
}
