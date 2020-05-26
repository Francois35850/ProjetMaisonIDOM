package main;

import java.util.ArrayList;
import java.util.ListIterator;

public class Objectifs {

	private static ArrayList<Objectif> objectifs;

	static {
		init();
	}

	private static void init() {
		objectifs = new ArrayList<Objectif>();

		objectifs.add(new Objectif("Allumer la TV du salon", false));
	}

	private Objectifs() {
	}

	public static Objectif getObjectif(String nom) {
		ListIterator<Objectif> it = objectifs.listIterator();
		while (it.hasNext()) {
			Objectif temp = it.next();
			if (temp.getNom() == nom)
				return temp;
		}
		return null;
	}

	public static boolean allObjectifsComplets() {
		ListIterator<Objectif> it = objectifs.listIterator();
		while (it.hasNext()) {
			if (!it.next().estRempli())
				return false;
		}
		System.out.println("Vous avez rempli tous les objectifs, vous avez terminé le jeu !");
		return true;
	}

}
