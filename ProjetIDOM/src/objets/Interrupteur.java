package objets;

import java.util.Scanner;
import main.Piece;
import main.ObjetNonRamassable;

public final class Interrupteur extends ObjetNonRamassable {

	private boolean allume;
	private Piece piece;
	
	public Interrupteur(String nom, boolean allume, Piece piece) {
		super(nom);
		this.allume = allume;
		this.piece = piece;
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
	
	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public void setLumiere(boolean lum) {
		allume = lum;
	}

}