package objets;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import main.Joueur;
import main.ObjetNonRamassable;
import main.Objets;

public class Television extends ObjetNonRamassable {
	
	private List<String> chaines;
	
	public Television(String nom) {
		super(nom);
		chaines = new ArrayList<String>();
		// ajout des chaines TV de [0 à 8]
		chaines.add("TF1"); chaines.add("France 2"); chaines.add("France 3"); chaines.add("Canal +"); chaines.add("France 5"); chaines.add("M6");chaines.add("Arte"); chaines.add("C8"); chaines.add("W9");
		
	}

	private int indiceTelecommande(List<Objets> objetsPieceC) {
		int res = 0;
		ListIterator<Objets> it = objetsPieceC.listIterator();
		while(it.hasNext()) {
			if(it.next() instanceof Telecommande) return res;
			else res++;
		}
		return -1;
	}
	
	@Override
	public String etat() {
		int indT = indiceTelecommande(Joueur.getPieceCourante().getObjets());
		Telecommande t = (Telecommande) Joueur.getPieceCourante().getObjets().get(indT);
		String res = "";
		if(t.getAllumee()) {
			if(t.getSon()) res+= " : allumée, son activé, chaîne : ";
			else res+= " : allumée, muet, chaîne : ";
			res+=chaines.get(t.getChaine());
		}
		else {
			res+= " : éteinte";
		}
		return res + "\n";
	}

	@Override
	public void utiliserObjet() {
		System.out.println("Utilisez la télécommande pour vous servir de la télévision");
	}
	
}
