package main;
import java.util.List;

public class Objectif {
	private String nom;
	private int longueur;
	private List<Objectif> listeObjectifs;
	
	public Objectif(String nom, int lon, List<Objectif> lst) {
		this.nom = nom;
		longueur = lon;
		listeObjectifs = lst;
	}
	
	Boolean ObjEstTrue() {
		return true;
	}

}
