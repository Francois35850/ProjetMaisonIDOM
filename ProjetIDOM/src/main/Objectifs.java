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

		objectifs.add(new Objectif("Allumer la TV du salon", false,
				new String[] { "Trouver les pile, les mettre dans la télécommande", "Allumer la TV" }));

		objectifs.add(new Objectif("Regarder ses messages", false,
				new String[] { "Regarder son portable", "Ouvrir ses messages" }));

		objectifs.add(new Objectif("Mettre de la musique", false, new String[] { "Regarder son portable" }));

		objectifs.add(new Objectif("Organiser une pool party", false,
				new String[] { "Mettre de la musique sur les enceintes", "Ouvrir la piscine avec le remote controller",
						"Désactiver le détecteur de la piscine", "Activer les lumières de la piscine",
						"Trouver du liquide vaisselle",
						"Mettre le liquide vaisselle dans la piscine pour faire des bulles",
						"Mettre des objets gonflables dans la piscine" }));
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

	public static void listObjectifs() {
		ListIterator<Objectif> it = objectifs.listIterator();
		while (it.hasNext()) {
			Objectif temp = it.next();
			System.out.print("   - " + temp.getNom() + " : ");
			if (temp.estRempli())
				System.out.println("complété.");
			else
				System.out.println("non complété.");
			temp.printlnDetails();
		}
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
