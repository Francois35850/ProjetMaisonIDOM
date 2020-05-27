package objetsRamassables;

import main.Main;
import main.ObjetRamassable;

public class Verre extends ObjetRamassable {

	private boolean rempli;
	private String contenu;

	public Verre(String nom, boolean rempli, String contenu) {
		super(nom);
		this.rempli = rempli;
		this.contenu = contenu;
	}

	@Override
	public void utiliserObjet() {
		if (rempli) {
			System.out.println("Vous dégustez un bon verre de " + contenu
					+ ", la consommation d'alcool est dangereuse pour la santé, à consommer avec modération");
			setNom("Verre vide");
			rempli = false;
			Main.ajoutTemps(4);
		} else
			System.out.println("Commencez par remplir votre verre");
	}
	
	public boolean getRempli() {
		return rempli;
	}

}
