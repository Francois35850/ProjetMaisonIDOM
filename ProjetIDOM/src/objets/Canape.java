package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import main.Piece;
import objetsRamassables.Pile;

public final class Canape extends ObjetNonRamassable {
	
	private boolean occupe;
	private List<ObjetRamassable> objetsARamasser;
	
	public Canape(String nom, Piece piece, boolean occupe,boolean pilesARamasser) {
		super(nom,piece);
		this.occupe = occupe;
		objetsARamasser = new ArrayList<ObjetRamassable>();
		if(pilesARamasser) {
			objetsARamasser.add(new Pile("Pile télécommande 1"));
			objetsARamasser.add(new Pile("Pile télécommande 2"));
		}
	}

	@Override
	public String etat() {
		String res = "";
		if(occupe) res += " : occupé";
		else res+= " : libre";
		return res+"\n";
	}
	
	private int indiceObjet(String nomObjet) {
		int res = 0;
		if(!objetsARamasser.isEmpty()) {
			ListIterator<ObjetRamassable> it = objetsARamasser.listIterator();
			while(it.hasNext()) {
				ObjetRamassable or = it.next();
				if(or.getNom().toUpperCase().compareTo(nomObjet.toUpperCase()) == 0) return res;
				else res++;
			}
			return -1;
		}
		else return -1;
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - s'assoir (15 mins)\n  - s'allonger(45 mins)\n  - regarder en dessous (5 mins)\n  - regarder sous les coussins (3 mins)\n  - retour");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
			case "S'ASSOIR" :
				if(!occupe) {Main.ajoutTemps(15); System.out.println("Vous vous asseyez sur le canapé");}
				break;
			case "S'ALLONGER" :
				if(!occupe) {Main.ajoutTemps(45); System.out.println("Vous vous allongez sur le canapé");}
				break;
			case "REGARDER EN DESSOUS" :
				Main.ajoutTemps(5);
				int indice = indiceObjet("Pile télécommande 1");
				if(indice !=-1) {
					Joueur.addInventaire(objetsARamasser.get(indice));
					objetsARamasser.remove(indice);
				}
				else {
					System.out.println("Vous ne trouvez rien sous le canapé...");
				}
				break;
			case "REGARDER SOUS LES COUSSINS" :
				Main.ajoutTemps(3);
				int indice2 = indiceObjet("Pile télécommande 2");
				if(indice2 !=-1) {
					Joueur.addInventaire(objetsARamasser.get(indice2));
					objetsARamasser.remove(indice2);
				}
				else {
					System.out.println("Vous ne trouvez rien sous les coussins...");
				}
				break;
			case "RETOUR" :
				System.out.println("Vous quittez le canapé");
				this.setUtilisation(false);
				break;
			default: 
				System.out.println("La commande n'est pas valide");
				break;
			}
		}
		sc.close();
	}

	

}
