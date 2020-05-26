package objets;

import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.Piece;

public class Piscine extends ObjetNonRamassable {
	private boolean ouvert;
	private boolean mousse;
	private boolean secu;
	private boolean lumiere;
	private boolean ambiance;

	public Piscine(String nom,Piece piece) {
		super(nom,piece);
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
			System.out.println("Liste des actions possibles pour cet objet :\n  - plongeon (3 min)\n  - nager (15 min)\n  - ouvrir\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "PLONGEON":
				if (ouvert) {
					if(Joueur.getEtatVetements()!=3) {
						System.out.println("Vous effectuez un plongeon tout habillé et ressortez trempé ...");
						System.out.println("Un maillot de bain aurait été une bonne idée ...");
						Main.ajoutTemps(3);
					}
					else {
						System.out.println("Vous faites une grosse bombe au milieu de la piscine\nVous ressortez trempé...");
						Main.ajoutTemps(3);
					}
					if (secu) {
						System.out.println("L'alarme retentie, vous avez oubliez de la désactiver \nLes chiens du quartier se mettent à aboyer");
					}
				} else {
					System.out.println("La piscine est fermée ! Vous voulez vous casser le cou ??");
				}
				break;
			case "NAGER":
				if (ouvert) {
					if(Joueur.getEtatVetements()!=3) {
						System.out.println("Vous n'avez pas la tenue adéquate pour faire quelques longueurs, allez vous changer");
					}
					else if(!secu){
						System.out.println("Vous faites quelques longueurs de piscine, c'est vraiment agréable sous ce beau soleil");
						System.out.println("Vous sortez de l'eau");
						Main.ajoutTemps(15);
					}
					else {
						System.out.println("Vous entrez tranquillement dans l'eau et commencez à nager quand l'alarme retentie !");
						System.out.println("Vous vous empressez de ressortir de l'eau");
						System.out.println("Bravo, vous faites hurler tous les chiens du quartier !");
						Main.ajoutTemps(2);
					}
				} else {
					System.out.println("La piscine est fermée ! Impossible de nager");
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
