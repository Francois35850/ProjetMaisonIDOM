package objets;

import java.util.Scanner;

import main.ObjetNonRamassable;

public final class Interrupteur extends ObjetNonRamassable {

	private boolean allume;
	
	public Interrupteur(String nom, boolean allume) {
		super(nom);
		this.allume = allume;
	}

	@Override
	public String etat() {
		String res = "";
		if(allume) res += " : lumière allumée";
		else res += " : lumière éteinte";
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		if(allume) {
			System.out.println("Vous avez éteint la lumière");
			allume = false;
		}
		else {
			System.out.println("Vous avez allumé la lumière");
			allume = true;
		}
	}
	
	public void setLumiere(boolean lum) {
		allume = lum;
	}

}