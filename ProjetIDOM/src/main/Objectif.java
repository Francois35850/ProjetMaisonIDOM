package main;
import java.util.List;
import java.util.ListIterator;

public class Objectif {
	private String nom;
	private int longueur;
	private List<Boolean> listeObjectifs;
	
	public Objectif(String nom, int lon, List<Boolean> lst) {
		this.nom = nom;
		longueur = lon;
		listeObjectifs = lst;
	}
	
	public boolean ObjEstTrue() {
		boolean realise = true;
		ListIterator<Boolean> itObjet = listeObjectifs.listIterator();
		while (itObjet.hasNext() && realise) {
			boolean prochain = itObjet.next();
			if (!prochain) realise = false;
		}
		return realise;
	}

}
