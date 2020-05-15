package objets;

import java.util.Scanner;

import main.Objet;

public final class Enceinte extends Objet {

	private boolean allumer;
	private boolean jouerMusique;
	
	public Enceinte(String nom, boolean allumer) {
		super(nom, false);
		this.allumer = allumer;
		this.jouerMusique = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String etat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - allumer\n  - eteindre\n  - jouer musique\n - annuler");
			String input = sc.nextLine();
			switch(input) {
				case "allumer" : 
					if(allumer) System.out.println("L'enceinte est déjà allumée");
					else {allumer = true; System.out.println("L'enceintre s'est allumée");}
					break;
				case "eteindre" : 
					if(!allumer) System.out.println("L'enceinte est déjà éteinte");
					else {allumer = false;jouerMusique = false; System.out.println("L'enceintre s'est éteinte");}
					break;
				case "jouer musique" :
					if(!allumer) System.out.println("Commencez par allumer l'enceinte");
					else if(jouerMusique) System.out.println("La musique est déjà lancée");
					else {jouerMusique = true; System.out.println("Voila du bon gros Jul");}
					break;
				case "annuler" :
					this.setUtilisation(false);
					System.out.println("Vous n'utilisez pas l'objet");
					break;
				default :
					System.out.println("La commande n'est pas valide");
					break;
			}
		}
		
	}

}
