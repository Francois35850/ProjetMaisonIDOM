package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public class PanneauDeCtrl extends ObjetNonRamassable{
	private Piscine p;

	public PanneauDeCtrl(String nom,Piscine pi) {
		super(nom);
		p = pi;
	}

	@Override
	public String etat() {
		return "";
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez la " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - lumiere\n  - ouvrir\n - alarme\n - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "LUMIERE":
				p.setLum(!p.getLum());
				if (p.getLum()) {
					System.out.println("Vous allumez la lumière de la piscine");
				}
				else System.out.println("Vous eteignez la lumière de la piscine");
				break;
			case "OUVRIR":
				if (p.getOuverture()) {
					System.out.println("La piscine est déjà ouverte");
				}
				else System.out.println("Vous ouvrez la piscine");
				p.setOuverture(true);
				break;
			case "ALARME":
				p.setSecu(!p.getSecu());
				if (p.getSecu()) {
					System.out.println("Vous activez l'alarme de la piscine");
				}
				else System.out.println("Vous désactivez l'alarme de la piscine");
				break;
			case "RETOUR":
				this.setUtilisation(false);
				System.out.println("Vous arrêtez d'utiliser l'objet");
				break;
			default:
				System.out.println("La commande n'est pas valide");
				break;
			}
		}
		
	}

}
