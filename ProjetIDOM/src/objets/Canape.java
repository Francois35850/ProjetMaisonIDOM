package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import objetsRamassables.Pile;

public final class Canape extends ObjetNonRamassable {
	
	private boolean occupe;
	private List<ObjetRamassable> objetsARamasser;
	
	public Canape(String nom,boolean occupe,boolean pilesARamasser) {
		super(nom);
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
			System.out.println("Liste des actions possibles pour cet objet :\n  - s'assoir\n  - s'allonger\n  - regarder en dessous\n  - regarder sous les coussins\n  - retour");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
			case "S'ASSOIR" :
				if(!occupe) { System.out.println("Vous vous asseyez sur le canapé"); occupe = true;}
				break;
			case "S'ALLONGER" :
				if(!occupe) { System.out.println("Vous vous allongez sur le canapé"); occupe = true;}
				break;
			case "REGARDER EN DESSOUS" :
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
	}

	

}
