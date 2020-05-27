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

		objectifs.add(new Objectif("Regarder un documentaire sur la télé du salon", false, null));

		objectifs.add(new Objectif("Regarder ses messages", false,
				new String[] { "Regarder son portable", "Ouvrir ses messages" })); // modifier

		objectifs.add(new Objectif("Mettre de la musique dans le salon", false, null)); // a changer

		objectifs.add(new Objectif("Organiser une pool party", false,
				new String[] { "Mettre de la musique à proximité de la piscine", "Ouvrir la piscine",
						"Désactiver le détecteur de la piscine", "Activer les lumières de la piscine",
						"Trouver un moyen de faire des bulles dans la piscine",
						"Mettre des objets gonflables dans la piscine" }));

		objectifs.add(new Objectif("Laver le linge de la famille", false, new String[] {
				"Ramasser le linge de tout le monde", "Lancer une machine", "Redistribuer le linge propre" }));
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
		System.out.println("Vous avez rempli tous les objectifs, vous pouvez sortir de la maison.");
		return true;
	}

}
