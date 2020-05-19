package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public class Piscine extends ObjetNonRamassable {
	private boolean ouvert;
	private boolean mousse;
	private boolean secu;
	private boolean lumiere;
	private boolean ambiance;

	public Piscine(String nom) {
		super(nom);
		ouvert = false;
		mousse = false;
		secu = true;
		lumiere = false;
		ambiance = false;
	}

	@Override
	public String etat() {
		String r = "";
		if (ouvert)
			r += " : ouverte ";
		else
			r += " : fermée ";
		if (mousse) {
			r += "et savonneuse !";
		}
		r += "\n";
		if (lumiere) r+= "    Une lumière tamisée est diffusée sous l'eau \n"; 
		if (ambiance) r+= "    Un dauphin et une girafe gonflables flottent sur l'eau \n"; 
		return r;
	}

	@Override
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez la " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println("Liste des actions possibles pour cet objet :\n  - plongeon\n  - ouvrir\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "PLONGEON":
				if (ouvert) {
					System.out.println("Vous effectuez un plongeon tout habillé et ressortez trempé ...");
					System.out.println("Un maillot de bain aurait été une bonne idée ...");
					if (secu) {
						System.out.println("L'alarme retentie, vous avez oubliez de la désactiver \nLes chiens du quartier se mettent à aboyer");
					}
				} else {
					System.out.println("La piscine est fermée ! Vous voulez vous casser le cou ??");
				}
				break;
			case "OUVRIR":
				if (ouvert) {
					System.out.println("La piscine est déjà ouverte");
				} else {
					System.out.println("La manivelle est bloquée, il va falloir trouver un autre moyen d'ouvrir la piscine ...");
				}
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
	
	public void setMousse(boolean b) {
		mousse = b;
	}
	public void setSecu(boolean b) {
		secu = b;
	}
	public void setOuverture(boolean b) {
		ouvert = b;
	}
	public void setLum(boolean b) {
		lumiere = b;
	}
	public void setAmb(boolean b) {
		ambiance = b;
	}
	public boolean getLum() {
		return lumiere;
	}
	public boolean getSecu() {
		return secu;
	}
	public boolean getOuverture() {
		return ouvert;
	}
}
