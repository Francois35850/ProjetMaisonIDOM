package objets;

import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.Main;
import main.ObjetNonRamassable;
import main.ObjetRamassable;
import main.Objets;
import main.Piece;
import objetsRamassables.Linge;
import objetsRamassables.Produit;

public final class LaveLinge extends ObjetNonRamassable {

	private boolean pastille;
	private boolean lingeD;
	private boolean lingeR;
	private boolean lingeP;
	private boolean enMarche;
	
	private boolean lingeInterieur;
	
	private int heureLancement;
	private int minuteLancement;

	public LaveLinge(String nom) {
		super(nom);
		enMarche = false;
		pastille = false;
		lingeD = false;
		lingeR = false;
		lingeP = false;
		lingeInterieur = false;
		heureLancement = -1;
		minuteLancement = -1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String etat() {
		String res = "";
		if (enMarche) {
			res += " : tournée en cours";
			if (machineTerminee()) {
				res += ", cycle terminé";
				if(lingeInterieur) res+= ", linge à l'intéieur";
				else res+= ", pas de linge à l'intérieur";
			}
			else res += ", cycle en cours";
		} else
			res += ": éteint";
		return res + "\n";
	}

	private void checkUtilisation() {
		ListIterator<ObjetRamassable> it = Joueur.getInventaire().listIterator();
		while (it.hasNext()) {
			Objets suiv = it.next();
			if (suiv.getNom().compareToIgnoreCase("pastille lave linge") == 0)
				pastille = true;
			else if (suiv.getNom().compareToIgnoreCase("Linge sale de David") == 0)
				lingeD = true;
			else if (suiv.getNom().compareToIgnoreCase("Linge sale de Régine") == 0)
				lingeR = true;
			else if (suiv.getNom().compareToIgnoreCase("Linge sale des parents") == 0)
				lingeP = true;
		}
	}

	private boolean machineTerminee() {
		return (Main.getHeure()>heureLancement+1 || (Main.getHeure()==heureLancement+1 && Main.getMinute()>=minuteLancement));
	}
	
	@Override
	public void utiliserObjet() {
		checkUtilisation();
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() + ".");
		while (this.getUtilisation()) {
			System.out.println(
					"Liste des actions possibles pour cet objet :\n  - lancer une machine (1h)\n  - arreter\n  - sortir le linge\n  - retour");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "LANCER UNE MACHINE":
				if(pastille && lingeD && lingeR && lingeP && !enMarche) {
					heureLancement = Main.getHeure();
					minuteLancement = Main.getMinute();
					System.out.println("Vous lancez une machine avec les vêtements de la famille");
					Joueur.supprInv("Pastille lave linge");
					Joueur.supprInv("Linge sale de David");
					Joueur.supprInv("Linge sale de Régine");
					Joueur.supprInv("Linge sale des parents");
					pastille = false;
					lingeD = false;
					lingeR = false;
					lingeP = false;
					enMarche = true;
					lingeInterieur = true;
				}
				else {
					if(enMarche) {
						System.out.println("La machine est déjà en marche");
					}
					else {
						if(!lingeD) System.out.println("Vous avez oublié de prendre une pastille pour le lave linge");
						if(!lingeD) System.out.println("Pensez à prendre le linge sale de David");
						if(!lingeD) System.out.println("Pensez à prendre le linge sale de Régine");
						if(!lingeD) System.out.println("Pensez à prendre le linge sale des parents");
					}
				}
				break;
			case "ARRETER":
				if(enMarche) {
					if(machineTerminee()) {
						System.out.println("La machine a bien fini son cycle, vous venez de l'arrêter");
						enMarche = false;
					}
					else {
						System.out.println("Vous ne pouvez pas terminer la machine pendant son cycle de lavage");
					}
				}
				else System.out.println("La machine n'est pas en marche");
				break;
			case "SORTIR LE LINGE":
				if(!enMarche) {
					if(lingeInterieur) {
						System.out.println("Vous récupérez le linge de toute la famille tout propre !");
						System.out.println("Vous n'avez plus qu'à le ramener dans les chambres");
						lingeInterieur = false;
						Joueur.addInventaire(new Linge("Linge propre de David", true, "Chambre de David"));
						Joueur.addInventaire(new Linge("Linge propre de Régine", true, "Chambre de Régine"));
						Joueur.addInventaire(new Linge("Linge propre des parents", true, "Chambre parentale"));
					}
					else {
						System.out.println("Cette machine ne contient pas de linge");
					}
				}
				else {
					System.out.println("La machine est en marche");
				}
				break;
			case "RETOUR":
				this.setUtilisation(false);
				System.out.println("Vous arrêtez d'utilisez l'objet");
				break;
			default:
				System.out.println("La commande n'est pas valide");
				break;
			}
		}

	}

}
