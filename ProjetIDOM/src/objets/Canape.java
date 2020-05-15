package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.ObjetNonRamassable;

public final class Canape extends ObjetNonRamassable {
	
	List<ObjetNonRamassable> objetsARamasser;
	
	public Canape(String nom) {
		super(nom);
	}

	@Override
	public String etat() {
		return "";
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub
		
	}

	

}
