package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public final class Enceinte extends ObjetNonRamassable {

	private boolean allumer;
	private boolean jouerMusique;
	
	public Enceinte(String nom, boolean allumer) {
		super(nom);
		this.allumer = allumer;
		this.jouerMusique = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String etat() {
		String res = "";
		if(allumer) {
			res+= " : allumé";
			if(jouerMusique) res+= ", musique allumée";
			else res+= ", musique éteinte";
		}
		else res+= ": éteinte";
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - allumer\n  - éteindre\n  - jouer musique\n  - retour");
			String input = sc.nextLine();
			switch(input.toUpperCase()) {
				case "ALLUMER" : 
					if(allumer) System.out.println("L'enceinte est déjà allumée");
					else {allumer = true; System.out.println("L'enceintre s'est allumée");}
					break;
				case "ETEINDRE" : 
					if(!allumer) System.out.println("L'enceinte est déjà éteinte");
					else {allumer = false;jouerMusique = false; System.out.println("L'enceintre s'est éteinte");}
					break;
				case "JOUER MUSIQUE" :
					if(!allumer) System.out.println("Commencez par allumer l'enceinte");
					else if(jouerMusique) System.out.println("La musique est déjà lancée");
					else {jouerMusique = true; System.out.println("Voila du bon gros Jul, parfait pour s'ambiancer un peu !");}
					break;
				case "RETOUR" :
					this.setUtilisation(false);
					System.out.println("Vous arrêtez d'utilisez l'objet");
					break;
				default :
					System.out.println("La commande n'est pas valide");
					break;
			}
		}
		
	}

}
